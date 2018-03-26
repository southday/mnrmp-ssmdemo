package southday.mnrmp.util;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * MNRMP 通信工具类
 * @author southday
 * @date Sep 19, 2016
 */
public class CommunicUtil {
	private static final String PROP_MAIL_HOST = "mail.host";
	private static final String PROP_MAIL_TRANSPORT_PROTOCOL = "mail.transport.protocol";
	private static final String PROP_MAIL_SMTP_AUTH = "mail.smtp.auth";
	private static final String PROP_MAIL_USER_ACCOUNT = "mail.user.account";
	private static final String PROP_MAIL_USER_AUTHORIZATIONCODE = "mail.user.authorizationCode";
	private static final String PROP_MAIL_USER_PASSWORD = "mail.user.password";
	private static final String PROP_MAIL_SENDER = "mail.sender";
	private static final String PROP_MAIL_SUBJECT = "mail.subject";
	
	private static final Properties mailProp = new Properties();
	
	static { // 初始化mailProp
		// 不知道为什么，使用load()方法去加载properties文件，到后面的transport.connect()就报错，而使用setProperty()方法去设置则没有问题！
		// mailProp.load(new InputStreamReader(new BufferedInputStream(new FileInputStream("config/mail.properties")), "UTF-8"));
		mailProp.setProperty(PROP_MAIL_HOST, "smtp.163.com");
		mailProp.setProperty(PROP_MAIL_TRANSPORT_PROTOCOL, "smtp");
		mailProp.setProperty(PROP_MAIL_SMTP_AUTH, "true");
		mailProp.setProperty(PROP_MAIL_USER_ACCOUNT, "mnrmp_group");
		mailProp.setProperty(PROP_MAIL_USER_AUTHORIZATIONCODE, "southday112");
		mailProp.setProperty(PROP_MAIL_USER_PASSWORD, "southday_group");
		mailProp.setProperty(PROP_MAIL_SENDER, "mnrmp_group@163.com");
		mailProp.setProperty(PROP_MAIL_SUBJECT, "MNRMP:请激活您的账号!");
	}
	
	/**
	 * 获取当前的ipv4地址，如果没有联网则返回"127.0.0.1"
	 * @return
	 * @throws Exception
	 */
	public static String currentNetworkIp4() throws Exception {
		Enumeration<NetworkInterface> allNetInterfaces = null;
		try {
			allNetInterfaces = NetworkInterface.getNetworkInterfaces();
		} catch (SocketException e) {
			e.printStackTrace();
		}
		InetAddress ip = null;
		while (allNetInterfaces.hasMoreElements()) {
			NetworkInterface netInterface = (NetworkInterface) allNetInterfaces.nextElement();
			Enumeration<InetAddress> addresses = netInterface.getInetAddresses();
			while (addresses.hasMoreElements()) {
				ip = addresses.nextElement();
				if (ip != null && ip instanceof Inet4Address && !"127.0.0.1".equals(ip.getHostAddress())) {
					return ip.getHostAddress();
				}
			}
		}
		return "127.0.0.1"; // 说明没有联网
	}
	
	/**
	 * 发送激活邮件
	 * @param userId 待激活用户的id
	 * @param account 待激活用户的账号
	 * @param activateCode 激活码
	 * @param recipient 收件人
	 * @return 返回true说明邮件发送成功，否则发送失败
	 */
	public static boolean sendActivateMail(Integer userId, String account, String activateCode, String recipient) {
		try {
			// 1. 创建session
			Session session = Session.getInstance(mailProp);
			// 开启Session的debug模式，这样就可以查看程序发送email的运行状态
			session.setDebug(true);
			// 2. 通过session得到transport对象
			Transport transport = session.getTransport();
			// 3. 使用邮箱的用户名和密码连接上邮件服务器，发送邮件时，发件人需要提交邮箱的用户名和密码给smtp服务器，
			// 用户名和密码都通过之后才能正常发送邮件给收件人
			transport.connect(mailProp.getProperty(PROP_MAIL_HOST), mailProp.getProperty(PROP_MAIL_USER_ACCOUNT), mailProp.getProperty(PROP_MAIL_USER_AUTHORIZATIONCODE));
			
			// 4. 创建邮件
			// 4.1 创建邮件对象
			MimeMessage message = new MimeMessage(session);
			// 4.2 指明邮件的发件人
			message.setFrom(new InternetAddress(mailProp.getProperty(PROP_MAIL_SENDER)));
			// 4.3 指明邮件的收件人
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
			// 4.4 指明邮件的标题
			message.setSubject(mailProp.getProperty(PROP_MAIL_SUBJECT));
			// 4.5 邮件的文本内容
			String ip4 = currentNetworkIp4(); // 获取本机ipv4地址
			String url = new StringBuilder().append("http://").append(ip4).append(":8080/MNRMP/common/activate.do?userId=").append(userId).append("&activateCode=").append(activateCode).toString();
			String content = new StringBuilder().append("<p>Hello! ").append(account).append("! 请点击下面的链接激活您的账号!</p><a href=\"").append(url).append("\">").append(url).append("</a>").toString();
			message.setContent(content, "text/html;charset=UTF-8");
			
			// 5. 发送邮件
			transport.sendMessage(message, message.getAllRecipients());
			transport.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false; // 发送邮件失败
		}
		return true; // 发送邮件成功
	}
}

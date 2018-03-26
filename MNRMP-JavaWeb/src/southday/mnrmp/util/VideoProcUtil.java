package southday.mnrmp.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 视频处理 工具类
 * @author southday
 * @date Sep 21, 2016
 */
public class VideoProcUtil {
    /**
     * 视频保存位置-本地
     */
    public static final String VIDEO_SAVE_SITE_LOCAL = "/home/coco/Software/Eclipse/workspace/MNRMP/WebRoot/videopic/videos/";
    /**
     * 视频缩略图保存位置-本地
     */
    public static final String MINIATURE_SAVE_SITE_LOCAL = "/home/coco/Software/Eclipse/workspace/MNRMP/WebRoot/videopic/pics/";
    /**
     * 视频保存位置-服务器
     */
    public static final String VIDEO_SAVE_SITE_SERVER = "/MNRMP/videopic/videos/";
    /**
     * 视频缩略图保存位置-服务器
     */
    public static final String MINIATURE_SAVE_SITE_SERVER = "/MNRMP/videopic/pics/";
    
    /**
     * 获取视频总时间
     * @param videoPath 视频路径
     * @param ffmpegPath ffmpeg路径
     * @return
     */
    public static int getVideoTime(String videoPath) {  
        List<String> commands = new ArrayList<String>();
        commands.add("ffmpeg");
        commands.add("-i");
        commands.add(videoPath);
        try {
            ProcessBuilder builder = new ProcessBuilder();
            builder.command(commands);
            final Process p = builder.start();
              
            // 从输入流中读取视频信息
            BufferedReader br = new BufferedReader(new InputStreamReader(p.getErrorStream()));
            StringBuffer sb = new StringBuffer();
            String line = "";
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
            br.close();
              
            // 从视频信息中解析时长
            String regexDuration = "Duration: (.*?), start: (.*?), bitrate: (\\d*) kb\\/s";
            Pattern pattern = Pattern.compile(regexDuration);
            Matcher m = pattern.matcher(sb.toString());
            if (m.find()) {
                return getTimelen(m.group(1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
    
    // 格式:"00:00:10.68"
    private static int getTimelen(String timelen){
        int min = 0;
        String strs[] = timelen.split(":");
        if (strs[0].compareTo("0") > 0) {
            min += Integer.valueOf(strs[0]) * 60 * 60; // 秒
        }
        if(strs[1].compareTo("0") > 0){
            min += Integer.valueOf(strs[1]) * 60;
        }
        if(strs[2].compareTo("0") > 0){
            min += Math.round(Float.valueOf(strs[2]));
        }
        return min;
    }
    
    /**
     * 抓取视频缩略图并保存，若成功则返回true，否则返回false
     * @param grabTime
     * @param videoPath
     * @param minaturePath
     * @return
     */
    public static boolean grabMiniature(int grabTime, String videoPath, String miniaturePath) {
        String command = new StringBuilder().append("ffmpeg -ss ").append(grabTime).append(" -i ").append(videoPath).append(" ").append(miniaturePath).append(" -r 1 -vframes 1 -an -vcodec mjpeg").toString();
        try {
            Runtime.getRuntime().exec(command);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
    
    /**
     * 移动mp4文件的元数据到视频的第一帧，实现客户端浏览器边加载边看
     * @param mp4Path
     * @return
     */
    public static boolean moveMetadataInMp4(String mp4Path) {
        String mp4Suffix = mp4Path.substring(mp4Path.indexOf("."), mp4Path.length());
        if (!".mp4".equals(mp4Suffix)) {
            return false; // 文件不是mp4文件
        }
        String command = new StringBuilder().append("qtfaststart ").append(mp4Path).toString();
        try {
            Runtime.getRuntime().exec(command);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
    
    /**
     * 使用UUID作为文件的新名称<br>
     * xxx.yyy -> UUID.yyy
     * @param originalFileName
     * @return
     * @throws Exception
     */
    public static String newVideoName(String originalFileName) throws Exception {
        if (originalFileName == null || originalFileName.length() <= 0) {
            throw new Exception("源文件名称非法");
        }
        int index = originalFileName.lastIndexOf(".");
        String extension = originalFileName.substring(index, originalFileName.length()); // .yyy
        originalFileName = UUID.randomUUID().toString(); // UUID
        String newFileName = originalFileName + extension; // UUID.yyy
        return newFileName;
    }
    
    /**
     * 视频缩略图名称和视频名称一样，只是后缀名不同
     * @param videoName
     * @return
     * @throws Exception
     */
    public static String newMiniatureName(String videoName) throws Exception {
        if (videoName == null || videoName.length() <= 0) {
            throw new Exception("视频文件名称错误");
        }
        return videoName.substring(0, videoName.lastIndexOf(".")) + ".png";
    }
    
    /**
     * 获取视频文件保存路径
     * @Param videoSaveSite 本地或服务器
     * @param videoName
     * @return
     * @throws Exception
     */
    public static String getVideoPath(String videoSaveSite, String videoName) throws Exception {
        if (videoName == null || videoName.length() <= 0) {
            throw new Exception("视频文件名称非法");
        }
        return videoSaveSite + videoName;
    }

    /**
     * 获取视频缩略图文件保存路径
     * @Param miniatureSaveSite 本地或服务器
     * @param miniaureName
     * @return
     * @throws Exception
     */
    public static String getMiniaturePath(String miniatureSaveSite, String miniatureName) throws Exception {
        if (miniatureName == null || miniatureName.length() <= 0) {
            throw new Exception("视频缩略图文件名非法");
        }
        return miniatureSaveSite + miniatureName;
    }
}

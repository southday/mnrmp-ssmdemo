package southday.mnrmp.util;

public class Test {
    public static void main(String[] args) throws Exception{
        String str = " 哈哈 是打开  外围鹅看将 手动  娃儿矿务局  ";
        for (String s : str.trim().split(" {1,}")) {
            System.out.println(s);
        }
    }
}

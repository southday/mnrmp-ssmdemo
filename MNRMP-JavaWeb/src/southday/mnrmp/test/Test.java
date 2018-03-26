package southday.mnrmp.test;

import southday.mnrmp.util.VideoProcUtil;

public class Test {
	public static void main(String[] args) {
		int grabTime = 5;
		String videoPath = "/home/coco/Software/Eclipse/workspace/MNRMP/WebRoot/WEB-INF/videopic/videos/b6bad862-7fb4-4f25-8960-61e6c78d57e9.mp4";
		String miniaturePath ="/home/coco/Software/Eclipse/workspace/MNRMP/WebRoot/WEB-INF/videopic/pics/b6bad862-7fb4-4f25-8960-61e6c78d57e9.png";
		System.out.println(VideoProcUtil.grabMiniature(grabTime, videoPath, miniaturePath));
	}
}

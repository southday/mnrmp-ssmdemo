<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>uploadVideo-test</title>
</head>
<body>
	 <form action="/MNRMP/user/uploadVideo.do" enctype="multipart/form-data" method="post">
        视频:<input type="file" name="multVideo" /><br />
        视频标题：<input type="text" name="videoTitle" /><br />
        简介:<input type="text" name="intro" /><br />
        视频分类:
            <input type="checkbox" name="category" value="ENTERTAINMENT" />娱乐
            <input type="checkbox" name="category" value="SCIENCE_TECHNOLOGY" />科技
            <input type="checkbox" name="category" value="DOCUMENTARY" />纪实
            <input type="checkbox" name="category" value="ORIGINAL" />原创
            <input type="checkbox" name="category" value="GAME" />游戏
            <input type="checkbox" name="category" value="TV_PLAY" />电视剧
            <input type="checkbox" name="category" value="FILM" />电影
            <input type="checkbox" name="category" value="CARTOON" />动画片
            <input type="checkbox" name="category" value="SPORTS" />体育
            <input type="checkbox" name="category" value="LIVE" />生活<br />
        视频目录:
            <input type="radio" name="catalogId" value="1" checked="true" />默认精选集
            <input type="radio" name="catalogId" value="2" />Hello
            <input type="radio" name="catalogId" value="3" />World
            <input type="radio" name="catalogId" value="4" />love<br />
        隐私设置:
        <select name="privacyCode">
            <option value="PUBLIC" selected="true">公开的</option>
            <option value="PRIVATE">个人的</option>
            <option value="ENCRYPTION">设置密码</option>
        </select>
        <br /><input type="submit" value="提交" />
    </form>
</body>
</html>
MNRMP 多媒体网络资源管理平台 </br>
Spring + SpringMVC + Mybatis 学习案例

#### 请求接口

- `jcaptcha` 
    + `/MNRMP/jcaptcha.jpg` 获取验证码

- `common`
    + `/MNRMP/common/loadDicData.do` 加载字典数据
    + `/MNRMP/common/checkAccount.do` 判断用户账号是否已存在(用于注册模块)
    + `/MNRMP/common/checkEmail.do` 判断用户电子邮箱是否已存在(用于注册模块)
    + `/MNRMP/common/register.do` 注册用户
    + `/MNRMP/common/activate.do` 激活账号，这里应该是填写类似`http://xxx.xxx.xxx.xxx:8080/MNRMP/common/activate.do?userId=x&statusCode=x`的网址，邮件可能会被163拦截了！
    + `/MNRMP/common/logout.do` 退出
    + `/MNRMP/common/loadHomePageVideos.do` 获取用于在首页显示的视频记录
    + `/MNRMP/common/getVideo.do` 点击首页中(或公共页面中)的某个视频，获取视频的详细信息

- `user`
    + `/MNRMP/user/getLoginedUser.do` 从服务器中获取当前登录者，若没有则从cookie中获取
    + `/MNRMP/user/login.do` 用户登录
    + `/MNRMP/user/uploadVideo.do` 用户上传视频资源
    + `/MNRMP/user/myAllCatalogs.do` 加载用户所有的视频目录
    + `/MNRMP/user/myCatalogs.do` 加载用户某个视频目录下的所有目录信息(包括它本身和所有递归的子目录)
    + `/MNRMP/user/updateBasicInfo.do` 更新用户基本信息
    + `/MNRMP/user/updatePassword.do` 更新用户密码
    + `/MNRMP/user/myUploads.do` 用户点击`我的上传`时，获取用户上传的视频记录
    + `/MNRMP/user/deleteRefusedVideo.do` 用户删除`被拒绝的`视频记录
    + `/MNRMP/user/myDownloads.do` 用户点击`我的下载`时，获取用户下载的视频记录
    + `/MNRMP/user/myCollects.do` 用户点击`我的收藏`时，获取用户收藏的视频记录
    + `/MNRMP/user/myPraises.do` 用户点击`我的点赞`时，获取用户点赞的视频记录
    + `/MNRMP/user/myVideosInCatalog.do` 用户点击某个`视频目录`，获取该视频目录下的视频记录
    + `/MNRMP/user/myVideosJustCurCatalog.do` 用户点击某个`视频目录`，仅获取该目录下的视频信息(不包括递归获取子目录的视频信息)
    + `/MNRMP/user/downloadVideo.do` 用户下载视频
    + `/MNRMP/user/collectVideo.do` 用户收藏视频，在要收藏视频时需要发情求加载当前用户的目录 (用户`收藏`和`取消收藏`都是同一个请求)
    + `/MNRMP/user/praiseVideo.do` 用户点赞视频 (用户`点赞`和`取消赞`都是同一个请求)
    + `/MNRMP/user/createCatalog.do` 用户创建视频目录
    + `/MNRMP/user/deleteCatalog.do` 用户删除视频目录，该视频目录下的所有视频将会丢失，在删除前要提示用户
    + `/MNRMP/user/renameCatalog.do` 用户对目录重命名
    + `/MNRMP/user/moveCatalog.do` 用户移动视频目录位置
    + `/MNRMP/user/moveVideo.do` 用户移动目录中的视频到另一个目录
    + `/MNRMP/user/getVideo.do` 用户点击某个视频(该用户的视频-上传-收藏-下载-点赞)，从服务器获取更详细的视频信息
    + `/MNRMP/user/comment.do` 用户评论
    + `/MNRMP/user/deleteComment.do` 用户删除评论(只能删除自己的评论)，会级联删除该评论下的所有子评论
    + `/MNRMP/user/getComments.do` 获取用户评论，只获取直接评论，没有递归获取子评论
    + `/MNRMP/user/supportComment.do` 支持评论
    + `/MNRMP/user/opposeComment.do` 反对评论

- `resManager`
    + `/MNRMP/resManager/login.do` 资源管理员登录
    + `/MNRMP/resManager/myAudits.do` 加载资源管理员审核记录
    + `/MNRMP/resManager/auditVideo.do` 审核视频资源
    + `/MNRMP/resManager/updateBasicInfo.do` 更新资源管理员基本信息
    + `/MNRMP/resManager/updatePassword.do` 更新资源管理员密码
    + `/MNRMP/resManager/getVideo.do` 资源管理员点击某个视频(他审核的视频)，从服务器获取更详细的视频信息

- `sysAdmin`
    + `/MNRMP/sysAdmin/login.do` 系统管理员登录
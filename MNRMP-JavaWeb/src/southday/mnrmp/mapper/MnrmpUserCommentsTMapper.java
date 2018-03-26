package southday.mnrmp.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import southday.mnrmp.po.MnrmpCommentEx;
import southday.mnrmp.po.MnrmpQueryParameter;
import southday.mnrmp.po.MnrmpUserCommentsT;

public interface MnrmpUserCommentsTMapper {
	
	/**
	 * 用户添加评论
	 * @param comment
	 * @return
	 * @throws Exception
	 */
	public MnrmpCommentEx insertComment(MnrmpUserCommentsT comment) throws Exception;
    
	/**
	 * 用户删除评论，只能删除自己的评论，级联删除该评论下的所有子评论
	 * @param comment
	 * @return 返回true代表回滚(即删除不成功)
	 * @throws Exception
	 */
	public Boolean deleteCommentWithChilds(MnrmpUserCommentsT comment) throws Exception;
	
	/**
	 * 查询评论，但只查询一部分，不是全部加载出来
	 * @param queryParam
	 * @return
	 * @throws Exception
	 */
	public List<MnrmpCommentEx> findCommentWithoutChilds(MnrmpQueryParameter queryParam) throws Exception;
	
	/**
	 * 判断某个评论是否有回复
	 * @param commentId
	 * @return
	 * @throws Exception
	 */
	public Boolean findChildCommentIsExists(@Param(value="commentId") Integer commentId) throws Exception;
	
	/**
	 * 用户对某个视频点击[支持]
	 * @param commentId
	 * @return 返回true代表操作成功
	 * @throws Exception
	 */
	public Boolean updateCommentSupportNum(@Param(value="commentId") Integer commentId) throws Exception;
	
	/**
	 * 用户对某个视频点击[反对} 返回true代表操作成功
	 * @param commentId
	 * @return
	 * @throws Exception
	 */
	public Boolean updateCommentOpposeNum(@Param(value="commentId") Integer commentId) throws Exception;
}
package com.test.mapper.dao;

import com.test.mapper.model.Blog;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by miaorf on 2016/7/20.
 */
public interface BlogMapper {

    Blog selectBlog(Integer id);

    Blog selectBlogWithAuthor(Integer id);

    Blog selectBlogWithAuthor2(Integer id);

    Blog selectBlogWithPost(Integer id);

    List<Blog> findActiveBlogWithNameLike(Blog blog);


    List<Blog> findActiveBlogWithNameLikeByString(@Param(value = "key") String key);
}

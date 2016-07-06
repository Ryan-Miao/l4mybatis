package com.test.start.mapper;

import com.test.start.model.Blog;

import java.util.List;

/**
 * Created by miaorf on 2016/6/27.
 */
public interface BlogMapper {

    Blog selectById(int id);

    List<Blog> selectAll();

    int insert(Blog blog);
}

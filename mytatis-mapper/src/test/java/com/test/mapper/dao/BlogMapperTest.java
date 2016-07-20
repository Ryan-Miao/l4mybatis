package com.test.mapper.dao;

import com.test.mapper.model.Blog;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by miaorf on 2016/7/20.
 */
public class BlogMapperTest {
    private SqlSession sqlSession;
    private BlogMapper mapper;
    private static SqlSessionFactory sqlSessionFactory;

    @BeforeClass
    public static void init() throws IOException {
        String config = "mybatis-config.xml";
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream(config));
    }

    @Before
    public void setUp() throws Exception {
        sqlSession = sqlSessionFactory.openSession();
        mapper = sqlSession.getMapper(BlogMapper.class);

    }

    @Test
    public void testSelectBlog() throws Exception{
        List<Blog> blogs = mapper.selectBlog(1);
        System.out.println(blogs);
    }

}
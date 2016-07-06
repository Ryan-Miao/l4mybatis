package com.test.start.mapper;

import com.test.start.model.Blog;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

/**
 * Created by miaorf on 2016/7/2.
 */
public class BlogMapperTest {

    private SqlSession sqlSession;
    private static SqlSessionFactory sqlSessionFactory;

    @BeforeClass
    public static void init() throws Exception{
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    @Before
    public void setUp() throws Exception {
        sqlSession = sqlSessionFactory.openSession();
    }

    @Test
    public void selectBlog() throws Exception {
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        Blog blog = mapper.selectById(1);
        Assert.assertNotNull(blog);
        Assert.assertEquals(blog.getName(),"test");
    }

    @Test
    public void insert() throws Exception {
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        Blog blog = new Blog();
        blog.setName("testInsert");
        int insert = mapper.insert(blog);
        System.out.println(insert);

        sqlSession.commit();

        List<Blog> blogs = mapper.selectAll();
        System.out.println(blogs);

    }

}
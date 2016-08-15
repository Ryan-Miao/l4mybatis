package com.test.mapper.dao;

import com.test.mapper.model.Author;
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
        Blog blog = mapper.selectBlog(1);
        assertNotNull(blog.getAuthor().getUsername());
    }

    @Test
    public void testSelectBlogWithAuthor() throws Exception{
        Blog blog = mapper.selectBlogWithAuthor(1);
        assertNotNull(blog.getAuthor().getUsername());
        return;
    }
    @Test
    public void testSelectBlogWithAuthor2() throws Exception{
        Blog blog = mapper.selectBlogWithAuthor2(1);
        assertNotNull(blog.getCoAuthor().getUsername());
        return;
    }
    @Test
    public void testSelectBlogWithPost() throws Exception{
        Blog blog = mapper.selectBlogWithPost(1);
        assertNotNull(blog.getPosts().get(0));
        return;
    }
    @Test
    public void testFindActiveBlogWithNameLike() throws Exception{
        Blog key = new Blog();
        key.setName("test%");
        List<Blog> blogs = mapper.findActiveBlogWithNameLike(key);
        System.out.println(blogs);
        return;
    }
    @Test
    public void testFindActiveBlogWithNameLikeByString() throws Exception{

        List<Blog> blogs = mapper.findActiveBlogWithNameLikeByString("test%");
        System.out.println(blogs);
        return;
    }
    @Test
    public void testFindActiveBlogLike() throws Exception{
        Blog blog = new Blog();
        blog.setName("%Insert");
        Author author = new Author();
        author.setUsername("Ryan%");
        blog.setAuthor(author);
        List<Blog> blogs = mapper.findActiveBlogLike(blog);
        System.out.println(blogs);
        assertTrue(blogs.size()==2);
    }


    @Test
    public void testFindBlogMap() throws Exception{
        Blog blog = new Blog();
        blog.setName("%Insert");
        Author author = new Author();
        author.setUsername("Ryan%");
        blog.setAuthor(author);
        List<Blog> blogs = mapper.findBlogMap(blog);
        System.out.println(blogs);
        assertTrue(blogs.size()==2);
    }



}
package com.test.mapper.dao;

import com.test.mapper.model.Author;
import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by miaorf on 2016/7/7.
 */
public class AuthorMapperTest {
    private SqlSession sqlSession;
    private AuthorMapper mapper;
    private static SqlSessionFactory sqlSessionFactory;

    @BeforeClass
    public static void init() throws IOException {
        String config = "mybatis-config.xml";
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream(config));
    }

    @Before
    public void setUp() throws Exception {
        sqlSession = sqlSessionFactory.openSession();
         mapper = sqlSession.getMapper(AuthorMapper.class);
    }

    @Test
    public void insertAuthorTest() throws  Exception{
        Author ryan = new Author("Ryan", "123456", "qweqwe@qq.com", "this is a blog");
        int result = mapper.insertAuthor(ryan);
        sqlSession.commit();

        assertNotNull(ryan.getId());
    }

    @Test(expected = PersistenceException.class)
    public void insertAuthorExceptionTest() throws  Exception{
        Author ryan = new Author("Ryan", null, "qweqwe@qq.com", "this is a blog");
        int result = mapper.insertAuthor(ryan);
        sqlSession.commit();

        assertNotNull(ryan.getId());
    }

    @Test
    public void insertAuthorsTest() throws  Exception{
        List<Author> list = new ArrayList<Author>();
        for (int i = 0; i < 3; i++) {
            list.add(new Author("Ryan"+i, "123456", "qweqwe@qq.com", "this is a blog"));
        }

        int result = mapper.insertAuthors(list);
        sqlSession.commit();

        assertNotNull(list.get(2).getId());
    }

    @Test
    public void selectAuthorByIdTest() throws Exception{
        Author author = mapper.selectAuthorById(3);
        assertNotNull(author);
    }

    @Test
    public void TestUpdateAuthorEffective() throws Exception{
        Author author = mapper.selectAuthorById(3);
        author.setBio("I have changed the bio");
        int i = mapper.updateAuthor(author);
        sqlSession.commit();
        assertTrue(i>0);
    }
    @Test
    public void TestUpdateAuthorInEffective() throws Exception{
        Author author = mapper.selectAuthorById(3);
        author.setId(1024);
        int i = mapper.updateAuthor(author);
        sqlSession.commit();
        assertTrue(i==0);
    }

    @Test
    public void TestDeleteAuthorEffective() throws Exception{
        int i = mapper.deleteAuthor(3);
        assertTrue(i==1);
    }
    @Test
    public void TestDeleteAuthorInEffective() throws Exception{
        int i = mapper.deleteAuthor(3000);
        assertTrue(i==0);
    }

}
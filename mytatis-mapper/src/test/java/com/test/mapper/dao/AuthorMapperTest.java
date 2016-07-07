package com.test.mapper.dao;

import com.test.mapper.model.Author;
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

import static org.junit.Assert.*;

/**
 * Created by miaorf on 2016/7/7.
 */
public class AuthorMapperTest {
    private SqlSession sqlSession;
    private static SqlSessionFactory sqlSessionFactory;

    @BeforeClass
    public static void init() throws IOException {
        String config = "mybatis-config.xml";
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream(config));
    }

    @Before
    public void setUp() throws Exception {
        sqlSession = sqlSessionFactory.openSession();
    }

    @Test
    public void insertAuthorTest() throws  Exception{
        AuthorMapper mapper = sqlSession.getMapper(AuthorMapper.class);
        Author ryan = new Author("Ryan", "123456", "qweqwe@qq.com", "this is a blog");
        int result = mapper.insertAuthor(ryan);
        sqlSession.commit();

        assertNotNull(ryan.getId());
    }

    @Test
    public void insertAuthorsTest() throws  Exception{
        AuthorMapper mapper = sqlSession.getMapper(AuthorMapper.class);
        List<Author> list = new ArrayList<Author>();
        for (int i = 0; i < 3; i++) {
            list.add(new Author("Ryan"+i, "123456", "qweqwe@qq.com", "this is a blog"));
        }

        int result = mapper.insertAuthors(list);
        sqlSession.commit();

        assertNotNull(list.get(2).getId());
    }

}
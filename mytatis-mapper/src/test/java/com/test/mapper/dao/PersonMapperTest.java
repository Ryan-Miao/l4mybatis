package com.test.mapper.dao;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;

import static org.junit.Assert.*;

/**
 * Created by miaorf on 2016/7/6.
 */
public class PersonMapperTest {
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
    public void selectPerson() throws Exception {
        PersonMapper mapper = sqlSession.getMapper(PersonMapper.class);
        HashMap map = mapper.selectPerson(1);
        System.out.println(map);
        assertEquals(map.get("name").toString(),"Ryan");
    }

}
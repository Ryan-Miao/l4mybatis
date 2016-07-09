package com.test.mapper.dao;

import com.test.mapper.model.Author;

import java.util.HashMap;
import java.util.List;

/**
 * Created by miaorf on 2016/7/6.
 */
public interface AuthorMapper {

    int insertAuthor(Author author);

    int insertAuthors(List<Author> list);

    Author selectAuthorById(int id);

    int updateAuthor(Author author);

    int deleteAuthor(int id);
}

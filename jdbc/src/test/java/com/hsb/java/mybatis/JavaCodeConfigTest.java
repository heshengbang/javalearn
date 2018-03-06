package com.hsb.java.mybatis;
        /*
         * Copyright ©2011-2017 hsb
         */

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

import javax.sql.DataSource;

public class JavaCodeConfigTest {
    public static void main(String[] args) {
        DataSource dataSource = BlogDataSourceFactory.getBlogDataSource();
        TransactionFactory transactionFactory = new JdbcTransactionFactory();
        Environment environment = new Environment("development", transactionFactory, dataSource);
        Configuration configuration = new Configuration(environment);
        configuration.addMapper(BlogMapper.class);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);

        SqlSession session = sqlSessionFactory.openSession();
        try {
            BlogMapper mapper = session.getMapper(BlogMapper.class);
            Blog blog = mapper.selectBlog(101);
        } finally {
            session.close();
        }
    }

    private static class BlogDataSourceFactory {

        static DataSource getBlogDataSource() {
            return null;
        }
    }

    private static interface BlogMapper {
        @Select("SELECT * FROM blog WHERE id = #{id}")
        Blog selectBlog(int id);
    }


    private static class Blog {
    }
}

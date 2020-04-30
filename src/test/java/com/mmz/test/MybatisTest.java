package com.mmz.test;

import com.mmz.dao.UserDao;
import com.mmz.mybatis.io.Resources;
import com.mmz.pojo.User;
import com.mmz.mybatis.sqlsession.SqlSession;
import com.mmz.mybatis.sqlsession.SqlSessionFactory;
import com.mmz.mybatis.sqlsession.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

/**
 * @Classname MybatisTest
 * @Description TODO
 * @Date 2020/4/30 9:11
 * @Created by mmz
 */
public class MybatisTest {
    public static void main(String[] args) throws Exception{
        //1.读取配置文件
        InputStream inputStream  = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.创建一个SqlSessionFactort
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = builder.build(inputStream);
        //3.使用工厂生产SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //4.使用SqlSession创建dao代理对象
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        //5.使用代理方法执行方法
        List<User> list = userDao.findAll();
        for(User user :list){
            System.out.println(user);
        }
        //6.释放资源
        sqlSession.close();
        inputStream.close();
    }
}

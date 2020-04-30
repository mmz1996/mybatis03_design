自定义mybatis

读取配置文件文件用到io包下面的Resources

得到字节流交给了构建者，构建者使用工具类Configuration，构建了一个工厂对象SqlSessionFactory

工厂对象提供了一个openSession方法，创建一个SqlSession对象

来详细说一下，自定义的mybatis，从MybatisTest.java开始说起

InputStream inputStream  = Resources.getResourceAsStream("SqlMapConfig.xml");
我们自己声明了Resources类，做一个字节流的加载

SqlSessionFactoryBuilder是一个类
根据输入的字节流，在其内部的build方法返回一个SqlSessionFactory的实体类
方法内部，用到了XMLConfigBuilder工具的loadConfiguration方法，解析输入xml的文件
返回一个Configuration类，该类是数据源的配置信息

SqlSessionFactory中有一个openSession方法，生成一个SqlSession

public SqlSession openSession() {
        return new DefaultSqlSession(configuration);
    }
    
生成SqlSession需要根据UserDao接口进行动态代理。

public DefaultSqlSession(Configuration configuration){
        this.configuration = configuration;
        this.connection = DataSourceUtil.getConnection(configuration);
    }

public <T> T getMapper(Class<T> daoInterfaceClass) {
        return (T)Proxy.newProxyInstance(daoInterfaceClass.getClassLoader(),new Class[]{daoInterfaceClass},new MapperProxy(configuration.getMappers(),connection));
    }
    
UserDao userDao = sqlSession.getMapper(UserDao.class);
返回一个userDao，然后进行findAll方法进行查询

在SqlSession的代理中，有一个MapperProxy类，继承InvocationHandler接口，重写invoke方法

invoke方法最后调用了另一个工具类Executor中的selectList方法，进行查询。
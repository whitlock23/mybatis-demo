package com.learning.test;

import com.learning.mapper.BrandMapper;
import com.learning.pojo.Brand;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Classname MyBatisTest
 * @Description test for mybatis
 * @Date 2021/12/7 2:25 下午
 * @Created by whitlock23
 */
public class MyBatisTest {
    @Test
    public void testSelectAll() throws IOException {
        //1. 获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2. 获取SqlSession 对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //3. 获取Mapper接口代理对象
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        //4.执行方法
        List<Brand> brands = mapper.selectAll();


        System.out.println(brands);
        //4. 释放资源
        sqlSession.close();
    }

    @Test
    public void testSelectById() throws IOException {
        int id = 1;
        //1. 获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2. 获取SqlSession 对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //3. 获取Mapper接口代理对象
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        //4.执行方法
        Brand brand = mapper.selectById(id);


        System.out.println(brand);
        //4. 释放资源
        sqlSession.close();
    }

    @Test
    public void testSelectByCondition() throws IOException {
        //接收参数
        int status = 1;
        String companyName = "华为";
        String brandName = "华为";

        // 处理参数
        companyName = "%" + companyName + "%";
        brandName = "%" + brandName + "%";

        //1. 获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //2. 获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //3. 获取Mapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        //4. 执行方法
        //方式一 ：接口方法参数使用 @Param 方式调用的方法
        //List<Brand> brands = brandMapper.selectByCondition(status, companyName, brandName);
        //方式二 ：接口方法参数是 实体类对象 方式调用的方法
        //封装对象
    /* Brand brand = new Brand();
        brand.setStatus(status);
        brand.setCompanyName(companyName);
        brand.setBrandName(brandName);*/

        //List<Brand> brands = brandMapper.selectByCondition(brand);

        //方式三 ：接口方法参数是 map集合对象 方式调用的方法
        Map map = new HashMap();
        map.put("status" , status);
        map.put("companyName", companyName);
        map.put("brandName" , brandName);
        List<Brand> brands = brandMapper.selectByCondition(map);
        System.out.println(brands);

        //5. 释放资源
        sqlSession.close();
    }


    @Test
    public void testSelectByConditionDynamic() throws IOException {
        //接收参数
        int status = 1;
        String companyName = "华为";
        String brandName = "华为";

        // 处理参数
        companyName = "%" + companyName + "%";
        brandName = "%" + brandName + "%";

        //1. 获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //2. 获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //3. 获取Mapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        //4. 执行方法
        //方式一 ：接口方法参数使用 @Param 方式调用的方法
        //List<Brand> brands = brandMapper.selectByCondition(status, companyName, brandName);
        //方式二 ：接口方法参数是 实体类对象 方式调用的方法
        //封装对象
    /* Brand brand = new Brand();
        brand.setStatus(status);
        brand.setCompanyName(companyName);
        brand.setBrandName(brandName);*/

        //List<Brand> brands = brandMapper.selectByCondition(brand);

        //方式三 ：接口方法参数是 map集合对象 方式调用的方法
        Map map = new HashMap();
//        map.put("status" , status);
        map.put("companyName", companyName);
        map.put("brandName" , brandName);
        List<Brand> brands = brandMapper.selectByConditionDynamic(map);
        System.out.println(brands);

        //5. 释放资源
        sqlSession.close();
    }


    @Test
    public void testSelectByConditionSingle() throws IOException {
        //接收参数
        int status = 1;
        String companyName = "华为";
        String brandName = "华为";

        // 处理参数
        companyName = "%" + companyName + "%";
        brandName = "%" + brandName + "%";

        //封装对象
        Brand brand = new Brand();
        //brand.setStatus(status);
        brand.setCompanyName(companyName);
        //brand.setBrandName(brandName);

        //1. 获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //2. 获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //3. 获取Mapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        //4. 执行方法
        List<Brand> brands = brandMapper.selectByConditionSingle(brand);
        System.out.println(brands);

        //5. 释放资源
        sqlSession.close();
    }

    @Test
    public void testAdd() throws IOException {
        //接收参数

        int status = 1;
        String companyName = "字节";
        String brandName = "字节";
        int ordered = 10;
        String description = "asd";

        // 处理参数
//        companyName = "%" + companyName + "%";
//        brandName = "%" + brandName + "%";

        //封装对象
        Brand brand = new Brand();
        brand.setStatus(status);
        brand.setCompanyName(companyName);
        brand.setBrandName(brandName);
        brand.setDescription(description);
        brand.setOrdered(ordered);


        //1. 获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //2. 获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //3. 获取Mapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        //4. 执行方法
        brandMapper.add(brand);

        //5. 提交事务
        sqlSession.commit();

        //6. 释放资源
        sqlSession.close();
    }

    @Test
    public void testUpdate() throws IOException {
        //接收参数

        int status = 1;
        String companyName = "字节";
        String brandName = "ByteDance";
        int ordered = 100;
        String description = "aasd";
        int id = 5;
        // 处理参数
//        companyName = "%" + companyName + "%";
//        brandName = "%" + brandName + "%";

        //封装对象
        Brand brand = new Brand();
        brand.setStatus(status);
//        brand.setCompanyName(companyName);
        brand.setBrandName(brandName);
//        brand.setDescription(description);
//        brand.setOrdered(ordered);
        brand.setId(id);


        //1. 获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //2. 获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //3. 获取Mapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        //4. 执行方法
        int count = brandMapper.update(brand);
        System.out.println(count);

        //5. 提交事务
        sqlSession.commit();

        //6. 释放资源
        sqlSession.close();
    }



    @Test
    public void testDeleteById() throws IOException {
        //接收参数
        int id = 5;

        //1. 获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //2. 获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //SqlSession sqlSession = sqlSessionFactory.openSession(true);
        //3. 获取Mapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        //4. 执行方法
        brandMapper.deleteById(id);
        //提交事务
        sqlSession.commit();
        //5. 释放资源
        sqlSession.close();
    }


    @Test
    public void testDeleteByIds() throws IOException {
        //接收参数
        int[] ids = {4,7,8};

        //1. 获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //2. 获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //SqlSession sqlSession = sqlSessionFactory.openSession(true);
        //3. 获取Mapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        //4. 执行方法
        brandMapper.deleteByIds(ids);
        //提交事务
        sqlSession.commit();
        //5. 释放资源
        sqlSession.close();
    }

}

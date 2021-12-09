package com.learning.mapper;

import com.learning.pojo.Brand;
import org.apache.ibatis.annotations.Param;


import java.util.List;
import java.util.Map;

/**
 * @Classname BrandMapper
 * @Description brand mapper interface
 * @Date 2021/12/8 1:35 下午
 * @Created by whitlock23
 */
public interface BrandMapper {
    List<Brand> selectAll();

    Brand selectById(int id);

    List<Brand> selectByCondition(@Param("status") int status, @Param("companyName") String companyName, @Param("brandName") String brandName);
    List<Brand> selectByCondition(Brand brand);
    List<Brand> selectByCondition(Map map);

    List<Brand> selectByConditionDynamic(@Param("status") int status, @Param("companyName") String companyName, @Param("brandName") String brandName);
    List<Brand> selectByConditionDynamic(Brand brand);
    List<Brand> selectByConditionDynamic(Map map);


    /**
     * 单条件动态查询
     * @param brand
     * @return
     */
    List<Brand> selectByConditionSingle(Brand brand);


    void add(Brand brand);

    int update(Brand brand);


    void deleteById(int id);

    void deleteByIds(int[] ids);

}

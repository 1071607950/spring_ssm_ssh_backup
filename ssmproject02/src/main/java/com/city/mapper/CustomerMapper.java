package com.city.mapper;

import com.city.pojo.CustomerModel;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CustomerMapper {

    @Insert("insert into customer (truename,gender,nation,birth,identify,address,info) values " +
            "(#{truename},#{gender},#{nation},#{birth},#{identify},#{address},#{info})")
    int addCus(CustomerModel customerModel);

    @Update("update customer set truename=#{truename},gender=#{gender},nation=#{nation}" +
            ",birth=#{birth},identify=#{identify},address=#{address} where id = #{id}")
    int updateCus(CustomerModel customerModel);

    @Delete("delete from customer where id = #{id}")
    int deleteCus(int id);

    @Select("select * from customer where id = #{id}")
    CustomerModel selectById(int id);

    @Select("select * from customer")
    List<CustomerModel> selectAll();
}

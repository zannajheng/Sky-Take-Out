package com.sky.mapper;

import com.sky.entity.DishFlavor;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DishFlavorMapper {
    /*
    向口味表插入n条数据
     */
    void insertBatch(List<DishFlavor> flavors);
}

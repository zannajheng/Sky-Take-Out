package com.sky.mapper;

import com.sky.annotation.AutoFill;
import com.sky.entity.SetmealDish;
import com.sky.enumeration.OperationType;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SetmealDishMapper {

    /*
    根据菜品ID查询对应的套餐ID
     */
    List<Long> getSetmealIdsByDishIds(List<Long> dishIds);

    /*
    批量保存套餐和菜品的关联关系
     */
    @AutoFill(value = OperationType.INSERT)
    void insertBatch(List<SetmealDish> setmealDishes);
}

package com.sky.service;

import com.sky.dto.SetmealDTO;
import com.sky.dto.SetmealPageQueryDTO;
import com.sky.result.PageResult;
import com.sky.vo.SetmealVO;

import java.util.List;

public interface SetmealService {

    /*
    新增套餐和菜品
     */
    void saveWithDishes(SetmealDTO setmealDTO);

    /*
    套餐分页查询
     */
    PageResult page(SetmealPageQueryDTO setmealPageQueryDTO);

    /*
    批量删除套餐
     */
    void deleteByIds(List<Long> ids);

    /*
    根据ID查询套餐
     */
    SetmealVO getByIdWithDish(Long id);

    /*
    修改套餐
     */
    void update(SetmealDTO setmealDTO);

    /*
    启售、停售套餐
     */
    void startOrStop(Integer status, Long id);
}

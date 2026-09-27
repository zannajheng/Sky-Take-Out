package com.sky.service;

import com.sky.dto.SetmealDTO;

public interface SetmealService {

    /*
    新增套餐和菜品
     */
    void saveWithDishes(SetmealDTO setmealDTO);
}

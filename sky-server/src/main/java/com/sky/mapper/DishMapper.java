package com.sky.mapper;

import com.github.pagehelper.Page;
import com.sky.annotation.AutoFill;
import com.sky.dto.DishPageQueryDTO;
import com.sky.entity.Dish;
import com.sky.entity.SetmealDish;
import com.sky.enumeration.OperationType;
import com.sky.vo.DishVO;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DishMapper {

    /**
     * 根据分类id查询菜品数量
     * @param categoryId
     * @return
     */
    @Select("select count(id) from dish where category_id = #{categoryId}")
    Integer countByCategoryId(Long categoryId);

    /*
    新增菜品
     */
    @AutoFill(value = OperationType.INSERT)
    void insert(Dish dish);

    /*
    菜品分页查询
     */
    Page<DishVO> pageQuery(DishPageQueryDTO dishPageQueryDTO);

    /*
    根据主键查询菜品
     */
    @Select("select * from dish where id = #{id}")
    Dish getById(Long id);

    /*
    根据主键删除菜品
     */
    @Delete("delete from dish where id = #{id}")
    void deleteById(Long id);

    /*
    根据菜品ID集合批量删除菜品
     */
    void deleteByIds(List<Long> ids);

    /*
    根据ID动态修改菜品数据
     */
    @AutoFill(value = OperationType.UPDATE)
    void update(Dish dish);

    /*
    动态条件查询菜品
     */
    List<Dish> list(Dish dish);

    /*
    根据套餐ID查询菜品
     */
    @Select("select dish.* " +
            "from dish " +
            "left join setmeal_dish " +
            "on dish.id = setmeal_dish.dish_id " +
            "where setmeal_dish.setmeal_id = #{setmealId}")
    List<Dish> getBySetmealId(Long setmealId);
}

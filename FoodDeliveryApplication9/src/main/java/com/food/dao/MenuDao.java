package com.food.dao;

import java.sql.SQLException;
import java.util.List;

import com.food.model.Menu;

public interface MenuDao {
      void addMenu(Menu menu) throws ClassNotFoundException;
      Menu getMenu(int menuId) throws ClassNotFoundException;
      void updateMenu(Menu menu) throws ClassNotFoundException;
      void deleteMenu(int menuId)throws ClassNotFoundException;
      
      List<Menu> getAllMenusByRestaurant(int restaurantId) throws ClassNotFoundException, SQLException;
	List<Menu> getAllMenus();
}

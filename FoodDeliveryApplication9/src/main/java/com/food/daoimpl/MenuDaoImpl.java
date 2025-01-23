package com.food.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.food.dao.MenuDao;
import com.food.model.Menu;
import com.food.util.DBConnectionUtil;

public class MenuDaoImpl implements MenuDao{

	@Override
	public void addMenu(Menu menu) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Menu getMenu(int menuId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateMenu(Menu menu) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteMenu(int menuId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Menu> getAllMenusByRestaurant(int restaurantId) {
		List<Menu> menus = new ArrayList<>();
        String sql = "SELECT * FROM menu WHERE RestaurantID = ?";
        try (Connection conn = DBConnectionUtil.getConnection();
             PreparedStatement pstm = conn.prepareStatement(sql)) {
            pstm.setInt(1, restaurantId);
            try (ResultSet rs = pstm.executeQuery()) {
                while (rs.next()) {
                    menus.add(extractMenuFromResultSet(rs));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return menus;
	}
	
	private Menu extractMenuFromResultSet(ResultSet rs) {
        Menu menu = new Menu();
        try {
            menu.setMenuId(rs.getInt("MenuID"));
            menu.setRestaurantId(rs.getInt("RestaurantID"));
            menu.setItemName(rs.getString("ItemName"));
            menu.setDescription(rs.getString("Description"));
            menu.setPrice(rs.getDouble("Price"));
            menu.setAvailable(rs.getBoolean("IsAvailable"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return menu;
    }

	@Override
	public List<Menu> getAllMenus() {
		// TODO Auto-generated method stub
		return null;
	}

}

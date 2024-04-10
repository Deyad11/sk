package com.demo.deepanshu.dao;
import com.demo.deepanshu.model.inventory_item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.List;
@Repository
public class inventory_itemIMP implements inventory_itemDAO {
	 @Autowired
	    private JdbcTemplate jdbcTemplate;
	 @Override
	 public int save(inventory_item inventoryItem) {
	     String sql = "INSERT INTO inventory_item(id, product_name, model, storage_capacity, color, quantity, production_date, expiration_date) " +
	                  "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
	     return jdbcTemplate.update(sql, inventoryItem.getId(), inventoryItem.getProductName(), inventoryItem.getModel(),
	                                inventoryItem.getStorageCapacity(), inventoryItem.getColor(),
	                                inventoryItem.getQuantity(), inventoryItem.getProductionDate(),
	                                inventoryItem.getExpirationDate());
	 }


	 @Override
	 public int update(inventory_item inventoryItem, int id) {
	     String sql = "UPDATE inventory_item SET product_name=?, model=?, storage_capacity=?, color=?, quantity=?, production_date=?, expiration_date=? WHERE id=?";
	     return jdbcTemplate.update(sql, inventoryItem.getProductName(), inventoryItem.getModel(),
	                                inventoryItem.getStorageCapacity(), inventoryItem.getColor(),
	                                inventoryItem.getQuantity(), inventoryItem.getProductionDate(),
	                                inventoryItem.getExpirationDate(), id);
	 }


	    @Override
	    public int delete(int id) {
	        String sql = "DELETE FROM inventory_item WHERE id=?";
	        return jdbcTemplate.update(sql, id);
	    }

	    @Override
	    public List<inventory_item> getAllInventoryItems() {
	        String sql = "SELECT * FROM inventory_item";
	        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(inventory_item.class));
	    }

	    @Override
	    public inventory_item getInventoryItemById(int id) {
	        String sql = "SELECT * FROM inventory_item WHERE id=?";
	        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(inventory_item.class), id);
	    }
	    @Override
	    public List<inventory_item> getExpiringItems(LocalDate expirationDate) {
	        String sql = "SELECT * FROM inventory_item WHERE expiration_date >= ?";
	        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(inventory_item.class), expirationDate);
	    }
	    @Override
	    public List<inventory_item> getItemsInRange(int startId, int endId) {
	        String sql = "SELECT * FROM inventory_item WHERE id BETWEEN ? AND ?";
	        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(inventory_item.class), startId, endId);
	    }
	    @Override
	    public List<inventory_item> getItemsByProductName(String productName) {
	        String sql = "SELECT * FROM inventory_item WHERE product_name = ?";
	        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(inventory_item.class), productName);
	    }
	    @Override
	    public List<inventory_item> getItemsWithQuantityLessThan(int maxQuantity) {
	        String sql = "SELECT * FROM inventory_item WHERE quantity < ?";
	        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(inventory_item.class), maxQuantity);
	    }

	    @Override
	    public List<inventory_item> getItemsWithQuantityGreaterThan(int minQuantity) {
	        String sql = "SELECT * FROM inventory_item WHERE quantity > ?";
	        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(inventory_item.class), minQuantity);
	    }
	    @Override
	    public void updateQuantity(int inventoryItemId, int quantityChange) {
	        String sql = "UPDATE inventory_item SET quantity = quantity + ? WHERE id = ?";
	        jdbcTemplate.update(sql, quantityChange, inventoryItemId);
	    }

	}

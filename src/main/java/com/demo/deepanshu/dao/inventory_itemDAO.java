package com.demo.deepanshu.dao;
import com.demo.deepanshu.model.inventory_item;
import java.util.List;
import java.time.LocalDate;
public interface inventory_itemDAO {
	int save(inventory_item inventoryItem);
    int update(inventory_item inventoryItem, int id);
    int delete(int id);
    List<inventory_item> getAllInventoryItems();
    inventory_item getInventoryItemById(int id);
    List<inventory_item> getExpiringItems(LocalDate expirationDate);
    List<inventory_item> getItemsInRange(int startId, int endId);
    List<inventory_item> getItemsByProductName(String productName);
    List<inventory_item> getItemsWithQuantityLessThan(int maxQuantity);
    List<inventory_item> getItemsWithQuantityGreaterThan(int minQuantity);
    void updateQuantity(int inventoryItemId, int quantityChange);		// TODO Auto-generated method stub
		
	}


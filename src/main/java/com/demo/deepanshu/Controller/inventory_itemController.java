package com.demo.deepanshu.Controller;
import com.demo.deepanshu.dao.inventory_itemDAO;
import com.demo.deepanshu.model.inventory_item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.*;
@RestController
@RequestMapping("/api/inventory")
public class inventory_itemController {
	    @Autowired
	    private inventory_itemDAO inventory_itemDAO;

	    @GetMapping("/items")
	    public List<inventory_item> getAllInventoryItems() {
	        return inventory_itemDAO.getAllInventoryItems();
	    }

	    @GetMapping("/items/{id}")
	    public inventory_item getInventoryItemById(@PathVariable int id) {
	        return inventory_itemDAO.getInventoryItemById(id);
	    }

	    @PostMapping("/item")
	    public String addInventoryItem(@RequestBody inventory_item inventoryItem) {
	        int rowsAffected = inventory_itemDAO.save(inventoryItem);

	        if (rowsAffected > 0) {
	            return "Inventory item added successfully";
	        } else {
	            return "Failed to add inventory item";
	        }
	    }

	    @PutMapping("/item/{id}")
	    public String updateInventoryItem(@RequestBody inventory_item inventoryItem, @PathVariable int id) {
	        int rowsAffected = inventory_itemDAO.update(inventoryItem, id);

	        if (rowsAffected > 0) {
	            return "Inventory item updated successfully";
	        } else {
	            return "Failed to update inventory item";
	        }
	    }

	    @DeleteMapping("/item/{id}")
	    public String deleteInventoryItem(@PathVariable int id) {
	        int rowsAffected = inventory_itemDAO.delete(id);

	        if (rowsAffected > 0) {
	            return "Inventory item deleted successfully";
	        } else {
	            return "Failed to delete inventory item";
	        }
	    }
	    @GetMapping("/expiring-items/{expirationDate}")
	    public List<inventory_item> getExpiringItems(@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate expirationDate) {
	        return inventory_itemDAO.getExpiringItems(expirationDate);
	    }

	    @GetMapping("/items/quantity/less-than/{maxQuantity}")
	    public List<inventory_item> getItemsWithQuantityLessThan(@PathVariable int maxQuantity) {
	        return inventory_itemDAO.getItemsWithQuantityLessThan(maxQuantity);
	    }
	    @GetMapping("/items/quantity/greater-than/{minQuantity}")
	    public List<inventory_item> getItemsWithQuantityGreaterThan(@PathVariable int minQuantity) {
	        return inventory_itemDAO.getItemsWithQuantityGreaterThan(minQuantity);
	    }
	    @GetMapping("/items/range/{startId}/{endId}")
	    public List<inventory_item> getItemsInRange(@PathVariable int startId, @PathVariable int endId) {
	        return inventory_itemDAO.getItemsInRange(startId, endId);
	    }
	    @GetMapping("/items/product/{productName}")
	    public List<inventory_item> getItemsByProductName(@PathVariable String productName) {
	        return inventory_itemDAO.getItemsByProductName(productName);
	    }

	}


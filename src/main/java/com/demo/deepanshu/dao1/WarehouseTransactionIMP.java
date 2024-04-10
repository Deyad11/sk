package com.demo.deepanshu.dao1;

import com.demo.deepanshu.dao.inventory_itemDAO;
import com.demo.deepanshu.model.inventory_item;
import com.demo.deepanshu.model1.WarehouseTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class WarehouseTransactionIMP implements WarehouseTransactionDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private inventory_itemDAO inventoryItemDAO;

    @Override
    @Transactional
    public void save(WarehouseTransaction warehouseTransaction) {
        String sql = "INSERT INTO warehouse_transaction (warehouse_id, inventory_item_id, quantity, transaction_type, transaction_date) " +
                "VALUES (?, ?, ?, ?, CURRENT_TIMESTAMP)";
        jdbcTemplate.update(sql,
                warehouseTransaction.getWarehouseId(),
                warehouseTransaction.getInventoryItemId(),
                warehouseTransaction.getQuantity(),
                warehouseTransaction.getTransactionType());

        // Update inventory quantity
        if (warehouseTransaction.getTransactionType().equals("RECEIVE")) {
            inventoryItemDAO.updateQuantity(warehouseTransaction.getInventoryItemId(), warehouseTransaction.getQuantity());
        } else if (warehouseTransaction.getTransactionType().equals("DISPATCH")) {
            inventoryItemDAO.updateQuantity(warehouseTransaction.getInventoryItemId(), -warehouseTransaction.getQuantity());
        }
    }

    @Override
    public List<WarehouseTransaction> getTransactionsByWarehouse(Long warehouseId) {
        String sql = "SELECT * FROM warehouse_transaction WHERE warehouse_id = ?";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(WarehouseTransaction.class), warehouseId);
    }

    @Override
    public List<WarehouseTransaction> getAllTransactions() {
        String sql = "SELECT * FROM warehouse_transaction";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(WarehouseTransaction.class));
    }
    
}

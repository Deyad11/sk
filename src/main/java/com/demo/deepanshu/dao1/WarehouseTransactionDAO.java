package com.demo.deepanshu.dao1;
import com.demo.deepanshu.model.inventory_item;
import com.demo.deepanshu.model1.*;
import java.util.List;

import com.demo.deepanshu.model1.WarehouseTransaction;
public interface WarehouseTransactionDAO {
	List<WarehouseTransaction> getTransactionsByWarehouse(Long warehouseId);
    List<WarehouseTransaction> getAllTransactions();
    void save(WarehouseTransaction warehouseTransaction);}

package com.demo.deepanshu.Controller1;
import com.demo.deepanshu.model.*;
import com.demo.deepanshu.dao.inventory_itemDAO;
import com.demo.deepanshu.dao1.WarehouseTransactionDAO;
import com.demo.deepanshu.dao1.WarehouseTransactionIMP;
import com.demo.deepanshu.model1.WarehouseTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/warehouse")
public class WarehouseTransactionController {

    @Autowired
    private WarehouseTransactionDAO warehouseTransactionDAO;
    @Autowired
    private WarehouseTransactionIMP warehouseTransactionIMP;

    @PostMapping("/saveTransaction")
    public String saveTransaction(@RequestBody WarehouseTransaction warehouseTransaction) {
        try {
            warehouseTransactionIMP.save(warehouseTransaction);
            return "Transaction saved successfully";
        } catch (Exception e) {
            return "Failed to save transaction: " + e.getMessage();
        }
    }
    @GetMapping("/transactions/{warehouseId}")
    public List<WarehouseTransaction> getTransactionsByWarehouse(@PathVariable Long warehouseId) {
        return warehouseTransactionDAO.getTransactionsByWarehouse(warehouseId);
    }

    @GetMapping("/transactions")
    public List<WarehouseTransaction> getAllTransactions() {
        return warehouseTransactionDAO.getAllTransactions();
    }

}

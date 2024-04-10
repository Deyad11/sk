package com.demo.deepanshu.model1;

import java.util.Date;

public class WarehouseTransaction {
	private Long id;
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getWarehouseId() {
		return warehouseId;
	}

	public void setWarehouseId(Long warehouseId) {
		this.warehouseId = warehouseId;
	}

	public int getInventoryItemId() {
		return inventoryItemId;
	}

	public void setInventoryItemId(int inventoryItemId) {
		this.inventoryItemId = inventoryItemId;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	private Long warehouseId;
    private int inventoryItemId;
    private Integer quantity;
    private String transactionType;
    private Date transactionDate;

    public WarehouseTransaction(Long id, Long warehouseId, int inventoryItemId, Integer quantity, String transactionType, Date transactionDate) {
        this.id = id;
        this.warehouseId = warehouseId;
        this.inventoryItemId = inventoryItemId;
        this.quantity = quantity;
        this.transactionType = transactionType;
        this.transactionDate = transactionDate;
    }

    public WarehouseTransaction() {
    }
}

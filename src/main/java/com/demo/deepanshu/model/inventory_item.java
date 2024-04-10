package com.demo.deepanshu.model;
import java.sql.Date;

public class inventory_item {
	private int id;
    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getStorageCapacity() {
		return storageCapacity;
	}

	public void setStorageCapacity(int storageCapacity) {
		this.storageCapacity = storageCapacity;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Date getProductionDate() {
		return productionDate;
	}

	public void setProductionDate(Date productionDate) {
		this.productionDate = productionDate;
	}

	public Date getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}

	private String productName;
    private String model;
    private int storageCapacity;
    private String color;
    private int quantity;
    private Date productionDate;
    private Date expirationDate;

    // Default constructor (no-args)
    public inventory_item() {
    }

    // Parameterized constructor
    public inventory_item(int id, String productName, String model, int storageCapacity,
                         String color, int quantity, Date productionDate, Date expirationDate) {
        this.id = id;
        this.productName = productName;
        this.model = model;
        this.storageCapacity = storageCapacity;
        this.color = color;
        this.quantity = quantity;
        this.productionDate = productionDate;
        this.expirationDate = expirationDate;
    }
}
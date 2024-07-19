package com.admin;

public class orderitem {

	private int orderno;
    private String category;
    private String name;
    private String size;
    private int quantity;
    private String supplierid;
    
    //overloaded constructor
	public orderitem(int orderno, String category, String name, String size, int quantity, String supplierid) {
		super();
		this.orderno = orderno;
		this.category = category;
		this.name = name;
		this.size = size;
		this.quantity = quantity;
		this.supplierid = supplierid;
	}

	//get methods
	public int getOrderno() {
		return orderno;
	}

	public String getCategory() {
		return category;
	}

	public String getName() {
		return name;
	}

	public String getSize() {
		return size;
	}

	public int getQuantity() {
		return quantity;
	}

	public String getSupplierid() {
		return supplierid;
	}


}

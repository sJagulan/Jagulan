package com.jagulan.s3881257.model;

public class Item {

    public Item() {

    }

    public Item(Integer id, String name, String desc, Double price) {
        super();
        this.id = id;
        this.name = name;
        this.desc = desc;
        this.price = price;
    }
 
    private Integer id;
    private String name;
    private String desc;
    private Double price;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Employee [id=" + id + ", name=" + name + ", desc=" + desc + ", price=" + price + "]";
    }
}

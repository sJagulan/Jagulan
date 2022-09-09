package com.jagulan.s3881257.dao;

import com.jagulan.s3881257.model.Item;
import org.springframework.stereotype.Repository;

import com.jagulan.s3881257.model.Items;

@Repository
public class ItemDAO
{
    private static Items list = new Items();
    
    static 
    {
        list.getItemList().add(new Item(1, "Lokesh", "Gupta", 0.99));
        list.getItemList().add(new Item(2, "Alex", "Kolenchiskey", 2.35));
        list.getItemList().add(new Item(3, "David", "Kameron", 5.63));
    }
    
    public Items getAllItems()
    {
        return list;
    }
    
    public void addItem(Item employee) {
        list.getItemList().add(employee);
    }
}

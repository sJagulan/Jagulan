package com.jagulan.s3881257.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.jagulan.s3881257.dao.ItemDAO;
import com.jagulan.s3881257.model.Item;
import com.jagulan.s3881257.model.Items;

@RestController
@RequestMapping(path = "/employees")
public class item_controller
{
    @Autowired
    private ItemDAO itemDao;

    @GetMapping(path="/", produces = "application/json")
    public Items getItems()
    {
        return itemDao.getAllItems();
    }

    @PostMapping(path= "/", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Object> addItem(
            @RequestHeader(name = "X-COM-PERSIST", required = true) String headerPersist,
            @RequestHeader(name = "X-COM-LOCATION", required = false, defaultValue = "ASIA") String headerLocation,
            @RequestBody Item item)
            throws Exception
    {
        //Generate resource id
        Integer id = itemDao.getAllItems().getItemList().size() + 1;
        item.setId(id);

        //add resource
        itemDao.addItem(item);

        //Create resource location
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(item.getId())
                .toUri();

        //Send location in response
        return ResponseEntity.created(location).build();
    }
}

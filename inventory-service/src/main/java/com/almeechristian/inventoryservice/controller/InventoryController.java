package com.almeechristian.inventoryservice.controller;

import com.almeechristian.inventoryservice.dto.InventoryResponse;
import com.almeechristian.inventoryservice.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping("/api/inventory")
@RequiredArgsConstructor
@RestController
public class InventoryController {

    private final InventoryService inventoryService;

    // "http://localhost:8082/api/inventory/iphone-13,iphone13-red" => Path variable
    // "http://localhost:8082/api/inventory?sku-code=iphone-13&sku-code=iphone13-red" => Request Parameters
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<InventoryResponse> isInStock(@RequestParam List<String> skuCode){

        return inventoryService.isInStock(skuCode);
    }
}

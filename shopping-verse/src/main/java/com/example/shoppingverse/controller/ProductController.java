package com.example.shoppingverse.controller;

import com.example.shoppingverse.dto.requestDto.ProductRequestDto;
import com.example.shoppingverse.dto.responseDto.ProductResponseDto;
import com.example.shoppingverse.exception.SellerNotFoundException;
import com.example.shoppingverse.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping("/add")
    public ResponseEntity addProduct(@RequestBody ProductRequestDto productRequestDto)
    {
        try
        {
            ProductResponseDto productResponseDto=productService.addProduct(productRequestDto);
            return new ResponseEntity(productResponseDto, HttpStatus.CREATED);
        }
        catch (SellerNotFoundException e)
        {
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
}

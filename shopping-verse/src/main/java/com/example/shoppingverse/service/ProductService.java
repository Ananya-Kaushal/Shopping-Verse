package com.example.shoppingverse.service;

import com.example.shoppingverse.dto.requestDto.ProductRequestDto;
import com.example.shoppingverse.dto.responseDto.ProductResponseDto;
import com.example.shoppingverse.exception.SellerNotFoundException;
import com.example.shoppingverse.model.Product;
import com.example.shoppingverse.model.Seller;
import com.example.shoppingverse.repository.ProductRepository;
import com.example.shoppingverse.repository.SellerRepository;
import com.example.shoppingverse.transformer.ProductTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    SellerRepository sellerRepository;

    @Autowired
    ProductRepository productRepository;

    public ProductResponseDto addProduct(ProductRequestDto productRequestDto) {

        //check if seller exists or not
        Seller seller=sellerRepository.findByEmailId(productRequestDto.getSellerEmail());
        if(seller==null)
        {
            throw new SellerNotFoundException("Seller does not exist.");
        }

        //Dto->Entity
        Product product= ProductTransformer.ProductRequestDtoToProduct(productRequestDto);
        product.setSeller(seller);
        seller.getProducts().add(product);

        //Save the Parent entity
        Seller savedSeller=sellerRepository.save(seller);//save both product and seller

        List<Product> products=savedSeller.getProducts();
        Product latestProduct=products.get(products.size()-1);

        //Entity -> Dto
        ProductResponseDto productResponseDto=ProductTransformer.ProductToProductResponseDto(latestProduct);
        return productResponseDto;
    }
}

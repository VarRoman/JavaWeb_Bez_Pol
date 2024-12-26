package com.example.cosmocatsmarket.web.mapper;

import com.example.cosmocatsmarket.domain.Product;
import com.example.cosmocatsmarket.dto.ProductDto;
import com.example.cosmocatsmarket.dto.ProductEntry;
import com.example.cosmocatsmarket.dto.ProductListDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper(componentModel = "spring")
public interface ProductMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "name", source = "name")
    @Mapping(target = "description", source = "description")
    @Mapping(target = "price", source = "price")
    Product toProduct(ProductDto productDto);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "description", source = "description")
    @Mapping(target = "price", source = "price")
    @Mapping(target = "rating", ignore = true)
    ProductEntry toProductEntry(Product product);

    List<ProductEntry> toProductEntries(List<Product> products);

    default ProductListDto toProductListDto(List<Product> products) {
        return ProductListDto.builder().productEntries(toProductEntries(products)).build();
    }
}

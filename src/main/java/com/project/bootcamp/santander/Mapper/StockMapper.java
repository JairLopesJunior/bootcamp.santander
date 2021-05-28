package com.project.bootcamp.santander.Mapper;

import com.project.bootcamp.santander.model.dto.StockDTO;
import com.project.bootcamp.santander.model.entity.Stock;
import org.springframework.stereotype.Component;

@Component
public class StockMapper {


    public Stock toEntity(StockDTO dto) {
        Stock stock = new Stock();
        stock.setId(dto.getId());
        stock.setName(dto.getName());
        stock.setPrice(dto.getPrice());
        stock.setVariation(dto.getVariation());
        stock.setData(dto.getDate());
        return stock;
    }

    public StockDTO toDTO(Stock stock) {
        StockDTO dto = new StockDTO();
        dto.setId(stock.getId());
        dto.setName(stock.getName());
        dto.setPrice(stock.getPrice());
        dto.setVariation(stock.getVariation());
        dto.setDate(stock.getData());
        return dto;
    }
}

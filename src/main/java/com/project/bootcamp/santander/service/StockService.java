package com.project.bootcamp.santander.service;

import com.project.bootcamp.santander.Mapper.StockMapper;
import com.project.bootcamp.santander.model.dto.StockDTO;
import com.project.bootcamp.santander.model.entity.Stock;
import com.project.bootcamp.santander.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class StockService {

    private StockRepository repository;
    private StockMapper mapper;

    @Autowired
    public StockService(StockRepository repository) {
        this.repository = repository;
    }

    public StockService(StockMapper mapper) {
        this.mapper = mapper;
    }

    @Transactional
    public StockDTO save(StockDTO dto) {
        Stock stock = mapper.toEntity(dto);
        repository.save(stock);
        return mapper.toDTO(stock);
    }
}

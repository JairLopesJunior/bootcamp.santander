package com.project.bootcamp.santander.service;

import com.project.bootcamp.santander.Mapper.StockMapper;
import com.project.bootcamp.santander.exceptions.BusinessException;
import com.project.bootcamp.santander.exceptions.NotFoundException;
import com.project.bootcamp.santander.model.dto.StockDTO;
import com.project.bootcamp.santander.model.entity.Stock;
import com.project.bootcamp.santander.repository.StockRepository;
import com.project.bootcamp.santander.util.MessageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class StockService {

    @Autowired
    private StockRepository repository;
    @Autowired
    private StockMapper mapper;

    @Transactional
    public StockDTO save(StockDTO dto) {
        Optional<Stock> optional  = repository.findByNameAndDate(dto.getName(), dto.getDate());
        if(optional.isPresent()){
            throw new BusinessException(MessageUtils.STOCK_ALREADY_EXISTS);
        }
        Stock stock = mapper.toEntity(dto);
        repository.save(stock);
        return mapper.toDTO(stock);
    }

    @Transactional
    public StockDTO update(StockDTO dto){
        Optional<Stock> optional  = repository.findByStockUpdate(dto.getName(), dto.getDate(), dto.getId());
        if(optional.isPresent()){
            throw new BusinessException(MessageUtils.STOCK_ALREADY_EXISTS);
        }
        Stock stock = mapper.toEntity(dto);
        repository.save(stock);
        return mapper.toDTO(stock);
    }

    public List<StockDTO> findAll(){
        List<Stock> list = repository.findAll();
        return mapper.toDTO(list);
    }

    public StockDTO findById(Long id){
        return repository.findById(id)
                .map(mapper::toDTO)
                .orElseThrow(NotFoundException::new);
    }

    @Transactional
    public StockDTO delete(Long id){
        StockDTO dto = this.findById(id);
        repository.deleteById(dto.getId());
        return dto;
    }

    public List<StockDTO> findByToday(){
        return repository.findByToday(LocalDate.now())
                .map(mapper::toDTO)
                .orElseThrow(NotFoundException::new);
    }
}

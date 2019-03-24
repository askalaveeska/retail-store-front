package com.aska.admin.store.controller;


import com.aska.admin.store.mapper.StoreMapper;
import com.aska.admin.store.model.StoreDTO;
import com.aska.admin.store.repository.StoreRepository;
import com.aska.admin.store.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class StoreController {

    @Autowired
    private StoreService storeService;

    @Autowired
    private StoreRepository storeRepository;

    @Autowired
    private StoreMapper storeMapper;

    @GetMapping(name = "api/store/{storeId}")
    public ResponseEntity<StoreDTO> getStoreDetails(@PathVariable long storeId){
        return ResponseEntity.ok(storeService.findByStoreId(storeId));
    }
    @PostMapping(name = "api/store")
    public ResponseEntity createStore(@RequestBody final StoreDTO storeDTO){
        final Boolean isExists =  storeRepository.existsByStoreName(storeDTO.getStoreName());
        if (isExists){
            return ResponseEntity.badRequest().build();
        }
        else{
            storeService.save(storeDTO);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }

    }

    @PutMapping(name = "api/store")
    public ResponseEntity updateStore(@RequestBody final StoreDTO storeDTO){
        return ResponseEntity.ok(storeRepository.save(storeMapper.from(storeDTO)));
    }

    @DeleteMapping("api/store/{storeId}")
    public ResponseEntity removeStore(@PathVariable final long storeId){
        storeRepository.deleteById(storeId);
        return ResponseEntity.ok().build();
    }
}

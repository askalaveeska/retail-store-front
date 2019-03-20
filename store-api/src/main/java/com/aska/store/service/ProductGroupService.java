package com.aska.store.service;

import com.aska.store.model.ProductGroupDTO;
import org.springframework.stereotype.Service;

/**
 * Created by ppalpandi on 3/10/2019.
 */
public interface ProductGroupService {

    ProductGroupDTO findByStoreId(final long store);
    ProductGroupDTO findByProductGroupId(final long productGroupId);
}

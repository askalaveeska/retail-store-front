package com.aska.admin.store.repository;

import com.aska.store.entity.RequestEntity;

import java.util.List;

/**
 * Created by ppalpandi on 3/10/2019.
 */
public interface RequestRepository{

    RequestEntity findByRequestId(final long requestId);
    List<RequestEntity> findAllByUserId(final long userId);

}

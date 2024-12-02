package org.delivery.storeadmin.domain.storeuser.business;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.delivery.db.store.StoreRepository;
import org.delivery.db.store.enums.StoreStatus;
import org.delivery.storeadmin.domain.storeuser.controller.model.StoreUserRegisterRequest;
import org.delivery.storeadmin.domain.storeuser.controller.model.StoreUserResponse;
import org.delivery.storeadmin.domain.storeuser.converter.StoreUserConverter;
import org.delivery.storeadmin.domain.storeuser.service.StoreUserService;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
@Slf4j
public class StoreUserBusiness {

    private final StoreUserConverter storeUserConverter;
    private final StoreUserService storeUserService;

    private final StoreRepository storeRepository;  // TODO SERVICE 로 변경하기


    public StoreUserResponse register(
            StoreUserRegisterRequest request
    ){
        log.info("Registering store user for store: {}", request.getStoreName());
        var storeEntity = storeRepository.findFirstByNameAndStatusOrderByIdDesc(request.getStoreName(), StoreStatus.REGISTERED);

        var entity = storeUserConverter.toEntity(request, storeEntity.get());

        var newEntity = storeUserService.register(entity);

        var response = storeUserConverter.toResponse(newEntity, storeEntity.get());

        log.info("Store user registered successfully: {}", newEntity);

        return response;
    }
}

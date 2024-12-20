package org.delivery.api.domain.user.service;

import lombok.RequiredArgsConstructor;
import org.delivery.common.error.ErrorCode;
import org.delivery.common.error.UserErrorCode;
import org.delivery.common.exception.ApiException;
import org.delivery.db.user.UserEntity;
import org.delivery.db.user.UserRepository;
import org.delivery.db.store.enums.StoreStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

/*
    * User 도메인 로직을 처리 하는 서비스
* */
@RequiredArgsConstructor
@Service
@Transactional
public class UserService {

    private final UserRepository userRepository;

    public UserEntity register(UserEntity userEntity){
        return Optional.ofNullable(userEntity)
                .map(it ->{
                    userEntity.setStatus(StoreStatus.REGISTERED);
                    userEntity.setRegisteredAt(LocalDateTime.now());
                    return userRepository.save(userEntity);

                })
                .orElseThrow(()-> new ApiException(ErrorCode.NULL_POINT,"User Entity Null"));
    }

    public UserEntity login(
            String email,
            String password
    ){
        var entity = getUserWithrow(email,password);
        return entity;
    }

    public UserEntity getUserWithrow(
            String email,
            String password
    ){
        return userRepository.findFirstByEmailAndPasswordAndStatusOrderByIdDesc(
                email,
                password,
                StoreStatus.REGISTERED
        ).orElseThrow(()-> new ApiException(UserErrorCode.USER_NOT_FOUND));
    }

    public UserEntity getUserWithrow(
            Long userId
    ){
        return userRepository.findFirstByIdAndStatusOrderByIdDesc(
                userId,
                StoreStatus.REGISTERED
        ).orElseThrow(()-> new ApiException(UserErrorCode.USER_NOT_FOUND));
    }
}

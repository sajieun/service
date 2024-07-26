package org.delivery.api.domain.user.business;

import lombok.RequiredArgsConstructor;
import org.delivery.api.commen.annotation.Business;
import org.delivery.api.domain.user.controller.model.UserLoginRequest;
import org.delivery.api.domain.user.controller.model.UserRegisterRequest;
import org.delivery.api.domain.user.controller.model.UserResponse;
import org.delivery.api.domain.user.converter.UserConverter;
import org.delivery.api.domain.user.service.UserService;

@RequiredArgsConstructor
@Business
public class UserBusiness {

    private final UserService userService;
    private final UserConverter userConverter;

    /**
     * 사용자에 대한 가입처리 로직
     * 1. request -> entity
     * 2. entity -> save
     * 3. save Entity -> response
     * 4. response return
     */
    public UserResponse register(UserRegisterRequest request) {

        var entity = userConverter.toEntity(request);
        var newEntity = userService.register(entity);
        var response = userConverter.toResponse(newEntity);
        return response;

        /*return Optional.ofNullable(request)
            .map(userConverter::toEntity)
            .map(userService::register)
            .map(userConverter::toResponse)
            .orElseThrow(() -> new ApiException(ErrorCode.NULL_POINT, "request null"));*/
    }

/*
    * 1. email, password 를 가지고 사용자 체크
    * 2. user entity 로그인 확인
    * 3. token 생성
    * 3. token response
* */
    public UserResponse login(UserLoginRequest request) {
        var userEntity = userService.login(request.getEmail(),request.getPassword());

        // 사용자 없으면 throw
        return userConverter.toResponse(userEntity);
    }
}
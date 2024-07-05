package org.delivery.api.account;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.delivery.api.account.model.AccountMeResponse;
import org.delivery.api.commen.api.Api;
import org.delivery.api.commen.error.UserErrorCode;
import org.delivery.db.account.AccountEntity;
import org.delivery.db.account.AccountRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/account")
public class AccountApiController {

    private final AccountRepository accountRepository;

// http://localhost:8080/api/account/me
    @GetMapping("/me")
    public Api<Object> me(){
        var response = AccountMeResponse.builder()
                .name("sajieun")
                .email("A@gamil.com")
                .registeredAt(LocalDateTime.now())
                .build();
        return Api.ERROR(UserErrorCode.USER_NOT_FOUND, "홍길동이라는 사람 없음");
    }
}

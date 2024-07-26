package org.delivery.api.domain.user.service;

import lombok.RequiredArgsConstructor;
import org.delivery.db.user.UserRepository;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
}

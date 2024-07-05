package org.delivery.api.commen.error;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum ErrorCode {

    OK(200,200,"성공"),
    ;

    // 변경되지 않아야 하기에 final
    private final Integer httpStatusCode;

    private final Integer errorCode;

    private final String description;

}

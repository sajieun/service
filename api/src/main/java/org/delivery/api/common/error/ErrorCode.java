package org.delivery.api.common.error;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public enum ErrorCode implements ErrorCodeIfs{

    OK(200,200,"성공"),

    BAD_REQUEST(HttpStatus.BAD_REQUEST.value(),400,"잘못된 요청"),

    SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR.value(),500,"서버에러" ),

    NULL_POINT(HttpStatus.INTERNAL_SERVER_ERROR.value(), 512,"Null point")
    ;

    // 변경되지 않아야 하기에 final
    private final Integer httpStatusCode;

    private final Integer errorCode;

    private final String description;

//    이걸 간단하게 하려면 @Getter 해주면 됨
//    @Override
//    public Integer getHttpStatusCode() {
//        return this.httpStatusCode;
//    }
//
//    @Override
//    public Integer getErrorCode() {
//        return this.errorCode;
//    }
//
//    @Override
//    public String getDescription() {
//        return this.description;
//    }

}

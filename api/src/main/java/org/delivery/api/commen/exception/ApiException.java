package org.delivery.api.commen.exception;

import lombok.Getter;
import org.delivery.api.commen.error.ErrorCodeIfs;

@Getter
public class ApiException extends RuntimeException implements ApiExceptionIfs{
    private final ErrorCodeIfs errorCodeIfs;

    private final String errorDescription;

    public ApiException(ErrorCodeIfs errorCodeIfs){
        super(errorCodeIfs.getDescription());
        this.errorCodeIfs =errorCodeIfs;
        this.errorDescription = errorCodeIfs.getDescription();

    }

    public ApiException(ErrorCodeIfs errorCodeIfs, String errorDescription){
        super(errorDescription);
        this.errorCodeIfs =errorCodeIfs;
        this.errorDescription = errorCodeIfs.getDescription();
    }

    public ApiException(ErrorCodeIfs errorCodeIfs, Throwable tx,String errorDescription){
        super(tx);
        this.errorCodeIfs =errorCodeIfs;
        this.errorDescription = errorDescription;
    }

    @Override
    public String getErrorCodeDescription() {
        return "";
    }
}

package org.delivery.api.commen.exception;

import org.delivery.api.commen.error.ErrorCodeIfs;

public interface ApiExceptionIfs {

    ErrorCodeIfs getErrorCodeIfs();

    String getErrorCodeDescription();
}

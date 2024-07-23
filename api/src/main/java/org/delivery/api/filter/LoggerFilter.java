package org.delivery.api.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;

import java.io.IOException;

@Slf4j
@Component
public class LoggerFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        // 실행 전: 요청과 응답을 ContentCachingRequestWrapper 및 ContentCachingResponseWrapper로 감싼다.
        // 이 래퍼들은 요청 및 응답 본문을 캐시하여 나중에 읽을 수 있게 해준다.
        var req = new ContentCachingRequestWrapper((HttpServletRequest) request);
        var res = new ContentCachingResponseWrapper((HttpServletResponse) response);

        log.info("INIT URL : {}", req.getRequestURI());

        // 필터 체인을 통해 요청과 응답을 전달하여 서블릿이 실제로 요청을 처리하게 한다.
        chain.doFilter(req, res);

        // 실행 후: 요청과 응답 정보를 로깅하기 위한 작업을 시작한다.

        // request 정보 로깅
        var headerNames = req.getHeaderNames();
        var headerValues = new StringBuilder();

        

        // 모든 요청 헤더를 순회하며 키-값 쌍으로 로그에 추가한다.
        headerNames.asIterator().forEachRemaining(headerKey -> {
            var headerValue = req.getHeader(headerKey);
            // 예시: authorization-token : ??? , user-agent : ???
            headerValues
                    .append("[")
                    .append(headerKey)
                    .append(" : ")
                    .append(headerValue)
                    .append("]");
        });

        // 요청 본문을 가져와서 문자열로 변환한다.
        var requestBody = new String(req.getContentAsByteArray());
        var uri = req.getRequestURI();
        var method = req.getMethod();

        // 요청 헤더와 본문을 로그에 출력한다.
        log.info(">>>> url : {} , method : {} , header : {}, body : {}",uri, method, headerValues, requestBody);

        // response 정보 로깅
        var responseHeaderValues = new StringBuilder();

        // 모든 응답 헤더를 순회하며 키-값 쌍으로 로그에 추가한다.
        res.getHeaderNames().forEach(headerKey -> {
            var headerValue = res.getHeader(headerKey);
            responseHeaderValues
                    .append("[")
                    .append(headerKey)
                    .append(" : ")
                    .append(headerValue)
                    .append("]");
        });

        // 응답 본문을 가져와서 문자열로 변환한다.
        var responseBody = new String(res.getContentAsByteArray());

        // 응답 헤더와 본문을 로그에 출력한다.
        log.info("<<<< url : {}, mehotd : {} ,header : {} , body : {}", uri, method, responseHeaderValues, responseBody);

        // 응답 본문을 실제 응답 객체에 복사하여 클라이언트에게 전달되도록 한다.
        // 이 작업을 하지 않으면 클라이언트는 응답 본문을 받을 수 없다.
        res.copyBodyToResponse();
    }
}

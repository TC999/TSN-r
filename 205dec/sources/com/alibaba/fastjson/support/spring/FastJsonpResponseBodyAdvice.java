package com.alibaba.fastjson.support.spring;

import java.util.regex.Pattern;
import javax.servlet.http.HttpServletRequest;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.util.Assert;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
@ControllerAdvice
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class FastJsonpResponseBodyAdvice implements ResponseBodyAdvice<Object> {
    private static final Pattern CALLBACK_PARAM_PATTERN = Pattern.compile("[0-9A-Za-z_\\.]*");
    public static final String[] DEFAULT_JSONP_QUERY_PARAM_NAMES = {"callback", "jsonp"};
    private final String[] jsonpQueryParamNames;

    public FastJsonpResponseBodyAdvice() {
        this.jsonpQueryParamNames = DEFAULT_JSONP_QUERY_PARAM_NAMES;
    }

    public Object beforeBodyWrite(Object obj, MethodParameter methodParameter, MediaType mediaType, Class<? extends HttpMessageConverter<?>> cls, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        MappingFastJsonValue orCreateContainer = getOrCreateContainer(obj);
        beforeBodyWriteInternal(orCreateContainer, mediaType, methodParameter, serverHttpRequest, serverHttpResponse);
        return orCreateContainer;
    }

    public void beforeBodyWriteInternal(MappingFastJsonValue mappingFastJsonValue, MediaType mediaType, MethodParameter methodParameter, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        HttpServletRequest servletRequest = ((ServletServerHttpRequest) serverHttpRequest).getServletRequest();
        for (String str : this.jsonpQueryParamNames) {
            String parameter = servletRequest.getParameter(str);
            if (parameter != null && isValidJsonpQueryParam(parameter)) {
                serverHttpResponse.getHeaders().setContentType(getContentType(mediaType, serverHttpRequest, serverHttpResponse));
                mappingFastJsonValue.setJsonpFunction(parameter);
                return;
            }
        }
    }

    protected MediaType getContentType(MediaType mediaType, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        return new MediaType("application", "javascript");
    }

    protected MappingFastJsonValue getOrCreateContainer(Object obj) {
        return obj instanceof MappingFastJsonValue ? (MappingFastJsonValue) obj : new MappingFastJsonValue(obj);
    }

    protected boolean isValidJsonpQueryParam(String str) {
        return CALLBACK_PARAM_PATTERN.matcher(str).matches();
    }

    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> cls) {
        return FastJsonpHttpMessageConverter4.class.isAssignableFrom(cls);
    }

    public FastJsonpResponseBodyAdvice(String... strArr) {
        Assert.isTrue(!ObjectUtils.isEmpty(strArr), "At least one query param name is required");
        this.jsonpQueryParamNames = strArr;
    }
}

package com.beizi.p051ad.internal.utilities;

import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.Map;

/* renamed from: com.beizi.ad.internal.utilities.HTTPResponse */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class HTTPResponse {
    private int code;
    private HttpErrorCode errorCode;
    private Map<String, List<String>> headers;
    private String locationUrl;
    private ByteArrayOutputStream responseBinaryBody;
    private String responseBody;
    private boolean succeeded;

    public HTTPResponse() {
    }

    public int getCode() {
        return this.code;
    }

    public HttpErrorCode getErrorCode() {
        return this.errorCode;
    }

    public Map<String, List<String>> getHeaders() {
        return this.headers;
    }

    public String getLocationUrl() {
        return this.locationUrl;
    }

    public ByteArrayOutputStream getResponseBinaryBody() {
        return this.responseBinaryBody;
    }

    public String getResponseBody() {
        return this.responseBody;
    }

    public boolean getSucceeded() {
        return this.succeeded;
    }

    public void setCode(int i) {
        this.code = i;
    }

    public void setErrorCode(HttpErrorCode httpErrorCode) {
        this.errorCode = httpErrorCode;
    }

    public void setHeaders(Map<String, List<String>> map) {
        this.headers = map;
    }

    public void setLocationUrl(String str) {
        this.locationUrl = str;
    }

    public void setResponseBinaryBody(ByteArrayOutputStream byteArrayOutputStream) {
        this.responseBinaryBody = byteArrayOutputStream;
    }

    public void setResponseBody(String str) {
        this.responseBody = str;
    }

    public void setSucceeded(boolean z) {
        this.succeeded = z;
    }

    public HTTPResponse(boolean z, String str, Map<String, List<String>> map) {
        this.succeeded = z;
        this.responseBody = str;
        this.headers = map;
    }

    public HTTPResponse(boolean z, ByteArrayOutputStream byteArrayOutputStream, Map<String, List<String>> map) {
        this.succeeded = z;
        this.responseBinaryBody = byteArrayOutputStream;
        this.headers = map;
    }
}

package com.amap.api.col.p0463l;

/* renamed from: com.amap.api.col.3l.fc */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class AMapException extends Exception {

    /* renamed from: a */
    private String f4171a;

    /* renamed from: b */
    private int f4172b;

    public AMapException(String str) {
        super(str);
        this.f4172b = 1000;
        this.f4171a = str;
        m55009a(str);
    }

    /* renamed from: a */
    public final String m55010a() {
        return this.f4171a;
    }

    /* renamed from: a */
    private void m55009a(String str) {
        if ("用户签名未通过".equals(str)) {
            this.f4172b = 1001;
        } else if (com.amap.api.services.core.AMapException.AMAP_INVALID_USER_KEY.equals(str)) {
            this.f4172b = 1002;
        } else if (com.amap.api.services.core.AMapException.AMAP_SERVICE_NOT_AVAILBALE.equals(str)) {
            this.f4172b = 1003;
        } else if (com.amap.api.services.core.AMapException.AMAP_DAILY_QUERY_OVER_LIMIT.equals(str)) {
            this.f4172b = 1004;
        } else if (com.amap.api.services.core.AMapException.AMAP_ACCESS_TOO_FREQUENT.equals(str)) {
            this.f4172b = 1005;
        } else if (com.amap.api.services.core.AMapException.AMAP_INVALID_USER_IP.equals(str)) {
            this.f4172b = 1006;
        } else if (com.amap.api.services.core.AMapException.AMAP_INVALID_USER_DOMAIN.equals(str)) {
            this.f4172b = 1007;
        } else if (com.amap.api.services.core.AMapException.AMAP_INVALID_USER_SCODE.equals(str)) {
            this.f4172b = 1008;
        } else if (com.amap.api.services.core.AMapException.AMAP_USERKEY_PLAT_NOMATCH.equals(str)) {
            this.f4172b = 1009;
        } else if (com.amap.api.services.core.AMapException.AMAP_IP_QUERY_OVER_LIMIT.equals(str)) {
            this.f4172b = 1010;
        } else if (com.amap.api.services.core.AMapException.AMAP_NOT_SUPPORT_HTTPS.equals(str)) {
            this.f4172b = 1011;
        } else if (com.amap.api.services.core.AMapException.AMAP_INSUFFICIENT_PRIVILEGES.equals(str)) {
            this.f4172b = 1012;
        } else if (com.amap.api.services.core.AMapException.AMAP_USER_KEY_RECYCLED.equals(str)) {
            this.f4172b = 1013;
        } else if (com.amap.api.services.core.AMapException.AMAP_ENGINE_RESPONSE_ERROR.equals(str)) {
            this.f4172b = 1100;
        } else if (com.amap.api.services.core.AMapException.AMAP_ENGINE_RESPONSE_DATA_ERROR.equals(str)) {
            this.f4172b = com.amap.api.services.core.AMapException.CODE_AMAP_ENGINE_RESPONSE_DATA_ERROR;
        } else if (com.amap.api.services.core.AMapException.AMAP_ENGINE_CONNECT_TIMEOUT.equals(str)) {
            this.f4172b = com.amap.api.services.core.AMapException.CODE_AMAP_ENGINE_CONNECT_TIMEOUT;
        } else if (com.amap.api.services.core.AMapException.AMAP_ENGINE_RETURN_TIMEOUT.equals(str)) {
            this.f4172b = com.amap.api.services.core.AMapException.CODE_AMAP_ENGINE_RETURN_TIMEOUT;
        } else if (com.amap.api.services.core.AMapException.AMAP_SERVICE_INVALID_PARAMS.equals(str)) {
            this.f4172b = com.amap.api.services.core.AMapException.CODE_AMAP_SERVICE_INVALID_PARAMS;
        } else if (com.amap.api.services.core.AMapException.AMAP_SERVICE_MISSING_REQUIRED_PARAMS.equals(str)) {
            this.f4172b = com.amap.api.services.core.AMapException.CODE_AMAP_SERVICE_MISSING_REQUIRED_PARAMS;
        } else if (com.amap.api.services.core.AMapException.AMAP_SERVICE_ILLEGAL_REQUEST.equals(str)) {
            this.f4172b = com.amap.api.services.core.AMapException.CODE_AMAP_SERVICE_ILLEGAL_REQUEST;
        } else if (com.amap.api.services.core.AMapException.AMAP_SERVICE_UNKNOWN_ERROR.equals(str)) {
            this.f4172b = com.amap.api.services.core.AMapException.CODE_AMAP_SERVICE_UNKNOWN_ERROR;
        } else if ("协议解析错误 - ProtocolException".equals(str)) {
            this.f4172b = com.amap.api.services.core.AMapException.CODE_AMAP_CLIENT_ERROR_PROTOCOL;
        } else if ("socket 连接超时 - SocketTimeoutException".equals(str)) {
            this.f4172b = com.amap.api.services.core.AMapException.CODE_AMAP_CLIENT_SOCKET_TIMEOUT_EXCEPTION;
        } else if ("url异常 - MalformedURLException".equals(str)) {
            this.f4172b = com.amap.api.services.core.AMapException.CODE_AMAP_CLIENT_URL_EXCEPTION;
        } else if ("未知主机 - UnKnowHostException".equals(str)) {
            this.f4172b = com.amap.api.services.core.AMapException.CODE_AMAP_CLIENT_UNKNOWHOST_EXCEPTION;
        } else if (com.amap.api.services.core.AMapException.AMAP_CLIENT_UNKNOWN_ERROR.equals(str)) {
            this.f4172b = 1900;
        } else if ("无效的参数 - IllegalArgumentException".equals(str)) {
            this.f4172b = com.amap.api.services.core.AMapException.CODE_AMAP_CLIENT_INVALID_PARAMETER;
        } else if (com.amap.api.services.core.AMapException.AMAP_CLIENT_NETWORK_EXCEPTION.equals(str)) {
            this.f4172b = com.amap.api.services.core.AMapException.CODE_AMAP_CLIENT_NETWORK_EXCEPTION;
        } else if ("IO 操作异常 - IOException".equals(str)) {
            this.f4172b = com.amap.api.services.core.AMapException.CODE_AMAP_CLIENT_IO_EXCEPTION;
        } else if ("空指针异常 - NullPointException".equals(str)) {
            this.f4172b = com.amap.api.services.core.AMapException.CODE_AMAP_CLIENT_NULLPOINT_EXCEPTION;
        } else {
            this.f4172b = 1800;
        }
    }

    public AMapException() {
        this.f4171a = "";
        this.f4172b = 1000;
    }
}

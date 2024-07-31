package com.umeng.socialize.tracker.utils;

import com.p518qq.p519e.comm.constants.ErrorCode;

/* renamed from: com.umeng.socialize.tracker.utils.a */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public enum Errors {
    UnKnownCode(5000),
    Timeout(5001),
    NetworkUnavailable(5002),
    SSLException(ErrorCode.VIDEO_PLAY_ERROR),
    IOException(ErrorCode.NO_AD_FILL),
    UnKnownHostException(ErrorCode.TRAFFIC_CONTROL_DAY),
    HttpError(ErrorCode.PACKAGE_NAME_ERROR),
    EmptyResponse(ErrorCode.RESOURCE_LOAD_ERROR),
    ErrorResponse(ErrorCode.IMAGE_LOAD_ERROR),
    ErrorMakeRequestBody(ErrorCode.TRAFFIC_CONTROL_HOUR);
    

    /* renamed from: k */
    private final int f39622k;

    Errors(int i) {
        this.f39622k = i;
    }

    /* renamed from: b */
    private String m13215b() {
        return "错误码：" + this.f39622k + " 错误信息：";
    }

    /* renamed from: a */
    public String m13216a() {
        if (this == UnKnownCode) {
            return m13215b() + "--未知错误--";
        } else if (this == Timeout) {
            return m13215b() + "--连接超时--";
        } else if (this == NetworkUnavailable) {
            return m13215b() + "--网络不可用--";
        } else if (this == SSLException) {
            return m13215b() + "--SSL证书认证失败--";
        } else if (this == IOException) {
            return m13215b() + "--IO异常--";
        } else if (this == HttpError) {
            return m13215b() + "--服务端返回HTTP错误--";
        } else if (this == EmptyResponse) {
            return m13215b() + "--服务端返回数据为空--";
        } else if (this == ErrorResponse) {
            return m13215b() + "--服务端返回错误数据--";
        } else if (this == ErrorMakeRequestBody) {
            return m13215b() + "--请求报文构建错误--";
        } else {
            return "unknown";
        }
    }
}

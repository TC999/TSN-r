package com.amap.api.maps;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class AMapException extends Exception {
    public static final String AMAP_NOT_SUPPORT = "\u79fb\u52a8\u8bbe\u5907\u4e0a\u672a\u5b89\u88c5\u9ad8\u5fb7\u5730\u56fe\u6216\u9ad8\u5fb7\u5730\u56fe\u7248\u672c\u8f83\u65e7";
    public static final String ERROR_CONNECTION = "http\u8fde\u63a5\u5931\u8d25 - ConnectionException";
    public static final String ERROR_FAILURE_AUTH = "key\u9274\u6743\u5931\u8d25";
    public static final String ERROR_FAILURE_OVERSEA_AUTH = "\u6d77\u5916\u9274\u6743\u5931\u8d25";
    public static final String ERROR_ILLEGAL_VALUE = "\u975e\u6cd5\u5750\u6807\u503c";
    public static final String ERROR_INVALID_PARAMETER = "\u65e0\u6548\u7684\u53c2\u6570 - IllegalArgumentException";
    public static final String ERROR_IO = "IO \u64cd\u4f5c\u5f02\u5e38 - IOException";
    public static final String ERROR_NOT_AVAILABLE = "\u4e0d\u53ef\u5199\u5165\u5f02\u5e38";
    public static final String ERROR_NOT_ENOUGH_SPACE = "\u7a7a\u95f4\u4e0d\u8db3";
    public static final String ERROR_NULL_PARAMETER = "\u7a7a\u6307\u9488\u5f02\u5e38 - NullPointException";
    public static final String ERROR_PROTOCOL = "\u534f\u8bae\u89e3\u6790\u9519\u8bef - ProtocolException";
    public static final String ERROR_SOCKET = "socket \u8fde\u63a5\u5f02\u5e38 - SocketException";
    public static final String ERROR_SOCKE_TIME_OUT = "socket \u8fde\u63a5\u8d85\u65f6 - SocketTimeoutException";
    public static final String ERROR_UNKNOWN = "\u672a\u77e5\u7684\u9519\u8bef";
    public static final String ERROR_UNKNOW_HOST = "\u672a\u77e5\u4e3b\u673a - UnKnowHostException";
    public static final String ERROR_UNKNOW_SERVICE = "\u670d\u52a1\u5668\u8fde\u63a5\u5931\u8d25 - UnknownServiceException";
    public static final String ERROR_URL = "url\u5f02\u5e38 - MalformedURLException";
    public static final String FEATURE_GLTF_NOT_SUPPORT = "GLTF\u529f\u80fd\u4e0d\u652f\u6301";
    public static final String FEATURE_MVT_NOT_SUPPORT = "MVT\u529f\u80fd\u4e0d\u652f\u6301";
    public static final String FEATURE_TERRAIN_NOT_SUPPORT = "\u5730\u5f62\u56fe\u529f\u80fd\u4e3a\u8ba1\u8d39\u80fd\u529b\uff0c\u8bf7\u8054\u7cfb\u5546\u52a1\u8fdb\u884c\u529f\u80fd\u5f00\u901a\u3002";
    public static final String ILLEGAL_AMAP_ARGUMENT = "\u975e\u6cd5\u53c2\u6570";
    private static final long serialVersionUID = 5204097757158979179L;
    private String errorMessage;

    public AMapException(String str) {
        super(str);
        this.errorMessage = str;
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }

    public AMapException() {
        this.errorMessage = "\u672a\u77e5\u7684\u9519\u8bef";
    }
}

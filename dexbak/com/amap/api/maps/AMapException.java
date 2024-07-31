package com.amap.api.maps;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class AMapException extends Exception {
    public static final String AMAP_NOT_SUPPORT = "移动设备上未安装高德地图或高德地图版本较旧";
    public static final String ERROR_CONNECTION = "http连接失败 - ConnectionException";
    public static final String ERROR_FAILURE_AUTH = "key鉴权失败";
    public static final String ERROR_FAILURE_OVERSEA_AUTH = "海外鉴权失败";
    public static final String ERROR_ILLEGAL_VALUE = "非法坐标值";
    public static final String ERROR_INVALID_PARAMETER = "无效的参数 - IllegalArgumentException";
    public static final String ERROR_IO = "IO 操作异常 - IOException";
    public static final String ERROR_NOT_AVAILABLE = "不可写入异常";
    public static final String ERROR_NOT_ENOUGH_SPACE = "空间不足";
    public static final String ERROR_NULL_PARAMETER = "空指针异常 - NullPointException";
    public static final String ERROR_PROTOCOL = "协议解析错误 - ProtocolException";
    public static final String ERROR_SOCKET = "socket 连接异常 - SocketException";
    public static final String ERROR_SOCKE_TIME_OUT = "socket 连接超时 - SocketTimeoutException";
    public static final String ERROR_UNKNOWN = "未知的错误";
    public static final String ERROR_UNKNOW_HOST = "未知主机 - UnKnowHostException";
    public static final String ERROR_UNKNOW_SERVICE = "服务器连接失败 - UnknownServiceException";
    public static final String ERROR_URL = "url异常 - MalformedURLException";
    public static final String FEATURE_GLTF_NOT_SUPPORT = "GLTF功能不支持";
    public static final String FEATURE_MVT_NOT_SUPPORT = "MVT功能不支持";
    public static final String FEATURE_TERRAIN_NOT_SUPPORT = "地形图功能为计费能力，请联系商务进行功能开通。";
    public static final String ILLEGAL_AMAP_ARGUMENT = "非法参数";
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
        this.errorMessage = ERROR_UNKNOWN;
    }
}

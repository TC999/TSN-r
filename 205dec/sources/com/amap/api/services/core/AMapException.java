package com.amap.api.services.core;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class AMapException extends Exception {
    public static final String AMAP_ACCESS_TOO_FREQUENT = "\u7528\u6237\u8bbf\u95ee\u8fc7\u4e8e\u9891\u7e41";
    public static final String AMAP_CLIENT_ERRORCODE_MISSSING = "\u6ca1\u6709\u5bf9\u5e94\u7684\u9519\u8bef";
    public static final String AMAP_CLIENT_ERRORCODE_MISSSING_TPPE = "AMAP_CLIENT_ERRORCODE_MISSSING";
    public static final String AMAP_CLIENT_ERROR_PROTOCOL = "\u534f\u8bae\u89e3\u6790\u9519\u8bef - ProtocolException";
    public static final String AMAP_CLIENT_INVALID_PARAMETER = "\u65e0\u6548\u7684\u53c2\u6570 - IllegalArgumentException";
    public static final String AMAP_CLIENT_IO_EXCEPTION = "IO \u64cd\u4f5c\u5f02\u5e38 - IOException";
    public static final String AMAP_CLIENT_NEARBY_NULL_RESULT = "NearbyInfo\u5bf9\u8c61\u4e3a\u7a7a";
    public static final String AMAP_CLIENT_NETWORK_EXCEPTION = "http\u6216socket\u8fde\u63a5\u5931\u8d25 - ConnectionException";
    public static final String AMAP_CLIENT_NULLPOINT_EXCEPTION = "\u7a7a\u6307\u9488\u5f02\u5e38 - NullPointException";
    public static final String AMAP_CLIENT_OVER_KEYWORD_LEN_MAX_COUNT_EXCEPTION = "\u5173\u952e\u5b57\u8fc7\u957f";
    public static final String AMAP_CLIENT_OVER_PASSAREA_ITEM_POINT_COUNT_EXCEPTION = "\u907f\u8ba9\u533a\u57df\u70b9\u4e2a\u6570\u8d85\u9650";
    public static final String AMAP_CLIENT_OVER_PASSAREA_MAX_AREA_EXCEPTION = "\u907f\u8ba9\u533a\u57df\u5927\u5c0f\u8d85\u9650";
    public static final String AMAP_CLIENT_OVER_PASSAREA_MAX_COUNT_EXCEPTION = "\u907f\u8ba9\u533a\u57df\u4e2a\u6570\u8d85\u9650";
    public static final String AMAP_CLIENT_OVER_PASSBY_MAX_COUNT_EXCEPTION = "\u9014\u7ecf\u70b9\u4e2a\u6570\u8d85\u9650";
    public static final String AMAP_CLIENT_SOCKET_TIMEOUT_EXCEPTION = "socket \u8fde\u63a5\u8d85\u65f6 - SocketTimeoutException";
    public static final String AMAP_CLIENT_UNKNOWHOST_EXCEPTION = "\u672a\u77e5\u4e3b\u673a - UnKnowHostException";
    public static final String AMAP_CLIENT_UNKNOWN_ERROR = "\u672a\u77e5\u9519\u8bef";
    public static final String AMAP_CLIENT_UNKNOWN_ERROR_TYPE = "CLIENT_UNKNOWN_ERROR";
    public static final String AMAP_CLIENT_UPLOADAUTO_STARTED_ERROR = "\u5df2\u5f00\u542f\u81ea\u52a8\u4e0a\u4f20";
    public static final String AMAP_CLIENT_UPLOAD_LOCATION_ERROR = "Point\u4e3a\u7a7a\uff0c\u6216\u4e0e\u524d\u6b21\u4e0a\u4f20\u7684\u76f8\u540c";
    public static final String AMAP_CLIENT_UPLOAD_TOO_FREQUENT = "\u4e24\u6b21\u5355\u6b21\u4e0a\u4f20\u7684\u95f4\u9694\u4f4e\u4e8e7\u79d2";
    public static final String AMAP_CLIENT_URL_EXCEPTION = "url\u5f02\u5e38 - MalformedURLException";
    public static final String AMAP_CLIENT_USERID_ILLEGAL = "USERID\u975e\u6cd5";
    public static final String AMAP_DAILY_QUERY_OVER_LIMIT = "\u8bbf\u95ee\u5df2\u8d85\u51fa\u65e5\u8bbf\u95ee\u91cf";
    public static final String AMAP_ENGINE_CONNECT_TIMEOUT = "\u670d\u52a1\u7aef\u8bf7\u6c42\u94fe\u63a5\u8d85\u65f6";
    public static final String AMAP_ENGINE_RESPONSE_DATA_ERROR = "\u5f15\u64ce\u8fd4\u56de\u6570\u636e\u5f02\u5e38";
    public static final String AMAP_ENGINE_RESPONSE_ERROR = "\u8bf7\u6c42\u670d\u52a1\u54cd\u5e94\u9519\u8bef";
    public static final String AMAP_ENGINE_RETURN_TIMEOUT = "\u8bfb\u53d6\u670d\u52a1\u7ed3\u679c\u8d85\u65f6";
    public static final String AMAP_ENGINE_TABLEID_NOT_EXIST = "key\u5bf9\u5e94\u7684tableID\u4e0d\u5b58\u5728";
    public static final int AMAP_ERROR_CORE = 1;
    public static final int AMAP_ERROR_LOCAL = 0;
    public static final int AMAP_ERROR_LOCAL_STANDARDIZED = 4;
    public static final int AMAP_ERROR_REST = 2;
    public static final String AMAP_ID_NOT_EXIST = "ID\u4e0d\u5b58\u5728";
    public static final String AMAP_INSUFFICIENT_PRIVILEGES = "\u6743\u9650\u4e0d\u8db3\uff0c\u670d\u52a1\u8bf7\u6c42\u88ab\u62d2\u7edd";
    public static final String AMAP_INVALID_USER_DOMAIN = "\u7528\u6237\u57df\u540d\u65e0\u6548";
    public static final String AMAP_INVALID_USER_IP = "\u7528\u6237IP\u65e0\u6548";
    public static final String AMAP_INVALID_USER_KEY = "\u7528\u6237key\u4e0d\u6b63\u786e\u6216\u8fc7\u671f";
    public static final String AMAP_INVALID_USER_SCODE = "\u7528\u6237MD5\u5b89\u5168\u7801\u672a\u901a\u8fc7";
    public static final String AMAP_IP_QUERY_OVER_LIMIT = "IP\u8bbf\u95ee\u8d85\u9650";
    public static final String AMAP_NEARBY_INVALID_USERID = "\u627e\u4e0d\u5230\u5bf9\u5e94\u7684userid\u4fe1\u606f,\u8bf7\u68c0\u67e5\u60a8\u63d0\u4f9b\u7684userid\u662f\u5426\u5b58\u5728";
    public static final String AMAP_NEARBY_KEY_NOT_BIND = "App key\u672a\u5f00\u901a\u201c\u9644\u8fd1\u201d\u529f\u80fd,\u8bf7\u6ce8\u518c\u9644\u8fd1KEY";
    public static final String AMAP_NOT_SUPPORT_HTTPS = "\u670d\u52a1\u4e0d\u652f\u6301https\u8bf7\u6c42";
    public static final String AMAP_OVER_DIRECTION_RANGE = "\u8d77\u70b9\u7ec8\u70b9\u8ddd\u79bb\u8fc7\u957f";
    public static final String AMAP_ROUTE_FAIL = "\u8def\u7ebf\u8ba1\u7b97\u5931\u8d25\uff0c\u901a\u5e38\u662f\u7531\u4e8e\u9053\u8def\u8fde\u901a\u5173\u7cfb\u5bfc\u81f4";
    public static final String AMAP_ROUTE_NO_ROADS_NEARBY = "\u89c4\u5212\u70b9\uff08\u8d77\u70b9\u3001\u7ec8\u70b9\u3001\u9014\u7ecf\u70b9\uff09\u9644\u8fd1\u641c\u4e0d\u5230\u8def";
    public static final String AMAP_ROUTE_OUT_OF_SERVICE = "\u89c4\u5212\u70b9\uff08\u5305\u62ec\u8d77\u70b9\u3001\u7ec8\u70b9\u3001\u9014\u7ecf\u70b9\uff09\u4e0d\u5728\u4e2d\u56fd\u9646\u5730\u8303\u56f4\u5185";
    public static final String AMAP_SERVICE_ILLEGAL_REQUEST = "\u8bf7\u6c42\u534f\u8bae\u975e\u6cd5";
    public static final String AMAP_SERVICE_INVALID_PARAMS = "\u8bf7\u6c42\u53c2\u6570\u975e\u6cd5";
    public static final String AMAP_SERVICE_MAINTENANCE = "\u670d\u52a1\u5668\u7ef4\u62a4\u4e2d";
    public static final String AMAP_SERVICE_MISSING_REQUIRED_PARAMS = "\u7f3a\u5c11\u5fc5\u586b\u53c2\u6570";
    public static final String AMAP_SERVICE_NOT_AVAILBALE = "\u8bf7\u6c42\u670d\u52a1\u4e0d\u5b58\u5728";
    public static final String AMAP_SERVICE_TABLEID_NOT_EXIST = "tableID\u683c\u5f0f\u4e0d\u6b63\u786e\u4e0d\u5b58\u5728";
    public static final String AMAP_SERVICE_UNKNOWN_ERROR = "\u5176\u4ed6\u672a\u77e5\u9519\u8bef";
    public static final String AMAP_SHARE_FAILURE = "\u77ed\u4e32\u8bf7\u6c42\u5931\u8d25";
    public static final String AMAP_SHARE_LICENSE_IS_EXPIRED = "\u77ed\u4e32\u5206\u4eab\u8ba4\u8bc1\u5931\u8d25";
    public static final String AMAP_SHARE_SIGNATURE_FAILURE = "\u7528\u6237\u7b7e\u540d\u672a\u901a\u8fc7";
    public static final String AMAP_SIGNATURE_ERROR = "\u7528\u6237\u7b7e\u540d\u672a\u901a\u8fc7";
    public static final String AMAP_USERKEY_PLAT_NOMATCH = "\u8bf7\u6c42key\u4e0e\u7ed1\u5b9a\u5e73\u53f0\u4e0d\u7b26";
    public static final String AMAP_USER_KEY_RECYCLED = "\u5f00\u53d1\u8005\u5220\u9664\u4e86key\uff0ckey\u88ab\u5220\u9664\u540e\u65e0\u6cd5\u6b63\u5e38\u4f7f\u7528";
    public static final int CODE_AMAP_ACCESS_TOO_FREQUENT = 1005;
    public static final int CODE_AMAP_CLIENT_ERRORCODE_MISSSING = 1800;
    public static final int CODE_AMAP_CLIENT_ERROR_PROTOCOL = 1801;
    public static final int CODE_AMAP_CLIENT_INVALID_PARAMETER = 1901;
    public static final int CODE_AMAP_CLIENT_IO_EXCEPTION = 1902;
    public static final int CODE_AMAP_CLIENT_NEARBY_NULL_RESULT = 2202;
    public static final int CODE_AMAP_CLIENT_NETWORK_EXCEPTION = 1806;
    public static final int CODE_AMAP_CLIENT_NULLPOINT_EXCEPTION = 1903;
    public static final int CODE_AMAP_CLIENT_OVER_KEYWORD_LEN_MAX_COUNT_EXCEPTION = 1813;
    public static final int CODE_AMAP_CLIENT_OVER_PASSAREA_ITEM_POINT_COUNT_EXCEPTION = 1812;
    public static final int CODE_AMAP_CLIENT_OVER_PASSAREA_MAX_AREA_EXCEPTION = 1811;
    public static final int CODE_AMAP_CLIENT_OVER_PASSAREA_MAX_COUNT_EXCEPTION = 1810;
    public static final int CODE_AMAP_CLIENT_OVER_PASSBY_MAX_COUNT_EXCEPTION = 1809;
    public static final int CODE_AMAP_CLIENT_SOCKET_TIMEOUT_EXCEPTION = 1802;
    public static final int CODE_AMAP_CLIENT_UNKNOWHOST_EXCEPTION = 1804;
    public static final int CODE_AMAP_CLIENT_UNKNOWN_ERROR = 1900;
    public static final int CODE_AMAP_CLIENT_UPLOADAUTO_STARTED_ERROR = 2200;
    public static final int CODE_AMAP_CLIENT_UPLOAD_LOCATION_ERROR = 2204;
    public static final int CODE_AMAP_CLIENT_UPLOAD_TOO_FREQUENT = 2203;
    public static final int CODE_AMAP_CLIENT_URL_EXCEPTION = 1803;
    public static final int CODE_AMAP_CLIENT_USERID_ILLEGAL = 2201;
    public static final int CODE_AMAP_DAILY_QUERY_OVER_LIMIT = 1004;
    public static final int CODE_AMAP_ENGINE_CONNECT_TIMEOUT = 1102;
    public static final int CODE_AMAP_ENGINE_RESPONSE_DATA_ERROR = 1101;
    public static final int CODE_AMAP_ENGINE_RESPONSE_ERROR = 1100;
    public static final int CODE_AMAP_ENGINE_RETURN_TIMEOUT = 1103;
    public static final int CODE_AMAP_ENGINE_TABLEID_NOT_EXIST = 2003;
    public static final int CODE_AMAP_ID_NOT_EXIST = 2001;
    public static final int CODE_AMAP_INSUFFICIENT_PRIVILEGES = 1012;
    public static final int CODE_AMAP_INVALID_USER_DOMAIN = 1007;
    public static final int CODE_AMAP_INVALID_USER_IP = 1006;
    public static final int CODE_AMAP_INVALID_USER_KEY = 1002;
    public static final int CODE_AMAP_INVALID_USER_SCODE = 1008;
    public static final int CODE_AMAP_IP_QUERY_OVER_LIMIT = 1010;
    public static final int CODE_AMAP_NEARBY_INVALID_USERID = 2100;
    public static final int CODE_AMAP_NEARBY_KEY_NOT_BIND = 2101;
    public static final int CODE_AMAP_NOT_SUPPORT_HTTPS = 1011;
    public static final int CODE_AMAP_OVER_DIRECTION_RANGE = 3003;
    public static final int CODE_AMAP_ROUTE_FAIL = 3002;
    public static final int CODE_AMAP_ROUTE_NO_ROADS_NEARBY = 3001;
    public static final int CODE_AMAP_ROUTE_OUT_OF_SERVICE = 3000;
    public static final int CODE_AMAP_SERVICE_ILLEGAL_REQUEST = 1202;
    public static final int CODE_AMAP_SERVICE_INVALID_PARAMS = 1200;
    public static final int CODE_AMAP_SERVICE_MAINTENANCE = 2002;
    public static final int CODE_AMAP_SERVICE_MISSING_REQUIRED_PARAMS = 1201;
    public static final int CODE_AMAP_SERVICE_NOT_AVAILBALE = 1003;
    public static final int CODE_AMAP_SERVICE_TABLEID_NOT_EXIST = 2000;
    public static final int CODE_AMAP_SERVICE_UNKNOWN_ERROR = 1203;
    public static final int CODE_AMAP_SHARE_FAILURE = 4001;
    public static final int CODE_AMAP_SHARE_LICENSE_IS_EXPIRED = 4000;
    public static final int CODE_AMAP_SHARE_SIGNATURE_FAILURE = 4002;
    public static final int CODE_AMAP_SIGNATURE_ERROR = 1001;
    public static final int CODE_AMAP_SUCCESS = 1000;
    public static final int CODE_AMAP_USERKEY_PLAT_NOMATCH = 1009;
    public static final int CODE_AMAP_USER_KEY_RECYCLED = 1013;

    /* renamed from: a  reason: collision with root package name */
    private int f10959a;

    /* renamed from: b  reason: collision with root package name */
    private String f10960b;

    /* renamed from: c  reason: collision with root package name */
    private String f10961c;

    /* renamed from: d  reason: collision with root package name */
    private int f10962d;

    public AMapException(String str) {
        super(str);
        this.f10960b = null;
        this.f10962d = 1000;
        this.f10961c = str;
        this.f10959a = 0;
        a(str);
    }

    private void a(String str) {
        if ("\u7528\u6237\u7b7e\u540d\u672a\u901a\u8fc7".equals(str)) {
            this.f10962d = 1001;
        } else if ("\u7528\u6237key\u4e0d\u6b63\u786e\u6216\u8fc7\u671f".equals(str)) {
            this.f10962d = 1002;
        } else if ("\u8bf7\u6c42\u670d\u52a1\u4e0d\u5b58\u5728".equals(str)) {
            this.f10962d = 1003;
        } else if ("\u8bbf\u95ee\u5df2\u8d85\u51fa\u65e5\u8bbf\u95ee\u91cf".equals(str)) {
            this.f10962d = 1004;
        } else if ("\u7528\u6237\u8bbf\u95ee\u8fc7\u4e8e\u9891\u7e41".equals(str)) {
            this.f10962d = 1005;
        } else if ("\u7528\u6237IP\u65e0\u6548".equals(str)) {
            this.f10962d = 1006;
        } else if ("\u7528\u6237\u57df\u540d\u65e0\u6548".equals(str)) {
            this.f10962d = 1007;
        } else if ("\u7528\u6237MD5\u5b89\u5168\u7801\u672a\u901a\u8fc7".equals(str)) {
            this.f10962d = 1008;
        } else if ("\u8bf7\u6c42key\u4e0e\u7ed1\u5b9a\u5e73\u53f0\u4e0d\u7b26".equals(str)) {
            this.f10962d = 1009;
        } else if ("IP\u8bbf\u95ee\u8d85\u9650".equals(str)) {
            this.f10962d = 1010;
        } else if ("\u670d\u52a1\u4e0d\u652f\u6301https\u8bf7\u6c42".equals(str)) {
            this.f10962d = 1011;
        } else if ("\u6743\u9650\u4e0d\u8db3\uff0c\u670d\u52a1\u8bf7\u6c42\u88ab\u62d2\u7edd".equals(str)) {
            this.f10962d = 1012;
        } else if ("\u5f00\u53d1\u8005\u5220\u9664\u4e86key\uff0ckey\u88ab\u5220\u9664\u540e\u65e0\u6cd5\u6b63\u5e38\u4f7f\u7528".equals(str)) {
            this.f10962d = 1013;
        } else if ("\u8bf7\u6c42\u670d\u52a1\u54cd\u5e94\u9519\u8bef".equals(str)) {
            this.f10962d = 1100;
        } else if ("\u5f15\u64ce\u8fd4\u56de\u6570\u636e\u5f02\u5e38".equals(str)) {
            this.f10962d = 1101;
        } else if ("\u670d\u52a1\u7aef\u8bf7\u6c42\u94fe\u63a5\u8d85\u65f6".equals(str)) {
            this.f10962d = 1102;
        } else if ("\u8bfb\u53d6\u670d\u52a1\u7ed3\u679c\u8d85\u65f6".equals(str)) {
            this.f10962d = 1103;
        } else if ("\u8bf7\u6c42\u53c2\u6570\u975e\u6cd5".equals(str)) {
            this.f10962d = 1200;
        } else if ("\u7f3a\u5c11\u5fc5\u586b\u53c2\u6570".equals(str)) {
            this.f10962d = 1201;
        } else if ("\u8bf7\u6c42\u534f\u8bae\u975e\u6cd5".equals(str)) {
            this.f10962d = 1202;
        } else if ("\u5176\u4ed6\u672a\u77e5\u9519\u8bef".equals(str)) {
            this.f10962d = 1203;
        } else if ("\u534f\u8bae\u89e3\u6790\u9519\u8bef - ProtocolException".equals(str)) {
            this.f10962d = 1801;
        } else if ("socket \u8fde\u63a5\u8d85\u65f6 - SocketTimeoutException".equals(str)) {
            this.f10962d = 1802;
        } else if ("url\u5f02\u5e38 - MalformedURLException".equals(str)) {
            this.f10962d = 1803;
        } else if ("\u672a\u77e5\u4e3b\u673a - UnKnowHostException".equals(str)) {
            this.f10962d = 1804;
        } else if ("\u65e0\u6548\u7684\u53c2\u6570 - IllegalArgumentException".equals(str)) {
            this.f10962d = 1901;
        } else if ("http\u6216socket\u8fde\u63a5\u5931\u8d25 - ConnectionException".equals(str)) {
            this.f10962d = 1806;
        } else if ("IO \u64cd\u4f5c\u5f02\u5e38 - IOException".equals(str)) {
            this.f10962d = 1902;
        } else if ("\u7a7a\u6307\u9488\u5f02\u5e38 - NullPointException".equals(str)) {
            this.f10962d = 1903;
        } else if ("tableID\u683c\u5f0f\u4e0d\u6b63\u786e\u4e0d\u5b58\u5728".equals(str)) {
            this.f10962d = 2000;
        } else if ("ID\u4e0d\u5b58\u5728".equals(str)) {
            this.f10962d = 2001;
        } else if ("\u670d\u52a1\u5668\u7ef4\u62a4\u4e2d".equals(str)) {
            this.f10962d = 2002;
        } else if ("key\u5bf9\u5e94\u7684tableID\u4e0d\u5b58\u5728".equals(str)) {
            this.f10962d = 2003;
        } else if ("\u627e\u4e0d\u5230\u5bf9\u5e94\u7684userid\u4fe1\u606f,\u8bf7\u68c0\u67e5\u60a8\u63d0\u4f9b\u7684userid\u662f\u5426\u5b58\u5728".equals(str)) {
            this.f10962d = 2100;
        } else if ("App key\u672a\u5f00\u901a\u201c\u9644\u8fd1\u201d\u529f\u80fd,\u8bf7\u6ce8\u518c\u9644\u8fd1KEY".equals(str)) {
            this.f10962d = 2101;
        } else if ("\u89c4\u5212\u70b9\uff08\u5305\u62ec\u8d77\u70b9\u3001\u7ec8\u70b9\u3001\u9014\u7ecf\u70b9\uff09\u4e0d\u5728\u4e2d\u56fd\u9646\u5730\u8303\u56f4\u5185".equals(str)) {
            this.f10962d = 3000;
        } else if ("\u89c4\u5212\u70b9\uff08\u8d77\u70b9\u3001\u7ec8\u70b9\u3001\u9014\u7ecf\u70b9\uff09\u9644\u8fd1\u641c\u4e0d\u5230\u8def".equals(str)) {
            this.f10962d = 3001;
        } else if ("\u8def\u7ebf\u8ba1\u7b97\u5931\u8d25\uff0c\u901a\u5e38\u662f\u7531\u4e8e\u9053\u8def\u8fde\u901a\u5173\u7cfb\u5bfc\u81f4".equals(str)) {
            this.f10962d = 3002;
        } else if ("\u8d77\u70b9\u7ec8\u70b9\u8ddd\u79bb\u8fc7\u957f".equals(str)) {
            this.f10962d = 3003;
        } else if ("\u5df2\u5f00\u542f\u81ea\u52a8\u4e0a\u4f20".equals(str)) {
            this.f10962d = 2200;
        } else if ("USERID\u975e\u6cd5".equals(str)) {
            this.f10962d = 2201;
        } else if ("NearbyInfo\u5bf9\u8c61\u4e3a\u7a7a".equals(str)) {
            this.f10962d = 2202;
        } else if ("\u4e24\u6b21\u5355\u6b21\u4e0a\u4f20\u7684\u95f4\u9694\u4f4e\u4e8e7\u79d2".equals(str)) {
            this.f10962d = 2203;
        } else if ("Point\u4e3a\u7a7a\uff0c\u6216\u4e0e\u524d\u6b21\u4e0a\u4f20\u7684\u76f8\u540c".equals(str)) {
            this.f10962d = 2204;
        } else if ("\u77ed\u4e32\u5206\u4eab\u8ba4\u8bc1\u5931\u8d25".equals(str)) {
            this.f10962d = 4000;
        } else if ("\u77ed\u4e32\u8bf7\u6c42\u5931\u8d25".equals(str)) {
            this.f10962d = 4001;
        } else if ("\u7528\u6237\u7b7e\u540d\u672a\u901a\u8fc7".equals(str)) {
            this.f10962d = 4002;
        } else if ("\u672a\u77e5\u9519\u8bef".equals(str)) {
            this.f10962d = 1900;
            this.f10960b = "CLIENT_UNKNOWN_ERROR";
        } else if ("\u907f\u8ba9\u533a\u57df\u70b9\u4e2a\u6570\u8d85\u9650".equals(str)) {
            this.f10962d = 1812;
        } else if ("\u5173\u952e\u5b57\u8fc7\u957f".equals(str)) {
            this.f10962d = 1813;
        } else if ("\u907f\u8ba9\u533a\u57df\u5927\u5c0f\u8d85\u9650".equals(str)) {
            this.f10962d = 1811;
        } else if ("\u907f\u8ba9\u533a\u57df\u4e2a\u6570\u8d85\u9650".equals(str)) {
            this.f10962d = 1810;
        } else if ("\u9014\u7ecf\u70b9\u4e2a\u6570\u8d85\u9650".equals(str)) {
            this.f10962d = 1809;
        } else {
            this.f10962d = 1800;
            this.f10960b = "AMAP_CLIENT_ERRORCODE_MISSSING";
        }
    }

    public int getErrorCode() {
        return this.f10962d;
    }

    public int getErrorLevel() {
        return this.f10959a;
    }

    public String getErrorMessage() {
        return this.f10961c;
    }

    public String getErrorType() {
        return this.f10960b;
    }

    public AMapException(String str, int i4, String str2) {
        super(str);
        this.f10962d = 1000;
        this.f10961c = str;
        this.f10959a = i4;
        this.f10960b = str2;
        a(str);
    }

    public AMapException(String str, int i4, String str2, int i5) {
        this(str);
        this.f10961c = str;
        this.f10959a = i4;
        this.f10960b = str2;
        this.f10962d = i5;
    }

    public AMapException() {
        this.f10959a = 0;
        this.f10960b = null;
        this.f10961c = "";
        this.f10962d = 1000;
    }
}

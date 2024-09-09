package com.bytedance.msdk.api;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class c {

    /* renamed from: c  reason: collision with root package name */
    public int f27444c;
    public String sr;

    /* renamed from: w  reason: collision with root package name */
    public String f27445w;
    public int xv;

    public c() {
        this(-99999, "no error message");
    }

    public static String c(int i4) {
        switch (i4) {
            case -2:
                return "\u7f51\u7edc\u8bf7\u6c42\u5931\u8d25";
            case -1:
                return "\u89e3\u6790\u5931\u8d25";
            case 1:
                return "MSDK\u8fd8\u672a\u521d\u59cb\u5316";
            case 10003:
                return AdError.AD_LOAD_AD_TIME_OUT_ERROR_MSG;
            case 10012:
                return "Adn\u8d85\u65f6\u540e\u56de\u8c03";
            case 10013:
                return "Adm\u6570\u636e\u5f02\u5e38";
            case 10014:
                return "\u5e7f\u544a\u4f4d\u4e0d\u662f\u5185\u5bb9\u6df7\u51fa\u5e7f\u544a\u4f4d\uff0c\u8bf7\u67e5\u770b\u914d\u7f6e";
            case 10015:
                return "\u8bf7\u5148\u83b7\u53d6token\u76f8\u5173\u4fe1\u606f";
            case 20005:
                return "\u5168\u90e8\u4ee3\u7801\u4f4d\u8bf7\u6c42\u5931\u8d25";
            case AdError.ERROR_CODE_ADN_LOAD_FAIL_ERROR_CONTROL /* 40044 */:
                return "\u5f53\u524dADN\u9650\u5236\u65f6\u95f4\u5185\u4e0d\u5141\u8bb8\u8bf7\u6c42";
            case 40045:
            case 840040:
                return "\u6682\u65e0\u914d\u7f6e\u4fe1\u606f\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5\uff0c\u6216\u8005\u6ce8\u518cconfig\u56de\u8c03\uff0c\u5177\u4f53\u53c2\u8003demo";
            case 40047:
                return "\u5e7f\u544a\u5bf9\u8c61\u672a\u4f7f\u7528\u8fc7\uff0c\u4e0d\u80fd\u91cd\u65b0\u52a0\u8f7d";
            case 40048:
                return "\u5e7f\u544a\u5bf9\u8c61\u4e0d\u53ef\u91cd\u590d\u4f7f\u7528";
            case AdError.ERROR_CODE_SHOW_FAIL_NO_AD /* 40052 */:
                return "\u5e7f\u544a\u5c55\u793a\u5931\u8d25\uff0c\u6682\u65e0\u5e7f\u544a\u53ef\u7528\uff0c\u8bf7\u91cd\u65b0\u52a0\u8f7d";
            case 40061:
                return "\u4ef7\u683c\u6807\u7b7e\u4e3a\u7a7a\u5b57\u7b26\uff0c\u65e0\u591a\u9636\u5e95\u4ef7\u6743\u9650\u6216\u6743\u9650\u5f02\u5e38";
            case 40062:
                return "\u65e0\u6cd5\u89e3\u6790\u4ef7\u683c\u6807\u7b7e\uff0c\u8bf7\u786e\u8ba4\u5e76\u66f4\u65b0\u5e73\u53f0\u914d\u7f6e";
            case 40063:
                return "\u975e\u7a7f\u5c71\u7532\u7ed9\u51fa\u7684\u5c55\u793a\u5e7f\u544a";
            case AdError.ERROR_CODE_CONTEXT_ERROR /* 41005 */:
                return "Context\u4e3anull\uff0c\u8bf7\u68c0\u67e5\u4f20\u5165\u7684Context";
            case 41041:
                return "\u8d85\u8fc7\u4ee3\u7801\u4f4d\u5c42\u7ea7\u89c4\u5b9a\u7684\u7528\u6237\u5c55\u793a\u4e0a\u9650\uff0c\u5b9e\u9645\u672a\u53d1\u8d77\u8bf7\u6c42\uff0c\u8bf7\u6c42\u5931\u8d25";
            case 41042:
                return "\u672a\u8d85\u8fc7\u4ee3\u7801\u4f4d\u5c42\u7ea7\u89c4\u5b9a\u7684\u5c55\u793a\u95f4\u9694\uff0c\u8bf7\u6c42\u9891\u7e41\uff0c\u5b9e\u9645\u672a\u53d1\u8d77\u8bf7\u6c42";
            case 41043:
                return "msdk thread handler\u4e3anull";
            case 41044:
                return "\u5df2\u7ecf\u8c03\u7528Destroy()\u65b9\u6cd5";
            case 44404:
                return "\u6ca1\u6709\u7f51\u7edc";
            case 44405:
                return "\u7f51\u7edc\u8d85\u65f6";
            case 49000:
                return "\u81ea\u5b9a\u4e49ADN banner load\u5931\u8d25";
            case 49001:
                return "\u81ea\u5b9a\u4e49ADN banner show\u5931\u8d25";
            case 49002:
                return "\u81ea\u5b9a\u4e49ADN \u63d2\u5c4f load\u5931\u8d25";
            case 49003:
                return "\u81ea\u5b9a\u4e49ADN \u63d2\u5c4f show\u5931\u8d25";
            case 49004:
                return "\u81ea\u5b9a\u4e49ADN \u6fc0\u52b1\u89c6\u9891 load\u5931\u8d25";
            case 49005:
                return "\u81ea\u5b9a\u4e49ADN \u6fc0\u52b1\u89c6\u9891 show\u5931\u8d25";
            case 49006:
                return "\u81ea\u5b9a\u4e49ADN \u5168\u5c4f\u89c6\u9891 load\u5931\u8d25";
            case 49007:
                return "\u81ea\u5b9a\u4e49ADN \u5168\u5c4f\u89c6\u9891 show\u5931\u8d25";
            case 49008:
                return "\u81ea\u5b9a\u4e49ADN \u5f00\u5c4f\u89c6\u9891 load\u5931\u8d25";
            case 49009:
                return "\u81ea\u5b9a\u4e49ADN \u5f00\u5c4f\u89c6\u9891 show\u5931\u8d25";
            case 49010:
                return "\u81ea\u5b9a\u4e49ADN \u4fe1\u606f\u6d41 load\u5931\u8d25";
            case 49012:
                return "\u81ea\u5b9a\u4e49ADN \u4fe1\u606f\u6d41 \u89c6\u9891\u64ad\u653e\u5931\u8d25";
            case 49015:
                return "\u81ea\u5b9a\u4e49ADN draw load\u5931\u8d25";
            case 49016:
                return "\u81ea\u5b9a\u4e49ADN draw \u89c6\u9891\u64ad\u653e\u5931\u8d25";
            case 50100:
                return "\u672c\u6b21\u51fa\u4ef7\u4f4e\u4e8e\u7ade\u4ef7\u5e95\u4ef7";
            case 81001:
                return "\u914d\u7f6e\u6b63\u5728\u8bf7\u6c42\u4e2d\uff0c\u7a0d\u540e\u91cd\u8bd5";
            case 81002:
                return "\u65e0\u767d\u540d\u5355\u6743\u9650";
            case 81003:
                return "\u4f20\u5165\u7684\u53c2\u6570\u6709\u8bef\u6216\u4e3a\u7a7a\uff0c\u8bf7\u68c0\u67e5\u53c2\u6570";
            case 81004:
                return "CSJ4900\u5df2\u7ecf\u79fb\u9664\u65e7\u63d2\u5c4f\u63a5\u53e3\uff0c\u4f46\u4ecd\u7136\u6709\u65e7\u63d2\u5c4f\u4ee3\u7801\u4f4d\u8bf7\u6c42\uff0c\u8bf7\u63a5\u5165CSJ48xx\u6216\u66f4\u6362\u4e3a\u65b0\u63d2\u5c4f\u4ee3\u7801\u4f4d";
            case 81008:
                return "no ad";
            case 81009:
                return "only customAd";
            case 81010:
                return "adn impl changed";
            case 81011:
                return "adn\u672c\u8eab\u95ee\u9898\uff0c\u4e0d\u652f\u6301\u8f6e\u64ad";
            case 81012:
                return "ui\u6d4b\u8bd5\u5de5\u5177config\u4e3anull";
            case 810085:
                return "\u547d\u4e2d\u8bf7\u6c42\u8fc7\u4e8e\u9891\u7e41\u3001\u65e0\u8fd4\u56de";
            case 840026:
                return "adSlot \u4e0d\u80fd\u4e3a null";
            case 840027:
                return "\u5f00\u5c4f\u5e7f\u544a\u81ea\u5b9a\u4e49\u515c\u5e95\u53c2\u6570\u4e0d\u6b63\u786e\uff0c\u8bf7\u6821\u9a8c";
            case 840028:
                return "\u5f00\u5c4f\u5e7f\u544a\u5f00\u53d1\u8005\u81ea\u5b9a\u4e49\u515c\u5e95\u4e2dpangle appId\uff0c\u4e0epangle sdk\u521d\u59cb\u5316\u7684appId\u4e0d\u4e00\u81f4\uff0c\u8bf7\u68c0\u67e5\u5e76\u4f20\u5165\u4e0e\u521d\u59cb\u5316\u76f8\u540cappId";
            case 840031:
                return "\u805a\u5408\u5e7f\u544a\u4f4d\u5bf9\u5e94\u7684\u5e7f\u544a\u7c7b\u578b\u548c\u5f53\u524d\u5e7f\u544a\u7c7b\u578b\u4e0d\u4e00\u81f4";
            case 840032:
                return "Banner\u5e7f\u544a\u6682\u65e0\u5e7f\u544a\u8fd4\u56de\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5";
            case 840033:
                return "\u63d2\u5c4f\u5e7f\u544a\u6682\u65e0\u5e7f\u544a\u8fd4\u56de\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5";
            case 840034:
                return "\u5f00\u5c4f\u5e7f\u544a\u6682\u65e0\u5e7f\u544a\u8fd4\u56de\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5";
            case 840035:
                return "\u4fe1\u606f\u6d41\u6a21\u677f\u5e7f\u544a\u6682\u65e0\u5e7f\u544a\u8fd4\u56de\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5";
            case 840036:
                return "\u6fc0\u52b1\u89c6\u9891\u5e7f\u544a\u6682\u65e0\u5e7f\u544a\u8fd4\u56de\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5";
            case 840037:
                return "\u5168\u5c4f\u89c6\u9891\u5e7f\u544a\u6682\u65e0\u5e7f\u544a\u8fd4\u56de\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5";
            case 840038:
                return "\u4fe1\u606f\u6d41\u81ea\u6e32\u67d3\u5e7f\u544a\u6682\u65e0\u5e7f\u544a\u8fd4\u56de\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5";
            case 840041:
                return "waterfall\u5c42\u7ea7\u5c55\u793a\u6b21\u6570\u8fbe\u5230\u4e0a\u9650\uff0c\u672c\u6b21\u5e7f\u544a\u52a0\u8f7d\u88ab\u963b\u6b62";
            case 840042:
                return "waterfall\u5c42\u7ea7\u5c55\u793a\u95f4\u9694\u672a\u8d85\u8fc7\u89c4\u5b9a\u7684\u6700\u77ed\u65f6\u957f\uff0c\u672c\u6b21\u5e7f\u544a\u52a0\u8f7d\u88ab\u963b\u6b62";
            case 840043:
                return "\u5e7f\u544a\u8bf7\u6c42\u8fc7\u4e8e\u9891\u7e41\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5";
            default:
                return AdError.AD_UNKNOWN_ERROR_MSG;
        }
    }

    public String toString() {
        return "AdError{code=" + this.f27444c + ", message='" + this.f27445w + "', thirdSdkErrorCode=" + this.xv + ", thirdSdkErrorMessage='" + this.sr + "'}";
    }

    public c(String str) {
        this(-99999, str);
    }

    public c(int i4, String str) {
        this(i4, str, i4, str);
    }

    public c(int i4, String str, int i5, String str2) {
        this.f27444c = i4;
        this.f27445w = str;
        this.xv = i5;
        this.sr = str2;
    }
}

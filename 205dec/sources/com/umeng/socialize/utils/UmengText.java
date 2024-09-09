package com.umeng.socialize.utils;

import com.umeng.socialize.bean.SHARE_MEDIA;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class UmengText {
    public static String FULL = "\u5b8c\u6574\u7248";
    public static String MAN = "\u7537";
    public static String SIMPLE = "\u7cbe\u7b80\u7248";
    public static String SOLVE = "\u89e3\u51b3\u65b9\u6848--";
    public static String WOMAN = "\u5973";

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public static class AUTH {
        public static String ALL_AUTH_EVERY = "\u6211\u60f3\u6bcf\u6b21\u83b7\u53d6\u7528\u6237\u8d44\u6599\u90fd\u6388\u6743\u600e\u4e48\u529e\uff1f";
        public static String ALL_AUTH_TWICE = "\u4e3a\u4ec0\u4e48\u6211\u6bcf\u6b21\u83b7\u53d6\u7528\u6237\u8d44\u6599\u90fd\u8df3\u8f6c\u4e24\u6b21\u6388\u6743\u754c\u9762\uff1f";
        public static String AUTH_DENIED = "[SA10001]\u6743\u9650\u9a8c\u8bc1\u5931\u8d25\uff0c\u8bf7\u68c0\u67e5\u4f60\u7684\u7b7e\u540d\u4ee5\u53ca\u8be5\u5e73\u53f0Appkey\u6743\u9650.";
        public static String DATA_EMPTY = "[SA10003]\u8fd4\u56de\u6570\u636e\u4e3a\u7a7a";
        public static String GET_FAIL_BY_EMPTY = "[SA10002]\u83b7\u53d6\u7528\u6237\u8d44\u6599\u4e3a\u7a7a\uff0cuid\u4e3a\u7a7a\u6216token\u4e3a\u7a7a";
        public static String NOT_SUPPORT_PLATFROM = "[SA10000]\u5e73\u53f0\u4e0d\u652f\u6301\u6388\u6743,\u65e0\u6cd5\u5b8c\u6210\u64cd\u4f5c";
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public static class CACHE {
        private static String id = "[SCC10000]";
        public static String CACHEFILE = id + "\u7f13\u5b58\u6587\u4ef6\u9519\u8bef\uff0c\u8bf7\u52ff\u62c5\u5fc3\uff0c\u4e0d\u5f71\u54cd\u6b63\u5e38\u4f7f\u7528";
        public static String CLOSE = id + "\u5173\u95ed\u6d41\u5f02\u5e38";
        public static String SD_NOT_FOUNT = "[SCC10001]\u6ca1\u6709\u627e\u5230\u5b58\u50a8\u8bbe\u5907\uff0c\u5b58\u50a8\u56fe\u7247";
        public static String MSANDCACHE_FOUNT = "[SCC10002]mSandCache \u627e\u4e0d\u5230";
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public static class CHECK {
        public static String ACTIVITYNULL = "[SCH10001]\u4f20\u5165Activity\u4e3a\u7a7a";
        public static String ALIPAYERROR = "[SCH10006]\u6ca1\u6709\u914d\u7f6e\u652f\u4ed8\u5b9d\u56de\u8c03activity\u6216\u914d\u7f6e\u4e0d\u6b63\u786e";
        public static String ALIPAYSUCCESS = "\u652f\u4ed8\u5b9d\u914d\u7f6e\u6b63\u786e";
        public static String ALL_NO_ONACTIVITY = "[SCH10000]\u60a8\u7684activity\u4e2d\u6ca1\u6709\u91cd\u5199onActivityResult\u65b9\u6cd5";
        public static String APPKEY_NOT_FOUND = "[SCH10003]\u8bf7\u914d\u7f6e\u60a8\u7684\u53cb\u76dfAppkey";
        public static String DEPENDENT_COMMON_NOT_MATCH = "\u5206\u4eabSDK 7.1.x\u5fc5\u987b\u914d\u5408\u53cb\u76df\u57fa\u7840\u7ec4\u4ef6\u5e93(v9.2.x\u7248\u672c\u6216\u66f4\u9ad8\u7248\u672c)\u4f7f\u7528!";
        public static String LISTENRNULL = "[SCH10005]\u76d1\u542c\u5668\u4e3a\u7a7a";
        public static String NOINT = "\u4f60\u7684\u521d\u59cb\u5316\u672a\u5b8c\u6210\uff0c\u8bf7\u5728Application\u7684onCreate\u4e2d\u8c03\u7528 UMConfigure.init(this,appkey,channel,UMConfigure.DEVICE_TYPE_PHONE,\"\");/";
        public static String NO_SUPPORT_AUTH = "[SCH10004]\u8be5\u5e73\u53f0\u4e0d\u652f\u6301\u67e5\u8be2\u662f\u5426\u6388\u6743";
        public static String NO_SUPPORT_INSTALL = "[SCH10004]\u8be5\u5e73\u53f0\u4e0d\u652f\u6301\u67e5\u8be2\u5b89\u88c5";
        public static String NO_SUPPORT_SDKL = "[SCH10004]\u8be5\u5e73\u53f0\u4e0d\u652f\u6301\u67e5\u8be2sdk\u652f\u6301";
        public static String ROUTERNULL = "[SCH10002]Router\u4e3a\u7a7a\u8bf7\u68c0\u67e5\u662f\u5426\u7a0b\u5e8f\u88ab\u6740\u6b7b\uff0c\u6216\u91ca\u653e\u4e86\u6211\u4eec\u6240\u6709\u7684\u5f15\u7528";
        public static String SDKVERSION = "\u60a8\u4f7f\u7528\u7684SDK\u7248\u672c\u4e3a\uff1a";
        public static String SHARE_CONTENT_IS_EMPTY = "\u5206\u4eab\u5bf9\u8c61\u4e0d\u80fd\u4e3a\u7a7a!";

        public static String checkSuccess(String str, String str2) {
            return "[SC20008]\u60a8\u672c\u6b21\u6253\u5305\u7684\u7b7e\u540d:" + str + "\n\u5305\u540d:" + str2;
        }

        public static String getActivityResult(int i4, int i5) {
            return "onActivityResult =" + i4 + "  resultCode=" + i5;
        }

        public static String noJar(SHARE_MEDIA share_media) {
            return "[SC10006]\u60a8\u6ca1\u6709\u914d\u7f6e " + share_media + " \u7684jar\u5305";
        }

        public static String noKey(SHARE_MEDIA share_media) {
            return "\u60a8\u6ca1\u6709\u914d\u7f6e" + share_media.toString() + "\u7684appkey,\u8bf7\u5728Application\u4e2d\u8c03\u7528PlatformConfig.setxxx\u8fdb\u884c\u914d\u7f6e";
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public static class DING {
        public static String Ding_FILE_PROVIDER_ERROR = "\u9489\u9489\u5206\u4eab\u521d\u59cb\u5316\u7f3a\u5c11FileProvider authorities\u53c2\u6570\uff0c\u8bf7\u68c0\u67e5\u662f\u5426\u8c03\u7528PlatformConfig.setDingFileProvider\u65b9\u6cd5\u8bbe\u7f6e\u76f8\u5173\u53c2\u6570\u3002";
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public static class DROPBOX {
        public static String NEEDACTIVITY = "[SDB10001]dropbox\u8bf7\u4f20\u5165Activity";
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public static class FACEBOOK {
        public static String ERRORMETA = "[SF10000]\u6ca1\u6709\u627e\u5230facebook_app_id\uff0cfacebook\u7684id\u5fc5\u987b\u5199\u5728string\u6587\u4ef6\u4e2d\u4e14\u540d\u5b57\u5fc5\u987b\u7528facebook_app_id";
        public static String FACEBOOK_AUTH_FAIL = "\u4e3a\u4ec0\u4e48facebook\u5206\u4eab\u5931\u8d25\uff1f";
        public static String FACEBOOK_CANCEL_SUCCESS = "\u4e3a\u4ec0\u4e48facebook\u5206\u4eab\u53d6\u6d88\u5374\u56de\u8c03\u6210\u529f\uff1f";
        public static String FACEBOOK_GRAY = "\u4e3a\u4ec0\u4e48\u53d1\u5e03\u6309\u94ae\u4e3a\u7070\u8272\uff1f";
        public static String FACEBOOK_NET_SUPPORT = "facebook\u7f51\u9875\u94fe\u63a5\uff0c\u7f29\u7565\u56fe\u5fc5\u987b\u4e3a\u7f51\u7edc\u56fe\u7247";
        public static String NOFACEBOOKACTIVITY = "[SF10000]\u60a8\u6ca1\u6709\u5728AndroidManifest.xml\u4e2d\u914d\u7f6ecom.umeng.facebook.FacebookActivity";
        public static String NOFACEBOOKCONTENTPROVIDER = "[SF10000]\u60a8\u6ca1\u6709\u5728AndroidManifest.xml\u4e2d\u914d\u7f6ecom.umeng.facebook.FacebookContentProvider";
        public static String NOMETA = "[SF10000]\u60a8\u6ca1\u6709\u5728AndroidManifest\u4e2d\u914d\u7f6efacebook\u7684appid";
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public static class IMAGE {
        private static String id = "[SI10000]";
        public static String BINARYTOFILE = id + "\u5b57\u8282\u6d41\u8f6c\u6587\u4ef6\u9519\u8bef";
        public static String BITMAOTOBINARY = id + "bitmap\u8f6c\u5b57\u8282\u6d41\u9519\u8bef";
        public static String CLOSE = id + "\u6d41\u5173\u95ed\u9519\u8bef";
        public static String GET_FILE_FROM_BINARY = id + "\u5b57\u8282\u6d41\u8f93\u51fa\u6587\u4ef6\u51fa\u9519";
        public static String TOOBIG = id + "\u52a0\u8f7d\u6587\u4ef6\u8fc7\u5927";
        public static String FILE_TO_BINARY_ERROR = id + "\u6587\u4ef6\u8f6c\u5165\u5b57\u8282\u6d41\uff0c\u5148\u8981\u8fdb\u884c\u538b\u7f29\u51fa\u9519";
        public static String GET_IMAGE_SCALE_ERROR = id + "\u83b7\u53d6\u6587\u4ef6\u5927\u5c0f\u51fa\u9519";
        public static String READ_IMAGE_ERROR = id + "\u8bfb\u53d6\u56fe\u7247\u6587\u4ef6\u51fa\u9519";
        public static String CHECK_FORMAT_ERROR = id + "checkFormat\u51fa\u9519";
        public static String THUMB_ERROR = "[SI10001]\u60a8\u7684\u539f\u59cb\u56fe\u7247\u592a\u5927,\u5bfc\u81f4\u7f29\u7565\u56fe\u538b\u7f29\u8fc7\u540e\u8fd8\u5927\u4e8e32KB,\u8bf7\u5c06\u5206\u4eab\u5230\u5fae\u4fe1\u7684\u56fe\u7247\u8fdb\u884c\u9002\u5f53\u7f29\u5c0f.";
        public static String SHARECONTENT_THUMB_ERROR = "[SI10002]\u7f29\u7565\u56fe\u53c2\u6570\u6709\u8bef\uff0c\u60a8\u6ca1\u6709\u8bbe\u7f6e\u7f29\u7565\u56fe\uff0c\u6216\u8005\u8bbe\u7f6e\u7684\u7f29\u7565\u56fe\u5185\u5bb9\u6709\u8bef\uff0c\u4e0d\u80fd\u88ab\u89e3\u6790";
        public static String SHARECONTENT_IMAGE_ERROR = "[SI10003]\u56fe\u7247\u53c2\u6570\u6709\u8bef\uff0c\u60a8\u6ca1\u6709\u8bbe\u7f6e\u7f29\u7565\u56fe\uff0c\u6216\u8005\u8bbe\u7f6e\u7684\u7f29\u7565\u56fe\u5185\u5bb9\u6709\u8bef\uff0c\u4e0d\u80fd\u88ab\u89e3\u6790";
        public static String IMAGEURL = "\u56fe\u7247\u4e0b\u8f7d\u94fe\u63a5:";
        public static String UNKNOW_UMIMAGE = "[SI10004]\u4e0d\u652f\u6301\u7684UMImage\u6784\u5efa\u7c7b\u578b\uff0c\u60a8\u4f20\u5165\u7684\u7c7b\u578b\u4e3a:";
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public static class INTER {
        public static String CONTEXT_ERROR = "[SIG10002]ContextUtil\u4e2dcontext\u4e3a\u7a7a\uff0c\u8bf7\u786e\u4fdd\u7a0b\u5e8f\u521d\u59cb\u5316\u5b8c\u6bd5\uff0c\u4e14\u7a0b\u5e8f\u4e2d\u4e0d\u8981\u4f7f\u7528ContextUtil.setContext\uff08null\uff09\u65b9\u6cd5";
        public static String HANDLERID = "handler id:";
        public static String MOREERROR = "[SIG10001]\u8c03\u7528\u7cfb\u7edf\u5206\u4eab\u83dc\u5355\u9519\u8bef\uff0c\u8bf7\u6362\u4e2a\u624b\u673a\u6d4b\u8bd5";
        public static String NULLJAR = "[SIG10000]\u6ca1\u6709\u52a0\u5165\u754c\u9762jar,\u8bf7\u6dfb\u52a0shareview";
        public static String PINFO = "\u5206\u4eab\u5e73\u53f0\u76f8\u5173\u4fe1\u606f:";

        public static String getVersion(String str) {
            return "\u5e73\u53f0(" + str + "):";
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public static class NET {
        private static String id = "[SN10000]";
        public static String PARSEERROR = id + "\u8fd4\u56de\u5b57\u7b26\u4e32\u4e0d\u662fjson\uff0c\u53ef\u80fd\u662f\u7531\u4e8e\u670d\u52a1\u5668\u4e0d\u901a\u9020\u6210";
        public static String TOOL = id + "\u5de5\u5177\u7c7b\u5185\u7684\u9519\u8bef\uff0c\u4e0d\u5f71\u54cd\u7528\u6237\u4f7f\u7528";
        public static String IMAGEDOWN = "[SN10004]\u56fe\u7247\u4e0b\u8f7d\u9519\u8bef,\u8bf7\u68c0\u67e5\u7f51\u5740";
        public static String CLOSE = id + "\u5173\u95ed\u6d41\u5f02\u5e38";
        public static String CREATE = id + "\u6784\u5efaresponse\u51fa\u9519,\u4e0d\u5f71\u54cd\u7528\u6237\u4f7f\u7528\uff0c\u4f46\u9700\u8981\u67e5\u660e\u539f\u56e0";
        public static String NET_AGAIN_ERROR = "[SN10001]\u91cd\u5b9a\u5411\u95ee\u9898\uff1aurl\u548c\u91cd\u5b9a\u5411url\u76f8\u540c";
        public static String JSONNULL = "[SN10002]\u540e\u53f0\u8fd4\u56dejson\u4e3a\u7a7a";
        public static String MACNULL = "[SN10003]\u7531\u4e8e\u6743\u9650\u95ee\u9898\uff0c\u6ca1\u6709\u83b7\u53d6\u5230mac";
        public static String POSTJSON = " post json\uff1a";
        public static String JSONRESULT = " return json\uff1a";
        public static String SHARESELFOK = " sharelog success";
        public static String SHARESELFFAIL = " sharelog fail";
        public static String NET_INAVALIBLE = "\u62b1\u6b49,\u60a8\u7684\u7f51\u7edc\u4e0d\u53ef\u7528...";
        public static String BODYNULL = "body is null";

        public static String assertURL(String str, String str2) {
            return "urlPath=" + str + "  SocializeNetUtils url=" + str2;
        }

        public static String getURLERROR(String str) {
            return id + "baseurl=" + str + " \u8be5url\u4e0d\u6b63\u786e";
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public static class QQ {
        public static String ERRORCALLBACK = "\u4e3a\u4ec0\u4e48qq\u5206\u4eab\u6210\u529f\u5374\u56de\u8c03\u53d6\u6d88\uff1f";
        public static String ERRORDATA = "[SQ10011]qq\u914d\u7f6e\u4e0d\u6b63\u786e\uff0cAndroidManifest\u4e2dAuthActivity\u7684data\u4e2d\u8981\u52a0\u5165\u81ea\u5df1\u7684qq\u5e94\u7528id";
        public static String ERRORINFO = "\u9519\u8bef\u4fe1\u606f:";
        public static String NOAPPID = "[SQ10000]qq\u914d\u7f6e\u4e0d\u6b63\u786e\uff0c\u6ca1\u6709\u68c0\u6d4b\u5230qq\u7684id\u914d\u7f6e";
        public static String NOCALLBACK = "\u4e3a\u4ec0\u4e48\u6211\u7684QQ\u6ca1\u6709\u56de\u8c03\uff1f";
        public static String NOPERMISSION = "\u4e3a\u4ec0\u4e48qq\u5206\u4eab\u5931\u8d25\uff0c\u7f3a\u5c11\u6743\u9650\uff1f";
        public static String NOREPLY = "\u4e3a\u4ec0\u4e48qq\u5206\u4eab\u6210\u529f\u5374\u6ca1\u6709\u6536\u5230\u6d88\u606f\uff1f";
        public static String OPENIDANDTOKEN = "[SQ20009]initOpenidAndToken error";
        public static String QQ100044 = "\u4e3a\u4ec0\u4e48qq\u63d0\u793a100044?";
        public static String QQ_ERROR = "[SQ20007]mTencent\u4fe1\u606f\u4e0d\u6b63\u786e\uff0c\u8bf7\u786e\u8ba4appid";
        public static String QQ_FILE_PROVIDER_ERROR = "[SQ20010]Tencent\u521d\u59cb\u5316\u7f3a\u5c11FileProvider authorities\u53c2\u6570\uff0c\u8bf7\u68c0\u67e5\u662f\u5426\u8c03\u7528PlatformConfig.setQQFileProvider\u65b9\u6cd5\u8bbe\u7f6e\u76f8\u5173\u53c2\u6570\u3002";
        public static String QQ_MUSIC = "QQ\u5206\u4eab\u97f3\u4e50,\u9664\u4e86\u8bbe\u7f6e\u64ad\u653e\u97f3\u4e50\u7684url,\u8fd8\u53ef\u4ee5\u8bbe\u7f6e\u4e00\u4e2a\u8df3\u8f6c\u7684url,\u53ef\u4ee5\u901a\u8fc7UMusic().setmTargetUrl(xxx)\u8bbe\u5b9a";
        public static String QQ_PERMISSION = "[SQ10004]QQ\u56fe\u7247\u5b58\u50a8\u5931\u8d25\uff0c\u8bf7\u68c0\u67e5\u56fe\u7247\u6216\u8005\u68c0\u67e5\u662f\u5426\u6709\u8bfb\u5199\u6743\u9650";
        public static String QQ_TENCENT_ERROR = "[SQ20007]Tencent\u53d8\u91cf\u521d\u59cb\u5316\u5931\u8d25\uff0c\u8bf7\u68c0\u67e5\u4f60\u7684app id\u8ddfAndroidManifest.xml\u6587\u4ef6\u4e2dAuthActivity\u7684scheme\u662f\u5426\u586b\u5199\u6b63\u786e";
        public static String TENCENTFAIL = "\u4e3a\u4ec0\u4e48qq tencent\u521d\u59cb\u5316\u5931\u8d25\uff1f";

        public static String getError(String str) {
            return "[SQ10011]\u6ca1\u6709\u5728AndroidManifest.xml\u4e2d\u68c0\u6d4b\u5230" + str + "\u8bf7\u6dfb\u52a0" + str;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public static class SHARE {
        public static String CONTEXT_EMPTY = "\u8bf7\u8f93\u5165\u5185\u5bb9....";
        public static String CONTEXT_LONG = "\u8d85\u51fa\u6700\u5927\u5b57\u6570\u9650\u5236....";
        public static String EMPTY_TEXT = "[SST10004]\u5206\u4eab\u7684\u6587\u672c\u4e0d\u80fd\u4e3a\u7a7a";
        public static String EMPTY_WEB_URL = "[SST10003]\u60a8\u5206\u4eab\u7684\u662f\u7f51\u9875\u7c7b\u578b\u4f46\u662f\u7f51\u5740\u4e3a\u7a7a";
        public static String ERRORTYPE = "[SST10000]\u4e0d\u652f\u6301\u7684\u5206\u4eab\u7c7b\u578b";
        public static String FILENAME = "\u6587\u4ef6\u540d:";
        public static String FLICKER_WARN = "Flickr\u53ea\u652f\u6301\u56fe\u7247\u5206\u4eab";
        public static String FOURSQUARE_WARN = "Foursquare\u53ea\u652f\u6301\u7eaf\u56fe\u7247\u5206\u4eab";
        public static String INFO = "\u4ee5\u4e0b\u4e3a\u5206\u4eab\u7684\u5185\u5bb9:";
        public static String LOCALIMAGE = "\u672c\u5730\u56fe\u7247:";
        public static String LOCALTHUMB = "\u672c\u5730\u7f29\u7565\u56fe:";
        public static String LONG_TEXT = "[SST10005]\u5206\u4eab\u7684\u6587\u672c\u8fc7\u957f";
        public static String LONG_URL = "[SST10006]\u5206\u4eab\u7684\u94fe\u63a5\u8fc7\u957f";
        public static String MUSICDES = "\u97f3\u4e50\u63cf\u8ff0:";
        public static String MUSICTITLE = "\u97f3\u4e50\u6807\u9898:";
        public static String MUSICURL = "\u97f3\u4e50\u94fe\u63a5:";
        public static String SHAREPLAT = "\u5206\u4eab\u5e73\u53f0:";
        public static String SHARESTYLE = "\u5206\u4eab\u7c7b\u578b:";
        public static String SHARETEXT = "\u5206\u4eab\u6587\u672c:";
        public static String SHAREVIEWV = "shareview\u7248\u672c\u53f7:";
        public static String SHARE_CONTENT_FAIL = "[SST10002]\u5f53\u524d\u5206\u4eab\u7c7b\u578b\u5185\u5bb9\u6709\u8bef\uff0c\u7f3a\u5c11\u8bbe\u7f6e\u53c2\u6570\u6216\u5185\u5bb9\u4e0d\u5408\u89c4\uff0c\u8bf7\u67e5\u770b\u53cb\u76dflog";
        public static String SHARE_STYLE = "\u5206\u4eab\u7c7b\u578b--";
        public static String SHARE_TO = "\u5206\u4eab\u5230";
        public static String URLDES = "url\u63cf\u8ff0:";
        public static String URLIMAGE = "\u56fe\u7247\u94fe\u63a5:";
        public static String URLTHUMB = "\u7f29\u7565\u56fe\u94fe\u63a5:";
        public static String URLTITLE = "url\u6807\u9898:";
        public static String URLURL = "\u94fe\u63a5:";
        public static String VERSION = "API\u7248\u672c\u53f7:";
        public static String VERSION_NOT_SUPPORT = "[SST10001]\u5206\u4eab\u5185\u5bb9\u6709\u8bef\uff0c\u8bf7\u67e5\u770blog\u6216\u5f53\u524d\u4f7f\u7528\u7684\u5ba2\u6237\u7aef\u7248\u672c\u4e0d\u652f\u6301\u5206\u4eab\u6216\u6388\u6743";
        public static String VIDEODES = "\u89c6\u9891\u63cf\u8ff0:";
        public static String VIDEOTITLE = "\u89c6\u9891\u6807\u9898:";
        public static String VIDEOURL = "\u89c6\u9891\u94fe\u63a5:";
        public static String WEB_HTTP = "[SST10007]\u5206\u4eab\u7684\u94fe\u63a5\u9700\u8981\u4ee5http\u5f00\u5934";
        public static String YNOTE_WARN = "\u6709\u9053\u4e91\u7b14\u8bb0\u53ea\u652f\u6301\u6587\u672c\uff0c\u56fe\u7247\uff0c\u56fe\u6587\u5206\u4eab";
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public static class SHAREBOARD {
        public static String NULLJAR = "[SSB10001]\u60a8\u7684\u5de5\u7a0b\u9700\u8981\u4f9d\u8d56v4\u6216\u6211\u4eec\u63d0\u4f9bumeng_shareboard_widget\u5305\uff0c\u8bf7\u53c2\u8003\u7ebf\u4e0a\u6587\u6863";
        public static String NULLNAME = "[SSB10000]\u83b7\u53d6\u5e73\u53f0\u540d\u5b57\u4e3a\u7a7a\uff0c\u8bf7\u68c0\u67e5\u4ee3\u7801";
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public static class SINA {
        public static String SINASTARTERROR = "[SS10008]\u542f\u52a8\u65b0\u6d6a\u5ba2\u6237\u7aef\u9519\u8bef";
        public static String SINA_AID_ERROR = "[SS10009]\u65b0\u6d6aAID\u83b7\u53d6\u5931\u8d25";
        public static String SINA_FILE_PROVIDER_ERROR = "[SS10014]\u65b0\u6d6a\u5fae\u535a\u5206\u4eab\u521d\u59cb\u5316\u7f3a\u5c11FileProvider authorities\u53c2\u6570\uff0c\u8bf7\u68c0\u67e5\u662f\u5426\u8c03\u7528PlatformConfig.setSinaFileProvider\u65b9\u6cd5\u8bbe\u7f6e\u76f8\u5173\u53c2\u6570\u3002";
        public static String SINA_GET_ERROR = "[SS10011]\u8fd4\u56de\u7ed3\u679c\u4e3a\u7a7a\uff0c\u8bf7\u68c0\u67e5\u7f51\u7edc\uff0c\u6216token\u662f\u5426\u8fc7\u671f,\u8bf7\u68c0\u67e5Appkey\u662f\u5426\u5ba1\u6838\u901a\u8fc7";
        public static String SINA_MUL_IMAGE = "\u65b0\u6d6a\u591a\u56fe\u5206\u4eab\u5fc5\u987b\u52a0\u6587\u5b57";
        public static String SINA_SIGN_ERROR = "[SS10001]\u65b0\u6d6a\u7b7e\u540d\u6216\u56de\u8c03\u5730\u5740\u9519\u8bef\uff0c\u8bf7\u53bb\u540e\u53f0\u68c0\u67e5";
        public static String SINA_THUMB_ERROR = "[SS10007]\u65b0\u6d6a\u591a\u5a92\u4f53\u5206\u4eab\uff0c\u9700\u8981\u6dfb\u52a0\u7f29\u7565\u56fe\uff0c\u8bf7\u68c0\u67e5\u662f\u5426\u6dfb\u52a0\u6b63\u786e";
        public static String SINA_UPLOAD_ERROR = "[SS10012]\u65b0\u6d6a\u4e0a\u4f20\u56fe\u7247\u5931\u8d25";

        public static String getError(String str) {
            return "[SS10010]\u6ca1\u6709\u5728AndroidManifest.xml\u4e2d\u68c0\u6d4b\u5230" + str + "\u8bf7\u6dfb\u52a0" + str;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public static class TWITTER {
        public static String TWITTER_AUTH_FAIL = "\u4e3a\u4ec0\u4e48\u63d0\u793a\u6211\u4eec\u65e0\u6cd5\u9a8c\u8bc1\u60a8\u7684\u51ed\u636e\uff1f";
        public static String TWITTER_NULL_SESSION = "\u5f53\u524d\u65e0\u6d3b\u52a8\u4f1a\u8bdd\uff0c\u8bf7\u786e\u4fdd\u5df2\u7ecf\u5b8c\u6210\u6388\u6743\u7533\u8bf7\u3002";
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public static class WX {
        public static String WEIXIN_FILE_PROVIDER_ERROR = "[SX10003]\u5fae\u4fe1\u5206\u4eab\u521d\u59cb\u5316\u7f3a\u5c11FileProvider authorities\u53c2\u6570\uff0c\u8bf7\u68c0\u67e5\u662f\u5426\u8c03\u7528PlatformConfig.setWXFileProvider\u65b9\u6cd5\u8bbe\u7f6e\u76f8\u5173\u53c2\u6570\u3002";
        public static String WX_40125 = "\u4e3a\u4ec0\u4e48\u5fae\u4fe1\u63d0\u793a40125/invalid APPsecret\uff1f";
        public static String WX_CIRCLE_NOCONTENT = "\u4e3a\u4ec0\u4e48\u5fae\u4fe1\u670b\u53cb\u5708\u94fe\u63a5\u4e0d\u663e\u793a\u63cf\u8ff0\u6587\u5b57\uff1f";
        public static String WX_CIRCLE_NOT_SUPPORT_EMOJ = "\u5fae\u4fe1\u670b\u53cb\u5708\u4e0d\u652f\u6301\u8868\u60c5\u5206\u4eab...";
        public static String WX_CIRCLE_NOT_SUPPORT_MIN = "\u5fae\u4fe1\u670b\u53cb\u5708\u4e0d\u652f\u6301\u5c0f\u7a0b\u5e8f\u5206\u4eab...";
        public static String WX_ERRORACTIVITY = "[SX10001]\u8bf7\u8ba9\u60a8\u7684WXEntryActivity\u7ee7\u627fcom.umeng.socialize.weixin.view.WXCallbackActivity";
        public static String WX_ERRORMANIFEST = "[SX10002]\u8bf7\u5728AndroidManifest\u6587\u4ef6\u4e2d\u914d\u7f6eWXEntryActivity";
        public static String WX_ERROR_SIGN = "\u4e3a\u4ec0\u4e48\u5fae\u4fe1\u6388\u6743\u4e00\u76f4\u7b49\u5f85\u4e0d\u80fd\u6210\u529f\uff1f";
        public static String WX_HIT_PUSH = "\u4e3a\u4ec0\u4e48\u5fae\u4fe1\u5206\u4eab\u63d0\u793ahit push hold\uff1f";
        public static String WX_NOACTIVITY = "[SX10000]\u60a8\u6ca1\u6709\u914d\u7f6eWXEntryActivity\u6216\u6ca1\u6709\u914d\u7f6e\u4e0d\u6b63\u786e";
        public static String WX_NOTHUMB_EMOJ = "\u5fae\u4fe1\u8868\u60c5\u5206\u4eab\u6ca1\u6709\u8bbe\u7f6e\u7f29\u7565\u56fe";
        public static String WX_NO_CALLBACK = "\u4e3a\u4ec0\u4e48\u5fae\u4fe1\u6ca1\u6709\u56de\u8c03\uff1f";
        public static String WX_NO_LINK = "\u4e3a\u4ec0\u4e48\u5fae\u4fe1\u767b\u9646\u63d0\u793a\u8be5\u94fe\u63a5\u65e0\u6cd5\u8bbf\u95ee\uff1f";
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public static class WXWORK {
        public static String WXWORK_FILE_PROVIDER_ERROR = "[SWW10000]\u4f01\u4e1a\u5fae\u4fe1\u5206\u4eab\u521d\u59cb\u5316\u7f3a\u5c11FileProvider authorities\u53c2\u6570\uff0c\u8bf7\u68c0\u67e5\u662f\u5426\u8c03\u7528PlatformConfig.setWXWorkFileProvider\u65b9\u6cd5\u8bbe\u7f6e\u76f8\u5173\u53c2\u6570\u3002";
    }

    public static String errorWithUrl(String str, String str2) {
        return str + "\n\u89e3\u51b3\u65b9\u6848\uff1a" + str2;
    }

    public static String netMethodError(String str) {
        return "\u9a8c\u8bc1\u8bf7\u6c42\u65b9\u5f0f\u5931\u8d25[" + str + "]";
    }

    public static String resError(String str, String str2, String str3) {
        return "\u7f3a\u5c11\u8d44\u6e90\u6587\u4ef6:packageName=" + str + "\n type=" + str2 + "\n name=" + str3 + "\u8bf7\u53bbsdk\u4e0b\u8f7d\u5305\u4e2d\u62f7\u8d1d";
    }

    public static String supportStyle(boolean z3, String str) {
        StringBuilder sb = new StringBuilder("\u8be5\u5e73\u53f0");
        sb.append(z3 ? "\u53ea" : "\u4e0d");
        sb.append("\u652f\u6301");
        if (str.contains("image")) {
            sb.append("\u56fe\u7247");
        }
        if (str.contains("netimg")) {
            sb.append("\u7f51\u7edc\u56fe\u7247");
        }
        if (str.contains("localimg")) {
            sb.append("\u672c\u5730\u56fe\u7247");
        }
        if (str.contains("url")) {
            sb.append("\u94fe\u63a5");
        }
        if (str.contains("video")) {
            sb.append("\u89c6\u9891");
        }
        if (str.contains("timg")) {
            sb.append("\u56fe\u6587");
        }
        if (str.contains("text")) {
            sb.append("\u7eaf\u6587\u672c");
        }
        sb.append("\u5206\u4eab");
        return sb.toString();
    }

    public static String tencentEmpty(boolean z3) {
        String str = z3 ? SIMPLE : FULL;
        return "\u60a8\u4f7f\u7528\u7684\u662f" + str + "\u4f46\u662f\u4f60\u7684AndroidManifest\u914d\u7f6e\u4e0d\u6b63\u786e\uff0c\u6216\u8005\u914d\u7f6e\u7684\u4e0d\u662f" + str + "\u7684\u8def\u5f84\uff0c\u8bf7\u53c2\u7167\u7ebf\u4e0a\u62a5\u9519\u5fc5\u770b\u6587\u6863";
    }

    public static String urlEmpty(int i4) {
        StringBuilder sb = new StringBuilder("\u9519\u8bef:\u8bbe\u7f6e\u89c6\u9891");
        if (i4 == 0) {
            sb.append("\u89c6\u9891");
        }
        if (i4 == 1) {
            sb.append("\u97f3\u4e50");
        }
        if (i4 == 2) {
            sb.append("\u7f51\u9875");
        }
        sb.append("\u5206\u4eab\u7c7b\u578b\uff0c\u94fe\u63a5\u4e0d\u80fd\u4e3a\u7a7a");
        return sb.toString();
    }
}

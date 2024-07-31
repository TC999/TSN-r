package com.umeng.socialize.utils;

import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.utils.UmengText;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class UrlUtil {
    public static final String QQ_TENCENT_INITFAIL = makeUrl("66781");
    public static final String ALL_AUTH_EVERY = makeUrl("66824");
    public static final String ALL_NOCLASSDEFFOUND = makeUrl("66809");
    public static final String FACEBOOK_GRAY = makeUrl("66838");
    public static final String FACEBOOK_CANCEL_SUCCESS = makeUrl("66839");
    public static final String FACEBOOK_AUTH_FAIL = makeUrl("66837");
    public static final String TWITTER_AUTH_FAIL = makeUrl("66841");
    public static final String QQ_SHARESUCCESS_CANCEL = makeUrl("66774");
    public static final String QQ_SHARESUCCESS_NOFOUND = makeUrl("66776");
    public static final String QQ_SHARE_FAIL = makeUrl("66778");
    public static final String QQ_10044 = makeUrl("66779");
    public static final String QQ_NO_CALLBACK = makeUrl("66780");
    public static final String SINA_ERROR_SIGN = makeUrl("66755");
    public static final String WX_NO_LINK = makeUrl("66786");
    public static final String WX_CIRCLE_NOCONTENT = makeUrl("66797");
    public static final String ALL_NO_JAR = makeUrl("66815");
    public static final String ALL_NO_ONACTIVITY = makeUrl("66849");
    public static final String WX_40125 = makeUrl("66802");
    public static final String WX_NO_CALLBACK = makeUrl("66791");
    public static final String WX_ERROR_SIGN = makeUrl("66787");
    public static final String WX_HIT_PUSH = makeUrl("66795");
    public static final String ALL_NO_RES = makeUrl("66810");
    public static final String ALL_NO_APPKEY = makeUrl("66831");
    public static final String ALL_ERROR_APPKEY = makeUrl("67234");
    public static final String ALL_SHAREFAIL = makeUrl("66875");
    public static final String ALL_AUTHFAIL = makeUrl("66876");

    public static void getInfoPrint(SHARE_MEDIA share_media) {
        SLog.m13212AQ(UmengText.AUTH.ALL_AUTH_EVERY, ALL_AUTH_EVERY);
        if (share_media == SHARE_MEDIA.QQ) {
            SLog.m13212AQ(UmengText.C13465QQ.QQ100044, QQ_10044);
        }
        if (share_media == SHARE_MEDIA.WEIXIN) {
            SLog.m13212AQ(UmengText.C13466WX.WX_NO_LINK, WX_NO_LINK);
            SLog.m13212AQ(UmengText.C13466WX.WX_ERROR_SIGN, WX_ERROR_SIGN);
            SLog.m13212AQ(UmengText.C13466WX.WX_40125, WX_40125);
        }
    }

    public static String makeUrl(String str) {
        return "https://developer.umeng.com/docs/66632/detail/" + str + "?um_channel=sdk";
    }

    public static void sharePrint(SHARE_MEDIA share_media) {
        if (share_media == SHARE_MEDIA.QQ) {
            SLog.m13212AQ(UmengText.C13465QQ.NOCALLBACK, QQ_NO_CALLBACK);
            SLog.m13212AQ(UmengText.C13465QQ.ERRORCALLBACK, QQ_SHARESUCCESS_CANCEL);
            SLog.m13212AQ(UmengText.C13465QQ.NOREPLY, QQ_SHARESUCCESS_NOFOUND);
            SLog.m13212AQ(UmengText.C13465QQ.NOPERMISSION, QQ_SHARE_FAIL);
            SLog.m13212AQ(UmengText.C13465QQ.TENCENTFAIL, QQ_TENCENT_INITFAIL);
            SLog.m13212AQ(UmengText.C13465QQ.QQ100044, QQ_10044);
        }
        if (share_media == SHARE_MEDIA.FACEBOOK || share_media == SHARE_MEDIA.FACEBOOK_MESSAGER) {
            SLog.m13212AQ(UmengText.FACEBOOK.FACEBOOK_GRAY, FACEBOOK_GRAY);
            SLog.m13212AQ(UmengText.FACEBOOK.FACEBOOK_CANCEL_SUCCESS, FACEBOOK_CANCEL_SUCCESS);
            SLog.m13212AQ(UmengText.FACEBOOK.FACEBOOK_AUTH_FAIL, FACEBOOK_AUTH_FAIL);
        }
        if (share_media == SHARE_MEDIA.TWITTER) {
            SLog.m13212AQ(UmengText.TWITTER.TWITTER_AUTH_FAIL, TWITTER_AUTH_FAIL);
        }
        if (share_media == SHARE_MEDIA.WEIXIN || share_media == SHARE_MEDIA.WEIXIN_CIRCLE) {
            SLog.m13212AQ(UmengText.C13466WX.WX_NO_CALLBACK, WX_NO_CALLBACK);
            SLog.m13212AQ(UmengText.C13466WX.WX_CIRCLE_NOCONTENT, WX_CIRCLE_NOCONTENT);
            SLog.m13212AQ(UmengText.C13466WX.WX_40125, WX_40125);
            SLog.m13212AQ(UmengText.C13466WX.WX_HIT_PUSH, WX_HIT_PUSH);
        }
    }
}

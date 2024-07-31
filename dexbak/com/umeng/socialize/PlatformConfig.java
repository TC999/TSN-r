package com.umeng.socialize;

import android.text.TextUtils;
import com.umeng.socialize.bean.SHARE_MEDIA;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class PlatformConfig {
    public static Map<SHARE_MEDIA, Platform> configs;
    private static String sFileProvider;

    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static class APPIDPlatform implements Platform {

        /* renamed from: p */
        private SHARE_MEDIA f39245p;
        public String appId = null;
        public String appkey = null;
        public String redirectUrl = null;
        public String fileProvider = null;
        public String click_key = null;
        public String agentId = null;
        public String schema = null;

        public APPIDPlatform(SHARE_MEDIA share_media) {
            this.f39245p = share_media;
        }

        @Override // com.umeng.socialize.PlatformConfig.Platform
        public String getAppSecret() {
            return this.appkey;
        }

        @Override // com.umeng.socialize.PlatformConfig.Platform
        public String getAppid() {
            return this.appId;
        }

        @Override // com.umeng.socialize.PlatformConfig.Platform
        public String getClick_key() {
            return this.click_key;
        }

        public String getFileProvider() {
            String str = this.fileProvider;
            return str != null ? str : PlatformConfig.sFileProvider;
        }

        @Override // com.umeng.socialize.PlatformConfig.Platform
        public SHARE_MEDIA getName() {
            return this.f39245p;
        }

        @Override // com.umeng.socialize.PlatformConfig.Platform
        public boolean isConfigured() {
            return (TextUtils.isEmpty(this.appId) || TextUtils.isEmpty(this.appkey)) ? false : true;
        }

        @Override // com.umeng.socialize.PlatformConfig.Platform
        public void parse(JSONObject jSONObject) {
        }

        public void setFileProvider(String str) {
            this.fileProvider = str;
        }
    }

    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static class CustomPlatform implements Platform {
        public static final String Name = "g+";
        public String appId = null;
        public String appkey = null;
        public String click_key = null;

        /* renamed from: p */
        private SHARE_MEDIA f39246p;

        public CustomPlatform(SHARE_MEDIA share_media) {
            this.f39246p = share_media;
        }

        @Override // com.umeng.socialize.PlatformConfig.Platform
        public String getAppSecret() {
            return this.appkey;
        }

        @Override // com.umeng.socialize.PlatformConfig.Platform
        public String getAppid() {
            return this.appId;
        }

        @Override // com.umeng.socialize.PlatformConfig.Platform
        public String getClick_key() {
            return this.click_key;
        }

        @Override // com.umeng.socialize.PlatformConfig.Platform
        public SHARE_MEDIA getName() {
            return this.f39246p;
        }

        @Override // com.umeng.socialize.PlatformConfig.Platform
        public boolean isConfigured() {
            return true;
        }

        @Override // com.umeng.socialize.PlatformConfig.Platform
        public void parse(JSONObject jSONObject) {
        }
    }

    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public interface Platform {
        String getAppSecret();

        String getAppid();

        String getClick_key();

        SHARE_MEDIA getName();

        boolean isConfigured();

        void parse(JSONObject jSONObject);
    }

    static {
        HashMap hashMap = new HashMap();
        configs = hashMap;
        SHARE_MEDIA share_media = SHARE_MEDIA.QQ;
        hashMap.put(share_media, new APPIDPlatform(share_media));
        Map<SHARE_MEDIA, Platform> map = configs;
        SHARE_MEDIA share_media2 = SHARE_MEDIA.QZONE;
        map.put(share_media2, new APPIDPlatform(share_media2));
        Map<SHARE_MEDIA, Platform> map2 = configs;
        SHARE_MEDIA share_media3 = SHARE_MEDIA.WEIXIN;
        map2.put(share_media3, new APPIDPlatform(share_media3));
        configs.put(SHARE_MEDIA.VKONTAKTE, new APPIDPlatform(share_media3));
        Map<SHARE_MEDIA, Platform> map3 = configs;
        SHARE_MEDIA share_media4 = SHARE_MEDIA.WEIXIN_CIRCLE;
        map3.put(share_media4, new APPIDPlatform(share_media4));
        Map<SHARE_MEDIA, Platform> map4 = configs;
        SHARE_MEDIA share_media5 = SHARE_MEDIA.WEIXIN_FAVORITE;
        map4.put(share_media5, new APPIDPlatform(share_media5));
        Map<SHARE_MEDIA, Platform> map5 = configs;
        SHARE_MEDIA share_media6 = SHARE_MEDIA.WXWORK;
        map5.put(share_media6, new APPIDPlatform(share_media6));
        Map<SHARE_MEDIA, Platform> map6 = configs;
        SHARE_MEDIA share_media7 = SHARE_MEDIA.FACEBOOK_MESSAGER;
        map6.put(share_media7, new CustomPlatform(share_media7));
        Map<SHARE_MEDIA, Platform> map7 = configs;
        SHARE_MEDIA share_media8 = SHARE_MEDIA.DOUBAN;
        map7.put(share_media8, new CustomPlatform(share_media8));
        Map<SHARE_MEDIA, Platform> map8 = configs;
        SHARE_MEDIA share_media9 = SHARE_MEDIA.YIXIN;
        map8.put(share_media9, new APPIDPlatform(share_media9));
        Map<SHARE_MEDIA, Platform> map9 = configs;
        SHARE_MEDIA share_media10 = SHARE_MEDIA.YIXIN_CIRCLE;
        map9.put(share_media10, new APPIDPlatform(share_media10));
        Map<SHARE_MEDIA, Platform> map10 = configs;
        SHARE_MEDIA share_media11 = SHARE_MEDIA.SINA;
        map10.put(share_media11, new APPIDPlatform(share_media11));
        Map<SHARE_MEDIA, Platform> map11 = configs;
        SHARE_MEDIA share_media12 = SHARE_MEDIA.ALIPAY;
        map11.put(share_media12, new APPIDPlatform(share_media12));
        Map<SHARE_MEDIA, Platform> map12 = configs;
        SHARE_MEDIA share_media13 = SHARE_MEDIA.DROPBOX;
        map12.put(share_media13, new APPIDPlatform(share_media13));
        Map<SHARE_MEDIA, Platform> map13 = configs;
        SHARE_MEDIA share_media14 = SHARE_MEDIA.FACEBOOK;
        map13.put(share_media14, new CustomPlatform(share_media14));
        Map<SHARE_MEDIA, Platform> map14 = configs;
        SHARE_MEDIA share_media15 = SHARE_MEDIA.TWITTER;
        map14.put(share_media15, new APPIDPlatform(share_media15));
        Map<SHARE_MEDIA, Platform> map15 = configs;
        SHARE_MEDIA share_media16 = SHARE_MEDIA.TUMBLR;
        map15.put(share_media16, new CustomPlatform(share_media16));
        Map<SHARE_MEDIA, Platform> map16 = configs;
        SHARE_MEDIA share_media17 = SHARE_MEDIA.PINTEREST;
        map16.put(share_media17, new APPIDPlatform(share_media17));
        Map<SHARE_MEDIA, Platform> map17 = configs;
        SHARE_MEDIA share_media18 = SHARE_MEDIA.POCKET;
        map17.put(share_media18, new CustomPlatform(share_media18));
        Map<SHARE_MEDIA, Platform> map18 = configs;
        SHARE_MEDIA share_media19 = SHARE_MEDIA.WHATSAPP;
        map18.put(share_media19, new CustomPlatform(share_media19));
        Map<SHARE_MEDIA, Platform> map19 = configs;
        SHARE_MEDIA share_media20 = SHARE_MEDIA.EMAIL;
        map19.put(share_media20, new CustomPlatform(share_media20));
        Map<SHARE_MEDIA, Platform> map20 = configs;
        SHARE_MEDIA share_media21 = SHARE_MEDIA.SMS;
        map20.put(share_media21, new CustomPlatform(share_media21));
        Map<SHARE_MEDIA, Platform> map21 = configs;
        SHARE_MEDIA share_media22 = SHARE_MEDIA.LINKEDIN;
        map21.put(share_media22, new CustomPlatform(share_media22));
        Map<SHARE_MEDIA, Platform> map22 = configs;
        SHARE_MEDIA share_media23 = SHARE_MEDIA.LINE;
        map22.put(share_media23, new CustomPlatform(share_media23));
        Map<SHARE_MEDIA, Platform> map23 = configs;
        SHARE_MEDIA share_media24 = SHARE_MEDIA.FLICKR;
        map23.put(share_media24, new CustomPlatform(share_media24));
        Map<SHARE_MEDIA, Platform> map24 = configs;
        SHARE_MEDIA share_media25 = SHARE_MEDIA.EVERNOTE;
        map24.put(share_media25, new CustomPlatform(share_media25));
        Map<SHARE_MEDIA, Platform> map25 = configs;
        SHARE_MEDIA share_media26 = SHARE_MEDIA.FOURSQUARE;
        map25.put(share_media26, new CustomPlatform(share_media26));
        Map<SHARE_MEDIA, Platform> map26 = configs;
        SHARE_MEDIA share_media27 = SHARE_MEDIA.YNOTE;
        map26.put(share_media27, new CustomPlatform(share_media27));
        Map<SHARE_MEDIA, Platform> map27 = configs;
        SHARE_MEDIA share_media28 = SHARE_MEDIA.KAKAO;
        map27.put(share_media28, new APPIDPlatform(share_media28));
        Map<SHARE_MEDIA, Platform> map28 = configs;
        SHARE_MEDIA share_media29 = SHARE_MEDIA.INSTAGRAM;
        map28.put(share_media29, new CustomPlatform(share_media29));
        Map<SHARE_MEDIA, Platform> map29 = configs;
        SHARE_MEDIA share_media30 = SHARE_MEDIA.MORE;
        map29.put(share_media30, new CustomPlatform(share_media30));
        configs.put(SHARE_MEDIA.DINGTALK, new APPIDPlatform(share_media30));
        Map<SHARE_MEDIA, Platform> map30 = configs;
        SHARE_MEDIA share_media31 = SHARE_MEDIA.BYTEDANCE;
        map30.put(share_media31, new APPIDPlatform(share_media31));
        Map<SHARE_MEDIA, Platform> map31 = configs;
        SHARE_MEDIA share_media32 = SHARE_MEDIA.BYTEDANCE_PUBLISH;
        map31.put(share_media32, new APPIDPlatform(share_media32));
        Map<SHARE_MEDIA, Platform> map32 = configs;
        SHARE_MEDIA share_media33 = SHARE_MEDIA.BYTEDANCE_FRIENDS;
        map32.put(share_media33, new APPIDPlatform(share_media33));
        Map<SHARE_MEDIA, Platform> map33 = configs;
        SHARE_MEDIA share_media34 = SHARE_MEDIA.HONOR;
        map33.put(share_media34, new APPIDPlatform(share_media34));
    }

    public static void disableAndroidId() {
        try {
            Class<?> cls = Class.forName("com.umeng.commonsdk.UMConfigure");
            Method declaredMethod = cls.getDeclaredMethod("disableAidCollect", new Class[0]);
            if (declaredMethod != null) {
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(cls, new Object[0]);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static String getFileProvider() {
        return sFileProvider;
    }

    public static Platform getPlatform(SHARE_MEDIA share_media) {
        return configs.get(share_media);
    }

    public static void setAlipay(String str) {
        ((APPIDPlatform) configs.get(SHARE_MEDIA.ALIPAY)).appId = str.replace(" ", "");
    }

    public static void setBytedance(String str, String str2, String str3, String str4) {
        APPIDPlatform aPPIDPlatform = (APPIDPlatform) configs.get(SHARE_MEDIA.BYTEDANCE);
        aPPIDPlatform.appId = str.replace(" ", "");
        aPPIDPlatform.click_key = str2.replace(" ", "");
        aPPIDPlatform.appkey = str3.replace(" ", "");
        aPPIDPlatform.setFileProvider(str4.replace(" ", ""));
        APPIDPlatform aPPIDPlatform2 = (APPIDPlatform) configs.get(SHARE_MEDIA.BYTEDANCE_PUBLISH);
        aPPIDPlatform2.appId = str.replace(" ", "");
        aPPIDPlatform2.click_key = str2.replace(" ", "");
        aPPIDPlatform2.appkey = str3.replace(" ", "");
        aPPIDPlatform2.setFileProvider(str4.replace(" ", ""));
        APPIDPlatform aPPIDPlatform3 = (APPIDPlatform) configs.get(SHARE_MEDIA.BYTEDANCE_FRIENDS);
        aPPIDPlatform3.appId = str.replace(" ", "");
        aPPIDPlatform3.click_key = str2.replace(" ", "");
        aPPIDPlatform3.appkey = str3.replace(" ", "");
        aPPIDPlatform3.setFileProvider(str4.replace(" ", ""));
        setFileProvider(str4);
    }

    public static void setDing(String str) {
        ((APPIDPlatform) configs.get(SHARE_MEDIA.DINGTALK)).appId = str.replace(" ", "");
    }

    @Deprecated
    public static void setDingFileProvider(String str) {
        ((APPIDPlatform) configs.get(SHARE_MEDIA.DINGTALK)).setFileProvider(str.replace(" ", ""));
        setFileProvider(str);
    }

    public static void setDropbox(String str, String str2) {
        APPIDPlatform aPPIDPlatform = (APPIDPlatform) configs.get(SHARE_MEDIA.DROPBOX);
        aPPIDPlatform.appId = str.replace(" ", "");
        aPPIDPlatform.appkey = str2.replace(" ", "");
    }

    public static void setFileProvider(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        sFileProvider = str;
    }

    public static void setHonor(String str, String str2) {
        APPIDPlatform aPPIDPlatform = (APPIDPlatform) configs.get(SHARE_MEDIA.HONOR);
        aPPIDPlatform.appId = str.replace(" ", "");
        aPPIDPlatform.appkey = str2.replace(" ", "");
    }

    public static void setHonorRedirectUrl(String str) {
        ((APPIDPlatform) configs.get(SHARE_MEDIA.HONOR)).redirectUrl = str;
    }

    public static void setKakao(String str) {
        ((APPIDPlatform) configs.get(SHARE_MEDIA.KAKAO)).appId = str.replace(" ", "");
    }

    public static void setPinterest(String str) {
        ((APPIDPlatform) configs.get(SHARE_MEDIA.PINTEREST)).appId = str.replace(" ", "");
    }

    @Deprecated
    public static void setQQFileProvider(String str) {
        ((APPIDPlatform) configs.get(SHARE_MEDIA.QZONE)).setFileProvider(str.replace(" ", ""));
        ((APPIDPlatform) configs.get(SHARE_MEDIA.QQ)).setFileProvider(str.replace(" ", ""));
        setFileProvider(str);
    }

    public static void setQQZone(String str, String str2) {
        APPIDPlatform aPPIDPlatform = (APPIDPlatform) configs.get(SHARE_MEDIA.QZONE);
        aPPIDPlatform.appId = str.replace(" ", "");
        aPPIDPlatform.appkey = str2.replace(" ", "");
        APPIDPlatform aPPIDPlatform2 = (APPIDPlatform) configs.get(SHARE_MEDIA.QQ);
        aPPIDPlatform2.appId = str.replace(" ", "");
        aPPIDPlatform2.appkey = str2.replace(" ", "");
    }

    @Deprecated
    public static void setSinaFileProvider(String str) {
        ((APPIDPlatform) configs.get(SHARE_MEDIA.SINA)).setFileProvider(str.replace(" ", ""));
        setFileProvider(str);
    }

    public static void setSinaWeibo(String str, String str2, String str3) {
        APPIDPlatform aPPIDPlatform = (APPIDPlatform) configs.get(SHARE_MEDIA.SINA);
        aPPIDPlatform.appId = str.replace(" ", "");
        aPPIDPlatform.appkey = str2.replace(" ", "");
        aPPIDPlatform.redirectUrl = str3;
    }

    public static void setTwitter(String str, String str2) {
        APPIDPlatform aPPIDPlatform = (APPIDPlatform) configs.get(SHARE_MEDIA.TWITTER);
        aPPIDPlatform.appId = str.replace(" ", "");
        aPPIDPlatform.appkey = str2.replace(" ", "");
    }

    public static void setVKontakte(String str, String str2) {
        APPIDPlatform aPPIDPlatform = (APPIDPlatform) configs.get(SHARE_MEDIA.VKONTAKTE);
        aPPIDPlatform.appId = str.replace(" ", "");
        aPPIDPlatform.appkey = str2.replace(" ", "");
    }

    @Deprecated
    public static void setWXFileProvider(String str) {
        ((APPIDPlatform) configs.get(SHARE_MEDIA.WEIXIN)).setFileProvider(str.replace(" ", ""));
        ((APPIDPlatform) configs.get(SHARE_MEDIA.WEIXIN_CIRCLE)).setFileProvider(str.replace(" ", ""));
        ((APPIDPlatform) configs.get(SHARE_MEDIA.WEIXIN_FAVORITE)).setFileProvider(str.replace(" ", ""));
        setFileProvider(str);
    }

    public static void setWXWork(String str, String str2, String str3, String str4) {
        APPIDPlatform aPPIDPlatform = (APPIDPlatform) configs.get(SHARE_MEDIA.WXWORK);
        aPPIDPlatform.appId = str.replace(" ", "");
        aPPIDPlatform.appkey = str2.replace(" ", "");
        aPPIDPlatform.agentId = str3.replace(" ", "");
        aPPIDPlatform.schema = str4.replace(" ", "");
    }

    @Deprecated
    public static void setWXWorkFileProvider(String str) {
        ((APPIDPlatform) configs.get(SHARE_MEDIA.WXWORK)).setFileProvider(str.replace(" ", ""));
        setFileProvider(str);
    }

    public static void setWeixin(String str, String str2) {
        APPIDPlatform aPPIDPlatform = (APPIDPlatform) configs.get(SHARE_MEDIA.WEIXIN);
        aPPIDPlatform.appId = str.replace(" ", "");
        aPPIDPlatform.appkey = str2.replace(" ", "");
        APPIDPlatform aPPIDPlatform2 = (APPIDPlatform) configs.get(SHARE_MEDIA.WEIXIN_CIRCLE);
        aPPIDPlatform2.appId = str.replace(" ", "");
        aPPIDPlatform2.appkey = str2.replace(" ", "");
        APPIDPlatform aPPIDPlatform3 = (APPIDPlatform) configs.get(SHARE_MEDIA.WEIXIN_FAVORITE);
        aPPIDPlatform3.appId = str.replace(" ", "");
        aPPIDPlatform3.appkey = str2.replace(" ", "");
    }

    public static void setYixin(String str) {
        ((APPIDPlatform) configs.get(SHARE_MEDIA.YIXIN)).appId = str.replace(" ", "");
        ((APPIDPlatform) configs.get(SHARE_MEDIA.YIXIN_CIRCLE)).appId = str.replace(" ", "");
    }
}

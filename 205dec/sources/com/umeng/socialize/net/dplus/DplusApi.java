package com.umeng.socialize.net.dplus;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.socialize.Config;
import com.umeng.socialize.PlatformConfig;
import com.umeng.socialize.ShareContent;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMEmoji;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.media.UMMin;
import com.umeng.socialize.media.UMQQMini;
import com.umeng.socialize.media.UMVideo;
import com.umeng.socialize.media.UMWeb;
import com.umeng.socialize.media.UMusic;
import com.umeng.socialize.utils.SLog;
import com.umeng.socialize.utils.SocializeUtils;
import com.umeng.socialize.utils.UMAuthUtils;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class DplusApi {
    private static final String FULL = "false";
    private static final String SIMPLE = "true";
    private static ExecutorService mExecutor = Executors.newSingleThreadExecutor();

    static /* synthetic */ JSONObject access$000() throws JSONException {
        return constructDauContent();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static JSONObject constructAuthContent(Map<String, String> map, boolean z3, SHARE_MEDIA share_media, String str) throws JSONException {
        JSONObject constructBaseContent = constructBaseContent(share_media, str);
        if (map != null) {
            constructBaseContent.put("am", share_media.getsharestyle(z3));
            if (share_media.toString().equals("WEIXIN")) {
                constructBaseContent.put("uid", map.get("openid"));
            } else {
                constructBaseContent.put("uid", map.get("uid"));
            }
            constructBaseContent.put("unionid", map.get("unionid"));
            constructBaseContent.put("aid", map.get("aid"));
            constructBaseContent.put("as", map.get("as"));
            if (TextUtils.isEmpty(map.get("access_token"))) {
                constructBaseContent.put("at", map.get("accessToken"));
            } else {
                constructBaseContent.put("at", map.get("access_token"));
            }
        }
        return constructBaseContent;
    }

    private static JSONObject constructBaseContent(SHARE_MEDIA share_media, String str) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        String share_media2 = share_media.toString();
        jSONObject.put("pf", share_media.getName());
        if ((share_media2.equals(SHARE_MEDIA.QQ.toString()) || share_media2.equals(SHARE_MEDIA.QZONE.toString())) && Config.isUmengQQ.booleanValue()) {
            jSONObject.put("sdkt", "true");
        } else if ((share_media2.equals(SHARE_MEDIA.WEIXIN.toString()) || share_media2.equals(SHARE_MEDIA.WEIXIN_CIRCLE.toString()) || share_media2.equals(SHARE_MEDIA.WEIXIN_FAVORITE.toString())) && Config.isUmengWx.booleanValue()) {
            jSONObject.put("sdkt", "true");
        } else {
            jSONObject.put("sdkt", "false");
        }
        jSONObject.put("ts", System.currentTimeMillis());
        jSONObject.put("tag", str);
        return jSONObject;
    }

    private static JSONObject constructDauContent() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("ts", System.currentTimeMillis());
        jSONObject.put("s_t", Config.shareType);
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static JSONObject constructShareContent(ShareContent shareContent, boolean z3, SHARE_MEDIA share_media, String str) throws JSONException {
        JSONObject constructBaseContent = constructBaseContent(share_media, str);
        String str2 = shareContent.mText;
        constructBaseContent.put("stype", shareContent.getShareType());
        constructBaseContent.put("sm", share_media.getsharestyle(z3));
        if (!TextUtils.isEmpty(str2) && str2.length() > 10240) {
            str2 = str2.substring(0, 10240);
        }
        if (shareContent.getShareType() != 2 && shareContent.getShareType() != 3) {
            if (shareContent.getShareType() == 1) {
                constructBaseContent.put("ct", str2);
            } else if (shareContent.getShareType() == 8) {
                UMVideo uMVideo = (UMVideo) shareContent.mMedia;
                if (uMVideo.getThumbImage() != null) {
                    if (uMVideo.getThumbImage().isUrlMedia()) {
                        constructBaseContent.put("picurl", uMVideo.getThumbImage().asUrlImage());
                    } else {
                        constructBaseContent.put("pic", SocializeUtils.hexdigest(SocializeUtils.md5(uMVideo.getThumbImage().toByte())));
                    }
                }
                if (share_media == SHARE_MEDIA.SINA) {
                    constructBaseContent.put("ct", str2);
                } else {
                    constructBaseContent.put("ct", uMVideo.getDescription());
                }
                constructBaseContent.put("title", uMVideo.getTitle());
                constructBaseContent.put("url", uMVideo.toUrl());
            } else if (shareContent.getShareType() == 4) {
                UMusic uMusic = (UMusic) shareContent.mMedia;
                if (uMusic.getThumbImage() != null) {
                    if (uMusic.getThumbImage().isUrlMedia()) {
                        constructBaseContent.put("picurl", uMusic.getThumbImage().asUrlImage());
                    } else {
                        constructBaseContent.put("pic", SocializeUtils.hexdigest(SocializeUtils.md5(uMusic.getThumbImage().toByte())));
                    }
                }
                if (share_media == SHARE_MEDIA.SINA) {
                    constructBaseContent.put("ct", str2);
                } else {
                    constructBaseContent.put("ct", uMusic.getDescription());
                }
                constructBaseContent.put("title", uMusic.getTitle());
                constructBaseContent.put("durl", uMusic.toUrl());
                constructBaseContent.put("url", uMusic.getmTargetUrl());
            } else if (shareContent.getShareType() == 32) {
                constructBaseContent.put("ct", str2);
            } else if (shareContent.getShareType() == 64) {
                UMEmoji uMEmoji = (UMEmoji) shareContent.mMedia;
                if (uMEmoji != null) {
                    if (uMEmoji.isUrlMedia()) {
                        constructBaseContent.put("picurl", uMEmoji.asUrlImage());
                    } else {
                        constructBaseContent.put("pic", SocializeUtils.md5(uMEmoji.toByte()));
                    }
                }
                constructBaseContent.put("ct", str2);
            } else if (shareContent.getShareType() == 128) {
                UMMin uMMin = (UMMin) shareContent.mMedia;
                if (uMMin.getThumbImage() != null) {
                    if (uMMin.getThumbImage().isUrlMedia()) {
                        constructBaseContent.put("picurl", uMMin.getThumbImage().asUrlImage());
                    } else {
                        constructBaseContent.put("pic", SocializeUtils.hexdigest(SocializeUtils.md5(uMMin.getThumbImage().toByte())));
                    }
                }
                constructBaseContent.put("ct", uMMin.getDescription());
                constructBaseContent.put("title", uMMin.getTitle());
                constructBaseContent.put("url", uMMin.toUrl());
                constructBaseContent.put("m_p", uMMin.getPath());
                constructBaseContent.put("m_u", uMMin.getUserName());
            } else if (shareContent.getShareType() == 256) {
                UMQQMini uMQQMini = (UMQQMini) shareContent.mMedia;
                if (uMQQMini.getThumbImage() != null) {
                    if (uMQQMini.getThumbImage().isUrlMedia()) {
                        constructBaseContent.put("picurl", uMQQMini.getThumbImage().asUrlImage());
                    } else {
                        constructBaseContent.put("pic", SocializeUtils.hexdigest(SocializeUtils.md5(uMQQMini.getThumbImage().toByte())));
                    }
                }
                constructBaseContent.put("ct", uMQQMini.getDescription());
                constructBaseContent.put("title", uMQQMini.getTitle());
                constructBaseContent.put("url", uMQQMini.toUrl());
                constructBaseContent.put("m_p", uMQQMini.getPath());
                constructBaseContent.put("m_u", uMQQMini.getMiniAppId());
            } else if (shareContent.getShareType() == 16) {
                UMWeb uMWeb = (UMWeb) shareContent.mMedia;
                if (uMWeb.getThumbImage() != null) {
                    if (uMWeb.getThumbImage().isUrlMedia()) {
                        constructBaseContent.put("picurl", uMWeb.getThumbImage().asUrlImage());
                    } else {
                        constructBaseContent.put("pic", SocializeUtils.hexdigest(SocializeUtils.md5(uMWeb.getThumbImage().toByte())));
                    }
                }
                if (share_media == SHARE_MEDIA.SINA) {
                    constructBaseContent.put("ct", str2);
                } else {
                    constructBaseContent.put("ct", uMWeb.getDescription());
                }
                constructBaseContent.put("title", uMWeb.getTitle());
                constructBaseContent.put("url", uMWeb.toUrl());
            }
        } else {
            UMImage uMImage = (UMImage) shareContent.mMedia;
            if (uMImage != null) {
                if (uMImage.isUrlMedia()) {
                    constructBaseContent.put("picurl", uMImage.asUrlImage());
                } else {
                    constructBaseContent.put("pic", SocializeUtils.hexdigest(SocializeUtils.md5(uMImage.toByte())));
                }
            }
            constructBaseContent.put("ct", str2);
        }
        return constructBaseContent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static JSONObject constructStatsAuthEndContent(SHARE_MEDIA share_media, String str, String str2, String str3) throws JSONException {
        JSONObject constructBaseContent = constructBaseContent(share_media, str);
        constructBaseContent.put("name", "s_a_e");
        constructBaseContent.put("result", str2);
        if (!TextUtils.isEmpty(str3)) {
            constructBaseContent.put("e_m", str3);
        }
        return constructBaseContent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static JSONObject constructStatsAuthStartContent(boolean z3, SHARE_MEDIA share_media, String str) throws JSONException {
        JSONObject constructBaseContent = constructBaseContent(share_media, str);
        constructBaseContent.put("name", "s_a_s");
        constructBaseContent.put("am", share_media.getsharestyle(z3));
        return constructBaseContent;
    }

    private static JSONObject constructStatsDauContent(Map<String, String> map, int i4) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("name", "s_dau");
        jSONObject.put("a_b", i4);
        if (map != null) {
            JSONObject jSONObject2 = new JSONObject();
            if (!TextUtils.isEmpty(map.get("position")) && !TextUtils.isEmpty(map.get("menubg"))) {
                jSONObject2.put("position", map.get("position"));
                jSONObject2.put("menubg", map.get("menubg"));
                jSONObject.put("s_i", jSONObject2);
            }
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static JSONObject constructStatsInfoEndContent(SHARE_MEDIA share_media, String str, String str2, String str3) throws JSONException {
        JSONObject constructBaseContent = constructBaseContent(share_media, str);
        constructBaseContent.put("name", "s_i_e");
        constructBaseContent.put("result", str2);
        if (!TextUtils.isEmpty(str3)) {
            constructBaseContent.put("e_m", str3);
        }
        return constructBaseContent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static JSONObject constructStatsInfoStartContent(SHARE_MEDIA share_media, String str) throws JSONException {
        JSONObject constructBaseContent = constructBaseContent(share_media, str);
        constructBaseContent.put("name", "s_i_s");
        return constructBaseContent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static JSONObject constructStatsShareContent(ShareContent shareContent, boolean z3, SHARE_MEDIA share_media, boolean z4, String str) throws JSONException {
        JSONObject constructBaseContent = constructBaseContent(share_media, str);
        constructBaseContent.put("name", "s_s_s");
        constructBaseContent.put("u_c", z4 + "");
        constructBaseContent.put("sm", share_media.getsharestyle(z3));
        constructBaseContent.put("stype", shareContent.getShareType());
        return constructBaseContent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static JSONObject constructStatsShareEndContent(SHARE_MEDIA share_media, String str, String str2, String str3) throws JSONException {
        JSONObject constructBaseContent = constructBaseContent(share_media, str);
        constructBaseContent.put("name", "s_s_e");
        constructBaseContent.put("result", str2);
        if (!TextUtils.isEmpty(str3)) {
            constructBaseContent.put("e_m", str3);
        }
        return constructBaseContent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static JSONObject constructUserInfoContent(Map<String, String> map, SHARE_MEDIA share_media, String str) throws JSONException {
        JSONObject constructBaseContent = constructBaseContent(share_media, str);
        if (map != null) {
            constructBaseContent.put("un", map.get("name"));
            constructBaseContent.put("up", map.get("iconurl"));
            constructBaseContent.put("sex", map.get("gender"));
            if (TextUtils.isEmpty(map.get("location"))) {
                constructBaseContent.put("regn", map.get("city"));
            } else {
                constructBaseContent.put("regn", map.get("location"));
            }
            if (share_media.toString().equals("WEIXIN")) {
                constructBaseContent.put("uid", map.get("openid"));
            } else {
                constructBaseContent.put("uid", map.get("uid"));
            }
            SHARE_MEDIA share_media2 = SHARE_MEDIA.BYTEDANCE;
            if (share_media2 == share_media) {
                String str2 = map.get("encrypt_mobile");
                if (!TextUtils.isEmpty(str2)) {
                    try {
                        constructBaseContent.put("pn", new String(Base64.encode(SocializeUtils.md5(UMAuthUtils.decrypt(str2, ((PlatformConfig.APPIDPlatform) PlatformConfig.configs.get(share_media2)).getAppSecret()).replace(new String(Base64.decode("Kzg2", 0)), "").getBytes()).getBytes(), 0)));
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            } else {
                SHARE_MEDIA share_media3 = SHARE_MEDIA.HONOR;
                if (share_media3 == share_media) {
                    String str3 = map.get("mobileNumber");
                    if (!TextUtils.isEmpty(str3)) {
                        try {
                            constructBaseContent.put("pn", new String(Base64.encode(SocializeUtils.md5(UMAuthUtils.decrypt(str3, ((PlatformConfig.APPIDPlatform) PlatformConfig.configs.get(share_media3)).getAppSecret()).replace(new String(Base64.decode("Kzg2", 0)), "").getBytes()).getBytes(), 0)));
                        } catch (Throwable th2) {
                            th2.printStackTrace();
                        }
                    }
                }
            }
            constructBaseContent.put("unionid", map.get("unionid"));
            constructBaseContent.put("ts", System.currentTimeMillis());
        }
        return constructBaseContent;
    }

    public static JSONObject getFakeData() throws JSONException {
        JSONObject constructBaseContent = constructBaseContent(SHARE_MEDIA.SINA, "test");
        constructBaseContent.put("name", "testetstttttttttttttttttttttttttttttttt");
        constructBaseContent.put("u_c", true);
        constructBaseContent.put("sm", "sso");
        constructBaseContent.put("stype", 0);
        return constructBaseContent;
    }

    public static void uploadAuth(final Context context, final Map<String, String> map, final boolean z3, final SHARE_MEDIA share_media, final String str) {
        mExecutor.execute(new Runnable() { // from class: com.umeng.socialize.net.dplus.DplusApi.4
            @Override // java.lang.Runnable
            public void run() {
                try {
                    JSONObject constructAuthContent = DplusApi.constructAuthContent(map, z3, share_media, str);
                    Context context2 = context;
                    UMWorkDispatch.sendEvent(context2, 24579, CommonNetImpl.get(context2), constructAuthContent);
                } catch (JSONException e4) {
                    SLog.error(e4);
                }
            }
        });
    }

    public static void uploadAuthStart(final Context context, final boolean z3, final SHARE_MEDIA share_media, final String str) {
        mExecutor.execute(new Runnable() { // from class: com.umeng.socialize.net.dplus.DplusApi.5
            @Override // java.lang.Runnable
            public void run() {
                try {
                    JSONObject constructStatsAuthStartContent = DplusApi.constructStatsAuthStartContent(z3, share_media, str);
                    Context context2 = context;
                    UMWorkDispatch.sendEvent(context2, 24581, CommonNetImpl.get(context2), constructStatsAuthStartContent);
                } catch (JSONException e4) {
                    SLog.error(e4);
                }
            }
        });
    }

    public static void uploadAuthend(final Context context, final SHARE_MEDIA share_media, final String str, final String str2, final String str3) {
        mExecutor.execute(new Runnable() { // from class: com.umeng.socialize.net.dplus.DplusApi.6
            @Override // java.lang.Runnable
            public void run() {
                try {
                    JSONObject constructStatsAuthEndContent = DplusApi.constructStatsAuthEndContent(SHARE_MEDIA.this, str, str2, str3);
                    Context context2 = context;
                    UMWorkDispatch.sendEvent(context2, 24581, CommonNetImpl.get(context2), constructStatsAuthEndContent);
                } catch (JSONException e4) {
                    SLog.error(e4);
                }
            }
        });
    }

    public static void uploadDAU(final Context context) {
        mExecutor.execute(new Runnable() { // from class: com.umeng.socialize.net.dplus.DplusApi.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    JSONObject access$000 = DplusApi.access$000();
                    Context context2 = context;
                    UMWorkDispatch.sendEvent(context2, 24577, CommonNetImpl.get(context2), access$000);
                } catch (JSONException e4) {
                    SLog.error(e4);
                }
            }
        });
    }

    public static void uploadInfoStart(final Context context, final SHARE_MEDIA share_media, final String str) {
        mExecutor.execute(new Runnable() { // from class: com.umeng.socialize.net.dplus.DplusApi.8
            @Override // java.lang.Runnable
            public void run() {
                try {
                    JSONObject constructStatsInfoStartContent = DplusApi.constructStatsInfoStartContent(SHARE_MEDIA.this, str);
                    Context context2 = context;
                    UMWorkDispatch.sendEvent(context2, 24581, CommonNetImpl.get(context2), constructStatsInfoStartContent);
                } catch (JSONException e4) {
                    SLog.error(e4);
                }
            }
        });
    }

    public static void uploadInfoend(final Context context, final SHARE_MEDIA share_media, final String str, final String str2, final String str3) {
        mExecutor.execute(new Runnable() { // from class: com.umeng.socialize.net.dplus.DplusApi.9
            @Override // java.lang.Runnable
            public void run() {
                try {
                    JSONObject constructStatsInfoEndContent = DplusApi.constructStatsInfoEndContent(SHARE_MEDIA.this, str, str2, str3);
                    Context context2 = context;
                    UMWorkDispatch.sendEvent(context2, 24581, CommonNetImpl.get(context2), constructStatsInfoEndContent);
                } catch (JSONException e4) {
                    SLog.error(e4);
                }
            }
        });
    }

    public static void uploadShare(final Context context, final ShareContent shareContent, final boolean z3, final SHARE_MEDIA share_media, final String str, final boolean z4) {
        mExecutor.execute(new Runnable() { // from class: com.umeng.socialize.net.dplus.DplusApi.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    JSONObject constructShareContent = DplusApi.constructShareContent(ShareContent.this, z3, share_media, str);
                    Context context2 = context;
                    UMWorkDispatch.sendEvent(context2, 24578, CommonNetImpl.get(context2), constructShareContent);
                } catch (JSONException e4) {
                    SLog.error(e4);
                }
            }
        });
        mExecutor.execute(new Runnable() { // from class: com.umeng.socialize.net.dplus.DplusApi.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    JSONObject constructStatsShareContent = DplusApi.constructStatsShareContent(ShareContent.this, z3, share_media, z4, str);
                    Context context2 = context;
                    UMWorkDispatch.sendEvent(context2, 24581, CommonNetImpl.get(context2), constructStatsShareContent);
                } catch (JSONException e4) {
                    SLog.error(e4);
                }
            }
        });
    }

    public static void uploadStatsDAU(Context context, Map<String, String> map, int i4) {
    }

    public static void uploadStatsShareEnd(final Context context, final SHARE_MEDIA share_media, final String str, final String str2, final String str3) {
        mExecutor.execute(new Runnable() { // from class: com.umeng.socialize.net.dplus.DplusApi.7
            @Override // java.lang.Runnable
            public void run() {
                try {
                    JSONObject constructStatsShareEndContent = DplusApi.constructStatsShareEndContent(SHARE_MEDIA.this, str, str2, str3);
                    Context context2 = context;
                    UMWorkDispatch.sendEvent(context2, 24581, CommonNetImpl.get(context2), constructStatsShareEndContent);
                } catch (JSONException e4) {
                    SLog.error(e4);
                }
            }
        });
    }

    public static void uploadUserInfo(final Context context, final Map<String, String> map, final SHARE_MEDIA share_media, final String str) {
        mExecutor.execute(new Runnable() { // from class: com.umeng.socialize.net.dplus.DplusApi.10
            @Override // java.lang.Runnable
            public void run() {
                try {
                    JSONObject constructUserInfoContent = DplusApi.constructUserInfoContent(map, share_media, str);
                    Context context2 = context;
                    UMWorkDispatch.sendEvent(context2, 24580, CommonNetImpl.get(context2), constructUserInfoContent);
                } catch (JSONException e4) {
                    SLog.error(e4);
                }
            }
        });
    }
}

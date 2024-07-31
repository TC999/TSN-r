package com.umeng.socialize.p570b;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import android.util.SparseArray;
import com.stub.StubApp;
import com.umeng.socialize.PlatformConfig;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.ShareContent;
import com.umeng.socialize.SocializeException;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareConfig;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.HandlerRequestCode;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.bean.UmengErrorCode;
import com.umeng.socialize.common.QueuedWork;
import com.umeng.socialize.handler.UMMoreHandler;
import com.umeng.socialize.handler.UMSSOHandler;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.media.UMVideo;
import com.umeng.socialize.media.UMWeb;
import com.umeng.socialize.media.UMediaObject;
import com.umeng.socialize.media.UMusic;
import com.umeng.socialize.net.analytics.SocialAnalytics;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import com.umeng.socialize.net.dplus.DplusApi;
import com.umeng.socialize.net.dplus.cache1.DplusCacheApi;
import com.umeng.socialize.net.utils.SocializeNetUtils;
import com.umeng.socialize.utils.CommonUtil;
import com.umeng.socialize.utils.ContextUtil;
import com.umeng.socialize.utils.SLog;
import com.umeng.socialize.utils.SocializeUtils;
import com.umeng.socialize.utils.UmengText;
import com.umeng.socialize.utils.UrlUtil;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.umeng.socialize.b.a */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public final class SocialRouter {

    /* renamed from: b */
    private static final String f39331b = "umeng_share_platform";

    /* renamed from: c */
    private static final String f39332c = "share_action";

    /* renamed from: a */
    private SHARE_MEDIA f39333a;

    /* renamed from: d */
    private final Map<SHARE_MEDIA, UMSSOHandler> f39334d;

    /* renamed from: e */
    private final List<Pair<SHARE_MEDIA, String>> f39335e;

    /* renamed from: f */
    private final C13335a f39336f;

    /* renamed from: g */
    private Context f39337g;

    /* renamed from: h */
    private final SparseArray<UMAuthListener> f39338h;

    /* renamed from: i */
    private final SparseArray<UMShareListener> f39339i;

    /* renamed from: j */
    private final SparseArray<UMAuthListener> f39340j;

    public SocialRouter(Context context) {
        HashMap hashMap = new HashMap();
        this.f39334d = hashMap;
        ArrayList arrayList = new ArrayList();
        this.f39335e = arrayList;
        arrayList.add(Pair.create(SHARE_MEDIA.SINA, "com.umeng.socialize.handler.SinaSsoHandler"));
        arrayList.add(Pair.create(SHARE_MEDIA.QQ, "com.umeng.socialize.handler.UMQQSsoHandler"));
        arrayList.add(Pair.create(SHARE_MEDIA.QZONE, "com.umeng.socialize.handler.QZoneSsoHandler"));
        arrayList.add(Pair.create(SHARE_MEDIA.WEIXIN, "com.umeng.socialize.handler.UMWXHandler"));
        arrayList.add(Pair.create(SHARE_MEDIA.WEIXIN_CIRCLE, ""));
        arrayList.add(Pair.create(SHARE_MEDIA.WEIXIN_FAVORITE, ""));
        arrayList.add(Pair.create(SHARE_MEDIA.PINTEREST, "com.umeng.socialize.handler.UMPinterestHandler"));
        arrayList.add(Pair.create(SHARE_MEDIA.WXWORK, "com.umeng.socialize.handler.UMWXWorkHandler"));
        arrayList.add(Pair.create(SHARE_MEDIA.YIXIN, "com.umeng.socialize.handler.UMYXHandler"));
        arrayList.add(Pair.create(SHARE_MEDIA.YIXIN_CIRCLE, ""));
        arrayList.add(Pair.create(SHARE_MEDIA.EMAIL, "com.umeng.socialize.handler.EmailHandler"));
        arrayList.add(Pair.create(SHARE_MEDIA.EVERNOTE, "com.umeng.socialize.handler.UMEvernoteHandler"));
        arrayList.add(Pair.create(SHARE_MEDIA.FACEBOOK, "com.umeng.socialize.handler.UMFacebookHandler"));
        arrayList.add(Pair.create(SHARE_MEDIA.FACEBOOK_MESSAGER, ""));
        arrayList.add(Pair.create(SHARE_MEDIA.FLICKR, "com.umeng.socialize.handler.UMFlickrHandler"));
        arrayList.add(Pair.create(SHARE_MEDIA.FOURSQUARE, "com.umeng.socialize.handler.UMFourSquareHandler"));
        arrayList.add(Pair.create(SHARE_MEDIA.INSTAGRAM, "com.umeng.socialize.handler.UMInstagramHandler"));
        arrayList.add(Pair.create(SHARE_MEDIA.KAKAO, "com.umeng.socialize.handler.UMKakaoHandler"));
        arrayList.add(Pair.create(SHARE_MEDIA.LINE, "com.umeng.socialize.handler.UMLineHandler"));
        arrayList.add(Pair.create(SHARE_MEDIA.LINKEDIN, "com.umeng.socialize.handler.UMLinkedInHandler"));
        arrayList.add(Pair.create(SHARE_MEDIA.POCKET, "com.umeng.socialize.handler.UMPocketHandler"));
        arrayList.add(Pair.create(SHARE_MEDIA.WHATSAPP, "com.umeng.socialize.handler.UMWhatsAppHandler"));
        arrayList.add(Pair.create(SHARE_MEDIA.YNOTE, "com.umeng.socialize.handler.UMYNoteHandler"));
        arrayList.add(Pair.create(SHARE_MEDIA.SMS, "com.umeng.socialize.handler.SmsHandler"));
        arrayList.add(Pair.create(SHARE_MEDIA.DOUBAN, "com.umeng.socialize.handler.DoubanHandler"));
        arrayList.add(Pair.create(SHARE_MEDIA.TUMBLR, "com.umeng.socialize.handler.UMTumblrHandler"));
        arrayList.add(Pair.create(SHARE_MEDIA.TWITTER, "com.umeng.socialize.handler.TwitterHandler"));
        arrayList.add(Pair.create(SHARE_MEDIA.ALIPAY, "com.umeng.socialize.handler.AlipayHandler"));
        arrayList.add(Pair.create(SHARE_MEDIA.MORE, "com.umeng.socialize.handler.UMMoreHandler"));
        arrayList.add(Pair.create(SHARE_MEDIA.DINGTALK, "com.umeng.socialize.handler.UMDingSSoHandler"));
        arrayList.add(Pair.create(SHARE_MEDIA.VKONTAKTE, "com.umeng.socialize.handler.UMVKHandler"));
        arrayList.add(Pair.create(SHARE_MEDIA.DROPBOX, "com.umeng.socialize.handler.UMDropBoxHandler"));
        arrayList.add(Pair.create(SHARE_MEDIA.BYTEDANCE, "com.umeng.socialize.handler.UMDYHandler"));
        arrayList.add(Pair.create(SHARE_MEDIA.BYTEDANCE_PUBLISH, ""));
        arrayList.add(Pair.create(SHARE_MEDIA.BYTEDANCE_FRIENDS, ""));
        arrayList.add(Pair.create(SHARE_MEDIA.HONOR, "com.umeng.socialize.handler.UMHonorHandler"));
        this.f39336f = new C13335a(hashMap);
        this.f39338h = new SparseArray<>();
        this.f39339i = new SparseArray<>();
        this.f39340j = new SparseArray<>();
        this.f39337g = context;
        m13337b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public synchronized UMShareListener m13323e(int i) {
        UMShareListener uMShareListener;
        uMShareListener = this.f39339i.get(i, null);
        if (uMShareListener != null) {
            this.f39339i.remove(i);
        }
        return uMShareListener;
    }

    /* renamed from: d */
    public boolean m13324d(Activity activity, SHARE_MEDIA share_media) {
        if (this.f39336f.m13321a(activity, share_media)) {
            this.f39334d.get(share_media).onCreate(activity, PlatformConfig.getPlatform(share_media));
            return this.f39334d.get(share_media).isAuthorize();
        }
        return false;
    }

    /* renamed from: b */
    private void m13332b(Context context) {
        String appkey = SocializeUtils.getAppkey(context);
        if (!TextUtils.isEmpty(appkey)) {
            if (!SocializeNetUtils.isConSpeCharacters(appkey)) {
                if (SocializeNetUtils.isSelfAppkey(appkey)) {
                    throw new SocializeException(UmengText.errorWithUrl(UmengText.CHECK.APPKEY_NOT_FOUND, UrlUtil.ALL_ERROR_APPKEY));
                }
                return;
            }
            throw new SocializeException(UmengText.errorWithUrl(UmengText.CHECK.APPKEY_NOT_FOUND, UrlUtil.ALL_ERROR_APPKEY));
        }
        throw new SocializeException(UmengText.errorWithUrl(UmengText.CHECK.APPKEY_NOT_FOUND, UrlUtil.ALL_NO_APPKEY));
    }

    /* renamed from: c */
    public String m13328c(Activity activity, SHARE_MEDIA share_media) {
        if (this.f39336f.m13321a(activity, share_media)) {
            this.f39334d.get(share_media).onCreate(activity, PlatformConfig.getPlatform(share_media));
            return this.f39334d.get(share_media).getSDKVersion();
        }
        return "";
    }

    /* renamed from: a */
    public void m13347a(Context context) {
        if (context != null) {
            this.f39337g = StubApp.getOrigApplicationContext(context.getApplicationContext());
        }
    }

    /* renamed from: a */
    private UMSSOHandler m13338a(String str) {
        try {
            return (UMSSOHandler) Class.forName(str).newInstance();
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public synchronized UMAuthListener m13325d(int i) {
        UMAuthListener uMAuthListener;
        uMAuthListener = this.f39340j.get(i, null);
        if (uMAuthListener != null) {
            this.f39340j.remove(i);
        }
        return uMAuthListener;
    }

    /* renamed from: a */
    public UMSSOHandler m13341a(SHARE_MEDIA share_media) {
        UMSSOHandler uMSSOHandler = this.f39334d.get(share_media);
        if (uMSSOHandler != null) {
            uMSSOHandler.onCreate(this.f39337g, PlatformConfig.getPlatform(share_media));
        }
        return uMSSOHandler;
    }

    /* renamed from: c */
    public void m13327c(Activity activity, final SHARE_MEDIA share_media, final UMAuthListener uMAuthListener) {
        if (this.f39336f.m13321a(activity, share_media)) {
            UMSSOHandler uMSSOHandler = this.f39334d.get(share_media);
            uMSSOHandler.onCreate(activity, PlatformConfig.getPlatform(share_media));
            String valueOf = String.valueOf(System.currentTimeMillis());
            if (ContextUtil.getContext() != null) {
                SocialAnalytics.authstart(ContextUtil.getContext(), share_media, uMSSOHandler.getSDKVersion(), uMSSOHandler.isInstall(), valueOf);
            }
            int ordinal = share_media.ordinal();
            m13355a(ordinal, uMAuthListener);
            UMAuthListener m13353a = m13353a(ordinal, valueOf, uMSSOHandler.isInstall());
            QueuedWork.runInMain(new Runnable() { // from class: com.umeng.socialize.b.a.4
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        uMAuthListener.onStart(share_media);
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            });
            uMSSOHandler.authorize(m13353a);
            this.f39333a = share_media;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: SocialRouter.java */
    /* renamed from: com.umeng.socialize.b.a$a */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static class C13335a {

        /* renamed from: a */
        private final Map<SHARE_MEDIA, UMSSOHandler> f39399a;

        public C13335a(Map<SHARE_MEDIA, UMSSOHandler> map) {
            this.f39399a = map;
        }

        /* renamed from: a */
        private boolean m13322a(Context context) {
            return context != null;
        }

        /* renamed from: a */
        public boolean m13321a(Context context, SHARE_MEDIA share_media) {
            if (!CommonUtil.isSilentMode(context) && m13322a(context) && m13319a(share_media)) {
                if (this.f39399a.get(share_media).isSupportAuth()) {
                    return true;
                }
                SLog.m13211E(share_media.toString() + UmengText.AUTH.NOT_SUPPORT_PLATFROM);
                return false;
            }
            return false;
        }

        /* renamed from: a */
        public boolean m13320a(ShareAction shareAction, Activity activity) {
            SHARE_MEDIA platform;
            if (CommonUtil.isSilentMode(activity) || (platform = shareAction.getPlatform()) == null) {
                return false;
            }
            if ((platform == SHARE_MEDIA.SINA || platform == SHARE_MEDIA.QQ) && !PlatformConfig.configs.get(platform).isConfigured()) {
                SLog.m13211E(UmengText.CHECK.noKey(platform));
                return false;
            }
            return m13319a(platform);
        }

        /* renamed from: a */
        private boolean m13319a(SHARE_MEDIA share_media) {
            if (this.f39399a.get(share_media) == null) {
                SLog.mutlE(UmengText.CHECK.noJar(share_media), UrlUtil.ALL_NO_JAR);
                return false;
            }
            return true;
        }
    }

    /* renamed from: a */
    public void m13356a(int i, int i2, Intent intent) {
        UMSSOHandler m13357a = m13357a(i);
        if (m13357a != null) {
            m13357a.onActivityResult(i, i2, intent);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: b */
    private void m13337b() {
        UMSSOHandler m13338a;
        for (Pair<SHARE_MEDIA, String> pair : this.f39335e) {
            Object obj = pair.first;
            if (obj == SHARE_MEDIA.WEIXIN_CIRCLE) {
                m13338a = this.f39334d.get(SHARE_MEDIA.WEIXIN);
            } else if (obj == SHARE_MEDIA.WEIXIN_FAVORITE) {
                m13338a = this.f39334d.get(SHARE_MEDIA.WEIXIN);
            } else if (obj == SHARE_MEDIA.FACEBOOK_MESSAGER) {
                m13338a = this.f39334d.get(SHARE_MEDIA.FACEBOOK);
            } else if (obj == SHARE_MEDIA.BYTEDANCE_PUBLISH) {
                m13338a = this.f39334d.get(SHARE_MEDIA.BYTEDANCE);
            } else if (obj == SHARE_MEDIA.BYTEDANCE_FRIENDS) {
                m13338a = this.f39334d.get(SHARE_MEDIA.BYTEDANCE);
            } else if (obj == SHARE_MEDIA.YIXIN_CIRCLE) {
                m13338a = this.f39334d.get(SHARE_MEDIA.YIXIN);
            } else if (obj == SHARE_MEDIA.MORE) {
                m13338a = new UMMoreHandler();
            } else {
                m13338a = m13338a((String) pair.second);
            }
            this.f39334d.put(pair.first, m13338a);
        }
    }

    @Deprecated
    /* renamed from: a */
    public void m13352a(Activity activity, int i, UMAuthListener uMAuthListener) {
        UMSSOHandler m13357a = m13357a(i);
        if (m13357a != null) {
            if (i == 10103 || i == 11101) {
                m13357a.onCreate(activity, PlatformConfig.getPlatform(m13336b(i)));
                m13340a(SHARE_MEDIA.QQ, uMAuthListener, m13357a, String.valueOf(System.currentTimeMillis()));
            }
        }
    }

    /* renamed from: a */
    private UMSSOHandler m13357a(int i) {
        int i2 = 10103;
        if (i != 10103 && i != 11101) {
            i2 = i;
        }
        if (i == 64207 || i == 64206 || i == 64208) {
            i2 = HandlerRequestCode.FACEBOOK_REQUEST_AUTH_CODE;
        }
        i2 = (i == 32973 || i == 765) ? 10001 : 10001;
        if (i == 5650) {
            i2 = HandlerRequestCode.SINA_REQUEST_CODE;
        }
        for (UMSSOHandler uMSSOHandler : this.f39334d.values()) {
            if (uMSSOHandler != null && i2 == uMSSOHandler.getRequestCode()) {
                return uMSSOHandler;
            }
        }
        return null;
    }

    /* renamed from: a */
    public void m13348a(Activity activity, SHARE_MEDIA share_media, UMAuthListener uMAuthListener) {
        if (this.f39336f.m13321a(activity, share_media)) {
            if (uMAuthListener == null) {
                uMAuthListener = new UMAuthListener() { // from class: com.umeng.socialize.b.a.1
                    @Override // com.umeng.socialize.UMAuthListener
                    public void onCancel(SHARE_MEDIA share_media2, int i) {
                    }

                    @Override // com.umeng.socialize.UMAuthListener
                    public void onComplete(SHARE_MEDIA share_media2, int i, Map<String, String> map) {
                    }

                    @Override // com.umeng.socialize.UMAuthListener
                    public void onError(SHARE_MEDIA share_media2, int i, Throwable th) {
                    }

                    @Override // com.umeng.socialize.UMAuthListener
                    public void onStart(SHARE_MEDIA share_media2) {
                    }
                };
            }
            this.f39334d.get(share_media).onCreate(activity, PlatformConfig.getPlatform(share_media));
            this.f39334d.get(share_media).deleteAuth(uMAuthListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public synchronized UMAuthListener m13329c(int i) {
        UMAuthListener uMAuthListener;
        this.f39333a = null;
        uMAuthListener = this.f39338h.get(i, null);
        if (uMAuthListener != null) {
            this.f39338h.remove(i);
        }
        return uMAuthListener;
    }

    /* renamed from: a */
    public boolean m13349a(Activity activity, SHARE_MEDIA share_media) {
        this.f39334d.get(share_media).onCreate(activity, PlatformConfig.getPlatform(share_media));
        return this.f39334d.get(share_media).isInstall();
    }

    /* renamed from: c */
    private synchronized void m13330c() {
        this.f39338h.clear();
        this.f39339i.clear();
        this.f39340j.clear();
    }

    /* renamed from: a */
    private UMAuthListener m13353a(final int i, final String str, final boolean z) {
        return new UMAuthListener() { // from class: com.umeng.socialize.b.a.5
            @Override // com.umeng.socialize.UMAuthListener
            public void onCancel(final SHARE_MEDIA share_media, final int i2) {
                QueuedWork.runInMain(new Runnable() { // from class: com.umeng.socialize.b.a.5.4
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            C133235 c133235 = C133235.this;
                            UMAuthListener m13329c = SocialRouter.this.m13329c(i);
                            if (m13329c != null) {
                                m13329c.onCancel(share_media, i2);
                            }
                            if (ContextUtil.getContext() != null) {
                                Context context = ContextUtil.getContext();
                                SHARE_MEDIA share_media2 = share_media;
                                C133235 c1332352 = C133235.this;
                                SocialAnalytics.authendt(context, share_media2, CommonNetImpl.CANCEL, z, "", str, null);
                            }
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                });
            }

            @Override // com.umeng.socialize.UMAuthListener
            public void onComplete(final SHARE_MEDIA share_media, final int i2, final Map<String, String> map) {
                QueuedWork.runInMain(new Runnable() { // from class: com.umeng.socialize.b.a.5.2
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            C133235 c133235 = C133235.this;
                            UMAuthListener m13329c = SocialRouter.this.m13329c(i);
                            if (m13329c != null) {
                                m13329c.onComplete(share_media, i2, map);
                            }
                            if (ContextUtil.getContext() != null) {
                                Context context = ContextUtil.getContext();
                                SHARE_MEDIA share_media2 = share_media;
                                C133235 c1332352 = C133235.this;
                                SocialAnalytics.authendt(context, share_media2, "success", z, "", str, SocialRouter.this.m13339a(share_media2, map));
                            }
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                });
            }

            @Override // com.umeng.socialize.UMAuthListener
            public void onError(final SHARE_MEDIA share_media, final int i2, final Throwable th) {
                QueuedWork.runInMain(new Runnable() { // from class: com.umeng.socialize.b.a.5.3
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            C133235 c133235 = C133235.this;
                            UMAuthListener m13329c = SocialRouter.this.m13329c(i);
                            if (m13329c != null) {
                                m13329c.onError(share_media, i2, th);
                            }
                            Throwable th2 = th;
                            if (th2 != null) {
                                SLog.m13211E(th2.getMessage());
                                SLog.runtimePrint(th.getMessage());
                            } else {
                                SLog.m13211E("null");
                                SLog.runtimePrint("null");
                            }
                            if (ContextUtil.getContext() == null || th == null) {
                                return;
                            }
                            SocialAnalytics.authendt(ContextUtil.getContext(), share_media, CommonNetImpl.FAIL, z, th.getMessage(), str, null);
                        } catch (Throwable th3) {
                            th3.printStackTrace();
                        }
                    }
                });
            }

            @Override // com.umeng.socialize.UMAuthListener
            public void onStart(final SHARE_MEDIA share_media) {
                QueuedWork.runInMain(new Runnable() { // from class: com.umeng.socialize.b.a.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            C133235 c133235 = C133235.this;
                            UMAuthListener m13329c = SocialRouter.this.m13329c(i);
                            if (m13329c != null) {
                                m13329c.onStart(share_media);
                            }
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                });
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public Map<String, String> m13339a(SHARE_MEDIA share_media, Map<String, String> map) {
        String str;
        String str2;
        String str3 = "";
        if (PlatformConfig.getPlatform(share_media) != null) {
            str3 = PlatformConfig.getPlatform(share_media).getAppid();
            str2 = PlatformConfig.getPlatform(share_media).getAppSecret();
            str = PlatformConfig.getPlatform(share_media).getClick_key();
        } else {
            str = "";
            str2 = str;
        }
        map.put(CommonNetImpl.AID, str3);
        map.put(CommonNetImpl.f39530AS, str2);
        map.put("at", str);
        return map;
    }

    /* renamed from: b */
    private SHARE_MEDIA m13336b(int i) {
        if (i == 10103 || i == 11101) {
            return SHARE_MEDIA.QQ;
        }
        if (i != 32973 && i != 765) {
            return SHARE_MEDIA.QQ;
        }
        return SHARE_MEDIA.SINA;
    }

    /* renamed from: b */
    public void m13333b(Activity activity, final SHARE_MEDIA share_media, final UMAuthListener uMAuthListener) {
        if (this.f39336f.m13321a(activity, share_media)) {
            UMSSOHandler uMSSOHandler = this.f39334d.get(share_media);
            uMSSOHandler.onCreate(activity, PlatformConfig.getPlatform(share_media));
            final String valueOf = String.valueOf(System.currentTimeMillis());
            if (ContextUtil.getContext() != null) {
                SocialAnalytics.getInfostart(ContextUtil.getContext(), share_media, valueOf);
            }
            final int ordinal = share_media.ordinal();
            m13335b(ordinal, uMAuthListener);
            UMAuthListener uMAuthListener2 = new UMAuthListener() { // from class: com.umeng.socialize.b.a.2
                @Override // com.umeng.socialize.UMAuthListener
                public void onCancel(final SHARE_MEDIA share_media2, final int i) {
                    QueuedWork.runInMain(new Runnable() { // from class: com.umeng.socialize.b.a.2.4
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                C133162 c133162 = C133162.this;
                                UMAuthListener m13325d = SocialRouter.this.m13325d(ordinal);
                                if (m13325d != null) {
                                    m13325d.onCancel(share_media2, i);
                                }
                                if (ContextUtil.getContext() != null) {
                                    SocialAnalytics.getInfoendt(ContextUtil.getContext(), share_media2, CommonNetImpl.CANCEL, "", valueOf, null);
                                }
                            } catch (Throwable th) {
                                th.printStackTrace();
                            }
                        }
                    });
                }

                @Override // com.umeng.socialize.UMAuthListener
                public void onComplete(final SHARE_MEDIA share_media2, final int i, final Map<String, String> map) {
                    QueuedWork.runInMain(new Runnable() { // from class: com.umeng.socialize.b.a.2.2
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                C133162 c133162 = C133162.this;
                                UMAuthListener m13325d = SocialRouter.this.m13325d(ordinal);
                                if (m13325d != null) {
                                    m13325d.onComplete(share_media2, i, map);
                                }
                                if (ContextUtil.getContext() != null) {
                                    SocialAnalytics.getInfoendt(ContextUtil.getContext(), share_media2, "success", "", valueOf, map);
                                }
                            } catch (Throwable th) {
                                th.printStackTrace();
                            }
                        }
                    });
                }

                @Override // com.umeng.socialize.UMAuthListener
                public void onError(final SHARE_MEDIA share_media2, final int i, final Throwable th) {
                    QueuedWork.runInMain(new Runnable() { // from class: com.umeng.socialize.b.a.2.3
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                C133162 c133162 = C133162.this;
                                UMAuthListener m13325d = SocialRouter.this.m13325d(ordinal);
                                if (m13325d != null) {
                                    m13325d.onError(share_media2, i, th);
                                }
                                Throwable th2 = th;
                                if (th2 != null) {
                                    SLog.m13211E(th2.getMessage());
                                    SLog.m13211E(UmengText.SOLVE + UrlUtil.ALL_AUTHFAIL);
                                    SLog.runtimePrint(th.getMessage());
                                } else {
                                    SLog.m13211E(UmengText.SOLVE + UrlUtil.ALL_AUTHFAIL);
                                }
                                if (ContextUtil.getContext() == null || th == null) {
                                    return;
                                }
                                SocialAnalytics.getInfoendt(ContextUtil.getContext(), share_media2, CommonNetImpl.FAIL, th.getMessage(), valueOf, null);
                            } catch (Throwable th3) {
                                th3.printStackTrace();
                            }
                        }
                    });
                }

                @Override // com.umeng.socialize.UMAuthListener
                public void onStart(final SHARE_MEDIA share_media2) {
                    QueuedWork.runInMain(new Runnable() { // from class: com.umeng.socialize.b.a.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                C133162 c133162 = C133162.this;
                                UMAuthListener m13325d = SocialRouter.this.m13325d(ordinal);
                                if (m13325d != null) {
                                    m13325d.onStart(share_media2);
                                }
                            } catch (Throwable th) {
                                th.printStackTrace();
                            }
                        }
                    });
                }
            };
            QueuedWork.runInMain(new Runnable() { // from class: com.umeng.socialize.b.a.3
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        uMAuthListener.onStart(share_media);
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            });
            uMSSOHandler.getPlatformInfo(uMAuthListener2);
        }
    }

    /* renamed from: a */
    private void m13345a(ShareAction shareAction) {
        ShareContent shareContent = shareAction.getShareContent();
        ArrayList arrayList = new ArrayList();
        arrayList.add(UmengText.SHARE.INFO);
        arrayList.add(UmengText.SHARE.SHAREPLAT + shareAction.getPlatform().toString());
        arrayList.add(UmengText.SHARE.SHARESTYLE + shareAction.getShareContent().getShareType());
        arrayList.add(UmengText.SHARE.SHARETEXT + shareContent.mText);
        UMediaObject uMediaObject = shareContent.mMedia;
        if (uMediaObject != null) {
            if (uMediaObject instanceof UMImage) {
                UMImage uMImage = (UMImage) uMediaObject;
                if (uMImage.isUrlMedia()) {
                    arrayList.add(UmengText.SHARE.URLIMAGE + uMImage.asUrlImage());
                } else {
                    byte[] asBinImage = uMImage.asBinImage();
                    StringBuilder sb = new StringBuilder();
                    sb.append(UmengText.SHARE.LOCALIMAGE);
                    sb.append(asBinImage == null ? 0 : asBinImage.length);
                    arrayList.add(sb.toString());
                }
                if (uMImage.getThumbImage() != null) {
                    UMImage thumbImage = uMImage.getThumbImage();
                    if (thumbImage.isUrlMedia()) {
                        arrayList.add(UmengText.SHARE.URLTHUMB + thumbImage.asUrlImage());
                    } else {
                        byte[] asBinImage2 = thumbImage.asBinImage();
                        if (asBinImage2 != null) {
                            arrayList.add(UmengText.SHARE.LOCALTHUMB + asBinImage2.length);
                        }
                    }
                }
            }
            UMediaObject uMediaObject2 = shareContent.mMedia;
            if (uMediaObject2 instanceof UMVideo) {
                UMVideo uMVideo = (UMVideo) uMediaObject2;
                arrayList.add(UmengText.SHARE.VIDEOURL + uMVideo.toUrl());
                arrayList.add(UmengText.SHARE.VIDEOTITLE + uMVideo.getTitle());
                arrayList.add(UmengText.SHARE.VIDEODES + uMVideo.getDescription());
                if (uMVideo.getThumbImage() != null) {
                    if (uMVideo.getThumbImage().isUrlMedia()) {
                        if (uMVideo.getThumbImage().asUrlImage() != null) {
                            arrayList.add(UmengText.SHARE.URLTHUMB + uMVideo.getThumbImage().asUrlImage());
                        }
                    } else {
                        byte[] asBinImage3 = uMVideo.getThumbImage().asBinImage();
                        if (asBinImage3 != null) {
                            arrayList.add(UmengText.SHARE.LOCALTHUMB + asBinImage3.length);
                        }
                    }
                }
            }
            UMediaObject uMediaObject3 = shareContent.mMedia;
            if (uMediaObject3 instanceof UMusic) {
                UMusic uMusic = (UMusic) uMediaObject3;
                arrayList.add(UmengText.SHARE.MUSICURL + uMusic.toUrl() + "   " + uMusic.getmTargetUrl());
                StringBuilder sb2 = new StringBuilder();
                sb2.append(UmengText.SHARE.MUSICTITLE);
                sb2.append(uMusic.getTitle());
                arrayList.add(sb2.toString());
                arrayList.add(UmengText.SHARE.MUSICDES + uMusic.getDescription());
                if (uMusic.getThumbImage() != null) {
                    if (uMusic.getThumbImage().isUrlMedia()) {
                        arrayList.add(UmengText.SHARE.URLTHUMB + uMusic.getThumbImage().asUrlImage());
                    } else {
                        byte[] asBinImage4 = uMusic.getThumbImage().asBinImage();
                        if (asBinImage4 != null) {
                            arrayList.add(UmengText.SHARE.LOCALTHUMB + asBinImage4.length);
                        }
                    }
                }
            }
            UMediaObject uMediaObject4 = shareContent.mMedia;
            if (uMediaObject4 instanceof UMWeb) {
                UMWeb uMWeb = (UMWeb) uMediaObject4;
                arrayList.add(UmengText.SHARE.URLURL + uMWeb.toUrl());
                arrayList.add(UmengText.SHARE.URLTITLE + uMWeb.getTitle());
                arrayList.add(UmengText.SHARE.URLDES + uMWeb.getDescription());
                if (uMWeb.getThumbImage() != null) {
                    if (uMWeb.getThumbImage().isUrlMedia()) {
                        arrayList.add(UmengText.SHARE.URLTHUMB + uMWeb.getThumbImage().asUrlImage());
                    } else {
                        byte[] asBinImage5 = uMWeb.getThumbImage().asBinImage();
                        if (asBinImage5 != null) {
                            arrayList.add(UmengText.SHARE.LOCALTHUMB + asBinImage5.length);
                        }
                    }
                }
            }
        }
        if (shareContent.file != null) {
            arrayList.add(UmengText.SHARE.FILENAME + shareContent.file.getName());
        }
        SLog.mutlI((String[]) arrayList.toArray(new String[1]));
    }

    /* renamed from: b */
    public boolean m13334b(Activity activity, SHARE_MEDIA share_media) {
        if (this.f39336f.m13321a(activity, share_media)) {
            this.f39334d.get(share_media).onCreate(activity, PlatformConfig.getPlatform(share_media));
            return this.f39334d.get(share_media).isSupport();
        }
        return false;
    }

    /* renamed from: b */
    private synchronized void m13335b(int i, UMAuthListener uMAuthListener) {
        this.f39340j.put(i, uMAuthListener);
    }

    /* renamed from: a */
    public void m13350a(Activity activity, final ShareAction shareAction, final UMShareListener uMShareListener) {
        m13332b(activity);
        WeakReference weakReference = new WeakReference(activity);
        if (this.f39336f.m13320a(shareAction, activity)) {
            if (SLog.isDebug()) {
                SLog.m13211E(UmengText.SHARE.VERSION + "7.3.2");
                m13345a(shareAction);
            }
            SHARE_MEDIA platform = shareAction.getPlatform();
            UMSSOHandler uMSSOHandler = this.f39334d.get(platform);
            uMSSOHandler.onCreate((Context) weakReference.get(), PlatformConfig.getPlatform(platform));
            final String valueOf = String.valueOf(System.currentTimeMillis());
            if (ContextUtil.getContext() != null) {
                DplusApi.uploadShare(ContextUtil.getContext(), shareAction.getShareContent(), uMSSOHandler.isInstall(), platform, valueOf, shareAction.getShareContent().mMedia instanceof UMImage ? ((UMImage) shareAction.getShareContent().mMedia).isHasWaterMark() : false);
            }
            final int ordinal = platform.ordinal();
            m13354a(ordinal, uMShareListener);
            final UMShareListener uMShareListener2 = new UMShareListener() { // from class: com.umeng.socialize.b.a.6
                @Override // com.umeng.socialize.UMShareListener
                public void onCancel(final SHARE_MEDIA share_media) {
                    QueuedWork.runInMain(new Runnable() { // from class: com.umeng.socialize.b.a.6.4
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                if (ContextUtil.getContext() != null) {
                                    SocialAnalytics.shareend(ContextUtil.getContext(), share_media, CommonNetImpl.CANCEL, "", valueOf);
                                }
                                C133286 c133286 = C133286.this;
                                UMShareListener m13323e = SocialRouter.this.m13323e(ordinal);
                                if (m13323e != null) {
                                    m13323e.onCancel(share_media);
                                }
                            } catch (Throwable th) {
                                th.printStackTrace();
                            }
                        }
                    });
                }

                @Override // com.umeng.socialize.UMShareListener
                public void onError(final SHARE_MEDIA share_media, final Throwable th) {
                    QueuedWork.runInMain(new Runnable() { // from class: com.umeng.socialize.b.a.6.3
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                if (ContextUtil.getContext() != null && th != null) {
                                    SocialAnalytics.shareend(ContextUtil.getContext(), share_media, CommonNetImpl.FAIL, th.getMessage(), valueOf);
                                }
                                C133286 c133286 = C133286.this;
                                UMShareListener m13323e = SocialRouter.this.m13323e(ordinal);
                                if (m13323e != null) {
                                    m13323e.onError(share_media, th);
                                }
                                Throwable th2 = th;
                                if (th2 != null) {
                                    SLog.m13211E(th2.getMessage());
                                    SLog.m13211E(UmengText.SOLVE + UrlUtil.ALL_SHAREFAIL);
                                    SLog.runtimePrint(th.getMessage());
                                    return;
                                }
                                SLog.m13211E("null");
                                SLog.m13211E(UmengText.SOLVE + UrlUtil.ALL_SHAREFAIL);
                                SLog.runtimePrint("null");
                            } catch (Throwable th3) {
                                th3.printStackTrace();
                            }
                        }
                    });
                }

                @Override // com.umeng.socialize.UMShareListener
                public void onResult(final SHARE_MEDIA share_media) {
                    QueuedWork.runInMain(new Runnable() { // from class: com.umeng.socialize.b.a.6.2
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                if (ContextUtil.getContext() != null) {
                                    SocialAnalytics.shareend(ContextUtil.getContext(), share_media, "success", "", valueOf);
                                }
                                C133286 c133286 = C133286.this;
                                UMShareListener m13323e = SocialRouter.this.m13323e(ordinal);
                                if (m13323e != null) {
                                    m13323e.onResult(share_media);
                                }
                            } catch (Throwable th) {
                                th.printStackTrace();
                            }
                        }
                    });
                }

                @Override // com.umeng.socialize.UMShareListener
                public void onStart(final SHARE_MEDIA share_media) {
                    QueuedWork.runInMain(new Runnable() { // from class: com.umeng.socialize.b.a.6.1
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                C133286 c133286 = C133286.this;
                                UMShareListener m13323e = SocialRouter.this.m13323e(ordinal);
                                if (m13323e != null) {
                                    m13323e.onStart(share_media);
                                }
                            } catch (Throwable th) {
                                th.printStackTrace();
                            }
                        }
                    });
                }
            };
            if (!shareAction.getUrlValid()) {
                QueuedWork.runInMain(new Runnable() { // from class: com.umeng.socialize.b.a.7
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            UMShareListener uMShareListener3 = uMShareListener2;
                            SHARE_MEDIA platform2 = shareAction.getPlatform();
                            uMShareListener3.onError(platform2, new Throwable(UmengErrorCode.ShareFailed.getMessage() + UmengText.SHARE.WEB_HTTP));
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                });
                return;
            }
            QueuedWork.runInMain(new Runnable() { // from class: com.umeng.socialize.b.a.8
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        UMShareListener uMShareListener3 = uMShareListener;
                        if (uMShareListener3 != null) {
                            uMShareListener3.onStart(shareAction.getPlatform());
                        }
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            });
            try {
                uMSSOHandler.share(shareAction.getShareContent(), uMShareListener2);
            } catch (Throwable th) {
                SLog.error(th);
            }
        }
    }

    /* renamed from: a */
    private synchronized void m13355a(int i, UMAuthListener uMAuthListener) {
        this.f39338h.put(i, uMAuthListener);
    }

    /* renamed from: a */
    private synchronized void m13354a(int i, UMShareListener uMShareListener) {
        this.f39339i.put(i, uMShareListener);
    }

    /* renamed from: a */
    private void m13340a(SHARE_MEDIA share_media, UMAuthListener uMAuthListener, UMSSOHandler uMSSOHandler, String str) {
        if (uMSSOHandler.isHasAuthListener()) {
            return;
        }
        int ordinal = share_media.ordinal();
        m13355a(ordinal, uMAuthListener);
        uMSSOHandler.setAuthListener(m13353a(ordinal, str, uMSSOHandler.isInstall()));
    }

    /* renamed from: a */
    public void m13358a() {
        m13330c();
        DplusCacheApi.getInstance().cleanCache(ContextUtil.getContext());
        UMSSOHandler uMSSOHandler = this.f39334d.get(SHARE_MEDIA.SINA);
        if (uMSSOHandler != null) {
            uMSSOHandler.release();
        }
        UMSSOHandler uMSSOHandler2 = this.f39334d.get(SHARE_MEDIA.MORE);
        if (uMSSOHandler2 != null) {
            uMSSOHandler2.release();
        }
        UMSSOHandler uMSSOHandler3 = this.f39334d.get(SHARE_MEDIA.DINGTALK);
        if (uMSSOHandler3 != null) {
            uMSSOHandler3.release();
        }
        UMSSOHandler uMSSOHandler4 = this.f39334d.get(SHARE_MEDIA.WEIXIN);
        if (uMSSOHandler4 != null) {
            uMSSOHandler4.release();
        }
        UMSSOHandler uMSSOHandler5 = this.f39334d.get(SHARE_MEDIA.QQ);
        if (uMSSOHandler5 != null) {
            uMSSOHandler5.release();
        }
        this.f39333a = null;
        DplusCacheApi.getInstance().closeDBConnection(ContextUtil.getContext());
    }

    /* renamed from: a */
    public void m13346a(Bundle bundle) {
        String str;
        int i;
        SHARE_MEDIA share_media = this.f39333a;
        if (share_media == null || !(share_media == SHARE_MEDIA.WEIXIN || share_media == SHARE_MEDIA.QQ || share_media == SHARE_MEDIA.SINA)) {
            str = "";
            i = -1;
        } else {
            str = share_media.toString();
            i = 0;
        }
        bundle.putString(f39331b, str);
        bundle.putInt(f39332c, i);
        this.f39333a = null;
    }

    /* renamed from: a */
    public void m13351a(Activity activity, Bundle bundle, UMAuthListener uMAuthListener) {
        SHARE_MEDIA convertToEmun;
        UMSSOHandler m13341a;
        if (bundle == null || uMAuthListener == null) {
            return;
        }
        String string = bundle.getString(f39331b, null);
        if (bundle.getInt(f39332c, -1) != 0 || TextUtils.isEmpty(string) || (convertToEmun = SHARE_MEDIA.convertToEmun(string)) == null) {
            return;
        }
        if (convertToEmun == SHARE_MEDIA.QQ) {
            m13341a = this.f39334d.get(convertToEmun);
            m13341a.onCreate(activity, PlatformConfig.getPlatform(convertToEmun));
        } else {
            m13341a = m13341a(convertToEmun);
        }
        if (m13341a != null) {
            m13340a(convertToEmun, uMAuthListener, m13341a, String.valueOf(System.currentTimeMillis()));
        }
    }

    /* renamed from: a */
    public void m13344a(UMShareConfig uMShareConfig) {
        if (this.f39334d.isEmpty()) {
            return;
        }
        for (Map.Entry<SHARE_MEDIA, UMSSOHandler> entry : this.f39334d.entrySet()) {
            UMSSOHandler value = entry.getValue();
            if (value != null) {
                value.setShareConfig(uMShareConfig);
            }
        }
    }
}

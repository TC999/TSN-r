package com.umeng.socialize.b;

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

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: SocialRouter.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public final class a {

    /* renamed from: b  reason: collision with root package name */
    private static final String f53920b = "umeng_share_platform";

    /* renamed from: c  reason: collision with root package name */
    private static final String f53921c = "share_action";

    /* renamed from: a  reason: collision with root package name */
    private SHARE_MEDIA f53922a;

    /* renamed from: d  reason: collision with root package name */
    private final Map<SHARE_MEDIA, UMSSOHandler> f53923d;

    /* renamed from: e  reason: collision with root package name */
    private final List<Pair<SHARE_MEDIA, String>> f53924e;

    /* renamed from: f  reason: collision with root package name */
    private final C1069a f53925f;

    /* renamed from: g  reason: collision with root package name */
    private Context f53926g;

    /* renamed from: h  reason: collision with root package name */
    private final SparseArray<UMAuthListener> f53927h;

    /* renamed from: i  reason: collision with root package name */
    private final SparseArray<UMShareListener> f53928i;

    /* renamed from: j  reason: collision with root package name */
    private final SparseArray<UMAuthListener> f53929j;

    public a(Context context) {
        HashMap hashMap = new HashMap();
        this.f53923d = hashMap;
        ArrayList arrayList = new ArrayList();
        this.f53924e = arrayList;
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
        this.f53925f = new C1069a(hashMap);
        this.f53927h = new SparseArray<>();
        this.f53928i = new SparseArray<>();
        this.f53929j = new SparseArray<>();
        this.f53926g = context;
        b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized UMShareListener e(int i4) {
        UMShareListener uMShareListener;
        uMShareListener = this.f53928i.get(i4, null);
        if (uMShareListener != null) {
            this.f53928i.remove(i4);
        }
        return uMShareListener;
    }

    public boolean d(Activity activity, SHARE_MEDIA share_media) {
        if (this.f53925f.a(activity, share_media)) {
            this.f53923d.get(share_media).onCreate(activity, PlatformConfig.getPlatform(share_media));
            return this.f53923d.get(share_media).isAuthorize();
        }
        return false;
    }

    private void b(Context context) {
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

    public String c(Activity activity, SHARE_MEDIA share_media) {
        if (this.f53925f.a(activity, share_media)) {
            this.f53923d.get(share_media).onCreate(activity, PlatformConfig.getPlatform(share_media));
            return this.f53923d.get(share_media).getSDKVersion();
        }
        return "";
    }

    public void a(Context context) {
        if (context != null) {
            this.f53926g = StubApp.getOrigApplicationContext(context.getApplicationContext());
        }
    }

    private UMSSOHandler a(String str) {
        try {
            return (UMSSOHandler) Class.forName(str).newInstance();
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized UMAuthListener d(int i4) {
        UMAuthListener uMAuthListener;
        uMAuthListener = this.f53929j.get(i4, null);
        if (uMAuthListener != null) {
            this.f53929j.remove(i4);
        }
        return uMAuthListener;
    }

    public UMSSOHandler a(SHARE_MEDIA share_media) {
        UMSSOHandler uMSSOHandler = this.f53923d.get(share_media);
        if (uMSSOHandler != null) {
            uMSSOHandler.onCreate(this.f53926g, PlatformConfig.getPlatform(share_media));
        }
        return uMSSOHandler;
    }

    public void c(Activity activity, final SHARE_MEDIA share_media, final UMAuthListener uMAuthListener) {
        if (this.f53925f.a(activity, share_media)) {
            UMSSOHandler uMSSOHandler = this.f53923d.get(share_media);
            uMSSOHandler.onCreate(activity, PlatformConfig.getPlatform(share_media));
            String valueOf = String.valueOf(System.currentTimeMillis());
            if (ContextUtil.getContext() != null) {
                SocialAnalytics.authstart(ContextUtil.getContext(), share_media, uMSSOHandler.getSDKVersion(), uMSSOHandler.isInstall(), valueOf);
            }
            int ordinal = share_media.ordinal();
            a(ordinal, uMAuthListener);
            UMAuthListener a4 = a(ordinal, valueOf, uMSSOHandler.isInstall());
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
            uMSSOHandler.authorize(a4);
            this.f53922a = share_media;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* compiled from: SocialRouter.java */
    /* renamed from: com.umeng.socialize.b.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public static class C1069a {

        /* renamed from: a  reason: collision with root package name */
        private final Map<SHARE_MEDIA, UMSSOHandler> f53988a;

        public C1069a(Map<SHARE_MEDIA, UMSSOHandler> map) {
            this.f53988a = map;
        }

        private boolean a(Context context) {
            return context != null;
        }

        public boolean a(Context context, SHARE_MEDIA share_media) {
            if (!CommonUtil.isSilentMode(context) && a(context) && a(share_media)) {
                if (this.f53988a.get(share_media).isSupportAuth()) {
                    return true;
                }
                SLog.E(share_media.toString() + UmengText.AUTH.NOT_SUPPORT_PLATFROM);
                return false;
            }
            return false;
        }

        public boolean a(ShareAction shareAction, Activity activity) {
            SHARE_MEDIA platform;
            if (CommonUtil.isSilentMode(activity) || (platform = shareAction.getPlatform()) == null) {
                return false;
            }
            if ((platform == SHARE_MEDIA.SINA || platform == SHARE_MEDIA.QQ) && !PlatformConfig.configs.get(platform).isConfigured()) {
                SLog.E(UmengText.CHECK.noKey(platform));
                return false;
            }
            return a(platform);
        }

        private boolean a(SHARE_MEDIA share_media) {
            if (this.f53988a.get(share_media) == null) {
                SLog.mutlE(UmengText.CHECK.noJar(share_media), UrlUtil.ALL_NO_JAR);
                return false;
            }
            return true;
        }
    }

    public void a(int i4, int i5, Intent intent) {
        UMSSOHandler a4 = a(i4);
        if (a4 != null) {
            a4.onActivityResult(i4, i5, intent);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void b() {
        UMSSOHandler a4;
        for (Pair<SHARE_MEDIA, String> pair : this.f53924e) {
            Object obj = pair.first;
            if (obj == SHARE_MEDIA.WEIXIN_CIRCLE) {
                a4 = this.f53923d.get(SHARE_MEDIA.WEIXIN);
            } else if (obj == SHARE_MEDIA.WEIXIN_FAVORITE) {
                a4 = this.f53923d.get(SHARE_MEDIA.WEIXIN);
            } else if (obj == SHARE_MEDIA.FACEBOOK_MESSAGER) {
                a4 = this.f53923d.get(SHARE_MEDIA.FACEBOOK);
            } else if (obj == SHARE_MEDIA.BYTEDANCE_PUBLISH) {
                a4 = this.f53923d.get(SHARE_MEDIA.BYTEDANCE);
            } else if (obj == SHARE_MEDIA.BYTEDANCE_FRIENDS) {
                a4 = this.f53923d.get(SHARE_MEDIA.BYTEDANCE);
            } else if (obj == SHARE_MEDIA.YIXIN_CIRCLE) {
                a4 = this.f53923d.get(SHARE_MEDIA.YIXIN);
            } else if (obj == SHARE_MEDIA.MORE) {
                a4 = new UMMoreHandler();
            } else {
                a4 = a((String) pair.second);
            }
            this.f53923d.put(pair.first, a4);
        }
    }

    @Deprecated
    public void a(Activity activity, int i4, UMAuthListener uMAuthListener) {
        UMSSOHandler a4 = a(i4);
        if (a4 != null) {
            if (i4 == 10103 || i4 == 11101) {
                a4.onCreate(activity, PlatformConfig.getPlatform(b(i4)));
                a(SHARE_MEDIA.QQ, uMAuthListener, a4, String.valueOf(System.currentTimeMillis()));
            }
        }
    }

    private UMSSOHandler a(int i4) {
        int i5 = 10103;
        if (i4 != 10103 && i4 != 11101) {
            i5 = i4;
        }
        i5 = (i4 == 64207 || i4 == 64206 || i4 == 64208) ? 64206 : 64206;
        i5 = (i4 == 32973 || i4 == 765) ? 10001 : 10001;
        if (i4 == 5650) {
            i5 = 5659;
        }
        for (UMSSOHandler uMSSOHandler : this.f53923d.values()) {
            if (uMSSOHandler != null && i5 == uMSSOHandler.getRequestCode()) {
                return uMSSOHandler;
            }
        }
        return null;
    }

    public void a(Activity activity, SHARE_MEDIA share_media, UMAuthListener uMAuthListener) {
        if (this.f53925f.a(activity, share_media)) {
            if (uMAuthListener == null) {
                uMAuthListener = new UMAuthListener() { // from class: com.umeng.socialize.b.a.1
                    @Override // com.umeng.socialize.UMAuthListener
                    public void onCancel(SHARE_MEDIA share_media2, int i4) {
                    }

                    @Override // com.umeng.socialize.UMAuthListener
                    public void onComplete(SHARE_MEDIA share_media2, int i4, Map<String, String> map) {
                    }

                    @Override // com.umeng.socialize.UMAuthListener
                    public void onError(SHARE_MEDIA share_media2, int i4, Throwable th) {
                    }

                    @Override // com.umeng.socialize.UMAuthListener
                    public void onStart(SHARE_MEDIA share_media2) {
                    }
                };
            }
            this.f53923d.get(share_media).onCreate(activity, PlatformConfig.getPlatform(share_media));
            this.f53923d.get(share_media).deleteAuth(uMAuthListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized UMAuthListener c(int i4) {
        UMAuthListener uMAuthListener;
        this.f53922a = null;
        uMAuthListener = this.f53927h.get(i4, null);
        if (uMAuthListener != null) {
            this.f53927h.remove(i4);
        }
        return uMAuthListener;
    }

    public boolean a(Activity activity, SHARE_MEDIA share_media) {
        this.f53923d.get(share_media).onCreate(activity, PlatformConfig.getPlatform(share_media));
        return this.f53923d.get(share_media).isInstall();
    }

    private synchronized void c() {
        this.f53927h.clear();
        this.f53928i.clear();
        this.f53929j.clear();
    }

    private UMAuthListener a(final int i4, final String str, final boolean z3) {
        return new UMAuthListener() { // from class: com.umeng.socialize.b.a.5
            @Override // com.umeng.socialize.UMAuthListener
            public void onCancel(final SHARE_MEDIA share_media, final int i5) {
                QueuedWork.runInMain(new Runnable() { // from class: com.umeng.socialize.b.a.5.4
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            AnonymousClass5 anonymousClass5 = AnonymousClass5.this;
                            UMAuthListener c4 = a.this.c(i4);
                            if (c4 != null) {
                                c4.onCancel(share_media, i5);
                            }
                            if (ContextUtil.getContext() != null) {
                                Context context = ContextUtil.getContext();
                                SHARE_MEDIA share_media2 = share_media;
                                AnonymousClass5 anonymousClass52 = AnonymousClass5.this;
                                SocialAnalytics.authendt(context, share_media2, "cancel", z3, "", str, null);
                            }
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                });
            }

            @Override // com.umeng.socialize.UMAuthListener
            public void onComplete(final SHARE_MEDIA share_media, final int i5, final Map<String, String> map) {
                QueuedWork.runInMain(new Runnable() { // from class: com.umeng.socialize.b.a.5.2
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            AnonymousClass5 anonymousClass5 = AnonymousClass5.this;
                            UMAuthListener c4 = a.this.c(i4);
                            if (c4 != null) {
                                c4.onComplete(share_media, i5, map);
                            }
                            if (ContextUtil.getContext() != null) {
                                Context context = ContextUtil.getContext();
                                SHARE_MEDIA share_media2 = share_media;
                                AnonymousClass5 anonymousClass52 = AnonymousClass5.this;
                                SocialAnalytics.authendt(context, share_media2, "success", z3, "", str, a.this.a(share_media2, map));
                            }
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                });
            }

            @Override // com.umeng.socialize.UMAuthListener
            public void onError(final SHARE_MEDIA share_media, final int i5, final Throwable th) {
                QueuedWork.runInMain(new Runnable() { // from class: com.umeng.socialize.b.a.5.3
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            AnonymousClass5 anonymousClass5 = AnonymousClass5.this;
                            UMAuthListener c4 = a.this.c(i4);
                            if (c4 != null) {
                                c4.onError(share_media, i5, th);
                            }
                            Throwable th2 = th;
                            if (th2 != null) {
                                SLog.E(th2.getMessage());
                                SLog.runtimePrint(th.getMessage());
                            } else {
                                SLog.E("null");
                                SLog.runtimePrint("null");
                            }
                            if (ContextUtil.getContext() == null || th == null) {
                                return;
                            }
                            SocialAnalytics.authendt(ContextUtil.getContext(), share_media, "fail", z3, th.getMessage(), str, null);
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
                            AnonymousClass5 anonymousClass5 = AnonymousClass5.this;
                            UMAuthListener c4 = a.this.c(i4);
                            if (c4 != null) {
                                c4.onStart(share_media);
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
    public Map<String, String> a(SHARE_MEDIA share_media, Map<String, String> map) {
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
        map.put("aid", str3);
        map.put("as", str2);
        map.put("at", str);
        return map;
    }

    private SHARE_MEDIA b(int i4) {
        if (i4 == 10103 || i4 == 11101) {
            return SHARE_MEDIA.QQ;
        }
        if (i4 != 32973 && i4 != 765) {
            return SHARE_MEDIA.QQ;
        }
        return SHARE_MEDIA.SINA;
    }

    public void b(Activity activity, final SHARE_MEDIA share_media, final UMAuthListener uMAuthListener) {
        if (this.f53925f.a(activity, share_media)) {
            UMSSOHandler uMSSOHandler = this.f53923d.get(share_media);
            uMSSOHandler.onCreate(activity, PlatformConfig.getPlatform(share_media));
            final String valueOf = String.valueOf(System.currentTimeMillis());
            if (ContextUtil.getContext() != null) {
                SocialAnalytics.getInfostart(ContextUtil.getContext(), share_media, valueOf);
            }
            final int ordinal = share_media.ordinal();
            b(ordinal, uMAuthListener);
            UMAuthListener uMAuthListener2 = new UMAuthListener() { // from class: com.umeng.socialize.b.a.2
                @Override // com.umeng.socialize.UMAuthListener
                public void onCancel(final SHARE_MEDIA share_media2, final int i4) {
                    QueuedWork.runInMain(new Runnable() { // from class: com.umeng.socialize.b.a.2.4
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                                UMAuthListener d4 = a.this.d(ordinal);
                                if (d4 != null) {
                                    d4.onCancel(share_media2, i4);
                                }
                                if (ContextUtil.getContext() != null) {
                                    SocialAnalytics.getInfoendt(ContextUtil.getContext(), share_media2, "cancel", "", valueOf, null);
                                }
                            } catch (Throwable th) {
                                th.printStackTrace();
                            }
                        }
                    });
                }

                @Override // com.umeng.socialize.UMAuthListener
                public void onComplete(final SHARE_MEDIA share_media2, final int i4, final Map<String, String> map) {
                    QueuedWork.runInMain(new Runnable() { // from class: com.umeng.socialize.b.a.2.2
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                                UMAuthListener d4 = a.this.d(ordinal);
                                if (d4 != null) {
                                    d4.onComplete(share_media2, i4, map);
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
                public void onError(final SHARE_MEDIA share_media2, final int i4, final Throwable th) {
                    QueuedWork.runInMain(new Runnable() { // from class: com.umeng.socialize.b.a.2.3
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                                UMAuthListener d4 = a.this.d(ordinal);
                                if (d4 != null) {
                                    d4.onError(share_media2, i4, th);
                                }
                                Throwable th2 = th;
                                if (th2 != null) {
                                    SLog.E(th2.getMessage());
                                    SLog.E(UmengText.SOLVE + UrlUtil.ALL_AUTHFAIL);
                                    SLog.runtimePrint(th.getMessage());
                                } else {
                                    SLog.E(UmengText.SOLVE + UrlUtil.ALL_AUTHFAIL);
                                }
                                if (ContextUtil.getContext() == null || th == null) {
                                    return;
                                }
                                SocialAnalytics.getInfoendt(ContextUtil.getContext(), share_media2, "fail", th.getMessage(), valueOf, null);
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
                                AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                                UMAuthListener d4 = a.this.d(ordinal);
                                if (d4 != null) {
                                    d4.onStart(share_media2);
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

    private void a(ShareAction shareAction) {
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

    public boolean b(Activity activity, SHARE_MEDIA share_media) {
        if (this.f53925f.a(activity, share_media)) {
            this.f53923d.get(share_media).onCreate(activity, PlatformConfig.getPlatform(share_media));
            return this.f53923d.get(share_media).isSupport();
        }
        return false;
    }

    private synchronized void b(int i4, UMAuthListener uMAuthListener) {
        this.f53929j.put(i4, uMAuthListener);
    }

    public void a(Activity activity, final ShareAction shareAction, final UMShareListener uMShareListener) {
        b(activity);
        WeakReference weakReference = new WeakReference(activity);
        if (this.f53925f.a(shareAction, activity)) {
            if (SLog.isDebug()) {
                SLog.E(UmengText.SHARE.VERSION + "7.3.2");
                a(shareAction);
            }
            SHARE_MEDIA platform = shareAction.getPlatform();
            UMSSOHandler uMSSOHandler = this.f53923d.get(platform);
            uMSSOHandler.onCreate((Context) weakReference.get(), PlatformConfig.getPlatform(platform));
            final String valueOf = String.valueOf(System.currentTimeMillis());
            if (ContextUtil.getContext() != null) {
                DplusApi.uploadShare(ContextUtil.getContext(), shareAction.getShareContent(), uMSSOHandler.isInstall(), platform, valueOf, shareAction.getShareContent().mMedia instanceof UMImage ? ((UMImage) shareAction.getShareContent().mMedia).isHasWaterMark() : false);
            }
            final int ordinal = platform.ordinal();
            a(ordinal, uMShareListener);
            final UMShareListener uMShareListener2 = new UMShareListener() { // from class: com.umeng.socialize.b.a.6
                @Override // com.umeng.socialize.UMShareListener
                public void onCancel(final SHARE_MEDIA share_media) {
                    QueuedWork.runInMain(new Runnable() { // from class: com.umeng.socialize.b.a.6.4
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                if (ContextUtil.getContext() != null) {
                                    SocialAnalytics.shareend(ContextUtil.getContext(), share_media, "cancel", "", valueOf);
                                }
                                AnonymousClass6 anonymousClass6 = AnonymousClass6.this;
                                UMShareListener e4 = a.this.e(ordinal);
                                if (e4 != null) {
                                    e4.onCancel(share_media);
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
                                    SocialAnalytics.shareend(ContextUtil.getContext(), share_media, "fail", th.getMessage(), valueOf);
                                }
                                AnonymousClass6 anonymousClass6 = AnonymousClass6.this;
                                UMShareListener e4 = a.this.e(ordinal);
                                if (e4 != null) {
                                    e4.onError(share_media, th);
                                }
                                Throwable th2 = th;
                                if (th2 != null) {
                                    SLog.E(th2.getMessage());
                                    SLog.E(UmengText.SOLVE + UrlUtil.ALL_SHAREFAIL);
                                    SLog.runtimePrint(th.getMessage());
                                    return;
                                }
                                SLog.E("null");
                                SLog.E(UmengText.SOLVE + UrlUtil.ALL_SHAREFAIL);
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
                                AnonymousClass6 anonymousClass6 = AnonymousClass6.this;
                                UMShareListener e4 = a.this.e(ordinal);
                                if (e4 != null) {
                                    e4.onResult(share_media);
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
                                AnonymousClass6 anonymousClass6 = AnonymousClass6.this;
                                UMShareListener e4 = a.this.e(ordinal);
                                if (e4 != null) {
                                    e4.onStart(share_media);
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

    private synchronized void a(int i4, UMAuthListener uMAuthListener) {
        this.f53927h.put(i4, uMAuthListener);
    }

    private synchronized void a(int i4, UMShareListener uMShareListener) {
        this.f53928i.put(i4, uMShareListener);
    }

    private void a(SHARE_MEDIA share_media, UMAuthListener uMAuthListener, UMSSOHandler uMSSOHandler, String str) {
        if (uMSSOHandler.isHasAuthListener()) {
            return;
        }
        int ordinal = share_media.ordinal();
        a(ordinal, uMAuthListener);
        uMSSOHandler.setAuthListener(a(ordinal, str, uMSSOHandler.isInstall()));
    }

    public void a() {
        c();
        DplusCacheApi.getInstance().cleanCache(ContextUtil.getContext());
        UMSSOHandler uMSSOHandler = this.f53923d.get(SHARE_MEDIA.SINA);
        if (uMSSOHandler != null) {
            uMSSOHandler.release();
        }
        UMSSOHandler uMSSOHandler2 = this.f53923d.get(SHARE_MEDIA.MORE);
        if (uMSSOHandler2 != null) {
            uMSSOHandler2.release();
        }
        UMSSOHandler uMSSOHandler3 = this.f53923d.get(SHARE_MEDIA.DINGTALK);
        if (uMSSOHandler3 != null) {
            uMSSOHandler3.release();
        }
        UMSSOHandler uMSSOHandler4 = this.f53923d.get(SHARE_MEDIA.WEIXIN);
        if (uMSSOHandler4 != null) {
            uMSSOHandler4.release();
        }
        UMSSOHandler uMSSOHandler5 = this.f53923d.get(SHARE_MEDIA.QQ);
        if (uMSSOHandler5 != null) {
            uMSSOHandler5.release();
        }
        this.f53922a = null;
        DplusCacheApi.getInstance().closeDBConnection(ContextUtil.getContext());
    }

    public void a(Bundle bundle) {
        String str;
        int i4;
        SHARE_MEDIA share_media = this.f53922a;
        if (share_media == null || !(share_media == SHARE_MEDIA.WEIXIN || share_media == SHARE_MEDIA.QQ || share_media == SHARE_MEDIA.SINA)) {
            str = "";
            i4 = -1;
        } else {
            str = share_media.toString();
            i4 = 0;
        }
        bundle.putString("umeng_share_platform", str);
        bundle.putInt("share_action", i4);
        this.f53922a = null;
    }

    public void a(Activity activity, Bundle bundle, UMAuthListener uMAuthListener) {
        SHARE_MEDIA convertToEmun;
        UMSSOHandler a4;
        if (bundle == null || uMAuthListener == null) {
            return;
        }
        String string = bundle.getString("umeng_share_platform", null);
        if (bundle.getInt("share_action", -1) != 0 || TextUtils.isEmpty(string) || (convertToEmun = SHARE_MEDIA.convertToEmun(string)) == null) {
            return;
        }
        if (convertToEmun == SHARE_MEDIA.QQ) {
            a4 = this.f53923d.get(convertToEmun);
            a4.onCreate(activity, PlatformConfig.getPlatform(convertToEmun));
        } else {
            a4 = a(convertToEmun);
        }
        if (a4 != null) {
            a(convertToEmun, uMAuthListener, a4, String.valueOf(System.currentTimeMillis()));
        }
    }

    public void a(UMShareConfig uMShareConfig) {
        if (this.f53923d.isEmpty()) {
            return;
        }
        for (Map.Entry<SHARE_MEDIA, UMSSOHandler> entry : this.f53923d.entrySet()) {
            UMSSOHandler value = entry.getValue();
            if (value != null) {
                value.setShareConfig(uMShareConfig);
            }
        }
    }
}

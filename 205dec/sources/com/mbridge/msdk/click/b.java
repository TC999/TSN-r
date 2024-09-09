package com.mbridge.msdk.click;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.text.TextUtils;
import android.widget.Toast;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.click.CommonJumpLoader;
import com.mbridge.msdk.foundation.db.i;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.SameMD5;
import com.mbridge.msdk.foundation.tools.ab;
import com.mbridge.msdk.foundation.tools.ac;
import com.mbridge.msdk.foundation.tools.ae;
import com.mbridge.msdk.foundation.tools.ag;
import com.mbridge.msdk.foundation.tools.ah;
import com.mbridge.msdk.foundation.tools.o;
import com.mbridge.msdk.foundation.tools.t;
import com.mbridge.msdk.foundation.tools.x;
import com.mbridge.msdk.mbdownload.manager.ADownloadManager;
import com.mbridge.msdk.out.Campaign;
import com.mbridge.msdk.out.Frame;
import com.mbridge.msdk.out.IDownloadListener;
import com.mbridge.msdk.out.LoadingActivity;
import com.mbridge.msdk.out.NativeListener;
import com.stub.StubApp;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbiz.WXLaunchMiniProgram;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import java.io.File;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import xyz.adscope.ad.model.http.request.ad.constant.AdRequestConstant;

/* compiled from: CommonClickControl.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f38838a;

    /* renamed from: b  reason: collision with root package name */
    public static Set<String> f38839b = new HashSet();

    /* renamed from: c  reason: collision with root package name */
    public static Set<String> f38840c = new HashSet();

    /* renamed from: d  reason: collision with root package name */
    public static Map<String, Long> f38841d = new HashMap();

    /* renamed from: e  reason: collision with root package name */
    public static Map<String, Long> f38842e = new HashMap();

    /* renamed from: f  reason: collision with root package name */
    static Handler f38843f = new Handler(Looper.getMainLooper()) { // from class: com.mbridge.msdk.click.b.9
        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            super.handleMessage(message);
            int i4 = message.what;
            if (i4 != 0) {
                if (i4 != 1) {
                    return;
                }
                b.d();
                return;
            }
            Object obj = message.obj;
            if (obj == null || !(obj instanceof Context)) {
                return;
            }
            b.a((Context) obj);
        }
    };

    /* renamed from: g  reason: collision with root package name */
    private String f38844g;

    /* renamed from: h  reason: collision with root package name */
    private long f38845h;

    /* renamed from: i  reason: collision with root package name */
    private long f38846i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f38847j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f38848k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f38849l;

    /* renamed from: o  reason: collision with root package name */
    private com.mbridge.msdk.c.a f38852o;

    /* renamed from: p  reason: collision with root package name */
    private i f38853p;

    /* renamed from: q  reason: collision with root package name */
    private Context f38854q;

    /* renamed from: r  reason: collision with root package name */
    private CommonJumpLoader f38855r;

    /* renamed from: s  reason: collision with root package name */
    private HashMap<String, CommonJumpLoader> f38856s;

    /* renamed from: u  reason: collision with root package name */
    private com.mbridge.msdk.foundation.same.report.d f38858u;

    /* renamed from: m  reason: collision with root package name */
    private boolean f38850m = false;

    /* renamed from: n  reason: collision with root package name */
    private boolean f38851n = true;

    /* renamed from: t  reason: collision with root package name */
    private NativeListener.NativeTrackingListener f38857t = null;

    /* renamed from: v  reason: collision with root package name */
    private Handler f38859v = new Handler() { // from class: com.mbridge.msdk.click.b.1
        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            super.handleMessage(message);
            int i4 = message.what;
            if (i4 == 0) {
                if (b.this.f38857t != null) {
                    b.this.f38857t.onDownloadStart(null);
                }
            } else if (i4 != 1) {
                if (i4 == 2 && b.this.f38857t != null) {
                    b.this.f38857t.onDownloadFinish((Campaign) message.obj);
                }
            } else if (b.this.f38857t != null) {
                b.this.f38857t.onDownloadProgress(message.arg1);
            }
        }
    };

    public b(Context context, String str) {
        this.f38853p = null;
        this.f38854q = null;
        com.mbridge.msdk.c.a b4 = com.mbridge.msdk.c.b.a().b(str);
        this.f38852o = b4;
        if (b4 == null) {
            this.f38852o = com.mbridge.msdk.c.b.a().b();
        }
        this.f38848k = this.f38852o.ad();
        Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
        this.f38854q = origApplicationContext;
        this.f38844g = str;
        if (this.f38853p == null) {
            this.f38853p = i.a(origApplicationContext);
        }
        this.f38858u = new com.mbridge.msdk.foundation.same.report.d(this.f38854q);
        this.f38856s = new HashMap<>();
    }

    static /* synthetic */ void g(b bVar) {
        try {
            Intent intent = new Intent();
            intent.setAction("ExitApp");
            bVar.f38854q.sendBroadcast(intent);
        } catch (Exception e4) {
            x.b("MBridge SDK M", "Exception", e4);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x0007, code lost:
        if (2 != r8.getLinkType()) goto L29;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean d(com.mbridge.msdk.foundation.entity.CampaignEx r8) {
        /*
            r7 = this;
            if (r8 == 0) goto L9
            r0 = 2
            int r1 = r8.getLinkType()     // Catch: java.lang.Exception -> L79
            if (r0 == r1) goto L10
        L9:
            r0 = 3
            int r1 = r8.getLinkType()     // Catch: java.lang.Exception -> L79
            if (r0 != r1) goto L81
        L10:
            java.lang.String r0 = r8.getId()     // Catch: java.lang.Exception -> L79
            java.util.Map<java.lang.String, java.lang.Long> r1 = com.mbridge.msdk.click.b.f38841d     // Catch: java.lang.Exception -> L79
            if (r1 == 0) goto L81
            boolean r1 = r1.containsKey(r0)     // Catch: java.lang.Exception -> L79
            java.lang.String r2 = "MBridge SDK M"
            if (r1 == 0) goto L60
            java.util.Map<java.lang.String, java.lang.Long> r1 = com.mbridge.msdk.click.b.f38841d     // Catch: java.lang.Exception -> L79
            java.lang.Object r0 = r1.get(r0)     // Catch: java.lang.Exception -> L79
            java.lang.Long r0 = (java.lang.Long) r0     // Catch: java.lang.Exception -> L79
            if (r0 == 0) goto L60
            long r3 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Exception -> L79
            long r5 = r0.longValue()     // Catch: java.lang.Exception -> L79
            int r1 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r1 > 0) goto L42
            java.util.Set<java.lang.String> r1 = com.mbridge.msdk.click.b.f38839b     // Catch: java.lang.Exception -> L79
            java.lang.String r5 = r8.getId()     // Catch: java.lang.Exception -> L79
            boolean r1 = r1.contains(r5)     // Catch: java.lang.Exception -> L79
            if (r1 == 0) goto L60
        L42:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L79
            r8.<init>()     // Catch: java.lang.Exception -> L79
            java.lang.String r1 = "\u70b9\u51fb\u65f6\u95f4\u672a\u8d85\u8fc7coit "
            r8.append(r1)     // Catch: java.lang.Exception -> L79
            r8.append(r3)     // Catch: java.lang.Exception -> L79
            java.lang.String r1 = "|"
            r8.append(r1)     // Catch: java.lang.Exception -> L79
            r8.append(r0)     // Catch: java.lang.Exception -> L79
            java.lang.String r8 = r8.toString()     // Catch: java.lang.Exception -> L79
            com.mbridge.msdk.foundation.tools.x.b(r2, r8)     // Catch: java.lang.Exception -> L79
            r8 = 0
            return r8
        L60:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L79
            r0.<init>()     // Catch: java.lang.Exception -> L79
            java.lang.String r1 = "\u672a\u53d1\u73b0\u6709\u70b9\u51fb\u6216\u70b9\u51fb\u8d85\u65f6\u4fdd\u5b58\u70b9\u51fb\u65f6\u95f4 interval = "
            r0.append(r1)     // Catch: java.lang.Exception -> L79
            int r8 = r8.getClickTimeOutInterval()     // Catch: java.lang.Exception -> L79
            r0.append(r8)     // Catch: java.lang.Exception -> L79
            java.lang.String r8 = r0.toString()     // Catch: java.lang.Exception -> L79
            com.mbridge.msdk.foundation.tools.x.b(r2, r8)     // Catch: java.lang.Exception -> L79
            goto L81
        L79:
            r8 = move-exception
            boolean r0 = com.mbridge.msdk.MBridgeConstans.DEBUG
            if (r0 == 0) goto L81
            r8.printStackTrace()
        L81:
            r8 = 1
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.click.b.d(com.mbridge.msdk.foundation.entity.CampaignEx):boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x0007, code lost:
        if (2 != r8.getLinkType()) goto L29;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean e(com.mbridge.msdk.foundation.entity.CampaignEx r8) {
        /*
            r7 = this;
            if (r8 == 0) goto L9
            r0 = 2
            int r1 = r8.getLinkType()     // Catch: java.lang.Exception -> L92
            if (r0 == r1) goto L10
        L9:
            r0 = 3
            int r1 = r8.getLinkType()     // Catch: java.lang.Exception -> L92
            if (r0 != r1) goto L9a
        L10:
            java.lang.String r0 = r8.getId()     // Catch: java.lang.Exception -> L92
            java.util.Map<java.lang.String, java.lang.Long> r1 = com.mbridge.msdk.click.b.f38841d     // Catch: java.lang.Exception -> L92
            if (r1 == 0) goto L9a
            boolean r1 = r1.containsKey(r0)     // Catch: java.lang.Exception -> L92
            java.lang.String r2 = "MBridge SDK M"
            if (r1 == 0) goto L60
            java.util.Map<java.lang.String, java.lang.Long> r1 = com.mbridge.msdk.click.b.f38841d     // Catch: java.lang.Exception -> L92
            java.lang.Object r0 = r1.get(r0)     // Catch: java.lang.Exception -> L92
            java.lang.Long r0 = (java.lang.Long) r0     // Catch: java.lang.Exception -> L92
            if (r0 == 0) goto L60
            long r3 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Exception -> L92
            long r5 = r0.longValue()     // Catch: java.lang.Exception -> L92
            int r1 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r1 > 0) goto L42
            java.util.Set<java.lang.String> r1 = com.mbridge.msdk.click.b.f38839b     // Catch: java.lang.Exception -> L92
            java.lang.String r5 = r8.getId()     // Catch: java.lang.Exception -> L92
            boolean r1 = r1.contains(r5)     // Catch: java.lang.Exception -> L92
            if (r1 == 0) goto L60
        L42:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L92
            r8.<init>()     // Catch: java.lang.Exception -> L92
            java.lang.String r1 = "\u70b9\u51fb\u65f6\u95f4\u672a\u8d85\u8fc7coit "
            r8.append(r1)     // Catch: java.lang.Exception -> L92
            r8.append(r3)     // Catch: java.lang.Exception -> L92
            java.lang.String r1 = "|"
            r8.append(r1)     // Catch: java.lang.Exception -> L92
            r8.append(r0)     // Catch: java.lang.Exception -> L92
            java.lang.String r8 = r8.toString()     // Catch: java.lang.Exception -> L92
            com.mbridge.msdk.foundation.tools.x.b(r2, r8)     // Catch: java.lang.Exception -> L92
            r8 = 0
            return r8
        L60:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L92
            r0.<init>()     // Catch: java.lang.Exception -> L92
            java.lang.String r1 = "\u672a\u53d1\u73b0\u6709\u70b9\u51fb\u6216\u70b9\u51fb\u8d85\u65f6\u4fdd\u5b58\u70b9\u51fb\u65f6\u95f4 interval = "
            r0.append(r1)     // Catch: java.lang.Exception -> L92
            int r1 = r8.getClickTimeOutInterval()     // Catch: java.lang.Exception -> L92
            r0.append(r1)     // Catch: java.lang.Exception -> L92
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Exception -> L92
            com.mbridge.msdk.foundation.tools.x.b(r2, r0)     // Catch: java.lang.Exception -> L92
            int r0 = r8.getClickTimeOutInterval()     // Catch: java.lang.Exception -> L92
            int r0 = r0 * 1000
            java.util.Map<java.lang.String, java.lang.Long> r1 = com.mbridge.msdk.click.b.f38841d     // Catch: java.lang.Exception -> L92
            java.lang.String r8 = r8.getId()     // Catch: java.lang.Exception -> L92
            long r2 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Exception -> L92
            long r4 = (long) r0     // Catch: java.lang.Exception -> L92
            long r2 = r2 + r4
            java.lang.Long r0 = java.lang.Long.valueOf(r2)     // Catch: java.lang.Exception -> L92
            r1.put(r8, r0)     // Catch: java.lang.Exception -> L92
            goto L9a
        L92:
            r8 = move-exception
            boolean r0 = com.mbridge.msdk.MBridgeConstans.DEBUG
            if (r0 == 0) goto L9a
            r8.printStackTrace()
        L9a:
            r8 = 1
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.click.b.e(com.mbridge.msdk.foundation.entity.CampaignEx):boolean");
    }

    private void f(CampaignEx campaignEx) {
        if (c() == 2) {
            ab.a(this.f38854q, campaignEx.getClickURL(), campaignEx, this.f38857t);
        } else {
            ab.b(this.f38854q, campaignEx.getClickURL(), this.f38857t);
        }
    }

    public final void c(CampaignEx campaignEx) {
        try {
            this.f38847j = false;
            if (e(campaignEx)) {
                String noticeUrl = campaignEx.getNoticeUrl();
                com.mbridge.msdk.foundation.db.c a4 = com.mbridge.msdk.foundation.db.c.a(this.f38853p);
                a4.a();
                CommonJumpLoader.JumpLoaderResult b4 = a4.b(campaignEx.getId(), this.f38844g);
                if (b4 != null) {
                    if (b4.getNoticeurl() != null) {
                        b4.setNoticeurl(null);
                    }
                    campaignEx.setJumpResult(b4);
                    a4.a(campaignEx, this.f38844g, false, -1, campaignEx.getTtc_type());
                }
                if (ac.a(campaignEx)) {
                    o.a().a(campaignEx);
                    if (c.e(this.f38854q, campaignEx.getDeepLinkURL())) {
                        NativeListener.NativeTrackingListener nativeTrackingListener = this.f38857t;
                        if (nativeTrackingListener != null) {
                            nativeTrackingListener.onStartRedirection(campaignEx, campaignEx.getClickURL());
                        }
                        if (this.f38854q != null) {
                            Intent intent = new Intent();
                            intent.setAction("mb_dp_close_broadcast_receiver");
                            try {
                                this.f38854q.sendBroadcast(intent);
                            } catch (Exception unused) {
                            }
                        }
                        a(campaignEx, noticeUrl + "&opdptype=1", -1);
                        c.b(campaignEx);
                        NativeListener.NativeTrackingListener nativeTrackingListener2 = this.f38857t;
                        if (nativeTrackingListener2 != null) {
                            nativeTrackingListener2.onFinishRedirection(campaignEx, campaignEx.getClickURL());
                            return;
                        }
                        return;
                    }
                    noticeUrl = noticeUrl + "&opdptype=0";
                    o.a().b(campaignEx);
                }
                if (campaignEx.getLinkType() == 12) {
                    NativeListener.NativeTrackingListener nativeTrackingListener3 = this.f38857t;
                    if (nativeTrackingListener3 != null) {
                        nativeTrackingListener3.onStartRedirection(campaignEx, campaignEx.getClickURL());
                    }
                    a(campaignEx, noticeUrl, -1);
                    a(this.f38854q, campaignEx);
                    NativeListener.NativeTrackingListener nativeTrackingListener4 = this.f38857t;
                    if (nativeTrackingListener4 != null) {
                        nativeTrackingListener4.onFinishRedirection(campaignEx, campaignEx.getClickURL());
                    }
                } else if (!campaignEx.getUserActivation() && c.d(this.f38854q, campaignEx.getPackageName())) {
                    c.f(this.f38854q, campaignEx.getPackageName());
                    x.a("MBridge SDK M", campaignEx.getPackageName() + " is intalled.");
                    a(campaignEx, noticeUrl, com.mbridge.msdk.foundation.same.a.J);
                    NativeListener.NativeTrackingListener nativeTrackingListener5 = this.f38857t;
                    if (nativeTrackingListener5 != null) {
                        nativeTrackingListener5.onStartRedirection(campaignEx, campaignEx.getClickURL());
                    }
                    a(campaignEx, false, false, false, campaignEx.getTtc_type(), true, Boolean.TRUE);
                    NativeListener.NativeTrackingListener nativeTrackingListener6 = this.f38857t;
                    if (nativeTrackingListener6 != null) {
                        nativeTrackingListener6.onFinishRedirection(campaignEx, campaignEx.getClickURL());
                        ab.a(this.f38857t);
                    }
                } else {
                    int linkType = campaignEx.getLinkType();
                    int c4 = c();
                    if (linkType != 3) {
                        a(campaignEx, noticeUrl, -1);
                    }
                    x.b("MBridge SDK M", "======302\u8df3\u8f6c\u524dlinkType:" + linkType + " openType:" + c4 + "======landingType\uff1a" + campaignEx.getLandingType());
                    if (linkType == 8 || linkType == 9 || linkType == 4) {
                        String clickURL = campaignEx.getClickURL();
                        NativeListener.NativeTrackingListener nativeTrackingListener7 = this.f38857t;
                        if (nativeTrackingListener7 != null) {
                            nativeTrackingListener7.onStartRedirection(campaignEx, clickURL);
                        }
                        if (TextUtils.isEmpty(clickURL)) {
                            x.b("MBridge SDK M", "linketype=" + linkType + " clickurl \u4e3a\u7a7a");
                            NativeListener.NativeTrackingListener nativeTrackingListener8 = this.f38857t;
                            if (nativeTrackingListener8 != null) {
                                nativeTrackingListener8.onRedirectionFailed(campaignEx, clickURL);
                            }
                            a(b4, campaignEx, true, false);
                        } else if (linkType == 8) {
                            x.b("MBridge SDK M", "linketype=8 \u7528webview \u6253\u5f00");
                            ab.a(this.f38854q, clickURL, campaignEx, this.f38857t);
                            a(b4, campaignEx, false, false);
                            NativeListener.NativeTrackingListener nativeTrackingListener9 = this.f38857t;
                            if (nativeTrackingListener9 != null) {
                                nativeTrackingListener9.onFinishRedirection(campaignEx, clickURL);
                            }
                        } else if (linkType == 9) {
                            x.b("MBridge SDK M", "linketype=9 \u7528\u6d4f\u89c8\u5668 \u6253\u5f00");
                            ab.b(this.f38854q, clickURL, this.f38857t);
                            a(b4, campaignEx, false, false);
                            NativeListener.NativeTrackingListener nativeTrackingListener10 = this.f38857t;
                            if (nativeTrackingListener10 != null) {
                                nativeTrackingListener10.onFinishRedirection(campaignEx, clickURL);
                            }
                        } else {
                            if (linkType == 4) {
                                if (c4 == 2) {
                                    x.b("MBridge SDK M", "linketype=4 opent=2 \u7528webview \u6253\u5f00");
                                    ab.a(this.f38854q, clickURL, campaignEx, this.f38857t);
                                } else {
                                    x.b("MBridge SDK M", "linketype=4 opent=\u4e0d\u4e3a2 \u7528Browser \u6253\u5f00");
                                    ab.b(this.f38854q, clickURL, this.f38857t);
                                }
                            }
                            NativeListener.NativeTrackingListener nativeTrackingListener11 = this.f38857t;
                            if (nativeTrackingListener11 != null) {
                                nativeTrackingListener11.onFinishRedirection(campaignEx, clickURL);
                            }
                            a(b4, campaignEx, false, false);
                        }
                    } else if (linkType == 2) {
                        x.b("MBridge SDK M", "linktype\u4e3a2 \u5f00\u59cb\u505a302\u8df3\u8f6c" + campaignEx.getClickURL());
                        if (!campaignEx.getClickURL().startsWith("market://") && !campaignEx.getClickURL().startsWith("https://play.google.com/")) {
                            a(campaignEx, false, true, false, campaignEx.getTtc_type(), false, Boolean.TRUE);
                            return;
                        }
                        NativeListener.NativeTrackingListener nativeTrackingListener12 = this.f38857t;
                        if (nativeTrackingListener12 != null) {
                            nativeTrackingListener12.onStartRedirection(campaignEx, campaignEx.getClickURL());
                        }
                        if (!ab.a.a(this.f38854q, campaignEx.getClickURL(), this.f38857t)) {
                            a(c4, campaignEx.getClickURL(), campaignEx, this.f38857t);
                        }
                        a(b4, campaignEx, false, false);
                        x.b("MBridge SDK M", "\u4e0d\u7528\u505a302\u8df3\u8f6c \u6700\u7ec8\u5730\u5740\u5df2\u7ecf\u662fgp\u4e86\uff1a" + campaignEx.getClickURL());
                        NativeListener.NativeTrackingListener nativeTrackingListener13 = this.f38857t;
                        if (nativeTrackingListener13 != null) {
                            nativeTrackingListener13.onFinishRedirection(campaignEx, campaignEx.getClickURL());
                        }
                    } else if (linkType == 3) {
                        x.b("MBridge SDK M", "linktype\u4e3a3 \u5f00\u59cb\u505a302\u8df3\u8f6c" + campaignEx.getClickURL());
                        a(campaignEx, false, true, false, campaignEx.getTtc_type(), false, Boolean.TRUE);
                    } else {
                        String clickURL2 = campaignEx.getClickURL();
                        if (TextUtils.isEmpty(clickURL2)) {
                            x.b("MBridge SDK M", "linketype=" + linkType + " clickurl \u4e3a\u7a7a");
                            NativeListener.NativeTrackingListener nativeTrackingListener14 = this.f38857t;
                            if (nativeTrackingListener14 != null) {
                                nativeTrackingListener14.onRedirectionFailed(campaignEx, clickURL2);
                            }
                            a(b4, campaignEx, true, false);
                            return;
                        }
                        NativeListener.NativeTrackingListener nativeTrackingListener15 = this.f38857t;
                        if (nativeTrackingListener15 != null) {
                            nativeTrackingListener15.onFinishRedirection(campaignEx, clickURL2);
                        }
                        x.b("MBridge SDK M", "linketyp\u4e0d\u662f23489\u7684\u503c \u7528\u6d4f\u89c8\u5668 \u6253\u5f00");
                        ab.b(this.f38854q, clickURL2, this.f38857t);
                        a(b4, campaignEx, false, false);
                    }
                }
            }
        } catch (Throwable th) {
            x.b("MBridge SDK M", th.getMessage(), th);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x005f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean b(com.mbridge.msdk.foundation.entity.CampaignEx r10) {
        /*
            r9 = this;
            boolean r0 = r9.d(r10)
            r1 = 1
            if (r0 != 0) goto L8
            return r1
        L8:
            boolean r0 = com.mbridge.msdk.foundation.tools.ac.a(r10)
            if (r0 == 0) goto L8e
            java.lang.String r0 = r10.getNoticeUrl()
            com.mbridge.msdk.foundation.tools.o r2 = com.mbridge.msdk.foundation.tools.o.a()
            r2.a(r10)
            android.content.Context r2 = r9.f38854q
            java.lang.String r3 = r10.getDeepLinkURL()
            boolean r2 = com.mbridge.msdk.click.c.e(r2, r3)
            if (r2 == 0) goto L87
            r2 = 2
            int r3 = r10.getLinkType()     // Catch: java.lang.Exception -> L34
            if (r2 == r3) goto L36
            r2 = 3
            int r3 = r10.getLinkType()     // Catch: java.lang.Exception -> L34
            if (r2 != r3) goto L5b
            goto L36
        L34:
            r2 = move-exception
            goto L54
        L36:
            java.lang.String r2 = r10.getId()     // Catch: java.lang.Exception -> L34
            java.util.Map<java.lang.String, java.lang.Long> r3 = com.mbridge.msdk.click.b.f38841d     // Catch: java.lang.Exception -> L34
            if (r3 == 0) goto L5b
            int r3 = r10.getClickTimeOutInterval()     // Catch: java.lang.Exception -> L34
            int r3 = r3 * 1000
            java.util.Map<java.lang.String, java.lang.Long> r4 = com.mbridge.msdk.click.b.f38841d     // Catch: java.lang.Exception -> L34
            long r5 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Exception -> L34
            long r7 = (long) r3     // Catch: java.lang.Exception -> L34
            long r5 = r5 + r7
            java.lang.Long r3 = java.lang.Long.valueOf(r5)     // Catch: java.lang.Exception -> L34
            r4.put(r2, r3)     // Catch: java.lang.Exception -> L34
            goto L5b
        L54:
            boolean r3 = com.mbridge.msdk.MBridgeConstans.DEBUG
            if (r3 == 0) goto L5b
            r2.printStackTrace()
        L5b:
            android.content.Context r2 = r9.f38854q
            if (r2 == 0) goto L6e
            android.content.Intent r2 = new android.content.Intent
            r2.<init>()
            java.lang.String r3 = "mb_dp_close_broadcast_receiver"
            r2.setAction(r3)
            android.content.Context r3 = r9.f38854q     // Catch: java.lang.Exception -> L6e
            r3.sendBroadcast(r2)     // Catch: java.lang.Exception -> L6e
        L6e:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r0)
            java.lang.String r0 = "&opdptype=1"
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            r2 = -1
            r9.a(r10, r0, r2)
            com.mbridge.msdk.click.c.b(r10)
            return r1
        L87:
            com.mbridge.msdk.foundation.tools.o r0 = com.mbridge.msdk.foundation.tools.o.a()
            r0.b(r10)
        L8e:
            r10 = 0
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.click.b.b(com.mbridge.msdk.foundation.entity.CampaignEx):boolean");
    }

    public final void a(String str) {
        this.f38844g = str;
    }

    public final void a(NativeListener.NativeTrackingListener nativeTrackingListener) {
        this.f38857t = nativeTrackingListener;
    }

    public final void a(boolean z3) {
        this.f38851n = z3;
    }

    public final void a() {
        Set<Map.Entry<String, CommonJumpLoader>> entrySet;
        CommonJumpLoader value;
        try {
            HashMap<String, CommonJumpLoader> hashMap = this.f38856s;
            if (hashMap != null && (entrySet = hashMap.entrySet()) != null && entrySet.size() > 0) {
                for (Map.Entry<String, CommonJumpLoader> entry : entrySet) {
                    if (entry != null && (value = entry.getValue()) != null) {
                        value.a();
                    }
                }
            }
            this.f38857t = null;
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void d() {
        try {
            String language = Locale.getDefault().getLanguage();
            if (!TextUtils.isEmpty(language) && language.equals("zh")) {
                Toast.makeText(com.mbridge.msdk.foundation.controller.a.f().j(), "\u6b63\u5728\u4e0b\u8f7d\u4e2d,\u8bf7\u7a0d\u5019...", 0).show();
            } else {
                Toast.makeText(com.mbridge.msdk.foundation.controller.a.f().j(), "Downloading....", 0).show();
            }
        } catch (Exception unused) {
        }
    }

    public final void a(CampaignEx campaignEx, NativeListener.NativeAdListener nativeAdListener) {
        if (nativeAdListener != null && campaignEx != null) {
            nativeAdListener.onAdClick(campaignEx);
        }
        x.b("MBridge SDK M", "clickStart");
        c(campaignEx);
    }

    public final void a(CampaignEx campaignEx) {
        try {
            if (e(campaignEx)) {
                com.mbridge.msdk.foundation.db.c a4 = com.mbridge.msdk.foundation.db.c.a(this.f38853p);
                a4.a();
                CommonJumpLoader.JumpLoaderResult b4 = a4.b(campaignEx.getId(), this.f38844g);
                if (b4 != null) {
                    if (b4.getNoticeurl() != null) {
                        b4.setNoticeurl(null);
                    }
                    campaignEx.setJumpResult(b4);
                    a4.a(campaignEx, this.f38844g, false, -1, campaignEx.getTtc_type());
                }
                if (c.d(this.f38854q, campaignEx.getPackageName())) {
                    x.a("MBridge SDK M", campaignEx.getPackageName() + " is intalled.");
                    return;
                }
                a(campaignEx, false, false, false, campaignEx.getTtc_type(), false, Boolean.FALSE);
            }
        } catch (Throwable th) {
            x.b("MBridge SDK M", th.getMessage(), th);
        }
    }

    public static void b(CampaignEx campaignEx, Context context, String str) {
        try {
            if (str.equals(CampaignEx.JSON_NATIVE_VIDEO_START) || str.equals("downloading")) {
                if (Looper.myLooper() == Looper.getMainLooper()) {
                    a(context);
                } else {
                    Message obtainMessage = f38843f.obtainMessage(0);
                    obtainMessage.obj = context;
                    f38843f.sendMessage(obtainMessage);
                }
            }
            c(campaignEx, context, str);
        } catch (Throwable th) {
            x.b("MBridge SDK M", th.getMessage(), th);
        }
    }

    private void b(final CampaignEx campaignEx, final String str, final boolean z3) {
        String md5;
        Context j4;
        boolean a4;
        boolean c4;
        if (campaignEx != null && !TextUtils.isEmpty(campaignEx.getAkdlui())) {
            md5 = campaignEx.getAkdlui();
        } else {
            md5 = SameMD5.getMD5(str);
        }
        final String str2 = md5;
        try {
            com.mbridge.msdk.foundation.tools.g.a(str, 1, campaignEx);
            j4 = com.mbridge.msdk.foundation.controller.a.f().j();
            a4 = ah.a(j4);
            c4 = ah.c(j4);
        } catch (Throwable th) {
            th = th;
        }
        try {
            if (!ah.b(j4)) {
                a(campaignEx, campaignEx.getNoticeUrl(), com.mbridge.msdk.foundation.same.a.H);
                c.a(j4, str, str2);
            } else if (!c4) {
                c(campaignEx, str, z3);
            } else if (!a4) {
                c(campaignEx, str, z3);
            } else {
                Context j5 = com.mbridge.msdk.foundation.controller.a.f().j();
                ae.a(j5, str2 + "isDowning", Long.valueOf(System.currentTimeMillis()));
                Context j6 = com.mbridge.msdk.foundation.controller.a.f().j();
                ae.a(j6, str2 + "process", Integer.valueOf(Process.myPid()));
                String str3 = (String) ADownloadManager.class.getMethod("initAPKDownloadTask", CampaignEx.class, String.class, IDownloadListener.class).invoke(ADownloadManager.class.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]), campaignEx, str, new IDownloadListener() { // from class: com.mbridge.msdk.click.b.10
                    @Override // com.mbridge.msdk.out.IDownloadListener
                    public final void onEnd(int i4, int i5, String str4) {
                        x.b("MBridge SDK M", "download listener onEnd result = " + i4 + " nid = " + i5 + " file = " + str4 + "-sdkclick:" + z3);
                        Context j7 = com.mbridge.msdk.foundation.controller.a.f().j();
                        StringBuilder sb = new StringBuilder();
                        sb.append(str2);
                        sb.append("isDowning");
                        ae.a(j7, sb.toString(), 0L);
                        Context j8 = com.mbridge.msdk.foundation.controller.a.f().j();
                        ae.a(j8, str2 + "process", 0);
                        if (!TextUtils.isEmpty(str4)) {
                            b.b(campaignEx, b.this.f38854q, "end");
                            com.mbridge.msdk.foundation.db.g.b(i.a(com.mbridge.msdk.foundation.controller.a.f().j())).a(campaignEx);
                            File file = new File(str4);
                            if (file.exists() && z3) {
                                c.a(b.this.f38854q, Uri.fromFile(file), str, str2);
                                ae.a(com.mbridge.msdk.foundation.controller.a.f().j(), str2, str4);
                            } else if (!z3) {
                                ae.a(com.mbridge.msdk.foundation.controller.a.f().j(), str2, str4);
                            }
                        }
                        if (b.this.f38857t == null || i4 != 1) {
                            return;
                        }
                        b.this.f38857t.onDownloadFinish(campaignEx);
                    }

                    @Override // com.mbridge.msdk.out.IDownloadListener
                    public final void onProgressUpdate(int i4) {
                    }

                    @Override // com.mbridge.msdk.out.IDownloadListener
                    public final void onStart() {
                        b bVar = b.this;
                        CampaignEx campaignEx2 = campaignEx;
                        bVar.a(campaignEx2, campaignEx2.getNoticeUrl(), com.mbridge.msdk.foundation.same.a.F);
                        b.b(campaignEx, b.this.f38854q, CampaignEx.JSON_NATIVE_VIDEO_START);
                        if (b.this.f38857t != null) {
                            b.this.f38857t.onDownloadStart(null);
                        }
                    }

                    @Override // com.mbridge.msdk.out.IDownloadListener
                    public final void onStatus(int i4) {
                    }
                });
            }
        } catch (Throwable th2) {
            th = th2;
            Context j7 = com.mbridge.msdk.foundation.controller.a.f().j();
            ae.a(j7, str2 + "isDowning", 0L);
            Context j8 = com.mbridge.msdk.foundation.controller.a.f().j();
            ae.a(j8, str2 + "process", 0);
            if (MBridgeConstans.DEBUG) {
                th.printStackTrace();
            }
            c(campaignEx, str, z3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(CampaignEx campaignEx, String str, int i4) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (i4 != -1) {
            str = str + "&apk_ptype=" + i4;
        }
        if (!str.contains("opdptype")) {
            str = str + "&opdptype=0";
        }
        a(this.f38854q, campaignEx, this.f38844g, str, true, false, com.mbridge.msdk.click.a.a.f38809i);
    }

    private void a(Context context, CampaignEx campaignEx) {
        if (context == null) {
            com.mbridge.msdk.foundation.same.report.e.a(com.mbridge.msdk.foundation.controller.a.f().j(), campaignEx, 2, "context is null", this.f38844g);
            return;
        }
        boolean z3 = t.v() == 1;
        boolean z4 = t.r(context) == 1;
        if (z3 && z4) {
            String ghId = campaignEx.getGhId();
            String ghPath = campaignEx.getGhPath();
            String bindId = campaignEx.getBindId();
            String m4 = com.mbridge.msdk.foundation.controller.a.f().m();
            if (!TextUtils.isEmpty(ghId)) {
                try {
                    if (!TextUtils.isEmpty(m4)) {
                        bindId = m4;
                    }
                    Object f4 = t.f(bindId);
                    Object newInstance = WXLaunchMiniProgram.Req.class.newInstance();
                    WXLaunchMiniProgram.Req.class.getField("userName").set(newInstance, ghId);
                    WXLaunchMiniProgram.Req.class.getField("path").set(newInstance, ghPath);
                    WXLaunchMiniProgram.Req.class.getField("miniprogramType").set(newInstance, WXLaunchMiniProgram.Req.class.getField("MINIPTOGRAM_TYPE_RELEASE").get(null));
                    IWXAPI.class.getMethod("sendReq", BaseReq.class).invoke(f4, newInstance);
                    com.mbridge.msdk.foundation.same.report.e.a(context, campaignEx, 1, "", this.f38844g);
                    return;
                } catch (Throwable th) {
                    com.mbridge.msdk.foundation.same.report.e.a(context, campaignEx, 2, th.getMessage(), this.f38844g);
                    f(campaignEx);
                    return;
                }
            }
            f(campaignEx);
            com.mbridge.msdk.foundation.same.report.e.a(context, campaignEx, 2, "ghid is empty", this.f38844g);
            return;
        }
        com.mbridge.msdk.foundation.same.report.e.a(context, campaignEx, 2, "integrated:" + z3 + "-hasWx:" + z4, this.f38844g);
        f(campaignEx);
    }

    public static void a(Context context, CampaignEx campaignEx, String str, String str2, boolean z3, boolean z4) {
        if (context == null) {
            return;
        }
        new CommonJumpLoader(StubApp.getOrigApplicationContext(context.getApplicationContext()), true).a("2", str, campaignEx, null, str2, z3, z4, com.mbridge.msdk.click.a.a.f38806f);
    }

    public static void a(Context context, CampaignEx campaignEx, String str, String str2, boolean z3, boolean z4, int i4) {
        if (context == null) {
            return;
        }
        new CommonJumpLoader(StubApp.getOrigApplicationContext(context.getApplicationContext()), true).a("2", str, campaignEx, null, str2, z3, z4, i4);
    }

    public static void a(Context context, CampaignEx campaignEx, String str, String[] strArr, boolean z3, boolean z4) {
        if (context == null || campaignEx == null || TextUtils.isEmpty(str) || strArr == null) {
            return;
        }
        CommonJumpLoader commonJumpLoader = new CommonJumpLoader(StubApp.getOrigApplicationContext(context.getApplicationContext()), true);
        for (String str2 : strArr) {
            commonJumpLoader.a("2", str, campaignEx, null, str2, z3, z4, com.mbridge.msdk.click.a.a.f38806f);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:58:0x015d A[Catch: Exception -> 0x01ad, TryCatch #0 {Exception -> 0x01ad, blocks: (B:3:0x0008, B:6:0x0016, B:8:0x001b, B:12:0x002a, B:15:0x0031, B:16:0x004d, B:19:0x0055, B:21:0x0066, B:23:0x0072, B:24:0x008a, B:27:0x0095, B:28:0x00a5, B:29:0x00aa, B:31:0x00bc, B:33:0x00c2, B:36:0x00d9, B:39:0x00e0, B:40:0x00ec, B:56:0x0145, B:58:0x015d, B:59:0x0160, B:61:0x0164, B:63:0x016e, B:65:0x0172, B:66:0x017e, B:68:0x0184, B:41:0x00f1, B:43:0x00fd, B:45:0x0107, B:48:0x0110, B:51:0x0132, B:52:0x013b, B:54:0x0140), top: B:73:0x0008 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(final com.mbridge.msdk.foundation.entity.CampaignEx r17, final boolean r18, boolean r19, boolean r20, final int r21, final boolean r22, final java.lang.Boolean r23) {
        /*
            Method dump skipped, instructions count: 434
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.click.b.a(com.mbridge.msdk.foundation.entity.CampaignEx, boolean, boolean, boolean, int, boolean, java.lang.Boolean):void");
    }

    private int c() {
        try {
            com.mbridge.msdk.c.a aVar = this.f38852o;
            if (aVar != null) {
                return aVar.U();
            }
            return 1;
        } catch (Exception e4) {
            e4.printStackTrace();
            return 1;
        }
    }

    private static void c(CampaignEx campaignEx, Context context, String str) {
        if (campaignEx != null) {
            try {
                if (campaignEx.getNativeVideoTracking() == null) {
                    return;
                }
                int i4 = 0;
                if (!str.equals(CampaignEx.JSON_NATIVE_VIDEO_START) && !str.equals("shortcuts_start")) {
                    if (str.equals("end")) {
                        if (campaignEx.getNativeVideoTracking().b() != null) {
                            while (i4 < campaignEx.getNativeVideoTracking().b().length) {
                                a(context, campaignEx, campaignEx.getCampaignUnitId(), campaignEx.getNativeVideoTracking().b()[i4], false, false);
                                i4++;
                            }
                            return;
                        }
                        return;
                    } else if (str.equals(AdRequestConstant.AD_REQUEST_CONTEXT_EXT_APP_INSTALL_INSTALL_KEY)) {
                        if (campaignEx.getNativeVideoTracking().c() != null) {
                            while (i4 < campaignEx.getNativeVideoTracking().c().length) {
                                a(context, campaignEx, campaignEx.getCampaignUnitId(), campaignEx.getNativeVideoTracking().c()[i4], false, false);
                                i4++;
                            }
                        }
                        com.mbridge.msdk.foundation.db.g.b(i.a(context)).i(campaignEx.getPackageName());
                        return;
                    } else {
                        return;
                    }
                }
                if (campaignEx.getNativeVideoTracking().a() != null) {
                    while (i4 < campaignEx.getNativeVideoTracking().a().length) {
                        a(context, campaignEx, campaignEx.getCampaignUnitId(), campaignEx.getNativeVideoTracking().a()[i4], false, false);
                        i4++;
                    }
                }
            } catch (Throwable th) {
                x.b("MBridge SDK M", th.getMessage(), th);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x002e A[Catch: all -> 0x0091, TryCatch #0 {all -> 0x0091, blocks: (B:3:0x0002, B:5:0x000c, B:7:0x0012, B:9:0x0018, B:10:0x001c, B:12:0x002e, B:14:0x003b), top: B:21:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003b A[Catch: all -> 0x0091, TRY_LEAVE, TryCatch #0 {all -> 0x0091, blocks: (B:3:0x0002, B:5:0x000c, B:7:0x0012, B:9:0x0018, B:10:0x001c, B:12:0x002e, B:14:0x003b), top: B:21:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0018 A[Catch: all -> 0x0091, TryCatch #0 {all -> 0x0091, blocks: (B:3:0x0002, B:5:0x000c, B:7:0x0012, B:9:0x0018, B:10:0x001c, B:12:0x002e, B:14:0x003b), top: B:21:0x0002 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void c(final com.mbridge.msdk.foundation.entity.CampaignEx r6, final java.lang.String r7, final boolean r8) {
        /*
            r5 = this;
            if (r6 == 0) goto L11
            java.lang.String r0 = r6.getAkdlui()     // Catch: java.lang.Throwable -> L91
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Throwable -> L91
            if (r0 != 0) goto L11
            java.lang.String r0 = r6.getAkdlui()     // Catch: java.lang.Throwable -> L91
            goto L12
        L11:
            r0 = r7
        L12:
            boolean r1 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Throwable -> L91
            if (r1 == 0) goto L1c
            java.lang.String r0 = com.mbridge.msdk.foundation.tools.SameMD5.getMD5(r7)     // Catch: java.lang.Throwable -> L91
        L1c:
            r1 = 2
            com.mbridge.msdk.foundation.tools.g.a(r7, r1, r6)     // Catch: java.lang.Throwable -> L91
            com.mbridge.msdk.foundation.controller.a r1 = com.mbridge.msdk.foundation.controller.a.f()     // Catch: java.lang.Throwable -> L91
            android.content.Context r1 = r1.j()     // Catch: java.lang.Throwable -> L91
            boolean r2 = com.mbridge.msdk.foundation.tools.ah.b(r1)     // Catch: java.lang.Throwable -> L91
            if (r2 != 0) goto L3b
            java.lang.String r8 = r6.getNoticeUrl()     // Catch: java.lang.Throwable -> L91
            int r2 = com.mbridge.msdk.foundation.same.a.H     // Catch: java.lang.Throwable -> L91
            r5.a(r6, r8, r2)     // Catch: java.lang.Throwable -> L91
            com.mbridge.msdk.click.c.a(r1, r7, r0)     // Catch: java.lang.Throwable -> L91
            return
        L3b:
            com.mbridge.msdk.foundation.controller.a r1 = com.mbridge.msdk.foundation.controller.a.f()     // Catch: java.lang.Throwable -> L91
            android.content.Context r1 = r1.j()     // Catch: java.lang.Throwable -> L91
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L91
            r2.<init>()     // Catch: java.lang.Throwable -> L91
            r2.append(r0)     // Catch: java.lang.Throwable -> L91
            java.lang.String r3 = "isDowning"
            r2.append(r3)     // Catch: java.lang.Throwable -> L91
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> L91
            long r3 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L91
            java.lang.Long r3 = java.lang.Long.valueOf(r3)     // Catch: java.lang.Throwable -> L91
            com.mbridge.msdk.foundation.tools.ae.a(r1, r2, r3)     // Catch: java.lang.Throwable -> L91
            com.mbridge.msdk.foundation.controller.a r1 = com.mbridge.msdk.foundation.controller.a.f()     // Catch: java.lang.Throwable -> L91
            android.content.Context r1 = r1.j()     // Catch: java.lang.Throwable -> L91
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L91
            r2.<init>()     // Catch: java.lang.Throwable -> L91
            r2.append(r0)     // Catch: java.lang.Throwable -> L91
            java.lang.String r0 = "process"
            r2.append(r0)     // Catch: java.lang.Throwable -> L91
            java.lang.String r0 = r2.toString()     // Catch: java.lang.Throwable -> L91
            int r2 = android.os.Process.myPid()     // Catch: java.lang.Throwable -> L91
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch: java.lang.Throwable -> L91
            com.mbridge.msdk.foundation.tools.ae.a(r1, r0, r2)     // Catch: java.lang.Throwable -> L91
            java.lang.Thread r0 = new java.lang.Thread     // Catch: java.lang.Throwable -> L91
            com.mbridge.msdk.click.b$2 r1 = new com.mbridge.msdk.click.b$2     // Catch: java.lang.Throwable -> L91
            r1.<init>()     // Catch: java.lang.Throwable -> L91
            r0.<init>(r1)     // Catch: java.lang.Throwable -> L91
            r0.start()     // Catch: java.lang.Throwable -> L91
            goto L99
        L91:
            r6 = move-exception
            boolean r7 = com.mbridge.msdk.MBridgeConstans.DEBUG
            if (r7 == 0) goto L99
            r6.printStackTrace()
        L99:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.click.b.c(com.mbridge.msdk.foundation.entity.CampaignEx, java.lang.String, boolean):void");
    }

    private void a(CommonJumpLoader.JumpLoaderResult jumpLoaderResult, CampaignEx campaignEx, int i4, boolean z3) {
        if (campaignEx == null || jumpLoaderResult == null) {
            return;
        }
        try {
            this.f38846i = System.currentTimeMillis() - this.f38845h;
            com.mbridge.msdk.foundation.entity.e eVar = new com.mbridge.msdk.foundation.entity.e();
            int D = t.D(this.f38854q);
            eVar.a(D);
            eVar.a(t.a(this.f38854q, D));
            eVar.j(campaignEx.getRequestId());
            eVar.k(campaignEx.getRequestIdNotice());
            eVar.d(i4);
            eVar.i(this.f38846i + "");
            eVar.h(campaignEx.getId());
            eVar.f(jumpLoaderResult.getType());
            if (!TextUtils.isEmpty(jumpLoaderResult.getUrl())) {
                eVar.g(URLEncoder.encode(jumpLoaderResult.getUrl(), "utf-8"));
            }
            eVar.c((this.f38845h / 1000) + "");
            eVar.b(Integer.parseInt(campaignEx.getLandingType()));
            eVar.c(campaignEx.getLinkType());
            eVar.b(this.f38844g);
            eVar.f(jumpLoaderResult.getType());
            if (!TextUtils.isEmpty(jumpLoaderResult.getUrl())) {
                eVar.g(URLEncoder.encode(jumpLoaderResult.getUrl(), "utf-8"));
            }
            if (this.f38848k) {
                eVar.e(jumpLoaderResult.getStatusCode());
                if (!TextUtils.isEmpty(jumpLoaderResult.getHeader())) {
                    eVar.e(URLEncoder.encode(jumpLoaderResult.getHeader(), "utf-8"));
                }
                if (!TextUtils.isEmpty(jumpLoaderResult.getContent())) {
                    eVar.f(URLEncoder.encode(jumpLoaderResult.getContent(), "UTF-8"));
                }
                if (!TextUtils.isEmpty(jumpLoaderResult.getExceptionMsg())) {
                    eVar.d(URLEncoder.encode(jumpLoaderResult.getExceptionMsg(), "utf-8"));
                }
            }
            if (z3) {
                this.f38858u.a("click_jump_error", eVar, this.f38844g);
                return;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(eVar);
            String a4 = com.mbridge.msdk.foundation.entity.e.a(arrayList);
            if (ag.b(a4)) {
                if (com.mbridge.msdk.foundation.same.report.b.a().c()) {
                    com.mbridge.msdk.foundation.same.report.b.a().a(a4);
                } else {
                    new com.mbridge.msdk.foundation.same.report.d(this.f38854q, 0).a("click_jump_success", a4, (String) null, (Frame) null);
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void a(Campaign campaign, String str) {
        try {
            if (!TextUtils.isEmpty(str) && campaign != null) {
                CampaignEx campaignEx = campaign instanceof CampaignEx ? (CampaignEx) campaign : null;
                if (!str.startsWith("market://") && !str.startsWith("https://play.google.com/")) {
                    com.mbridge.msdk.a.ALLOW_APK_DOWNLOAD = com.mbridge.msdk.c.a.aq();
                    if (!str.toLowerCase().endsWith(".apk") || com.mbridge.msdk.a.ALLOW_APK_DOWNLOAD) {
                        return;
                    }
                    if (campaignEx != null && !TextUtils.isEmpty(campaignEx.getPackageName())) {
                        Context context = this.f38854q;
                        if (!ab.a.a(context, "market://details?id=" + campaignEx.getPackageName(), this.f38857t)) {
                            try {
                                this.f38859v.post(new Runnable() { // from class: com.mbridge.msdk.click.b.8
                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        Toast.makeText(b.this.f38854q, "Opps!Access Unavailable", 0).show();
                                    }
                                });
                                return;
                            } catch (Exception unused) {
                                x.d("MBridge SDK M", "Opps!Access Unavailable.");
                                return;
                            }
                        } else if (com.mbridge.msdk.a.ALLOW_APK_DOWNLOAD) {
                            a(campaignEx, str, true);
                            return;
                        } else {
                            return;
                        }
                    } else if (com.mbridge.msdk.a.ALLOW_APK_DOWNLOAD) {
                        a(campaignEx, str, true);
                        return;
                    } else {
                        return;
                    }
                }
                if (!ab.a.a(this.f38854q, str, this.f38857t) && campaignEx != null) {
                    if (!TextUtils.isEmpty(campaignEx.getPackageName())) {
                        Context context2 = this.f38854q;
                        ab.a.a(context2, "market://details?id=" + campaignEx.getPackageName(), this.f38857t);
                    } else if (c() == 2) {
                        ab.a(this.f38854q, campaignEx.getClickURL(), campaignEx, this.f38857t);
                    } else {
                        ab.b(this.f38854q, campaignEx.getClickURL(), this.f38857t);
                    }
                }
                x.b("MBridge SDK M", "Jump to Google Play: " + str);
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(CommonJumpLoader.JumpLoaderResult jumpLoaderResult, CampaignEx campaignEx, boolean z3, boolean z4) {
        if (this.f38847j) {
            a(jumpLoaderResult, campaignEx, 1, z3);
        } else if (z4) {
            a(jumpLoaderResult, campaignEx, 2, z3);
        }
    }

    private void a(int i4, String str, CampaignEx campaignEx, NativeListener.NativeTrackingListener nativeTrackingListener) {
        try {
            if (!TextUtils.isEmpty(str)) {
                if (i4 == 2) {
                    ab.a(this.f38854q, str, campaignEx, nativeTrackingListener);
                } else {
                    ab.b(this.f38854q, str, nativeTrackingListener);
                }
            }
        } catch (Throwable th) {
            x.b("MBridge SDK M", th.getMessage(), th);
        }
    }

    private boolean a(CampaignEx campaignEx, CommonJumpLoader.JumpLoaderResult jumpLoaderResult, boolean z3, boolean z4, int i4) {
        boolean z5 = false;
        if (z3) {
            try {
                int intValue = Integer.valueOf(campaignEx.getLandingType()).intValue();
                if (intValue == 1) {
                    ab.b(this.f38854q, jumpLoaderResult.getUrl(), this.f38857t);
                } else if (intValue == 2) {
                    ab.a(this.f38854q, jumpLoaderResult.getUrl(), campaignEx, this.f38857t);
                } else if (campaignEx.getPackageName() != null) {
                    Context context = this.f38854q;
                    if (!ab.a.a(context, "market://details?id=" + campaignEx.getPackageName(), this.f38857t)) {
                        a(i4, jumpLoaderResult.getUrl(), campaignEx, this.f38857t);
                    }
                } else {
                    a(i4, jumpLoaderResult.getUrl(), campaignEx, this.f38857t);
                }
                z5 = true;
            } catch (Throwable th) {
                x.b("MBridge SDK M", th.getMessage(), th);
            }
        }
        if (z5) {
            a(jumpLoaderResult, campaignEx, true, z4);
            NativeListener.NativeTrackingListener nativeTrackingListener = this.f38857t;
            if (nativeTrackingListener != null && z3) {
                nativeTrackingListener.onFinishRedirection(campaignEx, jumpLoaderResult.getUrl());
            }
        } else {
            a(jumpLoaderResult, campaignEx, true, z4);
            NativeListener.NativeTrackingListener nativeTrackingListener2 = this.f38857t;
            if (nativeTrackingListener2 != null && z3) {
                nativeTrackingListener2.onRedirectionFailed(campaignEx, jumpLoaderResult.getUrl());
            }
        }
        return z5;
    }

    private boolean a(CampaignEx campaignEx, CommonJumpLoader.JumpLoaderResult jumpLoaderResult, boolean z3, boolean z4) {
        boolean z5 = false;
        if (z3) {
            try {
                a(campaignEx, campaignEx.getNoticeUrl(), com.mbridge.msdk.foundation.same.a.H);
                ab.b(this.f38854q, campaignEx.getClickURL(), this.f38857t);
                z5 = true;
            } catch (Throwable th) {
                x.b("MBridge SDK M", th.getMessage(), th);
            }
        }
        if (z5) {
            a(jumpLoaderResult, campaignEx, true, z4);
            NativeListener.NativeTrackingListener nativeTrackingListener = this.f38857t;
            if (nativeTrackingListener != null && z3) {
                nativeTrackingListener.onFinishRedirection(campaignEx, jumpLoaderResult.getUrl());
            }
        } else {
            a(jumpLoaderResult, campaignEx, true, z4);
            NativeListener.NativeTrackingListener nativeTrackingListener2 = this.f38857t;
            if (nativeTrackingListener2 != null && z3) {
                nativeTrackingListener2.onRedirectionFailed(campaignEx, jumpLoaderResult.getUrl());
            }
        }
        return z5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:100:?, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:101:?, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0101, code lost:
        if (com.mbridge.msdk.foundation.tools.ab.a.a(r6, "market://details?id=" + r12.getPackageName(), r11.f38857t) == false) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x01f0, code lost:
        a(r13, r12, true, r16);
        r0 = r11.f38857t;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x01f5, code lost:
        if (r0 == null) goto L101;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x01f7, code lost:
        if (r14 == false) goto L100;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x01f9, code lost:
        r0.onRedirectionFailed(null, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x01fd, code lost:
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(com.mbridge.msdk.foundation.entity.CampaignEx r12, com.mbridge.msdk.click.CommonJumpLoader.JumpLoaderResult r13, boolean r14, boolean r15, boolean r16, java.lang.Boolean r17) {
        /*
            Method dump skipped, instructions count: 515
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.click.b.a(com.mbridge.msdk.foundation.entity.CampaignEx, com.mbridge.msdk.click.CommonJumpLoader$JumpLoaderResult, boolean, boolean, boolean, java.lang.Boolean):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0010, code lost:
        if (android.text.TextUtils.isEmpty(r5) == false) goto L7;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean a(int r4, java.lang.String r5) {
        /*
            r3 = this;
            r0 = 2
            r1 = 1
            r2 = 0
            if (r4 != r0) goto Lc
            boolean r4 = com.mbridge.msdk.foundation.tools.ab.a.a(r5)     // Catch: java.lang.Exception -> L16
            if (r4 == 0) goto L13
            goto L14
        Lc:
            boolean r4 = android.text.TextUtils.isEmpty(r5)     // Catch: java.lang.Exception -> L16
            if (r4 != 0) goto L13
            goto L14
        L13:
            r1 = 0
        L14:
            r2 = r1
            goto L1a
        L16:
            r4 = move-exception
            r4.printStackTrace()
        L1a:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.click.b.a(int, java.lang.String):boolean");
    }

    private void a(CampaignEx campaignEx, String str, boolean z3) {
        String akdlui = campaignEx.getAkdlui();
        if (TextUtils.isEmpty(akdlui)) {
            akdlui = SameMD5.getMD5(str);
        }
        try {
            String obj = ae.b(com.mbridge.msdk.foundation.controller.a.f().j(), akdlui, "").toString();
            if (!TextUtils.isEmpty(obj)) {
                File file = new File(obj);
                if (file.exists()) {
                    if (z3) {
                        a(campaignEx, campaignEx.getNoticeUrl(), com.mbridge.msdk.foundation.same.a.I);
                        c.a(this.f38854q, Uri.fromFile(file), str, akdlui);
                        return;
                    }
                    return;
                }
            } else {
                Context j4 = com.mbridge.msdk.foundation.controller.a.f().j();
                int intValue = ((Integer) ae.b(j4, akdlui + "process", 0)).intValue();
                int myPid = Process.myPid();
                if (intValue != 0 && intValue == myPid) {
                    Context j5 = com.mbridge.msdk.foundation.controller.a.f().j();
                    long longValue = ((Long) ae.b(j5, akdlui + "isDowning", 0L)).longValue();
                    long currentTimeMillis = System.currentTimeMillis() - longValue;
                    if (longValue != 0 && currentTimeMillis < 600000) {
                        if (z3) {
                            Context j6 = com.mbridge.msdk.foundation.controller.a.f().j();
                            int intValue2 = ((Integer) ae.b(j6, akdlui + "downloadType", -1)).intValue();
                            if (intValue2 == 1) {
                                b(campaignEx, this.f38854q, "downloading");
                                a(campaignEx, campaignEx.getNoticeUrl(), com.mbridge.msdk.foundation.same.a.E);
                                return;
                            } else if (intValue2 == 2) {
                                a(campaignEx, this.f38854q, "downloading");
                                a(campaignEx, campaignEx.getNoticeUrl(), com.mbridge.msdk.foundation.same.a.E);
                                return;
                            } else {
                                ab.b(this.f38854q, campaignEx.getClickURL(), this.f38857t);
                                a(campaignEx, campaignEx.getNoticeUrl(), com.mbridge.msdk.foundation.same.a.H);
                                return;
                            }
                        }
                        return;
                    }
                }
            }
            if (ah.f39769a == -1) {
                try {
                    Class.forName("com.mbridge.msdk.mbdownload.b");
                    Class.forName("com.mbridge.msdk.mbdownload.f");
                    ah.f39769a = 1;
                    ah.f39770b = "ok";
                } catch (ClassNotFoundException e4) {
                    ah.f39769a = 0;
                    ah.f39770b = e4.getMessage();
                }
            }
            if (ah.f39769a == 1 && z3) {
                b(campaignEx, str, z3);
            } else {
                c(campaignEx, str, z3);
            }
        } catch (Throwable th) {
            ah.f39769a = -1;
            ah.f39770b = th.getMessage();
            x.b("downloadapk", "can't find download jar, use simple method");
            c(campaignEx, str, z3);
        }
    }

    public static void a(CampaignEx campaignEx, Context context, String str) {
        try {
            if (str.equals(CampaignEx.JSON_NATIVE_VIDEO_START) || str.equals("downloading")) {
                if (Looper.myLooper() == Looper.getMainLooper()) {
                    d();
                } else {
                    Message obtainMessage = f38843f.obtainMessage(1);
                    obtainMessage.obj = context;
                    f38843f.sendMessage(obtainMessage);
                }
            }
            c(campaignEx, context, str);
        } catch (Throwable th) {
            x.b("MBridge SDK M", th.getMessage(), th);
        }
    }

    public static void a(Context context) {
        com.mbridge.msdk.c.a b4 = com.mbridge.msdk.c.b.a().b(com.mbridge.msdk.foundation.controller.a.f().k());
        if (b4 == null) {
            b4 = com.mbridge.msdk.c.b.a().b();
        }
        if (b4 != null) {
            if (com.mbridge.msdk.foundation.controller.a.f().j() == null && context != null) {
                Toast.makeText(context, b4.Q(), 0).show();
            } else {
                Toast.makeText(com.mbridge.msdk.foundation.controller.a.f().j(), b4.Q(), 0).show();
            }
        }
    }

    static /* synthetic */ void a(b bVar, CampaignEx campaignEx, boolean z3, CommonJumpLoader.JumpLoaderResult jumpLoaderResult, int i4, boolean z4) {
        if (campaignEx == null) {
            return;
        }
        String str = "";
        if (jumpLoaderResult != null) {
            try {
                str = jumpLoaderResult.getUrl();
            } catch (Exception e4) {
                e4.printStackTrace();
                return;
            }
        }
        com.mbridge.msdk.foundation.db.c a4 = com.mbridge.msdk.foundation.db.c.a(bVar.f38853p);
        if (bVar.a(campaignEx.getLinkType(), str)) {
            bVar.a(jumpLoaderResult, campaignEx, false, z4);
            if (campaignEx.getJumpResult() != null && !TextUtils.isEmpty(campaignEx.getNoticeUrl())) {
                campaignEx.getJumpResult().setNoticeurl(campaignEx.getNoticeUrl());
            }
            a4.a(campaignEx, bVar.f38844g, z3, 1, i4);
            return;
        }
        bVar.a(jumpLoaderResult, campaignEx, true, z4);
        a4.a(campaignEx, bVar.f38844g, z3, 0, i4);
    }

    static /* synthetic */ void a(b bVar, CampaignEx campaignEx) {
        try {
            Intent intent = new Intent(bVar.f38854q, LoadingActivity.class);
            intent.setFlags(268435456);
            intent.putExtra(CampaignEx.JSON_KEY_ICON_URL, campaignEx.getIconUrl());
            bVar.f38854q.startActivity(intent);
        } catch (Exception e4) {
            x.b("MBridge SDK M", "Exception", e4);
        }
    }

    static /* synthetic */ void a(b bVar, final boolean z3, final Campaign campaign) {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.mbridge.msdk.click.b.7
            @Override // java.lang.Runnable
            public final void run() {
                if (z3 && !b.f38838a && MBridgeConstans.NATIVE_SHOW_LOADINGPAGER) {
                    b.g(b.this);
                }
                if (b.this.f38857t == null || b.f38838a || !MBridgeConstans.NATIVE_SHOW_LOADINGPAGER) {
                    return;
                }
                b.this.f38857t.onDismissLoading(campaign);
            }
        });
    }

    static /* synthetic */ void a(b bVar, final CampaignEx campaignEx, final String str, final boolean z3) {
        String md5;
        if (campaignEx != null && !TextUtils.isEmpty(campaignEx.getAkdlui())) {
            md5 = campaignEx.getAkdlui();
        } else {
            md5 = SameMD5.getMD5(str);
        }
        try {
            final String str2 = md5;
            com.mbridge.msdk.optimize.a.a(com.mbridge.msdk.foundation.tools.f.a("/apk", bVar.f38854q, new boolean[1]), c.a(str), str, new com.mbridge.msdk.optimize.b() { // from class: com.mbridge.msdk.click.b.3
                @Override // com.mbridge.msdk.optimize.b
                public final void a() {
                    b.this.f38859v.sendMessage(b.this.f38859v.obtainMessage(0));
                    b bVar2 = b.this;
                    CampaignEx campaignEx2 = campaignEx;
                    bVar2.a(campaignEx2, campaignEx2.getNoticeUrl(), com.mbridge.msdk.foundation.same.a.G);
                    if (z3) {
                        b.a(campaignEx, b.this.f38854q, CampaignEx.JSON_NATIVE_VIDEO_START);
                    } else {
                        b.a(campaignEx, b.this.f38854q, "shortcuts_start");
                    }
                }

                @Override // com.mbridge.msdk.optimize.b
                public final void b() {
                    c.a(b.this.f38854q, str, str2);
                }

                @Override // com.mbridge.msdk.optimize.b
                public final void a(int i4) {
                    Message obtainMessage = b.this.f38859v.obtainMessage(1);
                    obtainMessage.arg1 = i4;
                    b.this.f38859v.sendMessage(obtainMessage);
                }

                @Override // com.mbridge.msdk.optimize.b
                public final void a(File file) {
                    Context j4 = com.mbridge.msdk.foundation.controller.a.f().j();
                    ae.a(j4, str2 + "isDowning", 0L);
                    Context j5 = com.mbridge.msdk.foundation.controller.a.f().j();
                    ae.a(j5, str2 + "process", 0);
                    b.a(campaignEx, b.this.f38854q, "end");
                    com.mbridge.msdk.foundation.db.g.b(i.a(com.mbridge.msdk.foundation.controller.a.f().j())).a(campaignEx);
                    if (file.exists() && z3) {
                        c.a(b.this.f38854q, Uri.fromFile(file), str, str2);
                        ae.a(com.mbridge.msdk.foundation.controller.a.f().j(), str2, file.getAbsolutePath());
                    } else if (z3) {
                    } else {
                        ae.a(com.mbridge.msdk.foundation.controller.a.f().j(), str2, file.getAbsolutePath());
                    }
                }
            });
        } catch (Throwable unused) {
            c.a(com.mbridge.msdk.foundation.controller.a.f().j(), str, md5);
        }
    }
}

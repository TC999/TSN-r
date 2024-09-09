package com.mbridge.msdk.mbjscommon.confirmation;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.webkit.WebView;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.x;
import com.mbridge.msdk.mbjscommon.windvane.WindVaneWebView;
import com.mbridge.msdk.mbjscommon.windvane.h;
import com.mbridge.msdk.widget.custom.DownloadMessageDialog;
import com.mbridge.msdk.widget.dialog.MBAlertDialog;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Timer;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: SecondaryConfirmationManager.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class e implements Serializable {

    /* renamed from: b  reason: collision with root package name */
    public static int f40239b = 1;

    /* renamed from: c  reason: collision with root package name */
    public static int f40240c = 0;

    /* renamed from: d  reason: collision with root package name */
    public static int f40241d = 2;

    /* renamed from: a  reason: collision with root package name */
    HashMap<String, Integer> f40242a;

    /* renamed from: e  reason: collision with root package name */
    private WindVaneWebView f40243e;

    /* renamed from: f  reason: collision with root package name */
    private WindVaneWebView f40244f;

    /* renamed from: g  reason: collision with root package name */
    private com.mbridge.msdk.mbjscommon.confirmation.b f40245g;

    /* renamed from: h  reason: collision with root package name */
    private com.mbridge.msdk.mbjscommon.confirmation.b f40246h;

    /* renamed from: i  reason: collision with root package name */
    private c f40247i;

    /* renamed from: j  reason: collision with root package name */
    private int f40248j;

    /* renamed from: k  reason: collision with root package name */
    private MBAlertDialog f40249k;

    /* renamed from: l  reason: collision with root package name */
    private DownloadMessageDialog f40250l;

    /* renamed from: m  reason: collision with root package name */
    private AtomicBoolean f40251m;

    /* renamed from: n  reason: collision with root package name */
    private AtomicBoolean f40252n;

    /* renamed from: o  reason: collision with root package name */
    private volatile boolean f40253o;

    /* renamed from: p  reason: collision with root package name */
    private Timer f40254p;

    /* renamed from: q  reason: collision with root package name */
    private a f40255q;

    /* renamed from: r  reason: collision with root package name */
    private final Handler f40256r;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SecondaryConfirmationManager.java */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        private static final e f40284a = new e();
    }

    static /* synthetic */ void i(e eVar) {
        if (eVar.f40247i != null) {
            eVar.f40247i = null;
        }
        if (eVar.f40245g != null) {
            eVar.f40245g = null;
        }
        WindVaneWebView windVaneWebView = eVar.f40243e;
        if (windVaneWebView != null) {
            windVaneWebView.release();
        }
        WindVaneWebView windVaneWebView2 = eVar.f40244f;
        if (windVaneWebView2 != null) {
            windVaneWebView2.release();
        }
        MBAlertDialog mBAlertDialog = eVar.f40249k;
        if (mBAlertDialog != null && mBAlertDialog.isShowing()) {
            eVar.f40249k.dismiss();
        }
        DownloadMessageDialog downloadMessageDialog = eVar.f40250l;
        if (downloadMessageDialog != null && downloadMessageDialog.isShowing()) {
            eVar.f40250l.dismiss();
        }
        eVar.b();
    }

    private e() {
        this.f40242a = new HashMap<>();
        this.f40248j = 1;
        this.f40251m = new AtomicBoolean(false);
        this.f40252n = new AtomicBoolean(false);
        this.f40253o = false;
        this.f40254p = new Timer();
        this.f40256r = new Handler(Looper.getMainLooper()) { // from class: com.mbridge.msdk.mbjscommon.confirmation.e.1
            @Override // android.os.Handler
            public final void handleMessage(Message message) {
                super.handleMessage(message);
                int i4 = message.what;
                if (i4 == 1) {
                    if (e.this.f40245g != null) {
                        e.this.f40245g.a(1, "render is time out");
                    } else {
                        e.this.b();
                    }
                } else if (i4 == 2 && e.this.f40246h != null) {
                    e.this.f40246h.a(1, "render is time out");
                }
            }
        };
    }

    public final void b() {
        this.f40254p.cancel();
        this.f40253o = false;
    }

    public final void c() {
        try {
            DownloadMessageDialog downloadMessageDialog = this.f40250l;
            if (downloadMessageDialog != null) {
                downloadMessageDialog.dismiss();
            }
            MBAlertDialog mBAlertDialog = this.f40249k;
            if (mBAlertDialog != null) {
                mBAlertDialog.dismiss();
            }
        } catch (Throwable th) {
            x.d("SecondaryConfirmationManager", th.getMessage());
        }
    }

    public final MBAlertDialog d() {
        return this.f40249k;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00e9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void b(final java.lang.String r16, final com.mbridge.msdk.foundation.entity.CampaignEx r17, final android.content.Context r18, final java.lang.String r19, final com.mbridge.msdk.mbjscommon.confirmation.c r20) {
        /*
            Method dump skipped, instructions count: 237
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.mbjscommon.confirmation.e.b(java.lang.String, com.mbridge.msdk.foundation.entity.CampaignEx, android.content.Context, java.lang.String, com.mbridge.msdk.mbjscommon.confirmation.c):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: SecondaryConfirmationManager.java */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public static final class a implements DialogInterface.OnDismissListener {

        /* renamed from: a  reason: collision with root package name */
        private BroadcastReceiver f40278a;

        /* renamed from: b  reason: collision with root package name */
        private final String f40279b;

        /* renamed from: c  reason: collision with root package name */
        private final c f40280c;

        /* renamed from: d  reason: collision with root package name */
        private final WindVaneWebView f40281d;

        /* renamed from: e  reason: collision with root package name */
        private final WindVaneWebView f40282e;

        /* renamed from: f  reason: collision with root package name */
        private int f40283f;

        public a(BroadcastReceiver broadcastReceiver, String str, c cVar, WindVaneWebView windVaneWebView, WindVaneWebView windVaneWebView2, int i4) {
            this.f40278a = broadcastReceiver;
            this.f40279b = str;
            this.f40280c = cVar;
            this.f40281d = windVaneWebView;
            this.f40282e = windVaneWebView2;
            this.f40283f = i4;
        }

        public final void a(int i4) {
            this.f40283f = i4;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public final void onDismiss(DialogInterface dialogInterface) {
            if (this.f40278a != null) {
                try {
                    com.mbridge.msdk.foundation.controller.a.f().j().unregisterReceiver(this.f40278a);
                } catch (Exception e4) {
                    x.a("SecondaryConfirmationManager", e4.getMessage());
                }
            }
            String str = this.f40279b;
            c cVar = this.f40280c;
            WindVaneWebView windVaneWebView = this.f40281d;
            if (windVaneWebView != null && !windVaneWebView.isDestoryed() && this.f40281d.getObject() != null && this.f40281d.getObject().equals(e.a().a((Object) str))) {
                e.a(e.a(), this.f40281d);
            }
            WindVaneWebView windVaneWebView2 = this.f40282e;
            if (windVaneWebView2 != null && windVaneWebView2.getObject() != null && this.f40282e.getObject().equals(e.a().a((Object) str))) {
                e.a(e.a(), this.f40282e);
            }
            if (cVar != null) {
                cVar.a(this.f40283f);
                cVar.b();
            }
            e.i(e.a());
        }

        public a(String str, c cVar, WindVaneWebView windVaneWebView, WindVaneWebView windVaneWebView2, int i4) {
            this.f40279b = str;
            this.f40280c = cVar;
            this.f40281d = windVaneWebView;
            this.f40282e = windVaneWebView2;
            this.f40283f = i4;
        }
    }

    public static e a() {
        return b.f40284a;
    }

    private String a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            if (com.mbridge.msdk.c.b.a().e(com.mbridge.msdk.foundation.controller.a.f().k(), str2) != null) {
                str = com.mbridge.msdk.c.d.f38757a;
            }
            return !TextUtils.isEmpty(str) ? str : "";
        }
        return str;
    }

    /* JADX WARN: Removed duplicated region for block: B:68:0x0153 A[Catch: all -> 0x01ec, TryCatch #2 {, blocks: (B:4:0x0009, B:9:0x0011, B:12:0x001a, B:13:0x002a, B:15:0x0040, B:16:0x0043, B:18:0x0047, B:20:0x0050, B:21:0x0053, B:23:0x005d, B:25:0x0065, B:27:0x006b, B:32:0x0076, B:34:0x007c, B:37:0x0084, B:39:0x00a6, B:42:0x00b5, B:89:0x01fb, B:43:0x00e7, B:45:0x00ef, B:46:0x00fd, B:48:0x0103, B:49:0x0111, B:51:0x0116, B:53:0x011c, B:55:0x0126, B:57:0x0134, B:62:0x013f, B:64:0x0143, B:66:0x0149, B:68:0x0153, B:70:0x0161, B:72:0x0167, B:74:0x016e, B:76:0x0172, B:81:0x0193, B:83:0x01ae, B:84:0x01d5, B:78:0x0178, B:80:0x018a), top: B:95:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0172 A[Catch: all -> 0x01ec, TryCatch #2 {, blocks: (B:4:0x0009, B:9:0x0011, B:12:0x001a, B:13:0x002a, B:15:0x0040, B:16:0x0043, B:18:0x0047, B:20:0x0050, B:21:0x0053, B:23:0x005d, B:25:0x0065, B:27:0x006b, B:32:0x0076, B:34:0x007c, B:37:0x0084, B:39:0x00a6, B:42:0x00b5, B:89:0x01fb, B:43:0x00e7, B:45:0x00ef, B:46:0x00fd, B:48:0x0103, B:49:0x0111, B:51:0x0116, B:53:0x011c, B:55:0x0126, B:57:0x0134, B:62:0x013f, B:64:0x0143, B:66:0x0149, B:68:0x0153, B:70:0x0161, B:72:0x0167, B:74:0x016e, B:76:0x0172, B:81:0x0193, B:83:0x01ae, B:84:0x01d5, B:78:0x0178, B:80:0x018a), top: B:95:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x018a A[Catch: all -> 0x01ec, TryCatch #2 {, blocks: (B:4:0x0009, B:9:0x0011, B:12:0x001a, B:13:0x002a, B:15:0x0040, B:16:0x0043, B:18:0x0047, B:20:0x0050, B:21:0x0053, B:23:0x005d, B:25:0x0065, B:27:0x006b, B:32:0x0076, B:34:0x007c, B:37:0x0084, B:39:0x00a6, B:42:0x00b5, B:89:0x01fb, B:43:0x00e7, B:45:0x00ef, B:46:0x00fd, B:48:0x0103, B:49:0x0111, B:51:0x0116, B:53:0x011c, B:55:0x0126, B:57:0x0134, B:62:0x013f, B:64:0x0143, B:66:0x0149, B:68:0x0153, B:70:0x0161, B:72:0x0167, B:74:0x016e, B:76:0x0172, B:81:0x0193, B:83:0x01ae, B:84:0x01d5, B:78:0x0178, B:80:0x018a), top: B:95:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x01ae A[Catch: all -> 0x01ec, TryCatch #2 {, blocks: (B:4:0x0009, B:9:0x0011, B:12:0x001a, B:13:0x002a, B:15:0x0040, B:16:0x0043, B:18:0x0047, B:20:0x0050, B:21:0x0053, B:23:0x005d, B:25:0x0065, B:27:0x006b, B:32:0x0076, B:34:0x007c, B:37:0x0084, B:39:0x00a6, B:42:0x00b5, B:89:0x01fb, B:43:0x00e7, B:45:0x00ef, B:46:0x00fd, B:48:0x0103, B:49:0x0111, B:51:0x0116, B:53:0x011c, B:55:0x0126, B:57:0x0134, B:62:0x013f, B:64:0x0143, B:66:0x0149, B:68:0x0153, B:70:0x0161, B:72:0x0167, B:74:0x016e, B:76:0x0172, B:81:0x0193, B:83:0x01ae, B:84:0x01d5, B:78:0x0178, B:80:0x018a), top: B:95:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x01d5 A[Catch: all -> 0x01ec, TRY_LEAVE, TryCatch #2 {, blocks: (B:4:0x0009, B:9:0x0011, B:12:0x001a, B:13:0x002a, B:15:0x0040, B:16:0x0043, B:18:0x0047, B:20:0x0050, B:21:0x0053, B:23:0x005d, B:25:0x0065, B:27:0x006b, B:32:0x0076, B:34:0x007c, B:37:0x0084, B:39:0x00a6, B:42:0x00b5, B:89:0x01fb, B:43:0x00e7, B:45:0x00ef, B:46:0x00fd, B:48:0x0103, B:49:0x0111, B:51:0x0116, B:53:0x011c, B:55:0x0126, B:57:0x0134, B:62:0x013f, B:64:0x0143, B:66:0x0149, B:68:0x0153, B:70:0x0161, B:72:0x0167, B:74:0x016e, B:76:0x0172, B:81:0x0193, B:83:0x01ae, B:84:0x01d5, B:78:0x0178, B:80:0x018a), top: B:95:0x0009 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final synchronized void a(java.lang.String r20, final com.mbridge.msdk.foundation.entity.CampaignEx r21, android.content.Context r22, final java.lang.String r23, com.mbridge.msdk.widget.dialog.a r24) {
        /*
            Method dump skipped, instructions count: 515
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.mbjscommon.confirmation.e.a(java.lang.String, com.mbridge.msdk.foundation.entity.CampaignEx, android.content.Context, java.lang.String, com.mbridge.msdk.widget.dialog.a):void");
    }

    public final void b(Object obj, String str) {
        MBAlertDialog mBAlertDialog = this.f40249k;
        if (mBAlertDialog == null || !mBAlertDialog.isShowing() || this.f40249k.getListener() == null) {
            return;
        }
        this.f40249k.getListener().c();
    }

    public final void a(String str, final CampaignEx campaignEx, Context context, final String str2, c cVar) {
        final String a4 = a(str, str2);
        this.f40246h = new com.mbridge.msdk.mbjscommon.confirmation.b() { // from class: com.mbridge.msdk.mbjscommon.confirmation.e.3
            @Override // com.mbridge.msdk.mbjscommon.confirmation.b
            public final void a() {
                com.mbridge.msdk.mbjscommon.confirmation.a aVar;
                e.this.f40256r.removeMessages(2);
                if (e.this.f40244f != null && (aVar = (com.mbridge.msdk.mbjscommon.confirmation.a) e.this.f40244f.getObject()) != null) {
                    aVar.a(e.f40239b);
                    e.this.f40244f.setObject(aVar);
                }
                com.mbridge.msdk.foundation.same.report.e.a(com.mbridge.msdk.foundation.controller.a.f().j(), campaignEx, a4, str2, 1, "", 2);
            }

            @Override // com.mbridge.msdk.mbjscommon.confirmation.b
            public final void a(int i4, String str3) {
                com.mbridge.msdk.mbjscommon.confirmation.a aVar;
                e.this.f40256r.removeMessages(2);
                if (e.this.f40244f != null && (aVar = (com.mbridge.msdk.mbjscommon.confirmation.a) e.this.f40244f.getObject()) != null) {
                    aVar.a(e.f40241d);
                    e.this.f40244f.setObject(aVar);
                }
                if (i4 != 5) {
                    com.mbridge.msdk.foundation.same.report.e.a(com.mbridge.msdk.foundation.controller.a.f().j(), campaignEx, a4, str2, 2, str3, 2);
                }
            }
        };
        if (TextUtils.isEmpty(str)) {
            this.f40246h.a(2, "url is null");
        } else if (!str.contains("ldtm=1")) {
            this.f40246h.a(5, "unwanted prerender");
        } else {
            WindVaneWebView windVaneWebView = this.f40244f;
            if (windVaneWebView == null || windVaneWebView.isDestoryed()) {
                WindVaneWebView windVaneWebView2 = new WindVaneWebView(context);
                this.f40244f = windVaneWebView2;
                windVaneWebView2.setBackgroundColor(0);
                if (this.f40244f.getBackground() != null) {
                    this.f40244f.getBackground().setAlpha(0);
                }
            }
            this.f40252n.compareAndSet(true, false);
            this.f40256r.sendEmptyMessageDelayed(2, 500L);
            a(this.f40244f, str, campaignEx, context, str2, cVar, this.f40246h);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x004d A[Catch: Exception -> 0x00d1, TRY_LEAVE, TryCatch #0 {Exception -> 0x00d1, blocks: (B:3:0x001e, B:5:0x0024, B:9:0x0034, B:13:0x0047, B:15:0x004d, B:18:0x0055, B:19:0x009f, B:22:0x00a7, B:23:0x00ad, B:25:0x00cb), top: B:32:0x001e }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00c9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(com.mbridge.msdk.mbjscommon.windvane.WindVaneWebView r8, java.lang.String r9, com.mbridge.msdk.foundation.entity.CampaignEx r10, android.content.Context r11, java.lang.String r12, com.mbridge.msdk.mbjscommon.confirmation.c r13, final com.mbridge.msdk.mbjscommon.confirmation.b r14) {
        /*
            r7 = this;
            com.mbridge.msdk.mbjscommon.base.b r11 = new com.mbridge.msdk.mbjscommon.base.b
            r11.<init>()
            com.mbridge.msdk.mbjscommon.confirmation.e$4 r13 = new com.mbridge.msdk.mbjscommon.confirmation.e$4
            r13.<init>()
            r11.a(r13)
            com.mbridge.msdk.mbjscommon.confirmation.a r13 = new com.mbridge.msdk.mbjscommon.confirmation.a
            r13.<init>(r10, r9, r12)
            int r10 = com.mbridge.msdk.mbjscommon.confirmation.e.f40240c
            r13.a(r10)
            r8.setObject(r13)
            r8.setWebViewClient(r11)
            r10 = 3
            boolean r11 = android.text.TextUtils.isEmpty(r9)     // Catch: java.lang.Exception -> Ld1
            if (r11 != 0) goto L33
            com.mbridge.msdk.foundation.download.download.H5DownLoadManager r11 = com.mbridge.msdk.foundation.download.download.H5DownLoadManager.getInstance()     // Catch: java.lang.Exception -> Ld1
            java.lang.String r11 = r11.getH5ResAddress(r9)     // Catch: java.lang.Exception -> Ld1
            boolean r12 = android.text.TextUtils.isEmpty(r11)     // Catch: java.lang.Exception -> Ld1
            if (r12 != 0) goto L33
            goto L34
        L33:
            r11 = r9
        L34:
            com.mbridge.msdk.foundation.download.download.HTMLResourceManager r12 = com.mbridge.msdk.foundation.download.download.HTMLResourceManager.getInstance()     // Catch: java.lang.Exception -> Ld1
            java.lang.String r12 = r12.getHtmlContentFromUrl(r9)     // Catch: java.lang.Exception -> Ld1
            java.lang.String r13 = ""
            boolean r0 = android.text.TextUtils.isEmpty(r12)     // Catch: java.lang.Exception -> Ld1
            if (r0 != 0) goto L46
            r3 = r12
            goto L47
        L46:
            r3 = r13
        L47:
            boolean r12 = r8.isDestoryed()     // Catch: java.lang.Exception -> Ld1
            if (r12 != 0) goto Lc9
            boolean r12 = android.text.TextUtils.isEmpty(r3)     // Catch: java.lang.Exception -> Ld1
            java.lang.String r13 = "SecondaryConfirmationManager"
            if (r12 != 0) goto L9f
            java.lang.String r2 = r7.a(r9)     // Catch: java.lang.Exception -> Ld1
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> Ld1
            r9.<init>()     // Catch: java.lang.Exception -> Ld1
            java.lang.String r12 = "load====== html url:"
            r9.append(r12)     // Catch: java.lang.Exception -> Ld1
            r9.append(r11)     // Catch: java.lang.Exception -> Ld1
            java.lang.String r9 = r9.toString()     // Catch: java.lang.Exception -> Ld1
            com.mbridge.msdk.foundation.tools.x.a(r13, r9)     // Catch: java.lang.Exception -> Ld1
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> Ld1
            r9.<init>()     // Catch: java.lang.Exception -> Ld1
            java.lang.String r11 = "load===== html..."
            r9.append(r11)     // Catch: java.lang.Exception -> Ld1
            r9.append(r3)     // Catch: java.lang.Exception -> Ld1
            java.lang.String r9 = r9.toString()     // Catch: java.lang.Exception -> Ld1
            com.mbridge.msdk.foundation.tools.x.a(r13, r9)     // Catch: java.lang.Exception -> Ld1
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> Ld1
            r9.<init>()     // Catch: java.lang.Exception -> Ld1
            java.lang.String r11 = "load=====lastUrl html..."
            r9.append(r11)     // Catch: java.lang.Exception -> Ld1
            r9.append(r2)     // Catch: java.lang.Exception -> Ld1
            java.lang.String r9 = r9.toString()     // Catch: java.lang.Exception -> Ld1
            com.mbridge.msdk.foundation.tools.x.a(r13, r9)     // Catch: java.lang.Exception -> Ld1
            java.lang.String r4 = "text/html"
            java.lang.String r5 = "UTF-8"
            r6 = 0
            r1 = r8
            r1.loadDataWithBaseURL(r2, r3, r4, r5, r6)     // Catch: java.lang.Exception -> Ld1
            goto Lde
        L9f:
            boolean r9 = android.text.TextUtils.isEmpty(r11)     // Catch: java.lang.Exception -> Ld1
            if (r9 == 0) goto Lad
            if (r14 == 0) goto Lde
            java.lang.String r8 = "localUrl is null"
            r14.a(r10, r8)     // Catch: java.lang.Exception -> Ld1
            goto Lde
        Lad:
            java.lang.String r9 = r7.a(r11)     // Catch: java.lang.Exception -> Ld1
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> Ld1
            r11.<init>()     // Catch: java.lang.Exception -> Ld1
            java.lang.String r12 = "load====== url:"
            r11.append(r12)     // Catch: java.lang.Exception -> Ld1
            r11.append(r9)     // Catch: java.lang.Exception -> Ld1
            java.lang.String r11 = r11.toString()     // Catch: java.lang.Exception -> Ld1
            com.mbridge.msdk.foundation.tools.x.a(r13, r11)     // Catch: java.lang.Exception -> Ld1
            r8.loadUrl(r9)     // Catch: java.lang.Exception -> Ld1
            goto Lde
        Lc9:
            if (r14 == 0) goto Lde
            java.lang.String r8 = "webview has destoryed"
            r14.a(r10, r8)     // Catch: java.lang.Exception -> Ld1
            goto Lde
        Ld1:
            r8 = move-exception
            r8.printStackTrace()
            if (r14 == 0) goto Lde
            java.lang.String r8 = r8.getMessage()
            r14.a(r10, r8)
        Lde:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.mbjscommon.confirmation.e.a(com.mbridge.msdk.mbjscommon.windvane.WindVaneWebView, java.lang.String, com.mbridge.msdk.foundation.entity.CampaignEx, android.content.Context, java.lang.String, com.mbridge.msdk.mbjscommon.confirmation.c, com.mbridge.msdk.mbjscommon.confirmation.b):void");
    }

    private String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        Uri.Builder buildUpon = Uri.parse(str).buildUpon();
        buildUpon.appendQueryParameter("dialogRenderMode", "default");
        return buildUpon.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(CampaignEx campaignEx, Context context, String str, String str2, c cVar) {
        MBAlertDialog mBAlertDialog = this.f40249k;
        if (mBAlertDialog != null) {
            mBAlertDialog.makeDownloadAlert(campaignEx.getAppName());
            if (context instanceof Activity) {
                Activity activity = (Activity) context;
                if (activity.isDestroyed()) {
                    com.mbridge.msdk.foundation.same.report.e.a(context, campaignEx, str, str2, 4, 2);
                    b();
                    return;
                } else if (!activity.isFinishing()) {
                    this.f40249k.show();
                    this.f40248j = 1;
                    a(1);
                    cVar.a(this.f40248j);
                    com.mbridge.msdk.foundation.same.report.e.a(context, campaignEx, str, str2, 1, 2);
                    return;
                } else {
                    com.mbridge.msdk.foundation.same.report.e.a(context, campaignEx, str, str2, 4, 2);
                    b();
                    return;
                }
            }
            b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(WindVaneWebView windVaneWebView, String str, CampaignEx campaignEx, Context context, String str2, c cVar) {
        if (windVaneWebView != null && !windVaneWebView.isDestoryed()) {
            a(windVaneWebView);
            if (windVaneWebView.getParent() != null) {
                ((ViewGroup) windVaneWebView.getParent()).removeView(windVaneWebView);
            }
            this.f40249k.setContentView(windVaneWebView);
            if (context instanceof Activity) {
                Activity activity = (Activity) context;
                if (activity.isDestroyed()) {
                    com.mbridge.msdk.foundation.same.report.e.a(context, campaignEx, str, str2, 4, 2);
                    b();
                    return;
                } else if (!activity.isFinishing()) {
                    this.f40249k.show();
                    this.f40248j = 2;
                    a(2);
                    cVar.a(this.f40248j);
                    com.mbridge.msdk.foundation.same.report.e.a(context, campaignEx, str, str2, 2, 2);
                    return;
                } else {
                    com.mbridge.msdk.foundation.same.report.e.a(context, campaignEx, str, str2, 4, 2);
                    b();
                    return;
                }
            }
            b();
            return;
        }
        b(str, campaignEx, context, str2, cVar);
    }

    public final void a(Object obj, int i4) {
        com.mbridge.msdk.mbjscommon.confirmation.b bVar;
        com.mbridge.msdk.mbjscommon.confirmation.b bVar2;
        WindVaneWebView windVaneWebView = this.f40243e;
        if (windVaneWebView != null && windVaneWebView.getObject() != null && this.f40243e.getObject().equals(a(obj)) && !this.f40251m.compareAndSet(true, true) && (bVar2 = this.f40245g) != null) {
            if (i4 == f40239b) {
                bVar2.a();
            } else {
                bVar2.a(0, "webview render error and undefault");
            }
        }
        WindVaneWebView windVaneWebView2 = this.f40244f;
        if (windVaneWebView2 == null || windVaneWebView2.getObject() == null || !this.f40244f.getObject().equals(a(obj)) || this.f40252n.compareAndSet(true, true) || (bVar = this.f40246h) == null) {
            return;
        }
        if (i4 == f40239b) {
            bVar.a();
        } else {
            bVar.a(0, "webview render error and undefault");
        }
    }

    public final void a(Object obj, String str) {
        x.a("SecondaryConfirmationManager", "closeDialog");
        MBAlertDialog mBAlertDialog = this.f40249k;
        if (mBAlertDialog == null || !mBAlertDialog.isShowing()) {
            return;
        }
        this.f40249k.dismiss();
        this.f40249k.clear();
    }

    private void a(WindVaneWebView windVaneWebView) {
        if (windVaneWebView != null) {
            h.a().a((WebView) windVaneWebView, "webviewshow", "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.mbridge.msdk.mbjscommon.confirmation.a a(Object obj) {
        if (obj instanceof com.mbridge.msdk.mbjscommon.windvane.a) {
            Object object = ((com.mbridge.msdk.mbjscommon.windvane.a) obj).f40326a.getObject();
            if (object instanceof com.mbridge.msdk.mbjscommon.confirmation.a) {
                return (com.mbridge.msdk.mbjscommon.confirmation.a) object;
            }
        }
        return null;
    }

    private void a(int i4) {
        a aVar = this.f40255q;
        if (aVar != null) {
            aVar.a(i4);
        }
    }

    static /* synthetic */ void a(e eVar, WindVaneWebView windVaneWebView) {
        MBAlertDialog mBAlertDialog = eVar.f40249k;
        if (mBAlertDialog != null) {
            mBAlertDialog.clear();
        }
        if (windVaneWebView != null) {
            h.a().a((WebView) windVaneWebView, "close", "");
        }
    }
}

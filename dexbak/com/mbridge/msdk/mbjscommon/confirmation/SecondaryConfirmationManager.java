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
import com.mbridge.msdk.foundation.controller.MBSDKContext;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.report.C11385e;
import com.mbridge.msdk.foundation.tools.SameLogTool;
import com.mbridge.msdk.mbjscommon.windvane.CallMethodContext;
import com.mbridge.msdk.mbjscommon.windvane.WindVaneCallJs;
import com.mbridge.msdk.mbjscommon.windvane.WindVaneWebView;
import com.mbridge.msdk.p457c.SettingManager;
import com.mbridge.msdk.p457c.UnitSetting;
import com.mbridge.msdk.widget.custom.DownloadMessageDialog;
import com.mbridge.msdk.widget.dialog.MBAlertDialog;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Timer;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.mbridge.msdk.mbjscommon.confirmation.e */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class SecondaryConfirmationManager implements Serializable {

    /* renamed from: b */
    public static int f31467b = 1;

    /* renamed from: c */
    public static int f31468c = 0;

    /* renamed from: d */
    public static int f31469d = 2;

    /* renamed from: a */
    HashMap<String, Integer> f31470a;

    /* renamed from: e */
    private WindVaneWebView f31471e;

    /* renamed from: f */
    private WindVaneWebView f31472f;

    /* renamed from: g */
    private ConfirmationRenderListener f31473g;

    /* renamed from: h */
    private ConfirmationRenderListener f31474h;

    /* renamed from: i */
    private MBAlertDialogProxyListener f31475i;

    /* renamed from: j */
    private int f31476j;

    /* renamed from: k */
    private MBAlertDialog f31477k;

    /* renamed from: l */
    private DownloadMessageDialog f31478l;

    /* renamed from: m */
    private AtomicBoolean f31479m;

    /* renamed from: n */
    private AtomicBoolean f31480n;

    /* renamed from: o */
    private volatile boolean f31481o;

    /* renamed from: p */
    private Timer f31482p;

    /* renamed from: q */
    private DialogInterface$OnDismissListenerC11495a f31483q;

    /* renamed from: r */
    private final Handler f31484r;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SecondaryConfirmationManager.java */
    /* renamed from: com.mbridge.msdk.mbjscommon.confirmation.e$b */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class C11496b {

        /* renamed from: a */
        private static final SecondaryConfirmationManager f31512a = new SecondaryConfirmationManager();
    }

    /* renamed from: i */
    static /* synthetic */ void m21441i(SecondaryConfirmationManager secondaryConfirmationManager) {
        if (secondaryConfirmationManager.f31475i != null) {
            secondaryConfirmationManager.f31475i = null;
        }
        if (secondaryConfirmationManager.f31473g != null) {
            secondaryConfirmationManager.f31473g = null;
        }
        WindVaneWebView windVaneWebView = secondaryConfirmationManager.f31471e;
        if (windVaneWebView != null) {
            windVaneWebView.release();
        }
        WindVaneWebView windVaneWebView2 = secondaryConfirmationManager.f31472f;
        if (windVaneWebView2 != null) {
            windVaneWebView2.release();
        }
        MBAlertDialog mBAlertDialog = secondaryConfirmationManager.f31477k;
        if (mBAlertDialog != null && mBAlertDialog.isShowing()) {
            secondaryConfirmationManager.f31477k.dismiss();
        }
        DownloadMessageDialog downloadMessageDialog = secondaryConfirmationManager.f31478l;
        if (downloadMessageDialog != null && downloadMessageDialog.isShowing()) {
            secondaryConfirmationManager.f31478l.dismiss();
        }
        secondaryConfirmationManager.m21453b();
    }

    private SecondaryConfirmationManager() {
        this.f31470a = new HashMap<>();
        this.f31476j = 1;
        this.f31479m = new AtomicBoolean(false);
        this.f31480n = new AtomicBoolean(false);
        this.f31481o = false;
        this.f31482p = new Timer();
        this.f31484r = new Handler(Looper.getMainLooper()) { // from class: com.mbridge.msdk.mbjscommon.confirmation.e.1
            @Override // android.os.Handler
            public final void handleMessage(Message message) {
                super.handleMessage(message);
                int i = message.what;
                if (i == 1) {
                    if (SecondaryConfirmationManager.this.f31473g != null) {
                        SecondaryConfirmationManager.this.f31473g.mo21439a(1, "render is time out");
                    } else {
                        SecondaryConfirmationManager.this.m21453b();
                    }
                } else if (i == 2 && SecondaryConfirmationManager.this.f31474h != null) {
                    SecondaryConfirmationManager.this.f31474h.mo21439a(1, "render is time out");
                }
            }
        };
    }

    /* renamed from: b */
    public final void m21453b() {
        this.f31482p.cancel();
        this.f31481o = false;
    }

    /* renamed from: c */
    public final void m21449c() {
        try {
            DownloadMessageDialog downloadMessageDialog = this.f31478l;
            if (downloadMessageDialog != null) {
                downloadMessageDialog.dismiss();
            }
            MBAlertDialog mBAlertDialog = this.f31477k;
            if (mBAlertDialog != null) {
                mBAlertDialog.dismiss();
            }
        } catch (Throwable th) {
            SameLogTool.m21733d("SecondaryConfirmationManager", th.getMessage());
        }
    }

    /* renamed from: d */
    public final MBAlertDialog m21447d() {
        return this.f31477k;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00e9  */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m21450b(final java.lang.String r16, final com.mbridge.msdk.foundation.entity.CampaignEx r17, final android.content.Context r18, final java.lang.String r19, final com.mbridge.msdk.mbjscommon.confirmation.MBAlertDialogProxyListener r20) {
        /*
            Method dump skipped, instructions count: 237
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.mbjscommon.confirmation.SecondaryConfirmationManager.m21450b(java.lang.String, com.mbridge.msdk.foundation.entity.CampaignEx, android.content.Context, java.lang.String, com.mbridge.msdk.mbjscommon.confirmation.c):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: SecondaryConfirmationManager.java */
    /* renamed from: com.mbridge.msdk.mbjscommon.confirmation.e$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static final class DialogInterface$OnDismissListenerC11495a implements DialogInterface.OnDismissListener {

        /* renamed from: a */
        private BroadcastReceiver f31506a;

        /* renamed from: b */
        private final String f31507b;

        /* renamed from: c */
        private final MBAlertDialogProxyListener f31508c;

        /* renamed from: d */
        private final WindVaneWebView f31509d;

        /* renamed from: e */
        private final WindVaneWebView f31510e;

        /* renamed from: f */
        private int f31511f;

        public DialogInterface$OnDismissListenerC11495a(BroadcastReceiver broadcastReceiver, String str, MBAlertDialogProxyListener mBAlertDialogProxyListener, WindVaneWebView windVaneWebView, WindVaneWebView windVaneWebView2, int i) {
            this.f31506a = broadcastReceiver;
            this.f31507b = str;
            this.f31508c = mBAlertDialogProxyListener;
            this.f31509d = windVaneWebView;
            this.f31510e = windVaneWebView2;
            this.f31511f = i;
        }

        /* renamed from: a */
        public final void m21438a(int i) {
            this.f31511f = i;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public final void onDismiss(DialogInterface dialogInterface) {
            if (this.f31506a != null) {
                try {
                    MBSDKContext.m22865f().m22861j().unregisterReceiver(this.f31506a);
                } catch (Exception e) {
                    SameLogTool.m21738a("SecondaryConfirmationManager", e.getMessage());
                }
            }
            String str = this.f31507b;
            MBAlertDialogProxyListener mBAlertDialogProxyListener = this.f31508c;
            WindVaneWebView windVaneWebView = this.f31509d;
            if (windVaneWebView != null && !windVaneWebView.isDestoryed() && this.f31509d.getObject() != null && this.f31509d.getObject().equals(SecondaryConfirmationManager.m21474a().m21460a((Object) str))) {
                SecondaryConfirmationManager.m21469a(SecondaryConfirmationManager.m21474a(), this.f31509d);
            }
            WindVaneWebView windVaneWebView2 = this.f31510e;
            if (windVaneWebView2 != null && windVaneWebView2.getObject() != null && this.f31510e.getObject().equals(SecondaryConfirmationManager.m21474a().m21460a((Object) str))) {
                SecondaryConfirmationManager.m21469a(SecondaryConfirmationManager.m21474a(), this.f31510e);
            }
            if (mBAlertDialogProxyListener != null) {
                mBAlertDialogProxyListener.m21491a(this.f31511f);
                mBAlertDialogProxyListener.mo20508b();
            }
            SecondaryConfirmationManager.m21441i(SecondaryConfirmationManager.m21474a());
        }

        public DialogInterface$OnDismissListenerC11495a(String str, MBAlertDialogProxyListener mBAlertDialogProxyListener, WindVaneWebView windVaneWebView, WindVaneWebView windVaneWebView2, int i) {
            this.f31507b = str;
            this.f31508c = mBAlertDialogProxyListener;
            this.f31509d = windVaneWebView;
            this.f31510e = windVaneWebView2;
            this.f31511f = i;
        }
    }

    /* renamed from: a */
    public static SecondaryConfirmationManager m21474a() {
        return C11496b.f31512a;
    }

    /* renamed from: a */
    private String m21454a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            if (SettingManager.m23261a().m23244e(MBSDKContext.m22865f().m22860k(), str2) != null) {
                str = UnitSetting.f29913a;
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
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final synchronized void m21455a(java.lang.String r20, final com.mbridge.msdk.foundation.entity.CampaignEx r21, android.content.Context r22, final java.lang.String r23, com.mbridge.msdk.widget.dialog.MBAlertDialogListener r24) {
        /*
            Method dump skipped, instructions count: 515
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.mbjscommon.confirmation.SecondaryConfirmationManager.m21455a(java.lang.String, com.mbridge.msdk.foundation.entity.CampaignEx, android.content.Context, java.lang.String, com.mbridge.msdk.widget.dialog.a):void");
    }

    /* renamed from: b */
    public final void m21451b(Object obj, String str) {
        MBAlertDialog mBAlertDialog = this.f31477k;
        if (mBAlertDialog == null || !mBAlertDialog.isShowing() || this.f31477k.getListener() == null) {
            return;
        }
        this.f31477k.getListener().mo20507c();
    }

    /* renamed from: a */
    public final void m21456a(String str, final CampaignEx campaignEx, Context context, final String str2, MBAlertDialogProxyListener mBAlertDialogProxyListener) {
        final String m21454a = m21454a(str, str2);
        this.f31474h = new ConfirmationRenderListener() { // from class: com.mbridge.msdk.mbjscommon.confirmation.e.3
            @Override // com.mbridge.msdk.mbjscommon.confirmation.ConfirmationRenderListener
            /* renamed from: a */
            public final void mo21440a() {
                ConfirmationJsExtra confirmationJsExtra;
                SecondaryConfirmationManager.this.f31484r.removeMessages(2);
                if (SecondaryConfirmationManager.this.f31472f != null && (confirmationJsExtra = (ConfirmationJsExtra) SecondaryConfirmationManager.this.f31472f.getObject()) != null) {
                    confirmationJsExtra.m21497a(SecondaryConfirmationManager.f31467b);
                    SecondaryConfirmationManager.this.f31472f.setObject(confirmationJsExtra);
                }
                C11385e.m22079a(MBSDKContext.m22865f().m22861j(), campaignEx, m21454a, str2, 1, "", 2);
            }

            @Override // com.mbridge.msdk.mbjscommon.confirmation.ConfirmationRenderListener
            /* renamed from: a */
            public final void mo21439a(int i, String str3) {
                ConfirmationJsExtra confirmationJsExtra;
                SecondaryConfirmationManager.this.f31484r.removeMessages(2);
                if (SecondaryConfirmationManager.this.f31472f != null && (confirmationJsExtra = (ConfirmationJsExtra) SecondaryConfirmationManager.this.f31472f.getObject()) != null) {
                    confirmationJsExtra.m21497a(SecondaryConfirmationManager.f31469d);
                    SecondaryConfirmationManager.this.f31472f.setObject(confirmationJsExtra);
                }
                if (i != 5) {
                    C11385e.m22079a(MBSDKContext.m22865f().m22861j(), campaignEx, m21454a, str2, 2, str3, 2);
                }
            }
        };
        if (TextUtils.isEmpty(str)) {
            this.f31474h.mo21439a(2, "url is null");
        } else if (!str.contains("ldtm=1")) {
            this.f31474h.mo21439a(5, "unwanted prerender");
        } else {
            WindVaneWebView windVaneWebView = this.f31472f;
            if (windVaneWebView == null || windVaneWebView.isDestoryed()) {
                WindVaneWebView windVaneWebView2 = new WindVaneWebView(context);
                this.f31472f = windVaneWebView2;
                windVaneWebView2.setBackgroundColor(0);
                if (this.f31472f.getBackground() != null) {
                    this.f31472f.getBackground().setAlpha(0);
                }
            }
            this.f31480n.compareAndSet(true, false);
            this.f31484r.sendEmptyMessageDelayed(2, 500L);
            m21461a(this.f31472f, str, campaignEx, context, str2, mBAlertDialogProxyListener, this.f31474h);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x004d A[Catch: Exception -> 0x00d1, TRY_LEAVE, TryCatch #0 {Exception -> 0x00d1, blocks: (B:3:0x001e, B:5:0x0024, B:9:0x0034, B:13:0x0047, B:15:0x004d, B:18:0x0055, B:19:0x009f, B:22:0x00a7, B:23:0x00ad, B:25:0x00cb), top: B:32:0x001e }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00c9  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void m21461a(com.mbridge.msdk.mbjscommon.windvane.WindVaneWebView r8, java.lang.String r9, com.mbridge.msdk.foundation.entity.CampaignEx r10, android.content.Context r11, java.lang.String r12, com.mbridge.msdk.mbjscommon.confirmation.MBAlertDialogProxyListener r13, final com.mbridge.msdk.mbjscommon.confirmation.ConfirmationRenderListener r14) {
        /*
            r7 = this;
            com.mbridge.msdk.mbjscommon.base.b r11 = new com.mbridge.msdk.mbjscommon.base.b
            r11.<init>()
            com.mbridge.msdk.mbjscommon.confirmation.e$4 r13 = new com.mbridge.msdk.mbjscommon.confirmation.e$4
            r13.<init>()
            r11.m21526a(r13)
            com.mbridge.msdk.mbjscommon.confirmation.a r13 = new com.mbridge.msdk.mbjscommon.confirmation.a
            r13.<init>(r10, r9, r12)
            int r10 = com.mbridge.msdk.mbjscommon.confirmation.SecondaryConfirmationManager.f31468c
            r13.m21497a(r10)
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
            java.lang.String r2 = r7.m21457a(r9)     // Catch: java.lang.Exception -> Ld1
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> Ld1
            r9.<init>()     // Catch: java.lang.Exception -> Ld1
            java.lang.String r12 = "load====== html url:"
            r9.append(r12)     // Catch: java.lang.Exception -> Ld1
            r9.append(r11)     // Catch: java.lang.Exception -> Ld1
            java.lang.String r9 = r9.toString()     // Catch: java.lang.Exception -> Ld1
            com.mbridge.msdk.foundation.tools.SameLogTool.m21738a(r13, r9)     // Catch: java.lang.Exception -> Ld1
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> Ld1
            r9.<init>()     // Catch: java.lang.Exception -> Ld1
            java.lang.String r11 = "load===== html..."
            r9.append(r11)     // Catch: java.lang.Exception -> Ld1
            r9.append(r3)     // Catch: java.lang.Exception -> Ld1
            java.lang.String r9 = r9.toString()     // Catch: java.lang.Exception -> Ld1
            com.mbridge.msdk.foundation.tools.SameLogTool.m21738a(r13, r9)     // Catch: java.lang.Exception -> Ld1
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> Ld1
            r9.<init>()     // Catch: java.lang.Exception -> Ld1
            java.lang.String r11 = "load=====lastUrl html..."
            r9.append(r11)     // Catch: java.lang.Exception -> Ld1
            r9.append(r2)     // Catch: java.lang.Exception -> Ld1
            java.lang.String r9 = r9.toString()     // Catch: java.lang.Exception -> Ld1
            com.mbridge.msdk.foundation.tools.SameLogTool.m21738a(r13, r9)     // Catch: java.lang.Exception -> Ld1
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
            r14.mo21439a(r10, r8)     // Catch: java.lang.Exception -> Ld1
            goto Lde
        Lad:
            java.lang.String r9 = r7.m21457a(r11)     // Catch: java.lang.Exception -> Ld1
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> Ld1
            r11.<init>()     // Catch: java.lang.Exception -> Ld1
            java.lang.String r12 = "load====== url:"
            r11.append(r12)     // Catch: java.lang.Exception -> Ld1
            r11.append(r9)     // Catch: java.lang.Exception -> Ld1
            java.lang.String r11 = r11.toString()     // Catch: java.lang.Exception -> Ld1
            com.mbridge.msdk.foundation.tools.SameLogTool.m21738a(r13, r11)     // Catch: java.lang.Exception -> Ld1
            r8.loadUrl(r9)     // Catch: java.lang.Exception -> Ld1
            goto Lde
        Lc9:
            if (r14 == 0) goto Lde
            java.lang.String r8 = "webview has destoryed"
            r14.mo21439a(r10, r8)     // Catch: java.lang.Exception -> Ld1
            goto Lde
        Ld1:
            r8 = move-exception
            r8.printStackTrace()
            if (r14 == 0) goto Lde
            java.lang.String r8 = r8.getMessage()
            r14.mo21439a(r10, r8)
        Lde:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.mbjscommon.confirmation.SecondaryConfirmationManager.m21461a(com.mbridge.msdk.mbjscommon.windvane.WindVaneWebView, java.lang.String, com.mbridge.msdk.foundation.entity.CampaignEx, android.content.Context, java.lang.String, com.mbridge.msdk.mbjscommon.confirmation.c, com.mbridge.msdk.mbjscommon.confirmation.b):void");
    }

    /* renamed from: a */
    private String m21457a(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        Uri.Builder buildUpon = Uri.parse(str).buildUpon();
        buildUpon.appendQueryParameter("dialogRenderMode", "default");
        return buildUpon.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m21472a(CampaignEx campaignEx, Context context, String str, String str2, MBAlertDialogProxyListener mBAlertDialogProxyListener) {
        MBAlertDialog mBAlertDialog = this.f31477k;
        if (mBAlertDialog != null) {
            mBAlertDialog.makeDownloadAlert(campaignEx.getAppName());
            if (context instanceof Activity) {
                Activity activity = (Activity) context;
                if (activity.isDestroyed()) {
                    C11385e.m22081a(context, campaignEx, str, str2, 4, 2);
                    m21453b();
                    return;
                } else if (!activity.isFinishing()) {
                    this.f31477k.show();
                    this.f31476j = 1;
                    m21473a(1);
                    mBAlertDialogProxyListener.m21491a(this.f31476j);
                    C11385e.m22081a(context, campaignEx, str, str2, 1, 2);
                    return;
                } else {
                    C11385e.m22081a(context, campaignEx, str, str2, 4, 2);
                    m21453b();
                    return;
                }
            }
            m21453b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m21462a(WindVaneWebView windVaneWebView, String str, CampaignEx campaignEx, Context context, String str2, MBAlertDialogProxyListener mBAlertDialogProxyListener) {
        if (windVaneWebView != null && !windVaneWebView.isDestoryed()) {
            m21463a(windVaneWebView);
            if (windVaneWebView.getParent() != null) {
                ((ViewGroup) windVaneWebView.getParent()).removeView(windVaneWebView);
            }
            this.f31477k.setContentView(windVaneWebView);
            if (context instanceof Activity) {
                Activity activity = (Activity) context;
                if (activity.isDestroyed()) {
                    C11385e.m22081a(context, campaignEx, str, str2, 4, 2);
                    m21453b();
                    return;
                } else if (!activity.isFinishing()) {
                    this.f31477k.show();
                    this.f31476j = 2;
                    m21473a(2);
                    mBAlertDialogProxyListener.m21491a(this.f31476j);
                    C11385e.m22081a(context, campaignEx, str, str2, 2, 2);
                    return;
                } else {
                    C11385e.m22081a(context, campaignEx, str, str2, 4, 2);
                    m21453b();
                    return;
                }
            }
            m21453b();
            return;
        }
        m21450b(str, campaignEx, context, str2, mBAlertDialogProxyListener);
    }

    /* renamed from: a */
    public final void m21459a(Object obj, int i) {
        ConfirmationRenderListener confirmationRenderListener;
        ConfirmationRenderListener confirmationRenderListener2;
        WindVaneWebView windVaneWebView = this.f31471e;
        if (windVaneWebView != null && windVaneWebView.getObject() != null && this.f31471e.getObject().equals(m21460a(obj)) && !this.f31479m.compareAndSet(true, true) && (confirmationRenderListener2 = this.f31473g) != null) {
            if (i == f31467b) {
                confirmationRenderListener2.mo21440a();
            } else {
                confirmationRenderListener2.mo21439a(0, "webview render error and undefault");
            }
        }
        WindVaneWebView windVaneWebView2 = this.f31472f;
        if (windVaneWebView2 == null || windVaneWebView2.getObject() == null || !this.f31472f.getObject().equals(m21460a(obj)) || this.f31480n.compareAndSet(true, true) || (confirmationRenderListener = this.f31474h) == null) {
            return;
        }
        if (i == f31467b) {
            confirmationRenderListener.mo21440a();
        } else {
            confirmationRenderListener.mo21439a(0, "webview render error and undefault");
        }
    }

    /* renamed from: a */
    public final void m21458a(Object obj, String str) {
        SameLogTool.m21738a("SecondaryConfirmationManager", "closeDialog");
        MBAlertDialog mBAlertDialog = this.f31477k;
        if (mBAlertDialog == null || !mBAlertDialog.isShowing()) {
            return;
        }
        this.f31477k.dismiss();
        this.f31477k.clear();
    }

    /* renamed from: a */
    private void m21463a(WindVaneWebView windVaneWebView) {
        if (windVaneWebView != null) {
            WindVaneCallJs.m21387a().m21385a((WebView) windVaneWebView, "webviewshow", "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public ConfirmationJsExtra m21460a(Object obj) {
        if (obj instanceof CallMethodContext) {
            Object object = ((CallMethodContext) obj).f31554a.getObject();
            if (object instanceof ConfirmationJsExtra) {
                return (ConfirmationJsExtra) object;
            }
        }
        return null;
    }

    /* renamed from: a */
    private void m21473a(int i) {
        DialogInterface$OnDismissListenerC11495a dialogInterface$OnDismissListenerC11495a = this.f31483q;
        if (dialogInterface$OnDismissListenerC11495a != null) {
            dialogInterface$OnDismissListenerC11495a.m21438a(i);
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m21469a(SecondaryConfirmationManager secondaryConfirmationManager, WindVaneWebView windVaneWebView) {
        MBAlertDialog mBAlertDialog = secondaryConfirmationManager.f31477k;
        if (mBAlertDialog != null) {
            mBAlertDialog.clear();
        }
        if (windVaneWebView != null) {
            WindVaneCallJs.m21387a().m21385a((WebView) windVaneWebView, "close", "");
        }
    }
}

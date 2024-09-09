package com.acse.ottn;

import android.accessibilityservice.AccessibilityService;
import android.accessibilityservice.AccessibilityServiceInfo;
import android.app.admin.DevicePolicyManager;
import android.os.Build;
import android.os.Handler;
import android.os.Message;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class d2 {

    /* renamed from: g  reason: collision with root package name */
    public static final String f5541g = "MyAccessibilityService";

    /* renamed from: a  reason: collision with root package name */
    public boolean f5542a;

    /* renamed from: b  reason: collision with root package name */
    public Handler f5543b;

    /* renamed from: c  reason: collision with root package name */
    public AccessibilityService f5544c;

    /* renamed from: d  reason: collision with root package name */
    public AccessibilityServiceInfo f5545d;

    /* renamed from: e  reason: collision with root package name */
    public DevicePolicyManager f5546e;

    /* renamed from: f  reason: collision with root package name */
    public q3 f5547f;

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class a implements Handler.Callback {
        public a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what == 1 && Build.VERSION.SDK_INT >= 28) {
                d2.this.f5544c.performGlobalAction(8);
            }
            return true;
        }
    }

    public d2(AccessibilityService accessibilityService) {
        this.f5544c = accessibilityService;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x004a A[Catch: all -> 0x0063, TryCatch #0 {all -> 0x0063, blocks: (B:2:0x0000, B:4:0x0023, B:9:0x0038, B:11:0x004a, B:12:0x004f), top: B:17:0x0000 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a() {
        /*
            r4 = this;
            android.accessibilityservice.AccessibilityService r0 = r4.f5544c     // Catch: java.lang.Throwable -> L63
            java.lang.String r1 = "device_policy"
            java.lang.Object r0 = r0.getSystemService(r1)     // Catch: java.lang.Throwable -> L63
            android.app.admin.DevicePolicyManager r0 = (android.app.admin.DevicePolicyManager) r0     // Catch: java.lang.Throwable -> L63
            r4.f5546e = r0     // Catch: java.lang.Throwable -> L63
            android.accessibilityservice.AccessibilityService r0 = r4.f5544c     // Catch: java.lang.Throwable -> L63
            android.accessibilityservice.AccessibilityServiceInfo r0 = r0.getServiceInfo()     // Catch: java.lang.Throwable -> L63
            r4.f5545d = r0     // Catch: java.lang.Throwable -> L63
            com.acse.ottn.q3 r0 = new com.acse.ottn.q3     // Catch: java.lang.Throwable -> L63
            android.accessibilityservice.AccessibilityService r1 = r4.f5544c     // Catch: java.lang.Throwable -> L63
            r0.<init>(r1)     // Catch: java.lang.Throwable -> L63
            r4.f5547f = r0     // Catch: java.lang.Throwable -> L63
            int r0 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Throwable -> L63
            r1 = 28
            if (r0 >= r1) goto L37
            android.app.admin.DevicePolicyManager r0 = r4.f5546e     // Catch: java.lang.Throwable -> L63
            android.content.ComponentName r1 = new android.content.ComponentName     // Catch: java.lang.Throwable -> L63
            android.accessibilityservice.AccessibilityService r2 = r4.f5544c     // Catch: java.lang.Throwable -> L63
            java.lang.Class<com.acse.ottn.j2> r3 = com.acse.ottn.j2.class
            r1.<init>(r2, r3)     // Catch: java.lang.Throwable -> L63
            boolean r0 = r0.isAdminActive(r1)     // Catch: java.lang.Throwable -> L63
            if (r0 == 0) goto L35
            goto L37
        L35:
            r0 = 0
            goto L38
        L37:
            r0 = 1
        L38:
            r4.f5542a = r0     // Catch: java.lang.Throwable -> L63
            android.accessibilityservice.AccessibilityServiceInfo r1 = r4.f5545d     // Catch: java.lang.Throwable -> L63
            int r2 = r1.eventTypes     // Catch: java.lang.Throwable -> L63
            r2 = r2 | 32
            r1.eventTypes = r2     // Catch: java.lang.Throwable -> L63
            int r2 = r1.flags     // Catch: java.lang.Throwable -> L63
            r2 = r2 | 32
            r1.flags = r2     // Catch: java.lang.Throwable -> L63
            if (r0 == 0) goto L4f
            com.acse.ottn.q3 r0 = r4.f5547f     // Catch: java.lang.Throwable -> L63
            r0.a()     // Catch: java.lang.Throwable -> L63
        L4f:
            android.accessibilityservice.AccessibilityService r0 = r4.f5544c     // Catch: java.lang.Throwable -> L63
            android.accessibilityservice.AccessibilityServiceInfo r1 = r4.f5545d     // Catch: java.lang.Throwable -> L63
            r0.setServiceInfo(r1)     // Catch: java.lang.Throwable -> L63
            android.os.Handler r0 = new android.os.Handler     // Catch: java.lang.Throwable -> L63
            com.acse.ottn.d2$a r1 = new com.acse.ottn.d2$a     // Catch: java.lang.Throwable -> L63
            r1.<init>()     // Catch: java.lang.Throwable -> L63
            r0.<init>(r1)     // Catch: java.lang.Throwable -> L63
            r4.f5543b = r0     // Catch: java.lang.Throwable -> L63
            goto L67
        L63:
            r0 = move-exception
            r0.printStackTrace()
        L67:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.acse.ottn.d2.a():void");
    }
}

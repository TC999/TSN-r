package com.bytedance.msdk.api.sr;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class f {
    private Map<String, String> ev;

    /* renamed from: c  reason: collision with root package name */
    public final String f27627c = "TTMediationSDK";

    /* renamed from: w  reason: collision with root package name */
    private String f27630w = "";
    private String xv = "";
    private String sr = "";
    private int ux = 0;

    /* renamed from: f  reason: collision with root package name */
    private String f27628f = "";

    /* renamed from: r  reason: collision with root package name */
    private String f27629r = "";

    public void c(Map<String, String> map) {
        this.ev = new HashMap();
        if (map == null || map.size() <= 0) {
            return;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (entry != null) {
                if (!f(entry.getKey())) {
                    Log.e("TTMediationSDK", "\u6d41\u91cf\u5206\u7ec4" + entry.getKey() + "\u5b57\u6bb5\u5b58\u5728\u4e0d\u5408\u6cd5\u8f93\u5165");
                } else if (f(entry.getValue())) {
                    this.ev.put(entry.getKey(), entry.getValue());
                } else {
                    Log.e("TTMediationSDK", "\u6d41\u91cf\u5206\u7ec4" + entry.getKey() + "\u5b57\u6bb5\u7684\u503c" + entry.getValue() + "\u5b58\u5728\u4e0d\u5408\u6cd5\u8f93\u5165");
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x00b1, code lost:
        if (r7 == null) goto L40;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean equals(java.lang.Object r7) {
        /*
            r6 = this;
            r0 = 1
            if (r6 != r7) goto L4
            return r0
        L4:
            r1 = 0
            if (r7 == 0) goto Lbd
            java.lang.Class r2 = r6.getClass()
            java.lang.Class r3 = r7.getClass()
            if (r2 == r3) goto L13
            goto Lbd
        L13:
            com.bytedance.msdk.api.sr.f r7 = (com.bytedance.msdk.api.sr.f) r7
            int r2 = r6.ux()
            int r3 = r7.ux()
            if (r2 != r3) goto L67
            java.lang.String r2 = r6.r()
            java.lang.String r3 = r7.r()
            boolean r2 = android.text.TextUtils.equals(r2, r3)
            if (r2 == 0) goto L67
            java.lang.String r2 = r6.w()
            java.lang.String r3 = r7.w()
            boolean r2 = android.text.TextUtils.equals(r2, r3)
            if (r2 == 0) goto L67
            java.lang.String r2 = r6.xv()
            java.lang.String r3 = r7.xv()
            boolean r2 = android.text.TextUtils.equals(r2, r3)
            if (r2 == 0) goto L67
            java.lang.String r2 = r6.sr()
            java.lang.String r3 = r7.sr()
            boolean r2 = android.text.TextUtils.equals(r2, r3)
            if (r2 == 0) goto L67
            java.lang.String r2 = r6.f()
            java.lang.String r3 = r7.f()
            boolean r2 = android.text.TextUtils.equals(r2, r3)
            if (r2 == 0) goto L67
            r2 = 1
            goto L68
        L67:
            r2 = 0
        L68:
            java.util.Map r7 = r7.c()
            java.util.Map<java.lang.String, java.lang.String> r3 = r6.ev
            if (r3 == 0) goto Laf
            if (r7 == 0) goto Laf
            int r3 = r3.size()
            int r4 = r7.size()
            if (r3 == r4) goto L7d
            goto Lb5
        L7d:
            java.util.Map<java.lang.String, java.lang.String> r3 = r6.ev
            java.util.Set r3 = r3.keySet()
            java.util.Iterator r3 = r3.iterator()
        L87:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto Lb3
            java.lang.Object r4 = r3.next()
            java.lang.String r4 = (java.lang.String) r4
            boolean r5 = android.text.TextUtils.isEmpty(r4)
            if (r5 == 0) goto L9a
            goto L87
        L9a:
            java.util.Map<java.lang.String, java.lang.String> r5 = r6.ev
            java.lang.Object r5 = r5.get(r4)
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            java.lang.Object r4 = r7.get(r4)
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            boolean r4 = android.text.TextUtils.equals(r5, r4)
            if (r4 != 0) goto L87
            goto Lb5
        Laf:
            if (r3 != 0) goto Lb5
            if (r7 != 0) goto Lb5
        Lb3:
            r7 = 1
            goto Lb6
        Lb5:
            r7 = 0
        Lb6:
            if (r2 == 0) goto Lbb
            if (r7 == 0) goto Lbb
            goto Lbc
        Lbb:
            r0 = 0
        Lbc:
            return r0
        Lbd:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.api.sr.f.equals(java.lang.Object):boolean");
    }

    @Nullable
    public String f() {
        return this.f27628f;
    }

    @Nullable
    public String r() {
        return this.f27629r;
    }

    @Nullable
    public String sr() {
        return this.sr;
    }

    public int ux() {
        return this.ux;
    }

    @Nullable
    public String w() {
        return this.f27630w;
    }

    @Nullable
    public String xv() {
        return this.xv;
    }

    public static boolean f(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.matches("[A-Za-z0-9-_]{1,100}");
    }

    public void sr(String str) {
        if (f(str)) {
            this.f27628f = str;
        } else {
            Log.e("TTMediationSDK", "\u6d41\u91cf\u5206\u7ec4gender\u5b57\u6bb5\u5b58\u5728\u4e0d\u5408\u6cd5\u8f93\u5165");
        }
    }

    public void ux(String str) {
        if (f(str)) {
            this.f27629r = str;
        } else {
            Log.e("TTMediationSDK", "\u6d41\u91cf\u5206\u7ec4user_value_group\u5b57\u6bb5\u5b58\u5728\u4e0d\u5408\u6cd5\u8f93\u5165");
        }
    }

    public void w(String str) {
        if (f(str)) {
            this.xv = str;
        } else {
            Log.e("TTMediationSDK", "\u6d41\u91cf\u5206\u7ec4channer\u5b57\u6bb5\u5b58\u5728\u4e0d\u5408\u6cd5\u8f93\u5165");
        }
    }

    public void xv(String str) {
        if (f(str)) {
            this.sr = str;
        } else {
            Log.e("TTMediationSDK", "\u6d41\u91cf\u5206\u7ec4sub_channer\u5b57\u6bb5\u5b58\u5728\u4e0d\u5408\u6cd5\u8f93\u5165");
        }
    }

    @Nullable
    public Map<String, String> c() {
        return this.ev;
    }

    public void c(String str) {
        if (f(str)) {
            this.f27630w = str;
        } else {
            Log.e("TTMediationSDK", "\u6d41\u91cf\u5206\u7ec4user_id\u5b57\u6bb5\u5b58\u5728\u4e0d\u5408\u6cd5\u8f93\u5165");
        }
    }

    public void c(int i4) {
        this.ux = i4;
    }
}

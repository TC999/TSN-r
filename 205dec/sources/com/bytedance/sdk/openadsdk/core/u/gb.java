package com.bytedance.sdk.openadsdk.core.u;

import android.text.TextUtils;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class gb {

    /* renamed from: c  reason: collision with root package name */
    private String f34675c;

    /* renamed from: f  reason: collision with root package name */
    private String f34676f;
    private double sr;
    private boolean ux;

    /* renamed from: w  reason: collision with root package name */
    private int f34677w;
    private int xv;

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    private static final class c extends com.bytedance.sdk.openadsdk.ys.w.w.bk {

        /* renamed from: c  reason: collision with root package name */
        private int f34678c;
        private double sr;

        /* renamed from: w  reason: collision with root package name */
        private int f34679w;
        private String xv;

        public c(int i4, int i5, String str, double d4) {
            this.f34678c = i4;
            this.f34679w = i5;
            this.xv = str;
            this.sr = d4;
        }

        @Override // com.bytedance.sdk.openadsdk.ys.w.w.bk
        public int c() {
            return this.f34678c;
        }

        @Override // com.bytedance.sdk.openadsdk.ys.w.w.bk
        public double sr() {
            return this.sr;
        }

        @Override // com.bytedance.sdk.openadsdk.ys.w.w.bk
        public boolean ux() {
            String str;
            return this.f34678c > 0 && this.f34679w > 0 && (str = this.xv) != null && str.length() > 0;
        }

        @Override // com.bytedance.sdk.openadsdk.ys.w.w.bk
        public int w() {
            return this.f34679w;
        }

        @Override // com.bytedance.sdk.openadsdk.ys.w.w.bk
        public String xv() {
            return this.xv;
        }
    }

    public String c() {
        return this.f34675c;
    }

    public boolean f() {
        return this.ux;
    }

    public String r() {
        return this.f34676f;
    }

    public double sr() {
        return this.sr;
    }

    public boolean ux() {
        return !TextUtils.isEmpty(this.f34675c) && this.f34677w > 0 && this.xv > 0;
    }

    public int w() {
        return this.f34677w;
    }

    public int xv() {
        return this.xv;
    }

    public void c(String str) {
        this.f34675c = str;
    }

    public void w(int i4) {
        this.xv = i4;
    }

    public void c(int i4) {
        this.f34677w = i4;
    }

    public void w(String str) {
        this.f34676f = str;
    }

    public void c(double d4) {
        this.sr = d4;
    }

    public void c(boolean z3) {
        this.ux = z3;
    }

    public static com.bytedance.sdk.openadsdk.ys.w.w.bk c(gb gbVar) {
        if (gbVar == null || !gbVar.ux()) {
            return null;
        }
        return new c(gbVar.xv(), gbVar.w(), gbVar.c(), gbVar.sr());
    }

    public static final com.bytedance.sdk.openadsdk.ys.w.w.bk c(int i4, int i5, String str, double d4) {
        return new c(i4, i5, str, d4);
    }
}

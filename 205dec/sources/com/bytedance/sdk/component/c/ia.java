package com.bytedance.sdk.component.c;

import android.text.TextUtils;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class ia {

    /* renamed from: c  reason: collision with root package name */
    public final int f29666c;
    public final String ev;

    /* renamed from: f  reason: collision with root package name */
    public final String f29667f;

    /* renamed from: r  reason: collision with root package name */
    public final String f29668r;
    public final String sr;
    public final String ux;

    /* renamed from: w  reason: collision with root package name */
    public final String f29669w;
    public final String xv;

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static final class c {

        /* renamed from: c  reason: collision with root package name */
        private String f29670c;

        /* renamed from: f  reason: collision with root package name */
        private String f29671f;

        /* renamed from: r  reason: collision with root package name */
        private String f29672r;
        private String sr;
        private String ux;

        /* renamed from: w  reason: collision with root package name */
        private String f29673w;
        private String xv;

        private c() {
        }

        public c c(String str) {
            this.f29670c = str;
            return this;
        }

        public c f(String str) {
            this.f29671f = str;
            return this;
        }

        public c r(String str) {
            this.f29672r = str;
            return this;
        }

        public c sr(String str) {
            this.sr = str;
            return this;
        }

        public c ux(String str) {
            this.ux = str;
            return this;
        }

        public c w(String str) {
            this.f29673w = str;
            return this;
        }

        public c xv(String str) {
            this.xv = str;
            return this;
        }

        public ia c() {
            return new ia(this);
        }
    }

    public static c c() {
        return new c();
    }

    public String toString() {
        return "methodName: " + this.sr + ", params: " + this.ux + ", callbackId: " + this.f29667f + ", type: " + this.xv + ", version: " + this.f29669w + ", ";
    }

    private ia(String str, int i4) {
        this.f29669w = null;
        this.xv = null;
        this.sr = null;
        this.ux = null;
        this.f29667f = str;
        this.f29668r = null;
        this.f29666c = i4;
        this.ev = null;
    }

    public static ia c(String str, int i4) {
        return new ia(str, i4);
    }

    public static boolean c(ia iaVar) {
        return iaVar == null || iaVar.f29666c != 1 || TextUtils.isEmpty(iaVar.sr) || TextUtils.isEmpty(iaVar.ux);
    }

    private ia(c cVar) {
        this.f29669w = cVar.f29670c;
        this.xv = cVar.f29673w;
        this.sr = cVar.xv;
        this.ux = cVar.sr;
        this.f29667f = cVar.ux;
        this.f29668r = cVar.f29671f;
        this.f29666c = 1;
        this.ev = cVar.f29672r;
    }
}

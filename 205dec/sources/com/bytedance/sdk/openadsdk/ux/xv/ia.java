package com.bytedance.sdk.openadsdk.ux.xv;

import com.bytedance.sdk.openadsdk.core.u.me;

/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class ia {

    /* renamed from: c  reason: collision with root package name */
    private long f36324c;
    private com.bykv.vk.openvk.component.video.api.xv.sr sr;
    private me ux;

    /* renamed from: w  reason: collision with root package name */
    private String f36325w;
    private int xv;

    /* loaded from: E:\TSN-r\205dec\6241084.dex */
    public static class c {
        private int ev;
        private int gd;

        /* renamed from: k  reason: collision with root package name */
        private int f36329k;

        /* renamed from: p  reason: collision with root package name */
        private int f36330p;

        /* renamed from: r  reason: collision with root package name */
        private int f36331r;

        /* renamed from: c  reason: collision with root package name */
        private long f36327c = 0;

        /* renamed from: w  reason: collision with root package name */
        private long f36332w = 0;
        private long xv = 0;
        private boolean sr = false;
        private int ux = 0;

        /* renamed from: f  reason: collision with root package name */
        private int f36328f = 0;

        /* renamed from: a  reason: collision with root package name */
        private boolean f36326a = false;

        public boolean a() {
            return this.f36326a;
        }

        public boolean bk() {
            return this.sr;
        }

        public long c() {
            return this.f36327c;
        }

        public int ev() {
            long j4 = this.xv;
            if (j4 <= 0) {
                return 0;
            }
            return Math.min((int) ((this.f36327c * 100) / j4), 100);
        }

        public int f() {
            return this.f36331r;
        }

        public int gd() {
            return this.gd;
        }

        public int k() {
            return this.f36329k;
        }

        public int p() {
            return this.f36330p;
        }

        public int r() {
            return this.ev;
        }

        public int sr() {
            return this.ux;
        }

        public int ux() {
            return this.f36328f;
        }

        public long w() {
            return this.f36332w;
        }

        public long xv() {
            return this.xv;
        }

        public void c(long j4) {
            this.f36327c = j4;
        }

        public void f(int i4) {
            this.f36329k = i4;
        }

        public void sr(int i4) {
            this.ev = i4;
        }

        public void ux(int i4) {
            this.gd = i4;
        }

        public void w(long j4) {
            this.f36332w = j4;
        }

        public void xv(long j4) {
            this.xv = j4;
        }

        public void c(int i4) {
            this.ux = i4;
        }

        public void w(int i4) {
            this.f36328f = i4;
        }

        public void xv(int i4) {
            this.f36331r = i4;
        }

        public void c(boolean z3) {
            this.f36326a = z3;
        }

        public void w(boolean z3) {
            this.sr = z3;
        }
    }

    public ia(long j4, String str, int i4, com.bykv.vk.openvk.component.video.api.xv.sr srVar, me meVar) {
        this.f36324c = j4;
        this.f36325w = str;
        this.xv = i4;
        this.sr = srVar;
        this.ux = meVar;
    }

    public long c() {
        return this.f36324c;
    }

    public com.bykv.vk.openvk.component.video.api.xv.sr sr() {
        return this.sr;
    }

    public me ux() {
        return this.ux;
    }

    public String w() {
        return this.f36325w;
    }

    public int xv() {
        return this.xv;
    }
}

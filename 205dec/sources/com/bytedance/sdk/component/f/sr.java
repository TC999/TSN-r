package com.bytedance.sdk.component.f;

import android.content.Context;
import com.stub.StubApp;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class sr {

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static class c {

        /* renamed from: c  reason: collision with root package name */
        private volatile Context f29788c;
        private volatile int ev;

        /* renamed from: f  reason: collision with root package name */
        private volatile com.bytedance.sdk.component.f.c.xv f29789f;

        /* renamed from: r  reason: collision with root package name */
        private volatile boolean f29790r;
        private volatile boolean sr;
        private volatile boolean ux;

        /* renamed from: w  reason: collision with root package name */
        private volatile String f29791w;
        private volatile int xv;

        private com.bytedance.sdk.component.f.c xv() {
            com.bytedance.sdk.component.f.c c4 = com.bytedance.sdk.component.f.w.c.c.c(this.f29788c, this.f29791w, this.ux, this.ev);
            this.f29790r = true;
            if (c4 == null) {
                this.f29790r = false;
                return w();
            }
            return c4;
        }

        public c c(Context context) {
            if (context == null) {
                return this;
            }
            this.f29788c = StubApp.getOrigApplicationContext(context.getApplicationContext());
            xv.c(this.f29788c);
            return this;
        }

        public c w(boolean z3) {
            this.ux = z3;
            return this;
        }

        public c w(int i4) {
            this.ev = i4;
            return this;
        }

        private com.bytedance.sdk.component.f.c w() {
            if (this.ux) {
                return com.bytedance.sdk.component.f.xv.c.c.w(this.f29791w);
            }
            return com.bytedance.sdk.component.f.xv.w.w.c(this.f29791w, this.f29788c);
        }

        public c c(String str) {
            this.f29791w = str;
            return this;
        }

        public c c(int i4) {
            this.xv = i4;
            return this;
        }

        public c c(boolean z3) {
            this.sr = z3;
            return this;
        }

        public com.bytedance.sdk.component.f.c c() {
            com.bytedance.sdk.component.f.c.w xv;
            if (this.xv != 2) {
                xv = w();
            } else {
                xv = xv();
            }
            if (this.sr) {
                com.bytedance.sdk.component.f.c.w wVar = new com.bytedance.sdk.component.f.c.w(xv);
                wVar.c(new com.bytedance.sdk.component.f.c.c());
                xv = wVar;
            }
            if (this.f29789f != null) {
                com.bytedance.sdk.component.f.c.w wVar2 = new com.bytedance.sdk.component.f.c.w(xv);
                wVar2.c(this.f29789f);
                return wVar2;
            }
            return xv;
        }
    }
}

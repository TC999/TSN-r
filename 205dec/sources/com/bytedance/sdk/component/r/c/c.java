package com.bytedance.sdk.component.r.c;

import android.content.Context;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class c implements ux {

    /* renamed from: a  reason: collision with root package name */
    private AtomicBoolean f30033a;
    private int bk;

    /* renamed from: c  reason: collision with root package name */
    private f f30034c;
    private com.bytedance.sdk.component.r.w.sr.w.c ev;

    /* renamed from: f  reason: collision with root package name */
    private com.bytedance.sdk.component.r.w.sr.w.c f30035f;
    private com.bytedance.sdk.component.r.w.sr.w.c gd;

    /* renamed from: k  reason: collision with root package name */
    private sr f30036k;

    /* renamed from: p  reason: collision with root package name */
    private boolean f30037p;

    /* renamed from: r  reason: collision with root package name */
    private com.bytedance.sdk.component.r.w.sr.w.c f30038r;
    private Context sr;

    /* renamed from: t  reason: collision with root package name */
    private int f30039t;
    private com.bytedance.sdk.component.r.w.sr.w.c ux;

    /* renamed from: w  reason: collision with root package name */
    private k f30040w;
    private String xv;

    /* renamed from: com.bytedance.sdk.component.r.c.c$c  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static class C0450c {

        /* renamed from: a  reason: collision with root package name */
        private String f30041a;
        private Context bk;

        /* renamed from: c  reason: collision with root package name */
        private k f30042c;
        private f ev;

        /* renamed from: f  reason: collision with root package name */
        private boolean f30043f;

        /* renamed from: r  reason: collision with root package name */
        private sr f30046r;
        private com.bytedance.sdk.component.r.w.sr.w.c sr;
        private com.bytedance.sdk.component.r.w.sr.w.c ux;

        /* renamed from: w  reason: collision with root package name */
        private com.bytedance.sdk.component.r.w.sr.w.c f30047w;
        private com.bytedance.sdk.component.r.w.sr.w.c xv;
        private final AtomicBoolean gd = new AtomicBoolean(false);

        /* renamed from: p  reason: collision with root package name */
        private int f30045p = 5000;

        /* renamed from: k  reason: collision with root package name */
        private int f30044k = 10;

        public C0450c c(Context context) {
            this.bk = context;
            return this;
        }

        public C0450c w(boolean z3) {
            this.f30043f = z3;
            return this;
        }

        public C0450c xv(com.bytedance.sdk.component.r.w.sr.w.c cVar) {
            this.sr = cVar;
            return this;
        }

        public C0450c c(String str) {
            this.f30041a = str;
            return this;
        }

        public C0450c w(com.bytedance.sdk.component.r.w.sr.w.c cVar) {
            this.xv = cVar;
            return this;
        }

        public C0450c c(boolean z3) {
            this.gd.set(z3);
            return this;
        }

        public C0450c c(f fVar) {
            this.ev = fVar;
            return this;
        }

        public C0450c c(sr srVar) {
            this.f30046r = srVar;
            return this;
        }

        public C0450c c(com.bytedance.sdk.component.r.w.sr.w.c cVar) {
            this.f30047w = cVar;
            return this;
        }

        public C0450c c(k kVar) {
            this.f30042c = kVar;
            return this;
        }

        public c c() {
            c cVar = new c();
            cVar.f30040w = this.f30042c;
            cVar.ux = this.f30047w;
            cVar.f30035f = this.xv;
            cVar.f30038r = this.sr;
            cVar.ev = this.ux;
            cVar.f30037p = this.f30043f;
            cVar.f30036k = this.f30046r;
            cVar.f30034c = this.ev;
            cVar.f30033a = this.gd;
            cVar.xv = this.f30041a;
            cVar.sr = this.bk;
            cVar.f30039t = this.f30044k;
            cVar.bk = this.f30045p;
            return cVar;
        }
    }

    @Override // com.bytedance.sdk.component.r.c.ux
    public com.bytedance.sdk.component.r.w.sr.w.c ev() {
        return this.f30035f;
    }

    @Override // com.bytedance.sdk.component.r.c.ux
    public com.bytedance.sdk.component.r.w.sr.w.c f() {
        return this.gd;
    }

    @Override // com.bytedance.sdk.component.r.c.ux
    public com.bytedance.sdk.component.r.w.sr.w.c gd() {
        return this.f30038r;
    }

    @Override // com.bytedance.sdk.component.r.c.ux
    public Context getContext() {
        return this.sr;
    }

    @Override // com.bytedance.sdk.component.r.c.ux
    public boolean k() {
        return this.f30037p;
    }

    @Override // com.bytedance.sdk.component.r.c.ux
    public k p() {
        return this.f30040w;
    }

    @Override // com.bytedance.sdk.component.r.c.ux
    public com.bytedance.sdk.component.r.w.sr.w.c r() {
        return this.ux;
    }

    @Override // com.bytedance.sdk.component.r.c.ux
    public String ux() {
        return this.xv;
    }

    private c() {
        this.f30033a = new AtomicBoolean(false);
        this.bk = 200;
        this.f30039t = 10;
    }

    @Override // com.bytedance.sdk.component.r.c.ux
    public sr sr() {
        return this.f30036k;
    }

    @Override // com.bytedance.sdk.component.r.c.ux
    public boolean xv() {
        return this.f30033a.get();
    }

    @Override // com.bytedance.sdk.component.r.c.ux
    public f w() {
        return this.f30034c;
    }

    @Override // com.bytedance.sdk.component.r.c.ux
    public com.bytedance.sdk.component.r.w.sr.w.c c() {
        return this.ev;
    }

    @Override // com.bytedance.sdk.component.r.c.ux
    public void c(f fVar) {
        this.f30034c = fVar;
    }

    @Override // com.bytedance.sdk.component.r.c.ux
    public void c(boolean z3) {
        this.f30033a.set(z3);
    }
}

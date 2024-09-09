package com.bytedance.msdk.api.sr.c.r;

import androidx.annotation.NonNull;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class k {

    /* renamed from: a  reason: collision with root package name */
    public final int f27511a;
    public final int bk;

    /* renamed from: c  reason: collision with root package name */
    public final int f27512c;
    public final int ev;

    /* renamed from: f  reason: collision with root package name */
    public final int f27513f;
    public final int gd;

    /* renamed from: k  reason: collision with root package name */
    public final int f27514k;

    /* renamed from: p  reason: collision with root package name */
    public final int f27515p;

    /* renamed from: r  reason: collision with root package name */
    public final int f27516r;
    public final int sr;
    @NonNull

    /* renamed from: t  reason: collision with root package name */
    public final Map<String, Integer> f27517t;
    public final int ux;

    /* renamed from: w  reason: collision with root package name */
    public final int f27518w;
    public final int xv;

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        protected int f27519a;
        protected int bk;

        /* renamed from: c  reason: collision with root package name */
        protected int f27520c;
        protected int ev;

        /* renamed from: f  reason: collision with root package name */
        protected int f27521f;
        protected int gd;

        /* renamed from: k  reason: collision with root package name */
        protected int f27522k;

        /* renamed from: p  reason: collision with root package name */
        protected int f27523p;

        /* renamed from: r  reason: collision with root package name */
        protected int f27524r;
        protected int sr;
        @NonNull

        /* renamed from: t  reason: collision with root package name */
        protected Map<String, Integer> f27525t;
        protected int ux;

        /* renamed from: w  reason: collision with root package name */
        protected int f27526w;
        protected int xv;

        public c(int i4) {
            this.f27525t = Collections.emptyMap();
            this.f27520c = i4;
            this.f27525t = new HashMap();
        }

        @NonNull
        public c c(int i4) {
            this.f27526w = i4;
            return this;
        }

        @NonNull
        public c ev(int i4) {
            this.f27524r = i4;
            return this;
        }

        @NonNull
        public c f(int i4) {
            this.f27521f = i4;
            return this;
        }

        @NonNull
        public c gd(int i4) {
            this.xv = i4;
            return this;
        }

        @NonNull
        public c k(int i4) {
            this.ux = i4;
            return this;
        }

        @NonNull
        public c p(int i4) {
            this.sr = i4;
            return this;
        }

        @NonNull
        public c r(int i4) {
            this.ev = i4;
            return this;
        }

        @NonNull
        public c sr(int i4) {
            this.f27522k = i4;
            return this;
        }

        @NonNull
        public c ux(int i4) {
            this.f27519a = i4;
            return this;
        }

        @NonNull
        public c w(int i4) {
            this.gd = i4;
            return this;
        }

        @NonNull
        public c xv(int i4) {
            this.f27523p = i4;
            return this;
        }

        @NonNull
        public c c(Map<String, Integer> map) {
            this.f27525t = new HashMap(map);
            return this;
        }

        @NonNull
        public k c() {
            return new k(this);
        }
    }

    protected k(@NonNull c cVar) {
        this.f27512c = cVar.f27520c;
        this.f27518w = cVar.f27526w;
        this.xv = cVar.xv;
        this.sr = cVar.sr;
        this.ux = cVar.ux;
        this.f27513f = cVar.f27521f;
        this.f27516r = cVar.f27524r;
        this.ev = cVar.ev;
        this.f27517t = cVar.f27525t;
        this.gd = cVar.f27523p;
        this.f27515p = cVar.f27522k;
        this.f27514k = cVar.f27519a;
        this.f27511a = cVar.gd;
        this.bk = cVar.bk;
    }

    public static k c(com.bytedance.sdk.openadsdk.mediation.ad.c.w.c.sr srVar) {
        if (srVar != null) {
            c cVar = new c(srVar.c());
            cVar.c(srVar.w()).p(srVar.sr()).gd(srVar.xv()).xv(srVar.gd()).sr(srVar.p()).ux(srVar.k()).f(srVar.f()).ev(srVar.r()).k(srVar.ux()).w(srVar.a()).r(srVar.ev()).c(srVar.bk());
            return cVar.c();
        }
        return null;
    }

    public static com.bytedance.msdk.adapter.xv.w.c c(k kVar) {
        if (kVar != null) {
            return new com.bytedance.msdk.adapter.xv.w.c(kVar);
        }
        return null;
    }
}

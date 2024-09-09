package com.bytedance.sdk.component.w.c;

import android.os.Bundle;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.bytedance.sdk.component.xv.w.ba;
import com.bytedance.sdk.component.xv.w.j;
import com.bytedance.sdk.component.xv.w.u;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class a extends ev implements Cloneable {
    static final List<bk> ev = com.bytedance.sdk.component.w.c.w.p.c(bk.HTTP_2, bk.HTTP_1_1);

    /* renamed from: a  reason: collision with root package name */
    public Bundle f30358a;

    /* renamed from: c  reason: collision with root package name */
    public List<gd> f30359c;

    /* renamed from: f  reason: collision with root package name */
    public long f30360f;
    public List<bk> gd;

    /* renamed from: k  reason: collision with root package name */
    public j.c f30361k;

    /* renamed from: p  reason: collision with root package name */
    public Set<String> f30362p;

    /* renamed from: r  reason: collision with root package name */
    public TimeUnit f30363r;
    public long sr;
    public TimeUnit ux;

    /* renamed from: w  reason: collision with root package name */
    public long f30364w;
    public TimeUnit xv;

    public a() {
        this(new c());
    }

    public sr c() {
        return null;
    }

    public w c(t tVar) {
        return null;
    }

    public boolean c(String str, boolean z3) {
        return true;
    }

    public c w() {
        return new c(this);
    }

    public a(c cVar) {
        this.f30364w = cVar.f30370w;
        this.sr = cVar.sr;
        this.f30360f = cVar.f30366f;
        this.xv = cVar.xv;
        this.ux = cVar.ux;
        this.f30363r = cVar.f30369r;
        this.f30359c = cVar.f30365c;
        this.gd = cVar.ev;
        this.f30362p = cVar.gd;
    }

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static final class c {

        /* renamed from: c  reason: collision with root package name */
        public final List<gd> f30365c;
        List<bk> ev;

        /* renamed from: f  reason: collision with root package name */
        public long f30366f;
        public Set<String> gd;

        /* renamed from: k  reason: collision with root package name */
        private j.c f30367k;

        /* renamed from: p  reason: collision with root package name */
        public Bundle f30368p;

        /* renamed from: r  reason: collision with root package name */
        public TimeUnit f30369r;
        public long sr;
        public TimeUnit ux;

        /* renamed from: w  reason: collision with root package name */
        public long f30370w;
        public TimeUnit xv;

        public c() {
            this.f30365c = new ArrayList();
            this.f30370w = ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT;
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            this.xv = timeUnit;
            this.sr = ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT;
            this.ux = timeUnit;
            this.f30366f = ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT;
            this.f30369r = timeUnit;
            if (com.bytedance.sdk.component.w.c.c.c.c().w()) {
                this.f30367k = new j.c();
            }
        }

        public c c(long j4, TimeUnit timeUnit) {
            j.c cVar;
            this.f30370w = j4;
            this.xv = timeUnit;
            if (com.bytedance.sdk.component.w.c.c.c.c().w() && (cVar = this.f30367k) != null) {
                cVar.c(this.f30370w, timeUnit);
            }
            return this;
        }

        public c w(long j4, TimeUnit timeUnit) {
            j.c cVar;
            this.sr = j4;
            this.ux = timeUnit;
            if (com.bytedance.sdk.component.w.c.c.c.c().w() && (cVar = this.f30367k) != null) {
                cVar.w(this.sr, timeUnit);
            }
            return this;
        }

        public c xv(long j4, TimeUnit timeUnit) {
            j.c cVar;
            this.f30366f = j4;
            this.f30369r = timeUnit;
            if (com.bytedance.sdk.component.w.c.c.c.c().w() && (cVar = this.f30367k) != null) {
                cVar.xv(this.f30366f, timeUnit);
            }
            return this;
        }

        public c c(final gd gdVar) {
            j.c cVar;
            this.f30365c.add(gdVar);
            if (com.bytedance.sdk.component.w.c.c.c.c().w() && (cVar = this.f30367k) != null) {
                cVar.c(new u() { // from class: com.bytedance.sdk.component.w.c.a.c.1
                    @Override // com.bytedance.sdk.component.xv.w.u
                    public ba c(u.c cVar2) throws IOException {
                        return ((com.bytedance.sdk.component.w.c.c.c.f) gdVar.c(new com.bytedance.sdk.component.w.c.c.c.w(cVar2))).f30383c;
                    }
                });
            }
            return this;
        }

        public c c(Set<String> set) {
            this.gd = set;
            j.c cVar = this.f30367k;
            if (cVar != null) {
                cVar.c(set);
            }
            return this;
        }

        public c(String str) {
            this.f30365c = new ArrayList();
            this.f30370w = ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT;
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            this.xv = timeUnit;
            this.sr = ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT;
            this.ux = timeUnit;
            this.f30366f = ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT;
            this.f30369r = timeUnit;
            this.ev = a.ev;
            if (com.bytedance.sdk.component.w.c.c.c.c().w()) {
                this.f30367k = new j.c();
            }
        }

        public c c(List<bk> list) {
            ArrayList arrayList = new ArrayList(list);
            if (arrayList.contains(bk.HTTP_1_1)) {
                if (!arrayList.contains(bk.HTTP_1_0)) {
                    if (!arrayList.contains(null)) {
                        arrayList.remove(bk.SPDY_3);
                        this.ev = Collections.unmodifiableList(arrayList);
                        return this;
                    }
                    throw new IllegalArgumentException("protocols must not contain null");
                }
                throw new IllegalArgumentException("protocols must not contain http/1.0: " + arrayList);
            }
            throw new IllegalArgumentException("protocols doesn't contain http/1.1: " + arrayList);
        }

        public c(a aVar) {
            this.f30365c = new ArrayList();
            this.f30370w = ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT;
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            this.xv = timeUnit;
            this.sr = ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT;
            this.ux = timeUnit;
            this.f30366f = ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT;
            this.f30369r = timeUnit;
            this.f30370w = aVar.f30364w;
            this.xv = aVar.xv;
            this.sr = aVar.sr;
            this.ux = aVar.ux;
            this.f30366f = aVar.f30360f;
            this.f30369r = aVar.f30363r;
            this.ev = aVar.gd;
            this.gd = aVar.f30362p;
            if (com.bytedance.sdk.component.w.c.c.c.c().w()) {
                this.f30367k = aVar.f30361k;
            }
            j.c cVar = this.f30367k;
            if (cVar != null) {
                cVar.ls = (int) aVar.f30364w;
                cVar.f31052y = aVar.xv;
                cVar.gb = (int) aVar.sr;
                cVar.eq = aVar.ux;
                cVar.f31044n = (int) aVar.f30360f;
                cVar.me = aVar.f30363r;
                cVar.ba = aVar.f30362p;
                cVar.f31053z = aVar.f30358a;
            }
        }

        public c c(Bundle bundle) {
            this.f30368p = bundle;
            j.c cVar = this.f30367k;
            if (cVar != null) {
                cVar.f31053z = bundle;
            }
            return this;
        }

        public a c() {
            if (com.bytedance.sdk.component.w.c.c.c.c().w()) {
                return com.bytedance.sdk.component.w.c.c.c.c(this.f30367k);
            }
            return com.bytedance.sdk.component.w.c.c.c.c(this);
        }
    }

    public a(j.c cVar) {
        this.f30364w = cVar.ls;
        this.sr = cVar.gb;
        this.f30360f = cVar.f31044n;
        this.xv = cVar.f31052y;
        this.ux = cVar.eq;
        this.f30363r = cVar.me;
        this.f30362p = cVar.ba;
        this.f30361k = cVar;
    }
}

package com.bytedance.sdk.openadsdk.core.u;

import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.core.w.sr;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class u implements com.bytedance.sdk.component.adexpress.xv {

    /* renamed from: a  reason: collision with root package name */
    public final String f34826a;
    public final String bk;

    /* renamed from: c  reason: collision with root package name */
    public final float f34827c;
    public final int ev;

    /* renamed from: f  reason: collision with root package name */
    public final long f34828f;
    public SparseArray<sr.c> fp;
    private JSONObject fz;
    public final int gd;
    public String ia;

    /* renamed from: k  reason: collision with root package name */
    public final String f34829k;

    /* renamed from: p  reason: collision with root package name */
    public final int f34830p;

    /* renamed from: r  reason: collision with root package name */
    public final int f34831r;

    /* renamed from: s  reason: collision with root package name */
    public int f34832s;
    public final float sr;

    /* renamed from: t  reason: collision with root package name */
    public final String f34833t;
    public final long ux;

    /* renamed from: w  reason: collision with root package name */
    public final float f34834w;
    public final float xv;
    public final boolean ys;

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        private String f34835a;
        private String bk;
        private int ev;

        /* renamed from: f  reason: collision with root package name */
        private float f34837f;
        private boolean fp;
        private int gd;
        private JSONObject ia;

        /* renamed from: k  reason: collision with root package name */
        private int f34838k;

        /* renamed from: p  reason: collision with root package name */
        private int f34839p;

        /* renamed from: r  reason: collision with root package name */
        private float f34840r;

        /* renamed from: s  reason: collision with root package name */
        private String f34841s;
        private float sr;

        /* renamed from: t  reason: collision with root package name */
        private String f34842t;
        private float ux;

        /* renamed from: w  reason: collision with root package name */
        private long f34843w;
        private long xv;
        private String ys;

        /* renamed from: c  reason: collision with root package name */
        protected SparseArray<sr.c> f34836c = new SparseArray<>();
        private int fz = -1;

        public c c(boolean z3) {
            this.fp = z3;
            return this;
        }

        public c sr(float f4) {
            this.f34840r = f4;
            return this;
        }

        public c ux(String str) {
            this.f34841s = str;
            return this;
        }

        public c w(long j4) {
            this.xv = j4;
            return this;
        }

        public c xv(float f4) {
            this.f34837f = f4;
            return this;
        }

        public c c(long j4) {
            this.f34843w = j4;
            return this;
        }

        public c sr(int i4) {
            this.f34838k = i4;
            return this;
        }

        public c ux(int i4) {
            this.fz = i4;
            return this;
        }

        public c w(float f4) {
            this.ux = f4;
            return this;
        }

        public c xv(int i4) {
            this.f34839p = i4;
            return this;
        }

        public c c(float f4) {
            this.sr = f4;
            return this;
        }

        public c sr(String str) {
            this.ys = str;
            return this;
        }

        public c w(int i4) {
            this.gd = i4;
            return this;
        }

        public c xv(String str) {
            this.f34842t = str;
            return this;
        }

        public c c(int i4) {
            this.ev = i4;
            return this;
        }

        public c w(String str) {
            this.bk = str;
            return this;
        }

        public c c(String str) {
            this.f34835a = str;
            return this;
        }

        public c c(SparseArray<sr.c> sparseArray) {
            this.f34836c = sparseArray;
            return this;
        }

        public c c(JSONObject jSONObject) {
            this.ia = jSONObject;
            return this;
        }

        public u c() {
            return new u(this);
        }
    }

    public JSONObject c() {
        if (this.fz == null) {
            this.fz = new JSONObject();
        }
        return this.fz;
    }

    private u(c cVar) {
        this.f34832s = -1;
        this.f34827c = cVar.f34840r;
        this.f34834w = cVar.f34837f;
        this.xv = cVar.ux;
        this.sr = cVar.sr;
        this.ux = cVar.xv;
        this.f34828f = cVar.f34843w;
        this.f34831r = cVar.ev;
        this.ev = cVar.gd;
        this.gd = cVar.f34839p;
        this.f34830p = cVar.f34838k;
        this.f34829k = cVar.f34835a;
        this.fp = cVar.f34836c;
        this.ys = cVar.fp;
        this.fz = cVar.ia;
        this.f34826a = cVar.bk;
        this.bk = cVar.f34842t;
        this.f34833t = cVar.ys;
        this.ia = cVar.f34841s;
        this.f34832s = cVar.fz;
    }
}

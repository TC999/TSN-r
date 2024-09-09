package com.bytedance.sdk.openadsdk.core.u;

import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.core.w.sr;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class ev {

    /* renamed from: a  reason: collision with root package name */
    private final int f34637a;
    private final int bk;

    /* renamed from: c  reason: collision with root package name */
    private final int[] f34638c;
    private final float ev;

    /* renamed from: f  reason: collision with root package name */
    private final float f34639f;
    private final float fp;
    private final String fz;
    private String gb;
    private final long gd;

    /* renamed from: i  reason: collision with root package name */
    private final String f34640i;
    private final int ia;

    /* renamed from: j  reason: collision with root package name */
    private int f34641j;

    /* renamed from: k  reason: collision with root package name */
    private final int f34642k;
    private int ls;

    /* renamed from: n  reason: collision with root package name */
    private int f34643n;

    /* renamed from: p  reason: collision with root package name */
    private final long f34644p;

    /* renamed from: q  reason: collision with root package name */
    private SparseArray<sr.c> f34645q;

    /* renamed from: r  reason: collision with root package name */
    private final float f34646r;

    /* renamed from: s  reason: collision with root package name */
    private final String f34647s;
    private final int[] sr;

    /* renamed from: t  reason: collision with root package name */
    private final float f34648t;

    /* renamed from: u  reason: collision with root package name */
    private final String f34649u;
    private final float ux;

    /* renamed from: w  reason: collision with root package name */
    private final int[] f34650w;
    private final int[] xv;
    private final int ys;

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        private int[] f34651a;
        private int[] bk;

        /* renamed from: c  reason: collision with root package name */
        float f34652c;
        private String fz;
        private String gb;

        /* renamed from: i  reason: collision with root package name */
        private String f34654i;
        private SparseArray<sr.c> ia;

        /* renamed from: k  reason: collision with root package name */
        private int[] f34656k;

        /* renamed from: p  reason: collision with root package name */
        private int[] f34658p;

        /* renamed from: q  reason: collision with root package name */
        private String f34659q;

        /* renamed from: s  reason: collision with root package name */
        private int f34661s;

        /* renamed from: u  reason: collision with root package name */
        private String f34663u;

        /* renamed from: w  reason: collision with root package name */
        int f34664w;
        float xv;
        private long sr = -1;
        private long ux = -1;

        /* renamed from: f  reason: collision with root package name */
        private float f34653f = -1.0f;

        /* renamed from: r  reason: collision with root package name */
        private float f34660r = -1.0f;
        private float ev = -1.0f;
        private float gd = -1.0f;

        /* renamed from: t  reason: collision with root package name */
        private int f34662t = -1;
        private int ys = -1;
        private int fp = -1024;

        /* renamed from: j  reason: collision with root package name */
        private int f34655j = -1;
        private int ls = -1;

        /* renamed from: n  reason: collision with root package name */
        private int f34657n = -1;

        public c c(float f4) {
            this.f34652c = f4;
            return this;
        }

        public c ev(int i4) {
            this.f34657n = i4;
            return this;
        }

        public c f(float f4) {
            this.gd = f4;
            return this;
        }

        public c r(int i4) {
            this.ls = i4;
            return this;
        }

        public c sr(float f4) {
            this.f34660r = f4;
            return this;
        }

        public c ux(float f4) {
            this.ev = f4;
            return this;
        }

        public c w(float f4) {
            this.xv = f4;
            return this;
        }

        public c xv(float f4) {
            this.f34653f = f4;
            return this;
        }

        public c c(int i4) {
            this.f34664w = i4;
            return this;
        }

        public c f(int i4) {
            this.f34655j = i4;
            return this;
        }

        public c sr(int[] iArr) {
            this.bk = iArr;
            return this;
        }

        public c ux(int i4) {
            this.fp = i4;
            return this;
        }

        public c w(int i4) {
            this.f34661s = i4;
            return this;
        }

        public c xv(int[] iArr) {
            this.f34651a = iArr;
            return this;
        }

        public c c(SparseArray<sr.c> sparseArray) {
            this.ia = sparseArray;
            return this;
        }

        public c sr(int i4) {
            this.ys = i4;
            return this;
        }

        public c ux(String str) {
            this.gb = str;
            return this;
        }

        public c w(long j4) {
            this.ux = j4;
            return this;
        }

        public c xv(int i4) {
            this.f34662t = i4;
            return this;
        }

        public c c(long j4) {
            this.sr = j4;
            return this;
        }

        public c sr(String str) {
            this.f34659q = str;
            return this;
        }

        public c w(int[] iArr) {
            this.f34656k = iArr;
            return this;
        }

        public c xv(String str) {
            this.f34654i = str;
            return this;
        }

        public c c(int[] iArr) {
            this.f34658p = iArr;
            return this;
        }

        public c w(String str) {
            this.f34663u = str;
            return this;
        }

        public c c(String str) {
            this.fz = str;
            return this;
        }

        public ev c() {
            return new ev(this);
        }
    }

    public JSONObject c() {
        JSONObject jSONObject = new JSONObject();
        try {
            int[] iArr = this.f34638c;
            if (iArr != null && iArr.length == 2) {
                jSONObject.putOpt("ad_x", Integer.valueOf(iArr[0])).putOpt("ad_y", Integer.valueOf(this.f34638c[1]));
            }
            int[] iArr2 = this.f34650w;
            if (iArr2 != null && iArr2.length == 2) {
                jSONObject.putOpt("width", Integer.valueOf(iArr2[0])).putOpt("height", Integer.valueOf(this.f34650w[1]));
            }
            int[] iArr3 = this.xv;
            if (iArr3 != null && iArr3.length == 2) {
                jSONObject.putOpt("button_x", Integer.valueOf(iArr3[0])).putOpt("button_y", Integer.valueOf(this.xv[1]));
            }
            int[] iArr4 = this.sr;
            if (iArr4 != null && iArr4.length == 2) {
                jSONObject.putOpt("button_width", Integer.valueOf(iArr4[0])).putOpt("button_height", Integer.valueOf(this.sr[1]));
            }
            JSONObject jSONObject2 = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            if (this.f34645q != null) {
                for (int i4 = 0; i4 < this.f34645q.size(); i4++) {
                    sr.c valueAt = this.f34645q.valueAt(i4);
                    if (valueAt != null) {
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject3.putOpt("force", Double.valueOf(valueAt.xv)).putOpt("mr", Double.valueOf(valueAt.f35368w)).putOpt("phase", Integer.valueOf(valueAt.f35367c)).putOpt("ts", Long.valueOf(valueAt.sr));
                        jSONArray.put(jSONObject3);
                    }
                }
            }
            jSONObject2.putOpt("ftc", Integer.valueOf(this.ia)).putOpt("info", jSONArray);
            jSONObject.putOpt("down_x", Float.toString(this.ux)).putOpt("down_y", Float.toString(this.f34639f)).putOpt("up_x", Float.toString(this.f34646r)).putOpt("up_y", Float.toString(this.ev)).putOpt("down_time", Long.valueOf(this.gd)).putOpt("up_time", Long.valueOf(this.f34644p)).putOpt("toolType", Integer.valueOf(this.f34642k)).putOpt("deviceId", Integer.valueOf(this.f34637a)).putOpt("source", Integer.valueOf(this.bk)).putOpt("density", Float.valueOf(this.f34648t)).putOpt("densityDpi", Integer.valueOf(this.ys)).putOpt("scaleDensity", Float.valueOf(this.fp)).putOpt("ft", jSONObject2).putOpt("click_area_type", this.f34647s).putOpt("areaType", this.fz).putOpt("rectInfo", this.f34640i).putOpt("click_area_id", this.f34649u);
            int i5 = this.f34641j;
            if (i5 != -1) {
                jSONObject.putOpt("if_shake", Integer.valueOf(i5));
            }
            int i6 = this.ls;
            if (i6 != -1) {
                jSONObject.putOpt("if_twist", Integer.valueOf(i6));
            }
            int i7 = this.f34643n;
            if (i7 != -1) {
                jSONObject.putOpt("dpa_position", Integer.valueOf(i7)).putOpt("dpa_pid", this.gb);
            }
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    private ev(c cVar) {
        this.ls = -1;
        this.f34643n = -1;
        this.f34638c = cVar.f34656k;
        this.f34650w = cVar.f34651a;
        this.sr = cVar.bk;
        this.xv = cVar.f34658p;
        this.ux = cVar.gd;
        this.f34639f = cVar.ev;
        this.f34646r = cVar.f34660r;
        this.ev = cVar.f34653f;
        this.gd = cVar.ux;
        this.f34644p = cVar.sr;
        this.f34642k = cVar.f34662t;
        this.f34637a = cVar.ys;
        this.bk = cVar.fp;
        this.f34648t = cVar.f34652c;
        this.f34647s = cVar.fz;
        this.fz = cVar.f34663u;
        this.f34640i = cVar.f34659q;
        this.f34649u = cVar.f34654i;
        this.ys = cVar.f34664w;
        this.fp = cVar.xv;
        this.ia = cVar.f34661s;
        this.f34645q = cVar.ia;
        this.f34641j = cVar.f34655j;
        this.ls = cVar.ls;
        this.gb = cVar.gb;
        this.f34643n = cVar.f34657n;
    }
}

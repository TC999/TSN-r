package com.bytedance.msdk.api.sr;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.msdk.api.sr.ev;
import com.bytedance.msdk.api.sr.k;
import com.bytedance.msdk.api.sr.sr;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private boolean f27495a;
    private JSONObject bk;

    /* renamed from: c  reason: collision with root package name */
    private String f27496c;
    private sr ev;

    /* renamed from: f  reason: collision with root package name */
    private k f27497f;
    private ValueSet fp;
    private f gd;
    private boolean ia;

    /* renamed from: k  reason: collision with root package name */
    private boolean f27498k;

    /* renamed from: p  reason: collision with root package name */
    private Map<String, Object> f27499p;

    /* renamed from: r  reason: collision with root package name */
    private ev f27500r;
    private String sr;

    /* renamed from: t  reason: collision with root package name */
    private fp f27501t;
    private boolean ux;

    /* renamed from: w  reason: collision with root package name */
    private String f27502w;
    private boolean xv;
    private Map<String, Object> ys;

    /* renamed from: com.bytedance.msdk.api.sr.c$c  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static class C0403c {
        private JSONObject bk;

        /* renamed from: c  reason: collision with root package name */
        private String f27504c;
        private sr ev;

        /* renamed from: f  reason: collision with root package name */
        private k f27505f;
        private ValueSet fp;
        private f gd;
        private boolean ia;

        /* renamed from: p  reason: collision with root package name */
        private Map<String, Object> f27507p;

        /* renamed from: r  reason: collision with root package name */
        private ev f27508r;

        /* renamed from: t  reason: collision with root package name */
        private fp f27509t;

        /* renamed from: w  reason: collision with root package name */
        private String f27510w;
        private Map<String, Object> ys;
        private boolean xv = false;
        private String sr = "";
        private boolean ux = false;

        /* renamed from: k  reason: collision with root package name */
        private boolean f27506k = false;

        /* renamed from: a  reason: collision with root package name */
        private boolean f27503a = false;

        public C0403c c(String str) {
            this.f27504c = str;
            return this;
        }

        public C0403c sr(boolean z3) {
            this.ia = z3;
            return this;
        }

        public C0403c w(String str) {
            this.f27510w = str;
            return this;
        }

        public C0403c xv(@NonNull String str) {
            this.sr = str;
            return this;
        }

        public C0403c c(boolean z3) {
            this.xv = z3;
            return this;
        }

        public C0403c w(boolean z3) {
            this.ux = z3;
            return this;
        }

        public C0403c xv(boolean z3) {
            this.f27506k = z3;
            return this;
        }

        public C0403c c(@NonNull k kVar) {
            this.f27505f = kVar;
            return this;
        }

        public C0403c c(@NonNull ev evVar) {
            this.f27508r = evVar;
            return this;
        }

        public C0403c c(@NonNull f fVar) {
            this.gd = fVar;
            return this;
        }

        public C0403c c(Map<String, Object> map) {
            if (map != null && !map.isEmpty()) {
                HashMap hashMap = new HashMap();
                this.f27507p = hashMap;
                hashMap.putAll(map);
            }
            return this;
        }

        public C0403c c(JSONObject jSONObject) {
            this.bk = jSONObject;
            return this;
        }

        public C0403c c(fp fpVar) {
            this.f27509t = fpVar;
            return this;
        }

        public C0403c c(ValueSet valueSet) {
            this.fp = valueSet;
            return this;
        }

        public c c() {
            return new c(this);
        }
    }

    public boolean a() {
        return this.f27495a;
    }

    @Nullable
    public JSONObject bk() {
        return this.bk;
    }

    @Nullable
    public String c() {
        return this.f27496c;
    }

    @Nullable
    public sr ev() {
        return this.ev;
    }

    @NonNull
    public k f() {
        return this.f27497f;
    }

    public ValueSet fp() {
        return this.fp;
    }

    @NonNull
    public f gd() {
        return this.gd;
    }

    public boolean ia() {
        return this.ia;
    }

    public boolean k() {
        return this.f27498k;
    }

    @Nullable
    public Map<String, Object> p() {
        return this.f27499p;
    }

    @NonNull
    public ev r() {
        return this.f27500r;
    }

    @Nullable
    public String sr() {
        return this.sr;
    }

    @Nullable
    public fp t() {
        return this.f27501t;
    }

    public boolean ux() {
        return this.ux;
    }

    @Nullable
    public String w() {
        return this.f27502w;
    }

    public boolean xv() {
        return this.xv;
    }

    @Nullable
    public Map<String, Object> ys() {
        return this.ys;
    }

    private c(C0403c c0403c) {
        this.f27496c = c0403c.f27504c;
        this.f27502w = c0403c.f27510w;
        this.xv = c0403c.xv;
        this.sr = c0403c.sr;
        this.ux = c0403c.ux;
        if (c0403c.f27505f != null) {
            this.f27497f = c0403c.f27505f;
        } else {
            this.f27497f = new k.c().c();
        }
        if (c0403c.f27508r != null) {
            this.f27500r = c0403c.f27508r;
        } else {
            this.f27500r = new ev.c().c();
        }
        if (c0403c.ev != null) {
            this.ev = c0403c.ev;
        } else {
            this.ev = new sr.c().c();
        }
        if (c0403c.gd != null) {
            this.gd = c0403c.gd;
        } else {
            this.gd = new f();
        }
        this.f27499p = c0403c.f27507p;
        this.f27498k = c0403c.f27506k;
        this.f27495a = c0403c.f27503a;
        this.bk = c0403c.bk;
        this.f27501t = c0403c.f27509t;
        this.ys = c0403c.ys;
        this.fp = c0403c.fp;
        this.ia = c0403c.ia;
    }
}

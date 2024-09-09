package com.bytedance.sdk.openadsdk.core.ugeno.w;

import com.bytedance.adsdk.ugeno.w.f;
import com.bytedance.sdk.component.adexpress.w.bk;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class c extends bk {

    /* renamed from: c  reason: collision with root package name */
    private JSONObject f35040c;
    private float sr;
    private boolean ux;

    /* renamed from: w  reason: collision with root package name */
    private f f35041w;
    private float xv;

    /* renamed from: com.bytedance.sdk.openadsdk.core.ugeno.w.c$c  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static class C0516c extends bk.c {

        /* renamed from: c  reason: collision with root package name */
        private JSONObject f35042c;
        private float sr;
        private boolean ux;

        /* renamed from: w  reason: collision with root package name */
        private f f35043w;
        private float xv;

        public C0516c w(float f4) {
            this.sr = f4;
            return this;
        }

        public C0516c xv(JSONObject jSONObject) {
            this.f35042c = jSONObject;
            return this;
        }

        public C0516c c(f fVar) {
            this.f35043w = fVar;
            return this;
        }

        @Override // com.bytedance.sdk.component.adexpress.w.bk.c
        /* renamed from: w */
        public c c() {
            return new c(this);
        }

        public C0516c xv(boolean z3) {
            this.ux = z3;
            return this;
        }

        public C0516c c(float f4) {
            this.xv = f4;
            return this;
        }
    }

    public c(C0516c c0516c) {
        super(c0516c);
        this.f35040c = c0516c.f35042c;
        this.f35041w = c0516c.f35043w;
        this.xv = c0516c.xv;
        this.sr = c0516c.sr;
        this.ux = c0516c.ux;
    }

    public boolean ck() {
        return this.ux;
    }

    public JSONObject gb() {
        return this.f35040c;
    }

    public float j() {
        return this.xv;
    }

    public float ls() {
        return this.sr;
    }

    public f n() {
        return this.f35041w;
    }
}

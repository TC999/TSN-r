package com.bytedance.sdk.component.w.c;

import com.bytedance.sdk.component.w.c.f;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public abstract class t {

    /* renamed from: c  reason: collision with root package name */
    public a f30426c;

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static class c {

        /* renamed from: c  reason: collision with root package name */
        com.bytedance.sdk.component.w.c.c f30427c;

        /* renamed from: f  reason: collision with root package name */
        ys f30428f;

        /* renamed from: r  reason: collision with root package name */
        f.c f30429r;
        String sr;
        Object ux;

        /* renamed from: w  reason: collision with root package name */
        public Map<String, List<String>> f30430w;
        r xv;

        public c() {
            this.f30430w = new HashMap();
            this.f30429r = new f.c();
        }

        public c c(com.bytedance.sdk.component.w.c.c cVar) {
            this.f30427c = cVar;
            return this;
        }

        public c w(String str, String str2) {
            if (!this.f30430w.containsKey(str)) {
                this.f30430w.put(str, new ArrayList());
            }
            this.f30430w.get(str).add(str2);
            return this;
        }

        public c c(Object obj) {
            this.ux = obj;
            return this;
        }

        public c c(String str) {
            if (str != null) {
                if (str.regionMatches(true, 0, "ws:", 0, 3)) {
                    str = "http:" + str.substring(3);
                } else if (str.regionMatches(true, 0, "wss:", 0, 4)) {
                    str = "https:" + str.substring(4);
                }
                r xv = r.xv(str);
                if (xv != null) {
                    return c(xv);
                }
                throw new IllegalArgumentException("unexpected url: " + str);
            }
            throw new NullPointerException("url == null");
        }

        c(t tVar) {
            this.xv = tVar.w();
            this.sr = tVar.xv();
            this.f30430w = tVar.sr();
            this.ux = tVar.c();
            this.f30428f = tVar.f();
            this.f30427c = tVar.ux();
        }

        public t w() {
            return new t() { // from class: com.bytedance.sdk.component.w.c.t.c.1
                @Override // com.bytedance.sdk.component.w.c.t
                public Object c() {
                    return c.this.ux;
                }

                @Override // com.bytedance.sdk.component.w.c.t
                public ys f() {
                    return c.this.f30428f;
                }

                @Override // com.bytedance.sdk.component.w.c.t
                public Map sr() {
                    return c.this.f30430w;
                }

                public String toString() {
                    return "";
                }

                @Override // com.bytedance.sdk.component.w.c.t
                public com.bytedance.sdk.component.w.c.c ux() {
                    return c.this.f30427c;
                }

                @Override // com.bytedance.sdk.component.w.c.t
                public r w() {
                    return c.this.xv;
                }

                @Override // com.bytedance.sdk.component.w.c.t
                public String xv() {
                    return c.this.sr;
                }
            };
        }

        public c c(r rVar) {
            this.xv = rVar;
            return this;
        }

        public c c(String str, String str2) {
            return w(str, str2);
        }

        public c c(f fVar) {
            if (fVar != null) {
                this.f30430w = fVar.w();
            }
            return this;
        }

        public c c() {
            return c("GET", (ys) null);
        }

        public c c(String str, ys ysVar) {
            this.sr = str;
            this.f30428f = ysVar;
            return this;
        }

        public c c(ys ysVar) {
            return c("POST", ysVar);
        }
    }

    public abstract Object c();

    public void c(a aVar) {
        this.f30426c = aVar;
    }

    public ys f() {
        return null;
    }

    public c r() {
        return new c(this);
    }

    public abstract Map<String, List<String>> sr();

    public abstract com.bytedance.sdk.component.w.c.c ux();

    public abstract r w();

    public abstract String xv();
}

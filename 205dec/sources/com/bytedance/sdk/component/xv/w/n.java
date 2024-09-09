package com.bytedance.sdk.component.xv.w;

import com.bytedance.sdk.component.xv.w.s;
import java.net.URL;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public final class n {

    /* renamed from: c  reason: collision with root package name */
    final fz f31067c;

    /* renamed from: f  reason: collision with root package name */
    public z f31068f;

    /* renamed from: r  reason: collision with root package name */
    private volatile sr f31069r;
    final ck sr;
    final Object ux;

    /* renamed from: w  reason: collision with root package name */
    final String f31070w;
    final s xv;

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static class c {

        /* renamed from: c  reason: collision with root package name */
        fz f31071c;

        /* renamed from: f  reason: collision with root package name */
        z f31072f;
        ck sr;
        Object ux;

        /* renamed from: w  reason: collision with root package name */
        String f31073w;
        s.c xv;

        public c() {
            this.f31073w = "GET";
            this.xv = new s.c();
        }

        public c c(fz fzVar) {
            if (fzVar != null) {
                this.f31071c = fzVar;
                return this;
            }
            throw new NullPointerException("url == null");
        }

        public c delete(ck ckVar) {
            return c("DELETE", ckVar);
        }

        public c w(String str, String str2) {
            this.xv.c(str, str2);
            return this;
        }

        public c delete() {
            return delete(com.bytedance.sdk.component.xv.w.c.xv.sr);
        }

        public c w(String str) {
            this.xv.w(str);
            return this;
        }

        public c c(String str) {
            if (str != null) {
                if (str.regionMatches(true, 0, "ws:", 0, 3)) {
                    str = "http:" + str.substring(3);
                } else if (str.regionMatches(true, 0, "wss:", 0, 4)) {
                    str = "https:" + str.substring(4);
                }
                fz ux = fz.ux(str);
                if (ux != null) {
                    return c(ux);
                }
                throw new IllegalArgumentException("unexpected url: " + str);
            }
            throw new NullPointerException("url == null");
        }

        c(n nVar) {
            this.f31071c = nVar.f31067c;
            this.f31073w = nVar.f31070w;
            this.sr = nVar.sr;
            this.ux = nVar.ux;
            this.xv = nVar.xv.w();
            this.f31072f = nVar.f31068f;
        }

        public c c(URL url) {
            if (url != null) {
                fz c4 = fz.c(url);
                if (c4 != null) {
                    return c(c4);
                }
                throw new IllegalArgumentException("unexpected url: " + url);
            }
            throw new NullPointerException("url == null");
        }

        public c c(String str, String str2) {
            this.xv.xv(str, str2);
            return this;
        }

        public c c(s sVar) {
            this.xv = sVar.w();
            return this;
        }

        public c c(sr srVar) {
            String srVar2 = srVar.toString();
            return srVar2.isEmpty() ? w("Cache-Control") : c("Cache-Control", srVar2);
        }

        public c c(String str, ck ckVar) {
            if (str != null) {
                if (str.length() != 0) {
                    if (ckVar != null && !com.bytedance.sdk.component.xv.w.c.xv.f.xv(str)) {
                        throw new IllegalArgumentException("method " + str + " must not have a request body.");
                    } else if (ckVar == null && com.bytedance.sdk.component.xv.w.c.xv.f.w(str)) {
                        throw new IllegalArgumentException("method " + str + " must have a request body.");
                    } else {
                        this.f31073w = str;
                        this.sr = ckVar;
                        return this;
                    }
                }
                throw new IllegalArgumentException("method.length() == 0");
            }
            throw new NullPointerException("method == null");
        }

        public c c(Object obj) {
            this.ux = obj;
            return this;
        }

        public n c() {
            if (this.f31071c != null) {
                return new n(this);
            }
            throw new IllegalStateException("url == null");
        }
    }

    n(c cVar) {
        this.f31067c = cVar.f31071c;
        this.f31070w = cVar.f31073w;
        this.xv = cVar.xv.c();
        this.sr = cVar.sr;
        Object obj = cVar.ux;
        this.ux = obj == null ? this : obj;
        z zVar = cVar.f31072f;
        if (zVar != null) {
            this.f31068f = zVar;
        } else {
            this.f31068f = new z();
        }
    }

    public fz c() {
        return this.f31067c;
    }

    public boolean ev() {
        return this.f31067c.sr();
    }

    public c f() {
        return new c(this);
    }

    public sr r() {
        sr srVar = this.f31069r;
        if (srVar != null) {
            return srVar;
        }
        sr c4 = sr.c(this.xv);
        this.f31069r = c4;
        return c4;
    }

    public ck sr() {
        return this.sr;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Request{method=");
        sb.append(this.f31070w);
        sb.append(", url=");
        sb.append(this.f31067c);
        sb.append(", tag=");
        Object obj = this.ux;
        if (obj == this) {
            obj = null;
        }
        sb.append(obj);
        sb.append('}');
        return sb.toString();
    }

    public Object ux() {
        return this.ux;
    }

    public String w() {
        return this.f31070w;
    }

    public s xv() {
        return this.xv;
    }

    public String c(String str) {
        return this.xv.c(str);
    }
}

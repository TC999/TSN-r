package com.bytedance.sdk.openadsdk.core.u;

import android.graphics.Color;
import android.text.TextUtils;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class mt {

    /* renamed from: a  reason: collision with root package name */
    private w f34760a;
    private int bk;

    /* renamed from: c  reason: collision with root package name */
    private int f34761c;
    private int ev;

    /* renamed from: f  reason: collision with root package name */
    private int f34762f;

    /* renamed from: k  reason: collision with root package name */
    private w f34763k;

    /* renamed from: r  reason: collision with root package name */
    private int f34765r;
    private int sr;

    /* renamed from: t  reason: collision with root package name */
    private c f34766t;
    private int ux;

    /* renamed from: w  reason: collision with root package name */
    private String f34767w;
    private int ys;
    private boolean xv = false;
    private String gd = "#008DEA";

    /* renamed from: p  reason: collision with root package name */
    private String f34764p = "\u70b9\u51fb\u67e5\u770b";

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public class c {

        /* renamed from: c  reason: collision with root package name */
        int f34768c;
        int sr;

        /* renamed from: w  reason: collision with root package name */
        int f34769w;
        int xv;

        public c(JSONObject jSONObject, int i4) {
            this.f34768c = 30;
            this.f34769w = 30;
            this.xv = 150;
            this.sr = 40;
            if (jSONObject == null) {
                if (i4 == 2) {
                    this.xv = 40;
                    this.sr = 20;
                    return;
                }
                return;
            }
            int optInt = jSONObject.optInt("left_margin", 30);
            this.f34768c = optInt;
            if (optInt < 0 || optInt > mt.this.ia()) {
                this.f34768c = 30;
            }
            int optInt2 = jSONObject.optInt("right_margin", 30);
            this.f34769w = optInt2;
            if (optInt2 < 0 || optInt2 > mt.this.ia()) {
                this.f34769w = 30;
            }
            if (i4 == 2) {
                int optInt3 = jSONObject.optInt("top_margin", 40);
                this.xv = optInt3;
                if (optInt3 < 0 || optInt3 > mt.this.fp()) {
                    this.xv = 40;
                }
                int optInt4 = jSONObject.optInt("bottom_margin", 20);
                this.sr = optInt4;
                if (optInt4 < 0 || optInt4 > mt.this.fp()) {
                    this.sr = 20;
                    return;
                }
                return;
            }
            int optInt5 = jSONObject.optInt("top_margin", 150);
            this.xv = optInt5;
            if (optInt5 < 0 || optInt5 > mt.this.fp()) {
                this.xv = 150;
            }
            int optInt6 = jSONObject.optInt("bottom_margin", 40);
            this.sr = optInt6;
            if (optInt6 < 0 || optInt6 > mt.this.fp()) {
                this.sr = 40;
            }
        }

        public int c() {
            return this.f34768c;
        }

        public int sr() {
            return this.sr;
        }

        public JSONObject ux() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("left_margin", 30);
                jSONObject.put("right_margin", 30);
                jSONObject.put("top_margin", 150);
                jSONObject.put("bottom_margin", 40);
            } catch (Exception unused) {
            }
            return jSONObject;
        }

        public int w() {
            return this.f34769w;
        }

        public int xv() {
            return this.xv;
        }
    }

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public class w {

        /* renamed from: c  reason: collision with root package name */
        int f34770c;

        public w(JSONObject jSONObject, int i4) {
            this.f34770c = 14;
            if (jSONObject == null) {
                return;
            }
            this.f34770c = jSONObject.optInt("font_size", i4);
        }

        public JSONObject c() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("font_size", this.f34770c);
            } catch (Exception unused) {
            }
            return jSONObject;
        }

        public int w() {
            return this.f34770c;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int fp() {
        return com.bytedance.sdk.openadsdk.core.eq.xk.sr(com.bytedance.sdk.openadsdk.core.ls.getContext(), com.bytedance.sdk.openadsdk.core.eq.xk.ux(com.bytedance.sdk.openadsdk.core.ls.getContext()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int ia() {
        return com.bytedance.sdk.openadsdk.core.eq.xk.sr(com.bytedance.sdk.openadsdk.core.ls.getContext(), com.bytedance.sdk.openadsdk.core.eq.xk.sr(com.bytedance.sdk.openadsdk.core.ls.getContext()));
    }

    public w a() {
        return this.f34763k;
    }

    public w bk() {
        return this.f34760a;
    }

    public int ev() {
        return this.ys;
    }

    public int f() {
        return this.f34765r;
    }

    public int gd() {
        if (this.sr == 4 && !com.bytedance.sdk.openadsdk.core.k.sr().c(com.bytedance.sdk.openadsdk.core.ls.getContext())) {
            this.sr = 0;
        } else if (this.sr == 7 && !com.bytedance.sdk.openadsdk.core.k.sr().w(com.bytedance.sdk.openadsdk.core.ls.getContext())) {
            this.sr = 0;
        }
        return this.sr;
    }

    public String k() {
        return this.f34764p;
    }

    public String p() {
        return this.gd;
    }

    public int r() {
        return this.ev;
    }

    public int sr() {
        return this.ux;
    }

    public c t() {
        return this.f34766t;
    }

    public int ux() {
        return this.f34762f;
    }

    public boolean xv() {
        return this.xv;
    }

    public int ys() {
        return this.bk;
    }

    public int c() {
        return this.f34761c;
    }

    public void ev(int i4) {
        if (i4 > 0 && i4 < fp()) {
            this.bk = i4;
        } else {
            this.bk = 5;
        }
    }

    public void f(int i4) {
        this.ys = i4;
    }

    public void r(int i4) {
        this.sr = i4;
    }

    public void sr(int i4) {
        this.f34765r = i4;
    }

    public void ux(int i4) {
        this.ev = i4;
    }

    public String w() {
        if (this.sr == 4 && !com.bytedance.sdk.openadsdk.core.k.sr().c(com.bytedance.sdk.openadsdk.core.ls.getContext())) {
            this.f34767w = "\u70b9\u51fb\u8df3\u8f6c\u81f3\u8be6\u60c5\u9875\u6216\u7b2c\u4e09\u65b9\u5e94\u7528";
        } else if (this.sr == 7 && !com.bytedance.sdk.openadsdk.core.k.sr().w(com.bytedance.sdk.openadsdk.core.ls.getContext())) {
            this.f34767w = "\u70b9\u51fb\u8df3\u8f6c\u81f3\u8be6\u60c5\u9875\u6216\u7b2c\u4e09\u65b9\u5e94\u7528";
        }
        return this.f34767w;
    }

    public void xv(int i4) {
        this.f34762f = i4;
    }

    public void c(int i4) {
        this.f34761c = i4;
    }

    public void xv(String str) {
        if (TextUtils.isEmpty(str)) {
            int i4 = this.sr;
            if (i4 == 7) {
                this.f34764p = "\u626d\u52a8\u624b\u673a";
                return;
            } else if (i4 == 5) {
                this.f34764p = "\u5411\u4e0a\u6ed1\u52a8";
                return;
            } else if (i4 == 4) {
                this.f34764p = "\u6447\u4e00\u6447";
                return;
            } else {
                return;
            }
        }
        this.f34764p = str;
    }

    public void c(String str) {
        if (TextUtils.isEmpty(str)) {
            this.xv = true;
            int i4 = this.sr;
            if (i4 == 3) {
                this.f34767w = "\u8df3\u8f6c\u81f3\u8be6\u60c5\u9875\u6216\u7b2c\u4e09\u65b9\u5e94\u7528";
                return;
            } else if (i4 == 4) {
                this.f34767w = "\u524d\u5f80\u8be6\u60c5\u9875\u6216\u7b2c\u4e09\u65b9\u5e94\u7528";
                return;
            } else if (i4 != 5 && i4 != 7) {
                this.f34767w = "\u70b9\u51fb\u8df3\u8f6c\u81f3\u8be6\u60c5\u9875\u6216\u7b2c\u4e09\u65b9\u5e94\u7528";
                return;
            } else {
                this.f34767w = "\u524d\u5f80\u8be6\u60c5\u9875\u6216\u7b2c\u4e09\u65b9\u5e94\u7528";
                return;
            }
        }
        this.f34767w = str;
    }

    public void w(int i4) {
        this.ux = i4;
    }

    public void w(String str) {
        try {
            Color.parseColor(str);
            this.gd = str;
        } catch (Throwable unused) {
            this.gd = "#008DEA";
        }
    }

    public void w(JSONObject jSONObject) {
        this.f34760a = new w(jSONObject, 20);
    }

    public void c(JSONObject jSONObject) {
        this.f34763k = new w(jSONObject, 14);
    }

    public void c(JSONObject jSONObject, int i4) {
        this.f34766t = new c(jSONObject, i4);
    }
}

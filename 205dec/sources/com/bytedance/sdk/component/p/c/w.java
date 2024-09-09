package com.bytedance.sdk.component.p.c;

import android.text.TextUtils;
import com.bytedance.sdk.component.p.sr.f;
import com.bytedance.sdk.component.p.sr.sr;
import com.bytedance.sdk.component.p.sr.ux;
import com.bytedance.sdk.component.p.sr.xv;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class w implements sr {

    /* renamed from: c  reason: collision with root package name */
    private String f29952c;

    /* renamed from: f  reason: collision with root package name */
    private int f29953f;
    private xv sr;
    private com.bytedance.sdk.component.p.c.c ux;

    /* renamed from: w  reason: collision with root package name */
    private JSONObject f29954w;
    private Map<String, Object> xv;

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static class c {

        /* renamed from: c  reason: collision with root package name */
        private int f29956c = 1;

        /* renamed from: f  reason: collision with root package name */
        private xv f29957f;

        /* renamed from: r  reason: collision with root package name */
        private JSONObject f29958r;
        private JSONObject sr;
        private Map<String, Object> ux;

        /* renamed from: w  reason: collision with root package name */
        private String f29959w;
        private StringBuilder xv;

        public c(String str) {
            this.f29959w = str;
        }

        public c c(JSONObject jSONObject) {
            this.sr = jSONObject;
            return this;
        }

        public c w(JSONObject jSONObject) {
            this.f29958r = jSONObject;
            return this;
        }

        public c c(Map<String, Object> map) {
            this.ux = map;
            return this;
        }

        public c c(xv xvVar) {
            this.f29957f = xvVar;
            return this;
        }

        public w c() {
            return new w(this);
        }
    }

    @Override // com.bytedance.sdk.component.p.sr.sr
    public f w() {
        return null;
    }

    @Override // com.bytedance.sdk.component.p.sr.sr
    public ux xv() {
        return new ux() { // from class: com.bytedance.sdk.component.p.c.w.1
            @Override // com.bytedance.sdk.component.p.sr.ux
            public void c(com.bytedance.sdk.component.p.c.c cVar) {
            }

            @Override // com.bytedance.sdk.component.p.sr.ux
            public void c(com.bytedance.sdk.component.p.c.c cVar, String str) {
            }

            @Override // com.bytedance.sdk.component.p.sr.ux
            public void c(com.bytedance.sdk.component.p.c.c cVar, Map<String, Object> map) {
                for (com.bytedance.sdk.component.p.xv.c cVar2 : com.bytedance.sdk.component.p.xv.w.INSTANCE.c(w.this.f29952c).c(cVar.r(), cVar.xv(), map)) {
                    w.this.c(cVar2, map);
                }
            }

            @Override // com.bytedance.sdk.component.p.sr.ux
            public void w(com.bytedance.sdk.component.p.c.c cVar, Map<String, Object> map) {
                for (com.bytedance.sdk.component.p.xv.c cVar2 : com.bytedance.sdk.component.p.xv.w.INSTANCE.c(w.this.f29952c).w(cVar.r(), cVar.xv(), map)) {
                    w.this.c(cVar2, map);
                }
            }
        };
    }

    private w(c cVar) {
        this.f29953f = 1;
        this.f29953f = cVar.f29956c;
        if (cVar.f29956c == 2) {
            this.ux = new com.bytedance.sdk.component.p.c.c(cVar.xv, cVar.sr, cVar.ux);
            this.f29953f = 2;
        } else {
            this.f29952c = cVar.f29959w;
            if (cVar.f29958r != null) {
                com.bytedance.sdk.component.p.xv.w.INSTANCE.c(cVar.f29958r);
            }
        }
        this.f29954w = cVar.sr;
        this.xv = cVar.ux;
        this.sr = cVar.f29957f;
    }

    public void c() {
        com.bytedance.sdk.component.p.xv.xv c4;
        xv xvVar = this.sr;
        if (xvVar != null) {
            xvVar.c(this);
        }
        if (this.f29953f == 2) {
            xv xvVar2 = this.sr;
            if (xvVar2 != null) {
                xvVar2.c(this.ux);
            }
            this.ux.f();
        } else if (TextUtils.isEmpty(this.f29952c) || (c4 = com.bytedance.sdk.component.p.xv.w.INSTANCE.c(this.f29952c)) == null) {
        } else {
            c(c4.c(), this.xv);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.bytedance.sdk.component.p.xv.c cVar, Map<String, Object> map) {
        if (cVar == null) {
            return;
        }
        if (map == null) {
            map = new HashMap<>();
        }
        com.bytedance.sdk.component.p.c.c cVar2 = new com.bytedance.sdk.component.p.c.c(cVar, this.f29954w, map);
        cVar2.c(this.f29952c);
        cVar2.c(this);
        xv xvVar = this.sr;
        if (xvVar != null) {
            xvVar.c(cVar2);
        }
        cVar2.f();
        for (com.bytedance.sdk.component.p.xv.c cVar3 : com.bytedance.sdk.component.p.xv.w.INSTANCE.c(this.f29952c).xv(cVar, cVar2.xv(), map)) {
            if (cVar3 != null) {
                c(cVar3, map);
            }
        }
    }
}

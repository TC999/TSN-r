package com.bytedance.msdk.ux.ux;

import com.bytedance.msdk.f.wv;
import com.bytedance.msdk.ux.f;
import com.bytedance.pangle.sdk.component.log.impl.event.policy.PolicyConfig;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class w implements com.bytedance.msdk.ux.c.w, com.bytedance.msdk.ux.sr, com.bytedance.msdk.ux.w, com.bytedance.msdk.ux.xv {

    /* renamed from: c  reason: collision with root package name */
    private static volatile w f28456c;
    private com.bytedance.msdk.ux.sr sr;

    /* renamed from: w  reason: collision with root package name */
    private com.bytedance.msdk.ux.xv f28457w;
    private com.bytedance.msdk.ux.w xv;

    private w() {
    }

    public static w p() {
        if (f28456c == null) {
            synchronized (w.class) {
                if (f28456c == null) {
                    f28456c = new w();
                }
            }
        }
        return f28456c;
    }

    @Override // com.bytedance.msdk.ux.c.w
    public void c(String str, boolean z3) {
        if (this.f28457w == null) {
            this.f28457w = xv.c();
        }
        if (this.xv == null) {
            this.xv = c.sr();
        }
        if (this.sr == null) {
            this.sr = sr.c();
        }
    }

    @Override // com.bytedance.msdk.ux.sr
    public boolean ev() {
        com.bytedance.msdk.ux.sr srVar = this.sr;
        if (srVar == null) {
            return true;
        }
        return srVar.ev();
    }

    @Override // com.bytedance.msdk.ux.xv
    public int f() {
        com.bytedance.msdk.ux.xv xvVar = this.f28457w;
        if (xvVar == null) {
            return 0;
        }
        return xvVar.f();
    }

    @Override // com.bytedance.msdk.ux.ux
    public wv gd() {
        return f.r();
    }

    @Override // com.bytedance.msdk.ux.sr
    public void r() {
        com.bytedance.msdk.ux.sr srVar = this.sr;
        if (srVar != null) {
            srVar.r();
        }
    }

    @Override // com.bytedance.msdk.ux.xv
    public int sr() {
        com.bytedance.msdk.ux.xv xvVar = this.f28457w;
        if (xvVar == null) {
            return 100;
        }
        return xvVar.sr();
    }

    @Override // com.bytedance.msdk.ux.xv
    public long ux() {
        com.bytedance.msdk.ux.xv xvVar = this.f28457w;
        return xvVar == null ? PolicyConfig.THREAD_BLOCK_TIMEOUT : xvVar.ux();
    }

    @Override // com.bytedance.msdk.ux.xv
    public void w(JSONObject jSONObject) {
        com.bytedance.msdk.ux.xv xvVar = this.f28457w;
        if (xvVar != null) {
            xvVar.w(jSONObject);
        }
    }

    @Override // com.bytedance.msdk.ux.w
    public boolean xv() {
        com.bytedance.msdk.ux.w wVar = this.xv;
        if (wVar == null) {
            return false;
        }
        return wVar.xv();
    }

    @Override // com.bytedance.msdk.ux.w
    public List<com.bytedance.msdk.core.k.c> w() {
        com.bytedance.msdk.ux.w wVar = this.xv;
        if (wVar == null) {
            return null;
        }
        return wVar.w();
    }

    @Override // com.bytedance.msdk.ux.w
    public void c(JSONObject jSONObject) {
        com.bytedance.msdk.ux.w wVar = this.xv;
        if (wVar != null) {
            wVar.c(jSONObject);
        }
    }

    @Override // com.bytedance.msdk.ux.w
    public com.bytedance.msdk.core.k.c c(String str) {
        com.bytedance.msdk.ux.w wVar = this.xv;
        if (wVar == null) {
            return null;
        }
        return wVar.c(str);
    }

    @Override // com.bytedance.msdk.ux.w
    public void c() {
        com.bytedance.msdk.ux.w wVar = this.xv;
        if (wVar != null) {
            wVar.c();
        }
    }

    @Override // com.bytedance.msdk.ux.sr
    public void c(JSONArray jSONArray) {
        com.bytedance.msdk.ux.sr srVar = this.sr;
        if (srVar != null) {
            srVar.c(jSONArray);
        }
    }

    @Override // com.bytedance.msdk.ux.sr
    public com.bytedance.msdk.core.k.w c(String str, int i4, int i5) {
        com.bytedance.msdk.ux.sr srVar = this.sr;
        if (srVar == null) {
            return null;
        }
        return srVar.c(str, i4, i5);
    }

    @Override // com.bytedance.msdk.ux.ux
    public void c(Runnable runnable) {
        if (runnable != null) {
            com.bytedance.msdk.adapter.sr.f.sr(runnable);
        }
    }
}

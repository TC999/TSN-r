package com.bytedance.sdk.gromore.c.c.sr;

import android.text.TextUtils;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class c implements com.bytedance.sdk.gromore.c.c.sr {

    /* renamed from: c  reason: collision with root package name */
    private com.bytedance.msdk.api.w f31175c;

    public c(com.bytedance.msdk.api.w wVar) {
        this.f31175c = wVar;
    }

    @Override // com.bytedance.sdk.gromore.c.c.sr
    public String c() {
        com.bytedance.msdk.api.w wVar = this.f31175c;
        if (wVar != null) {
            return wVar.w();
        }
        return null;
    }

    @Override // com.bytedance.sdk.gromore.c.c.sr
    public int sr() {
        com.bytedance.msdk.api.w wVar = this.f31175c;
        if (wVar != null) {
            return wVar.ux();
        }
        return 0;
    }

    @Override // com.bytedance.sdk.gromore.c.c.sr
    public String ux() {
        com.bytedance.msdk.api.w wVar = this.f31175c;
        if (wVar != null) {
            return wVar.f();
        }
        return null;
    }

    @Override // com.bytedance.sdk.gromore.c.c.sr
    public String w() {
        com.bytedance.msdk.api.w wVar = this.f31175c;
        if (wVar != null) {
            if (TextUtils.isEmpty(wVar.xv())) {
                return this.f31175c.sr();
            }
            return this.f31175c.xv();
        }
        return null;
    }

    @Override // com.bytedance.sdk.gromore.c.c.sr
    public String xv() {
        com.bytedance.msdk.api.w wVar = this.f31175c;
        if (wVar != null) {
            return wVar.c();
        }
        return null;
    }
}

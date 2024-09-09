package com.bytedance.msdk.sr.c;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class f extends sr {

    /* renamed from: c  reason: collision with root package name */
    private String f28386c;

    public f() {
        super(null);
        com.bytedance.msdk.core.k.c r3 = r();
        if (r3 != null) {
            this.f28386c = r3.c();
        }
    }

    @Override // com.bytedance.msdk.sr.c.xv
    protected Map<String, Object> c() {
        HashMap hashMap = new HashMap();
        hashMap.put("app_id", this.f28386c);
        return hashMap;
    }

    @Override // com.bytedance.msdk.sr.c.xv
    protected String w() {
        return "klevin";
    }

    @Override // com.bytedance.msdk.sr.c.xv
    protected String xv() {
        if (TextUtils.isEmpty(this.f28386c)) {
            com.bytedance.msdk.core.k.c r3 = r();
            if (r3 != null) {
                this.f28386c = r3.c();
            }
            return TextUtils.isEmpty(this.f28386c) ? "appId\u4e3a\u7a7a" : "";
        }
        return "";
    }

    public f(com.bytedance.msdk.api.sr.p pVar) {
        super(pVar);
        if (pVar != null) {
            this.f28386c = pVar.xv();
        }
    }
}

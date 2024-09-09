package com.bytedance.msdk.sr.c;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class ev extends sr {

    /* renamed from: c  reason: collision with root package name */
    private String f28384c;

    /* renamed from: w  reason: collision with root package name */
    private String f28385w;

    public ev() {
        super(null);
        com.bytedance.msdk.core.k.c r3 = r();
        if (r3 != null) {
            this.f28384c = r3.c();
            this.f28385w = r3.w();
        }
    }

    @Override // com.bytedance.msdk.sr.c.xv
    protected Map<String, Object> c() {
        HashMap hashMap = new HashMap();
        hashMap.put("app_id", this.f28384c);
        hashMap.put("app_key", this.f28385w);
        return hashMap;
    }

    @Override // com.bytedance.msdk.sr.c.xv
    protected String w() {
        return "mintegral";
    }

    @Override // com.bytedance.msdk.sr.c.xv
    protected String xv() {
        if (TextUtils.isEmpty(this.f28384c) || TextUtils.isEmpty(this.f28385w)) {
            com.bytedance.msdk.core.k.c r3 = r();
            if (r3 != null) {
                this.f28384c = r3.c();
                this.f28385w = r3.w();
            }
            return (TextUtils.isEmpty(this.f28384c) || TextUtils.isEmpty(this.f28385w)) ? "appId\u4e3a\u7a7a\u6216appKey\u4e3a\u7a7a" : "";
        }
        return "";
    }

    public ev(com.bytedance.msdk.api.sr.p pVar) {
        super(pVar);
        if (pVar != null) {
            this.f28384c = pVar.xv();
            this.f28385w = pVar.sr();
        }
    }
}

package com.bytedance.msdk.sr.c;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class a extends sr {

    /* renamed from: c  reason: collision with root package name */
    private String f28380c;

    /* renamed from: w  reason: collision with root package name */
    private String f28381w;

    public a() {
        super(null);
        com.bytedance.msdk.core.k.c r3 = r();
        if (r3 != null) {
            this.f28380c = r3.c();
            this.f28381w = r3.w();
        }
    }

    @Override // com.bytedance.msdk.sr.c.xv
    protected Map<String, Object> c() {
        HashMap hashMap = new HashMap();
        hashMap.put("app_id", this.f28380c);
        hashMap.put("app_key", this.f28381w);
        return hashMap;
    }

    @Override // com.bytedance.msdk.sr.c.xv
    protected String w() {
        return "sigmob";
    }

    @Override // com.bytedance.msdk.sr.c.xv
    protected String xv() {
        if (TextUtils.isEmpty(this.f28380c) || TextUtils.isEmpty(this.f28381w)) {
            com.bytedance.msdk.core.k.c r3 = r();
            if (r3 != null) {
                this.f28380c = r3.c();
                this.f28381w = r3.w();
            }
            return (TextUtils.isEmpty(this.f28380c) || TextUtils.isEmpty(this.f28381w)) ? "appId\u4e3a\u7a7a\u6216appKey\u4e3a\u7a7a" : "";
        }
        return "";
    }

    public a(com.bytedance.msdk.api.sr.p pVar) {
        super(pVar);
        if (pVar != null) {
            this.f28380c = pVar.xv();
            this.f28381w = pVar.sr();
        }
    }
}

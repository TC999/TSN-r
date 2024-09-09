package com.bytedance.msdk.sr.c;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class w extends sr {

    /* renamed from: c  reason: collision with root package name */
    private String f28390c;

    public w() {
        super(null);
        com.bytedance.msdk.core.k.c r3 = r();
        if (r3 != null) {
            this.f28390c = r3.c();
        }
    }

    @Override // com.bytedance.msdk.sr.c.xv
    protected Map<String, Object> c() {
        HashMap hashMap = new HashMap();
        hashMap.put("app_id", this.f28390c);
        hashMap.put("baidu_https", Boolean.valueOf(com.bytedance.msdk.core.w.k().yu()));
        if (!TextUtils.isEmpty(com.bytedance.msdk.core.w.k().f())) {
            hashMap.put("baidu_wx_app_id", com.bytedance.msdk.core.w.k().f());
        }
        return hashMap;
    }

    @Override // com.bytedance.msdk.sr.c.xv
    protected String w() {
        return "baidu";
    }

    @Override // com.bytedance.msdk.sr.c.xv
    protected String xv() {
        if (TextUtils.isEmpty(this.f28390c)) {
            com.bytedance.msdk.core.k.c r3 = r();
            if (r3 != null) {
                this.f28390c = r3.c();
            }
            return TextUtils.isEmpty(this.f28390c) ? "appId\u4e3a\u7a7a" : "";
        }
        return "";
    }

    public w(com.bytedance.msdk.api.sr.p pVar) {
        super(pVar);
        if (pVar != null) {
            this.f28390c = pVar.xv();
        }
    }
}

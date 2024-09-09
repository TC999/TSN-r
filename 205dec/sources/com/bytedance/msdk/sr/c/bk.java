package com.bytedance.msdk.sr.c;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class bk extends sr {

    /* renamed from: c  reason: collision with root package name */
    private String f28382c;

    public bk() {
        super(null);
        com.bytedance.msdk.core.k.c r3 = r();
        if (r3 != null) {
            this.f28382c = r3.c();
        }
    }

    @Override // com.bytedance.msdk.sr.c.xv
    protected Map<String, Object> c() {
        HashMap hashMap = new HashMap();
        hashMap.put("app_id", this.f28382c);
        return hashMap;
    }

    @Override // com.bytedance.msdk.sr.c.xv
    protected String w() {
        return "unity";
    }

    @Override // com.bytedance.msdk.sr.c.xv
    protected String xv() {
        if (TextUtils.isEmpty(this.f28382c)) {
            com.bytedance.msdk.core.k.c r3 = r();
            if (r3 != null) {
                this.f28382c = r3.c();
            }
            return TextUtils.isEmpty(this.f28382c) ? "appId\u4e3a\u7a7a" : "";
        }
        return "";
    }
}

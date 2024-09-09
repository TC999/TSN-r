package com.bytedance.msdk.sr.c;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public abstract class p extends sr {

    /* renamed from: c  reason: collision with root package name */
    protected String f28387c;

    public p() {
        super(null);
        com.bytedance.msdk.core.k.c r3 = r();
        if (r3 != null) {
            this.f28387c = r3.c();
        }
        if (TextUtils.isEmpty(this.f28387c)) {
            this.f28387c = com.bytedance.msdk.core.w.k().a();
        }
    }

    public static p gd() {
        if (com.bytedance.msdk.core.w.k().wx()) {
            return new k();
        }
        return new gd();
    }

    public static p w(com.bytedance.msdk.api.sr.p pVar) {
        if (com.bytedance.msdk.core.w.k().wx()) {
            return new k(pVar);
        }
        return new gd(pVar);
    }

    @Override // com.bytedance.msdk.sr.c.xv
    protected Map<String, Object> c() {
        HashMap hashMap = new HashMap();
        hashMap.put("app_id", this.f28387c);
        hashMap.put("pangle_is_pangle_use_texture_view", Boolean.valueOf(com.bytedance.msdk.core.w.k().j()));
        hashMap.put("pangle_app_name", com.bytedance.msdk.core.w.k().i());
        hashMap.put("pangle_is_pangle_paid", Boolean.valueOf(com.bytedance.msdk.core.w.k().ys()));
        hashMap.put("pangle_title_bar_theme", Integer.valueOf(com.bytedance.msdk.core.w.k().q()));
        hashMap.put("pangle_is_pangle_allow_show_notify", Boolean.valueOf(com.bytedance.msdk.core.w.k().t()));
        hashMap.put("pangle_is_pangle_allow_show_page_when_screen_lock", Boolean.valueOf(com.bytedance.msdk.core.w.k().u()));
        hashMap.put("pangle_direct_download_networktype", com.bytedance.msdk.core.w.k().fz());
        hashMap.put("pangle_need_clear_task_reset", com.bytedance.msdk.core.w.k().ls());
        hashMap.put("pangle_keywords", com.bytedance.msdk.core.w.k().z());
        hashMap.put("pangle_support_multi_process", Boolean.valueOf(com.bytedance.msdk.core.w.k().bk()));
        return hashMap;
    }

    @Override // com.bytedance.msdk.sr.c.xv
    protected String xv() {
        if (TextUtils.isEmpty(this.f28387c)) {
            com.bytedance.msdk.core.k.c r3 = r();
            if (r3 != null) {
                this.f28387c = r3.c();
            }
            return TextUtils.isEmpty(this.f28387c) ? "appId\u4e3a\u7a7a" : "";
        }
        return "";
    }

    public p(com.bytedance.msdk.api.sr.p pVar) {
        super(pVar);
        if (pVar != null) {
            this.f28387c = pVar.xv();
        }
    }
}

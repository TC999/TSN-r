package com.bytedance.embedapplog;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import xyz.adscope.ad.model.http.request.ad.constant.AdRequestConstant;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public final class jv {

    /* renamed from: c  reason: collision with root package name */
    private final SharedPreferences f26749c;

    /* JADX INFO: Access modifiers changed from: package-private */
    @WorkerThread
    public jv(Context context) {
        this.f26749c = com.bytedance.sdk.openadsdk.api.plugin.w.w(context, "device_register_oaid_refine", 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @WorkerThread
    public void c(@Nullable rd rdVar) {
        if (rdVar == null) {
            return;
        }
        this.f26749c.edit().putString(AdRequestConstant.AD_REQUEST_DEVICE_EXT_OAID_KEY, rdVar.w().toString()).apply();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    @WorkerThread
    public rd c() {
        return rd.c(this.f26749c.getString(AdRequestConstant.AD_REQUEST_DEVICE_EXT_OAID_KEY, ""));
    }
}

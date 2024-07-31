package com.kwad.sdk.core.config.item;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.service.ServiceProvider;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.config.item.c */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10255c extends AbstractC10254b<Integer> {
    public C10255c() {
        super("batchReportCacheType", 2);
    }

    /* renamed from: aT */
    public static int m26492aT(@Nullable Context context) {
        SharedPreferences sharedPreferences;
        C10331c.m26254d("batchReportCacheType", "loadBatchReportCacheType");
        if (context == null || (sharedPreferences = context.getSharedPreferences("ksadsdk_rep", 0)) == null) {
            return 2;
        }
        return sharedPreferences.getInt("batchReportCacheType", 2);
    }

    /* renamed from: h */
    private static void m26491h(@Nullable Context context, int i) {
        SharedPreferences sharedPreferences;
        C10331c.m26254d("batchReportCacheType", "saveBatchReportCacheType");
        if (context == null || (sharedPreferences = context.getSharedPreferences("ksadsdk_rep", 0)) == null) {
            return;
        }
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putInt("batchReportCacheType", i);
        edit.apply();
    }

    @Override // com.kwad.sdk.core.config.item.AbstractC10254b
    /* renamed from: a */
    public final void mo26480a(@NonNull SharedPreferences sharedPreferences) {
        setValue(Integer.valueOf(m26492aT(ServiceProvider.m24363KO())));
    }

    @Override // com.kwad.sdk.core.config.item.AbstractC10254b
    /* renamed from: b */
    public final void mo26479b(@NonNull SharedPreferences.Editor editor) {
        m26491h(ServiceProvider.m24363KO(), getValue().intValue());
    }

    @Override // com.kwad.sdk.core.config.item.AbstractC10254b
    /* renamed from: k */
    public final void mo26478k(JSONObject jSONObject) {
        if (jSONObject != null) {
            setValue(Integer.valueOf(jSONObject.optInt(getKey(), m26495CH().intValue())));
        } else {
            setValue(m26495CH());
        }
    }
}

package com.umeng.commonsdk.statistics.idtracking;

import android.content.Context;
import android.content.SharedPreferences;
import com.umeng.analytics.pro.PathCenter;
import com.umeng.commonsdk.config.FieldManager;
import com.umeng.commonsdk.utils.UMConstant;

/* renamed from: com.umeng.commonsdk.statistics.idtracking.h */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class OaidTracking extends AbstractIdTracker {

    /* renamed from: a */
    public static final String f39002a = PathCenter.m14695b().m14694b(PathCenter.f37693l);

    /* renamed from: b */
    public static final String f39003b = "key_umeng_sp_oaid";

    /* renamed from: c */
    public static final String f39004c = "key_umeng_sp_oaid_required_time";

    /* renamed from: d */
    private static final String f39005d = "oaid";

    /* renamed from: e */
    private Context f39006e;

    public OaidTracking(Context context) {
        super(f39005d);
        this.f39006e = context;
    }

    @Override // com.umeng.commonsdk.statistics.idtracking.AbstractIdTracker
    /* renamed from: f */
    public String mo13690f() {
        if (FieldManager.allow(UMConstant.f39161G)) {
            try {
                SharedPreferences sharedPreferences = this.f39006e.getSharedPreferences(f39002a, 0);
                if (sharedPreferences != null) {
                    return sharedPreferences.getString(f39003b, "");
                }
                return null;
            } catch (Throwable unused) {
                return null;
            }
        }
        return null;
    }
}

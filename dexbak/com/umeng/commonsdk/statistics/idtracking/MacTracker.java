package com.umeng.commonsdk.statistics.idtracking;

import android.content.Context;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.statistics.AnalyticsConstants;
import com.umeng.commonsdk.statistics.common.DeviceConfig;

/* renamed from: com.umeng.commonsdk.statistics.idtracking.g */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class MacTracker extends AbstractIdTracker {

    /* renamed from: a */
    private static final String f39000a = "mac";

    /* renamed from: b */
    private Context f39001b;

    public MacTracker(Context context) {
        super("mac");
        this.f39001b = context;
    }

    @Override // com.umeng.commonsdk.statistics.idtracking.AbstractIdTracker
    /* renamed from: f */
    public String mo13690f() {
        try {
            return DeviceConfig.getMac(this.f39001b);
        } catch (Exception e) {
            if (AnalyticsConstants.UM_DEBUG) {
                e.printStackTrace();
            }
            UMCrashManager.reportCrash(this.f39001b, e);
            return null;
        }
    }
}

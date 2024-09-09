package com.umeng.commonsdk.statistics.idtracking;

import android.content.Context;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.statistics.AnalyticsConstants;
import com.umeng.commonsdk.statistics.common.DeviceConfig;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: MacTracker.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class g extends a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f53635a = "mac";

    /* renamed from: b  reason: collision with root package name */
    private Context f53636b;

    public g(Context context) {
        super("mac");
        this.f53636b = context;
    }

    @Override // com.umeng.commonsdk.statistics.idtracking.a
    public String f() {
        try {
            return DeviceConfig.getMac(this.f53636b);
        } catch (Exception e4) {
            if (AnalyticsConstants.UM_DEBUG) {
                e4.printStackTrace();
            }
            UMCrashManager.reportCrash(this.f53636b, e4);
            return null;
        }
    }
}

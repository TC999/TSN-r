package com.umeng.analytics.pro;

import android.content.SharedPreferences;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.service.UMGlobalContext;

/* renamed from: com.umeng.analytics.pro.af */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class LaunchTimesCondition implements ActionCondition {

    /* renamed from: a */
    private int f37609a;

    public LaunchTimesCondition(int i) {
        this.f37609a = i;
    }

    @Override // com.umeng.analytics.pro.ActionCondition
    /* renamed from: a */
    public boolean mo14750a() {
        long j = 0;
        try {
            SharedPreferences m14703a = SpWrapper.m14703a(UMGlobalContext.getAppContext());
            if (m14703a != null) {
                j = m14703a.getLong(SpWrapper.f37665a, 0L);
                if (j >= this.f37609a) {
                    return true;
                }
            }
        } catch (Throwable unused) {
        }
        UMRTLog.m14008i(UMRTLog.RTLOG_TAG, "launch times skipped. times: " + j + " ; config: " + this.f37609a);
        return false;
    }

    @Override // com.umeng.analytics.pro.ActionCondition
    /* renamed from: b */
    public boolean mo14749b() {
        return !mo14750a();
    }

    @Override // com.umeng.analytics.pro.ActionCondition
    /* renamed from: c */
    public long mo14748c() {
        return 0L;
    }
}

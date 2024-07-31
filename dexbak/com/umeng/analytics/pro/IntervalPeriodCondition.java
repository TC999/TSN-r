package com.umeng.analytics.pro;

import android.content.SharedPreferences;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.service.UMGlobalContext;

/* renamed from: com.umeng.analytics.pro.ae */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class IntervalPeriodCondition implements ActionCondition {

    /* renamed from: a */
    private String f37607a;

    /* renamed from: b */
    private long f37608b;

    public IntervalPeriodCondition(String str, long j) {
        this.f37607a = str;
        this.f37608b = j;
    }

    @Override // com.umeng.analytics.pro.ActionCondition
    /* renamed from: a */
    public boolean mo14750a() {
        try {
            String str = SpWrapper.f37666b + this.f37607a;
            SharedPreferences m14703a = SpWrapper.m14703a(UMGlobalContext.getAppContext());
            if (m14703a != null) {
                long currentTimeMillis = System.currentTimeMillis() - m14703a.getLong(str, 0L);
                if (currentTimeMillis > this.f37608b * 1000) {
                    return true;
                }
                UMRTLog.m14008i(UMRTLog.RTLOG_TAG, "internal period skipped. elapse: " + currentTimeMillis + "; config: " + (this.f37608b * 1000));
                return false;
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
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

package com.umeng.analytics.pro;

import android.content.SharedPreferences;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.service.UMGlobalContext;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: IntervalPeriodCondition.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class ae implements aa {

    /* renamed from: a  reason: collision with root package name */
    private String f52501a;

    /* renamed from: b  reason: collision with root package name */
    private long f52502b;

    public ae(String str, long j4) {
        this.f52501a = str;
        this.f52502b = j4;
    }

    @Override // com.umeng.analytics.pro.aa
    public boolean a() {
        try {
            String str = "interval_" + this.f52501a;
            SharedPreferences a4 = ar.a(UMGlobalContext.getAppContext());
            if (a4 != null) {
                long currentTimeMillis = System.currentTimeMillis() - a4.getLong(str, 0L);
                if (currentTimeMillis > this.f52502b * 1000) {
                    return true;
                }
                UMRTLog.i("MobclickRT", "internal period skipped. elapse: " + currentTimeMillis + "; config: " + (this.f52502b * 1000));
                return false;
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    @Override // com.umeng.analytics.pro.aa
    public boolean b() {
        return !a();
    }

    @Override // com.umeng.analytics.pro.aa
    public long c() {
        return 0L;
    }
}

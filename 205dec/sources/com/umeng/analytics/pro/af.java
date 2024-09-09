package com.umeng.analytics.pro;

import android.content.SharedPreferences;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.service.UMGlobalContext;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: LaunchTimesCondition.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class af implements aa {

    /* renamed from: a  reason: collision with root package name */
    private int f52503a;

    public af(int i4) {
        this.f52503a = i4;
    }

    @Override // com.umeng.analytics.pro.aa
    public boolean a() {
        long j4 = 0;
        try {
            SharedPreferences a4 = ar.a(UMGlobalContext.getAppContext());
            if (a4 != null) {
                j4 = a4.getLong("cl_count", 0L);
                if (j4 >= this.f52503a) {
                    return true;
                }
            }
        } catch (Throwable unused) {
        }
        UMRTLog.i("MobclickRT", "launch times skipped. times: " + j4 + " ; config: " + this.f52503a);
        return false;
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

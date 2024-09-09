package com.umeng.analytics.pro;

import android.content.Context;
import android.content.SharedPreferences;
import com.umeng.analytics.AnalyticsConfig;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;
import com.umeng.commonsdk.utils.UMUtils;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: SessionIdGenerateServiceImpl.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class x implements w {

    /* renamed from: a  reason: collision with root package name */
    private long f53144a = AnalyticsConfig.kContinueSessionMillis;

    @Override // com.umeng.analytics.pro.w
    public void a(long j4) {
        this.f53144a = j4;
    }

    @Override // com.umeng.analytics.pro.w
    public long a() {
        return this.f53144a;
    }

    @Override // com.umeng.analytics.pro.w
    public String a(Context context) {
        String appkey = UMUtils.getAppkey(context);
        long currentTimeMillis = System.currentTimeMillis();
        if (appkey != null) {
            return UMUtils.MD5(currentTimeMillis + appkey + "02:00:00:00:00:00");
        }
        throw new RuntimeException("Appkey is null or empty, Please check!");
    }

    @Override // com.umeng.analytics.pro.w
    public boolean a(long j4, long j5) {
        long currentTimeMillis = System.currentTimeMillis();
        return (j4 == 0 || currentTimeMillis - j4 >= this.f53144a) && j5 > 0 && currentTimeMillis - j5 > this.f53144a;
    }

    @Override // com.umeng.analytics.pro.w
    public void a(Context context, String str) {
        long currentTimeMillis = System.currentTimeMillis();
        try {
            SharedPreferences.Editor edit = PreferenceWrapper.getDefault(context).edit();
            edit.putString("session_id", str);
            edit.putLong("session_end_time", 0L);
            edit.putLong("a_start_time", currentTimeMillis);
            edit.putLong("a_end_time", 0L);
            edit.commit();
        } catch (Exception unused) {
        }
    }
}

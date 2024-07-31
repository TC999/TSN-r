package com.umeng.analytics.pro;

import android.content.Context;
import android.content.SharedPreferences;
import com.umeng.analytics.AnalyticsConfig;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;
import com.umeng.commonsdk.utils.UMUtils;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.umeng.analytics.pro.x */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class SessionIdGenerateServiceImpl implements SessionIdGenerateService {

    /* renamed from: a */
    private long f38473a = AnalyticsConfig.kContinueSessionMillis;

    @Override // com.umeng.analytics.pro.SessionIdGenerateService
    /* renamed from: a */
    public void mo14163a(long j) {
        this.f38473a = j;
    }

    @Override // com.umeng.analytics.pro.SessionIdGenerateService
    /* renamed from: a */
    public long mo14164a() {
        return this.f38473a;
    }

    @Override // com.umeng.analytics.pro.SessionIdGenerateService
    /* renamed from: a */
    public String mo14161a(Context context) {
        String appkey = UMUtils.getAppkey(context);
        long currentTimeMillis = System.currentTimeMillis();
        if (appkey != null) {
            return UMUtils.MD5(currentTimeMillis + appkey + "02:00:00:00:00:00");
        }
        throw new RuntimeException("Appkey is null or empty, Please check!");
    }

    @Override // com.umeng.analytics.pro.SessionIdGenerateService
    /* renamed from: a */
    public boolean mo14162a(long j, long j2) {
        long currentTimeMillis = System.currentTimeMillis();
        return (j == 0 || currentTimeMillis - j >= this.f38473a) && j2 > 0 && currentTimeMillis - j2 > this.f38473a;
    }

    @Override // com.umeng.analytics.pro.SessionIdGenerateService
    /* renamed from: a */
    public void mo14160a(Context context, String str) {
        long currentTimeMillis = System.currentTimeMillis();
        try {
            SharedPreferences.Editor edit = PreferenceWrapper.getDefault(context).edit();
            edit.putString("session_id", str);
            edit.putLong(SessionTracker.f38454b, 0L);
            edit.putLong(SessionTracker.f38457e, currentTimeMillis);
            edit.putLong(SessionTracker.f38458f, 0L);
            edit.commit();
        } catch (Exception unused) {
        }
    }
}

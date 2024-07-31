package com.umeng.analytics.filter;

import android.text.TextUtils;
import com.umeng.analytics.AnalyticsConfig;

/* renamed from: com.umeng.analytics.filter.b */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class EventWhiteList extends EventList {

    /* renamed from: a */
    private SmartDict f37586a;

    /* renamed from: b */
    private Object f37587b;

    public EventWhiteList(String str, String str2) {
        super(str, str2);
        this.f37587b = new Object();
    }

    @Override // com.umeng.analytics.filter.EventList
    protected void eventListChange() {
        if (TextUtils.isEmpty(this.mEventList)) {
            return;
        }
        synchronized (this.f37587b) {
            this.f37586a = null;
            this.f37586a = new SmartDict(true, this.mEventList);
        }
    }

    @Override // com.umeng.analytics.filter.EventList
    public boolean matchHit(String str) {
        boolean m14772a;
        if (TextUtils.isEmpty(this.mEventList)) {
            return true;
        }
        synchronized (this.f37587b) {
            if (this.f37586a == null) {
                this.f37586a = new SmartDict(true, this.mEventList);
            }
            m14772a = this.f37586a.m14772a(str);
        }
        return m14772a;
    }

    @Override // com.umeng.analytics.filter.EventList
    public void setMD5ClearFlag(boolean z) {
        AnalyticsConfig.CLEAR_EKV_WL = z;
    }
}

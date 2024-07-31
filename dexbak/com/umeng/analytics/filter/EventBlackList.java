package com.umeng.analytics.filter;

import android.text.TextUtils;
import com.umeng.analytics.AnalyticsConfig;

/* renamed from: com.umeng.analytics.filter.a */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class EventBlackList extends EventList {

    /* renamed from: a */
    private SmartDict f37584a;

    /* renamed from: b */
    private Object f37585b;

    public EventBlackList(String str, String str2) {
        super(str, str2);
        this.f37585b = new Object();
    }

    @Override // com.umeng.analytics.filter.EventList
    protected void eventListChange() {
        if (TextUtils.isEmpty(this.mEventList)) {
            return;
        }
        synchronized (this.f37585b) {
            this.f37584a = null;
            this.f37584a = new SmartDict(false, this.mEventList);
        }
    }

    @Override // com.umeng.analytics.filter.EventList
    public boolean matchHit(String str) {
        boolean m14772a;
        if (TextUtils.isEmpty(this.mEventList)) {
            return false;
        }
        synchronized (this.f37585b) {
            if (this.f37584a == null) {
                this.f37584a = new SmartDict(false, this.mEventList);
            }
            m14772a = this.f37584a.m14772a(str);
        }
        return m14772a;
    }

    @Override // com.umeng.analytics.filter.EventList
    public void setMD5ClearFlag(boolean z) {
        AnalyticsConfig.CLEAR_EKV_BL = z;
    }
}

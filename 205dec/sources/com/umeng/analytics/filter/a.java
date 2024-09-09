package com.umeng.analytics.filter;

import android.text.TextUtils;
import com.umeng.analytics.AnalyticsConfig;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: EventBlackList.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class a extends EventList {

    /* renamed from: a  reason: collision with root package name */
    private d f52478a;

    /* renamed from: b  reason: collision with root package name */
    private Object f52479b;

    public a(String str, String str2) {
        super(str, str2);
        this.f52479b = new Object();
    }

    @Override // com.umeng.analytics.filter.EventList
    protected void eventListChange() {
        if (TextUtils.isEmpty(this.mEventList)) {
            return;
        }
        synchronized (this.f52479b) {
            this.f52478a = null;
            this.f52478a = new d(false, this.mEventList);
        }
    }

    @Override // com.umeng.analytics.filter.EventList
    public boolean matchHit(String str) {
        boolean a4;
        if (TextUtils.isEmpty(this.mEventList)) {
            return false;
        }
        synchronized (this.f52479b) {
            if (this.f52478a == null) {
                this.f52478a = new d(false, this.mEventList);
            }
            a4 = this.f52478a.a(str);
        }
        return a4;
    }

    @Override // com.umeng.analytics.filter.EventList
    public void setMD5ClearFlag(boolean z3) {
        AnalyticsConfig.CLEAR_EKV_BL = z3;
    }
}

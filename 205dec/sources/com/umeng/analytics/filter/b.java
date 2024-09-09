package com.umeng.analytics.filter;

import android.text.TextUtils;
import com.umeng.analytics.AnalyticsConfig;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: EventWhiteList.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class b extends EventList {

    /* renamed from: a  reason: collision with root package name */
    private d f52480a;

    /* renamed from: b  reason: collision with root package name */
    private Object f52481b;

    public b(String str, String str2) {
        super(str, str2);
        this.f52481b = new Object();
    }

    @Override // com.umeng.analytics.filter.EventList
    protected void eventListChange() {
        if (TextUtils.isEmpty(this.mEventList)) {
            return;
        }
        synchronized (this.f52481b) {
            this.f52480a = null;
            this.f52480a = new d(true, this.mEventList);
        }
    }

    @Override // com.umeng.analytics.filter.EventList
    public boolean matchHit(String str) {
        boolean a4;
        if (TextUtils.isEmpty(this.mEventList)) {
            return true;
        }
        synchronized (this.f52481b) {
            if (this.f52480a == null) {
                this.f52480a = new d(true, this.mEventList);
            }
            a4 = this.f52480a.a(str);
        }
        return a4;
    }

    @Override // com.umeng.analytics.filter.EventList
    public void setMD5ClearFlag(boolean z3) {
        AnalyticsConfig.CLEAR_EKV_WL = z3;
    }
}

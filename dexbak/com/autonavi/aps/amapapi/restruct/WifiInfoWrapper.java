package com.autonavi.aps.amapapi.restruct;

import android.net.wifi.WifiInfo;
import android.text.TextUtils;
import com.autonavi.aps.amapapi.utils.C2432j;

/* renamed from: com.autonavi.aps.amapapi.restruct.j */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class WifiInfoWrapper {

    /* renamed from: a */
    private WifiInfo f8182a;

    /* renamed from: b */
    private String f8183b;

    /* renamed from: c */
    private String f8184c;

    /* renamed from: d */
    private int f8185d = -1;

    public WifiInfoWrapper(WifiInfo wifiInfo) {
        this.f8182a = wifiInfo;
    }

    /* renamed from: a */
    public final String m51498a() {
        if (this.f8184c == null) {
            this.f8184c = SystemApiWrapper.m51511a(this.f8182a);
        }
        return this.f8184c;
    }

    /* renamed from: b */
    public final String m51497b() {
        if (this.f8183b == null) {
            this.f8183b = SystemApiWrapper.m51510b(this.f8182a);
        }
        return this.f8183b;
    }

    /* renamed from: c */
    public final int m51496c() {
        if (this.f8185d == -1) {
            this.f8185d = SystemApiWrapper.m51509c(this.f8182a);
        }
        return this.f8185d;
    }

    /* renamed from: d */
    public final boolean m51495d() {
        return (this.f8182a == null || TextUtils.isEmpty(m51497b()) || !C2432j.m51191a(m51498a())) ? false : true;
    }
}

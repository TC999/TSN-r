package cn.jiguang.ad;

import android.content.Intent;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public String f2094a;

    /* renamed from: b  reason: collision with root package name */
    public String f2095b;

    /* renamed from: c  reason: collision with root package name */
    public int f2096c;

    /* renamed from: d  reason: collision with root package name */
    public String f2097d;

    /* renamed from: e  reason: collision with root package name */
    public Intent f2098e;

    /* renamed from: f  reason: collision with root package name */
    public Intent f2099f;

    /* renamed from: h  reason: collision with root package name */
    public String f2101h;

    /* renamed from: i  reason: collision with root package name */
    public String f2102i;

    /* renamed from: j  reason: collision with root package name */
    public int f2103j;

    /* renamed from: g  reason: collision with root package name */
    public int f2100g = 0;

    /* renamed from: k  reason: collision with root package name */
    public int f2104k = 0;

    public c() {
    }

    public c(String str, String str2, int i4) {
        this.f2094a = str;
        this.f2095b = str2;
        this.f2096c = i4;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        String str = this.f2094a;
        String str2 = ((c) obj).f2094a;
        return str != null ? str.equals(str2) : str2 == null;
    }

    public String toString() {
        return "JWakeTargetInfo{packageName='" + this.f2094a + "', serviceName='" + this.f2095b + "', targetVersion=" + this.f2096c + ", providerAuthority='" + this.f2097d + "', activityIntent=" + this.f2098e + ", activityIntentBackup=" + this.f2099f + ", wakeType=" + this.f2100g + ", authenType=" + this.f2101h + ", instrumentationName=" + this.f2102i + ", cmd=" + this.f2103j + ", delaySecTime=" + this.f2104k + '}';
    }
}

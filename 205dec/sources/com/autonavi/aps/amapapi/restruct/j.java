package com.autonavi.aps.amapapi.restruct;

import android.net.wifi.WifiInfo;
import android.text.TextUtils;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: WifiInfoWrapper.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class j {

    /* renamed from: a  reason: collision with root package name */
    private WifiInfo f11859a;

    /* renamed from: b  reason: collision with root package name */
    private String f11860b;

    /* renamed from: c  reason: collision with root package name */
    private String f11861c;

    /* renamed from: d  reason: collision with root package name */
    private int f11862d = -1;

    public j(WifiInfo wifiInfo) {
        this.f11859a = wifiInfo;
    }

    public final String a() {
        if (this.f11861c == null) {
            this.f11861c = h.a(this.f11859a);
        }
        return this.f11861c;
    }

    public final String b() {
        if (this.f11860b == null) {
            this.f11860b = h.b(this.f11859a);
        }
        return this.f11860b;
    }

    public final int c() {
        if (this.f11862d == -1) {
            this.f11862d = h.c(this.f11859a);
        }
        return this.f11862d;
    }

    public final boolean d() {
        return (this.f11859a == null || TextUtils.isEmpty(b()) || !com.autonavi.aps.amapapi.utils.j.a(a())) ? false : true;
    }
}

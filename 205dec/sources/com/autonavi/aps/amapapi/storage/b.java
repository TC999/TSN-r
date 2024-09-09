package com.autonavi.aps.amapapi.storage;

import com.amap.api.col.p0003l.hk;
import com.amap.api.col.p0003l.hl;
import com.amap.api.location.AMapLocation;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: LastLocationInfo.java */
@hk(a = "c")
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class b {
    @hl(a = "a2", b = 6)

    /* renamed from: a  reason: collision with root package name */
    private String f11909a;
    @hl(a = "a3", b = 5)

    /* renamed from: b  reason: collision with root package name */
    private long f11910b;
    @hl(a = "a4", b = 6)

    /* renamed from: c  reason: collision with root package name */
    private String f11911c;

    /* renamed from: d  reason: collision with root package name */
    private AMapLocation f11912d;

    public final AMapLocation a() {
        return this.f11912d;
    }

    public final String b() {
        return this.f11911c;
    }

    public final String c() {
        return this.f11909a;
    }

    public final long d() {
        return this.f11910b;
    }

    public final void a(AMapLocation aMapLocation) {
        this.f11912d = aMapLocation;
    }

    public final void b(String str) {
        this.f11909a = str;
    }

    public final void a(String str) {
        this.f11911c = str;
    }

    public final void a(long j4) {
        this.f11910b = j4;
    }
}

package com.autonavi.aps.amapapi.storage;

import com.amap.api.col.p0463l.EntityClass;
import com.amap.api.col.p0463l.EntityField;
import com.amap.api.location.AMapLocation;

@EntityClass(m54740a = "c")
/* renamed from: com.autonavi.aps.amapapi.storage.b */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class LastLocationInfo {
    @EntityField(m54738a = "a2", m54737b = 6)

    /* renamed from: a */
    private String f8237a;
    @EntityField(m54738a = "a3", m54737b = 5)

    /* renamed from: b */
    private long f8238b;
    @EntityField(m54738a = "a4", m54737b = 6)

    /* renamed from: c */
    private String f8239c;

    /* renamed from: d */
    private AMapLocation f8240d;

    /* renamed from: a */
    public final AMapLocation m51421a() {
        return this.f8240d;
    }

    /* renamed from: b */
    public final String m51417b() {
        return this.f8239c;
    }

    /* renamed from: c */
    public final String m51415c() {
        return this.f8237a;
    }

    /* renamed from: d */
    public final long m51414d() {
        return this.f8238b;
    }

    /* renamed from: a */
    public final void m51419a(AMapLocation aMapLocation) {
        this.f8240d = aMapLocation;
    }

    /* renamed from: b */
    public final void m51416b(String str) {
        this.f8237a = str;
    }

    /* renamed from: a */
    public final void m51418a(String str) {
        this.f8239c = str;
    }

    /* renamed from: a */
    public final void m51420a(long j) {
        this.f8238b = j;
    }
}

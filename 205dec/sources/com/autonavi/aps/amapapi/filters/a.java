package com.autonavi.aps.amapapi.filters;

import android.text.TextUtils;
import com.amap.api.location.AMapLocation;
import com.autonavi.aps.amapapi.utils.j;
import com.bytedance.pangle.sdk.component.log.impl.event.policy.PolicyConfig;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: LocFilter.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    com.autonavi.aps.amapapi.model.a f11743a = null;

    /* renamed from: b  reason: collision with root package name */
    long f11744b = 0;

    /* renamed from: c  reason: collision with root package name */
    long f11745c = 0;

    /* renamed from: h  reason: collision with root package name */
    private boolean f11750h = true;

    /* renamed from: d  reason: collision with root package name */
    int f11746d = 0;

    /* renamed from: e  reason: collision with root package name */
    long f11747e = 0;

    /* renamed from: f  reason: collision with root package name */
    AMapLocation f11748f = null;

    /* renamed from: g  reason: collision with root package name */
    long f11749g = 0;

    private com.autonavi.aps.amapapi.model.a b(com.autonavi.aps.amapapi.model.a aVar) {
        if (j.a(aVar)) {
            if (this.f11750h && com.autonavi.aps.amapapi.utils.a.a(aVar.getTime())) {
                if (aVar.getLocationType() == 5 || aVar.getLocationType() == 6) {
                    aVar.setLocationType(4);
                }
            } else {
                aVar.setLocationType(this.f11746d);
            }
        }
        return aVar;
    }

    public final void a() {
        this.f11743a = null;
        this.f11744b = 0L;
        this.f11745c = 0L;
        this.f11748f = null;
        this.f11749g = 0L;
    }

    public final com.autonavi.aps.amapapi.model.a a(com.autonavi.aps.amapapi.model.a aVar) {
        if (j.b() - this.f11747e > PolicyConfig.mServerBusyRetryBaseInternal) {
            this.f11743a = aVar;
            this.f11747e = j.b();
            return this.f11743a;
        }
        this.f11747e = j.b();
        if (j.a(this.f11743a) && j.a(aVar)) {
            if (aVar.getTime() != this.f11743a.getTime() || aVar.getAccuracy() >= 300.0f) {
                if ("gps".equals(aVar.getProvider())) {
                    this.f11744b = j.b();
                    this.f11743a = aVar;
                    return aVar;
                } else if (aVar.c() != this.f11743a.c()) {
                    this.f11744b = j.b();
                    this.f11743a = aVar;
                    return aVar;
                } else if (aVar.getBuildingId() != null && !aVar.getBuildingId().equals(this.f11743a.getBuildingId()) && !TextUtils.isEmpty(aVar.getBuildingId())) {
                    this.f11744b = j.b();
                    this.f11743a = aVar;
                    return aVar;
                } else {
                    this.f11746d = aVar.getLocationType();
                    float a4 = j.a(aVar, this.f11743a);
                    float accuracy = this.f11743a.getAccuracy();
                    float accuracy2 = aVar.getAccuracy();
                    float f4 = accuracy2 - accuracy;
                    long b4 = j.b();
                    long j4 = b4 - this.f11744b;
                    boolean z3 = true;
                    boolean z4 = accuracy <= 100.0f && accuracy2 > 299.0f;
                    z3 = (accuracy <= 299.0f || accuracy2 <= 299.0f) ? false : false;
                    if (z4 || z3) {
                        long j5 = this.f11745c;
                        if (j5 == 0) {
                            this.f11745c = b4;
                        } else if (b4 - j5 > PolicyConfig.mServerBusyRetryBaseInternal) {
                            this.f11744b = b4;
                            this.f11743a = aVar;
                            this.f11745c = 0L;
                            return aVar;
                        }
                        com.autonavi.aps.amapapi.model.a b5 = b(this.f11743a);
                        this.f11743a = b5;
                        return b5;
                    } else if (accuracy2 < 100.0f && accuracy > 299.0f) {
                        this.f11744b = b4;
                        this.f11743a = aVar;
                        this.f11745c = 0L;
                        return aVar;
                    } else {
                        if (accuracy2 <= 299.0f) {
                            this.f11745c = 0L;
                        }
                        if (a4 >= 10.0f || a4 <= 0.1d || accuracy2 <= 5.0f) {
                            if (f4 < 300.0f) {
                                this.f11744b = j.b();
                                this.f11743a = aVar;
                                return aVar;
                            } else if (j4 >= PolicyConfig.mServerBusyRetryBaseInternal) {
                                this.f11744b = j.b();
                                this.f11743a = aVar;
                                return aVar;
                            } else {
                                com.autonavi.aps.amapapi.model.a b6 = b(this.f11743a);
                                this.f11743a = b6;
                                return b6;
                            }
                        } else if (f4 >= -300.0f) {
                            com.autonavi.aps.amapapi.model.a b7 = b(this.f11743a);
                            this.f11743a = b7;
                            return b7;
                        } else if (accuracy / accuracy2 >= 2.0f) {
                            this.f11744b = b4;
                            this.f11743a = aVar;
                            return aVar;
                        } else {
                            com.autonavi.aps.amapapi.model.a b8 = b(this.f11743a);
                            this.f11743a = b8;
                            return b8;
                        }
                    }
                }
            }
            return aVar;
        }
        this.f11744b = j.b();
        this.f11743a = aVar;
        return aVar;
    }

    public final void a(boolean z3) {
        this.f11750h = z3;
    }

    public final AMapLocation a(AMapLocation aMapLocation) {
        if (j.a(aMapLocation)) {
            long b4 = j.b() - this.f11749g;
            this.f11749g = j.b();
            if (b4 > 5000) {
                return aMapLocation;
            }
            AMapLocation aMapLocation2 = this.f11748f;
            if (aMapLocation2 == null) {
                this.f11748f = aMapLocation;
                return aMapLocation;
            } else if (1 != aMapLocation2.getLocationType() && !"gps".equalsIgnoreCase(this.f11748f.getProvider())) {
                this.f11748f = aMapLocation;
                return aMapLocation;
            } else if (this.f11748f.getAltitude() == aMapLocation.getAltitude() && this.f11748f.getLongitude() == aMapLocation.getLongitude()) {
                this.f11748f = aMapLocation;
                return aMapLocation;
            } else {
                long abs = Math.abs(aMapLocation.getTime() - this.f11748f.getTime());
                if (PolicyConfig.mServerBusyRetryBaseInternal < abs) {
                    this.f11748f = aMapLocation;
                    return aMapLocation;
                } else if (j.a(aMapLocation, this.f11748f) > (((this.f11748f.getSpeed() + aMapLocation.getSpeed()) * ((float) abs)) / 2000.0f) + ((this.f11748f.getAccuracy() + aMapLocation.getAccuracy()) * 2.0f) + 3000.0f) {
                    return this.f11748f;
                } else {
                    this.f11748f = aMapLocation;
                    return aMapLocation;
                }
            }
        }
        return aMapLocation;
    }
}

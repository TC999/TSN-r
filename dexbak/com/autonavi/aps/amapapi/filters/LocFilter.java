package com.autonavi.aps.amapapi.filters;

import android.text.TextUtils;
import com.amap.api.location.AMapLocation;
import com.amap.api.services.geocoder.GeocodeSearch;
import com.autonavi.aps.amapapi.model.AMapLocationServer;
import com.autonavi.aps.amapapi.utils.AuthUtil;
import com.autonavi.aps.amapapi.utils.C2432j;

/* renamed from: com.autonavi.aps.amapapi.filters.a */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class LocFilter {

    /* renamed from: a */
    AMapLocationServer f8066a = null;

    /* renamed from: b */
    long f8067b = 0;

    /* renamed from: c */
    long f8068c = 0;

    /* renamed from: h */
    private boolean f8073h = true;

    /* renamed from: d */
    int f8069d = 0;

    /* renamed from: e */
    long f8070e = 0;

    /* renamed from: f */
    AMapLocation f8071f = null;

    /* renamed from: g */
    long f8072g = 0;

    /* renamed from: b */
    private AMapLocationServer m51636b(AMapLocationServer aMapLocationServer) {
        if (C2432j.m51194a(aMapLocationServer)) {
            if (this.f8073h && AuthUtil.m51348a(aMapLocationServer.getTime())) {
                if (aMapLocationServer.getLocationType() == 5 || aMapLocationServer.getLocationType() == 6) {
                    aMapLocationServer.setLocationType(4);
                }
            } else {
                aMapLocationServer.setLocationType(this.f8069d);
            }
        }
        return aMapLocationServer;
    }

    /* renamed from: a */
    public final void m51640a() {
        this.f8066a = null;
        this.f8067b = 0L;
        this.f8068c = 0L;
        this.f8071f = null;
        this.f8072g = 0L;
    }

    /* renamed from: a */
    public final AMapLocationServer m51638a(AMapLocationServer aMapLocationServer) {
        if (C2432j.m51186b() - this.f8070e > 30000) {
            this.f8066a = aMapLocationServer;
            this.f8070e = C2432j.m51186b();
            return this.f8066a;
        }
        this.f8070e = C2432j.m51186b();
        if (C2432j.m51194a(this.f8066a) && C2432j.m51194a(aMapLocationServer)) {
            if (aMapLocationServer.getTime() != this.f8066a.getTime() || aMapLocationServer.getAccuracy() >= 300.0f) {
                if (GeocodeSearch.GPS.equals(aMapLocationServer.getProvider())) {
                    this.f8067b = C2432j.m51186b();
                    this.f8066a = aMapLocationServer;
                    return aMapLocationServer;
                } else if (aMapLocationServer.m51627c() != this.f8066a.m51627c()) {
                    this.f8067b = C2432j.m51186b();
                    this.f8066a = aMapLocationServer;
                    return aMapLocationServer;
                } else if (aMapLocationServer.getBuildingId() != null && !aMapLocationServer.getBuildingId().equals(this.f8066a.getBuildingId()) && !TextUtils.isEmpty(aMapLocationServer.getBuildingId())) {
                    this.f8067b = C2432j.m51186b();
                    this.f8066a = aMapLocationServer;
                    return aMapLocationServer;
                } else {
                    this.f8069d = aMapLocationServer.getLocationType();
                    float m51196a = C2432j.m51196a(aMapLocationServer, this.f8066a);
                    float accuracy = this.f8066a.getAccuracy();
                    float accuracy2 = aMapLocationServer.getAccuracy();
                    float f = accuracy2 - accuracy;
                    long m51186b = C2432j.m51186b();
                    long j = m51186b - this.f8067b;
                    boolean z = true;
                    boolean z2 = accuracy <= 100.0f && accuracy2 > 299.0f;
                    z = (accuracy <= 299.0f || accuracy2 <= 299.0f) ? false : false;
                    if (z2 || z) {
                        long j2 = this.f8068c;
                        if (j2 == 0) {
                            this.f8068c = m51186b;
                        } else if (m51186b - j2 > 30000) {
                            this.f8067b = m51186b;
                            this.f8066a = aMapLocationServer;
                            this.f8068c = 0L;
                            return aMapLocationServer;
                        }
                        AMapLocationServer m51636b = m51636b(this.f8066a);
                        this.f8066a = m51636b;
                        return m51636b;
                    } else if (accuracy2 < 100.0f && accuracy > 299.0f) {
                        this.f8067b = m51186b;
                        this.f8066a = aMapLocationServer;
                        this.f8068c = 0L;
                        return aMapLocationServer;
                    } else {
                        if (accuracy2 <= 299.0f) {
                            this.f8068c = 0L;
                        }
                        if (m51196a >= 10.0f || m51196a <= 0.1d || accuracy2 <= 5.0f) {
                            if (f < 300.0f) {
                                this.f8067b = C2432j.m51186b();
                                this.f8066a = aMapLocationServer;
                                return aMapLocationServer;
                            } else if (j >= 30000) {
                                this.f8067b = C2432j.m51186b();
                                this.f8066a = aMapLocationServer;
                                return aMapLocationServer;
                            } else {
                                AMapLocationServer m51636b2 = m51636b(this.f8066a);
                                this.f8066a = m51636b2;
                                return m51636b2;
                            }
                        } else if (f >= -300.0f) {
                            AMapLocationServer m51636b3 = m51636b(this.f8066a);
                            this.f8066a = m51636b3;
                            return m51636b3;
                        } else if (accuracy / accuracy2 >= 2.0f) {
                            this.f8067b = m51186b;
                            this.f8066a = aMapLocationServer;
                            return aMapLocationServer;
                        } else {
                            AMapLocationServer m51636b4 = m51636b(this.f8066a);
                            this.f8066a = m51636b4;
                            return m51636b4;
                        }
                    }
                }
            }
            return aMapLocationServer;
        }
        this.f8067b = C2432j.m51186b();
        this.f8066a = aMapLocationServer;
        return aMapLocationServer;
    }

    /* renamed from: a */
    public final void m51637a(boolean z) {
        this.f8073h = z;
    }

    /* renamed from: a */
    public final AMapLocation m51639a(AMapLocation aMapLocation) {
        if (C2432j.m51197a(aMapLocation)) {
            long m51186b = C2432j.m51186b() - this.f8072g;
            this.f8072g = C2432j.m51186b();
            if (m51186b > 5000) {
                return aMapLocation;
            }
            AMapLocation aMapLocation2 = this.f8071f;
            if (aMapLocation2 == null) {
                this.f8071f = aMapLocation;
                return aMapLocation;
            } else if (1 != aMapLocation2.getLocationType() && !GeocodeSearch.GPS.equalsIgnoreCase(this.f8071f.getProvider())) {
                this.f8071f = aMapLocation;
                return aMapLocation;
            } else if (this.f8071f.getAltitude() == aMapLocation.getAltitude() && this.f8071f.getLongitude() == aMapLocation.getLongitude()) {
                this.f8071f = aMapLocation;
                return aMapLocation;
            } else {
                long abs = Math.abs(aMapLocation.getTime() - this.f8071f.getTime());
                if (30000 < abs) {
                    this.f8071f = aMapLocation;
                    return aMapLocation;
                } else if (C2432j.m51196a(aMapLocation, this.f8071f) > (((this.f8071f.getSpeed() + aMapLocation.getSpeed()) * ((float) abs)) / 2000.0f) + ((this.f8071f.getAccuracy() + aMapLocation.getAccuracy()) * 2.0f) + 3000.0f) {
                    return this.f8071f;
                } else {
                    this.f8071f = aMapLocation;
                    return aMapLocation;
                }
            }
        }
        return aMapLocation;
    }
}

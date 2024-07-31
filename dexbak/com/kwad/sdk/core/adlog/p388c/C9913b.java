package com.kwad.sdk.core.adlog.p388c;

import com.kwad.sdk.core.adlog.C9893a;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.track.AdTrackLog;
import com.kwad.sdk.p434g.InterfaceC10761a;
import com.kwad.sdk.utils.C11008ac;

/* renamed from: com.kwad.sdk.core.adlog.c.b */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9913b {
    private final C9912a aqr = new C9912a();

    /* renamed from: Bs */
    public final C9912a m27270Bs() {
        return this.aqr;
    }

    /* renamed from: ah */
    public final C9913b m27269ah(long j) {
        this.aqr.f29531vz = j;
        return this;
    }

    /* renamed from: b */
    public final C9913b m27268b(C9893a.C9894a c9894a) {
        this.aqr.f29523KH = c9894a;
        return this;
    }

    /* renamed from: cK */
    public final C9913b m27266cK(int i) {
        this.aqr.f29528kl = i;
        return this;
    }

    /* renamed from: cL */
    public final C9913b m27265cL(int i) {
        this.aqr.apK = i;
        return this;
    }

    /* renamed from: cM */
    public final C9913b m27264cM(int i) {
        this.aqr.apL = i;
        return this;
    }

    /* renamed from: cN */
    public final C9913b m27263cN(int i) {
        this.aqr.downloadSource = i;
        return this;
    }

    /* renamed from: cO */
    public final C9913b m27262cO(int i) {
        this.aqr.apY = i;
        return this;
    }

    /* renamed from: cP */
    public final C9913b m27261cP(int i) {
        this.aqr.aqb = i;
        return this;
    }

    /* renamed from: cQ */
    public final C9913b m27260cQ(int i) {
        this.aqr.aqc = i;
        return this;
    }

    /* renamed from: cR */
    public final C9913b m27259cR(int i) {
        this.aqr.apQ = i;
        return this;
    }

    /* renamed from: cS */
    public final C9913b m27258cS(int i) {
        this.aqr.aqi = i;
        return this;
    }

    /* renamed from: cT */
    public final C9913b m27257cT(int i) {
        this.aqr.aqm = i;
        return this;
    }

    /* renamed from: cU */
    public final C9913b m27256cU(int i) {
        this.aqr.m27280cD(i);
        return this;
    }

    /* renamed from: cV */
    public final C9913b m27255cV(int i) {
        this.aqr.aqo = i;
        return this;
    }

    /* renamed from: cW */
    public final C9913b m27254cW(int i) {
        this.aqr.f29525KJ = i;
        return this;
    }

    /* renamed from: cX */
    public final C9913b m27253cX(int i) {
        this.aqr.aqp = i;
        return this;
    }

    /* renamed from: cY */
    public final C9913b m27252cY(int i) {
        this.aqr.f29524KI = i;
        return this;
    }

    /* renamed from: dd */
    public final C9913b m27251dd(String str) {
        this.aqr.f29522KG = str;
        return this;
    }

    /* renamed from: de */
    public final C9913b m27250de(String str) {
        this.aqr.apZ = str;
        return this;
    }

    /* renamed from: df */
    public final C9913b m27249df(String str) {
        this.aqr.aqa = str;
        return this;
    }

    /* renamed from: dg */
    public final C9913b m27248dg(String str) {
        this.aqr.aqk = str;
        return this;
    }

    /* renamed from: f */
    public final C9913b m27247f(C11008ac.C11009a c11009a) {
        this.aqr.f29529kn = c11009a;
        return this;
    }

    /* renamed from: l */
    public final C9913b m27246l(double d) {
        this.aqr.f29530ko = d;
        return this;
    }

    /* renamed from: v */
    public final C9913b m27245v(int i, int i2) {
        C9912a c9912a = this.aqr;
        c9912a.apM = i + "," + i2;
        return this;
    }

    /* renamed from: b */
    public final C9913b m27267b(AdTemplate adTemplate, String str, String str2, InterfaceC10761a<AdTrackLog> interfaceC10761a) {
        C9912a c9912a = this.aqr;
        if (c9912a.f29523KH == null) {
            c9912a.f29523KH = new C9893a.C9894a();
        }
        this.aqr.f29523KH.m27412a(adTemplate, str, str2, interfaceC10761a);
        return this;
    }
}

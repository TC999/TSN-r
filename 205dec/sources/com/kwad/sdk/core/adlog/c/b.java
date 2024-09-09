package com.kwad.sdk.core.adlog.c;

import com.kwad.sdk.core.adlog.a;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.track.AdTrackLog;
import com.kwad.sdk.utils.ac;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class b {
    private final a aqr = new a();

    public final a Bs() {
        return this.aqr;
    }

    public final b ah(long j4) {
        this.aqr.vz = j4;
        return this;
    }

    public final b b(a.C0688a c0688a) {
        this.aqr.KH = c0688a;
        return this;
    }

    public final b cK(int i4) {
        this.aqr.kl = i4;
        return this;
    }

    public final b cL(int i4) {
        this.aqr.apK = i4;
        return this;
    }

    public final b cM(int i4) {
        this.aqr.apL = i4;
        return this;
    }

    public final b cN(int i4) {
        this.aqr.downloadSource = i4;
        return this;
    }

    public final b cO(int i4) {
        this.aqr.apY = i4;
        return this;
    }

    public final b cP(int i4) {
        this.aqr.aqb = i4;
        return this;
    }

    public final b cQ(int i4) {
        this.aqr.aqc = i4;
        return this;
    }

    public final b cR(int i4) {
        this.aqr.apQ = i4;
        return this;
    }

    public final b cS(int i4) {
        this.aqr.aqi = i4;
        return this;
    }

    public final b cT(int i4) {
        this.aqr.aqm = i4;
        return this;
    }

    public final b cU(int i4) {
        this.aqr.cD(i4);
        return this;
    }

    public final b cV(int i4) {
        this.aqr.aqo = i4;
        return this;
    }

    public final b cW(int i4) {
        this.aqr.KJ = i4;
        return this;
    }

    public final b cX(int i4) {
        this.aqr.aqp = i4;
        return this;
    }

    public final b cY(int i4) {
        this.aqr.KI = i4;
        return this;
    }

    public final b dd(String str) {
        this.aqr.KG = str;
        return this;
    }

    public final b de(String str) {
        this.aqr.apZ = str;
        return this;
    }

    public final b df(String str) {
        this.aqr.aqa = str;
        return this;
    }

    public final b dg(String str) {
        this.aqr.aqk = str;
        return this;
    }

    public final b f(ac.a aVar) {
        this.aqr.kn = aVar;
        return this;
    }

    public final b l(double d4) {
        this.aqr.ko = d4;
        return this;
    }

    public final b v(int i4, int i5) {
        a aVar = this.aqr;
        aVar.apM = i4 + "," + i5;
        return this;
    }

    public final b b(AdTemplate adTemplate, String str, String str2, com.kwad.sdk.g.a<AdTrackLog> aVar) {
        a aVar2 = this.aqr;
        if (aVar2.KH == null) {
            aVar2.KH = new a.C0688a();
        }
        this.aqr.KH.a(adTemplate, str, str2, aVar);
        return this;
    }
}

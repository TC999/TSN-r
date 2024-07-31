package com.kwad.sdk.core.adlog.p388c;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.adlog.C9893a;
import com.kwad.sdk.core.report.C10458h;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.p408a.C10482a;
import com.kwad.sdk.utils.C11008ac;
import org.json.JSONObject;

@KsJson
/* renamed from: com.kwad.sdk.core.adlog.c.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C9912a extends C10482a {

    /* renamed from: KG */
    public String f29522KG;

    /* renamed from: KH */
    public C9893a.C9894a f29523KH;

    /* renamed from: Li */
    public long f29526Li;

    /* renamed from: Om */
    public int f29527Om;
    @NonNull
    public AdTemplate adTemplate;
    public String adnName;
    public int adnType;
    public int aoM;
    public JSONObject apH;
    public int apI;
    public int apJ;
    public int apK;
    public int apL;
    public String apM;
    public int apR;
    public String apS;
    public int apT;
    public int apU;
    public String apW;
    public int apX;
    public int apY;
    public String apZ;
    public String aqa;
    public int aqb;
    public int aqc;
    public long aqd;
    public long aqe;
    public int aqh;
    public int aqi;
    public String aqk;
    public int aqm;
    public int aqn;
    public int aqo;
    public String aqq;
    public int downloadSource;

    /* renamed from: kl */
    public int f29528kl;

    /* renamed from: kn */
    public C11008ac.C11009a f29529kn;

    /* renamed from: ko */
    public double f29530ko;

    /* renamed from: vz */
    public long f29531vz;
    public long apN = -1;
    public int apO = -1;
    public long apP = -1;
    public int apQ = -1;

    /* renamed from: KI */
    public int f29524KI = 0;
    public String apV = "";
    public int aqf = -1;
    public int aqg = -1;
    public int downloadStatus = 0;
    public int aqj = -1;

    /* renamed from: KF */
    public int f29521KF = -1;
    public int aql = -1;
    public int adxResult = -1;

    /* renamed from: KJ */
    public int f29525KJ = -1;
    public int aqp = 0;

    /* renamed from: Br */
    public static C9912a m27285Br() {
        return new C9912a();
    }

    /* renamed from: a */
    public final void m27283a(@Nullable C10458h c10458h) {
        if (c10458h != null) {
            this.aqq = c10458h.m26023EL();
        }
    }

    /* renamed from: af */
    public final C9912a m27282af(long j) {
        this.f29531vz = j;
        return this;
    }

    /* renamed from: ag */
    public final C9912a m27281ag(long j) {
        this.f29526Li = j;
        return this;
    }

    /* renamed from: cD */
    public final void m27280cD(int i) {
        if (i == 0) {
            this.aqn = 1;
        } else if (i == 1) {
            this.aqn = 2;
        } else if (i != 2) {
        } else {
            this.aqn = 3;
        }
    }

    /* renamed from: cE */
    public final C9912a m27279cE(int i) {
        this.f29528kl = i;
        return this;
    }

    /* renamed from: cF */
    public final C9912a m27278cF(int i) {
        this.f29524KI = i;
        return this;
    }

    /* renamed from: cG */
    public final C9912a m27277cG(int i) {
        this.f29525KJ = i;
        return this;
    }

    /* renamed from: cH */
    public final C9912a m27276cH(int i) {
        this.f29521KF = i;
        return this;
    }

    /* renamed from: cI */
    public final C9912a m27275cI(int i) {
        this.f29527Om = i;
        return this;
    }

    /* renamed from: cJ */
    public final C9912a m27274cJ(int i) {
        this.apX = i;
        return this;
    }

    /* renamed from: dc */
    public final C9912a m27273dc(String str) {
        this.f29522KG = str;
        return this;
    }

    /* renamed from: e */
    public final void m27272e(AdTemplate adTemplate, String str, String str2) {
        C9893a.C9894a c9894a = this.f29523KH;
        if (c9894a == null) {
            C9893a.C9894a c9894a2 = new C9893a.C9894a();
            this.f29523KH = c9894a2;
            c9894a2.m27412a(adTemplate, null, null, null);
        } else if (c9894a.apk == null) {
            c9894a.m27412a(adTemplate, null, null, null);
        }
    }

    /* renamed from: a */
    public final C9912a m27284a(C9893a.C9894a c9894a) {
        this.f29523KH = c9894a;
        return this;
    }

    /* renamed from: e */
    public final C9912a m27271e(C11008ac.C11009a c11009a) {
        this.f29529kn = c11009a;
        return this;
    }
}

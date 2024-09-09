package com.kwad.sdk.core.adlog.c;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.adlog.a;
import com.kwad.sdk.core.report.h;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ac;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
@KsJson
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class a extends com.kwad.sdk.core.response.a.a {
    public String KG;
    public a.C0688a KH;
    public long Li;
    public int Om;
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
    public int kl;
    public ac.a kn;
    public double ko;
    public long vz;
    public long apN = -1;
    public int apO = -1;
    public long apP = -1;
    public int apQ = -1;
    public int KI = 0;
    public String apV = "";
    public int aqf = -1;
    public int aqg = -1;
    public int downloadStatus = 0;
    public int aqj = -1;
    public int KF = -1;
    public int aql = -1;
    public int adxResult = -1;
    public int KJ = -1;
    public int aqp = 0;

    public static a Br() {
        return new a();
    }

    public final void a(@Nullable h hVar) {
        if (hVar != null) {
            this.aqq = hVar.EL();
        }
    }

    public final a af(long j4) {
        this.vz = j4;
        return this;
    }

    public final a ag(long j4) {
        this.Li = j4;
        return this;
    }

    public final void cD(int i4) {
        if (i4 == 0) {
            this.aqn = 1;
        } else if (i4 == 1) {
            this.aqn = 2;
        } else if (i4 != 2) {
        } else {
            this.aqn = 3;
        }
    }

    public final a cE(int i4) {
        this.kl = i4;
        return this;
    }

    public final a cF(int i4) {
        this.KI = i4;
        return this;
    }

    public final a cG(int i4) {
        this.KJ = i4;
        return this;
    }

    public final a cH(int i4) {
        this.KF = i4;
        return this;
    }

    public final a cI(int i4) {
        this.Om = i4;
        return this;
    }

    public final a cJ(int i4) {
        this.apX = i4;
        return this;
    }

    public final a dc(String str) {
        this.KG = str;
        return this;
    }

    public final void e(AdTemplate adTemplate, String str, String str2) {
        a.C0688a c0688a = this.KH;
        if (c0688a == null) {
            a.C0688a c0688a2 = new a.C0688a();
            this.KH = c0688a2;
            c0688a2.a(adTemplate, null, null, null);
        } else if (c0688a.apk == null) {
            c0688a.a(adTemplate, null, null, null);
        }
    }

    public final a a(a.C0688a c0688a) {
        this.KH = c0688a;
        return this;
    }

    public final a e(ac.a aVar) {
        this.kn = aVar;
        return this;
    }
}

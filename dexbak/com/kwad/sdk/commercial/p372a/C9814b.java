package com.kwad.sdk.commercial.p372a;

import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.commercial.p374c.AbstractC9822a;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.p409b.C10487e;
import java.net.URL;

@KsJson
/* renamed from: com.kwad.sdk.commercial.a.b */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C9814b extends AbstractC9822a {
    public String aog;
    public String aoh;
    public String aoi;
    public long aoj;
    public long aok;
    public int aol;
    public int aom;
    public String downloadId;
    public long downloadTime;
    public int status;
    public String url;

    /* renamed from: AK */
    public static C9814b m27705AK() {
        return new C9814b();
    }

    /* renamed from: ac */
    public final C9814b m27704ac(long j) {
        this.downloadTime = j;
        return this;
    }

    @Override // com.kwad.sdk.commercial.p374c.AbstractC9822a
    /* renamed from: bb */
    public final C9814b setAdTemplate(AdTemplate adTemplate) {
        super.setAdTemplate(adTemplate);
        AdInfo m25641dQ = C10487e.m25641dQ(adTemplate);
        this.url = C10487e.m25638dT(adTemplate);
        try {
            this.aog = new URL(this.url).getHost();
        } catch (Throwable unused) {
        }
        this.downloadId = m25641dQ.downloadId;
        AdInfo.AdBaseInfo adBaseInfo = m25641dQ.adBaseInfo;
        this.aoh = adBaseInfo.appPackageName;
        this.aoi = adBaseInfo.appName;
        this.aoj = m25641dQ.totalBytes;
        this.aok = m25641dQ.soFarBytes;
        return this;
    }

    /* renamed from: cc */
    public final C9814b m27702cc(int i) {
        this.status = i;
        return this;
    }

    /* renamed from: cd */
    public final C9814b m27701cd(int i) {
        this.aol = i;
        return this;
    }

    /* renamed from: ce */
    public final C9814b m27700ce(int i) {
        this.aom = i;
        return this;
    }
}

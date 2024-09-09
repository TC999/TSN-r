package com.kwad.sdk.core.adlog.b;

import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.response.model.AdTemplate;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
@KsJson
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class b extends com.kwad.sdk.commercial.c.a {
    public int aoM;
    public int apD;
    public int apE;
    public long apF;
    public int apt;
    public String apu;
    public int retryCount;
    public int status;

    public static b Bp() {
        return new b();
    }

    public final b ae(long j4) {
        this.apF = j4;
        return this;
    }

    @Override // com.kwad.sdk.commercial.c.a
    /* renamed from: bS */
    public final b setAdTemplate(AdTemplate adTemplate) {
        super.setAdTemplate(adTemplate);
        return this;
    }

    public final b cZ(String str) {
        this.apu = str;
        return this;
    }

    public final b cs(int i4) {
        this.status = i4;
        return this;
    }

    public final b ct(int i4) {
        this.aoM = i4;
        return this;
    }

    public final b cu(int i4) {
        this.retryCount = i4;
        return this;
    }

    public final b cv(int i4) {
        this.apt = i4;
        return this;
    }

    public final b cw(int i4) {
        this.apD = i4;
        return this;
    }

    public final b cx(int i4) {
        this.apE = i4;
        return this;
    }
}

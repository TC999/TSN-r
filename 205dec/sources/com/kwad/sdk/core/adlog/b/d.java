package com.kwad.sdk.core.adlog.b;

import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.response.model.AdTemplate;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
@KsJson
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class d extends com.kwad.sdk.commercial.c.a {
    public int aoM;
    public String aoO;
    public int apG;
    public int retryCount;
    public int status;

    public static d Bq() {
        return new d();
    }

    @Override // com.kwad.sdk.commercial.c.a
    /* renamed from: bT */
    public final d setAdTemplate(AdTemplate adTemplate) {
        super.setAdTemplate(adTemplate);
        return this;
    }

    public final d cA(int i4) {
        this.apG = 1;
        return this;
    }

    public final d cB(int i4) {
        this.retryCount = i4;
        return this;
    }

    @Override // com.kwad.sdk.commercial.c.a
    /* renamed from: cC */
    public final d setErrorCode(int i4) {
        super.setErrorCode(i4);
        return this;
    }

    public final d cy(int i4) {
        this.status = i4;
        return this;
    }

    public final d cz(int i4) {
        this.aoM = i4;
        return this;
    }

    public final d da(String str) {
        this.aoO = str;
        return this;
    }

    @Override // com.kwad.sdk.commercial.c.a
    /* renamed from: db */
    public final d setErrorMsg(String str) {
        super.setErrorMsg(str);
        return this;
    }
}

package com.kwad.sdk.commercial.c;

import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.commercial.d;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.core.response.model.AdTemplate;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
@KsJson
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public abstract class a extends com.kwad.sdk.core.response.a.a {
    public long creativeId;
    public int errorCode;
    public String errorMsg;
    public long llsid;
    public long posId;
    public String templateId;
    public String templateVersion;

    public a setAdTemplate(AdTemplate adTemplate) {
        if (adTemplate == null) {
            return this;
        }
        this.creativeId = e.ea(adTemplate);
        this.llsid = e.dN(adTemplate);
        this.posId = e.dJ(adTemplate);
        AdMatrixInfo.MatrixTemplate aT = d.aT(adTemplate);
        if (aT != null) {
            this.templateId = aT.templateId;
            this.templateVersion = aT.templateVersion;
        }
        return this;
    }

    public a setErrorCode(int i4) {
        this.errorCode = i4;
        return this;
    }

    public a setErrorMsg(String str) {
        this.errorMsg = str;
        return this;
    }

    public a setLlsid(long j4) {
        this.llsid = j4;
        return this;
    }

    public a setPosId(long j4) {
        this.posId = j4;
        return this;
    }
}

package com.kwad.sdk.core.request.model;

import com.ksad.json.annotation.KsJson;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
@KsJson
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class g extends com.kwad.sdk.core.response.a.a {
    public String azQ;
    public String azR;
    public int thirdAge;
    public int thirdGender;
    public String thirdInterest;

    public static g Ff() {
        return new g();
    }

    public final g eo(String str) {
        this.azQ = str;
        return this;
    }
}

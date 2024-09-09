package com.kwad.sdk.core.response.model;

import android.text.TextUtils;
import com.ksad.json.annotation.KsJson;
import java.io.Serializable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
@KsJson
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class TemplateConfig extends com.kwad.sdk.core.response.a.a implements com.kwad.sdk.core.b, Serializable {
    private static final long serialVersionUID = -6943205584670122269L;
    public String h5Checksum;
    public String h5Url;
    public String h5Version;

    public boolean notEmpty() {
        return (TextUtils.isEmpty(this.h5Url) || TextUtils.isEmpty(this.h5Version) || TextUtils.isEmpty(this.h5Checksum)) ? false : true;
    }
}

package com.kwad.sdk.crash.model.message;

import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.response.p408a.C10482a;
import java.io.Serializable;

@KsJson
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class AnrReason extends C10482a implements Serializable {
    private static final long serialVersionUID = 2458805633316742361L;
    public String mLongMsg;
    public String mShortMsg;
    public String mTag;

    @Override // com.kwad.sdk.core.response.p408a.C10482a
    public String toString() {
        return "mTag: " + this.mTag + "\nmShortMsg: " + this.mShortMsg + "\nmLongMsg: " + this.mLongMsg + '\n';
    }
}

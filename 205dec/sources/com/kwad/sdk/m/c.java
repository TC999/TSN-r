package com.kwad.sdk.m;

import com.ksad.json.annotation.KsJson;
import java.util.List;

@KsJson
/* loaded from: E:\TSN-r\205dec\6206960.dex */
public class c extends com.kwad.sdk.core.response.a.a {
    public List<String> aOr;
    public List<a> aOs;
    public List<com.kwad.sdk.m.a.a> aOt;
    public long funcSwitch;
    public long byteCount = 1000;
    public double sampleRate = 1.0d;

    @KsJson
    /* loaded from: E:\TSN-r\205dec\6206960.dex */
    public static class a extends com.kwad.sdk.core.response.a.a {
        public String aOu;
        public String aOv;
    }

    private boolean dX(int i4) {
        return (Lk() || (this.funcSwitch & ((long) i4)) == 0) ? false : true;
    }

    public final boolean Lk() {
        return (this.funcSwitch & 1) == 0;
    }

    public final boolean Ll() {
        return dX(4);
    }

    public final boolean Lm() {
        return dX(16);
    }
}

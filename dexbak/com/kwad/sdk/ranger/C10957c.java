package com.kwad.sdk.ranger;

import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.response.p408a.C10482a;
import com.kwad.sdk.ranger.p446a.C10946a;
import java.util.List;

@KsJson
/* renamed from: com.kwad.sdk.ranger.c */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C10957c extends C10482a {
    public List<String> aNk;
    public List<C10958a> aNl;
    public List<C10946a> aNm;
    public long funcSwitch;
    public long byteCount = 1000;
    public double sampleRate = 1.0d;

    @KsJson
    /* renamed from: com.kwad.sdk.ranger.c$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class C10958a extends C10482a {
        public String aNn;
        public String aNo;
    }

    /* renamed from: dX */
    private boolean m24370dX(int i) {
        return (m24373KC() || (this.funcSwitch & ((long) i)) == 0) ? false : true;
    }

    /* renamed from: KC */
    public final boolean m24373KC() {
        return (this.funcSwitch & 1) == 0;
    }

    /* renamed from: KD */
    public final boolean m24372KD() {
        return m24370dX(4);
    }

    /* renamed from: KE */
    public final boolean m24371KE() {
        return m24370dX(16);
    }
}

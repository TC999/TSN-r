package com.kwad.components.p208ad.fullscreen.p228b;

import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.core.response.p408a.C10482a;
import java.text.SimpleDateFormat;
import java.util.Date;

@KsJson
/* renamed from: com.kwad.components.ad.fullscreen.b.b */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C7609b extends C10482a {

    /* renamed from: gL */
    private static SimpleDateFormat f25857gL = new SimpleDateFormat("yyyy-MM-dd");

    /* renamed from: gM */
    public long f25858gM;

    /* renamed from: gN */
    public int f25859gN;

    public C7609b() {
        this.f25858gM = -1L;
        this.f25859gN = -1;
    }

    /* renamed from: f */
    public final boolean m32788f(long j) {
        if (this.f25858gM > 0 && j > 0) {
            try {
                return f25857gL.format(new Date(this.f25858gM)).equals(f25857gL.format(new Date(j)));
            } catch (Exception e) {
                C10331c.printStackTraceOnly(e);
            }
        }
        return false;
    }

    /* renamed from: w */
    public final boolean m32787w(int i) {
        int i2 = this.f25859gN;
        return i2 > 0 && i2 >= i;
    }

    public C7609b(long j, int i) {
        this.f25858gM = j;
        this.f25859gN = 1;
    }
}

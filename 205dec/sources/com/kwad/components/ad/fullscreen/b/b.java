package com.kwad.components.ad.fullscreen.b;

import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.e.c;
import java.text.SimpleDateFormat;
import java.util.Date;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
@KsJson
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class b extends com.kwad.sdk.core.response.a.a {
    private static SimpleDateFormat gL = new SimpleDateFormat("yyyy-MM-dd");
    public long gM;
    public int gN;

    public b() {
        this.gM = -1L;
        this.gN = -1;
    }

    public final boolean f(long j4) {
        if (this.gM > 0 && j4 > 0) {
            try {
                return gL.format(new Date(this.gM)).equals(gL.format(new Date(j4)));
            } catch (Exception e4) {
                c.printStackTraceOnly(e4);
            }
        }
        return false;
    }

    public final boolean w(int i4) {
        int i5 = this.gN;
        return i5 > 0 && i5 >= i4;
    }

    public b(long j4, int i4) {
        this.gM = j4;
        this.gN = 1;
    }
}

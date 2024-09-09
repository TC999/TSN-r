package com.kwad.components.core.k;

import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.e.c;
import java.text.SimpleDateFormat;
import java.util.Date;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
@KsJson
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class a extends com.kwad.sdk.core.response.a.a implements com.kwad.sdk.core.b {
    private static SimpleDateFormat Mp = new SimpleDateFormat("yyyy-MM-dd");
    public int Mq;
    public long Mr;

    public final boolean j(int i4, int i5) {
        c.d("AdForceActiveInfo", "checkAndAddCount forceActiveIntervalHour: " + i4 + ", forceActiveThreshold: " + i5);
        if (this.Mr > 0) {
            long currentTimeMillis = System.currentTimeMillis();
            String format = Mp.format(new Date(this.Mr));
            String format2 = Mp.format(new Date(currentTimeMillis));
            c.d("AdForceActiveInfo", "checkAndAddCount lastDate: " + format + ", currentDate: " + format2);
            if (!format.equals(format2)) {
                this.Mq = 0;
                oI();
                return true;
            }
            long j4 = this.Mr + (i4 * 60 * 60 * 1000);
            c.d("AdForceActiveInfo", "checkAndAddCount minTimestamp: " + j4 + ", currentActiveCount: " + this.Mq);
            if (j4 >= currentTimeMillis || this.Mq > i5) {
                return false;
            }
            oI();
            return true;
        }
        oI();
        return true;
    }

    public final void oI() {
        this.Mr = System.currentTimeMillis();
        this.Mq++;
        c.d("AdForceActiveInfo", "doAddCount, lastForceActiveTimestamp: " + this.Mr + ", currentActiveCount " + this.Mq);
    }
}

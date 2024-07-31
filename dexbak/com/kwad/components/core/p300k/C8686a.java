package com.kwad.components.core.p300k;

import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.InterfaceC9914b;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.core.response.p408a.C10482a;
import java.text.SimpleDateFormat;
import java.util.Date;

@KsJson
/* renamed from: com.kwad.components.core.k.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C8686a extends C10482a implements InterfaceC9914b {

    /* renamed from: Mp */
    private static SimpleDateFormat f28355Mp = new SimpleDateFormat("yyyy-MM-dd");

    /* renamed from: Mq */
    public int f28356Mq;

    /* renamed from: Mr */
    public long f28357Mr;

    /* renamed from: j */
    public final boolean m30016j(int i, int i2) {
        C10331c.m26254d("AdForceActiveInfo", "checkAndAddCount forceActiveIntervalHour: " + i + ", forceActiveThreshold: " + i2);
        if (this.f28357Mr > 0) {
            long currentTimeMillis = System.currentTimeMillis();
            String format = f28355Mp.format(new Date(this.f28357Mr));
            String format2 = f28355Mp.format(new Date(currentTimeMillis));
            C10331c.m26254d("AdForceActiveInfo", "checkAndAddCount lastDate: " + format + ", currentDate: " + format2);
            if (!format.equals(format2)) {
                this.f28356Mq = 0;
                m30015oI();
                return true;
            }
            long j = this.f28357Mr + (i * 60 * 60 * 1000);
            C10331c.m26254d("AdForceActiveInfo", "checkAndAddCount minTimestamp: " + j + ", currentActiveCount: " + this.f28356Mq);
            if (j >= currentTimeMillis || this.f28356Mq > i2) {
                return false;
            }
            m30015oI();
            return true;
        }
        m30015oI();
        return true;
    }

    /* renamed from: oI */
    public final void m30015oI() {
        this.f28357Mr = System.currentTimeMillis();
        this.f28356Mq++;
        C10331c.m26254d("AdForceActiveInfo", "doAddCount, lastForceActiveTimestamp: " + this.f28357Mr + ", currentActiveCount " + this.f28356Mq);
    }
}

package com.kwad.components.core.proxy.a;

import android.os.SystemClock;
import com.kwad.components.core.proxy.PageCreateStage;
import com.kwad.sdk.utils.ay;
import com.kwad.sdk.utils.bn;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class a {
    private String Ra;
    private long Rb;
    private long Rc;
    private long Rd;
    private boolean Re;
    private c Rf;

    public a(c cVar) {
        this.Rf = cVar;
    }

    public final void F(long j4) {
        this.Rb = j4;
        this.Rc = SystemClock.uptimeMillis();
    }

    public final void av(String str) {
        this.Ra = str;
    }

    public final void qh() {
        if (this.Re) {
            return;
        }
        this.Re = true;
        bn.runOnUiThread(new ay() { // from class: com.kwad.components.core.proxy.a.a.1
            @Override // com.kwad.sdk.utils.ay
            public final void doTask() {
                a.this.Rd = SystemClock.uptimeMillis();
                a.this.report();
            }
        });
    }

    public final void report() {
        b bVar = new b();
        bVar.Ra = this.Ra;
        long j4 = this.Rb;
        bVar.Ri = j4 != 0 ? this.Rc - j4 : 0L;
        long j5 = this.Rc;
        bVar.Rj = j5 != 0 ? this.Rd - j5 : 0L;
        bVar.Rh = j4 != 0 ? this.Rd - j4 : 0L;
        com.kwad.components.core.o.a.qi().a(bVar);
        com.kwad.sdk.core.e.c.d("PageMonitor", bVar.toString());
    }

    public final void a(PageCreateStage pageCreateStage) {
        c cVar = this.Rf;
        if (cVar != null) {
            cVar.onCreateStageChange(pageCreateStage);
        }
    }
}

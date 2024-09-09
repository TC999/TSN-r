package com.kwad.components.core.a;

import android.os.SystemClock;
import android.text.TextUtils;
import com.kwad.sdk.core.c.b;
import com.kwad.sdk.core.config.d;
import com.kwad.sdk.core.e.c;
import com.kwad.sdk.core.report.g;
import com.kwad.sdk.core.report.n;
import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class a {
    private String IB;
    private String IC;
    private long ID;
    private long IE;
    private Timer IF;
    private boolean IG = false;
    private final long period;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* renamed from: com.kwad.components.core.a.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public static final class C0619a {
        private static final a II = new a();
    }

    public a() {
        this.ID = -1L;
        try {
            this.ID = SystemClock.elapsedRealtime();
        } catch (Throwable th) {
            this.ID = System.currentTimeMillis();
            c.printStackTraceOnly(th);
        }
        this.period = TimeUnit.MINUTES.toMillis(d.BG());
        com.kwad.sdk.core.c.d dVar = new com.kwad.sdk.core.c.d() { // from class: com.kwad.components.core.a.a.1
            @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
            public final void onBackToBackground() {
                super.onBackToBackground();
                a.this.ms();
            }

            @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
            public final void onBackToForeground() {
                super.onBackToForeground();
                a.this.eF();
            }
        };
        b.DD();
        b.a(dVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ah(int i4) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j4 = elapsedRealtime - this.ID;
        this.ID = elapsedRealtime;
        if (i4 == 1) {
            this.IE = 0L;
            this.IC = UUID.randomUUID().toString();
            if (TextUtils.isEmpty(this.IB)) {
                this.IB = this.IC;
            }
        }
        this.IE++;
        n nVar = new n(10220L);
        nVar.auc = this.IE;
        if (j4 > 0) {
            nVar.ayO = j4;
        }
        nVar.ayP = i4;
        nVar.IB = this.IB;
        nVar.IC = this.IC;
        g.a2(nVar);
    }

    public static a mr() {
        return C0619a.II;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ms() {
        this.IG = false;
        if (this.period <= 0) {
            return;
        }
        Timer timer = this.IF;
        if (timer != null) {
            timer.cancel();
        }
        ah(3);
    }

    public final void eF() {
        if (this.IG) {
            return;
        }
        this.IG = true;
        if (this.period <= 0) {
            return;
        }
        this.IF = new Timer();
        ah(1);
        TimerTask timerTask = new TimerTask() { // from class: com.kwad.components.core.a.a.2
            @Override // java.util.TimerTask, java.lang.Runnable
            public final void run() {
                a.this.ah(2);
            }
        };
        try {
            Timer timer = this.IF;
            long j4 = this.period;
            timer.schedule(timerTask, j4, j4);
        } catch (Throwable unused) {
        }
    }
}

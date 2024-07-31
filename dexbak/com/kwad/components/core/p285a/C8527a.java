package com.kwad.components.core.p285a;

import android.os.SystemClock;
import android.text.TextUtils;
import com.kwad.sdk.core.config.C10251d;
import com.kwad.sdk.core.p391c.AbstractC10247d;
import com.kwad.sdk.core.p391c.C10232b;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.core.report.C10455g;
import com.kwad.sdk.core.report.C10464n;
import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/* renamed from: com.kwad.components.core.a.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C8527a {

    /* renamed from: IB */
    private String f28051IB;

    /* renamed from: IC */
    private String f28052IC;

    /* renamed from: ID */
    private long f28053ID;

    /* renamed from: IE */
    private long f28054IE;

    /* renamed from: IF */
    private Timer f28055IF;

    /* renamed from: IG */
    private boolean f28056IG = false;
    private final long period;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.kwad.components.core.a.a$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static final class C8530a {

        /* renamed from: II */
        private static final C8527a f28059II = new C8527a();
    }

    public C8527a() {
        this.f28053ID = -1L;
        try {
            this.f28053ID = SystemClock.elapsedRealtime();
        } catch (Throwable th) {
            this.f28053ID = System.currentTimeMillis();
            C10331c.printStackTraceOnly(th);
        }
        this.period = TimeUnit.MINUTES.toMillis(C10251d.m26587BG());
        AbstractC10247d abstractC10247d = new AbstractC10247d() { // from class: com.kwad.components.core.a.a.1
            @Override // com.kwad.sdk.core.p391c.AbstractC10247d, com.kwad.sdk.core.p391c.InterfaceC10246c
            public final void onBackToBackground() {
                super.onBackToBackground();
                C8527a.this.m30414ms();
            }

            @Override // com.kwad.sdk.core.p391c.AbstractC10247d, com.kwad.sdk.core.p391c.InterfaceC10246c
            public final void onBackToForeground() {
                super.onBackToForeground();
                C8527a.this.m30416eF();
            }
        };
        C10232b.m26625DD();
        C10232b.m26622a(abstractC10247d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ah */
    public void m30417ah(int i) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j = elapsedRealtime - this.f28053ID;
        this.f28053ID = elapsedRealtime;
        if (i == 1) {
            this.f28054IE = 0L;
            this.f28052IC = UUID.randomUUID().toString();
            if (TextUtils.isEmpty(this.f28051IB)) {
                this.f28051IB = this.f28052IC;
            }
        }
        this.f28054IE++;
        C10464n c10464n = new C10464n(10220L);
        c10464n.auc = this.f28054IE;
        if (j > 0) {
            c10464n.ayO = j;
        }
        c10464n.ayP = i;
        c10464n.f29562IB = this.f28051IB;
        c10464n.f29563IC = this.f28052IC;
        C10455g.m26032a(c10464n);
    }

    /* renamed from: mr */
    public static C8527a m30415mr() {
        return C8530a.f28059II;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ms */
    public void m30414ms() {
        this.f28056IG = false;
        if (this.period <= 0) {
            return;
        }
        Timer timer = this.f28055IF;
        if (timer != null) {
            timer.cancel();
        }
        m30417ah(3);
    }

    /* renamed from: eF */
    public final void m30416eF() {
        if (this.f28056IG) {
            return;
        }
        this.f28056IG = true;
        if (this.period <= 0) {
            return;
        }
        this.f28055IF = new Timer();
        m30417ah(1);
        TimerTask timerTask = new TimerTask() { // from class: com.kwad.components.core.a.a.2
            @Override // java.util.TimerTask, java.lang.Runnable
            public final void run() {
                C8527a.this.m30417ah(2);
            }
        };
        try {
            Timer timer = this.f28055IF;
            long j = this.period;
            timer.schedule(timerTask, j, j);
        } catch (Throwable unused) {
        }
    }
}

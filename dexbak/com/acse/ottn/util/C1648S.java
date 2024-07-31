package com.acse.ottn.util;

import android.os.CountDownTimer;
import java.util.Timer;
import java.util.TimerTask;

/* renamed from: com.acse.ottn.util.S */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class C1648S {

    /* renamed from: a */
    private static C1648S f3276a;

    /* renamed from: com.acse.ottn.util.S$a */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public interface InterfaceC1649a {
        /* renamed from: a */
        void mo55884a(long j);

        void onFinish();
    }

    private C1648S() {
    }

    /* renamed from: a */
    public static C1648S m56165a() {
        if (f3276a == null) {
            synchronized (C1648S.class) {
                if (f3276a == null) {
                    f3276a = new C1648S();
                }
            }
        }
        return f3276a;
    }

    /* renamed from: a */
    public CountDownTimer m56164a(int i, int i2, InterfaceC1649a interfaceC1649a) {
        return new CountDownTimerC1637K(this, i, i2, interfaceC1649a);
    }

    /* renamed from: b */
    public TimerTask m56163b(int i, int i2, InterfaceC1649a interfaceC1649a) {
        C1643N c1643n = new C1643N(this, new int[]{0}, i2, i, interfaceC1649a);
        new Timer().scheduleAtFixedRate(c1643n, 0L, i2);
        return c1643n;
    }

    /* renamed from: c */
    public Timer m56162c(int i, int i2, InterfaceC1649a interfaceC1649a) {
        C1647Q c1647q = new C1647Q(this, new int[]{0}, i2, i, interfaceC1649a);
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(c1647q, 0L, i2);
        return timer;
    }
}

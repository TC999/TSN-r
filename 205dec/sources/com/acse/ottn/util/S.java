package com.acse.ottn.util;

import android.os.CountDownTimer;
import java.util.Timer;
import java.util.TimerTask;

/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class S {

    /* renamed from: a  reason: collision with root package name */
    private static S f6786a;

    /* loaded from: E:\TSN-r\205dec\6276784.dex */
    public interface a {
        void a(long j4);

        void onFinish();
    }

    private S() {
    }

    public static S a() {
        if (f6786a == null) {
            synchronized (S.class) {
                if (f6786a == null) {
                    f6786a = new S();
                }
            }
        }
        return f6786a;
    }

    public CountDownTimer a(int i4, int i5, a aVar) {
        return new K(this, i4, i5, aVar);
    }

    public TimerTask b(int i4, int i5, a aVar) {
        N n4 = new N(this, new int[]{0}, i5, i4, aVar);
        new Timer().scheduleAtFixedRate(n4, 0L, i5);
        return n4;
    }

    public Timer c(int i4, int i5, a aVar) {
        Q q3 = new Q(this, new int[]{0}, i5, i4, aVar);
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(q3, 0L, i5);
        return timer;
    }
}

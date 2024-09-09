package cn.jpush.android.s;

import android.os.CountDownTimer;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private CountDownTimer f4349a;

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public interface a {
        void a();
    }

    public void a() {
        CountDownTimer countDownTimer = this.f4349a;
        if (countDownTimer != null) {
            countDownTimer.cancel();
            this.f4349a = null;
        }
    }

    public void a(final a aVar, long j4, long j5) {
        this.f4349a = new CountDownTimer(j4, j5) { // from class: cn.jpush.android.s.c.1
            @Override // android.os.CountDownTimer
            public void onFinish() {
                a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.a();
                }
            }

            @Override // android.os.CountDownTimer
            public void onTick(long j6) {
            }
        }.start();
    }
}

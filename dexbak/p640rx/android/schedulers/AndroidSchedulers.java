package p640rx.android.schedulers;

import android.os.Looper;
import p640rx.Scheduler;
import p640rx.android.plugins.RxAndroidPlugins;

/* renamed from: rx.android.schedulers.a */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class AndroidSchedulers {

    /* renamed from: b */
    private static final AndroidSchedulers f44641b = new AndroidSchedulers();

    /* renamed from: a */
    private final Scheduler f44642a;

    private AndroidSchedulers() {
        Scheduler m1985b = RxAndroidPlugins.m1990a().m1989b().m1985b();
        if (m1985b != null) {
            this.f44642a = m1985b;
        } else {
            this.f44642a = new LooperScheduler(Looper.getMainLooper());
        }
    }

    /* renamed from: a */
    public static Scheduler m1983a(Looper looper) {
        if (looper != null) {
            return new LooperScheduler(looper);
        }
        throw new NullPointerException("looper == null");
    }

    /* renamed from: b */
    public static Scheduler m1982b() {
        return f44641b.f44642a;
    }
}

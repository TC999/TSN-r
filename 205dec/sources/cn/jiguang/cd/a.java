package cn.jiguang.cd;

import android.content.Context;
import android.os.Debug;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
final class a extends Thread {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f3270a;

    /* renamed from: b  reason: collision with root package name */
    private final InterfaceC0059a f3271b;

    /* renamed from: c  reason: collision with root package name */
    private final e f3272c;

    /* renamed from: d  reason: collision with root package name */
    private final long f3273d;

    /* renamed from: e  reason: collision with root package name */
    private final AtomicLong f3274e;

    /* renamed from: f  reason: collision with root package name */
    private final AtomicBoolean f3275f;

    /* renamed from: g  reason: collision with root package name */
    private final Context f3276g;

    /* renamed from: h  reason: collision with root package name */
    private final cn.jiguang.cm.b f3277h;

    /* renamed from: cn.jiguang.cd.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public interface InterfaceC0059a {
        void a(cn.jiguang.ce.a aVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(long j4, boolean z3, InterfaceC0059a interfaceC0059a, Context context) {
        this(j4, z3, interfaceC0059a, new f(), context);
    }

    a(long j4, boolean z3, InterfaceC0059a interfaceC0059a, e eVar, Context context) {
        this.f3274e = new AtomicLong(0L);
        this.f3275f = new AtomicBoolean(false);
        this.f3277h = new cn.jiguang.cm.b() { // from class: cn.jiguang.cd.a.1
            @Override // cn.jiguang.cm.b
            public void a() {
                a.this.f3274e.set(0L);
                a.this.f3275f.set(false);
            }
        };
        this.f3270a = z3;
        this.f3271b = interfaceC0059a;
        this.f3273d = j4;
        this.f3272c = eVar;
        this.f3276g = context;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        setName("jg_anr_watchdog");
        long j4 = this.f3273d;
        while (!isInterrupted()) {
            boolean z3 = this.f3274e.get() == 0;
            this.f3274e.addAndGet(j4);
            if (z3) {
                this.f3272c.a(this.f3277h);
            }
            try {
                Thread.sleep(j4);
                if (this.f3274e.get() != 0 && !this.f3275f.get()) {
                    if (this.f3270a || !(Debug.isDebuggerConnected() || Debug.waitingForDebugger())) {
                        cn.jiguang.bq.d.i("ANRWatchDog", "Raising ANR");
                        this.f3271b.a(new cn.jiguang.ce.a("Application Not Responding for at least " + this.f3273d + " ms.", this.f3272c.a()));
                        j4 = this.f3273d;
                    } else {
                        cn.jiguang.bq.d.i("ANRWatchDog", "An ANR was detected but ignored because the debugger is connected.");
                    }
                    this.f3275f.set(true);
                }
            } catch (InterruptedException e4) {
                Thread.currentThread().interrupt();
                cn.jiguang.bq.d.i("ANRWatchDog", String.format("Interrupted: %s", e4.getMessage()));
                return;
            }
        }
    }
}

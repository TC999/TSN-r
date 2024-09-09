package com.bytedance.c.w.ux;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Printer;
import android.util.SparseArray;
import com.bytedance.c.w.b;
import java.lang.reflect.Field;
import java.util.LinkedList;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class f implements Handler.Callback {

    /* renamed from: j  reason: collision with root package name */
    private static Printer f26617j;

    /* renamed from: k  reason: collision with root package name */
    private static f f26618k;

    /* renamed from: l  reason: collision with root package name */
    private static final Printer f26619l = new a();

    /* renamed from: c  reason: collision with root package name */
    private long f26622c;

    /* renamed from: d  reason: collision with root package name */
    private long f26623d;

    /* renamed from: i  reason: collision with root package name */
    private boolean f26628i;

    /* renamed from: b  reason: collision with root package name */
    private int f26621b = 0;

    /* renamed from: e  reason: collision with root package name */
    private final SparseArray<List<Runnable>> f26624e = new SparseArray<>();

    /* renamed from: f  reason: collision with root package name */
    private final List<Printer> f26625f = new LinkedList();

    /* renamed from: g  reason: collision with root package name */
    private final List<Printer> f26626g = new LinkedList();

    /* renamed from: h  reason: collision with root package name */
    private boolean f26627h = false;

    /* renamed from: a  reason: collision with root package name */
    private Handler f26620a = new Handler(d.a().getLooper(), this);

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    static class a implements Printer {
        a() {
        }

        @Override // android.util.Printer
        public void println(String str) {
            if (str == null) {
                return;
            }
            if (str.startsWith(">>>>> Dispatching")) {
                f.a().d(str);
            } else if (str.startsWith("<<<<< Finished")) {
                f.a().j(str);
            }
            if (f.f26617j == null || f.f26617j == f.f26619l) {
                return;
            }
            f.f26617j.println(str);
        }
    }

    private f() {
        i();
    }

    public static f a() {
        if (f26618k == null) {
            synchronized (f.class) {
                if (f26618k == null) {
                    f26618k = new f();
                }
            }
        }
        return f26618k;
    }

    private static void e(List<? extends Runnable> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        try {
            for (Runnable runnable : list) {
                runnable.run();
            }
        } catch (Exception e4) {
            b.k.b(e4);
        }
    }

    private synchronized void f(List<? extends Printer> list, String str) {
        if (list != null) {
            if (!list.isEmpty()) {
                try {
                    for (Printer printer : list) {
                        printer.println(str);
                    }
                } catch (Exception e4) {
                    b.k.b(e4);
                }
            }
        }
    }

    private Printer h() {
        try {
            Field declaredField = Class.forName("android.os.Looper").getDeclaredField("mLogging");
            declaredField.setAccessible(true);
            return (Printer) declaredField.get(Looper.getMainLooper());
        } catch (Exception e4) {
            b.k.c(e4);
            return null;
        }
    }

    public void b(long j4, Runnable runnable) {
        c(j4, runnable, 1, 0L);
    }

    public void c(long j4, Runnable runnable, int i4, long j5) {
        if (j4 < 0) {
            return;
        }
        for (int i5 = 0; i5 < i4; i5++) {
            int i6 = (int) j4;
            List<Runnable> list = this.f26624e.get(i6);
            if (list == null) {
                synchronized (this.f26624e) {
                    list = this.f26624e.get(i6);
                    if (list == null) {
                        list = new LinkedList<>();
                        this.f26624e.put(i6, list);
                    }
                }
            }
            list.add(runnable);
            j4 += j5;
        }
    }

    void d(String str) {
        if (!this.f26628i) {
            c.a(32L);
            this.f26628i = true;
        }
        this.f26622c = SystemClock.uptimeMillis();
        try {
            f(this.f26625f, str);
            this.f26620a.sendEmptyMessage(0);
        } catch (Exception e4) {
            b.k.b(e4);
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (this.f26620a.hasMessages(0)) {
            return true;
        }
        int i4 = message.what;
        if (i4 == 0) {
            this.f26621b = 0;
            if (this.f26624e.size() != 0 && this.f26624e.keyAt(0) == 0) {
                e(this.f26624e.valueAt(0));
                this.f26621b++;
            }
        } else if (i4 == 1) {
            this.f26620a.removeMessages(2);
            if (this.f26624e.size() != 0) {
                SparseArray<List<Runnable>> sparseArray = this.f26624e;
                if (sparseArray.keyAt(sparseArray.size() - 1) == 0) {
                    e(this.f26624e.get(Integer.MAX_VALUE));
                }
            }
            return true;
        } else if (i4 == 2) {
            e(this.f26624e.valueAt(this.f26621b));
            this.f26621b++;
        }
        if (this.f26621b >= this.f26624e.size()) {
            return true;
        }
        long keyAt = this.f26624e.keyAt(this.f26621b);
        if (keyAt != 2147483647L) {
            this.f26620a.sendEmptyMessageAtTime(2, this.f26622c + keyAt);
        }
        return true;
    }

    public void i() {
        if (this.f26627h) {
            return;
        }
        this.f26627h = true;
        Printer h4 = h();
        f26617j = h4;
        Printer printer = f26619l;
        if (h4 == printer) {
            f26617j = null;
        }
        Looper.getMainLooper().setMessageLogging(printer);
    }

    void j(String str) {
        this.f26623d = SystemClock.uptimeMillis();
        try {
            this.f26620a.removeMessages(2);
            f(this.f26626g, str);
            this.f26620a.sendEmptyMessage(1);
        } catch (Exception e4) {
            b.k.c(e4);
        }
    }
}

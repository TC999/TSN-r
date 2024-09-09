package cn.jiguang.cb;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import cn.jiguang.bq.d;
import cn.jiguang.bx.h;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private static volatile b f3229a;

    /* renamed from: b  reason: collision with root package name */
    private static final Object f3230b = new Object();

    /* renamed from: c  reason: collision with root package name */
    private boolean f3231c = false;

    /* renamed from: d  reason: collision with root package name */
    private ConcurrentHashMap<Integer, cn.jiguang.cb.a> f3232d = new ConcurrentHashMap<>();

    /* renamed from: e  reason: collision with root package name */
    private Handler f3233e;

    /* renamed from: f  reason: collision with root package name */
    private HandlerThread f3234f;

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            try {
                cn.jiguang.cb.a aVar = (cn.jiguang.cb.a) b.this.f3232d.get(Integer.valueOf(message.what));
                if (aVar != null) {
                    aVar.a(message);
                    int i4 = aVar.f3228c;
                    if (i4 == 1) {
                        sendEmptyMessageDelayed(message.what, h.a().f() * 1000);
                    } else if (i4 != 3) {
                        b.this.f3232d.remove(Integer.valueOf(message.what));
                    }
                } else {
                    d.i("TaskHandlerManager_xxx", "miss task:" + message.what);
                }
            } catch (Throwable th) {
                d.i("TaskHandlerManager_xxx", "handleMessage,e:" + th);
            }
        }
    }

    private b() {
    }

    public static b a() {
        if (f3229a == null) {
            synchronized (f3230b) {
                if (f3229a == null) {
                    f3229a = new b();
                }
            }
        }
        return f3229a;
    }

    private void a(int i4, int i5, long j4, cn.jiguang.cb.a aVar) {
        if (this.f3233e == null) {
            return;
        }
        aVar.f3227b = j4;
        aVar.f3228c = i4;
        this.f3232d.put(Integer.valueOf(i5), aVar);
        if (this.f3233e.hasMessages(i5)) {
            d.i("TaskHandlerManager_xxx", "register,same action in handler,will replace " + i5);
            this.f3233e.removeMessages(i5);
        }
        this.f3233e.sendEmptyMessageDelayed(i5, j4);
    }

    public void a(int i4, long j4, cn.jiguang.cb.a aVar) {
        a(1, i4, j4, aVar);
    }

    public synchronized void a(Context context) {
        if (this.f3231c) {
            return;
        }
        if (context == null) {
            d.c("TaskHandlerManager_xxx", "init context is null");
            return;
        }
        d.c("TaskHandlerManager_xxx", "init task manager...");
        try {
            HandlerThread handlerThread = this.f3234f;
            if (handlerThread == null || !handlerThread.isAlive()) {
                HandlerThread handlerThread2 = new HandlerThread("jg_tsk_thread") { // from class: cn.jiguang.cb.b.1
                    @Override // android.os.HandlerThread, java.lang.Thread, java.lang.Runnable
                    public void run() {
                        try {
                            super.run();
                        } catch (RuntimeException e4) {
                            d.l("TaskHandlerManager_xxx", "handler thread run e:" + e4 + "  t=" + Thread.currentThread().getName() + "_" + Thread.currentThread().getId());
                        }
                    }
                };
                this.f3234f = handlerThread2;
                handlerThread2.start();
            }
            this.f3233e = new a(this.f3234f.getLooper() == null ? Looper.getMainLooper() : this.f3234f.getLooper());
        } catch (Exception unused) {
            this.f3233e = new a(Looper.getMainLooper());
        }
        this.f3231c = true;
    }

    public boolean a(int i4) {
        Handler handler = this.f3233e;
        if (handler == null) {
            return false;
        }
        return handler.hasMessages(i4);
    }

    public void b(int i4) {
        if (this.f3233e == null) {
            return;
        }
        this.f3232d.remove(Integer.valueOf(i4));
        this.f3233e.removeMessages(i4);
    }

    public void b(int i4, long j4, cn.jiguang.cb.a aVar) {
        if (this.f3233e == null) {
            return;
        }
        aVar.f3228c = 2;
        this.f3232d.put(Integer.valueOf(i4), aVar);
        if (this.f3233e.hasMessages(i4)) {
            d.c("TaskHandlerManager_xxx", "sendMsg,replace:" + i4);
            this.f3233e.removeMessages(i4);
        } else {
            d.c("TaskHandlerManager_xxx", "sendMsg,action=" + i4);
        }
        this.f3233e.sendEmptyMessageDelayed(i4, j4);
    }
}

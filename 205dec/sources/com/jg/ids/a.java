package com.jg.ids;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;

/* loaded from: E:\TSN-r\205dec\93344.dex */
public abstract class a extends f {

    /* renamed from: b  reason: collision with root package name */
    private static Handler f37804b = new Handler(Looper.getMainLooper());

    /* renamed from: c  reason: collision with root package name */
    private Handler f37805c;

    /* renamed from: d  reason: collision with root package name */
    private HandlerThread f37806d;

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void a(Message message);

    protected abstract void b();

    public a(Context context, String str) {
        super(context);
        this.f37805c = null;
        this.f37806d = null;
        try {
            this.f37806d = new HandlerThread(str);
            this.f37806d.start();
            this.f37805c = new b(this, this.f37806d.getLooper());
            if (c() && d()) {
                b();
            }
        } catch (Throwable th) {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void b(Message message) {
        this.f37805c.sendMessage(message);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Message a() {
        return this.f37805c.obtainMessage();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void a(Runnable runnable) {
        f37804b.post(runnable);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(int i4, String str) {
        switch (i4) {
            case 0:
                a(new c(this, str));
                return;
            case 1:
                a(new d(this, str));
                return;
            case 2:
                a(new e(this, str));
                return;
            default:
                return;
        }
    }
}

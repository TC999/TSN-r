package com.baidu.liantian.b;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Message;
import com.stub.StubApp;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* compiled from: CtrlUtil.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class f {

    /* renamed from: b  reason: collision with root package name */
    private static Lock f12123b = new ReentrantLock();

    /* renamed from: c  reason: collision with root package name */
    private static f f12124c = null;

    /* renamed from: a  reason: collision with root package name */
    public com.baidu.liantian.rp.f.a f12125a;

    private f(Context context) {
        this.f12125a = new com.baidu.liantian.rp.f.a(context);
    }

    public static f a(Context context) {
        f fVar = f12124c;
        if (fVar != null) {
            return fVar;
        }
        try {
            f12123b.lock();
            if (f12124c == null) {
                f12124c = new f(context);
            }
            return f12124c;
        } finally {
            f12123b.unlock();
        }
    }

    public final void b() {
        com.baidu.liantian.rp.f.a aVar = this.f12125a;
        Message message = new Message();
        message.what = 7;
        aVar.a(message);
    }

    public final void c() {
        Message message = new Message();
        message.what = 2;
        this.f12125a.a(message);
    }

    public final void a() {
        com.baidu.liantian.rp.f.a aVar = this.f12125a;
        if (aVar.f12268d == null) {
            aVar.f12268d = new com.baidu.liantian.rp.e.a();
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.b.r.p");
        StubApp.getOrigApplicationContext(aVar.f12266b.getApplicationContext()).registerReceiver(aVar.f12268d, intentFilter);
        Message message = new Message();
        message.what = 5;
        aVar.a(message);
    }
}

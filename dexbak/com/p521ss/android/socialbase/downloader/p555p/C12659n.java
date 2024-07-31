package com.p521ss.android.socialbase.downloader.p555p;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.NonNull;

/* renamed from: com.ss.android.socialbase.downloader.p.n */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public final class C12659n implements Handler.Callback {

    /* renamed from: ok */
    private volatile Handler f35723ok = new Handler(C12661ok.f35724ok, this);

    /* renamed from: com.ss.android.socialbase.downloader.p.n$a */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public interface InterfaceC12660a {
        /* renamed from: ok */
        long mo16746ok();
    }

    /* renamed from: com.ss.android.socialbase.downloader.p.n$ok */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    private static class C12661ok {

        /* renamed from: ok */
        private static final Looper f35724ok;

        static {
            HandlerThread handlerThread = new HandlerThread("DownloadWatchDog");
            handlerThread.start();
            f35724ok = handlerThread.getLooper();
        }
    }

    /* renamed from: ok */
    public static Looper m16748ok() {
        return C12661ok.f35724ok;
    }

    /* renamed from: a */
    public void m16749a() {
        Handler handler = this.f35723ok;
        if (handler == null) {
            return;
        }
        this.f35723ok = null;
        handler.removeCallbacksAndMessages(null);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(@NonNull Message message) {
        if (message.what != 0) {
            return true;
        }
        try {
            InterfaceC12660a interfaceC12660a = (InterfaceC12660a) message.obj;
            long mo16746ok = interfaceC12660a.mo16746ok();
            if (mo16746ok > 0) {
                m16747ok(interfaceC12660a, mo16746ok);
                return true;
            }
            return true;
        } catch (Throwable th) {
            th.printStackTrace();
            return true;
        }
    }

    /* renamed from: ok */
    public void m16747ok(InterfaceC12660a interfaceC12660a, long j) {
        Handler handler = this.f35723ok;
        if (handler == null) {
            return;
        }
        Message obtain = Message.obtain();
        obtain.what = 0;
        obtain.obj = interfaceC12660a;
        handler.sendMessageDelayed(obtain, j);
    }
}

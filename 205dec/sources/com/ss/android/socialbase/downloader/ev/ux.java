package com.ss.android.socialbase.downloader.ev;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.NonNull;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
public final class ux implements Handler.Callback {

    /* renamed from: c  reason: collision with root package name */
    private volatile Handler f49544c = new Handler(c.f49545c, this);

    /* loaded from: E:\TSN-r\205dec\6206960.dex */
    private static class c {

        /* renamed from: c  reason: collision with root package name */
        private static final Looper f49545c;

        static {
            HandlerThread handlerThread = new HandlerThread("DownloadWatchDog");
            handlerThread.start();
            f49545c = handlerThread.getLooper();
        }
    }

    /* loaded from: E:\TSN-r\205dec\6206960.dex */
    public interface w {
        long c();
    }

    public static Looper c() {
        return c.f49545c;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(@NonNull Message message) {
        if (message.what != 0) {
            return true;
        }
        try {
            w wVar = (w) message.obj;
            long c4 = wVar.c();
            if (c4 > 0) {
                c(wVar, c4);
                return true;
            }
            return true;
        } catch (Throwable th) {
            th.printStackTrace();
            return true;
        }
    }

    public void w() {
        Handler handler = this.f49544c;
        if (handler == null) {
            return;
        }
        this.f49544c = null;
        handler.removeCallbacksAndMessages(null);
    }

    public void c(w wVar, long j4) {
        Handler handler = this.f49544c;
        if (handler == null) {
            return;
        }
        Message obtain = Message.obtain();
        obtain.what = 0;
        obtain.obj = wVar;
        handler.sendMessageDelayed(obtain, j4);
    }
}

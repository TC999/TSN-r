package com.ss.android.socialbase.downloader.p;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.NonNull;

/* loaded from: E:\TSN-r\205dec\6400276.dex */
public final class n implements Handler.Callback {
    private volatile Handler ok = new Handler(ok.ok, this);

    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public interface a {
        long ok();
    }

    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    private static class ok {
        private static final Looper ok;

        static {
            HandlerThread handlerThread = new HandlerThread("DownloadWatchDog");
            handlerThread.start();
            ok = handlerThread.getLooper();
        }
    }

    public static Looper ok() {
        return ok.ok;
    }

    public void a() {
        Handler handler = this.ok;
        if (handler == null) {
            return;
        }
        this.ok = null;
        handler.removeCallbacksAndMessages(null);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(@NonNull Message message) {
        if (message.what != 0) {
            return true;
        }
        try {
            a aVar = (a) message.obj;
            long ok2 = aVar.ok();
            if (ok2 > 0) {
                ok(aVar, ok2);
                return true;
            }
            return true;
        } catch (Throwable th) {
            th.printStackTrace();
            return true;
        }
    }

    public void ok(a aVar, long j4) {
        Handler handler = this.ok;
        if (handler == null) {
            return;
        }
        Message obtain = Message.obtain();
        obtain.what = 0;
        obtain.obj = aVar;
        handler.sendMessageDelayed(obtain, j4);
    }
}

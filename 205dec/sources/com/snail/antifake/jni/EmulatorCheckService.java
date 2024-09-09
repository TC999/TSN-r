package com.snail.antifake.jni;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import androidx.annotation.Nullable;
import com.snail.antifake.IEmulatorCheck;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class EmulatorCheckService extends Service {

    /* renamed from: a  reason: collision with root package name */
    Handler f48148a = new Handler();

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    class a extends IEmulatorCheck.Stub {

        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
        /* renamed from: com.snail.antifake.jni.EmulatorCheckService$a$a  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\6400276.dex */
        class RunnableC0934a implements Runnable {
            RunnableC0934a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                System.exit(0);
            }
        }

        a() {
        }

        @Override // com.snail.antifake.IEmulatorCheck
        public boolean d() throws RemoteException {
            return EmulatorDetectUtil.b(EmulatorCheckService.this);
        }

        @Override // com.snail.antifake.IEmulatorCheck
        public void e() throws RemoteException {
            EmulatorCheckService.this.stopSelf();
            EmulatorCheckService.this.f48148a.postDelayed(new RunnableC0934a(), 500L);
        }
    }

    @Override // android.app.Service
    @Nullable
    public IBinder onBind(Intent intent) {
        return new a();
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        Log.v("lishang", "onCreate");
    }
}

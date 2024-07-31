package com.snail.antifake.jni;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import androidx.annotation.Nullable;
import com.snail.antifake.IEmulatorCheck;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class EmulatorCheckService extends Service {

    /* renamed from: a */
    Handler f33814a = new Handler();

    /* renamed from: com.snail.antifake.jni.EmulatorCheckService$a */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    class BinderC11948a extends IEmulatorCheck.Stub {

        /* renamed from: com.snail.antifake.jni.EmulatorCheckService$a$a */
        /* loaded from: E:\fuckcool\tsn\6400276.dex */
        class RunnableC11949a implements Runnable {
            RunnableC11949a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                System.exit(0);
            }
        }

        BinderC11948a() {
        }

        @Override // com.snail.antifake.IEmulatorCheck
        /* renamed from: d */
        public boolean mo19671d() throws RemoteException {
            return EmulatorDetectUtil.m19668b(EmulatorCheckService.this);
        }

        @Override // com.snail.antifake.IEmulatorCheck
        /* renamed from: e */
        public void mo19670e() throws RemoteException {
            EmulatorCheckService.this.stopSelf();
            EmulatorCheckService.this.f33814a.postDelayed(new RunnableC11949a(), 500L);
        }
    }

    @Override // android.app.Service
    @Nullable
    public IBinder onBind(Intent intent) {
        return new BinderC11948a();
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        Log.v("lishang", "onCreate");
    }
}

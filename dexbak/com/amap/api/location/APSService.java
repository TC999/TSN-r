package com.amap.api.location;

import android.app.Notification;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.amap.api.col.p0463l.ApsServiceCore;
import com.autonavi.aps.amapapi.utils.C2428b;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class APSService extends Service {

    /* renamed from: a */
    ApsServiceCore f6951a;

    /* renamed from: b */
    int f6952b = 0;

    /* renamed from: c */
    boolean f6953c = false;

    /* renamed from: a */
    private void m52129a(Context context) {
        try {
            if (this.f6951a == null) {
                this.f6951a = new ApsServiceCore(context);
            }
            this.f6951a.m53803b();
        } catch (Throwable th) {
            C2428b.m51299a(th, "APSService", "onCreate");
        }
        super.onCreate();
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        try {
            return this.f6951a.m53804a(intent);
        } catch (Throwable th) {
            C2428b.m51299a(th, "APSService", "onBind");
            return null;
        }
    }

    @Override // android.app.Service
    public void onCreate() {
        m52129a(this);
    }

    @Override // android.app.Service
    public void onDestroy() {
        try {
            this.f6951a.m53801d();
            if (this.f6953c) {
                stopForeground(true);
            }
        } catch (Throwable th) {
            C2428b.m51299a(th, "APSService", "onDestroy");
        }
        super.onDestroy();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        int i3;
        if (intent != null) {
            try {
                int intExtra = intent.getIntExtra("g", 0);
                if (intExtra == 1) {
                    int intExtra2 = intent.getIntExtra("i", 0);
                    Notification notification = (Notification) intent.getParcelableExtra("h");
                    if (intExtra2 != 0 && notification != null) {
                        startForeground(intExtra2, notification);
                        this.f6953c = true;
                        this.f6952b++;
                    }
                } else if (intExtra == 2) {
                    if (intent.getBooleanExtra("j", true) && (i3 = this.f6952b) > 0) {
                        this.f6952b = i3 - 1;
                    }
                    if (this.f6952b <= 0) {
                        stopForeground(true);
                        this.f6953c = false;
                    } else {
                        stopForeground(false);
                    }
                }
            } catch (Throwable unused) {
            }
        }
        try {
            return this.f6951a.m53802c();
        } catch (Throwable th) {
            C2428b.m51299a(th, "APSService", "onStartCommand");
            return super.onStartCommand(intent, i, i2);
        }
    }
}

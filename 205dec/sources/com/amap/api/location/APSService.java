package com.amap.api.location;

import android.app.Notification;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.amap.api.col.p0003l.u3;
import com.autonavi.aps.amapapi.utils.b;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class APSService extends Service {

    /* renamed from: a  reason: collision with root package name */
    u3 f10655a;

    /* renamed from: b  reason: collision with root package name */
    int f10656b = 0;

    /* renamed from: c  reason: collision with root package name */
    boolean f10657c = false;

    private void a(Context context) {
        try {
            if (this.f10655a == null) {
                this.f10655a = new u3(context);
            }
            this.f10655a.b();
        } catch (Throwable th) {
            b.a(th, "APSService", "onCreate");
        }
        super.onCreate();
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        try {
            return this.f10655a.a(intent);
        } catch (Throwable th) {
            b.a(th, "APSService", "onBind");
            return null;
        }
    }

    @Override // android.app.Service
    public void onCreate() {
        a(this);
    }

    @Override // android.app.Service
    public void onDestroy() {
        try {
            this.f10655a.d();
            if (this.f10657c) {
                stopForeground(true);
            }
        } catch (Throwable th) {
            b.a(th, "APSService", "onDestroy");
        }
        super.onDestroy();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i4, int i5) {
        int i6;
        if (intent != null) {
            try {
                int intExtra = intent.getIntExtra("g", 0);
                if (intExtra == 1) {
                    int intExtra2 = intent.getIntExtra("i", 0);
                    Notification notification = (Notification) intent.getParcelableExtra("h");
                    if (intExtra2 != 0 && notification != null) {
                        startForeground(intExtra2, notification);
                        this.f10657c = true;
                        this.f10656b++;
                    }
                } else if (intExtra == 2) {
                    if (intent.getBooleanExtra("j", true) && (i6 = this.f10656b) > 0) {
                        this.f10656b = i6 - 1;
                    }
                    if (this.f10656b <= 0) {
                        stopForeground(true);
                        this.f10657c = false;
                    } else {
                        stopForeground(false);
                    }
                }
            } catch (Throwable unused) {
            }
        }
        try {
            return this.f10655a.c();
        } catch (Throwable th) {
            b.a(th, "APSService", "onStartCommand");
            return super.onStartCommand(intent, i4, i5);
        }
    }
}

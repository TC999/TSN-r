package com.baidu.liantian;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.text.TextUtils;
import com.amap.api.col.p0003l.f4;
import com.baidu.liantian.b.r;
import com.baidu.liantian.core.ApkInfo;
import com.baidu.liantian.core.g;
import com.stub.StubApp;

/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class LiantianService extends Service {

    /* renamed from: a  reason: collision with root package name */
    private volatile int f12098a = 0;

    static /* synthetic */ void a(LiantianService liantianService) {
        try {
            liantianService.f12098a--;
            if (liantianService.f12098a <= 0) {
                liantianService.f12098a = 0;
                b.a();
                liantianService.stopSelf();
            }
        } catch (Throwable unused) {
            com.baidu.liantian.b.e.a();
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public int onStartCommand(final Intent intent, int i4, int i5) {
        try {
        } catch (Throwable unused) {
            com.baidu.liantian.b.e.a();
        }
        if (intent == null) {
            return super.onStartCommand(intent, i4, i5);
        }
        this.f12098a++;
        final String stringExtra = intent.getStringExtra("from_plugin_package");
        intent.getAction();
        b.a();
        r.a().a(new Runnable() { // from class: com.baidu.liantian.LiantianService.1
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    System.currentTimeMillis();
                    intent.getAction();
                    b.a();
                    if ("s".equals(intent.getStringExtra("t"))) {
                        String stringExtra2 = intent.getStringExtra("c");
                        Intent intent2 = new Intent();
                        intent2.putExtra("t", "s");
                        intent2.putExtra("c", stringExtra2);
                        a.a(StubApp.getOrigApplicationContext(LiantianService.this.getApplicationContext()), intent2);
                    }
                    b.a();
                    if (TextUtils.isEmpty(stringExtra)) {
                        LiantianService.a(LiantianService.this);
                    } else if (LiantianService.this.getPackageName().equals(stringExtra)) {
                        LiantianService liantianService = LiantianService.this;
                        LiantianService.a(liantianService, liantianService.getClassLoader(), intent);
                        LiantianService.a(LiantianService.this);
                    } else {
                        g a4 = g.a();
                        if (a4 == null) {
                            LiantianService.a(LiantianService.this);
                            return;
                        }
                        ApkInfo d4 = a4.d(stringExtra);
                        f4.a(d4);
                        b.a();
                        if (d4 == null) {
                            LiantianService.a(LiantianService.this);
                            return;
                        }
                        LiantianService.a(LiantianService.this, d4.classLoader, intent);
                        System.currentTimeMillis();
                        intent.toString();
                        b.a();
                        LiantianService.a(LiantianService.this);
                    }
                } catch (Throwable unused2) {
                    com.baidu.liantian.b.e.a();
                    LiantianService.a(LiantianService.this);
                }
            }
        });
        return super.onStartCommand(intent, i4, i5);
    }

    static /* synthetic */ void a(LiantianService liantianService, ClassLoader classLoader, Intent intent) {
        try {
            Class<?> loadClass = classLoader.loadClass(intent.getStringExtra("target_class"));
            Object newInstance = loadClass.newInstance();
            f4.a(newInstance);
            b.a();
            String stringExtra = intent.getStringExtra("target_method");
            b.a();
            loadClass.getDeclaredMethod(stringExtra, Context.class, Intent.class).invoke(newInstance, StubApp.getOrigApplicationContext(liantianService.getApplicationContext()), intent);
        } catch (Throwable th) {
            th.getMessage();
            b.b();
        }
    }
}

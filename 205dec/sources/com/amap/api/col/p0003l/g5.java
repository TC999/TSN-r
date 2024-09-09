package com.amap.api.col.p0003l;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.provider.Settings;
import android.text.TextUtils;
import com.stub.StubApp;
import java.lang.ref.WeakReference;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* compiled from: AdiuManager.java */
/* renamed from: com.amap.api.col.3l.g5  reason: invalid package */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class g5 {

    /* renamed from: c  reason: collision with root package name */
    private static g5 f7871c;

    /* renamed from: a  reason: collision with root package name */
    private final Context f7872a;

    /* renamed from: b  reason: collision with root package name */
    private final String f7873b = n5.d(q4.u("RYW1hcF9kZXZpY2VfYWRpdQ"));

    /* compiled from: AdiuStorageModel.java */
    /* renamed from: com.amap.api.col.3l.g5$a */
    /* loaded from: E:\TSN-r\205dec\6276784.dex */
    final class a extends Thread {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f7874a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f7875b;

        a(String str, int i4) {
            this.f7874a = str;
            this.f7875b = i4;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public final void run() {
            String h4 = m5.h(this.f7874a);
            if (TextUtils.isEmpty(h4)) {
                return;
            }
            if ((this.f7875b & 1) > 0) {
                try {
                    if (Build.VERSION.SDK_INT >= 23) {
                        if (Settings.System.canWrite(g5.a(g5.this))) {
                            Settings.System.putString(g5.a(g5.this).getContentResolver(), g5.f(g5.this), h4);
                        }
                    } else {
                        Settings.System.putString(g5.a(g5.this).getContentResolver(), g5.f(g5.this), h4);
                    }
                } catch (Exception unused) {
                }
            }
            if ((this.f7875b & 16) > 0) {
                i5.b(g5.a(g5.this), g5.f(g5.this), h4);
            }
            if ((this.f7875b & 256) > 0) {
                SharedPreferences.Editor edit = g5.a(g5.this).getSharedPreferences(g5.e, 0).edit();
                edit.putString(g5.f(g5.this), h4);
                edit.apply();
            }
        }
    }

    private g5(Context context) {
        this.f7872a = StubApp.getOrigApplicationContext(context.getApplicationContext());
    }

    public static g5 a(Context context) {
        if (f7871c == null) {
            synchronized (g5.class) {
                if (f7871c == null) {
                    f7871c = new g5(context);
                }
            }
        }
        return f7871c;
    }

    public final synchronized void b() {
        try {
            if (i4.z() == null) {
                i4.q(k5.a());
            }
        } catch (Throwable unused) {
        }
    }

    public final void c(String str) {
        h5.b(this.f7872a).d(this.f7873b);
        h5.b(this.f7872a).g(str);
    }

    /* compiled from: AdiuStorageModel.java */
    /* renamed from: com.amap.api.col.3l.g5$b */
    /* loaded from: E:\TSN-r\205dec\6276784.dex */
    private static final class b extends Handler {

        /* renamed from: a  reason: collision with root package name */
        private final WeakReference<g5> f7877a;

        b(g5 g5Var) {
            this.f7877a = new WeakReference<>(g5Var);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            Object obj;
            g5 g5Var = this.f7877a.get();
            if (g5Var == null || message == null || (obj = message.obj) == null) {
                return;
            }
            g5.c(g5Var, (String) obj, message.what);
        }

        b(Looper looper, g5 g5Var) {
            super(looper);
            this.f7877a = new WeakReference<>(g5Var);
        }
    }
}

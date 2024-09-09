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
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* compiled from: AdiuStorageModel.java */
/* renamed from: com.amap.api.col.3l.h5  reason: invalid package */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class h5 {

    /* renamed from: e  reason: collision with root package name */
    public static final String f7994e = q4.u("SU2hhcmVkUHJlZmVyZW5jZUFkaXU");

    /* renamed from: f  reason: collision with root package name */
    private static h5 f7995f;

    /* renamed from: a  reason: collision with root package name */
    private List<String> f7996a;

    /* renamed from: b  reason: collision with root package name */
    private String f7997b;

    /* renamed from: c  reason: collision with root package name */
    private final Context f7998c;

    /* renamed from: d  reason: collision with root package name */
    private final Handler f7999d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AdiuStorageModel.java */
    /* renamed from: com.amap.api.col.3l.h5$a */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public final class a extends Thread {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f8000a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f8001b;

        a(String str, int i4) {
            this.f8000a = str;
            this.f8001b = i4;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public final void run() {
            String h4 = n5.h(this.f8000a);
            if (TextUtils.isEmpty(h4)) {
                return;
            }
            if ((this.f8001b & 1) > 0) {
                try {
                    if (Build.VERSION.SDK_INT >= 23) {
                        if (Settings.System.canWrite(h5.this.f7998c)) {
                            Settings.System.putString(h5.this.f7998c.getContentResolver(), h5.this.f7997b, h4);
                        }
                    } else {
                        Settings.System.putString(h5.this.f7998c.getContentResolver(), h5.this.f7997b, h4);
                    }
                } catch (Exception unused) {
                }
            }
            if ((this.f8001b & 16) > 0) {
                j5.b(h5.this.f7998c, h5.this.f7997b, h4);
            }
            if ((this.f8001b & 256) > 0) {
                SharedPreferences.Editor edit = h5.this.f7998c.getSharedPreferences(h5.f7994e, 0).edit();
                edit.putString(h5.this.f7997b, h4);
                edit.apply();
            }
        }
    }

    private h5(Context context) {
        this.f7998c = StubApp.getOrigApplicationContext(context.getApplicationContext());
        if (Looper.myLooper() == null) {
            this.f7999d = new b(Looper.getMainLooper(), this);
        } else {
            this.f7999d = new b(this);
        }
    }

    public static h5 b(Context context) {
        if (f7995f == null) {
            synchronized (h5.class) {
                if (f7995f == null) {
                    f7995f = new h5(context);
                }
            }
        }
        return f7995f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void e(String str, int i4) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            new a(str, i4).start();
            return;
        }
        String h4 = n5.h(str);
        if (!TextUtils.isEmpty(h4)) {
            if ((i4 & 1) > 0) {
                try {
                    if (Build.VERSION.SDK_INT >= 23) {
                        Settings.System.putString(this.f7998c.getContentResolver(), this.f7997b, h4);
                    } else {
                        Settings.System.putString(this.f7998c.getContentResolver(), this.f7997b, h4);
                    }
                } catch (Exception unused) {
                }
            }
            if ((i4 & 16) > 0) {
                j5.b(this.f7998c, this.f7997b, h4);
            }
            if ((i4 & 256) > 0) {
                SharedPreferences.Editor edit = this.f7998c.getSharedPreferences(f7994e, 0).edit();
                edit.putString(this.f7997b, h4);
                edit.apply();
            }
        }
    }

    public final void d(String str) {
        this.f7997b = str;
    }

    public final void g(String str) {
        List<String> list = this.f7996a;
        if (list != null) {
            list.clear();
            this.f7996a.add(str);
        }
        e(str, 273);
    }

    /* compiled from: AdiuStorageModel.java */
    /* renamed from: com.amap.api.col.3l.h5$b */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    private static final class b extends Handler {

        /* renamed from: a  reason: collision with root package name */
        private final WeakReference<h5> f8003a;

        b(h5 h5Var) {
            this.f8003a = new WeakReference<>(h5Var);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            Object obj;
            h5 h5Var = this.f8003a.get();
            if (h5Var == null || message == null || (obj = message.obj) == null) {
                return;
            }
            h5Var.e((String) obj, message.what);
        }

        b(Looper looper, h5 h5Var) {
            super(looper);
            this.f8003a = new WeakReference<>(h5Var);
        }
    }
}

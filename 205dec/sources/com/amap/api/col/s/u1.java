package com.amap.api.col.s;

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
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: AdiuStorageModel.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class u1 {

    /* renamed from: e  reason: collision with root package name */
    public static final String f10265e = j1.t("SU2hhcmVkUHJlZmVyZW5jZUFkaXU");

    /* renamed from: f  reason: collision with root package name */
    private static u1 f10266f;

    /* renamed from: a  reason: collision with root package name */
    private List<String> f10267a;

    /* renamed from: b  reason: collision with root package name */
    private String f10268b;

    /* renamed from: c  reason: collision with root package name */
    private final Context f10269c;

    /* renamed from: d  reason: collision with root package name */
    private final Handler f10270d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: AdiuStorageModel.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public final class a extends Thread {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f10271a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f10272b;

        a(String str, int i4) {
            this.f10271a = str;
            this.f10272b = i4;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public final void run() {
            String h4 = a2.h(this.f10271a);
            if (TextUtils.isEmpty(h4)) {
                return;
            }
            if ((this.f10272b & 1) > 0) {
                try {
                    if (Build.VERSION.SDK_INT >= 23) {
                        if (Settings.System.canWrite(u1.this.f10269c)) {
                            Settings.System.putString(u1.this.f10269c.getContentResolver(), u1.this.f10268b, h4);
                        }
                    } else {
                        Settings.System.putString(u1.this.f10269c.getContentResolver(), u1.this.f10268b, h4);
                    }
                } catch (Exception unused) {
                }
            }
            if ((this.f10272b & 16) > 0) {
                w1.b(u1.this.f10269c, u1.this.f10268b, h4);
            }
            if ((this.f10272b & 256) > 0) {
                SharedPreferences.Editor edit = u1.this.f10269c.getSharedPreferences(u1.f10265e, 0).edit();
                edit.putString(u1.this.f10268b, h4);
                edit.apply();
            }
        }
    }

    private u1(Context context) {
        this.f10269c = StubApp.getOrigApplicationContext(context.getApplicationContext());
        if (Looper.myLooper() == null) {
            this.f10270d = new b(Looper.getMainLooper(), this);
        } else {
            this.f10270d = new b(this);
        }
    }

    public static u1 b(Context context) {
        if (f10266f == null) {
            synchronized (u1.class) {
                if (f10266f == null) {
                    f10266f = new u1(context);
                }
            }
        }
        return f10266f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void e(String str, int i4) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            new a(str, i4).start();
            return;
        }
        String h4 = a2.h(str);
        if (!TextUtils.isEmpty(h4)) {
            if ((i4 & 1) > 0) {
                try {
                    if (Build.VERSION.SDK_INT >= 23) {
                        Settings.System.putString(this.f10269c.getContentResolver(), this.f10268b, h4);
                    } else {
                        Settings.System.putString(this.f10269c.getContentResolver(), this.f10268b, h4);
                    }
                } catch (Exception unused) {
                }
            }
            if ((i4 & 16) > 0) {
                w1.b(this.f10269c, this.f10268b, h4);
            }
            if ((i4 & 256) > 0) {
                SharedPreferences.Editor edit = this.f10269c.getSharedPreferences(f10265e, 0).edit();
                edit.putString(this.f10268b, h4);
                edit.apply();
            }
        }
    }

    public final void d(String str) {
        this.f10268b = str;
    }

    public final void g(String str) {
        List<String> list = this.f10267a;
        if (list != null) {
            list.clear();
            this.f10267a.add(str);
        }
        e(str, 273);
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: AdiuStorageModel.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    private static final class b extends Handler {

        /* renamed from: a  reason: collision with root package name */
        private final WeakReference<u1> f10274a;

        b(u1 u1Var) {
            this.f10274a = new WeakReference<>(u1Var);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            Object obj;
            u1 u1Var = this.f10274a.get();
            if (u1Var == null || message == null || (obj = message.obj) == null) {
                return;
            }
            u1Var.e((String) obj, message.what);
        }

        b(Looper looper, u1 u1Var) {
            super(looper);
            this.f10274a = new WeakReference<>(u1Var);
        }
    }
}

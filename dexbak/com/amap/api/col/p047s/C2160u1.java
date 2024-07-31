package com.amap.api.col.p047s;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.provider.Settings;
import android.text.TextUtils;
import com.stub.StubApp;
import com.umeng.commonsdk.stateless.UMSLNetWorkSender;
import java.lang.ref.WeakReference;
import java.util.List;

/* compiled from: AdiuStorageModel.java */
/* renamed from: com.amap.api.col.s.u1 */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class C2160u1 {

    /* renamed from: e */
    public static final String f6537e = C2079j1.m52857t("SU2hhcmVkUHJlZmVyZW5jZUFkaXU");

    /* renamed from: f */
    private static C2160u1 f6538f;

    /* renamed from: a */
    private List<String> f6539a;

    /* renamed from: b */
    private String f6540b;

    /* renamed from: c */
    private final Context f6541c;

    /* renamed from: d */
    private final Handler f6542d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AdiuStorageModel.java */
    /* renamed from: com.amap.api.col.s.u1$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public final class C2161a extends Thread {

        /* renamed from: a */
        final /* synthetic */ String f6543a;

        /* renamed from: b */
        final /* synthetic */ int f6544b;

        C2161a(String str, int i) {
            this.f6543a = str;
            this.f6544b = i;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public final void run() {
            String m53257h = C2018a2.m53257h(this.f6543a);
            if (TextUtils.isEmpty(m53257h)) {
                return;
            }
            if ((this.f6544b & 1) > 0) {
                try {
                    if (Build.VERSION.SDK_INT >= 23) {
                        if (Settings.System.canWrite(C2160u1.this.f6541c)) {
                            Settings.System.putString(C2160u1.this.f6541c.getContentResolver(), C2160u1.this.f6540b, m53257h);
                        }
                    } else {
                        Settings.System.putString(C2160u1.this.f6541c.getContentResolver(), C2160u1.this.f6540b, m53257h);
                    }
                } catch (Exception unused) {
                }
            }
            if ((this.f6544b & 16) > 0) {
                C2192w1.m52362b(C2160u1.this.f6541c, C2160u1.this.f6540b, m53257h);
            }
            if ((this.f6544b & 256) > 0) {
                SharedPreferences.Editor edit = C2160u1.this.f6541c.getSharedPreferences(C2160u1.f6537e, 0).edit();
                edit.putString(C2160u1.this.f6540b, m53257h);
                edit.apply();
            }
        }
    }

    private C2160u1(Context context) {
        this.f6541c = StubApp.getOrigApplicationContext(context.getApplicationContext());
        if (Looper.myLooper() == null) {
            this.f6542d = new HandlerC2162b(Looper.getMainLooper(), this);
        } else {
            this.f6542d = new HandlerC2162b(this);
        }
    }

    /* renamed from: b */
    public static C2160u1 m52436b(Context context) {
        if (f6538f == null) {
            synchronized (C2160u1.class) {
                if (f6538f == null) {
                    f6538f = new C2160u1(context);
                }
            }
        }
        return f6538f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public synchronized void m52433e(String str, int i) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            new C2161a(str, i).start();
            return;
        }
        String m53257h = C2018a2.m53257h(str);
        if (!TextUtils.isEmpty(m53257h)) {
            if ((i & 1) > 0) {
                try {
                    if (Build.VERSION.SDK_INT >= 23) {
                        Settings.System.putString(this.f6541c.getContentResolver(), this.f6540b, m53257h);
                    } else {
                        Settings.System.putString(this.f6541c.getContentResolver(), this.f6540b, m53257h);
                    }
                } catch (Exception unused) {
                }
            }
            if ((i & 16) > 0) {
                C2192w1.m52362b(this.f6541c, this.f6540b, m53257h);
            }
            if ((i & 256) > 0) {
                SharedPreferences.Editor edit = this.f6541c.getSharedPreferences(f6537e, 0).edit();
                edit.putString(this.f6540b, m53257h);
                edit.apply();
            }
        }
    }

    /* renamed from: d */
    public final void m52434d(String str) {
        this.f6540b = str;
    }

    /* renamed from: g */
    public final void m52431g(String str) {
        List<String> list = this.f6539a;
        if (list != null) {
            list.clear();
            this.f6539a.add(str);
        }
        m52433e(str, UMSLNetWorkSender.f38894a);
    }

    /* compiled from: AdiuStorageModel.java */
    /* renamed from: com.amap.api.col.s.u1$b */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    private static final class HandlerC2162b extends Handler {

        /* renamed from: a */
        private final WeakReference<C2160u1> f6546a;

        HandlerC2162b(C2160u1 c2160u1) {
            this.f6546a = new WeakReference<>(c2160u1);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            Object obj;
            C2160u1 c2160u1 = this.f6546a.get();
            if (c2160u1 == null || message == null || (obj = message.obj) == null) {
                return;
            }
            c2160u1.m52433e((String) obj, message.what);
        }

        HandlerC2162b(Looper looper, C2160u1 c2160u1) {
            super(looper);
            this.f6546a = new WeakReference<>(c2160u1);
        }
    }
}

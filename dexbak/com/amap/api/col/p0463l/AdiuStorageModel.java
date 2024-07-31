package com.amap.api.col.p0463l;

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

/* renamed from: com.amap.api.col.3l.g5 */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class AdiuStorageModel {

    /* renamed from: e */
    public static final String f4271e = C1925p4.m54183u("SU2hhcmVkUHJlZmVyZW5jZUFkaXU");

    /* renamed from: f */
    private static AdiuStorageModel f4272f;

    /* renamed from: a */
    private List<String> f4273a;

    /* renamed from: b */
    private String f4274b;

    /* renamed from: c */
    private final Context f4275c;

    /* renamed from: d */
    private final Handler f4276d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AdiuStorageModel.java */
    /* renamed from: com.amap.api.col.3l.g5$a */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public final class C1819a extends Thread {

        /* renamed from: a */
        final /* synthetic */ String f4277a;

        /* renamed from: b */
        final /* synthetic */ int f4278b;

        C1819a(String str, int i) {
            this.f4277a = str;
            this.f4278b = i;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public final void run() {
            String m54520h = SecurityUtil.m54520h(this.f4277a);
            if (TextUtils.isEmpty(m54520h)) {
                return;
            }
            if ((this.f4278b & 1) > 0) {
                try {
                    if (Build.VERSION.SDK_INT >= 23) {
                        if (Settings.System.canWrite(AdiuStorageModel.this.f4275c)) {
                            Settings.System.putString(AdiuStorageModel.this.f4275c.getContentResolver(), AdiuStorageModel.this.f4274b, m54520h);
                        }
                    } else {
                        Settings.System.putString(AdiuStorageModel.this.f4275c.getContentResolver(), AdiuStorageModel.this.f4274b, m54520h);
                    }
                } catch (Exception unused) {
                }
            }
            if ((this.f4278b & 16) > 0) {
                FileStorageModel.m54712b(AdiuStorageModel.this.f4275c, AdiuStorageModel.this.f4274b, m54520h);
            }
            if ((this.f4278b & 256) > 0) {
                SharedPreferences.Editor edit = AdiuStorageModel.this.f4275c.getSharedPreferences(AdiuStorageModel.f4271e, 0).edit();
                edit.putString(AdiuStorageModel.this.f4274b, m54520h);
                edit.apply();
            }
        }
    }

    private AdiuStorageModel(Context context) {
        this.f4275c = StubApp.getOrigApplicationContext(context.getApplicationContext());
        if (Looper.myLooper() == null) {
            this.f4276d = new HandlerC1820b(Looper.getMainLooper(), this);
        } else {
            this.f4276d = new HandlerC1820b(this);
        }
    }

    /* renamed from: b */
    public static AdiuStorageModel m54920b(Context context) {
        if (f4272f == null) {
            synchronized (AdiuStorageModel.class) {
                if (f4272f == null) {
                    f4272f = new AdiuStorageModel(context);
                }
            }
        }
        return f4272f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public synchronized void m54917e(String str, int i) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            new C1819a(str, i).start();
            return;
        }
        String m54520h = SecurityUtil.m54520h(str);
        if (!TextUtils.isEmpty(m54520h)) {
            if ((i & 1) > 0) {
                try {
                    if (Build.VERSION.SDK_INT >= 23) {
                        Settings.System.putString(this.f4275c.getContentResolver(), this.f4274b, m54520h);
                    } else {
                        Settings.System.putString(this.f4275c.getContentResolver(), this.f4274b, m54520h);
                    }
                } catch (Exception unused) {
                }
            }
            if ((i & 16) > 0) {
                FileStorageModel.m54712b(this.f4275c, this.f4274b, m54520h);
            }
            if ((i & 256) > 0) {
                SharedPreferences.Editor edit = this.f4275c.getSharedPreferences(f4271e, 0).edit();
                edit.putString(this.f4274b, m54520h);
                edit.apply();
            }
        }
    }

    /* renamed from: d */
    public final void m54918d(String str) {
        this.f4274b = str;
    }

    /* renamed from: g */
    public final void m54915g(String str) {
        List<String> list = this.f4273a;
        if (list != null) {
            list.clear();
            this.f4273a.add(str);
        }
        m54917e(str, UMSLNetWorkSender.f38894a);
    }

    /* compiled from: AdiuStorageModel.java */
    /* renamed from: com.amap.api.col.3l.g5$b */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    private static final class HandlerC1820b extends Handler {

        /* renamed from: a */
        private final WeakReference<AdiuStorageModel> f4280a;

        HandlerC1820b(AdiuStorageModel adiuStorageModel) {
            this.f4280a = new WeakReference<>(adiuStorageModel);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            Object obj;
            AdiuStorageModel adiuStorageModel = this.f4280a.get();
            if (adiuStorageModel == null || message == null || (obj = message.obj) == null) {
                return;
            }
            adiuStorageModel.m54917e((String) obj, message.what);
        }

        HandlerC1820b(Looper looper, AdiuStorageModel adiuStorageModel) {
            super(looper);
            this.f4280a = new WeakReference<>(adiuStorageModel);
        }
    }
}

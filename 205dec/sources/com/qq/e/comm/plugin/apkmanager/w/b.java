package com.qq.e.comm.plugin.apkmanager.w;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.qq.e.ads.cfg.MultiProcessFlag;
import com.qq.e.comm.plugin.util.b1;
import com.qq.e.comm.plugin.util.d1;
import java.io.File;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class b extends com.qq.e.comm.plugin.apkmanager.w.c {

    /* renamed from: b  reason: collision with root package name */
    private Handler f41926b = new Handler(Looper.getMainLooper());

    /* renamed from: c  reason: collision with root package name */
    private final Map<String, c> f41927c = new ConcurrentHashMap();

    /* renamed from: d  reason: collision with root package name */
    private final Map<String, Long> f41928d = new ConcurrentHashMap();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class a implements Runnable {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f41929c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ c f41930d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ long f41931e;

        a(String str, c cVar, long j4) {
            this.f41929c = str;
            this.f41930d = cVar;
            this.f41931e = j4;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                b.this.b(this.f41929c, this.f41930d, this.f41931e);
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: A */
    /* renamed from: com.qq.e.comm.plugin.apkmanager.w.b$b  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public static final class C0789b {

        /* renamed from: a  reason: collision with root package name */
        static b f41933a = new b();
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public static final class c {

        /* renamed from: a  reason: collision with root package name */
        public int f41934a;

        /* renamed from: b  reason: collision with root package name */
        public int f41935b;

        /* renamed from: c  reason: collision with root package name */
        public int f41936c;
    }

    public c b(Context context, String str) {
        String a4 = com.qq.e.comm.plugin.apkmanager.x.b.a(str);
        c cVar = this.f41927c.get(a4);
        if (cVar == null || cVar.f41934a == 8) {
            File b4 = b1.b(a4 + ".apk");
            if (cVar == null) {
                cVar = new c();
            }
            if (cVar.f41934a == 8 && b4 != null && b4.exists()) {
                cVar.f41935b = 100;
            } else if (com.qq.e.comm.plugin.apkmanager.x.b.a(b4, str, context)) {
                cVar.f41934a = 8;
                cVar.f41935b = 100;
            } else {
                cVar.f41934a = 0;
                cVar.f41935b = 0;
            }
            this.f41927c.put(a4, cVar);
        }
        return cVar;
    }

    public int c(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        c b4 = b(context, str);
        if (b4.f41934a == 4) {
            return b4.f41935b;
        }
        return 0;
    }

    public int d(Context context, String str) {
        return a(context, str, true);
    }

    public static b a() {
        return C0789b.f41933a;
    }

    public int a(Context context, String str, boolean z3) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        if (z3 && d.f(a(context, str))) {
            return 1;
        }
        return b(context, str).f41934a;
    }

    public void a(String str, int i4) {
        a(str, i4, 0);
    }

    public void a(String str, int i4, int i5) {
        String a4 = com.qq.e.comm.plugin.apkmanager.x.b.a(str);
        c cVar = this.f41927c.get(a4);
        if (cVar != null) {
            cVar.f41934a = i4;
            cVar.f41936c = i5;
        } else {
            cVar = new c();
            cVar.f41934a = i4;
            this.f41927c.put(a4, cVar);
        }
        if (d.a(i4)) {
            cVar.f41935b = 0;
        }
        Long l4 = this.f41928d.get(a4);
        long longValue = l4 == null ? 0L : l4.longValue();
        a(str, cVar.f41934a, cVar.f41935b, longValue);
        a(str, cVar, longValue);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str, c cVar, long j4) {
        Intent intent = new Intent();
        Context a4 = com.qq.e.comm.plugin.d0.a.d().a();
        String packageName = a4.getPackageName();
        intent.setAction(packageName + ".gdtdownload");
        intent.putExtra("package", str);
        intent.putExtra("status", cVar.f41934a);
        intent.putExtra("progress", cVar.f41935b);
        intent.putExtra("totalSize", j4);
        intent.setPackage(packageName);
        d1.a("Before broadCast::" + intent, new Object[0]);
        a4.sendBroadcast(intent);
    }

    public void b(String str) {
        String a4 = com.qq.e.comm.plugin.apkmanager.x.b.a(str);
        c cVar = this.f41927c.get(a4);
        if (this.f41928d.get(a4) == null) {
            this.f41928d.put(a4, 0L);
        }
        if (cVar != null) {
            cVar.f41935b = 0;
            return;
        }
        c cVar2 = new c();
        cVar2.f41935b = 0;
        this.f41927c.put(a4, cVar2);
    }

    private void a(String str, c cVar, long j4) {
        if (MultiProcessFlag.isMultiProcess()) {
            this.f41926b.post(new a(str, cVar, j4));
        }
    }

    public void a(String str, int i4, long j4) {
        String a4 = com.qq.e.comm.plugin.apkmanager.x.b.a(str);
        c cVar = this.f41927c.get(a4);
        if (this.f41928d.get(a4) == null) {
            this.f41928d.put(a4, Long.valueOf(j4));
        }
        boolean z3 = true;
        if (cVar != null) {
            if (cVar.f41935b != i4) {
                cVar.f41935b = i4;
            } else {
                z3 = false;
            }
        } else {
            cVar = new c();
            cVar.f41935b = i4;
            this.f41927c.put(a4, cVar);
        }
        if (z3) {
            a(str, cVar.f41934a, cVar.f41935b, j4);
            if (cVar.f41935b % 5 == 0) {
                a(str, cVar, j4);
            }
        }
    }

    private int a(Context context, String str) {
        return com.qq.e.comm.plugin.apkmanager.x.b.b(context, str) ? 1 : 0;
    }

    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        a(str, 1, 100, 0L);
        c cVar = new c();
        cVar.f41934a = 1;
        cVar.f41935b = 100;
        a(str, cVar, 0L);
    }
}

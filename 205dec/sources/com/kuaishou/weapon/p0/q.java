package com.kuaishou.weapon.p0;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.stub.StubApp;
import java.io.File;
import java.util.Timer;
import java.util.TimerTask;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class q {

    /* renamed from: a  reason: collision with root package name */
    public static final int f38395a = 3;

    /* renamed from: b  reason: collision with root package name */
    private static q f38396b = null;

    /* renamed from: g  reason: collision with root package name */
    private static final String f38397g = "1";

    /* renamed from: c  reason: collision with root package name */
    private volatile boolean f38398c = false;

    /* renamed from: d  reason: collision with root package name */
    private dp f38399d;

    /* renamed from: e  reason: collision with root package name */
    private Context f38400e;

    /* renamed from: f  reason: collision with root package name */
    private t f38401f;

    private q(Context context) {
        this.f38400e = context;
        this.f38399d = dp.a(context);
        this.f38401f = t.a(context);
    }

    private static void d() {
        try {
            dp a4 = dp.a();
            if (a4 != null) {
                a4.b("W_S_V", "1");
            }
        } catch (Exception unused) {
        }
    }

    public void c() {
        for (s sVar : this.f38401f.a()) {
            r a4 = r.a();
            if ((a4 != null ? a4.d(sVar.f38417c) : null) == null) {
                a(sVar.f38415a, sVar.f38418d, (PackageInfo) null);
            }
        }
    }

    public static synchronized q a(Context context) {
        q qVar;
        synchronized (q.class) {
            try {
                if (f38396b == null) {
                    f38396b = new q(context);
                }
                qVar = f38396b;
            } catch (Exception unused) {
                return null;
            }
        }
        return qVar;
    }

    public synchronized void b() {
        try {
            if (this.f38398c) {
                return;
            }
            this.f38398c = true;
            for (s sVar : this.f38401f.a()) {
                String str = null;
                try {
                    str = this.f38400e.getFilesDir().getCanonicalPath();
                } catch (Throwable unused) {
                }
                if (str != null) {
                    sVar.f38427m = str + "/." + sVar.f38415a;
                    StringBuilder sb = new StringBuilder();
                    sb.append(sVar.f38427m);
                    sb.append("/lib");
                    dn.c(sb.toString());
                    dn.c(sVar.f38427m);
                }
            }
            this.f38401f.b();
            if (!this.f38399d.b("wiipaot")) {
                this.f38399d.a("wiipaot", Boolean.TRUE, true);
            } else {
                this.f38401f.c();
            }
            n.a().a(new u(this.f38400e, 1, false));
        } catch (Throwable unused2) {
        }
    }

    public void a() {
        d();
        if (WeaponHI.isLoad) {
            b();
        } else {
            WeaponHI.iD();
        }
    }

    public synchronized boolean a(int i4, String str, PackageInfo packageInfo) {
        return a(i4, str, null, false, packageInfo);
    }

    private synchronized boolean a(int i4, String str, String str2, boolean z3, PackageInfo packageInfo) {
        if (z3) {
            if (this.f38401f.c(i4) != 1) {
                return false;
            }
        }
        s a4 = this.f38401f.a(i4);
        if (a4 == null) {
            this.f38401f.b(i4, -1);
            return false;
        } else if (!dn.a(new File(a4.f38419e))) {
            this.f38401f.b(i4, -1);
            return false;
        } else {
            if (packageInfo != null) {
                a4.f38432r = packageInfo;
            }
            r a5 = r.a(StubApp.getOrigApplicationContext(this.f38400e.getApplicationContext()), true);
            if (!a5.a(a4, false)) {
                this.f38401f.b(i4, -1);
                a5.a(a4.f38419e);
                return false;
            }
            s c4 = a5.c(a4.f38419e);
            c4.f38416b = 1;
            c4.f38430p = 1;
            this.f38401f.a(c4);
            return true;
        }
    }

    public void b(String str) {
        r a4;
        try {
            if (TextUtils.isEmpty(str) || (a4 = r.a()) == null) {
                return;
            }
            a4.b(str);
        } catch (Throwable unused) {
        }
    }

    public void a(String str, String str2) {
        this.f38401f.a(str);
        File file = new File(str2);
        if (file.exists()) {
            file.delete();
        }
    }

    public void a(final String str) {
        try {
            n.a().a(new Runnable() { // from class: com.kuaishou.weapon.p0.q.1
                @Override // java.lang.Runnable
                public void run() {
                    final r a4;
                    try {
                        if (TextUtils.isEmpty(str) || (a4 = r.a(StubApp.getOrigApplicationContext(q.this.f38400e.getApplicationContext()), true)) == null) {
                            return;
                        }
                        final s d4 = a4.d(str);
                        if (d4 == null) {
                            s b4 = q.this.f38401f.b(str);
                            if (b4 != null) {
                                q.this.a(str, b4.f38419e);
                                return;
                            }
                            return;
                        }
                        new Timer().schedule(new TimerTask() { // from class: com.kuaishou.weapon.p0.q.1.1
                            @Override // java.util.TimerTask, java.lang.Runnable
                            public void run() {
                                a4.b(str);
                                q.this.f38401f.a(str);
                                File file = new File(d4.f38419e);
                                if (file.exists()) {
                                    file.delete();
                                }
                            }
                        }, 600000L);
                        a4.b(str);
                        q.this.f38401f.a(str);
                        File file = new File(d4.f38419e);
                        if (file.exists()) {
                            file.delete();
                        }
                    } catch (Throwable unused) {
                    }
                }
            });
        } catch (Throwable unused) {
        }
    }

    public boolean a(s sVar, String str, String str2) {
        r a4;
        if (sVar == null) {
            return false;
        }
        File file = new File(sVar.f38419e);
        if (dn.a(file)) {
            try {
                if (!this.f38401f.b(sVar.f38415a)) {
                    this.f38401f.a(sVar);
                }
                a4 = r.a(StubApp.getOrigApplicationContext(this.f38400e.getApplicationContext()), true);
                this.f38401f.a(sVar.f38415a, 1);
                b(sVar.f38417c);
            } catch (Throwable unused) {
            }
            if (!a4.a(sVar, true)) {
                file.delete();
                a(sVar.f38415a, sVar.f38418d, null, true, null);
                this.f38401f.a(sVar.f38415a, 0);
                return false;
            }
            sVar = a4.c(sVar.f38419e);
            if (sVar == null) {
                this.f38401f.a(sVar.f38415a, 0);
                return false;
            }
            try {
                s a5 = this.f38401f.a(sVar.f38415a);
                File file2 = null;
                if (a5 != null && !a5.f38418d.equals(sVar.f38418d)) {
                    file2 = new File(a5.f38419e);
                }
                sVar.f38416b = 1;
                sVar.f38430p = 1;
                if (this.f38401f.a(sVar) > 0 && file2 != null && file2.exists()) {
                    file2.delete();
                }
                this.f38401f.a(sVar.f38415a, 0);
                return true;
            } catch (Throwable unused2) {
                return false;
            }
        }
        return false;
    }
}

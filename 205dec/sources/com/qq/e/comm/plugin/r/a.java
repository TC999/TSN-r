package com.qq.e.comm.plugin.r;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.util.Log;
import com.qq.e.comm.plugin.n0.e;
import com.qq.e.comm.plugin.o0.g.b;
import com.qq.e.comm.plugin.p.d;
import com.qq.e.comm.plugin.p.h;
import com.qq.e.comm.plugin.util.b1;
import com.qq.e.comm.plugin.util.e1;
import com.qq.e.comm.plugin.util.j2;
import com.qq.e.comm.plugin.util.o;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import yaq.pro;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public abstract class a<T> {

    /* renamed from: n  reason: collision with root package name */
    private static final boolean f45653n;

    /* renamed from: a  reason: collision with root package name */
    protected String f45654a;

    /* renamed from: b  reason: collision with root package name */
    protected String f45655b;

    /* renamed from: c  reason: collision with root package name */
    protected String f45656c;

    /* renamed from: d  reason: collision with root package name */
    protected String f45657d;

    /* renamed from: e  reason: collision with root package name */
    protected String f45658e;

    /* renamed from: f  reason: collision with root package name */
    protected int f45659f;

    /* renamed from: g  reason: collision with root package name */
    protected boolean f45660g;

    /* renamed from: h  reason: collision with root package name */
    protected File f45661h;

    /* renamed from: i  reason: collision with root package name */
    protected File f45662i;

    /* renamed from: j  reason: collision with root package name */
    protected File f45663j;

    /* renamed from: k  reason: collision with root package name */
    protected T f45664k;

    /* renamed from: l  reason: collision with root package name */
    private int f45665l;

    /* renamed from: m  reason: collision with root package name */
    private Class<T> f45666m;

    static {
        f45653n = com.qq.e.comm.plugin.d0.a.d().f().a("acod", 0) == 1;
    }

    private boolean e() {
        int i4 = this.f45665l;
        return i4 > 0 && i4 >= this.f45659f;
    }

    private Class h() throws Throwable {
        return (Class) pro.getobjresult(242, 0, this);
    }

    public void a(Context context, String str) {
        try {
            this.f45661h = context.getDir(b1.a(str), 0);
            if (d() && !a()) {
                this.f45662i = new File(this.f45661h, this.f45657d);
                File file = !o.c() ? new File(context.getDir(b1.a(str, context.getPackageName()), 0), this.f45657d) : null;
                if (this.f45662i.exists() && j2.a().a(this.f45656c, this.f45662i)) {
                    f();
                } else if (file != null && file.exists() && j2.a().a(this.f45656c, file)) {
                    this.f45662i = file;
                    f();
                } else {
                    b1.a(this.f45661h);
                    com.qq.e.comm.plugin.o0.g.a.a().a(new b.C0867b().d(this.f45655b).a(this.f45661h).a(this.f45657d).b(false).d(this.f45660g).a(), new b());
                }
            }
        } catch (Throwable th) {
            a(9800000, 199, th);
        }
    }

    protected abstract c c();

    protected abstract boolean d() throws Throwable;

    protected void f() throws Throwable {
        Integer num;
        Context a4;
        ApplicationInfo applicationInfo;
        if (Build.VERSION.SDK_INT >= 34 && (a4 = com.qq.e.comm.plugin.d0.a.d().a()) != null && (applicationInfo = a4.getApplicationInfo()) != null && applicationInfo.targetSdkVersion >= 34 && !this.f45662i.setReadOnly()) {
            b1.a(this.f45661h);
            a(9800000, 5, null);
            return;
        }
        a(9800000, 0, null);
        com.qq.e.comm.plugin.r.b.c(this.f45657d);
        try {
            Class<T> h4 = h();
            this.f45666m = h4;
            this.f45664k = h4.getConstructor(Object[].class).newInstance(b());
            e = null;
            num = null;
        } catch (ClassNotFoundException e4) {
            e = e4;
            num = 3;
        } catch (IllegalAccessError e5) {
            e = e5;
            num = 9;
        } catch (IllegalAccessException e6) {
            num = 5;
            e = e6;
        } catch (InstantiationException e7) {
            e = e7;
            num = 6;
        } catch (NoSuchMethodException e8) {
            e = e8;
            num = 7;
        } catch (UnsatisfiedLinkError e9) {
            e = e9;
            num = 8;
        } catch (InvocationTargetException e10) {
            e = e10;
            num = 4;
        } catch (Throwable th) {
            e = th;
            num = 100;
        }
        if (num == null) {
            a(9800002, 0, null);
            com.qq.e.comm.plugin.r.b.a(this.f45657d, 0);
            return;
        }
        b1.a(this.f45661h);
        String str = this.f45657d;
        int i4 = this.f45665l + 1;
        this.f45665l = i4;
        com.qq.e.comm.plugin.r.b.a(str, i4);
        a(9800002, num.intValue(), e);
        if (e()) {
            a(9800003, 0, e);
        }
    }

    protected abstract boolean g();

    /* JADX INFO: Access modifiers changed from: protected */
    public Object[] b() {
        return new Object[]{com.qq.e.comm.plugin.d0.a.d().a(), e1.i(), Integer.valueOf(com.qq.e.comm.plugin.d0.a.d().e().b()), Boolean.FALSE, com.qq.e.comm.plugin.d0.a.d().b().a(), this.f45661h.getAbsolutePath(), this.f45654a};
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    private class b extends h {
        private b() {
        }

        @Override // com.qq.e.comm.plugin.p.b
        public void a(File file, long j4) {
            try {
                if (!j2.a().a(a.this.f45656c, file)) {
                    b1.a(a.this.f45661h);
                    a.this.a(9800000, 2, null);
                } else if (a.this.g()) {
                    a.this.f();
                }
            } catch (Throwable th) {
                a.this.a(9800000, 198, th);
            }
        }

        @Override // com.qq.e.comm.plugin.p.h, com.qq.e.comm.plugin.p.b
        public void a(d dVar) {
            a.this.a(9800000, 4, dVar);
        }
    }

    private boolean a() {
        this.f45665l = com.qq.e.comm.plugin.r.b.b(this.f45657d);
        if (e()) {
            return true;
        }
        if (com.qq.e.comm.plugin.r.b.a(this.f45657d)) {
            a(9800002, 101, null);
            return true;
        }
        return false;
    }

    void a(int i4, int i5, Throwable th) {
        e eVar = new e(i4);
        eVar.c(c().f45671c);
        eVar.d(i5);
        com.qq.e.comm.plugin.n0.d dVar = new com.qq.e.comm.plugin.n0.d();
        String str = this.f45657d;
        if (str != null) {
            dVar.a("ver", str);
        }
        if (th != null) {
            dVar.a("ot", Log.getStackTraceString(th));
        }
        eVar.a(dVar);
    }
}

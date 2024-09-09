package cn.jpush.android.u;

import android.content.Context;
import android.graphics.Point;
import android.view.View;
import cn.jpush.android.ad.m;
import cn.jpush.android.helper.Logger;
import cn.jpush.android.r.a;
import cn.jpush.android.s.b;
import cn.jpush.android.s.c;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public abstract class b {

    /* renamed from: a  reason: collision with root package name */
    protected a f4381a;

    /* renamed from: b  reason: collision with root package name */
    protected cn.jpush.android.d.d f4382b;

    /* renamed from: c  reason: collision with root package name */
    protected cn.jpush.android.t.a f4383c;

    /* renamed from: d  reason: collision with root package name */
    protected Context f4384d;

    /* renamed from: e  reason: collision with root package name */
    protected int f4385e;

    /* renamed from: f  reason: collision with root package name */
    private cn.jpush.android.s.c f4386f;

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public interface a {
        void a(Context context, View view);

        void a(Context context, View view, Object obj);
    }

    public b(Context context, cn.jpush.android.t.a aVar, cn.jpush.android.d.d dVar, int i4) {
        this.f4383c = aVar;
        this.f4382b = dVar;
        this.f4384d = context;
        this.f4385e = i4;
    }

    public static b a(Context context, cn.jpush.android.t.a aVar, cn.jpush.android.d.d dVar, int i4) {
        if (i4 == 10 || i4 == 11) {
            return new cn.jpush.android.u.a(context, aVar, dVar, i4);
        }
        if (i4 == 20 || i4 == 21) {
            return new d(context, aVar, dVar, i4);
        }
        if (i4 == 30 || i4 == 31) {
            return new c(context, aVar, dVar, i4);
        }
        if (i4 != 40) {
            return null;
        }
        return new f(context, aVar, dVar, i4);
    }

    private void a(final View view) {
        Point point = new Point(0, -m.a(this.f4384d, 94));
        Point point2 = new Point(0, 0);
        long f4 = this.f4383c.f();
        Logger.d("BaseInAppWrapper", "slideIntoView startPoint: " + point + ", endPoint: " + point2 + ", toShowTime: " + f4);
        cn.jpush.android.r.a.a(view, point, point2, f4, new a.InterfaceC0072a() { // from class: cn.jpush.android.u.b.1
            @Override // cn.jpush.android.r.a.InterfaceC0072a
            public void a() {
                Logger.d("BaseInAppWrapper", "notify inapp show animation end");
                b bVar = b.this;
                a aVar = bVar.f4381a;
                if (aVar != null) {
                    aVar.a(bVar.f4384d, view);
                }
            }
        });
    }

    private void b(final View view) {
        if (this.f4386f == null) {
            this.f4386f = new cn.jpush.android.s.c();
        }
        long e4 = this.f4383c.e() + this.f4383c.f();
        Logger.d("BaseInAppWrapper", "configAutoDismiss autoTickTime: " + e4);
        this.f4386f.a(new c.a() { // from class: cn.jpush.android.u.b.2
            @Override // cn.jpush.android.s.c.a
            public void a() {
                try {
                    Logger.d("BaseInAppWrapper", "dismiss timer reach, dismiss notify inapp message");
                    cn.jpush.android.r.a.a(view, new Point(0, -m.a(b.this.f4384d, 94)), b.this.f4383c.g(), new a.InterfaceC0072a() { // from class: cn.jpush.android.u.b.2.1
                        @Override // cn.jpush.android.r.a.InterfaceC0072a
                        public void a() {
                            AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                            b bVar = b.this;
                            a aVar = bVar.f4381a;
                            if (aVar != null) {
                                aVar.a(bVar.f4384d, view, bVar.f4382b);
                            }
                        }
                    });
                } catch (Throwable th) {
                    Logger.w("BaseInAppWrapper", "in-app slide to dismiss error." + th.getMessage());
                }
            }
        }, e4, 1000L);
    }

    private void c(View view) {
        view.setOnTouchListener(new cn.jpush.android.s.b(this, null, this.f4382b.aG, new b.a() { // from class: cn.jpush.android.u.b.3
            @Override // cn.jpush.android.s.b.a
            public void a(View view2, Object obj) {
                b bVar = b.this;
                a aVar = bVar.f4381a;
                if (aVar != null) {
                    aVar.a(bVar.f4384d, view2, bVar.f4382b);
                }
            }

            @Override // cn.jpush.android.s.b.a
            public boolean a(Object obj) {
                return true;
            }
        }));
    }

    public static boolean c(int i4) {
        return 10 == i4 || 11 == i4;
    }

    public int a(int i4) {
        return m.b(this.f4384d, i4);
    }

    public void a(a aVar) {
        this.f4381a = aVar;
    }

    public int b(int i4) {
        return m.c(this.f4384d, i4);
    }

    public abstract void c();

    public abstract void d();

    public abstract View e();

    public abstract boolean f();

    public abstract void g();

    public void h() {
        try {
            View e4 = e();
            cn.jpush.android.t.a k4 = k();
            if (k4 != null && e4 != null) {
                a(e4);
                int i4 = this.f4385e;
                if (10 == i4 || 11 == i4 || 40 == i4) {
                    c(e4);
                    b(e4);
                    return;
                }
                return;
            }
            Logger.w("BaseInAppWrapper", "startViewAnimation param is null, view:" + e4 + "config:" + k4);
        } catch (Throwable th) {
            Logger.w("BaseInAppWrapper", "start in-app with animation error. " + th.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void i() {
        cn.jpush.android.s.c cVar = this.f4386f;
        if (cVar != null) {
            cVar.a();
        }
    }

    public cn.jpush.android.d.d j() {
        return this.f4382b;
    }

    public cn.jpush.android.t.a k() {
        return this.f4383c;
    }
}

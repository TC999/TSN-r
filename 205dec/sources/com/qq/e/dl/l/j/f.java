package com.qq.e.dl.l.j;

import android.graphics.PointF;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import com.qq.e.comm.plugin.util.d1;
import com.qq.e.dl.l.h;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class f implements View.OnTouchListener, View.OnClickListener, com.qq.e.dl.l.d {

    /* renamed from: c  reason: collision with root package name */
    private final com.qq.e.dl.l.h f47158c;

    /* renamed from: d  reason: collision with root package name */
    private final h.d f47159d;

    /* renamed from: e  reason: collision with root package name */
    private c f47160e;

    /* renamed from: f  reason: collision with root package name */
    private PointF f47161f;

    /* renamed from: g  reason: collision with root package name */
    private PointF f47162g;

    /* renamed from: h  reason: collision with root package name */
    private MotionEvent f47163h;

    /* renamed from: i  reason: collision with root package name */
    private View f47164i;

    /* renamed from: j  reason: collision with root package name */
    private List<Runnable> f47165j;

    /* renamed from: k  reason: collision with root package name */
    private int f47166k = 0;

    /* renamed from: l  reason: collision with root package name */
    private List<g> f47167l;

    /* renamed from: m  reason: collision with root package name */
    private List<g> f47168m;

    /* renamed from: n  reason: collision with root package name */
    private List<g> f47169n;

    /* renamed from: o  reason: collision with root package name */
    private com.qq.e.dl.l.h f47170o;

    /* renamed from: p  reason: collision with root package name */
    private boolean f47171p;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public final class b implements Runnable {

        /* renamed from: c  reason: collision with root package name */
        g f47172c;

        @Override // java.lang.Runnable
        public void run() {
            if (f.this.c()) {
                return;
            }
            f fVar = f.this;
            fVar.a(this.f47172c.c(fVar.f47164i, f.this.f47163h, f.this.f47161f, f.this.f47162g), this.f47172c);
        }

        private b(g gVar) {
            this.f47172c = gVar;
        }
    }

    public f(com.qq.e.dl.l.h hVar, h.d dVar) {
        this.f47158c = hVar;
        this.f47159d = dVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        a(this.f47160e);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        boolean z3 = false;
        if (action == 0) {
            if (view != null && (view.getScaleX() == 0.0f || view.getScaleY() == 0.0f)) {
                return false;
            }
            PointF a4 = a(motionEvent);
            this.f47161f = a4;
            this.f47162g = a4;
            this.f47170o = null;
            if (b()) {
                a(view, true);
            }
        }
        if (this.f47167l == null) {
            return false;
        }
        this.f47163h = motionEvent;
        this.f47164i = view;
        if (action == 0) {
            b(view, motionEvent);
            e();
        } else if (action == 1) {
            d();
            d(view, motionEvent);
        } else if (action != 2) {
            if (action != 3) {
                return false;
            }
            d();
            a(view, motionEvent);
        } else if (this.f47168m != null) {
            c(view, motionEvent);
        }
        if (c() || (this.f47166k == 1 && !view.isClickable())) {
            z3 = true;
        }
        a(action);
        return z3;
    }

    private boolean b() {
        return this.f47158c.a().a() == 2 || this.f47158c.a().a() == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c() {
        return this.f47166k == 3;
    }

    private void d(View view, MotionEvent motionEvent) {
        this.f47171p = true;
        this.f47162g = a(motionEvent);
        for (g gVar : this.f47167l) {
            if (!c()) {
                a(gVar.a(view, motionEvent, this.f47161f, this.f47162g), gVar);
            }
            c e4 = gVar.e();
            if (e4 != null && e4.f47127h) {
                this.f47159d.c(this.f47158c, e4);
            }
            gVar.b();
        }
    }

    private void e() {
        List<g> list = this.f47169n;
        if (list == null || list.isEmpty()) {
            return;
        }
        for (g gVar : this.f47169n) {
            if (this.f47165j == null) {
                this.f47165j = new ArrayList(this.f47169n.size());
            }
            b bVar = new b(gVar);
            this.f47165j.add(bVar);
            d1.a("postDelayed MinDurationCheck, getMinDuration = %d", Integer.valueOf(gVar.f()));
            com.qq.e.dl.j.d.a().postDelayed(bVar, gVar.f());
        }
    }

    private void b(View view, MotionEvent motionEvent) {
        for (g gVar : this.f47167l) {
            if (!c()) {
                a(gVar.a(view, motionEvent, this.f47161f), gVar);
            }
            c e4 = gVar.e();
            if (e4 != null && e4.f47127h) {
                this.f47159d.a(this.f47158c, e4);
            }
        }
    }

    private void c(View view, MotionEvent motionEvent) {
        this.f47162g = a(motionEvent);
        for (g gVar : this.f47168m) {
            if (!c()) {
                a(gVar.b(view, motionEvent, this.f47161f, this.f47162g), gVar);
            }
        }
    }

    public void a(List<c> list) {
        View m4 = this.f47158c.m();
        if (m4 == null) {
            return;
        }
        int size = list.size();
        this.f47167l = new ArrayList(size);
        this.f47168m = new ArrayList(size);
        this.f47169n = new ArrayList(size);
        Iterator<c> it = list.iterator();
        while (true) {
            g gVar = null;
            if (it.hasNext()) {
                c next = it.next();
                switch (next.f47120a) {
                    case 1:
                        if (com.qq.e.dl.l.j.b.a(next.f47122c)) {
                            gVar = new com.qq.e.dl.l.j.b(next, false, this.f47158c.a().f());
                            break;
                        } else {
                            this.f47160e = next;
                            m4.setOnClickListener(this);
                            m4.setFocusable(false);
                            break;
                        }
                    case 3:
                        gVar = new i(next);
                        break;
                    case 4:
                        gVar = new com.qq.e.dl.l.j.b(next, a(), this.f47158c.a().f());
                        break;
                    case 5:
                        com.qq.e.dl.c e4 = this.f47158c.a().e();
                        if (e4 != null) {
                            next.a(this.f47158c.f());
                            e4.a(this.f47158c, next, this);
                            e4.start();
                            break;
                        }
                        break;
                    case 6:
                        gVar = new h(next);
                        break;
                    case 7:
                        gVar = new e(next);
                        break;
                    case 8:
                        com.qq.e.dl.e g4 = this.f47158c.a().g();
                        if (g4 != null) {
                            next.a(this.f47158c.f());
                            g4.a(this.f47158c, next, this);
                            g4.start();
                            break;
                        }
                        break;
                }
                if (gVar != null) {
                    this.f47167l.add(gVar);
                    if (gVar.a()) {
                        this.f47168m.add(gVar);
                    }
                    if (gVar.d()) {
                        this.f47169n.add(gVar);
                    }
                    this.f47158c.a(gVar.c());
                }
            } else {
                if (this.f47168m.size() <= 0) {
                    this.f47168m = null;
                }
                if (this.f47169n.size() <= 0) {
                    this.f47169n = null;
                }
                if (this.f47167l.size() <= 0) {
                    this.f47167l = null;
                }
                if (this.f47167l == null && this.f47160e == null) {
                    return;
                }
                m4.setOnTouchListener(this);
                return;
            }
        }
    }

    @Override // com.qq.e.dl.l.d
    public void c(com.qq.e.dl.l.h hVar, c cVar) {
        this.f47159d.c(hVar, cVar);
    }

    @Override // com.qq.e.dl.l.d
    public boolean b(com.qq.e.dl.l.h hVar, c cVar) {
        return this.f47159d.b(hVar, cVar);
    }

    private boolean b(com.qq.e.dl.l.h hVar, PointF pointF) {
        Rect r3;
        if (hVar == null || (r3 = hVar.r()) == null) {
            return false;
        }
        return r3.contains((int) pointF.x, (int) pointF.y);
    }

    private void d() {
        List<Runnable> list = this.f47165j;
        if (list == null || list.isEmpty()) {
            return;
        }
        for (Runnable runnable : this.f47165j) {
            com.qq.e.dl.j.d.a().removeCallbacks(runnable);
        }
    }

    public static void a(View view, boolean z3) {
        ViewParent parent;
        if (view == null || (parent = view.getParent()) == null) {
            return;
        }
        parent.requestDisallowInterceptTouchEvent(z3);
    }

    private boolean a() {
        return this.f47158c.a().a() == 2;
    }

    private PointF a(MotionEvent motionEvent) {
        return new PointF(motionEvent.getRawX(), motionEvent.getRawY());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Boolean bool, g gVar) {
        if (bool == null) {
            this.f47166k = 1;
        } else if (a(gVar.e())) {
            if (bool.booleanValue()) {
                this.f47166k = 3;
            } else {
                this.f47166k = 1;
            }
        } else if (bool.booleanValue()) {
            this.f47166k = 1;
        } else if (this.f47166k == 0) {
            this.f47166k = 2;
        }
    }

    private void a(View view, MotionEvent motionEvent) {
        if (this.f47171p) {
            return;
        }
        this.f47162g = a(motionEvent);
        for (g gVar : this.f47167l) {
            gVar.a(view, motionEvent, this.f47161f, this.f47162g);
            c e4 = gVar.e();
            if (e4 != null && e4.f47127h) {
                this.f47159d.c(this.f47158c, gVar.e());
            }
            gVar.b();
        }
    }

    private void a(int i4) {
        if (i4 == 1 || i4 == 3) {
            this.f47166k = 0;
            this.f47171p = false;
        }
    }

    @Override // com.qq.e.dl.l.d
    public void a(com.qq.e.dl.l.h hVar, c cVar) {
        this.f47159d.a(hVar, cVar);
    }

    @Override // com.qq.e.dl.l.d
    public void a(com.qq.e.dl.l.h hVar, c cVar, float f4) {
        this.f47159d.a(hVar, cVar, f4);
    }

    private boolean a(c cVar) {
        if (this.f47170o == null) {
            this.f47170o = a(this.f47158c, this.f47161f);
        }
        com.qq.e.dl.l.h hVar = this.f47170o;
        if (hVar != null) {
            cVar.a(hVar.f());
        } else {
            cVar.a(0);
        }
        return this.f47159d.b(this.f47158c, cVar);
    }

    private com.qq.e.dl.l.h a(com.qq.e.dl.l.h hVar, PointF pointF) {
        if (pointF == null) {
            return null;
        }
        if (hVar instanceof com.qq.e.dl.l.k.d) {
            com.qq.e.dl.l.k.d dVar = (com.qq.e.dl.l.k.d) hVar;
            for (int w3 = dVar.w() - 1; w3 >= 0; w3--) {
                com.qq.e.dl.l.h i4 = dVar.i(w3);
                if (((i4 instanceof com.qq.e.dl.l.k.d) || i4.f() != 0) && b(i4, pointF)) {
                    com.qq.e.dl.l.h a4 = a(i4, pointF);
                    if (a4.f() != 0) {
                        return a4;
                    }
                }
            }
            return hVar;
        }
        return hVar;
    }
}

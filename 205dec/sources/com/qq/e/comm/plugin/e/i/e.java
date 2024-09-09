package com.qq.e.comm.plugin.e.i;

import android.content.Context;
import android.text.TextUtils;
import android.view.MotionEvent;
import com.qq.e.comm.plugin.d0.d.h;
import com.qq.e.comm.plugin.n0.v;
import com.qq.e.comm.plugin.util.f1;
import com.qq.e.comm.plugin.util.x1;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class e implements d {

    /* renamed from: c  reason: collision with root package name */
    private static Boolean f42746c;

    /* renamed from: d  reason: collision with root package name */
    private static Boolean f42747d;

    /* renamed from: e  reason: collision with root package name */
    private static Boolean f42748e;

    /* renamed from: f  reason: collision with root package name */
    private static Boolean f42749f;

    /* renamed from: g  reason: collision with root package name */
    private static String f42750g;

    /* renamed from: a  reason: collision with root package name */
    private final d f42751a;

    /* renamed from: b  reason: collision with root package name */
    private final Context f42752b;

    public e(Context context, d dVar) {
        this.f42752b = context.getApplicationContext();
        this.f42751a = dVar;
    }

    public void a(MotionEvent motionEvent, boolean z3, com.qq.e.comm.plugin.e.c cVar, int i4, int i5) {
        int x3;
        int y3;
        if (motionEvent == null || cVar == null || this.f42752b == null) {
            return;
        }
        int action = motionEvent.getAction();
        if (action == 0 || action == 1) {
            h f4 = com.qq.e.comm.plugin.d0.a.d().f();
            if (f42746c == null) {
                f42746c = Boolean.valueOf(f4.a("otCheck", 0) == 1);
            }
            if (f42746c.booleanValue() && com.qq.e.comm.plugin.l0.f.p()) {
                JSONObject j4 = com.qq.e.comm.plugin.l0.f.j();
                int optInt = j4.optInt("data", -1);
                float a4 = x1.a(j4.optString("offsetx"), 0.0f);
                float a5 = x1.a(j4.optString("offsety"), 0.0f);
                if (optInt >= 0) {
                    if (z3) {
                        x3 = (int) (motionEvent.getRawX() - a4);
                        y3 = (int) (motionEvent.getRawY() - a5);
                    } else {
                        x3 = ((int) (motionEvent.getX() - a4)) + i4;
                        y3 = ((int) (motionEvent.getY() - a5)) + i5;
                    }
                    if (action == 0) {
                        cVar.f42704x0 = String.valueOf(optInt);
                        cVar.f42706y0 = String.valueOf(f1.b(this.f42752b, x3));
                        cVar.f42708z0 = String.valueOf(f1.b(this.f42752b, y3));
                        if (optInt > 0) {
                            cVar.A0 = j4.optString("caller");
                            v.a(9300003, null, Integer.valueOf(action), new com.qq.e.comm.plugin.n0.d(j4));
                        }
                    } else if (action == 1) {
                        cVar.B0 = String.valueOf(optInt);
                        cVar.C0 = String.valueOf(f1.b(this.f42752b, x3));
                        cVar.D0 = String.valueOf(f1.b(this.f42752b, y3));
                        if (optInt > 0) {
                            cVar.E0 = j4.optString("caller");
                            v.a(9300003, null, Integer.valueOf(action), new com.qq.e.comm.plugin.n0.d(j4));
                        }
                    }
                } else if (action == 0) {
                    cVar.f42704x0 = String.valueOf(optInt);
                    cVar.f42706y0 = String.valueOf(-999);
                    cVar.f42708z0 = String.valueOf(-999);
                } else if (action == 1) {
                    cVar.B0 = String.valueOf(optInt);
                    cVar.C0 = String.valueOf(-999);
                    cVar.D0 = String.valueOf(-999);
                }
            }
            if (f42747d == null) {
                f42747d = Boolean.valueOf(f4.a("fcCheck", 0) == 1);
            }
            if (f42747d.booleanValue()) {
                JSONObject h4 = com.qq.e.comm.plugin.l0.f.h();
                int optInt2 = h4.optInt("data", -1);
                cVar.F0 = String.valueOf(optInt2);
                if (optInt2 > 0) {
                    cVar.G0 = h4.optString("caller");
                    v.a(9300002, null, 0, new com.qq.e.comm.plugin.n0.d(h4));
                }
            }
        }
    }

    @Override // com.qq.e.comm.plugin.e.i.d
    public com.qq.e.comm.plugin.e.c a() {
        com.qq.e.comm.plugin.e.c a4 = this.f42751a.a();
        a4.f42690q0 = String.valueOf(com.qq.e.comm.plugin.l0.f.l());
        if (f42748e == null || f42749f == null) {
            int a5 = com.qq.e.comm.plugin.d0.a.d().f().a("asicc", 1);
            f42748e = Boolean.valueOf(a5 > 0);
            f42749f = Boolean.valueOf(a5 == 1);
        }
        if (f42748e.booleanValue()) {
            if (f42749f.booleanValue()) {
                if (TextUtils.isEmpty(f42750g)) {
                    f42750g = String.valueOf(com.qq.e.comm.plugin.l0.f.i());
                }
                a4.f42692r0 = f42750g;
            } else {
                a4.f42692r0 = String.valueOf(com.qq.e.comm.plugin.l0.f.i());
            }
        }
        a4.f42694s0 = String.valueOf(com.qq.e.comm.plugin.l0.f.k());
        a4.f42696t0 = String.valueOf(com.qq.e.comm.plugin.l0.f.e().second);
        a4.f42698u0 = String.valueOf(com.qq.e.comm.plugin.l0.f.g());
        a4.f42700v0 = String.valueOf(com.qq.e.comm.plugin.l0.f.f());
        a4.f42702w0 = "2";
        a4.K = com.qq.e.comm.plugin.l0.f.b();
        a4.f42656L = com.qq.e.comm.plugin.l0.f.c();
        a4.M = String.valueOf(com.qq.e.comm.plugin.l0.f.d());
        return a4;
    }
}

package com.facebook.rebound;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class Spring {

    /* renamed from: o  reason: collision with root package name */
    private static int f37045o = 0;

    /* renamed from: p  reason: collision with root package name */
    private static final double f37046p = 0.064d;

    /* renamed from: q  reason: collision with root package name */
    private static final double f37047q = 0.001d;

    /* renamed from: a  reason: collision with root package name */
    private SpringConfig f37048a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f37049b;

    /* renamed from: c  reason: collision with root package name */
    private final String f37050c;

    /* renamed from: g  reason: collision with root package name */
    private double f37054g;

    /* renamed from: h  reason: collision with root package name */
    private double f37055h;

    /* renamed from: n  reason: collision with root package name */
    private final BaseSpringSystem f37061n;

    /* renamed from: d  reason: collision with root package name */
    private final PhysicsState f37051d = new PhysicsState();

    /* renamed from: e  reason: collision with root package name */
    private final PhysicsState f37052e = new PhysicsState();

    /* renamed from: f  reason: collision with root package name */
    private final PhysicsState f37053f = new PhysicsState();

    /* renamed from: i  reason: collision with root package name */
    private boolean f37056i = true;

    /* renamed from: j  reason: collision with root package name */
    private double f37057j = 0.005d;

    /* renamed from: k  reason: collision with root package name */
    private double f37058k = 0.005d;

    /* renamed from: l  reason: collision with root package name */
    private CopyOnWriteArraySet<SpringListener> f37059l = new CopyOnWriteArraySet<>();

    /* renamed from: m  reason: collision with root package name */
    private double f37060m = 0.0d;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* loaded from: E:\TSN-r\205dec\6241084.dex */
    public static class PhysicsState {

        /* renamed from: a  reason: collision with root package name */
        double f37062a;

        /* renamed from: b  reason: collision with root package name */
        double f37063b;

        private PhysicsState() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Spring(BaseSpringSystem baseSpringSystem) {
        if (baseSpringSystem != null) {
            this.f37061n = baseSpringSystem;
            StringBuilder sb = new StringBuilder();
            sb.append("spring:");
            int i4 = f37045o;
            f37045o = i4 + 1;
            sb.append(i4);
            this.f37050c = sb.toString();
            B(SpringConfig.f37076c);
            return;
        }
        throw new IllegalArgumentException("Spring cannot be created outside of a BaseSpringSystem");
    }

    private double g(PhysicsState physicsState) {
        return Math.abs(this.f37055h - physicsState.f37062a);
    }

    private void o(double d4) {
        PhysicsState physicsState = this.f37051d;
        PhysicsState physicsState2 = this.f37052e;
        double d5 = 1.0d - d4;
        physicsState.f37062a = (physicsState.f37062a * d4) + (physicsState2.f37062a * d5);
        physicsState.f37063b = (physicsState.f37063b * d4) + (physicsState2.f37063b * d5);
    }

    public Spring A(double d4) {
        this.f37057j = d4;
        return this;
    }

    public Spring B(SpringConfig springConfig) {
        if (springConfig != null) {
            this.f37048a = springConfig;
            return this;
        }
        throw new IllegalArgumentException("springConfig is required");
    }

    public Spring C(double d4) {
        PhysicsState physicsState = this.f37051d;
        if (d4 == physicsState.f37063b) {
            return this;
        }
        physicsState.f37063b = d4;
        this.f37061n.a(i());
        return this;
    }

    public boolean D() {
        return (p() && E()) ? false : true;
    }

    public boolean E() {
        return this.f37056i;
    }

    public Spring a(SpringListener springListener) {
        if (springListener != null) {
            this.f37059l.add(springListener);
            return this;
        }
        throw new IllegalArgumentException("newListener is required");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(double d4) {
        double d5;
        boolean z3;
        boolean z4;
        boolean p3 = p();
        if (p3 && this.f37056i) {
            return;
        }
        this.f37060m += d4 <= 0.064d ? d4 : 0.064d;
        SpringConfig springConfig = this.f37048a;
        double d6 = springConfig.f37078b;
        double d7 = springConfig.f37077a;
        PhysicsState physicsState = this.f37051d;
        double d8 = physicsState.f37062a;
        double d9 = physicsState.f37063b;
        PhysicsState physicsState2 = this.f37053f;
        double d10 = physicsState2.f37062a;
        double d11 = physicsState2.f37063b;
        while (true) {
            d5 = this.f37060m;
            if (d5 < 0.001d) {
                break;
            }
            double d12 = d5 - 0.001d;
            this.f37060m = d12;
            if (d12 < 0.001d) {
                PhysicsState physicsState3 = this.f37052e;
                physicsState3.f37062a = d8;
                physicsState3.f37063b = d9;
            }
            double d13 = this.f37055h;
            double d14 = ((d13 - d10) * d6) - (d7 * d9);
            double d15 = d9 + (d14 * 0.001d * 0.5d);
            double d16 = ((d13 - (((d9 * 0.001d) * 0.5d) + d8)) * d6) - (d7 * d15);
            double d17 = d9 + (d16 * 0.001d * 0.5d);
            double d18 = ((d13 - (d8 + ((d15 * 0.001d) * 0.5d))) * d6) - (d7 * d17);
            double d19 = d8 + (d17 * 0.001d);
            double d20 = d9 + (d18 * 0.001d);
            d8 += (d9 + ((d15 + d17) * 2.0d) + d20) * 0.16666666666666666d * 0.001d;
            d9 += (d14 + ((d16 + d18) * 2.0d) + (((d13 - d19) * d6) - (d7 * d20))) * 0.16666666666666666d * 0.001d;
            d10 = d19;
            d11 = d20;
        }
        PhysicsState physicsState4 = this.f37053f;
        physicsState4.f37062a = d10;
        physicsState4.f37063b = d11;
        PhysicsState physicsState5 = this.f37051d;
        physicsState5.f37062a = d8;
        physicsState5.f37063b = d9;
        if (d5 > 0.0d) {
            o(d5 / 0.001d);
        }
        boolean z5 = true;
        if (p() || (this.f37049b && r())) {
            if (d6 > 0.0d) {
                double d21 = this.f37055h;
                this.f37054g = d21;
                this.f37051d.f37062a = d21;
            } else {
                double d22 = this.f37051d.f37062a;
                this.f37055h = d22;
                this.f37054g = d22;
            }
            C(0.0d);
            z3 = true;
        } else {
            z3 = p3;
        }
        if (this.f37056i) {
            this.f37056i = false;
            z4 = true;
        } else {
            z4 = false;
        }
        if (z3) {
            this.f37056i = true;
        } else {
            z5 = false;
        }
        Iterator<SpringListener> it = this.f37059l.iterator();
        while (it.hasNext()) {
            SpringListener next = it.next();
            if (z4) {
                next.onSpringActivate(this);
            }
            next.onSpringUpdate(this);
            if (z5) {
                next.onSpringAtRest(this);
            }
        }
    }

    public boolean c(double d4) {
        return Math.abs(f() - d4) <= j();
    }

    public void d() {
        this.f37059l.clear();
        this.f37061n.e(this);
    }

    public double e() {
        return g(this.f37051d);
    }

    public double f() {
        return this.f37051d.f37062a;
    }

    public double h() {
        return this.f37055h;
    }

    public String i() {
        return this.f37050c;
    }

    public double j() {
        return this.f37058k;
    }

    public double k() {
        return this.f37057j;
    }

    public SpringConfig l() {
        return this.f37048a;
    }

    public double m() {
        return this.f37054g;
    }

    public double n() {
        return this.f37051d.f37063b;
    }

    public boolean p() {
        return Math.abs(this.f37051d.f37063b) <= this.f37057j && (g(this.f37051d) <= this.f37058k || this.f37048a.f37078b == 0.0d);
    }

    public boolean q() {
        return this.f37049b;
    }

    public boolean r() {
        return this.f37048a.f37078b > 0.0d && ((this.f37054g < this.f37055h && f() > this.f37055h) || (this.f37054g > this.f37055h && f() < this.f37055h));
    }

    public Spring s() {
        this.f37059l.clear();
        return this;
    }

    public Spring t(SpringListener springListener) {
        if (springListener != null) {
            this.f37059l.remove(springListener);
            return this;
        }
        throw new IllegalArgumentException("listenerToRemove is required");
    }

    public Spring u() {
        PhysicsState physicsState = this.f37051d;
        double d4 = physicsState.f37062a;
        this.f37055h = d4;
        this.f37053f.f37062a = d4;
        physicsState.f37063b = 0.0d;
        return this;
    }

    public Spring v(double d4) {
        return w(d4, true);
    }

    public Spring w(double d4, boolean z3) {
        this.f37054g = d4;
        this.f37051d.f37062a = d4;
        this.f37061n.a(i());
        Iterator<SpringListener> it = this.f37059l.iterator();
        while (it.hasNext()) {
            it.next().onSpringUpdate(this);
        }
        if (z3) {
            u();
        }
        return this;
    }

    public Spring x(double d4) {
        if (this.f37055h == d4 && p()) {
            return this;
        }
        this.f37054g = f();
        this.f37055h = d4;
        this.f37061n.a(i());
        Iterator<SpringListener> it = this.f37059l.iterator();
        while (it.hasNext()) {
            it.next().onSpringEndStateChange(this);
        }
        return this;
    }

    public Spring y(boolean z3) {
        this.f37049b = z3;
        return this;
    }

    public Spring z(double d4) {
        this.f37058k = d4;
        return this;
    }
}

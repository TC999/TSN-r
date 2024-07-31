package com.facebook.rebound;

import com.github.mikephil.charting.utils.Utils;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class Spring {

    /* renamed from: o */
    private static int f23449o = 0;

    /* renamed from: p */
    private static final double f23450p = 0.064d;

    /* renamed from: q */
    private static final double f23451q = 0.001d;

    /* renamed from: a */
    private SpringConfig f23452a;

    /* renamed from: b */
    private boolean f23453b;

    /* renamed from: c */
    private final String f23454c;

    /* renamed from: g */
    private double f23458g;

    /* renamed from: h */
    private double f23459h;

    /* renamed from: n */
    private final BaseSpringSystem f23465n;

    /* renamed from: d */
    private final PhysicsState f23455d = new PhysicsState();

    /* renamed from: e */
    private final PhysicsState f23456e = new PhysicsState();

    /* renamed from: f */
    private final PhysicsState f23457f = new PhysicsState();

    /* renamed from: i */
    private boolean f23460i = true;

    /* renamed from: j */
    private double f23461j = 0.005d;

    /* renamed from: k */
    private double f23462k = 0.005d;

    /* renamed from: l */
    private CopyOnWriteArraySet<SpringListener> f23463l = new CopyOnWriteArraySet<>();

    /* renamed from: m */
    private double f23464m = Utils.DOUBLE_EPSILON;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static class PhysicsState {

        /* renamed from: a */
        double f23466a;

        /* renamed from: b */
        double f23467b;

        private PhysicsState() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Spring(BaseSpringSystem baseSpringSystem) {
        if (baseSpringSystem != null) {
            this.f23465n = baseSpringSystem;
            StringBuilder sb = new StringBuilder();
            sb.append("spring:");
            int i = f23449o;
            f23449o = i + 1;
            sb.append(i);
            this.f23454c = sb.toString();
            m35601B(SpringConfig.f23480c);
            return;
        }
        throw new IllegalArgumentException("Spring cannot be created outside of a BaseSpringSystem");
    }

    /* renamed from: g */
    private double m35591g(PhysicsState physicsState) {
        return Math.abs(this.f23459h - physicsState.f23466a);
    }

    /* renamed from: o */
    private void m35583o(double d) {
        PhysicsState physicsState = this.f23455d;
        PhysicsState physicsState2 = this.f23456e;
        double d2 = 1.0d - d;
        physicsState.f23466a = (physicsState.f23466a * d) + (physicsState2.f23466a * d2);
        physicsState.f23467b = (physicsState.f23467b * d) + (physicsState2.f23467b * d2);
    }

    /* renamed from: A */
    public Spring m35602A(double d) {
        this.f23461j = d;
        return this;
    }

    /* renamed from: B */
    public Spring m35601B(SpringConfig springConfig) {
        if (springConfig != null) {
            this.f23452a = springConfig;
            return this;
        }
        throw new IllegalArgumentException("springConfig is required");
    }

    /* renamed from: C */
    public Spring m35600C(double d) {
        PhysicsState physicsState = this.f23455d;
        if (d == physicsState.f23467b) {
            return this;
        }
        physicsState.f23467b = d;
        this.f23465n.m35641a(m35589i());
        return this;
    }

    /* renamed from: D */
    public boolean m35599D() {
        return (m35582p() && m35598E()) ? false : true;
    }

    /* renamed from: E */
    public boolean m35598E() {
        return this.f23460i;
    }

    /* renamed from: a */
    public Spring m35597a(SpringListener springListener) {
        if (springListener != null) {
            this.f23463l.add(springListener);
            return this;
        }
        throw new IllegalArgumentException("newListener is required");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public void m35596b(double d) {
        double d2;
        boolean z;
        boolean z2;
        boolean m35582p = m35582p();
        if (m35582p && this.f23460i) {
            return;
        }
        double d3 = f23450p;
        if (d <= f23450p) {
            d3 = d;
        }
        this.f23464m += d3;
        SpringConfig springConfig = this.f23452a;
        double d4 = springConfig.f23482b;
        double d5 = springConfig.f23481a;
        PhysicsState physicsState = this.f23455d;
        double d6 = physicsState.f23466a;
        double d7 = physicsState.f23467b;
        PhysicsState physicsState2 = this.f23457f;
        double d8 = physicsState2.f23466a;
        double d9 = physicsState2.f23467b;
        while (true) {
            d2 = this.f23464m;
            if (d2 < f23451q) {
                break;
            }
            double d10 = d2 - f23451q;
            this.f23464m = d10;
            if (d10 < f23451q) {
                PhysicsState physicsState3 = this.f23456e;
                physicsState3.f23466a = d6;
                physicsState3.f23467b = d7;
            }
            double d11 = this.f23459h;
            double d12 = ((d11 - d8) * d4) - (d5 * d7);
            double d13 = d7 + (d12 * f23451q * 0.5d);
            double d14 = ((d11 - (((d7 * f23451q) * 0.5d) + d6)) * d4) - (d5 * d13);
            double d15 = d7 + (d14 * f23451q * 0.5d);
            double d16 = ((d11 - (d6 + ((d13 * f23451q) * 0.5d))) * d4) - (d5 * d15);
            double d17 = d6 + (d15 * f23451q);
            double d18 = d7 + (d16 * f23451q);
            d6 += (d7 + ((d13 + d15) * 2.0d) + d18) * 0.16666666666666666d * f23451q;
            d7 += (d12 + ((d14 + d16) * 2.0d) + (((d11 - d17) * d4) - (d5 * d18))) * 0.16666666666666666d * f23451q;
            d8 = d17;
            d9 = d18;
        }
        PhysicsState physicsState4 = this.f23457f;
        physicsState4.f23466a = d8;
        physicsState4.f23467b = d9;
        PhysicsState physicsState5 = this.f23455d;
        physicsState5.f23466a = d6;
        physicsState5.f23467b = d7;
        if (d2 > Utils.DOUBLE_EPSILON) {
            m35583o(d2 / f23451q);
        }
        boolean z3 = true;
        if (m35582p() || (this.f23453b && m35580r())) {
            if (d4 > Utils.DOUBLE_EPSILON) {
                double d19 = this.f23459h;
                this.f23458g = d19;
                this.f23455d.f23466a = d19;
            } else {
                double d20 = this.f23455d.f23466a;
                this.f23459h = d20;
                this.f23458g = d20;
            }
            m35600C(Utils.DOUBLE_EPSILON);
            z = true;
        } else {
            z = m35582p;
        }
        if (this.f23460i) {
            this.f23460i = false;
            z2 = true;
        } else {
            z2 = false;
        }
        if (z) {
            this.f23460i = true;
        } else {
            z3 = false;
        }
        Iterator<SpringListener> it = this.f23463l.iterator();
        while (it.hasNext()) {
            SpringListener next = it.next();
            if (z2) {
                next.onSpringActivate(this);
            }
            next.onSpringUpdate(this);
            if (z3) {
                next.onSpringAtRest(this);
            }
        }
    }

    /* renamed from: c */
    public boolean m35595c(double d) {
        return Math.abs(m35592f() - d) <= m35588j();
    }

    /* renamed from: d */
    public void m35594d() {
        this.f23463l.clear();
        this.f23465n.m35637e(this);
    }

    /* renamed from: e */
    public double m35593e() {
        return m35591g(this.f23455d);
    }

    /* renamed from: f */
    public double m35592f() {
        return this.f23455d.f23466a;
    }

    /* renamed from: h */
    public double m35590h() {
        return this.f23459h;
    }

    /* renamed from: i */
    public String m35589i() {
        return this.f23454c;
    }

    /* renamed from: j */
    public double m35588j() {
        return this.f23462k;
    }

    /* renamed from: k */
    public double m35587k() {
        return this.f23461j;
    }

    /* renamed from: l */
    public SpringConfig m35586l() {
        return this.f23452a;
    }

    /* renamed from: m */
    public double m35585m() {
        return this.f23458g;
    }

    /* renamed from: n */
    public double m35584n() {
        return this.f23455d.f23467b;
    }

    /* renamed from: p */
    public boolean m35582p() {
        return Math.abs(this.f23455d.f23467b) <= this.f23461j && (m35591g(this.f23455d) <= this.f23462k || this.f23452a.f23482b == Utils.DOUBLE_EPSILON);
    }

    /* renamed from: q */
    public boolean m35581q() {
        return this.f23453b;
    }

    /* renamed from: r */
    public boolean m35580r() {
        return this.f23452a.f23482b > Utils.DOUBLE_EPSILON && ((this.f23458g < this.f23459h && m35592f() > this.f23459h) || (this.f23458g > this.f23459h && m35592f() < this.f23459h));
    }

    /* renamed from: s */
    public Spring m35579s() {
        this.f23463l.clear();
        return this;
    }

    /* renamed from: t */
    public Spring m35578t(SpringListener springListener) {
        if (springListener != null) {
            this.f23463l.remove(springListener);
            return this;
        }
        throw new IllegalArgumentException("listenerToRemove is required");
    }

    /* renamed from: u */
    public Spring m35577u() {
        PhysicsState physicsState = this.f23455d;
        double d = physicsState.f23466a;
        this.f23459h = d;
        this.f23457f.f23466a = d;
        physicsState.f23467b = Utils.DOUBLE_EPSILON;
        return this;
    }

    /* renamed from: v */
    public Spring m35576v(double d) {
        return m35575w(d, true);
    }

    /* renamed from: w */
    public Spring m35575w(double d, boolean z) {
        this.f23458g = d;
        this.f23455d.f23466a = d;
        this.f23465n.m35641a(m35589i());
        Iterator<SpringListener> it = this.f23463l.iterator();
        while (it.hasNext()) {
            it.next().onSpringUpdate(this);
        }
        if (z) {
            m35577u();
        }
        return this;
    }

    /* renamed from: x */
    public Spring m35574x(double d) {
        if (this.f23459h == d && m35582p()) {
            return this;
        }
        this.f23458g = m35592f();
        this.f23459h = d;
        this.f23465n.m35641a(m35589i());
        Iterator<SpringListener> it = this.f23463l.iterator();
        while (it.hasNext()) {
            it.next().onSpringEndStateChange(this);
        }
        return this;
    }

    /* renamed from: y */
    public Spring m35573y(boolean z) {
        this.f23453b = z;
        return this;
    }

    /* renamed from: z */
    public Spring m35572z(double d) {
        this.f23462k = d;
        return this;
    }
}

package com.facebook.rebound;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class SpringChain implements SpringListener {

    /* renamed from: h */
    private static final int f23469h = 40;

    /* renamed from: i */
    private static final int f23470i = 6;

    /* renamed from: j */
    private static final int f23471j = 70;

    /* renamed from: k */
    private static final int f23472k = 10;

    /* renamed from: a */
    private final SpringSystem f23474a;

    /* renamed from: b */
    private final CopyOnWriteArrayList<SpringListener> f23475b;

    /* renamed from: c */
    private final CopyOnWriteArrayList<Spring> f23476c;

    /* renamed from: d */
    private int f23477d;

    /* renamed from: e */
    private final SpringConfig f23478e;

    /* renamed from: f */
    private final SpringConfig f23479f;

    /* renamed from: g */
    private static final SpringConfigRegistry f23468g = SpringConfigRegistry.m35559c();

    /* renamed from: l */
    private static int f23473l = 0;

    private SpringChain() {
        this(40, 6, 70, 10);
    }

    /* renamed from: b */
    public static SpringChain m35570b() {
        return new SpringChain();
    }

    /* renamed from: c */
    public static SpringChain m35569c(int i, int i2, int i3, int i4) {
        return new SpringChain(i, i2, i3, i4);
    }

    /* renamed from: a */
    public SpringChain m35571a(SpringListener springListener) {
        this.f23476c.add(this.f23474a.m35638d().m35597a(this).m35601B(this.f23479f));
        this.f23475b.add(springListener);
        return this;
    }

    /* renamed from: d */
    public List<Spring> m35568d() {
        return this.f23476c;
    }

    /* renamed from: e */
    public SpringConfig m35567e() {
        return this.f23479f;
    }

    /* renamed from: f */
    public Spring m35566f() {
        return this.f23476c.get(this.f23477d);
    }

    /* renamed from: g */
    public SpringConfig m35565g() {
        return this.f23478e;
    }

    /* renamed from: h */
    public SpringChain m35564h(int i) {
        this.f23477d = i;
        if (this.f23476c.get(i) == null) {
            return null;
        }
        for (Spring spring : this.f23474a.m35636f()) {
            spring.m35601B(this.f23479f);
        }
        m35566f().m35601B(this.f23478e);
        return this;
    }

    @Override // com.facebook.rebound.SpringListener
    public void onSpringActivate(Spring spring) {
        this.f23475b.get(this.f23476c.indexOf(spring)).onSpringActivate(spring);
    }

    @Override // com.facebook.rebound.SpringListener
    public void onSpringAtRest(Spring spring) {
        this.f23475b.get(this.f23476c.indexOf(spring)).onSpringAtRest(spring);
    }

    @Override // com.facebook.rebound.SpringListener
    public void onSpringEndStateChange(Spring spring) {
        this.f23475b.get(this.f23476c.indexOf(spring)).onSpringEndStateChange(spring);
    }

    @Override // com.facebook.rebound.SpringListener
    public void onSpringUpdate(Spring spring) {
        int i;
        int i2;
        int indexOf = this.f23476c.indexOf(spring);
        SpringListener springListener = this.f23475b.get(indexOf);
        int i3 = this.f23477d;
        if (indexOf == i3) {
            i2 = indexOf - 1;
            i = indexOf + 1;
        } else if (indexOf < i3) {
            i2 = indexOf - 1;
            i = -1;
        } else {
            i = indexOf > i3 ? indexOf + 1 : -1;
            i2 = -1;
        }
        if (i > -1 && i < this.f23476c.size()) {
            this.f23476c.get(i).m35574x(spring.m35592f());
        }
        if (i2 > -1 && i2 < this.f23476c.size()) {
            this.f23476c.get(i2).m35574x(spring.m35592f());
        }
        springListener.onSpringUpdate(spring);
    }

    private SpringChain(int i, int i2, int i3, int i4) {
        this.f23474a = SpringSystem.m35555m();
        this.f23475b = new CopyOnWriteArrayList<>();
        this.f23476c = new CopyOnWriteArrayList<>();
        this.f23477d = -1;
        SpringConfig m35562b = SpringConfig.m35562b(i, i2);
        this.f23478e = m35562b;
        SpringConfig m35562b2 = SpringConfig.m35562b(i3, i4);
        this.f23479f = m35562b2;
        SpringConfigRegistry springConfigRegistry = f23468g;
        StringBuilder sb = new StringBuilder();
        sb.append("main spring ");
        int i5 = f23473l;
        f23473l = i5 + 1;
        sb.append(i5);
        springConfigRegistry.m35561a(m35562b, sb.toString());
        StringBuilder sb2 = new StringBuilder();
        sb2.append("attachment spring ");
        int i6 = f23473l;
        f23473l = i6 + 1;
        sb2.append(i6);
        springConfigRegistry.m35561a(m35562b2, sb2.toString());
    }
}

package com.acse.ottn.animator.p031a;

import android.view.animation.Interpolator;

/* renamed from: com.acse.ottn.animator.a.k */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public abstract class AbstractC1350k implements Cloneable {

    /* renamed from: a */
    float f2388a;

    /* renamed from: b */
    Class f2389b;

    /* renamed from: c */
    private Interpolator f2390c = null;

    /* renamed from: d */
    boolean f2391d = false;

    /* renamed from: com.acse.ottn.animator.a.k$a */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    static class C1351a extends AbstractC1350k {

        /* renamed from: e */
        float f2392e;

        C1351a(float f) {
            this.f2388a = f;
            this.f2389b = Float.TYPE;
        }

        C1351a(float f, float f2) {
            this.f2388a = f;
            this.f2392e = f2;
            this.f2389b = Float.TYPE;
            this.f2391d = true;
        }

        @Override // com.acse.ottn.animator.p031a.AbstractC1350k
        /* renamed from: a */
        public void mo57066a(Object obj) {
            if (obj == null || obj.getClass() != Float.class) {
                return;
            }
            this.f2392e = ((Float) obj).floatValue();
            this.f2391d = true;
        }

        @Override // com.acse.ottn.animator.p031a.AbstractC1350k
        /* renamed from: clone */
        public C1351a mo60092clone() {
            C1351a c1351a = new C1351a(m57080a(), this.f2392e);
            c1351a.m57075a(m57074b());
            return c1351a;
        }

        @Override // com.acse.ottn.animator.p031a.AbstractC1350k
        /* renamed from: d */
        public Object mo57065d() {
            return Float.valueOf(this.f2392e);
        }

        /* renamed from: f */
        public float m57068f() {
            return this.f2392e;
        }
    }

    /* renamed from: com.acse.ottn.animator.a.k$b */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    static class C1352b extends AbstractC1350k {

        /* renamed from: e */
        int f2393e;

        C1352b(float f) {
            this.f2388a = f;
            this.f2389b = Integer.TYPE;
        }

        C1352b(float f, int i) {
            this.f2388a = f;
            this.f2393e = i;
            this.f2389b = Integer.TYPE;
            this.f2391d = true;
        }

        @Override // com.acse.ottn.animator.p031a.AbstractC1350k
        /* renamed from: a */
        public void mo57066a(Object obj) {
            if (obj == null || obj.getClass() != Integer.class) {
                return;
            }
            this.f2393e = ((Integer) obj).intValue();
            this.f2391d = true;
        }

        @Override // com.acse.ottn.animator.p031a.AbstractC1350k
        /* renamed from: clone */
        public C1352b mo60092clone() {
            C1352b c1352b = new C1352b(m57080a(), this.f2393e);
            c1352b.m57075a(m57074b());
            return c1352b;
        }

        @Override // com.acse.ottn.animator.p031a.AbstractC1350k
        /* renamed from: d */
        public Object mo57065d() {
            return Integer.valueOf(this.f2393e);
        }

        /* renamed from: f */
        public int m57067f() {
            return this.f2393e;
        }
    }

    /* renamed from: com.acse.ottn.animator.a.k$c */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    static class C1353c extends AbstractC1350k {

        /* renamed from: e */
        Object f2394e;

        C1353c(float f, Object obj) {
            this.f2388a = f;
            this.f2394e = obj;
            boolean z = obj != null;
            this.f2391d = z;
            this.f2389b = z ? obj.getClass() : Object.class;
        }

        @Override // com.acse.ottn.animator.p031a.AbstractC1350k
        /* renamed from: a */
        public void mo57066a(Object obj) {
            this.f2394e = obj;
            this.f2391d = obj != null;
        }

        @Override // com.acse.ottn.animator.p031a.AbstractC1350k
        /* renamed from: clone */
        public C1353c mo60092clone() {
            C1353c c1353c = new C1353c(m57080a(), this.f2394e);
            c1353c.m57075a(m57074b());
            return c1353c;
        }

        @Override // com.acse.ottn.animator.p031a.AbstractC1350k
        /* renamed from: d */
        public Object mo57065d() {
            return this.f2394e;
        }
    }

    /* renamed from: a */
    public static AbstractC1350k m57079a(float f) {
        return new C1351a(f);
    }

    /* renamed from: a */
    public static AbstractC1350k m57078a(float f, float f2) {
        return new C1351a(f, f2);
    }

    /* renamed from: a */
    public static AbstractC1350k m57077a(float f, int i) {
        return new C1352b(f, i);
    }

    /* renamed from: a */
    public static AbstractC1350k m57076a(float f, Object obj) {
        return new C1353c(f, obj);
    }

    /* renamed from: b */
    public static AbstractC1350k m57073b(float f) {
        return new C1352b(f);
    }

    /* renamed from: c */
    public static AbstractC1350k m57071c(float f) {
        return new C1353c(f, null);
    }

    /* renamed from: a */
    public float m57080a() {
        return this.f2388a;
    }

    /* renamed from: a */
    public void m57075a(Interpolator interpolator) {
        this.f2390c = interpolator;
    }

    /* renamed from: a */
    public abstract void mo57066a(Object obj);

    /* renamed from: b */
    public Interpolator m57074b() {
        return this.f2390c;
    }

    /* renamed from: c */
    public Class m57072c() {
        return this.f2389b;
    }

    @Override // 
    /* renamed from: clone */
    public abstract AbstractC1350k mo60092clone();

    /* renamed from: d */
    public abstract Object mo57065d();

    /* renamed from: d */
    public void m57070d(float f) {
        this.f2388a = f;
    }

    /* renamed from: e */
    public boolean m57069e() {
        return this.f2391d;
    }
}

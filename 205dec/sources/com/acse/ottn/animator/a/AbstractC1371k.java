package com.acse.ottn.animator.a;

import android.view.animation.Interpolator;

/* renamed from: com.acse.ottn.animator.a.k  reason: case insensitive filesystem */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
public abstract class AbstractC1371k implements Cloneable {

    /* renamed from: a  reason: collision with root package name */
    float f4935a;

    /* renamed from: b  reason: collision with root package name */
    Class f4936b;

    /* renamed from: c  reason: collision with root package name */
    private Interpolator f4937c = null;

    /* renamed from: d  reason: collision with root package name */
    boolean f4938d = false;

    /* renamed from: com.acse.ottn.animator.a.k$a */
    /* loaded from: E:\TSN-r\205dec\6276784.dex */
    static class a extends AbstractC1371k {

        /* renamed from: e  reason: collision with root package name */
        float f4939e;

        a(float f4) {
            this.f4935a = f4;
            this.f4936b = Float.TYPE;
        }

        a(float f4, float f5) {
            this.f4935a = f4;
            this.f4939e = f5;
            this.f4936b = Float.TYPE;
            this.f4938d = true;
        }

        @Override // com.acse.ottn.animator.a.AbstractC1371k
        public void a(Object obj) {
            if (obj == null || obj.getClass() != Float.class) {
                return;
            }
            this.f4939e = ((Float) obj).floatValue();
            this.f4938d = true;
        }

        @Override // com.acse.ottn.animator.a.AbstractC1371k
        /* renamed from: clone */
        public a mo13clone() {
            a aVar = new a(a(), this.f4939e);
            aVar.a(b());
            return aVar;
        }

        @Override // com.acse.ottn.animator.a.AbstractC1371k
        public Object d() {
            return Float.valueOf(this.f4939e);
        }

        public float f() {
            return this.f4939e;
        }
    }

    /* renamed from: com.acse.ottn.animator.a.k$b */
    /* loaded from: E:\TSN-r\205dec\6276784.dex */
    static class b extends AbstractC1371k {

        /* renamed from: e  reason: collision with root package name */
        int f4940e;

        b(float f4) {
            this.f4935a = f4;
            this.f4936b = Integer.TYPE;
        }

        b(float f4, int i4) {
            this.f4935a = f4;
            this.f4940e = i4;
            this.f4936b = Integer.TYPE;
            this.f4938d = true;
        }

        @Override // com.acse.ottn.animator.a.AbstractC1371k
        public void a(Object obj) {
            if (obj == null || obj.getClass() != Integer.class) {
                return;
            }
            this.f4940e = ((Integer) obj).intValue();
            this.f4938d = true;
        }

        @Override // com.acse.ottn.animator.a.AbstractC1371k
        /* renamed from: clone */
        public b mo13clone() {
            b bVar = new b(a(), this.f4940e);
            bVar.a(b());
            return bVar;
        }

        @Override // com.acse.ottn.animator.a.AbstractC1371k
        public Object d() {
            return Integer.valueOf(this.f4940e);
        }

        public int f() {
            return this.f4940e;
        }
    }

    /* renamed from: com.acse.ottn.animator.a.k$c */
    /* loaded from: E:\TSN-r\205dec\6276784.dex */
    static class c extends AbstractC1371k {

        /* renamed from: e  reason: collision with root package name */
        Object f4941e;

        c(float f4, Object obj) {
            this.f4935a = f4;
            this.f4941e = obj;
            boolean z3 = obj != null;
            this.f4938d = z3;
            this.f4936b = z3 ? obj.getClass() : Object.class;
        }

        @Override // com.acse.ottn.animator.a.AbstractC1371k
        public void a(Object obj) {
            this.f4941e = obj;
            this.f4938d = obj != null;
        }

        @Override // com.acse.ottn.animator.a.AbstractC1371k
        /* renamed from: clone */
        public c mo13clone() {
            c cVar = new c(a(), this.f4941e);
            cVar.a(b());
            return cVar;
        }

        @Override // com.acse.ottn.animator.a.AbstractC1371k
        public Object d() {
            return this.f4941e;
        }
    }

    public static AbstractC1371k a(float f4) {
        return new a(f4);
    }

    public static AbstractC1371k a(float f4, float f5) {
        return new a(f4, f5);
    }

    public static AbstractC1371k a(float f4, int i4) {
        return new b(f4, i4);
    }

    public static AbstractC1371k a(float f4, Object obj) {
        return new c(f4, obj);
    }

    public static AbstractC1371k b(float f4) {
        return new b(f4);
    }

    public static AbstractC1371k c(float f4) {
        return new c(f4, null);
    }

    public float a() {
        return this.f4935a;
    }

    public void a(Interpolator interpolator) {
        this.f4937c = interpolator;
    }

    public abstract void a(Object obj);

    public Interpolator b() {
        return this.f4937c;
    }

    public Class c() {
        return this.f4936b;
    }

    @Override // 
    /* renamed from: clone */
    public abstract AbstractC1371k mo13clone();

    public abstract Object d();

    public void d(float f4) {
        this.f4935a = f4;
    }

    public boolean e() {
        return this.f4938d;
    }
}

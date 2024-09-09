package com.acse.ottn;

import android.view.animation.Interpolator;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public abstract class u1 implements Cloneable {

    /* renamed from: a  reason: collision with root package name */
    public float f6648a;

    /* renamed from: b  reason: collision with root package name */
    public Class f6649b;

    /* renamed from: c  reason: collision with root package name */
    public Interpolator f6650c = null;

    /* renamed from: d  reason: collision with root package name */
    public boolean f6651d = false;

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public static class a extends u1 {

        /* renamed from: e  reason: collision with root package name */
        public float f6652e;

        public a(float f4, float f5) {
            this.f6648a = f4;
            this.f6652e = f5;
            this.f6649b = Float.TYPE;
            this.f6651d = true;
        }

        @Override // com.acse.ottn.u1
        public Object e() {
            return Float.valueOf(this.f6652e);
        }

        @Override // com.acse.ottn.u1
        /* renamed from: g */
        public a clone() {
            a aVar = new a(b(), this.f6652e);
            aVar.a(c());
            return aVar;
        }

        public float h() {
            return this.f6652e;
        }

        @Override // com.acse.ottn.u1
        public void a(Object obj) {
            if (obj == null || obj.getClass() != Float.class) {
                return;
            }
            this.f6652e = ((Float) obj).floatValue();
            this.f6651d = true;
        }

        public a(float f4) {
            this.f6648a = f4;
            this.f6649b = Float.TYPE;
        }
    }

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public static class b extends u1 {

        /* renamed from: e  reason: collision with root package name */
        public int f6653e;

        public b(float f4, int i4) {
            this.f6648a = f4;
            this.f6653e = i4;
            this.f6649b = Integer.TYPE;
            this.f6651d = true;
        }

        @Override // com.acse.ottn.u1
        public Object e() {
            return Integer.valueOf(this.f6653e);
        }

        @Override // com.acse.ottn.u1
        /* renamed from: g */
        public b clone() {
            b bVar = new b(b(), this.f6653e);
            bVar.a(c());
            return bVar;
        }

        public int h() {
            return this.f6653e;
        }

        @Override // com.acse.ottn.u1
        public void a(Object obj) {
            if (obj == null || obj.getClass() != Integer.class) {
                return;
            }
            this.f6653e = ((Integer) obj).intValue();
            this.f6651d = true;
        }

        public b(float f4) {
            this.f6648a = f4;
            this.f6649b = Integer.TYPE;
        }
    }

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public static class c extends u1 {

        /* renamed from: e  reason: collision with root package name */
        public Object f6654e;

        public c(float f4, Object obj) {
            this.f6648a = f4;
            this.f6654e = obj;
            boolean z3 = obj != null;
            this.f6651d = z3;
            this.f6649b = z3 ? obj.getClass() : Object.class;
        }

        @Override // com.acse.ottn.u1
        public Object e() {
            return this.f6654e;
        }

        @Override // com.acse.ottn.u1
        /* renamed from: g */
        public c clone() {
            c cVar = new c(b(), this.f6654e);
            cVar.a(c());
            return cVar;
        }

        @Override // com.acse.ottn.u1
        public void a(Object obj) {
            this.f6654e = obj;
            this.f6651d = obj != null;
        }
    }

    public static u1 a(float f4, int i4) {
        return new b(f4, i4);
    }

    public static u1 b(float f4) {
        return new b(f4);
    }

    public static u1 c(float f4) {
        return new c(f4, null);
    }

    @Override // 
    /* renamed from: a */
    public abstract u1 clone();

    public abstract void a(Object obj);

    public void d(float f4) {
        this.f6648a = f4;
    }

    public abstract Object e();

    public boolean f() {
        return this.f6651d;
    }

    public static u1 a(float f4, float f5) {
        return new a(f4, f5);
    }

    public float b() {
        return this.f6648a;
    }

    public Interpolator c() {
        return this.f6650c;
    }

    public Class d() {
        return this.f6649b;
    }

    public static u1 a(float f4) {
        return new a(f4);
    }

    public static u1 a(float f4, Object obj) {
        return new c(f4, obj);
    }

    public void a(Interpolator interpolator) {
        this.f6650c = interpolator;
    }
}

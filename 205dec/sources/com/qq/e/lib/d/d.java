package com.qq.e.lib.d;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public final class d {

    /* renamed from: e  reason: collision with root package name */
    public static final d f47411e;

    /* renamed from: f  reason: collision with root package name */
    public static final d f47412f;

    /* renamed from: g  reason: collision with root package name */
    public static final d f47413g;

    /* renamed from: h  reason: collision with root package name */
    public static final d f47414h;

    /* renamed from: i  reason: collision with root package name */
    public static final d f47415i;

    /* renamed from: j  reason: collision with root package name */
    public static final d f47416j;

    /* renamed from: a  reason: collision with root package name */
    final float[] f47417a;

    /* renamed from: b  reason: collision with root package name */
    final float[] f47418b = new float[3];

    /* renamed from: c  reason: collision with root package name */
    final float[] f47419c = new float[3];

    /* renamed from: d  reason: collision with root package name */
    boolean f47420d = true;

    static {
        d dVar = new d();
        f47411e = dVar;
        b(dVar);
        e(f47411e);
        d dVar2 = new d();
        f47412f = dVar2;
        d(dVar2);
        e(f47412f);
        d dVar3 = new d();
        f47413g = dVar3;
        a(dVar3);
        e(f47413g);
        d dVar4 = new d();
        f47414h = dVar4;
        b(dVar4);
        c(f47414h);
        d dVar5 = new d();
        f47415i = dVar5;
        d(dVar5);
        c(f47415i);
        d dVar6 = new d();
        f47416j = dVar6;
        a(dVar6);
        c(f47416j);
    }

    d() {
        float[] fArr = new float[3];
        this.f47417a = fArr;
        a(fArr);
        a(this.f47418b);
        l();
    }

    private void l() {
        float[] fArr = this.f47419c;
        fArr[0] = 0.24f;
        fArr[1] = 0.52f;
        fArr[2] = 0.24f;
    }

    public float a() {
        return this.f47419c[1];
    }

    public float b() {
        return this.f47418b[2];
    }

    public float c() {
        return this.f47417a[2];
    }

    public float d() {
        return this.f47418b[0];
    }

    public float e() {
        return this.f47417a[0];
    }

    public float f() {
        return this.f47419c[2];
    }

    public float g() {
        return this.f47419c[0];
    }

    public float h() {
        return this.f47418b[1];
    }

    public float i() {
        return this.f47417a[1];
    }

    public boolean j() {
        return this.f47420d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k() {
        int length = this.f47419c.length;
        float f4 = 0.0f;
        for (int i4 = 0; i4 < length; i4++) {
            float f5 = this.f47419c[i4];
            if (f5 > 0.0f) {
                f4 += f5;
            }
        }
        if (f4 != 0.0f) {
            int length2 = this.f47419c.length;
            for (int i5 = 0; i5 < length2; i5++) {
                float[] fArr = this.f47419c;
                if (fArr[i5] > 0.0f) {
                    fArr[i5] = fArr[i5] / f4;
                }
            }
        }
    }

    private static void a(float[] fArr) {
        fArr[0] = 0.0f;
        fArr[1] = 0.5f;
        fArr[2] = 1.0f;
    }

    private static void b(d dVar) {
        float[] fArr = dVar.f47418b;
        fArr[0] = 0.55f;
        fArr[1] = 0.74f;
    }

    private static void c(d dVar) {
        float[] fArr = dVar.f47417a;
        fArr[1] = 0.3f;
        fArr[2] = 0.4f;
    }

    private static void d(d dVar) {
        float[] fArr = dVar.f47418b;
        fArr[0] = 0.3f;
        fArr[1] = 0.5f;
        fArr[2] = 0.7f;
    }

    private static void e(d dVar) {
        float[] fArr = dVar.f47417a;
        fArr[0] = 0.35f;
        fArr[1] = 1.0f;
    }

    private static void a(d dVar) {
        float[] fArr = dVar.f47418b;
        fArr[1] = 0.26f;
        fArr[2] = 0.45f;
    }
}

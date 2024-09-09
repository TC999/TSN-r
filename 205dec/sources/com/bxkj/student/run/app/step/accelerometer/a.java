package com.bxkj.student.run.app.step.accelerometer;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: StepCount.java */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class a implements b {

    /* renamed from: c  reason: collision with root package name */
    private d f22644c;

    /* renamed from: f  reason: collision with root package name */
    private c f22647f;

    /* renamed from: a  reason: collision with root package name */
    private int f22642a = 0;

    /* renamed from: b  reason: collision with root package name */
    private int f22643b = 0;

    /* renamed from: d  reason: collision with root package name */
    private long f22645d = 0;

    /* renamed from: e  reason: collision with root package name */
    private long f22646e = 0;

    /* renamed from: g  reason: collision with root package name */
    private boolean f22648g = false;

    public a() {
        c cVar = new c();
        this.f22647f = cVar;
        cVar.d(this);
    }

    @Override // com.bxkj.student.run.app.step.accelerometer.b
    public void a() {
        this.f22645d = this.f22646e;
        long currentTimeMillis = System.currentTimeMillis();
        this.f22646e = currentTimeMillis;
        if (currentTimeMillis - this.f22645d <= 3000) {
            int i4 = this.f22642a;
            if (i4 < 9) {
                this.f22642a = i4 + 1;
                return;
            } else if (i4 == 9) {
                int i5 = i4 + 1;
                this.f22642a = i5;
                if (!this.f22648g) {
                    this.f22643b += i5;
                }
                d();
                return;
            } else {
                if (!this.f22648g) {
                    this.f22643b++;
                }
                d();
                return;
            }
        }
        this.f22642a = 1;
    }

    public c b() {
        return this.f22647f;
    }

    public void c(d listener) {
        this.f22644c = listener;
    }

    public void d() {
        d dVar = this.f22644c;
        if (dVar != null) {
            dVar.a(this.f22643b);
        }
    }

    public a e(boolean pause) {
        this.f22648g = pause;
        return this;
    }

    public void f(int initValue) {
        this.f22643b = initValue;
        this.f22642a = 0;
        this.f22645d = 0L;
        this.f22646e = 0L;
        d();
    }
}

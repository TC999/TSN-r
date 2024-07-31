package com.bxkj.student.run.app.step.accelerometer;

/* renamed from: com.bxkj.student.run.app.step.accelerometer.a */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class StepCount implements StepCountListener {

    /* renamed from: c */
    private StepValuePassListener f19413c;

    /* renamed from: f */
    private StepDetector f19416f;

    /* renamed from: a */
    private int f19411a = 0;

    /* renamed from: b */
    private int f19412b = 0;

    /* renamed from: d */
    private long f19414d = 0;

    /* renamed from: e */
    private long f19415e = 0;

    /* renamed from: g */
    private boolean f19417g = false;

    public StepCount() {
        StepDetector stepDetector = new StepDetector();
        this.f19416f = stepDetector;
        stepDetector.m39741d(this);
    }

    @Override // com.bxkj.student.run.app.step.accelerometer.StepCountListener
    /* renamed from: a */
    public void mo39745a() {
        this.f19414d = this.f19415e;
        long currentTimeMillis = System.currentTimeMillis();
        this.f19415e = currentTimeMillis;
        if (currentTimeMillis - this.f19414d <= 3000) {
            int i = this.f19411a;
            if (i < 9) {
                this.f19411a = i + 1;
                return;
            } else if (i == 9) {
                int i2 = i + 1;
                this.f19411a = i2;
                if (!this.f19417g) {
                    this.f19412b += i2;
                }
                m39748d();
                return;
            } else {
                if (!this.f19417g) {
                    this.f19412b++;
                }
                m39748d();
                return;
            }
        }
        this.f19411a = 1;
    }

    /* renamed from: b */
    public StepDetector m39750b() {
        return this.f19416f;
    }

    /* renamed from: c */
    public void m39749c(StepValuePassListener listener) {
        this.f19413c = listener;
    }

    /* renamed from: d */
    public void m39748d() {
        StepValuePassListener stepValuePassListener = this.f19413c;
        if (stepValuePassListener != null) {
            stepValuePassListener.mo38207a(this.f19412b);
        }
    }

    /* renamed from: e */
    public StepCount m39747e(boolean pause) {
        this.f19417g = pause;
        return this;
    }

    /* renamed from: f */
    public void m39746f(int initValue) {
        this.f19412b = initValue;
        this.f19411a = 0;
        this.f19414d = 0L;
        this.f19415e = 0L;
        m39748d();
    }
}

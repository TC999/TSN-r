package com.bxkj.student.v2.ui.sports.v3.service.step;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import kotlin.Metadata;
import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: V3StepDetector.kt */
@Metadata(bv = {}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0010\u0013\n\u0002\b.\n\u0002\u0010\t\n\u0002\b\u0019\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b`\u0010aJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\r\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000bJ\u000e\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eJ\u0016\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u000eJ\u000e\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u000eJ\u0016\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\bR\"\u0010 \u001a\u00020\u001a8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001a\u0010$\u001a\u00020\b8\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\u0010\u0010!\u001a\u0004\b\"\u0010#R\"\u0010*\u001a\u00020\u00178\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\"\u0010/\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b+\u0010!\u001a\u0004\b,\u0010#\"\u0004\b-\u0010.R\"\u00106\u001a\u00020\u00138\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b0\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\"\u00109\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b7\u0010!\u001a\u0004\b+\u0010#\"\u0004\b8\u0010.R\"\u0010<\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b:\u0010!\u001a\u0004\b0\u0010#\"\u0004\b;\u0010.R\"\u0010@\u001a\u00020\u00138\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b=\u00101\u001a\u0004\b>\u00103\"\u0004\b?\u00105R\"\u0010E\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b>\u0010-\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR\"\u0010H\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001c\u0010-\u001a\u0004\bF\u0010B\"\u0004\bG\u0010DR\"\u0010O\u001a\u00020I8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bA\u0010J\u001a\u0004\bK\u0010L\"\u0004\bM\u0010NR\"\u0010Q\u001a\u00020I8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b,\u0010J\u001a\u0004\bP\u0010L\"\u0004\bJ\u0010NR\"\u0010T\u001a\u00020I8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b&\u0010J\u001a\u0004\bR\u0010L\"\u0004\bS\u0010NR\"\u0010V\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010-\u001a\u0004\b7\u0010B\"\u0004\bU\u0010DR\"\u0010Y\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bW\u0010-\u001a\u0004\b:\u0010B\"\u0004\bX\u0010DR\u001a\u0010Z\u001a\u00020\u000e8\u0006X\u0086D\u00a2\u0006\f\n\u0004\bP\u0010-\u001a\u0004\b=\u0010BR\"\u0010\\\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bR\u0010-\u001a\u0004\b\u0018\u0010B\"\u0004\b[\u0010DR\"\u0010]\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bK\u0010!\u001a\u0004\bW\u0010#\"\u0004\b!\u0010.R\u0018\u0010_\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bF\u0010^\u00a8\u0006b"}, d2 = {"Lcom/bxkj/student/v2/ui/sports/v3/service/step/a;", "Landroid/hardware/SensorEventListener;", "Landroid/hardware/SensorEvent;", "event", "Lkotlin/f1;", "onSensorChanged", "Landroid/hardware/Sensor;", "sensor", "", "accuracy", "onAccuracyChanged", "Lcom/bxkj/student/run/app/step/b;", "listener", "u", "", "values", "b", "newValue", "oldValue", "", "c", "value", "w", "", "n", "a", "", "[D", "j", "()[D", "D", "([D)V", "oriValues", "I", "t", "()I", "ValueNum", "[F", "m", "()[F", "G", "([F)V", "tempValue", "d", "l", "F", "(I)V", "tempCount", "e", "Z", "v", "()Z", "z", "(Z)V", "isDirectionUp", "f", "x", "continueUpCount", "g", "y", "continueUpFormerCount", "h", "i", "C", "lastStatus", "k", "()F", "E", "(F)V", "peakOfWave", "s", "M", "valleyOfWave", "", "J", "r", "()J", "L", "(J)V", "timeOfThisPeak", "p", "timeOfLastPeak", CampaignEx.JSON_KEY_AD_Q, "K", "timeOfNow", "A", "gravityNew", "o", "B", "gravityOld", "InitialValue", "H", "ThreadValue", "TimeInterval", "Lcom/bxkj/student/run/app/step/b;", "mStepListeners", "<init>", "()V", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public final class a implements SensorEventListener {

    /* renamed from: d  reason: collision with root package name */
    private int f24304d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f24305e;

    /* renamed from: f  reason: collision with root package name */
    private int f24306f;

    /* renamed from: g  reason: collision with root package name */
    private int f24307g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f24308h;

    /* renamed from: i  reason: collision with root package name */
    private float f24309i;

    /* renamed from: j  reason: collision with root package name */
    private float f24310j;

    /* renamed from: k  reason: collision with root package name */
    private long f24311k;

    /* renamed from: l  reason: collision with root package name */
    private long f24312l;

    /* renamed from: m  reason: collision with root package name */
    private long f24313m;

    /* renamed from: n  reason: collision with root package name */
    private float f24314n;

    /* renamed from: o  reason: collision with root package name */
    private float f24315o;
    @Nullable

    /* renamed from: s  reason: collision with root package name */
    private com.bxkj.student.run.app.step.b f24319s;
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private double[] f24301a = new double[3];

    /* renamed from: b  reason: collision with root package name */
    private final int f24302b = 4;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private float[] f24303c = new float[4];

    /* renamed from: p  reason: collision with root package name */
    private final float f24316p = 1.3f;

    /* renamed from: q  reason: collision with root package name */
    private float f24317q = 2.0f;

    /* renamed from: r  reason: collision with root package name */
    private int f24318r = 250;

    public final void A(float f4) {
        this.f24314n = f4;
    }

    public final void B(float f4) {
        this.f24315o = f4;
    }

    public final void C(boolean z3) {
        this.f24308h = z3;
    }

    public final void D(@NotNull double[] dArr) {
        f0.p(dArr, "<set-?>");
        this.f24301a = dArr;
    }

    public final void E(float f4) {
        this.f24309i = f4;
    }

    public final void F(int i4) {
        this.f24304d = i4;
    }

    public final void G(@NotNull float[] fArr) {
        f0.p(fArr, "<set-?>");
        this.f24303c = fArr;
    }

    public final void H(float f4) {
        this.f24317q = f4;
    }

    public final void I(int i4) {
        this.f24318r = i4;
    }

    public final void J(long j4) {
        this.f24312l = j4;
    }

    public final void K(long j4) {
        this.f24313m = j4;
    }

    public final void L(long j4) {
        this.f24311k = j4;
    }

    public final void M(float f4) {
        this.f24310j = f4;
    }

    public final float a(@NotNull float[] value, int i4) {
        f0.p(value, "value");
        float f4 = 0.0f;
        if (i4 > 0) {
            int i5 = 0;
            while (true) {
                int i6 = i5 + 1;
                f4 += value[i5];
                if (i6 >= i4) {
                    break;
                }
                i5 = i6;
            }
        }
        float f5 = f4 / this.f24302b;
        if (f5 >= 8.0f) {
            return 4.3f;
        }
        if (f5 < 7.0f || f5 >= 8.0f) {
            if (f5 < 4.0f || f5 >= 7.0f) {
                return (f5 < 3.0f || f5 >= 4.0f) ? 1.3f : 2.0f;
            }
            return 2.3f;
        }
        return 3.3f;
    }

    public final void b(float f4) {
        float f5 = this.f24315o;
        if (f5 == 0.0f) {
            this.f24315o = f4;
        } else if (c(f4, f5)) {
            this.f24312l = this.f24311k;
            long currentTimeMillis = System.currentTimeMillis();
            this.f24313m = currentTimeMillis;
            if (currentTimeMillis - this.f24312l >= this.f24318r && this.f24309i - this.f24310j >= this.f24317q) {
                this.f24311k = currentTimeMillis;
                com.bxkj.student.run.app.step.b bVar = this.f24319s;
                if (bVar != null) {
                    f0.m(bVar);
                    bVar.a();
                }
            }
            long j4 = this.f24313m;
            if (j4 - this.f24312l >= this.f24318r) {
                float f6 = this.f24309i;
                float f7 = this.f24310j;
                if (f6 - f7 >= this.f24316p) {
                    this.f24311k = j4;
                    this.f24317q = w(f6 - f7);
                }
            }
        }
        this.f24315o = f4;
    }

    public final boolean c(float f4, float f5) {
        boolean z3 = this.f24305e;
        this.f24308h = z3;
        if (f4 >= f5) {
            this.f24305e = true;
            this.f24306f++;
        } else {
            this.f24307g = this.f24306f;
            this.f24306f = 0;
            this.f24305e = false;
        }
        boolean z4 = this.f24305e;
        if (!z4 && z3 && (this.f24307g >= 2 || f5 >= 20.0f)) {
            this.f24309i = f5;
            return true;
        }
        if (!z3 && z4) {
            this.f24310j = f5;
        }
        return false;
    }

    public final int d() {
        return this.f24306f;
    }

    public final int e() {
        return this.f24307g;
    }

    public final float f() {
        return this.f24314n;
    }

    public final float g() {
        return this.f24315o;
    }

    public final float h() {
        return this.f24316p;
    }

    public final boolean i() {
        return this.f24308h;
    }

    @NotNull
    public final double[] j() {
        return this.f24301a;
    }

    public final float k() {
        return this.f24309i;
    }

    public final int l() {
        return this.f24304d;
    }

    @NotNull
    public final float[] m() {
        return this.f24303c;
    }

    public final float n() {
        return this.f24317q;
    }

    public final int o() {
        return this.f24318r;
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(@NotNull Sensor sensor, int i4) {
        f0.p(sensor, "sensor");
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(@NotNull SensorEvent event) {
        f0.p(event, "event");
        int i4 = 0;
        while (true) {
            int i5 = i4 + 1;
            this.f24301a[i4] = event.values[i4];
            if (i5 > 2) {
                break;
            }
            i4 = i5;
        }
        com.bxkj.student.run.app.step.b bVar = this.f24319s;
        if (bVar != null) {
            f0.m(bVar);
            bVar.b(this.f24301a);
        }
        double[] dArr = this.f24301a;
        float sqrt = (float) Math.sqrt((dArr[0] * dArr[0]) + (dArr[1] * dArr[1]) + (dArr[2] * dArr[2]));
        this.f24314n = sqrt;
        b(sqrt);
    }

    public final long p() {
        return this.f24312l;
    }

    public final long q() {
        return this.f24313m;
    }

    public final long r() {
        return this.f24311k;
    }

    public final float s() {
        return this.f24310j;
    }

    public final int t() {
        return this.f24302b;
    }

    public final void u(@Nullable com.bxkj.student.run.app.step.b bVar) {
        this.f24319s = bVar;
    }

    public final boolean v() {
        return this.f24305e;
    }

    public final float w(float f4) {
        float f5 = this.f24317q;
        int i4 = this.f24304d;
        int i5 = this.f24302b;
        if (i4 < i5) {
            this.f24303c[i4] = f4;
            this.f24304d = i4 + 1;
        } else {
            f5 = a(this.f24303c, i5);
            int i6 = this.f24302b;
            if (1 < i6) {
                int i7 = 1;
                while (true) {
                    int i8 = i7 + 1;
                    float[] fArr = this.f24303c;
                    fArr[i7 - 1] = fArr[i7];
                    if (i8 >= i6) {
                        break;
                    }
                    i7 = i8;
                }
            }
            this.f24303c[this.f24302b - 1] = f4;
        }
        return f5;
    }

    public final void x(int i4) {
        this.f24306f = i4;
    }

    public final void y(int i4) {
        this.f24307g = i4;
    }

    public final void z(boolean z3) {
        this.f24305e = z3;
    }
}

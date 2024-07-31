package com.bxkj.student.p094v2.p098ui.sports.p102v3.service.step;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import androidx.exifinterface.media.ExifInterface;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.bxkj.student.run.app.step.InterfaceC5361b;
import com.kuaishou.weapon.p205p0.C7304t;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import com.umeng.analytics.pro.UMCommonContent;
import kotlin.Metadata;
import kotlin.jvm.internal.C14342f0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(m12618bv = {}, m12617d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0010\u0013\n\u0002\b.\n\u0002\u0010\t\n\u0002\b\u0019\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b`\u0010aJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\r\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000bJ\u000e\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eJ\u0016\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u000eJ\u000e\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u000eJ\u0016\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\bR\"\u0010 \u001a\u00020\u001a8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001a\u0010$\u001a\u00020\b8\u0006X\u0086D¢\u0006\f\n\u0004\b\u0010\u0010!\u001a\u0004\b\"\u0010#R\"\u0010*\u001a\u00020\u00178\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\"\u0010/\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b+\u0010!\u001a\u0004\b,\u0010#\"\u0004\b-\u0010.R\"\u00106\u001a\u00020\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b0\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\"\u00109\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b7\u0010!\u001a\u0004\b+\u0010#\"\u0004\b8\u0010.R\"\u0010<\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b:\u0010!\u001a\u0004\b0\u0010#\"\u0004\b;\u0010.R\"\u0010@\u001a\u00020\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b=\u00101\u001a\u0004\b>\u00103\"\u0004\b?\u00105R\"\u0010E\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b>\u0010-\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR\"\u0010H\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010-\u001a\u0004\bF\u0010B\"\u0004\bG\u0010DR\"\u0010O\u001a\u00020I8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bA\u0010J\u001a\u0004\bK\u0010L\"\u0004\bM\u0010NR\"\u0010Q\u001a\u00020I8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b,\u0010J\u001a\u0004\bP\u0010L\"\u0004\bJ\u0010NR\"\u0010T\u001a\u00020I8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b&\u0010J\u001a\u0004\bR\u0010L\"\u0004\bS\u0010NR\"\u0010V\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010-\u001a\u0004\b7\u0010B\"\u0004\bU\u0010DR\"\u0010Y\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bW\u0010-\u001a\u0004\b:\u0010B\"\u0004\bX\u0010DR\u001a\u0010Z\u001a\u00020\u000e8\u0006X\u0086D¢\u0006\f\n\u0004\bP\u0010-\u001a\u0004\b=\u0010BR\"\u0010\\\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bR\u0010-\u001a\u0004\b\u0018\u0010B\"\u0004\b[\u0010DR\"\u0010]\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bK\u0010!\u001a\u0004\bW\u0010#\"\u0004\b!\u0010.R\u0018\u0010_\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bF\u0010^¨\u0006b"}, m12616d2 = {"Lcom/bxkj/student/v2/ui/sports/v3/service/step/a;", "Landroid/hardware/SensorEventListener;", "Landroid/hardware/SensorEvent;", "event", "Lkotlin/f1;", "onSensorChanged", "Landroid/hardware/Sensor;", UMCommonContent.f37799ac, "", "accuracy", "onAccuracyChanged", "Lcom/bxkj/student/run/app/step/b;", "listener", "u", "", "values", "b", "newValue", "oldValue", "", "c", DomainCampaignEx.LOOPBACK_VALUE, IAdInterListener.AdReqParam.WIDTH, "", "n", "a", "", "[D", "j", "()[D", "D", "([D)V", "oriValues", "I", UMCommonContent.f37782aL, "()I", "ValueNum", "[F", "m", "()[F", "G", "([F)V", "tempValue", "d", C7304t.f25048d, "F", "(I)V", "tempCount", "e", "Z", "v", "()Z", UMCommonContent.f37777aG, "(Z)V", "isDirectionUp", "f", "x", "continueUpCount", "g", "y", "continueUpFormerCount", "h", "i", "C", "lastStatus", "k", "()F", ExifInterface.LONGITUDE_EAST, "(F)V", "peakOfWave", "s", "M", "valleyOfWave", "", "J", "r", "()J", "L", "(J)V", "timeOfThisPeak", "p", "timeOfLastPeak", CampaignEx.JSON_KEY_AD_Q, "K", "timeOfNow", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "gravityNew", "o", "B", "gravityOld", "InitialValue", "H", "ThreadValue", "TimeInterval", "Lcom/bxkj/student/run/app/step/b;", "mStepListeners", "<init>", "()V", "student_xiaomiRelease"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: com.bxkj.student.v2.ui.sports.v3.service.step.a */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class V3StepDetector implements SensorEventListener {

    /* renamed from: d */
    private int f20885d;

    /* renamed from: e */
    private boolean f20886e;

    /* renamed from: f */
    private int f20887f;

    /* renamed from: g */
    private int f20888g;

    /* renamed from: h */
    private boolean f20889h;

    /* renamed from: i */
    private float f20890i;

    /* renamed from: j */
    private float f20891j;

    /* renamed from: k */
    private long f20892k;

    /* renamed from: l */
    private long f20893l;

    /* renamed from: m */
    private long f20894m;

    /* renamed from: n */
    private float f20895n;

    /* renamed from: o */
    private float f20896o;
    @Nullable

    /* renamed from: s */
    private InterfaceC5361b f20900s;
    @NotNull

    /* renamed from: a */
    private double[] f20882a = new double[3];

    /* renamed from: b */
    private final int f20883b = 4;
    @NotNull

    /* renamed from: c */
    private float[] f20884c = new float[4];

    /* renamed from: p */
    private final float f20897p = 1.3f;

    /* renamed from: q */
    private float f20898q = 2.0f;

    /* renamed from: r */
    private int f20899r = 250;

    /* renamed from: A */
    public final void m38246A(float f) {
        this.f20895n = f;
    }

    /* renamed from: B */
    public final void m38245B(float f) {
        this.f20896o = f;
    }

    /* renamed from: C */
    public final void m38244C(boolean z) {
        this.f20889h = z;
    }

    /* renamed from: D */
    public final void m38243D(@NotNull double[] dArr) {
        C14342f0.m8184p(dArr, "<set-?>");
        this.f20882a = dArr;
    }

    /* renamed from: E */
    public final void m38242E(float f) {
        this.f20890i = f;
    }

    /* renamed from: F */
    public final void m38241F(int i) {
        this.f20885d = i;
    }

    /* renamed from: G */
    public final void m38240G(@NotNull float[] fArr) {
        C14342f0.m8184p(fArr, "<set-?>");
        this.f20884c = fArr;
    }

    /* renamed from: H */
    public final void m38239H(float f) {
        this.f20898q = f;
    }

    /* renamed from: I */
    public final void m38238I(int i) {
        this.f20899r = i;
    }

    /* renamed from: J */
    public final void m38237J(long j) {
        this.f20893l = j;
    }

    /* renamed from: K */
    public final void m38236K(long j) {
        this.f20894m = j;
    }

    /* renamed from: L */
    public final void m38235L(long j) {
        this.f20892k = j;
    }

    /* renamed from: M */
    public final void m38234M(float f) {
        this.f20891j = f;
    }

    /* renamed from: a */
    public final float m38233a(@NotNull float[] value, int i) {
        C14342f0.m8184p(value, "value");
        float f = 0.0f;
        if (i > 0) {
            int i2 = 0;
            while (true) {
                int i3 = i2 + 1;
                f += value[i2];
                if (i3 >= i) {
                    break;
                }
                i2 = i3;
            }
        }
        float f2 = f / this.f20883b;
        if (f2 >= 8.0f) {
            return 4.3f;
        }
        if (f2 < 7.0f || f2 >= 8.0f) {
            if (f2 < 4.0f || f2 >= 7.0f) {
                return (f2 < 3.0f || f2 >= 4.0f) ? 1.3f : 2.0f;
            }
            return 2.3f;
        }
        return 3.3f;
    }

    /* renamed from: b */
    public final void m38232b(float f) {
        float f2 = this.f20896o;
        if (f2 == 0.0f) {
            this.f20896o = f;
        } else if (m38231c(f, f2)) {
            this.f20893l = this.f20892k;
            long currentTimeMillis = System.currentTimeMillis();
            this.f20894m = currentTimeMillis;
            if (currentTimeMillis - this.f20893l >= this.f20899r && this.f20890i - this.f20891j >= this.f20898q) {
                this.f20892k = currentTimeMillis;
                InterfaceC5361b interfaceC5361b = this.f20900s;
                if (interfaceC5361b != null) {
                    C14342f0.m8187m(interfaceC5361b);
                    interfaceC5361b.m39739a();
                }
            }
            long j = this.f20894m;
            if (j - this.f20893l >= this.f20899r) {
                float f3 = this.f20890i;
                float f4 = this.f20891j;
                if (f3 - f4 >= this.f20897p) {
                    this.f20892k = j;
                    this.f20898q = m38211w(f3 - f4);
                }
            }
        }
        this.f20896o = f;
    }

    /* renamed from: c */
    public final boolean m38231c(float f, float f2) {
        boolean z = this.f20886e;
        this.f20889h = z;
        if (f >= f2) {
            this.f20886e = true;
            this.f20887f++;
        } else {
            this.f20888g = this.f20887f;
            this.f20887f = 0;
            this.f20886e = false;
        }
        boolean z2 = this.f20886e;
        if (!z2 && z && (this.f20888g >= 2 || f2 >= 20.0f)) {
            this.f20890i = f2;
            return true;
        }
        if (!z && z2) {
            this.f20891j = f2;
        }
        return false;
    }

    /* renamed from: d */
    public final int m38230d() {
        return this.f20887f;
    }

    /* renamed from: e */
    public final int m38229e() {
        return this.f20888g;
    }

    /* renamed from: f */
    public final float m38228f() {
        return this.f20895n;
    }

    /* renamed from: g */
    public final float m38227g() {
        return this.f20896o;
    }

    /* renamed from: h */
    public final float m38226h() {
        return this.f20897p;
    }

    /* renamed from: i */
    public final boolean m38225i() {
        return this.f20889h;
    }

    @NotNull
    /* renamed from: j */
    public final double[] m38224j() {
        return this.f20882a;
    }

    /* renamed from: k */
    public final float m38223k() {
        return this.f20890i;
    }

    /* renamed from: l */
    public final int m38222l() {
        return this.f20885d;
    }

    @NotNull
    /* renamed from: m */
    public final float[] m38221m() {
        return this.f20884c;
    }

    /* renamed from: n */
    public final float m38220n() {
        return this.f20898q;
    }

    /* renamed from: o */
    public final int m38219o() {
        return this.f20899r;
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(@NotNull Sensor sensor, int i) {
        C14342f0.m8184p(sensor, "sensor");
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(@NotNull SensorEvent event) {
        C14342f0.m8184p(event, "event");
        int i = 0;
        while (true) {
            int i2 = i + 1;
            this.f20882a[i] = event.values[i];
            if (i2 > 2) {
                break;
            }
            i = i2;
        }
        InterfaceC5361b interfaceC5361b = this.f20900s;
        if (interfaceC5361b != null) {
            C14342f0.m8187m(interfaceC5361b);
            interfaceC5361b.m39738b(this.f20882a);
        }
        double[] dArr = this.f20882a;
        float sqrt = (float) Math.sqrt((dArr[0] * dArr[0]) + (dArr[1] * dArr[1]) + (dArr[2] * dArr[2]));
        this.f20895n = sqrt;
        m38232b(sqrt);
    }

    /* renamed from: p */
    public final long m38218p() {
        return this.f20893l;
    }

    /* renamed from: q */
    public final long m38217q() {
        return this.f20894m;
    }

    /* renamed from: r */
    public final long m38216r() {
        return this.f20892k;
    }

    /* renamed from: s */
    public final float m38215s() {
        return this.f20891j;
    }

    /* renamed from: t */
    public final int m38214t() {
        return this.f20883b;
    }

    /* renamed from: u */
    public final void m38213u(@Nullable InterfaceC5361b interfaceC5361b) {
        this.f20900s = interfaceC5361b;
    }

    /* renamed from: v */
    public final boolean m38212v() {
        return this.f20886e;
    }

    /* renamed from: w */
    public final float m38211w(float f) {
        float f2 = this.f20898q;
        int i = this.f20885d;
        int i2 = this.f20883b;
        if (i < i2) {
            this.f20884c[i] = f;
            this.f20885d = i + 1;
        } else {
            f2 = m38233a(this.f20884c, i2);
            int i3 = this.f20883b;
            if (1 < i3) {
                int i4 = 1;
                while (true) {
                    int i5 = i4 + 1;
                    float[] fArr = this.f20884c;
                    fArr[i4 - 1] = fArr[i4];
                    if (i5 >= i3) {
                        break;
                    }
                    i4 = i5;
                }
            }
            this.f20884c[this.f20883b - 1] = f;
        }
        return f2;
    }

    /* renamed from: x */
    public final void m38210x(int i) {
        this.f20887f = i;
    }

    /* renamed from: y */
    public final void m38209y(int i) {
        this.f20888g = i;
    }

    /* renamed from: z */
    public final void m38208z(boolean z) {
        this.f20886e = z;
    }
}

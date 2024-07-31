package com.kwad.sdk.core.p402g;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import androidx.annotation.Nullable;
import com.github.mikephil.charting.utils.Utils;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.utils.C11040ba;
import java.util.Arrays;

/* renamed from: com.kwad.sdk.core.g.c */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10377c {
    @Nullable
    private InterfaceC10375a aAh;
    @Nullable
    private C10379a aAi;
    private AdMatrixInfo.RotateInfo rotateInfo;
    private volatile boolean aAc = true;
    private long aAd = 0;
    private double aAe = 9.999999717180685E-10d;
    private double[] aAf = {Utils.DOUBLE_EPSILON, Utils.DOUBLE_EPSILON, Utils.DOUBLE_EPSILON};
    private double[] aAg = {Utils.DOUBLE_EPSILON, Utils.DOUBLE_EPSILON, Utils.DOUBLE_EPSILON};
    private final C11040ba.InterfaceC11042b aAj = new C11040ba.InterfaceC11042b() { // from class: com.kwad.sdk.core.g.c.1
        @Override // com.kwad.sdk.utils.C11040ba.InterfaceC11042b
        public final void onFailed() {
            if (C10377c.this.aAh != null) {
                C10377c.this.aAh.mo26221lr();
            }
        }
    };

    /* renamed from: com.kwad.sdk.core.g.c$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    class C10379a implements SensorEventListener {
        private C10379a() {
        }

        @Override // android.hardware.SensorEventListener
        public final void onAccuracyChanged(Sensor sensor, int i) {
        }

        @Override // android.hardware.SensorEventListener
        public final void onSensorChanged(SensorEvent sensorEvent) {
            float[] fArr = sensorEvent.values;
            float f = fArr[0];
            float f2 = fArr[1];
            float f3 = fArr[2];
            if (C10377c.this.aAd != 0) {
                double d = sensorEvent.timestamp - C10377c.this.aAd;
                double d2 = C10377c.this.aAe;
                Double.isNaN(d);
                double d3 = d * d2;
                double[] dArr = C10377c.this.aAg;
                double d4 = dArr[0];
                double d5 = f;
                Double.isNaN(d5);
                dArr[0] = d4 + Math.toDegrees(d5 * d3);
                double[] dArr2 = C10377c.this.aAg;
                double d6 = dArr2[1];
                double d7 = f2;
                Double.isNaN(d7);
                dArr2[1] = d6 + Math.toDegrees(d7 * d3);
                double[] dArr3 = C10377c.this.aAg;
                double d8 = dArr3[2];
                double d9 = f3;
                Double.isNaN(d9);
                dArr3[2] = d8 + Math.toDegrees(d9 * d3);
                C10377c.this.m26217Fr();
                C10377c.this.m26216Fs();
            }
            C10377c.this.aAd = sensorEvent.timestamp;
        }

        /* synthetic */ C10379a(C10377c c10377c, byte b) {
            this();
        }
    }

    public C10377c(AdMatrixInfo.RotateInfo rotateInfo) {
        this.rotateInfo = rotateInfo;
    }

    /* renamed from: Fq */
    private void m26218Fq() {
        Arrays.fill(this.aAf, (double) Utils.DOUBLE_EPSILON);
        Arrays.fill(this.aAg, (double) Utils.DOUBLE_EPSILON);
        this.aAd = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Fr */
    public void m26217Fr() {
        if (this.aAc) {
            if (Math.abs(this.aAg[0]) > Math.abs(this.aAf[0])) {
                this.aAf[0] = this.aAg[0];
            }
            if (Math.abs(this.aAg[1]) > Math.abs(this.aAf[1])) {
                this.aAf[1] = this.aAg[1];
            }
            if (Math.abs(this.aAg[2]) > Math.abs(this.aAf[2])) {
                this.aAf[2] = this.aAg[2];
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Fs */
    public void m26216Fs() {
        AdMatrixInfo.RotateInfo rotateInfo;
        if (!this.aAc || (rotateInfo = this.rotateInfo) == null || this.aAh == null) {
            return;
        }
        AdMatrixInfo.RotateDegreeInfo rotateDegreeInfo = rotateInfo.f29582x;
        if (!m26214a(0, rotateDegreeInfo.rotateDegree, rotateDegreeInfo.direction)) {
            AdMatrixInfo.RotateDegreeInfo rotateDegreeInfo2 = this.rotateInfo.f29583y;
            if (!m26214a(1, rotateDegreeInfo2.rotateDegree, rotateDegreeInfo2.direction)) {
                AdMatrixInfo.RotateDegreeInfo rotateDegreeInfo3 = this.rotateInfo.f29584z;
                if (!m26214a(2, rotateDegreeInfo3.rotateDegree, rotateDegreeInfo3.direction)) {
                    return;
                }
            }
        }
        this.aAc = false;
        this.aAh.mo26222U(m26215Ft());
    }

    /* renamed from: Ft */
    private String m26215Ft() {
        return "{\"x\": " + this.aAf[0] + ",\"y\":" + this.aAf[1] + ",\"z\":" + this.aAf[2] + "}";
    }

    /* renamed from: bi */
    public final void m26208bi(Context context) {
        if (context == null) {
            return;
        }
        m26218Fq();
        this.aAc = true;
        if (this.aAi == null) {
            this.aAi = new C10379a(this, (byte) 0);
        }
        C11040ba.m23973MB().m23972a(2, 2, this.aAi, this.aAj);
    }

    /* renamed from: bj */
    public final synchronized void m26207bj(Context context) {
        if (context != null) {
            if (this.aAi != null) {
                C11040ba.m23973MB().m23971a(this.aAi);
                this.aAi = null;
            }
        }
    }

    /* renamed from: a */
    public final void m26210a(AdMatrixInfo.RotateInfo rotateInfo) {
        this.rotateInfo = rotateInfo;
    }

    /* renamed from: a */
    public final void m26213a(@Nullable InterfaceC10375a interfaceC10375a) {
        this.aAh = interfaceC10375a;
    }

    /* renamed from: a */
    private boolean m26214a(int i, double d, int i2) {
        if (d <= Utils.DOUBLE_EPSILON || Math.abs(this.aAg[i]) < d) {
            return false;
        }
        double[] dArr = this.aAg;
        return (dArr[i] <= Utils.DOUBLE_EPSILON || i2 != 1) && (dArr[i] >= Utils.DOUBLE_EPSILON || i2 != 2);
    }
}

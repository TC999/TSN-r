package com.kwad.sdk.core.g;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.utils.ba;
import java.util.Arrays;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class c {
    @Nullable
    private com.kwad.sdk.core.g.a aAh;
    @Nullable
    private a aAi;
    private AdMatrixInfo.RotateInfo rotateInfo;
    private volatile boolean aAc = true;
    private long aAd = 0;
    private double aAe = 9.999999717180685E-10d;
    private double[] aAf = {0.0d, 0.0d, 0.0d};
    private double[] aAg = {0.0d, 0.0d, 0.0d};
    private final ba.b aAj = new ba.b() { // from class: com.kwad.sdk.core.g.c.1
        @Override // com.kwad.sdk.utils.ba.b
        public final void onFailed() {
            if (c.this.aAh != null) {
                c.this.aAh.lr();
            }
        }
    };

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    class a implements SensorEventListener {
        private a() {
        }

        @Override // android.hardware.SensorEventListener
        public final void onAccuracyChanged(Sensor sensor, int i4) {
        }

        @Override // android.hardware.SensorEventListener
        public final void onSensorChanged(SensorEvent sensorEvent) {
            float[] fArr = sensorEvent.values;
            float f4 = fArr[0];
            float f5 = fArr[1];
            float f6 = fArr[2];
            if (c.this.aAd != 0) {
                double d4 = sensorEvent.timestamp - c.this.aAd;
                double d5 = c.this.aAe;
                Double.isNaN(d4);
                double d6 = d4 * d5;
                double[] dArr = c.this.aAg;
                double d7 = dArr[0];
                double d8 = f4;
                Double.isNaN(d8);
                dArr[0] = d7 + Math.toDegrees(d8 * d6);
                double[] dArr2 = c.this.aAg;
                double d9 = dArr2[1];
                double d10 = f5;
                Double.isNaN(d10);
                dArr2[1] = d9 + Math.toDegrees(d10 * d6);
                double[] dArr3 = c.this.aAg;
                double d11 = dArr3[2];
                double d12 = f6;
                Double.isNaN(d12);
                dArr3[2] = d11 + Math.toDegrees(d12 * d6);
                c.this.Fr();
                c.this.Fs();
            }
            c.this.aAd = sensorEvent.timestamp;
        }

        /* synthetic */ a(c cVar, byte b4) {
            this();
        }
    }

    public c(AdMatrixInfo.RotateInfo rotateInfo) {
        this.rotateInfo = rotateInfo;
    }

    private void Fq() {
        Arrays.fill(this.aAf, 0.0d);
        Arrays.fill(this.aAg, 0.0d);
        this.aAd = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Fr() {
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
    public void Fs() {
        AdMatrixInfo.RotateInfo rotateInfo;
        if (!this.aAc || (rotateInfo = this.rotateInfo) == null || this.aAh == null) {
            return;
        }
        AdMatrixInfo.RotateDegreeInfo rotateDegreeInfo = rotateInfo.f38653x;
        if (!a(0, rotateDegreeInfo.rotateDegree, rotateDegreeInfo.direction)) {
            AdMatrixInfo.RotateDegreeInfo rotateDegreeInfo2 = this.rotateInfo.f38654y;
            if (!a(1, rotateDegreeInfo2.rotateDegree, rotateDegreeInfo2.direction)) {
                AdMatrixInfo.RotateDegreeInfo rotateDegreeInfo3 = this.rotateInfo.f38655z;
                if (!a(2, rotateDegreeInfo3.rotateDegree, rotateDegreeInfo3.direction)) {
                    return;
                }
            }
        }
        this.aAc = false;
        this.aAh.U(Ft());
    }

    private String Ft() {
        return "{\"x\": " + this.aAf[0] + ",\"y\":" + this.aAf[1] + ",\"z\":" + this.aAf[2] + "}";
    }

    public final void bi(Context context) {
        if (context == null) {
            return;
        }
        Fq();
        this.aAc = true;
        if (this.aAi == null) {
            this.aAi = new a(this, (byte) 0);
        }
        ba.MB().a(2, 2, this.aAi, this.aAj);
    }

    public final synchronized void bj(Context context) {
        if (context != null) {
            if (this.aAi != null) {
                ba.MB().a(this.aAi);
                this.aAi = null;
            }
        }
    }

    public final void a(AdMatrixInfo.RotateInfo rotateInfo) {
        this.rotateInfo = rotateInfo;
    }

    public final void a(@Nullable com.kwad.sdk.core.g.a aVar) {
        this.aAh = aVar;
    }

    private boolean a(int i4, double d4, int i5) {
        if (d4 <= 0.0d || Math.abs(this.aAg[i4]) < d4) {
            return false;
        }
        double[] dArr = this.aAg;
        return (dArr[i4] <= 0.0d || i5 != 1) && (dArr[i4] >= 0.0d || i5 != 2);
    }
}

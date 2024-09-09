package com.kwad.sdk.core.g;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import androidx.annotation.Nullable;
import com.kwad.sdk.components.DevelopMangerComponents;
import com.kwad.sdk.utils.ba;
import java.util.Random;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class d {
    private static float aAm = 9.81f;
    private static double aAn = 0.01d;
    private volatile boolean aAc = true;
    private final ba.b aAj = new ba.b() { // from class: com.kwad.sdk.core.g.d.1
        @Override // com.kwad.sdk.utils.ba.b
        public final void onFailed() {
            if (d.this.aAo != null) {
                d.this.aAo.aV();
            }
        }
    };
    private float aAl;
    @Nullable
    private b aAo;
    @Nullable
    private a aAp;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    class a implements SensorEventListener {
        private boolean aAs;
        private Random awB;
        private final float[] aAr = {0.0f, 0.0f, 9.8f};
        private final float[] aAt = {0.0f, 0.0f, 0.0f};

        public a() {
            this.aAs = false;
            if (((DevelopMangerComponents) com.kwad.sdk.components.c.f(DevelopMangerComponents.class)) != null) {
                this.aAs = false;
            }
        }

        private void Fx() {
            if (this.awB == null) {
                this.awB = new Random();
            }
            if (this.awB.nextInt(100) == 1) {
                a(this.aAr);
            }
        }

        private void a(float[] fArr) {
            c(fArr);
            float f4 = fArr[0];
            float f5 = fArr[1];
            float f6 = fArr[2];
            double abs = Math.abs(Math.sqrt((f4 * f4) + (f5 * f5) + (f6 * f6)));
            if (b(fArr)) {
                double d4 = d.aAm;
                Double.isNaN(d4);
                abs = Math.abs(abs - d4);
            }
            if (!d.this.aAc || abs < d.this.aAl || d.this.aAo == null) {
                return;
            }
            d.a(d.this, false);
            d.this.aAo.a(abs);
        }

        private static boolean b(float[] fArr) {
            double abs = Math.abs(Math.sqrt((fArr[0] * fArr[0]) + (fArr[1] * fArr[1]) + (fArr[2] * fArr[2])));
            double d4 = d.aAm;
            Double.isNaN(d4);
            return Math.abs(abs - d4) <= d.aAn;
        }

        private void c(float[] fArr) {
            float[] fArr2 = this.aAt;
            float f4 = (fArr2[0] == 0.0f && fArr2[1] == 0.0f && fArr2[2] == 0.0f) ? 1.0f : 0.6f;
            float f5 = 1.0f - f4;
            fArr[0] = (fArr[0] * f4) + (fArr2[0] * f5);
            fArr[1] = (fArr[1] * f4) + (fArr2[1] * f5);
            fArr[2] = (f4 * fArr[2]) + (f5 * fArr2[2]);
            System.arraycopy(fArr, 0, fArr2, 0, 3);
        }

        @Override // android.hardware.SensorEventListener
        public final void onAccuracyChanged(Sensor sensor, int i4) {
        }

        @Override // android.hardware.SensorEventListener
        public final void onSensorChanged(SensorEvent sensorEvent) {
            a(sensorEvent.values);
            if (this.aAs) {
                Fx();
            }
        }
    }

    public d(float f4) {
        if (f4 <= 0.0f) {
            this.aAl = 5.0f;
        } else {
            this.aAl = f4;
        }
    }

    public final synchronized void Fu() {
        this.aAc = true;
    }

    public final void bi(Context context) {
        if (context == null) {
            com.kwad.sdk.core.e.c.d("ShakeDetector", "startDetect context is null");
            return;
        }
        this.aAc = true;
        if (this.aAp == null) {
            this.aAp = new a();
        }
        ba.MB().a(1, 2, this.aAp, this.aAj);
    }

    public final synchronized void bj(Context context) {
        if (context != null) {
            if (this.aAp != null) {
                ba.MB().a(this.aAp);
                this.aAp = null;
            }
        }
    }

    public final void e(float f4) {
        this.aAl = f4;
    }

    static /* synthetic */ boolean a(d dVar, boolean z3) {
        dVar.aAc = false;
        return false;
    }

    public final void a(@Nullable b bVar) {
        this.aAo = bVar;
    }
}

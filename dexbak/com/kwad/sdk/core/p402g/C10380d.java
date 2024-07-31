package com.kwad.sdk.core.p402g;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import androidx.annotation.Nullable;
import com.kwad.sdk.components.C9861c;
import com.kwad.sdk.components.DevelopMangerComponents;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.utils.C11040ba;
import java.util.Random;

/* renamed from: com.kwad.sdk.core.g.d */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10380d {
    private static float aAm = 9.81f;
    private static double aAn = 0.01d;
    private volatile boolean aAc = true;
    private final C11040ba.InterfaceC11042b aAj = new C11040ba.InterfaceC11042b() { // from class: com.kwad.sdk.core.g.d.1
        @Override // com.kwad.sdk.utils.C11040ba.InterfaceC11042b
        public final void onFailed() {
            if (C10380d.this.aAo != null) {
                C10380d.this.aAo.mo26219aV();
            }
        }
    };
    private float aAl;
    @Nullable
    private InterfaceC10376b aAo;
    @Nullable
    private C10382a aAp;

    /* renamed from: com.kwad.sdk.core.g.d$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    class C10382a implements SensorEventListener {
        private boolean aAs;
        private Random awB;
        private final float[] aAr = {0.0f, 0.0f, 9.8f};
        private final float[] aAt = {0.0f, 0.0f, 0.0f};

        public C10382a() {
            this.aAs = false;
            if (((DevelopMangerComponents) C9861c.m27501f(DevelopMangerComponents.class)) != null) {
                this.aAs = false;
            }
        }

        /* renamed from: Fx */
        private void m26191Fx() {
            if (this.awB == null) {
                this.awB = new Random();
            }
            if (this.awB.nextInt(100) == 1) {
                m26190a(this.aAr);
            }
        }

        /* renamed from: a */
        private void m26190a(float[] fArr) {
            m26188c(fArr);
            float f = fArr[0];
            float f2 = fArr[1];
            float f3 = fArr[2];
            double abs = Math.abs(Math.sqrt((f * f) + (f2 * f2) + (f3 * f3)));
            if (m26189b(fArr)) {
                double d = C10380d.aAm;
                Double.isNaN(d);
                abs = Math.abs(abs - d);
            }
            if (!C10380d.this.aAc || abs < C10380d.this.aAl || C10380d.this.aAo == null) {
                return;
            }
            C10380d.m26197a(C10380d.this, false);
            C10380d.this.aAo.mo26220a(abs);
        }

        /* renamed from: b */
        private static boolean m26189b(float[] fArr) {
            double abs = Math.abs(Math.sqrt((fArr[0] * fArr[0]) + (fArr[1] * fArr[1]) + (fArr[2] * fArr[2])));
            double d = C10380d.aAm;
            Double.isNaN(d);
            return Math.abs(abs - d) <= C10380d.aAn;
        }

        /* renamed from: c */
        private void m26188c(float[] fArr) {
            float[] fArr2 = this.aAt;
            float f = (fArr2[0] == 0.0f && fArr2[1] == 0.0f && fArr2[2] == 0.0f) ? 1.0f : 0.6f;
            float f2 = 1.0f - f;
            fArr[0] = (fArr[0] * f) + (fArr2[0] * f2);
            fArr[1] = (fArr[1] * f) + (fArr2[1] * f2);
            fArr[2] = (f * fArr[2]) + (f2 * fArr2[2]);
            System.arraycopy(fArr, 0, fArr2, 0, 3);
        }

        @Override // android.hardware.SensorEventListener
        public final void onAccuracyChanged(Sensor sensor, int i) {
        }

        @Override // android.hardware.SensorEventListener
        public final void onSensorChanged(SensorEvent sensorEvent) {
            m26190a(sensorEvent.values);
            if (this.aAs) {
                m26191Fx();
            }
        }
    }

    public C10380d(float f) {
        if (f <= 0.0f) {
            this.aAl = 5.0f;
        } else {
            this.aAl = f;
        }
    }

    /* renamed from: Fu */
    public final synchronized void m26202Fu() {
        this.aAc = true;
    }

    /* renamed from: bi */
    public final void m26195bi(Context context) {
        if (context == null) {
            C10331c.m26254d("ShakeDetector", "startDetect context is null");
            return;
        }
        this.aAc = true;
        if (this.aAp == null) {
            this.aAp = new C10382a();
        }
        C11040ba.m23973MB().m23972a(1, 2, this.aAp, this.aAj);
    }

    /* renamed from: bj */
    public final synchronized void m26194bj(Context context) {
        if (context != null) {
            if (this.aAp != null) {
                C11040ba.m23973MB().m23971a(this.aAp);
                this.aAp = null;
            }
        }
    }

    /* renamed from: e */
    public final void m26192e(float f) {
        this.aAl = f;
    }

    /* renamed from: a */
    static /* synthetic */ boolean m26197a(C10380d c10380d, boolean z) {
        c10380d.aAc = false;
        return false;
    }

    /* renamed from: a */
    public final void m26199a(@Nullable InterfaceC10376b interfaceC10376b) {
        this.aAo = interfaceC10376b;
    }
}

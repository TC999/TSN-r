package com.kwad.sdk.utils;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import com.kwad.sdk.utils.ba;
import java.util.ArrayList;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class bb implements SensorEventListener {
    private final b aPQ;
    private final b aPR;
    private final b aPS;
    private boolean aPT;
    private boolean aPU;
    private final ba.b aPV;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    static class a {
        private static final bb aPX = new bb((byte) 0);
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    static class b {
        private SensorEvent aPY;
        private long timestamp;

        private b() {
        }

        public final void Q(List<com.kwad.sdk.l.a.e> list) {
            if (this.aPY == null) {
                return;
            }
            com.kwad.sdk.l.a.e eVar = new com.kwad.sdk.l.a.e();
            eVar.sensorType = this.aPY.sensor.getType();
            eVar.timestamp = this.timestamp / 1000;
            for (float f4 : this.aPY.values) {
                eVar.aNc.add(Float.valueOf(f4));
            }
            list.add(eVar);
        }

        public final void b(SensorEvent sensorEvent) {
            this.aPY = sensorEvent;
            this.timestamp = System.currentTimeMillis();
        }

        /* synthetic */ b(byte b4) {
            this();
        }
    }

    /* synthetic */ bb(byte b4) {
        this();
    }

    public static bb MC() {
        return a.aPX;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void ME() {
        if (this.aPU) {
            ba.MB().a(this);
            this.aPU = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void register() {
        if (!this.aPT && !this.aPU) {
            this.aPU = true;
            ba.MB().a(3, 3, this, this.aPV);
            ba.MB().a(2, 3, this, this.aPV);
            ba.MB().a(4, 3, this, this.aPV);
        }
    }

    public final synchronized List<com.kwad.sdk.l.a.e> MD() {
        if (o.Ll()) {
            com.kwad.sdk.core.c.b.DD();
            if (com.kwad.sdk.core.c.b.isAppOnForeground()) {
                register();
            }
            ArrayList arrayList = new ArrayList();
            this.aPQ.Q(arrayList);
            this.aPR.Q(arrayList);
            this.aPS.Q(arrayList);
            return arrayList;
        }
        return null;
    }

    @Override // android.hardware.SensorEventListener
    public final void onAccuracyChanged(Sensor sensor, int i4) {
    }

    @Override // android.hardware.SensorEventListener
    public final void onSensorChanged(SensorEvent sensorEvent) {
        int type = sensorEvent.sensor.getType();
        if (type == 1) {
            this.aPQ.b(sensorEvent);
        } else if (type == 4) {
            this.aPR.b(sensorEvent);
        } else if (type != 9) {
        } else {
            this.aPS.b(sensorEvent);
        }
    }

    private bb() {
        this.aPQ = new b((byte) 0);
        this.aPR = new b((byte) 0);
        this.aPS = new b((byte) 0);
        this.aPT = false;
        this.aPV = new ba.b() { // from class: com.kwad.sdk.utils.bb.2
            @Override // com.kwad.sdk.utils.ba.b
            public final void onFailed() {
                bb.a(bb.this, true);
            }
        };
        com.kwad.sdk.core.c.b.DD();
        com.kwad.sdk.core.c.b.a(new com.kwad.sdk.core.c.d() { // from class: com.kwad.sdk.utils.bb.1
            @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
            public final void onBackToBackground() {
                super.onBackToBackground();
                bb.this.ME();
            }

            @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
            public final void onBackToForeground() {
                super.onBackToForeground();
                if (o.Ll()) {
                    bb.this.register();
                }
            }
        });
    }

    static /* synthetic */ boolean a(bb bbVar, boolean z3) {
        bbVar.aPT = true;
        return true;
    }
}

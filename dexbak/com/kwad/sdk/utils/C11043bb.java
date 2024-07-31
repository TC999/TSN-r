package com.kwad.sdk.utils;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import com.kwad.sdk.core.p391c.AbstractC10247d;
import com.kwad.sdk.core.p391c.C10232b;
import com.kwad.sdk.p441l.p442a.C10856e;
import com.kwad.sdk.utils.C11040ba;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.kwad.sdk.utils.bb */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C11043bb implements SensorEventListener {
    private final C11047b aPQ;
    private final C11047b aPR;
    private final C11047b aPS;
    private boolean aPT;
    private boolean aPU;
    private final C11040ba.InterfaceC11042b aPV;

    /* renamed from: com.kwad.sdk.utils.bb$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    static class C11046a {
        private static final C11043bb aPX = new C11043bb((byte) 0);
    }

    /* renamed from: com.kwad.sdk.utils.bb$b */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    static class C11047b {
        private SensorEvent aPY;
        private long timestamp;

        private C11047b() {
        }

        /* renamed from: Q */
        public final void m23956Q(List<C10856e> list) {
            if (this.aPY == null) {
                return;
            }
            C10856e c10856e = new C10856e();
            c10856e.sensorType = this.aPY.sensor.getType();
            c10856e.timestamp = this.timestamp / 1000;
            for (float f : this.aPY.values) {
                c10856e.aNc.add(Float.valueOf(f));
            }
            list.add(c10856e);
        }

        /* renamed from: b */
        public final void m23955b(SensorEvent sensorEvent) {
            this.aPY = sensorEvent;
            this.timestamp = System.currentTimeMillis();
        }

        /* synthetic */ C11047b(byte b) {
            this();
        }
    }

    /* synthetic */ C11043bb(byte b) {
        this();
    }

    /* renamed from: MC */
    public static C11043bb m23963MC() {
        return C11046a.aPX;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ME */
    public synchronized void m23961ME() {
        if (this.aPU) {
            C11040ba.m23973MB().m23971a(this);
            this.aPU = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void register() {
        if (!this.aPT && !this.aPU) {
            this.aPU = true;
            C11040ba.m23973MB().m23972a(3, 3, this, this.aPV);
            C11040ba.m23973MB().m23972a(2, 3, this, this.aPV);
            C11040ba.m23973MB().m23972a(4, 3, this, this.aPV);
        }
    }

    /* renamed from: MD */
    public final synchronized List<C10856e> m23962MD() {
        if (C11120o.m23759Ll()) {
            C10232b.m26625DD();
            if (C10232b.isAppOnForeground()) {
                register();
            }
            ArrayList arrayList = new ArrayList();
            this.aPQ.m23956Q(arrayList);
            this.aPR.m23956Q(arrayList);
            this.aPS.m23956Q(arrayList);
            return arrayList;
        }
        return null;
    }

    @Override // android.hardware.SensorEventListener
    public final void onAccuracyChanged(Sensor sensor, int i) {
    }

    @Override // android.hardware.SensorEventListener
    public final void onSensorChanged(SensorEvent sensorEvent) {
        int type = sensorEvent.sensor.getType();
        if (type == 1) {
            this.aPQ.m23955b(sensorEvent);
        } else if (type == 4) {
            this.aPR.m23955b(sensorEvent);
        } else if (type != 9) {
        } else {
            this.aPS.m23955b(sensorEvent);
        }
    }

    private C11043bb() {
        this.aPQ = new C11047b((byte) 0);
        this.aPR = new C11047b((byte) 0);
        this.aPS = new C11047b((byte) 0);
        this.aPT = false;
        this.aPV = new C11040ba.InterfaceC11042b() { // from class: com.kwad.sdk.utils.bb.2
            @Override // com.kwad.sdk.utils.C11040ba.InterfaceC11042b
            public final void onFailed() {
                C11043bb.m23959a(C11043bb.this, true);
            }
        };
        C10232b.m26625DD();
        C10232b.m26622a(new AbstractC10247d() { // from class: com.kwad.sdk.utils.bb.1
            @Override // com.kwad.sdk.core.p391c.AbstractC10247d, com.kwad.sdk.core.p391c.InterfaceC10246c
            public final void onBackToBackground() {
                super.onBackToBackground();
                C11043bb.this.m23961ME();
            }

            @Override // com.kwad.sdk.core.p391c.AbstractC10247d, com.kwad.sdk.core.p391c.InterfaceC10246c
            public final void onBackToForeground() {
                super.onBackToForeground();
                if (C11120o.m23759Ll()) {
                    C11043bb.this.register();
                }
            }
        });
    }

    /* renamed from: a */
    static /* synthetic */ boolean m23959a(C11043bb c11043bb, boolean z) {
        c11043bb.aPT = true;
        return true;
    }
}

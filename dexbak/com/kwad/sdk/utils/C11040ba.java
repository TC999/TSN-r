package com.kwad.sdk.utils;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.service.ServiceProvider;
import com.umeng.analytics.pro.UMCommonContent;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;

/* renamed from: com.kwad.sdk.utils.ba */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C11040ba {
    private static volatile C11040ba aPM;
    private SensorManager aPN;
    private final Map<String, C11041a> aPO = new ConcurrentHashMap();
    private final Map<String, CopyOnWriteArraySet<SensorEventListener>> aPP = new ConcurrentHashMap();

    /* renamed from: com.kwad.sdk.utils.ba$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class C11041a implements SensorEventListener {

        /* renamed from: XV */
        private final WeakReference<C11040ba> f29676XV;
        private final String key;

        public C11041a(String str, C11040ba c11040ba) {
            this.key = str;
            this.f29676XV = new WeakReference<>(c11040ba);
        }

        @Override // android.hardware.SensorEventListener
        public final void onAccuracyChanged(Sensor sensor, int i) {
        }

        @Override // android.hardware.SensorEventListener
        public final void onSensorChanged(SensorEvent sensorEvent) {
            C11040ba c11040ba = this.f29676XV.get();
            if (c11040ba != null) {
                c11040ba.m23968a(this.key, sensorEvent);
            }
        }
    }

    /* renamed from: com.kwad.sdk.utils.ba$b */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public interface InterfaceC11042b {
        void onFailed();
    }

    private C11040ba() {
    }

    /* renamed from: A */
    private static String m23974A(int i, int i2) {
        return i + "_" + i2;
    }

    @NonNull
    /* renamed from: MB */
    public static C11040ba m23973MB() {
        if (aPM == null) {
            synchronized (C11040ba.class) {
                if (aPM == null) {
                    aPM = new C11040ba();
                }
            }
        }
        return aPM;
    }

    @Nullable
    /* renamed from: eb */
    private Sensor m23967eb(int i) {
        if (getSensorManager() == null) {
            return null;
        }
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        return null;
                    }
                    return getSensorManager().getDefaultSensor(9);
                }
                return getSensorManager().getDefaultSensor(1);
            }
            return getSensorManager().getDefaultSensor(4);
        }
        return getSensorManager().getDefaultSensor(10);
    }

    /* renamed from: ec */
    private static int m23966ec(int i) {
        if (i != -3) {
            if (i != -2) {
                return i != -1 ? 3 : 0;
            }
            return 1;
        }
        return 2;
    }

    /* renamed from: gM */
    private void m23965gM(String str) {
        C11041a c11041a = this.aPO.get(str);
        if (c11041a != null) {
            this.aPO.remove(str);
            getSensorManager().unregisterListener(c11041a);
        }
    }

    /* renamed from: gN */
    private C11041a m23964gN(String str) {
        C11041a c11041a = this.aPO.get(str);
        if (c11041a == null) {
            C11041a c11041a2 = new C11041a(str, this);
            this.aPO.put(str, c11041a2);
            return c11041a2;
        }
        return c11041a;
    }

    private SensorManager getSensorManager() {
        if (this.aPN == null) {
            this.aPN = (SensorManager) ServiceProvider.getContext().getSystemService(UMCommonContent.f37799ac);
        }
        return this.aPN;
    }

    /* renamed from: a */
    public final synchronized void m23972a(int i, int i2, SensorEventListener sensorEventListener, InterfaceC11042b interfaceC11042b) {
        Sensor m23967eb = m23967eb(i);
        if (m23967eb == null) {
            if (interfaceC11042b != null) {
                interfaceC11042b.onFailed();
            }
            return;
        }
        String m23974A = m23974A(i, i2);
        CopyOnWriteArraySet<SensorEventListener> copyOnWriteArraySet = this.aPP.get(m23974A);
        if (copyOnWriteArraySet == null) {
            copyOnWriteArraySet = new CopyOnWriteArraySet<>();
        }
        copyOnWriteArraySet.add(sensorEventListener);
        if (copyOnWriteArraySet.size() == 1) {
            this.aPP.put(m23974A, copyOnWriteArraySet);
            m23969a(m23974A, i2, m23967eb);
        }
    }

    /* renamed from: a */
    public final synchronized void m23971a(SensorEventListener sensorEventListener) {
        for (Map.Entry<String, CopyOnWriteArraySet<SensorEventListener>> entry : this.aPP.entrySet()) {
            CopyOnWriteArraySet<SensorEventListener> value = entry.getValue();
            Iterator<SensorEventListener> it = value.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                SensorEventListener next = it.next();
                if (next.equals(sensorEventListener)) {
                    value.remove(next);
                    break;
                }
            }
            if (value.size() == 0) {
                m23965gM(entry.getKey());
            }
        }
    }

    /* renamed from: a */
    private void m23969a(String str, int i, Sensor sensor) {
        getSensorManager().registerListener(m23964gN(str), sensor, m23966ec(i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m23968a(String str, SensorEvent sensorEvent) {
        CopyOnWriteArraySet<SensorEventListener> copyOnWriteArraySet = this.aPP.get(str);
        if (copyOnWriteArraySet != null) {
            Iterator<SensorEventListener> it = copyOnWriteArraySet.iterator();
            while (it.hasNext()) {
                it.next().onSensorChanged(sensorEvent);
            }
        }
    }
}

package com.kwad.sdk.utils;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.service.ServiceProvider;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class ba {
    private static volatile ba aPM;
    private SensorManager aPN;
    private final Map<String, a> aPO = new ConcurrentHashMap();
    private final Map<String, CopyOnWriteArraySet<SensorEventListener>> aPP = new ConcurrentHashMap();

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public static class a implements SensorEventListener {
        private final WeakReference<ba> XV;
        private final String key;

        public a(String str, ba baVar) {
            this.key = str;
            this.XV = new WeakReference<>(baVar);
        }

        @Override // android.hardware.SensorEventListener
        public final void onAccuracyChanged(Sensor sensor, int i4) {
        }

        @Override // android.hardware.SensorEventListener
        public final void onSensorChanged(SensorEvent sensorEvent) {
            ba baVar = this.XV.get();
            if (baVar != null) {
                baVar.a(this.key, sensorEvent);
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public interface b {
        void onFailed();
    }

    private ba() {
    }

    private static String A(int i4, int i5) {
        return i4 + "_" + i5;
    }

    @NonNull
    public static ba MB() {
        if (aPM == null) {
            synchronized (ba.class) {
                if (aPM == null) {
                    aPM = new ba();
                }
            }
        }
        return aPM;
    }

    @Nullable
    private Sensor eb(int i4) {
        if (getSensorManager() == null) {
            return null;
        }
        if (i4 != 1) {
            if (i4 != 2) {
                if (i4 != 3) {
                    if (i4 != 4) {
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

    private static int ec(int i4) {
        if (i4 != -3) {
            if (i4 != -2) {
                return i4 != -1 ? 3 : 0;
            }
            return 1;
        }
        return 2;
    }

    private void gM(String str) {
        a aVar = this.aPO.get(str);
        if (aVar != null) {
            this.aPO.remove(str);
            getSensorManager().unregisterListener(aVar);
        }
    }

    private a gN(String str) {
        a aVar = this.aPO.get(str);
        if (aVar == null) {
            a aVar2 = new a(str, this);
            this.aPO.put(str, aVar2);
            return aVar2;
        }
        return aVar;
    }

    private SensorManager getSensorManager() {
        if (this.aPN == null) {
            this.aPN = (SensorManager) ServiceProvider.getContext().getSystemService("sensor");
        }
        return this.aPN;
    }

    public final synchronized void a(int i4, int i5, SensorEventListener sensorEventListener, b bVar) {
        Sensor eb = eb(i4);
        if (eb == null) {
            if (bVar != null) {
                bVar.onFailed();
            }
            return;
        }
        String A = A(i4, i5);
        CopyOnWriteArraySet<SensorEventListener> copyOnWriteArraySet = this.aPP.get(A);
        if (copyOnWriteArraySet == null) {
            copyOnWriteArraySet = new CopyOnWriteArraySet<>();
        }
        copyOnWriteArraySet.add(sensorEventListener);
        if (copyOnWriteArraySet.size() == 1) {
            this.aPP.put(A, copyOnWriteArraySet);
            a(A, i5, eb);
        }
    }

    public final synchronized void a(SensorEventListener sensorEventListener) {
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
                gM(entry.getKey());
            }
        }
    }

    private void a(String str, int i4, Sensor sensor) {
        getSensorManager().registerListener(gN(str), sensor, ec(i4));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, SensorEvent sensorEvent) {
        CopyOnWriteArraySet<SensorEventListener> copyOnWriteArraySet = this.aPP.get(str);
        if (copyOnWriteArraySet != null) {
            Iterator<SensorEventListener> it = copyOnWriteArraySet.iterator();
            while (it.hasNext()) {
                it.next().onSensorChanged(sensorEvent);
            }
        }
    }
}

package com.qq.e.comm.plugin.k0.f;

import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.qq.e.comm.plugin.n0.v;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public interface e extends com.qq.e.comm.plugin.k0.b, SensorEventListener {

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public static class a {
        public static e a(int i4, int i5, int i6) {
            e eVar;
            SensorManager sensorManager = (SensorManager) com.qq.e.comm.plugin.d0.a.d().a().getSystemService("sensor");
            if (sensorManager == null) {
                return null;
            }
            Sensor a4 = com.qq.e.comm.plugin.k0.a.b().a(4);
            Sensor a5 = com.qq.e.comm.plugin.k0.a.b().a(9);
            int i7 = 1;
            Sensor a6 = com.qq.e.comm.plugin.k0.a.b().a(1);
            Sensor a7 = com.qq.e.comm.plugin.k0.a.b().a(2);
            if (a4 != null) {
                eVar = new c(sensorManager, a4, i4, i5, i6);
            } else if (a5 != null && a7 != null) {
                eVar = new b(sensorManager, a5, a7, i4, i5, i6);
                i7 = 2;
            } else if (a6 != null && a7 != null) {
                eVar = new b(sensorManager, a6, a7, i4, i5, i6);
                i7 = 3;
            } else {
                b bVar = new b(sensorManager, null, null, i4, i5, i6);
                com.qq.e.comm.plugin.k0.a.b().a(bVar);
                eVar = bVar;
                i7 = 4;
            }
            v.a(9130011, null, Integer.valueOf(i7));
            return eVar;
        }
    }

    void a(int i4);

    void a(Sensor sensor, Sensor sensor2);

    void a(d dVar);
}

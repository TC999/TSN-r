package com.qq.e.comm.plugin.k0;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import com.qq.e.comm.plugin.k0.f.e;
import com.qq.e.comm.plugin.util.d1;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class a {

    /* renamed from: g  reason: collision with root package name */
    private static volatile a f44518g;

    /* renamed from: f  reason: collision with root package name */
    private CopyOnWriteArrayList<WeakReference<e>> f44524f;

    /* renamed from: b  reason: collision with root package name */
    private AtomicBoolean f44520b = new AtomicBoolean(false);

    /* renamed from: e  reason: collision with root package name */
    private final int[] f44523e = {4, 2, 9, 1};

    /* renamed from: d  reason: collision with root package name */
    private ConcurrentHashMap<Integer, Sensor> f44522d = new ConcurrentHashMap<>();

    /* renamed from: a  reason: collision with root package name */
    private SensorManager f44519a = (SensorManager) com.qq.e.comm.plugin.d0.a.d().a().getSystemService("sensor");

    /* renamed from: c  reason: collision with root package name */
    private int f44521c = com.qq.e.comm.plugin.d0.a.d().f().a("sotms", 0);

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public final class b implements Runnable {

        /* renamed from: c  reason: collision with root package name */
        private int f44525c;

        @Override // java.lang.Runnable
        public void run() {
            int i4 = this.f44525c;
            if (i4 < 0 || i4 > a.this.f44523e.length - 1) {
                return;
            }
            Sensor defaultSensor = a.this.f44519a.getDefaultSensor(a.this.f44523e[this.f44525c]);
            if (defaultSensor != null) {
                a.this.f44522d.put(Integer.valueOf(defaultSensor.getType()), defaultSensor);
            }
            if (this.f44525c == a.this.f44523e.length - 1) {
                a.this.d();
            }
        }

        private b(int i4) {
            this.f44525c = i4;
        }
    }

    private a() {
    }

    public static a b() {
        if (f44518g == null) {
            synchronized (a.class) {
                if (f44518g == null) {
                    f44518g = new a();
                }
            }
        }
        return f44518g;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        Sensor sensor;
        d1.a("gdt_tag_sensor", "GDTSensorManager notifyListener");
        CopyOnWriteArrayList<WeakReference<e>> copyOnWriteArrayList = this.f44524f;
        if (copyOnWriteArrayList == null || copyOnWriteArrayList.size() == 0 || (sensor = this.f44522d.get(2)) == null) {
            return;
        }
        Sensor sensor2 = this.f44522d.get(9);
        Sensor sensor3 = this.f44522d.get(1);
        if (sensor2 == null) {
            sensor2 = sensor3;
        }
        if (sensor2 == null) {
            return;
        }
        Iterator<WeakReference<e>> it = this.f44524f.iterator();
        while (it.hasNext()) {
            e eVar = it.next().get();
            if (eVar != null) {
                eVar.a(sensor2, sensor);
            }
        }
    }

    public Sensor a(int i4) {
        SensorManager sensorManager;
        if (a() && (sensorManager = this.f44519a) != null) {
            return sensorManager.getDefaultSensor(i4);
        }
        c();
        return this.f44522d.get(Integer.valueOf(i4));
    }

    public void c() {
        if (this.f44520b.getAndSet(true)) {
            return;
        }
        if (this.f44519a == null) {
            this.f44519a = (SensorManager) com.qq.e.comm.plugin.d0.a.d().a().getSystemService("sensor");
        }
        if (this.f44519a == null) {
            return;
        }
        if (com.qq.e.comm.plugin.d0.a.d().f().a("sole", 0) == 1) {
            d1.a("gdt_tag_sensor", "GDTSensorManager initSensor mSensorManager.getSensorList(Sensor.TYPE_ALL)");
            List<Sensor> sensorList = this.f44519a.getSensorList(-1);
            if (sensorList != null && sensorList.size() > 0) {
                for (Sensor sensor : sensorList) {
                    int type = sensor.getType();
                    int[] iArr = this.f44523e;
                    if (type == iArr[0] || type == iArr[1] || type == iArr[2] || type == iArr[3]) {
                        this.f44522d.put(Integer.valueOf(type), sensor);
                    }
                }
            }
            d();
        } else if (!a()) {
            d1.a("gdt_tag_sensor", "GDTSensorManager initSensor mSensorManager.getDefaultSensor()");
            int[] iArr2 = this.f44523e;
            int length = iArr2.length;
            if (length == 0) {
                return;
            }
            Sensor defaultSensor = this.f44519a.getDefaultSensor(iArr2[0]);
            if (defaultSensor != null) {
                this.f44522d.put(Integer.valueOf(defaultSensor.getType()), defaultSensor);
            }
            for (int i4 = 1; i4 < length; i4++) {
                com.qq.e.dl.j.d.b().postDelayed(new b(i4), this.f44521c * i4);
            }
        }
    }

    private boolean a() {
        return this.f44521c <= 0;
    }

    public void a(e eVar) {
        if (this.f44524f == null) {
            this.f44524f = new CopyOnWriteArrayList<>();
        }
        if (eVar != null) {
            this.f44524f.add(new WeakReference<>(eVar));
        }
    }
}

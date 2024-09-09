package com.bytedance.sdk.openadsdk.bk;

import android.content.Context;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Vibrator;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class p {

    /* renamed from: c  reason: collision with root package name */
    public static c f31614c;

    /* renamed from: f  reason: collision with root package name */
    private static SensorManager f31615f;

    /* renamed from: w  reason: collision with root package name */
    protected static final float[] f31616w = new float[3];
    protected static final float[] xv = new float[3];
    protected static final float[] sr = new float[9];
    protected static final float[] ux = new float[3];

    private static int c(int i4) {
        if (i4 == 0 || i4 == 1 || i4 == 2 || i4 == 3) {
            return i4;
        }
        return 2;
    }

    public static void c(c cVar) {
        f31614c = cVar;
    }

    public static void sr(Context context, SensorEventListener sensorEventListener, int i4) {
        if (sensorEventListener == null || context == null) {
            return;
        }
        try {
            c cVar = f31614c;
            if (cVar != null && cVar.ev()) {
                f31614c.c(context, sensorEventListener, 1, c(i4));
                f31614c.c(context, sensorEventListener, 2, c(i4));
            } else {
                SensorManager c4 = c(context);
                c4.registerListener(sensorEventListener, c4.getDefaultSensor(1), c(i4));
                c4.registerListener(sensorEventListener, c4.getDefaultSensor(2), c(i4));
            }
        } catch (Throwable th) {
            r.c("SensorHub", "startListenRotationVector err", th);
        }
    }

    public static void w(Context context, SensorEventListener sensorEventListener, int i4) {
        if (sensorEventListener == null || context == null) {
            return;
        }
        try {
            c cVar = f31614c;
            if (cVar != null && cVar.ev()) {
                f31614c.c(context, sensorEventListener, 4, c(i4));
            } else {
                SensorManager c4 = c(context);
                c4.registerListener(sensorEventListener, c4.getDefaultSensor(4), c(i4));
            }
        } catch (Throwable th) {
            r.c("SensorHub", "startListenGyroscope error", th);
        }
    }

    public static void xv(Context context, SensorEventListener sensorEventListener, int i4) {
        if (sensorEventListener == null || context == null) {
            return;
        }
        try {
            c cVar = f31614c;
            if (cVar != null && cVar.ev()) {
                f31614c.c(context, sensorEventListener, 10, c(i4));
            } else {
                SensorManager c4 = c(context);
                c4.registerListener(sensorEventListener, c4.getDefaultSensor(10), c(i4));
            }
        } catch (Throwable th) {
            r.c("SensorHub", "startListenLinearAcceleration error", th);
        }
    }

    private static SensorManager c(Context context) {
        if (f31615f == null) {
            synchronized (p.class) {
                if (f31615f == null) {
                    f31615f = (SensorManager) context.getSystemService("sensor");
                }
            }
        }
        return f31615f;
    }

    public static void c(Context context, SensorEventListener sensorEventListener, int i4) {
        if (sensorEventListener == null || context == null) {
            return;
        }
        try {
            c cVar = f31614c;
            if (cVar != null && cVar.ev()) {
                f31614c.c(context, sensorEventListener, 1, c(i4));
            } else {
                SensorManager c4 = c(context);
                c4.registerListener(sensorEventListener, c4.getDefaultSensor(1), c(i4));
            }
        } catch (Throwable th) {
            r.c("SensorHub", "startListenAccelerometer error", th);
        }
    }

    public static void c(Context context, SensorEventListener sensorEventListener) {
        if (sensorEventListener == null || context == null) {
            return;
        }
        try {
            c(context).unregisterListener(sensorEventListener);
        } catch (Throwable th) {
            r.c("SensorHub", "stopListen error", th);
        }
    }

    public static void c(Context context, long j4) {
        if (context == null) {
            return;
        }
        ((Vibrator) context.getSystemService("vibrator")).vibrate(j4);
    }
}

package com.bykv.vk.component.ttvideo.player;

import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.util.Log;

@Keep
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class SensorData {
    protected static final int Sensor_ACC_Data = 1;
    protected static final int Sensor_MAG_Data = 2;
    protected static final int Sensor_ROT_Data = 3;
    private long mHandle = 0;
    private SensorManager mSensorManager = null;
    private SensorEventListener mListener = null;
    private float[] magnet = new float[3];
    private float[] accel = new float[3];

    private static final native void _writeData(long j4, int i4, float f4, float f5, float f6);

    protected void finalize() {
        stop();
    }

    public Boolean initListeners() {
        return Boolean.FALSE;
    }

    @CalledByNative
    public void setHandle(long j4, TTPlayer tTPlayer) {
        this.mHandle = j4;
        tTPlayer.getContext();
    }

    @CalledByNative
    public int start() {
        return initListeners().booleanValue() ? 0 : -1;
    }

    @CalledByNative
    public void stop() {
        Log.e("ttmn", "stop sensor");
        this.mHandle = 0L;
    }
}

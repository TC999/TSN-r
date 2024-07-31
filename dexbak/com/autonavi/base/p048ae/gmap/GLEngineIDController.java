package com.autonavi.base.p048ae.gmap;

import com.clj.fastble.BleManager;

/* renamed from: com.autonavi.base.ae.gmap.GLEngineIDController */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class GLEngineIDController {
    private static final String TAG = "GLEngineIDController";
    private static GLEngineIDController sController = new GLEngineIDController();
    private int engineIDIndex = BleManager.f22896l;

    private GLEngineIDController() {
    }

    public static GLEngineIDController getController() {
        return sController;
    }

    public synchronized int generate() {
        int i;
        i = this.engineIDIndex + 1;
        this.engineIDIndex = i;
        return i;
    }
}

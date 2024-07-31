package com.baidu.idl.face.platform.p049ui.utils;

import android.hardware.Camera;

/* renamed from: com.baidu.idl.face.platform.ui.utils.CameraUtils */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class CameraUtils {
    public static final String TAG = "CameraUtils";

    public static void releaseCamera(Camera camera) {
        try {
            try {
                camera.release();
            } catch (RuntimeException e) {
                e.printStackTrace();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}

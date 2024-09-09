package com.baidu.idl.face.platform.ui.utils;

import android.hardware.Camera;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class CameraUtils {
    public static final String TAG = "CameraUtils";

    public static void releaseCamera(Camera camera) {
        try {
            try {
                camera.release();
            } catch (RuntimeException e4) {
                e4.printStackTrace();
            }
        } catch (Exception e5) {
            e5.printStackTrace();
        }
    }
}

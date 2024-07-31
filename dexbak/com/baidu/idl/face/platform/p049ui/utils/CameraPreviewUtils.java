package com.baidu.idl.face.platform.p049ui.utils;

import android.graphics.Point;
import android.hardware.Camera;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.baidu.idl.face.platform.ui.utils.CameraPreviewUtils */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class CameraPreviewUtils {
    private static final int MAX_PREVIEW_PIXELS = 2073600;
    private static final int MIN_PREVIEW_PIXELS = 307200;
    private static final String TAG = "CameraPreviewUtils";

    public static Point getBestPreview(Camera.Parameters parameters, Point point) {
        double d;
        double d2;
        double d3;
        List<Camera.Size> supportedPreviewSizes = parameters.getSupportedPreviewSizes();
        if (supportedPreviewSizes == null) {
            parameters.getPreviewSize();
            return new Point(640, 480);
        }
        ArrayList arrayList = new ArrayList(supportedPreviewSizes);
        Collections.sort(arrayList, new Comparator<Camera.Size>() { // from class: com.baidu.idl.face.platform.ui.utils.CameraPreviewUtils.1
            @Override // java.util.Comparator
            public int compare(Camera.Size size, Camera.Size size2) {
                int i = size.height * size.width;
                int i2 = size2.height * size2.width;
                if (i2 < i) {
                    return -1;
                }
                return i2 > i ? 1 : 0;
            }
        });
        int i = point.x;
        int i2 = point.y;
        if (i > i2) {
            d = i;
            d2 = i2;
        } else {
            d = i2;
            d2 = i;
        }
        Double.isNaN(d);
        Double.isNaN(d2);
        double d4 = d / d2;
        Camera.Size size = null;
        Iterator it = arrayList.iterator();
        double d5 = -1.0d;
        while (it.hasNext()) {
            Camera.Size size2 = (Camera.Size) it.next();
            int i3 = size2.width;
            int i4 = size2.height;
            int i5 = i3 * i4;
            if (i5 < MIN_PREVIEW_PIXELS) {
                it.remove();
            } else if (i5 > MAX_PREVIEW_PIXELS) {
                it.remove();
            } else if (i4 > i3) {
                it.remove();
            } else if (i4 % 2 == 0 && i3 % 2 == 0) {
                if (i3 > i4) {
                    double d6 = i3;
                    double d7 = i4;
                    Double.isNaN(d6);
                    Double.isNaN(d7);
                    d3 = d6 / d7;
                } else {
                    double d8 = i4;
                    double d9 = i3;
                    Double.isNaN(d8);
                    Double.isNaN(d9);
                    d3 = d8 / d9;
                }
                double abs = Math.abs(d3 - d4);
                boolean z = false;
                if ((d5 == -1.0d && abs <= 0.25d) || (d5 >= abs && abs <= 0.25d)) {
                    z = true;
                }
                if (z) {
                    size = size2;
                    d5 = abs;
                }
            } else {
                it.remove();
            }
        }
        if (size != null) {
            return new Point(size.width, size.height);
        }
        parameters.getPreviewSize();
        return new Point(640, 480);
    }
}

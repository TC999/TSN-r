package com.baidu.idl.face.platform.ui.utils;

import android.graphics.Point;
import android.hardware.Camera;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class CameraPreviewUtils {
    private static final int MAX_PREVIEW_PIXELS = 2073600;
    private static final int MIN_PREVIEW_PIXELS = 307200;
    private static final String TAG = "CameraPreviewUtils";

    public static Point getBestPreview(Camera.Parameters parameters, Point point) {
        double d4;
        double d5;
        double d6;
        List<Camera.Size> supportedPreviewSizes = parameters.getSupportedPreviewSizes();
        if (supportedPreviewSizes == null) {
            parameters.getPreviewSize();
            return new Point(640, 480);
        }
        ArrayList arrayList = new ArrayList(supportedPreviewSizes);
        Collections.sort(arrayList, new Comparator<Camera.Size>() { // from class: com.baidu.idl.face.platform.ui.utils.CameraPreviewUtils.1
            @Override // java.util.Comparator
            public int compare(Camera.Size size, Camera.Size size2) {
                int i4 = size.height * size.width;
                int i5 = size2.height * size2.width;
                if (i5 < i4) {
                    return -1;
                }
                return i5 > i4 ? 1 : 0;
            }
        });
        int i4 = point.x;
        int i5 = point.y;
        if (i4 > i5) {
            d4 = i4;
            d5 = i5;
        } else {
            d4 = i5;
            d5 = i4;
        }
        Double.isNaN(d4);
        Double.isNaN(d5);
        double d7 = d4 / d5;
        Camera.Size size = null;
        Iterator it = arrayList.iterator();
        double d8 = -1.0d;
        while (it.hasNext()) {
            Camera.Size size2 = (Camera.Size) it.next();
            int i6 = size2.width;
            int i7 = size2.height;
            int i8 = i6 * i7;
            if (i8 < 307200) {
                it.remove();
            } else if (i8 > 2073600) {
                it.remove();
            } else if (i7 > i6) {
                it.remove();
            } else if (i7 % 2 == 0 && i6 % 2 == 0) {
                if (i6 > i7) {
                    double d9 = i6;
                    double d10 = i7;
                    Double.isNaN(d9);
                    Double.isNaN(d10);
                    d6 = d9 / d10;
                } else {
                    double d11 = i7;
                    double d12 = i6;
                    Double.isNaN(d11);
                    Double.isNaN(d12);
                    d6 = d11 / d12;
                }
                double abs = Math.abs(d6 - d7);
                boolean z3 = false;
                if ((d8 == -1.0d && abs <= 0.25d) || (d8 >= abs && abs <= 0.25d)) {
                    z3 = true;
                }
                if (z3) {
                    size = size2;
                    d8 = abs;
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

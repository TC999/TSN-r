package cn.bingoogolapple.qrcode.core;

import android.content.Context;
import android.graphics.Point;
import android.hardware.Camera;
import android.view.WindowManager;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* compiled from: CameraConfigurationManager.java */
/* loaded from: E:\TSN-r\205dec\6329136.dex */
final class c {

    /* renamed from: a  reason: collision with root package name */
    private final Context f1605a;

    /* renamed from: b  reason: collision with root package name */
    private Point f1606b;

    /* renamed from: c  reason: collision with root package name */
    private Point f1607c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(Context context) {
        this.f1605a = context;
    }

    private static boolean a(Camera camera) {
        return e(camera.getParameters().getSupportedFocusModes(), "auto") != null;
    }

    private void c(Camera camera, boolean z3) {
        String e4;
        Camera.Parameters parameters = camera.getParameters();
        if (z3) {
            e4 = e(parameters.getSupportedFlashModes(), "torch", "on");
        } else {
            e4 = e(parameters.getSupportedFlashModes(), "off");
        }
        if (e4 != null) {
            parameters.setFlashMode(e4);
        }
        camera.setParameters(parameters);
    }

    private static Point d(List<Camera.Size> list, Point point) {
        Iterator<Camera.Size> it = list.iterator();
        int i4 = 0;
        int i5 = 0;
        int i6 = Integer.MAX_VALUE;
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Camera.Size next = it.next();
            int i7 = next.width;
            int i8 = next.height;
            int abs = Math.abs(i7 - point.x) + Math.abs(i8 - point.y);
            if (abs == 0) {
                i5 = i8;
                i4 = i7;
                break;
            } else if (abs < i6) {
                i5 = i8;
                i4 = i7;
                i6 = abs;
            }
        }
        if (i4 <= 0 || i5 <= 0) {
            return null;
        }
        return new Point(i4, i5);
    }

    private static String e(Collection<String> collection, String... strArr) {
        if (collection != null) {
            for (String str : strArr) {
                if (collection.contains(str)) {
                    return str;
                }
            }
        }
        return null;
    }

    private int g() {
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        int i4 = 0;
        Camera.getCameraInfo(0, cameraInfo);
        WindowManager windowManager = (WindowManager) this.f1605a.getSystemService("window");
        if (windowManager == null) {
            return 0;
        }
        int rotation = windowManager.getDefaultDisplay().getRotation();
        if (rotation != 0) {
            if (rotation == 1) {
                i4 = 90;
            } else if (rotation == 2) {
                i4 = 180;
            } else if (rotation == 3) {
                i4 = 270;
            }
        }
        if (cameraInfo.facing == 1) {
            return (360 - ((cameraInfo.orientation + i4) % 360)) % 360;
        }
        return ((cameraInfo.orientation - i4) + 360) % 360;
    }

    private static Point h(Camera.Parameters parameters, Point point) {
        Point d4 = d(parameters.getSupportedPreviewSizes(), point);
        return d4 == null ? new Point((point.x >> 3) << 3, (point.y >> 3) << 3) : d4;
    }

    private int[] k(Camera camera, float f4) {
        int i4 = (int) (f4 * 1000.0f);
        int[] iArr = null;
        int i5 = Integer.MAX_VALUE;
        for (int[] iArr2 : camera.getParameters().getSupportedPreviewFpsRange()) {
            int abs = Math.abs(i4 - iArr2[0]) + Math.abs(i4 - iArr2[1]);
            if (abs < i5) {
                iArr = iArr2;
                i5 = abs;
            }
        }
        return iArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(Camera camera) {
        c(camera, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Point f() {
        return this.f1606b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i(Camera camera) {
        Point j4 = a.j(this.f1605a);
        Point point = new Point();
        point.x = j4.x;
        point.y = j4.y;
        if (a.m(this.f1605a)) {
            point.x = j4.y;
            point.y = j4.x;
        }
        this.f1607c = h(camera.getParameters(), point);
        if (a.m(this.f1605a)) {
            Point point2 = this.f1607c;
            this.f1606b = new Point(point2.y, point2.x);
            return;
        }
        this.f1606b = this.f1607c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j(Camera camera) {
        c(camera, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void l(Camera camera) {
        Camera.Parameters parameters = camera.getParameters();
        Point point = this.f1607c;
        parameters.setPreviewSize(point.x, point.y);
        int[] k4 = k(camera, 60.0f);
        if (k4 != null) {
            parameters.setPreviewFpsRange(k4[0], k4[1]);
        }
        camera.setDisplayOrientation(g());
        camera.setParameters(parameters);
    }
}

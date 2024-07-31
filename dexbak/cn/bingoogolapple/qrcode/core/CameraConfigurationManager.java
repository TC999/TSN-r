package cn.bingoogolapple.qrcode.core;

import android.content.Context;
import android.graphics.Point;
import android.hardware.Camera;
import android.view.WindowManager;
import com.baidu.idl.face.platform.utils.BitmapUtils;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlinx.coroutines.Debug;

/* renamed from: cn.bingoogolapple.qrcode.core.c */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
final class CameraConfigurationManager {

    /* renamed from: a */
    private final Context f1618a;

    /* renamed from: b */
    private Point f1619b;

    /* renamed from: c */
    private Point f1620c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public CameraConfigurationManager(Context context) {
        this.f1618a = context;
    }

    /* renamed from: a */
    private static boolean m57959a(Camera camera) {
        return m57955e(camera.getParameters().getSupportedFocusModes(), Debug.f43399c) != null;
    }

    /* renamed from: c */
    private void m57957c(Camera camera, boolean z) {
        String m57955e;
        Camera.Parameters parameters = camera.getParameters();
        if (z) {
            m57955e = m57955e(parameters.getSupportedFlashModes(), "torch", Debug.f43400d);
        } else {
            m57955e = m57955e(parameters.getSupportedFlashModes(), Debug.f43401e);
        }
        if (m57955e != null) {
            parameters.setFlashMode(m57955e);
        }
        camera.setParameters(parameters);
    }

    /* renamed from: d */
    private static Point m57956d(List<Camera.Size> list, Point point) {
        Iterator<Camera.Size> it = list.iterator();
        int i = 0;
        int i2 = 0;
        int i3 = Integer.MAX_VALUE;
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Camera.Size next = it.next();
            int i4 = next.width;
            int i5 = next.height;
            int abs = Math.abs(i4 - point.x) + Math.abs(i5 - point.y);
            if (abs == 0) {
                i2 = i5;
                i = i4;
                break;
            } else if (abs < i3) {
                i2 = i5;
                i = i4;
                i3 = abs;
            }
        }
        if (i <= 0 || i2 <= 0) {
            return null;
        }
        return new Point(i, i2);
    }

    /* renamed from: e */
    private static String m57955e(Collection<String> collection, String... strArr) {
        if (collection != null) {
            for (String str : strArr) {
                if (collection.contains(str)) {
                    return str;
                }
            }
        }
        return null;
    }

    /* renamed from: g */
    private int m57953g() {
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        int i = 0;
        Camera.getCameraInfo(0, cameraInfo);
        WindowManager windowManager = (WindowManager) this.f1618a.getSystemService("window");
        if (windowManager == null) {
            return 0;
        }
        int rotation = windowManager.getDefaultDisplay().getRotation();
        if (rotation != 0) {
            if (rotation == 1) {
                i = 90;
            } else if (rotation == 2) {
                i = 180;
            } else if (rotation == 3) {
                i = BitmapUtils.ROTATE270;
            }
        }
        if (cameraInfo.facing == 1) {
            return (360 - ((cameraInfo.orientation + i) % 360)) % 360;
        }
        return ((cameraInfo.orientation - i) + 360) % 360;
    }

    /* renamed from: h */
    private static Point m57952h(Camera.Parameters parameters, Point point) {
        Point m57956d = m57956d(parameters.getSupportedPreviewSizes(), point);
        return m57956d == null ? new Point((point.x >> 3) << 3, (point.y >> 3) << 3) : m57956d;
    }

    /* renamed from: k */
    private int[] m57949k(Camera camera, float f) {
        int i = (int) (f * 1000.0f);
        int[] iArr = null;
        int i2 = Integer.MAX_VALUE;
        for (int[] iArr2 : camera.getParameters().getSupportedPreviewFpsRange()) {
            int abs = Math.abs(i - iArr2[0]) + Math.abs(i - iArr2[1]);
            if (abs < i2) {
                iArr = iArr2;
                i2 = abs;
            }
        }
        return iArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public void m57958b(Camera camera) {
        m57957c(camera, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: f */
    public Point m57954f() {
        return this.f1619b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: i */
    public void m57951i(Camera camera) {
        Point m57967j = BGAQRCodeUtil.m57967j(this.f1618a);
        Point point = new Point();
        point.x = m57967j.x;
        point.y = m57967j.y;
        if (BGAQRCodeUtil.m57964m(this.f1618a)) {
            point.x = m57967j.y;
            point.y = m57967j.x;
        }
        this.f1620c = m57952h(camera.getParameters(), point);
        if (BGAQRCodeUtil.m57964m(this.f1618a)) {
            Point point2 = this.f1620c;
            this.f1619b = new Point(point2.y, point2.x);
            return;
        }
        this.f1619b = this.f1620c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: j */
    public void m57950j(Camera camera) {
        m57957c(camera, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: l */
    public void m57948l(Camera camera) {
        Camera.Parameters parameters = camera.getParameters();
        Point point = this.f1620c;
        parameters.setPreviewSize(point.x, point.y);
        int[] m57949k = m57949k(camera, 60.0f);
        if (m57949k != null) {
            parameters.setPreviewFpsRange(m57949k[0], m57949k[1]);
        }
        camera.setDisplayOrientation(m57953g());
        camera.setParameters(parameters);
    }
}

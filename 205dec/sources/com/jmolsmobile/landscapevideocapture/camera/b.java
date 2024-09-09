package com.jmolsmobile.landscapevideocapture.camera;

import android.annotation.TargetApi;
import android.hardware.Camera;
import android.media.CamcorderProfile;
import android.os.Build;
import android.view.SurfaceHolder;
import com.jmolsmobile.landscapevideocapture.camera.OpenCameraException;
import java.io.IOException;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* compiled from: CameraWrapper.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private final int f37906a;

    /* renamed from: b  reason: collision with root package name */
    private c f37907b;

    public b(c cVar, int i4) {
        this.f37907b = cVar;
        this.f37906a = i4;
    }

    private CamcorderProfile e() {
        CamcorderProfile camcorderProfile = CamcorderProfile.get(1);
        if (camcorderProfile != null) {
            return camcorderProfile;
        }
        CamcorderProfile camcorderProfile2 = CamcorderProfile.get(0);
        if (camcorderProfile2 != null) {
            return camcorderProfile2;
        }
        throw new RuntimeException("No quality level found");
    }

    public void a(int i4, int i5) {
        Camera.Parameters f4 = this.f37907b.f();
        a f5 = f(f4.getSupportedPreviewSizes(), i4, i5);
        f4.setPreviewSize(f5.b(), f5.a());
        f4.setPreviewFormat(17);
        this.f37907b.p(f4);
        this.f37907b.k(g());
        com.jmolsmobile.landscapevideocapture.b.a("VideoCapture_CameraWrapper", "Preview size: " + f5.b() + "x" + f5.a());
    }

    public void b() {
        Camera.Parameters f4 = this.f37907b.f();
        f4.setFocusMode("continuous-video");
        this.f37907b.p(f4);
    }

    public CamcorderProfile c() {
        if (CamcorderProfile.hasProfile(5)) {
            return CamcorderProfile.get(5);
        }
        if (CamcorderProfile.hasProfile(4)) {
            return CamcorderProfile.get(4);
        }
        return e();
    }

    public Camera d() {
        return this.f37907b.e();
    }

    public a f(List<Camera.Size> list, int i4, int i5) {
        double d4 = i4;
        double d5 = i5;
        Double.isNaN(d4);
        Double.isNaN(d5);
        double d6 = d4 / d5;
        Camera.Size size = null;
        if (list == null) {
            return null;
        }
        double d7 = Double.MAX_VALUE;
        double d8 = Double.MAX_VALUE;
        for (Camera.Size size2 : list) {
            double d9 = size2.width;
            double d10 = size2.height;
            Double.isNaN(d9);
            Double.isNaN(d10);
            if (Math.abs((d9 / d10) - d6) <= 0.1d && Math.abs(size2.height - i5) < d8) {
                d8 = Math.abs(size2.height - i5);
                size = size2;
            }
        }
        if (size == null) {
            for (Camera.Size size3 : list) {
                if (Math.abs(size3.height - i5) < d7) {
                    size = size3;
                    d7 = Math.abs(size3.height - i5);
                }
            }
        }
        return new a(size.width, size.height);
    }

    public int g() {
        int i4 = this.f37906a * 90;
        if (this.f37907b.h()) {
            return (360 - ((this.f37907b.b() + i4) % 360)) % 360;
        }
        return ((this.f37907b.b() - i4) + 360) % 360;
    }

    public d h(int i4, int i5) {
        a f4 = f(i(Build.VERSION.SDK_INT), i4, i5);
        if (f4 == null) {
            com.jmolsmobile.landscapevideocapture.b.b("VideoCapture_CameraWrapper", "Failed to find supported recording size - falling back to requested: " + i4 + "x" + i5);
            return new d(i4, i5);
        }
        com.jmolsmobile.landscapevideocapture.b.a("VideoCapture_CameraWrapper", "Recording size: " + f4.b() + "x" + f4.a());
        return new d(f4.b(), f4.a());
    }

    @TargetApi(11)
    protected List<Camera.Size> i(int i4) {
        Camera.Parameters f4 = this.f37907b.f();
        if (i4 < 11) {
            com.jmolsmobile.landscapevideocapture.b.b("VideoCapture_CameraWrapper", "Using supportedPreviewSizes iso supportedVideoSizes due to API restriction");
            return f4.getSupportedPreviewSizes();
        } else if (f4.getSupportedVideoSizes() == null) {
            com.jmolsmobile.landscapevideocapture.b.b("VideoCapture_CameraWrapper", "Using supportedPreviewSizes because supportedVideoSizes is null");
            return f4.getSupportedPreviewSizes();
        } else {
            return f4.getSupportedVideoSizes();
        }
    }

    public void j(boolean z3) throws OpenCameraException {
        try {
            this.f37907b.i(z3);
            if (this.f37907b.e() == null) {
                throw new OpenCameraException(OpenCameraException.OpenType.NOCAMERA);
            }
        } catch (RuntimeException e4) {
            e4.printStackTrace();
            throw new OpenCameraException(OpenCameraException.OpenType.INUSE);
        }
    }

    public void k() throws PrepareCameraException {
        try {
            this.f37907b.o();
        } catch (RuntimeException e4) {
            e4.printStackTrace();
            throw new PrepareCameraException();
        }
    }

    public void l() {
        if (d() == null) {
            return;
        }
        this.f37907b.j();
    }

    public void m(SurfaceHolder surfaceHolder) throws IOException {
        this.f37907b.l(surfaceHolder);
        this.f37907b.m();
    }

    public void n() throws Exception {
        this.f37907b.n();
        this.f37907b.a();
    }
}

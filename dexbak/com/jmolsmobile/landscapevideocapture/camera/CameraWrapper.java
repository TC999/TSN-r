package com.jmolsmobile.landscapevideocapture.camera;

import android.annotation.TargetApi;
import android.hardware.Camera;
import android.media.CamcorderProfile;
import android.os.Build;
import android.view.SurfaceHolder;
import com.jmolsmobile.landscapevideocapture.CLog;
import com.jmolsmobile.landscapevideocapture.camera.OpenCameraException;
import java.io.IOException;
import java.util.List;

/* renamed from: com.jmolsmobile.landscapevideocapture.camera.b */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class CameraWrapper {

    /* renamed from: a */
    private final int f24358a;

    /* renamed from: b */
    private NativeCamera f24359b;

    public CameraWrapper(NativeCamera nativeCamera, int i) {
        this.f24359b = nativeCamera;
        this.f24358a = i;
    }

    /* renamed from: e */
    private CamcorderProfile m34540e() {
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

    /* renamed from: a */
    public void m34544a(int i, int i2) {
        Camera.Parameters m34525f = this.f24359b.m34525f();
        CameraSize m34539f = m34539f(m34525f.getSupportedPreviewSizes(), i, i2);
        m34525f.setPreviewSize(m34539f.m34545b(), m34539f.m34546a());
        m34525f.setPreviewFormat(17);
        this.f24359b.m34515p(m34525f);
        this.f24359b.m34520k(m34538g());
        CLog.m34554a(CLog.f24348f, "Preview size: " + m34539f.m34545b() + "x" + m34539f.m34546a());
    }

    /* renamed from: b */
    public void m34543b() {
        Camera.Parameters m34525f = this.f24359b.m34525f();
        m34525f.setFocusMode("continuous-video");
        this.f24359b.m34515p(m34525f);
    }

    /* renamed from: c */
    public CamcorderProfile m34542c() {
        if (CamcorderProfile.hasProfile(5)) {
            return CamcorderProfile.get(5);
        }
        if (CamcorderProfile.hasProfile(4)) {
            return CamcorderProfile.get(4);
        }
        return m34540e();
    }

    /* renamed from: d */
    public Camera m34541d() {
        return this.f24359b.m34526e();
    }

    /* renamed from: f */
    public CameraSize m34539f(List<Camera.Size> list, int i, int i2) {
        double d = i;
        double d2 = i2;
        Double.isNaN(d);
        Double.isNaN(d2);
        double d3 = d / d2;
        Camera.Size size = null;
        if (list == null) {
            return null;
        }
        double d4 = Double.MAX_VALUE;
        double d5 = Double.MAX_VALUE;
        for (Camera.Size size2 : list) {
            double d6 = size2.width;
            double d7 = size2.height;
            Double.isNaN(d6);
            Double.isNaN(d7);
            if (Math.abs((d6 / d7) - d3) <= 0.1d && Math.abs(size2.height - i2) < d5) {
                d5 = Math.abs(size2.height - i2);
                size = size2;
            }
        }
        if (size == null) {
            for (Camera.Size size3 : list) {
                if (Math.abs(size3.height - i2) < d4) {
                    size = size3;
                    d4 = Math.abs(size3.height - i2);
                }
            }
        }
        return new CameraSize(size.width, size.height);
    }

    /* renamed from: g */
    public int m34538g() {
        int i = this.f24358a * 90;
        if (this.f24359b.m34523h()) {
            return (360 - ((this.f24359b.m34529b() + i) % 360)) % 360;
        }
        return ((this.f24359b.m34529b() - i) + 360) % 360;
    }

    /* renamed from: h */
    public RecordingSize m34537h(int i, int i2) {
        CameraSize m34539f = m34539f(m34536i(Build.VERSION.SDK_INT), i, i2);
        if (m34539f == null) {
            CLog.m34553b(CLog.f24348f, "Failed to find supported recording size - falling back to requested: " + i + "x" + i2);
            return new RecordingSize(i, i2);
        }
        CLog.m34554a(CLog.f24348f, "Recording size: " + m34539f.m34545b() + "x" + m34539f.m34546a());
        return new RecordingSize(m34539f.m34545b(), m34539f.m34546a());
    }

    @TargetApi(11)
    /* renamed from: i */
    protected List<Camera.Size> m34536i(int i) {
        Camera.Parameters m34525f = this.f24359b.m34525f();
        if (i < 11) {
            CLog.m34553b(CLog.f24348f, "Using supportedPreviewSizes iso supportedVideoSizes due to API restriction");
            return m34525f.getSupportedPreviewSizes();
        } else if (m34525f.getSupportedVideoSizes() == null) {
            CLog.m34553b(CLog.f24348f, "Using supportedPreviewSizes because supportedVideoSizes is null");
            return m34525f.getSupportedPreviewSizes();
        } else {
            return m34525f.getSupportedVideoSizes();
        }
    }

    /* renamed from: j */
    public void m34535j(boolean z) throws OpenCameraException {
        try {
            this.f24359b.m34522i(z);
            if (this.f24359b.m34526e() == null) {
                throw new OpenCameraException(OpenCameraException.OpenType.NOCAMERA);
            }
        } catch (RuntimeException e) {
            e.printStackTrace();
            throw new OpenCameraException(OpenCameraException.OpenType.INUSE);
        }
    }

    /* renamed from: k */
    public void m34534k() throws PrepareCameraException {
        try {
            this.f24359b.m34516o();
        } catch (RuntimeException e) {
            e.printStackTrace();
            throw new PrepareCameraException();
        }
    }

    /* renamed from: l */
    public void m34533l() {
        if (m34541d() == null) {
            return;
        }
        this.f24359b.m34521j();
    }

    /* renamed from: m */
    public void m34532m(SurfaceHolder surfaceHolder) throws IOException {
        this.f24359b.m34519l(surfaceHolder);
        this.f24359b.m34518m();
    }

    /* renamed from: n */
    public void m34531n() throws Exception {
        this.f24359b.m34517n();
        this.f24359b.m34530a();
    }
}

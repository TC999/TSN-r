package com.jmolsmobile.landscapevideocapture.preview;

import android.hardware.Camera;
import android.view.SurfaceHolder;
import com.jmolsmobile.landscapevideocapture.CLog;
import com.jmolsmobile.landscapevideocapture.camera.CameraWrapper;
import java.io.IOException;

/* renamed from: com.jmolsmobile.landscapevideocapture.preview.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class CapturePreview implements SurfaceHolder.Callback {

    /* renamed from: a */
    private boolean f24418a = false;

    /* renamed from: b */
    private final CapturePreviewInterface f24419b;

    /* renamed from: c */
    public final CameraWrapper f24420c;

    public CapturePreview(CapturePreviewInterface capturePreviewInterface, CameraWrapper cameraWrapper, SurfaceHolder surfaceHolder) {
        this.f24419b = capturePreviewInterface;
        this.f24420c = cameraWrapper;
        m34484a(surfaceHolder);
    }

    /* renamed from: a */
    private void m34484a(SurfaceHolder surfaceHolder) {
        surfaceHolder.removeCallback(this);
        surfaceHolder.addCallback(this);
        surfaceHolder.setType(3);
    }

    /* renamed from: b */
    public static boolean m34483b() {
        for (int i = 0; i < Camera.getNumberOfCameras(); i++) {
            Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
            Camera.getCameraInfo(i, cameraInfo);
            if (cameraInfo.facing == 1) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: c */
    public void m34482c() {
        if (this.f24418a) {
            try {
                this.f24420c.m34531n();
                m34481d(false);
            } catch (Exception e) {
                e.printStackTrace();
                CLog.m34553b(CLog.f24345c, "Failed to clean up preview resources");
            }
        }
    }

    /* renamed from: d */
    protected void m34481d(boolean z) {
        this.f24418a = z;
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        if (this.f24418a) {
            try {
                this.f24420c.m34531n();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        try {
            this.f24420c.m34544a(i2, i3);
            CLog.m34554a(CLog.f24345c, "Configured camera for preview in surface of " + i2 + " by " + i3);
            try {
                this.f24420c.m34543b();
            } catch (RuntimeException e2) {
                e2.printStackTrace();
                CLog.m34554a(CLog.f24345c, "AutoFocus not available for preview");
            }
            try {
                this.f24420c.m34532m(surfaceHolder);
                m34481d(true);
            } catch (IOException e3) {
                e3.printStackTrace();
                CLog.m34554a(CLog.f24345c, "Failed to show preview - unable to connect camera to preview (IOException)");
                this.f24419b.mo34480a();
            } catch (RuntimeException e4) {
                e4.printStackTrace();
                CLog.m34554a(CLog.f24345c, "Failed to show preview - unable to start camera preview (RuntimeException)");
                this.f24419b.mo34480a();
            }
        } catch (RuntimeException e5) {
            e5.printStackTrace();
            CLog.m34554a(CLog.f24345c, "Failed to show preview - invalid parameters set to camera preview");
            this.f24419b.mo34480a();
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
    }
}

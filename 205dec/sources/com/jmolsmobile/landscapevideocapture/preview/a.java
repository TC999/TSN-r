package com.jmolsmobile.landscapevideocapture.preview;

import android.hardware.Camera;
import android.view.SurfaceHolder;
import java.io.IOException;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* compiled from: CapturePreview.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class a implements SurfaceHolder.Callback {

    /* renamed from: a  reason: collision with root package name */
    private boolean f37958a = false;

    /* renamed from: b  reason: collision with root package name */
    private final b f37959b;

    /* renamed from: c  reason: collision with root package name */
    public final com.jmolsmobile.landscapevideocapture.camera.b f37960c;

    public a(b bVar, com.jmolsmobile.landscapevideocapture.camera.b bVar2, SurfaceHolder surfaceHolder) {
        this.f37959b = bVar;
        this.f37960c = bVar2;
        a(surfaceHolder);
    }

    private void a(SurfaceHolder surfaceHolder) {
        surfaceHolder.removeCallback(this);
        surfaceHolder.addCallback(this);
        surfaceHolder.setType(3);
    }

    public static boolean b() {
        for (int i4 = 0; i4 < Camera.getNumberOfCameras(); i4++) {
            Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
            Camera.getCameraInfo(i4, cameraInfo);
            if (cameraInfo.facing == 1) {
                return true;
            }
        }
        return false;
    }

    public void c() {
        if (this.f37958a) {
            try {
                this.f37960c.n();
                d(false);
            } catch (Exception e4) {
                e4.printStackTrace();
                com.jmolsmobile.landscapevideocapture.b.b("VideoCapture_Preview", "Failed to clean up preview resources");
            }
        }
    }

    protected void d(boolean z3) {
        this.f37958a = z3;
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i4, int i5, int i6) {
        if (this.f37958a) {
            try {
                this.f37960c.n();
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        }
        try {
            this.f37960c.a(i5, i6);
            com.jmolsmobile.landscapevideocapture.b.a("VideoCapture_Preview", "Configured camera for preview in surface of " + i5 + " by " + i6);
            try {
                this.f37960c.b();
            } catch (RuntimeException e5) {
                e5.printStackTrace();
                com.jmolsmobile.landscapevideocapture.b.a("VideoCapture_Preview", "AutoFocus not available for preview");
            }
            try {
                this.f37960c.m(surfaceHolder);
                d(true);
            } catch (IOException e6) {
                e6.printStackTrace();
                com.jmolsmobile.landscapevideocapture.b.a("VideoCapture_Preview", "Failed to show preview - unable to connect camera to preview (IOException)");
                this.f37959b.a();
            } catch (RuntimeException e7) {
                e7.printStackTrace();
                com.jmolsmobile.landscapevideocapture.b.a("VideoCapture_Preview", "Failed to show preview - unable to start camera preview (RuntimeException)");
                this.f37959b.a();
            }
        } catch (RuntimeException e8) {
            e8.printStackTrace();
            com.jmolsmobile.landscapevideocapture.b.a("VideoCapture_Preview", "Failed to show preview - invalid parameters set to camera preview");
            this.f37959b.a();
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
    }
}

package com.jmolsmobile.landscapevideocapture.camera;

import android.hardware.Camera;
import android.view.SurfaceHolder;
import java.io.IOException;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* compiled from: NativeCamera.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private Camera f37908a = null;

    /* renamed from: b  reason: collision with root package name */
    private boolean f37909b = false;

    /* renamed from: c  reason: collision with root package name */
    private Camera.Parameters f37910c = null;

    private int c() {
        return this.f37909b ? 1 : 0;
    }

    private int d() {
        int numberOfCameras = Camera.getNumberOfCameras();
        for (int i4 = 0; i4 < numberOfCameras; i4++) {
            Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
            Camera.getCameraInfo(i4, cameraInfo);
            if (cameraInfo.facing == c()) {
                return i4;
            }
        }
        return -1;
    }

    private boolean g() {
        for (int i4 = 0; i4 < Camera.getNumberOfCameras(); i4++) {
            Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
            Camera.getCameraInfo(i4, cameraInfo);
            if (cameraInfo.facing == 1) {
                return true;
            }
        }
        return false;
    }

    public void a() {
        this.f37908a.setPreviewCallback(null);
    }

    public int b() {
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        Camera.getCameraInfo(d(), cameraInfo);
        return cameraInfo.orientation;
    }

    public Camera e() {
        return this.f37908a;
    }

    public Camera.Parameters f() {
        if (this.f37910c == null) {
            this.f37910c = this.f37908a.getParameters();
        }
        return this.f37910c;
    }

    public boolean h() {
        return this.f37909b;
    }

    public void i(boolean z3) throws RuntimeException {
        if (z3) {
            if (g()) {
                this.f37908a = Camera.open(1);
                this.f37909b = true;
                return;
            }
            return;
        }
        this.f37908a = Camera.open(0);
    }

    public void j() {
        this.f37908a.release();
    }

    public void k(int i4) {
        this.f37908a.setDisplayOrientation(i4);
    }

    public void l(SurfaceHolder surfaceHolder) throws IOException {
        this.f37908a.setPreviewDisplay(surfaceHolder);
    }

    public void m() {
        this.f37908a.startPreview();
    }

    public void n() {
        this.f37908a.stopPreview();
    }

    public void o() {
        this.f37908a.unlock();
    }

    public void p(Camera.Parameters parameters) {
        this.f37910c = parameters;
        this.f37908a.setParameters(parameters);
    }
}

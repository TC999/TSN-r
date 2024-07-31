package com.jmolsmobile.landscapevideocapture.camera;

import android.hardware.Camera;
import android.view.SurfaceHolder;
import java.io.IOException;

/* renamed from: com.jmolsmobile.landscapevideocapture.camera.c */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class NativeCamera {

    /* renamed from: a */
    private Camera f24360a = null;

    /* renamed from: b */
    private boolean f24361b = false;

    /* renamed from: c */
    private Camera.Parameters f24362c = null;

    /* renamed from: c */
    private int m34528c() {
        return this.f24361b ? 1 : 0;
    }

    /* renamed from: d */
    private int m34527d() {
        int numberOfCameras = Camera.getNumberOfCameras();
        for (int i = 0; i < numberOfCameras; i++) {
            Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
            Camera.getCameraInfo(i, cameraInfo);
            if (cameraInfo.facing == m34528c()) {
                return i;
            }
        }
        return -1;
    }

    /* renamed from: g */
    private boolean m34524g() {
        for (int i = 0; i < Camera.getNumberOfCameras(); i++) {
            Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
            Camera.getCameraInfo(i, cameraInfo);
            if (cameraInfo.facing == 1) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    public void m34530a() {
        this.f24360a.setPreviewCallback(null);
    }

    /* renamed from: b */
    public int m34529b() {
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        Camera.getCameraInfo(m34527d(), cameraInfo);
        return cameraInfo.orientation;
    }

    /* renamed from: e */
    public Camera m34526e() {
        return this.f24360a;
    }

    /* renamed from: f */
    public Camera.Parameters m34525f() {
        if (this.f24362c == null) {
            this.f24362c = this.f24360a.getParameters();
        }
        return this.f24362c;
    }

    /* renamed from: h */
    public boolean m34523h() {
        return this.f24361b;
    }

    /* renamed from: i */
    public void m34522i(boolean z) throws RuntimeException {
        if (z) {
            if (m34524g()) {
                this.f24360a = Camera.open(1);
                this.f24361b = true;
                return;
            }
            return;
        }
        this.f24360a = Camera.open(0);
    }

    /* renamed from: j */
    public void m34521j() {
        this.f24360a.release();
    }

    /* renamed from: k */
    public void m34520k(int i) {
        this.f24360a.setDisplayOrientation(i);
    }

    /* renamed from: l */
    public void m34519l(SurfaceHolder surfaceHolder) throws IOException {
        this.f24360a.setPreviewDisplay(surfaceHolder);
    }

    /* renamed from: m */
    public void m34518m() {
        this.f24360a.startPreview();
    }

    /* renamed from: n */
    public void m34517n() {
        this.f24360a.stopPreview();
    }

    /* renamed from: o */
    public void m34516o() {
        this.f24360a.unlock();
    }

    /* renamed from: p */
    public void m34515p(Camera.Parameters parameters) {
        this.f24362c = parameters;
        this.f24360a.setParameters(parameters);
    }
}

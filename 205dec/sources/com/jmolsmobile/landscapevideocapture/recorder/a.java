package com.jmolsmobile.landscapevideocapture.recorder;

import android.hardware.Camera;
import android.media.CamcorderProfile;
import android.media.MediaRecorder;
import android.view.SurfaceHolder;
import com.jmolsmobile.landscapevideocapture.c;
import com.jmolsmobile.landscapevideocapture.camera.OpenCameraException;
import com.jmolsmobile.landscapevideocapture.camera.PrepareCameraException;
import com.jmolsmobile.landscapevideocapture.camera.d;
import com.jmolsmobile.landscapevideocapture.configuration.CaptureConfiguration;
import java.io.IOException;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* compiled from: VideoRecorder.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class a implements MediaRecorder.OnInfoListener, com.jmolsmobile.landscapevideocapture.preview.b {

    /* renamed from: a  reason: collision with root package name */
    private com.jmolsmobile.landscapevideocapture.camera.b f37961a;

    /* renamed from: b  reason: collision with root package name */
    private com.jmolsmobile.landscapevideocapture.preview.a f37962b;

    /* renamed from: c  reason: collision with root package name */
    private final CaptureConfiguration f37963c;

    /* renamed from: d  reason: collision with root package name */
    private final c f37964d;

    /* renamed from: e  reason: collision with root package name */
    private MediaRecorder f37965e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f37966f = false;

    /* renamed from: g  reason: collision with root package name */
    private final b f37967g;

    public a(b bVar, CaptureConfiguration captureConfiguration, c cVar, com.jmolsmobile.landscapevideocapture.camera.b bVar2, SurfaceHolder surfaceHolder, boolean z3) {
        this.f37963c = captureConfiguration;
        this.f37967g = bVar;
        this.f37964d = cVar;
        this.f37961a = bVar2;
        e(surfaceHolder, z3);
    }

    private boolean d() {
        try {
            this.f37961a.k();
            j(new MediaRecorder());
            b(c(), this.f37961a.d());
            com.jmolsmobile.landscapevideocapture.b.a("VideoCapture_VideoRecorder", "MediaRecorder successfully initialized");
            return true;
        } catch (PrepareCameraException e4) {
            e4.printStackTrace();
            this.f37967g.c("Unable to record video");
            com.jmolsmobile.landscapevideocapture.b.b("VideoCapture_VideoRecorder", "Failed to initialize recorder - " + e4.toString());
            return false;
        }
    }

    private boolean g() {
        try {
            c().prepare();
            com.jmolsmobile.landscapevideocapture.b.a("VideoCapture_VideoRecorder", "MediaRecorder successfully prepared");
            return true;
        } catch (IOException e4) {
            e4.printStackTrace();
            com.jmolsmobile.landscapevideocapture.b.b("VideoCapture_VideoRecorder", "MediaRecorder preparation failed - " + e4.toString());
            return false;
        } catch (IllegalStateException e5) {
            e5.printStackTrace();
            com.jmolsmobile.landscapevideocapture.b.b("VideoCapture_VideoRecorder", "MediaRecorder preparation failed - " + e5.toString());
            return false;
        }
    }

    private void i() {
        MediaRecorder c4 = c();
        if (c4 != null) {
            c4.release();
            j(null);
        }
    }

    private boolean k() {
        try {
            c().start();
            com.jmolsmobile.landscapevideocapture.b.a("VideoCapture_VideoRecorder", "MediaRecorder successfully started");
            return true;
        } catch (IllegalStateException e4) {
            e4.printStackTrace();
            com.jmolsmobile.landscapevideocapture.b.b("VideoCapture_VideoRecorder", "MediaRecorder start failed - " + e4.toString());
            return false;
        } catch (RuntimeException e5) {
            e5.printStackTrace();
            com.jmolsmobile.landscapevideocapture.b.b("VideoCapture_VideoRecorder", "MediaRecorder start failed - " + e5.toString());
            this.f37967g.c("Unable to record video with given settings");
            return false;
        }
    }

    @Override // com.jmolsmobile.landscapevideocapture.preview.b
    public void a() {
        this.f37967g.c("Unable to show camera preview");
    }

    protected void b(MediaRecorder mediaRecorder, Camera camera) throws IllegalStateException, IllegalArgumentException {
        mediaRecorder.setCamera(camera);
        mediaRecorder.setAudioSource(this.f37963c.k());
        mediaRecorder.setVideoSource(this.f37963c.u());
        CamcorderProfile c4 = this.f37961a.c();
        c4.fileFormat = this.f37963c.o();
        d h4 = this.f37961a.h(this.f37963c.v(), this.f37963c.t());
        c4.videoFrameWidth = h4.f37911a;
        c4.videoFrameHeight = h4.f37912b;
        c4.videoBitRate = this.f37963c.q();
        c4.audioCodec = this.f37963c.j();
        c4.videoCodec = this.f37963c.r();
        mediaRecorder.setProfile(c4);
        mediaRecorder.setMaxDuration(this.f37963c.m());
        mediaRecorder.setOutputFile(this.f37964d.d());
        mediaRecorder.setOrientationHint(this.f37961a.g());
        mediaRecorder.setVideoFrameRate(this.f37963c.s());
        try {
            mediaRecorder.setMaxFileSize(this.f37963c.n());
        } catch (IllegalArgumentException unused) {
            com.jmolsmobile.landscapevideocapture.b.b("VideoCapture_VideoRecorder", "Failed to set max filesize - illegal argument: " + this.f37963c.n());
        } catch (RuntimeException unused2) {
            com.jmolsmobile.landscapevideocapture.b.b("VideoCapture_VideoRecorder", "Failed to set max filesize - runtime exception");
        }
        mediaRecorder.setOnInfoListener(this);
    }

    protected MediaRecorder c() {
        return this.f37965e;
    }

    protected void e(SurfaceHolder surfaceHolder, boolean z3) {
        try {
            this.f37961a.j(z3);
            this.f37962b = new com.jmolsmobile.landscapevideocapture.preview.a(this, this.f37961a, surfaceHolder);
        } catch (OpenCameraException e4) {
            e4.printStackTrace();
            this.f37967g.c(e4.getMessage());
        }
    }

    protected boolean f() {
        return this.f37966f;
    }

    public void h() {
        com.jmolsmobile.landscapevideocapture.preview.a aVar = this.f37962b;
        if (aVar != null) {
            aVar.c();
        }
        com.jmolsmobile.landscapevideocapture.camera.b bVar = this.f37961a;
        if (bVar != null) {
            bVar.l();
            this.f37961a = null;
        }
        i();
        com.jmolsmobile.landscapevideocapture.b.a("VideoCapture_VideoRecorder", "Released all resources");
    }

    protected void j(MediaRecorder mediaRecorder) {
        this.f37965e = mediaRecorder;
    }

    protected void l() {
        this.f37966f = false;
        if (d() && g() && k()) {
            this.f37966f = true;
            this.f37967g.d();
            com.jmolsmobile.landscapevideocapture.b.a("VideoCapture_VideoRecorder", "Successfully started recording - outputfile: " + this.f37964d.d());
        }
    }

    public void m(String str) {
        if (f()) {
            try {
                c().stop();
                this.f37967g.g();
                com.jmolsmobile.landscapevideocapture.b.a("VideoCapture_VideoRecorder", "Successfully stopped recording - outputfile: " + this.f37964d.d());
            } catch (RuntimeException unused) {
                com.jmolsmobile.landscapevideocapture.b.a("VideoCapture_VideoRecorder", "Failed to stop recording");
            }
            this.f37966f = false;
            this.f37967g.f(str);
        }
    }

    public void n() throws AlreadyUsedException {
        if (this.f37961a != null) {
            if (f()) {
                m(null);
                return;
            } else {
                l();
                return;
            }
        }
        throw new AlreadyUsedException();
    }

    @Override // android.media.MediaRecorder.OnInfoListener
    public void onInfo(MediaRecorder mediaRecorder, int i4, int i5) {
        if (i4 != 800) {
            if (i4 != 801) {
                return;
            }
            com.jmolsmobile.landscapevideocapture.b.a("VideoCapture_VideoRecorder", "MediaRecorder max filesize reached");
            m("Capture stopped - Max file size reached");
            return;
        }
        com.jmolsmobile.landscapevideocapture.b.a("VideoCapture_VideoRecorder", "MediaRecorder max duration reached");
        m("\u5f55\u5236\u5b8c\u6210,\u5df2\u8fbe\u6700\u5927" + (this.f37963c.m() / 1000) + "\u79d2\u9650\u5236");
    }
}

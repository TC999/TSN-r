package com.jmolsmobile.landscapevideocapture.recorder;

import android.hardware.Camera;
import android.media.CamcorderProfile;
import android.media.MediaRecorder;
import android.view.SurfaceHolder;
import com.jmolsmobile.landscapevideocapture.CLog;
import com.jmolsmobile.landscapevideocapture.VideoFile;
import com.jmolsmobile.landscapevideocapture.camera.CameraWrapper;
import com.jmolsmobile.landscapevideocapture.camera.OpenCameraException;
import com.jmolsmobile.landscapevideocapture.camera.PrepareCameraException;
import com.jmolsmobile.landscapevideocapture.camera.RecordingSize;
import com.jmolsmobile.landscapevideocapture.configuration.CaptureConfiguration;
import com.jmolsmobile.landscapevideocapture.preview.CapturePreview;
import com.jmolsmobile.landscapevideocapture.preview.CapturePreviewInterface;
import java.io.IOException;

/* compiled from: VideoRecorder.java */
/* renamed from: com.jmolsmobile.landscapevideocapture.recorder.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C7141a implements MediaRecorder.OnInfoListener, CapturePreviewInterface {

    /* renamed from: a */
    private CameraWrapper f24421a;

    /* renamed from: b */
    private CapturePreview f24422b;

    /* renamed from: c */
    private final CaptureConfiguration f24423c;

    /* renamed from: d */
    private final VideoFile f24424d;

    /* renamed from: e */
    private MediaRecorder f24425e;

    /* renamed from: f */
    private boolean f24426f = false;

    /* renamed from: g */
    private final VideoRecorderInterface f24427g;

    public C7141a(VideoRecorderInterface videoRecorderInterface, CaptureConfiguration captureConfiguration, VideoFile videoFile, CameraWrapper cameraWrapper, SurfaceHolder surfaceHolder, boolean z) {
        this.f24423c = captureConfiguration;
        this.f24427g = videoRecorderInterface;
        this.f24424d = videoFile;
        this.f24421a = cameraWrapper;
        m34476e(surfaceHolder, z);
    }

    /* renamed from: d */
    private boolean m34477d() {
        try {
            this.f24421a.m34534k();
            m34471j(new MediaRecorder());
            m34479b(m34478c(), this.f24421a.m34541d());
            CLog.m34554a(CLog.f24347e, "MediaRecorder successfully initialized");
            return true;
        } catch (PrepareCameraException e) {
            e.printStackTrace();
            this.f24427g.mo34466c("Unable to record video");
            CLog.m34553b(CLog.f24347e, "Failed to initialize recorder - " + e.toString());
            return false;
        }
    }

    /* renamed from: g */
    private boolean m34474g() {
        try {
            m34478c().prepare();
            CLog.m34554a(CLog.f24347e, "MediaRecorder successfully prepared");
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            CLog.m34553b(CLog.f24347e, "MediaRecorder preparation failed - " + e.toString());
            return false;
        } catch (IllegalStateException e2) {
            e2.printStackTrace();
            CLog.m34553b(CLog.f24347e, "MediaRecorder preparation failed - " + e2.toString());
            return false;
        }
    }

    /* renamed from: i */
    private void m34472i() {
        MediaRecorder m34478c = m34478c();
        if (m34478c != null) {
            m34478c.release();
            m34471j(null);
        }
    }

    /* renamed from: k */
    private boolean m34470k() {
        try {
            m34478c().start();
            CLog.m34554a(CLog.f24347e, "MediaRecorder successfully started");
            return true;
        } catch (IllegalStateException e) {
            e.printStackTrace();
            CLog.m34553b(CLog.f24347e, "MediaRecorder start failed - " + e.toString());
            return false;
        } catch (RuntimeException e2) {
            e2.printStackTrace();
            CLog.m34553b(CLog.f24347e, "MediaRecorder start failed - " + e2.toString());
            this.f24427g.mo34466c("Unable to record video with given settings");
            return false;
        }
    }

    @Override // com.jmolsmobile.landscapevideocapture.preview.CapturePreviewInterface
    /* renamed from: a */
    public void mo34480a() {
        this.f24427g.mo34466c("Unable to show camera preview");
    }

    /* renamed from: b */
    protected void m34479b(MediaRecorder mediaRecorder, Camera camera) throws IllegalStateException, IllegalArgumentException {
        mediaRecorder.setCamera(camera);
        mediaRecorder.setAudioSource(this.f24423c.m34504k());
        mediaRecorder.setVideoSource(this.f24423c.m34494u());
        CamcorderProfile m34542c = this.f24421a.m34542c();
        m34542c.fileFormat = this.f24423c.m34500o();
        RecordingSize m34537h = this.f24421a.m34537h(this.f24423c.m34493v(), this.f24423c.m34495t());
        m34542c.videoFrameWidth = m34537h.f24363a;
        m34542c.videoFrameHeight = m34537h.f24364b;
        m34542c.videoBitRate = this.f24423c.m34498q();
        m34542c.audioCodec = this.f24423c.m34505j();
        m34542c.videoCodec = this.f24423c.m34497r();
        mediaRecorder.setProfile(m34542c);
        mediaRecorder.setMaxDuration(this.f24423c.m34502m());
        mediaRecorder.setOutputFile(this.f24424d.m34548d());
        mediaRecorder.setOrientationHint(this.f24421a.m34538g());
        mediaRecorder.setVideoFrameRate(this.f24423c.m34496s());
        try {
            mediaRecorder.setMaxFileSize(this.f24423c.m34501n());
        } catch (IllegalArgumentException unused) {
            CLog.m34553b(CLog.f24347e, "Failed to set max filesize - illegal argument: " + this.f24423c.m34501n());
        } catch (RuntimeException unused2) {
            CLog.m34553b(CLog.f24347e, "Failed to set max filesize - runtime exception");
        }
        mediaRecorder.setOnInfoListener(this);
    }

    /* renamed from: c */
    protected MediaRecorder m34478c() {
        return this.f24425e;
    }

    /* renamed from: e */
    protected void m34476e(SurfaceHolder surfaceHolder, boolean z) {
        try {
            this.f24421a.m34535j(z);
            this.f24422b = new CapturePreview(this, this.f24421a, surfaceHolder);
        } catch (OpenCameraException e) {
            e.printStackTrace();
            this.f24427g.mo34466c(e.getMessage());
        }
    }

    /* renamed from: f */
    protected boolean m34475f() {
        return this.f24426f;
    }

    /* renamed from: h */
    public void m34473h() {
        CapturePreview capturePreview = this.f24422b;
        if (capturePreview != null) {
            capturePreview.m34482c();
        }
        CameraWrapper cameraWrapper = this.f24421a;
        if (cameraWrapper != null) {
            cameraWrapper.m34533l();
            this.f24421a = null;
        }
        m34472i();
        CLog.m34554a(CLog.f24347e, "Released all resources");
    }

    /* renamed from: j */
    protected void m34471j(MediaRecorder mediaRecorder) {
        this.f24425e = mediaRecorder;
    }

    /* renamed from: l */
    protected void m34469l() {
        this.f24426f = false;
        if (m34477d() && m34474g() && m34470k()) {
            this.f24426f = true;
            this.f24427g.mo34465d();
            CLog.m34554a(CLog.f24347e, "Successfully started recording - outputfile: " + this.f24424d.m34548d());
        }
    }

    /* renamed from: m */
    public void m34468m(String str) {
        if (m34475f()) {
            try {
                m34478c().stop();
                this.f24427g.mo34463g();
                CLog.m34554a(CLog.f24347e, "Successfully stopped recording - outputfile: " + this.f24424d.m34548d());
            } catch (RuntimeException unused) {
                CLog.m34554a(CLog.f24347e, "Failed to stop recording");
            }
            this.f24426f = false;
            this.f24427g.mo34464f(str);
        }
    }

    /* renamed from: n */
    public void m34467n() throws AlreadyUsedException {
        if (this.f24421a != null) {
            if (m34475f()) {
                m34468m(null);
                return;
            } else {
                m34469l();
                return;
            }
        }
        throw new AlreadyUsedException();
    }

    @Override // android.media.MediaRecorder.OnInfoListener
    public void onInfo(MediaRecorder mediaRecorder, int i, int i2) {
        if (i != 800) {
            if (i != 801) {
                return;
            }
            CLog.m34554a(CLog.f24347e, "MediaRecorder max filesize reached");
            m34468m("Capture stopped - Max file size reached");
            return;
        }
        CLog.m34554a(CLog.f24347e, "MediaRecorder max duration reached");
        m34468m("录制完成,已达最大" + (this.f24423c.m34502m() / 1000) + "秒限制");
    }
}

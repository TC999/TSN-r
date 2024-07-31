package com.p201hw.videoprocessor.util;

/* renamed from: com.hw.videoprocessor.util.i */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class VideoMultiStepProgress implements VideoProgressListener {

    /* renamed from: a */
    private float[] f24179a;

    /* renamed from: b */
    private int f24180b;

    /* renamed from: c */
    private VideoProgressListener f24181c;

    /* renamed from: d */
    private float f24182d;

    public VideoMultiStepProgress(float[] fArr, VideoProgressListener videoProgressListener) {
        this.f24179a = fArr;
        this.f24181c = videoProgressListener;
    }

    @Override // com.p201hw.videoprocessor.util.VideoProgressListener
    /* renamed from: a */
    public void mo34843a(float f) {
        VideoProgressListener videoProgressListener = this.f24181c;
        if (videoProgressListener != null) {
            videoProgressListener.mo34843a((f * this.f24179a[this.f24180b]) + this.f24182d);
        }
    }

    /* renamed from: b */
    public void m34850b(int i) {
        this.f24180b = i;
        this.f24182d = 0.0f;
        for (int i2 = 0; i2 < i; i2++) {
            this.f24182d += this.f24179a[i2];
        }
    }

    /* renamed from: c */
    public void m34849c(VideoProgressListener videoProgressListener) {
        this.f24181c = videoProgressListener;
    }
}

package com.p201hw.videoprocessor.util;

/* renamed from: com.hw.videoprocessor.util.j */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class VideoProgressAve {

    /* renamed from: a */
    private VideoProgressListener f24183a;

    /* renamed from: b */
    private float f24184b;

    /* renamed from: c */
    private float f24185c;

    /* renamed from: d */
    private int f24186d;

    /* renamed from: e */
    private int f24187e;

    /* renamed from: f */
    private Float f24188f;

    public VideoProgressAve(VideoProgressListener videoProgressListener) {
        this.f24183a = videoProgressListener;
    }

    /* renamed from: a */
    public void m34848a(float f) {
        this.f24185c = f;
        VideoProgressListener videoProgressListener = this.f24183a;
        if (videoProgressListener != null) {
            videoProgressListener.mo34843a((this.f24184b + f) / 2.0f);
        }
        CL.m34891k("mAudioProgress:" + this.f24185c, new Object[0]);
    }

    /* renamed from: b */
    public void m34847b(long j) {
        int i;
        if (this.f24183a == null) {
            return;
        }
        Float f = this.f24188f;
        if (f != null) {
            j = ((float) j) * f.floatValue();
        }
        float f2 = ((((float) j) / 1000.0f) - this.f24186d) / (this.f24187e - i);
        this.f24184b = f2;
        if (f2 < 0.0f) {
            f2 = 0.0f;
        }
        this.f24184b = f2;
        if (f2 > 1.0f) {
            f2 = 1.0f;
        }
        this.f24184b = f2;
        this.f24183a.mo34843a((f2 + this.f24185c) / 2.0f);
        CL.m34891k("mEncodeProgress:" + this.f24184b, new Object[0]);
    }

    /* renamed from: c */
    public void m34846c(int i) {
        this.f24187e = i;
    }

    /* renamed from: d */
    public void m34845d(Float f) {
        this.f24188f = f;
    }

    /* renamed from: e */
    public void m34844e(int i) {
        this.f24186d = i;
    }
}

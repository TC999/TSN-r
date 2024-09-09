package com.hw.videoprocessor;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import android.view.Surface;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* compiled from: VideoAppendEncodeThread.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class d extends Thread implements c {

    /* renamed from: a  reason: collision with root package name */
    private MediaCodec f37497a;

    /* renamed from: b  reason: collision with root package name */
    private MediaMuxer f37498b;

    /* renamed from: c  reason: collision with root package name */
    private AtomicBoolean f37499c;

    /* renamed from: d  reason: collision with root package name */
    private Exception f37500d;

    /* renamed from: e  reason: collision with root package name */
    private int f37501e;

    /* renamed from: f  reason: collision with root package name */
    private int f37502f;

    /* renamed from: g  reason: collision with root package name */
    private int f37503g;

    /* renamed from: h  reason: collision with root package name */
    private int f37504h;

    /* renamed from: i  reason: collision with root package name */
    private MediaExtractor f37505i;

    /* renamed from: j  reason: collision with root package name */
    private int f37506j;

    /* renamed from: k  reason: collision with root package name */
    private volatile CountDownLatch f37507k;

    /* renamed from: l  reason: collision with root package name */
    private volatile Surface f37508l;

    /* renamed from: m  reason: collision with root package name */
    private long f37509m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f37510n;

    /* renamed from: o  reason: collision with root package name */
    private boolean f37511o;

    /* renamed from: p  reason: collision with root package name */
    private long f37512p;

    /* renamed from: q  reason: collision with root package name */
    private int f37513q;

    public d(MediaExtractor mediaExtractor, MediaMuxer mediaMuxer, int i4, int i5, int i6, int i7, int i8, AtomicBoolean atomicBoolean, long j4, boolean z3, boolean z4, int i9) {
        super("VideoProcessEncodeThread");
        this.f37498b = mediaMuxer;
        this.f37499c = atomicBoolean;
        this.f37505i = mediaExtractor;
        this.f37501e = i4;
        this.f37503g = i6;
        this.f37502f = i5;
        this.f37504h = i7;
        this.f37506j = i8;
        this.f37507k = new CountDownLatch(1);
        this.f37509m = j4;
        this.f37512p = j4;
        this.f37510n = z3;
        this.f37511o = z4;
        this.f37513q = i9;
    }

    private void c() throws IOException {
        MediaFormat trackFormat = this.f37505i.getTrackFormat(this.f37506j);
        int integer = trackFormat.containsKey("frame-rate") ? trackFormat.getInteger("frame-rate") : h.f37546c;
        MediaFormat createVideoFormat = MediaFormat.createVideoFormat("video/avc", this.f37502f, this.f37503g);
        createVideoFormat.setInteger("color-format", 2130708361);
        createVideoFormat.setInteger("bitrate", this.f37501e);
        createVideoFormat.setInteger("frame-rate", integer);
        createVideoFormat.setInteger("i-frame-interval", this.f37504h);
        MediaCodec createEncoderByType = MediaCodec.createEncoderByType("video/avc");
        this.f37497a = createEncoderByType;
        createEncoderByType.configure(createVideoFormat, (Surface) null, (MediaCrypto) null, 1);
        this.f37508l = this.f37497a.createInputSurface();
        this.f37497a.start();
        this.f37507k.countDown();
        MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
        boolean z3 = false;
        int i4 = 0;
        while (true) {
            if (this.f37499c.get() && !z3) {
                this.f37497a.signalEndOfInputStream();
                z3 = true;
            }
            int dequeueOutputBuffer = this.f37497a.dequeueOutputBuffer(bufferInfo, 2500L);
            com.hw.videoprocessor.util.c.k("encode outputBufferIndex = " + dequeueOutputBuffer, new Object[0]);
            if (z3 && dequeueOutputBuffer == -1) {
                i4++;
                if (i4 > 10) {
                    com.hw.videoprocessor.util.c.f("INFO_TRY_AGAIN_LATER 10 times,force End!", new Object[0]);
                    return;
                }
            } else {
                i4 = 0;
            }
            if (dequeueOutputBuffer != -1) {
                if (dequeueOutputBuffer == -2) {
                    MediaFormat outputFormat = this.f37497a.getOutputFormat();
                    com.hw.videoprocessor.util.c.k("encode newFormat = " + outputFormat, new Object[0]);
                } else if (dequeueOutputBuffer < 0) {
                    com.hw.videoprocessor.util.c.f("unexpected result from decoder.dequeueOutputBuffer: " + dequeueOutputBuffer, new Object[0]);
                } else {
                    ByteBuffer outputBuffer = this.f37497a.getOutputBuffer(dequeueOutputBuffer);
                    long j4 = bufferInfo.presentationTimeUs + this.f37509m;
                    bufferInfo.presentationTimeUs = j4;
                    if (this.f37510n || bufferInfo.flags != 2) {
                        if (!this.f37511o && bufferInfo.flags == 4) {
                            com.hw.videoprocessor.util.c.k("encoderDone", new Object[0]);
                            this.f37497a.releaseOutputBuffer(dequeueOutputBuffer, false);
                            return;
                        }
                        if (bufferInfo.flags == 4 && j4 < 0) {
                            bufferInfo.presentationTimeUs = 0L;
                        }
                        com.hw.videoprocessor.util.c.k("writeSampleData,size:" + bufferInfo.size + " time:" + (bufferInfo.presentationTimeUs / 1000) + " flag:" + bufferInfo.flags, new Object[0]);
                        this.f37498b.writeSampleData(this.f37513q, outputBuffer, bufferInfo);
                        long j5 = this.f37512p;
                        long j6 = bufferInfo.presentationTimeUs;
                        if (j5 < j6) {
                            this.f37512p = j6;
                        }
                        this.f37497a.releaseOutputBuffer(dequeueOutputBuffer, false);
                        if (bufferInfo.flags == 4) {
                            com.hw.videoprocessor.util.c.k("encoderDone", new Object[0]);
                            return;
                        }
                    }
                }
            }
        }
    }

    @Override // com.hw.videoprocessor.c
    public CountDownLatch a() {
        return this.f37507k;
    }

    @Override // com.hw.videoprocessor.c
    public Surface b() {
        return this.f37508l;
    }

    public Exception d() {
        return this.f37500d;
    }

    public long e() {
        return this.f37512p;
    }

    /* JADX WARN: Finally extract failed */
    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        MediaCodec mediaCodec;
        super.run();
        try {
            try {
                c();
                mediaCodec = this.f37497a;
                if (mediaCodec == null) {
                    return;
                }
            } catch (Exception e4) {
                com.hw.videoprocessor.util.c.g(e4);
                this.f37500d = e4;
                if (this.f37497a == null) {
                    return;
                }
                mediaCodec = this.f37497a;
            }
            mediaCodec.stop();
            this.f37497a.release();
        } catch (Throwable th) {
            MediaCodec mediaCodec2 = this.f37497a;
            if (mediaCodec2 != null) {
                mediaCodec2.stop();
                this.f37497a.release();
            }
            throw th;
        }
    }
}

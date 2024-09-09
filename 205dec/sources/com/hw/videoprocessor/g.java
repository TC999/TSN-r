package com.hw.videoprocessor;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import android.view.Surface;
import com.hw.videoprocessor.util.j;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* compiled from: VideoEncodeThread.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class g extends Thread implements c {

    /* renamed from: a  reason: collision with root package name */
    private MediaCodec f37529a;

    /* renamed from: b  reason: collision with root package name */
    private MediaMuxer f37530b;

    /* renamed from: c  reason: collision with root package name */
    private AtomicBoolean f37531c;

    /* renamed from: d  reason: collision with root package name */
    private CountDownLatch f37532d;

    /* renamed from: e  reason: collision with root package name */
    private Exception f37533e;

    /* renamed from: f  reason: collision with root package name */
    private int f37534f;

    /* renamed from: g  reason: collision with root package name */
    private int f37535g;

    /* renamed from: h  reason: collision with root package name */
    private int f37536h;

    /* renamed from: i  reason: collision with root package name */
    private int f37537i;

    /* renamed from: j  reason: collision with root package name */
    private int f37538j;

    /* renamed from: k  reason: collision with root package name */
    private MediaExtractor f37539k;

    /* renamed from: l  reason: collision with root package name */
    private int f37540l;

    /* renamed from: m  reason: collision with root package name */
    private volatile CountDownLatch f37541m;

    /* renamed from: n  reason: collision with root package name */
    private volatile Surface f37542n;

    /* renamed from: o  reason: collision with root package name */
    private j f37543o;

    public g(MediaExtractor mediaExtractor, MediaMuxer mediaMuxer, int i4, int i5, int i6, int i7, int i8, int i9, AtomicBoolean atomicBoolean, CountDownLatch countDownLatch) {
        super("VideoProcessEncodeThread");
        this.f37530b = mediaMuxer;
        this.f37531c = atomicBoolean;
        this.f37532d = countDownLatch;
        this.f37539k = mediaExtractor;
        this.f37534f = i4;
        this.f37536h = i6;
        this.f37535g = i5;
        this.f37537i = i7;
        this.f37540l = i9;
        this.f37538j = i8;
        this.f37541m = new CountDownLatch(1);
    }

    private void c() throws IOException {
        boolean z3;
        MediaFormat trackFormat = this.f37539k.getTrackFormat(this.f37540l);
        int i4 = this.f37538j;
        if (i4 <= 0) {
            i4 = trackFormat.containsKey("frame-rate") ? trackFormat.getInteger("frame-rate") : h.f37546c;
        }
        MediaFormat createVideoFormat = MediaFormat.createVideoFormat("video/avc", this.f37535g, this.f37536h);
        createVideoFormat.setInteger("color-format", 2130708361);
        createVideoFormat.setInteger("frame-rate", i4);
        createVideoFormat.setInteger("i-frame-interval", this.f37537i);
        MediaCodec createEncoderByType = MediaCodec.createEncoderByType("video/avc");
        this.f37529a = createEncoderByType;
        if (i.m(createEncoderByType, "video/avc", createVideoFormat, 8, 512)) {
            com.hw.videoprocessor.util.c.k("supportProfileHigh,enable ProfileHigh", new Object[0]);
        }
        int g4 = i.g(this.f37529a, "video/avc");
        if (g4 > 0 && this.f37534f > g4) {
            com.hw.videoprocessor.util.c.f(this.f37534f + " bitrate too large,set to:" + g4, new Object[0]);
            this.f37534f = (int) (((float) g4) * 0.8f);
        }
        createVideoFormat.setInteger("bitrate", this.f37534f);
        int i5 = 1;
        this.f37529a.configure(createVideoFormat, (Surface) null, (MediaCrypto) null, 1);
        this.f37542n = this.f37529a.createInputSurface();
        this.f37529a.start();
        this.f37541m.countDown();
        MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
        int i6 = (int) (1000000.0f / i4);
        int i7 = -5;
        boolean z4 = false;
        int i8 = 0;
        int i9 = -5;
        boolean z5 = false;
        long j4 = -1;
        while (true) {
            if (this.f37531c.get() && !z4) {
                this.f37529a.signalEndOfInputStream();
                z4 = true;
            }
            int dequeueOutputBuffer = this.f37529a.dequeueOutputBuffer(bufferInfo, 2500L);
            com.hw.videoprocessor.util.c.k("encode outputBufferIndex = " + dequeueOutputBuffer, new Object[0]);
            if (z4 && dequeueOutputBuffer == -1) {
                i8 += i5;
                if (i8 > 10) {
                    com.hw.videoprocessor.util.c.f("INFO_TRY_AGAIN_LATER 10 times,force End!", new Object[0]);
                    return;
                }
            } else {
                i8 = 0;
            }
            if (dequeueOutputBuffer != -1) {
                if (dequeueOutputBuffer == -2) {
                    MediaFormat outputFormat = this.f37529a.getOutputFormat();
                    if (i9 == i7) {
                        i9 = this.f37530b.addTrack(outputFormat);
                        this.f37530b.start();
                        this.f37532d.countDown();
                    }
                    com.hw.videoprocessor.util.c.k("encode newFormat = " + outputFormat, new Object[0]);
                } else if (dequeueOutputBuffer < 0) {
                    com.hw.videoprocessor.util.c.f("unexpected result from decoder.dequeueOutputBuffer: " + dequeueOutputBuffer, new Object[0]);
                } else {
                    ByteBuffer outputBuffer = this.f37529a.getOutputBuffer(dequeueOutputBuffer);
                    z3 = z4;
                    if (bufferInfo.flags == 4 && bufferInfo.presentationTimeUs < 0) {
                        bufferInfo.presentationTimeUs = 0L;
                    }
                    if (!z5 && j4 != -1 && bufferInfo.presentationTimeUs < (i6 / 2) + j4) {
                        com.hw.videoprocessor.util.c.f("video \u65f6\u95f4\u6233\u9519\u8bef\uff0clastVideoFrameTimeUs:" + j4 + " info.presentationTimeUs:" + bufferInfo.presentationTimeUs + " VIDEO_FRAME_TIME_US:" + i6, new Object[0]);
                        z5 = true;
                    }
                    if (z5) {
                        bufferInfo.presentationTimeUs = i6 + j4;
                        com.hw.videoprocessor.util.c.f("video \u65f6\u95f4\u6233\u9519\u8bef\uff0c\u4f7f\u7528\u4fee\u6b63\u7684\u65f6\u95f4\u6233:" + bufferInfo.presentationTimeUs, new Object[0]);
                        z5 = false;
                    }
                    if (bufferInfo.flags != 2) {
                        j4 = bufferInfo.presentationTimeUs;
                    }
                    com.hw.videoprocessor.util.c.k("writeSampleData,size:" + bufferInfo.size + " time:" + (bufferInfo.presentationTimeUs / 1000), new Object[0]);
                    this.f37530b.writeSampleData(i9, outputBuffer, bufferInfo);
                    e(bufferInfo);
                    this.f37529a.releaseOutputBuffer(dequeueOutputBuffer, false);
                    if (bufferInfo.flags == 4) {
                        com.hw.videoprocessor.util.c.k("encoderDone", new Object[0]);
                        return;
                    }
                    z4 = z3;
                    i5 = 1;
                    i7 = -5;
                }
                z3 = z4;
                z4 = z3;
                i5 = 1;
                i7 = -5;
            }
        }
    }

    private void e(MediaCodec.BufferInfo bufferInfo) {
        j jVar = this.f37543o;
        if (jVar == null) {
            return;
        }
        jVar.b((bufferInfo.flags & 4) > 0 ? Long.MAX_VALUE : bufferInfo.presentationTimeUs);
    }

    @Override // com.hw.videoprocessor.c
    public CountDownLatch a() {
        return this.f37541m;
    }

    @Override // com.hw.videoprocessor.c
    public Surface b() {
        return this.f37542n;
    }

    public Exception d() {
        return this.f37533e;
    }

    public void f(j jVar) {
        this.f37543o = jVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0016, code lost:
        if (r1 != null) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0018, code lost:
        r1 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0019, code lost:
        r3.f37533e = r1;
        com.hw.videoprocessor.util.c.g(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0039, code lost:
        if (r1 != null) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:?, code lost:
        return;
     */
    @Override // java.lang.Thread, java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void run() {
        /*
            r3 = this;
            super.run()
            r3.c()     // Catch: java.lang.Throwable -> L1f java.lang.Exception -> L21
            android.media.MediaCodec r0 = r3.f37529a     // Catch: java.lang.Exception -> L13
            if (r0 == 0) goto L3c
            r0.stop()     // Catch: java.lang.Exception -> L13
            android.media.MediaCodec r0 = r3.f37529a     // Catch: java.lang.Exception -> L13
            r0.release()     // Catch: java.lang.Exception -> L13
            goto L3c
        L13:
            r0 = move-exception
            java.lang.Exception r1 = r3.f37533e
            if (r1 != 0) goto L19
        L18:
            r1 = r0
        L19:
            r3.f37533e = r1
            com.hw.videoprocessor.util.c.g(r0)
            goto L3c
        L1f:
            r0 = move-exception
            goto L3d
        L21:
            r0 = move-exception
            com.hw.videoprocessor.util.c.g(r0)     // Catch: java.lang.Throwable -> L1f
            r3.f37533e = r0     // Catch: java.lang.Throwable -> L1f
            android.media.MediaCodec r0 = r3.f37529a     // Catch: java.lang.Exception -> L36
            if (r0 == 0) goto L3c
            android.media.MediaCodec r0 = r3.f37529a     // Catch: java.lang.Exception -> L36
            r0.stop()     // Catch: java.lang.Exception -> L36
            android.media.MediaCodec r0 = r3.f37529a     // Catch: java.lang.Exception -> L36
            r0.release()     // Catch: java.lang.Exception -> L36
            goto L3c
        L36:
            r0 = move-exception
            java.lang.Exception r1 = r3.f37533e
            if (r1 != 0) goto L19
            goto L18
        L3c:
            return
        L3d:
            android.media.MediaCodec r1 = r3.f37529a     // Catch: java.lang.Exception -> L4a
            if (r1 == 0) goto L55
            r1.stop()     // Catch: java.lang.Exception -> L4a
            android.media.MediaCodec r1 = r3.f37529a     // Catch: java.lang.Exception -> L4a
            r1.release()     // Catch: java.lang.Exception -> L4a
            goto L55
        L4a:
            r1 = move-exception
            java.lang.Exception r2 = r3.f37533e
            if (r2 != 0) goto L50
            r2 = r1
        L50:
            r3.f37533e = r2
            com.hw.videoprocessor.util.c.g(r1)
        L55:
            goto L57
        L56:
            throw r0
        L57:
            goto L56
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hw.videoprocessor.g.run():void");
    }
}

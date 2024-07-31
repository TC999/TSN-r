package com.p201hw.videoprocessor;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import android.view.Surface;
import com.p201hw.videoprocessor.util.CL;
import com.p201hw.videoprocessor.util.VideoProgressAve;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* renamed from: com.hw.videoprocessor.g */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class VideoEncodeThread extends Thread implements IVideoEncodeThread {

    /* renamed from: a */
    private MediaCodec f24047a;

    /* renamed from: b */
    private MediaMuxer f24048b;

    /* renamed from: c */
    private AtomicBoolean f24049c;

    /* renamed from: d */
    private CountDownLatch f24050d;

    /* renamed from: e */
    private Exception f24051e;

    /* renamed from: f */
    private int f24052f;

    /* renamed from: g */
    private int f24053g;

    /* renamed from: h */
    private int f24054h;

    /* renamed from: i */
    private int f24055i;

    /* renamed from: j */
    private int f24056j;

    /* renamed from: k */
    private MediaExtractor f24057k;

    /* renamed from: l */
    private int f24058l;

    /* renamed from: m */
    private volatile CountDownLatch f24059m;

    /* renamed from: n */
    private volatile Surface f24060n;

    /* renamed from: o */
    private VideoProgressAve f24061o;

    public VideoEncodeThread(MediaExtractor mediaExtractor, MediaMuxer mediaMuxer, int i, int i2, int i3, int i4, int i5, int i6, AtomicBoolean atomicBoolean, CountDownLatch countDownLatch) {
        super("VideoProcessEncodeThread");
        this.f24048b = mediaMuxer;
        this.f24049c = atomicBoolean;
        this.f24050d = countDownLatch;
        this.f24057k = mediaExtractor;
        this.f24052f = i;
        this.f24054h = i3;
        this.f24053g = i2;
        this.f24055i = i4;
        this.f24058l = i6;
        this.f24056j = i5;
        this.f24059m = new CountDownLatch(1);
    }

    /* renamed from: c */
    private void m35039c() throws IOException {
        boolean z;
        MediaFormat trackFormat = this.f24057k.getTrackFormat(this.f24058l);
        int i = this.f24056j;
        if (i <= 0) {
            i = trackFormat.containsKey("frame-rate") ? trackFormat.getInteger("frame-rate") : VideoProcessor.f24064c;
        }
        MediaFormat createVideoFormat = MediaFormat.createVideoFormat("video/avc", this.f24053g, this.f24054h);
        createVideoFormat.setInteger("color-format", 2130708361);
        createVideoFormat.setInteger("frame-rate", i);
        createVideoFormat.setInteger("i-frame-interval", this.f24055i);
        MediaCodec createEncoderByType = MediaCodec.createEncoderByType("video/avc");
        this.f24047a = createEncoderByType;
        if (VideoUtil.m34984m(createEncoderByType, "video/avc", createVideoFormat, 8, 512)) {
            CL.m34891k("supportProfileHigh,enable ProfileHigh", new Object[0]);
        }
        int m34990g = VideoUtil.m34990g(this.f24047a, "video/avc");
        if (m34990g > 0 && this.f24052f > m34990g) {
            CL.m34896f(this.f24052f + " bitrate too large,set to:" + m34990g, new Object[0]);
            this.f24052f = (int) (((float) m34990g) * 0.8f);
        }
        createVideoFormat.setInteger(IjkMediaMeta.IJKM_KEY_BITRATE, this.f24052f);
        int i2 = 1;
        this.f24047a.configure(createVideoFormat, (Surface) null, (MediaCrypto) null, 1);
        this.f24060n = this.f24047a.createInputSurface();
        this.f24047a.start();
        this.f24059m.countDown();
        MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
        int i3 = (int) (1000000.0f / i);
        int i4 = -5;
        boolean z2 = false;
        int i5 = 0;
        int i6 = -5;
        boolean z3 = false;
        long j = -1;
        while (true) {
            if (this.f24049c.get() && !z2) {
                this.f24047a.signalEndOfInputStream();
                z2 = true;
            }
            int dequeueOutputBuffer = this.f24047a.dequeueOutputBuffer(bufferInfo, 2500L);
            CL.m34891k("encode outputBufferIndex = " + dequeueOutputBuffer, new Object[0]);
            if (z2 && dequeueOutputBuffer == -1) {
                i5 += i2;
                if (i5 > 10) {
                    CL.m34896f("INFO_TRY_AGAIN_LATER 10 times,force End!", new Object[0]);
                    return;
                }
            } else {
                i5 = 0;
            }
            if (dequeueOutputBuffer != -1) {
                if (dequeueOutputBuffer == -2) {
                    MediaFormat outputFormat = this.f24047a.getOutputFormat();
                    if (i6 == i4) {
                        i6 = this.f24048b.addTrack(outputFormat);
                        this.f24048b.start();
                        this.f24050d.countDown();
                    }
                    CL.m34891k("encode newFormat = " + outputFormat, new Object[0]);
                } else if (dequeueOutputBuffer < 0) {
                    CL.m34896f("unexpected result from decoder.dequeueOutputBuffer: " + dequeueOutputBuffer, new Object[0]);
                } else {
                    ByteBuffer outputBuffer = this.f24047a.getOutputBuffer(dequeueOutputBuffer);
                    z = z2;
                    if (bufferInfo.flags == 4 && bufferInfo.presentationTimeUs < 0) {
                        bufferInfo.presentationTimeUs = 0L;
                    }
                    if (!z3 && j != -1 && bufferInfo.presentationTimeUs < (i3 / 2) + j) {
                        CL.m34896f("video 时间戳错误，lastVideoFrameTimeUs:" + j + " info.presentationTimeUs:" + bufferInfo.presentationTimeUs + " VIDEO_FRAME_TIME_US:" + i3, new Object[0]);
                        z3 = true;
                    }
                    if (z3) {
                        bufferInfo.presentationTimeUs = i3 + j;
                        CL.m34896f("video 时间戳错误，使用修正的时间戳:" + bufferInfo.presentationTimeUs, new Object[0]);
                        z3 = false;
                    }
                    if (bufferInfo.flags != 2) {
                        j = bufferInfo.presentationTimeUs;
                    }
                    CL.m34891k("writeSampleData,size:" + bufferInfo.size + " time:" + (bufferInfo.presentationTimeUs / 1000), new Object[0]);
                    this.f24048b.writeSampleData(i6, outputBuffer, bufferInfo);
                    m35037e(bufferInfo);
                    this.f24047a.releaseOutputBuffer(dequeueOutputBuffer, false);
                    if (bufferInfo.flags == 4) {
                        CL.m34891k("encoderDone", new Object[0]);
                        return;
                    }
                    z2 = z;
                    i2 = 1;
                    i4 = -5;
                }
                z = z2;
                z2 = z;
                i2 = 1;
                i4 = -5;
            }
        }
    }

    /* renamed from: e */
    private void m35037e(MediaCodec.BufferInfo bufferInfo) {
        VideoProgressAve videoProgressAve = this.f24061o;
        if (videoProgressAve == null) {
            return;
        }
        videoProgressAve.m34847b((bufferInfo.flags & 4) > 0 ? Long.MAX_VALUE : bufferInfo.presentationTimeUs);
    }

    @Override // com.p201hw.videoprocessor.IVideoEncodeThread
    /* renamed from: a */
    public CountDownLatch mo35041a() {
        return this.f24059m;
    }

    @Override // com.p201hw.videoprocessor.IVideoEncodeThread
    /* renamed from: b */
    public Surface mo35040b() {
        return this.f24060n;
    }

    /* renamed from: d */
    public Exception m35038d() {
        return this.f24051e;
    }

    /* renamed from: f */
    public void m35036f(VideoProgressAve videoProgressAve) {
        this.f24061o = videoProgressAve;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0016, code lost:
        if (r1 != null) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0018, code lost:
        r1 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0019, code lost:
        r3.f24051e = r1;
        com.p201hw.videoprocessor.util.CL.m34895g(r0);
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
            r3.m35039c()     // Catch: java.lang.Throwable -> L1f java.lang.Exception -> L21
            android.media.MediaCodec r0 = r3.f24047a     // Catch: java.lang.Exception -> L13
            if (r0 == 0) goto L3c
            r0.stop()     // Catch: java.lang.Exception -> L13
            android.media.MediaCodec r0 = r3.f24047a     // Catch: java.lang.Exception -> L13
            r0.release()     // Catch: java.lang.Exception -> L13
            goto L3c
        L13:
            r0 = move-exception
            java.lang.Exception r1 = r3.f24051e
            if (r1 != 0) goto L19
        L18:
            r1 = r0
        L19:
            r3.f24051e = r1
            com.p201hw.videoprocessor.util.CL.m34895g(r0)
            goto L3c
        L1f:
            r0 = move-exception
            goto L3d
        L21:
            r0 = move-exception
            com.p201hw.videoprocessor.util.CL.m34895g(r0)     // Catch: java.lang.Throwable -> L1f
            r3.f24051e = r0     // Catch: java.lang.Throwable -> L1f
            android.media.MediaCodec r0 = r3.f24047a     // Catch: java.lang.Exception -> L36
            if (r0 == 0) goto L3c
            android.media.MediaCodec r0 = r3.f24047a     // Catch: java.lang.Exception -> L36
            r0.stop()     // Catch: java.lang.Exception -> L36
            android.media.MediaCodec r0 = r3.f24047a     // Catch: java.lang.Exception -> L36
            r0.release()     // Catch: java.lang.Exception -> L36
            goto L3c
        L36:
            r0 = move-exception
            java.lang.Exception r1 = r3.f24051e
            if (r1 != 0) goto L19
            goto L18
        L3c:
            return
        L3d:
            android.media.MediaCodec r1 = r3.f24047a     // Catch: java.lang.Exception -> L4a
            if (r1 == 0) goto L55
            r1.stop()     // Catch: java.lang.Exception -> L4a
            android.media.MediaCodec r1 = r3.f24047a     // Catch: java.lang.Exception -> L4a
            r1.release()     // Catch: java.lang.Exception -> L4a
            goto L55
        L4a:
            r1 = move-exception
            java.lang.Exception r2 = r3.f24051e
            if (r2 != 0) goto L50
            r2 = r1
        L50:
            r3.f24051e = r2
            com.p201hw.videoprocessor.util.CL.m34895g(r1)
        L55:
            goto L57
        L56:
            throw r0
        L57:
            goto L56
        */
        throw new UnsupportedOperationException("Method not decompiled: com.p201hw.videoprocessor.VideoEncodeThread.run():void");
    }
}

package com.p201hw.videoprocessor;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import android.view.Surface;
import com.p201hw.videoprocessor.util.CL;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* renamed from: com.hw.videoprocessor.d */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class VideoAppendEncodeThread extends Thread implements IVideoEncodeThread {

    /* renamed from: a */
    private MediaCodec f24015a;

    /* renamed from: b */
    private MediaMuxer f24016b;

    /* renamed from: c */
    private AtomicBoolean f24017c;

    /* renamed from: d */
    private Exception f24018d;

    /* renamed from: e */
    private int f24019e;

    /* renamed from: f */
    private int f24020f;

    /* renamed from: g */
    private int f24021g;

    /* renamed from: h */
    private int f24022h;

    /* renamed from: i */
    private MediaExtractor f24023i;

    /* renamed from: j */
    private int f24024j;

    /* renamed from: k */
    private volatile CountDownLatch f24025k;

    /* renamed from: l */
    private volatile Surface f24026l;

    /* renamed from: m */
    private long f24027m;

    /* renamed from: n */
    private boolean f24028n;

    /* renamed from: o */
    private boolean f24029o;

    /* renamed from: p */
    private long f24030p;

    /* renamed from: q */
    private int f24031q;

    public VideoAppendEncodeThread(MediaExtractor mediaExtractor, MediaMuxer mediaMuxer, int i, int i2, int i3, int i4, int i5, AtomicBoolean atomicBoolean, long j, boolean z, boolean z2, int i6) {
        super("VideoProcessEncodeThread");
        this.f24016b = mediaMuxer;
        this.f24017c = atomicBoolean;
        this.f24023i = mediaExtractor;
        this.f24019e = i;
        this.f24021g = i3;
        this.f24020f = i2;
        this.f24022h = i4;
        this.f24024j = i5;
        this.f24025k = new CountDownLatch(1);
        this.f24027m = j;
        this.f24030p = j;
        this.f24028n = z;
        this.f24029o = z2;
        this.f24031q = i6;
    }

    /* renamed from: c */
    private void m35047c() throws IOException {
        MediaFormat trackFormat = this.f24023i.getTrackFormat(this.f24024j);
        int integer = trackFormat.containsKey("frame-rate") ? trackFormat.getInteger("frame-rate") : VideoProcessor.f24064c;
        MediaFormat createVideoFormat = MediaFormat.createVideoFormat("video/avc", this.f24020f, this.f24021g);
        createVideoFormat.setInteger("color-format", 2130708361);
        createVideoFormat.setInteger(IjkMediaMeta.IJKM_KEY_BITRATE, this.f24019e);
        createVideoFormat.setInteger("frame-rate", integer);
        createVideoFormat.setInteger("i-frame-interval", this.f24022h);
        MediaCodec createEncoderByType = MediaCodec.createEncoderByType("video/avc");
        this.f24015a = createEncoderByType;
        createEncoderByType.configure(createVideoFormat, (Surface) null, (MediaCrypto) null, 1);
        this.f24026l = this.f24015a.createInputSurface();
        this.f24015a.start();
        this.f24025k.countDown();
        MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
        boolean z = false;
        int i = 0;
        while (true) {
            if (this.f24017c.get() && !z) {
                this.f24015a.signalEndOfInputStream();
                z = true;
            }
            int dequeueOutputBuffer = this.f24015a.dequeueOutputBuffer(bufferInfo, 2500L);
            CL.m34891k("encode outputBufferIndex = " + dequeueOutputBuffer, new Object[0]);
            if (z && dequeueOutputBuffer == -1) {
                i++;
                if (i > 10) {
                    CL.m34896f("INFO_TRY_AGAIN_LATER 10 times,force End!", new Object[0]);
                    return;
                }
            } else {
                i = 0;
            }
            if (dequeueOutputBuffer != -1) {
                if (dequeueOutputBuffer == -2) {
                    MediaFormat outputFormat = this.f24015a.getOutputFormat();
                    CL.m34891k("encode newFormat = " + outputFormat, new Object[0]);
                } else if (dequeueOutputBuffer < 0) {
                    CL.m34896f("unexpected result from decoder.dequeueOutputBuffer: " + dequeueOutputBuffer, new Object[0]);
                } else {
                    ByteBuffer outputBuffer = this.f24015a.getOutputBuffer(dequeueOutputBuffer);
                    long j = bufferInfo.presentationTimeUs + this.f24027m;
                    bufferInfo.presentationTimeUs = j;
                    if (this.f24028n || bufferInfo.flags != 2) {
                        if (!this.f24029o && bufferInfo.flags == 4) {
                            CL.m34891k("encoderDone", new Object[0]);
                            this.f24015a.releaseOutputBuffer(dequeueOutputBuffer, false);
                            return;
                        }
                        if (bufferInfo.flags == 4 && j < 0) {
                            bufferInfo.presentationTimeUs = 0L;
                        }
                        CL.m34891k("writeSampleData,size:" + bufferInfo.size + " time:" + (bufferInfo.presentationTimeUs / 1000) + " flag:" + bufferInfo.flags, new Object[0]);
                        this.f24016b.writeSampleData(this.f24031q, outputBuffer, bufferInfo);
                        long j2 = this.f24030p;
                        long j3 = bufferInfo.presentationTimeUs;
                        if (j2 < j3) {
                            this.f24030p = j3;
                        }
                        this.f24015a.releaseOutputBuffer(dequeueOutputBuffer, false);
                        if (bufferInfo.flags == 4) {
                            CL.m34891k("encoderDone", new Object[0]);
                            return;
                        }
                    }
                }
            }
        }
    }

    @Override // com.p201hw.videoprocessor.IVideoEncodeThread
    /* renamed from: a */
    public CountDownLatch mo35041a() {
        return this.f24025k;
    }

    @Override // com.p201hw.videoprocessor.IVideoEncodeThread
    /* renamed from: b */
    public Surface mo35040b() {
        return this.f24026l;
    }

    /* renamed from: d */
    public Exception m35046d() {
        return this.f24018d;
    }

    /* renamed from: e */
    public long m35045e() {
        return this.f24030p;
    }

    /* JADX WARN: Finally extract failed */
    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        MediaCodec mediaCodec;
        super.run();
        try {
            try {
                m35047c();
                mediaCodec = this.f24015a;
                if (mediaCodec == null) {
                    return;
                }
            } catch (Exception e) {
                CL.m34895g(e);
                this.f24018d = e;
                if (this.f24015a == null) {
                    return;
                }
                mediaCodec = this.f24015a;
            }
            mediaCodec.stop();
            this.f24015a.release();
        } catch (Throwable th) {
            MediaCodec mediaCodec2 = this.f24015a;
            if (mediaCodec2 != null) {
                mediaCodec2.stop();
                this.f24015a.release();
            }
            throw th;
        }
    }
}

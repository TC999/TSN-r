package com.p201hw.videoprocessor;

import android.media.MediaCodec;
import android.media.MediaExtractor;
import androidx.annotation.Nullable;
import com.p201hw.videoprocessor.util.FrameDropper;
import com.p201hw.videoprocessor.util.InputSurface;
import com.p201hw.videoprocessor.util.OutputSurface;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.hw.videoprocessor.e */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class VideoDecodeThread extends Thread {

    /* renamed from: a */
    private MediaExtractor f24032a;

    /* renamed from: b */
    private MediaCodec f24033b;

    /* renamed from: c */
    private Integer f24034c;

    /* renamed from: d */
    private Integer f24035d;

    /* renamed from: e */
    private Float f24036e;

    /* renamed from: f */
    private AtomicBoolean f24037f;

    /* renamed from: g */
    private Exception f24038g;

    /* renamed from: h */
    private int f24039h;

    /* renamed from: i */
    private IVideoEncodeThread f24040i;

    /* renamed from: j */
    private InputSurface f24041j;

    /* renamed from: k */
    private OutputSurface f24042k;

    /* renamed from: l */
    private Integer f24043l;

    /* renamed from: m */
    private Integer f24044m;

    /* renamed from: n */
    private boolean f24045n;

    /* renamed from: o */
    private FrameDropper f24046o;

    public VideoDecodeThread(IVideoEncodeThread iVideoEncodeThread, MediaExtractor mediaExtractor, @Nullable Integer num, @Nullable Integer num2, @Nullable Integer num3, @Nullable Integer num4, @Nullable Float f, boolean z, int i, AtomicBoolean atomicBoolean) {
        super("VideoProcessDecodeThread");
        this.f24032a = mediaExtractor;
        this.f24034c = num;
        this.f24035d = num2;
        this.f24036e = f;
        this.f24039h = i;
        this.f24037f = atomicBoolean;
        this.f24040i = iVideoEncodeThread;
        this.f24043l = num4;
        this.f24044m = num3;
        this.f24045n = z;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0232 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0240  */
    /* JADX WARN: Type inference failed for: r11v24 */
    /* JADX WARN: Type inference failed for: r11v6 */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void m35044a() throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 773
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.p201hw.videoprocessor.VideoDecodeThread.m35044a():void");
    }

    /* renamed from: b */
    public Exception m35043b() {
        return this.f24038g;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0024, code lost:
        if (r1 != null) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0026, code lost:
        r1 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0027, code lost:
        r3.f24038g = r1;
        com.p201hw.videoprocessor.util.CL.m34895g(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0055, code lost:
        if (r1 != null) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:?, code lost:
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
            r3.m35044a()     // Catch: java.lang.Throwable -> L2d java.lang.Exception -> L2f
            com.hw.videoprocessor.util.e r0 = r3.f24041j
            if (r0 == 0) goto Ld
            r0.m34872e()
        Ld:
            com.hw.videoprocessor.util.f r0 = r3.f24042k
            if (r0 == 0) goto L14
            r0.m34861i()
        L14:
            android.media.MediaCodec r0 = r3.f24033b     // Catch: java.lang.Exception -> L21
            if (r0 == 0) goto L58
            r0.stop()     // Catch: java.lang.Exception -> L21
            android.media.MediaCodec r0 = r3.f24033b     // Catch: java.lang.Exception -> L21
            r0.release()     // Catch: java.lang.Exception -> L21
            goto L58
        L21:
            r0 = move-exception
            java.lang.Exception r1 = r3.f24038g
            if (r1 != 0) goto L27
        L26:
            r1 = r0
        L27:
            r3.f24038g = r1
            com.p201hw.videoprocessor.util.CL.m34895g(r0)
            goto L58
        L2d:
            r0 = move-exception
            goto L59
        L2f:
            r0 = move-exception
            r3.f24038g = r0     // Catch: java.lang.Throwable -> L2d
            com.p201hw.videoprocessor.util.CL.m34895g(r0)     // Catch: java.lang.Throwable -> L2d
            com.hw.videoprocessor.util.e r0 = r3.f24041j
            if (r0 == 0) goto L3e
            com.hw.videoprocessor.util.e r0 = r3.f24041j
            r0.m34872e()
        L3e:
            com.hw.videoprocessor.util.f r0 = r3.f24042k
            if (r0 == 0) goto L45
            r0.m34861i()
        L45:
            android.media.MediaCodec r0 = r3.f24033b     // Catch: java.lang.Exception -> L52
            if (r0 == 0) goto L58
            r0.stop()     // Catch: java.lang.Exception -> L52
            android.media.MediaCodec r0 = r3.f24033b     // Catch: java.lang.Exception -> L52
            r0.release()     // Catch: java.lang.Exception -> L52
            goto L58
        L52:
            r0 = move-exception
            java.lang.Exception r1 = r3.f24038g
            if (r1 != 0) goto L27
            goto L26
        L58:
            return
        L59:
            com.hw.videoprocessor.util.e r1 = r3.f24041j
            if (r1 == 0) goto L60
            r1.m34872e()
        L60:
            com.hw.videoprocessor.util.f r1 = r3.f24042k
            if (r1 == 0) goto L67
            r1.m34861i()
        L67:
            android.media.MediaCodec r1 = r3.f24033b     // Catch: java.lang.Exception -> L74
            if (r1 == 0) goto L7f
            r1.stop()     // Catch: java.lang.Exception -> L74
            android.media.MediaCodec r1 = r3.f24033b     // Catch: java.lang.Exception -> L74
            r1.release()     // Catch: java.lang.Exception -> L74
            goto L7f
        L74:
            r1 = move-exception
            java.lang.Exception r2 = r3.f24038g
            if (r2 != 0) goto L7a
            r2 = r1
        L7a:
            r3.f24038g = r2
            com.p201hw.videoprocessor.util.CL.m34895g(r1)
        L7f:
            goto L81
        L80:
            throw r0
        L81:
            goto L80
        */
        throw new UnsupportedOperationException("Method not decompiled: com.p201hw.videoprocessor.VideoDecodeThread.run():void");
    }
}

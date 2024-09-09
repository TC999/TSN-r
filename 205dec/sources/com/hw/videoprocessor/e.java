package com.hw.videoprocessor;

import android.media.MediaCodec;
import android.media.MediaExtractor;
import androidx.annotation.Nullable;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* compiled from: VideoDecodeThread.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class e extends Thread {

    /* renamed from: a  reason: collision with root package name */
    private MediaExtractor f37514a;

    /* renamed from: b  reason: collision with root package name */
    private MediaCodec f37515b;

    /* renamed from: c  reason: collision with root package name */
    private Integer f37516c;

    /* renamed from: d  reason: collision with root package name */
    private Integer f37517d;

    /* renamed from: e  reason: collision with root package name */
    private Float f37518e;

    /* renamed from: f  reason: collision with root package name */
    private AtomicBoolean f37519f;

    /* renamed from: g  reason: collision with root package name */
    private Exception f37520g;

    /* renamed from: h  reason: collision with root package name */
    private int f37521h;

    /* renamed from: i  reason: collision with root package name */
    private c f37522i;

    /* renamed from: j  reason: collision with root package name */
    private com.hw.videoprocessor.util.e f37523j;

    /* renamed from: k  reason: collision with root package name */
    private com.hw.videoprocessor.util.f f37524k;

    /* renamed from: l  reason: collision with root package name */
    private Integer f37525l;

    /* renamed from: m  reason: collision with root package name */
    private Integer f37526m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f37527n;

    /* renamed from: o  reason: collision with root package name */
    private com.hw.videoprocessor.util.d f37528o;

    public e(c cVar, MediaExtractor mediaExtractor, @Nullable Integer num, @Nullable Integer num2, @Nullable Integer num3, @Nullable Integer num4, @Nullable Float f4, boolean z3, int i4, AtomicBoolean atomicBoolean) {
        super("VideoProcessDecodeThread");
        this.f37514a = mediaExtractor;
        this.f37516c = num;
        this.f37517d = num2;
        this.f37518e = f4;
        this.f37521h = i4;
        this.f37519f = atomicBoolean;
        this.f37522i = cVar;
        this.f37525l = num4;
        this.f37526m = num3;
        this.f37527n = z3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0232 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0240  */
    /* JADX WARN: Type inference failed for: r11v24 */
    /* JADX WARN: Type inference failed for: r11v6 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a() throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 773
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hw.videoprocessor.e.a():void");
    }

    public Exception b() {
        return this.f37520g;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0024, code lost:
        if (r1 != null) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0026, code lost:
        r1 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0027, code lost:
        r3.f37520g = r1;
        com.hw.videoprocessor.util.c.g(r0);
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
            r3.a()     // Catch: java.lang.Throwable -> L2d java.lang.Exception -> L2f
            com.hw.videoprocessor.util.e r0 = r3.f37523j
            if (r0 == 0) goto Ld
            r0.e()
        Ld:
            com.hw.videoprocessor.util.f r0 = r3.f37524k
            if (r0 == 0) goto L14
            r0.i()
        L14:
            android.media.MediaCodec r0 = r3.f37515b     // Catch: java.lang.Exception -> L21
            if (r0 == 0) goto L58
            r0.stop()     // Catch: java.lang.Exception -> L21
            android.media.MediaCodec r0 = r3.f37515b     // Catch: java.lang.Exception -> L21
            r0.release()     // Catch: java.lang.Exception -> L21
            goto L58
        L21:
            r0 = move-exception
            java.lang.Exception r1 = r3.f37520g
            if (r1 != 0) goto L27
        L26:
            r1 = r0
        L27:
            r3.f37520g = r1
            com.hw.videoprocessor.util.c.g(r0)
            goto L58
        L2d:
            r0 = move-exception
            goto L59
        L2f:
            r0 = move-exception
            r3.f37520g = r0     // Catch: java.lang.Throwable -> L2d
            com.hw.videoprocessor.util.c.g(r0)     // Catch: java.lang.Throwable -> L2d
            com.hw.videoprocessor.util.e r0 = r3.f37523j
            if (r0 == 0) goto L3e
            com.hw.videoprocessor.util.e r0 = r3.f37523j
            r0.e()
        L3e:
            com.hw.videoprocessor.util.f r0 = r3.f37524k
            if (r0 == 0) goto L45
            r0.i()
        L45:
            android.media.MediaCodec r0 = r3.f37515b     // Catch: java.lang.Exception -> L52
            if (r0 == 0) goto L58
            r0.stop()     // Catch: java.lang.Exception -> L52
            android.media.MediaCodec r0 = r3.f37515b     // Catch: java.lang.Exception -> L52
            r0.release()     // Catch: java.lang.Exception -> L52
            goto L58
        L52:
            r0 = move-exception
            java.lang.Exception r1 = r3.f37520g
            if (r1 != 0) goto L27
            goto L26
        L58:
            return
        L59:
            com.hw.videoprocessor.util.e r1 = r3.f37523j
            if (r1 == 0) goto L60
            r1.e()
        L60:
            com.hw.videoprocessor.util.f r1 = r3.f37524k
            if (r1 == 0) goto L67
            r1.i()
        L67:
            android.media.MediaCodec r1 = r3.f37515b     // Catch: java.lang.Exception -> L74
            if (r1 == 0) goto L7f
            r1.stop()     // Catch: java.lang.Exception -> L74
            android.media.MediaCodec r1 = r3.f37515b     // Catch: java.lang.Exception -> L74
            r1.release()     // Catch: java.lang.Exception -> L74
            goto L7f
        L74:
            r1 = move-exception
            java.lang.Exception r2 = r3.f37520g
            if (r2 != 0) goto L7a
            r2 = r1
        L7a:
            r3.f37520g = r2
            com.hw.videoprocessor.util.c.g(r1)
        L7f:
            goto L81
        L80:
            throw r0
        L81:
            goto L80
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hw.videoprocessor.e.run():void");
    }
}

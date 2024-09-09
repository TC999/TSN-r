package com.hw.videoprocessor;

import android.content.Context;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import androidx.annotation.Nullable;
import com.hw.videoprocessor.util.j;
import com.hw.videoprocessor.util.k;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* compiled from: AudioProcessThread.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class a extends Thread implements k {

    /* renamed from: a  reason: collision with root package name */
    private String f37479a;

    /* renamed from: b  reason: collision with root package name */
    private Integer f37480b;

    /* renamed from: c  reason: collision with root package name */
    private Integer f37481c;

    /* renamed from: d  reason: collision with root package name */
    private Float f37482d;

    /* renamed from: e  reason: collision with root package name */
    private Context f37483e;

    /* renamed from: f  reason: collision with root package name */
    private Exception f37484f;

    /* renamed from: g  reason: collision with root package name */
    private MediaMuxer f37485g;

    /* renamed from: h  reason: collision with root package name */
    private int f37486h;

    /* renamed from: i  reason: collision with root package name */
    private MediaExtractor f37487i;

    /* renamed from: j  reason: collision with root package name */
    private CountDownLatch f37488j;

    /* renamed from: k  reason: collision with root package name */
    private j f37489k;

    public a(Context context, String str, MediaMuxer mediaMuxer, @Nullable Integer num, @Nullable Integer num2, @Nullable Float f4, int i4, CountDownLatch countDownLatch) {
        super("VideoProcessDecodeThread");
        this.f37479a = str;
        this.f37480b = num;
        this.f37481c = num2;
        this.f37482d = f4;
        this.f37485g = mediaMuxer;
        this.f37483e = context;
        this.f37486h = i4;
        this.f37487i = new MediaExtractor();
        this.f37488j = countDownLatch;
    }

    private void b() throws Exception {
        this.f37487i.setDataSource(this.f37479a);
        int k4 = i.k(this.f37487i, true);
        if (k4 >= 0) {
            this.f37487i.selectTrack(k4);
            MediaFormat trackFormat = this.f37487i.getTrackFormat(k4);
            String string = trackFormat.containsKey("mime") ? trackFormat.getString("mime") : "audio/mp4a-latm";
            Integer num = this.f37480b;
            Integer valueOf = num == null ? null : Integer.valueOf(num.intValue() * 1000);
            Integer num2 = this.f37481c;
            Integer valueOf2 = num2 != null ? Integer.valueOf(num2.intValue() * 1000) : null;
            if (this.f37488j.await(3L, TimeUnit.SECONDS)) {
                if (this.f37482d == null && string.equals("audio/mp4a-latm")) {
                    com.hw.videoprocessor.util.b.u(this.f37487i, this.f37485g, this.f37486h, valueOf, valueOf2, this);
                } else {
                    Context context = this.f37483e;
                    MediaExtractor mediaExtractor = this.f37487i;
                    MediaMuxer mediaMuxer = this.f37485g;
                    int i4 = this.f37486h;
                    Float f4 = this.f37482d;
                    com.hw.videoprocessor.util.b.v(context, mediaExtractor, mediaMuxer, i4, valueOf, valueOf2, Float.valueOf(f4 == null ? 1.0f : f4.floatValue()), this);
                }
            } else {
                throw new TimeoutException("wait muxerStartLatch timeout!");
            }
        }
        j jVar = this.f37489k;
        if (jVar != null) {
            jVar.a(1.0f);
        }
    }

    @Override // com.hw.videoprocessor.util.k
    public void a(float f4) {
        j jVar = this.f37489k;
        if (jVar != null) {
            jVar.a(f4);
        }
    }

    public Exception c() {
        return this.f37484f;
    }

    public void d(j jVar) {
        this.f37489k = jVar;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        try {
            try {
                b();
            } catch (Exception e4) {
                this.f37484f = e4;
                com.hw.videoprocessor.util.c.g(e4);
            }
        } finally {
            this.f37487i.release();
        }
    }
}

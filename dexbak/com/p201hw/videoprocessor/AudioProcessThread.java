package com.p201hw.videoprocessor;

import android.content.Context;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import androidx.annotation.Nullable;
import com.p201hw.videoprocessor.util.AudioUtil;
import com.p201hw.videoprocessor.util.CL;
import com.p201hw.videoprocessor.util.VideoProgressAve;
import com.p201hw.videoprocessor.util.VideoProgressListener;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import tv.danmaku.ijk.media.player.misc.IMediaFormat;

/* renamed from: com.hw.videoprocessor.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class AudioProcessThread extends Thread implements VideoProgressListener {

    /* renamed from: a */
    private String f23997a;

    /* renamed from: b */
    private Integer f23998b;

    /* renamed from: c */
    private Integer f23999c;

    /* renamed from: d */
    private Float f24000d;

    /* renamed from: e */
    private Context f24001e;

    /* renamed from: f */
    private Exception f24002f;

    /* renamed from: g */
    private MediaMuxer f24003g;

    /* renamed from: h */
    private int f24004h;

    /* renamed from: i */
    private MediaExtractor f24005i;

    /* renamed from: j */
    private CountDownLatch f24006j;

    /* renamed from: k */
    private VideoProgressAve f24007k;

    public AudioProcessThread(Context context, String str, MediaMuxer mediaMuxer, @Nullable Integer num, @Nullable Integer num2, @Nullable Float f, int i, CountDownLatch countDownLatch) {
        super("VideoProcessDecodeThread");
        this.f23997a = str;
        this.f23998b = num;
        this.f23999c = num2;
        this.f24000d = f;
        this.f24003g = mediaMuxer;
        this.f24001e = context;
        this.f24004h = i;
        this.f24005i = new MediaExtractor();
        this.f24006j = countDownLatch;
    }

    /* renamed from: b */
    private void m35050b() throws Exception {
        this.f24005i.setDataSource(this.f23997a);
        int m34986k = VideoUtil.m34986k(this.f24005i, true);
        if (m34986k >= 0) {
            this.f24005i.selectTrack(m34986k);
            MediaFormat trackFormat = this.f24005i.getTrackFormat(m34986k);
            String string = trackFormat.containsKey(IMediaFormat.KEY_MIME) ? trackFormat.getString(IMediaFormat.KEY_MIME) : "audio/mp4a-latm";
            Integer num = this.f23998b;
            Integer valueOf = num == null ? null : Integer.valueOf(num.intValue() * 1000);
            Integer num2 = this.f23999c;
            Integer valueOf2 = num2 != null ? Integer.valueOf(num2.intValue() * 1000) : null;
            if (this.f24006j.await(3L, TimeUnit.SECONDS)) {
                if (this.f24000d == null && string.equals("audio/mp4a-latm")) {
                    AudioUtil.m34903u(this.f24005i, this.f24003g, this.f24004h, valueOf, valueOf2, this);
                } else {
                    Context context = this.f24001e;
                    MediaExtractor mediaExtractor = this.f24005i;
                    MediaMuxer mediaMuxer = this.f24003g;
                    int i = this.f24004h;
                    Float f = this.f24000d;
                    AudioUtil.m34902v(context, mediaExtractor, mediaMuxer, i, valueOf, valueOf2, Float.valueOf(f == null ? 1.0f : f.floatValue()), this);
                }
            } else {
                throw new TimeoutException("wait muxerStartLatch timeout!");
            }
        }
        VideoProgressAve videoProgressAve = this.f24007k;
        if (videoProgressAve != null) {
            videoProgressAve.m34848a(1.0f);
        }
    }

    @Override // com.p201hw.videoprocessor.util.VideoProgressListener
    /* renamed from: a */
    public void mo34843a(float f) {
        VideoProgressAve videoProgressAve = this.f24007k;
        if (videoProgressAve != null) {
            videoProgressAve.m34848a(f);
        }
    }

    /* renamed from: c */
    public Exception m35049c() {
        return this.f24002f;
    }

    /* renamed from: d */
    public void m35048d(VideoProgressAve videoProgressAve) {
        this.f24007k = videoProgressAve;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        try {
            try {
                m35050b();
            } catch (Exception e) {
                this.f24002f = e;
                CL.m34895g(e);
            }
        } finally {
            this.f24005i.release();
        }
    }
}

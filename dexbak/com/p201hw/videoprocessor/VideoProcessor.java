package com.p201hw.videoprocessor;

import android.annotation.TargetApi;
import android.content.Context;
import android.media.MediaCodec;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.media.MediaMetadataRetriever;
import android.media.MediaMuxer;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.p201hw.videoprocessor.util.AudioUtil;
import com.p201hw.videoprocessor.util.CL;
import com.p201hw.videoprocessor.util.VideoMultiStepProgress;
import com.p201hw.videoprocessor.util.VideoProgressAve;
import com.p201hw.videoprocessor.util.VideoProgressListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

@TargetApi(21)
/* renamed from: com.hw.videoprocessor.h */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class VideoProcessor {

    /* renamed from: a */
    static final String f24062a = "VideoProcessor";

    /* renamed from: b */
    static final String f24063b = "video/avc";

    /* renamed from: c */
    public static int f24064c = 15;

    /* renamed from: d */
    public static final int f24065d = 1;

    /* renamed from: e */
    public static final int f24066e = 192000;

    /* renamed from: f */
    public static boolean f24067f = true;

    /* renamed from: g */
    static final int f24068g = 2500;

    /* compiled from: VideoProcessor.java */
    /* renamed from: com.hw.videoprocessor.h$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    static class RunnableC7069a implements Runnable {

        /* renamed from: a */
        final /* synthetic */ String f24069a;

        /* renamed from: b */
        final /* synthetic */ File f24070b;

        /* renamed from: c */
        final /* synthetic */ Integer f24071c;

        /* renamed from: d */
        final /* synthetic */ Integer f24072d;

        /* renamed from: e */
        final /* synthetic */ CountDownLatch f24073e;

        RunnableC7069a(String str, File file, Integer num, Integer num2, CountDownLatch countDownLatch) {
            this.f24069a = str;
            this.f24070b = file;
            this.f24071c = num;
            this.f24072d = num2;
            this.f24073e = countDownLatch;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                try {
                    AudioUtil.m34917g(this.f24069a, this.f24070b.getAbsolutePath(), this.f24071c, this.f24072d);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            } finally {
                this.f24073e.countDown();
            }
        }
    }

    /* compiled from: VideoProcessor.java */
    /* renamed from: com.hw.videoprocessor.h$b */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    static class RunnableC7070b implements Runnable {

        /* renamed from: a */
        final /* synthetic */ String f24074a;

        /* renamed from: b */
        final /* synthetic */ File f24075b;

        /* renamed from: c */
        final /* synthetic */ int f24076c;

        /* renamed from: d */
        final /* synthetic */ int f24077d;

        /* renamed from: e */
        final /* synthetic */ CountDownLatch f24078e;

        RunnableC7070b(String str, File file, int i, int i2, CountDownLatch countDownLatch) {
            this.f24074a = str;
            this.f24075b = file;
            this.f24076c = i;
            this.f24077d = i2;
            this.f24078e = countDownLatch;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                try {
                    String str = this.f24074a;
                    String absolutePath = this.f24075b.getAbsolutePath();
                    int i = this.f24076c;
                    int i2 = this.f24077d;
                    AudioUtil.m34917g(str, absolutePath, 0, Integer.valueOf(i > i2 ? i2 * 1000 : i * 1000));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            } finally {
                this.f24078e.countDown();
            }
        }
    }

    /* compiled from: VideoProcessor.java */
    /* renamed from: com.hw.videoprocessor.h$c */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class C7071c {

        /* renamed from: a */
        private Context f24079a;

        /* renamed from: b */
        private String f24080b;

        /* renamed from: c */
        private String f24081c;
        @Nullable

        /* renamed from: d */
        private Integer f24082d;
        @Nullable

        /* renamed from: e */
        private Integer f24083e;
        @Nullable

        /* renamed from: f */
        private Integer f24084f;
        @Nullable

        /* renamed from: g */
        private Integer f24085g;
        @Nullable

        /* renamed from: h */
        private Float f24086h;
        @Nullable

        /* renamed from: i */
        private Boolean f24087i;
        @Nullable

        /* renamed from: j */
        private Integer f24088j;
        @Nullable

        /* renamed from: k */
        private Integer f24089k;
        @Nullable

        /* renamed from: l */
        private Integer f24090l;
        @Nullable

        /* renamed from: m */
        private VideoProgressListener f24091m;

        /* renamed from: n */
        private boolean f24092n = true;

        public C7071c(Context context) {
            this.f24079a = context;
        }

        /* renamed from: A */
        public C7071c m35025A(VideoProgressListener videoProgressListener) {
            this.f24091m = videoProgressListener;
            return this;
        }

        /* renamed from: B */
        public C7071c m35024B(float f) {
            this.f24086h = Float.valueOf(f);
            return this;
        }

        /* renamed from: C */
        public C7071c m35023C(int i) {
            this.f24084f = Integer.valueOf(i);
            return this;
        }

        /* renamed from: p */
        public C7071c m35007p(int i) {
            this.f24088j = Integer.valueOf(i);
            return this;
        }

        /* renamed from: q */
        public C7071c m35006q(boolean z) {
            this.f24087i = Boolean.valueOf(z);
            return this;
        }

        /* renamed from: r */
        public C7071c m35005r(boolean z) {
            this.f24092n = z;
            return this;
        }

        /* renamed from: s */
        public C7071c m35004s(int i) {
            this.f24085g = Integer.valueOf(i);
            return this;
        }

        /* renamed from: t */
        public C7071c m35003t(int i) {
            this.f24089k = Integer.valueOf(i);
            return this;
        }

        /* renamed from: u */
        public C7071c m35002u(int i) {
            this.f24090l = Integer.valueOf(i);
            return this;
        }

        /* renamed from: v */
        public C7071c m35001v(String str) {
            this.f24080b = str;
            return this;
        }

        /* renamed from: w */
        public C7071c m35000w(int i) {
            this.f24083e = Integer.valueOf(i);
            return this;
        }

        /* renamed from: x */
        public C7071c m34999x(int i) {
            this.f24082d = Integer.valueOf(i);
            return this;
        }

        /* renamed from: y */
        public C7071c m34998y(String str) {
            this.f24081c = str;
            return this;
        }

        /* renamed from: z */
        public void m34997z() throws Exception {
            VideoProcessor.m35031e(this.f24079a, this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x0216  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0219  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:80:0x0310 -> B:46:0x020d). Please submit an issue!!! */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void m35035a(android.content.Context r37, java.lang.String r38, java.lang.String r39, @androidx.annotation.IntRange(from = 0, m60035to = 100) int r40, float r41, float r42) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 1138
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.p201hw.videoprocessor.VideoProcessor.m35035a(android.content.Context, java.lang.String, java.lang.String, int, float, float):void");
    }

    /* renamed from: b */
    public static void m35034b(Context context, String str, String str2, float f) throws Exception {
        m35030f(context).m35001v(str).m34998y(str2).m35024B(f).m34997z();
    }

    /* renamed from: c */
    public static void m35033c(Context context, String str, String str2, int i, int i2) throws Exception {
        m35030f(context).m35001v(str).m34998y(str2).m35023C(i).m35004s(i2).m34997z();
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x01fb, code lost:
        if (r12 != 0.0f) goto L163;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0375, code lost:
        if (r9 != 0.0f) goto L194;
     */
    /* JADX WARN: Removed duplicated region for block: B:118:0x056c A[Catch: all -> 0x05a2, TryCatch #0 {all -> 0x05a2, blocks: (B:95:0x04a4, B:100:0x04b2, B:102:0x04d0, B:104:0x04eb, B:108:0x0500, B:112:0x0539, B:114:0x0543, B:118:0x056c, B:119:0x058a, B:121:0x058f, B:122:0x0591), top: B:182:0x04a4 }] */
    /* JADX WARN: Removed duplicated region for block: B:121:0x058f A[Catch: all -> 0x05a2, TryCatch #0 {all -> 0x05a2, blocks: (B:95:0x04a4, B:100:0x04b2, B:102:0x04d0, B:104:0x04eb, B:108:0x0500, B:112:0x0539, B:114:0x0543, B:118:0x056c, B:119:0x058a, B:121:0x058f, B:122:0x0591), top: B:182:0x04a4 }] */
    /* JADX WARN: Removed duplicated region for block: B:201:0x04ab A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:98:0x04af  */
    /* renamed from: d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void m35032d(android.content.Context r38, java.lang.String r39, java.lang.String r40, java.lang.String r41, java.lang.Integer r42, java.lang.Integer r43, @androidx.annotation.IntRange(from = 0, m60035to = 100) int r44, @androidx.annotation.IntRange(from = 0, m60035to = 100) int r45, float r46, float r47) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 1809
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.p201hw.videoprocessor.VideoProcessor.m35032d(android.content.Context, java.lang.String, java.lang.String, java.lang.String, java.lang.Integer, java.lang.Integer, int, int, float, float):void");
    }

    /* renamed from: e */
    public static void m35031e(@NonNull Context context, @NonNull C7071c c7071c) throws Exception {
        int i;
        int i2;
        MediaMuxer mediaMuxer;
        Integer num;
        int i3;
        MediaMuxer mediaMuxer2;
        long j;
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        mediaMetadataRetriever.setDataSource(c7071c.f24080b);
        int parseInt = Integer.parseInt(mediaMetadataRetriever.extractMetadata(18));
        int parseInt2 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(19));
        int parseInt3 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(24));
        int parseInt4 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(20));
        int parseInt5 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(9));
        mediaMetadataRetriever.release();
        if (c7071c.f24088j == null) {
            c7071c.f24088j = Integer.valueOf(parseInt4);
        }
        if (c7071c.f24090l == null) {
            c7071c.f24090l = 1;
        }
        if (c7071c.f24082d != null) {
            parseInt = c7071c.f24082d.intValue();
        }
        if (c7071c.f24083e != null) {
            parseInt2 = c7071c.f24083e.intValue();
        }
        if (parseInt % 2 != 0) {
            parseInt++;
        }
        if (parseInt2 % 2 != 0) {
            parseInt2++;
        }
        if (parseInt3 == 90 || parseInt3 == 270) {
            i = parseInt;
            i2 = parseInt2;
        } else {
            i2 = parseInt;
            i = parseInt2;
        }
        MediaExtractor mediaExtractor = new MediaExtractor();
        mediaExtractor.setDataSource(c7071c.f24080b);
        int m34986k = VideoUtil.m34986k(mediaExtractor, false);
        int m34986k2 = VideoUtil.m34986k(mediaExtractor, true);
        MediaMuxer mediaMuxer3 = new MediaMuxer(c7071c.f24081c, 0);
        boolean booleanValue = c7071c.f24087i == null ? true : c7071c.f24087i.booleanValue();
        Integer num2 = c7071c.f24085g;
        if (m34986k2 >= 0) {
            MediaFormat trackFormat = mediaExtractor.getTrackFormat(m34986k2);
            int m34915i = AudioUtil.m34915i(trackFormat);
            int integer = trackFormat.getInteger("channel-count");
            int integer2 = trackFormat.getInteger("sample-rate");
            int m34914j = AudioUtil.m34914j(trackFormat);
            MediaFormat createAudioFormat = MediaFormat.createAudioFormat("audio/mp4a-latm", integer2, integer);
            createAudioFormat.setInteger(IjkMediaMeta.IJKM_KEY_BITRATE, m34915i);
            createAudioFormat.setInteger("aac-profile", 2);
            createAudioFormat.setInteger("max-input-size", m34914j);
            if (booleanValue) {
                if (c7071c.f24084f == null && c7071c.f24085g == null && c7071c.f24086h == null) {
                    mediaMuxer2 = mediaMuxer3;
                } else {
                    long j2 = trackFormat.getLong("durationUs");
                    if (c7071c.f24084f == null || c7071c.f24085g == null) {
                        mediaMuxer2 = mediaMuxer3;
                        j = j2;
                    } else {
                        mediaMuxer2 = mediaMuxer3;
                        j = (c7071c.f24085g.intValue() - c7071c.f24084f.intValue()) * 1000;
                    }
                    if (c7071c.f24086h != null) {
                        j = ((float) j) / c7071c.f24086h.floatValue();
                    }
                    createAudioFormat.setLong("durationUs", j);
                }
            } else {
                mediaMuxer2 = mediaMuxer3;
                long j3 = parseInt5 * 1000;
                long j4 = trackFormat.getLong("durationUs");
                if (c7071c.f24084f != null || c7071c.f24085g != null || c7071c.f24086h != null) {
                    if (c7071c.f24084f != null && c7071c.f24085g != null) {
                        j3 = (c7071c.f24085g.intValue() - c7071c.f24084f.intValue()) * 1000;
                    }
                    if (c7071c.f24086h != null) {
                        j3 = ((float) j3) / c7071c.f24086h.floatValue();
                    }
                    if (j3 >= j4) {
                        j3 = j4;
                    }
                    createAudioFormat.setLong("durationUs", j3);
                    num2 = Integer.valueOf((c7071c.f24084f == null ? 0 : c7071c.f24084f.intValue()) + ((int) (j3 / 1000)));
                }
            }
            AudioUtil.m34919e(createAudioFormat, 2, integer2, integer);
            mediaMuxer = mediaMuxer2;
            i3 = mediaMuxer.addTrack(createAudioFormat);
            num = num2;
        } else {
            mediaMuxer = mediaMuxer3;
            num = num2;
            i3 = 0;
        }
        mediaExtractor.selectTrack(m34986k);
        if (c7071c.f24084f != null) {
            mediaExtractor.seekTo(c7071c.f24084f.intValue() * 1000, 0);
        } else {
            mediaExtractor.seekTo(0L, 0);
        }
        VideoProgressAve videoProgressAve = new VideoProgressAve(c7071c.f24091m);
        videoProgressAve.m34845d(c7071c.f24086h);
        videoProgressAve.m34844e(c7071c.f24084f == null ? 0 : c7071c.f24084f.intValue());
        if (c7071c.f24085g != null) {
            parseInt5 = c7071c.f24085g.intValue();
        }
        videoProgressAve.m34846c(parseInt5);
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        CountDownLatch countDownLatch = new CountDownLatch(1);
        VideoEncodeThread videoEncodeThread = new VideoEncodeThread(mediaExtractor, mediaMuxer, c7071c.f24088j.intValue(), i2, i, c7071c.f24090l.intValue(), c7071c.f24089k == null ? f24064c : c7071c.f24089k.intValue(), m34986k, atomicBoolean, countDownLatch);
        int m34992e = VideoUtil.m34992e(c7071c.f24080b);
        if (m34992e <= 0) {
            m34992e = (int) Math.ceil(VideoUtil.m34994c(c7071c.f24080b));
        }
        VideoDecodeThread videoDecodeThread = new VideoDecodeThread(videoEncodeThread, mediaExtractor, c7071c.f24084f, c7071c.f24085g, Integer.valueOf(m34992e), Integer.valueOf(c7071c.f24089k == null ? f24064c : c7071c.f24089k.intValue()), c7071c.f24086h, c7071c.f24092n, m34986k, atomicBoolean);
        AudioProcessThread audioProcessThread = new AudioProcessThread(context, c7071c.f24080b, mediaMuxer, c7071c.f24084f, num, booleanValue ? c7071c.f24086h : null, i3, countDownLatch);
        videoEncodeThread.m35036f(videoProgressAve);
        audioProcessThread.m35048d(videoProgressAve);
        videoDecodeThread.start();
        videoEncodeThread.start();
        audioProcessThread.start();
        try {
            long currentTimeMillis = System.currentTimeMillis();
            videoDecodeThread.join();
            videoEncodeThread.join();
            long currentTimeMillis2 = System.currentTimeMillis();
            audioProcessThread.join();
            CL.m34882t(String.format("编解码:%dms,音频:%dms", Long.valueOf(currentTimeMillis2 - currentTimeMillis), Long.valueOf(System.currentTimeMillis() - currentTimeMillis)), new Object[0]);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            mediaMuxer.release();
            mediaExtractor.release();
        } catch (Exception e2) {
            CL.m34895g(e2);
        }
        if (videoEncodeThread.m35038d() == null) {
            if (videoDecodeThread.m35043b() == null) {
                if (audioProcessThread.m35049c() != null) {
                    throw audioProcessThread.m35049c();
                }
                return;
            }
            throw videoDecodeThread.m35043b();
        }
        throw videoEncodeThread.m35038d();
    }

    /* renamed from: f */
    public static C7071c m35030f(Context context) {
        return new C7071c(context);
    }

    /* renamed from: g */
    public static void m35029g(Context context, String str, String str2, boolean z, @Nullable VideoProgressListener videoProgressListener) throws Exception {
        File file = new File(context.getCacheDir(), System.currentTimeMillis() + ".temp");
        File file2 = new File(context.getCacheDir(), System.currentTimeMillis() + ".temp2");
        try {
            MediaExtractor mediaExtractor = new MediaExtractor();
            mediaExtractor.setDataSource(str);
            mediaExtractor.selectTrack(VideoUtil.m34986k(mediaExtractor, false));
            ArrayList arrayList = new ArrayList();
            int i = 0;
            int i2 = 0;
            while (true) {
                int sampleFlags = mediaExtractor.getSampleFlags();
                if (sampleFlags > 0 && (sampleFlags & 1) != 0) {
                    i++;
                }
                long sampleTime = mediaExtractor.getSampleTime();
                if (sampleTime < 0) {
                    break;
                }
                arrayList.add(Long.valueOf(sampleTime));
                i2++;
                mediaExtractor.advance();
            }
            mediaExtractor.release();
            if (i2 != i && i2 != i + 1) {
                int i3 = 1;
                VideoMultiStepProgress videoMultiStepProgress = new VideoMultiStepProgress(new float[]{0.45f, 0.1f, 0.45f}, videoProgressListener);
                videoMultiStepProgress.m34850b(0);
                float f = i;
                float f2 = 1.0f + ((i2 - i) / f);
                MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                mediaMetadataRetriever.setDataSource(str);
                int parseInt = Integer.parseInt(mediaMetadataRetriever.extractMetadata(20));
                int parseInt2 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(9));
                try {
                    m35030f(context).m35001v(str).m34998y(file.getAbsolutePath()).m35007p((int) (parseInt * f2)).m35002u(0).m35025A(videoMultiStepProgress).m34997z();
                } catch (MediaCodec.CodecException e) {
                    CL.m34895g(e);
                    m35030f(context).m35001v(str).m34998y(file.getAbsolutePath()).m35007p((int) (parseInt * f2)).m35002u(-1).m35025A(videoMultiStepProgress).m34997z();
                }
                videoMultiStepProgress.m34850b(1);
                m35027i(file.getAbsolutePath(), file2.getAbsolutePath(), z, null, videoMultiStepProgress);
                int i4 = (int) (f / (parseInt2 / 1000.0f));
                if (i4 != 0) {
                    i3 = i4;
                }
                videoMultiStepProgress.m34850b(2);
                m35030f(context).m35001v(file2.getAbsolutePath()).m34998y(str2).m35007p(parseInt).m35002u(i3).m35025A(videoMultiStepProgress).m34997z();
            }
            m35027i(str, str2, z, arrayList, videoProgressListener);
        } finally {
            file.delete();
            file2.delete();
        }
    }

    /* renamed from: h */
    public static void m35028h(String str, String str2, boolean z) throws IOException {
        m35027i(str, str2, z, null, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x012e A[Catch: all -> 0x01f5, Exception -> 0x01f7, TryCatch #1 {Exception -> 0x01f7, blocks: (B:12:0x007e, B:14:0x0084, B:16:0x0090, B:19:0x00aa, B:48:0x012e, B:50:0x0139, B:52:0x0149, B:55:0x0160, B:58:0x0176, B:60:0x017b, B:63:0x018a, B:65:0x0194, B:66:0x0199, B:67:0x019f, B:70:0x01a8, B:73:0x01bc, B:75:0x01c1, B:78:0x01cf, B:79:0x01d6, B:81:0x01dc, B:22:0x00c0, B:24:0x00c5, B:27:0x00d2, B:28:0x00d7, B:33:0x00e8, B:36:0x00f3, B:39:0x0109, B:41:0x010e, B:44:0x011b, B:45:0x0120, B:82:0x01e2), top: B:94:0x007e, outer: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x01dc A[Catch: all -> 0x01f5, Exception -> 0x01f7, TryCatch #1 {Exception -> 0x01f7, blocks: (B:12:0x007e, B:14:0x0084, B:16:0x0090, B:19:0x00aa, B:48:0x012e, B:50:0x0139, B:52:0x0149, B:55:0x0160, B:58:0x0176, B:60:0x017b, B:63:0x018a, B:65:0x0194, B:66:0x0199, B:67:0x019f, B:70:0x01a8, B:73:0x01bc, B:75:0x01c1, B:78:0x01cf, B:79:0x01d6, B:81:0x01dc, B:22:0x00c0, B:24:0x00c5, B:27:0x00d2, B:28:0x00d7, B:33:0x00e8, B:36:0x00f3, B:39:0x0109, B:41:0x010e, B:44:0x011b, B:45:0x0120, B:82:0x01e2), top: B:94:0x007e, outer: #0 }] */
    /* renamed from: i */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void m35027i(java.lang.String r28, java.lang.String r29, boolean r30, java.util.List<java.lang.Long> r31, @androidx.annotation.Nullable com.p201hw.videoprocessor.util.VideoProgressListener r32) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 523
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.p201hw.videoprocessor.VideoProcessor.m35027i(java.lang.String, java.lang.String, boolean, java.util.List, com.hw.videoprocessor.util.k):void");
    }

    /* renamed from: j */
    public static void m35026j(Context context, String str, String str2, int i, int i2) throws Exception {
        m35030f(context).m35001v(str).m34998y(str2).m34999x(i).m35000w(i2).m34997z();
    }
}

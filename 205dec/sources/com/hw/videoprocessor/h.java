package com.hw.videoprocessor;

import android.annotation.TargetApi;
import android.content.Context;
import android.media.MediaCodec;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.media.MediaMetadataRetriever;
import android.media.MediaMuxer;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.hw.videoprocessor.util.j;
import com.hw.videoprocessor.util.k;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* compiled from: VideoProcessor.java */
@TargetApi(21)
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    static final String f37544a = "VideoProcessor";

    /* renamed from: b  reason: collision with root package name */
    static final String f37545b = "video/avc";

    /* renamed from: c  reason: collision with root package name */
    public static int f37546c = 15;

    /* renamed from: d  reason: collision with root package name */
    public static final int f37547d = 1;

    /* renamed from: e  reason: collision with root package name */
    public static final int f37548e = 192000;

    /* renamed from: f  reason: collision with root package name */
    public static boolean f37549f = true;

    /* renamed from: g  reason: collision with root package name */
    static final int f37550g = 2500;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* compiled from: VideoProcessor.java */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    static class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f37551a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ File f37552b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Integer f37553c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ Integer f37554d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ CountDownLatch f37555e;

        a(String str, File file, Integer num, Integer num2, CountDownLatch countDownLatch) {
            this.f37551a = str;
            this.f37552b = file;
            this.f37553c = num;
            this.f37554d = num2;
            this.f37555e = countDownLatch;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                try {
                    com.hw.videoprocessor.util.b.g(this.f37551a, this.f37552b.getAbsolutePath(), this.f37553c, this.f37554d);
                } catch (IOException e4) {
                    throw new RuntimeException(e4);
                }
            } finally {
                this.f37555e.countDown();
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* compiled from: VideoProcessor.java */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    static class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f37556a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ File f37557b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f37558c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ int f37559d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ CountDownLatch f37560e;

        b(String str, File file, int i4, int i5, CountDownLatch countDownLatch) {
            this.f37556a = str;
            this.f37557b = file;
            this.f37558c = i4;
            this.f37559d = i5;
            this.f37560e = countDownLatch;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                try {
                    String str = this.f37556a;
                    String absolutePath = this.f37557b.getAbsolutePath();
                    int i4 = this.f37558c;
                    int i5 = this.f37559d;
                    com.hw.videoprocessor.util.b.g(str, absolutePath, 0, Integer.valueOf(i4 > i5 ? i5 * 1000 : i4 * 1000));
                } catch (IOException e4) {
                    throw new RuntimeException(e4);
                }
            } finally {
                this.f37560e.countDown();
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* compiled from: VideoProcessor.java */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        private Context f37561a;

        /* renamed from: b  reason: collision with root package name */
        private String f37562b;

        /* renamed from: c  reason: collision with root package name */
        private String f37563c;
        @Nullable

        /* renamed from: d  reason: collision with root package name */
        private Integer f37564d;
        @Nullable

        /* renamed from: e  reason: collision with root package name */
        private Integer f37565e;
        @Nullable

        /* renamed from: f  reason: collision with root package name */
        private Integer f37566f;
        @Nullable

        /* renamed from: g  reason: collision with root package name */
        private Integer f37567g;
        @Nullable

        /* renamed from: h  reason: collision with root package name */
        private Float f37568h;
        @Nullable

        /* renamed from: i  reason: collision with root package name */
        private Boolean f37569i;
        @Nullable

        /* renamed from: j  reason: collision with root package name */
        private Integer f37570j;
        @Nullable

        /* renamed from: k  reason: collision with root package name */
        private Integer f37571k;
        @Nullable

        /* renamed from: l  reason: collision with root package name */
        private Integer f37572l;
        @Nullable

        /* renamed from: m  reason: collision with root package name */
        private k f37573m;

        /* renamed from: n  reason: collision with root package name */
        private boolean f37574n = true;

        public c(Context context) {
            this.f37561a = context;
        }

        public c A(k kVar) {
            this.f37573m = kVar;
            return this;
        }

        public c B(float f4) {
            this.f37568h = Float.valueOf(f4);
            return this;
        }

        public c C(int i4) {
            this.f37566f = Integer.valueOf(i4);
            return this;
        }

        public c p(int i4) {
            this.f37570j = Integer.valueOf(i4);
            return this;
        }

        public c q(boolean z3) {
            this.f37569i = Boolean.valueOf(z3);
            return this;
        }

        public c r(boolean z3) {
            this.f37574n = z3;
            return this;
        }

        public c s(int i4) {
            this.f37567g = Integer.valueOf(i4);
            return this;
        }

        public c t(int i4) {
            this.f37571k = Integer.valueOf(i4);
            return this;
        }

        public c u(int i4) {
            this.f37572l = Integer.valueOf(i4);
            return this;
        }

        public c v(String str) {
            this.f37562b = str;
            return this;
        }

        public c w(int i4) {
            this.f37565e = Integer.valueOf(i4);
            return this;
        }

        public c x(int i4) {
            this.f37564d = Integer.valueOf(i4);
            return this;
        }

        public c y(String str) {
            this.f37563c = str;
            return this;
        }

        public void z() throws Exception {
            h.e(this.f37561a, this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x0216  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0219  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:80:0x0310 -> B:46:0x020d). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void a(android.content.Context r37, java.lang.String r38, java.lang.String r39, @androidx.annotation.IntRange(from = 0, to = 100) int r40, float r41, float r42) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 1138
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hw.videoprocessor.h.a(android.content.Context, java.lang.String, java.lang.String, int, float, float):void");
    }

    public static void b(Context context, String str, String str2, float f4) throws Exception {
        f(context).v(str).y(str2).B(f4).z();
    }

    public static void c(Context context, String str, String str2, int i4, int i5) throws Exception {
        f(context).v(str).y(str2).C(i4).s(i5).z();
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
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void d(android.content.Context r38, java.lang.String r39, java.lang.String r40, java.lang.String r41, java.lang.Integer r42, java.lang.Integer r43, @androidx.annotation.IntRange(from = 0, to = 100) int r44, @androidx.annotation.IntRange(from = 0, to = 100) int r45, float r46, float r47) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 1809
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hw.videoprocessor.h.d(android.content.Context, java.lang.String, java.lang.String, java.lang.String, java.lang.Integer, java.lang.Integer, int, int, float, float):void");
    }

    public static void e(@NonNull Context context, @NonNull c cVar) throws Exception {
        int i4;
        int i5;
        MediaMuxer mediaMuxer;
        Integer num;
        int i6;
        MediaMuxer mediaMuxer2;
        long j4;
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        mediaMetadataRetriever.setDataSource(cVar.f37562b);
        int parseInt = Integer.parseInt(mediaMetadataRetriever.extractMetadata(18));
        int parseInt2 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(19));
        int parseInt3 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(24));
        int parseInt4 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(20));
        int parseInt5 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(9));
        mediaMetadataRetriever.release();
        if (cVar.f37570j == null) {
            cVar.f37570j = Integer.valueOf(parseInt4);
        }
        if (cVar.f37572l == null) {
            cVar.f37572l = 1;
        }
        if (cVar.f37564d != null) {
            parseInt = cVar.f37564d.intValue();
        }
        if (cVar.f37565e != null) {
            parseInt2 = cVar.f37565e.intValue();
        }
        if (parseInt % 2 != 0) {
            parseInt++;
        }
        if (parseInt2 % 2 != 0) {
            parseInt2++;
        }
        if (parseInt3 == 90 || parseInt3 == 270) {
            i4 = parseInt;
            i5 = parseInt2;
        } else {
            i5 = parseInt;
            i4 = parseInt2;
        }
        MediaExtractor mediaExtractor = new MediaExtractor();
        mediaExtractor.setDataSource(cVar.f37562b);
        int k4 = i.k(mediaExtractor, false);
        int k5 = i.k(mediaExtractor, true);
        MediaMuxer mediaMuxer3 = new MediaMuxer(cVar.f37563c, 0);
        boolean booleanValue = cVar.f37569i == null ? true : cVar.f37569i.booleanValue();
        Integer num2 = cVar.f37567g;
        if (k5 >= 0) {
            MediaFormat trackFormat = mediaExtractor.getTrackFormat(k5);
            int i7 = com.hw.videoprocessor.util.b.i(trackFormat);
            int integer = trackFormat.getInteger(com.bykv.vk.component.ttvideo.player.MediaFormat.KEY_CHANNEL_COUNT);
            int integer2 = trackFormat.getInteger(com.bykv.vk.component.ttvideo.player.MediaFormat.KEY_SAMPLE_RATE);
            int j5 = com.hw.videoprocessor.util.b.j(trackFormat);
            MediaFormat createAudioFormat = MediaFormat.createAudioFormat("audio/mp4a-latm", integer2, integer);
            createAudioFormat.setInteger("bitrate", i7);
            createAudioFormat.setInteger("aac-profile", 2);
            createAudioFormat.setInteger("max-input-size", j5);
            if (booleanValue) {
                if (cVar.f37566f == null && cVar.f37567g == null && cVar.f37568h == null) {
                    mediaMuxer2 = mediaMuxer3;
                } else {
                    long j6 = trackFormat.getLong("durationUs");
                    if (cVar.f37566f == null || cVar.f37567g == null) {
                        mediaMuxer2 = mediaMuxer3;
                        j4 = j6;
                    } else {
                        mediaMuxer2 = mediaMuxer3;
                        j4 = (cVar.f37567g.intValue() - cVar.f37566f.intValue()) * 1000;
                    }
                    if (cVar.f37568h != null) {
                        j4 = ((float) j4) / cVar.f37568h.floatValue();
                    }
                    createAudioFormat.setLong("durationUs", j4);
                }
            } else {
                mediaMuxer2 = mediaMuxer3;
                long j7 = parseInt5 * 1000;
                long j8 = trackFormat.getLong("durationUs");
                if (cVar.f37566f != null || cVar.f37567g != null || cVar.f37568h != null) {
                    if (cVar.f37566f != null && cVar.f37567g != null) {
                        j7 = (cVar.f37567g.intValue() - cVar.f37566f.intValue()) * 1000;
                    }
                    if (cVar.f37568h != null) {
                        j7 = ((float) j7) / cVar.f37568h.floatValue();
                    }
                    if (j7 >= j8) {
                        j7 = j8;
                    }
                    createAudioFormat.setLong("durationUs", j7);
                    num2 = Integer.valueOf((cVar.f37566f == null ? 0 : cVar.f37566f.intValue()) + ((int) (j7 / 1000)));
                }
            }
            com.hw.videoprocessor.util.b.e(createAudioFormat, 2, integer2, integer);
            mediaMuxer = mediaMuxer2;
            i6 = mediaMuxer.addTrack(createAudioFormat);
            num = num2;
        } else {
            mediaMuxer = mediaMuxer3;
            num = num2;
            i6 = 0;
        }
        mediaExtractor.selectTrack(k4);
        if (cVar.f37566f != null) {
            mediaExtractor.seekTo(cVar.f37566f.intValue() * 1000, 0);
        } else {
            mediaExtractor.seekTo(0L, 0);
        }
        j jVar = new j(cVar.f37573m);
        jVar.d(cVar.f37568h);
        jVar.e(cVar.f37566f == null ? 0 : cVar.f37566f.intValue());
        if (cVar.f37567g != null) {
            parseInt5 = cVar.f37567g.intValue();
        }
        jVar.c(parseInt5);
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        CountDownLatch countDownLatch = new CountDownLatch(1);
        g gVar = new g(mediaExtractor, mediaMuxer, cVar.f37570j.intValue(), i5, i4, cVar.f37572l.intValue(), cVar.f37571k == null ? f37546c : cVar.f37571k.intValue(), k4, atomicBoolean, countDownLatch);
        int e4 = i.e(cVar.f37562b);
        if (e4 <= 0) {
            e4 = (int) Math.ceil(i.c(cVar.f37562b));
        }
        e eVar = new e(gVar, mediaExtractor, cVar.f37566f, cVar.f37567g, Integer.valueOf(e4), Integer.valueOf(cVar.f37571k == null ? f37546c : cVar.f37571k.intValue()), cVar.f37568h, cVar.f37574n, k4, atomicBoolean);
        com.hw.videoprocessor.a aVar = new com.hw.videoprocessor.a(context, cVar.f37562b, mediaMuxer, cVar.f37566f, num, booleanValue ? cVar.f37568h : null, i6, countDownLatch);
        gVar.f(jVar);
        aVar.d(jVar);
        eVar.start();
        gVar.start();
        aVar.start();
        try {
            long currentTimeMillis = System.currentTimeMillis();
            eVar.join();
            gVar.join();
            long currentTimeMillis2 = System.currentTimeMillis();
            aVar.join();
            com.hw.videoprocessor.util.c.t(String.format("\u7f16\u89e3\u7801:%dms,\u97f3\u9891:%dms", Long.valueOf(currentTimeMillis2 - currentTimeMillis), Long.valueOf(System.currentTimeMillis() - currentTimeMillis)), new Object[0]);
        } catch (InterruptedException e5) {
            e5.printStackTrace();
        }
        try {
            mediaMuxer.release();
            mediaExtractor.release();
        } catch (Exception e6) {
            com.hw.videoprocessor.util.c.g(e6);
        }
        if (gVar.d() == null) {
            if (eVar.b() == null) {
                if (aVar.c() != null) {
                    throw aVar.c();
                }
                return;
            }
            throw eVar.b();
        }
        throw gVar.d();
    }

    public static c f(Context context) {
        return new c(context);
    }

    public static void g(Context context, String str, String str2, boolean z3, @Nullable k kVar) throws Exception {
        File file = new File(context.getCacheDir(), System.currentTimeMillis() + ".temp");
        File file2 = new File(context.getCacheDir(), System.currentTimeMillis() + ".temp2");
        try {
            MediaExtractor mediaExtractor = new MediaExtractor();
            mediaExtractor.setDataSource(str);
            mediaExtractor.selectTrack(i.k(mediaExtractor, false));
            ArrayList arrayList = new ArrayList();
            int i4 = 0;
            int i5 = 0;
            while (true) {
                int sampleFlags = mediaExtractor.getSampleFlags();
                if (sampleFlags > 0 && (sampleFlags & 1) != 0) {
                    i4++;
                }
                long sampleTime = mediaExtractor.getSampleTime();
                if (sampleTime < 0) {
                    break;
                }
                arrayList.add(Long.valueOf(sampleTime));
                i5++;
                mediaExtractor.advance();
            }
            mediaExtractor.release();
            if (i5 != i4 && i5 != i4 + 1) {
                int i6 = 1;
                com.hw.videoprocessor.util.i iVar = new com.hw.videoprocessor.util.i(new float[]{0.45f, 0.1f, 0.45f}, kVar);
                iVar.b(0);
                float f4 = i4;
                float f5 = 1.0f + ((i5 - i4) / f4);
                MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                mediaMetadataRetriever.setDataSource(str);
                int parseInt = Integer.parseInt(mediaMetadataRetriever.extractMetadata(20));
                int parseInt2 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(9));
                try {
                    f(context).v(str).y(file.getAbsolutePath()).p((int) (parseInt * f5)).u(0).A(iVar).z();
                } catch (MediaCodec.CodecException e4) {
                    com.hw.videoprocessor.util.c.g(e4);
                    f(context).v(str).y(file.getAbsolutePath()).p((int) (parseInt * f5)).u(-1).A(iVar).z();
                }
                iVar.b(1);
                i(file.getAbsolutePath(), file2.getAbsolutePath(), z3, null, iVar);
                int i7 = (int) (f4 / (parseInt2 / 1000.0f));
                if (i7 != 0) {
                    i6 = i7;
                }
                iVar.b(2);
                f(context).v(file2.getAbsolutePath()).y(str2).p(parseInt).u(i6).A(iVar).z();
            }
            i(str, str2, z3, arrayList, kVar);
        } finally {
            file.delete();
            file2.delete();
        }
    }

    public static void h(String str, String str2, boolean z3) throws IOException {
        i(str, str2, z3, null, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x012e A[Catch: all -> 0x01f5, Exception -> 0x01f7, TryCatch #1 {Exception -> 0x01f7, blocks: (B:12:0x007e, B:14:0x0084, B:16:0x0090, B:19:0x00aa, B:48:0x012e, B:50:0x0139, B:52:0x0149, B:55:0x0160, B:58:0x0176, B:60:0x017b, B:63:0x018a, B:65:0x0194, B:66:0x0199, B:67:0x019f, B:70:0x01a8, B:73:0x01bc, B:75:0x01c1, B:78:0x01cf, B:79:0x01d6, B:81:0x01dc, B:22:0x00c0, B:24:0x00c5, B:27:0x00d2, B:28:0x00d7, B:33:0x00e8, B:36:0x00f3, B:39:0x0109, B:41:0x010e, B:44:0x011b, B:45:0x0120, B:82:0x01e2), top: B:94:0x007e, outer: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x01dc A[Catch: all -> 0x01f5, Exception -> 0x01f7, TryCatch #1 {Exception -> 0x01f7, blocks: (B:12:0x007e, B:14:0x0084, B:16:0x0090, B:19:0x00aa, B:48:0x012e, B:50:0x0139, B:52:0x0149, B:55:0x0160, B:58:0x0176, B:60:0x017b, B:63:0x018a, B:65:0x0194, B:66:0x0199, B:67:0x019f, B:70:0x01a8, B:73:0x01bc, B:75:0x01c1, B:78:0x01cf, B:79:0x01d6, B:81:0x01dc, B:22:0x00c0, B:24:0x00c5, B:27:0x00d2, B:28:0x00d7, B:33:0x00e8, B:36:0x00f3, B:39:0x0109, B:41:0x010e, B:44:0x011b, B:45:0x0120, B:82:0x01e2), top: B:94:0x007e, outer: #0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void i(java.lang.String r28, java.lang.String r29, boolean r30, java.util.List<java.lang.Long> r31, @androidx.annotation.Nullable com.hw.videoprocessor.util.k r32) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 523
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hw.videoprocessor.h.i(java.lang.String, java.lang.String, boolean, java.util.List, com.hw.videoprocessor.util.k):void");
    }

    public static void j(Context context, String str, String str2, int i4, int i5) throws Exception {
        f(context).v(str).y(str2).x(i4).w(i5).z();
    }
}

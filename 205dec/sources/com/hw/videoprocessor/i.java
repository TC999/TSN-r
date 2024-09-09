package com.hw.videoprocessor;

import android.content.Context;
import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.media.MediaMetadataRetriever;
import android.media.MediaMuxer;
import android.util.Pair;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* compiled from: VideoUtil.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class i {
    static long a(MediaExtractor mediaExtractor, MediaMuxer mediaMuxer, int i4, Integer num, Integer num2, long j4, int i5, int i6, boolean z3, boolean z4) throws Exception {
        int k4 = k(mediaExtractor, false);
        mediaExtractor.selectTrack(k4);
        Integer num3 = num == null ? 0 : num;
        mediaExtractor.seekTo(num3.intValue(), 2);
        MediaFormat trackFormat = mediaExtractor.getTrackFormat(k4);
        int integer = trackFormat.getInteger("width");
        int integer2 = trackFormat.getInteger("height");
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        d dVar = new d(mediaExtractor, mediaMuxer, i5, integer, integer2, i6, k4, atomicBoolean, j4, z3, z4, i4);
        e eVar = new e(dVar, mediaExtractor, Integer.valueOf(num3.intValue() / 1000), num2 == null ? null : Integer.valueOf(num2.intValue() / 1000), null, null, null, false, k4, atomicBoolean);
        eVar.start();
        dVar.start();
        try {
            eVar.join();
            dVar.join();
        } catch (InterruptedException e4) {
            e4.printStackTrace();
        }
        try {
            mediaExtractor.release();
        } catch (Exception e5) {
            com.hw.videoprocessor.util.c.g(e5);
        }
        if (dVar.d() == null) {
            if (eVar.b() == null) {
                return dVar.e();
            }
            throw eVar.b();
        }
        throw dVar.d();
    }

    public static void b(List<File> list, String str, Integer num, Integer num2) throws Exception {
        String str2;
        String str3;
        long j4;
        int i4;
        List<File> list2 = list;
        if (list2 == null || list.size() == 0) {
            return;
        }
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        int i5 = 0;
        mediaMetadataRetriever.setDataSource(list2.get(0).getAbsolutePath());
        int parseInt = num == null ? Integer.parseInt(mediaMetadataRetriever.extractMetadata(20)) : num.intValue();
        MediaExtractor mediaExtractor = new MediaExtractor();
        mediaExtractor.setDataSource(list2.get(0).getAbsolutePath());
        int k4 = k(mediaExtractor, false);
        boolean z3 = true;
        int k5 = k(mediaExtractor, true);
        MediaMuxer mediaMuxer = new MediaMuxer(str, 0);
        int addTrack = mediaMuxer.addTrack(mediaExtractor.getTrackFormat(k4));
        boolean z4 = k5 >= 0;
        int addTrack2 = z4 ? mediaMuxer.addTrack(mediaExtractor.getTrackFormat(k5)) : 0;
        mediaMuxer.start();
        long j5 = 0;
        long j6 = 0;
        int i6 = 0;
        while (i6 < list.size()) {
            if (i6 > 0) {
                mediaExtractor = new MediaExtractor();
                mediaExtractor.setDataSource(list2.get(i6).getAbsolutePath());
                k5 = k(mediaExtractor, z3);
            }
            int i7 = k5;
            MediaExtractor mediaExtractor2 = mediaExtractor;
            if (z4) {
                j5 = com.hw.videoprocessor.util.b.t(mediaExtractor2, mediaMuxer, addTrack2, null, null, j6, null);
                mediaExtractor2.unselectTrack(i7);
            }
            long j7 = j5;
            int i8 = i6;
            long a4 = a(mediaExtractor2, mediaMuxer, addTrack, null, null, j6, parseInt, num2.intValue(), i6 == 0, false);
            long j8 = a4 > j7 ? a4 : j7;
            com.hw.videoprocessor.util.c.k("\u7247\u6bb5" + i8 + "\u5df2\u5408\u6210,audioFrameTime:" + (((float) j7) / 1000.0f) + " videoFrameTime:" + (((float) a4) / 1000.0f), new Object[i5]);
            long j9 = j8 + 33000;
            mediaExtractor2.release();
            long currentTimeMillis = System.currentTimeMillis();
            StringBuilder sb = new StringBuilder();
            sb.append(list2.get(i8).getAbsolutePath());
            sb.append(".rev");
            String sb2 = sb.toString();
            h.h(list2.get(i8).getAbsolutePath(), sb2, true);
            long currentTimeMillis2 = System.currentTimeMillis();
            com.hw.videoprocessor.util.c.f("reverseVideoNoDecode:" + (currentTimeMillis2 - currentTimeMillis) + "ms", new Object[i5]);
            MediaExtractor mediaExtractor3 = new MediaExtractor();
            mediaExtractor3.setDataSource(sb2);
            if (z4) {
                str3 = "\u5df2\u5408\u6210,audioFrameTime:";
                str2 = " videoFrameTime:";
                i4 = k(mediaExtractor3, true);
                long t3 = com.hw.videoprocessor.util.b.t(mediaExtractor3, mediaMuxer, addTrack2, null, null, j9, null);
                mediaExtractor3.unselectTrack(i4);
                j4 = t3;
            } else {
                str2 = " videoFrameTime:";
                str3 = "\u5df2\u5408\u6210,audioFrameTime:";
                j4 = j7;
                i4 = i7;
            }
            String str4 = str2;
            long j10 = j4;
            long a5 = a(mediaExtractor3, mediaMuxer, addTrack, null, null, j9, parseInt, num2.intValue(), false, i8 == list.size() + (-1));
            j5 = j10;
            long j11 = a5 > j5 ? a5 : j5;
            com.hw.videoprocessor.util.c.k("\u53cd\u5e8f\u7247\u6bb5" + i8 + str3 + (((float) j5) / 1000.0f) + str4 + (((float) a5) / 1000.0f), new Object[0]);
            mediaExtractor3.release();
            new File(sb2).delete();
            k5 = i4;
            j6 = j11 + 33000;
            mediaExtractor = mediaExtractor3;
            z3 = true;
            list2 = list;
            i6 = i8 + 1;
            i5 = 0;
        }
        mediaMuxer.release();
    }

    public static float c(String str) throws IOException {
        MediaExtractor mediaExtractor = new MediaExtractor();
        mediaExtractor.setDataSource(str);
        int i4 = 0;
        mediaExtractor.selectTrack(k(mediaExtractor, false));
        long j4 = 0;
        while (true) {
            long sampleTime = mediaExtractor.getSampleTime();
            if (sampleTime < 0) {
                mediaExtractor.release();
                return i4 / ((((float) j4) / 1000.0f) / 1000.0f);
            }
            i4++;
            mediaExtractor.advance();
            j4 = sampleTime;
        }
    }

    public static int d(String str) throws IOException {
        MediaExtractor mediaExtractor = new MediaExtractor();
        mediaExtractor.setDataSource(str);
        int i4 = 0;
        mediaExtractor.selectTrack(k(mediaExtractor, false));
        int i5 = 0;
        while (true) {
            int sampleFlags = mediaExtractor.getSampleFlags();
            if (sampleFlags > 0 && (sampleFlags & 1) != 0) {
                i4++;
            }
            if (mediaExtractor.getSampleTime() < 0) {
                break;
            }
            i5++;
            mediaExtractor.advance();
        }
        mediaExtractor.release();
        float f4 = ((i5 - i4) / i4) + 1.0f;
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        mediaMetadataRetriever.setDataSource(str);
        int parseInt = Integer.parseInt(mediaMetadataRetriever.extractMetadata(20));
        mediaMetadataRetriever.release();
        return i5 == i4 ? parseInt : (int) (f4 * parseInt);
    }

    public static int e(String str) {
        MediaExtractor mediaExtractor = new MediaExtractor();
        try {
            mediaExtractor.setDataSource(str);
            MediaFormat trackFormat = mediaExtractor.getTrackFormat(k(mediaExtractor, false));
            return trackFormat.containsKey("frame-rate") ? trackFormat.getInteger("frame-rate") : -1;
        } catch (IOException e4) {
            com.hw.videoprocessor.util.c.g(e4);
            return -1;
        } finally {
            mediaExtractor.release();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static List<Long> f(MediaExtractor mediaExtractor) {
        ArrayList arrayList = new ArrayList();
        while (true) {
            long sampleTime = mediaExtractor.getSampleTime();
            if (sampleTime < 0) {
                return arrayList;
            }
            arrayList.add(Long.valueOf(sampleTime));
            mediaExtractor.advance();
        }
    }

    public static int g(MediaCodec mediaCodec, String str) {
        try {
            return mediaCodec.getCodecInfo().getCapabilitiesForType(str).getVideoCapabilities().getBitrateRange().getUpper().intValue();
        } catch (Exception e4) {
            com.hw.videoprocessor.util.c.g(e4);
            return -1;
        }
    }

    public static File h(Context context) {
        File file = new File(context.getCacheDir(), "video/");
        file.mkdirs();
        return file;
    }

    public static Pair<Integer, Integer> i(String str) throws IOException {
        MediaExtractor mediaExtractor = new MediaExtractor();
        mediaExtractor.setDataSource(str);
        int i4 = 0;
        mediaExtractor.selectTrack(k(mediaExtractor, false));
        int i5 = 0;
        while (true) {
            int sampleFlags = mediaExtractor.getSampleFlags();
            if (sampleFlags > 0 && (sampleFlags & 1) != 0) {
                i4++;
            }
            if (mediaExtractor.getSampleTime() < 0) {
                mediaExtractor.release();
                return new Pair<>(Integer.valueOf(i4), Integer.valueOf(i5));
            }
            i5++;
            mediaExtractor.advance();
        }
    }

    public static void j(MediaExtractor mediaExtractor, int i4, int i5) {
        int i6 = i5 * 1000;
        if (mediaExtractor.getSampleTrackIndex() != i4) {
            mediaExtractor.selectTrack(i4);
        }
        mediaExtractor.seekTo(i6, 0);
        while (i6 > 0 && mediaExtractor.getSampleTrackIndex() != i4) {
            i6 -= 10000;
            mediaExtractor.seekTo(i6, 0);
        }
    }

    public static int k(MediaExtractor mediaExtractor, boolean z3) {
        int trackCount = mediaExtractor.getTrackCount();
        for (int i4 = 0; i4 < trackCount; i4++) {
            String string = mediaExtractor.getTrackFormat(i4).getString("mime");
            if (z3) {
                if (string.startsWith("audio/")) {
                    return i4;
                }
            } else if (string.startsWith("video/")) {
                return i4;
            }
        }
        return -5;
    }

    public static List<File> l(Context context, String str, String str2, int i4, int i5, Integer num, float f4, Integer num2) throws Exception {
        int i6 = (int) (i4 * f4);
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        mediaMetadataRetriever.setDataSource(str);
        int parseInt = Integer.parseInt(mediaMetadataRetriever.extractMetadata(9));
        LinkedList<Pair> linkedList = new LinkedList();
        int i7 = 0;
        while (true) {
            if (parseInt <= 0) {
                break;
            }
            parseInt -= i6;
            if (parseInt < i5) {
                linkedList.add(new Pair(Integer.valueOf(i7), Integer.valueOf(i7 + i6 + parseInt)));
                break;
            }
            Integer valueOf = Integer.valueOf(i7);
            i7 += i6;
            linkedList.add(new Pair(valueOf, Integer.valueOf(i7)));
        }
        ArrayList arrayList = new ArrayList(linkedList.size());
        for (Pair pair : linkedList) {
            File file = new File(str2, pair.first + ".mp4");
            h.f(context).v(str).y(file.getAbsolutePath()).C(((Integer) pair.first).intValue()).s(((Integer) pair.second).intValue()).B(f4).p(num.intValue()).u(num2.intValue()).z();
            arrayList.add(file);
        }
        return arrayList;
    }

    public static boolean m(MediaCodec mediaCodec, String str, MediaFormat mediaFormat, int i4, int i5) {
        MediaCodecInfo.CodecProfileLevel[] codecProfileLevelArr = mediaCodec.getCodecInfo().getCapabilitiesForType(str).profileLevels;
        if (codecProfileLevelArr == null) {
            return false;
        }
        for (MediaCodecInfo.CodecProfileLevel codecProfileLevel : codecProfileLevelArr) {
            if (codecProfileLevel.profile == i4 && codecProfileLevel.level == i5) {
                mediaFormat.setInteger("profile", i4);
                mediaFormat.setInteger("level", i5);
                return true;
            }
        }
        return false;
    }
}

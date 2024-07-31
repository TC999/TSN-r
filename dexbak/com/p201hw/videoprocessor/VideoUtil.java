package com.p201hw.videoprocessor;

import android.content.Context;
import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.media.MediaMetadataRetriever;
import android.media.MediaMuxer;
import android.util.Pair;
import com.p201hw.videoprocessor.util.AudioUtil;
import com.p201hw.videoprocessor.util.CL;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import tv.danmaku.ijk.media.player.misc.IMediaFormat;

/* renamed from: com.hw.videoprocessor.i */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class VideoUtil {
    /* renamed from: a */
    static long m34996a(MediaExtractor mediaExtractor, MediaMuxer mediaMuxer, int i, Integer num, Integer num2, long j, int i2, int i3, boolean z, boolean z2) throws Exception {
        int m34986k = m34986k(mediaExtractor, false);
        mediaExtractor.selectTrack(m34986k);
        Integer num3 = num == null ? 0 : num;
        mediaExtractor.seekTo(num3.intValue(), 2);
        MediaFormat trackFormat = mediaExtractor.getTrackFormat(m34986k);
        int integer = trackFormat.getInteger("width");
        int integer2 = trackFormat.getInteger("height");
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        VideoAppendEncodeThread videoAppendEncodeThread = new VideoAppendEncodeThread(mediaExtractor, mediaMuxer, i2, integer, integer2, i3, m34986k, atomicBoolean, j, z, z2, i);
        VideoDecodeThread videoDecodeThread = new VideoDecodeThread(videoAppendEncodeThread, mediaExtractor, Integer.valueOf(num3.intValue() / 1000), num2 == null ? null : Integer.valueOf(num2.intValue() / 1000), null, null, null, false, m34986k, atomicBoolean);
        videoDecodeThread.start();
        videoAppendEncodeThread.start();
        try {
            videoDecodeThread.join();
            videoAppendEncodeThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            mediaExtractor.release();
        } catch (Exception e2) {
            CL.m34895g(e2);
        }
        if (videoAppendEncodeThread.m35046d() == null) {
            if (videoDecodeThread.m35043b() == null) {
                return videoAppendEncodeThread.m35045e();
            }
            throw videoDecodeThread.m35043b();
        }
        throw videoAppendEncodeThread.m35046d();
    }

    /* renamed from: b */
    public static void m34995b(List<File> list, String str, Integer num, Integer num2) throws Exception {
        String str2;
        String str3;
        long j;
        int i;
        List<File> list2 = list;
        if (list2 == null || list.size() == 0) {
            return;
        }
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        int i2 = 0;
        mediaMetadataRetriever.setDataSource(list2.get(0).getAbsolutePath());
        int parseInt = num == null ? Integer.parseInt(mediaMetadataRetriever.extractMetadata(20)) : num.intValue();
        MediaExtractor mediaExtractor = new MediaExtractor();
        mediaExtractor.setDataSource(list2.get(0).getAbsolutePath());
        int m34986k = m34986k(mediaExtractor, false);
        boolean z = true;
        int m34986k2 = m34986k(mediaExtractor, true);
        MediaMuxer mediaMuxer = new MediaMuxer(str, 0);
        int addTrack = mediaMuxer.addTrack(mediaExtractor.getTrackFormat(m34986k));
        boolean z2 = m34986k2 >= 0;
        int addTrack2 = z2 ? mediaMuxer.addTrack(mediaExtractor.getTrackFormat(m34986k2)) : 0;
        mediaMuxer.start();
        long j2 = 0;
        long j3 = 0;
        int i3 = 0;
        while (i3 < list.size()) {
            if (i3 > 0) {
                mediaExtractor = new MediaExtractor();
                mediaExtractor.setDataSource(list2.get(i3).getAbsolutePath());
                m34986k2 = m34986k(mediaExtractor, z);
            }
            int i4 = m34986k2;
            MediaExtractor mediaExtractor2 = mediaExtractor;
            if (z2) {
                j2 = AudioUtil.m34904t(mediaExtractor2, mediaMuxer, addTrack2, null, null, j3, null);
                mediaExtractor2.unselectTrack(i4);
            }
            long j4 = j2;
            int i5 = i3;
            long m34996a = m34996a(mediaExtractor2, mediaMuxer, addTrack, null, null, j3, parseInt, num2.intValue(), i3 == 0, false);
            long j5 = m34996a > j4 ? m34996a : j4;
            CL.m34891k("片段" + i5 + "已合成,audioFrameTime:" + (((float) j4) / 1000.0f) + " videoFrameTime:" + (((float) m34996a) / 1000.0f), new Object[i2]);
            long j6 = j5 + 33000;
            mediaExtractor2.release();
            long currentTimeMillis = System.currentTimeMillis();
            StringBuilder sb = new StringBuilder();
            sb.append(list2.get(i5).getAbsolutePath());
            sb.append(".rev");
            String sb2 = sb.toString();
            VideoProcessor.m35028h(list2.get(i5).getAbsolutePath(), sb2, true);
            long currentTimeMillis2 = System.currentTimeMillis();
            CL.m34896f("reverseVideoNoDecode:" + (currentTimeMillis2 - currentTimeMillis) + "ms", new Object[i2]);
            MediaExtractor mediaExtractor3 = new MediaExtractor();
            mediaExtractor3.setDataSource(sb2);
            if (z2) {
                str3 = "已合成,audioFrameTime:";
                str2 = " videoFrameTime:";
                i = m34986k(mediaExtractor3, true);
                long m34904t = AudioUtil.m34904t(mediaExtractor3, mediaMuxer, addTrack2, null, null, j6, null);
                mediaExtractor3.unselectTrack(i);
                j = m34904t;
            } else {
                str2 = " videoFrameTime:";
                str3 = "已合成,audioFrameTime:";
                j = j4;
                i = i4;
            }
            String str4 = str2;
            long j7 = j;
            long m34996a2 = m34996a(mediaExtractor3, mediaMuxer, addTrack, null, null, j6, parseInt, num2.intValue(), false, i5 == list.size() + (-1));
            j2 = j7;
            long j8 = m34996a2 > j2 ? m34996a2 : j2;
            CL.m34891k("反序片段" + i5 + str3 + (((float) j2) / 1000.0f) + str4 + (((float) m34996a2) / 1000.0f), new Object[0]);
            mediaExtractor3.release();
            new File(sb2).delete();
            m34986k2 = i;
            j3 = j8 + 33000;
            mediaExtractor = mediaExtractor3;
            z = true;
            list2 = list;
            i3 = i5 + 1;
            i2 = 0;
        }
        mediaMuxer.release();
    }

    /* renamed from: c */
    public static float m34994c(String str) throws IOException {
        MediaExtractor mediaExtractor = new MediaExtractor();
        mediaExtractor.setDataSource(str);
        int i = 0;
        mediaExtractor.selectTrack(m34986k(mediaExtractor, false));
        long j = 0;
        while (true) {
            long sampleTime = mediaExtractor.getSampleTime();
            if (sampleTime < 0) {
                mediaExtractor.release();
                return i / ((((float) j) / 1000.0f) / 1000.0f);
            }
            i++;
            mediaExtractor.advance();
            j = sampleTime;
        }
    }

    /* renamed from: d */
    public static int m34993d(String str) throws IOException {
        MediaExtractor mediaExtractor = new MediaExtractor();
        mediaExtractor.setDataSource(str);
        int i = 0;
        mediaExtractor.selectTrack(m34986k(mediaExtractor, false));
        int i2 = 0;
        while (true) {
            int sampleFlags = mediaExtractor.getSampleFlags();
            if (sampleFlags > 0 && (sampleFlags & 1) != 0) {
                i++;
            }
            if (mediaExtractor.getSampleTime() < 0) {
                break;
            }
            i2++;
            mediaExtractor.advance();
        }
        mediaExtractor.release();
        float f = ((i2 - i) / i) + 1.0f;
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        mediaMetadataRetriever.setDataSource(str);
        int parseInt = Integer.parseInt(mediaMetadataRetriever.extractMetadata(20));
        mediaMetadataRetriever.release();
        return i2 == i ? parseInt : (int) (f * parseInt);
    }

    /* renamed from: e */
    public static int m34992e(String str) {
        MediaExtractor mediaExtractor = new MediaExtractor();
        try {
            mediaExtractor.setDataSource(str);
            MediaFormat trackFormat = mediaExtractor.getTrackFormat(m34986k(mediaExtractor, false));
            return trackFormat.containsKey("frame-rate") ? trackFormat.getInteger("frame-rate") : -1;
        } catch (IOException e) {
            CL.m34895g(e);
            return -1;
        } finally {
            mediaExtractor.release();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: f */
    public static List<Long> m34991f(MediaExtractor mediaExtractor) {
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

    /* renamed from: g */
    public static int m34990g(MediaCodec mediaCodec, String str) {
        try {
            return mediaCodec.getCodecInfo().getCapabilitiesForType(str).getVideoCapabilities().getBitrateRange().getUpper().intValue();
        } catch (Exception e) {
            CL.m34895g(e);
            return -1;
        }
    }

    /* renamed from: h */
    public static File m34989h(Context context) {
        File file = new File(context.getCacheDir(), "video/");
        file.mkdirs();
        return file;
    }

    /* renamed from: i */
    public static Pair<Integer, Integer> m34988i(String str) throws IOException {
        MediaExtractor mediaExtractor = new MediaExtractor();
        mediaExtractor.setDataSource(str);
        int i = 0;
        mediaExtractor.selectTrack(m34986k(mediaExtractor, false));
        int i2 = 0;
        while (true) {
            int sampleFlags = mediaExtractor.getSampleFlags();
            if (sampleFlags > 0 && (sampleFlags & 1) != 0) {
                i++;
            }
            if (mediaExtractor.getSampleTime() < 0) {
                mediaExtractor.release();
                return new Pair<>(Integer.valueOf(i), Integer.valueOf(i2));
            }
            i2++;
            mediaExtractor.advance();
        }
    }

    /* renamed from: j */
    public static void m34987j(MediaExtractor mediaExtractor, int i, int i2) {
        int i3 = i2 * 1000;
        if (mediaExtractor.getSampleTrackIndex() != i) {
            mediaExtractor.selectTrack(i);
        }
        mediaExtractor.seekTo(i3, 0);
        while (i3 > 0 && mediaExtractor.getSampleTrackIndex() != i) {
            i3 -= 10000;
            mediaExtractor.seekTo(i3, 0);
        }
    }

    /* renamed from: k */
    public static int m34986k(MediaExtractor mediaExtractor, boolean z) {
        int trackCount = mediaExtractor.getTrackCount();
        for (int i = 0; i < trackCount; i++) {
            String string = mediaExtractor.getTrackFormat(i).getString(IMediaFormat.KEY_MIME);
            if (z) {
                if (string.startsWith("audio/")) {
                    return i;
                }
            } else if (string.startsWith("video/")) {
                return i;
            }
        }
        return -5;
    }

    /* renamed from: l */
    public static List<File> m34985l(Context context, String str, String str2, int i, int i2, Integer num, float f, Integer num2) throws Exception {
        int i3 = (int) (i * f);
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        mediaMetadataRetriever.setDataSource(str);
        int parseInt = Integer.parseInt(mediaMetadataRetriever.extractMetadata(9));
        LinkedList<Pair> linkedList = new LinkedList();
        int i4 = 0;
        while (true) {
            if (parseInt <= 0) {
                break;
            }
            parseInt -= i3;
            if (parseInt < i2) {
                linkedList.add(new Pair(Integer.valueOf(i4), Integer.valueOf(i4 + i3 + parseInt)));
                break;
            }
            Integer valueOf = Integer.valueOf(i4);
            i4 += i3;
            linkedList.add(new Pair(valueOf, Integer.valueOf(i4)));
        }
        ArrayList arrayList = new ArrayList(linkedList.size());
        for (Pair pair : linkedList) {
            File file = new File(str2, pair.first + ".mp4");
            VideoProcessor.m35030f(context).m35001v(str).m34998y(file.getAbsolutePath()).m35023C(((Integer) pair.first).intValue()).m35004s(((Integer) pair.second).intValue()).m35024B(f).m35007p(num.intValue()).m35002u(num2.intValue()).m34997z();
            arrayList.add(file);
        }
        return arrayList;
    }

    /* renamed from: m */
    public static boolean m34984m(MediaCodec mediaCodec, String str, MediaFormat mediaFormat, int i, int i2) {
        MediaCodecInfo.CodecProfileLevel[] codecProfileLevelArr = mediaCodec.getCodecInfo().getCapabilitiesForType(str).profileLevels;
        if (codecProfileLevelArr == null) {
            return false;
        }
        for (MediaCodecInfo.CodecProfileLevel codecProfileLevel : codecProfileLevelArr) {
            if (codecProfileLevel.profile == i && codecProfileLevel.level == i2) {
                mediaFormat.setInteger("profile", i);
                mediaFormat.setInteger("level", i2);
                return true;
            }
        }
        return false;
    }
}

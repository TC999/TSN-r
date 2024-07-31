package com.p201hw.videoprocessor.util;

import android.content.Context;
import android.media.MediaCodec;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import android.util.Pair;
import androidx.annotation.IntRange;
import androidx.annotation.Nullable;
import com.github.mikephil.charting.utils.Utils;
import com.p201hw.videoprocessor.VideoProcessor;
import com.p201hw.videoprocessor.VideoUtil;
import com.p201hw.videoprocessor.jssrc.SSRC;
import com.tencent.bugly.BUGLY;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.HashMap;
import java.util.Map;
import kotlin.UByte;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
import tv.danmaku.ijk.media.player.misc.IMediaFormat;

/* renamed from: com.hw.videoprocessor.util.b */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class AudioUtil {

    /* renamed from: a */
    private static final Map<Integer, Integer> f24122a;

    /* renamed from: b */
    static final String f24123b = "VideoProcessor";

    /* renamed from: c */
    public static int f24124c;

    static {
        HashMap hashMap = new HashMap();
        f24122a = hashMap;
        hashMap.put(96000, 0);
        hashMap.put(88200, 1);
        hashMap.put(64000, 2);
        hashMap.put(48000, 3);
        hashMap.put(44100, 4);
        hashMap.put(32000, 5);
        hashMap.put(24000, 6);
        hashMap.put(22050, 7);
        hashMap.put(16000, 8);
        hashMap.put(12000, 9);
        hashMap.put(11025, 10);
        hashMap.put(8000, 11);
        hashMap.put(7350, 12);
        f24124c = 1;
    }

    /* renamed from: a */
    public static void m34923a(Context context, String str, String str2, @IntRange(from = 0, m60035to = 100) int i, @Nullable VideoProgressListener videoProgressListener) throws IOException {
        String name = new File(str).getName();
        File m34989h = VideoUtil.m34989h(context);
        File file = new File(m34989h, name + ".pcm");
        File m34989h2 = VideoUtil.m34989h(context);
        File file2 = new File(m34989h2, name + "_2.pcm");
        File m34989h3 = VideoUtil.m34989h(context);
        File file3 = new File(m34989h3, name + ".wav");
        m34917g(str, file.getAbsolutePath(), null, null);
        m34922b(file.getAbsolutePath(), file2.getAbsolutePath(), i);
        MediaExtractor mediaExtractor = new MediaExtractor();
        mediaExtractor.setDataSource(str);
        MediaFormat trackFormat = mediaExtractor.getTrackFormat(VideoUtil.m34986k(mediaExtractor, true));
        int integer = trackFormat.getInteger("sample-rate");
        int integer2 = trackFormat.getInteger("channel-count");
        new PcmToWavUtil(integer, integer2 == 2 ? 12 : 16, integer2, 2).m34859a(file2.getAbsolutePath(), file3.getAbsolutePath());
        m34916h(file3.getPath(), str2, trackFormat, videoProgressListener);
    }

    /* renamed from: b */
    public static void m34922b(String str, String str2, @IntRange(from = 0, m60035to = 100) int i) throws IOException {
        if (i == 100) {
            m34918f(str, str2);
            return;
        }
        float m34911m = m34911m(i);
        byte[] bArr = new byte[2048];
        FileInputStream fileInputStream = new FileInputStream(str);
        FileOutputStream fileOutputStream = new FileOutputStream(str2);
        while (fileInputStream.read(bArr) != -1) {
            try {
                for (int i2 = 0; i2 < 2048; i2 += 2) {
                    int i3 = i2 + 1;
                    int i4 = (int) (((short) ((bArr[i2] & UByte.f41242c) | ((bArr[i3] & UByte.f41242c) << 8))) * m34911m);
                    if (i4 > 32767) {
                        i4 = 32767;
                    } else if (i4 < -32768) {
                        i4 = -32768;
                    }
                    bArr[i2] = (byte) (i4 & 255);
                    bArr[i3] = (byte) ((i4 >>> 8) & 255);
                }
                fileOutputStream.write(bArr);
            } finally {
                fileInputStream.close();
                fileOutputStream.close();
            }
        }
    }

    /* renamed from: c */
    public static Pair<Integer, Integer> m34921c(String str, String str2, MediaFormat mediaFormat, MediaFormat mediaFormat2) {
        int i;
        int i2 = 1;
        int integer = mediaFormat.containsKey("channel-count") ? mediaFormat.getInteger("channel-count") : 1;
        int integer2 = mediaFormat2.containsKey("channel-count") ? mediaFormat2.getInteger("channel-count") : 1;
        int integer3 = mediaFormat.containsKey("sample-rate") ? mediaFormat.getInteger("sample-rate") : 44100;
        int integer4 = mediaFormat2.containsKey("sample-rate") ? mediaFormat2.getInteger("sample-rate") : 44100;
        if (integer == integer2 && integer3 == integer4 && integer <= 2) {
            return new Pair<>(Integer.valueOf(integer), Integer.valueOf(integer3));
        }
        File file = new File(str + ".temp");
        File file2 = new File(str2 + ".temp");
        if (integer != integer2 || integer > 2 || integer2 > 2) {
            if (integer > 1) {
                try {
                    try {
                        m34905s(str, file.getAbsolutePath(), integer);
                        File file3 = new File(str);
                        file3.delete();
                        file.renameTo(file3);
                        i = 1;
                    } catch (Exception e) {
                        e = e;
                        CL.m34895g(e);
                        Pair<Integer, Integer> pair = new Pair<>(Integer.valueOf(integer), Integer.valueOf(integer3));
                        file.delete();
                        file2.exists();
                        return pair;
                    }
                } catch (Throwable th) {
                    file.delete();
                    file2.exists();
                    throw th;
                }
            } else {
                i = integer;
            }
            if (integer2 > 1) {
                m34905s(str2, file2.getAbsolutePath(), integer2);
                File file4 = new File(str2);
                file4.delete();
                file2.renameTo(file4);
                integer2 = 1;
            }
            integer = i;
        } else {
            i2 = integer;
        }
        if (integer3 != integer4) {
            try {
                int min = Math.min(integer3, integer4);
                if (integer3 != min) {
                    try {
                        m34910n(str, file.getAbsolutePath(), integer3, min, integer);
                        File file5 = new File(str);
                        file5.delete();
                        file.renameTo(file5);
                    } catch (Exception e2) {
                        e = e2;
                        integer3 = min;
                        integer = i2;
                        CL.m34895g(e);
                        Pair<Integer, Integer> pair2 = new Pair<>(Integer.valueOf(integer), Integer.valueOf(integer3));
                        file.delete();
                        file2.exists();
                        return pair2;
                    }
                }
                if (integer4 != min) {
                    m34910n(str2, file2.getAbsolutePath(), integer4, min, integer2);
                    File file6 = new File(str2);
                    file6.delete();
                    file2.renameTo(file6);
                }
                integer3 = min;
            } catch (Exception e3) {
                e = e3;
            }
        }
        Pair<Integer, Integer> pair3 = new Pair<>(Integer.valueOf(i2), Integer.valueOf(integer3));
        file.delete();
        file2.exists();
        return pair3;
    }

    /* JADX WARN: Removed duplicated region for block: B:58:0x00cf A[Catch: IOException -> 0x00cb, TryCatch #9 {IOException -> 0x00cb, blocks: (B:54:0x00c7, B:58:0x00cf, B:60:0x00d4, B:62:0x00d9), top: B:74:0x00c7 }] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00d4 A[Catch: IOException -> 0x00cb, TryCatch #9 {IOException -> 0x00cb, blocks: (B:54:0x00c7, B:58:0x00cf, B:60:0x00d4, B:62:0x00d9), top: B:74:0x00c7 }] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00d9 A[Catch: IOException -> 0x00cb, TRY_LEAVE, TryCatch #9 {IOException -> 0x00cb, blocks: (B:54:0x00c7, B:58:0x00cf, B:60:0x00d4, B:62:0x00d9), top: B:74:0x00c7 }] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00c7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.io.File m34920d(java.io.File r12, int r13, int r14) {
        /*
            Method dump skipped, instructions count: 227
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.p201hw.videoprocessor.util.AudioUtil.m34920d(java.io.File, int, int):java.io.File");
    }

    /* renamed from: e */
    public static void m34919e(MediaFormat mediaFormat, int i, int i2, int i3) {
        Map<Integer, Integer> map = f24122a;
        int intValue = map.containsKey(Integer.valueOf(i2)) ? map.get(Integer.valueOf(i2)).intValue() : 4;
        ByteBuffer allocate = ByteBuffer.allocate(2);
        allocate.put(0, (byte) ((i << 3) | (intValue >> 1)));
        allocate.put(1, (byte) (((intValue & 1) << 7) | (i3 << 3)));
        mediaFormat.setByteBuffer("csd-0", allocate);
    }

    /* renamed from: f */
    public static void m34918f(String str, String str2) throws IOException {
        FileChannel channel = new FileOutputStream(str2).getChannel();
        FileChannel channel2 = new FileInputStream(str).getChannel();
        channel2.transferTo(0L, channel2.size(), channel);
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x009e A[Catch: all -> 0x00ed, TryCatch #0 {all -> 0x00ed, blocks: (B:14:0x0070, B:16:0x0076, B:28:0x009e, B:34:0x00f3, B:39:0x0100, B:41:0x011d, B:42:0x0134, B:46:0x015c, B:45:0x013b, B:29:0x00ae, B:19:0x0082, B:21:0x008b, B:23:0x0091), top: B:53:0x0070 }] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00ae A[Catch: all -> 0x00ed, TryCatch #0 {all -> 0x00ed, blocks: (B:14:0x0070, B:16:0x0076, B:28:0x009e, B:34:0x00f3, B:39:0x0100, B:41:0x011d, B:42:0x0134, B:46:0x015c, B:45:0x013b, B:29:0x00ae, B:19:0x0082, B:21:0x008b, B:23:0x0091), top: B:53:0x0070 }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00f3 A[Catch: all -> 0x00ed, TryCatch #0 {all -> 0x00ed, blocks: (B:14:0x0070, B:16:0x0076, B:28:0x009e, B:34:0x00f3, B:39:0x0100, B:41:0x011d, B:42:0x0134, B:46:0x015c, B:45:0x013b, B:29:0x00ae, B:19:0x0082, B:21:0x008b, B:23:0x0091), top: B:53:0x0070 }] */
    /* renamed from: g */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void m34917g(java.lang.String r21, java.lang.String r22, java.lang.Integer r23, java.lang.Integer r24) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 381
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.p201hw.videoprocessor.util.AudioUtil.m34917g(java.lang.String, java.lang.String, java.lang.Integer, java.lang.Integer):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x01d3 A[Catch: all -> 0x0233, TryCatch #1 {all -> 0x0233, blocks: (B:35:0x01ab, B:39:0x01d3, B:40:0x01f0, B:42:0x01f5, B:43:0x01f7, B:45:0x01fc, B:51:0x0213, B:53:0x021e), top: B:70:0x01ab }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x01f5 A[Catch: all -> 0x0233, TryCatch #1 {all -> 0x0233, blocks: (B:35:0x01ab, B:39:0x01d3, B:40:0x01f0, B:42:0x01f5, B:43:0x01f7, B:45:0x01fc, B:51:0x0213, B:53:0x021e), top: B:70:0x01ab }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x01fc A[Catch: all -> 0x0233, TryCatch #1 {all -> 0x0233, blocks: (B:35:0x01ab, B:39:0x01d3, B:40:0x01f0, B:42:0x01f5, B:43:0x01f7, B:45:0x01fc, B:51:0x0213, B:53:0x021e), top: B:70:0x01ab }] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x021c  */
    /* renamed from: h */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void m34916h(java.lang.String r31, java.lang.String r32, android.media.MediaFormat r33, @androidx.annotation.Nullable com.p201hw.videoprocessor.util.VideoProgressListener r34) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 590
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.p201hw.videoprocessor.util.AudioUtil.m34916h(java.lang.String, java.lang.String, android.media.MediaFormat, com.hw.videoprocessor.util.k):void");
    }

    /* renamed from: i */
    public static int m34915i(MediaFormat mediaFormat) {
        return mediaFormat.containsKey(IjkMediaMeta.IJKM_KEY_BITRATE) ? mediaFormat.getInteger(IjkMediaMeta.IJKM_KEY_BITRATE) : VideoProcessor.f24066e;
    }

    /* renamed from: j */
    public static int m34914j(MediaFormat mediaFormat) {
        return mediaFormat.containsKey("max-input-size") ? mediaFormat.getInteger("max-input-size") : BUGLY.C12768a.MAX_USERDATA_VALUE_LENGTH;
    }

    /* renamed from: k */
    public static boolean m34913k(String str) throws IOException {
        MediaExtractor mediaExtractor = new MediaExtractor();
        mediaExtractor.setDataSource(str);
        int trackCount = mediaExtractor.getTrackCount();
        MediaFormat mediaFormat = null;
        for (int i = 0; i < trackCount; i++) {
            mediaFormat = mediaExtractor.getTrackFormat(i);
            if (mediaFormat.getString(IMediaFormat.KEY_MIME).startsWith("audio/")) {
                break;
            }
        }
        mediaExtractor.release();
        return mediaFormat != null && mediaFormat.getInteger("channel-count") > 1;
    }

    /* renamed from: l */
    public static void m34912l(String str, String str2, String str3, @IntRange(from = 0, m60035to = 100) int i, @IntRange(from = 0, m60035to = 100) int i2) throws IOException {
        float m34911m = m34911m(i);
        float m34911m2 = m34911m(i2);
        int i3 = 2048;
        byte[] bArr = new byte[2048];
        byte[] bArr2 = new byte[2048];
        byte[] bArr3 = new byte[2048];
        FileInputStream fileInputStream = new FileInputStream(str);
        FileInputStream fileInputStream2 = new FileInputStream(str2);
        FileOutputStream fileOutputStream = new FileOutputStream(str3);
        boolean z = false;
        boolean z2 = false;
        while (true) {
            if (z && z2) {
                fileInputStream.close();
                fileInputStream2.close();
                fileOutputStream.close();
                return;
            }
            if (!z) {
                try {
                    z = fileInputStream.read(bArr) == -1;
                    System.arraycopy(bArr, 0, bArr3, 0, i3);
                } catch (Throwable th) {
                    fileInputStream.close();
                    fileInputStream2.close();
                    fileOutputStream.close();
                    throw th;
                }
            }
            if (!z2) {
                z2 = fileInputStream2.read(bArr2) == -1;
                int i4 = 0;
                while (i4 < i3) {
                    int i5 = i4 + 1;
                    int i6 = (int) ((((short) (((bArr2[i5] & UByte.f41242c) << 8) | (bArr2[i4] & UByte.f41242c))) * m34911m2) + (((short) ((bArr[i4] & UByte.f41242c) | ((bArr[i5] & UByte.f41242c) << 8))) * m34911m));
                    if (i6 > 32767) {
                        i6 = 32767;
                    } else if (i6 < -32768) {
                        i6 = -32768;
                    }
                    bArr3[i4] = (byte) (i6 & 255);
                    bArr3[i5] = (byte) ((i6 >>> 8) & 255);
                    i4 += 2;
                    i3 = 2048;
                }
            }
            fileOutputStream.write(bArr3);
            i3 = 2048;
        }
    }

    /* renamed from: m */
    private static float m34911m(@IntRange(from = 0, m60035to = 100) int i) {
        return (i / 100.0f) * f24124c;
    }

    /* renamed from: n */
    public static boolean m34910n(String str, String str2, int i, int i2, int i3) {
        try {
            new SSRC(new FileInputStream(str), new FileOutputStream(str2), i, i2, 2, 2, i3, (int) new File(str).length(), Utils.DOUBLE_EPSILON, 0, true);
            return true;
        } catch (IOException e) {
            CL.m34895g(e);
            e.printStackTrace();
            return true;
        }
    }

    /* renamed from: o */
    public static void m34909o(String str, String str2) throws IOException {
        MediaExtractor mediaExtractor = new MediaExtractor();
        mediaExtractor.setDataSource(str);
        try {
            int m34986k = VideoUtil.m34986k(mediaExtractor, false);
            mediaExtractor.selectTrack(m34986k);
            MediaFormat trackFormat = mediaExtractor.getTrackFormat(m34986k);
            MediaMuxer mediaMuxer = new MediaMuxer(str2, 0);
            int addTrack = mediaMuxer.addTrack(trackFormat);
            mediaMuxer.start();
            MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
            ByteBuffer allocateDirect = ByteBuffer.allocateDirect(trackFormat.getInteger("max-input-size"));
            while (true) {
                long sampleTime = mediaExtractor.getSampleTime();
                if (sampleTime == -1) {
                    mediaMuxer.stop();
                    mediaMuxer.release();
                    return;
                }
                int sampleFlags = mediaExtractor.getSampleFlags();
                int readSampleData = mediaExtractor.readSampleData(allocateDirect, 0);
                bufferInfo.presentationTimeUs = sampleTime;
                bufferInfo.flags = sampleFlags;
                bufferInfo.size = readSampleData;
                mediaMuxer.writeSampleData(addTrack, allocateDirect, bufferInfo);
                mediaExtractor.advance();
            }
        } finally {
            mediaExtractor.release();
        }
    }

    /* renamed from: p */
    public static void m34908p(String str, String str2, String str3, boolean z) throws IOException {
        MediaExtractor mediaExtractor = new MediaExtractor();
        mediaExtractor.setDataSource(str);
        MediaExtractor mediaExtractor2 = new MediaExtractor();
        mediaExtractor2.setDataSource(str2);
        try {
            int m34986k = VideoUtil.m34986k(mediaExtractor, false);
            int m34986k2 = VideoUtil.m34986k(mediaExtractor2, true);
            mediaExtractor.selectTrack(m34986k);
            mediaExtractor2.selectTrack(m34986k2);
            MediaFormat trackFormat = mediaExtractor2.getTrackFormat(m34986k2);
            MediaFormat trackFormat2 = mediaExtractor.getTrackFormat(m34986k);
            MediaMuxer mediaMuxer = new MediaMuxer(str3, 0);
            int addTrack = mediaMuxer.addTrack(trackFormat);
            int addTrack2 = mediaMuxer.addTrack(trackFormat2);
            mediaMuxer.start();
            MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
            ByteBuffer allocateDirect = ByteBuffer.allocateDirect(trackFormat2.getInteger("max-input-size"));
            long j = 0;
            long j2 = 0;
            while (true) {
                long sampleTime = mediaExtractor.getSampleTime();
                if (sampleTime == -1) {
                    break;
                }
                int sampleFlags = mediaExtractor.getSampleFlags();
                int readSampleData = mediaExtractor.readSampleData(allocateDirect, 0);
                bufferInfo.presentationTimeUs = sampleTime;
                bufferInfo.flags = sampleFlags;
                bufferInfo.size = readSampleData;
                mediaMuxer.writeSampleData(addTrack2, allocateDirect, bufferInfo);
                mediaExtractor.advance();
                j2 = sampleTime;
                j = 0;
            }
            int integer = 1024000000 / trackFormat.getInteger("sample-rate");
            ByteBuffer allocateDirect2 = ByteBuffer.allocateDirect(m34914j(trackFormat));
            long j3 = j;
            long j4 = j3;
            while (j3 < j2) {
                mediaExtractor2.seekTo(j, 2);
                while (true) {
                    long sampleTime2 = mediaExtractor2.getSampleTime();
                    if (sampleTime2 == -1) {
                        break;
                    }
                    j3 = sampleTime2 + j4;
                    if (j3 > j2) {
                        break;
                    }
                    int sampleFlags2 = mediaExtractor2.getSampleFlags();
                    int readSampleData2 = mediaExtractor2.readSampleData(allocateDirect2, 0);
                    bufferInfo.presentationTimeUs = j3;
                    bufferInfo.flags = sampleFlags2;
                    bufferInfo.size = readSampleData2;
                    mediaMuxer.writeSampleData(addTrack, allocateDirect2, bufferInfo);
                    mediaExtractor2.advance();
                }
                j4 = j3 + integer;
                if (!z) {
                    break;
                }
                j = 0;
            }
            mediaMuxer.stop();
            mediaMuxer.release();
        } finally {
            mediaExtractor.release();
            mediaExtractor2.release();
        }
    }

    /* renamed from: q */
    public static void m34907q(String str, String str2) throws IOException {
        FileOutputStream fileOutputStream;
        RandomAccessFile randomAccessFile = null;
        try {
            RandomAccessFile randomAccessFile2 = new RandomAccessFile(str, "r");
            try {
                fileOutputStream = new FileOutputStream(str2);
                try {
                    long j = 2;
                    byte[] bArr = new byte[2];
                    for (long length = randomAccessFile2.length() - j; length >= 0; length -= j) {
                        randomAccessFile2.seek(length);
                        randomAccessFile2.read(bArr);
                        fileOutputStream.write(bArr);
                    }
                    randomAccessFile2.close();
                    fileOutputStream.close();
                } catch (Throwable th) {
                    th = th;
                    randomAccessFile = randomAccessFile2;
                    if (randomAccessFile != null) {
                        randomAccessFile.close();
                    }
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream = null;
            }
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream = null;
        }
    }

    /* renamed from: r */
    public static void m34906r(String str, String str2) throws IOException {
        m34905s(str, str2, 2);
    }

    /* renamed from: s */
    public static void m34905s(String str, String str2, @IntRange(from = 2) int i) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(str);
        FileOutputStream fileOutputStream = new FileOutputStream(str2);
        byte[] bArr = new byte[i * 1024];
        byte[] bArr2 = new byte[1024];
        while (fileInputStream.read(bArr) != -1) {
            for (int i2 = 0; i2 < 1024; i2 += 2) {
                int i3 = i * i2;
                bArr2[i2] = bArr[i3];
                bArr2[i2 + 1] = bArr[i3 + 1];
            }
            fileOutputStream.write(bArr2);
        }
        fileInputStream.close();
        fileOutputStream.close();
    }

    /* renamed from: t */
    public static long m34904t(MediaExtractor mediaExtractor, MediaMuxer mediaMuxer, int i, Integer num, Integer num2, long j, VideoProgressListener videoProgressListener) throws IOException {
        int m34986k = VideoUtil.m34986k(mediaExtractor, true);
        mediaExtractor.selectTrack(m34986k);
        Integer num3 = num == null ? 0 : num;
        mediaExtractor.seekTo(num3.intValue(), 2);
        MediaFormat trackFormat = mediaExtractor.getTrackFormat(m34986k);
        long j2 = trackFormat.getLong("durationUs");
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(trackFormat.getInteger("max-input-size"));
        MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
        long j3 = j;
        while (true) {
            long sampleTime = mediaExtractor.getSampleTime();
            if (sampleTime == -1) {
                break;
            } else if (sampleTime < num3.intValue()) {
                mediaExtractor.advance();
            } else if (num2 != null && sampleTime > num2.intValue()) {
                break;
            } else {
                if (videoProgressListener != null) {
                    float intValue = ((float) (sampleTime - num3.intValue())) / ((float) (num2 == null ? j2 : num2.intValue() - num3.intValue()));
                    if (intValue < 0.0f) {
                        intValue = 0.0f;
                    }
                    if (intValue > 1.0f) {
                        intValue = 1.0f;
                    }
                    videoProgressListener.mo34843a(intValue);
                }
                bufferInfo.presentationTimeUs = (sampleTime - num3.intValue()) + j;
                bufferInfo.flags = mediaExtractor.getSampleFlags();
                int readSampleData = mediaExtractor.readSampleData(allocateDirect, 0);
                bufferInfo.size = readSampleData;
                if (readSampleData < 0) {
                    break;
                }
                CL.m34891k("writeAudioSampleData,time:" + (((float) bufferInfo.presentationTimeUs) / 1000.0f), new Object[0]);
                mediaMuxer.writeSampleData(i, allocateDirect, bufferInfo);
                long j4 = bufferInfo.presentationTimeUs;
                mediaExtractor.advance();
                j3 = j4;
            }
        }
        return j3;
    }

    /* renamed from: u */
    public static long m34903u(MediaExtractor mediaExtractor, MediaMuxer mediaMuxer, int i, Integer num, Integer num2, VideoProgressListener videoProgressListener) throws IOException {
        return m34904t(mediaExtractor, mediaMuxer, i, num, num2, 0L, videoProgressListener);
    }

    /* JADX WARN: Removed duplicated region for block: B:104:0x0430 A[Catch: all -> 0x04af, TryCatch #4 {all -> 0x04af, blocks: (B:100:0x0404, B:104:0x0430, B:105:0x044e, B:107:0x0453, B:108:0x0455, B:110:0x045e, B:114:0x047a, B:120:0x048a, B:122:0x0496, B:113:0x0470), top: B:147:0x0404 }] */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0453 A[Catch: all -> 0x04af, TryCatch #4 {all -> 0x04af, blocks: (B:100:0x0404, B:104:0x0430, B:105:0x044e, B:107:0x0453, B:108:0x0455, B:110:0x045e, B:114:0x047a, B:120:0x048a, B:122:0x0496, B:113:0x0470), top: B:147:0x0404 }] */
    /* JADX WARN: Removed duplicated region for block: B:110:0x045e A[Catch: all -> 0x04af, TryCatch #4 {all -> 0x04af, blocks: (B:100:0x0404, B:104:0x0430, B:105:0x044e, B:107:0x0453, B:108:0x0455, B:110:0x045e, B:114:0x047a, B:120:0x048a, B:122:0x0496, B:113:0x0470), top: B:147:0x0404 }] */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0492  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x035c A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00b9 A[Catch: all -> 0x011a, TryCatch #3 {all -> 0x011a, blocks: (B:10:0x0084, B:12:0x008a, B:25:0x00b9, B:31:0x0126, B:36:0x0134, B:38:0x0150, B:39:0x0166, B:50:0x01b3, B:42:0x016f, B:44:0x0193, B:48:0x01ab, B:47:0x01a1, B:26:0x00ce, B:16:0x0098, B:18:0x00a5, B:20:0x00ac), top: B:145:0x0084 }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00ce A[Catch: all -> 0x011a, TryCatch #3 {all -> 0x011a, blocks: (B:10:0x0084, B:12:0x008a, B:25:0x00b9, B:31:0x0126, B:36:0x0134, B:38:0x0150, B:39:0x0166, B:50:0x01b3, B:42:0x016f, B:44:0x0193, B:48:0x01ab, B:47:0x01a1, B:26:0x00ce, B:16:0x0098, B:18:0x00a5, B:20:0x00ac), top: B:145:0x0084 }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0126 A[Catch: all -> 0x011a, TryCatch #3 {all -> 0x011a, blocks: (B:10:0x0084, B:12:0x008a, B:25:0x00b9, B:31:0x0126, B:36:0x0134, B:38:0x0150, B:39:0x0166, B:50:0x01b3, B:42:0x016f, B:44:0x0193, B:48:0x01ab, B:47:0x01a1, B:26:0x00ce, B:16:0x0098, B:18:0x00a5, B:20:0x00ac), top: B:145:0x0084 }] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0360  */
    /* renamed from: v */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void m34902v(android.content.Context r34, android.media.MediaExtractor r35, android.media.MediaMuxer r36, int r37, java.lang.Integer r38, java.lang.Integer r39, @androidx.annotation.NonNull java.lang.Float r40, @androidx.annotation.Nullable com.p201hw.videoprocessor.util.VideoProgressListener r41) throws java.lang.Exception {
        /*
            Method dump skipped, instructions count: 1252
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.p201hw.videoprocessor.util.AudioUtil.m34902v(android.content.Context, android.media.MediaExtractor, android.media.MediaMuxer, int, java.lang.Integer, java.lang.Integer, java.lang.Float, com.hw.videoprocessor.util.k):void");
    }
}

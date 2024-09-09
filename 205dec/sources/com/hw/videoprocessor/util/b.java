package com.hw.videoprocessor.util;

import android.content.Context;
import android.media.MediaCodec;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import android.util.Pair;
import androidx.annotation.IntRange;
import androidx.annotation.Nullable;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.HashMap;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* compiled from: AudioUtil.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private static final Map<Integer, Integer> f37604a;

    /* renamed from: b  reason: collision with root package name */
    static final String f37605b = "VideoProcessor";

    /* renamed from: c  reason: collision with root package name */
    public static int f37606c;

    static {
        HashMap hashMap = new HashMap();
        f37604a = hashMap;
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
        hashMap.put(Integer.valueOf((int) AVMDLDataLoader.KeyIsLiveSetLoaderType), 11);
        hashMap.put(7350, 12);
        f37606c = 1;
    }

    public static void a(Context context, String str, String str2, @IntRange(from = 0, to = 100) int i4, @Nullable k kVar) throws IOException {
        String name = new File(str).getName();
        File h4 = com.hw.videoprocessor.i.h(context);
        File file = new File(h4, name + ".pcm");
        File h5 = com.hw.videoprocessor.i.h(context);
        File file2 = new File(h5, name + "_2.pcm");
        File h6 = com.hw.videoprocessor.i.h(context);
        File file3 = new File(h6, name + ".wav");
        g(str, file.getAbsolutePath(), null, null);
        b(file.getAbsolutePath(), file2.getAbsolutePath(), i4);
        MediaExtractor mediaExtractor = new MediaExtractor();
        mediaExtractor.setDataSource(str);
        MediaFormat trackFormat = mediaExtractor.getTrackFormat(com.hw.videoprocessor.i.k(mediaExtractor, true));
        int integer = trackFormat.getInteger(com.bykv.vk.component.ttvideo.player.MediaFormat.KEY_SAMPLE_RATE);
        int integer2 = trackFormat.getInteger(com.bykv.vk.component.ttvideo.player.MediaFormat.KEY_CHANNEL_COUNT);
        new g(integer, integer2 == 2 ? 12 : 16, integer2, 2).a(file2.getAbsolutePath(), file3.getAbsolutePath());
        h(file3.getPath(), str2, trackFormat, kVar);
    }

    public static void b(String str, String str2, @IntRange(from = 0, to = 100) int i4) throws IOException {
        if (i4 == 100) {
            f(str, str2);
            return;
        }
        float m4 = m(i4);
        byte[] bArr = new byte[2048];
        FileInputStream fileInputStream = new FileInputStream(str);
        FileOutputStream fileOutputStream = new FileOutputStream(str2);
        while (fileInputStream.read(bArr) != -1) {
            try {
                for (int i5 = 0; i5 < 2048; i5 += 2) {
                    int i6 = i5 + 1;
                    int i7 = (int) (((short) ((bArr[i5] & 255) | ((bArr[i6] & 255) << 8))) * m4);
                    if (i7 > 32767) {
                        i7 = 32767;
                    } else if (i7 < -32768) {
                        i7 = -32768;
                    }
                    bArr[i5] = (byte) (i7 & 255);
                    bArr[i6] = (byte) ((i7 >>> 8) & 255);
                }
                fileOutputStream.write(bArr);
            } finally {
                fileInputStream.close();
                fileOutputStream.close();
            }
        }
    }

    public static Pair<Integer, Integer> c(String str, String str2, MediaFormat mediaFormat, MediaFormat mediaFormat2) {
        int i4;
        int i5 = 1;
        int integer = mediaFormat.containsKey(com.bykv.vk.component.ttvideo.player.MediaFormat.KEY_CHANNEL_COUNT) ? mediaFormat.getInteger(com.bykv.vk.component.ttvideo.player.MediaFormat.KEY_CHANNEL_COUNT) : 1;
        int integer2 = mediaFormat2.containsKey(com.bykv.vk.component.ttvideo.player.MediaFormat.KEY_CHANNEL_COUNT) ? mediaFormat2.getInteger(com.bykv.vk.component.ttvideo.player.MediaFormat.KEY_CHANNEL_COUNT) : 1;
        int integer3 = mediaFormat.containsKey(com.bykv.vk.component.ttvideo.player.MediaFormat.KEY_SAMPLE_RATE) ? mediaFormat.getInteger(com.bykv.vk.component.ttvideo.player.MediaFormat.KEY_SAMPLE_RATE) : 44100;
        int integer4 = mediaFormat2.containsKey(com.bykv.vk.component.ttvideo.player.MediaFormat.KEY_SAMPLE_RATE) ? mediaFormat2.getInteger(com.bykv.vk.component.ttvideo.player.MediaFormat.KEY_SAMPLE_RATE) : 44100;
        if (integer == integer2 && integer3 == integer4 && integer <= 2) {
            return new Pair<>(Integer.valueOf(integer), Integer.valueOf(integer3));
        }
        File file = new File(str + ".temp");
        File file2 = new File(str2 + ".temp");
        if (integer != integer2 || integer > 2 || integer2 > 2) {
            if (integer > 1) {
                try {
                    try {
                        s(str, file.getAbsolutePath(), integer);
                        File file3 = new File(str);
                        file3.delete();
                        file.renameTo(file3);
                        i4 = 1;
                    } catch (Exception e4) {
                        e = e4;
                        c.g(e);
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
                i4 = integer;
            }
            if (integer2 > 1) {
                s(str2, file2.getAbsolutePath(), integer2);
                File file4 = new File(str2);
                file4.delete();
                file2.renameTo(file4);
                integer2 = 1;
            }
            integer = i4;
        } else {
            i5 = integer;
        }
        if (integer3 != integer4) {
            try {
                int min = Math.min(integer3, integer4);
                if (integer3 != min) {
                    try {
                        n(str, file.getAbsolutePath(), integer3, min, integer);
                        File file5 = new File(str);
                        file5.delete();
                        file.renameTo(file5);
                    } catch (Exception e5) {
                        e = e5;
                        integer3 = min;
                        integer = i5;
                        c.g(e);
                        Pair<Integer, Integer> pair2 = new Pair<>(Integer.valueOf(integer), Integer.valueOf(integer3));
                        file.delete();
                        file2.exists();
                        return pair2;
                    }
                }
                if (integer4 != min) {
                    n(str2, file2.getAbsolutePath(), integer4, min, integer2);
                    File file6 = new File(str2);
                    file6.delete();
                    file2.renameTo(file6);
                }
                integer3 = min;
            } catch (Exception e6) {
                e = e6;
            }
        }
        Pair<Integer, Integer> pair3 = new Pair<>(Integer.valueOf(i5), Integer.valueOf(integer3));
        file.delete();
        file2.exists();
        return pair3;
    }

    /* JADX WARN: Removed duplicated region for block: B:58:0x00cf A[Catch: IOException -> 0x00cb, TryCatch #9 {IOException -> 0x00cb, blocks: (B:54:0x00c7, B:58:0x00cf, B:60:0x00d4, B:62:0x00d9), top: B:74:0x00c7 }] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00d4 A[Catch: IOException -> 0x00cb, TryCatch #9 {IOException -> 0x00cb, blocks: (B:54:0x00c7, B:58:0x00cf, B:60:0x00d4, B:62:0x00d9), top: B:74:0x00c7 }] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00d9 A[Catch: IOException -> 0x00cb, TRY_LEAVE, TryCatch #9 {IOException -> 0x00cb, blocks: (B:54:0x00c7, B:58:0x00cf, B:60:0x00d4, B:62:0x00d9), top: B:74:0x00c7 }] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00c7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.io.File d(java.io.File r12, int r13, int r14) {
        /*
            Method dump skipped, instructions count: 227
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hw.videoprocessor.util.b.d(java.io.File, int, int):java.io.File");
    }

    public static void e(MediaFormat mediaFormat, int i4, int i5, int i6) {
        Map<Integer, Integer> map = f37604a;
        int intValue = map.containsKey(Integer.valueOf(i5)) ? map.get(Integer.valueOf(i5)).intValue() : 4;
        ByteBuffer allocate = ByteBuffer.allocate(2);
        allocate.put(0, (byte) ((i4 << 3) | (intValue >> 1)));
        allocate.put(1, (byte) (((intValue & 1) << 7) | (i6 << 3)));
        mediaFormat.setByteBuffer("csd-0", allocate);
    }

    public static void f(String str, String str2) throws IOException {
        FileChannel channel = new FileOutputStream(str2).getChannel();
        FileChannel channel2 = new FileInputStream(str).getChannel();
        channel2.transferTo(0L, channel2.size(), channel);
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x009e A[Catch: all -> 0x00ed, TryCatch #0 {all -> 0x00ed, blocks: (B:14:0x0070, B:16:0x0076, B:28:0x009e, B:34:0x00f3, B:39:0x0100, B:41:0x011d, B:42:0x0134, B:46:0x015c, B:45:0x013b, B:29:0x00ae, B:19:0x0082, B:21:0x008b, B:23:0x0091), top: B:53:0x0070 }] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00ae A[Catch: all -> 0x00ed, TryCatch #0 {all -> 0x00ed, blocks: (B:14:0x0070, B:16:0x0076, B:28:0x009e, B:34:0x00f3, B:39:0x0100, B:41:0x011d, B:42:0x0134, B:46:0x015c, B:45:0x013b, B:29:0x00ae, B:19:0x0082, B:21:0x008b, B:23:0x0091), top: B:53:0x0070 }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00f3 A[Catch: all -> 0x00ed, TryCatch #0 {all -> 0x00ed, blocks: (B:14:0x0070, B:16:0x0076, B:28:0x009e, B:34:0x00f3, B:39:0x0100, B:41:0x011d, B:42:0x0134, B:46:0x015c, B:45:0x013b, B:29:0x00ae, B:19:0x0082, B:21:0x008b, B:23:0x0091), top: B:53:0x0070 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void g(java.lang.String r21, java.lang.String r22, java.lang.Integer r23, java.lang.Integer r24) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 381
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hw.videoprocessor.util.b.g(java.lang.String, java.lang.String, java.lang.Integer, java.lang.Integer):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x01d3 A[Catch: all -> 0x0233, TryCatch #1 {all -> 0x0233, blocks: (B:35:0x01ab, B:39:0x01d3, B:40:0x01f0, B:42:0x01f5, B:43:0x01f7, B:45:0x01fc, B:51:0x0213, B:53:0x021e), top: B:70:0x01ab }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x01f5 A[Catch: all -> 0x0233, TryCatch #1 {all -> 0x0233, blocks: (B:35:0x01ab, B:39:0x01d3, B:40:0x01f0, B:42:0x01f5, B:43:0x01f7, B:45:0x01fc, B:51:0x0213, B:53:0x021e), top: B:70:0x01ab }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x01fc A[Catch: all -> 0x0233, TryCatch #1 {all -> 0x0233, blocks: (B:35:0x01ab, B:39:0x01d3, B:40:0x01f0, B:42:0x01f5, B:43:0x01f7, B:45:0x01fc, B:51:0x0213, B:53:0x021e), top: B:70:0x01ab }] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x021c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void h(java.lang.String r31, java.lang.String r32, android.media.MediaFormat r33, @androidx.annotation.Nullable com.hw.videoprocessor.util.k r34) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 590
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hw.videoprocessor.util.b.h(java.lang.String, java.lang.String, android.media.MediaFormat, com.hw.videoprocessor.util.k):void");
    }

    public static int i(MediaFormat mediaFormat) {
        if (mediaFormat.containsKey("bitrate")) {
            return mediaFormat.getInteger("bitrate");
        }
        return 192000;
    }

    public static int j(MediaFormat mediaFormat) {
        if (mediaFormat.containsKey("max-input-size")) {
            return mediaFormat.getInteger("max-input-size");
        }
        return 100000;
    }

    public static boolean k(String str) throws IOException {
        MediaExtractor mediaExtractor = new MediaExtractor();
        mediaExtractor.setDataSource(str);
        int trackCount = mediaExtractor.getTrackCount();
        MediaFormat mediaFormat = null;
        for (int i4 = 0; i4 < trackCount; i4++) {
            mediaFormat = mediaExtractor.getTrackFormat(i4);
            if (mediaFormat.getString("mime").startsWith("audio/")) {
                break;
            }
        }
        mediaExtractor.release();
        return mediaFormat != null && mediaFormat.getInteger(com.bykv.vk.component.ttvideo.player.MediaFormat.KEY_CHANNEL_COUNT) > 1;
    }

    public static void l(String str, String str2, String str3, @IntRange(from = 0, to = 100) int i4, @IntRange(from = 0, to = 100) int i5) throws IOException {
        float m4 = m(i4);
        float m5 = m(i5);
        int i6 = 2048;
        byte[] bArr = new byte[2048];
        byte[] bArr2 = new byte[2048];
        byte[] bArr3 = new byte[2048];
        FileInputStream fileInputStream = new FileInputStream(str);
        FileInputStream fileInputStream2 = new FileInputStream(str2);
        FileOutputStream fileOutputStream = new FileOutputStream(str3);
        boolean z3 = false;
        boolean z4 = false;
        while (true) {
            if (z3 && z4) {
                fileInputStream.close();
                fileInputStream2.close();
                fileOutputStream.close();
                return;
            }
            if (!z3) {
                try {
                    z3 = fileInputStream.read(bArr) == -1;
                    System.arraycopy(bArr, 0, bArr3, 0, i6);
                } catch (Throwable th) {
                    fileInputStream.close();
                    fileInputStream2.close();
                    fileOutputStream.close();
                    throw th;
                }
            }
            if (!z4) {
                z4 = fileInputStream2.read(bArr2) == -1;
                int i7 = 0;
                while (i7 < i6) {
                    int i8 = i7 + 1;
                    int i9 = (int) ((((short) (((bArr2[i8] & 255) << 8) | (bArr2[i7] & 255))) * m5) + (((short) ((bArr[i7] & 255) | ((bArr[i8] & 255) << 8))) * m4));
                    if (i9 > 32767) {
                        i9 = 32767;
                    } else if (i9 < -32768) {
                        i9 = -32768;
                    }
                    bArr3[i7] = (byte) (i9 & 255);
                    bArr3[i8] = (byte) ((i9 >>> 8) & 255);
                    i7 += 2;
                    i6 = 2048;
                }
            }
            fileOutputStream.write(bArr3);
            i6 = 2048;
        }
    }

    private static float m(@IntRange(from = 0, to = 100) int i4) {
        return (i4 / 100.0f) * f37606c;
    }

    public static boolean n(String str, String str2, int i4, int i5, int i6) {
        try {
            new com.hw.videoprocessor.jssrc.b(new FileInputStream(str), new FileOutputStream(str2), i4, i5, 2, 2, i6, (int) new File(str).length(), 0.0d, 0, true);
            return true;
        } catch (IOException e4) {
            c.g(e4);
            e4.printStackTrace();
            return true;
        }
    }

    public static void o(String str, String str2) throws IOException {
        MediaExtractor mediaExtractor = new MediaExtractor();
        mediaExtractor.setDataSource(str);
        try {
            int k4 = com.hw.videoprocessor.i.k(mediaExtractor, false);
            mediaExtractor.selectTrack(k4);
            MediaFormat trackFormat = mediaExtractor.getTrackFormat(k4);
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

    public static void p(String str, String str2, String str3, boolean z3) throws IOException {
        MediaExtractor mediaExtractor = new MediaExtractor();
        mediaExtractor.setDataSource(str);
        MediaExtractor mediaExtractor2 = new MediaExtractor();
        mediaExtractor2.setDataSource(str2);
        try {
            int k4 = com.hw.videoprocessor.i.k(mediaExtractor, false);
            int k5 = com.hw.videoprocessor.i.k(mediaExtractor2, true);
            mediaExtractor.selectTrack(k4);
            mediaExtractor2.selectTrack(k5);
            MediaFormat trackFormat = mediaExtractor2.getTrackFormat(k5);
            MediaFormat trackFormat2 = mediaExtractor.getTrackFormat(k4);
            MediaMuxer mediaMuxer = new MediaMuxer(str3, 0);
            int addTrack = mediaMuxer.addTrack(trackFormat);
            int addTrack2 = mediaMuxer.addTrack(trackFormat2);
            mediaMuxer.start();
            MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
            ByteBuffer allocateDirect = ByteBuffer.allocateDirect(trackFormat2.getInteger("max-input-size"));
            long j4 = 0;
            long j5 = 0;
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
                j5 = sampleTime;
                j4 = 0;
            }
            int integer = 1024000000 / trackFormat.getInteger(com.bykv.vk.component.ttvideo.player.MediaFormat.KEY_SAMPLE_RATE);
            ByteBuffer allocateDirect2 = ByteBuffer.allocateDirect(j(trackFormat));
            long j6 = j4;
            long j7 = j6;
            while (j6 < j5) {
                mediaExtractor2.seekTo(j4, 2);
                while (true) {
                    long sampleTime2 = mediaExtractor2.getSampleTime();
                    if (sampleTime2 == -1) {
                        break;
                    }
                    j6 = sampleTime2 + j7;
                    if (j6 > j5) {
                        break;
                    }
                    int sampleFlags2 = mediaExtractor2.getSampleFlags();
                    int readSampleData2 = mediaExtractor2.readSampleData(allocateDirect2, 0);
                    bufferInfo.presentationTimeUs = j6;
                    bufferInfo.flags = sampleFlags2;
                    bufferInfo.size = readSampleData2;
                    mediaMuxer.writeSampleData(addTrack, allocateDirect2, bufferInfo);
                    mediaExtractor2.advance();
                }
                j7 = j6 + integer;
                if (!z3) {
                    break;
                }
                j4 = 0;
            }
            mediaMuxer.stop();
            mediaMuxer.release();
        } finally {
            mediaExtractor.release();
            mediaExtractor2.release();
        }
    }

    public static void q(String str, String str2) throws IOException {
        FileOutputStream fileOutputStream;
        RandomAccessFile randomAccessFile = null;
        try {
            RandomAccessFile randomAccessFile2 = new RandomAccessFile(str, "r");
            try {
                fileOutputStream = new FileOutputStream(str2);
                try {
                    long j4 = 2;
                    byte[] bArr = new byte[2];
                    for (long length = randomAccessFile2.length() - j4; length >= 0; length -= j4) {
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

    public static void r(String str, String str2) throws IOException {
        s(str, str2, 2);
    }

    public static void s(String str, String str2, @IntRange(from = 2) int i4) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(str);
        FileOutputStream fileOutputStream = new FileOutputStream(str2);
        byte[] bArr = new byte[i4 * 1024];
        byte[] bArr2 = new byte[1024];
        while (fileInputStream.read(bArr) != -1) {
            for (int i5 = 0; i5 < 1024; i5 += 2) {
                int i6 = i4 * i5;
                bArr2[i5] = bArr[i6];
                bArr2[i5 + 1] = bArr[i6 + 1];
            }
            fileOutputStream.write(bArr2);
        }
        fileInputStream.close();
        fileOutputStream.close();
    }

    public static long t(MediaExtractor mediaExtractor, MediaMuxer mediaMuxer, int i4, Integer num, Integer num2, long j4, k kVar) throws IOException {
        int k4 = com.hw.videoprocessor.i.k(mediaExtractor, true);
        mediaExtractor.selectTrack(k4);
        Integer num3 = num == null ? 0 : num;
        mediaExtractor.seekTo(num3.intValue(), 2);
        MediaFormat trackFormat = mediaExtractor.getTrackFormat(k4);
        long j5 = trackFormat.getLong("durationUs");
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(trackFormat.getInteger("max-input-size"));
        MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
        long j6 = j4;
        while (true) {
            long sampleTime = mediaExtractor.getSampleTime();
            if (sampleTime == -1) {
                break;
            } else if (sampleTime < num3.intValue()) {
                mediaExtractor.advance();
            } else if (num2 != null && sampleTime > num2.intValue()) {
                break;
            } else {
                if (kVar != null) {
                    float intValue = ((float) (sampleTime - num3.intValue())) / ((float) (num2 == null ? j5 : num2.intValue() - num3.intValue()));
                    if (intValue < 0.0f) {
                        intValue = 0.0f;
                    }
                    if (intValue > 1.0f) {
                        intValue = 1.0f;
                    }
                    kVar.a(intValue);
                }
                bufferInfo.presentationTimeUs = (sampleTime - num3.intValue()) + j4;
                bufferInfo.flags = mediaExtractor.getSampleFlags();
                int readSampleData = mediaExtractor.readSampleData(allocateDirect, 0);
                bufferInfo.size = readSampleData;
                if (readSampleData < 0) {
                    break;
                }
                c.k("writeAudioSampleData,time:" + (((float) bufferInfo.presentationTimeUs) / 1000.0f), new Object[0]);
                mediaMuxer.writeSampleData(i4, allocateDirect, bufferInfo);
                long j7 = bufferInfo.presentationTimeUs;
                mediaExtractor.advance();
                j6 = j7;
            }
        }
        return j6;
    }

    public static long u(MediaExtractor mediaExtractor, MediaMuxer mediaMuxer, int i4, Integer num, Integer num2, k kVar) throws IOException {
        return t(mediaExtractor, mediaMuxer, i4, num, num2, 0L, kVar);
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
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void v(android.content.Context r34, android.media.MediaExtractor r35, android.media.MediaMuxer r36, int r37, java.lang.Integer r38, java.lang.Integer r39, @androidx.annotation.NonNull java.lang.Float r40, @androidx.annotation.Nullable com.hw.videoprocessor.util.k r41) throws java.lang.Exception {
        /*
            Method dump skipped, instructions count: 1252
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hw.videoprocessor.util.b.v(android.content.Context, android.media.MediaExtractor, android.media.MediaMuxer, int, java.lang.Integer, java.lang.Integer, java.lang.Float, com.hw.videoprocessor.util.k):void");
    }
}

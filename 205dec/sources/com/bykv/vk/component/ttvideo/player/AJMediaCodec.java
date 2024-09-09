package com.bykv.vk.component.ttvideo.player;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaCrypto;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import android.view.Surface;
import com.acse.ottn.f3;
import com.bykv.vk.component.ttvideo.utils.Util;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.ss.android.download.api.constant.BaseConstants;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;

@Keep
@TargetApi(16)
/* loaded from: E:\TSN-r\205dec\6465380.dex */
class AJMediaCodec {
    private static final int AV_TRC_ARIB_STD_B67 = 18;
    private static final int AV_TRC_SMPTE2084 = 16;
    private static final int CODEC_ERROR = -10000;
    private static final int CODEC_EXCEPTION_ERROR = -10001;
    private static final int CODEC_ILLEGAL_ARGUMENT = -10003;
    private static final int CODEC_ILLEGAL_STATE = -10002;
    private static final double FIX_VERSION = 0.18041d;
    private static final long INPUT_TIMEOUT_US = 30000;
    private static final String KEY_CROP_BOTTOM = "crop-bottom";
    private static final String KEY_CROP_LEFT = "crop-left";
    private static final String KEY_CROP_RIGHT = "crop-right";
    private static final String KEY_CROP_TOP = "crop-top";
    private static final int NO_VALUE = -1;
    private static final int PIXEL_FORMAT_NV12 = 3;
    private static final int PIXEL_FORMAT_YUV420P = 0;
    private static final String TAG = "aj_media_codec";
    private static final String VENDOR_OPPO_PROPERTY = "persist.sys.aweme.hdsupport";
    private static final String VERSION_PROPERTY = "ro.config.hw_codec_support";
    private MediaCodec.BufferInfo mBufferInfo;
    private Surface mDummySurface;
    private String mExceptionInfo;
    private ByteBuffer[] mInputBuffers;
    private MediaCodec mMediaCodec;
    private ByteBuffer[] mOutputBuffers;
    private static ArrayList<MediaCodecInfo> mVideoHWDecoderCodecs = new ArrayList<>();
    private static Object mCodecListLock = new Object();
    private static boolean mEvaluatedDeviceNeedsSetOutputSurfaceWorkaround = false;
    private static boolean mDeviceNeedsSetOutputSurfaceWorkaround = false;
    private static boolean mIsInitDetected = false;
    private static boolean mIsByteVC1Blocklist = false;
    private static boolean mNeedByteVC1WorkAround = false;
    private boolean mInputBuffersValid = false;
    private android.media.MediaFormat mOutputMediaFormat = null;

    @CalledByNative
    public AJMediaCodec() {
        boolean z3 = false;
        if (!mIsInitDetected) {
            if (Util.HARDWARE.toLowerCase(Locale.US).startsWith("mt") && Util.SDK_INT < 26) {
                z3 = true;
            }
            mNeedByteVC1WorkAround = z3;
            if (isHisiByteVC1BlockList() || isMtkByteVC1BlockList()) {
                mIsByteVC1Blocklist = true;
            }
        }
        codecNeedsSetOutputSurfaceWorkaround();
        mIsInitDetected = true;
        Log.i(TAG, "initialize, need workaround " + mDeviceNeedsSetOutputSurfaceWorkaround);
    }

    public static int ceilDivide(int i4, int i5) {
        return ((i4 + i5) - 1) / i5;
    }

    private static boolean codecNeedsFlushWorkaround(String str) {
        int i4 = Util.SDK_INT;
        return i4 < 18 || (i4 == 18 && ("OMX.SEC.avc.dec".equals(str) || "OMX.SEC.avc.dec.secure".equals(str))) || (i4 == 19 && Util.MODEL.startsWith("SM-G800") && ("OMX.Exynos.avc.dec".equals(str) || "OMX.Exynos.avc.dec.secure".equals(str)));
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x005a A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x007c A[Catch: all -> 0x0093, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x0007, B:8:0x000e, B:10:0x0018, B:51:0x008d, B:13:0x0020, B:35:0x0061, B:50:0x008b, B:40:0x0072, B:43:0x007c, B:34:0x005f, B:20:0x0039, B:23:0x0043, B:26:0x004d, B:52:0x008f), top: B:58:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0088 A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean codecNeedsSetOutputSurfaceWorkaround() {
        /*
            java.lang.Class<com.bykv.vk.component.ttvideo.player.AJMediaCodec> r0 = com.bykv.vk.component.ttvideo.player.AJMediaCodec.class
            monitor-enter(r0)
            boolean r1 = com.bykv.vk.component.ttvideo.player.AJMediaCodec.mEvaluatedDeviceNeedsSetOutputSurfaceWorkaround     // Catch: java.lang.Throwable -> L93
            if (r1 != 0) goto L8f
            int r1 = com.bykv.vk.component.ttvideo.utils.Util.SDK_INT     // Catch: java.lang.Throwable -> L93
            r2 = 27
            r3 = 1
            if (r1 > r2) goto L1c
            java.lang.String r4 = "dangal"
            java.lang.String r5 = com.bykv.vk.component.ttvideo.utils.Util.DEVICE     // Catch: java.lang.Throwable -> L93
            boolean r4 = r4.equals(r5)     // Catch: java.lang.Throwable -> L93
            if (r4 == 0) goto L1c
            com.bykv.vk.component.ttvideo.player.AJMediaCodec.mDeviceNeedsSetOutputSurfaceWorkaround = r3     // Catch: java.lang.Throwable -> L93
            goto L8d
        L1c:
            if (r1 < r2) goto L20
            goto L8d
        L20:
            java.lang.String r1 = com.bykv.vk.component.ttvideo.utils.Util.DEVICE     // Catch: java.lang.Throwable -> L93
            int r2 = r1.hashCode()     // Catch: java.lang.Throwable -> L93
            r4 = 99329(0x18401, float:1.3919E-40)
            r5 = 0
            r6 = 2
            r7 = -1
            if (r2 == r4) goto L4d
            r4 = 3351335(0x332327, float:4.69622E-39)
            if (r2 == r4) goto L43
            r4 = 1865889110(0x6f373556, float:5.6700236E28)
            if (r2 == r4) goto L39
            goto L57
        L39:
            java.lang.String r2 = "santoni"
            boolean r1 = r1.equals(r2)     // Catch: java.lang.Throwable -> L93
            if (r1 == 0) goto L57
            r1 = 2
            goto L58
        L43:
            java.lang.String r2 = "mido"
            boolean r1 = r1.equals(r2)     // Catch: java.lang.Throwable -> L93
            if (r1 == 0) goto L57
            r1 = 1
            goto L58
        L4d:
            java.lang.String r2 = "deb"
            boolean r1 = r1.equals(r2)     // Catch: java.lang.Throwable -> L93
            if (r1 == 0) goto L57
            r1 = 0
            goto L58
        L57:
            r1 = -1
        L58:
            if (r1 == 0) goto L5f
            if (r1 == r3) goto L5f
            if (r1 == r6) goto L5f
            goto L61
        L5f:
            com.bykv.vk.component.ttvideo.player.AJMediaCodec.mDeviceNeedsSetOutputSurfaceWorkaround = r3     // Catch: java.lang.Throwable -> L93
        L61:
            java.lang.String r1 = com.bykv.vk.component.ttvideo.utils.Util.MODEL     // Catch: java.lang.Throwable -> L93
            int r2 = r1.hashCode()     // Catch: java.lang.Throwable -> L93
            r4 = 2006354(0x1e9d52, float:2.811501E-39)
            if (r2 == r4) goto L7c
            r4 = 2006367(0x1e9d5f, float:2.811519E-39)
            if (r2 == r4) goto L72
            goto L85
        L72:
            java.lang.String r2 = "AFTN"
            boolean r1 = r1.equals(r2)     // Catch: java.lang.Throwable -> L93
            if (r1 == 0) goto L85
            r5 = 1
            goto L86
        L7c:
            java.lang.String r2 = "AFTA"
            boolean r1 = r1.equals(r2)     // Catch: java.lang.Throwable -> L93
            if (r1 == 0) goto L85
            goto L86
        L85:
            r5 = -1
        L86:
            if (r5 == 0) goto L8b
            if (r5 == r3) goto L8b
            goto L8d
        L8b:
            com.bykv.vk.component.ttvideo.player.AJMediaCodec.mDeviceNeedsSetOutputSurfaceWorkaround = r3     // Catch: java.lang.Throwable -> L93
        L8d:
            com.bykv.vk.component.ttvideo.player.AJMediaCodec.mEvaluatedDeviceNeedsSetOutputSurfaceWorkaround = r3     // Catch: java.lang.Throwable -> L93
        L8f:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L93
            boolean r0 = com.bykv.vk.component.ttvideo.player.AJMediaCodec.mDeviceNeedsSetOutputSurfaceWorkaround
            return r0
        L93:
            r1 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L93
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bykv.vk.component.ttvideo.player.AJMediaCodec.codecNeedsSetOutputSurfaceWorkaround():boolean");
    }

    private void createDummySurface() {
        Log.d(TAG, "create dummy surface");
        this.mDummySurface = DummySurface.newInstanceV17(false);
    }

    private static int getMaxInputSize(String str, int i4, int i5) {
        int i6;
        int i7;
        if (i4 == -1 || i5 == -1) {
            return -1;
        }
        if (!str.equals("video/3gpp") && !str.equals("video/mp4v-es")) {
            if (str.equals("video/avc")) {
                if ("BRAVIA 4K 2015".equals(Util.MODEL)) {
                    return -1;
                }
                i6 = ceilDivide(i4, 16) * ceilDivide(i5, 16) * 16 * 16;
                i7 = 2;
                return (i6 * 3) / (i7 * 2);
            } else if (!str.equals("video/x-vnd.on2.vp8")) {
                if (str.equals("video/hevc") || str.equals("video/x-vnd.on2.vp9")) {
                    i6 = i4 * i5;
                    i7 = 4;
                    return (i6 * 3) / (i7 * 2);
                }
                return -1;
            }
        }
        i6 = i4 * i5;
        i7 = 2;
        return (i6 * 3) / (i7 * 2);
    }

    public static String getProperty(String str, String str2) {
        try {
            try {
                Class<?> cls = Class.forName("android.os.SystemProperties");
                return (String) cls.getMethod(f3.f5657f, String.class, String.class).invoke(cls, str, str2);
            } catch (Exception e4) {
                e4.printStackTrace();
                return str2;
            }
        } catch (Throwable unused) {
            return str2;
        }
    }

    private boolean isHisiByteVC1BlockList() {
        String property = getProperty("ro.board.platform", null);
        if (Util.SDK_INT != 26 || property == null) {
            return false;
        }
        if (property.startsWith("kirin960") || property.startsWith("hi3660")) {
            double d4 = 0.0d;
            try {
                d4 = Double.parseDouble(getProperty(VERSION_PROPERTY, "0.0"));
            } catch (NumberFormatException unused) {
                Log.w(TAG, "vendor property abnormal");
            }
            return d4 < FIX_VERSION;
        }
        return false;
    }

    private boolean isMtkByteVC1BlockList() {
        String lowerCase = Util.HARDWARE.toLowerCase(Locale.US);
        return lowerCase.startsWith("mt6763") || lowerCase.startsWith("mt6757") || lowerCase.startsWith("mt6739") || lowerCase.startsWith("mt6750");
    }

    private static void maybeSetCsdBuffers(android.media.MediaFormat mediaFormat, ByteBuffer byteBuffer, int i4) {
        if (byteBuffer == null) {
            return;
        }
        mediaFormat.setByteBuffer("csd-" + i4, byteBuffer);
    }

    private static void maybeSetInteger(android.media.MediaFormat mediaFormat, String str, int i4) {
        if (i4 != -1) {
            mediaFormat.setInteger(str, i4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x000d, code lost:
        if (r5 != null) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void releaseCodec(android.media.MediaCodec r5) {
        /*
            r4 = this;
            java.lang.String r0 = "codec release end"
            java.lang.String r1 = "aj_media_codec"
            if (r5 != 0) goto L7
            return
        L7:
            r2 = 0
            r5.release()     // Catch: java.lang.Throwable -> L18 java.lang.Exception -> L28
            android.view.Surface r5 = r4.mDummySurface
            if (r5 == 0) goto L14
        Lf:
            r5.release()
            r4.mDummySurface = r2
        L14:
            android.util.Log.i(r1, r0)
            goto L2f
        L18:
            r5 = move-exception
            android.view.Surface r3 = r4.mDummySurface
            if (r3 == 0) goto L24
            android.view.Surface r3 = r4.mDummySurface
            r3.release()
            r4.mDummySurface = r2
        L24:
            android.util.Log.i(r1, r0)
            throw r5
        L28:
            android.view.Surface r5 = r4.mDummySurface
            if (r5 == 0) goto L14
            android.view.Surface r5 = r4.mDummySurface
            goto Lf
        L2f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bykv.vk.component.ttvideo.player.AJMediaCodec.releaseCodec(android.media.MediaCodec):void");
    }

    @TargetApi(21)
    private int renderOutputBufferV21(int i4, long j4) {
        try {
            this.mMediaCodec.releaseOutputBuffer(i4, j4);
            return 0;
        } catch (Exception unused) {
            return -10000;
        }
    }

    @TargetApi(23)
    private int setOutputSurfaceV23(MediaCodec mediaCodec, Surface surface) {
        try {
            mediaCodec.setOutputSurface(surface);
            return 0;
        } catch (Exception e4) {
            handleCodecException(e4);
            Log.w(TAG, "setoutputsurface failed = " + e4);
            return -1;
        }
    }

    @CalledByNative
    private boolean supportSetSurface() {
        return !mDeviceNeedsSetOutputSurfaceWorkaround;
    }

    public boolean MTKByteVC1NeedWorkAround() {
        return mNeedByteVC1WorkAround;
    }

    @CalledByNative
    public void close() {
        Log.i(TAG, "close start");
        if (this.mMediaCodec != null) {
            stop();
            final MediaCodec mediaCodec = this.mMediaCodec;
            this.mInputBuffers = null;
            this.mOutputBuffers = null;
            this.mMediaCodec = null;
            try {
                AVThreadPool.addTask(new Runnable() { // from class: com.bykv.vk.component.ttvideo.player.AJMediaCodec.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Log.i(AJMediaCodec.TAG, "start releaseCodec task");
                        AJMediaCodec.this.releaseCodec(mediaCodec);
                    }
                });
            } catch (Throwable unused) {
                Log.w(TAG, "new thread failed");
                releaseCodec(mediaCodec);
            }
        }
        Log.i(TAG, "close end");
    }

    @CalledByNative
    public int configure(int i4, int i5, int i6, int i7, int i8, String str, ByteBuffer byteBuffer, ByteBuffer byteBuffer2, ByteBuffer byteBuffer3, Surface surface, boolean z3, boolean z4, int i9, int i10, boolean z5, int i11, boolean z6, boolean z7, int i12, int i13) {
        Surface surface2 = surface;
        int i14 = i9;
        int i15 = i10;
        Log.i(TAG, "configure =" + surface2 + ", surfaceConfigure =" + z3);
        android.media.MediaFormat mediaFormat = new android.media.MediaFormat();
        mediaFormat.setString("mime", str);
        maybeSetInteger(mediaFormat, "width", i4);
        maybeSetInteger(mediaFormat, "height", i5);
        if (i14 != -1 && i15 != -1) {
            if (i14 <= i4) {
                i14 = i4;
            }
            maybeSetInteger(mediaFormat, "max-width", i14);
            if (i15 <= i5) {
                i15 = i5;
            }
            maybeSetInteger(mediaFormat, "max-height", i15);
        }
        maybeSetInteger(mediaFormat, MediaFormat.KEY_SAMPLE_RATE, i7);
        maybeSetInteger(mediaFormat, MediaFormat.KEY_CHANNEL_COUNT, i8);
        Log.i(TAG, "format  = " + mediaFormat);
        int maxInputSize = getMaxInputSize(str, i4, i5);
        Log.i(TAG, "max input = " + maxInputSize);
        maybeSetInteger(mediaFormat, "max-input-size", maxInputSize);
        maybeSetCsdBuffers(mediaFormat, byteBuffer, 0);
        maybeSetCsdBuffers(mediaFormat, byteBuffer2, 1);
        maybeSetCsdBuffers(mediaFormat, byteBuffer3, 2);
        if (z3) {
            int i16 = Util.SDK_INT;
            if (i16 >= 21) {
                maybeSetInteger(mediaFormat, "rotation-degrees", i6);
            }
            if ((surface2 == null || !surface.isValid()) && this.mDummySurface == null && i16 >= 23 && !mDeviceNeedsSetOutputSurfaceWorkaround) {
                Log.i(TAG, "create dummy surface");
                createDummySurface();
                surface2 = this.mDummySurface;
            }
            if (surface2 == null) {
                this.mExceptionInfo = "Error: configure with null surface";
                return CODEC_ILLEGAL_ARGUMENT;
            }
        }
        if (Util.SDK_INT >= 23 && z4) {
            mediaFormat.setInteger("priority", 0);
        }
        if (z5) {
            VendorQTI.setupVpp(mediaFormat, i11);
        }
        if (z6) {
            VendorQTI.debugEffect(mediaFormat);
        }
        if (z7) {
            VendorQTI.enableLowLatency(mediaFormat);
        }
        if (i13 > 0 && i12 >= 0) {
            String dolbyCodecs = MediaCodecUtil.getDolbyCodecs(i12, i13);
            Log.d(TAG, "dv codecs = " + dolbyCodecs);
            Pair<Integer, Integer> dolbyVisionProfileAndLevel = MediaCodecUtil.getDolbyVisionProfileAndLevel(dolbyCodecs, dolbyCodecs.split("\\."));
            if (dolbyVisionProfileAndLevel != null) {
                Log.d(TAG, "dv profile & level  = " + dolbyVisionProfileAndLevel.toString());
                maybeSetInteger(mediaFormat, "profile", ((Integer) dolbyVisionProfileAndLevel.first).intValue());
            }
        }
        try {
            this.mMediaCodec.configure(mediaFormat, surface2, (MediaCrypto) null, 0);
            return 0;
        } catch (Exception e4) {
            handleCodecException(e4);
            Log.d(TAG, "configure failed = " + this.mMediaCodec + ", ex=" + e4.toString());
            if (e4 instanceof IllegalArgumentException) {
                return CODEC_ILLEGAL_ARGUMENT;
            }
            return -1;
        }
    }

    @CalledByNative
    public int createByCodecName(String str) {
        Log.i(TAG, "createByCodecName = " + str);
        try {
            this.mMediaCodec = MediaCodec.createByCodecName(str);
            return 0;
        } catch (Exception e4) {
            handleCodecException(e4);
            Log.d(TAG, "createByCodecName fail = " + e4.toString());
            return -1;
        }
    }

    @TargetApi(23)
    @CalledByNative
    public void decodeFRC(int i4) {
        if (this.mMediaCodec == null || !this.mInputBuffersValid || Util.SDK_INT < 23) {
            return;
        }
        Log.i(TAG, "frc level = " + i4);
        Bundle bundle = new Bundle();
        bundle.putInt("vivo.video-dec.dynamic-frc", i4);
        try {
            this.mMediaCodec.setParameters(bundle);
        } catch (Exception e4) {
            Log.w(TAG, "setParameters failed ret = " + e4);
        }
    }

    @CalledByNative
    public int dequeueInputBuffer(long j4) {
        try {
            return this.mMediaCodec.dequeueInputBuffer(j4);
        } catch (Exception e4) {
            Log.d(TAG, "dequeueInputBuffer failed, exception: " + e4);
            return handleCodecException(e4);
        }
    }

    @CalledByNative
    public void flush() {
        Log.i(TAG, "flush");
        try {
            this.mMediaCodec.flush();
        } catch (Exception unused) {
        }
        Log.i(TAG, "flush done");
    }

    @CalledByNative
    public String getBestCodecName(String str) {
        String[] supportedTypes;
        AJMediaCodecRank aJMediaCodecRank;
        if (Util.SDK_INT < 16) {
            Log.d(TAG, "API < 16");
            return null;
        } else if (TextUtils.isEmpty(str)) {
            return null;
        } else {
            if (str.equals("video/hevc") && mIsByteVC1Blocklist) {
                Log.w(TAG, "the device is hw decoder blocklist," + Util.HARDWARE);
                return null;
            }
            Log.i(TAG, "detect hardware codec by codecType = " + str);
            ArrayList arrayList = new ArrayList();
            synchronized (mCodecListLock) {
                boolean z3 = !mVideoHWDecoderCodecs.isEmpty();
                try {
                    int size = z3 ? mVideoHWDecoderCodecs.size() : MediaCodecList.getCodecCount();
                    for (int i4 = 0; i4 < size && (!z3 || arrayList.isEmpty()); i4++) {
                        MediaCodecInfo codecInfoAt = z3 ? mVideoHWDecoderCodecs.get(i4) : MediaCodecList.getCodecInfoAt(i4);
                        String name = codecInfoAt.getName();
                        Log.d(TAG, "found codec name : " + name);
                        if (!codecInfoAt.isEncoder() && !name.startsWith("OMX.google") && !name.startsWith("c2.android") && (supportedTypes = codecInfoAt.getSupportedTypes()) != null) {
                            for (String str2 : supportedTypes) {
                                if (!TextUtils.isEmpty(str2)) {
                                    if (!z3 && str2.startsWith("video/")) {
                                        mVideoHWDecoderCodecs.add(codecInfoAt);
                                    }
                                    if (str2.equalsIgnoreCase(str)) {
                                        Log.d(TAG, "codec types : " + str2);
                                        if ((name.startsWith("OMX.") || name.startsWith("c2.")) && !name.startsWith("OMX.pv") && !name.startsWith("OMX.ittiam") && !name.contains("ffmpeg") && !name.contains("avcodec") && !name.contains("secure") && ((!name.startsWith("OMX.MTK.") || Util.SDK_INT >= 18) && !codecNeedsFlushWorkaround(name) && (aJMediaCodecRank = AJMediaCodecRank.setupRank(codecInfoAt, str)) != null)) {
                                            Log.i(TAG, "codec : " + aJMediaCodecRank.mMediaCodecInfo.getName() + ",  rank : " + aJMediaCodecRank.mRank);
                                            int i5 = aJMediaCodecRank.mRank;
                                            if (i5 == 40 && Util.SDK_INT < 21) {
                                                Log.w(TAG, "skip vendor mediacodec api impl ambiguous");
                                            } else if (i5 == 20) {
                                                Log.w(TAG, "skip vendor software codec");
                                            } else {
                                                arrayList.add(aJMediaCodecRank);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    if (arrayList.isEmpty()) {
                        return null;
                    }
                    AJMediaCodecRank aJMediaCodecRank2 = (AJMediaCodecRank) arrayList.get(0);
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        AJMediaCodecRank aJMediaCodecRank3 = (AJMediaCodecRank) it.next();
                        if (aJMediaCodecRank3.mRank > aJMediaCodecRank2.mRank) {
                            aJMediaCodecRank2 = aJMediaCodecRank3;
                        }
                    }
                    return aJMediaCodecRank2.mMediaCodecInfo.getName();
                } catch (Exception unused) {
                    Log.w(TAG, "mediaserver died");
                    return null;
                }
            }
        }
    }

    @CalledByNative
    public int getChannelCount() {
        android.media.MediaFormat mediaFormat = this.mOutputMediaFormat;
        if (mediaFormat != null) {
            try {
                return mediaFormat.getInteger(MediaFormat.KEY_CHANNEL_COUNT);
            } catch (Exception unused) {
            }
        }
        return 0;
    }

    @CalledByNative
    public int getColorFormat() {
        android.media.MediaFormat mediaFormat = this.mOutputMediaFormat;
        if (mediaFormat != null) {
            try {
                int integer = mediaFormat.getInteger("color-format");
                return (integer == 21 || integer == 2130706688 || integer == 2141391872) ? 3 : 0;
            } catch (Exception unused) {
            }
        }
        return 0;
    }

    @CalledByNative
    public int getColorTransfer() {
        android.media.MediaFormat mediaFormat = this.mOutputMediaFormat;
        if (mediaFormat != null) {
            try {
                int integer = mediaFormat.getInteger("color-transfer");
                if (integer != 6) {
                    return integer != 7 ? 0 : 18;
                }
                return 16;
            } catch (Exception unused) {
            }
        }
        return 0;
    }

    @CalledByNative
    public String getErrorInfo() {
        return this.mExceptionInfo;
    }

    @CalledByNative
    public int getFormatHeight() {
        android.media.MediaFormat mediaFormat = this.mOutputMediaFormat;
        if (mediaFormat != null) {
            try {
                if (mediaFormat.containsKey(KEY_CROP_RIGHT) && this.mOutputMediaFormat.containsKey(KEY_CROP_LEFT) && this.mOutputMediaFormat.containsKey(KEY_CROP_BOTTOM) && this.mOutputMediaFormat.containsKey(KEY_CROP_TOP)) {
                    return (this.mOutputMediaFormat.getInteger(KEY_CROP_BOTTOM) - this.mOutputMediaFormat.getInteger(KEY_CROP_TOP)) + 1;
                }
                return this.mOutputMediaFormat.getInteger("height");
            } catch (Exception unused) {
            }
        }
        return 0;
    }

    @CalledByNative
    public int getFormatWidth() {
        android.media.MediaFormat mediaFormat = this.mOutputMediaFormat;
        if (mediaFormat != null) {
            try {
                if (mediaFormat.containsKey(KEY_CROP_RIGHT) && this.mOutputMediaFormat.containsKey(KEY_CROP_LEFT) && this.mOutputMediaFormat.containsKey(KEY_CROP_BOTTOM) && this.mOutputMediaFormat.containsKey(KEY_CROP_TOP)) {
                    return (this.mOutputMediaFormat.getInteger(KEY_CROP_RIGHT) - this.mOutputMediaFormat.getInteger(KEY_CROP_LEFT)) + 1;
                }
                return this.mOutputMediaFormat.getInteger("width");
            } catch (Exception unused) {
            }
        }
        return 0;
    }

    @CalledByNative
    public ByteBuffer[] getInputBuffers() {
        if (this.mInputBuffersValid) {
            return this.mInputBuffers;
        }
        return null;
    }

    @CalledByNative
    public int getOSVerion() {
        return Util.SDK_INT;
    }

    @CalledByNative
    public int getSampleRate() {
        android.media.MediaFormat mediaFormat = this.mOutputMediaFormat;
        if (mediaFormat != null) {
            try {
                return mediaFormat.getInteger(MediaFormat.KEY_SAMPLE_RATE);
            } catch (Exception unused) {
            }
        }
        return 0;
    }

    @CalledByNative
    public int getSliceHeight() {
        android.media.MediaFormat mediaFormat = this.mOutputMediaFormat;
        if (mediaFormat != null) {
            try {
                return mediaFormat.getInteger("slice-height");
            } catch (Exception unused) {
            }
        }
        return 0;
    }

    @CalledByNative
    public int getStride() {
        android.media.MediaFormat mediaFormat = this.mOutputMediaFormat;
        if (mediaFormat != null) {
            try {
                return mediaFormat.getInteger("stride");
            } catch (Exception unused) {
            }
        }
        return 0;
    }

    public int handleCodecException(Exception exc) {
        this.mExceptionInfo = exc.toString();
        if (Util.SDK_INT >= 21) {
            return handleCodecExceptionV21(exc);
        }
        if (exc instanceof IllegalStateException) {
            return CODEC_ILLEGAL_STATE;
        }
        return -10000;
    }

    @TargetApi(21)
    public int handleCodecExceptionV21(Exception exc) {
        if (exc instanceof MediaCodec.CodecException) {
            MediaCodec.CodecException codecException = (MediaCodec.CodecException) exc;
            if (Util.SDK_INT >= 23) {
                Log.d(TAG, "exception codecExc isRecoverable: " + codecException.isRecoverable() + ", errorcode: " + codecException.getErrorCode());
                if (!codecException.isRecoverable() && codecException.getErrorCode() != 1100 && codecException.getErrorCode() != 1101) {
                    return CODEC_EXCEPTION_ERROR;
                }
            } else {
                Log.d(TAG, "exception codecExc isRecoverable: " + codecException.isRecoverable());
                if (!codecException.isRecoverable()) {
                    return CODEC_EXCEPTION_ERROR;
                }
            }
        }
        if (exc instanceof IllegalStateException) {
            return CODEC_ILLEGAL_STATE;
        }
        return -10000;
    }

    public int open(int i4, int i5, int i6, String str, String str2, ByteBuffer byteBuffer, Surface surface) {
        Log.i(TAG, "open, rotation = " + i6 + "; codecName = " + str + "; codecType =" + str2);
        try {
            this.mMediaCodec = MediaCodec.createByCodecName(str);
            Log.i(TAG, "configure mediacodec");
            android.media.MediaFormat mediaFormat = new android.media.MediaFormat();
            mediaFormat.setString("mime", str2);
            maybeSetInteger(mediaFormat, "width", i4);
            maybeSetInteger(mediaFormat, "height", i5);
            if (byteBuffer != null) {
                mediaFormat.setByteBuffer("csd-0", byteBuffer);
            }
            if (surface != null && Util.SDK_INT >= 21) {
                maybeSetInteger(mediaFormat, "rotation-degrees", i6);
            }
            try {
                this.mMediaCodec.configure(mediaFormat, surface, (MediaCrypto) null, 0);
                Log.i(TAG, "mediacodec start");
                try {
                    this.mMediaCodec.start();
                    this.mInputBuffers = this.mMediaCodec.getInputBuffers();
                    this.mInputBuffersValid = true;
                    Log.d(TAG, String.format(Locale.US, "open() input params. width:%d,height:%d", Integer.valueOf(i4), Integer.valueOf(i5)));
                    return 0;
                } catch (Exception e4) {
                    Log.d(TAG, e4.toString());
                    return -1;
                }
            } catch (Exception e5) {
                Log.d(TAG, e5.toString());
                return -1;
            }
        } catch (Exception e6) {
            Log.d(TAG, e6.toString());
            return -1;
        }
    }

    @CalledByNative
    public int queueInputBuffer(int i4, int i5, int i6, long j4, int i7) {
        try {
            this.mMediaCodec.queueInputBuffer(i4, i5, i6, j4, i7);
            return 0;
        } catch (Exception e4) {
            Log.d(TAG, "queueInputBuffer failed, exception: " + e4);
            return handleCodecException(e4);
        }
    }

    @CalledByNative
    public int read(AJMediaCodecFrame aJMediaCodecFrame, long j4) {
        while (true) {
            try {
                int dequeueOutputBuffer = this.mMediaCodec.dequeueOutputBuffer(this.mBufferInfo, j4);
                if (dequeueOutputBuffer >= 0) {
                    aJMediaCodecFrame.data = this.mOutputBuffers[dequeueOutputBuffer];
                    MediaCodec.BufferInfo bufferInfo = this.mBufferInfo;
                    aJMediaCodecFrame.pts = bufferInfo.presentationTimeUs;
                    aJMediaCodecFrame.index = dequeueOutputBuffer;
                    aJMediaCodecFrame.size = bufferInfo.size;
                    aJMediaCodecFrame.flags = bufferInfo.flags;
                    return 0;
                } else if (dequeueOutputBuffer != -3) {
                    if (dequeueOutputBuffer != -2) {
                        if (dequeueOutputBuffer != -1) {
                            Log.e(TAG, "error, idx = " + dequeueOutputBuffer);
                        }
                        return -1;
                    }
                    Log.i(TAG, "INFO_OUTPUT_FORMAT_CHANGED");
                    try {
                        this.mOutputMediaFormat = this.mMediaCodec.getOutputFormat();
                        if (this.mOutputBuffers == null) {
                            try {
                                this.mOutputBuffers = this.mMediaCodec.getOutputBuffers();
                            } catch (Exception e4) {
                                Log.i(TAG, "getOutputBuffers e = " + e4);
                                return handleCodecException(e4);
                            }
                        }
                        return dequeueOutputBuffer;
                    } catch (Exception e5) {
                        Log.i(TAG, "getOutputFormat e =" + e5);
                        return handleCodecException(e5);
                    }
                } else {
                    Log.i(TAG, "INFO_OUTPUT_BUFFERS_CHANGED");
                    try {
                        this.mOutputBuffers = this.mMediaCodec.getOutputBuffers();
                    } catch (Exception e6) {
                        Log.i(TAG, "getOutputBuffers e = " + e6);
                        return handleCodecException(e6);
                    }
                }
            } catch (Exception e7) {
                Log.i(TAG, "dequeueOutputBuffer e :" + e7);
                return handleCodecException(e7);
            }
        }
    }

    @CalledByNative
    public int releaseBuffer(int i4, boolean z3, long j4) {
        if (Util.SDK_INT >= 21 && z3) {
            return renderOutputBufferV21(i4, j4);
        }
        try {
            this.mMediaCodec.releaseOutputBuffer(i4, z3);
            return 0;
        } catch (Exception e4) {
            return handleCodecException(e4);
        }
    }

    @CalledByNative
    public int setOutputSurface(Surface surface) {
        Log.d(TAG, "setoutput surface = " + surface);
        if (mDeviceNeedsSetOutputSurfaceWorkaround || !this.mInputBuffersValid) {
            return -1;
        }
        if (surface == null) {
            if (this.mDummySurface == null) {
                createDummySurface();
            }
            surface = this.mDummySurface;
            Log.i(TAG, "use dummy surface");
        }
        Log.d(TAG, "setoutputSurface = " + surface);
        return setOutputSurfaceV23(this.mMediaCodec, surface);
    }

    @TargetApi(23)
    @CalledByNative
    public void speedEnhance(float f4) {
        if (this.mMediaCodec == null || !this.mInputBuffersValid || Util.SDK_INT < 23 || f4 <= 30.0f) {
            return;
        }
        Log.i(TAG, "rate " + f4);
        Bundle bundle = new Bundle();
        bundle.putFloat("operating-rate", f4);
        try {
            this.mMediaCodec.setParameters(bundle);
        } catch (Exception e4) {
            Log.w(TAG, "setParameters failed ret = " + e4);
        }
    }

    @CalledByNative
    public int start() {
        Log.i(TAG, CampaignEx.JSON_NATIVE_VIDEO_START);
        try {
            this.mMediaCodec.start();
            this.mInputBuffers = this.mMediaCodec.getInputBuffers();
            if (Util.SDK_INT >= 21) {
                this.mOutputBuffers = this.mMediaCodec.getOutputBuffers();
            }
            this.mInputBuffersValid = true;
            this.mBufferInfo = new MediaCodec.BufferInfo();
            Log.i(TAG, "start end");
            return 0;
        } catch (Exception e4) {
            handleCodecException(e4);
            return -1;
        }
    }

    @CalledByNative
    public int stop() {
        if (this.mInputBuffersValid) {
            Log.i(TAG, "stop");
            try {
                this.mInputBuffersValid = false;
                this.mMediaCodec.stop();
            } catch (Exception unused) {
                Log.d(TAG, "mediacodec stop exception");
                return -1;
            }
        }
        return 0;
    }

    @CalledByNative
    public int vendorOppoHWEnable() {
        if (Util.BARND.equals(BaseConstants.ROM_OPPO_UPPER_CONSTANT)) {
            String property = getProperty(VENDOR_OPPO_PROPERTY, "1");
            Log.i(TAG, "oppo property = " + property);
            try {
                return Integer.parseInt(property);
            } catch (NumberFormatException unused) {
                Log.w(TAG, "vendor oppo property abnormal");
            }
        }
        return 1;
    }

    @CalledByNative
    public int write(AJMediaCodecFrame aJMediaCodecFrame) {
        if (aJMediaCodecFrame != null && aJMediaCodecFrame.data != null) {
            try {
                int dequeueInputBuffer = this.mMediaCodec.dequeueInputBuffer(30000L);
                if (dequeueInputBuffer < 0) {
                    return dequeueInputBuffer == -1 ? 4 : -1;
                }
                this.mInputBuffers[dequeueInputBuffer].put(aJMediaCodecFrame.data);
                this.mMediaCodec.queueInputBuffer(dequeueInputBuffer, 0, aJMediaCodecFrame.size, aJMediaCodecFrame.pts, 0);
                return 0;
            } catch (Exception e4) {
                Log.e(TAG, "write meet exception =" + e4);
                return -1;
            }
        }
        Log.d(TAG, "buffer is nullpoint");
        return -1;
    }
}

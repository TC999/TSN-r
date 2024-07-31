package com.baidu.idl.face.platform;

import java.util.ArrayList;
import java.util.List;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class FaceEnvironment {

    /* renamed from: OS */
    public static final String f8430OS = "android";
    public static final String SDK_VERSION = "4.1.5";
    public static final String TAG = "Baidu-IDL-FaceSDK";
    public static final long TIME_DETECT_MODULE = 15000;
    public static long TIME_DETECT_NO_FACE_CONTINUOUS = 0;
    public static final long TIME_LIVENESS_COURSE = 5000;
    public static long TIME_LIVENESS_MODULE = 0;
    public static long TIME_MODULE = 0;
    public static long TIME_TIPS_REPEAT = 0;
    public static final float VALUE_BLURNESS = 0.7f;
    public static final float VALUE_BRIGHTNESS = 82.0f;
    public static final int VALUE_CACHE_IMAGE_NUM = 3;
    public static final float VALUE_CLOSED_RATIO = 1.0f;
    public static final float VALUE_CLOSE_EYES = 0.7f;
    public static final float VALUE_CROP_CHINEXTEND = 0.11111111f;
    public static final float VALUE_CROP_ENLARGERATIO = 1.5f;
    public static final float VALUE_CROP_FOREHEADEXTEND = 0.22222222f;
    public static final int VALUE_CROP_HEIGHT = 640;
    public static final int VALUE_CROP_WIDTH = 480;
    public static final int VALUE_DECODE_THREAD_NUM = 2;
    public static final float VALUE_FAR_RATIO = 0.4f;
    public static final int VALUE_HEAD_PITCH = 8;
    public static final int VALUE_HEAD_ROLL = 8;
    public static final int VALUE_HEAD_YAW = 8;
    public static final int VALUE_IMAGESTANCE_IS_MIRROR = 1;
    public static final int VALUE_LIVENESS_DEFAULT_RANDOM_COUNT = 3;
    public static final float VALUE_MASK_THRESHOLD = 0.7f;
    public static final float VALUE_MAX_BRIGHTNESS = 200.0f;
    public static final int VALUE_MIN_FACE_SIZE = 200;
    public static final float VALUE_NOT_FACE_THRESHOLD = 0.6f;
    public static final float VALUE_OCCLUSION = 0.5f;
    public static final boolean VALUE_OPEN_MASK = true;
    public static final boolean VALUE_OPEN_ONLINE = true;
    public static final float VALUE_SCALE = 1.0f;
    public static final int VALUE_SEC_TYPE = 0;
    public static final List<LivenessTypeEnum> livenessTypeDefaultList;
    private static int[] mSoundIds;
    private static int[] mTipsTextIds;

    static {
        ArrayList arrayList = new ArrayList();
        livenessTypeDefaultList = arrayList;
        TIME_TIPS_REPEAT = 2000L;
        TIME_MODULE = 0L;
        TIME_DETECT_NO_FACE_CONTINUOUS = 1000L;
        TIME_LIVENESS_MODULE = 15000L;
        arrayList.add(LivenessTypeEnum.Eye);
        arrayList.add(LivenessTypeEnum.Mouth);
        arrayList.add(LivenessTypeEnum.HeadRight);
        mSoundIds = new int[FaceStatusNewEnum.values().length];
        mTipsTextIds = new int[FaceStatusNewEnum.values().length];
        int i = 0;
        while (true) {
            int[] iArr = mSoundIds;
            if (i >= iArr.length) {
                return;
            }
            iArr[i] = 0;
            mTipsTextIds[i] = 0;
            i++;
        }
    }

    public static int getSoundId(FaceStatusNewEnum faceStatusNewEnum) {
        return mSoundIds[faceStatusNewEnum.ordinal()];
    }

    public static int getTipsId(FaceStatusNewEnum faceStatusNewEnum) {
        return mTipsTextIds[faceStatusNewEnum.ordinal()];
    }

    public static void setSoundId(FaceStatusNewEnum faceStatusNewEnum, int i) {
        int[] iArr = mSoundIds;
        if (iArr != null) {
            try {
                iArr[faceStatusNewEnum.ordinal()] = i;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void setTipsId(FaceStatusNewEnum faceStatusNewEnum, int i) {
        int[] iArr = mTipsTextIds;
        if (iArr != null) {
            try {
                iArr[faceStatusNewEnum.ordinal()] = i;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

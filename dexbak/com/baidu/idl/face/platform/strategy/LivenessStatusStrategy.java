package com.baidu.idl.face.platform.strategy;

import android.graphics.Rect;
import android.util.Log;
import com.baidu.idl.face.platform.FaceConfig;
import com.baidu.idl.face.platform.FaceSDKManager;
import com.baidu.idl.face.platform.FaceStatusNewEnum;
import com.baidu.idl.face.platform.LivenessTypeEnum;
import com.baidu.idl.face.platform.model.FaceExtInfo;
import com.baidu.idl.main.facesdk.model.BDFaceImageInstance;
import com.baidu.idl.main.facesdk.model.BDFaceSDKCommon;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class LivenessStatusStrategy {
    private static final String TAG = "LivenessStatusStrategy";
    private volatile int mLivenessIndex;
    private List<LivenessTypeEnum> mLivenessList;
    private boolean mLivenessTimeoutFlag = false;
    private volatile LivenessTypeEnum mCurrentLivenessTypeEnum = null;
    private long mFaceID = -1;
    private HashMap<LivenessTypeEnum, Boolean> mLivenessStatusMap = new HashMap<>();
    private long mQualityDuration = 0;
    private long mLivenessTimeDuration = 0;
    private long mLivenessDuration = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.idl.face.platform.strategy.LivenessStatusStrategy$1 */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static /* synthetic */ class C24891 {
        static final /* synthetic */ int[] $SwitchMap$com$baidu$idl$face$platform$LivenessTypeEnum;

        static {
            int[] iArr = new int[LivenessTypeEnum.values().length];
            $SwitchMap$com$baidu$idl$face$platform$LivenessTypeEnum = iArr;
            try {
                iArr[LivenessTypeEnum.Eye.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$baidu$idl$face$platform$LivenessTypeEnum[LivenessTypeEnum.Mouth.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$baidu$idl$face$platform$LivenessTypeEnum[LivenessTypeEnum.HeadUp.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$baidu$idl$face$platform$LivenessTypeEnum[LivenessTypeEnum.HeadDown.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$baidu$idl$face$platform$LivenessTypeEnum[LivenessTypeEnum.HeadLeft.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$baidu$idl$face$platform$LivenessTypeEnum[LivenessTypeEnum.HeadRight.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public LivenessStatusStrategy() {
        this.mLivenessIndex = 0;
        this.mLivenessIndex = 0;
    }

    private void clearLivenessStatus() {
        this.mLivenessStatusMap.clear();
        for (int i = 0; i < this.mLivenessList.size(); i++) {
            this.mLivenessStatusMap.put(this.mLivenessList.get(i), Boolean.FALSE);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getCurrentLivenessCount() {
        return this.mLivenessIndex + 1;
    }

    public FaceStatusNewEnum getCurrentLivenessNewStatus() {
        if (this.mCurrentLivenessTypeEnum != null) {
            switch (C24891.$SwitchMap$com$baidu$idl$face$platform$LivenessTypeEnum[this.mCurrentLivenessTypeEnum.ordinal()]) {
                case 1:
                    return FaceStatusNewEnum.FaceLivenessActionTypeLiveEye;
                case 2:
                    return FaceStatusNewEnum.FaceLivenessActionTypeLiveMouth;
                case 3:
                    return FaceStatusNewEnum.FaceLivenessActionTypeLivePitchUp;
                case 4:
                    return FaceStatusNewEnum.FaceLivenessActionTypeLivePitchDown;
                case 5:
                    return FaceStatusNewEnum.FaceLivenessActionTypeLiveYawLeft;
                case 6:
                    return FaceStatusNewEnum.FaceLivenessActionTypeLiveYawRight;
            }
        }
        return null;
    }

    public LivenessTypeEnum getCurrentLivenessType() {
        return this.mCurrentLivenessTypeEnum;
    }

    public boolean isCourseTimeout(FaceConfig faceConfig) {
        if (this.mLivenessDuration == 0) {
            this.mLivenessDuration = System.currentTimeMillis();
        }
        return System.currentTimeMillis() - this.mLivenessDuration > faceConfig.getTimeLivenessCourse();
    }

    public boolean isCurrentLivenessSuccess() {
        boolean booleanValue = this.mLivenessStatusMap.containsKey(this.mCurrentLivenessTypeEnum) ? this.mLivenessStatusMap.get(this.mCurrentLivenessTypeEnum).booleanValue() : false;
        if (booleanValue) {
            this.mLivenessTimeDuration = 0L;
        }
        return booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isExistNextLiveness() {
        return this.mLivenessIndex + 1 < this.mLivenessList.size();
    }

    public boolean isLivenessSuccess() {
        boolean z;
        Iterator<Map.Entry<LivenessTypeEnum, Boolean>> it = this.mLivenessStatusMap.entrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                z = true;
                break;
            }
            Map.Entry<LivenessTypeEnum, Boolean> next = it.next();
            if (!next.getValue().booleanValue()) {
                z = false;
                next.getKey().name();
                break;
            }
        }
        if (z) {
            this.mLivenessTimeDuration = 0L;
        }
        return z;
    }

    public boolean isTimeout() {
        return this.mLivenessTimeoutFlag;
    }

    public boolean nextLiveness() {
        if (this.mLivenessIndex + 1 < this.mLivenessList.size()) {
            this.mLivenessIndex++;
            this.mCurrentLivenessTypeEnum = this.mLivenessList.get(this.mLivenessIndex);
            this.mLivenessDuration = 0L;
            Log.e(TAG, "ext 开始下个活体验证 =" + this.mCurrentLivenessTypeEnum.name());
            return true;
        }
        return false;
    }

    public void processLiveness(FaceExtInfo faceExtInfo, BDFaceImageInstance bDFaceImageInstance, Rect rect) {
        if (this.mLivenessTimeDuration == 0) {
            this.mLivenessTimeDuration = System.currentTimeMillis();
        }
        if (System.currentTimeMillis() - this.mLivenessTimeDuration > FaceSDKManager.getInstance().getFaceConfig().getTimeDetectModule()) {
            this.mLivenessTimeoutFlag = true;
        } else if (faceExtInfo != null) {
            if (faceExtInfo.getFaceId() != this.mFaceID) {
                this.mFaceID = faceExtInfo.getFaceId();
            }
            AtomicInteger atomicInteger = new AtomicInteger();
            switch (C24891.$SwitchMap$com$baidu$idl$face$platform$LivenessTypeEnum[this.mCurrentLivenessTypeEnum.ordinal()]) {
                case 1:
                    int processLiveness = FaceSDKManager.getInstance().processLiveness(BDFaceSDKCommon.BDFaceActionLiveType.BDFace_ACTION_LIVE_BLINK, bDFaceImageInstance, faceExtInfo, atomicInteger);
                    String str = TAG;
                    Log.e(str, "ext Eye err " + processLiveness + "exist " + atomicInteger);
                    break;
                case 2:
                    int processLiveness2 = FaceSDKManager.getInstance().processLiveness(BDFaceSDKCommon.BDFaceActionLiveType.BDFACE_ACTION_LIVE_OPEN_MOUTH, bDFaceImageInstance, faceExtInfo, atomicInteger);
                    String str2 = TAG;
                    Log.e(str2, "ext Mouth err " + processLiveness2 + "exist " + atomicInteger);
                    break;
                case 3:
                    int processLiveness3 = FaceSDKManager.getInstance().processLiveness(BDFaceSDKCommon.BDFaceActionLiveType.BDFACE_ACTION_LIVE_LOOK_UP, bDFaceImageInstance, faceExtInfo, atomicInteger);
                    String str3 = TAG;
                    Log.e(str3, "ext HeadUp err " + processLiveness3 + "exist " + atomicInteger);
                    break;
                case 4:
                    int processLiveness4 = FaceSDKManager.getInstance().processLiveness(BDFaceSDKCommon.BDFaceActionLiveType.BDFACE_ACTION_LIVE_NOD, bDFaceImageInstance, faceExtInfo, atomicInteger);
                    String str4 = TAG;
                    Log.e(str4, "ext HeadDown err " + processLiveness4 + "exist " + atomicInteger);
                    break;
                case 5:
                    int processLiveness5 = FaceSDKManager.getInstance().processLiveness(BDFaceSDKCommon.BDFaceActionLiveType.BDFACE_ACTION_LIVE_TURN_LEFT, bDFaceImageInstance, faceExtInfo, atomicInteger);
                    String str5 = TAG;
                    Log.e(str5, "ext HeadLeft err " + processLiveness5 + "exist " + atomicInteger);
                    break;
                case 6:
                    int processLiveness6 = FaceSDKManager.getInstance().processLiveness(BDFaceSDKCommon.BDFaceActionLiveType.BDFACE_ACTION_LIVE_TURN_RIGHT, bDFaceImageInstance, faceExtInfo, atomicInteger);
                    String str6 = TAG;
                    Log.e(str6, "ext HeadRight err " + processLiveness6 + "exist " + atomicInteger);
                    break;
            }
            List<LivenessTypeEnum> list = this.mLivenessList;
            LivenessTypeEnum livenessTypeEnum = LivenessTypeEnum.Eye;
            if (list.contains(livenessTypeEnum) && !this.mLivenessStatusMap.containsKey(livenessTypeEnum)) {
                this.mLivenessStatusMap.put(livenessTypeEnum, Boolean.valueOf(atomicInteger.get() == 1));
            } else if (this.mCurrentLivenessTypeEnum == livenessTypeEnum && atomicInteger.get() == 1) {
                this.mLivenessStatusMap.put(livenessTypeEnum, Boolean.valueOf(atomicInteger.get() == 1));
            }
            List<LivenessTypeEnum> list2 = this.mLivenessList;
            LivenessTypeEnum livenessTypeEnum2 = LivenessTypeEnum.Mouth;
            if (list2.contains(livenessTypeEnum2) && !this.mLivenessStatusMap.containsKey(livenessTypeEnum2)) {
                this.mLivenessStatusMap.put(livenessTypeEnum2, Boolean.valueOf(atomicInteger.get() == 1));
            } else if (this.mCurrentLivenessTypeEnum == livenessTypeEnum2 && atomicInteger.get() == 1) {
                this.mLivenessStatusMap.put(livenessTypeEnum2, Boolean.valueOf(atomicInteger.get() == 1));
            }
            List<LivenessTypeEnum> list3 = this.mLivenessList;
            LivenessTypeEnum livenessTypeEnum3 = LivenessTypeEnum.HeadUp;
            if (list3.contains(livenessTypeEnum3) && !this.mLivenessStatusMap.containsKey(livenessTypeEnum3)) {
                this.mLivenessStatusMap.put(livenessTypeEnum3, Boolean.valueOf(atomicInteger.get() == 1));
            } else if (this.mCurrentLivenessTypeEnum == livenessTypeEnum3 && atomicInteger.get() == 1) {
                this.mLivenessStatusMap.put(livenessTypeEnum3, Boolean.valueOf(atomicInteger.get() == 1));
            }
            List<LivenessTypeEnum> list4 = this.mLivenessList;
            LivenessTypeEnum livenessTypeEnum4 = LivenessTypeEnum.HeadDown;
            if (list4.contains(livenessTypeEnum4) && !this.mLivenessStatusMap.containsKey(livenessTypeEnum4)) {
                this.mLivenessStatusMap.put(livenessTypeEnum4, Boolean.valueOf(atomicInteger.get() == 1));
            } else if (this.mCurrentLivenessTypeEnum == livenessTypeEnum4 && atomicInteger.get() == 1) {
                this.mLivenessStatusMap.put(livenessTypeEnum4, Boolean.valueOf(atomicInteger.get() == 1));
            }
            List<LivenessTypeEnum> list5 = this.mLivenessList;
            LivenessTypeEnum livenessTypeEnum5 = LivenessTypeEnum.HeadLeft;
            if (list5.contains(livenessTypeEnum5) && !this.mLivenessStatusMap.containsKey(livenessTypeEnum5)) {
                this.mLivenessStatusMap.put(livenessTypeEnum5, Boolean.valueOf(atomicInteger.get() == 1));
            } else if (this.mCurrentLivenessTypeEnum == livenessTypeEnum5 && atomicInteger.get() == 1) {
                this.mLivenessStatusMap.put(livenessTypeEnum5, Boolean.valueOf(atomicInteger.get() == 1));
            }
            List<LivenessTypeEnum> list6 = this.mLivenessList;
            LivenessTypeEnum livenessTypeEnum6 = LivenessTypeEnum.HeadRight;
            if (list6.contains(livenessTypeEnum6) && !this.mLivenessStatusMap.containsKey(livenessTypeEnum6)) {
                this.mLivenessStatusMap.put(livenessTypeEnum6, Boolean.valueOf(atomicInteger.get() == 1));
            } else if (this.mCurrentLivenessTypeEnum == livenessTypeEnum6 && atomicInteger.get() == 1) {
                this.mLivenessStatusMap.put(livenessTypeEnum6, Boolean.valueOf(atomicInteger.get() == 1));
            }
        }
    }

    public void reset() {
        this.mLivenessIndex = 0;
        clearLivenessStatus();
        if (this.mLivenessList != null && this.mLivenessIndex < this.mLivenessList.size()) {
            this.mCurrentLivenessTypeEnum = this.mLivenessList.get(this.mLivenessIndex);
        }
        this.mLivenessDuration = 0L;
        this.mLivenessTimeoutFlag = false;
        this.mLivenessTimeDuration = 0L;
    }

    public void resetQualityTime() {
        this.mQualityDuration = System.currentTimeMillis();
    }

    public void resetState() {
        this.mLivenessDuration = 0L;
    }

    public void setLivenessList(List<LivenessTypeEnum> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        this.mLivenessList = list;
        this.mCurrentLivenessTypeEnum = list.get(0);
        String str = TAG;
        Log.e(str, "mCurrentLivenessTypeEnum = " + this.mCurrentLivenessTypeEnum);
        clearLivenessStatus();
    }

    public boolean showQualityTips() {
        return System.currentTimeMillis() - this.mQualityDuration > 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void startNextLiveness() {
        this.mLivenessIndex++;
        this.mCurrentLivenessTypeEnum = this.mLivenessList.get(this.mLivenessIndex);
        this.mLivenessDuration = 0L;
    }
}

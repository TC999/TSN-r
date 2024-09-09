package com.baidu.idl.face.platform.strategy;

import android.graphics.Rect;
import com.baidu.idl.face.platform.FaceConfig;
import com.baidu.idl.face.platform.FaceStatusNewEnum;
import com.baidu.idl.face.platform.model.FaceExtInfo;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
class DetectStrategy {
    private static final String TAG = "DetectStrategy";
    private FaceStatusNewEnum mCurrentFaceStatus;
    private long mDuration = 0;
    private boolean mTimeoutFlag = false;
    private float mTotalCropScore;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* renamed from: com.baidu.idl.face.platform.strategy.DetectStrategy$1  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$baidu$idl$face$platform$FaceStatusNewEnum;

        static {
            int[] iArr = new int[FaceStatusNewEnum.values().length];
            $SwitchMap$com$baidu$idl$face$platform$FaceStatusNewEnum = iArr;
            try {
                iArr[FaceStatusNewEnum.DetectRemindCodePoorIllumination.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$baidu$idl$face$platform$FaceStatusNewEnum[FaceStatusNewEnum.DetectRemindCodeImageBlured.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$baidu$idl$face$platform$FaceStatusNewEnum[FaceStatusNewEnum.DetectRemindCodeOcclusionLeftEye.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$baidu$idl$face$platform$FaceStatusNewEnum[FaceStatusNewEnum.DetectRemindCodeOcclusionRightEye.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$baidu$idl$face$platform$FaceStatusNewEnum[FaceStatusNewEnum.DetectRemindCodeOcclusionNose.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$baidu$idl$face$platform$FaceStatusNewEnum[FaceStatusNewEnum.DetectRemindCodeOcclusionMouth.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$baidu$idl$face$platform$FaceStatusNewEnum[FaceStatusNewEnum.DetectRemindCodeOcclusionLeftContour.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$baidu$idl$face$platform$FaceStatusNewEnum[FaceStatusNewEnum.DetectRemindCodeOcclusionRightContour.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$baidu$idl$face$platform$FaceStatusNewEnum[FaceStatusNewEnum.DetectRemindCodeOcclusionChinContour.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$baidu$idl$face$platform$FaceStatusNewEnum[FaceStatusNewEnum.DetectRemindCodeTooFar.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$baidu$idl$face$platform$FaceStatusNewEnum[FaceStatusNewEnum.DetectRemindCodeTooClose.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$com$baidu$idl$face$platform$FaceStatusNewEnum[FaceStatusNewEnum.DetectRemindCodeNoFaceDetected.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$com$baidu$idl$face$platform$FaceStatusNewEnum[FaceStatusNewEnum.DetectRemindCodePitchOutofUpRange.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$com$baidu$idl$face$platform$FaceStatusNewEnum[FaceStatusNewEnum.DetectRemindCodePitchOutofDownRange.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                $SwitchMap$com$baidu$idl$face$platform$FaceStatusNewEnum[FaceStatusNewEnum.DetectRemindCodeYawOutofLeftRange.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                $SwitchMap$com$baidu$idl$face$platform$FaceStatusNewEnum[FaceStatusNewEnum.DetectRemindCodeYawOutofRightRange.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
        }
    }

    private void checkTimeout(FaceStatusNewEnum faceStatusNewEnum, FaceConfig faceConfig) {
        if (faceConfig == null) {
            return;
        }
        FaceStatusNewEnum faceStatusNewEnum2 = this.mCurrentFaceStatus;
        if (faceStatusNewEnum2 == null || faceStatusNewEnum2 != faceStatusNewEnum) {
            this.mCurrentFaceStatus = faceStatusNewEnum;
            this.mDuration = System.currentTimeMillis();
            this.mTimeoutFlag = false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (this.mCurrentFaceStatus != faceStatusNewEnum || currentTimeMillis - this.mDuration <= faceConfig.getTimeDetectModule()) {
            return;
        }
        this.mTimeoutFlag = true;
    }

    private FaceStatusNewEnum getModuleState(FaceExtInfo[] faceExtInfoArr, Rect rect, boolean z3, FaceConfig faceConfig) {
        FaceStatusNewEnum faceStatusNewEnum = FaceStatusNewEnum.OK;
        FaceExtInfo faceExtInfo = faceExtInfoArr[0];
        this.mTotalCropScore = 0.0f;
        if (!z3) {
            if (faceExtInfo.getOcclusion().leftEye > faceConfig.getOcclusionLeftEyeValue()) {
                return FaceStatusNewEnum.DetectRemindCodeOcclusionLeftEye;
            }
            this.mTotalCropScore += 1.0f - faceExtInfo.getOcclusion().leftEye;
            if (faceExtInfo.getOcclusion().rightEye > faceConfig.getOcclusionRightEyeValue()) {
                return FaceStatusNewEnum.DetectRemindCodeOcclusionRightEye;
            }
            this.mTotalCropScore += 1.0f - faceExtInfo.getOcclusion().rightEye;
            if (faceExtInfo.getOcclusion().nose > faceConfig.getOcclusionNoseValue()) {
                return FaceStatusNewEnum.DetectRemindCodeOcclusionNose;
            }
            this.mTotalCropScore += 1.0f - faceExtInfo.getOcclusion().nose;
            if (faceExtInfo.getOcclusion().mouth > faceConfig.getOcclusionMouthValue()) {
                return FaceStatusNewEnum.DetectRemindCodeOcclusionMouth;
            }
            this.mTotalCropScore += 1.0f - faceExtInfo.getOcclusion().mouth;
            if (faceExtInfo.getOcclusion().leftCheek > faceConfig.getOcclusionLeftContourValue()) {
                return FaceStatusNewEnum.DetectRemindCodeOcclusionLeftContour;
            }
            this.mTotalCropScore += 1.0f - faceExtInfo.getOcclusion().leftCheek;
            if (faceExtInfo.getOcclusion().rightCheek > faceConfig.getOcclusionRightContourValue()) {
                return FaceStatusNewEnum.DetectRemindCodeOcclusionRightContour;
            }
            this.mTotalCropScore += 1.0f - faceExtInfo.getOcclusion().rightCheek;
            if (faceExtInfo.getOcclusion().chin > faceConfig.getOcclusionChinValue()) {
                return FaceStatusNewEnum.DetectRemindCodeOcclusionChinContour;
            }
            this.mTotalCropScore += 1.0f - faceExtInfo.getOcclusion().chin;
        }
        if (faceExtInfoArr[0].getFaceWidth() < rect.width() * faceConfig.getFaceFarRatio()) {
            FaceStatusNewEnum faceStatusNewEnum2 = FaceStatusNewEnum.DetectRemindCodeTooFar;
            checkTimeout(faceStatusNewEnum2, faceConfig);
            return faceStatusNewEnum2;
        } else if (faceExtInfoArr[0].getFaceWidth() > rect.width() * faceConfig.getFaceClosedRatio()) {
            FaceStatusNewEnum faceStatusNewEnum3 = FaceStatusNewEnum.DetectRemindCodeTooClose;
            checkTimeout(faceStatusNewEnum3, faceConfig);
            return faceStatusNewEnum3;
        } else if (faceExtInfo.getPitch() < (-faceConfig.getHeadPitchValue()) - 2) {
            return FaceStatusNewEnum.DetectRemindCodePitchOutofDownRange;
        } else {
            if (faceExtInfo.getPitch() > faceConfig.getHeadPitchValue() - 2) {
                return FaceStatusNewEnum.DetectRemindCodePitchOutofUpRange;
            }
            this.mTotalCropScore += (45.0f - Math.abs(faceExtInfo.getPitch())) / 45.0f;
            if (faceExtInfo.getYaw() > faceConfig.getHeadYawValue()) {
                return FaceStatusNewEnum.DetectRemindCodeYawOutofLeftRange;
            }
            if (faceExtInfo.getYaw() < (-faceConfig.getHeadYawValue())) {
                return FaceStatusNewEnum.DetectRemindCodeYawOutofRightRange;
            }
            this.mTotalCropScore += (45.0f - Math.abs(faceExtInfo.getYaw())) / 45.0f;
            if (faceExtInfo.getRoll() > faceConfig.getHeadRollValue()) {
                return FaceStatusNewEnum.DetectRemindCodeYawOutofRightRange;
            }
            if (faceExtInfo.getRoll() < (-faceConfig.getHeadRollValue())) {
                return FaceStatusNewEnum.DetectRemindCodeYawOutofLeftRange;
            }
            this.mTotalCropScore += (45.0f - Math.abs(faceExtInfo.getRoll())) / 45.0f;
            if (faceExtInfo.getBluriness() > faceConfig.getBlurnessValue()) {
                return FaceStatusNewEnum.DetectRemindCodeImageBlured;
            }
            this.mTotalCropScore += 1.0f - faceExtInfo.getBluriness();
            if (faceExtInfo.getIllum() < faceConfig.getBrightnessValue()) {
                return FaceStatusNewEnum.DetectRemindCodePoorIllumination;
            }
            if (faceExtInfo.getIllum() > faceConfig.getBrightnessMaxValue()) {
                return FaceStatusNewEnum.DetectRemindCodeMuchIllumination;
            }
            if (faceExtInfo.getLeftEyeClose() > faceConfig.getEyeClosedValue()) {
                return FaceStatusNewEnum.DetectRemindCodeLeftEyeClosed;
            }
            this.mTotalCropScore += 1.0f - faceExtInfo.getLeftEyeClose();
            if (faceExtInfo.getRightEyeClose() > faceConfig.getEyeClosedValue()) {
                return FaceStatusNewEnum.DetectRemindCodeRightEyeClosed;
            }
            this.mTotalCropScore += 1.0f - faceExtInfo.getRightEyeClose();
            return faceStatusNewEnum;
        }
    }

    private boolean isDefaultDetectStatus(FaceStatusNewEnum faceStatusNewEnum) {
        switch (AnonymousClass1.$SwitchMap$com$baidu$idl$face$platform$FaceStatusNewEnum[faceStatusNewEnum.ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
                return true;
            default:
                return false;
        }
    }

    public FaceStatusNewEnum checkDetect(Rect rect, FaceExtInfo[] faceExtInfoArr, FaceConfig faceConfig) {
        FaceStatusNewEnum faceStatusNewEnum = FaceStatusNewEnum.OK;
        if (faceExtInfoArr != null && faceExtInfoArr.length > 0 && faceExtInfoArr[0] != null && faceConfig != null) {
            if (faceExtInfoArr[0].getFaceWidth() > rect.width() * faceConfig.getFaceClosedRatio()) {
                FaceStatusNewEnum faceStatusNewEnum2 = FaceStatusNewEnum.DetectRemindCodeTooClose;
                checkTimeout(faceStatusNewEnum2, faceConfig);
                return faceStatusNewEnum2;
            } else if (faceExtInfoArr[0].getFaceWidth() < rect.width() * faceConfig.getFaceFarRatio()) {
                FaceStatusNewEnum faceStatusNewEnum3 = FaceStatusNewEnum.DetectRemindCodeTooFar;
                checkTimeout(faceStatusNewEnum3, faceConfig);
                return faceStatusNewEnum3;
            } else if (faceExtInfoArr[0].getLandmarksOutOfDetectCount(rect) > 10) {
                FaceStatusNewEnum faceStatusNewEnum4 = FaceStatusNewEnum.DetectRemindCodeBeyondPreviewFrame;
                checkTimeout(faceStatusNewEnum4, faceConfig);
                return faceStatusNewEnum4;
            } else {
                return faceStatusNewEnum;
            }
        }
        FaceStatusNewEnum faceStatusNewEnum5 = FaceStatusNewEnum.DetectRemindCodeNoFaceDetected;
        checkTimeout(faceStatusNewEnum5, faceConfig);
        return faceStatusNewEnum5;
    }

    public FaceStatusNewEnum getCropStatus(FaceExtInfo faceExtInfo, FaceConfig faceConfig) {
        if (faceExtInfo != null && faceConfig != null) {
            this.mTotalCropScore = 0.0f;
            if (faceExtInfo.getOcclusion().leftEye > faceConfig.getOcclusionLeftEyeValue()) {
                return FaceStatusNewEnum.DetectRemindCodeOcclusionLeftEye;
            }
            this.mTotalCropScore += 1.0f - faceExtInfo.getOcclusion().leftEye;
            if (faceExtInfo.getOcclusion().rightEye > faceConfig.getOcclusionRightEyeValue()) {
                return FaceStatusNewEnum.DetectRemindCodeOcclusionRightEye;
            }
            this.mTotalCropScore += 1.0f - faceExtInfo.getOcclusion().rightEye;
            if (faceExtInfo.getOcclusion().nose > faceConfig.getOcclusionNoseValue()) {
                return FaceStatusNewEnum.DetectRemindCodeOcclusionNose;
            }
            this.mTotalCropScore += 1.0f - faceExtInfo.getOcclusion().nose;
            if (faceExtInfo.getOcclusion().mouth > faceConfig.getOcclusionMouthValue()) {
                return FaceStatusNewEnum.DetectRemindCodeOcclusionMouth;
            }
            this.mTotalCropScore += 1.0f - faceExtInfo.getOcclusion().mouth;
            if (faceExtInfo.getOcclusion().leftCheek > faceConfig.getOcclusionLeftContourValue()) {
                return FaceStatusNewEnum.DetectRemindCodeOcclusionLeftContour;
            }
            this.mTotalCropScore += 1.0f - faceExtInfo.getOcclusion().leftCheek;
            if (faceExtInfo.getOcclusion().rightCheek > faceConfig.getOcclusionRightContourValue()) {
                return FaceStatusNewEnum.DetectRemindCodeOcclusionRightContour;
            }
            this.mTotalCropScore += 1.0f - faceExtInfo.getOcclusion().rightCheek;
            if (faceExtInfo.getOcclusion().chin > faceConfig.getOcclusionChinValue()) {
                return FaceStatusNewEnum.DetectRemindCodeOcclusionChinContour;
            }
            this.mTotalCropScore += 1.0f - faceExtInfo.getOcclusion().chin;
            if (faceExtInfo.getPitch() < (-faceConfig.getHeadPitchValue()) - 2) {
                return FaceStatusNewEnum.DetectRemindCodePitchOutofDownRange;
            }
            if (faceExtInfo.getPitch() > faceConfig.getHeadPitchValue() - 2) {
                return FaceStatusNewEnum.DetectRemindCodePitchOutofUpRange;
            }
            this.mTotalCropScore += (45.0f - Math.abs(faceExtInfo.getPitch())) / 45.0f;
            if (faceExtInfo.getYaw() < (-faceConfig.getHeadYawValue())) {
                return FaceStatusNewEnum.DetectRemindCodeYawOutofRightRange;
            }
            if (faceExtInfo.getYaw() > faceConfig.getHeadYawValue()) {
                return FaceStatusNewEnum.DetectRemindCodeYawOutofLeftRange;
            }
            this.mTotalCropScore += (45.0f - Math.abs(faceExtInfo.getYaw())) / 45.0f;
            if (faceExtInfo.getRoll() > faceConfig.getHeadRollValue()) {
                return FaceStatusNewEnum.DetectRemindCodeYawOutofRightRange;
            }
            if (faceExtInfo.getRoll() < (-faceConfig.getHeadRollValue())) {
                return FaceStatusNewEnum.DetectRemindCodeYawOutofLeftRange;
            }
            this.mTotalCropScore += (45.0f - Math.abs(faceExtInfo.getRoll())) / 45.0f;
            if (faceExtInfo.getBluriness() > faceConfig.getBlurnessValue()) {
                return FaceStatusNewEnum.DetectRemindCodeImageBlured;
            }
            this.mTotalCropScore += 1.0f - faceExtInfo.getBluriness();
            if (faceExtInfo.getIllum() < faceConfig.getBrightnessValue()) {
                return FaceStatusNewEnum.DetectRemindCodePoorIllumination;
            }
            if (faceExtInfo.getIllum() > faceConfig.getBrightnessMaxValue()) {
                return FaceStatusNewEnum.DetectRemindCodeMuchIllumination;
            }
            if (faceExtInfo.getLeftEyeClose() > faceConfig.getEyeClosedValue()) {
                return FaceStatusNewEnum.DetectRemindCodeLeftEyeClosed;
            }
            this.mTotalCropScore += 1.0f - faceExtInfo.getLeftEyeClose();
            if (faceExtInfo.getRightEyeClose() > faceConfig.getEyeClosedValue()) {
                return FaceStatusNewEnum.DetectRemindCodeRightEyeClosed;
            }
            this.mTotalCropScore += 1.0f - faceExtInfo.getRightEyeClose();
            return FaceStatusNewEnum.OK;
        }
        return FaceStatusNewEnum.DetectRemindCodeNoFaceDetected;
    }

    public FaceStatusNewEnum getDetectState(FaceExtInfo[] faceExtInfoArr, Rect rect, boolean z3, FaceConfig faceConfig) {
        FaceStatusNewEnum faceStatusNewEnum = FaceStatusNewEnum.OK;
        if (faceExtInfoArr != null && faceExtInfoArr.length > 0 && faceExtInfoArr[0] != null && faceConfig != null) {
            if (faceExtInfoArr[0].getLandmarksOutOfDetectCount(rect) > 10) {
                FaceStatusNewEnum faceStatusNewEnum2 = FaceStatusNewEnum.DetectRemindCodeBeyondPreviewFrame;
                checkTimeout(faceStatusNewEnum2, faceConfig);
                return faceStatusNewEnum2;
            }
            return getModuleState(faceExtInfoArr, rect, z3, faceConfig);
        }
        FaceStatusNewEnum faceStatusNewEnum3 = FaceStatusNewEnum.DetectRemindCodeNoFaceDetected;
        checkTimeout(faceStatusNewEnum3, faceConfig);
        return faceStatusNewEnum3;
    }

    public float getTotalCropScore() {
        return this.mTotalCropScore;
    }

    public boolean isTimeout() {
        return this.mTimeoutFlag;
    }

    public void reset() {
        this.mDuration = 0L;
        this.mTimeoutFlag = false;
        this.mCurrentFaceStatus = null;
        this.mTotalCropScore = 0.0f;
    }
}

package com.baidu.idl.face.platform;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class FaceConfig implements Serializable {
    private static final String TAG = FaceConfig.class.getSimpleName();
    private int minFaceSize = 200;
    private float notFaceValue = 0.6f;
    private float brightnessValue = 82.0f;
    private float brightnessMaxValue = 200.0f;
    private float blurnessValue = 0.7f;
    private float occlusionValue = 0.5f;
    private float occlusionLeftEyeValue = 0.5f;
    private float occlusionRightEyeValue = 0.5f;
    private float occlusionNoseValue = 0.5f;
    private float occlusionMouthValue = 0.5f;
    private float occlusionLeftContourValue = 0.5f;
    private float occlusionRightContourValue = 0.5f;
    private float occlusionChinValue = 0.5f;
    private int headPitchValue = 8;
    private int headYawValue = 8;
    private int headRollValue = 8;
    private float eyeClosedValue = 0.7f;
    private boolean isSound = true;
    private boolean isLivenessRandom = false;
    private int cacheImageNum = 3;
    private int livenessRandomCount = 3;
    private List<LivenessTypeEnum> livenessTypeList = FaceEnvironment.livenessTypeDefaultList;
    private boolean isOpenOnline = true;
    private int cropHeight = 640;
    private int cropWidth = 480;
    private float enlargeRatio = 1.5f;
    private float scale = 1.0f;
    private int secType = 0;
    private float maskValue = 0.7f;
    private boolean isOpenMask = true;
    private long timeDetectModule = 15000;
    private long timeLivenessCourse = 5000;
    private int qualityLevel = 0;
    private float faceFarRatio = 0.4f;
    private float faceClosedRatio = 1.0f;

    public static List<LivenessTypeEnum> getRandomList(List<LivenessTypeEnum> list, int i4) {
        if (list.size() < i4) {
            return list;
        }
        Random random = new Random();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        int i5 = 0;
        while (i5 < i4) {
            int nextInt = random.nextInt(list.size());
            if (arrayList.contains(Integer.valueOf(nextInt))) {
                i5--;
            } else {
                arrayList.add(Integer.valueOf(nextInt));
                arrayList2.add(list.get(nextInt));
            }
            i5++;
        }
        return arrayList2;
    }

    public float getBlurnessValue() {
        return this.blurnessValue;
    }

    public float getBrightnessMaxValue() {
        return this.brightnessMaxValue;
    }

    public float getBrightnessValue() {
        return this.brightnessValue;
    }

    public int getCacheImageNum() {
        return this.cacheImageNum;
    }

    public int getCropHeight() {
        return this.cropHeight;
    }

    public int getCropWidth() {
        return this.cropWidth;
    }

    public float getEnlargeRatio() {
        return this.enlargeRatio;
    }

    public float getEyeClosedValue() {
        return this.eyeClosedValue;
    }

    public float getFaceClosedRatio() {
        return this.faceClosedRatio;
    }

    public float getFaceFarRatio() {
        return this.faceFarRatio;
    }

    public int getHeadPitchValue() {
        return this.headPitchValue;
    }

    public int getHeadRollValue() {
        return this.headRollValue;
    }

    public int getHeadYawValue() {
        return this.headYawValue;
    }

    public int getLivenessRandomCount() {
        return this.livenessRandomCount;
    }

    public List<LivenessTypeEnum> getLivenessTypeList() {
        List<LivenessTypeEnum> list = this.livenessTypeList;
        if (list != null && list.size() != 0) {
            if (this.isLivenessRandom) {
                List<LivenessTypeEnum> list2 = this.livenessTypeList;
                return getRandomList(list2, list2.size());
            }
        } else {
            ArrayList arrayList = new ArrayList();
            this.livenessTypeList = arrayList;
            arrayList.addAll(FaceEnvironment.livenessTypeDefaultList);
            Collections.shuffle(this.livenessTypeList);
            this.livenessTypeList = this.livenessTypeList.subList(0, getLivenessRandomCount());
        }
        return this.livenessTypeList;
    }

    public float getMaskValue() {
        return this.maskValue;
    }

    public int getMinFaceSize() {
        return this.minFaceSize;
    }

    public float getNotFaceValue() {
        return this.notFaceValue;
    }

    public float getOcclusionChinValue() {
        return this.occlusionChinValue;
    }

    public float getOcclusionLeftContourValue() {
        return this.occlusionLeftContourValue;
    }

    public float getOcclusionLeftEyeValue() {
        return this.occlusionLeftEyeValue;
    }

    public float getOcclusionMouthValue() {
        return this.occlusionMouthValue;
    }

    public float getOcclusionNoseValue() {
        return this.occlusionNoseValue;
    }

    public float getOcclusionRightContourValue() {
        return this.occlusionRightContourValue;
    }

    public float getOcclusionRightEyeValue() {
        return this.occlusionRightEyeValue;
    }

    public float getOcclusionValue() {
        return this.occlusionValue;
    }

    public int getQualityLevel() {
        return this.qualityLevel;
    }

    public float getScale() {
        return this.scale;
    }

    public int getSecType() {
        return this.secType;
    }

    public long getTimeDetectModule() {
        return this.timeDetectModule;
    }

    public long getTimeLivenessCourse() {
        return this.timeLivenessCourse;
    }

    public boolean isLivenessRandom() {
        return this.isLivenessRandom;
    }

    public boolean isOpenMask() {
        return this.isOpenMask;
    }

    public boolean isOpenOnline() {
        return this.isOpenOnline;
    }

    public boolean isSound() {
        return this.isSound;
    }

    public void setBlurnessValue(float f4) {
        this.blurnessValue = f4;
    }

    public void setBrightnessMaxValue(float f4) {
        this.brightnessMaxValue = f4;
    }

    public void setBrightnessValue(float f4) {
        this.brightnessValue = f4;
    }

    public void setCacheImageNum(int i4) {
        this.cacheImageNum = i4;
    }

    public void setCropHeight(int i4) {
        this.cropHeight = i4;
    }

    public void setCropWidth(int i4) {
        this.cropWidth = i4;
    }

    public void setEnlargeRatio(float f4) {
        this.enlargeRatio = f4;
    }

    public void setEyeClosedValue(float f4) {
        this.eyeClosedValue = f4;
    }

    public void setFaceClosedRatio(float f4) {
        this.faceClosedRatio = f4;
    }

    public void setFaceFarRatio(float f4) {
        this.faceFarRatio = f4;
    }

    public void setHeadPitchValue(int i4) {
        this.headPitchValue = i4;
    }

    public void setHeadRollValue(int i4) {
        this.headRollValue = i4;
    }

    public void setHeadYawValue(int i4) {
        this.headYawValue = i4;
    }

    public void setLivenessRandom(boolean z3) {
        this.isLivenessRandom = z3;
    }

    public void setLivenessRandomCount(int i4) {
        int size = FaceEnvironment.livenessTypeDefaultList.size();
        if (i4 > size) {
            i4 = size;
        }
        this.livenessRandomCount = i4;
    }

    public void setLivenessTypeList(List<LivenessTypeEnum> list) {
        this.livenessTypeList = list;
    }

    public void setMaskValue(float f4) {
        this.maskValue = f4;
    }

    public void setMinFaceSize(int i4) {
        this.minFaceSize = i4;
    }

    public void setNotFaceValue(float f4) {
        this.notFaceValue = f4;
    }

    public void setOcclusionChinValue(float f4) {
        this.occlusionChinValue = f4;
    }

    public void setOcclusionLeftContourValue(float f4) {
        this.occlusionLeftContourValue = f4;
    }

    public void setOcclusionLeftEyeValue(float f4) {
        this.occlusionLeftEyeValue = f4;
    }

    public void setOcclusionMouthValue(float f4) {
        this.occlusionMouthValue = f4;
    }

    public void setOcclusionNoseValue(float f4) {
        this.occlusionNoseValue = f4;
    }

    public void setOcclusionRightContourValue(float f4) {
        this.occlusionRightContourValue = f4;
    }

    public void setOcclusionRightEyeValue(float f4) {
        this.occlusionRightEyeValue = f4;
    }

    public void setOcclusionValue(float f4) {
        this.occlusionValue = f4;
    }

    public void setOpenMask(boolean z3) {
        this.isOpenMask = z3;
    }

    public void setOpenOnline(boolean z3) {
        this.isOpenOnline = z3;
    }

    public void setQualityLevel(int i4) {
        this.qualityLevel = i4;
    }

    public void setScale(float f4) {
        this.scale = f4;
    }

    public void setSecType(int i4) {
        this.secType = i4;
    }

    public void setSound(boolean z3) {
        this.isSound = z3;
    }

    public void setTimeDetectModule(long j4) {
        this.timeDetectModule = j4;
    }

    public void setTimeLivenessCourse(long j4) {
        this.timeLivenessCourse = j4;
    }
}

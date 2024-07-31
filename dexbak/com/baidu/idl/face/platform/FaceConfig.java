package com.baidu.idl.face.platform;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
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

    public static List<LivenessTypeEnum> getRandomList(List<LivenessTypeEnum> list, int i) {
        if (list.size() < i) {
            return list;
        }
        Random random = new Random();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        int i2 = 0;
        while (i2 < i) {
            int nextInt = random.nextInt(list.size());
            if (arrayList.contains(Integer.valueOf(nextInt))) {
                i2--;
            } else {
                arrayList.add(Integer.valueOf(nextInt));
                arrayList2.add(list.get(nextInt));
            }
            i2++;
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

    public void setBlurnessValue(float f) {
        this.blurnessValue = f;
    }

    public void setBrightnessMaxValue(float f) {
        this.brightnessMaxValue = f;
    }

    public void setBrightnessValue(float f) {
        this.brightnessValue = f;
    }

    public void setCacheImageNum(int i) {
        this.cacheImageNum = i;
    }

    public void setCropHeight(int i) {
        this.cropHeight = i;
    }

    public void setCropWidth(int i) {
        this.cropWidth = i;
    }

    public void setEnlargeRatio(float f) {
        this.enlargeRatio = f;
    }

    public void setEyeClosedValue(float f) {
        this.eyeClosedValue = f;
    }

    public void setFaceClosedRatio(float f) {
        this.faceClosedRatio = f;
    }

    public void setFaceFarRatio(float f) {
        this.faceFarRatio = f;
    }

    public void setHeadPitchValue(int i) {
        this.headPitchValue = i;
    }

    public void setHeadRollValue(int i) {
        this.headRollValue = i;
    }

    public void setHeadYawValue(int i) {
        this.headYawValue = i;
    }

    public void setLivenessRandom(boolean z) {
        this.isLivenessRandom = z;
    }

    public void setLivenessRandomCount(int i) {
        int size = FaceEnvironment.livenessTypeDefaultList.size();
        if (i > size) {
            i = size;
        }
        this.livenessRandomCount = i;
    }

    public void setLivenessTypeList(List<LivenessTypeEnum> list) {
        this.livenessTypeList = list;
    }

    public void setMaskValue(float f) {
        this.maskValue = f;
    }

    public void setMinFaceSize(int i) {
        this.minFaceSize = i;
    }

    public void setNotFaceValue(float f) {
        this.notFaceValue = f;
    }

    public void setOcclusionChinValue(float f) {
        this.occlusionChinValue = f;
    }

    public void setOcclusionLeftContourValue(float f) {
        this.occlusionLeftContourValue = f;
    }

    public void setOcclusionLeftEyeValue(float f) {
        this.occlusionLeftEyeValue = f;
    }

    public void setOcclusionMouthValue(float f) {
        this.occlusionMouthValue = f;
    }

    public void setOcclusionNoseValue(float f) {
        this.occlusionNoseValue = f;
    }

    public void setOcclusionRightContourValue(float f) {
        this.occlusionRightContourValue = f;
    }

    public void setOcclusionRightEyeValue(float f) {
        this.occlusionRightEyeValue = f;
    }

    public void setOcclusionValue(float f) {
        this.occlusionValue = f;
    }

    public void setOpenMask(boolean z) {
        this.isOpenMask = z;
    }

    public void setOpenOnline(boolean z) {
        this.isOpenOnline = z;
    }

    public void setQualityLevel(int i) {
        this.qualityLevel = i;
    }

    public void setScale(float f) {
        this.scale = f;
    }

    public void setSecType(int i) {
        this.secType = i;
    }

    public void setSound(boolean z) {
        this.isSound = z;
    }

    public void setTimeDetectModule(long j) {
        this.timeDetectModule = j;
    }

    public void setTimeLivenessCourse(long j) {
        this.timeLivenessCourse = j;
    }
}

package com.baidu.idl.main.facesdk;

import com.baidu.idl.main.facesdk.model.BDFaceOcclusion;
import com.baidu.idl.main.facesdk.model.BDFaceSDKCommon;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class FaceInfo {
    public int age;
    public float angle;
    public float bluriness;
    public float centerX;
    public float centerY;
    public BDFaceSDKCommon.BDFaceEmotionEnum emotionSeven;
    public BDFaceSDKCommon.BDFaceEmotion emotionThree;
    public int faceID;
    public BDFaceSDKCommon.BDFaceGender gender;
    public BDFaceSDKCommon.BDFaceGlasses glasses;
    public float height;
    public int illum;
    public float[] landmarks;
    public float leftEyeclose;
    public float mouthclose;
    public BDFaceOcclusion occlusion;
    public float pitch;
    public BDFaceSDKCommon.BDFaceRace race;
    public float rightEyeclose;
    public float roll;
    public float score;
    public float width;
    public float yaw;

    public FaceInfo(int i4, float[] fArr, float[] fArr2) {
        this.faceID = i4;
        if (fArr != null && fArr.length == 6) {
            this.centerX = fArr[0];
            this.centerY = fArr[1];
            this.width = fArr[2];
            this.height = fArr[3];
            this.angle = fArr[4];
            this.score = fArr[5];
        }
        this.landmarks = fArr2;
    }

    public FaceInfo(int i4, float[] fArr, float[] fArr2, float[] fArr3, float[] fArr4, int[] iArr, float[] fArr5) {
        this.faceID = i4;
        if (fArr != null && fArr.length == 6) {
            this.centerX = fArr[0];
            this.centerY = fArr[1];
            this.width = fArr[2];
            this.height = fArr[3];
            this.angle = fArr[4];
            this.score = fArr[5];
        }
        this.landmarks = fArr2;
        if (fArr3 != null && fArr3.length == 3) {
            this.yaw = fArr3[0];
            this.roll = fArr3[1];
            this.pitch = fArr3[2];
        }
        if (fArr4 != null && fArr4.length == 9) {
            this.occlusion = new BDFaceOcclusion(fArr4[0], fArr4[1], fArr4[2], fArr4[3], fArr4[4], fArr4[5], fArr4[6]);
            this.illum = (int) fArr4[7];
            this.bluriness = fArr4[8];
        }
        if (iArr != null && iArr.length == 6) {
            this.age = iArr[0];
            this.race = BDFaceSDKCommon.BDFaceRace.values()[iArr[1]];
            this.emotionThree = BDFaceSDKCommon.BDFaceEmotion.values()[iArr[2]];
            this.glasses = BDFaceSDKCommon.BDFaceGlasses.values()[iArr[3]];
            this.gender = BDFaceSDKCommon.BDFaceGender.values()[iArr[4]];
            this.emotionSeven = BDFaceSDKCommon.BDFaceEmotionEnum.values()[iArr[5]];
        }
        if (fArr5 == null || fArr5.length != 3) {
            return;
        }
        this.leftEyeclose = fArr5[0];
        this.rightEyeclose = fArr5[1];
        this.mouthclose = fArr5[2];
    }

    public FaceInfo(int i4, float[] fArr, float[] fArr2, float[] fArr3, float[] fArr4, float[] fArr5) {
        this.faceID = i4;
        if (fArr != null && fArr.length == 6) {
            this.centerX = fArr[0];
            this.centerY = fArr[1];
            this.width = fArr[2];
            this.height = fArr[3];
            this.angle = fArr[4];
            this.score = fArr[5];
        }
        this.landmarks = fArr2;
        if (fArr3 != null && fArr3.length == 3) {
            this.yaw = fArr3[0];
            this.roll = fArr3[1];
            this.pitch = fArr3[2];
        }
        if (fArr4 != null && fArr4.length == 9) {
            this.occlusion = new BDFaceOcclusion(fArr4[0], fArr4[1], fArr4[2], fArr4[3], fArr4[4], fArr4[5], fArr4[6]);
            this.illum = (int) fArr4[7];
            this.bluriness = fArr4[8];
        }
        if (fArr5 == null || fArr5.length != 3) {
            return;
        }
        this.leftEyeclose = fArr5[0];
        this.rightEyeclose = fArr5[1];
        this.mouthclose = fArr5[2];
    }
}

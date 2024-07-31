package com.baidu.idl.face.platform.model;

import android.graphics.Point;
import android.graphics.Rect;
import com.baidu.idl.main.facesdk.FaceInfo;
import com.baidu.idl.main.facesdk.model.BDFaceOcclusion;
import java.util.HashMap;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class FaceExtInfo {
    private static int nComponents = 9;
    private HashMap<String, Point[]> facePointMap;
    private float mAngle;
    private float mBluriness;
    private float mCenterX;
    private float mCenterY;
    private int mFaceID;
    private float mHeight;
    private int mIllum;
    private float[] mLandmarks;
    private float mLeftEyeClose;
    private BDFaceOcclusion mOcclusion;
    private float mPitch;
    private float mRightEyeClose;
    private float mRoll;
    private float mScore;
    private float mWidth;
    private float mYaw;
    private static int[] comp1 = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
    private static int[] comp2 = {13, 14, 15, 16, 17, 18, 19, 20, 13, 21};
    private static int[] comp3 = {22, 23, 24, 25, 26, 27, 28, 29, 22};
    private static int[] comp4 = {30, 31, 32, 33, 34, 35, 36, 37, 30, 38};
    private static int[] comp5 = {39, 40, 41, 42, 43, 44, 45, 46, 39};
    private static int[] comp6 = {47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 47};
    private static int[] comp7 = {51, 57, 52};
    private static int[] comp8 = {58, 59, 60, 61, 62, 63, 64, 65, 58};
    private static int[] comp9 = {58, 66, 67, 68, 62, 69, 70, 71, 58};
    private static int[] nPoints = {13, 10, 9, 10, 9, 11, 3, 9, 9};

    public FaceExtInfo() {
    }

    public void addFaceInfo(FaceInfo faceInfo) {
        this.mFaceID = faceInfo.faceID;
        this.mCenterX = faceInfo.centerX;
        this.mCenterY = faceInfo.centerY;
        this.mWidth = faceInfo.width;
        this.mHeight = faceInfo.height;
        this.mAngle = faceInfo.angle;
        this.mScore = faceInfo.score;
        this.mLandmarks = faceInfo.landmarks;
        this.mPitch = faceInfo.pitch;
        this.mRoll = faceInfo.roll;
        this.mYaw = faceInfo.yaw;
        this.mBluriness = faceInfo.bluriness;
        this.mIllum = faceInfo.illum;
        BDFaceOcclusion bDFaceOcclusion = faceInfo.occlusion;
        this.mOcclusion = bDFaceOcclusion;
        bDFaceOcclusion.leftEye = bDFaceOcclusion.leftEye;
        bDFaceOcclusion.rightEye = bDFaceOcclusion.rightEye;
        bDFaceOcclusion.nose = bDFaceOcclusion.nose;
        bDFaceOcclusion.mouth = bDFaceOcclusion.mouth;
        bDFaceOcclusion.leftCheek = bDFaceOcclusion.leftCheek;
        bDFaceOcclusion.rightCheek = bDFaceOcclusion.rightCheek;
        bDFaceOcclusion.chin = bDFaceOcclusion.chin;
        this.mLeftEyeClose = faceInfo.leftEyeclose;
        this.mRightEyeClose = faceInfo.rightEyeclose;
    }

    public float getBluriness() {
        return this.mBluriness;
    }

    public float getConfidence() {
        return this.mScore;
    }

    public int getFaceId() {
        return this.mFaceID;
    }

    public Rect getFaceRect() {
        float f = this.mCenterX;
        float f2 = this.mWidth;
        return new Rect((int) (f - (f2 / 2.0f)), (int) (this.mCenterY - (f2 / 2.0f)), (int) f2, (int) f2);
    }

    public int getFaceWidth() {
        return (int) this.mWidth;
    }

    public int getIllum() {
        return this.mIllum;
    }

    public int getLandmarksOutOfDetectCount(Rect rect) {
        if (this.mLandmarks.length == 144) {
            int[][] iArr = {comp1, comp2, comp3, comp4, comp5, comp6, comp7, comp8, comp9};
            float[] fArr = new float[4];
            int i = 0;
            for (int i2 = 0; i2 < nComponents; i2++) {
                int i3 = 0;
                while (i3 < nPoints[i2] - 1) {
                    float[] fArr2 = this.mLandmarks;
                    fArr[0] = fArr2[iArr[i2][i3] << 1];
                    fArr[1] = fArr2[(iArr[i2][i3] << 1) + 1];
                    i3++;
                    fArr[2] = fArr2[iArr[i2][i3] << 1];
                    fArr[3] = fArr2[(iArr[i2][i3] << 1) + 1];
                    if (!rect.contains((int) (fArr[0] * 1.0f), (int) (fArr[1] * 1.0f))) {
                        i++;
                    }
                    if (!rect.contains((int) (fArr[2] * 1.0f), (int) (fArr[3] * 1.0f))) {
                        i++;
                    }
                }
            }
            return i;
        }
        return 0;
    }

    public float getLeftEyeClose() {
        return this.mLeftEyeClose;
    }

    public BDFaceOcclusion getOcclusion() {
        return this.mOcclusion;
    }

    public float getPitch() {
        return this.mPitch;
    }

    public void getRectPoints(int[] iArr) {
        int[] iArr2 = iArr;
        double d = this.mAngle;
        Double.isNaN(d);
        double d2 = (d * 3.14159d) / 180.0d;
        double cos = Math.cos(d2);
        double sin = Math.sin(d2);
        double d3 = this.mCenterX;
        float f = this.mWidth;
        double d4 = f;
        Double.isNaN(d4);
        Double.isNaN(d3);
        double d5 = d3 + ((d4 * cos) / 2.0d);
        double d6 = f;
        Double.isNaN(d6);
        int i = (int) (d5 - ((d6 * sin) / 2.0d));
        double d7 = this.mCenterY;
        double d8 = f;
        Double.isNaN(d8);
        Double.isNaN(d7);
        double d9 = d7 + ((sin * d8) / 2.0d);
        double d10 = f;
        Double.isNaN(d10);
        int i2 = (int) (d9 + ((cos * d10) / 2.0d));
        double d11 = this.mAngle;
        Double.isNaN(d11);
        double d12 = (d11 * 3.14159d) / 180.0d;
        double cos2 = Math.cos(d12) * 0.5d;
        double sin2 = Math.sin(d12) * 0.5d;
        if (iArr2 == null || iArr2.length == 0) {
            iArr2 = new int[8];
        }
        double d13 = i;
        float f2 = this.mWidth;
        double d14 = f2;
        Double.isNaN(d14);
        Double.isNaN(d13);
        double d15 = f2;
        Double.isNaN(d15);
        iArr2[0] = (int) ((d13 - (d14 * sin2)) - (d15 * cos2));
        double d16 = i2;
        double d17 = f2;
        Double.isNaN(d17);
        Double.isNaN(d16);
        double d18 = f2;
        Double.isNaN(d18);
        iArr2[1] = (int) ((d16 + (d17 * cos2)) - (d18 * sin2));
        double d19 = f2;
        Double.isNaN(d19);
        Double.isNaN(d13);
        double d20 = d13 + (d19 * sin2);
        double d21 = f2;
        Double.isNaN(d21);
        iArr2[2] = (int) (d20 - (d21 * cos2));
        double d22 = f2;
        Double.isNaN(d22);
        Double.isNaN(d16);
        double d23 = d16 - (cos2 * d22);
        double d24 = f2;
        Double.isNaN(d24);
        iArr2[3] = (int) (d23 - (sin2 * d24));
        int i3 = i * 2;
        iArr2[4] = i3 - iArr2[0];
        int i4 = i2 * 2;
        iArr2[5] = i4 - iArr2[1];
        iArr2[6] = i3 - iArr2[2];
        iArr2[7] = i4 - iArr2[3];
    }

    public float getRightEyeClose() {
        return this.mRightEyeClose;
    }

    public float getRoll() {
        return this.mRoll;
    }

    public float getYaw() {
        return this.mYaw;
    }

    public float[] getmLandmarks() {
        return this.mLandmarks;
    }

    public boolean isOutofDetectRect(Rect rect) {
        return rect.contains(getFaceRect());
    }

    public void setLeftEyeClose(float f) {
        this.mLeftEyeClose = f;
    }

    public void setRightEyeClose(float f) {
        this.mRightEyeClose = f;
    }

    public FaceExtInfo(FaceInfo faceInfo) {
        this.mFaceID = faceInfo.faceID;
        this.mCenterX = faceInfo.centerX;
        this.mCenterY = faceInfo.centerY;
        this.mWidth = faceInfo.width;
        this.mHeight = faceInfo.height;
        this.mAngle = faceInfo.angle;
        this.mScore = faceInfo.score;
        this.mLandmarks = faceInfo.landmarks;
        this.mPitch = faceInfo.pitch;
        this.mRoll = faceInfo.roll;
        this.mYaw = faceInfo.yaw;
        this.mBluriness = faceInfo.bluriness;
        this.mIllum = faceInfo.illum;
        BDFaceOcclusion bDFaceOcclusion = faceInfo.occlusion;
        this.mOcclusion = bDFaceOcclusion;
        bDFaceOcclusion.leftEye = bDFaceOcclusion.leftEye;
        bDFaceOcclusion.rightEye = bDFaceOcclusion.rightEye;
        bDFaceOcclusion.nose = bDFaceOcclusion.nose;
        bDFaceOcclusion.mouth = bDFaceOcclusion.mouth;
        bDFaceOcclusion.leftCheek = bDFaceOcclusion.leftCheek;
        bDFaceOcclusion.rightCheek = bDFaceOcclusion.rightCheek;
        bDFaceOcclusion.chin = bDFaceOcclusion.chin;
        this.mLeftEyeClose = faceInfo.leftEyeclose;
        this.mRightEyeClose = faceInfo.rightEyeclose;
    }

    public Rect getFaceRect(float f, float f2, float f3) {
        float f4 = this.mCenterX * f;
        float f5 = this.mCenterY * f2;
        float f6 = this.mWidth;
        return new Rect((int) (f4 - (((f6 / 2.0f) * f) * f3)), (int) (f5 - (((f6 / 2.0f) * f2) * f3)), (int) (f4 + ((f6 / 2.0f) * f * f3)), (int) (f5 + ((f6 / 2.0f) * f2 * f3)));
    }
}

package com.baidu.idl.face.platform.model;

import android.graphics.Point;
import android.graphics.Rect;
import com.baidu.idl.main.facesdk.FaceInfo;
import com.baidu.idl.main.facesdk.model.BDFaceOcclusion;
import java.util.HashMap;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
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
        float f4 = this.mCenterX;
        float f5 = this.mWidth;
        return new Rect((int) (f4 - (f5 / 2.0f)), (int) (this.mCenterY - (f5 / 2.0f)), (int) f5, (int) f5);
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
            int i4 = 0;
            for (int i5 = 0; i5 < nComponents; i5++) {
                int i6 = 0;
                while (i6 < nPoints[i5] - 1) {
                    float[] fArr2 = this.mLandmarks;
                    fArr[0] = fArr2[iArr[i5][i6] << 1];
                    fArr[1] = fArr2[(iArr[i5][i6] << 1) + 1];
                    i6++;
                    fArr[2] = fArr2[iArr[i5][i6] << 1];
                    fArr[3] = fArr2[(iArr[i5][i6] << 1) + 1];
                    if (!rect.contains((int) (fArr[0] * 1.0f), (int) (fArr[1] * 1.0f))) {
                        i4++;
                    }
                    if (!rect.contains((int) (fArr[2] * 1.0f), (int) (fArr[3] * 1.0f))) {
                        i4++;
                    }
                }
            }
            return i4;
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
        double d4 = this.mAngle;
        Double.isNaN(d4);
        double d5 = (d4 * 3.14159d) / 180.0d;
        double cos = Math.cos(d5);
        double sin = Math.sin(d5);
        double d6 = this.mCenterX;
        float f4 = this.mWidth;
        double d7 = f4;
        Double.isNaN(d7);
        Double.isNaN(d6);
        double d8 = d6 + ((d7 * cos) / 2.0d);
        double d9 = f4;
        Double.isNaN(d9);
        int i4 = (int) (d8 - ((d9 * sin) / 2.0d));
        double d10 = this.mCenterY;
        double d11 = f4;
        Double.isNaN(d11);
        Double.isNaN(d10);
        double d12 = d10 + ((sin * d11) / 2.0d);
        double d13 = f4;
        Double.isNaN(d13);
        int i5 = (int) (d12 + ((cos * d13) / 2.0d));
        double d14 = this.mAngle;
        Double.isNaN(d14);
        double d15 = (d14 * 3.14159d) / 180.0d;
        double cos2 = Math.cos(d15) * 0.5d;
        double sin2 = Math.sin(d15) * 0.5d;
        if (iArr2 == null || iArr2.length == 0) {
            iArr2 = new int[8];
        }
        double d16 = i4;
        float f5 = this.mWidth;
        double d17 = f5;
        Double.isNaN(d17);
        Double.isNaN(d16);
        double d18 = f5;
        Double.isNaN(d18);
        iArr2[0] = (int) ((d16 - (d17 * sin2)) - (d18 * cos2));
        double d19 = i5;
        double d20 = f5;
        Double.isNaN(d20);
        Double.isNaN(d19);
        double d21 = f5;
        Double.isNaN(d21);
        iArr2[1] = (int) ((d19 + (d20 * cos2)) - (d21 * sin2));
        double d22 = f5;
        Double.isNaN(d22);
        Double.isNaN(d16);
        double d23 = d16 + (d22 * sin2);
        double d24 = f5;
        Double.isNaN(d24);
        iArr2[2] = (int) (d23 - (d24 * cos2));
        double d25 = f5;
        Double.isNaN(d25);
        Double.isNaN(d19);
        double d26 = d19 - (cos2 * d25);
        double d27 = f5;
        Double.isNaN(d27);
        iArr2[3] = (int) (d26 - (sin2 * d27));
        int i6 = i4 * 2;
        iArr2[4] = i6 - iArr2[0];
        int i7 = i5 * 2;
        iArr2[5] = i7 - iArr2[1];
        iArr2[6] = i6 - iArr2[2];
        iArr2[7] = i7 - iArr2[3];
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

    public void setLeftEyeClose(float f4) {
        this.mLeftEyeClose = f4;
    }

    public void setRightEyeClose(float f4) {
        this.mRightEyeClose = f4;
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

    public Rect getFaceRect(float f4, float f5, float f6) {
        float f7 = this.mCenterX * f4;
        float f8 = this.mCenterY * f5;
        float f9 = this.mWidth;
        return new Rect((int) (f7 - (((f9 / 2.0f) * f4) * f6)), (int) (f8 - (((f9 / 2.0f) * f5) * f6)), (int) (f7 + ((f9 / 2.0f) * f4 * f6)), (int) (f8 + ((f9 / 2.0f) * f5 * f6)));
    }
}

package com.baidu.idl.main.facesdk.model;

import com.baidu.idl.main.facesdk.model.BDFaceSDKCommon;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class BDFaceGazeInfo {
    public float leftEyeConf;
    public BDFaceSDKCommon.BDFaceGazeDirection leftEyeGaze;
    public float rightEyeConf;
    public BDFaceSDKCommon.BDFaceGazeDirection rightEyeGaze;

    public BDFaceGazeInfo(int i, float f, int i2, float f2) {
        this.leftEyeGaze = BDFaceSDKCommon.BDFaceGazeDirection.values()[i];
        this.leftEyeConf = f;
        this.rightEyeGaze = BDFaceSDKCommon.BDFaceGazeDirection.values()[i2];
        this.rightEyeConf = f2;
    }
}

package com.baidu.idl.main.facesdk.model;

import com.baidu.idl.main.facesdk.model.BDFaceSDKCommon;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class BDFaceGazeInfo {
    public float leftEyeConf;
    public BDFaceSDKCommon.BDFaceGazeDirection leftEyeGaze;
    public float rightEyeConf;
    public BDFaceSDKCommon.BDFaceGazeDirection rightEyeGaze;

    public BDFaceGazeInfo(int i4, float f4, int i5, float f5) {
        this.leftEyeGaze = BDFaceSDKCommon.BDFaceGazeDirection.values()[i4];
        this.leftEyeConf = f4;
        this.rightEyeGaze = BDFaceSDKCommon.BDFaceGazeDirection.values()[i5];
        this.rightEyeConf = f5;
    }
}

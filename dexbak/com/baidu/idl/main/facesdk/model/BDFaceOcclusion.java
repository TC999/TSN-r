package com.baidu.idl.main.facesdk.model;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class BDFaceOcclusion {
    public float chin;
    public float leftCheek;
    public float leftEye;
    public float mouth;
    public float nose;
    public float rightCheek;
    public float rightEye;

    public BDFaceOcclusion(float f, float f2, float f3, float f4, float f5, float f6, float f7) {
        this.leftEye = f;
        this.rightEye = f2;
        this.nose = f3;
        this.mouth = f4;
        this.leftCheek = f5;
        this.rightCheek = f6;
        this.chin = f7;
    }
}

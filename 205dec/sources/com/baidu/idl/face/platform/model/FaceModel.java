package com.baidu.idl.face.platform.model;

import com.baidu.idl.face.platform.FaceStatusNewEnum;
import com.baidu.idl.main.facesdk.FaceInfo;
import com.baidu.idl.main.facesdk.model.BDFaceImageInstance;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class FaceModel {
    private BDFaceImageInstance BitmapInstance;
    private BDFaceImageInstance cropInstance;
    private FaceExtInfo[] faceInfos;
    private FaceStatusNewEnum faceNewStatus;
    private FaceInfo[] faceSDKInfos;
    private long frameTime;
    private BDFaceImageInstance imageInstance;

    public BDFaceImageInstance getBitmapInstance() {
        return this.BitmapInstance;
    }

    public BDFaceImageInstance getCropInstance() {
        return this.cropInstance;
    }

    public FaceExtInfo[] getFaceInfos() {
        return this.faceInfos;
    }

    public FaceStatusNewEnum getFaceModuleStateNew() {
        return this.faceNewStatus;
    }

    public FaceInfo[] getFaceSDKInfos() {
        return this.faceSDKInfos;
    }

    public long getFrameTime() {
        return this.frameTime;
    }

    public BDFaceImageInstance getImageInstance() {
        return this.imageInstance;
    }

    public void setBitmapInstance(BDFaceImageInstance bDFaceImageInstance) {
        this.BitmapInstance = bDFaceImageInstance;
    }

    public void setCropInstance(BDFaceImageInstance bDFaceImageInstance) {
        this.cropInstance = bDFaceImageInstance;
    }

    public void setFaceInfos(FaceExtInfo[] faceExtInfoArr) {
        this.faceInfos = faceExtInfoArr;
    }

    public void setFaceModuleStateNew(FaceStatusNewEnum faceStatusNewEnum) {
        this.faceNewStatus = faceStatusNewEnum;
    }

    public void setFaceSDKInfos(FaceInfo[] faceInfoArr) {
        this.faceSDKInfos = faceInfoArr;
    }

    public void setFrameTime(long j4) {
        this.frameTime = j4;
    }

    public void setImageInstance(BDFaceImageInstance bDFaceImageInstance) {
        this.imageInstance = bDFaceImageInstance;
    }
}

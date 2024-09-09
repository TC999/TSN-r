package com.baidu.idl.face.platform;

import com.baidu.idl.face.platform.model.FaceExtInfo;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public interface ILivenessViewCallback {
    void animStop();

    void setCurrentLiveType(LivenessTypeEnum livenessTypeEnum);

    void setFaceInfo(FaceExtInfo faceExtInfo);

    void viewReset();
}

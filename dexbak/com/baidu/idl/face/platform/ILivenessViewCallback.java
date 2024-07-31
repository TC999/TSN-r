package com.baidu.idl.face.platform;

import com.baidu.idl.face.platform.model.FaceExtInfo;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public interface ILivenessViewCallback {
    void animStop();

    void setCurrentLiveType(LivenessTypeEnum livenessTypeEnum);

    void setFaceInfo(FaceExtInfo faceExtInfo);

    void viewReset();
}

package com.baidu.idl.face.platform.p049ui;

import com.baidu.idl.face.platform.FaceEnvironment;
import com.baidu.idl.face.platform.FaceStatusNewEnum;

/* renamed from: com.baidu.idl.face.platform.ui.FaceSDKResSettings */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class FaceSDKResSettings {
    public static void initializeResId() {
        FaceStatusNewEnum faceStatusNewEnum = FaceStatusNewEnum.DetectRemindCodeNoFaceDetected;
        int i = C2505R.raw.detect_face_in;
        FaceEnvironment.setSoundId(faceStatusNewEnum, i);
        FaceStatusNewEnum faceStatusNewEnum2 = FaceStatusNewEnum.DetectRemindCodeBeyondPreviewFrame;
        FaceEnvironment.setSoundId(faceStatusNewEnum2, i);
        FaceEnvironment.setSoundId(faceStatusNewEnum, i);
        FaceStatusNewEnum faceStatusNewEnum3 = FaceStatusNewEnum.FaceLivenessActionTypeLiveEye;
        FaceEnvironment.setSoundId(faceStatusNewEnum3, C2505R.raw.liveness_eye);
        FaceStatusNewEnum faceStatusNewEnum4 = FaceStatusNewEnum.FaceLivenessActionTypeLiveMouth;
        FaceEnvironment.setSoundId(faceStatusNewEnum4, C2505R.raw.liveness_mouth);
        FaceStatusNewEnum faceStatusNewEnum5 = FaceStatusNewEnum.FaceLivenessActionTypeLivePitchUp;
        FaceEnvironment.setSoundId(faceStatusNewEnum5, C2505R.raw.liveness_head_up);
        FaceStatusNewEnum faceStatusNewEnum6 = FaceStatusNewEnum.FaceLivenessActionTypeLivePitchDown;
        FaceEnvironment.setSoundId(faceStatusNewEnum6, C2505R.raw.liveness_head_down);
        FaceStatusNewEnum faceStatusNewEnum7 = FaceStatusNewEnum.FaceLivenessActionTypeLiveYawLeft;
        FaceEnvironment.setSoundId(faceStatusNewEnum7, C2505R.raw.liveness_head_left);
        FaceStatusNewEnum faceStatusNewEnum8 = FaceStatusNewEnum.FaceLivenessActionTypeLiveYawRight;
        FaceEnvironment.setSoundId(faceStatusNewEnum8, C2505R.raw.liveness_head_right);
        FaceStatusNewEnum faceStatusNewEnum9 = FaceStatusNewEnum.FaceLivenessActionComplete;
        int i2 = C2505R.raw.face_good;
        FaceEnvironment.setSoundId(faceStatusNewEnum9, i2);
        FaceStatusNewEnum faceStatusNewEnum10 = FaceStatusNewEnum.OK;
        FaceEnvironment.setSoundId(faceStatusNewEnum10, i2);
        int i3 = C2505R.C2511string.detect_face_in;
        FaceEnvironment.setTipsId(faceStatusNewEnum, i3);
        FaceEnvironment.setTipsId(faceStatusNewEnum2, i3);
        FaceEnvironment.setTipsId(FaceStatusNewEnum.DetectRemindCodePoorIllumination, C2505R.C2511string.detect_low_light);
        FaceEnvironment.setTipsId(FaceStatusNewEnum.DetectRemindCodeImageBlured, C2505R.C2511string.detect_keep);
        FaceEnvironment.setTipsId(FaceStatusNewEnum.DetectRemindCodeOcclusionLeftEye, C2505R.C2511string.detect_occ_left_eye);
        FaceEnvironment.setTipsId(FaceStatusNewEnum.DetectRemindCodeOcclusionRightEye, C2505R.C2511string.detect_occ_right_eye);
        FaceEnvironment.setTipsId(FaceStatusNewEnum.DetectRemindCodeOcclusionNose, C2505R.C2511string.detect_occ_nose);
        FaceEnvironment.setTipsId(FaceStatusNewEnum.DetectRemindCodeOcclusionMouth, C2505R.C2511string.detect_occ_mouth);
        FaceEnvironment.setTipsId(FaceStatusNewEnum.DetectRemindCodeOcclusionLeftContour, C2505R.C2511string.detect_occ_left_check);
        FaceEnvironment.setTipsId(FaceStatusNewEnum.DetectRemindCodeOcclusionRightContour, C2505R.C2511string.detect_occ_right_check);
        FaceEnvironment.setTipsId(FaceStatusNewEnum.DetectRemindCodeOcclusionChinContour, C2505R.C2511string.detect_occ_chin);
        FaceEnvironment.setTipsId(FaceStatusNewEnum.DetectRemindCodePitchOutofUpRange, C2505R.C2511string.detect_head_down);
        FaceEnvironment.setTipsId(FaceStatusNewEnum.DetectRemindCodePitchOutofDownRange, C2505R.C2511string.detect_head_up);
        FaceEnvironment.setTipsId(FaceStatusNewEnum.DetectRemindCodeYawOutofLeftRange, C2505R.C2511string.detect_head_right);
        FaceEnvironment.setTipsId(FaceStatusNewEnum.DetectRemindCodeYawOutofRightRange, C2505R.C2511string.detect_head_left);
        FaceEnvironment.setTipsId(FaceStatusNewEnum.DetectRemindCodeTooFar, C2505R.C2511string.detect_zoom_in);
        FaceEnvironment.setTipsId(FaceStatusNewEnum.DetectRemindCodeTooClose, C2505R.C2511string.detect_zoom_out);
        FaceEnvironment.setTipsId(FaceStatusNewEnum.DetectRemindCodeLeftEyeClosed, C2505R.C2511string.detect_left_eye_close);
        FaceEnvironment.setTipsId(FaceStatusNewEnum.DetectRemindCodeRightEyeClosed, C2505R.C2511string.detect_right_eye_close);
        FaceEnvironment.setTipsId(faceStatusNewEnum3, C2505R.C2511string.liveness_eye);
        FaceEnvironment.setTipsId(faceStatusNewEnum4, C2505R.C2511string.liveness_mouth);
        FaceEnvironment.setTipsId(faceStatusNewEnum5, C2505R.C2511string.liveness_head_up);
        FaceEnvironment.setTipsId(faceStatusNewEnum6, C2505R.C2511string.liveness_head_down);
        FaceEnvironment.setTipsId(faceStatusNewEnum7, C2505R.C2511string.liveness_head_left);
        FaceEnvironment.setTipsId(faceStatusNewEnum8, C2505R.C2511string.liveness_head_right);
        int i4 = C2505R.C2511string.liveness_good;
        FaceEnvironment.setTipsId(faceStatusNewEnum9, i4);
        FaceEnvironment.setTipsId(faceStatusNewEnum10, i4);
        FaceEnvironment.setTipsId(FaceStatusNewEnum.DetectRemindCodeTimeout, C2505R.C2511string.detect_timeout);
    }
}

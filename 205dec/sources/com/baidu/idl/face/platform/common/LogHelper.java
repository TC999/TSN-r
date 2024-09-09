package com.baidu.idl.face.platform.common;

import android.text.TextUtils;
import com.baidu.idl.face.platform.FaceStatusNewEnum;
import com.baidu.idl.face.platform.network.LogRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class LogHelper {
    private static final String TAG = "LogHelper";
    private static HashMap<String, Object> logMap = new HashMap<>();
    private static ArrayList<Integer> logLivenessLiveness = new ArrayList<>();
    private static HashMap<String, Integer> logTipsMap = new HashMap<>();

    public static void addLivenessLog(int i4) {
        ArrayList<Integer> arrayList = logLivenessLiveness;
        if (arrayList == null || arrayList.contains(Integer.valueOf(i4))) {
            return;
        }
        logLivenessLiveness.add(Integer.valueOf(i4));
    }

    public static void addLog(String str, Object obj) {
        HashMap<String, Object> hashMap = logMap;
        if (hashMap != null) {
            hashMap.put(str, obj);
        }
    }

    public static void addLogWithKey(String str, Object obj) {
        HashMap<String, Object> hashMap = logMap;
        if (hashMap == null || hashMap.containsKey(str)) {
            return;
        }
        logMap.put(str, obj);
    }

    public static void addTipsLogWithKey(String str) {
        HashMap<String, Integer> hashMap = logTipsMap;
        if (hashMap != null && !hashMap.containsKey(str)) {
            logTipsMap.put(str, 1);
            return;
        }
        HashMap<String, Integer> hashMap2 = logTipsMap;
        if (hashMap2 == null || !hashMap2.containsKey(str)) {
            return;
        }
        logTipsMap.put(str, Integer.valueOf(logTipsMap.get(str).intValue() + 1));
    }

    public static void clear() {
        logMap = new HashMap<>();
        logLivenessLiveness = new ArrayList<>();
        logTipsMap = new HashMap<>();
    }

    private static String getLog() {
        StringBuilder sb = new StringBuilder();
        try {
            sb.append("{");
            int i4 = 0;
            for (Map.Entry<String, Object> entry : logMap.entrySet()) {
                if (i4 == logMap.size() - 1) {
                    if (entry.getValue() instanceof String) {
                        sb.append(entry.getKey() + ":'" + entry.getValue() + "'");
                    } else {
                        sb.append(entry.getKey() + ":" + entry.getValue());
                    }
                } else {
                    if (entry.getValue() instanceof String) {
                        sb.append(entry.getKey() + ":'" + entry.getValue() + "'");
                    } else {
                        sb.append(entry.getKey() + ":" + entry.getValue());
                    }
                    sb.append(",");
                }
                i4++;
            }
            ArrayList<Integer> arrayList = logLivenessLiveness;
            if (arrayList != null && arrayList.size() > 0) {
                sb.append(",lv:[");
                for (int i5 = 0; i5 < logLivenessLiveness.size(); i5++) {
                    if (i5 == logLivenessLiveness.size() - 1) {
                        sb.append(logLivenessLiveness.get(i5));
                    } else {
                        sb.append(logLivenessLiveness.get(i5) + ",");
                    }
                }
                sb.append("]");
            }
            HashMap<String, Integer> hashMap = logTipsMap;
            if (hashMap != null && hashMap.size() > 0) {
                sb.append(",msg:{");
                sb.append(getTipsMessage());
                sb.append("}");
            }
            sb.append("}");
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        logMap = new HashMap<>();
        logLivenessLiveness = new ArrayList<>();
        logTipsMap = new HashMap<>();
        return sb.toString();
    }

    private static String getTipsKey(String str) {
        return TextUtils.equals(str, FaceStatusNewEnum.DetectRemindCodeOcclusionLeftEye.name()) ? "leftEyeOccusion" : TextUtils.equals(str, FaceStatusNewEnum.DetectRemindCodeOcclusionRightEye.name()) ? "rightEyeOccusion" : TextUtils.equals(str, FaceStatusNewEnum.DetectRemindCodeOcclusionNose.name()) ? "noseOccusion" : TextUtils.equals(str, FaceStatusNewEnum.DetectRemindCodeOcclusionMouth.name()) ? "mouthOccusion" : TextUtils.equals(str, FaceStatusNewEnum.DetectRemindCodeOcclusionLeftContour.name()) ? "leftFaceOccusion" : TextUtils.equals(str, FaceStatusNewEnum.DetectRemindCodeOcclusionRightContour.name()) ? "rightFaceOccusion" : TextUtils.equals(str, FaceStatusNewEnum.DetectRemindCodeOcclusionChinContour.name()) ? "chinOccusion" : TextUtils.equals(str, FaceStatusNewEnum.DetectRemindCodePoorIllumination.name()) ? "lightUp" : TextUtils.equals(str, FaceStatusNewEnum.DetectRemindCodeImageBlured.name()) ? "stayStill" : TextUtils.equals(str, FaceStatusNewEnum.DetectRemindCodeTooFar.name()) ? "moveClose" : TextUtils.equals(str, FaceStatusNewEnum.DetectRemindCodeTooClose.name()) ? "moveFurther" : TextUtils.equals(str, FaceStatusNewEnum.DetectRemindCodePitchOutofDownRange.name()) ? "headUp" : TextUtils.equals(str, FaceStatusNewEnum.DetectRemindCodePitchOutofUpRange.name()) ? "headDown" : TextUtils.equals(str, FaceStatusNewEnum.DetectRemindCodeYawOutofRightRange.name()) ? "turnLeft" : TextUtils.equals(str, FaceStatusNewEnum.DetectRemindCodeYawOutofLeftRange.name()) ? "turnRight" : (TextUtils.equals(str, FaceStatusNewEnum.DetectRemindCodeNoFaceDetected.name()) || TextUtils.equals(str, FaceStatusNewEnum.DetectRemindCodeBeyondPreviewFrame.name())) ? "moveFace" : "";
    }

    private static String getTipsMessage() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Integer> entry : logTipsMap.entrySet()) {
            String tipsKey = getTipsKey(entry.getKey());
            if (!TextUtils.isEmpty(tipsKey)) {
                sb.append(tipsKey + ":" + entry.getValue());
                sb.append(",");
            }
        }
        if (sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }

    public static void sendLog() {
        LogRequest.sendLogMessage(getLog());
    }
}

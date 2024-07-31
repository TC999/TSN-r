package com.baidu.idl.face.platform.common;

import android.text.TextUtils;
import com.baidu.idl.face.platform.FaceStatusNewEnum;
import com.baidu.idl.face.platform.network.LogRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class LogHelper {
    private static final String TAG = "LogHelper";
    private static HashMap<String, Object> logMap = new HashMap<>();
    private static ArrayList<Integer> logLivenessLiveness = new ArrayList<>();
    private static HashMap<String, Integer> logTipsMap = new HashMap<>();

    public static void addLivenessLog(int i) {
        ArrayList<Integer> arrayList = logLivenessLiveness;
        if (arrayList == null || arrayList.contains(Integer.valueOf(i))) {
            return;
        }
        logLivenessLiveness.add(Integer.valueOf(i));
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
            int i = 0;
            for (Map.Entry<String, Object> entry : logMap.entrySet()) {
                if (i == logMap.size() - 1) {
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
                i++;
            }
            ArrayList<Integer> arrayList = logLivenessLiveness;
            if (arrayList != null && arrayList.size() > 0) {
                sb.append(",lv:[");
                for (int i2 = 0; i2 < logLivenessLiveness.size(); i2++) {
                    if (i2 == logLivenessLiveness.size() - 1) {
                        sb.append(logLivenessLiveness.get(i2));
                    } else {
                        sb.append(logLivenessLiveness.get(i2) + ",");
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
        } catch (Exception e) {
            e.printStackTrace();
        }
        logMap = new HashMap<>();
        logLivenessLiveness = new ArrayList<>();
        logTipsMap = new HashMap<>();
        return sb.toString();
    }

    private static String getTipsKey(String str) {
        return TextUtils.equals(str, FaceStatusNewEnum.DetectRemindCodeOcclusionLeftEye.name()) ? ConstantHelper.LOG_TIPS_LEFTEYE_OCC : TextUtils.equals(str, FaceStatusNewEnum.DetectRemindCodeOcclusionRightEye.name()) ? ConstantHelper.LOG_TIPS_RIGHTEYE_OCC : TextUtils.equals(str, FaceStatusNewEnum.DetectRemindCodeOcclusionNose.name()) ? ConstantHelper.LOG_TIPS_NOSE_OCC : TextUtils.equals(str, FaceStatusNewEnum.DetectRemindCodeOcclusionMouth.name()) ? ConstantHelper.LOG_TIPS_MOUTH_OCC : TextUtils.equals(str, FaceStatusNewEnum.DetectRemindCodeOcclusionLeftContour.name()) ? ConstantHelper.LOG_TIPS_LEFTFACE_OCC : TextUtils.equals(str, FaceStatusNewEnum.DetectRemindCodeOcclusionRightContour.name()) ? ConstantHelper.LOG_TIPS_RIGHTFACE_OCC : TextUtils.equals(str, FaceStatusNewEnum.DetectRemindCodeOcclusionChinContour.name()) ? ConstantHelper.LOG_TIPS_CHIN_OCC : TextUtils.equals(str, FaceStatusNewEnum.DetectRemindCodePoorIllumination.name()) ? ConstantHelper.LOG_TIPS_LIGHTUP : TextUtils.equals(str, FaceStatusNewEnum.DetectRemindCodeImageBlured.name()) ? ConstantHelper.LOG_TIPS_STAYSTILL : TextUtils.equals(str, FaceStatusNewEnum.DetectRemindCodeTooFar.name()) ? ConstantHelper.LOG_TIPS_MOVECLOSE : TextUtils.equals(str, FaceStatusNewEnum.DetectRemindCodeTooClose.name()) ? ConstantHelper.LOG_TIPS_MOVEFURTHER : TextUtils.equals(str, FaceStatusNewEnum.DetectRemindCodePitchOutofDownRange.name()) ? ConstantHelper.LOG_TIPS_HEADUP : TextUtils.equals(str, FaceStatusNewEnum.DetectRemindCodePitchOutofUpRange.name()) ? ConstantHelper.LOG_TIPS_HEADDOWN : TextUtils.equals(str, FaceStatusNewEnum.DetectRemindCodeYawOutofRightRange.name()) ? ConstantHelper.LOG_TIPS_TURNLEFT : TextUtils.equals(str, FaceStatusNewEnum.DetectRemindCodeYawOutofLeftRange.name()) ? ConstantHelper.LOG_TIPS_TURNRIGHT : (TextUtils.equals(str, FaceStatusNewEnum.DetectRemindCodeNoFaceDetected.name()) || TextUtils.equals(str, FaceStatusNewEnum.DetectRemindCodeBeyondPreviewFrame.name())) ? ConstantHelper.LOG_TIPS_MOVEFACE : "";
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

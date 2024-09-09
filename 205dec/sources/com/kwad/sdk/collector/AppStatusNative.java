package com.kwad.sdk.collector;

import androidx.annotation.Keep;
import com.kwad.sdk.collector.model.jni.AnalyseTaskNative;
import com.kwad.sdk.collector.model.jni.AppRunningInfoNative;
import com.kwad.sdk.collector.model.jni.RulesTargetNative;
import com.kwad.sdk.collector.model.jni.UploadEntryNative;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
@Keep
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class AppStatusNative {
    public static native String[] analyseTaskGetPathSuffixSet(AnalyseTaskNative analyseTaskNative);

    public static native long analyseTaskGetRunningInfo(AnalyseTaskNative analyseTaskNative);

    public static native long analyseTaskGetStartTime(AnalyseTaskNative analyseTaskNative);

    public static native long[] analysis(long[] jArr, String str);

    public static native long appRunningInfoGetGranularity(AppRunningInfoNative appRunningInfoNative);

    public static native long appRunningInfoGetLastRunningTime(AppRunningInfoNative appRunningInfoNative);

    public static native String appRunningInfoGetName(AppRunningInfoNative appRunningInfoNative);

    public static native String appRunningInfoGetPackageName(AppRunningInfoNative appRunningInfoNative);

    public static native void appRunningInfoSetLastRunningTime(AppRunningInfoNative appRunningInfoNative, long j4);

    public static native long nativeCreateAnalyseTask(long j4, String[] strArr, long j5);

    public static native long nativeCreateAppRunningInfo(long j4, String str, String str2);

    public static native long nativeCreateRulesTarget();

    public static native long nativeCreateUploadEntry();

    public static native void nativeDeleteAnalyseTask(long j4);

    public static native void nativeDeleteAppRunningInfo(long j4);

    public static native void nativeDeleteRulesTarget(long j4);

    public static native void nativeDeleteUploadEntry(long j4);

    public static native long[] nativeGetUploadEntry(long[] jArr, long j4, String str);

    public static native String rulesTargetGetPackageName(RulesTargetNative rulesTargetNative);

    public static native String[] rulesTargetGetPaths(RulesTargetNative rulesTargetNative);

    public static native void rulesTargetSetPackageName(RulesTargetNative rulesTargetNative, String str);

    public static native void rulesTargetSetPaths(RulesTargetNative rulesTargetNative, String[] strArr);

    public static native String uploadEntryGetOriginFilePath(UploadEntryNative uploadEntryNative);

    public static native String uploadEntryGetPackageName(UploadEntryNative uploadEntryNative);

    public static native void uploadEntrySetOriginFilePath(UploadEntryNative uploadEntryNative, String str);

    public static native void uploadEntrySetPackageName(UploadEntryNative uploadEntryNative, String str);
}

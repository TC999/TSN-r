package com.kwad.sdk.collector.model.jni;

import com.kwad.sdk.collector.AppStatusNative;
import com.kwad.sdk.collector.model.a;
import java.util.Set;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class AnalyseTaskNative extends NativeObject implements a {
    public AnalyseTaskNative(AppRunningInfoNative appRunningInfoNative, Set<String> set, long j4) {
        String[] strArr = new String[set.size()];
        set.toArray(strArr);
        this.mPtr = AppStatusNative.nativeCreateAnalyseTask(appRunningInfoNative.mPtr, strArr, j4);
    }

    @Override // com.kwad.sdk.collector.model.jni.NativeObject
    public void destroy() {
        long j4 = this.mPtr;
        if (j4 != 0) {
            AppStatusNative.nativeDeleteAnalyseTask(j4);
            this.mPtr = 0L;
        }
    }
}

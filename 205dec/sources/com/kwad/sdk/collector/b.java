package com.kwad.sdk.collector;

import android.os.Environment;
import com.bytedance.pangle.sdk.component.log.impl.cache.db.TTPathConst;
import com.kwad.sdk.collector.AppStatusRules;
import com.kwad.sdk.collector.model.jni.AnalyseTaskNative;
import com.kwad.sdk.collector.model.jni.AppRunningInfoNative;
import com.kwad.sdk.collector.model.jni.RulesTargetNative;
import com.kwad.sdk.collector.model.jni.UploadEntryNative;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class b {
    public static com.kwad.sdk.collector.a Av() {
        return new a();
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public static class a implements com.kwad.sdk.collector.a {
        @Override // com.kwad.sdk.collector.a
        public final List<com.kwad.sdk.collector.model.b> a(AppStatusRules.Strategy strategy) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            com.kwad.sdk.collector.model.c.a(strategy, arrayList2);
            File file = new File(Environment.getExternalStorageDirectory(), "/Android/data/");
            int size = arrayList2.size();
            long[] jArr = new long[size];
            for (int i4 = 0; i4 < size; i4++) {
                com.kwad.sdk.collector.model.a aVar = (com.kwad.sdk.collector.model.a) arrayList2.get(i4);
                if (!(aVar instanceof AnalyseTaskNative)) {
                    return arrayList;
                }
                jArr[i4] = ((AnalyseTaskNative) aVar).getNativePtr();
            }
            if (d.Ax()) {
                try {
                    long[] analysis = AppStatusNative.analysis(jArr, file.getAbsolutePath() + TTPathConst.sSeparator);
                    StringBuilder sb = new StringBuilder("analysisByFile: runningInfoPtrs: ");
                    sb.append(analysis);
                    com.kwad.sdk.core.e.c.d("AppStatusAnalyserNative", sb.toString());
                    for (long j4 : analysis) {
                        arrayList.add(new AppRunningInfoNative(j4));
                    }
                } catch (Throwable th) {
                    com.kwad.sdk.core.e.c.printStackTraceOnly(th);
                }
            }
            com.kwad.sdk.core.e.c.d("AppStatusAnalyserNative", "analysisByFile: info size: " + arrayList.size());
            return arrayList;
        }

        @Override // com.kwad.sdk.collector.a
        public final List<com.kwad.sdk.collector.model.e> a(List<com.kwad.sdk.collector.model.d> list, long j4, String str) {
            int size = list.size();
            long[] jArr = new long[list.size()];
            for (int i4 = 0; i4 < size; i4++) {
                com.kwad.sdk.collector.model.d dVar = list.get(i4);
                if (dVar instanceof RulesTargetNative) {
                    jArr[i4] = ((RulesTargetNative) dVar).getNativePtr();
                }
            }
            ArrayList arrayList = new ArrayList();
            if (d.Ax()) {
                try {
                    for (long j5 : AppStatusNative.nativeGetUploadEntry(jArr, j4, str)) {
                        arrayList.add(new UploadEntryNative(j5));
                    }
                } catch (Throwable th) {
                    com.kwad.sdk.core.e.c.printStackTraceOnly(th);
                }
            }
            return arrayList;
        }
    }
}

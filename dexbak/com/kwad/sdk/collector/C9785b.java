package com.kwad.sdk.collector;

import android.os.Environment;
import com.kwad.sdk.collector.AppStatusRules;
import com.kwad.sdk.collector.model.C9809c;
import com.kwad.sdk.collector.model.InterfaceC9807a;
import com.kwad.sdk.collector.model.InterfaceC9808b;
import com.kwad.sdk.collector.model.InterfaceC9810d;
import com.kwad.sdk.collector.model.InterfaceC9811e;
import com.kwad.sdk.collector.model.jni.AnalyseTaskNative;
import com.kwad.sdk.collector.model.jni.AppRunningInfoNative;
import com.kwad.sdk.collector.model.jni.RulesTargetNative;
import com.kwad.sdk.collector.model.jni.UploadEntryNative;
import com.kwad.sdk.core.p397e.C10331c;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.kwad.sdk.collector.b */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9785b {
    /* renamed from: Av */
    public static InterfaceC9781a m27780Av() {
        return new C9786a();
    }

    /* renamed from: com.kwad.sdk.collector.b$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class C9786a implements InterfaceC9781a {
        @Override // com.kwad.sdk.collector.InterfaceC9781a
        /* renamed from: a */
        public final List<InterfaceC9808b> mo27777a(AppStatusRules.Strategy strategy) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            C9809c.m27734a(strategy, arrayList2);
            File file = new File(Environment.getExternalStorageDirectory(), "/Android/data/");
            int size = arrayList2.size();
            long[] jArr = new long[size];
            for (int i = 0; i < size; i++) {
                InterfaceC9807a interfaceC9807a = (InterfaceC9807a) arrayList2.get(i);
                if (!(interfaceC9807a instanceof AnalyseTaskNative)) {
                    return arrayList;
                }
                jArr[i] = ((AnalyseTaskNative) interfaceC9807a).getNativePtr();
            }
            if (C9796d.m27763Ax()) {
                try {
                    long[] analysis = AppStatusNative.analysis(jArr, file.getAbsolutePath() + "/");
                    StringBuilder sb = new StringBuilder("analysisByFile: runningInfoPtrs: ");
                    sb.append(analysis);
                    C10331c.m26254d("AppStatusAnalyserNative", sb.toString());
                    for (long j : analysis) {
                        arrayList.add(new AppRunningInfoNative(j));
                    }
                } catch (Throwable th) {
                    C10331c.printStackTraceOnly(th);
                }
            }
            C10331c.m26254d("AppStatusAnalyserNative", "analysisByFile: info size: " + arrayList.size());
            return arrayList;
        }

        @Override // com.kwad.sdk.collector.InterfaceC9781a
        /* renamed from: a */
        public final List<InterfaceC9811e> mo27775a(List<InterfaceC9810d> list, long j, String str) {
            int size = list.size();
            long[] jArr = new long[list.size()];
            for (int i = 0; i < size; i++) {
                InterfaceC9810d interfaceC9810d = list.get(i);
                if (interfaceC9810d instanceof RulesTargetNative) {
                    jArr[i] = ((RulesTargetNative) interfaceC9810d).getNativePtr();
                }
            }
            ArrayList arrayList = new ArrayList();
            if (C9796d.m27763Ax()) {
                try {
                    for (long j2 : AppStatusNative.nativeGetUploadEntry(jArr, j, str)) {
                        arrayList.add(new UploadEntryNative(j2));
                    }
                } catch (Throwable th) {
                    C10331c.printStackTraceOnly(th);
                }
            }
            return arrayList;
        }
    }
}

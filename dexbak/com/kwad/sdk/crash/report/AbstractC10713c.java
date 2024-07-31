package com.kwad.sdk.crash.report;

import android.util.Log;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.crash.C10654a;
import com.kwad.sdk.crash.C10671e;
import com.kwad.sdk.crash.model.message.ExceptionMessage;
import com.kwad.sdk.crash.report.request.C10722b;
import com.kwad.sdk.crash.report.request.C10727c;
import com.kwad.sdk.crash.utils.C10739c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/* renamed from: com.kwad.sdk.crash.report.c */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public abstract class AbstractC10713c implements InterfaceC10717e {
    private ArrayList<C10714a> aHe = new ArrayList<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.kwad.sdk.crash.report.c$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class C10714a {
        private ExceptionMessage aHf;
        private int aHg;

        C10714a(ExceptionMessage exceptionMessage, int i) {
            this.aHf = exceptionMessage;
            this.aHg = i;
        }
    }

    /* renamed from: HY */
    private void m25055HY() {
        if (this.aHe.isEmpty()) {
            return;
        }
        try {
            Iterator<C10714a> it = this.aHe.iterator();
            while (it.hasNext()) {
                C10714a next = it.next();
                m25052b(next.aHf, next.aHg, null);
                it.remove();
            }
        } catch (Throwable th) {
            C10331c.printStackTraceOnly(th);
        }
    }

    /* renamed from: b */
    private void m25052b(ExceptionMessage exceptionMessage, int i, @Nullable CountDownLatch countDownLatch) {
        if (exceptionMessage == null || !m25051c(exceptionMessage)) {
            return;
        }
        if (i == 3) {
            C10711a.m25060b(exceptionMessage);
        }
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(C10727c.m25022d(exceptionMessage));
        C10722b.m25028a(arrayList, countDownLatch);
    }

    /* renamed from: c */
    private boolean m25051c(ExceptionMessage exceptionMessage) {
        try {
            C10671e m25134Hu = C10671e.m25134Hu();
            if (m25134Hu.m25129Hz() != null && m25134Hu.m25130Hy() != 2) {
                List<C10654a> list = m25134Hu.m25129Hz().aFy;
                double d = m25134Hu.m25129Hz().aFb;
                String appId = m25134Hu.getAppId();
                String sdkVersion = m25134Hu.getSdkVersion();
                for (C10654a c10654a : list) {
                    if (c10654a != null && (C10739c.m25006b(c10654a.aEY) || c10654a.aEY.contains(appId))) {
                        if (C10739c.m25006b(c10654a.aEZ) || c10654a.aEZ.contains(sdkVersion)) {
                            if (C10739c.m25006b(c10654a.aFa) || m25053a(exceptionMessage.mCrashDetail, c10654a.aFa)) {
                                d = c10654a.aFb;
                            }
                        }
                    }
                }
                return Math.random() < d;
            }
            return true;
        } catch (Exception e) {
            C10331c.m26246w("BaseExceptionUploader", Log.getStackTraceString(e));
            return true;
        }
    }

    /* renamed from: a */
    public final void m25054a(ExceptionMessage exceptionMessage, int i, @Nullable CountDownLatch countDownLatch) {
        try {
            m25055HY();
            m25052b(exceptionMessage, i, countDownLatch);
        } catch (Throwable th) {
            C10331c.printStackTraceOnly(th);
            this.aHe.add(new C10714a(exceptionMessage, i));
            if (countDownLatch != null) {
                countDownLatch.countDown();
            }
        }
    }

    /* renamed from: a */
    private static boolean m25053a(String str, List<String> list) {
        for (String str2 : list) {
            if (str.contains(str2)) {
                return true;
            }
        }
        return false;
    }
}

package com.kwad.sdk.crash.report;

import android.util.Log;
import androidx.annotation.Nullable;
import com.kwad.sdk.crash.model.message.ExceptionMessage;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public abstract class c implements e {
    private ArrayList<a> aHe = new ArrayList<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public static class a {
        private ExceptionMessage aHf;
        private int aHg;

        a(ExceptionMessage exceptionMessage, int i4) {
            this.aHf = exceptionMessage;
            this.aHg = i4;
        }
    }

    private void HY() {
        if (this.aHe.isEmpty()) {
            return;
        }
        try {
            Iterator<a> it = this.aHe.iterator();
            while (it.hasNext()) {
                a next = it.next();
                b(next.aHf, next.aHg, null);
                it.remove();
            }
        } catch (Throwable th) {
            com.kwad.sdk.core.e.c.printStackTraceOnly(th);
        }
    }

    private void b(ExceptionMessage exceptionMessage, int i4, @Nullable CountDownLatch countDownLatch) {
        if (exceptionMessage == null || !c(exceptionMessage)) {
            return;
        }
        if (i4 == 3) {
            com.kwad.sdk.crash.report.a.b(exceptionMessage);
        }
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(com.kwad.sdk.crash.report.request.c.d(exceptionMessage));
        com.kwad.sdk.crash.report.request.b.a(arrayList, countDownLatch);
    }

    private boolean c(ExceptionMessage exceptionMessage) {
        try {
            com.kwad.sdk.crash.e Hu = com.kwad.sdk.crash.e.Hu();
            if (Hu.Hz() != null && Hu.Hy() != 2) {
                List<com.kwad.sdk.crash.a> list = Hu.Hz().aFy;
                double d4 = Hu.Hz().aFb;
                String appId = Hu.getAppId();
                String sdkVersion = Hu.getSdkVersion();
                for (com.kwad.sdk.crash.a aVar : list) {
                    if (aVar != null && (com.kwad.sdk.crash.utils.c.b(aVar.aEY) || aVar.aEY.contains(appId))) {
                        if (com.kwad.sdk.crash.utils.c.b(aVar.aEZ) || aVar.aEZ.contains(sdkVersion)) {
                            if (com.kwad.sdk.crash.utils.c.b(aVar.aFa) || a(exceptionMessage.mCrashDetail, aVar.aFa)) {
                                d4 = aVar.aFb;
                            }
                        }
                    }
                }
                return Math.random() < d4;
            }
            return true;
        } catch (Exception e4) {
            com.kwad.sdk.core.e.c.w("BaseExceptionUploader", Log.getStackTraceString(e4));
            return true;
        }
    }

    public final void a(ExceptionMessage exceptionMessage, int i4, @Nullable CountDownLatch countDownLatch) {
        try {
            HY();
            b(exceptionMessage, i4, countDownLatch);
        } catch (Throwable th) {
            com.kwad.sdk.core.e.c.printStackTraceOnly(th);
            this.aHe.add(new a(exceptionMessage, i4));
            if (countDownLatch != null) {
                countDownLatch.countDown();
            }
        }
    }

    private static boolean a(String str, List<String> list) {
        for (String str2 : list) {
            if (str.contains(str2)) {
                return true;
            }
        }
        return false;
    }
}

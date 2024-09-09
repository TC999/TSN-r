package com.kwad.sdk.core.threads;

import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class a {
    private static Map<String, WeakReference<C0701a>> aAu = new ConcurrentHashMap();

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* renamed from: com.kwad.sdk.core.threads.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public static class C0701a {
        private HandlerThread aAv;
        private Handler fS;

        public C0701a(String str) {
            String str2;
            if (TextUtils.isEmpty(str)) {
                str2 = "ksad-HT";
            } else {
                str2 = "ksad-" + str;
            }
            HandlerThread handlerThread = new HandlerThread(str2);
            this.aAv = handlerThread;
            handlerThread.start();
            this.fS = new Handler(this.aAv.getLooper());
        }

        public final Handler getHandler() {
            return this.fS;
        }
    }

    public static synchronized Handler Fy() {
        Handler handler;
        synchronized (a.class) {
            handler = es("commonHT").getHandler();
        }
        return handler;
    }

    public static synchronized Handler Fz() {
        Handler handler;
        synchronized (a.class) {
            handler = es("reportHT").getHandler();
        }
        return handler;
    }

    @NonNull
    private static C0701a es(String str) {
        WeakReference<C0701a> weakReference = aAu.get(str);
        if (weakReference != null && weakReference.get() != null) {
            return weakReference.get();
        }
        C0701a c0701a = new C0701a(str);
        aAu.put(str, new WeakReference<>(c0701a));
        return c0701a;
    }
}

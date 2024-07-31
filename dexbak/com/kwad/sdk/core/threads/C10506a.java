package com.kwad.sdk.core.threads;

import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.kwad.sdk.core.threads.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10506a {
    private static Map<String, WeakReference<C10507a>> aAu = new ConcurrentHashMap();

    /* renamed from: com.kwad.sdk.core.threads.a$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class C10507a {
        private HandlerThread aAv;

        /* renamed from: fS */
        private Handler f29587fS;

        public C10507a(String str) {
            String str2;
            if (TextUtils.isEmpty(str)) {
                str2 = "ksad-HT";
            } else {
                str2 = "ksad-" + str;
            }
            HandlerThread handlerThread = new HandlerThread(str2);
            this.aAv = handlerThread;
            handlerThread.start();
            this.f29587fS = new Handler(this.aAv.getLooper());
        }

        public final Handler getHandler() {
            return this.f29587fS;
        }
    }

    /* renamed from: Fy */
    public static synchronized Handler m25587Fy() {
        Handler handler;
        synchronized (C10506a.class) {
            handler = m25585es("commonHT").getHandler();
        }
        return handler;
    }

    /* renamed from: Fz */
    public static synchronized Handler m25586Fz() {
        Handler handler;
        synchronized (C10506a.class) {
            handler = m25585es("reportHT").getHandler();
        }
        return handler;
    }

    @NonNull
    /* renamed from: es */
    private static C10507a m25585es(String str) {
        WeakReference<C10507a> weakReference = aAu.get(str);
        if (weakReference != null && weakReference.get() != null) {
            return weakReference.get();
        }
        C10507a c10507a = new C10507a(str);
        aAu.put(str, new WeakReference<>(c10507a));
        return c10507a;
    }
}

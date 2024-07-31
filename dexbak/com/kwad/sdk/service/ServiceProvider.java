package com.kwad.sdk.service;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.components.offline.api.BuildConfig;
import com.kwad.sdk.api.SdkConfig;
import com.kwad.sdk.p434g.InterfaceC10761a;
import com.kwad.sdk.p445n.C10887l;
import com.kwad.sdk.service.p449a.InterfaceC10967e;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class ServiceProvider {

    /* renamed from: JC */
    private static List<Throwable> f29670JC;
    @SuppressLint({"StaticFieldLeak"})
    private static Context aNZ;
    @SuppressLint({"StaticFieldLeak"})
    private static Context aOa;
    private static SdkConfig aOb;
    private static boolean aOc;
    @SuppressLint({"StaticFieldLeak"})
    private static Context mContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public enum ServiceProviderDelegate {
        INSTANCE;
        
        private final Map<Class<?>, Object> mProviders = new HashMap(32);

        ServiceProviderDelegate() {
        }

        public final <T> T get(Class<T> cls) {
            return (T) this.mProviders.get(cls);
        }

        public final <T> void put(Class<T> cls, T t) {
            this.mProviders.put(cls, t);
        }
    }

    /* renamed from: KN */
    public static void m24364KN() {
        aOc = true;
    }

    @NonNull
    @Deprecated
    /* renamed from: KO */
    public static Context m24363KO() {
        return mContext;
    }

    @NonNull
    /* renamed from: KP */
    public static SdkConfig m24362KP() {
        return aOb;
    }

    /* renamed from: b */
    public static void m24361b(SdkConfig sdkConfig) {
        aOb = sdkConfig;
    }

    /* renamed from: bC */
    public static void m24359bC(Context context) {
        aNZ = context;
        mContext = C10887l.m24553dt(context);
    }

    /* renamed from: d */
    public static void m24358d(InterfaceC10761a<Throwable> interfaceC10761a) {
        List<Throwable> list = f29670JC;
        if (list == null) {
            return;
        }
        for (Throwable th : list) {
            interfaceC10761a.accept(th);
        }
        f29670JC.clear();
        f29670JC = null;
    }

    public static <T> T get(Class<T> cls) {
        return (T) ServiceProviderDelegate.INSTANCE.get(cls);
    }

    public static String getAppId() {
        return aOb.appId;
    }

    public static String getAppName() {
        return aOb.appName;
    }

    @NonNull
    public static Context getContext() {
        if (aOc) {
            return m24363KO();
        }
        if (aOa == null) {
            aOa = C10887l.wrapContextIfNeed(mContext);
        }
        return aOa;
    }

    public static String getSdkVersion() {
        return BuildConfig.VERSION_NAME;
    }

    public static <T> void put(Class<T> cls, T t) {
        ServiceProviderDelegate.INSTANCE.put(cls, t);
    }

    public static void reportSdkCaughtException(Throwable th) {
        InterfaceC10967e interfaceC10967e = (InterfaceC10967e) get(InterfaceC10967e.class);
        if (interfaceC10967e != null) {
            interfaceC10967e.gatherException(th);
        } else {
            m24360b(th);
        }
    }

    /* renamed from: b */
    private static void m24360b(Throwable th) {
        if (f29670JC == null) {
            f29670JC = new CopyOnWriteArrayList();
        }
        f29670JC.add(th);
    }
}

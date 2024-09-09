package com.kwad.sdk.n;

import android.content.Context;
import android.content.res.Resources;
import androidx.annotation.NonNull;
import com.acse.ottn.f3;
import com.kwad.sdk.api.core.IKsAdSDK;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.s;
import java.lang.reflect.Field;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class e {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final AtomicBoolean JB;
    private Resources aTd;
    private Resources aTe;
    private h aTf;
    private boolean aTg;
    private ClassLoader aTh;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public static class a {
        private static final e aTi = new e((byte) 0);
    }

    /* synthetic */ e(byte b4) {
        this();
    }

    public static e NV() {
        return a.aTi;
    }

    private boolean NW() {
        Context KO;
        Field[] declaredFields;
        Object a4;
        Field[] declaredFields2;
        try {
            KO = ServiceProvider.KO();
        } catch (Throwable th) {
            ((com.kwad.sdk.service.a.e) ServiceProvider.get(com.kwad.sdk.service.a.e.class)).gatherException(th);
        }
        if (!l.ds(KO)) {
            ((com.kwad.sdk.service.a.e) ServiceProvider.get(com.kwad.sdk.service.a.e.class)).gatherException(new IllegalArgumentException("KSPlugin unwrapContextIfNeed fail"));
            return false;
        }
        Class<?> cls = Class.forName("com.kwad.sdk.api.loader.Loader", false, getClass().getClassLoader());
        Object invoke = cls.getDeclaredMethod(f3.f5657f, new Class[0]).invoke(null, new Object[0]);
        for (Field field : cls.getDeclaredFields()) {
            if (field.getType() != IKsAdSDK.class && field.getType() != Context.class && field.getType() != AtomicBoolean.class && (a4 = s.a(field, invoke)) != null) {
                for (Field field2 : a4.getClass().getDeclaredFields()) {
                    if (field2.getType() == Resources.class) {
                        field2.setAccessible(true);
                        Resources resources = (Resources) field2.get(a4);
                        Resources resources2 = KO.getResources();
                        h hVar = new h(resources, resources2);
                        s.a(field2, a4, hVar);
                        this.aTd = resources2;
                        this.aTe = resources;
                        this.aTf = hVar;
                        return true;
                    }
                }
                continue;
            }
        }
        return false;
    }

    private static boolean yQ() {
        return ((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).yQ();
    }

    private static boolean yR() {
        return ((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).yR();
    }

    public final boolean MA() {
        return this.JB.get();
    }

    public final ClassLoader getClassLoader() {
        return this.aTh;
    }

    public final Resources getResources() {
        return this.aTf;
    }

    public final void init() {
        if (this.JB.get()) {
            return;
        }
        try {
            if (((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).yp()) {
                if (yQ() && NW()) {
                    this.aTh = getClass().getClassLoader();
                    i.cj(yR());
                    com.kwad.sdk.core.e.c.d("KSDY/KSPlugin", toString());
                    this.aTg = true;
                } else {
                    this.aTg = false;
                }
            }
        } catch (Throwable th) {
            ((com.kwad.sdk.service.a.e) ServiceProvider.get(com.kwad.sdk.service.a.e.class)).gatherException(th);
        }
        this.JB.set(true);
    }

    @NonNull
    public String toString() {
        return "KSPlugin{mHostResources=" + this.aTd + ", mResResources=" + this.aTe + ", mPluginResources=" + this.aTf + ", mEnable=" + this.aTg + '}';
    }

    private e() {
        this.JB = new AtomicBoolean(false);
    }
}

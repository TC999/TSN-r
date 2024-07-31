package com.kwad.sdk.p445n;

import android.content.Context;
import android.content.res.Resources;
import androidx.annotation.NonNull;
import com.kwad.sdk.api.core.IKsAdSDK;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.p449a.InterfaceC10967e;
import com.kwad.sdk.service.p449a.InterfaceC10968f;
import com.kwad.sdk.service.p449a.InterfaceC10970h;
import com.kwad.sdk.utils.C11124s;
import java.lang.reflect.Field;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.kwad.sdk.n.e */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C10873e {
    static final /* synthetic */ boolean $assertionsDisabled = false;

    /* renamed from: JB */
    private final AtomicBoolean f29665JB;
    private Resources aTd;
    private Resources aTe;
    private C10877h aTf;
    private boolean aTg;
    private ClassLoader aTh;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.kwad.sdk.n.e$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class C10874a {
        private static final C10873e aTi = new C10873e((byte) 0);
    }

    /* synthetic */ C10873e(byte b) {
        this();
    }

    /* renamed from: NV */
    public static C10873e m24602NV() {
        return C10874a.aTi;
    }

    /* renamed from: NW */
    private boolean m24601NW() {
        Context m24363KO;
        Field[] declaredFields;
        Object m23704a;
        Field[] declaredFields2;
        try {
            m24363KO = ServiceProvider.m24363KO();
        } catch (Throwable th) {
            ((InterfaceC10967e) ServiceProvider.get(InterfaceC10967e.class)).gatherException(th);
        }
        if (!C10887l.m24554ds(m24363KO)) {
            ((InterfaceC10967e) ServiceProvider.get(InterfaceC10967e.class)).gatherException(new IllegalArgumentException("KSPlugin unwrapContextIfNeed fail"));
            return false;
        }
        Class<?> cls = Class.forName("com.kwad.sdk.api.loader.Loader", false, getClass().getClassLoader());
        Object invoke = cls.getDeclaredMethod("get", new Class[0]).invoke(null, new Object[0]);
        for (Field field : cls.getDeclaredFields()) {
            if (field.getType() != IKsAdSDK.class && field.getType() != Context.class && field.getType() != AtomicBoolean.class && (m23704a = C11124s.m23704a(field, invoke)) != null) {
                for (Field field2 : m23704a.getClass().getDeclaredFields()) {
                    if (field2.getType() == Resources.class) {
                        field2.setAccessible(true);
                        Resources resources = (Resources) field2.get(m23704a);
                        Resources resources2 = m24363KO.getResources();
                        C10877h c10877h = new C10877h(resources, resources2);
                        C11124s.m23703a(field2, m23704a, c10877h);
                        this.aTd = resources2;
                        this.aTe = resources;
                        this.aTf = c10877h;
                        return true;
                    }
                }
                continue;
            }
        }
        return false;
    }

    /* renamed from: yQ */
    private static boolean m24600yQ() {
        return ((InterfaceC10970h) ServiceProvider.get(InterfaceC10970h.class)).mo24307yQ();
    }

    /* renamed from: yR */
    private static boolean m24599yR() {
        return ((InterfaceC10970h) ServiceProvider.get(InterfaceC10970h.class)).mo24306yR();
    }

    /* renamed from: MA */
    public final boolean m24603MA() {
        return this.f29665JB.get();
    }

    public final ClassLoader getClassLoader() {
        return this.aTh;
    }

    public final Resources getResources() {
        return this.aTf;
    }

    public final void init() {
        if (this.f29665JB.get()) {
            return;
        }
        try {
            if (((InterfaceC10968f) ServiceProvider.get(InterfaceC10968f.class)).mo24339yp()) {
                if (m24600yQ() && m24601NW()) {
                    this.aTh = getClass().getClassLoader();
                    C10878i.m24592cj(m24599yR());
                    C10331c.m26254d("KSDY/KSPlugin", toString());
                    this.aTg = true;
                } else {
                    this.aTg = false;
                }
            }
        } catch (Throwable th) {
            ((InterfaceC10967e) ServiceProvider.get(InterfaceC10967e.class)).gatherException(th);
        }
        this.f29665JB.set(true);
    }

    @NonNull
    public String toString() {
        return "KSPlugin{mHostResources=" + this.aTd + ", mResResources=" + this.aTe + ", mPluginResources=" + this.aTf + ", mEnable=" + this.aTg + '}';
    }

    private C10873e() {
        this.f29665JB = new AtomicBoolean(false);
    }
}

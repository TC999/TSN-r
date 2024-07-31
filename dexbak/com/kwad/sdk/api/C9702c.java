package com.kwad.sdk.api;

import androidx.annotation.Nullable;
import com.kwad.sdk.api.core.IKsAdSDK;
import com.kwad.sdk.api.p367a.AbstractRunnableC9699a;
import com.kwad.sdk.api.p367a.C9700b;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* renamed from: com.kwad.sdk.api.c */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9702c {

    /* renamed from: JC */
    private static List<Throwable> f29507JC;
    private static IKsAdSDK alV;

    /* renamed from: a */
    public static void m28020a(IKsAdSDK iKsAdSDK) {
        alV = iKsAdSDK;
    }

    /* renamed from: b */
    private static void m28019b(Throwable th) {
        try {
            if (f29507JC == null) {
                f29507JC = new CopyOnWriteArrayList();
            }
            f29507JC.add(th);
        } catch (Throwable unused) {
        }
    }

    /* renamed from: ca */
    public static String m28018ca(String str) {
        return (String) m28017f("TRANSFORM_API_HOST", str);
    }

    @Nullable
    /* renamed from: f */
    public static <T> T m28017f(String str, Object... objArr) {
        try {
            T t = (T) alV.mo28008dM(str, objArr);
            if (t != null) {
                return t;
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    /* renamed from: m */
    public static void m28016m(Throwable th) {
        try {
            if (alV != null && KsAdSDK.haseInit()) {
                alV.mo28007re(th);
            } else {
                m28019b(th);
            }
        } catch (Throwable unused) {
        }
    }

    /* renamed from: mQ */
    public static void m28015mQ() {
        try {
            C9700b.m28021a(new AbstractRunnableC9699a() { // from class: com.kwad.sdk.api.c.1
                @Override // com.kwad.sdk.api.p367a.AbstractRunnableC9699a
                public final void doTask() {
                    try {
                        if (C9702c.f29507JC == null) {
                            return;
                        }
                        for (Throwable th : C9702c.f29507JC) {
                            if (C9702c.alV != null && KsAdSDK.haseInit()) {
                                C9702c.alV.mo28007re(th);
                            }
                        }
                        C9702c.f29507JC.clear();
                        C9702c.m28014s(null);
                    } catch (Throwable unused) {
                    }
                }
            });
        } catch (Throwable unused) {
        }
    }

    /* renamed from: s */
    static /* synthetic */ List m28014s(List list) {
        f29507JC = null;
        return null;
    }

    /* renamed from: zV */
    public static IKsAdSDK m28013zV() {
        return alV;
    }

    /* renamed from: zW */
    public static boolean m28012zW() {
        Boolean bool = (Boolean) m28017f("enableDynamic", new Object[0]);
        return (bool == null || bool.booleanValue()) ? false : true;
    }

    /* renamed from: zX */
    public static int m28011zX() {
        Integer num = (Integer) m28017f("getAutoRevertTime", new Object[0]);
        if (num != null) {
            return num.intValue();
        }
        return -1;
    }
}

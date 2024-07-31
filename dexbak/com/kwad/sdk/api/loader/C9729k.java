package com.kwad.sdk.api.loader;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.kwad.sdk.api.C9702c;
import com.kwad.sdk.api.core.IKsAdSDK;
import java.io.File;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.kwad.sdk.api.loader.k */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9729k {
    private final String amA;
    private final String amB;
    private final String amC;
    private Resources amD;
    private ClassLoader amE;
    private IKsAdSDK amF;

    private C9729k(String str, String str2, String str3) {
        this.amA = str;
        this.amB = str2;
        this.amC = str3;
    }

    /* renamed from: Ag */
    private void m27891Ag() {
        if (!TextUtils.isEmpty(this.amA)) {
            File file = new File(this.amA);
            if (!file.isFile() || !file.exists()) {
                throw new RuntimeException("mApk not a file");
            }
            return;
        }
        throw new RuntimeException("mApk is null");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static synchronized C9729k m27889a(Context context, ClassLoader classLoader, String str) {
        C9729k m27888b;
        synchronized (C9729k.class) {
            try {
                m27888b = m27888b(context, classLoader, C9724h.m27922s(context, str), C9724h.m27921t(context, str), C9724h.m27920u(context, str));
            } catch (Throwable th) {
                C9702c.m28016m(th);
                return null;
            }
        }
        return m27888b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public static C9729k m27888b(Context context, ClassLoader classLoader, String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str)) {
            File file = new File(str);
            if (file.exists() && file.isFile()) {
                C9729k c9729k = new C9729k(str, str2, str3);
                c9729k.m27890a(context, classLoader);
                return c9729k;
            }
            throw new RuntimeException("mApk not a file");
        }
        throw new RuntimeException("mApk is null");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: Ae */
    public final Resources m27893Ae() {
        return this.amD;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: Af */
    public final IKsAdSDK m27892Af() {
        return this.amF;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final ClassLoader getClassLoader() {
        return this.amE;
    }

    public final String toString() {
        return "ExternalPackage{mApk='" + this.amA + "', mDexDir='" + this.amB + "', mNativeLibDir='" + this.amC + "', mResource=" + this.amD + ", mClassLoader=" + this.amE + ", mKsSdk=" + this.amF + '}';
    }

    /* renamed from: a */
    private void m27890a(Context context, ClassLoader classLoader) {
        m27891Ag();
        Resources m27877a = C9748q.m27877a(context, context.getResources(), this.amA);
        ClassLoader m27945a = C9719e.m27945a(context, classLoader, this.amA, this.amB, this.amC);
        IKsAdSDK m28004a = Loader.m28004a(m27945a);
        this.amD = m27877a;
        this.amE = m27945a;
        this.amF = m28004a;
        int sDKType = m28004a.getSDKType();
        if (sDKType == 1) {
            return;
        }
        throw new RuntimeException("sdkType error apiType: 1 , sdkType:" + sDKType);
    }
}

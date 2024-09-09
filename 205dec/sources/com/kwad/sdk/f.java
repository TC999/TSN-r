package com.kwad.sdk;

import androidx.annotation.NonNull;
import com.kwad.sdk.components.DevelopMangerComponents;
import com.kwad.sdk.export.proxy.AdHttpProxy;
import java.util.Random;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class f {
    private static AdHttpProxy akE;

    /* renamed from: com.kwad.sdk.f$1  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\6206960.dex */
    final class AnonymousClass1 implements com.kwad.sdk.f.a {
        final /* synthetic */ long alx;

        AnonymousClass1(long j4) {
            this.alx = j4;
        }

        public final void accept(Object obj) {
            m.ac(this.alx);
        }
    }

    /* renamed from: com.kwad.sdk.f$2  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\6206960.dex */
    final class AnonymousClass2 implements com.kwad.sdk.f.a {
        final /* synthetic */ long Mt;

        AnonymousClass2(long j4) {
            this.Mt = j4;
        }

        public final void accept(Object obj) {
            m.ad(this.Mt);
        }
    }

    /* renamed from: com.kwad.sdk.f$3  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\6206960.dex */
    final class AnonymousClass3 implements com.kwad.sdk.f.a {
        final /* synthetic */ long alx;

        AnonymousClass3(long j4) {
            this.alx = j4;
        }

        public final void accept(Object obj) {
            m.af(this.alx);
        }
    }

    /* renamed from: com.kwad.sdk.f$4  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\6206960.dex */
    final class AnonymousClass4 implements com.kwad.sdk.f.a {
        final /* synthetic */ long Mt;

        AnonymousClass4(long j4) {
            this.Mt = j4;
        }

        public final void accept(Object obj) {
            m.ag(this.Mt);
        }
    }

    @NonNull
    public static AdHttpProxy xT() {
        AdHttpProxy adHttpProxy = akE;
        if (adHttpProxy != null) {
            return adHttpProxy;
        }
        if (com.kwad.framework.a.a.md.booleanValue()) {
            return xU();
        }
        try {
            if (com.kwad.sdk.core.network.a.c.DS() != null) {
                akE = new com.kwad.sdk.core.network.c.b();
            } else {
                akE = new com.kwad.sdk.core.network.c.a();
            }
        } catch (Throwable unused) {
            akE = new com.kwad.sdk.core.network.c.a();
        }
        return akE;
    }

    private static AdHttpProxy xU() {
        com.kwad.sdk.components.c.f(DevelopMangerComponents.class);
        return new Random().nextInt(5) != 0 ? new com.kwad.sdk.core.network.c.b() : new com.kwad.sdk.core.network.c.a();
    }
}

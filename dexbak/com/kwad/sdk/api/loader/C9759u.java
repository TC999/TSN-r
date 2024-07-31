package com.kwad.sdk.api.loader;

import android.content.Context;
import android.text.TextUtils;
import com.kwad.sdk.api.C9702c;
import com.kwad.sdk.api.core.IKsAdSDK;
import com.kwad.sdk.api.loader.C9731m;
import com.kwad.sdk.api.p367a.AbstractRunnableC9699a;
import com.kwad.sdk.api.p367a.C9700b;
import com.umeng.analytics.pro.UMCommonContent;
import java.util.concurrent.atomic.AtomicBoolean;
import p011a.R8$$SyntheticClass;

/* renamed from: com.kwad.sdk.api.loader.u */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9759u {
    private static final AtomicBoolean ank = new AtomicBoolean();

    /* renamed from: Al */
    private static String m27839Al() {
        String m28018ca = C9702c.m28018ca("https://open.e.kuaishou.com/rest/e/v3/open/sdk2");
        return !TextUtils.isEmpty(m28018ca) ? m28018ca : "https://open.e.kuaishou.com/rest/e/v3/open/sdk2";
    }

    /* renamed from: a */
    public static void m27838a(final Context context, final IKsAdSDK iKsAdSDK) {
        if (C9702c.m28012zW()) {
            return;
        }
        AtomicBoolean atomicBoolean = ank;
        if (atomicBoolean.get() || context == null || iKsAdSDK == null) {
            return;
        }
        atomicBoolean.set(true);
        C9700b.m28021a(new AbstractRunnableC9699a() { // from class: com.kwad.sdk.api.loader.u.1
            @Override // com.kwad.sdk.api.p367a.AbstractRunnableC9699a
            public final void doTask() {
                try {
                    if (Math.abs(System.currentTimeMillis() - C9757t.m27840x(context, "lastUpdateTime")) < C9757t.m27840x(context, UMCommonContent.f37794aX) * 1000) {
                        return;
                    }
                    C9731m.m27887Aj().mo27880a(new InterfaceC9763v() { // from class: com.kwad.sdk.api.loader.u.1.1
                        @Override // com.kwad.sdk.api.loader.InterfaceC9763v
                        /* renamed from: Am */
                        public final String mo27834Am() {
                            return C9759u.access$000();
                        }

                        @Override // com.kwad.sdk.api.loader.InterfaceC9763v
                        /* renamed from: An */
                        public final IKsAdSDK mo27833An() {
                            return iKsAdSDK;
                        }

                        @Override // com.kwad.sdk.api.loader.InterfaceC9763v
                        public final Context getContext() {
                            return context;
                        }
                    }, new C9731m.InterfaceC9735c<Boolean>() { // from class: com.kwad.sdk.api.loader.u.1.2
                        /* renamed from: c */
                        private static void m27836c(Boolean bool) {
                            R8$$SyntheticClass.m60055a(bool);
                        }

                        @Override // com.kwad.sdk.api.loader.C9731m.InterfaceC9735c
                        /* renamed from: g */
                        public final /* synthetic */ void mo27835g(Boolean bool) {
                            m27836c(bool);
                        }
                    });
                } catch (Throwable unused) {
                }
            }
        });
    }

    /* renamed from: aF */
    public static void m27837aF(Context context) {
        C9723g.m27932m(context, "");
    }

    static /* synthetic */ String access$000() {
        return m27839Al();
    }
}

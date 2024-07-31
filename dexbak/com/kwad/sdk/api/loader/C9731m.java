package com.kwad.sdk.api.loader;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.kwad.sdk.api.C9702c;
import com.kwad.sdk.api.loader.C9712a;
import com.kwad.sdk.api.loader.C9721f;
import com.umeng.analytics.pro.UMCommonContent;
import java.io.File;
import p011a.R8$$SyntheticClass;

/* renamed from: com.kwad.sdk.api.loader.m */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
final class C9731m {

    /* renamed from: com.kwad.sdk.api.loader.m$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    static abstract class AbstractC9732a<T> implements InterfaceC9735c<T> {
        InterfaceC9735c<T> amJ;

        AbstractC9732a(InterfaceC9735c<T> interfaceC9735c) {
            this.amJ = interfaceC9735c;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.kwad.sdk.api.loader.m$b */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class C9733b implements InterfaceC9740f<C9712a.C9713a> {
        C9733b() {
        }

        @Override // com.kwad.sdk.api.loader.C9731m.InterfaceC9740f
        /* renamed from: a */
        public final void mo27880a(final InterfaceC9763v interfaceC9763v, final InterfaceC9735c<C9712a.C9713a> interfaceC9735c) {
            try {
                new C9721f(interfaceC9763v).m27942a(new C9721f.InterfaceC9722a() { // from class: com.kwad.sdk.api.loader.m.b.1
                    @Override // com.kwad.sdk.api.loader.C9721f.InterfaceC9722a
                    @WorkerThread
                    /* renamed from: a */
                    public final void mo27886a(C9712a.C9714b c9714b) {
                        R8$$SyntheticClass.m60055a(c9714b);
                        if (c9714b.m27955Ac()) {
                            interfaceC9735c.mo27835g(c9714b.ama);
                        } else {
                            new RuntimeException("UpdateData is illegal");
                        }
                        try {
                            C9718d.m27947ay(interfaceC9763v.getContext()).cancel();
                        } catch (Throwable unused) {
                        }
                    }
                });
            } catch (Exception unused) {
            }
        }
    }

    /* renamed from: com.kwad.sdk.api.loader.m$c */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public interface InterfaceC9735c<T> {
        /* renamed from: g */
        void mo27835g(T t);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.kwad.sdk.api.loader.m$d */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class C9736d implements InterfaceC9740f<C9712a.C9713a> {
        InterfaceC9740f<C9712a.C9713a> amN;

        C9736d(InterfaceC9740f<C9712a.C9713a> interfaceC9740f) {
            this.amN = interfaceC9740f;
        }

        @Override // com.kwad.sdk.api.loader.C9731m.InterfaceC9740f
        /* renamed from: a */
        public final void mo27880a(final InterfaceC9763v interfaceC9763v, final InterfaceC9735c<C9712a.C9713a> interfaceC9735c) {
            this.amN.mo27880a(interfaceC9763v, new AbstractC9732a<C9712a.C9713a>(interfaceC9735c) { // from class: com.kwad.sdk.api.loader.m.d.1
                /* JADX INFO: Access modifiers changed from: private */
                @Override // com.kwad.sdk.api.loader.C9731m.InterfaceC9735c
                @WorkerThread
                /* renamed from: c */
                public void mo27835g(@NonNull C9712a.C9713a c9713a) {
                    long currentTimeMillis = System.currentTimeMillis();
                    File file = null;
                    try {
                        C9727j.m27915a(c9713a);
                        file = C9724h.m27925p(interfaceC9763v.getContext(), c9713a.sdkVersion);
                        C9726i.m27918c(c9713a.alX, file);
                        C9727j.m27913a(c9713a, System.currentTimeMillis() - currentTimeMillis);
                        c9713a.alY = file;
                        interfaceC9735c.mo27835g(c9713a);
                    } catch (Throwable th) {
                        C9727j.m27912a(c9713a, System.currentTimeMillis() - currentTimeMillis, Log.getStackTraceString(th));
                        C9724h.m27926j(file);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.kwad.sdk.api.loader.m$e */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class C9738e implements InterfaceC9740f<Boolean> {
        InterfaceC9740f<C9712a.C9713a> amN;

        C9738e(InterfaceC9740f<C9712a.C9713a> interfaceC9740f) {
            this.amN = interfaceC9740f;
        }

        @Override // com.kwad.sdk.api.loader.C9731m.InterfaceC9740f
        /* renamed from: a */
        public final void mo27880a(final InterfaceC9763v interfaceC9763v, final InterfaceC9735c<Boolean> interfaceC9735c) {
            this.amN.mo27880a(interfaceC9763v, new InterfaceC9735c<C9712a.C9713a>() { // from class: com.kwad.sdk.api.loader.m.e.1
                /* renamed from: a */
                private void m27884a(C9712a.C9713a c9713a, int i, Throwable th) {
                    C9724h.m27926j(c9713a.alY);
                    C9727j.m27910b(c9713a, i, Log.getStackTraceString(th));
                }

                /* JADX INFO: Access modifiers changed from: private */
                @Override // com.kwad.sdk.api.loader.C9731m.InterfaceC9735c
                /* renamed from: c */
                public void mo27835g(@NonNull C9712a.C9713a c9713a) {
                    long currentTimeMillis = System.currentTimeMillis();
                    try {
                        C9727j.m27911b(c9713a);
                        if (!C9715b.m27952a(interfaceC9763v.getContext(), C97391.class.getClassLoader(), c9713a.alY.getPath(), c9713a.sdkVersion)) {
                            m27884a(c9713a, 1, new RuntimeException("Apk pre install fail"));
                            return;
                        }
                        C9723g.m27931n(interfaceC9763v.getContext(), c9713a.sdkVersion);
                        C9724h.m27926j(c9713a.alY);
                        C9727j.m27909b(c9713a, System.currentTimeMillis() - currentTimeMillis);
                        interfaceC9735c.mo27835g(Boolean.TRUE);
                    } catch (Throwable th) {
                        m27884a(c9713a, 2, th);
                    }
                }
            });
        }
    }

    /* renamed from: com.kwad.sdk.api.loader.m$f */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public interface InterfaceC9740f<T> {
        /* renamed from: a */
        void mo27880a(InterfaceC9763v interfaceC9763v, InterfaceC9735c<T> interfaceC9735c);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.kwad.sdk.api.loader.m$g */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class C9741g implements InterfaceC9740f<C9712a.C9713a> {
        InterfaceC9740f<C9712a.C9713a> amN;

        C9741g(InterfaceC9740f<C9712a.C9713a> interfaceC9740f) {
            this.amN = interfaceC9740f;
        }

        @Override // com.kwad.sdk.api.loader.C9731m.InterfaceC9740f
        /* renamed from: a */
        public final void mo27880a(InterfaceC9763v interfaceC9763v, final InterfaceC9735c<C9712a.C9713a> interfaceC9735c) {
            this.amN.mo27880a(interfaceC9763v, new AbstractC9732a<C9712a.C9713a>(interfaceC9735c) { // from class: com.kwad.sdk.api.loader.m.g.1
                /* renamed from: a */
                private void m27882a(C9712a.C9713a c9713a, int i, Throwable th) {
                    C9724h.m27926j(c9713a.alY);
                    C9727j.m27914a(c9713a, i, th.getMessage());
                }

                /* JADX INFO: Access modifiers changed from: private */
                @Override // com.kwad.sdk.api.loader.C9731m.InterfaceC9735c
                /* renamed from: c */
                public void mo27835g(@NonNull C9712a.C9713a c9713a) {
                    try {
                        File file = c9713a.alY;
                        if (!C9755r.m27849k(file)) {
                            m27882a(c9713a, 1, new RuntimeException("Security checkFileValid fail"));
                        } else if (!C9755r.m27850a(file, c9713a.md5)) {
                            m27882a(c9713a, 2, new RuntimeException("Security checkMd5 fail"));
                        } else {
                            interfaceC9735c.mo27835g(c9713a);
                        }
                    } catch (Throwable th) {
                        m27882a(c9713a, 3, th);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.kwad.sdk.api.loader.m$h */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class C9743h implements InterfaceC9740f<C9712a.C9713a> {
        InterfaceC9740f<C9712a.C9713a> amN;

        C9743h(InterfaceC9740f<C9712a.C9713a> interfaceC9740f) {
            this.amN = interfaceC9740f;
        }

        @Override // com.kwad.sdk.api.loader.C9731m.InterfaceC9740f
        /* renamed from: a */
        public final void mo27880a(final InterfaceC9763v interfaceC9763v, final InterfaceC9735c<C9712a.C9713a> interfaceC9735c) {
            this.amN.mo27880a(interfaceC9763v, new InterfaceC9735c<C9712a.C9713a>() { // from class: com.kwad.sdk.api.loader.m.h.1
                /* JADX INFO: Access modifiers changed from: private */
                @Override // com.kwad.sdk.api.loader.C9731m.InterfaceC9735c
                /* renamed from: c */
                public void mo27835g(C9712a.C9713a c9713a) {
                    String m27934az = C9723g.m27934az(interfaceC9763v.getContext());
                    if (TextUtils.isEmpty(m27934az)) {
                        m27934az = C9702c.m28013zV().getSDKVersion();
                    }
                    String str = c9713a.sdkVersion;
                    C9757t.m27846a(interfaceC9763v.getContext(), UMCommonContent.f37794aX, c9713a.interval);
                    C9757t.m27846a(interfaceC9763v.getContext(), "lastUpdateTime", System.currentTimeMillis());
                    if (c9713a.m27956Ab()) {
                        C9759u.m27837aF(interfaceC9763v.getContext());
                        new RuntimeException("DynamicType == -1, curVersion: " + m27934az);
                    } else if (C9723g.m27937K(c9713a.sdkVersion, m27934az) && c9713a.m27957Aa()) {
                        interfaceC9735c.mo27835g(c9713a);
                    } else {
                        new RuntimeException("No new sdkVersion. remote sdkVersion:" + c9713a.sdkVersion + " currentDynamicVersion:" + m27934az + " dynamicType:" + c9713a.alW);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: Aj */
    public static InterfaceC9740f<Boolean> m27887Aj() {
        return new C9738e(new C9741g(new C9736d(new C9743h(new C9733b()))));
    }
}

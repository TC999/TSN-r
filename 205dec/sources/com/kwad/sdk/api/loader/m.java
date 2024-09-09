package com.kwad.sdk.api.loader;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.kwad.sdk.api.loader.a;
import com.kwad.sdk.api.loader.f;
import java.io.File;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
final class m {

    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    static abstract class a<T> implements c<T> {
        c<T> amJ;

        a(c<T> cVar) {
            this.amJ = cVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public static class b implements f<a.C0681a> {
        b() {
        }

        @Override // com.kwad.sdk.api.loader.m.f
        public final void a(final v vVar, final c<a.C0681a> cVar) {
            try {
                new com.kwad.sdk.api.loader.f(vVar).a(new f.a() { // from class: com.kwad.sdk.api.loader.m.b.1
                    @Override // com.kwad.sdk.api.loader.f.a
                    @WorkerThread
                    public final void a(a.b bVar) {
                        a.a.a(bVar);
                        if (bVar.Ac()) {
                            cVar.g(bVar.ama);
                        } else {
                            new RuntimeException("UpdateData is illegal");
                        }
                        try {
                            com.kwad.sdk.api.loader.d.ay(vVar.getContext()).cancel();
                        } catch (Throwable unused) {
                        }
                    }
                });
            } catch (Exception unused) {
            }
        }
    }

    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public interface c<T> {
        void g(T t3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public static class d implements f<a.C0681a> {
        f<a.C0681a> amN;

        d(f<a.C0681a> fVar) {
            this.amN = fVar;
        }

        @Override // com.kwad.sdk.api.loader.m.f
        public final void a(final v vVar, final c<a.C0681a> cVar) {
            this.amN.a(vVar, new a<a.C0681a>(cVar) { // from class: com.kwad.sdk.api.loader.m.d.1
                /* JADX INFO: Access modifiers changed from: private */
                @Override // com.kwad.sdk.api.loader.m.c
                @WorkerThread
                /* renamed from: c */
                public void g(@NonNull a.C0681a c0681a) {
                    long currentTimeMillis = System.currentTimeMillis();
                    File file = null;
                    try {
                        j.a(c0681a);
                        file = com.kwad.sdk.api.loader.h.p(vVar.getContext(), c0681a.sdkVersion);
                        i.c(c0681a.alX, file);
                        j.a(c0681a, System.currentTimeMillis() - currentTimeMillis);
                        c0681a.alY = file;
                        cVar.g(c0681a);
                    } catch (Throwable th) {
                        j.a(c0681a, System.currentTimeMillis() - currentTimeMillis, Log.getStackTraceString(th));
                        com.kwad.sdk.api.loader.h.j(file);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public static class e implements f<Boolean> {
        f<a.C0681a> amN;

        e(f<a.C0681a> fVar) {
            this.amN = fVar;
        }

        @Override // com.kwad.sdk.api.loader.m.f
        public final void a(final v vVar, final c<Boolean> cVar) {
            this.amN.a(vVar, new c<a.C0681a>() { // from class: com.kwad.sdk.api.loader.m.e.1
                private void a(a.C0681a c0681a, int i4, Throwable th) {
                    com.kwad.sdk.api.loader.h.j(c0681a.alY);
                    j.b(c0681a, i4, Log.getStackTraceString(th));
                }

                /* JADX INFO: Access modifiers changed from: private */
                @Override // com.kwad.sdk.api.loader.m.c
                /* renamed from: c */
                public void g(@NonNull a.C0681a c0681a) {
                    long currentTimeMillis = System.currentTimeMillis();
                    try {
                        j.b(c0681a);
                        if (!com.kwad.sdk.api.loader.b.a(vVar.getContext(), AnonymousClass1.class.getClassLoader(), c0681a.alY.getPath(), c0681a.sdkVersion)) {
                            a(c0681a, 1, new RuntimeException("Apk pre install fail"));
                            return;
                        }
                        com.kwad.sdk.api.loader.g.n(vVar.getContext(), c0681a.sdkVersion);
                        com.kwad.sdk.api.loader.h.j(c0681a.alY);
                        j.b(c0681a, System.currentTimeMillis() - currentTimeMillis);
                        cVar.g(Boolean.TRUE);
                    } catch (Throwable th) {
                        a(c0681a, 2, th);
                    }
                }
            });
        }
    }

    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public interface f<T> {
        void a(v vVar, c<T> cVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public static class g implements f<a.C0681a> {
        f<a.C0681a> amN;

        g(f<a.C0681a> fVar) {
            this.amN = fVar;
        }

        @Override // com.kwad.sdk.api.loader.m.f
        public final void a(v vVar, final c<a.C0681a> cVar) {
            this.amN.a(vVar, new a<a.C0681a>(cVar) { // from class: com.kwad.sdk.api.loader.m.g.1
                private void a(a.C0681a c0681a, int i4, Throwable th) {
                    com.kwad.sdk.api.loader.h.j(c0681a.alY);
                    j.a(c0681a, i4, th.getMessage());
                }

                /* JADX INFO: Access modifiers changed from: private */
                @Override // com.kwad.sdk.api.loader.m.c
                /* renamed from: c */
                public void g(@NonNull a.C0681a c0681a) {
                    try {
                        File file = c0681a.alY;
                        if (!r.k(file)) {
                            a(c0681a, 1, new RuntimeException("Security checkFileValid fail"));
                        } else if (!r.a(file, c0681a.md5)) {
                            a(c0681a, 2, new RuntimeException("Security checkMd5 fail"));
                        } else {
                            cVar.g(c0681a);
                        }
                    } catch (Throwable th) {
                        a(c0681a, 3, th);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public static class h implements f<a.C0681a> {
        f<a.C0681a> amN;

        h(f<a.C0681a> fVar) {
            this.amN = fVar;
        }

        @Override // com.kwad.sdk.api.loader.m.f
        public final void a(final v vVar, final c<a.C0681a> cVar) {
            this.amN.a(vVar, new c<a.C0681a>() { // from class: com.kwad.sdk.api.loader.m.h.1
                /* JADX INFO: Access modifiers changed from: private */
                @Override // com.kwad.sdk.api.loader.m.c
                /* renamed from: c */
                public void g(a.C0681a c0681a) {
                    String az = com.kwad.sdk.api.loader.g.az(vVar.getContext());
                    if (TextUtils.isEmpty(az)) {
                        az = com.kwad.sdk.api.c.zV().getSDKVersion();
                    }
                    String str = c0681a.sdkVersion;
                    t.a(vVar.getContext(), "interval", c0681a.interval);
                    t.a(vVar.getContext(), "lastUpdateTime", System.currentTimeMillis());
                    if (c0681a.Ab()) {
                        u.aF(vVar.getContext());
                        new RuntimeException("DynamicType == -1, curVersion: " + az);
                    } else if (com.kwad.sdk.api.loader.g.K(c0681a.sdkVersion, az) && c0681a.Aa()) {
                        cVar.g(c0681a);
                    } else {
                        new RuntimeException("No new sdkVersion. remote sdkVersion:" + c0681a.sdkVersion + " currentDynamicVersion:" + az + " dynamicType:" + c0681a.alW);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static f<Boolean> Aj() {
        return new e(new g(new d(new h(new b()))));
    }
}

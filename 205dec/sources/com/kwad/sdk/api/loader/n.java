package com.kwad.sdk.api.loader;

import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.Log;
import android.view.ContextThemeWrapper;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.amap.api.col.p0003l.f4;
import com.kwad.sdk.api.core.ResContext;
import com.kwad.sdk.api.loader.a;
import com.kwad.sdk.api.loader.g;
import java.io.File;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class n extends ContextThemeWrapper implements ResContext {
    private final ContextThemeWrapper aiO;
    private Resources.Theme aiP;
    private int aiQ;

    /* loaded from: E:\TSN-r\205dec\6241084.dex */
    static abstract class a<T> implements c<T> {
        c<T> aod;

        a(c<T> cVar) {
            this.aod = cVar;
        }
    }

    /* loaded from: E:\TSN-r\205dec\6241084.dex */
    static class b implements f<a.C0681a> {
        b() {
        }

        @Override // com.kwad.sdk.api.loader.n.f
        public final void a(final v vVar, final c<a.C0681a> cVar) {
            try {
                new com.kwad.sdk.api.loader.g(vVar).a(new g.a() { // from class: com.kwad.sdk.api.loader.n.b.1
                    @Override // com.kwad.sdk.api.loader.g.a
                    @WorkerThread
                    public final void a(a.b bVar) {
                        f4.a(bVar);
                        if (bVar.AK()) {
                            cVar.i(bVar.anc);
                        } else {
                            new RuntimeException("UpdateData is illegal");
                        }
                        try {
                            com.kwad.sdk.api.loader.e.aL(vVar.getContext()).cancel();
                        } catch (Throwable unused) {
                        }
                    }
                });
            } catch (Exception unused) {
            }
        }
    }

    /* loaded from: E:\TSN-r\205dec\6241084.dex */
    public interface c<T> {
        void i(T t3);
    }

    /* loaded from: E:\TSN-r\205dec\6241084.dex */
    static class d implements f<a.C0681a> {
        f<a.C0681a> aoh;

        d(f<a.C0681a> fVar) {
            this.aoh = fVar;
        }

        @Override // com.kwad.sdk.api.loader.n.f
        public final void a(final v vVar, final c<a.C0681a> cVar) {
            this.aoh.a(vVar, new a<a.C0681a>(cVar) { // from class: com.kwad.sdk.api.loader.n.d.1
                /* JADX INFO: Access modifiers changed from: private */
                @Override // com.kwad.sdk.api.loader.n.c
                @WorkerThread
                /* renamed from: c */
                public void i(@NonNull a.C0681a c0681a) {
                    long currentTimeMillis = System.currentTimeMillis();
                    File file = null;
                    try {
                        k.a(c0681a);
                        file = i.r(vVar.getContext(), c0681a.sdkVersion);
                        j.c(c0681a.amZ, file);
                        k.a(c0681a, System.currentTimeMillis() - currentTimeMillis);
                        c0681a.ana = file;
                        cVar.i(c0681a);
                    } catch (Throwable th) {
                        k.a(c0681a, System.currentTimeMillis() - currentTimeMillis, Log.getStackTraceString(th));
                        i.j(file);
                    }
                }
            });
        }
    }

    /* loaded from: E:\TSN-r\205dec\6241084.dex */
    static class e implements f<Boolean> {
        f<a.C0681a> aoh;

        e(f<a.C0681a> fVar) {
            this.aoh = fVar;
        }

        @Override // com.kwad.sdk.api.loader.n.f
        public final void a(final v vVar, final c<Boolean> cVar) {
            this.aoh.a(vVar, new c<a.C0681a>() { // from class: com.kwad.sdk.api.loader.n.e.1
                private void a(a.C0681a c0681a, int i4, Throwable th) {
                    i.j(c0681a.ana);
                    k.b(c0681a, i4, Log.getStackTraceString(th));
                }

                /* JADX INFO: Access modifiers changed from: private */
                @Override // com.kwad.sdk.api.loader.n.c
                /* renamed from: c */
                public void i(@NonNull a.C0681a c0681a) {
                    long currentTimeMillis = System.currentTimeMillis();
                    try {
                        k.b(c0681a);
                        if (!com.kwad.sdk.api.loader.c.a(vVar.getContext(), AnonymousClass1.class.getClassLoader(), c0681a.ana.getPath(), c0681a.sdkVersion)) {
                            a(c0681a, 1, new RuntimeException("Apk pre install fail"));
                            return;
                        }
                        com.kwad.sdk.api.loader.h.p(vVar.getContext(), c0681a.sdkVersion);
                        i.j(c0681a.ana);
                        k.b(c0681a, System.currentTimeMillis() - currentTimeMillis);
                        cVar.i(Boolean.TRUE);
                    } catch (Throwable th) {
                        a(c0681a, 2, th);
                    }
                }
            });
        }
    }

    /* loaded from: E:\TSN-r\205dec\6241084.dex */
    public interface f<T> {
        void a(v vVar, c<T> cVar);
    }

    /* loaded from: E:\TSN-r\205dec\6241084.dex */
    static class g implements f<a.C0681a> {
        f<a.C0681a> aoh;

        g(f<a.C0681a> fVar) {
            this.aoh = fVar;
        }

        @Override // com.kwad.sdk.api.loader.n.f
        public final void a(v vVar, final c<a.C0681a> cVar) {
            this.aoh.a(vVar, new a<a.C0681a>(cVar) { // from class: com.kwad.sdk.api.loader.n.g.1
                private void a(a.C0681a c0681a, int i4, Throwable th) {
                    i.j(c0681a.ana);
                    k.a(c0681a, i4, th.getMessage());
                }

                /* JADX INFO: Access modifiers changed from: private */
                @Override // com.kwad.sdk.api.loader.n.c
                /* renamed from: c */
                public void i(@NonNull a.C0681a c0681a) {
                    try {
                        File file = c0681a.ana;
                        if (!s.k(file)) {
                            a(c0681a, 1, new RuntimeException("Security checkFileValid fail"));
                        } else if (!s.a(file, c0681a.md5)) {
                            a(c0681a, 2, new RuntimeException("Security checkMd5 fail"));
                        } else {
                            cVar.i(c0681a);
                        }
                    } catch (Throwable th) {
                        a(c0681a, 3, th);
                    }
                }
            });
        }
    }

    /* loaded from: E:\TSN-r\205dec\6241084.dex */
    static class h implements f<a.C0681a> {
        f<a.C0681a> aoh;

        h(f<a.C0681a> fVar) {
            this.aoh = fVar;
        }

        @Override // com.kwad.sdk.api.loader.n.f
        public final void a(final v vVar, final c<a.C0681a> cVar) {
            this.aoh.a(vVar, new c<a.C0681a>() { // from class: com.kwad.sdk.api.loader.n.h.1
                /* JADX INFO: Access modifiers changed from: private */
                @Override // com.kwad.sdk.api.loader.n.c
                /* renamed from: c */
                public void i(a.C0681a c0681a) {
                    String aM = com.kwad.sdk.api.loader.h.aM(vVar.getContext());
                    if (TextUtils.isEmpty(aM)) {
                        aM = com.kwad.sdk.api.c.AD().getSDKVersion();
                    }
                    String str = c0681a.sdkVersion;
                    com.kwad.sdk.api.loader.b.a(vVar.getContext(), "interval", c0681a.interval);
                    com.kwad.sdk.api.loader.b.a(vVar.getContext(), "lastUpdateTime", System.currentTimeMillis());
                    if (c0681a.AJ()) {
                        u.aS(vVar.getContext());
                        new RuntimeException("DynamicType == -1, curVersion: " + aM);
                    } else if (com.kwad.sdk.api.loader.h.K(c0681a.sdkVersion, aM) && c0681a.AI()) {
                        cVar.i(c0681a);
                    } else {
                        new RuntimeException("No new sdkVersion. remote sdkVersion:" + c0681a.sdkVersion + " currentDynamicVersion:" + aM + " dynamicType:" + c0681a.amY);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(ContextThemeWrapper contextThemeWrapper) {
        super(contextThemeWrapper, 0);
        this.aiO = contextThemeWrapper;
        this.aiQ = ((Integer) Reflect.h(contextThemeWrapper).cj("getThemeResId").get()).intValue();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final Context getApplicationContext() {
        return Wrapper.wrapContextIfNeed(super.getApplicationContext());
    }

    @Override // android.content.ContextWrapper
    public final Context getBaseContext() {
        return Wrapper.wrapContextIfNeed(super.getBaseContext());
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final ClassLoader getClassLoader() {
        return Wrapper.replaceExternalClassLoader(super.getClassLoader());
    }

    @Override // com.kwad.sdk.api.core.ResContext
    public final Context getDelegatedContext() {
        return this.aiO;
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public final Resources getResources() {
        return Wrapper.replaceExternalResources(super.getResources());
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public final Object getSystemService(String str) {
        return Wrapper.wrapSystemService(this.aiO.getSystemService(str), str, this);
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public final Resources.Theme getTheme() {
        Resources.Theme theme;
        try {
            theme = super.getTheme();
        } catch (Exception e4) {
            e4.printStackTrace();
            theme = null;
        }
        Resources.Theme theme2 = this.aiP;
        if (theme2 == null || theme2 == theme) {
            this.aiP = Wrapper.replaceTheme(theme, theme2, this.aiQ);
        }
        return this.aiP;
    }

    @Override // android.content.Context
    public final void registerComponentCallbacks(ComponentCallbacks componentCallbacks) {
        this.aiO.registerComponentCallbacks(componentCallbacks);
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public final void setTheme(int i4) {
        this.aiQ = i4;
        super.setTheme(i4);
    }

    @Override // android.content.Context
    public final void unregisterComponentCallbacks(ComponentCallbacks componentCallbacks) {
        this.aiO.unregisterComponentCallbacks(componentCallbacks);
    }
}

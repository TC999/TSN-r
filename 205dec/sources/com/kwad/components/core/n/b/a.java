package com.kwad.components.core.n.b;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.kwad.components.offline.api.IOfflineCompo;
import com.kwad.library.solder.lib.ext.PluginError;
import com.kwad.library.solder.lib.ext.b;
import com.kwad.library.solder.lib.i;
import com.kwad.sdk.core.e.c;
import com.kwad.sdk.service.ServiceProvider;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public abstract class a<T extends IOfflineCompo<?>> {
    private long EW;
    private String Mx = "";

    private void ab(final Context context) {
        if (com.kwad.components.core.a.Iu.booleanValue()) {
            c.d(getTag(), "init start disableOffline");
            a(context, false, getClass().getClassLoader());
            return;
        }
        com.kwad.library.solder.lib.c.b oL = oL();
        String tag = getTag();
        c.d(tag, "load component start pluginInfo: " + oL);
        com.kwad.library.solder.a.a.a(context, oL, new b.a() { // from class: com.kwad.components.core.n.b.a.1
            long My;

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.library.solder.lib.ext.b.C0679b, com.kwad.library.solder.lib.ext.b
            public void b(com.kwad.library.solder.lib.b.a aVar) {
                super.b((AnonymousClass1) aVar);
                c.d(a.this.getTag(), "install component resource start");
                com.kwad.components.core.n.c.a.b(a.this.oO(), a.this.getDuration(), a.this.Mx);
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.library.solder.lib.ext.b.C0679b, com.kwad.library.solder.lib.ext.b
            /* renamed from: c */
            public void a(com.kwad.library.solder.lib.b.a aVar) {
                super.a((AnonymousClass1) aVar);
                c.d(a.this.getTag(), "install component resource success");
                com.kwad.components.core.n.c.a.c(a.this.oO(), a.this.getDuration(), a.this.Mx);
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.library.solder.lib.ext.b.C0679b, com.kwad.library.solder.lib.ext.b
            /* renamed from: d */
            public void e(com.kwad.library.solder.lib.b.a aVar) {
                super.e((AnonymousClass1) aVar);
                this.My = SystemClock.elapsedRealtime();
                a.this.Mx = aVar.xu() ? "ASSETS" : "NETWORK";
                c.d(a.this.getTag(), "update component resource start");
                com.kwad.components.core.n.c.c.d(a.this.oO(), a.this.getDuration(), a.this.Mx);
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.library.solder.lib.ext.b.C0679b, com.kwad.library.solder.lib.ext.b
            /* renamed from: e */
            public void c(com.kwad.library.solder.lib.b.a aVar) {
                super.c((AnonymousClass1) aVar);
                c.d(a.this.getTag(), "load component resource start");
                a.this.Mx = "LOCAL";
                com.kwad.components.core.n.c.a.b(a.this.oO(), a.this.getDuration(), aVar.xl().wY().xz());
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.library.solder.lib.ext.b.C0679b, com.kwad.library.solder.lib.ext.b
            public void a(com.kwad.library.solder.lib.b.a aVar, com.kwad.library.b.a aVar2) {
                super.a((AnonymousClass1) aVar, (com.kwad.library.solder.lib.b.a) aVar2);
                c.d(a.this.getTag(), "load component resource success");
                com.kwad.components.core.n.c.a.a(a.this.oO(), a.this.getDuration(), a.this.Mx);
                a aVar3 = a.this;
                aVar3.a(context, !"LOCAL".equals(aVar3.Mx), aVar2.wU());
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.library.solder.lib.ext.b.C0679b, com.kwad.library.solder.lib.ext.b
            /* renamed from: a */
            public void d(com.kwad.library.solder.lib.b.a aVar) {
                super.d((AnonymousClass1) aVar);
                c.d(a.this.getTag(), "update component resource success");
                com.kwad.components.core.n.c.c.a(a.this.oO(), a.this.getDuration(), SystemClock.elapsedRealtime() - this.My, a.this.Mx);
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.library.solder.lib.ext.b.C0679b, com.kwad.library.solder.lib.ext.b
            public void a(com.kwad.library.solder.lib.b.a aVar, PluginError pluginError) {
                super.a((AnonymousClass1) aVar, pluginError);
                if (aVar.getState() == 1) {
                    com.kwad.components.core.n.c.c.b(a.this.oO(), a.this.getDuration(), pluginError.getCode(), a.this.Mx, pluginError.getMessage());
                }
                String oO = a.this.oO();
                long duration = a.this.getDuration();
                int code = pluginError.getCode();
                com.kwad.components.core.n.c.a.a(oO, duration, code, "cmp_load_error " + pluginError.getMessage(), a.this.Mx);
                String tag2 = a.this.getTag();
                c.d(tag2, "load component resource failed error: " + pluginError);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long getDuration() {
        return SystemClock.elapsedRealtime() - this.EW;
    }

    private com.kwad.library.solder.lib.c.b oL() {
        com.kwad.library.solder.lib.c.b bVar = new com.kwad.library.solder.lib.c.b();
        bVar.akf = oP();
        bVar.Jd = true;
        bVar.akj = false;
        bVar.akg = com.kwad.sdk.core.network.idc.a.DU().dU(oR());
        bVar.version = oQ();
        bVar.aki = oS();
        if (com.kwad.components.core.a.Ix.booleanValue()) {
            bVar.ajI = oT();
            bVar.ajJ = true;
        }
        if (TextUtils.isEmpty(oS()) || TextUtils.isEmpty(oP()) || TextUtils.isEmpty(oQ()) || TextUtils.isEmpty(oR())) {
            com.kwad.components.core.n.c.a.a(oO(), getDuration(), 6001, "buildRemotePlugInfo error", this.Mx);
        }
        return bVar;
    }

    private void oM() {
        String tag = getTag();
        c.d(tag, "init component start cost: " + getDuration());
        com.kwad.components.core.n.c.a.d(oO(), getDuration());
    }

    protected abstract void a(Context context, boolean z3, T t3);

    public final void au(int i4) {
        String tag = getTag();
        c.d(tag, "init component error time: " + getDuration());
        String oO = oO();
        long duration = getDuration();
        com.kwad.components.core.n.c.a.a(oO, duration, 5001, "cmp_init_error, errorCode:" + i4, this.Mx);
    }

    protected abstract String getTag();

    public final void init(Context context) {
        try {
            if (isEnabled()) {
                this.EW = SystemClock.elapsedRealtime();
                com.kwad.components.core.n.c.a.c(oO(), getDuration());
                c.d(getTag(), "init start");
                ab(context);
                return;
            }
            try {
                c.d(getTag(), "del start");
                com.kwad.library.solder.a.a.j(context, oP());
            } catch (Throwable unused) {
            }
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public abstract boolean isEnabled();

    public final void oN() {
        String tag = getTag();
        c.d(tag, "init component success cost: " + getDuration());
        com.kwad.components.core.n.c.a.c(oO(), getDuration(), i.xe().wY().xz());
    }

    public abstract String oO();

    protected abstract String oP();

    protected abstract String oQ();

    protected abstract String oR();

    protected abstract String oS();

    protected abstract String oT();

    protected abstract String oU();

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(Context context, boolean z3, ClassLoader classLoader) {
        oM();
        String oU = oU();
        try {
            IOfflineCompo iOfflineCompo = (IOfflineCompo) classLoader.loadClass(oU).newInstance();
            String tag = getTag();
            c.d(tag, "load component instance success: " + iOfflineCompo.getClass().getName() + ", loadFromNet:" + z3 + ", classLoader:" + classLoader);
            a(context, z3, (boolean) iOfflineCompo);
        } catch (Throwable th) {
            com.kwad.components.core.n.c.a.a(oO(), getDuration(), 4005, "loadClass error", this.Mx);
            String tag2 = getTag();
            c.e(tag2, "loadClass or instance failed: " + oU, th);
        }
    }
}

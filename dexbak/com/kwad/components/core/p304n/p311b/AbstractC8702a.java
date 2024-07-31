package com.kwad.components.core.p304n.p311b;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.kwad.components.core.C8526a;
import com.kwad.components.core.p304n.p316c.C8762a;
import com.kwad.components.core.p304n.p316c.C8764c;
import com.kwad.components.offline.api.IOfflineCompo;
import com.kwad.library.p355b.C9586a;
import com.kwad.library.solder.lib.C9645i;
import com.kwad.library.solder.lib.ext.InterfaceC9629b;
import com.kwad.library.solder.lib.ext.PluginError;
import com.kwad.library.solder.lib.p361b.C9612a;
import com.kwad.library.solder.lib.p362c.C9617b;
import com.kwad.library.solder.p359a.C9602a;
import com.kwad.sdk.core.network.idc.C10425a;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.service.ServiceProvider;

/* renamed from: com.kwad.components.core.n.b.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public abstract class AbstractC8702a<T extends IOfflineCompo<?>> {

    /* renamed from: EW */
    private long f28365EW;

    /* renamed from: Mx */
    private String f28366Mx = "";

    /* renamed from: ab */
    private void m30000ab(final Context context) {
        if (C8526a.f28046Iu.booleanValue()) {
            C10331c.m26254d(getTag(), "init start disableOffline");
            m30004a(context, false, getClass().getClassLoader());
            return;
        }
        C9617b m29997oL = m29997oL();
        String tag = getTag();
        C10331c.m26254d(tag, "load component start pluginInfo: " + m29997oL);
        C9602a.m28257a(context, m29997oL, new InterfaceC9629b.C9630a() { // from class: com.kwad.components.core.n.b.a.1

            /* renamed from: My */
            long f28367My;

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.library.solder.lib.ext.InterfaceC9629b.C9631b, com.kwad.library.solder.lib.ext.InterfaceC9629b
            /* renamed from: b */
            public void mo28159b(C9612a c9612a) {
                super.mo28159b((C87031) c9612a);
                C10331c.m26254d(AbstractC8702a.this.getTag(), "install component resource start");
                C8762a.m29942b(AbstractC8702a.this.mo28822oO(), AbstractC8702a.this.getDuration(), AbstractC8702a.this.f28366Mx);
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.library.solder.lib.ext.InterfaceC9629b.C9631b, com.kwad.library.solder.lib.ext.InterfaceC9629b
            /* renamed from: c */
            public void mo28160a(C9612a c9612a) {
                super.mo28160a((C87031) c9612a);
                C10331c.m26254d(AbstractC8702a.this.getTag(), "install component resource success");
                C8762a.m29939c(AbstractC8702a.this.mo28822oO(), AbstractC8702a.this.getDuration(), AbstractC8702a.this.f28366Mx);
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.library.solder.lib.ext.InterfaceC9629b.C9631b, com.kwad.library.solder.lib.ext.InterfaceC9629b
            /* renamed from: d */
            public void mo28157e(C9612a c9612a) {
                super.mo28157e((C87031) c9612a);
                this.f28367My = SystemClock.elapsedRealtime();
                AbstractC8702a.this.f28366Mx = c9612a.m28220xu() ? "ASSETS" : "NETWORK";
                C10331c.m26254d(AbstractC8702a.this.getTag(), "update component resource start");
                C8764c.m29927d(AbstractC8702a.this.mo28822oO(), AbstractC8702a.this.getDuration(), AbstractC8702a.this.f28366Mx);
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.library.solder.lib.ext.InterfaceC9629b.C9631b, com.kwad.library.solder.lib.ext.InterfaceC9629b
            /* renamed from: e */
            public void mo28158c(C9612a c9612a) {
                super.mo28158c((C87031) c9612a);
                C10331c.m26254d(AbstractC8702a.this.getTag(), "load component resource start");
                AbstractC8702a.this.f28366Mx = "LOCAL";
                C8762a.m29943b(AbstractC8702a.this.mo28822oO(), AbstractC8702a.this.getDuration(), c9612a.m28229xl().mo28177wY().m28147xz());
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.library.solder.lib.ext.InterfaceC9629b.C9631b, com.kwad.library.solder.lib.ext.InterfaceC9629b
            /* renamed from: a */
            public void mo24651a(C9612a c9612a, C9586a c9586a) {
                super.mo24651a((C87031) c9612a, (C9612a) c9586a);
                C10331c.m26254d(AbstractC8702a.this.getTag(), "load component resource success");
                C8762a.m29944a(AbstractC8702a.this.mo28822oO(), AbstractC8702a.this.getDuration(), AbstractC8702a.this.f28366Mx);
                AbstractC8702a abstractC8702a = AbstractC8702a.this;
                abstractC8702a.m30004a(context, !"LOCAL".equals(abstractC8702a.f28366Mx), c9586a.m28309wU());
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.library.solder.lib.ext.InterfaceC9629b.C9631b, com.kwad.library.solder.lib.ext.InterfaceC9629b
            /* renamed from: a */
            public void mo25119d(C9612a c9612a) {
                super.mo25119d((C87031) c9612a);
                C10331c.m26254d(AbstractC8702a.this.getTag(), "update component resource success");
                C8764c.m29929a(AbstractC8702a.this.mo28822oO(), AbstractC8702a.this.getDuration(), SystemClock.elapsedRealtime() - this.f28367My, AbstractC8702a.this.f28366Mx);
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.library.solder.lib.ext.InterfaceC9629b.C9631b, com.kwad.library.solder.lib.ext.InterfaceC9629b
            /* renamed from: a */
            public void mo24650a(C9612a c9612a, PluginError pluginError) {
                super.mo24650a((C87031) c9612a, pluginError);
                if (c9612a.getState() == 1) {
                    C8764c.m29928b(AbstractC8702a.this.mo28822oO(), AbstractC8702a.this.getDuration(), pluginError.getCode(), AbstractC8702a.this.f28366Mx, pluginError.getMessage());
                }
                String mo28822oO = AbstractC8702a.this.mo28822oO();
                long duration = AbstractC8702a.this.getDuration();
                int code = pluginError.getCode();
                C8762a.m29945a(mo28822oO, duration, code, "cmp_load_error " + pluginError.getMessage(), AbstractC8702a.this.f28366Mx);
                String tag2 = AbstractC8702a.this.getTag();
                C10331c.m26254d(tag2, "load component resource failed error: " + pluginError);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long getDuration() {
        return SystemClock.elapsedRealtime() - this.f28365EW;
    }

    /* renamed from: oL */
    private C9617b m29997oL() {
        C9617b c9617b = new C9617b();
        c9617b.akf = mo28821oP();
        c9617b.f29489Jd = true;
        c9617b.akj = false;
        c9617b.akg = C10425a.m26107DU().m26085dU(mo28819oR());
        c9617b.version = mo28820oQ();
        c9617b.aki = mo28818oS();
        if (C8526a.f28049Ix.booleanValue()) {
            c9617b.ajI = mo28817oT();
            c9617b.ajJ = true;
        }
        if (TextUtils.isEmpty(mo28818oS()) || TextUtils.isEmpty(mo28821oP()) || TextUtils.isEmpty(mo28820oQ()) || TextUtils.isEmpty(mo28819oR())) {
            C8762a.m29945a(mo28822oO(), getDuration(), PluginError.ERROR_BUILD_REMOTE_PLUGIN_INFO, "buildRemotePlugInfo error", this.f28366Mx);
        }
        return c9617b;
    }

    /* renamed from: oM */
    private void m29996oM() {
        String tag = getTag();
        C10331c.m26254d(tag, "init component start cost: " + getDuration());
        C8762a.m29938d(mo28822oO(), getDuration());
    }

    /* renamed from: a */
    protected abstract void mo28832a(Context context, boolean z, T t);

    /* renamed from: au */
    public final void m29999au(int i) {
        String tag = getTag();
        C10331c.m26254d(tag, "init component error time: " + getDuration());
        String mo28822oO = mo28822oO();
        long duration = getDuration();
        C8762a.m29945a(mo28822oO, duration, 5001, "cmp_init_error, errorCode:" + i, this.f28366Mx);
    }

    protected abstract String getTag();

    public final void init(Context context) {
        try {
            if (isEnabled()) {
                this.f28365EW = SystemClock.elapsedRealtime();
                C8762a.m29941c(mo28822oO(), getDuration());
                C10331c.m26254d(getTag(), "init start");
                m30000ab(context);
                return;
            }
            try {
                C10331c.m26254d(getTag(), "del start");
                C9602a.m28254j(context, mo28821oP());
            } catch (Throwable unused) {
            }
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public abstract boolean isEnabled();

    /* renamed from: oN */
    public final void m29995oN() {
        String tag = getTag();
        C10331c.m26254d(tag, "init component success cost: " + getDuration());
        C8762a.m29940c(mo28822oO(), getDuration(), C9645i.m28105xe().m28106wY().m28147xz());
    }

    /* renamed from: oO */
    public abstract String mo28822oO();

    /* renamed from: oP */
    protected abstract String mo28821oP();

    /* renamed from: oQ */
    protected abstract String mo28820oQ();

    /* renamed from: oR */
    protected abstract String mo28819oR();

    /* renamed from: oS */
    protected abstract String mo28818oS();

    /* renamed from: oT */
    protected abstract String mo28817oT();

    /* renamed from: oU */
    protected abstract String mo28816oU();

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public void m30004a(Context context, boolean z, ClassLoader classLoader) {
        m29996oM();
        String mo28816oU = mo28816oU();
        try {
            IOfflineCompo iOfflineCompo = (IOfflineCompo) classLoader.loadClass(mo28816oU).newInstance();
            String tag = getTag();
            C10331c.m26254d(tag, "load component instance success: " + iOfflineCompo.getClass().getName() + ", loadFromNet:" + z + ", classLoader:" + classLoader);
            mo28832a(context, z, (boolean) iOfflineCompo);
        } catch (Throwable th) {
            C8762a.m29945a(mo28822oO(), getDuration(), 4005, "loadClass error", this.f28366Mx);
            String tag2 = getTag();
            C10331c.m26249e(tag2, "loadClass or instance failed: " + mo28816oU, th);
        }
    }
}

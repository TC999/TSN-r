package com.kwad.library.solder.lib;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.kwad.library.solder.lib.ext.PluginError;
import com.kwad.library.solder.lib.p360a.AbstractC9604a;
import com.kwad.library.solder.lib.p360a.AbstractC9608e;
import com.kwad.library.solder.lib.p360a.InterfaceC9606c;
import com.kwad.library.solder.lib.p360a.InterfaceC9607d;
import com.kwad.library.solder.lib.p362c.C9616a;
import com.kwad.library.solder.lib.p362c.C9617b;
import com.kwad.sdk.utils.C11013ag;
import com.kwad.sdk.utils.C11122q;
import com.stub.StubApp;
import java.io.File;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.kwad.library.solder.lib.d */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9618d implements InterfaceC9606c {
    private final ConcurrentHashMap<String, AbstractC9604a> aiY = new ConcurrentHashMap<>();
    private final Context mContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C9618d(Context context) {
        this.mContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
    }

    /* renamed from: a */
    private synchronized void m28196a(String str, AbstractC9604a abstractC9604a) {
        if (abstractC9604a != null) {
            if (abstractC9604a.isLoaded()) {
                this.aiY.put(str, abstractC9604a);
            }
        }
    }

    /* renamed from: b */
    private static void m28195b(AbstractC9608e abstractC9608e) {
        abstractC9608e.getState();
        abstractC9608e.m28233bO(7);
        abstractC9608e.m28229xl().mo28173xc().m28161r(abstractC9608e);
    }

    /* renamed from: c */
    private static void m28192c(AbstractC9608e abstractC9608e) {
        abstractC9608e.getState();
        abstractC9608e.m28229xl().mo28173xc().m28162q(abstractC9608e);
    }

    /* renamed from: f */
    private static void m28191f(AbstractC9608e abstractC9608e) {
        abstractC9608e.getState();
        abstractC9608e.m28233bO(0);
        abstractC9608e.m28229xl().mo28173xc().m28165n(abstractC9608e);
    }

    /* renamed from: h */
    private AbstractC9604a m28189h(AbstractC9608e abstractC9608e) {
        m28195b(abstractC9608e);
        AbstractC9604a m28248a = abstractC9608e.mo28214bO(abstractC9608e.m28222xs()).m28248a(abstractC9608e.m28217xx());
        String m28242xj = m28248a.m28242xj();
        File file = new File(m28242xj);
        abstractC9608e.m28225xp();
        InterfaceC9607d m28229xl = abstractC9608e.m28229xl();
        if (file.exists()) {
            String m28225xp = abstractC9608e.m28225xp();
            String version = abstractC9608e.getVersion();
            AbstractC9604a mo28193bG = mo28193bG(m28225xp);
            if (mo28193bG != null) {
                m28198a(abstractC9608e);
                return mo28193bG;
            }
            m28248a.m28246bJ(m28225xp);
            m28248a.m28247bI(version);
            if (m28229xl.mo28174xb().mo28208a(m28225xp, version, abstractC9608e.m28218xw())) {
                String mo28210F = m28229xl.mo28174xb().mo28210F(m28225xp, version);
                if (C11122q.m23718gs(mo28210F)) {
                    m28248a.m28245bK(mo28210F);
                    m28248a.m28244l(this.mContext, mo28210F);
                    m28196a(m28225xp, m28248a);
                    m28198a(abstractC9608e);
                    return m28248a;
                }
            }
            String mo28207b = m28229xl.mo28174xb().mo28207b(m28248a);
            m28248a.m28245bK(mo28207b);
            m28248a.m28244l(this.mContext, mo28207b);
            m28196a(m28225xp, m28248a);
            if (m28242xj.endsWith(m28229xl.mo28177wY().m28152xE())) {
                C11122q.delete(m28242xj);
            }
            m28198a(abstractC9608e);
            return m28248a;
        }
        throw new PluginError.LoadError("Apk file not exist.", 3001);
    }

    @Override // com.kwad.library.solder.lib.p360a.InterfaceC9606c
    /* renamed from: bG */
    public final synchronized AbstractC9604a mo28193bG(String str) {
        AbstractC9604a abstractC9604a = this.aiY.get(str);
        if (abstractC9604a != null) {
            if (!abstractC9604a.isLoaded()) {
                return null;
            }
        }
        return abstractC9604a;
    }

    @Override // com.kwad.library.solder.lib.p360a.InterfaceC9606c
    /* renamed from: g */
    public final void mo28190g(@NonNull AbstractC9608e abstractC9608e) {
        abstractC9608e.m28225xp();
        abstractC9608e.m28236bL("Load");
        m28192c(abstractC9608e);
        if (abstractC9608e.isCanceled()) {
            m28191f(abstractC9608e);
            return;
        }
        AbstractC9604a abstractC9604a = this.aiY.get(abstractC9608e.m28225xp());
        if (abstractC9604a != null && abstractC9604a.isLoaded()) {
            abstractC9608e.m28231c(abstractC9604a);
            abstractC9608e.m28225xp();
            abstractC9604a.m28242xj();
            m28197a(abstractC9608e, abstractC9604a);
            return;
        }
        C9617b m28217xx = abstractC9608e.m28217xx();
        if (m28217xx == null) {
            m28194b(abstractC9608e, new PluginError.LoadError("not pluginInfo", (int) PluginError.ERROR_UPD_REQUEST));
            return;
        }
        List<C9616a> m28216xy = abstractC9608e.m28216xy();
        C9616a c9616a = null;
        if (m28216xy != null && !m28216xy.isEmpty()) {
            for (C9616a c9616a2 : m28216xy) {
                if (abstractC9608e.getVersion().equals(c9616a2.version)) {
                    c9616a = c9616a2;
                } else {
                    abstractC9608e.m28229xl().mo28174xb().mo28212D(abstractC9608e.m28225xp(), c9616a2.version);
                }
            }
        }
        if (c9616a == null) {
            if (!C11013ag.isWifiConnected(this.mContext) && (m28217xx.akj || (m28217xx.akk && abstractC9608e.m28223xr() > 0))) {
                m28194b(abstractC9608e, new PluginError.NotWifiDownloadError("It can be downloaded only on WiFi", (int) PluginError.ERROR_UPD_NOT_WIFI_DOWNLOAD));
                return;
            }
            try {
                if (!abstractC9608e.m28229xl().mo28175xa().mo28120k(abstractC9608e)) {
                    return;
                }
            } catch (Throwable th) {
                m28194b(abstractC9608e, new PluginError.UpdateError(th, (int) PluginError.ERROR_UPD_REQUEST));
                return;
            }
        } else {
            String mo28210F = abstractC9608e.m28229xl().mo28174xb().mo28210F(c9616a.akf, c9616a.version);
            abstractC9608e.m28235bM(mo28210F);
            abstractC9608e.m28234bN(mo28210F);
            abstractC9608e.m28233bO(2);
            abstractC9608e.m28237bI(c9616a.version);
        }
        if (abstractC9608e.getState() != 2 && abstractC9608e.getState() != 3 && abstractC9608e.getState() != 4) {
            m28194b(abstractC9608e, new PluginError.InstallError("state exception", 2002));
            return;
        }
        String m28222xs = abstractC9608e.m28222xs();
        abstractC9608e.m28225xp();
        if (TextUtils.isEmpty(m28222xs)) {
            m28194b(abstractC9608e, new PluginError.LoadError("path not found", (int) PluginError.ERROR_UPD_FILE_NOT_FOUND));
        } else if (abstractC9608e.isCanceled()) {
            m28191f(abstractC9608e);
        } else {
            try {
                AbstractC9604a m28189h = m28189h(abstractC9608e);
                abstractC9608e.m28231c(m28189h);
                abstractC9608e.m28225xp();
                m28197a(abstractC9608e, m28189h);
            } catch (PluginError.InstallError e) {
                e = e;
                m28194b(abstractC9608e, e);
            } catch (PluginError.LoadError e2) {
                e = e2;
                m28194b(abstractC9608e, e);
            } catch (Throwable th2) {
                C9603a.m28251e("PluginLoaderImpl", "load plugin failed, path = " + m28222xs, th2);
                m28194b(abstractC9608e, new PluginError.InstallError("load or install plugin failed:" + th2.getMessage(), 4004));
            }
        }
    }

    /* renamed from: a */
    private static void m28198a(AbstractC9608e abstractC9608e) {
        abstractC9608e.getState();
        abstractC9608e.m28233bO(8);
        abstractC9608e.m28229xl().mo28173xc().m28169a(abstractC9608e);
    }

    /* renamed from: b */
    private static void m28194b(AbstractC9608e abstractC9608e, PluginError pluginError) {
        abstractC9608e.getState();
        abstractC9608e.m28233bO(6);
        abstractC9608e.m28230j(pluginError);
        abstractC9608e.m28229xl().mo28173xc().m28167c(abstractC9608e, pluginError);
    }

    /* renamed from: a */
    private static void m28197a(AbstractC9608e abstractC9608e, AbstractC9604a abstractC9604a) {
        abstractC9608e.getState();
        abstractC9608e.m28233bO(5);
        abstractC9608e.m28229xl().mo28173xc().m28168b(abstractC9608e, abstractC9604a);
    }
}

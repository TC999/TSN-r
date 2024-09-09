package com.kwad.library.solder.lib;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.kwad.library.solder.lib.ext.PluginError;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.utils.q;
import com.stub.StubApp;
import java.io.File;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class d implements com.kwad.library.solder.lib.a.c {
    private final ConcurrentHashMap<String, com.kwad.library.solder.lib.a.a> aiY = new ConcurrentHashMap<>();
    private final Context mContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(Context context) {
        this.mContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
    }

    private synchronized void a(String str, com.kwad.library.solder.lib.a.a aVar) {
        if (aVar != null) {
            if (aVar.isLoaded()) {
                this.aiY.put(str, aVar);
            }
        }
    }

    private static void b(com.kwad.library.solder.lib.a.e eVar) {
        eVar.getState();
        eVar.bO(7);
        eVar.xl().xc().r(eVar);
    }

    private static void c(com.kwad.library.solder.lib.a.e eVar) {
        eVar.getState();
        eVar.xl().xc().q(eVar);
    }

    private static void f(com.kwad.library.solder.lib.a.e eVar) {
        eVar.getState();
        eVar.bO(0);
        eVar.xl().xc().n(eVar);
    }

    private com.kwad.library.solder.lib.a.a h(com.kwad.library.solder.lib.a.e eVar) {
        b(eVar);
        com.kwad.library.solder.lib.a.a a4 = eVar.bO(eVar.xs()).a(eVar.xx());
        String xj = a4.xj();
        File file = new File(xj);
        eVar.xp();
        com.kwad.library.solder.lib.a.d xl = eVar.xl();
        if (file.exists()) {
            String xp = eVar.xp();
            String version = eVar.getVersion();
            com.kwad.library.solder.lib.a.a bG = bG(xp);
            if (bG != null) {
                a(eVar);
                return bG;
            }
            a4.bJ(xp);
            a4.bI(version);
            if (xl.xb().a(xp, version, eVar.xw())) {
                String F = xl.xb().F(xp, version);
                if (q.gs(F)) {
                    a4.bK(F);
                    a4.l(this.mContext, F);
                    a(xp, a4);
                    a(eVar);
                    return a4;
                }
            }
            String b4 = xl.xb().b(a4);
            a4.bK(b4);
            a4.l(this.mContext, b4);
            a(xp, a4);
            if (xj.endsWith(xl.wY().xE())) {
                q.delete(xj);
            }
            a(eVar);
            return a4;
        }
        throw new PluginError.LoadError("Apk file not exist.", 3001);
    }

    @Override // com.kwad.library.solder.lib.a.c
    public final synchronized com.kwad.library.solder.lib.a.a bG(String str) {
        com.kwad.library.solder.lib.a.a aVar = this.aiY.get(str);
        if (aVar != null) {
            if (!aVar.isLoaded()) {
                return null;
            }
        }
        return aVar;
    }

    @Override // com.kwad.library.solder.lib.a.c
    public final void g(@NonNull com.kwad.library.solder.lib.a.e eVar) {
        eVar.xp();
        eVar.bL("Load");
        c(eVar);
        if (eVar.isCanceled()) {
            f(eVar);
            return;
        }
        com.kwad.library.solder.lib.a.a aVar = this.aiY.get(eVar.xp());
        if (aVar != null && aVar.isLoaded()) {
            eVar.c(aVar);
            eVar.xp();
            aVar.xj();
            a(eVar, aVar);
            return;
        }
        com.kwad.library.solder.lib.c.b xx = eVar.xx();
        if (xx == null) {
            b(eVar, new PluginError.LoadError("not pluginInfo", 2006));
            return;
        }
        List<com.kwad.library.solder.lib.c.a> xy = eVar.xy();
        com.kwad.library.solder.lib.c.a aVar2 = null;
        if (xy != null && !xy.isEmpty()) {
            for (com.kwad.library.solder.lib.c.a aVar3 : xy) {
                if (eVar.getVersion().equals(aVar3.version)) {
                    aVar2 = aVar3;
                } else {
                    eVar.xl().xb().D(eVar.xp(), aVar3.version);
                }
            }
        }
        if (aVar2 == null) {
            if (!ag.isWifiConnected(this.mContext) && (xx.akj || (xx.akk && eVar.xr() > 0))) {
                b(eVar, new PluginError.NotWifiDownloadError("It can be downloaded only on WiFi", 2007));
                return;
            }
            try {
                if (!eVar.xl().xa().k(eVar)) {
                    return;
                }
            } catch (Throwable th) {
                b(eVar, new PluginError.UpdateError(th, 2006));
                return;
            }
        } else {
            String F = eVar.xl().xb().F(aVar2.akf, aVar2.version);
            eVar.bM(F);
            eVar.bN(F);
            eVar.bO(2);
            eVar.bI(aVar2.version);
        }
        if (eVar.getState() != 2 && eVar.getState() != 3 && eVar.getState() != 4) {
            b(eVar, new PluginError.InstallError("state exception", 2002));
            return;
        }
        String xs = eVar.xs();
        eVar.xp();
        if (TextUtils.isEmpty(xs)) {
            b(eVar, new PluginError.LoadError("path not found", 2009));
        } else if (eVar.isCanceled()) {
            f(eVar);
        } else {
            try {
                com.kwad.library.solder.lib.a.a h4 = h(eVar);
                eVar.c(h4);
                eVar.xp();
                a(eVar, h4);
            } catch (PluginError.InstallError e4) {
                e = e4;
                b(eVar, e);
            } catch (PluginError.LoadError e5) {
                e = e5;
                b(eVar, e);
            } catch (Throwable th2) {
                a.e("PluginLoaderImpl", "load plugin failed, path = " + xs, th2);
                b(eVar, new PluginError.InstallError("load or install plugin failed:" + th2.getMessage(), 4004));
            }
        }
    }

    private static void a(com.kwad.library.solder.lib.a.e eVar) {
        eVar.getState();
        eVar.bO(8);
        eVar.xl().xc().a(eVar);
    }

    private static void b(com.kwad.library.solder.lib.a.e eVar, PluginError pluginError) {
        eVar.getState();
        eVar.bO(6);
        eVar.j(pluginError);
        eVar.xl().xc().c(eVar, pluginError);
    }

    private static void a(com.kwad.library.solder.lib.a.e eVar, com.kwad.library.solder.lib.a.a aVar) {
        eVar.getState();
        eVar.bO(5);
        eVar.xl().xc().b(eVar, aVar);
    }
}

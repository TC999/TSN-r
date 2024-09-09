package com.kwad.library.solder.lib;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.kwad.library.solder.lib.a.f;
import com.kwad.library.solder.lib.ext.PluginError;
import com.kwad.sdk.utils.ad;
import com.kwad.sdk.utils.q;
import com.stub.StubApp;
import java.io.File;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class f implements com.kwad.library.solder.lib.a.f {
    private f.a ajk;
    private final Context mContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(Context context) {
        this.mContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
    }

    private static void e(com.kwad.library.solder.lib.a.e eVar) {
        eVar.getState();
        eVar.xl().xc().o(eVar);
    }

    private static void f(com.kwad.library.solder.lib.a.e eVar) {
        eVar.getState();
        eVar.bO(0);
        eVar.xl().xc().n(eVar);
    }

    private static void l(com.kwad.library.solder.lib.a.e eVar) {
        eVar.getState();
        eVar.xl().xc().p(eVar);
    }

    @Override // com.kwad.library.solder.lib.a.f
    public final com.kwad.library.solder.lib.a.f a(f.a aVar) {
        this.ajk = aVar;
        return this;
    }

    @Override // com.kwad.library.solder.lib.a.f
    public final boolean k(@NonNull com.kwad.library.solder.lib.a.e eVar) {
        eVar.xp();
        eVar.bL("Update");
        e(eVar);
        if (eVar.xq()) {
            eVar.xl().xb().bE(eVar.xp());
        }
        if (eVar.isCanceled()) {
            f(eVar);
            return false;
        }
        try {
            eVar.xl().xb().wW();
            if (eVar.xu()) {
                try {
                    File e4 = eVar.xl().xb().e(eVar.xv(), false);
                    if (eVar.isCanceled()) {
                        f(eVar);
                        return false;
                    }
                    try {
                        q.a(this.mContext, eVar.xv(), e4);
                        eVar.bM(e4.getAbsolutePath());
                        eVar.bO(3);
                        l(eVar);
                    } catch (Throwable th) {
                        a.e("PluginUpdaterImpl", th);
                        a(eVar, new PluginError.UpdateError(th, 2004));
                    }
                } catch (Throwable th2) {
                    th2.getLocalizedMessage();
                    a(eVar, new PluginError.UpdateError(th2, 2003));
                    return false;
                }
            } else {
                eVar.xp();
                eVar.getDownloadUrl();
                try {
                    File e5 = eVar.xl().xb().e(eVar.getDownloadUrl(), eVar.xl().wY().xH());
                    if (eVar.xw() != null && e5.exists() && TextUtils.equals(ad.ab(e5), eVar.xw())) {
                        eVar.bM(e5.getAbsolutePath());
                        eVar.bO(4);
                        l(eVar);
                        return true;
                    }
                    try {
                        a(eVar, e5);
                        eVar.bM(e5.getAbsolutePath());
                        eVar.bO(4);
                        l(eVar);
                    } catch (PluginError.CancelError unused) {
                        f(eVar);
                        return false;
                    } catch (PluginError.UpdateError e6) {
                        a.e("PluginUpdaterImpl", "Download plugin fail, error = " + e6.getLocalizedMessage());
                        eVar.j(e6);
                        a(eVar, e6);
                        return false;
                    }
                } catch (Throwable th3) {
                    a.e("PluginUpdaterImpl", "Can not get temp file, error = " + th3.getLocalizedMessage());
                    a(eVar, new PluginError.UpdateError(th3, 2003));
                    return false;
                }
            }
            return true;
        } catch (Throwable th4) {
            a.e("PluginUpdaterImpl", th4);
            a(eVar, new PluginError.UpdateError(th4, 2005));
            return false;
        }
    }

    private static void a(com.kwad.library.solder.lib.a.e eVar, PluginError.UpdateError updateError) {
        eVar.getState();
        eVar.bO(1);
        eVar.j(updateError);
        eVar.xl().xc().c(eVar, updateError);
    }

    private void a(com.kwad.library.solder.lib.a.e eVar, File file) {
        long currentTimeMillis = System.currentTimeMillis();
        Log.d("PluginUpdaterImpl", "start download pluginId: " + eVar.xp());
        f.a aVar = this.ajk;
        if (aVar != null) {
            aVar.a(eVar, file);
            Log.i("PluginUpdaterImpl", "finish download pluginId: " + eVar.xp() + " cost:" + (System.currentTimeMillis() - currentTimeMillis));
            return;
        }
        throw new PluginError.UpdateError("update ", 2008);
    }
}

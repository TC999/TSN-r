package com.kwad.library.solder.lib;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.kwad.library.solder.lib.ext.PluginError;
import com.kwad.library.solder.lib.p360a.AbstractC9608e;
import com.kwad.library.solder.lib.p360a.InterfaceC9609f;
import com.kwad.sdk.utils.C11010ad;
import com.kwad.sdk.utils.C11122q;
import com.stub.StubApp;
import java.io.File;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.kwad.library.solder.lib.f */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9642f implements InterfaceC9609f {
    private InterfaceC9609f.InterfaceC9610a ajk;
    private final Context mContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C9642f(Context context) {
        this.mContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
    }

    /* renamed from: e */
    private static void m28122e(AbstractC9608e abstractC9608e) {
        abstractC9608e.getState();
        abstractC9608e.m28229xl().mo28173xc().m28164o(abstractC9608e);
    }

    /* renamed from: f */
    private static void m28121f(AbstractC9608e abstractC9608e) {
        abstractC9608e.getState();
        abstractC9608e.m28233bO(0);
        abstractC9608e.m28229xl().mo28173xc().m28165n(abstractC9608e);
    }

    /* renamed from: l */
    private static void m28119l(AbstractC9608e abstractC9608e) {
        abstractC9608e.getState();
        abstractC9608e.m28229xl().mo28173xc().m28163p(abstractC9608e);
    }

    @Override // com.kwad.library.solder.lib.p360a.InterfaceC9609f
    /* renamed from: a */
    public final InterfaceC9609f mo28123a(InterfaceC9609f.InterfaceC9610a interfaceC9610a) {
        this.ajk = interfaceC9610a;
        return this;
    }

    @Override // com.kwad.library.solder.lib.p360a.InterfaceC9609f
    /* renamed from: k */
    public final boolean mo28120k(@NonNull AbstractC9608e abstractC9608e) {
        abstractC9608e.m28225xp();
        abstractC9608e.m28236bL("Update");
        m28122e(abstractC9608e);
        if (abstractC9608e.m28224xq()) {
            abstractC9608e.m28229xl().mo28174xb().mo28206bE(abstractC9608e.m28225xp());
        }
        if (abstractC9608e.isCanceled()) {
            m28121f(abstractC9608e);
            return false;
        }
        try {
            abstractC9608e.m28229xl().mo28174xb().mo28202wW();
            if (abstractC9608e.m28220xu()) {
                try {
                    File mo28204e = abstractC9608e.m28229xl().mo28174xb().mo28204e(abstractC9608e.m28219xv(), false);
                    if (abstractC9608e.isCanceled()) {
                        m28121f(abstractC9608e);
                        return false;
                    }
                    try {
                        C11122q.m23733a(this.mContext, abstractC9608e.m28219xv(), mo28204e);
                        abstractC9608e.m28235bM(mo28204e.getAbsolutePath());
                        abstractC9608e.m28233bO(3);
                        m28119l(abstractC9608e);
                    } catch (Throwable th) {
                        C9603a.m28250e("PluginUpdaterImpl", th);
                        m28125a(abstractC9608e, new PluginError.UpdateError(th, (int) PluginError.ERROR_UPD_EXTRACT));
                    }
                } catch (Throwable th2) {
                    th2.getLocalizedMessage();
                    m28125a(abstractC9608e, new PluginError.UpdateError(th2, 2003));
                    return false;
                }
            } else {
                abstractC9608e.m28225xp();
                abstractC9608e.getDownloadUrl();
                try {
                    File mo28204e2 = abstractC9608e.m28229xl().mo28174xb().mo28204e(abstractC9608e.getDownloadUrl(), abstractC9608e.m28229xl().mo28177wY().m28149xH());
                    if (abstractC9608e.m28218xw() != null && mo28204e2.exists() && TextUtils.equals(C11010ad.m24145ab(mo28204e2), abstractC9608e.m28218xw())) {
                        abstractC9608e.m28235bM(mo28204e2.getAbsolutePath());
                        abstractC9608e.m28233bO(4);
                        m28119l(abstractC9608e);
                        return true;
                    }
                    try {
                        m28124a(abstractC9608e, mo28204e2);
                        abstractC9608e.m28235bM(mo28204e2.getAbsolutePath());
                        abstractC9608e.m28233bO(4);
                        m28119l(abstractC9608e);
                    } catch (PluginError.CancelError unused) {
                        m28121f(abstractC9608e);
                        return false;
                    } catch (PluginError.UpdateError e) {
                        C9603a.m28252e("PluginUpdaterImpl", "Download plugin fail, error = " + e.getLocalizedMessage());
                        abstractC9608e.m28230j(e);
                        m28125a(abstractC9608e, e);
                        return false;
                    }
                } catch (Throwable th3) {
                    C9603a.m28252e("PluginUpdaterImpl", "Can not get temp file, error = " + th3.getLocalizedMessage());
                    m28125a(abstractC9608e, new PluginError.UpdateError(th3, 2003));
                    return false;
                }
            }
            return true;
        } catch (Throwable th4) {
            C9603a.m28250e("PluginUpdaterImpl", th4);
            m28125a(abstractC9608e, new PluginError.UpdateError(th4, (int) PluginError.ERROR_UPD_CAPACITY));
            return false;
        }
    }

    /* renamed from: a */
    private static void m28125a(AbstractC9608e abstractC9608e, PluginError.UpdateError updateError) {
        abstractC9608e.getState();
        abstractC9608e.m28233bO(1);
        abstractC9608e.m28230j(updateError);
        abstractC9608e.m28229xl().mo28173xc().m28167c(abstractC9608e, updateError);
    }

    /* renamed from: a */
    private void m28124a(AbstractC9608e abstractC9608e, File file) {
        long currentTimeMillis = System.currentTimeMillis();
        Log.d("PluginUpdaterImpl", "start download pluginId: " + abstractC9608e.m28225xp());
        InterfaceC9609f.InterfaceC9610a interfaceC9610a = this.ajk;
        if (interfaceC9610a != null) {
            interfaceC9610a.mo28102a(abstractC9608e, file);
            Log.i("PluginUpdaterImpl", "finish download pluginId: " + abstractC9608e.m28225xp() + " cost:" + (System.currentTimeMillis() - currentTimeMillis));
            return;
        }
        throw new PluginError.UpdateError("update ", (int) PluginError.ERROR_UPD_NO_DOWNLOADER);
    }
}

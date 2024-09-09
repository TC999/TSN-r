package com.kwad.components.ad.reward.k.a;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.annotation.Nullable;
import com.kwad.components.ad.reward.g;
import com.kwad.components.core.webview.tachikoma.c.e;
import java.lang.ref.WeakReference;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class b extends com.kwad.components.core.webview.tachikoma.c.e {
    private static WeakReference<b> xt;
    private g xq;
    private long xs;

    public static b a(g gVar, e.b bVar) {
        b bVar2 = new b();
        bVar2.xq = gVar;
        bVar2.mAdResultData = bVar.hk();
        bVar2.xn = bVar.getTemplateId();
        bVar2.aaC = bVar.ke();
        bVar2.aaM = bVar.sX();
        Bundle bundle = new Bundle();
        bundle.putString("templateId", bVar.getTemplateId());
        bVar2.setArguments(bundle);
        return bVar2;
    }

    private static boolean jj() {
        WeakReference<b> weakReference = xt;
        return (weakReference == null || weakReference.get() == null) ? false : true;
    }

    private void l(long j4) {
        this.xs = j4;
        com.kwad.components.core.webview.tachikoma.c.b bVar = this.aay;
        if (bVar != null) {
            bVar.xs = j4;
        }
    }

    @Override // com.kwad.components.core.webview.tachikoma.c.e
    public final com.kwad.components.core.webview.tachikoma.c.b jk() {
        return new a(this.xq);
    }

    @Override // com.kwad.components.core.webview.tachikoma.c.e
    public final com.kwad.components.core.webview.tachikoma.c.c jl() {
        return new c();
    }

    @Override // com.kwad.components.core.webview.tachikoma.c.e
    public final void jm() {
        super.jm();
        this.aay.xs = this.xs;
    }

    @Override // com.kwad.components.core.webview.tachikoma.c.e, android.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        this.xq = null;
        xt = null;
    }

    @Nullable
    public static b a(b bVar, Activity activity, long j4, com.kwad.components.core.webview.tachikoma.e.c cVar, e.a aVar) {
        if (activity == null || activity.isFinishing() || jj()) {
            return null;
        }
        bVar.Sy = cVar;
        bVar.aaD = aVar;
        bVar.show(activity.getFragmentManager(), "tkCloseDialog");
        if (j4 > 0) {
            bVar.l(j4);
        }
        xt = new WeakReference<>(bVar);
        return bVar;
    }

    @Nullable
    public static b a(g gVar, Activity activity, long j4, DialogInterface.OnDismissListener onDismissListener, com.kwad.components.core.webview.tachikoma.e.c cVar) {
        if (activity == null || activity.isFinishing() || jj()) {
            return null;
        }
        e.b bVar = new e.b();
        bVar.d(gVar.mAdResultData);
        bVar.aU(com.kwad.sdk.core.response.b.b.dv(gVar.mAdTemplate));
        b a4 = a(gVar, bVar);
        a4.Sy = cVar;
        a4.d(onDismissListener);
        a4.l(j4);
        a4.show(activity.getFragmentManager(), "tkExtraReward");
        xt = new WeakReference<>(a4);
        return a4;
    }
}

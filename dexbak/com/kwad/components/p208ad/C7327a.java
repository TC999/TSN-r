package com.kwad.components.p208ad;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import com.kwad.components.p208ad.adbit.C7334c;
import com.kwad.components.p208ad.p210b.InterfaceC7340a;
import com.kwad.components.p208ad.p237i.C7685b;
import com.kwad.sdk.C10829k;
import com.kwad.sdk.api.KsExitInstallListener;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.components.AbstractC9863d;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.p364a.p365a.AlertDialogC9668a;

/* renamed from: com.kwad.components.ad.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C7327a extends AbstractC9863d implements InterfaceC7340a {
    @Override // com.kwad.components.p208ad.p210b.InterfaceC7340a
    public final String getBidRequestToken(KsScene ksScene) {
        return C7334c.m33460a(SceneImpl.covert(ksScene));
    }

    @Override // com.kwad.components.p208ad.p210b.InterfaceC7340a
    public final String getBidRequestTokenV2(KsScene ksScene) {
        return C7334c.getBidRequestTokenV2(ksScene);
    }

    @Override // com.kwad.sdk.components.InterfaceC9848a
    public final Class getComponentsType() {
        return InterfaceC7340a.class;
    }

    @Override // com.kwad.sdk.components.InterfaceC9848a
    public final void init(Context context) {
        C7685b.m32650md().init();
    }

    @Override // com.kwad.sdk.components.AbstractC9863d, com.kwad.sdk.components.InterfaceC9848a
    public final int priority() {
        return -100;
    }

    @Override // com.kwad.components.p208ad.p210b.InterfaceC7340a
    public final boolean showInstallDialog(Activity activity, final KsExitInstallListener ksExitInstallListener) {
        if (C10829k.m24699zd().m24700ys()) {
            return AlertDialogC9668a.m28089a(activity, new DialogInterface.OnDismissListener() { // from class: com.kwad.components.ad.a.1
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    KsExitInstallListener ksExitInstallListener2 = ksExitInstallListener;
                    if (ksExitInstallListener2 != null) {
                        ksExitInstallListener2.onDialogClose();
                    }
                }
            }, new DialogInterface.OnClickListener() { // from class: com.kwad.components.ad.a.2
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    KsExitInstallListener ksExitInstallListener2 = ksExitInstallListener;
                    if (ksExitInstallListener2 == null || i != -1) {
                        return;
                    }
                    ksExitInstallListener2.onInstallClick();
                }
            });
        }
        return false;
    }
}

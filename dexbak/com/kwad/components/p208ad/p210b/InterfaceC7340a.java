package com.kwad.components.p208ad.p210b;

import android.app.Activity;
import com.kwad.sdk.api.KsExitInstallListener;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.components.InterfaceC9848a;

/* renamed from: com.kwad.components.ad.b.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public interface InterfaceC7340a extends InterfaceC9848a {
    String getBidRequestToken(KsScene ksScene);

    String getBidRequestTokenV2(KsScene ksScene);

    boolean showInstallDialog(Activity activity, KsExitInstallListener ksExitInstallListener);
}

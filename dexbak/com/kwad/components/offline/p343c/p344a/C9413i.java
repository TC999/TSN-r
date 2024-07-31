package com.kwad.components.offline.p343c.p344a;

import android.app.Activity;
import android.view.View;
import androidx.annotation.NonNull;
import com.kwad.components.offline.api.p341tk.IOfflineCompoTachikomaContext;
import com.kwad.components.offline.api.p341tk.IOfflineTKView;
import com.kwad.sdk.components.InterfaceC9869j;
import com.kwad.sdk.components.InterfaceC9872m;
import com.kwad.sdk.components.InterfaceC9874o;
import com.kwad.sdk.components.InterfaceC9875p;
import com.kwad.sdk.components.InterfaceC9876q;
import com.kwad.sdk.core.webview.p422c.InterfaceC10625a;
import com.kwad.sdk.core.webview.p422c.InterfaceC10631g;
import com.kwad.sdk.utils.C11023ap;
import java.util.Map;

/* renamed from: com.kwad.components.offline.c.a.i */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9413i implements InterfaceC9876q {
    private final IOfflineCompoTachikomaContext ads;

    public C9413i(@NonNull IOfflineCompoTachikomaContext iOfflineCompoTachikomaContext) {
        C11023ap.checkNotNull(iOfflineCompoTachikomaContext);
        this.ads = iOfflineCompoTachikomaContext;
    }

    @Override // com.kwad.sdk.components.InterfaceC9876q
    /* renamed from: a */
    public final void mo27483a(String str, String str2, InterfaceC9875p interfaceC9875p) {
        this.ads.execute(str, str2, new C9412h(interfaceC9875p));
    }

    @Override // com.kwad.sdk.components.InterfaceC9876q
    /* renamed from: aY */
    public final InterfaceC9872m mo27482aY(String str) {
        final IOfflineTKView tKView = this.ads.getTKView(str, new Object[0]);
        return new InterfaceC9872m() { // from class: com.kwad.components.offline.c.a.i.1
            @Override // com.kwad.sdk.components.InterfaceC9872m
            public final void bindActivity(Activity activity) {
                tKView.bindActivity(activity);
            }

            @Override // com.kwad.sdk.components.InterfaceC9872m
            public final View getView() {
                return tKView.getView();
            }

            @Override // com.kwad.sdk.components.InterfaceC9872m
            public final boolean onBackPressed() {
                return tKView.onBackPressed();
            }

            @Override // com.kwad.sdk.components.InterfaceC9872m
            public final void render() {
                tKView.render();
            }
        };
    }

    @Override // com.kwad.sdk.components.InterfaceC9876q
    /* renamed from: b */
    public final void mo27481b(InterfaceC10631g interfaceC10631g) {
        if (interfaceC10631g == null) {
            return;
        }
        this.ads.registerTKBridge(new C9410f(interfaceC10631g));
    }

    @Override // com.kwad.sdk.components.InterfaceC9876q
    /* renamed from: c */
    public final void mo27480c(InterfaceC10625a interfaceC10625a) {
        if (interfaceC10625a == null) {
            return;
        }
        this.ads.registerJsBridge(new C9403b(interfaceC10625a));
    }

    @Override // com.kwad.sdk.components.InterfaceC9876q
    public final Object execute(String str) {
        return this.ads.execute(str);
    }

    @Override // com.kwad.sdk.components.InterfaceC9876q
    public final int getUniqId() {
        return this.ads.getUniqId();
    }

    @Override // com.kwad.sdk.components.InterfaceC9876q
    public final View getView() {
        return this.ads.getView();
    }

    @Override // com.kwad.sdk.components.InterfaceC9876q
    public final void onDestroy() {
        this.ads.onDestroy();
    }

    @Override // com.kwad.sdk.components.InterfaceC9876q
    public final void setCustomEnv(Map<String, Object> map) {
        this.ads.setCustomEnv(map);
    }

    @Override // com.kwad.sdk.components.InterfaceC9876q
    /* renamed from: a */
    public final void mo27484a(InterfaceC9874o interfaceC9874o) {
        if (interfaceC9874o != null) {
            this.ads.registerHostActionHandler(new C9404c(interfaceC9874o));
        }
    }

    @Override // com.kwad.sdk.components.InterfaceC9876q
    /* renamed from: a */
    public final void mo27485a(InterfaceC9869j interfaceC9869j) {
        if (interfaceC9869j != null) {
            this.ads.registerApkLoadCreator(new C9409e(interfaceC9869j));
        }
    }
}

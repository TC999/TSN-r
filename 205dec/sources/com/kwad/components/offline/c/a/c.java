package com.kwad.components.offline.c.a;

import android.content.Intent;
import com.kwad.components.offline.api.tk.IOfflineHostActionHandler;
import com.kwad.components.offline.api.tk.IOfflineTKDialog;
import com.kwad.components.offline.api.tk.IOfflineTKNativeIntent;
import com.kwad.sdk.components.k;
import com.kwad.sdk.components.l;
import com.kwad.sdk.components.n;
import com.kwad.sdk.components.o;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class c implements IOfflineHostActionHandler {
    private final o Zj;

    public c(o oVar) {
        this.Zj = oVar;
    }

    private l a(final IOfflineTKNativeIntent iOfflineTKNativeIntent) {
        return new l() { // from class: com.kwad.components.offline.c.a.c.1
            @Override // com.kwad.sdk.components.l
            public final void a(n nVar) {
                iOfflineTKNativeIntent.registerJSCallHandler(new g(nVar));
            }

            @Override // com.kwad.sdk.components.l
            public final void callTKBridge(String str) {
                iOfflineTKNativeIntent.callTKBridge(str);
            }

            @Override // com.kwad.sdk.components.l
            public final void callbackDismiss() {
                iOfflineTKNativeIntent.callbackDismiss();
            }

            @Override // com.kwad.sdk.components.l
            public final void callbackPageStatus(boolean z3, String str) {
                iOfflineTKNativeIntent.callbackPageStatus(z3, str);
            }

            @Override // com.kwad.sdk.components.l
            public final String getClassName() {
                return iOfflineTKNativeIntent.getClassName();
            }

            @Override // com.kwad.sdk.components.l
            public final Intent getIntent() {
                return iOfflineTKNativeIntent.getIntent();
            }

            @Override // com.kwad.sdk.components.l
            public final String getTemplateString() {
                return iOfflineTKNativeIntent.getTemplateString();
            }

            @Override // com.kwad.sdk.components.l
            public final String getUrl() {
                return iOfflineTKNativeIntent.getUrl();
            }

            @Override // com.kwad.sdk.components.l
            public final String getViewKey() {
                return iOfflineTKNativeIntent.getViewKey();
            }
        };
    }

    @Override // com.kwad.components.offline.api.tk.IOfflineHostActionHandler
    public final void dismissDialog(IOfflineTKDialog iOfflineTKDialog) {
        o oVar = this.Zj;
        if (oVar != null) {
            oVar.b(a(iOfflineTKDialog));
        }
    }

    @Override // com.kwad.components.offline.api.tk.IOfflineHostActionHandler
    public final void showDialog(IOfflineTKDialog iOfflineTKDialog) {
        o oVar = this.Zj;
        if (oVar != null) {
            oVar.a(a(iOfflineTKDialog));
        }
    }

    @Override // com.kwad.components.offline.api.tk.IOfflineHostActionHandler
    public final void startActivity(IOfflineTKNativeIntent iOfflineTKNativeIntent) {
        o oVar = this.Zj;
        if (oVar != null) {
            oVar.a(a(iOfflineTKNativeIntent));
        }
    }

    private k a(final IOfflineTKDialog iOfflineTKDialog) {
        return new k() { // from class: com.kwad.components.offline.c.a.c.2
            @Override // com.kwad.sdk.components.k
            public final void a(n nVar) {
                iOfflineTKDialog.registerJSCallHandler(new g(nVar));
            }

            @Override // com.kwad.sdk.components.k
            public final void callTKBridge(String str) {
                iOfflineTKDialog.callTKBridge(str);
            }

            @Override // com.kwad.sdk.components.k
            public final void callbackDialogDismiss() {
                iOfflineTKDialog.callbackDialogDismiss();
            }

            @Override // com.kwad.sdk.components.k
            public final void callbackPageStatus(boolean z3, String str) {
                iOfflineTKDialog.callbackPageStatus(z3, str);
            }

            @Override // com.kwad.sdk.components.k
            public final int getDialogId() {
                return iOfflineTKDialog.getDialogId();
            }

            @Override // com.kwad.sdk.components.k
            public final String getStyleTemplate() {
                return iOfflineTKDialog.getStyleTemplate();
            }

            @Override // com.kwad.sdk.components.k
            public final String getViewKey() {
                return iOfflineTKDialog.getViewKey();
            }
        };
    }
}

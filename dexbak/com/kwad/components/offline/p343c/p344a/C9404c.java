package com.kwad.components.offline.p343c.p344a;

import android.content.Intent;
import com.kwad.components.offline.api.p341tk.IOfflineHostActionHandler;
import com.kwad.components.offline.api.p341tk.IOfflineTKDialog;
import com.kwad.components.offline.api.p341tk.IOfflineTKNativeIntent;
import com.kwad.sdk.components.InterfaceC9870k;
import com.kwad.sdk.components.InterfaceC9871l;
import com.kwad.sdk.components.InterfaceC9873n;
import com.kwad.sdk.components.InterfaceC9874o;

/* renamed from: com.kwad.components.offline.c.a.c */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9404c implements IOfflineHostActionHandler {

    /* renamed from: Zj */
    private final InterfaceC9874o f29468Zj;

    public C9404c(InterfaceC9874o interfaceC9874o) {
        this.f29468Zj = interfaceC9874o;
    }

    /* renamed from: a */
    private InterfaceC9871l m28842a(final IOfflineTKNativeIntent iOfflineTKNativeIntent) {
        return new InterfaceC9871l() { // from class: com.kwad.components.offline.c.a.c.1
            @Override // com.kwad.sdk.components.InterfaceC9871l
            /* renamed from: a */
            public final void mo27489a(InterfaceC9873n interfaceC9873n) {
                iOfflineTKNativeIntent.registerJSCallHandler(new C9411g(interfaceC9873n));
            }

            @Override // com.kwad.sdk.components.InterfaceC9871l
            public final void callTKBridge(String str) {
                iOfflineTKNativeIntent.callTKBridge(str);
            }

            @Override // com.kwad.sdk.components.InterfaceC9871l
            public final void callbackDismiss() {
                iOfflineTKNativeIntent.callbackDismiss();
            }

            @Override // com.kwad.sdk.components.InterfaceC9871l
            public final void callbackPageStatus(boolean z, String str) {
                iOfflineTKNativeIntent.callbackPageStatus(z, str);
            }

            @Override // com.kwad.sdk.components.InterfaceC9871l
            public final String getClassName() {
                return iOfflineTKNativeIntent.getClassName();
            }

            @Override // com.kwad.sdk.components.InterfaceC9871l
            public final Intent getIntent() {
                return iOfflineTKNativeIntent.getIntent();
            }

            @Override // com.kwad.sdk.components.InterfaceC9871l
            public final String getTemplateString() {
                return iOfflineTKNativeIntent.getTemplateString();
            }

            @Override // com.kwad.sdk.components.InterfaceC9871l
            public final String getUrl() {
                return iOfflineTKNativeIntent.getUrl();
            }

            @Override // com.kwad.sdk.components.InterfaceC9871l
            public final String getViewKey() {
                return iOfflineTKNativeIntent.getViewKey();
            }
        };
    }

    @Override // com.kwad.components.offline.api.p341tk.IOfflineHostActionHandler
    public final void dismissDialog(IOfflineTKDialog iOfflineTKDialog) {
        InterfaceC9874o interfaceC9874o = this.f29468Zj;
        if (interfaceC9874o != null) {
            interfaceC9874o.mo27486b(m28843a(iOfflineTKDialog));
        }
    }

    @Override // com.kwad.components.offline.api.p341tk.IOfflineHostActionHandler
    public final void showDialog(IOfflineTKDialog iOfflineTKDialog) {
        InterfaceC9874o interfaceC9874o = this.f29468Zj;
        if (interfaceC9874o != null) {
            interfaceC9874o.mo27488a(m28843a(iOfflineTKDialog));
        }
    }

    @Override // com.kwad.components.offline.api.p341tk.IOfflineHostActionHandler
    public final void startActivity(IOfflineTKNativeIntent iOfflineTKNativeIntent) {
        InterfaceC9874o interfaceC9874o = this.f29468Zj;
        if (interfaceC9874o != null) {
            interfaceC9874o.mo27487a(m28842a(iOfflineTKNativeIntent));
        }
    }

    /* renamed from: a */
    private InterfaceC9870k m28843a(final IOfflineTKDialog iOfflineTKDialog) {
        return new InterfaceC9870k() { // from class: com.kwad.components.offline.c.a.c.2
            @Override // com.kwad.sdk.components.InterfaceC9870k
            /* renamed from: a */
            public final void mo27490a(InterfaceC9873n interfaceC9873n) {
                iOfflineTKDialog.registerJSCallHandler(new C9411g(interfaceC9873n));
            }

            @Override // com.kwad.sdk.components.InterfaceC9870k
            public final void callTKBridge(String str) {
                iOfflineTKDialog.callTKBridge(str);
            }

            @Override // com.kwad.sdk.components.InterfaceC9870k
            public final void callbackDialogDismiss() {
                iOfflineTKDialog.callbackDialogDismiss();
            }

            @Override // com.kwad.sdk.components.InterfaceC9870k
            public final void callbackPageStatus(boolean z, String str) {
                iOfflineTKDialog.callbackPageStatus(z, str);
            }

            @Override // com.kwad.sdk.components.InterfaceC9870k
            public final int getDialogId() {
                return iOfflineTKDialog.getDialogId();
            }

            @Override // com.kwad.sdk.components.InterfaceC9870k
            public final String getStyleTemplate() {
                return iOfflineTKDialog.getStyleTemplate();
            }

            @Override // com.kwad.sdk.components.InterfaceC9870k
            public final String getViewKey() {
                return iOfflineTKDialog.getViewKey();
            }
        };
    }
}

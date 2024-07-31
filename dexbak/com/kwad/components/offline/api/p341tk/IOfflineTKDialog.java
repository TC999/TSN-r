package com.kwad.components.offline.api.p341tk;

/* renamed from: com.kwad.components.offline.api.tk.IOfflineTKDialog */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public interface IOfflineTKDialog {
    void callTKBridge(String str);

    void callbackDialogDismiss();

    void callbackPageStatus(boolean z, String str);

    int getDialogId();

    String getStyleTemplate();

    String getViewKey();

    void registerJSCallHandler(IOfflineTKCallHandler iOfflineTKCallHandler);
}

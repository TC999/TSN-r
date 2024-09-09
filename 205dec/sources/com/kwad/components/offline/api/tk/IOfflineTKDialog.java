package com.kwad.components.offline.api.tk;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public interface IOfflineTKDialog {
    void callTKBridge(String str);

    void callbackDialogDismiss();

    void callbackPageStatus(boolean z3, String str);

    int getDialogId();

    String getStyleTemplate();

    String getViewKey();

    void registerJSCallHandler(IOfflineTKCallHandler iOfflineTKCallHandler);
}

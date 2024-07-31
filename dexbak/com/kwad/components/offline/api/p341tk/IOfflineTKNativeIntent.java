package com.kwad.components.offline.api.p341tk;

import android.content.Intent;

/* renamed from: com.kwad.components.offline.api.tk.IOfflineTKNativeIntent */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public interface IOfflineTKNativeIntent {
    void callTKBridge(String str);

    void callbackDismiss();

    void callbackPageStatus(boolean z, String str);

    String getClassName();

    Intent getIntent();

    String getTemplateString();

    String getUrl();

    String getViewKey();

    void registerJSCallHandler(IOfflineTKCallHandler iOfflineTKCallHandler);
}

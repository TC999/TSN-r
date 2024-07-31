package com.kwad.components.offline.api.p341tk.jsbridge;

import androidx.annotation.NonNull;

/* renamed from: com.kwad.components.offline.api.tk.jsbridge.IOfflineCompoBridgeHandler */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public interface IOfflineCompoBridgeHandler {
    @NonNull
    String getKey();

    void handleJsCall(String str, @NonNull IOfflineCompoCallBackFunction iOfflineCompoCallBackFunction);

    void onDestroy();
}

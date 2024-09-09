package com.kwad.components.offline.api.tk.jsbridge;

import androidx.annotation.NonNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public interface IOfflineCompoBridgeHandler {
    @NonNull
    String getKey();

    void handleJsCall(String str, @NonNull IOfflineCompoCallBackFunction iOfflineCompoCallBackFunction);

    void onDestroy();
}

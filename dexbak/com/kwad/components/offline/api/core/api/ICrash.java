package com.kwad.components.offline.api.core.api;

import com.kwad.components.offline.api.p341tk.model.report.TKExceptionUploadParams;

/* loaded from: E:\fuckcool\tsn\6520572.dex */
public interface ICrash {
    void addCustomKeyValue(ICrashCustomKeyValue iCrashCustomKeyValue);

    void addOnCrashListener(ICrashOccurListener iCrashOccurListener);

    void gatherException(TKExceptionUploadParams tKExceptionUploadParams);

    void gatherException(Throwable th);
}

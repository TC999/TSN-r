package com.kwad.components.offline.api.p341tk;

import androidx.annotation.NonNull;
import com.kwad.components.offline.api.p341tk.model.StyleTemplate;

/* renamed from: com.kwad.components.offline.api.tk.TKDownloadListener */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public interface TKDownloadListener {
    void onFailed(String str);

    void onSuccess(@NonNull StyleTemplate styleTemplate);
}

package com.kwad.components.offline.api.tk;

import androidx.annotation.NonNull;
import com.kwad.components.offline.api.tk.model.StyleTemplate;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public interface TKDownloadListener {
    void onFailed(String str);

    void onSuccess(@NonNull StyleTemplate styleTemplate);
}

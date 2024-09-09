package com.kwad.components.offline.api.core.model;

import androidx.annotation.Nullable;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public interface IOfflineCompoJsonParse {
    void parseJson(@Nullable JSONObject jSONObject);

    JSONObject toJson();
}

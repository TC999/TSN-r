package com.bytedance.pangle.apm;

import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
@Keep
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public abstract class AbsApm {
    public abstract String getDid();

    public abstract void init();

    public abstract void monitorEvent(String str, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3);

    public abstract void reportError(String str, @NonNull Throwable th);
}

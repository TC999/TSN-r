package com.kwad.components.p208ad.adbit;

import androidx.annotation.NonNull;
import com.kwad.sdk.utils.C11126t;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.kwad.components.ad.adbit.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C7332a {
    @NonNull

    /* renamed from: bA */
    public Map<String, String> f25254bA;
    @NonNull

    /* renamed from: bz */
    public JSONObject f25255bz;

    public C7332a(@NonNull JSONObject jSONObject, @NonNull Map<String, String> map) {
        this.f25255bz = jSONObject;
        this.f25254bA = map;
    }

    /* renamed from: N */
    public final String m33465N() {
        for (String str : this.f25254bA.keySet()) {
            C11126t.putValue(this.f25255bz, str, this.f25254bA.get(str));
        }
        return this.f25255bz.toString();
    }
}

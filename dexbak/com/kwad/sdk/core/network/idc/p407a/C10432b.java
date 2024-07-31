package com.kwad.sdk.core.network.idc.p407a;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.InterfaceC9914b;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.utils.C11126t;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.network.idc.a.b */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10432b implements InterfaceC9914b {
    private final Map<String, List<String>> awM = new ConcurrentHashMap();

    @NonNull
    /* renamed from: Ea */
    private Map<String, List<String>> m26078Ea() {
        return this.awM;
    }

    /* renamed from: dW */
    public static C10432b m26074dW(String str) {
        C10432b c10432b = new C10432b();
        try {
            c10432b.parseJson(new JSONObject(str));
        } catch (JSONException e) {
            C10331c.printStackTraceOnly(e);
        }
        return c10432b;
    }

    @NonNull
    /* renamed from: Eb */
    public final Set<String> m26077Eb() {
        return this.awM.keySet();
    }

    /* renamed from: a */
    public final void m26076a(C10432b c10432b) {
        this.awM.clear();
        if (c10432b != null) {
            this.awM.putAll(c10432b.m26078Ea());
        }
    }

    @NonNull
    /* renamed from: dV */
    public final List<String> m26075dV(String str) {
        List<String> list = this.awM.get(str);
        return list == null ? Collections.emptyList() : list;
    }

    public final boolean isEmpty() {
        return this.awM.isEmpty();
    }

    @Override // com.kwad.sdk.core.InterfaceC9914b
    public final void parseJson(@Nullable JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            if (!TextUtils.isEmpty(next)) {
                hashMap.put(next, C11126t.m23675h(jSONObject.optJSONArray(next)));
            }
        }
        this.awM.clear();
        this.awM.putAll(hashMap);
    }

    @Override // com.kwad.sdk.core.InterfaceC9914b
    public final JSONObject toJson() {
        Map<String, List<String>> map = this.awM;
        JSONObject jSONObject = new JSONObject();
        for (String str : map.keySet()) {
            C11126t.putValue(jSONObject, str, C11126t.m23681O(map.get(str)));
        }
        return jSONObject;
    }
}

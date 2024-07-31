package com.kwad.sdk.p441l.p442a;

import android.content.Context;
import android.provider.Settings;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.InterfaceC9914b;
import com.kwad.sdk.core.response.p408a.C10482a;
import com.kwad.sdk.utils.C11126t;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.l.a.d */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10855d extends C10482a implements InterfaceC9914b {
    public int aMV = 0;
    public int aMW = 0;
    public int aMX = 0;
    public int aMY = 0;
    public int aMZ = 0;
    public int aNa = 0;
    public int aNb = 0;

    public C10855d(Context context) {
        if (context != null) {
            m24633bM(Settings.Secure.getInt(context.getContentResolver(), "adb_enabled", 0) > 0);
        }
    }

    /* renamed from: a */
    private void m24638a(C10855d c10855d, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c10855d.aMV = jSONObject.optInt("isRoot");
        c10855d.aMW = jSONObject.optInt("isXPosed");
        c10855d.aMX = jSONObject.optInt("isFrameworkHooked");
        c10855d.aMY = jSONObject.optInt("isVirtual");
        c10855d.aMZ = jSONObject.optInt("isAdbEnabled");
        c10855d.aNa = jSONObject.optInt("isEmulator");
        c10855d.aNb = jSONObject.optInt("isGroupControl");
        super.afterParseJson(jSONObject);
    }

    /* renamed from: b */
    private static JSONObject m24637b(C10855d c10855d, JSONObject jSONObject) {
        C11126t.putValue(jSONObject, "isRoot", c10855d.aMV);
        C11126t.putValue(jSONObject, "isXPosed", c10855d.aMW);
        C11126t.putValue(jSONObject, "isFrameworkHooked", c10855d.aMX);
        C11126t.putValue(jSONObject, "isVirtual", c10855d.aMY);
        C11126t.putValue(jSONObject, "isAdbEnabled", c10855d.aMZ);
        C11126t.putValue(jSONObject, "isEmulator", c10855d.aNa);
        C11126t.putValue(jSONObject, "isGroupControl", c10855d.aNb);
        return jSONObject;
    }

    /* renamed from: bM */
    private void m24633bM(boolean z) {
        this.aMZ = m24630bP(z);
    }

    /* renamed from: bP */
    private static int m24630bP(boolean z) {
        return z ? 1 : 2;
    }

    /* renamed from: bJ */
    public final void m24636bJ(boolean z) {
        this.aMV = m24630bP(z);
    }

    /* renamed from: bK */
    public final void m24635bK(boolean z) {
        this.aMW = m24630bP(z);
    }

    /* renamed from: bL */
    public final void m24634bL(boolean z) {
        this.aMX = m24630bP(z);
    }

    /* renamed from: bN */
    public final void m24632bN(boolean z) {
        this.aNa = m24630bP(z);
    }

    /* renamed from: bO */
    public final void m24631bO(boolean z) {
        this.aNb = m24630bP(z);
    }

    @Override // com.kwad.sdk.core.response.p408a.C10482a, com.kwad.sdk.core.InterfaceC9914b
    public final void parseJson(@Nullable JSONObject jSONObject) {
        m24638a(this, jSONObject);
        afterParseJson(jSONObject);
    }

    @Override // com.kwad.sdk.core.response.p408a.C10482a, com.kwad.sdk.core.InterfaceC9914b
    public final JSONObject toJson() {
        JSONObject m24637b = m24637b(this, new JSONObject());
        afterToJson(m24637b);
        return m24637b;
    }
}

package com.kwad.sdk.crash.online.monitor.p428a;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.response.p408a.C10482a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

@KsJson
/* renamed from: com.kwad.sdk.crash.online.monitor.a.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C10696a extends C10482a {
    public List<String> aGO = new ArrayList();
    public List<String> aGP = new ArrayList();
    public List<String> aGQ = new ArrayList();
    public List<String> aGR = new ArrayList();
    public List<C10697b> aGS = new ArrayList();
    public Map<String, C10697b> aGT = new HashMap();
    public int aGU;
    public int aGV;
    public int aGW;
    public double aor;

    /* renamed from: HU */
    public final boolean m25100HU() {
        return (this.aGW & 4) != 0;
    }

    /* renamed from: HV */
    public final boolean m25099HV() {
        return (this.aGW & 1) != 0;
    }

    /* renamed from: HW */
    public final boolean m25098HW() {
        return (this.aGW & 2) != 0;
    }

    /* renamed from: HX */
    public final boolean m25097HX() {
        return this.aGW == 0;
    }

    @Override // com.kwad.sdk.core.response.p408a.C10482a
    public void afterParseJson(JSONObject jSONObject) {
        super.afterParseJson(jSONObject);
        List<C10697b> list = this.aGS;
        if (list != null) {
            for (C10697b c10697b : list) {
                this.aGT.put(c10697b.appId, c10697b);
            }
            this.aGS.clear();
        }
    }

    @Nullable
    /* renamed from: fz */
    public final C10697b m25096fz(String str) {
        if (this.aGT != null) {
            C10697b c10697b = TextUtils.isEmpty(str) ? null : this.aGT.get(str);
            return c10697b == null ? this.aGT.get("000000000") : c10697b;
        }
        return null;
    }
}

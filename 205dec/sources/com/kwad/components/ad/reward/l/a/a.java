package com.kwad.components.ad.reward.l.a;

import androidx.annotation.Nullable;
import com.kwad.sdk.core.config.d;
import com.kwad.sdk.core.e.c;
import com.kwad.sdk.utils.t;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class a extends com.kwad.components.ad.reward.l.a {
    private b xF = new b();
    private final C0593a xG = new C0593a(d.Cg());

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* renamed from: com.kwad.components.ad.reward.l.a.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public static class C0593a extends com.kwad.components.ad.reward.l.b {
        public C0593a(int i4) {
            StringBuilder sb = new StringBuilder();
            sb.append(i4);
            this.xD = String.format("\u8fdb\u9636\u5956\u52b1\uff1a\u6d4f\u89c8\u8be6\u60c5\u9875 %ss", sb.toString());
            StringBuilder sb2 = new StringBuilder();
            sb2.append(i4);
            this.xE = String.format("\u8fdb\u9636\u5956\u52b1\uff1a\u6d4f\u89c8\u8be6\u60c5\u9875 %ss", sb2.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public static class b extends com.kwad.components.ad.reward.l.b {
        public b() {
            this.xD = "\u57fa\u7840\u5956\u52b1\uff1a\u89c2\u770b\u89c6\u9891";
            this.xE = "\u57fa\u7840\u5956\u52b1\uff1a\u9700\u518d\u89c2\u770b%ss\u89c6\u9891";
        }
    }

    private void jC() {
        if (this.xG.isCompleted()) {
            js();
        } else {
            jt();
        }
    }

    @Override // com.kwad.components.ad.reward.l.b, com.kwad.components.ad.reward.l.c
    public final boolean isCompleted() {
        return this.xG.isCompleted();
    }

    public final void jA() {
        c.d("LandPageOpenTask", "markWatchVideoCompleted");
        this.xF.js();
        jC();
    }

    public final boolean jB() {
        return this.xF.isCompleted();
    }

    @Override // com.kwad.components.ad.reward.l.a
    public final List<com.kwad.components.ad.reward.l.c> jq() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.xF);
        arrayList.add(this.xG);
        return arrayList;
    }

    @Override // com.kwad.components.ad.reward.l.a
    public final int jr() {
        int i4 = 0;
        for (com.kwad.components.ad.reward.l.c cVar : jq()) {
            if (!cVar.isCompleted()) {
                i4++;
            }
        }
        return i4;
    }

    public final void markOpenNsCompleted() {
        c.d("LandPageOpenTask", "markOpenNsCompleted");
        this.xG.js();
        jC();
    }

    @Override // com.kwad.components.ad.reward.l.b, com.kwad.sdk.core.b
    public final void parseJson(@Nullable JSONObject jSONObject) {
        try {
            this.xF.parseJson(jSONObject.optJSONObject("mWatchVideoTask"));
            this.xG.parseJson(jSONObject.optJSONObject("mOpenNsTask"));
        } catch (Throwable unused) {
        }
    }

    @Override // com.kwad.components.ad.reward.l.b, com.kwad.sdk.core.b
    public final JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        t.a(jSONObject, "mWatchVideoTask", this.xF);
        t.a(jSONObject, "mOpenNsTask", this.xG);
        return jSONObject;
    }
}

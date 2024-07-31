package com.kwad.components.p208ad.reward.p260l.p261a;

import androidx.annotation.Nullable;
import com.kwad.components.p208ad.reward.p260l.AbstractC8004a;
import com.kwad.components.p208ad.reward.p260l.AbstractC8008b;
import com.kwad.components.p208ad.reward.p260l.InterfaceC8013c;
import com.kwad.sdk.core.config.C10251d;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.utils.C11126t;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* renamed from: com.kwad.components.ad.reward.l.a.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C8005a extends AbstractC8004a {

    /* renamed from: xF */
    private C8007b f26712xF = new C8007b();

    /* renamed from: xG */
    private final C8006a f26713xG = new C8006a(C10251d.m26548Cg());

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.kwad.components.ad.reward.l.a.a$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class C8006a extends AbstractC8008b {
        public C8006a(int i) {
            StringBuilder sb = new StringBuilder();
            sb.append(i);
            this.f26715xD = String.format("进阶奖励：浏览详情页 %ss", sb.toString());
            StringBuilder sb2 = new StringBuilder();
            sb2.append(i);
            this.f26716xE = String.format("进阶奖励：浏览详情页 %ss", sb2.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.kwad.components.ad.reward.l.a.a$b */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class C8007b extends AbstractC8008b {
        public C8007b() {
            this.f26715xD = "基础奖励：观看视频";
            this.f26716xE = "基础奖励：需再观看%ss视频";
        }
    }

    /* renamed from: jC */
    private void m31883jC() {
        if (this.f26713xG.isCompleted()) {
            m31882js();
        } else {
            m31881jt();
        }
    }

    @Override // com.kwad.components.p208ad.reward.p260l.AbstractC8008b, com.kwad.components.p208ad.reward.p260l.InterfaceC8013c
    public final boolean isCompleted() {
        return this.f26713xG.isCompleted();
    }

    /* renamed from: jA */
    public final void m31885jA() {
        C10331c.m26254d("LandPageOpenTask", "markWatchVideoCompleted");
        this.f26712xF.m31882js();
        m31883jC();
    }

    /* renamed from: jB */
    public final boolean m31884jB() {
        return this.f26712xF.isCompleted();
    }

    @Override // com.kwad.components.p208ad.reward.p260l.AbstractC8004a
    /* renamed from: jq */
    public final List<InterfaceC8013c> mo31870jq() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f26712xF);
        arrayList.add(this.f26713xG);
        return arrayList;
    }

    @Override // com.kwad.components.p208ad.reward.p260l.AbstractC8004a
    /* renamed from: jr */
    public final int mo31869jr() {
        int i = 0;
        for (InterfaceC8013c interfaceC8013c : mo31870jq()) {
            if (!interfaceC8013c.isCompleted()) {
                i++;
            }
        }
        return i;
    }

    public final void markOpenNsCompleted() {
        C10331c.m26254d("LandPageOpenTask", "markOpenNsCompleted");
        this.f26713xG.m31882js();
        m31883jC();
    }

    @Override // com.kwad.components.p208ad.reward.p260l.AbstractC8008b, com.kwad.sdk.core.InterfaceC9914b
    public final void parseJson(@Nullable JSONObject jSONObject) {
        try {
            this.f26712xF.parseJson(jSONObject.optJSONObject("mWatchVideoTask"));
            this.f26713xG.parseJson(jSONObject.optJSONObject("mOpenNsTask"));
        } catch (Throwable unused) {
        }
    }

    @Override // com.kwad.components.p208ad.reward.p260l.AbstractC8008b, com.kwad.sdk.core.InterfaceC9914b
    public final JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        C11126t.m23678a(jSONObject, "mWatchVideoTask", this.f26712xF);
        C11126t.m23678a(jSONObject, "mOpenNsTask", this.f26713xG);
        return jSONObject;
    }
}

package com.kwad.components.p208ad.reward.p260l.p262b;

import android.content.Context;
import androidx.annotation.Nullable;
import com.kwad.components.p208ad.reward.p248a.C7844b;
import com.kwad.components.p208ad.reward.p260l.AbstractC8004a;
import com.kwad.components.p208ad.reward.p260l.AbstractC8008b;
import com.kwad.components.p208ad.reward.p260l.InterfaceC8013c;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.p409b.C10483a;
import com.kwad.sdk.core.response.p409b.C10487e;
import com.kwad.sdk.utils.C11017ak;
import com.kwad.sdk.utils.C11126t;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* renamed from: com.kwad.components.ad.reward.l.b.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C8009a extends AbstractC8004a {

    /* renamed from: xH */
    private C8012c f26717xH = new C8012c();

    /* renamed from: xI */
    private C8010a f26718xI = new C8010a();

    /* renamed from: xJ */
    private final C8011b f26719xJ = new C8011b(C7844b.m32187gr());

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.kwad.components.ad.reward.l.b.a$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class C8010a extends AbstractC8008b {
        public C8010a() {
            this.f26715xD = "安装应用";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.kwad.components.ad.reward.l.b.a$b */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class C8011b extends AbstractC8008b {
        public C8011b(int i) {
            StringBuilder sb = new StringBuilder();
            sb.append(i);
            this.f26715xD = String.format("进阶奖励：安装并激活APP %ss", sb.toString());
            StringBuilder sb2 = new StringBuilder();
            sb2.append(i);
            this.f26716xE = String.format("进阶奖励：安装并激活APP %ss", sb2.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.kwad.components.ad.reward.l.b.a$c */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class C8012c extends AbstractC8008b {
        public C8012c() {
            this.f26715xD = "基础奖励：观看视频";
            this.f26716xE = "基础奖励：需再观看%ss视频";
        }
    }

    /* renamed from: a */
    public static void m31878a(C8009a c8009a, Context context, AdTemplate adTemplate) {
        if (C11017ak.m24114an(context, C10483a.m25911ay(C10487e.m25641dQ(adTemplate)))) {
            c8009a.m31874jD();
        } else {
            c8009a.m31873jE();
        }
    }

    /* renamed from: jC */
    private void m31875jC() {
        if (this.f26717xH.isCompleted() && this.f26718xI.isCompleted() && this.f26719xJ.isCompleted()) {
            m31882js();
        } else {
            m31881jt();
        }
    }

    /* renamed from: jE */
    private void m31873jE() {
        C10331c.m26254d("LaunchAppTask", "markInstallUncompleted");
        this.f26718xI.m31881jt();
        m31875jC();
    }

    @Override // com.kwad.components.p208ad.reward.p260l.AbstractC8008b, com.kwad.components.p208ad.reward.p260l.InterfaceC8013c
    public final boolean isCompleted() {
        return this.f26718xI.isCompleted() && this.f26719xJ.isCompleted();
    }

    /* renamed from: jA */
    public final void m31877jA() {
        C10331c.m26254d("LaunchAppTask", "markWatchVideoCompleted");
        this.f26717xH.m31882js();
        m31875jC();
    }

    /* renamed from: jB */
    public final boolean m31876jB() {
        return this.f26717xH.isCompleted();
    }

    /* renamed from: jD */
    public final void m31874jD() {
        C10331c.m26254d("LaunchAppTask", "markInstallCompleted");
        this.f26718xI.m31882js();
        m31875jC();
    }

    /* renamed from: jF */
    public final void m31872jF() {
        C10331c.m26254d("LaunchAppTask", "markUseAppCompleted");
        this.f26719xJ.m31882js();
        m31875jC();
    }

    /* renamed from: jG */
    public final boolean m31871jG() {
        C10331c.m26254d("LaunchAppTask", "isInstallCompleted");
        return this.f26718xI.isCompleted();
    }

    @Override // com.kwad.components.p208ad.reward.p260l.AbstractC8004a
    /* renamed from: jq */
    public final List<InterfaceC8013c> mo31870jq() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f26717xH);
        arrayList.add(this.f26719xJ);
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

    @Override // com.kwad.components.p208ad.reward.p260l.AbstractC8008b, com.kwad.sdk.core.InterfaceC9914b
    public final void parseJson(@Nullable JSONObject jSONObject) {
        try {
            this.f26717xH.parseJson(jSONObject.optJSONObject("mWatchVideoTask"));
            this.f26719xJ.parseJson(jSONObject.optJSONObject("mUseAppTask"));
        } catch (Throwable unused) {
        }
    }

    @Override // com.kwad.components.p208ad.reward.p260l.AbstractC8008b, com.kwad.sdk.core.InterfaceC9914b
    public final JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        C11126t.m23678a(jSONObject, "mWatchVideoTask", this.f26717xH);
        C11126t.m23678a(jSONObject, "mInstallAppTask", this.f26718xI);
        C11126t.m23678a(jSONObject, "mUseAppTask", this.f26719xJ);
        return jSONObject;
    }
}

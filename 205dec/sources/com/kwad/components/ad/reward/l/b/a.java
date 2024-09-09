package com.kwad.components.ad.reward.l.b;

import android.content.Context;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ak;
import com.kwad.sdk.utils.t;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class a extends com.kwad.components.ad.reward.l.a {
    private c xH = new c();
    private C0594a xI = new C0594a();
    private final b xJ = new b(com.kwad.components.ad.reward.a.b.gr());

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* renamed from: com.kwad.components.ad.reward.l.b.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public static class C0594a extends com.kwad.components.ad.reward.l.b {
        public C0594a() {
            this.xD = "\u5b89\u88c5\u5e94\u7528";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public static class b extends com.kwad.components.ad.reward.l.b {
        public b(int i4) {
            StringBuilder sb = new StringBuilder();
            sb.append(i4);
            this.xD = String.format("\u8fdb\u9636\u5956\u52b1\uff1a\u5b89\u88c5\u5e76\u6fc0\u6d3bAPP %ss", sb.toString());
            StringBuilder sb2 = new StringBuilder();
            sb2.append(i4);
            this.xE = String.format("\u8fdb\u9636\u5956\u52b1\uff1a\u5b89\u88c5\u5e76\u6fc0\u6d3bAPP %ss", sb2.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public static class c extends com.kwad.components.ad.reward.l.b {
        public c() {
            this.xD = "\u57fa\u7840\u5956\u52b1\uff1a\u89c2\u770b\u89c6\u9891";
            this.xE = "\u57fa\u7840\u5956\u52b1\uff1a\u9700\u518d\u89c2\u770b%ss\u89c6\u9891";
        }
    }

    public static void a(a aVar, Context context, AdTemplate adTemplate) {
        if (ak.an(context, com.kwad.sdk.core.response.b.a.ay(e.dQ(adTemplate)))) {
            aVar.jD();
        } else {
            aVar.jE();
        }
    }

    private void jC() {
        if (this.xH.isCompleted() && this.xI.isCompleted() && this.xJ.isCompleted()) {
            js();
        } else {
            jt();
        }
    }

    private void jE() {
        com.kwad.sdk.core.e.c.d("LaunchAppTask", "markInstallUncompleted");
        this.xI.jt();
        jC();
    }

    @Override // com.kwad.components.ad.reward.l.b, com.kwad.components.ad.reward.l.c
    public final boolean isCompleted() {
        return this.xI.isCompleted() && this.xJ.isCompleted();
    }

    public final void jA() {
        com.kwad.sdk.core.e.c.d("LaunchAppTask", "markWatchVideoCompleted");
        this.xH.js();
        jC();
    }

    public final boolean jB() {
        return this.xH.isCompleted();
    }

    public final void jD() {
        com.kwad.sdk.core.e.c.d("LaunchAppTask", "markInstallCompleted");
        this.xI.js();
        jC();
    }

    public final void jF() {
        com.kwad.sdk.core.e.c.d("LaunchAppTask", "markUseAppCompleted");
        this.xJ.js();
        jC();
    }

    public final boolean jG() {
        com.kwad.sdk.core.e.c.d("LaunchAppTask", "isInstallCompleted");
        return this.xI.isCompleted();
    }

    @Override // com.kwad.components.ad.reward.l.a
    public final List<com.kwad.components.ad.reward.l.c> jq() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.xH);
        arrayList.add(this.xJ);
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

    @Override // com.kwad.components.ad.reward.l.b, com.kwad.sdk.core.b
    public final void parseJson(@Nullable JSONObject jSONObject) {
        try {
            this.xH.parseJson(jSONObject.optJSONObject("mWatchVideoTask"));
            this.xJ.parseJson(jSONObject.optJSONObject("mUseAppTask"));
        } catch (Throwable unused) {
        }
    }

    @Override // com.kwad.components.ad.reward.l.b, com.kwad.sdk.core.b
    public final JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        t.a(jSONObject, "mWatchVideoTask", this.xH);
        t.a(jSONObject, "mInstallAppTask", this.xI);
        t.a(jSONObject, "mUseAppTask", this.xJ);
        return jSONObject;
    }
}

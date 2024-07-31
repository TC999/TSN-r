package com.kwad.components.core.p330s;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.p287c.C8544a;
import com.kwad.components.core.p287c.C8554g;
import com.kwad.components.core.p304n.p305a.p307b.InterfaceC8696a;
import com.kwad.sdk.components.C9861c;
import com.kwad.sdk.components.DevelopMangerComponents;
import com.kwad.sdk.core.adlog.C9908c;
import com.kwad.sdk.core.adlog.p388c.C9913b;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.p409b.C10487e;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.AbstractRunnableC11033ay;
import com.kwad.sdk.utils.C11095g;
import org.json.JSONObject;

/* renamed from: com.kwad.components.core.s.b */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C8934b {

    /* renamed from: SY */
    private static volatile C8934b f28850SY;

    private C8934b() {
    }

    @NonNull
    /* renamed from: qY */
    public static C8934b m29570qY() {
        if (f28850SY == null) {
            synchronized (C8934b.class) {
                if (f28850SY == null) {
                    f28850SY = new C8934b();
                }
            }
        }
        return f28850SY;
    }

    /* renamed from: a */
    public final boolean m29571a(final AdTemplate adTemplate, @Nullable JSONObject jSONObject, @Nullable C9913b c9913b) {
        boolean z = false;
        if (((DevelopMangerComponents) C9861c.m27501f(DevelopMangerComponents.class)) != null) {
            C10331c.m26254d("AdEventHelper", "processAdImpress notImpression: false");
        }
        if (c9913b != null) {
            c9913b.m27267b(adTemplate, null, null, null);
        }
        boolean m27331b = C9908c.m27331b(adTemplate, jSONObject, c9913b);
        try {
            SceneImpl sceneImpl = adTemplate.mAdScene;
            if (sceneImpl != null && sceneImpl.adStyle == 10000) {
                z = true;
            }
            int i = adTemplate.adStyle;
            if (i == 3 || i == 2 || i == 13 || z) {
                C10487e.m25641dQ(adTemplate);
                if (m27331b && C9861c.m27501f(InterfaceC8696a.class) != null) {
                    C9861c.m27501f(InterfaceC8696a.class);
                }
            }
        } catch (Throwable unused) {
        }
        C11095g.execute(new AbstractRunnableC11033ay() { // from class: com.kwad.components.core.s.b.1
            @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
            public final void doTask() {
                C8544a m30401mu = C8544a.m30401mu();
                if (m30401mu != null) {
                    m30401mu.m30399r(C10487e.m25631ea(adTemplate));
                }
            }
        });
        C8554g.m30373mF().m30376ak(adTemplate);
        return m27331b;
    }
}

package com.kwad.components.p208ad.reward.p252e;

import androidx.annotation.Nullable;
import com.kwad.components.core.p298i.C8675d;
import com.kwad.sdk.api.KsRewardVideoAd;
import java.util.HashMap;

/* renamed from: com.kwad.components.ad.reward.e.f */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C7885f {

    /* renamed from: ru */
    private static final HashMap<String, C7885f> f26500ru = new HashMap<>();
    private KsRewardVideoAd.RewardAdInteractionListener mInteractionListener;

    /* renamed from: oy */
    private C8675d f26501oy;

    /* renamed from: rv */
    private KsRewardVideoAd.RewardAdInteractionListener f26502rv;

    @Nullable
    /* renamed from: F */
    private static C7885f m32096F(String str) {
        return f26500ru.get(str);
    }

    /* renamed from: G */
    public static KsRewardVideoAd.RewardAdInteractionListener m32095G(String str) {
        C7885f m32096F = m32096F(str);
        if (m32096F != null) {
            return m32096F.f26502rv;
        }
        return null;
    }

    /* renamed from: H */
    public static void m32094H(String str) {
        C7885f m32096F = m32096F(str);
        if (m32096F != null) {
            m32096F.f26502rv = m32096F.mInteractionListener;
        }
    }

    /* renamed from: I */
    public static C8675d m32093I(String str) {
        C7885f m32096F = m32096F(str);
        if (m32096F != null) {
            return m32096F.f26501oy;
        }
        return null;
    }

    /* renamed from: J */
    public static void m32092J(String str) {
        C7885f m32096F = m32096F(str);
        if (m32096F != null) {
            m32096F.destroy();
            f26500ru.put(str, null);
        }
    }

    /* renamed from: a */
    public static void m32091a(String str, KsRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener, C8675d c8675d) {
        C7885f c7885f = new C7885f();
        c7885f.mInteractionListener = rewardAdInteractionListener;
        c7885f.f26501oy = c8675d;
        c7885f.f26502rv = rewardAdInteractionListener;
        f26500ru.put(str, c7885f);
    }

    private void destroy() {
        this.mInteractionListener = null;
        this.f26502rv = null;
        C8675d c8675d = this.f26501oy;
        if (c8675d != null) {
            c8675d.destroy();
            this.f26501oy = null;
        }
    }
}

package com.kwad.components.p208ad.reward.model;

import android.content.Intent;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.kwad.components.core.internal.api.C8681e;
import com.kwad.components.core.p287c.C8552f;
import com.kwad.components.p208ad.reward.KSRewardVideoActivityProxy;
import com.kwad.components.p208ad.reward.p248a.C7844b;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.core.config.C10251d;
import com.kwad.sdk.core.diskcache.p394b.C10291a;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.core.response.model.AdGlobalConfigInfo;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.p409b.C10483a;
import com.kwad.sdk.core.response.p409b.C10485c;
import com.kwad.sdk.core.response.p409b.C10487e;
import com.kwad.sdk.utils.C11126t;
import java.io.File;
import java.io.Serializable;
import org.json.JSONObject;

/* renamed from: com.kwad.components.ad.reward.model.c */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C8028c {
    private AdInfo mAdInfo;
    private AdResultData mAdResultData;
    private AdTemplate mAdTemplate;
    private JSONObject mReportExtData;
    public int mScreenOrientation;
    private KsVideoPlayConfig mVideoPlayConfig;
    private int rewardType = 1;

    /* renamed from: gt */
    public final boolean f26769gt = C7844b.m32191gD();

    @Nullable
    /* renamed from: a */
    public static C8028c m31796a(Intent intent) {
        KsVideoPlayConfig ksVideoPlayConfig;
        if (C10251d.m26555CG()) {
            ksVideoPlayConfig = C8681e.m30024b(intent.getStringExtra("key_video_play_config_json"), true);
        } else {
            Serializable serializableExtra = intent.getSerializableExtra("key_video_play_config");
            if (!(serializableExtra instanceof KsVideoPlayConfig)) {
                C10331c.m26250e("RewardActivityModel", "data is not instanceof VideoPlayConfigImpl:" + serializableExtra);
                return null;
            }
            ksVideoPlayConfig = (KsVideoPlayConfig) serializableExtra;
        }
        int intExtra = intent.getIntExtra(KSRewardVideoActivityProxy.KEY_REWARD_TYPE, 1);
        try {
            AdResultData m30380d = C8552f.m30378mE().m30380d(intent.getIntExtra("key_ad_result_cache_idx", 0), true);
            if (m30380d == null) {
                return null;
            }
            return m31795a(m30380d, intExtra, ksVideoPlayConfig);
        } catch (Throwable th) {
            C10331c.printStackTraceOnly(th);
            return null;
        }
    }

    /* renamed from: c */
    private static boolean m31792c(AdTemplate adTemplate, AdInfo adInfo) {
        if (!C10251d.m26555CG() && C10487e.m25625eg(adTemplate) < 0) {
            File m26391bV = C10291a.m26395Dc().m26391bV(C10483a.m25977K(adInfo));
            if (m26391bV == null || !m26391bV.exists()) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: bH */
    public final AdInfo m31794bH() {
        return this.mAdInfo;
    }

    /* renamed from: bI */
    public final boolean m31793bI() {
        return C10487e.m25629ec(this.mAdTemplate);
    }

    public final AdTemplate getAdTemplate() {
        return this.mAdTemplate;
    }

    public final int getScreenOrientation() {
        return this.mScreenOrientation;
    }

    /* renamed from: hi */
    public final boolean m31791hi() {
        return C10487e.m25624i(getAdTemplate(), C7844b.m32176k(m31794bH()));
    }

    /* renamed from: hj */
    public final boolean m31790hj() {
        return C10487e.m25654F(getAdTemplate());
    }

    /* renamed from: hk */
    public final AdResultData m31789hk() {
        return this.mAdResultData;
    }

    /* renamed from: hl */
    public final KsVideoPlayConfig m31788hl() {
        return this.mVideoPlayConfig;
    }

    /* renamed from: hm */
    public final int m31787hm() {
        return this.rewardType;
    }

    /* renamed from: hn */
    public final JSONObject m31786hn() {
        return this.mReportExtData;
    }

    /* renamed from: ho */
    public final AdGlobalConfigInfo m31785ho() {
        AdResultData adResultData = this.mAdResultData;
        if (adResultData != null) {
            return adResultData.adGlobalConfigInfo;
        }
        return null;
    }

    @Nullable
    /* renamed from: a */
    private static C8028c m31795a(AdResultData adResultData, int i, KsVideoPlayConfig ksVideoPlayConfig) {
        C8028c c8028c = new C8028c();
        AdTemplate m25661n = C10485c.m25661n(adResultData);
        if (m25661n == null) {
            C10331c.m26250e("RewardActivityModel", "data is null:");
            return null;
        }
        AdInfo m25641dQ = C10487e.m25641dQ(m25661n);
        if (m31792c(m25661n, m25641dQ)) {
            boolean isShowLandscape = ksVideoPlayConfig.isShowLandscape();
            m25661n.mInitVoiceStatus = ksVideoPlayConfig.isVideoSoundEnable() ? 2 : 1;
            if (!TextUtils.isEmpty(ksVideoPlayConfig.getShowScene())) {
                JSONObject jSONObject = new JSONObject();
                C11126t.putValue(jSONObject, "ext_showscene", ksVideoPlayConfig.getShowScene());
                c8028c.mReportExtData = jSONObject;
            }
            c8028c.mVideoPlayConfig = ksVideoPlayConfig;
            c8028c.mAdResultData = adResultData;
            c8028c.mAdTemplate = m25661n;
            c8028c.mAdInfo = m25641dQ;
            c8028c.mScreenOrientation = isShowLandscape ? 1 : 0;
            c8028c.rewardType = i;
            return c8028c;
        }
        return null;
    }
}

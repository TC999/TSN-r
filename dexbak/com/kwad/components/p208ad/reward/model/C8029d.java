package com.kwad.components.p208ad.reward.model;

import com.bytedance.android.live.base.api.push.ILivePush;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.p409b.C10483a;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;

/* renamed from: com.kwad.components.ad.reward.model.d */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C8029d {
    /* renamed from: m */
    public static String m31784m(AdInfo adInfo) {
        return C10483a.m25842cL(adInfo) ? ILivePush.ClickType.LIVE : C10483a.m25876bd(adInfo) ? SocializeProtocolConstants.IMAGE : C10483a.m25884bX(adInfo) ? "reward_preview" : "video";
    }
}

package com.iab.omid.library.mmadbridge.adsession.media;

import com.iab.omid.library.mmadbridge.adsession.AbstractC7075b;
import com.iab.omid.library.mmadbridge.adsession.C7081h;
import com.iab.omid.library.mmadbridge.p202b.C7092f;
import com.iab.omid.library.mmadbridge.p204d.C7101b;
import com.iab.omid.library.mmadbridge.p204d.C7105e;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import org.json.JSONObject;

/* renamed from: com.iab.omid.library.mmadbridge.adsession.media.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C7082a {

    /* renamed from: a */
    private final C7081h f24221a;

    private C7082a(C7081h c7081h) {
        this.f24221a = c7081h;
    }

    /* renamed from: e */
    private void m34777e(float f) {
        if (f <= 0.0f) {
            throw new IllegalArgumentException("Invalid Media duration");
        }
    }

    /* renamed from: f */
    private void m34776f(float f) {
        if (f < 0.0f || f > 1.0f) {
            throw new IllegalArgumentException("Invalid Media volume");
        }
    }

    /* renamed from: g */
    public static C7082a m34775g(AbstractC7075b abstractC7075b) {
        C7081h c7081h = (C7081h) abstractC7075b;
        C7105e.m34671d(abstractC7075b, "AdSession is null");
        C7105e.m34663l(c7081h);
        C7105e.m34672c(c7081h);
        C7105e.m34668g(c7081h);
        C7105e.m34665j(c7081h);
        C7082a c7082a = new C7082a(c7081h);
        c7081h.mo34802f().m34644i(c7082a);
        return c7082a;
    }

    /* renamed from: a */
    public void m34781a(InteractionType interactionType) {
        C7105e.m34671d(interactionType, "InteractionType is null");
        C7105e.m34667h(this.f24221a);
        JSONObject jSONObject = new JSONObject();
        C7101b.m34688h(jSONObject, "interactionType", interactionType);
        this.f24221a.mo34802f().m34641l("adUserInteraction", jSONObject);
    }

    /* renamed from: b */
    public void m34780b() {
        C7105e.m34667h(this.f24221a);
        this.f24221a.mo34802f().m34643j("bufferFinish");
    }

    /* renamed from: c */
    public void m34779c() {
        C7105e.m34667h(this.f24221a);
        this.f24221a.mo34802f().m34643j("bufferStart");
    }

    /* renamed from: d */
    public void m34778d() {
        C7105e.m34667h(this.f24221a);
        this.f24221a.mo34802f().m34643j(CampaignEx.JSON_NATIVE_VIDEO_COMPLETE);
    }

    /* renamed from: h */
    public void m34774h() {
        C7105e.m34667h(this.f24221a);
        this.f24221a.mo34802f().m34643j("firstQuartile");
    }

    /* renamed from: i */
    public void m34773i() {
        C7105e.m34667h(this.f24221a);
        this.f24221a.mo34802f().m34643j(CampaignEx.JSON_NATIVE_VIDEO_MIDPOINT);
    }

    /* renamed from: j */
    public void m34772j() {
        C7105e.m34667h(this.f24221a);
        this.f24221a.mo34802f().m34643j(CampaignEx.JSON_NATIVE_VIDEO_PAUSE);
    }

    /* renamed from: k */
    public void m34771k(PlayerState playerState) {
        C7105e.m34671d(playerState, "PlayerState is null");
        C7105e.m34667h(this.f24221a);
        JSONObject jSONObject = new JSONObject();
        C7101b.m34688h(jSONObject, "state", playerState);
        this.f24221a.mo34802f().m34641l("playerStateChange", jSONObject);
    }

    /* renamed from: l */
    public void m34770l() {
        C7105e.m34667h(this.f24221a);
        this.f24221a.mo34802f().m34643j(CampaignEx.JSON_NATIVE_VIDEO_RESUME);
    }

    /* renamed from: m */
    public void m34769m() {
        C7105e.m34667h(this.f24221a);
        this.f24221a.mo34802f().m34643j("skipped");
    }

    /* renamed from: n */
    public void m34768n(float f, float f2) {
        m34777e(f);
        m34776f(f2);
        C7105e.m34667h(this.f24221a);
        JSONObject jSONObject = new JSONObject();
        C7101b.m34688h(jSONObject, "duration", Float.valueOf(f));
        C7101b.m34688h(jSONObject, "mediaPlayerVolume", Float.valueOf(f2));
        C7101b.m34688h(jSONObject, "deviceVolume", Float.valueOf(C7092f.m34717b().m34713f()));
        this.f24221a.mo34802f().m34641l(CampaignEx.JSON_NATIVE_VIDEO_START, jSONObject);
    }

    /* renamed from: o */
    public void m34767o() {
        C7105e.m34667h(this.f24221a);
        this.f24221a.mo34802f().m34643j("thirdQuartile");
    }

    /* renamed from: p */
    public void m34766p(float f) {
        m34776f(f);
        C7105e.m34667h(this.f24221a);
        JSONObject jSONObject = new JSONObject();
        C7101b.m34688h(jSONObject, "mediaPlayerVolume", Float.valueOf(f));
        C7101b.m34688h(jSONObject, "deviceVolume", Float.valueOf(C7092f.m34717b().m34713f()));
        this.f24221a.mo34802f().m34641l("volumeChange", jSONObject);
    }
}

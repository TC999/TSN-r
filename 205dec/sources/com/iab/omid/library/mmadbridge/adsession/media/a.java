package com.iab.omid.library.mmadbridge.adsession.media;

import com.iab.omid.library.mmadbridge.adsession.h;
import com.iab.omid.library.mmadbridge.b.f;
import com.iab.omid.library.mmadbridge.d.e;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private final h f37703a;

    private a(h hVar) {
        this.f37703a = hVar;
    }

    private void e(float f4) {
        if (f4 <= 0.0f) {
            throw new IllegalArgumentException("Invalid Media duration");
        }
    }

    private void f(float f4) {
        if (f4 < 0.0f || f4 > 1.0f) {
            throw new IllegalArgumentException("Invalid Media volume");
        }
    }

    public static a g(com.iab.omid.library.mmadbridge.adsession.b bVar) {
        h hVar = (h) bVar;
        e.d(bVar, "AdSession is null");
        e.l(hVar);
        e.c(hVar);
        e.g(hVar);
        e.j(hVar);
        a aVar = new a(hVar);
        hVar.f().i(aVar);
        return aVar;
    }

    public void a(InteractionType interactionType) {
        e.d(interactionType, "InteractionType is null");
        e.h(this.f37703a);
        JSONObject jSONObject = new JSONObject();
        com.iab.omid.library.mmadbridge.d.b.h(jSONObject, "interactionType", interactionType);
        this.f37703a.f().l("adUserInteraction", jSONObject);
    }

    public void b() {
        e.h(this.f37703a);
        this.f37703a.f().j("bufferFinish");
    }

    public void c() {
        e.h(this.f37703a);
        this.f37703a.f().j("bufferStart");
    }

    public void d() {
        e.h(this.f37703a);
        this.f37703a.f().j(CampaignEx.JSON_NATIVE_VIDEO_COMPLETE);
    }

    public void h() {
        e.h(this.f37703a);
        this.f37703a.f().j("firstQuartile");
    }

    public void i() {
        e.h(this.f37703a);
        this.f37703a.f().j(CampaignEx.JSON_NATIVE_VIDEO_MIDPOINT);
    }

    public void j() {
        e.h(this.f37703a);
        this.f37703a.f().j(CampaignEx.JSON_NATIVE_VIDEO_PAUSE);
    }

    public void k(PlayerState playerState) {
        e.d(playerState, "PlayerState is null");
        e.h(this.f37703a);
        JSONObject jSONObject = new JSONObject();
        com.iab.omid.library.mmadbridge.d.b.h(jSONObject, "state", playerState);
        this.f37703a.f().l("playerStateChange", jSONObject);
    }

    public void l() {
        e.h(this.f37703a);
        this.f37703a.f().j(CampaignEx.JSON_NATIVE_VIDEO_RESUME);
    }

    public void m() {
        e.h(this.f37703a);
        this.f37703a.f().j("skipped");
    }

    public void n(float f4, float f5) {
        e(f4);
        f(f5);
        e.h(this.f37703a);
        JSONObject jSONObject = new JSONObject();
        com.iab.omid.library.mmadbridge.d.b.h(jSONObject, "duration", Float.valueOf(f4));
        com.iab.omid.library.mmadbridge.d.b.h(jSONObject, "mediaPlayerVolume", Float.valueOf(f5));
        com.iab.omid.library.mmadbridge.d.b.h(jSONObject, "deviceVolume", Float.valueOf(f.b().f()));
        this.f37703a.f().l(CampaignEx.JSON_NATIVE_VIDEO_START, jSONObject);
    }

    public void o() {
        e.h(this.f37703a);
        this.f37703a.f().j("thirdQuartile");
    }

    public void p(float f4) {
        f(f4);
        e.h(this.f37703a);
        JSONObject jSONObject = new JSONObject();
        com.iab.omid.library.mmadbridge.d.b.h(jSONObject, "mediaPlayerVolume", Float.valueOf(f4));
        com.iab.omid.library.mmadbridge.d.b.h(jSONObject, "deviceVolume", Float.valueOf(f.b().f()));
        this.f37703a.f().l("volumeChange", jSONObject);
    }
}

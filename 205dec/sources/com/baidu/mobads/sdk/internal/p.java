package com.baidu.mobads.sdk.internal;

import com.baidu.mobads.sdk.api.NativeResponse;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class p implements NativeResponse.CustomizeMediaPlayer {

    /* renamed from: a  reason: collision with root package name */
    private static final String f12889a = "vstart";

    /* renamed from: b  reason: collision with root package name */
    private static final String f12890b = "vrepeatedplay";

    /* renamed from: c  reason: collision with root package name */
    private static final String f12891c = "vclose";

    /* renamed from: d  reason: collision with root package name */
    private static final String f12892d = "vreadyplay";

    /* renamed from: e  reason: collision with root package name */
    private static final String f12893e = "vplayfail";

    /* renamed from: f  reason: collision with root package name */
    private static final String f12894f = "vmute";

    /* renamed from: g  reason: collision with root package name */
    private static final String f12895g = "vfrozen";

    /* renamed from: h  reason: collision with root package name */
    private static final String f12896h = "vshow";

    /* renamed from: i  reason: collision with root package name */
    private static final String f12897i = "curTimeSec";

    /* renamed from: j  reason: collision with root package name */
    private static final String f12898j = "startTimeSec";

    /* renamed from: k  reason: collision with root package name */
    private static final String f12899k = "autoPlay";

    /* renamed from: l  reason: collision with root package name */
    private static final String f12900l = "reasonValue";

    /* renamed from: m  reason: collision with root package name */
    private final dm f12901m;

    /* renamed from: n  reason: collision with root package name */
    private final a f12902n;

    /* renamed from: o  reason: collision with root package name */
    private boolean f12903o = false;

    /* renamed from: p  reason: collision with root package name */
    private int f12904p = 0;

    public p(dm dmVar, a aVar) {
        this.f12901m = dmVar;
        this.f12902n = aVar;
    }

    private void a(String str, JSONObject jSONObject) {
        a aVar;
        JSONObject T;
        if (this.f12901m == null || (aVar = this.f12902n) == null || (T = aVar.T()) == null) {
            return;
        }
        try {
            T.put("msg", "sendVideoThirdLog");
            T.put("trackType", str);
            T.put("trackInfo", jSONObject);
            this.f12901m.a(T);
        } catch (Throwable th) {
            bv.a().d(th.getMessage());
        }
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse.CustomizeMediaPlayer
    public String getVideoUrl() {
        a aVar = this.f12902n;
        if (aVar != null) {
            return aVar.n();
        }
        return null;
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse.CustomizeMediaPlayer
    public void reportPlayError(int i4) {
        a("vplayfail", a(this.f12904p, i4, this.f12903o, 0));
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse.CustomizeMediaPlayer
    public void reportPlayFrozen(int i4) {
        a("vfrozen", a(this.f12904p, i4, this.f12903o, 0));
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse.CustomizeMediaPlayer
    public void reportPlayerReady() {
        a("vreadyplay", a(0, 0, false, 0));
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse.CustomizeMediaPlayer
    public void reportVideoMuteChange(int i4, boolean z3) {
        a("vmute", a(this.f12904p, i4, this.f12903o, z3 ? 2 : 1));
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse.CustomizeMediaPlayer
    public void reportVideoPause(int i4, NativeResponse.VideoReason videoReason) {
        a("vclose", a(this.f12904p, i4, this.f12903o, videoReason.getCode()));
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse.CustomizeMediaPlayer
    public void reportVideoReplay() {
        this.f12904p = 0;
        a("vrepeatedplay", a(0, 0, this.f12903o, 0));
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse.CustomizeMediaPlayer
    public void reportVideoResume(int i4) {
        this.f12904p = i4;
        a("vstart", a(i4, i4, this.f12903o, 0));
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse.CustomizeMediaPlayer
    public void reportVideoShow() {
        a("vshow", a(0, 0, false, 7));
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse.CustomizeMediaPlayer
    public void reportVideoStart(boolean z3) {
        this.f12904p = 0;
        this.f12903o = z3;
        a("vstart", a(0, 0, z3, 0));
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse.CustomizeMediaPlayer
    public void reportVideoStop(int i4, NativeResponse.VideoReason videoReason) {
        a("vclose", a(this.f12904p, i4, this.f12903o, videoReason.getCode()));
    }

    private JSONObject a(int i4, int i5, boolean z3, int i6) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("startTimeSec", i4 / 1000);
            jSONObject.put("curTimeSec", i5 / 1000);
            jSONObject.put("autoPlay", z3);
            jSONObject.put("reasonValue", i6);
        } catch (Throwable th) {
            bv.a().d(th.getMessage());
        }
        return jSONObject;
    }
}

package com.baidu.mobads.sdk.internal;

import com.baidu.mobads.sdk.api.NativeResponse;
import org.json.JSONObject;

/* renamed from: com.baidu.mobads.sdk.internal.p */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class C2719p implements NativeResponse.CustomizeMediaPlayer {

    /* renamed from: a */
    private static final String f9103a = "vstart";

    /* renamed from: b */
    private static final String f9104b = "vrepeatedplay";

    /* renamed from: c */
    private static final String f9105c = "vclose";

    /* renamed from: d */
    private static final String f9106d = "vreadyplay";

    /* renamed from: e */
    private static final String f9107e = "vplayfail";

    /* renamed from: f */
    private static final String f9108f = "vmute";

    /* renamed from: g */
    private static final String f9109g = "vfrozen";

    /* renamed from: h */
    private static final String f9110h = "vshow";

    /* renamed from: i */
    private static final String f9111i = "curTimeSec";

    /* renamed from: j */
    private static final String f9112j = "startTimeSec";

    /* renamed from: k */
    private static final String f9113k = "autoPlay";

    /* renamed from: l */
    private static final String f9114l = "reasonValue";

    /* renamed from: m */
    private final C2692dj f9115m;

    /* renamed from: n */
    private final C2573a f9116n;

    /* renamed from: o */
    private boolean f9117o = false;

    /* renamed from: p */
    private int f9118p = 0;

    public C2719p(C2692dj c2692dj, C2573a c2573a) {
        this.f9115m = c2692dj;
        this.f9116n = c2573a;
    }

    /* renamed from: a */
    private void m50351a(String str, JSONObject jSONObject) {
        C2573a c2573a;
        JSONObject m51110T;
        if (this.f9115m == null || (c2573a = this.f9116n) == null || (m51110T = c2573a.m51110T()) == null) {
            return;
        }
        try {
            m51110T.put("msg", "sendVideoThirdLog");
            m51110T.put("trackType", str);
            m51110T.put("trackInfo", jSONObject);
            this.f9115m.m50819a(m51110T);
        } catch (Throwable th) {
            C2634bs.m50744a().m50727d(th.getMessage());
        }
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse.CustomizeMediaPlayer
    public String getVideoUrl() {
        C2573a c2573a = this.f9116n;
        if (c2573a != null) {
            return c2573a.m51089n();
        }
        return null;
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse.CustomizeMediaPlayer
    public void reportPlayError(int i) {
        m50351a(f9107e, m50352a(this.f9118p, i, this.f9117o, 0));
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse.CustomizeMediaPlayer
    public void reportPlayFrozen(int i) {
        m50351a(f9109g, m50352a(this.f9118p, i, this.f9117o, 0));
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse.CustomizeMediaPlayer
    public void reportPlayerReady() {
        m50351a(f9106d, m50352a(0, 0, false, 0));
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse.CustomizeMediaPlayer
    public void reportVideoMuteChange(int i, boolean z) {
        m50351a(f9108f, m50352a(this.f9118p, i, this.f9117o, z ? 2 : 1));
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse.CustomizeMediaPlayer
    public void reportVideoPause(int i, NativeResponse.VideoReason videoReason) {
        m50351a(f9105c, m50352a(this.f9118p, i, this.f9117o, videoReason.getCode()));
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse.CustomizeMediaPlayer
    public void reportVideoReplay() {
        this.f9118p = 0;
        m50351a(f9104b, m50352a(0, 0, this.f9117o, 0));
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse.CustomizeMediaPlayer
    public void reportVideoResume(int i) {
        this.f9118p = i;
        m50351a(f9103a, m50352a(i, i, this.f9117o, 0));
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse.CustomizeMediaPlayer
    public void reportVideoShow() {
        m50351a(f9110h, m50352a(0, 0, false, 7));
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse.CustomizeMediaPlayer
    public void reportVideoStart(boolean z) {
        this.f9118p = 0;
        this.f9117o = z;
        m50351a(f9103a, m50352a(0, 0, z, 0));
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse.CustomizeMediaPlayer
    public void reportVideoStop(int i, NativeResponse.VideoReason videoReason) {
        m50351a(f9105c, m50352a(this.f9118p, i, this.f9117o, videoReason.getCode()));
    }

    /* renamed from: a */
    private JSONObject m50352a(int i, int i2, boolean z, int i3) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(f9112j, i / 1000);
            jSONObject.put(f9111i, i2 / 1000);
            jSONObject.put(f9113k, z);
            jSONObject.put(f9114l, i3);
        } catch (Throwable th) {
            C2634bs.m50744a().m50727d(th.getMessage());
        }
        return jSONObject;
    }
}

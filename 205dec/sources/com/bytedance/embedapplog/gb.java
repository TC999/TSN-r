package com.bytedance.embedapplog;

import android.content.Context;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class gb extends i {

    /* renamed from: f  reason: collision with root package name */
    private final n f26731f;
    private final Context ux;

    /* JADX INFO: Access modifiers changed from: package-private */
    public gb(Context context, n nVar) {
        super(false, false);
        this.ux = context;
        this.f26731f = nVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.embedapplog.i
    public boolean c(JSONObject jSONObject) {
        jSONObject.put("sdk_version", MediaPlayer.MEDIA_PLAYER_OPTION_GET_VIDEO_DEVICE_WAIT_START_TIME);
        jSONObject.put("sdk_version_name", "3.9.1.baseChina-rc.21");
        jSONObject.put("channel", this.f26731f.p());
        ck.c(jSONObject, "aid", this.f26731f.gd());
        ck.c(jSONObject, "release_build", this.f26731f.n());
        ck.c(jSONObject, "app_region", this.f26731f.bk());
        ck.c(jSONObject, "app_language", this.f26731f.a());
        ck.c(jSONObject, "user_agent", this.f26731f.ck());
        ck.c(jSONObject, "ab_sdk_version", this.f26731f.ys());
        ck.c(jSONObject, "ab_version", this.f26731f.fz());
        ck.c(jSONObject, "aliyun_uuid", this.f26731f.c());
        String k4 = this.f26731f.k();
        if (TextUtils.isEmpty(k4)) {
            k4 = h.c(this.ux, this.f26731f);
        }
        if (!TextUtils.isEmpty(k4)) {
            ck.c(jSONObject, "google_aid", k4);
        }
        String gb = this.f26731f.gb();
        if (!TextUtils.isEmpty(gb)) {
            try {
                jSONObject.put("app_track", new JSONObject(gb));
            } catch (Throwable th) {
                be.w(th);
            }
        }
        String t3 = this.f26731f.t();
        if (t3 != null && t3.length() > 0) {
            jSONObject.put("custom", new JSONObject(t3));
        }
        ck.c(jSONObject, "user_unique_id", this.f26731f.fp());
        return true;
    }
}

package com.qq.e.comm.plugin.n0;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.concurrent.Future;
import org.json.JSONObject;
import yaq.pro;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class s {
    private static com.qq.e.comm.plugin.i0.n.f a(String str, String str2) {
        return (com.qq.e.comm.plugin.i0.n.f) pro.getobjresult(MediaPlayer.MEDIA_PLAYER_OPTION_CMAF_HTTP_REQ_FINISH_TIME, 1, str, str2);
    }

    private static Future<com.qq.e.comm.plugin.i0.n.g> a(String str, JSONObject jSONObject) {
        return (Future) pro.getobjresult(MediaPlayer.MEDIA_PLAYER_OPTION_CMAF_HTTP_RES_FINISH_TIME, 1, str, jSONObject);
    }

    public static Future<com.qq.e.comm.plugin.i0.n.g> a(JSONObject jSONObject) {
        return (Future) pro.getobjresult(MediaPlayer.MEDIA_PLAYER_OPTION_CMAF_MPD_DNS_TIME, 1, jSONObject);
    }

    static Future<com.qq.e.comm.plugin.i0.n.g> b(JSONObject jSONObject) {
        return (Future) pro.getobjresult(MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_PARAM_SEND_OUTLET_TIME, 1, jSONObject);
    }
}

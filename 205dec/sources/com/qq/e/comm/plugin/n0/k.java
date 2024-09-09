package com.qq.e.comm.plugin.n0;

import android.os.Build;
import android.text.TextUtils;
import android.util.Pair;
import com.bykv.vk.component.ttvideo.LiveConfigKey;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.qq.e.comm.plugin.util.a2;
import com.qq.e.comm.plugin.util.d1;
import com.qq.e.comm.plugin.util.e1;
import com.qq.e.comm.plugin.util.f0;
import com.qq.e.comm.plugin.util.j0;
import com.qq.e.comm.plugin.util.v0;
import com.qq.e.comm.plugin.util.y;
import java.util.Iterator;
import java.util.Locale;
import java.util.TimeZone;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;
import xyz.adscope.ad.model.http.request.ad.constant.AdRequestConstant;
import yaq.pro;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
class k {

    /* renamed from: a  reason: collision with root package name */
    private static final String f44776a = UUID.randomUUID().toString();

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    private static final class a {

        /* renamed from: a  reason: collision with root package name */
        private JSONObject f44777a;

        a() {
            j0 j0Var = new j0();
            j0Var.a("pkg", com.qq.e.comm.plugin.d0.a.d().b().b());
            j0Var.a(AdRequestConstant.AD_REQUEST_DEVICE_EXT_AV_KEY, com.qq.e.comm.plugin.d0.a.d().b().d());
            j0Var.a("sv", e1.i());
            j0Var.a("plv", com.qq.e.comm.plugin.d0.a.d().e().b());
            j0Var.a("sdk_st", e1.g());
            j0Var.a("sdk_cnl", e1.d());
            j0Var.a("ov", Build.VERSION.RELEASE);
            j0Var.a(CampaignEx.JSON_KEY_AD_AL, Build.VERSION.SDK_INT);
            j0Var.a("os", 2);
            String a4 = com.qq.e.comm.plugin.m.b.f44639e.a(com.qq.e.comm.plugin.d0.a.d().a());
            j0Var.a("imei", a4);
            j0Var.a("st", 2);
            j0Var.a("muid", a4);
            j0Var.a(LiveConfigKey.MEDIUM, com.qq.e.comm.plugin.d0.a.d().c().f42280j);
            j0Var.a("pl", Build.FINGERPRINT);
            j0Var.a("mn", Build.PRODUCT);
            Pair<Integer, Integer> b4 = y.b();
            if (((Integer) b4.first).intValue() > ((Integer) b4.second).intValue()) {
                j0Var.a("w", b4.second);
                j0Var.a("h", b4.first);
            } else {
                j0Var.a("w", b4.first);
                j0Var.a("h", b4.second);
            }
            j0Var.a("lid", k.a());
            String e4 = e1.e();
            if (!TextUtils.isEmpty(e4)) {
                j0Var.a("sdk_ex1", e4);
            }
            String f4 = e1.f();
            if (!TextUtils.isEmpty(f4)) {
                j0Var.a("sdk_ex2", f4);
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.putOpt("is_harmony_os", Boolean.valueOf(f0.c()));
                jSONObject.putOpt("os_version", f0.a());
                jSONObject.putOpt("harmony_pure_mode", Integer.valueOf(f0.b()));
                j0Var.a("harmony_sys_info", jSONObject);
            } catch (JSONException e5) {
                d1.a(e5.getMessage(), e5);
            }
            this.f44777a = j0Var.a();
        }

        j0 a() {
            j0 j0Var = new j0();
            j0Var.a("ts", System.currentTimeMillis());
            j0Var.a("app", com.qq.e.comm.plugin.d0.a.d().b().a());
            j0Var.a("ct", com.qq.e.comm.plugin.d0.a.d().c().n().a());
            String a4 = v0.a();
            if (!TextUtils.isEmpty(a4)) {
                j0Var.a("cell_native", a4);
            }
            j0Var.a("lg", Locale.getDefault().getLanguage());
            TimeZone timeZone = TimeZone.getDefault();
            j0Var.a("tz", timeZone.getID());
            try {
                j0Var.a("gmt_tz", timeZone.getDisplayName(false, 0));
            } catch (Throwable unused) {
            }
            j0Var.a("ca", com.qq.e.comm.plugin.d0.a.d().c().b().a());
            Iterator<String> keys = this.f44777a.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                j0Var.a(next, this.f44777a.opt(next));
            }
            a2.a(j0Var, "/log or /event");
            return j0Var;
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    private static final class b {

        /* renamed from: a  reason: collision with root package name */
        private static final a f44778a = new a();
    }

    static /* synthetic */ String a() {
        return (String) pro.getobjresult(MediaPlayer.MEDIA_PLAYER_OPTION_FIRST_VIDEO_SEND_OUTLET_TIME, 1, new Object[0]);
    }

    public static j0 b() {
        return (j0) pro.getobjresult(MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_TIMESCALE_ENABLE, 1, new Object[0]);
    }

    private static j0 c() {
        return (j0) pro.getobjresult(MediaPlayer.MEDIA_PLAYER_OPTION_AVNOSYNC_REPORT_THRES, 1, new Object[0]);
    }
}

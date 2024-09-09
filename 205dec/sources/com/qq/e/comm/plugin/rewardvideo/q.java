package com.qq.e.comm.plugin.rewardvideo;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.qq.e.ads.rewardvideo.ServerSideVerificationOptions;
import com.qq.e.comm.plugin.g0.f0;
import com.qq.e.comm.plugin.n0.v;
import com.qq.e.comm.plugin.util.a0;
import com.qq.e.comm.plugin.util.s0;
import org.json.JSONException;
import org.json.JSONObject;
import yaq.pro;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class q {

    /* renamed from: a  reason: collision with root package name */
    private static final boolean f46003a;

    static {
        f46003a = com.qq.e.comm.plugin.d0.a.d().f().a("rcrmc", 0) == 0;
    }

    public static int a(String str) {
        return com.qq.e.comm.plugin.t.c.a("rewardLoadAdCount", str, 1);
    }

    public static void a(Context context, f0 f0Var) {
        pro.getVresult(MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_RANGE_SIZE, 1, context, f0Var);
    }

    public static void a(com.qq.e.comm.plugin.g0.e eVar, m mVar, ServerSideVerificationOptions serverSideVerificationOptions) {
        pro.getVresult(244, 1, eVar, mVar, serverSideVerificationOptions);
    }

    public static int b(com.qq.e.comm.plugin.g0.e eVar) {
        return com.qq.e.comm.plugin.t.c.a("rewardVideoCardShowTime", eVar.q0(), 4, eVar.p0());
    }

    public static int c(com.qq.e.comm.plugin.g0.e eVar) {
        int a4 = com.qq.e.comm.plugin.d0.a.d().f().a(eVar.o().g() ? "ifcfsvdgest" : "rvfsvdgest", eVar.q0(), -1);
        return a4 <= 100 ? a4 : com.qq.e.comm.plugin.t.a.b().a(eVar.p0(), String.valueOf(a4), -1);
    }

    public static boolean d(String str) {
        return com.qq.e.comm.plugin.d0.a.d().f().a("sksrppe", str, 1) == 1;
    }

    public static int e(com.qq.e.comm.plugin.g0.e eVar) {
        int a4 = com.qq.e.comm.plugin.d0.a.d().f().a("rvccd", -1);
        if (a4 > 10000) {
            a4 = com.qq.e.comm.plugin.t.a.b().a(eVar.p0(), String.valueOf(a4), -1);
        }
        if (a4 <= -1) {
            return -1;
        }
        return a4 * 100;
    }

    public static boolean a() {
        return com.qq.e.comm.plugin.d0.a.d().f().a("bxgrvbc", 0) == 1;
    }

    public static Pair<String, Boolean> d(com.qq.e.comm.plugin.g0.e eVar) {
        if (eVar == null) {
            return new Pair<>("\u5956\u52b1", Boolean.FALSE);
        }
        String y02 = eVar.y0();
        if (!TextUtils.isEmpty(y02)) {
            return new Pair<>(y02, Boolean.TRUE);
        }
        return new Pair<>(com.qq.e.comm.plugin.t.c.a("te_rarn", eVar.q0(), "\u5956\u52b1", eVar.p0()), Boolean.FALSE);
    }

    public static JSONObject a(Context context, com.qq.e.comm.plugin.g0.e eVar) throws JSONException {
        JSONObject jSONObject = new JSONObject(eVar.m());
        if (com.qq.e.comm.plugin.util.c.a(context, eVar) || !eVar.X0()) {
            jSONObject.put("custom_button_txt", eVar.B());
            jSONObject.put("dpa_custom_button_txt", a0.a(eVar) ? eVar.I().f43728f : "");
        }
        return jSONObject;
    }

    public static String b(String str) {
        return !TextUtils.isEmpty(str) ? s0.a(str) : "";
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    static class a implements com.qq.e.comm.plugin.i0.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ com.qq.e.comm.plugin.n0.c f46004a;

        a(com.qq.e.comm.plugin.n0.c cVar) {
            this.f46004a = cVar;
        }

        @Override // com.qq.e.comm.plugin.i0.b
        public void a(com.qq.e.comm.plugin.i0.n.f fVar, com.qq.e.comm.plugin.i0.n.g gVar) {
            int i4;
            if (gVar != null) {
                i4 = gVar.getStatusCode();
                if (i4 == 200) {
                    v.a(1020075, this.f46004a);
                    return;
                }
            } else {
                i4 = 3000;
            }
            v.a(1020076, this.f46004a, Integer.valueOf(i4), 3005, null);
        }

        @Override // com.qq.e.comm.plugin.i0.b
        public void a(com.qq.e.comm.plugin.i0.n.f fVar, Exception exc) {
            v.b(1020076, this.f46004a, 3000);
        }
    }

    public static int a(com.qq.e.comm.plugin.g0.e eVar, boolean z3) {
        if (z3) {
            return 1;
        }
        return a0.a(eVar) ? 2 : 0;
    }

    public static int a(com.qq.e.comm.plugin.g0.e eVar) {
        return com.qq.e.comm.plugin.t.c.a("racest", eVar.q0(), 4, eVar.p0());
    }

    public static boolean c(String str) {
        return com.qq.e.comm.plugin.d0.a.d().f().a("sksrpaje", str, 1) == 1;
    }
}

package com.qq.e.comm.plugin.g0;

import com.mbridge.msdk.mbbid.common.BidResponsedEx;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
final class d0 {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(c0 c0Var, JSONObject jSONObject) {
        c0Var.f43494g1 = jSONObject.optInt(BidResponsedEx.KEY_CID);
        c0Var.f43495h1 = jSONObject.optInt("need_empty_report") == 1;
        c0Var.f43496i1 = jSONObject.optInt("is_empty") == 1;
        c0Var.f43497j1 = jSONObject.optString("uoid");
        c0Var.f43498k1 = jSONObject.optInt("rot_index", -1);
        c0Var.f43499l1 = jSONObject.optInt("timelife");
        c0Var.f43501n1 = jSONObject.optString("video_md5");
        c0Var.f43502o1 = jSONObject.optString("joint_uoid");
        c0Var.f43503p1 = jSONObject.optString("joint_loc");
    }
}

package com.bytedance.sdk.openadsdk.core.eq;

import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.ys.w.xv.w;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class n {

    /* renamed from: a  reason: collision with root package name */
    private static String f33274a = "mSupportRenderControl";
    private static String bk = "mSupportIconStyle";

    /* renamed from: c  reason: collision with root package name */
    private static String f33275c = "mAdId";
    private static String ev = "mImgAcceptedHeight";

    /* renamed from: f  reason: collision with root package name */
    private static String f33276f = "mIsAutoPlay";
    private static String fp = "mUserID";
    private static String fz = "mExternalABVid";
    private static String gd = "mExpressViewAcceptedWidth";

    /* renamed from: i  reason: collision with root package name */
    private static String f33277i = "mPrimeRit";
    private static String ia = "mOrientation";

    /* renamed from: j  reason: collision with root package name */
    private static String f33278j = "mRewardName";

    /* renamed from: k  reason: collision with root package name */
    private static String f33279k = "mSupportDeepLink";
    private static String ls = "mRewardAmount";

    /* renamed from: p  reason: collision with root package name */
    private static String f33280p = "mExpressViewAcceptedHeight";

    /* renamed from: q  reason: collision with root package name */
    private static String f33281q = "mBidAdm";

    /* renamed from: r  reason: collision with root package name */
    private static String f33282r = "mImgAcceptedWidth";

    /* renamed from: s  reason: collision with root package name */
    private static String f33283s = "mNativeAdType";
    private static String sr = "mCodeId";

    /* renamed from: t  reason: collision with root package name */
    private static String f33284t = "mAdCount";

    /* renamed from: u  reason: collision with root package name */
    private static String f33285u = "mAdLoadSeq";
    private static String ux = "mUserData";

    /* renamed from: w  reason: collision with root package name */
    private static String f33286w = "mCreativeId";
    private static String xv = "mExt";
    private static String ys = "mMediaExtra";

    public static com.bytedance.sdk.openadsdk.ys.w.xv.w c(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            w.c cVar = new w.c();
            cVar.c(jSONObject.optString(f33275c, ""));
            cVar.w(jSONObject.optString(f33286w, ""));
            cVar.xv(jSONObject.optString(xv, ""));
            cVar.sr(jSONObject.optString(sr, ""));
            cVar.gd(jSONObject.optString(ux));
            cVar.c(jSONObject.optBoolean(f33276f, true));
            int optInt = jSONObject.optInt(f33282r, 640);
            cVar.w(jSONObject.optInt(ev, 320));
            cVar.c(optInt);
            double optDouble = jSONObject.optDouble(gd, 0.0d);
            double optDouble2 = jSONObject.optDouble(f33280p, 0.0d);
            cVar.w(Double.valueOf(optDouble).floatValue());
            cVar.c(Double.valueOf(optDouble2).floatValue());
            cVar.w(jSONObject.optBoolean(f33279k, true));
            cVar.xv(jSONObject.optInt(f33284t, 1));
            cVar.ux(jSONObject.optString(ys, ""));
            cVar.f(jSONObject.optString(fp, ""));
            cVar.sr(jSONObject.optInt(ia, 2));
            cVar.ux(jSONObject.optInt(f33283s));
            cVar.c(wv.k(jSONObject.optString(fz, "")));
            cVar.f(jSONObject.optInt(f33285u, 0));
            cVar.r(jSONObject.optString(f33277i, ""));
            cVar.ev(jSONObject.optString(f33281q));
            cVar.ev(jSONObject.optInt(ls, 0));
            cVar.p(jSONObject.optString(f33278j, ""));
            return cVar.c();
        } catch (Exception unused) {
            return null;
        }
    }

    public static final w.c w(com.bytedance.sdk.openadsdk.ys.w.xv.w wVar) {
        return new w.c(wVar);
    }

    public static JSONObject c(com.bytedance.sdk.openadsdk.ys.w.xv.w wVar, String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(f33275c, wVar.xv());
            jSONObject.put(f33286w, wVar.sr());
            jSONObject.put(xv, wVar.ux());
            jSONObject.put(sr, str);
            jSONObject.put(ux, wVar.ls());
            jSONObject.put(f33276f, wVar.r());
            jSONObject.put(f33282r, wVar.ev());
            jSONObject.put(ev, wVar.gd());
            jSONObject.put(gd, wVar.p());
            jSONObject.put(f33280p, wVar.k());
            jSONObject.put(f33279k, wVar.a());
            jSONObject.put(f33274a, wVar.bk());
            if (com.bytedance.sdk.openadsdk.core.eq.f33190w >= 5900) {
                jSONObject.put(bk, wVar.z());
            }
            jSONObject.put(f33284t, wVar.t());
            jSONObject.put(ys, wVar.ys());
            jSONObject.put(fp, wVar.fp());
            jSONObject.put(ia, wVar.ia());
            jSONObject.put(f33283s, wVar.s());
            jSONObject.put(fz, wv.c(wVar.fz()));
            jSONObject.put(f33285u, wVar.u());
            jSONObject.put(f33277i, wVar.i());
            jSONObject.put(f33281q, wVar.j());
            if (com.bytedance.sdk.openadsdk.core.eq.f33190w >= 5204) {
                jSONObject.put(ls, wVar.ck());
                jSONObject.put(f33278j, wVar.n());
            }
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    public static JSONObject c(com.bytedance.sdk.openadsdk.ys.w.xv.w wVar) {
        return c(wVar, wVar.f());
    }

    public static com.bytedance.sdk.openadsdk.ys.w.xv.w c(int i4, String str, float f4, float f5) {
        return c().sr(str).r(i4).w(f5).c(f4).c();
    }

    public static com.bytedance.sdk.openadsdk.ys.w.xv.w c(int i4) {
        return c().r(i4).c();
    }

    public static com.bytedance.sdk.openadsdk.ys.w.xv.w c(int i4, ValueSet valueSet) {
        com.bytedance.sdk.openadsdk.ys.w.xv.w wVar = new com.bytedance.sdk.openadsdk.ys.w.xv.w(valueSet);
        w.c cVar = new w.c(wVar);
        float p3 = wVar.p();
        float k4 = wVar.k();
        if (p3 <= 0.0f) {
            p3 = xk.sr(com.bytedance.sdk.openadsdk.core.ls.getContext(), wVar.ev());
            k4 = xk.sr(com.bytedance.sdk.openadsdk.core.ls.getContext(), wVar.gd());
        }
        if (p3 > 0.0f || k4 > 0.0f) {
            double sr2 = xk.sr(com.bytedance.sdk.openadsdk.core.ls.getContext(), xk.ux(com.bytedance.sdk.openadsdk.core.ls.getContext()));
            Double.isNaN(sr2);
            int i5 = (int) (sr2 * 1.3d);
            double sr3 = xk.sr(com.bytedance.sdk.openadsdk.core.ls.getContext(), xk.sr(com.bytedance.sdk.openadsdk.core.ls.getContext()));
            Double.isNaN(sr3);
            int i6 = (int) (sr3 * 1.3d);
            int max = Math.max(i5, i6);
            int min = Math.min(i5, i6);
            if (p3 > k4) {
                if (i6 > 0) {
                    float f4 = max;
                    if (p3 > f4) {
                        k4 = min;
                        p3 = f4;
                    }
                }
            } else if (i5 > 0) {
                float f5 = max;
                if (k4 > f5) {
                    p3 = min;
                    k4 = f5;
                }
            }
        }
        cVar.c(p3).w(k4);
        return w(cVar.c()).r(i4).c();
    }

    private static final w.c c() {
        return new w.c().xv(1).w(320).c(640).w(true).f("defaultUser").sr(2).c(true);
    }
}

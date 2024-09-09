package com.bytedance.msdk.core.admanager.reward.rewardagain;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.bytedance.msdk.adapter.sr.f;
import com.bytedance.msdk.c.ux;
import com.bytedance.msdk.core.admanager.p;
import com.bytedance.msdk.core.gd.bk;
import com.bytedance.msdk.f.wv;
import com.bytedance.msdk.xv.r;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.adhost.R;
import com.stub.StubApp;
import java.lang.ref.SoftReference;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class xv {

    /* renamed from: c  reason: collision with root package name */
    private final SoftReference<Context> f27787c;

    /* renamed from: f  reason: collision with root package name */
    private TTAdConstant.RitScenes f27788f;

    /* renamed from: r  reason: collision with root package name */
    private String f27789r;
    private com.bytedance.msdk.api.sr.c.ev.c sr;
    private Activity ux;

    /* renamed from: w  reason: collision with root package name */
    private final com.bytedance.msdk.api.c.w f27790w;
    private com.bytedance.msdk.api.sr.c.ev.c xv;

    /* renamed from: p  reason: collision with root package name */
    private static final Map<String, w> f27786p = new ConcurrentHashMap();

    /* renamed from: k  reason: collision with root package name */
    private static final Map<String, com.bytedance.msdk.core.admanager.reward.rewardagain.c> f27785k = new ConcurrentHashMap();

    /* renamed from: a  reason: collision with root package name */
    private static c f27784a = new c();
    private volatile boolean ev = false;
    private volatile boolean gd = false;

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static class c {

        /* renamed from: c  reason: collision with root package name */
        public w f27804c;

        /* renamed from: w  reason: collision with root package name */
        public Runnable f27805w;
        public Runnable xv;
    }

    public xv(Context context, com.bytedance.msdk.api.c.w wVar, com.bytedance.msdk.api.sr.c.ev.c cVar, com.bytedance.msdk.api.sr.c.ev.c cVar2) {
        this.f27787c = new SoftReference<>(context);
        this.f27790w = wVar;
        if (cVar != null) {
            this.xv = cVar;
        }
        if (cVar2 != null) {
            this.sr = cVar2;
        }
    }

    public static double ev(String str) {
        com.bytedance.msdk.core.admanager.reward.rewardagain.c cVar = f27785k.get(str);
        if (cVar != null) {
            return cVar.f();
        }
        return 0.0d;
    }

    public static com.bytedance.msdk.core.admanager.reward.rewardagain.c gd(String str) {
        return f27785k.get(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(String str) {
        com.bytedance.msdk.api.sr.c.ev.c cVar = this.xv;
        if (cVar != null) {
            cVar.s_();
        }
        r.w(this.f27790w, str);
    }

    public static void p(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        f27785k.remove(str);
    }

    private static String f() {
        return new SimpleDateFormat("dd-MM-yyyy HH", Locale.getDefault()).format(new Date());
    }

    public static double r(String str) {
        com.bytedance.msdk.core.admanager.reward.rewardagain.c cVar = f27785k.get(str);
        if (cVar != null) {
            double xv = cVar.xv();
            if (xv < 0.0d || xv > 1.0d) {
                return -1.0d;
            }
            return xv;
        }
        return -1.0d;
    }

    private static String ux() {
        return new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(new Date());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xv(com.bytedance.msdk.core.admanager.reward.rewardagain.c cVar, String str, ux uxVar) {
        int c4 = c(this.f27790w, cVar, uxVar);
        r.c(this.f27790w, str, c4);
        if (c4 == 0) {
            c();
            return;
        }
        com.bytedance.msdk.api.sr.c.ev.c cVar2 = this.xv;
        if (cVar2 != null) {
            cVar2.s_();
        }
    }

    public void w(com.bytedance.msdk.api.sr.c.ev.c cVar) {
        if (cVar != null) {
            this.sr = cVar;
        }
    }

    public static void sr(String str) {
        wv c4 = wv.c((String) null, com.bytedance.msdk.core.c.getContext());
        String w3 = c4.w("ra_show_count_in_hour");
        if (!TextUtils.isEmpty(w3)) {
            try {
                JSONObject jSONObject = new JSONObject(w3);
                String f4 = f();
                JSONObject optJSONObject = jSONObject.optJSONObject(f4);
                if (optJSONObject == null) {
                    c4.c("ra_show_count_in_hour", "");
                    optJSONObject = new JSONObject();
                }
                optJSONObject.put(str, optJSONObject.optInt(str, 0) + 1);
                jSONObject.put(f4, optJSONObject);
                c4.c("ra_show_count_in_hour", jSONObject.toString());
                return;
            } catch (JSONException e4) {
                e4.printStackTrace();
                return;
            }
        }
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(str, 1);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put(f(), jSONObject2);
            c4.c("ra_show_count_in_hour", jSONObject3.toString());
        } catch (JSONException e5) {
            e5.printStackTrace();
        }
    }

    private void w(final com.bytedance.msdk.core.admanager.reward.rewardagain.c cVar, final String str, final ux uxVar) {
        c cVar2 = new c();
        f27784a = cVar2;
        cVar2.f27804c = f27786p.get(cVar.sr());
        f27784a.f27805w = new Runnable() { // from class: com.bytedance.msdk.core.admanager.reward.rewardagain.xv.3
            @Override // java.lang.Runnable
            public void run() {
                xv.this.xv(cVar, str, uxVar);
                xv.r();
            }
        };
        f27784a.xv = new Runnable() { // from class: com.bytedance.msdk.core.admanager.reward.rewardagain.xv.4
            @Override // java.lang.Runnable
            public void run() {
                xv.this.k(str);
                xv.r();
            }
        };
        Intent intent = new Intent(com.bytedance.msdk.core.c.getContext(), GMRewardAgainDialogActivity.class);
        intent.setFlags(268435456);
        com.bytedance.msdk.core.c.getContext().startActivity(intent);
    }

    public static long f(String str) {
        String w3 = wv.c((String) null, com.bytedance.msdk.core.c.getContext()).w("ra_play_rit_ts");
        try {
            if (!TextUtils.isEmpty(w3)) {
                return new JSONObject(w3).optLong(str, -1L);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return -1L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void r() {
        c cVar = f27784a;
        cVar.f27804c = null;
        cVar.f27805w = null;
        cVar.xv = null;
    }

    public static void ux(String str) {
        JSONObject jSONObject;
        wv c4 = wv.c((String) null, com.bytedance.msdk.core.c.getContext());
        String w3 = c4.w("ra_play_rit_ts");
        try {
            if (TextUtils.isEmpty(w3)) {
                jSONObject = new JSONObject();
            } else {
                jSONObject = new JSONObject(w3);
            }
            jSONObject.put(str, System.currentTimeMillis());
            c4.c("ra_play_rit_ts", jSONObject.toString());
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void c(Activity activity, TTAdConstant.RitScenes ritScenes, String str) {
        this.ux = activity;
        this.f27788f = ritScenes;
        this.f27789r = str;
    }

    public static int xv(String str) {
        String w3 = wv.c((String) null, com.bytedance.msdk.core.c.getContext()).w("ra_show_count_in_hour");
        if (!TextUtils.isEmpty(w3)) {
            try {
                JSONObject optJSONObject = new JSONObject(w3).optJSONObject(f());
                if (optJSONObject != null) {
                    return optJSONObject.optInt(str, 0);
                }
            } catch (JSONException e4) {
                e4.printStackTrace();
            }
        }
        return 0;
    }

    public void c(com.bytedance.msdk.api.sr.c.ev.c cVar) {
        if (cVar != null) {
            this.xv = cVar;
        }
    }

    public void c(final com.bytedance.msdk.core.admanager.reward.rewardagain.c cVar, final String str, final ux uxVar) {
        Activity activity = this.ux;
        if (activity != null && !activity.isFinishing() && !this.ux.isDestroyed()) {
            final Dialog dialog = new Dialog(this.ux);
            View inflate = LayoutInflater.from(StubApp.getOrigApplicationContext(this.ux.getApplicationContext())).inflate(R.layout.reward_again_dialog, (ViewGroup) null);
            ImageView imageView = (ImageView) inflate.findViewById(R.id.ra_pic);
            TextView textView = (TextView) inflate.findViewById(R.id.ra_title);
            TextView textView2 = (TextView) inflate.findViewById(R.id.ra_btn_ok);
            TextView textView3 = (TextView) inflate.findViewById(R.id.ra_btn_cancel);
            w wVar = f27786p.get(cVar.sr());
            if (wVar != null) {
                textView.setText(wVar.w());
                textView2.setText(wVar.sr());
                textView3.setText(wVar.ux());
                if (!TextUtils.isEmpty(wVar.xv())) {
                    new com.bytedance.msdk.adapter.sr.w(imageView).c((Object[]) new String[]{wVar.xv()});
                }
            }
            textView2.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.msdk.core.admanager.reward.rewardagain.xv.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    xv.this.xv(cVar, str, uxVar);
                    dialog.dismiss();
                }
            });
            textView3.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.msdk.core.admanager.reward.rewardagain.xv.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    xv.this.k(str);
                    dialog.dismiss();
                }
            });
            dialog.setContentView(inflate);
            dialog.setCanceledOnTouchOutside(false);
            dialog.setCancelable(false);
            dialog.show();
            return;
        }
        com.bytedance.msdk.adapter.sr.xv.c("TTMediationSDK", "--==-- reward again show activity dialog");
        w(cVar, str, uxVar);
    }

    public void w() {
        this.gd = true;
    }

    public static void w(String str) {
        wv c4 = wv.c((String) null, com.bytedance.msdk.core.c.getContext());
        String w3 = c4.w("ra_show_count");
        if (!TextUtils.isEmpty(w3)) {
            try {
                JSONObject jSONObject = new JSONObject(w3);
                String ux = ux();
                JSONObject optJSONObject = jSONObject.optJSONObject(ux);
                if (optJSONObject == null) {
                    c4.c("ra_show_count", "");
                    optJSONObject = new JSONObject();
                }
                optJSONObject.put(str, optJSONObject.optInt(str, 0) + 1);
                jSONObject.put(ux, optJSONObject);
                c4.c("ra_show_count", jSONObject.toString());
                return;
            } catch (JSONException e4) {
                e4.printStackTrace();
                return;
            }
        }
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(str, 1);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put(ux(), jSONObject2);
            c4.c("ra_show_count", jSONObject3.toString());
        } catch (JSONException e5) {
            e5.printStackTrace();
        }
    }

    public static c xv() {
        return f27784a;
    }

    public void c() {
        Context context = this.f27787c.get();
        if (context != null) {
            final p pVar = new p(context, this.f27790w.u());
            c(pVar);
            this.f27790w.ux(1);
            pVar.w(this.f27790w, new com.bytedance.msdk.api.sr.c.ev.w() { // from class: com.bytedance.msdk.core.admanager.reward.rewardagain.xv.5
                @Override // com.bytedance.msdk.api.sr.c.ev.w
                public void c(@NonNull com.bytedance.msdk.api.c cVar) {
                    if (xv.this.ev) {
                        return;
                    }
                    xv.this.ev = true;
                    if (xv.this.xv != null) {
                        xv.this.xv.s_();
                    }
                }

                @Override // com.bytedance.msdk.api.sr.c.ev.w
                public void w() {
                    if (xv.this.ev) {
                        return;
                    }
                    xv.this.ev = true;
                    pVar.c(xv.this.ux, xv.this.f27788f, xv.this.f27789r);
                }

                @Override // com.bytedance.msdk.api.sr.c.ev.w
                public void c() {
                    if (xv.this.ev) {
                        return;
                    }
                    xv.this.ev = true;
                    pVar.c(xv.this.ux, xv.this.f27788f, xv.this.f27789r);
                }
            });
            f.w(new Runnable() { // from class: com.bytedance.msdk.core.admanager.reward.rewardagain.xv.6
                @Override // java.lang.Runnable
                public void run() {
                    if (xv.this.ev) {
                        return;
                    }
                    xv.this.ev = true;
                    if (xv.this.xv != null) {
                        xv.this.xv.s_();
                    }
                }
            }, 500L);
        }
    }

    private void c(p pVar) {
        pVar.c(new com.bytedance.msdk.api.sr.c.ev.c() { // from class: com.bytedance.msdk.core.admanager.reward.rewardagain.xv.7
            @Override // com.bytedance.msdk.api.sr.c.ev.c
            public void c() {
                String u3 = xv.this.f27790w != null ? xv.this.f27790w.u() : "";
                xv.w(u3);
                xv.sr(u3);
                xv.ux(u3);
                if (xv.this.sr != null) {
                    xv.this.sr.c();
                }
            }

            @Override // com.bytedance.msdk.api.sr.c.ev.c
            public void c_(@NonNull com.bytedance.msdk.api.c cVar) {
                if (xv.this.sr != null) {
                    xv.this.sr.c_(cVar);
                }
            }

            @Override // com.bytedance.msdk.api.sr.c.ev.c
            public void f() {
                if (xv.this.sr != null) {
                    xv.this.sr.f();
                }
            }

            @Override // com.bytedance.msdk.api.sr.c.ev.c
            public void r_() {
                if (xv.this.sr != null) {
                    xv.this.sr.r_();
                }
            }

            @Override // com.bytedance.msdk.api.sr.c.ev.c
            public void s_() {
                if (xv.this.xv != null) {
                    xv.this.xv.s_();
                }
            }

            @Override // com.bytedance.msdk.api.sr.c.ev.c
            public void t_() {
                if (xv.this.sr != null) {
                    xv.this.sr.t_();
                }
            }

            @Override // com.bytedance.msdk.api.sr.c.ev.c
            public void ux() {
                if (xv.this.sr != null) {
                    xv.this.sr.ux();
                }
            }

            @Override // com.bytedance.msdk.api.sr.c.ev.c
            public void c(@NonNull com.bytedance.msdk.api.xv.c cVar) {
                if (xv.this.sr != null) {
                    xv.this.sr.c(cVar);
                }
            }
        });
        pVar.w(new com.bytedance.msdk.api.sr.c.ev.c() { // from class: com.bytedance.msdk.core.admanager.reward.rewardagain.xv.8
            @Override // com.bytedance.msdk.api.sr.c.ev.c
            public void c() {
                if (xv.this.sr != null) {
                    xv.this.sr.c();
                }
            }

            @Override // com.bytedance.msdk.api.sr.c.ev.c
            public void c_(@NonNull com.bytedance.msdk.api.c cVar) {
                if (xv.this.sr != null) {
                    xv.this.sr.c_(cVar);
                }
            }

            @Override // com.bytedance.msdk.api.sr.c.ev.c
            public void f() {
                if (xv.this.sr != null) {
                    xv.this.sr.f();
                }
            }

            @Override // com.bytedance.msdk.api.sr.c.ev.c
            public void r_() {
                if (xv.this.sr != null) {
                    xv.this.sr.r_();
                }
            }

            @Override // com.bytedance.msdk.api.sr.c.ev.c
            public void s_() {
                if (xv.this.xv != null) {
                    xv.this.xv.s_();
                }
            }

            @Override // com.bytedance.msdk.api.sr.c.ev.c
            public void t_() {
                if (xv.this.sr != null) {
                    xv.this.sr.t_();
                }
            }

            @Override // com.bytedance.msdk.api.sr.c.ev.c
            public void ux() {
                if (xv.this.sr != null) {
                    xv.this.sr.ux();
                }
            }

            @Override // com.bytedance.msdk.api.sr.c.ev.c
            public void c(@NonNull com.bytedance.msdk.api.xv.c cVar) {
                if (xv.this.sr != null) {
                    xv.this.sr.c(cVar);
                }
            }
        });
    }

    public int c(com.bytedance.msdk.api.c.w wVar, com.bytedance.msdk.core.admanager.reward.rewardagain.c cVar, ux uxVar) {
        if (!this.gd) {
            com.bytedance.msdk.adapter.sr.xv.c("TTMediationSDK", "--==--ra: \u8fd8\u672a\u89e6\u53d1rewardVerify");
            return 1;
        }
        String u3 = wVar.u();
        int ux = cVar.ux();
        int c4 = c(u3);
        if (c4 >= ux) {
            com.bytedance.msdk.adapter.sr.xv.c("TTMediationSDK", "--==--ra: \u6fc0\u52b1\u518d\u5f97\u5c55\u793a\u6b21\u6570\u8d85\u8fc7\u5929\u7ea7\u522b\u9650\u5236\uff0c\u9650\u5236: " + ux + ", \u5df2\u7ecf\u5c55\u793a: " + c4);
            return 2;
        } else if (f27786p.get(cVar.sr()) == null) {
            com.bytedance.msdk.adapter.sr.xv.c("TTMediationSDK", "--==--ra: \u6fc0\u52b1\u518d\u5f97\u6837\u5f0f\u4e3a\u7a7a");
            return 3;
        } else if (com.bytedance.msdk.core.r.c.c().xv()) {
            com.bytedance.msdk.adapter.sr.xv.c("TTMediationSDK", "--==--ra: \u547d\u4e2d\u8bf7\u6c42\u7194\u65ad");
            return 4;
        } else if (!bk.c().ev(u3)) {
            com.bytedance.msdk.adapter.sr.xv.c("TTMediationSDK", "--==--ra: \u547d\u4e2d\u5c55\u793a\u9891\u63a7");
            return 5;
        } else if (!bk.c().xv(u3)) {
            com.bytedance.msdk.adapter.sr.xv.c("TTMediationSDK", "--==--ra: \u547d\u4e2d\u5c55\u793a\u95f4\u9694");
            return 6;
        } else {
            double w3 = com.bytedance.msdk.core.ux.w.w.c().w(u3, wVar);
            if (w3 <= -1.0d) {
                com.bytedance.msdk.adapter.sr.xv.c("TTMediationSDK", "--==--ra: \u6fc0\u52b1\u518d\u5f97\u65e0\u7f13\u5b58\u53ef\u7528");
                return 7;
            } else if (w3 < ev(u3)) {
                com.bytedance.msdk.adapter.sr.xv.c("TTMediationSDK", "--==--ra: \u6fc0\u52b1\u518d\u5f97\u6709\u7f13\u5b58\uff0c\u4f46\u662fecpm\u4e0d\u7b26\u5408");
                return 8;
            } else {
                int c5 = cVar.c();
                int xv = xv(u3);
                if (xv >= c5) {
                    com.bytedance.msdk.adapter.sr.xv.c("TTMediationSDK", "--==--ra: \u6fc0\u52b1\u518d\u5f97\u5c55\u793a\u6b21\u6570\u8d85\u8fc7\u5c0f\u65f6\u7ea7\u522b\u9650\u5236\uff0c\u9650\u5236: " + c5 + ", \u5df2\u7ecf\u5c55\u793a: " + xv);
                    return 9;
                }
                long w4 = cVar.w();
                long f4 = f(u3);
                long currentTimeMillis = System.currentTimeMillis() - f4;
                if (f4 != -1 && currentTimeMillis < w4) {
                    com.bytedance.msdk.adapter.sr.xv.c("TTMediationSDK", "--==--ra: \u6fc0\u52b1\u518d\u5f97\u5c55\u793a\u95f4\u9694\u8d85\u8fc7\u9650\u5236\uff0cconfig\u95f4\u9694: " + w4 + ", \u5b9e\u9645\u95f4\u9694: " + currentTimeMillis);
                    return 10;
                }
                double r3 = r(u3);
                if (uxVar == null || r3 == -1.0d || w3 >= uxVar.getCpm() * r3) {
                    return 0;
                }
                com.bytedance.msdk.adapter.sr.xv.c("TTMediationSDK", "--==--ra: \u6fc0\u52b1\u518d\u5f97ecpm\u4e0b\u63a2\u671f\u95f4\u4e0d\u6ee1\u8db3");
                return 11;
            }
        }
    }

    public static int c(String str) {
        String w3 = wv.c((String) null, com.bytedance.msdk.core.c.getContext()).w("ra_show_count");
        if (!TextUtils.isEmpty(w3)) {
            try {
                JSONObject optJSONObject = new JSONObject(w3).optJSONObject(ux());
                if (optJSONObject != null) {
                    return optJSONObject.optInt(str, 0);
                }
            } catch (JSONException e4) {
                e4.printStackTrace();
            }
        }
        return 0;
    }

    public static void c(String str, com.bytedance.msdk.core.admanager.reward.rewardagain.c cVar) {
        if (TextUtils.isEmpty(str) || cVar == null) {
            return;
        }
        f27785k.put(str, cVar);
    }

    public static void c(JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() <= 0) {
            return;
        }
        for (int i4 = 0; i4 < jSONArray.length(); i4++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i4);
            if (optJSONObject != null) {
                w wVar = new w();
                wVar.c(optJSONObject.optString("ra_id"));
                wVar.w(optJSONObject.optString("title"));
                wVar.xv(optJSONObject.optString("pic_url"));
                wVar.sr(optJSONObject.optString("btn_ok"));
                wVar.ux(optJSONObject.optString("btn_cancel"));
                f27786p.put(wVar.c(), wVar);
            }
        }
    }
}

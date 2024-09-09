package com.bytedance.sdk.openadsdk.core.y;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Network;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.ev;
import com.bytedance.sdk.openadsdk.core.u.wo;
import com.bytedance.sdk.openadsdk.core.xv.ux;
import com.bytedance.sdk.openadsdk.core.y.c.sr;
import com.bytedance.sdk.openadsdk.core.y.c.w;
import com.bytedance.sdk.openadsdk.core.y.c.xv;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class c {
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: c  reason: collision with root package name */
    private static volatile c f35645c;
    private final wo sr;
    private final ux ux;

    /* renamed from: w  reason: collision with root package name */
    private final Context f35648w;
    private final xv xv;

    /* renamed from: r  reason: collision with root package name */
    private final AtomicBoolean f35647r = new AtomicBoolean(false);

    /* renamed from: f  reason: collision with root package name */
    private boolean f35646f = true;

    private c(Context context) {
        this.f35648w = context;
        this.xv = xv.c(context);
        ux c4 = ux.c();
        this.ux = c4;
        if (c4 != null) {
            this.sr = new wo(c4.xv("vd", 3300000L), c4.xv("err", 3300000L), c4.xv("tk", 3300000L), c4.xv("cr", 3300000L));
        } else {
            this.sr = new wo("", "-1", "", "");
        }
    }

    public static c c(Context context) {
        if (f35645c == null) {
            synchronized (c.class) {
                if (f35645c == null) {
                    f35645c = new c(context);
                }
            }
        }
        return f35645c;
    }

    public wo c() {
        ux uxVar = this.ux;
        if ((uxVar != null && !TextUtils.isEmpty(uxVar.xv("tk", 3300000L))) || !this.f35646f) {
            return this.sr;
        }
        if (!this.f35647r.compareAndSet(false, true)) {
            return this.sr;
        }
        ev.c().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.y.c.1
            /* JADX WARN: Removed duplicated region for block: B:52:0x00cc  */
            /* JADX WARN: Removed duplicated region for block: B:54:0x00df  */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void run() {
                /*
                    Method dump skipped, instructions count: 290
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.y.c.AnonymousClass1.run():void");
            }
        });
        return this.sr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(Network network, List<String> list) {
        String c4;
        String str;
        String str2;
        String str3;
        String str4;
        for (String str5 : list) {
            try {
                if ("https://msg.cmpassport.com/h5/getMobile".equals(str5)) {
                    c4 = str5;
                    str3 = sr.c();
                    str4 = "1";
                    str = null;
                    str2 = "0";
                } else if ("https://id6.me/gw/preuniq.do".equals(str5)) {
                    String c5 = com.bytedance.sdk.component.utils.c.c(8);
                    c4 = sr.c(str5, c5);
                    str = c5;
                    str2 = "1";
                    str3 = null;
                    str4 = "3";
                } else {
                    this.f35647r.set(false);
                    return;
                }
                c(network, c4, str3, str4, str2, str);
            } catch (Exception unused) {
                this.sr.c("", "6", "", "");
            }
            if (!TextUtils.isEmpty(this.sr.w())) {
                break;
            }
        }
        if (!TextUtils.isEmpty(this.sr.c()) && (this.sr.c().equals("-10001") || this.sr.c().equals("103111") || this.sr.c().equals("105002"))) {
            this.f35646f = false;
        }
        this.f35647r.set(false);
        this.xv.w();
    }

    private void c(Network network, String str, String str2, final String str3, final String str4, final String str5) {
        w.c(network, str, str2, new w.c() { // from class: com.bytedance.sdk.openadsdk.core.y.c.2
            @Override // com.bytedance.sdk.openadsdk.core.y.c.w.c
            public void c(String str6) {
                String str7;
                String str8 = "";
                try {
                    JSONObject jSONObject = new JSONObject(str6);
                    str7 = "0";
                    if ("1".equals(str3)) {
                        JSONObject jSONObject2 = jSONObject.getJSONObject("body");
                        String string = jSONObject2.getString("resultCode");
                        if ("103000".equals(string)) {
                            str8 = jSONObject2.getString("token");
                        } else {
                            str7 = string;
                        }
                    } else {
                        String valueOf = String.valueOf(jSONObject.getInt("result"));
                        if ("0".equals(valueOf)) {
                            str8 = new JSONObject(com.bytedance.sdk.openadsdk.core.y.c.c.c(false, com.bytedance.sdk.component.utils.ux.c(jSONObject.getString("data")), str5)).getString("accessCode");
                        } else {
                            str7 = valueOf;
                        }
                    }
                } catch (Exception unused) {
                    str7 = "6";
                }
                c.this.sr.c(str4, str7, str8, str3);
                if (c.this.ux == null || TextUtils.isEmpty(str8)) {
                    return;
                }
                c.this.ux.ux("vd", str4);
                c.this.ux.ux("cr", str3);
                c.this.ux.ux("err", str7);
                c.this.ux.ux("tk", str8);
            }

            @Override // com.bytedance.sdk.openadsdk.core.y.c.w.c
            public void c() {
                c.this.sr.c(str4, "6", "", str3);
            }
        });
    }
}

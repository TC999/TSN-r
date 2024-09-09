package com.bytedance.sdk.openadsdk.core.w.c.w;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.widget.Toast;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.component.utils.a;
import com.bytedance.sdk.component.utils.w;
import com.bytedance.sdk.openadsdk.core.ck;
import com.bytedance.sdk.openadsdk.core.eq.u;
import com.bytedance.sdk.openadsdk.core.eq.wv;
import com.bytedance.sdk.openadsdk.core.ls;
import com.bytedance.sdk.openadsdk.core.u.me;
import com.bytedance.sdk.openadsdk.core.u.ok;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class p {
    private static volatile boolean ev;

    /* renamed from: c  reason: collision with root package name */
    private Toast f35320c;

    /* renamed from: f  reason: collision with root package name */
    private boolean f35321f;

    /* renamed from: r  reason: collision with root package name */
    private ok f35322r;
    private int sr;
    private String ux;

    /* renamed from: w  reason: collision with root package name */
    private final me f35323w;
    private final Context xv;

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public interface c {
        void c();

        void w();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public class w implements ck.xv<JSONObject> {

        /* renamed from: c  reason: collision with root package name */
        private final c f35329c;
        private final Toast sr;

        /* renamed from: w  reason: collision with root package name */
        private final ok f35330w;

        w(c cVar, ok okVar, Toast toast) {
            this.f35329c = cVar;
            this.f35330w = okVar;
            this.sr = toast;
        }

        @Override // com.bytedance.sdk.openadsdk.core.ck.xv
        public void c(int i4, String str) {
            a.sr("WechatClickHandler", "getWechatLink failed:" + i4 + ", " + str);
            this.f35330w.w(0);
            Toast toast = this.sr;
            if (toast != null) {
                toast.cancel();
            }
            c cVar = this.f35329c;
            if (cVar != null) {
                cVar.w();
            }
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.bytedance.sdk.openadsdk.core.ck.xv
        public void c(JSONObject jSONObject) {
            String optString = jSONObject.optString("scheme");
            if (!TextUtils.isEmpty(optString)) {
                p.this.c(optString, this.f35330w, this.f35329c);
            } else {
                c(MediaPlayer.MEDIA_PLAYER_OPTION_BASEPLAYER_AUDIO_BUFLEN, " scheme is null!");
            }
        }
    }

    public p(me meVar, Context context) {
        this.f35323w = meVar;
        this.xv = context;
    }

    public p w(boolean z3) {
        this.f35321f = z3;
        return this;
    }

    private int w(c cVar) {
        ok si;
        me meVar = this.f35323w;
        if (meVar == null || (si = meVar.si()) == null) {
            return 0;
        }
        if (si.f() == 1 && ev.xv().c()) {
            if (TextUtils.isEmpty(si.r())) {
                return 0;
            }
            c(cVar, si);
            return 2;
        }
        return 1;
    }

    public static boolean c() {
        return ev;
    }

    public static void c(boolean z3) {
        ev = z3;
    }

    public p c(String str) {
        this.ux = str;
        return this;
    }

    public p c(int i4) {
        this.sr = i4;
        return this;
    }

    public boolean c(c cVar) {
        int w3;
        if (this.f35322r == null) {
            me meVar = this.f35323w;
            this.f35322r = meVar != null ? meVar.si() : null;
        }
        ok okVar = this.f35322r;
        if (okVar == null) {
            return false;
        }
        int w4 = okVar.w();
        if (w4 != 1) {
            if (w4 == 2 && (w3 = w(cVar)) != 0) {
                if (w3 == 2) {
                    return true;
                }
                if (TextUtils.isEmpty(this.f35322r.c())) {
                    return false;
                }
                c(cVar, this.f35322r, 2000L);
                return true;
            }
            return false;
        } else if (this.f35321f && (TextUtils.isEmpty(this.f35322r.ev()) || w(cVar) == 2)) {
            return true;
        }
        return false;
    }

    private void w() {
        com.bytedance.sdk.openadsdk.n.f.c(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.w.c.w.p.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (p.this.f35320c != null) {
                        p.this.f35320c.cancel();
                    }
                    p pVar = p.this;
                    pVar.f35320c = Toast.makeText(pVar.xv, "\u5373\u5c06\u8df3\u8f6c\u5fae\u4fe1...", 1);
                    p.this.f35320c.setGravity(17, 0, 0);
                    p.this.f35320c.show();
                } catch (Throwable th) {
                    a.xv("toast error:" + th.getMessage());
                }
            }
        });
    }

    private void c(final c cVar, ok okVar) {
        w();
        ls.c().c(okVar, this.f35323w.pu(), this.f35323w.cf(), new w(cVar, okVar, this.f35320c) { // from class: com.bytedance.sdk.openadsdk.core.w.c.w.p.1
            @Override // com.bytedance.sdk.openadsdk.core.w.c.w.p.w, com.bytedance.sdk.openadsdk.core.ck.xv
            public void c(JSONObject jSONObject) {
                String optString = jSONObject.optString("userName");
                String optString2 = jSONObject.optString("path");
                if (!TextUtils.isEmpty(optString)) {
                    if (p.this.f35320c != null) {
                        p.this.f35320c.cancel();
                    }
                    ev.xv().c(p.this.f35323w, optString, optString2, cVar, p.this.ux, p.this.f35321f);
                    return;
                }
                c(MediaPlayer.MEDIA_PLAYER_OPTION_BASEPLAYER_AUDIO_BUFLEN, " userName or path is null!");
            }
        }, 1, 2000L);
    }

    private void c(c cVar, ok okVar, long j4) {
        w();
        ls.c().c(okVar, this.f35323w.pu(), this.f35323w.cf(), new w(cVar, okVar, this.f35320c), 2, j4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str, final ok okVar, final c cVar) {
        Toast toast = this.f35320c;
        if (toast != null) {
            toast.cancel();
        }
        Uri parse = Uri.parse(str);
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(parse);
        intent.addFlags(268435456);
        final String c4 = u.xv(this.f35323w) ? this.ux : wv.c(this.sr);
        com.bytedance.sdk.component.utils.w.c(this.xv, intent, new w.c() { // from class: com.bytedance.sdk.openadsdk.core.w.c.w.p.3
            @Override // com.bytedance.sdk.component.utils.w.c
            public void c() {
                okVar.w(1);
                com.bytedance.sdk.openadsdk.core.a.xv.xv(p.this.f35323w, c4, "deeplink_success_realtime");
                com.bytedance.sdk.openadsdk.core.a.xv.ev(p.this.f35323w, c4, "open_url_app", null);
                com.bytedance.sdk.openadsdk.core.a.f.c().c(p.this.f35323w, c4, false);
                c cVar2 = cVar;
                if (cVar2 != null) {
                    cVar2.c();
                }
            }

            @Override // com.bytedance.sdk.component.utils.w.c
            public void c(Throwable th) {
                okVar.w(0);
                c cVar2 = cVar;
                if (cVar2 != null) {
                    cVar2.w();
                }
            }
        });
    }
}

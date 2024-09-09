package com.bytedance.sdk.openadsdk.core.q;

import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.component.utils.a;
import com.bytedance.sdk.openadsdk.core.ck;
import com.bytedance.sdk.openadsdk.core.eq.wv;
import com.bytedance.sdk.openadsdk.core.ls;
import com.bytedance.sdk.openadsdk.core.u.me;
import java.io.IOException;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class w {

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public interface c {
        void c(int i4, String str);

        void c(JSONObject jSONObject);
    }

    /* renamed from: com.bytedance.sdk.openadsdk.core.q.w$w  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public interface InterfaceC0506w {
        void c();

        void c(JSONObject jSONObject);
    }

    public static void c(com.bytedance.sdk.openadsdk.core.ugeno.f.c cVar, InterfaceC0506w interfaceC0506w) {
        if (cVar != null) {
            c(cVar.xv(), cVar.c(), cVar.w(), interfaceC0506w);
        } else if (interfaceC0506w != null) {
            interfaceC0506w.c();
        }
    }

    public static void c(String str, final String str2, final String str3, final InterfaceC0506w interfaceC0506w) {
        if (TextUtils.isEmpty(str)) {
            if (interfaceC0506w != null) {
                interfaceC0506w.c();
                return;
            }
            return;
        }
        com.bytedance.sdk.component.ev.w.w xv = ux.c().w().xv();
        xv.c(str);
        xv.c(new com.bytedance.sdk.component.ev.c.c() { // from class: com.bytedance.sdk.openadsdk.core.q.w.1
            @Override // com.bytedance.sdk.component.ev.c.c
            public void c(com.bytedance.sdk.component.ev.w.xv xvVar, com.bytedance.sdk.component.ev.w wVar) {
                if (wVar == null) {
                    return;
                }
                if (wVar.ev()) {
                    String sr = wVar.sr();
                    com.bytedance.sdk.openadsdk.core.ugeno.sr.c().c(str2, str3, sr);
                    if (interfaceC0506w != null) {
                        try {
                            interfaceC0506w.c(new JSONObject(sr));
                            return;
                        } catch (JSONException e4) {
                            e4.printStackTrace();
                            interfaceC0506w.c();
                            return;
                        }
                    }
                    return;
                }
                InterfaceC0506w interfaceC0506w2 = interfaceC0506w;
                if (interfaceC0506w2 != null) {
                    interfaceC0506w2.c();
                }
            }

            @Override // com.bytedance.sdk.component.ev.c.c
            public void c(com.bytedance.sdk.component.ev.w.xv xvVar, IOException iOException) {
                InterfaceC0506w interfaceC0506w2 = interfaceC0506w;
                if (interfaceC0506w2 != null) {
                    interfaceC0506w2.c();
                }
            }
        });
    }

    public static void c(me meVar, JSONObject jSONObject, final com.bytedance.sdk.openadsdk.core.ia.xv xvVar, com.bytedance.sdk.openadsdk.ys.w.xv.w wVar) {
        if (xvVar == null) {
            return;
        }
        if (meVar != null) {
            try {
                if (!TextUtils.isEmpty(meVar.cf())) {
                    int ev = wv.ev(meVar);
                    com.bytedance.sdk.openadsdk.ys.w.xv.w oo = meVar.oo();
                    if (oo != null) {
                        wVar = oo;
                    }
                    com.bytedance.sdk.openadsdk.core.u.wv wvVar = new com.bytedance.sdk.openadsdk.core.u.wv();
                    wvVar.ux = true;
                    if (meVar.rh() != null) {
                        wvVar.f34867r = 2;
                    }
                    JSONObject ya = meVar.ya();
                    if (ya == null) {
                        ya = new JSONObject();
                    }
                    if (jSONObject != null) {
                        Iterator<String> keys = jSONObject.keys();
                        while (keys.hasNext()) {
                            String next = keys.next();
                            ya.put(next, jSONObject.opt(next));
                        }
                    }
                    wvVar.bk = ya;
                    ls.c().c(wVar, wvVar, ev, new ck.w() { // from class: com.bytedance.sdk.openadsdk.core.q.w.2
                        @Override // com.bytedance.sdk.openadsdk.core.ck.w
                        public void c(int i4, String str, com.bytedance.sdk.openadsdk.core.u.w wVar2) {
                            com.bytedance.sdk.openadsdk.core.ia.xv.this.c(false, null, false);
                            wVar2.c(i4);
                            com.bytedance.sdk.openadsdk.core.u.w.c(wVar2);
                        }

                        @Override // com.bytedance.sdk.openadsdk.core.ck.w
                        public void c(com.bytedance.sdk.openadsdk.core.u.c cVar, com.bytedance.sdk.openadsdk.core.u.w wVar2) {
                            if (cVar.w() != null && !cVar.w().isEmpty()) {
                                com.bytedance.sdk.openadsdk.core.ia.xv.this.c(true, cVar.w(), false);
                                return;
                            }
                            com.bytedance.sdk.openadsdk.core.ia.xv.this.c(false, null, false);
                            wVar2.c(-3);
                            com.bytedance.sdk.openadsdk.core.u.w.c(wVar2);
                        }
                    });
                    return;
                }
            } catch (Exception e4) {
                a.xv("PageNetUtils", "get ads error", e4);
                return;
            }
        }
        xvVar.c(false, null, false);
    }

    public static void c(String str, final c cVar) {
        com.bytedance.sdk.component.ev.w.w xv = ux.c().w().xv();
        xv.c(str);
        xv.c(new com.bytedance.sdk.component.ev.c.c() { // from class: com.bytedance.sdk.openadsdk.core.q.w.3
            @Override // com.bytedance.sdk.component.ev.c.c
            public void c(com.bytedance.sdk.component.ev.w.xv xvVar, com.bytedance.sdk.component.ev.w wVar) {
                if (wVar != null && wVar.ev()) {
                    try {
                        JSONObject jSONObject = new JSONObject(wVar.sr());
                        c cVar2 = c.this;
                        if (cVar2 != null) {
                            cVar2.c(jSONObject);
                            return;
                        }
                        return;
                    } catch (JSONException e4) {
                        e4.printStackTrace();
                        return;
                    }
                }
                c cVar3 = c.this;
                if (cVar3 == null || wVar == null) {
                    return;
                }
                cVar3.c(wVar.c(), wVar.w());
            }

            @Override // com.bytedance.sdk.component.ev.c.c
            public void c(com.bytedance.sdk.component.ev.w.xv xvVar, IOException iOException) {
                c cVar2 = c.this;
                if (cVar2 != null) {
                    cVar2.c(MediaPlayer.MEDIA_PLAYER_OPTION_ABR_DOWNLOAD_VIDEO_BITRATE, iOException.getMessage());
                }
            }
        });
    }
}

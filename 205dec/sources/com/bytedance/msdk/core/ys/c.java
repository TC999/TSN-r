package com.bytedance.msdk.core.ys;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.msdk.adapter.sr.xv;
import com.bytedance.msdk.api.c.w;
import com.bytedance.msdk.core.k.ev;
import com.bytedance.msdk.core.k.p;
import com.bytedance.msdk.core.k.r;
import com.bytedance.msdk.f.f;
import com.bytedance.msdk.f.m;
import com.bytedance.msdk.f.t;
import com.bytedance.msdk.f.ux;
import com.bytedance.msdk.f.ys;
import com.bytedance.sdk.component.ev.w.sr;
import com.mbridge.msdk.mbbid.out.BidResponsed;
import java.io.IOException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
import xyz.adscope.ad.advertisings.constants.ConstantAd;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class c {

    /* renamed from: c  reason: collision with root package name */
    private static volatile c f28297c;

    /* renamed from: com.bytedance.msdk.core.ys.c$c  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public interface InterfaceC0423c {
        void c(com.bytedance.msdk.api.c cVar);

        void c(r rVar);
    }

    public static int c(int i4) {
        if (i4 != 1) {
            if (i4 != 2) {
                return (i4 == 3 || i4 == 4 || i4 == 7 || i4 == 8) ? 5 : 3;
            }
            return 4;
        }
        return 2;
    }

    private JSONObject w() {
        if (TextUtils.isEmpty(com.bytedance.msdk.core.c.w().gd())) {
            return null;
        }
        try {
            return new JSONObject(com.bytedance.msdk.core.c.w().gd());
        } catch (Exception e4) {
            e4.printStackTrace();
            return null;
        }
    }

    private void xv(JSONObject jSONObject) {
        ux c4 = f.c(com.bytedance.msdk.core.c.getContext());
        if (c4 != null) {
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("latitude", c4.f28362c);
                jSONObject2.put("longitude", c4.f28363w);
                jSONObject.put("geo", jSONObject2);
            } catch (Exception unused) {
            }
        }
    }

    private String c(Map<String, com.bytedance.msdk.adapter.c> map, Context context, w wVar, p pVar, Map<String, Object> map2) {
        if (wVar != null && pVar != null) {
            if (TextUtils.equals("baidu", pVar.t())) {
                com.bytedance.msdk.adapter.c w3 = com.bytedance.msdk.core.r.r.w(pVar);
                if (w3 == null) {
                    return "";
                }
                try {
                    map.put(String.format("%1$s_%2$s_%3$s", wVar.c(), wVar.u(), pVar.ia()), w3);
                    if (wVar.fz() == 5) {
                        return w3.getBiddingToken(context, pVar.ia(), wVar);
                    }
                    return w3.getBiddingToken(context, pVar.ia(), wVar);
                } catch (Throwable unused) {
                    return "";
                }
            }
            return com.bytedance.msdk.sr.w.c.c(map2, pVar.t());
        }
        xv.w("serverBiddingRequest", "adSlot is null or waterFallConfig is null can not get server bidding token");
        return "";
    }

    private JSONObject w(w wVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            int fz = wVar.fz();
            jSONObject.put("id", wVar.u());
            jSONObject.put("adtype", fz);
            jSONObject.put("pos", c(fz));
            c(jSONObject, "accepted_size", wVar.q(), wVar.j());
            jSONObject.put("is_support_dpl", wVar.n());
            int ls = wVar.ls();
            int i4 = 1;
            if (ls < 1) {
                ls = 1;
            }
            if (ls > 3) {
                ls = 3;
            }
            if (fz != 7 && fz != 8) {
                i4 = ls;
            }
            jSONObject.put("ad_count", i4);
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    private JSONObject xv() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("appid", com.bytedance.msdk.core.w.k().a());
            jSONObject.put("name", com.bytedance.msdk.core.w.k().i());
            w(jSONObject);
            xv(jSONObject);
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    public static c c() {
        if (f28297c == null) {
            synchronized (c.class) {
                if (f28297c == null) {
                    f28297c = new c();
                }
            }
        }
        return f28297c;
    }

    private void w(JSONObject jSONObject) {
        try {
            jSONObject.put("package_name", m.c());
            jSONObject.put("version_code", m.w());
            jSONObject.put("version", m.xv());
        } catch (Exception unused) {
        }
    }

    private String w(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            com.bytedance.msdk.api.sr.c.w.f.c c4 = com.bytedance.msdk.sr.w.c.c(str);
            if (c4 != null) {
                return c4.c();
            }
            com.bytedance.msdk.adapter.c.xv c5 = com.bytedance.msdk.sr.w.w.c().c(str);
            if (c5 == null) {
                return null;
            }
            return c5.w();
        } catch (Throwable th) {
            th.printStackTrace();
            xv.sr("TTMediationSDK_SDK_Init", "GDT SDK \u521d\u59cb\u5316\u5931\u8d25\u3002\u3002 e=" + th.toString());
            return null;
        }
    }

    public void c(Map<String, com.bytedance.msdk.adapter.c> map, Context context, w wVar, List<p> list, List<com.bytedance.msdk.c.ux> list2, com.bytedance.msdk.core.k.w wVar2, int i4, boolean z3, final InterfaceC0423c interfaceC0423c) {
        final JSONObject jSONObject = new JSONObject();
        String c4 = c(map, context, wVar, list, list2, wVar2, i4, z3, jSONObject);
        sr w3 = com.bytedance.msdk.w.w.c().w().w();
        w3.c(com.bytedance.msdk.core.xv.sr());
        String ev = com.bytedance.msdk.core.w.k().ev();
        if (!TextUtils.isEmpty(ev)) {
            w3.w("X-Tt-Env", ev);
            w3.w("x-use-ppe", "1");
        }
        w3.w("User-Agent", com.bytedance.msdk.c.sr.f27665c);
        w3.xv(c4);
        w3.c(new com.bytedance.sdk.component.ev.c.c() { // from class: com.bytedance.msdk.core.ys.c.1
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Removed duplicated region for block: B:102:0x02ac A[Catch: all -> 0x02e9, TRY_ENTER, TRY_LEAVE, TryCatch #7 {all -> 0x0313, blocks: (B:72:0x01df, B:71:0x01dc, B:73:0x01eb, B:77:0x01fc, B:79:0x0206, B:80:0x0221, B:82:0x0229, B:84:0x0244, B:87:0x024b, B:93:0x0289, B:94:0x028c, B:95:0x0292, B:97:0x029f, B:100:0x02a6, B:106:0x0302, B:107:0x0305, B:102:0x02ac, B:89:0x0251), top: B:136:0x01dc }] */
            /* JADX WARN: Removed duplicated region for block: B:115:0x0335 A[Catch: all -> 0x0372, TryCatch #5 {all -> 0x0372, blocks: (B:109:0x030a, B:114:0x031d, B:115:0x0335, B:116:0x034d), top: B:132:0x0026 }] */
            /* JADX WARN: Removed duplicated region for block: B:125:0x0396  */
            /* JADX WARN: Removed duplicated region for block: B:29:0x0084 A[Catch: all -> 0x0374, TryCatch #10 {all -> 0x0374, blocks: (B:6:0x0011, B:8:0x0028, B:12:0x0032, B:29:0x0084, B:31:0x008e, B:19:0x005e, B:26:0x007b, B:14:0x003c, B:21:0x006c), top: B:142:0x0011 }] */
            /* JADX WARN: Removed duplicated region for block: B:79:0x0206 A[Catch: all -> 0x0313, TryCatch #7 {all -> 0x0313, blocks: (B:72:0x01df, B:71:0x01dc, B:73:0x01eb, B:77:0x01fc, B:79:0x0206, B:80:0x0221, B:82:0x0229, B:84:0x0244, B:87:0x024b, B:93:0x0289, B:94:0x028c, B:95:0x0292, B:97:0x029f, B:100:0x02a6, B:106:0x0302, B:107:0x0305, B:102:0x02ac, B:89:0x0251), top: B:136:0x01dc }] */
            /* JADX WARN: Removed duplicated region for block: B:82:0x0229 A[Catch: all -> 0x0313, TryCatch #7 {all -> 0x0313, blocks: (B:72:0x01df, B:71:0x01dc, B:73:0x01eb, B:77:0x01fc, B:79:0x0206, B:80:0x0221, B:82:0x0229, B:84:0x0244, B:87:0x024b, B:93:0x0289, B:94:0x028c, B:95:0x0292, B:97:0x029f, B:100:0x02a6, B:106:0x0302, B:107:0x0305, B:102:0x02ac, B:89:0x0251), top: B:136:0x01dc }] */
            /* JADX WARN: Type inference failed for: r1v21 */
            /* JADX WARN: Type inference failed for: r1v28, types: [java.lang.String] */
            /* JADX WARN: Type inference failed for: r1v29 */
            /* JADX WARN: Type inference failed for: r1v3 */
            /* JADX WARN: Type inference failed for: r1v39 */
            /* JADX WARN: Type inference failed for: r1v4, types: [java.lang.String] */
            /* JADX WARN: Type inference failed for: r1v40 */
            /* JADX WARN: Type inference failed for: r1v41 */
            /* JADX WARN: Type inference failed for: r1v42 */
            /* JADX WARN: Type inference failed for: r1v43 */
            /* JADX WARN: Type inference failed for: r1v44 */
            /* JADX WARN: Type inference failed for: r1v45 */
            /* JADX WARN: Type inference failed for: r1v46 */
            /* JADX WARN: Type inference failed for: r1v47 */
            /* JADX WARN: Type inference failed for: r1v7 */
            /* JADX WARN: Type inference failed for: r1v9 */
            /* JADX WARN: Type inference failed for: r2v0 */
            /* JADX WARN: Type inference failed for: r2v15 */
            /* JADX WARN: Type inference failed for: r2v16 */
            /* JADX WARN: Type inference failed for: r2v17 */
            /* JADX WARN: Type inference failed for: r2v18 */
            /* JADX WARN: Type inference failed for: r2v5 */
            /* JADX WARN: Type inference failed for: r2v7 */
            @Override // com.bytedance.sdk.component.ev.c.c
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void c(com.bytedance.sdk.component.ev.w.xv r21, com.bytedance.sdk.component.ev.w r22) {
                /*
                    Method dump skipped, instructions count: 958
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.core.ys.c.AnonymousClass1.c(com.bytedance.sdk.component.ev.w.xv, com.bytedance.sdk.component.ev.w):void");
            }

            @Override // com.bytedance.sdk.component.ev.c.c
            public void c(com.bytedance.sdk.component.ev.w.xv xvVar, IOException iOException) {
                int i5;
                String iOException2;
                if (iOException instanceof SocketTimeoutException) {
                    i5 = 44405;
                    iOException2 = iOException.toString();
                } else {
                    i5 = 44404;
                    iOException2 = iOException != null ? iOException.toString() : "\u6ca1\u6709\u7f51\u7edc";
                }
                xv.sr("ServerBiddingHelper", "Server Bidding Request onError...errorCode=" + i5);
                InterfaceC0423c interfaceC0423c2 = interfaceC0423c;
                if (interfaceC0423c2 != null) {
                    c.this.c(interfaceC0423c2, new com.bytedance.msdk.api.c(i5, iOException2));
                }
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x007c A[Catch: all -> 0x00b4, TryCatch #2 {all -> 0x00b4, blocks: (B:8:0x000c, B:10:0x0021, B:14:0x002a, B:31:0x007c, B:33:0x0086, B:34:0x00a2, B:35:0x00a8, B:22:0x0058, B:29:0x0075, B:36:0x00ae, B:16:0x0034, B:24:0x0066), top: B:41:0x000c }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00a8 A[Catch: all -> 0x00b4, TryCatch #2 {all -> 0x00b4, blocks: (B:8:0x000c, B:10:0x0021, B:14:0x002a, B:31:0x007c, B:33:0x0086, B:34:0x00a2, B:35:0x00a8, B:22:0x0058, B:29:0x0075, B:36:0x00ae, B:16:0x0034, B:24:0x0066), top: B:41:0x000c }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void c(com.bytedance.msdk.core.k.r r6, java.lang.String r7) {
        /*
            r5 = this;
            java.lang.String r0 = "ServerBiddingHelper"
            if (r6 != 0) goto L5
            return
        L5:
            boolean r1 = android.text.TextUtils.isEmpty(r7)
            if (r1 == 0) goto Lc
            return
        Lc:
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch: java.lang.Throwable -> Lb4
            r1.<init>(r7)     // Catch: java.lang.Throwable -> Lb4
            r7 = 0
            java.lang.String r2 = "cypher"
            r3 = -1
            int r2 = r1.optInt(r2, r3)     // Catch: java.lang.Throwable -> Lb4
            java.lang.String r4 = "message"
            java.lang.String r1 = r1.optString(r4)     // Catch: java.lang.Throwable -> Lb4
            if (r2 <= r3) goto Lae
            boolean r3 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.Throwable -> Lb4
            if (r3 != 0) goto Lae
            r3 = 2
            if (r2 != r3) goto L55
            java.lang.String r1 = com.bytedance.msdk.f.m.c(r1)     // Catch: java.lang.Throwable -> Lb4
            boolean r2 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.Throwable -> Lb4
            if (r2 != 0) goto L7a
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch: java.lang.Throwable -> L3b
            r2.<init>(r1)     // Catch: java.lang.Throwable -> L3b
        L39:
            r7 = r2
            goto L7a
        L3b:
            r1 = move-exception
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lb4
            r2.<init>()     // Catch: java.lang.Throwable -> Lb4
            java.lang.String r3 = ">>>>> m_meta data error: "
            r2.append(r3)     // Catch: java.lang.Throwable -> Lb4
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> Lb4
            r2.append(r1)     // Catch: java.lang.Throwable -> Lb4
            java.lang.String r1 = r2.toString()     // Catch: java.lang.Throwable -> Lb4
            com.bytedance.msdk.adapter.sr.xv.c(r0, r1)     // Catch: java.lang.Throwable -> Lb4
            goto L7a
        L55:
            r3 = 1
            if (r2 != r3) goto L73
            java.lang.String r2 = com.bytedance.msdk.f.w.c()     // Catch: java.lang.Throwable -> Lb4
            java.lang.String r1 = com.bytedance.msdk.f.c.w(r1, r2)     // Catch: java.lang.Throwable -> Lb4
            boolean r2 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.Throwable -> Lb4
            if (r2 != 0) goto L7a
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch: java.lang.Throwable -> L6c
            r2.<init>(r1)     // Catch: java.lang.Throwable -> L6c
            goto L39
        L6c:
            r1 = move-exception
            java.lang.String r2 = "m_meta data error: "
            com.bytedance.msdk.adapter.sr.xv.c(r0, r2, r1)     // Catch: java.lang.Throwable -> Lb4
            goto L7a
        L73:
            if (r2 != 0) goto L7a
            org.json.JSONObject r7 = new org.json.JSONObject     // Catch: java.lang.Throwable -> Lb4
            r7.<init>(r1)     // Catch: java.lang.Throwable -> Lb4
        L7a:
            if (r7 == 0) goto La8
            java.lang.String r1 = r7.toString()     // Catch: java.lang.Throwable -> Lb4
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.Throwable -> Lb4
            if (r1 != 0) goto La2
            java.lang.String r1 = "request_id"
            java.lang.String r1 = r7.optString(r1)     // Catch: java.lang.Throwable -> Lb4
            r6.xv(r1)     // Catch: java.lang.Throwable -> Lb4
            java.lang.String r1 = "server_bidding_extra"
            java.lang.String r1 = r7.optString(r1)     // Catch: java.lang.Throwable -> Lb4
            r6.ux(r1)     // Catch: java.lang.Throwable -> Lb4
            java.lang.String r1 = "server_request_id"
            java.lang.String r7 = r7.optString(r1)     // Catch: java.lang.Throwable -> Lb4
            r6.sr(r7)     // Catch: java.lang.Throwable -> Lb4
            goto Lcd
        La2:
            java.lang.String r6 = "m_meta..data.string is null "
            com.bytedance.msdk.adapter.sr.xv.sr(r0, r6)     // Catch: java.lang.Throwable -> Lb4
            goto Lcd
        La8:
            java.lang.String r6 = "m_meta...data is null"
            com.bytedance.msdk.adapter.sr.xv.sr(r0, r6)     // Catch: java.lang.Throwable -> Lb4
            goto Lcd
        Lae:
            java.lang.String r6 = "m_meta onResponse error "
            com.bytedance.msdk.adapter.sr.xv.sr(r0, r6)     // Catch: java.lang.Throwable -> Lb4
            goto Lcd
        Lb4:
            r6 = move-exception
            java.lang.String r6 = r6.toString()
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r1 = "m_meta onResponse throwable \uff1a"
            r7.append(r1)
            r7.append(r6)
            java.lang.String r6 = r7.toString()
            com.bytedance.msdk.adapter.sr.xv.sr(r0, r6)
        Lcd:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.core.ys.c.c(com.bytedance.msdk.core.k.r, java.lang.String):void");
    }

    private ev c(JSONObject jSONObject) {
        JSONObject jSONObject2;
        if (jSONObject == null) {
            return null;
        }
        String optString = jSONObject.optString("m_adm");
        Object opt = jSONObject.opt("extra_data_and_no_parse");
        if (TextUtils.isEmpty(optString)) {
            return null;
        }
        try {
            JSONObject jSONObject3 = new JSONObject(optString);
            int optInt = jSONObject3.optInt("cypher", -1);
            String optString2 = jSONObject3.optString("message");
            if (optInt <= -1 || TextUtils.isEmpty(optString2)) {
                xv.sr("ServerBiddingHelper", "adm winner data onResponse error ");
                return null;
            }
            if (optInt == 2) {
                String c4 = m.c(optString2);
                if (!TextUtils.isEmpty(c4)) {
                    jSONObject2 = new JSONObject(c4);
                }
                jSONObject2 = null;
            } else if (optInt == 1) {
                String w3 = com.bytedance.msdk.f.c.w(optString2, com.bytedance.msdk.f.w.c());
                if (!TextUtils.isEmpty(w3)) {
                    jSONObject2 = new JSONObject(w3);
                }
                jSONObject2 = null;
            } else {
                if (optInt == 0) {
                    jSONObject2 = new JSONObject(optString2);
                }
                jSONObject2 = null;
            }
            if (jSONObject2 != null) {
                if (!TextUtils.isEmpty(jSONObject2.toString())) {
                    ev evVar = new ev();
                    evVar.w(jSONObject2.optInt("req_bidding_type"));
                    evVar.xv(jSONObject2.optString(BidResponsed.KEY_PRICE));
                    evVar.sr(jSONObject2.optString("load_price"));
                    evVar.p(jSONObject2.optString("adm"));
                    evVar.ux(jSONObject2.optString("name"));
                    evVar.r(jSONObject2.optString("app_id"));
                    evVar.f(jSONObject2.optString("slot_id"));
                    evVar.ev(jSONObject2.optString("win_callback", null));
                    evVar.gd(jSONObject2.optString("fail_callback", null));
                    evVar.c(jSONObject2.optString("m_aid", null));
                    evVar.w(jSONObject2.optString("ad_extra", null));
                    evVar.c(jSONObject2.optInt("pricing_type", 1));
                    evVar.c(opt);
                    return evVar;
                }
                xv.sr("ServerBiddingHelper", "adm winner data.string is null ");
                return null;
            }
            xv.sr("ServerBiddingHelper", "adm winner data is null");
            return null;
        } catch (Throwable th) {
            xv.sr("ServerBiddingHelper", "adm winner onResponse throwable \uff1a" + th.toString());
            return null;
        }
    }

    public void c(String str, InterfaceC0423c interfaceC0423c) {
        if (!TextUtils.isEmpty(str)) {
            try {
                r rVar = new r();
                JSONObject jSONObject = new JSONObject(str);
                JSONArray optJSONArray = jSONObject.optJSONArray("items");
                String optString = jSONObject.optString("m_meta");
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    ArrayList arrayList = new ArrayList();
                    for (int i4 = 0; i4 < optJSONArray.length(); i4++) {
                        ev c4 = c(optJSONArray.optJSONObject(i4));
                        if (c4 != null) {
                            arrayList.add(c4);
                        }
                    }
                    rVar.c(arrayList);
                }
                c(rVar, optString);
                c(interfaceC0423c, rVar);
                return;
            } catch (Throwable th) {
                String th2 = th.toString();
                xv.sr("ServerBiddingHelper", "Server Bidding onResponse throwable \uff1a" + th2);
                if (TextUtils.isEmpty(th2)) {
                    th2 = com.bytedance.msdk.api.c.c(-1);
                }
                c(interfaceC0423c, new com.bytedance.msdk.api.c(-1, th2));
                return;
            }
        }
        xv.sr("ServerBiddingHelper", "Server Bidding Request onResponse...response is invalid");
        c(interfaceC0423c, new com.bytedance.msdk.api.c(-1, "response is invalid"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(final InterfaceC0423c interfaceC0423c, final com.bytedance.msdk.api.c cVar) {
        com.bytedance.msdk.adapter.sr.f.c(new Runnable() { // from class: com.bytedance.msdk.core.ys.c.2
            @Override // java.lang.Runnable
            public void run() {
                InterfaceC0423c interfaceC0423c2 = interfaceC0423c;
                if (interfaceC0423c2 != null) {
                    interfaceC0423c2.c(cVar);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(final InterfaceC0423c interfaceC0423c, final r rVar) {
        com.bytedance.msdk.adapter.sr.f.c(new Runnable() { // from class: com.bytedance.msdk.core.ys.c.3
            @Override // java.lang.Runnable
            public void run() {
                InterfaceC0423c interfaceC0423c2 = interfaceC0423c;
                if (interfaceC0423c2 != null) {
                    interfaceC0423c2.c(rVar);
                }
            }
        });
    }

    private JSONObject c(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return new JSONObject(str);
        } catch (Exception e4) {
            e4.printStackTrace();
            return null;
        }
    }

    public String c(Map<String, com.bytedance.msdk.adapter.c> map, Context context, w wVar, List<p> list, com.bytedance.msdk.core.k.w wVar2, int i4, boolean z3, JSONObject jSONObject) {
        return context == null ? "" : c(map, context, wVar, list, (List<com.bytedance.msdk.c.ux>) null, wVar2, i4, z3, jSONObject);
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:179:0x05cd
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:81)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:47)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    private java.lang.String c(java.util.Map<java.lang.String, com.bytedance.msdk.adapter.c> r36, android.content.Context r37, com.bytedance.msdk.api.c.w r38, java.util.List<com.bytedance.msdk.core.k.p> r39, java.util.List<com.bytedance.msdk.c.ux> r40, com.bytedance.msdk.core.k.w r41, int r42, boolean r43, org.json.JSONObject r44) {
        /*
            Method dump skipped, instructions count: 1533
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.core.ys.c.c(java.util.Map, android.content.Context, com.bytedance.msdk.api.c.w, java.util.List, java.util.List, com.bytedance.msdk.core.k.w, int, boolean, org.json.JSONObject):java.lang.String");
    }

    private String c(w wVar, p pVar) {
        String c4 = wVar != null ? wVar.c() : null;
        if (pVar != null) {
            return (c4 + "_") + pVar.ia();
        }
        return c4;
    }

    private String c(JSONObject jSONObject, boolean z3) {
        JSONObject c4 = m.c(jSONObject);
        if (c4 != null) {
            try {
                c4.putOpt("token_type", Integer.valueOf(z3 ? 1 : 0));
            } catch (Exception unused) {
            }
            return c4.toString();
        }
        return null;
    }

    private JSONObject c(w wVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(ConstantAd.KEY_CACHE_AD, wVar.c());
            jSONObject.put("ad_sdk_version", com.bytedance.msdk.c.sr.w());
            jSONObject.put("plugin_version", com.bytedance.msdk.c.sr.sr());
            jSONObject.put("source_type", "app");
            jSONObject.put("app", xv());
            JSONObject ux = t.ux(com.bytedance.msdk.core.c.getContext());
            if (ux != null && wVar.eq() > 0) {
                ux.put("orientation", wVar.eq());
            }
            jSONObject.put("device", ux);
            jSONObject.put("ua", com.bytedance.msdk.c.sr.f27665c);
            jSONObject.put("ip", t.w());
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(w(wVar));
            jSONObject.put("adslots", jSONArray);
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            jSONObject.put("ts", currentTimeMillis);
            String str = "";
            if (wVar.u() != null && wVar.c() != null) {
                str = String.valueOf(currentTimeMillis).concat(wVar.u()).concat(wVar.c());
            }
            jSONObject.put("req_sign", ys.c(str));
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    private void c(JSONObject jSONObject, String str, int i4, int i5) {
        if (i4 <= 0 || i5 <= 0) {
            return;
        }
        JSONObject jSONObject2 = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        try {
            jSONObject2.put("width", i4);
            jSONObject2.put("height", i5);
            jSONArray.put(jSONObject2);
            jSONObject.put(str, jSONArray);
        } catch (Exception unused) {
        }
    }
}

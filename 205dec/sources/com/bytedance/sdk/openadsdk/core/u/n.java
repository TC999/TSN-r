package com.bytedance.sdk.openadsdk.core.u;

import android.net.Uri;
import android.text.TextUtils;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import cn.jpush.android.local.JPushConstants;
import com.bytedance.sdk.component.w.c.gd;
import com.bytedance.sdk.openadsdk.core.eq.f;
import com.mbridge.msdk.mbbid.common.BidResponsedEx;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class n {

    /* renamed from: a  reason: collision with root package name */
    private static volatile boolean f34772a;

    /* renamed from: c  reason: collision with root package name */
    public static final Set<String> f34773c;
    private static final Set<String> ev;

    /* renamed from: f  reason: collision with root package name */
    private static final Set<String> f34774f;
    private static final Set<String> gd;

    /* renamed from: k  reason: collision with root package name */
    private static final Map<String, String> f34775k;

    /* renamed from: p  reason: collision with root package name */
    private static boolean f34776p;

    /* renamed from: r  reason: collision with root package name */
    private static final Set<String> f34777r;
    private static final Set<String> sr;
    private static final Set<String> ux;
    private static final Set<String> xv;

    /* renamed from: w  reason: collision with root package name */
    private int f34778w;

    static {
        HashSet hashSet = new HashSet();
        xv = hashSet;
        sr = new CopyOnWriteArraySet();
        CopyOnWriteArraySet copyOnWriteArraySet = new CopyOnWriteArraySet();
        ux = copyOnWriteArraySet;
        f34774f = new CopyOnWriteArraySet();
        f34777r = new CopyOnWriteArraySet();
        CopyOnWriteArraySet copyOnWriteArraySet2 = new CopyOnWriteArraySet();
        ev = copyOnWriteArraySet2;
        gd = new CopyOnWriteArraySet();
        f34776p = false;
        f34775k = new HashMap();
        f34773c = new CopyOnWriteArraySet();
        f34772a = false;
        hashSet.addAll(Arrays.asList("dragon1967", "snssdk1128", "snssdk2329", "snssdk141", "snssdk35", "snssdk32", "snssdk1112"));
        copyOnWriteArraySet2.addAll(Arrays.asList(".*thefatherofsalmon\\.com.*@3", ".*qallzmx\\.quicklyopen\\.com.*@3", ".*fastappjump-drcn\\.hispace\\.hicloud\\.com.*@3", ".*fastappjump-drcn\\.hispace\\.dbankcloud\\.cn.*@3"));
        copyOnWriteArraySet.addAll(Arrays.asList("^hap://app", "^hwfastapp://", ".*thefatherofsalmon\\.com.*", ".*qallzmx\\.quicklyopen\\.com.*", ".*fastappjump-drcn\\.hispace\\.hicloud\\.com.*", ".*fastappjump-drcn\\.hispace\\.dbankcloud\\.cn.*"));
    }

    public n(JSONObject jSONObject) {
        this.f34778w = jSONObject.optInt("block_auto_open");
    }

    public static void w(JSONObject jSONObject) {
        try {
            JSONArray optJSONArray = jSONObject.optJSONArray("turn_up_white_list");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                sr.clear();
                for (int i4 = 0; i4 < optJSONArray.length(); i4++) {
                    String optString = optJSONArray.optString(i4);
                    if (!TextUtils.isEmpty(optString)) {
                        sr.add(optString);
                    }
                }
            }
        } catch (Exception unused) {
        }
        try {
            JSONArray optJSONArray2 = jSONObject.optJSONArray("turn_up_black_list_1");
            if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                ux.clear();
                for (int i5 = 0; i5 < optJSONArray2.length(); i5++) {
                    String optString2 = optJSONArray2.optString(i5);
                    if (!TextUtils.isEmpty(optString2)) {
                        ux.add(optString2);
                    }
                }
            }
        } catch (Exception unused2) {
        }
        try {
            JSONArray optJSONArray3 = jSONObject.optJSONArray("turn_up_black_list_2");
            if (optJSONArray3 != null && optJSONArray3.length() > 0) {
                f34774f.clear();
                for (int i6 = 0; i6 < optJSONArray3.length(); i6++) {
                    String optString3 = optJSONArray3.optString(i6);
                    if (!TextUtils.isEmpty(optString3)) {
                        f34774f.add(optString3);
                    }
                }
            }
        } catch (Exception unused3) {
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("app_common_config");
        if (optJSONObject != null) {
            try {
                JSONArray optJSONArray4 = optJSONObject.optJSONArray("url_report_rule_list");
                if (optJSONArray4 != null && optJSONArray4.length() > 0) {
                    f34777r.clear();
                    for (int i7 = 0; i7 < optJSONArray4.length(); i7++) {
                        String optString4 = optJSONArray4.optString(i7);
                        if (!TextUtils.isEmpty(optString4)) {
                            f34777r.add(optString4);
                        }
                    }
                }
                JSONArray optJSONArray5 = optJSONObject.optJSONArray("net_url_block_list");
                if (optJSONArray5 != null && optJSONArray5.length() > 0) {
                    ev.clear();
                    for (int i8 = 0; i8 < optJSONArray5.length(); i8++) {
                        String optString5 = optJSONArray5.optString(i8);
                        if (!TextUtils.isEmpty(optString5)) {
                            ev.add(optString5);
                        }
                    }
                }
                JSONArray optJSONArray6 = optJSONObject.optJSONArray("dialog_black_list");
                if (optJSONArray6 != null && optJSONArray6.length() > 0) {
                    gd.clear();
                    for (int i9 = 0; i9 < optJSONArray6.length(); i9++) {
                        String optString6 = optJSONArray6.optString(i9);
                        if (!TextUtils.isEmpty(optString6)) {
                            gd.add(optString6);
                        }
                    }
                }
            } catch (Exception unused4) {
            }
        }
        f34776p = true;
    }

    public void c(JSONObject jSONObject) {
        try {
            jSONObject.put("block_auto_open", this.f34778w);
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
    }

    public static void c(com.bytedance.sdk.component.f.c cVar) {
        cVar.c("turn_up_white_list", sr);
        cVar.c("turn_up_black_list_1", ux);
        cVar.c("turn_up_black_list_2", f34774f);
        cVar.c("url_report_rule_list", f34777r);
        cVar.c("net_url_block_list", ev);
        cVar.c("_turn_up_is_get_list", f34776p);
        cVar.c("dialog_black_list", gd);
    }

    public static int c(me meVar) {
        n yr;
        if (meVar == null || (yr = meVar.yr()) == null) {
            return 0;
        }
        return yr.f34778w;
    }

    public static boolean c(WebView webView, AtomicInteger atomicInteger, com.bytedance.sdk.openadsdk.core.xk xkVar, String str, boolean z3, boolean z4) {
        if (str.startsWith("bytedance") || str.startsWith("nativeapp")) {
            return false;
        }
        if (com.bytedance.sdk.openadsdk.core.eq.wv.c(str, atomicInteger) || !c(webView, atomicInteger, str, true)) {
            if (xkVar == null || w(str, xv) || w(str, sr)) {
                return false;
            }
            if (w(str, f34777r)) {
                w(xkVar.f(), str);
            }
            boolean c4 = c(str, xkVar.f(z4), z3, z4);
            if (c4 && f34776p) {
                c(xkVar.f(), str);
            }
            return c4;
        }
        return true;
    }

    private static boolean c(WebView webView, AtomicInteger atomicInteger, String str, boolean z3) {
        if (TextUtils.isEmpty(str) || webView == null) {
            return false;
        }
        final String[] strArr = {""};
        try {
            final String path = Uri.parse(str).getPath();
            Map<String, String> map = f34775k;
            if (map.containsKey(path)) {
                return c(atomicInteger, map.get(path), str, webView, z3);
            }
            if (!f34772a) {
                for (String str2 : com.bytedance.sdk.openadsdk.core.eq.ba.c("cloud_path_check_res").w("cloud_path_check_res", new HashSet())) {
                    if (!TextUtils.isEmpty(str2)) {
                        String[] split = str2.split(",");
                        f34775k.put(split[0], split[1]);
                    }
                }
                Map<String, String> map2 = f34775k;
                if (map2.containsKey(path)) {
                    return c(atomicInteger, map2.get(path), str, webView, z3);
                }
            }
            com.bytedance.sdk.component.ev.w.sr w3 = com.bytedance.sdk.openadsdk.core.q.ux.c().w().w();
            w3.c(Uri.parse("https://scc.bytedance.com/scc_sdk/url_scan_v4").buildUpon().appendQueryParameter("aid", "1181").appendQueryParameter("device_platform", "android").appendQueryParameter("device_id", com.bytedance.sdk.openadsdk.core.i.xv()).appendQueryParameter("scc_mode", "raw").appendQueryParameter("scc_from", "App").toString());
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("ts", System.currentTimeMillis());
            jSONObject.put("scene", "common");
            jSONObject.put("url", str);
            jSONObject.put("extra", "");
            w3.c(jSONObject);
            final CountDownLatch countDownLatch = new CountDownLatch(1);
            w3.c(new com.bytedance.sdk.component.ev.c.c() { // from class: com.bytedance.sdk.openadsdk.core.u.n.1
                @Override // com.bytedance.sdk.component.ev.c.c
                public void c(com.bytedance.sdk.component.ev.w.xv xvVar, com.bytedance.sdk.component.ev.w wVar) {
                    try {
                        strArr[0] = new JSONObject(wVar.sr()).optJSONObject("data").optString("label");
                    } catch (Throwable unused) {
                    }
                    if (TextUtils.isEmpty(strArr[0])) {
                        return;
                    }
                    if (n.f34775k.size() > 1000) {
                        Iterator it = n.f34775k.entrySet().iterator();
                        for (int i4 = 0; i4 < 200; i4++) {
                            it.next();
                            it.remove();
                        }
                    }
                    n.f34775k.put(path, strArr[0]);
                    if (!n.f34772a) {
                        boolean unused2 = n.f34772a = true;
                        com.bytedance.sdk.component.utils.ev.c().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.u.n.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                com.bytedance.sdk.component.f.c c4 = com.bytedance.sdk.openadsdk.core.eq.ba.c("cloud_path_check_res");
                                c4.w();
                                HashSet hashSet = new HashSet();
                                for (Map.Entry entry : n.f34775k.entrySet()) {
                                    hashSet.add(((String) entry.getKey()) + "," + ((String) entry.getValue()));
                                }
                                c4.c("cloud_path_check_res", hashSet);
                                boolean unused3 = n.f34772a = false;
                            }
                        }, 1800000L);
                    }
                    countDownLatch.countDown();
                }

                @Override // com.bytedance.sdk.component.ev.c.c
                public void c(com.bytedance.sdk.component.ev.w.xv xvVar, IOException iOException) {
                    countDownLatch.countDown();
                }
            });
            countDownLatch.await();
            return c(atomicInteger, strArr[0], str, webView, z3);
        } catch (Throwable unused) {
            return false;
        }
    }

    public static void w(com.bytedance.sdk.component.f.c cVar) {
        Set<String> set = sr;
        set.addAll(cVar.w("turn_up_white_list", set));
        Set<String> set2 = ux;
        set2.addAll(cVar.w("turn_up_black_list_1", set2));
        Set<String> set3 = f34774f;
        set3.addAll(cVar.w("turn_up_black_list_2", set3));
        Set<String> set4 = f34777r;
        set4.addAll(cVar.w("url_report_rule_list", set4));
        Set<String> set5 = ev;
        set5.addAll(cVar.w("net_url_block_list", set5));
        f34776p = cVar.w("_turn_up_is_get_list", false);
        Set<String> set6 = gd;
        set6.addAll(cVar.w("dialog_black_list", set6));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean w(String str, Set<String> set) {
        if (str == null) {
            return false;
        }
        try {
            for (String str2 : set) {
                if (Pattern.compile(str2).matcher(str).find()) {
                    return true;
                }
            }
            return false;
        } catch (Exception e4) {
            com.bytedance.sdk.component.utils.a.f("JumpModel", "" + e4.getMessage());
            return false;
        }
    }

    private static boolean c(AtomicInteger atomicInteger, String str, String str2, WebView webView, boolean z3) {
        if (webView == null || TextUtils.isEmpty(str) || atomicInteger == null) {
            return false;
        }
        if (atomicInteger.get() == 1) {
            return true;
        }
        char c4 = '\uffff';
        switch (str.hashCode()) {
            case -284840886:
                if (str.equals("unknown")) {
                    c4 = 1;
                    break;
                }
                break;
            case 3181155:
                if (str.equals("gray")) {
                    c4 = 2;
                    break;
                }
                break;
            case 93818879:
                if (str.equals("black")) {
                    c4 = 0;
                    break;
                }
                break;
            case 113101865:
                if (str.equals("white")) {
                    c4 = 3;
                    break;
                }
                break;
        }
        if (c4 != 0) {
            return false;
        }
        atomicInteger.set(1);
        com.bytedance.sdk.openadsdk.core.eq.f.c(webView.getContext(), (String) null, true, (f.c) null);
        return true;
    }

    public static void w(final me meVar, final String str) {
        com.bytedance.sdk.openadsdk.core.fz.a.c().w(new com.bytedance.sdk.openadsdk.p.c.c() { // from class: com.bytedance.sdk.openadsdk.core.u.n.4
            @Override // com.bytedance.sdk.openadsdk.p.c.c
            public com.bytedance.sdk.openadsdk.core.fz.c.c c() throws Exception {
                JSONObject jSONObject = new JSONObject();
                jSONObject.putOpt("url", str);
                return com.bytedance.sdk.openadsdk.core.fz.c.xv.w().c("stats_url_report_rule").ev(meVar.cf()).w(jSONObject.toString());
            }
        }, "stats_url_report_rule");
    }

    public static com.bytedance.sdk.component.w.c.gd w() {
        return new com.bytedance.sdk.component.w.c.gd() { // from class: com.bytedance.sdk.openadsdk.core.u.n.5
            @Override // com.bytedance.sdk.component.w.c.gd
            public com.bytedance.sdk.component.w.c.fp c(gd.c cVar) throws IOException {
                String str;
                com.bytedance.sdk.component.w.c.fp c4 = cVar.c(cVar.c());
                String str2 = "";
                final String c5 = c4.c("csj-location-record", "");
                final String c6 = c4.c("csj-source-from", "");
                final String c7 = c4.c("csj-extra-info", "");
                if (c4.xv() == 8848) {
                    final String ux2 = c4.ux();
                    com.bytedance.sdk.openadsdk.core.fz.a.c().w(new com.bytedance.sdk.openadsdk.p.c.c() { // from class: com.bytedance.sdk.openadsdk.core.u.n.5.1
                        @Override // com.bytedance.sdk.openadsdk.p.c.c
                        public com.bytedance.sdk.openadsdk.core.fz.c.c c() throws Exception {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.putOpt("url", ux2);
                            jSONObject.putOpt("sourceFrom", c6);
                            jSONObject.putOpt("extraInfo", c7);
                            return com.bytedance.sdk.openadsdk.core.fz.c.xv.w().c("stats_net_block_url").w(jSONObject.toString());
                        }
                    }, "stats_net_block_url");
                }
                try {
                    String[] c8 = n.c(c5);
                    if (c8 == null || c8.length <= 1) {
                        str = "";
                    } else {
                        String str3 = c8[0];
                        try {
                            str = c8[c8.length - 1];
                            str2 = str3;
                        } catch (Exception unused) {
                            str = "";
                            str2 = str3;
                            final String str4 = str2;
                            final String str5 = str;
                            if (!TextUtils.isEmpty(c5) || 0 == 0 || n.w(str4, n.sr)) {
                                return c4;
                            }
                            com.bytedance.sdk.openadsdk.core.fz.a.c().w(new com.bytedance.sdk.openadsdk.p.c.c() { // from class: com.bytedance.sdk.openadsdk.core.u.n.5.2
                                @Override // com.bytedance.sdk.openadsdk.p.c.c
                                public com.bytedance.sdk.openadsdk.core.fz.c.c c() throws Exception {
                                    JSONObject jSONObject = new JSONObject();
                                    jSONObject.putOpt("url", c5);
                                    jSONObject.putOpt("sourceFrom", c6);
                                    jSONObject.putOpt("sourceUrl", str4);
                                    jSONObject.putOpt("destUrl", str5);
                                    jSONObject.putOpt("extraInfo", c7);
                                    return com.bytedance.sdk.openadsdk.core.fz.c.xv.w().c("stats_net_locations_url").w(jSONObject.toString());
                                }
                            }, "stats_net_locations_url");
                            return c4;
                        }
                    }
                } catch (Exception unused2) {
                    str = "";
                }
                try {
                    Integer.parseInt(c6);
                } catch (Exception unused3) {
                    final String str42 = str2;
                    final String str52 = str;
                    if (TextUtils.isEmpty(c5)) {
                    }
                    return c4;
                }
            }
        };
    }

    public static boolean c(WebView webView, AtomicInteger atomicInteger, com.bytedance.sdk.openadsdk.core.xk xkVar, WebResourceRequest webResourceRequest, boolean z3, boolean z4) {
        Uri url;
        if (webResourceRequest == null || (url = webResourceRequest.getUrl()) == null) {
            return false;
        }
        return c(webView, atomicInteger, xkVar, url.toString(), z3, z4);
    }

    public static boolean c(final com.bytedance.sdk.openadsdk.core.xk xkVar, final int i4, final String str) {
        final boolean z3 = !f34776p || w(str, gd);
        com.bytedance.sdk.openadsdk.core.fz.a.c().w(new com.bytedance.sdk.openadsdk.p.c.c() { // from class: com.bytedance.sdk.openadsdk.core.u.n.2
            @Override // com.bytedance.sdk.openadsdk.p.c.c
            public com.bytedance.sdk.openadsdk.core.fz.c.c c() throws Exception {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.putOpt("url", str);
                    jSONObject.putOpt("type", Integer.valueOf(i4));
                    jSONObject.putOpt("is_block", Boolean.valueOf(z3));
                    jSONObject.putOpt("customer_id", com.bytedance.sdk.openadsdk.core.eq.wv.p(xkVar.f()));
                    return com.bytedance.sdk.openadsdk.core.fz.c.xv.w().c("stats_dialog_report_rule").ev(xkVar.f().cf()).w(jSONObject.toString());
                } catch (Throwable unused) {
                    return com.bytedance.sdk.openadsdk.core.fz.c.xv.w();
                }
            }
        }, "stats_dialog_report_rule");
        return z3;
    }

    private static boolean c(String str, int i4, boolean z3, boolean z4) {
        boolean z5 = (!z4 || str.startsWith(JPushConstants.HTTP_PRE) || str.startsWith(JPushConstants.HTTPS_PRE)) ? false : true;
        if (i4 == 1) {
            if (f34776p) {
                return w(str, f34774f);
            }
            return false;
        } else if (i4 == 2) {
            return !f34776p ? z3 : z5 || w(str, ux) || w(str, f34774f);
        } else if (i4 != 3) {
            return false;
        } else {
            return z3 || !f34776p || z5 || w(str, ux) || w(str, f34774f);
        }
    }

    public static void c(final me meVar, final String str) {
        com.bytedance.sdk.openadsdk.core.fz.a.c().w(new com.bytedance.sdk.openadsdk.p.c.c() { // from class: com.bytedance.sdk.openadsdk.core.u.n.3
            @Override // com.bytedance.sdk.openadsdk.p.c.c
            public com.bytedance.sdk.openadsdk.core.fz.c.c c() throws Exception {
                JSONObject jSONObject = new JSONObject();
                jSONObject.putOpt("url", str);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("aid", meVar.zb());
                jSONObject2.put(BidResponsedEx.KEY_CID, meVar.jr());
                jSONObject2.put("req_id", meVar.xq());
                jSONObject2.put("customer_id", com.bytedance.sdk.openadsdk.core.eq.wv.p(meVar));
                jSONObject.putOpt("extraInfo", jSONObject2.toString());
                return com.bytedance.sdk.openadsdk.core.fz.c.xv.w().c("stats_block_report").ev(meVar.cf()).w(jSONObject.toString());
            }
        }, "stats_block_report");
    }

    public static Set<String> c() {
        return ev;
    }

    public static String[] c(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return str.substring(1, str.length() - 1).split(",");
    }
}

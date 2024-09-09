package com.bytedance.sdk.component.r.w.xv;

import android.text.TextUtils;
import com.bytedance.pangle.sdk.component.log.impl.core.monitor.EventMonitor;
import com.bytedance.sdk.component.r.c.sr;
import com.bytedance.sdk.component.r.c.ux;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class c {

    /* renamed from: c  reason: collision with root package name */
    private static final LinkedList<String> f30176c = new LinkedList<>();

    /* renamed from: w  reason: collision with root package name */
    private static final LinkedList<String> f30179w = new LinkedList<>();
    private static final LinkedList<String> xv = new LinkedList<>();
    private static final LinkedList<String> sr = new LinkedList<>();
    private static final Map<String, Integer> ux = new HashMap();

    /* renamed from: f  reason: collision with root package name */
    private static String f30177f = "upload_init";

    /* renamed from: r  reason: collision with root package name */
    private static int f30178r = 0;
    private static int ev = 0;
    private static AtomicLong gd = new AtomicLong();

    public static synchronized int c(String str) {
        synchronized (c.class) {
            if (TextUtils.isEmpty(str)) {
                return 0;
            }
            Map<String, Integer> map = ux;
            Integer num = map.get(str);
            if (num == null) {
                map.put(str, 1);
                return 1;
            }
            int intValue = num.intValue() + 1;
            map.put(str, Integer.valueOf(intValue));
            return intValue;
        }
    }

    public static boolean c(int i4) {
        return i4 == 2 || i4 == 1;
    }

    public static void ev(com.bytedance.sdk.component.r.c.w wVar, ux uxVar) {
        if (uxVar != null && uxVar.sr() != null && uxVar.sr().xv()) {
            try {
                com.bytedance.sdk.component.r.w.w.w.f30136c.c(System.currentTimeMillis() - wVar.ev());
                wVar.w(System.currentTimeMillis());
                if (wVar.sr() != 0 || uxVar.sr() == null || !uxVar.sr().ys()) {
                    return;
                }
                String c4 = c(wVar, uxVar);
                if (xv(c4)) {
                    return;
                }
                JSONObject r3 = wVar.r();
                String optString = wVar.r().optString("ad_extra_data");
                if (!TextUtils.isEmpty(optString)) {
                    JSONObject jSONObject = new JSONObject(optString);
                    if (TextUtils.isEmpty(jSONObject.optString(EventMonitor.SAVE_SUCCESS_LABELS))) {
                        jSONObject.put(EventMonitor.SAVE_SUCCESS_LABELS, sr(c4));
                    }
                    r3.put("ad_extra_data", jSONObject.toString());
                    return;
                }
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(EventMonitor.SAVE_SUCCESS_LABELS, sr(c4));
                r3.put("ad_extra_data", jSONObject2.toString());
            } catch (Exception unused) {
            }
        }
    }

    private static synchronized void f(String str) {
        synchronized (c.class) {
            LinkedList<String> linkedList = sr;
            if (linkedList.size() >= 10) {
                linkedList.removeFirst();
                linkedList.add(str);
            } else {
                linkedList.add(str);
            }
        }
    }

    public static void gd(com.bytedance.sdk.component.r.c.w wVar, ux uxVar) {
        if (uxVar == null) {
            return;
        }
        try {
            sr sr2 = uxVar.sr();
            if (sr2 == null || !sr2.c()) {
                return;
            }
            if (!TextUtils.isEmpty(wVar.xv())) {
                w.c(com.bytedance.sdk.component.r.w.w.w.f30136c.fz(), 1, uxVar);
            }
            if (wVar.sr() == 1) {
                xv.xv("_delete", "stats,[type:" + w(wVar, uxVar) + ",index:" + sr(wVar, uxVar) + ",localId:" + wVar.xv() + ",sessionId:" + p(wVar, uxVar) + "]", uxVar);
            } else if (wVar.sr() == 0) {
                if (wVar.w() == 3) {
                    if (wVar.r() != null) {
                        String optString = wVar.r().optString("event");
                        StringBuilder sb = new StringBuilder();
                        sb.append("v3,[");
                        sb.append("label:");
                        sb.append(optString);
                        long c4 = c(uxVar, wVar);
                        if (c4 != 0) {
                            sb.append(", index:");
                            sb.append(c4);
                        }
                        sb.append(", localId:");
                        sb.append(wVar.xv());
                        sb.append(", sessionId:");
                        sb.append(p(wVar, uxVar));
                        sb.append("]");
                        xv.xv("_delete", sb.toString(), uxVar);
                        return;
                    }
                    xv.xv("_delete", "v3_error", uxVar);
                    return;
                }
                StringBuilder sb2 = new StringBuilder();
                sb2.append("ad [");
                sb2.append("label:");
                sb2.append(c(wVar, uxVar));
                long c5 = c(uxVar, wVar);
                if (c5 != 0) {
                    sb2.append(", index:");
                    sb2.append(c5);
                }
                sb2.append(", localId:");
                sb2.append(wVar.xv());
                sb2.append(", sessionId:");
                sb2.append(p(wVar, uxVar));
                sb2.append("]");
                xv.xv("_delete", sb2.toString(), uxVar);
            }
        } catch (Exception e4) {
            xv.sr("_delete error", e4.getMessage(), uxVar);
        }
    }

    private static String p(com.bytedance.sdk.component.r.c.w wVar, ux uxVar) {
        String optString;
        if (wVar == null || wVar.r() == null || !c(uxVar)) {
            return null;
        }
        JSONObject r3 = wVar.r();
        if (wVar.sr() == 1) {
            optString = r3.optString(EventMonitor.EVENT_EXTRA);
        } else {
            optString = r3.optString("ad_extra_data");
        }
        try {
            return new JSONObject(optString).optString(EventMonitor.KEY_SDK_SESSION_ID);
        } catch (JSONException e4) {
            xv.sr(e4.getMessage(), uxVar);
            return null;
        }
    }

    public static void r(com.bytedance.sdk.component.r.c.w wVar, ux uxVar) {
        try {
            if (wVar.sr() == 0 && uxVar.sr() != null && uxVar.sr().ys()) {
                JSONObject r3 = wVar.r();
                String c4 = c(wVar, uxVar);
                if (xv(c4)) {
                    return;
                }
                String optString = r3.optString("ad_extra_data");
                if (!TextUtils.isEmpty(optString)) {
                    JSONObject jSONObject = new JSONObject(optString);
                    if (TextUtils.isEmpty(jSONObject.optString(EventMonitor.WILL_SEND_LABELS))) {
                        jSONObject.put(EventMonitor.WILL_SEND_LABELS, ux(c4));
                        jSONObject.put(EventMonitor.SEND_SUCCESS_VALID_LABELS, w());
                    }
                    r3.put("ad_extra_data", jSONObject.toString());
                    return;
                }
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(EventMonitor.WILL_SEND_LABELS, ux(c4));
                jSONObject2.put(EventMonitor.SEND_SUCCESS_VALID_LABELS, w());
                r3.put("ad_extra_data", jSONObject2.toString());
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    private static synchronized String sr(String str) {
        String sb;
        synchronized (c.class) {
            LinkedList<String> linkedList = f30179w;
            if (linkedList.size() >= 10) {
                linkedList.removeFirst();
                linkedList.add(str);
            } else {
                linkedList.add(str);
            }
            StringBuilder sb2 = new StringBuilder();
            Iterator<String> it = linkedList.iterator();
            while (it.hasNext()) {
                sb2.append(it.next());
                sb2.append(",");
            }
            sb = sb2.toString();
        }
        return sb;
    }

    private static synchronized String ux(String str) {
        String sb;
        synchronized (c.class) {
            LinkedList<String> linkedList = xv;
            if (linkedList.size() >= 10) {
                linkedList.removeFirst();
                linkedList.add(str);
            } else {
                linkedList.add(str);
            }
            StringBuilder sb2 = new StringBuilder();
            Iterator<String> it = linkedList.iterator();
            while (it.hasNext()) {
                sb2.append(it.next());
                sb2.append(",");
            }
            sb = sb2.toString();
        }
        return sb;
    }

    public static String w(int i4) {
        switch (i4) {
            case 1:
                return "flush once";
            case 2:
                return "flush memory db";
            case 3:
                return "flush memory";
            case 4:
                return "new event";
            case 5:
                return "server busy";
            case 6:
                return "empty message";
            case 7:
                return "net error";
            default:
                return "default";
        }
    }

    public static synchronized String w(String str) {
        String sb;
        synchronized (c.class) {
            LinkedList<String> linkedList = f30176c;
            if (linkedList.size() >= 10) {
                linkedList.removeFirst();
                linkedList.add(str);
            } else {
                linkedList.add(str);
            }
            StringBuilder sb2 = new StringBuilder();
            Iterator<String> it = linkedList.iterator();
            while (it.hasNext()) {
                sb2.append(it.next());
                sb2.append(",");
            }
            sb = sb2.toString();
        }
        return sb;
    }

    public static String xv(com.bytedance.sdk.component.r.c.w wVar, ux uxVar) {
        String c4 = c(wVar, uxVar);
        if (TextUtils.isEmpty(c4)) {
            if (TextUtils.isEmpty(w(wVar, uxVar))) {
                return null;
            }
            return "type:" + w(wVar, uxVar);
        }
        return "label:" + c4;
    }

    public static boolean xv(String str) {
        return false;
    }

    public static String f(com.bytedance.sdk.component.r.c.w wVar, ux uxVar) {
        if (wVar != null && wVar.r() != null && !w(uxVar) && !sr(uxVar)) {
            String optString = wVar.r().optString("log_extra");
            if (!TextUtils.isEmpty(optString)) {
                try {
                    return new JSONObject(optString).optString("req_id");
                } catch (JSONException e4) {
                    e4.printStackTrace();
                }
            }
        }
        return null;
    }

    public static boolean xv(ux uxVar) {
        return uxVar != null && TextUtils.equals(uxVar.ux(), "pangle");
    }

    public static boolean xv(com.bytedance.sdk.component.r.c.w wVar) {
        return wVar != null && wVar.sr() == 0 && wVar.ux() == 2;
    }

    public static String c(com.bytedance.sdk.component.r.c.w wVar, ux uxVar) {
        if (wVar == null || wVar.r() == null || w(uxVar) || sr(uxVar)) {
            return null;
        }
        if (wVar.w() == 3) {
            return wVar.r().optString("event");
        }
        return wVar.r().optString("label");
    }

    public static int sr(com.bytedance.sdk.component.r.c.w wVar, ux uxVar) {
        if (wVar != null && wVar.r() != null && wVar.sr() == 1) {
            try {
                return new JSONObject(wVar.r().optString(EventMonitor.EVENT_EXTRA)).optInt(EventMonitor.STATS_INDEX);
            } catch (JSONException e4) {
                e4.printStackTrace();
            }
        }
        return -1;
    }

    public static synchronized int ux(com.bytedance.sdk.component.r.c.w wVar, ux uxVar) {
        synchronized (c.class) {
            if (wVar != null) {
                if (wVar.r() != null) {
                    try {
                        return new JSONObject(wVar.r().optString("ad_extra_data")).optInt(EventMonitor.SDK_EVENT_SELF_COUNT);
                    } catch (Exception e4) {
                        e4.printStackTrace();
                        return 0;
                    }
                }
            }
            return 0;
        }
    }

    private static synchronized String w() {
        String sb;
        synchronized (c.class) {
            StringBuilder sb2 = new StringBuilder();
            Iterator<String> it = sr.iterator();
            while (it.hasNext()) {
                sb2.append(it.next());
                sb2.append(",");
            }
            sb = sb2.toString();
        }
        return sb;
    }

    public static boolean f(com.bytedance.sdk.component.r.c.w wVar) {
        return wVar != null && wVar.sr() == 2 && wVar.ux() == 3;
    }

    public static String w(com.bytedance.sdk.component.r.c.w wVar, ux uxVar) {
        if (wVar == null || wVar.r() == null || w(uxVar) || sr(uxVar)) {
            return null;
        }
        return wVar.r().optString("type");
    }

    public static boolean c(List<com.bytedance.sdk.component.r.c.w> list, List<com.bytedance.sdk.component.r.c.w> list2, ux uxVar) {
        if (list != null && list2 != null) {
            try {
                int size = list.size();
                int size2 = list2.size();
                if (size != 0 && size2 != 0 && size == size2) {
                    for (com.bytedance.sdk.component.r.c.w wVar : list) {
                        if (!c(list2, wVar)) {
                            return false;
                        }
                    }
                    return true;
                }
                return false;
            } catch (Exception e4) {
                xv.sr("" + e4.getMessage(), uxVar);
            }
        }
        return false;
    }

    public static boolean sr(ux uxVar) {
        return uxVar != null && TextUtils.equals(uxVar.ux(), "pgl_mediation");
    }

    public static boolean sr(com.bytedance.sdk.component.r.c.w wVar) {
        return wVar != null && wVar.sr() == 1 && wVar.ux() == 2;
    }

    public static boolean w(ux uxVar) {
        return uxVar != null && TextUtils.equals(uxVar.ux(), "csj_mediation");
    }

    public static boolean ux(ux uxVar) {
        return c(uxVar) || xv(uxVar);
    }

    public static boolean w(com.bytedance.sdk.component.r.c.w wVar) {
        return wVar != null && wVar.sr() == 3 && wVar.ux() == 2;
    }

    public static boolean ux(com.bytedance.sdk.component.r.c.w wVar) {
        return wVar != null && wVar.sr() == 1 && wVar.ux() == 3;
    }

    private static boolean c(List<com.bytedance.sdk.component.r.c.w> list, com.bytedance.sdk.component.r.c.w wVar) {
        for (com.bytedance.sdk.component.r.c.w wVar2 : list) {
            if (c(wVar2, wVar)) {
                return true;
            }
        }
        return false;
    }

    private static boolean c(com.bytedance.sdk.component.r.c.w wVar, com.bytedance.sdk.component.r.c.w wVar2) {
        if (wVar == null || wVar2 == null || wVar.ux() != wVar2.ux() || wVar.sr() != wVar2.sr()) {
            return false;
        }
        String xv2 = wVar.xv();
        String xv3 = wVar2.xv();
        if (!TextUtils.isEmpty(xv2) && !TextUtils.isEmpty(xv3)) {
            return TextUtils.equals(xv2, xv3);
        }
        return false;
    }

    public static void c(List<com.bytedance.sdk.component.r.c.w> list, String str, com.bytedance.sdk.component.r.w.c.w wVar) {
        JSONObject r3;
        if (list != null) {
            try {
                if (list.size() != 0) {
                    com.bytedance.sdk.component.r.c.w wVar2 = list.get(0);
                    if (wVar2 == null || wVar2.sr() == 0) {
                        long incrementAndGet = gd.incrementAndGet();
                        for (com.bytedance.sdk.component.r.c.w wVar3 : list) {
                            if (wVar3 != null && (r3 = wVar3.r()) != null) {
                                String optString = r3.optString("ad_extra_data");
                                if (!TextUtils.isEmpty(optString)) {
                                    JSONObject jSONObject = new JSONObject(optString);
                                    jSONObject.put("upload_count", incrementAndGet);
                                    jSONObject.put("upload_ts", System.currentTimeMillis());
                                    if (wVar != null) {
                                        String w3 = wVar.w();
                                        boolean c4 = wVar.c();
                                        if (!TextUtils.isEmpty(w3)) {
                                            jSONObject.put("delete_msg", w3 + " success:" + c4);
                                        }
                                    }
                                    r3.put("ad_extra_data", jSONObject.toString());
                                }
                            }
                        }
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static void c(com.bytedance.sdk.component.r.c.w wVar, String str, long j4, String str2, String str3, String str4, String str5) {
        JSONObject r3;
        if (wVar != null) {
            try {
                if (wVar.sr() != 0 || (r3 = wVar.r()) == null) {
                    return;
                }
                String optString = r3.optString("ad_extra_data");
                if (TextUtils.isEmpty(optString)) {
                    return;
                }
                JSONObject jSONObject = new JSONObject(optString);
                jSONObject.put(str, j4);
                jSONObject.put(str2, str3);
                jSONObject.put(str4, str5);
                r3.put("ad_extra_data", jSONObject.toString());
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static String c(JSONObject jSONObject, ux uxVar) {
        if (jSONObject != null && !w(uxVar) && !sr(uxVar)) {
            String optString = jSONObject.optString("log_extra");
            if (!TextUtils.isEmpty(optString)) {
                try {
                    return new JSONObject(optString).optString("rit");
                } catch (JSONException e4) {
                    e4.printStackTrace();
                }
            }
        }
        return "";
    }

    public static void c(List<com.bytedance.sdk.component.r.c.w> list, int i4, ux uxVar) {
        try {
            if (uxVar.sr().xv()) {
                for (com.bytedance.sdk.component.r.c.w wVar : list) {
                    if (wVar != null && wVar.gd() != 0) {
                        long currentTimeMillis = System.currentTimeMillis() - wVar.gd();
                        com.bytedance.sdk.component.r.w.w.c.c cVar = com.bytedance.sdk.component.r.w.w.w.f30136c;
                        cVar.a().incrementAndGet();
                        cVar.ia().getAndAdd(currentTimeMillis);
                        wVar.xv(System.currentTimeMillis());
                    }
                    if (wVar != null) {
                        r(wVar, uxVar);
                    }
                }
                com.bytedance.sdk.component.r.w.w.w.f30136c.t().getAndAdd(list.size());
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public static boolean c(ux uxVar) {
        return uxVar != null && TextUtils.equals(uxVar.ux(), "csj");
    }

    public static void c(JSONObject jSONObject, com.bytedance.sdk.component.r.w.sr.c.c cVar, ux uxVar, int i4) {
        sr sr2;
        if (uxVar != null && (sr2 = uxVar.sr()) != null && sr2.c() && ux(uxVar)) {
            xv.c("log_show_query :" + jSONObject.optString("label") + " priority:" + ((int) cVar.ux()) + " retry:" + i4, uxVar);
        }
    }

    public static void c(List<com.bytedance.sdk.component.r.c.w> list, int i4, String str, ux uxVar) {
        sr sr2;
        if (uxVar == null || (sr2 = uxVar.sr()) == null || !sr2.c() || list == null || w(uxVar) || sr(uxVar)) {
            return;
        }
        boolean z3 = false;
        StringBuilder sb = new StringBuilder();
        for (com.bytedance.sdk.component.r.c.w wVar : list) {
            if (wVar.sr() == 0) {
                JSONObject r3 = wVar.r();
                String c4 = c(wVar, uxVar);
                if (wVar.w() == 3) {
                    if (r3 != null) {
                        c4 = r3.optString("event");
                    }
                    sb.append(" [v3:");
                    sb.append(c4);
                    sb.append("] ");
                } else {
                    long c5 = c(uxVar, wVar);
                    int ux2 = ux(wVar, uxVar);
                    sb.append(" [");
                    sb.append(c5);
                    sb.append("_");
                    sb.append(c4);
                    if (ux2 == 0) {
                        sb.append("] ");
                    } else {
                        sb.append("_");
                        sb.append(ux2);
                        sb.append("] ");
                    }
                }
                z3 = true;
            } else if (wVar.sr() == 1) {
                String w3 = w(wVar, uxVar);
                int sr3 = sr(wVar, uxVar);
                sb.append(" [");
                sb.append(sr3);
                sb.append("_");
                sb.append(w3);
                sb.append("] ");
            }
        }
        if (z3) {
            xv.xv("_upload", "ads:" + ((Object) sb) + w(i4) + "," + str + ",total:" + list.size(), uxVar);
            return;
        }
        xv.xv("_upload", "stats:" + ((Object) sb) + w(i4) + "," + str + ",total:" + list.size(), uxVar);
    }

    public static boolean c(com.bytedance.sdk.component.r.c.w wVar) {
        return wVar != null && wVar.sr() == 0 && wVar.ux() == 1;
    }

    private static void c(com.bytedance.sdk.component.r.c.w wVar, String str, sr srVar, ux uxVar) {
        String c4 = c(wVar, uxVar);
        if (xv(c4)) {
            return;
        }
        String f4 = f(wVar, uxVar);
        if (wVar.sr() == 0 && srVar.ys()) {
            f(c4 + "_" + f4 + "_" + str);
        }
    }

    public static String c(List<com.bytedance.sdk.component.r.c.w> list) {
        com.bytedance.sdk.component.r.c.w wVar;
        if (list == null || list.size() == 0 || (wVar = list.get(0)) == null) {
            return null;
        }
        byte sr2 = wVar.sr();
        byte ux2 = wVar.ux();
        if (sr2 == 0 && ux2 == 1) {
            return "loghighpriority";
        }
        if (sr2 == 0 && ux2 == 2) {
            return "adevent";
        }
        if (sr2 == 1 && ux2 == 2) {
            return "logstats";
        }
        if (sr2 == 1 && ux2 == 3) {
            return "logstatsbatch";
        }
        return null;
    }

    public static long c(ux uxVar, com.bytedance.sdk.component.r.c.w wVar) {
        if (wVar != null && wVar.r() != null) {
            try {
                return new JSONObject(wVar.r().optString("ad_extra_data")).optLong(EventMonitor.KEY_SDK_EVENT_INDEX);
            } catch (Exception e4) {
                xv.sr(e4.getMessage(), uxVar);
            }
        }
        return 0L;
    }

    public static void c(boolean z3, int i4, String str, String str2, int i5, String str3) {
        f30178r++;
        if (z3) {
            ev++;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("suc", z3);
            jSONObject.put("scnt", ev);
            jSONObject.put("acnt", f30178r);
            jSONObject.put("code", i4);
            jSONObject.put("reqid", str2);
            jSONObject.put("len:", i5);
            jSONObject.put("rit", str3);
            jSONObject.put("msg", str);
            sr r3 = com.bytedance.sdk.component.r.w.c.xv("csj").r();
            if (r3 != null) {
                jSONObject.put("url", r3.a().f());
            } else {
                jSONObject.put("url", "emptyurl");
            }
            f30177f = jSONObject.toString();
        } catch (Exception unused) {
            f30177f = "unknown_json";
        }
    }

    public static String c() {
        return f30177f;
    }

    public static void c(int i4, com.bytedance.sdk.component.r.c.w wVar, ux uxVar) {
        sr r3;
        if (w(uxVar) || uxVar == null || sr(uxVar) || (r3 = com.bytedance.sdk.component.r.w.c.xv(uxVar.ux()).r()) == null || !r3.c()) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        String w3 = w(wVar, uxVar);
        if (!TextUtils.isEmpty(w3)) {
            sb.append("type:");
            sb.append(w3);
            sb.append("_");
            sb.append(sr(wVar, uxVar));
        }
        String c4 = c(wVar, uxVar);
        if (!TextUtils.isEmpty(c4)) {
            sb.append("label:");
            sb.append(c4);
            sb.append("_");
            sb.append(c(uxVar, wVar));
        }
        sb.append(", message:");
        sb.append(w(i4));
        xv.xv("_save", sb.toString(), uxVar);
    }

    public static void c(int i4, List<com.bytedance.sdk.component.r.c.w> list, long j4, ux uxVar) {
        if (uxVar == null || !uxVar.sr().xv()) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis() - j4;
        xv.c("uploadCost:" + currentTimeMillis, uxVar);
        if (i4 == 200) {
            com.bytedance.sdk.component.r.w.w.c.c cVar = com.bytedance.sdk.component.r.w.w.w.f30136c;
            cVar.ck().getAndAdd(currentTimeMillis);
            cVar.gb().incrementAndGet();
            cVar.q().getAndAdd(list.size());
            cVar.r().getAndAdd(list.size());
            return;
        }
        xv.sr("-------AdThread code is " + i4 + " error  ------------", uxVar);
        if (i4 == -1) {
            com.bytedance.sdk.component.r.w.w.w.f30136c.j().getAndAdd(list.size());
        } else {
            com.bytedance.sdk.component.r.w.w.w.f30136c.k().getAndAdd(list.size());
        }
        com.bytedance.sdk.component.r.w.w.c.c cVar2 = com.bytedance.sdk.component.r.w.w.w.f30136c;
        cVar2.z().getAndAdd(currentTimeMillis);
        cVar2.n().incrementAndGet();
    }

    public static int c(List<com.bytedance.sdk.component.r.c.w> list, ux uxVar) {
        JSONObject r3;
        String optString;
        if (list != null && list.size() == 1) {
            try {
                com.bytedance.sdk.component.r.c.w wVar = list.get(0);
                if (wVar != null && wVar.ux() == 1 && (r3 = wVar.r()) != null && wVar.sr() == 0) {
                    JSONObject optJSONObject = r3.optJSONObject(EventMonitor.V3_PARAMS);
                    if (optJSONObject == null) {
                        optString = r3.optString("ad_extra_data");
                    } else {
                        optString = optJSONObject.optString("ad_extra_data");
                    }
                    JSONObject jSONObject = new JSONObject(optString);
                    int optInt = jSONObject.optInt("inner_appid", 0);
                    if (optInt != 0) {
                        jSONObject.remove("inner_appid");
                        if (optJSONObject == null) {
                            r3.put("ad_extra_data", jSONObject.toString());
                        } else {
                            optJSONObject.put("ad_extra_data", jSONObject.toString());
                            r3.put(EventMonitor.V3_PARAMS, optJSONObject);
                        }
                        xv.c("inner_appid:" + optInt, uxVar);
                        return optInt;
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return 0;
    }

    public static void c(List<com.bytedance.sdk.component.r.c.w> list, String str, ux uxVar) {
        try {
            sr sr2 = uxVar.sr();
            if (sr2 != null && sr2.xv() && list != null && sr2.ys()) {
                for (com.bytedance.sdk.component.r.c.w wVar : list) {
                    if (wVar != null) {
                        c(wVar, str, sr2, uxVar);
                    }
                }
            }
        } catch (Exception e4) {
            xv.sr(e4.getMessage(), uxVar);
        }
    }
}

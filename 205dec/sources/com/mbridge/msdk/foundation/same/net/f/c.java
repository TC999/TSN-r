package com.mbridge.msdk.foundation.same.net.f;

import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.same.net.k;
import com.mbridge.msdk.foundation.tools.x;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* compiled from: RequestControlUtil.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    private final String f39555a;

    /* renamed from: b  reason: collision with root package name */
    private int f39556b;

    /* renamed from: c  reason: collision with root package name */
    private ArrayList<Integer> f39557c;

    /* renamed from: d  reason: collision with root package name */
    private ConcurrentHashMap<String, a> f39558d;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: RequestControlUtil.java */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public long f39559a;

        /* renamed from: b  reason: collision with root package name */
        public int f39560b;

        /* renamed from: c  reason: collision with root package name */
        public String f39561c;

        public a(long j4, int i4, String str) {
            this.f39559a = j4;
            this.f39560b = i4;
            this.f39561c = str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: RequestControlUtil.java */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        private static final c f39562a = new c();
    }

    public static c a() {
        return b.f39562a;
    }

    private c() {
        this.f39555a = "IDErrorUtil";
        this.f39557c = new ArrayList<>();
        this.f39558d = new ConcurrentHashMap<>();
        com.mbridge.msdk.c.a b4 = com.mbridge.msdk.c.b.a().b(com.mbridge.msdk.foundation.controller.a.f().k());
        b4 = b4 == null ? com.mbridge.msdk.c.b.a().b() : b4;
        this.f39556b = b4.aU() * 1000;
        if (b4.aV() != null && b4.aV().size() > 0) {
            x.d("IDErrorUtil", "Setting ercd not EMPTY will use setting.");
            this.f39557c.addAll(b4.aV());
            return;
        }
        x.d("IDErrorUtil", "Setting ercd is EMPTY and use default code list.");
        this.f39557c.addAll(Arrays.asList(-1, -10, -1201, -1202, -1203, -1205, -1206, -1208, -1301, -1302, -1305, -1306, -1307, -1915, 10602, 10603, 10604, 10609, 10610, 10616));
    }

    public final synchronized void a(String str, int i4, String str2, long j4) {
        if (this.f39558d.containsKey(str)) {
            return;
        }
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        if (this.f39557c.contains(Integer.valueOf(i4))) {
            x.d("IDErrorUtil", "addErrorInfo : " + str + " " + str2);
            this.f39558d.put(str, new a(j4, i4, str2));
        }
    }

    private synchronized a a(String str) {
        a aVar;
        x.d("IDErrorUtil", "getErrorInfo : " + str);
        if (!this.f39558d.containsKey(str) || (aVar = this.f39558d.get(str)) == null) {
            return null;
        }
        if (aVar.f39560b == -1) {
            return aVar;
        }
        if (System.currentTimeMillis() > aVar.f39559a + this.f39556b) {
            this.f39558d.remove(str);
            if (this.f39558d.size() > 0) {
                for (Map.Entry<String, a> entry : this.f39558d.entrySet()) {
                    x.d("IDErrorUtil", "getErrorInfo : delete timeout entry");
                    if (System.currentTimeMillis() - entry.getValue().f39559a > this.f39556b) {
                        this.f39558d.remove(entry.getKey());
                    }
                }
            }
            return null;
        }
        x.d("IDErrorUtil", "getErrorInfo : " + aVar.f39561c);
        return aVar;
    }

    public final k a(com.mbridge.msdk.foundation.same.net.g.d dVar) {
        int parseInt;
        String str = dVar.b().get("app_id");
        String str2 = dVar.b().get(MBridgeConstans.PROPERTIES_UNIT_ID);
        String str3 = dVar.b().get("ad_type");
        String str4 = dVar.b().get("token");
        String str5 = str + "_" + dVar.b().get("placement_id") + "_" + str2 + "_" + str3;
        a a4 = a(str5);
        if (a4 != null && !TextUtils.isEmpty(a4.f39561c)) {
            try {
                if (a4.f39560b != -1) {
                    return k.a(new JSONObject(a4.f39561c), new com.mbridge.msdk.foundation.same.net.e.c(200, a4.f39561c.getBytes(), null));
                }
                if (!TextUtils.isEmpty(str4)) {
                    return null;
                }
                if (str3 != null && !TextUtils.isEmpty(str3) && (parseInt = Integer.parseInt(str3)) != 287 && parseInt != 94) {
                    if (System.currentTimeMillis() < (com.mbridge.msdk.c.b.a().d(str, str2).w() * 1000) + a4.f39559a) {
                        return k.a(new JSONObject(a4.f39561c), new com.mbridge.msdk.foundation.same.net.e.c(200, a4.f39561c.getBytes(), null));
                    }
                    this.f39558d.remove(str5);
                    return null;
                }
            } catch (Exception e4) {
                x.d("IDErrorUtil", e4.getMessage());
            }
        }
        x.d("IDErrorUtil", "getErrorInfo RETURN NULL");
        return null;
    }
}

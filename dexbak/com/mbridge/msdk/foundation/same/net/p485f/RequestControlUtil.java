package com.mbridge.msdk.foundation.same.net.p485f;

import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.controller.MBSDKContext;
import com.mbridge.msdk.foundation.same.net.C11356k;
import com.mbridge.msdk.foundation.same.net.p484e.NetworkResponse;
import com.mbridge.msdk.foundation.same.net.p486g.CommonRequestParams;
import com.mbridge.msdk.foundation.tools.SameLogTool;
import com.mbridge.msdk.mbbid.out.BidResponsed;
import com.mbridge.msdk.p457c.Setting;
import com.mbridge.msdk.p457c.SettingManager;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* renamed from: com.mbridge.msdk.foundation.same.net.f.c */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class RequestControlUtil {

    /* renamed from: a */
    private final String f30761a;

    /* renamed from: b */
    private int f30762b;

    /* renamed from: c */
    private ArrayList<Integer> f30763c;

    /* renamed from: d */
    private ConcurrentHashMap<String, C11350a> f30764d;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: RequestControlUtil.java */
    /* renamed from: com.mbridge.msdk.foundation.same.net.f.c$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class C11350a {

        /* renamed from: a */
        public long f30765a;

        /* renamed from: b */
        public int f30766b;

        /* renamed from: c */
        public String f30767c;

        public C11350a(long j, int i, String str) {
            this.f30765a = j;
            this.f30766b = i;
            this.f30767c = str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: RequestControlUtil.java */
    /* renamed from: com.mbridge.msdk.foundation.same.net.f.c$b */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class C11351b {

        /* renamed from: a */
        private static final RequestControlUtil f30768a = new RequestControlUtil();
    }

    /* renamed from: a */
    public static RequestControlUtil m22253a() {
        return C11351b.f30768a;
    }

    private RequestControlUtil() {
        this.f30761a = "IDErrorUtil";
        this.f30763c = new ArrayList<>();
        this.f30764d = new ConcurrentHashMap<>();
        Setting m23252b = SettingManager.m23261a().m23252b(MBSDKContext.m22865f().m22860k());
        m23252b = m23252b == null ? SettingManager.m23261a().m23253b() : m23252b;
        this.f30762b = m23252b.m23377aU() * 1000;
        if (m23252b.m23376aV() != null && m23252b.m23376aV().size() > 0) {
            SameLogTool.m21733d("IDErrorUtil", "Setting ercd not EMPTY will use setting.");
            this.f30763c.addAll(m23252b.m23376aV());
            return;
        }
        SameLogTool.m21733d("IDErrorUtil", "Setting ercd is EMPTY and use default code list.");
        this.f30763c.addAll(Arrays.asList(-1, -10, -1201, -1202, -1203, -1205, -1206, -1208, -1301, -1302, -1305, -1306, -1307, -1915, 10602, 10603, 10604, 10609, 10610, 10616));
    }

    /* renamed from: a */
    public final synchronized void m22250a(String str, int i, String str2, long j) {
        if (this.f30764d.containsKey(str)) {
            return;
        }
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        if (this.f30763c.contains(Integer.valueOf(i))) {
            SameLogTool.m21733d("IDErrorUtil", "addErrorInfo : " + str + " " + str2);
            this.f30764d.put(str, new C11350a(j, i, str2));
        }
    }

    /* renamed from: a */
    private synchronized C11350a m22251a(String str) {
        C11350a c11350a;
        SameLogTool.m21733d("IDErrorUtil", "getErrorInfo : " + str);
        if (!this.f30764d.containsKey(str) || (c11350a = this.f30764d.get(str)) == null) {
            return null;
        }
        if (c11350a.f30766b == -1) {
            return c11350a;
        }
        if (System.currentTimeMillis() > c11350a.f30765a + this.f30762b) {
            this.f30764d.remove(str);
            if (this.f30764d.size() > 0) {
                for (Map.Entry<String, C11350a> entry : this.f30764d.entrySet()) {
                    SameLogTool.m21733d("IDErrorUtil", "getErrorInfo : delete timeout entry");
                    if (System.currentTimeMillis() - entry.getValue().f30765a > this.f30762b) {
                        this.f30764d.remove(entry.getKey());
                    }
                }
            }
            return null;
        }
        SameLogTool.m21733d("IDErrorUtil", "getErrorInfo : " + c11350a.f30767c);
        return c11350a;
    }

    /* renamed from: a */
    public final C11356k m22252a(CommonRequestParams commonRequestParams) {
        int parseInt;
        String str = commonRequestParams.m22221b().get("app_id");
        String str2 = commonRequestParams.m22221b().get(MBridgeConstans.PROPERTIES_UNIT_ID);
        String str3 = commonRequestParams.m22221b().get("ad_type");
        String str4 = commonRequestParams.m22221b().get(BidResponsed.KEY_TOKEN);
        String str5 = str + "_" + commonRequestParams.m22221b().get("placement_id") + "_" + str2 + "_" + str3;
        C11350a m22251a = m22251a(str5);
        if (m22251a != null && !TextUtils.isEmpty(m22251a.f30767c)) {
            try {
                if (m22251a.f30766b != -1) {
                    return C11356k.m22175a(new JSONObject(m22251a.f30767c), new NetworkResponse(200, m22251a.f30767c.getBytes(), null));
                }
                if (!TextUtils.isEmpty(str4)) {
                    return null;
                }
                if (str3 != null && !TextUtils.isEmpty(str3) && (parseInt = Integer.parseInt(str3)) != 287 && parseInt != 94) {
                    if (System.currentTimeMillis() < (SettingManager.m23261a().m23246d(str, str2).m23174w() * 1000) + m22251a.f30765a) {
                        return C11356k.m22175a(new JSONObject(m22251a.f30767c), new NetworkResponse(200, m22251a.f30767c.getBytes(), null));
                    }
                    this.f30764d.remove(str5);
                    return null;
                }
            } catch (Exception e) {
                SameLogTool.m21733d("IDErrorUtil", e.getMessage());
            }
        }
        SameLogTool.m21733d("IDErrorUtil", "getErrorInfo RETURN NULL");
        return null;
    }
}

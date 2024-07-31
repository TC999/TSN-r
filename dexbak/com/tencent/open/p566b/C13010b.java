package com.tencent.open.p566b;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.mbridge.msdk.mbbid.out.BidResponsed;
import com.tencent.connect.common.Constants;
import com.tencent.open.log.SLog;
import com.tencent.open.p565a.C13003f;
import com.tencent.open.utils.C13058f;
import com.tencent.open.utils.C13061g;
import com.tencent.open.utils.C13066k;
import com.tencent.open.utils.C13067l;
import com.tencent.open.utils.C13071m;
import io.netty.handler.codec.rtsp.RtspHeaders;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;

/* compiled from: ProGuard */
/* renamed from: com.tencent.open.b.b */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C13010b {

    /* renamed from: a */
    private static C13010b f37289a;

    /* renamed from: b */
    private String f37290b = "";

    /* renamed from: c */
    private String f37291c = "";

    /* renamed from: d */
    private String f37292d = "";

    /* renamed from: e */
    private String f37293e = "";

    /* renamed from: f */
    private String f37294f = "";

    /* renamed from: g */
    private String f37295g = "";

    /* renamed from: h */
    private String f37296h = "";

    /* renamed from: i */
    private List<Serializable> f37297i = Collections.synchronizedList(new ArrayList());

    /* renamed from: j */
    private List<Serializable> f37298j = Collections.synchronizedList(new ArrayList());

    /* renamed from: k */
    private Executor f37299k = C13067l.m14975b();

    /* renamed from: l */
    private boolean f37300l;

    private C13010b() {
    }

    /* renamed from: c */
    private void m15180c() {
        while (!this.f37298j.isEmpty()) {
            C13012c c13012c = (C13012c) this.f37298j.remove(0);
            c13012c.f37303a.put("appid", this.f37290b);
            c13012c.f37303a.put("app_name", this.f37291c);
            c13012c.f37303a.put(Constants.PARAM_APP_VER, this.f37293e);
            c13012c.f37303a.put(Constants.PARAM_PKG_NAME, this.f37294f);
            c13012c.f37303a.put("qq_install", this.f37295g);
            c13012c.f37303a.put(Constants.PARAM_QQ_VER, this.f37296h);
            c13012c.f37303a.put("openid", this.f37292d);
            HashMap<String, String> hashMap = c13012c.f37303a;
            hashMap.put("time_appid_openid", c13012c.f37303a.get(RtspHeaders.Values.TIME) + "_" + this.f37290b + "_" + this.f37292d);
            StringBuilder sb = new StringBuilder();
            sb.append("fixDirtyData--------------------------");
            sb.append(c13012c);
            SLog.m15127i("AttaReporter", sb.toString());
            this.f37297i.add(c13012c);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public void m15179d() {
        SLog.m15127i("AttaReporter", "attaReportAtSubThread");
        if (!this.f37300l) {
            List<Serializable> m15166b = C13016g.m15166b("report_atta");
            this.f37300l = m15166b.isEmpty();
            this.f37297i.addAll(m15166b);
            Iterator<Serializable> it = m15166b.iterator();
            while (it.hasNext()) {
                SLog.m15127i("AttaReporter", "attaReportAtSubThread from db = " + it.next());
            }
        }
        ArrayList arrayList = new ArrayList();
        while (!this.f37297i.isEmpty()) {
            C13012c c13012c = (C13012c) this.f37297i.remove(0);
            if (!m15182b(c13012c)) {
                arrayList.add(c13012c);
            }
        }
        if (!arrayList.isEmpty()) {
            SLog.m15127i("AttaReporter", "attaReportAtSubThread fail size=" + arrayList.size());
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                SLog.m15127i("AttaReporter", "attaReportAtSubThread fail cache to db, " + ((C13012c) ((Serializable) it2.next())));
            }
            C13016g.m15167a("report_atta", arrayList);
            this.f37300l = false;
        } else if (this.f37300l) {
        } else {
            SLog.m15127i("AttaReporter", "attaReportAtSubThread clear db");
            C13016g.m15168a("report_atta");
            this.f37300l = true;
        }
    }

    /* renamed from: a */
    public static synchronized C13010b m15193a() {
        C13010b c13010b;
        synchronized (C13010b.class) {
            if (f37289a == null) {
                f37289a = new C13010b();
            }
            c13010b = f37289a;
        }
        return c13010b;
    }

    /* renamed from: b */
    private C13012c m15181b(String str, String str2, Object obj, Map<String, Object> map) {
        long currentTimeMillis = System.currentTimeMillis();
        HashMap hashMap = new HashMap();
        hashMap.put("attaid", "09400051119");
        hashMap.put(BidResponsed.KEY_TOKEN, "9389887874");
        hashMap.put("time_appid_openid", currentTimeMillis + "_" + this.f37290b + "_" + this.f37292d);
        hashMap.put(RtspHeaders.Values.TIME, String.valueOf(currentTimeMillis));
        hashMap.put("openid", this.f37292d);
        hashMap.put("appid", this.f37290b);
        hashMap.put("app_name", this.f37291c);
        hashMap.put(Constants.PARAM_APP_VER, this.f37293e);
        hashMap.put(Constants.PARAM_PKG_NAME, this.f37294f);
        hashMap.put("os", "AND");
        hashMap.put("os_ver", Build.VERSION.RELEASE);
        hashMap.put(Constants.PARAM_SDK_VER, Constants.SDK_VERSION);
        hashMap.put(Constants.PARAM_MODEL_NAME, C13058f.m15034a().m15029c(C13061g.m15027a()));
        hashMap.put("interface_name", str);
        hashMap.put("interface_data", str2);
        hashMap.put("interface_result", obj == null ? "" : obj.toString());
        hashMap.put("qq_install", this.f37295g);
        hashMap.put(Constants.PARAM_QQ_VER, this.f37296h);
        if (map != null && !map.isEmpty()) {
            Object obj2 = map.get("reserve1");
            hashMap.put("reserve1", obj2 == null ? "" : obj2.toString());
            Object obj3 = map.get("reserve2");
            hashMap.put("reserve2", obj3 == null ? "" : obj3.toString());
            Object obj4 = map.get("reserve3");
            hashMap.put("reserve3", obj4 == null ? "" : obj4.toString());
            Object obj5 = map.get("reserve4");
            hashMap.put("reserve4", obj5 != null ? obj5.toString() : "");
        }
        return new C13012c(hashMap);
    }

    /* renamed from: a */
    public void m15189a(String str, Context context) {
        SLog.m15127i("AttaReporter", "init");
        this.f37290b = str;
        this.f37291c = C13066k.m14998a(context);
        this.f37293e = C13071m.m14934d(context, C13061g.m15024b());
        this.f37294f = C13061g.m15024b();
        this.f37295g = C13066k.m14989b(context) ? "1" : "0";
        this.f37296h = C13071m.m14937c(context, "com.tencent.mobileqq");
        m15180c();
        C13016g.m15169a();
    }

    /* renamed from: a */
    public void m15190a(String str) {
        SLog.m15127i("AttaReporter", "updateOpenId");
        if (str == null) {
            str = "";
        }
        this.f37292d = str;
    }

    /* renamed from: a */
    public void m15187a(String str, String str2) {
        m15185a(str, str2, null);
    }

    /* renamed from: a */
    public void m15185a(String str, String str2, Map<String, Object> map) {
        m15186a(str, str2, "", map);
    }

    /* renamed from: a */
    public void m15188a(String str, Object obj) {
        m15186a(str, "", obj, null);
    }

    /* renamed from: a */
    public void m15186a(String str, String str2, Object obj, Map<String, Object> map) {
        C13012c m15181b = m15181b(str, str2, obj, map);
        if (!TextUtils.isEmpty(this.f37290b) && !TextUtils.isEmpty(this.f37291c) && C13061g.m15027a() != null) {
            m15191a(m15181b);
            return;
        }
        SLog.m15127i("AttaReporter", "attaReport cancel appid=" + this.f37290b + ", mAppName=" + this.f37291c + ", context=" + C13061g.m15027a() + ", " + m15181b);
        this.f37298j.add(m15181b);
    }

    /* renamed from: a */
    private void m15191a(final C13012c c13012c) {
        this.f37299k.execute(new Runnable() { // from class: com.tencent.open.b.b.1
            @Override // java.lang.Runnable
            public void run() {
                C13010b.this.f37297i.add(c13012c);
                if (C13071m.m14945b(C13061g.m15027a())) {
                    try {
                        C13010b.this.m15179d();
                        return;
                    } catch (Exception e) {
                        SLog.m15128e("AttaReporter", "Exception", e);
                        return;
                    }
                }
                SLog.m15127i("AttaReporter", "attaReport net disconnect, " + c13012c);
            }
        });
    }

    /* renamed from: b */
    private boolean m15182b(C13012c c13012c) {
        int i = 0;
        do {
            i++;
            try {
                SLog.m15127i("AttaReporter", "doAttaReportItem post " + c13012c);
                return C13003f.m15216a().m15209b("https://h.trace.qq.com/kv", c13012c.f37303a).mo15204d() == 200;
            } catch (Exception e) {
                SLog.m15126i("AttaReporter", "Exception", e);
                if (i >= 2) {
                    return false;
                }
            }
        } while (i >= 2);
        return false;
    }

    /* renamed from: b */
    public static String m15184b() {
        return m15193a().f37290b;
    }
}

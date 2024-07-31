package com.tencent.bugly.proguard;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Pair;
import com.umeng.analytics.pro.C13131bm;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.proguard.ag */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public final class C12808ag {

    /* renamed from: a */
    private final SimpleDateFormat f36490a;

    /* renamed from: b */
    private final C12805ad f36491b;

    /* compiled from: BUGLY */
    /* renamed from: com.tencent.bugly.proguard.ag$a */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static class C12810a {

        /* renamed from: a */
        private static final C12808ag f36494a = new C12808ag((byte) 0);

        /* renamed from: a */
        public static /* synthetic */ C12808ag m15914a() {
            return f36494a;
        }
    }

    /* compiled from: BUGLY */
    /* renamed from: com.tencent.bugly.proguard.ag$b */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static class C12811b {

        /* renamed from: a */
        String f36495a;

        /* renamed from: b */
        public long f36496b;

        /* renamed from: c */
        public String f36497c;

        public final String toString() {
            return "SLAData{uuid='" + this.f36495a + "', time=" + this.f36496b + ", data='" + this.f36497c + "'}";
        }
    }

    /* synthetic */ C12808ag(byte b) {
        this();
    }

    /* renamed from: c */
    static void m15917c(List<C12811b> list) {
        if (list != null && !list.isEmpty()) {
            C12820al.m15874c("sla batch report list size:%s", Integer.valueOf(list.size()));
            if (list.size() > 30) {
                list = list.subList(0, 29);
            }
            ArrayList arrayList = new ArrayList();
            for (C12811b c12811b : list) {
                arrayList.add(c12811b.f36497c);
            }
            Pair<Integer, String> m15935a = C12805ad.m15935a(arrayList);
            C12820al.m15874c("sla batch report result, rspCode:%s rspMsg:%s", m15935a.first, m15935a.second);
            if (((Integer) m15935a.first).intValue() == 200) {
                m15916d(list);
                return;
            }
            return;
        }
        C12820al.m15874c("sla batch report data is empty", new Object[0]);
    }

    /* renamed from: d */
    public static void m15916d(List<C12811b> list) {
        if (list != null && !list.isEmpty()) {
            C12820al.m15874c("sla batch delete list size:%s", Integer.valueOf(list.size()));
            try {
                String str = "_id in (" + m15921a(",", list) + ")";
                C12820al.m15874c("sla batch delete where:%s", str);
                C12920w.m15509a().m15493a("t_sla", str);
                return;
            } catch (Throwable th) {
                C12820al.m15875b(th);
                return;
            }
        }
        C12820al.m15874c("sla batch delete list is null", new Object[0]);
    }

    /* renamed from: e */
    private static void m15915e(List<C12811b> list) {
        for (C12811b c12811b : list) {
            C12820al.m15874c("sla save id:%s time:%s msg:%s", c12811b.f36495a, Long.valueOf(c12811b.f36496b), c12811b.f36497c);
            try {
                ContentValues contentValues = new ContentValues();
                contentValues.put(C13131bm.f37927d, c12811b.f36495a);
                contentValues.put("_tm", Long.valueOf(c12811b.f36496b));
                contentValues.put("_dt", c12811b.f36497c);
                C12920w.m15509a().m15494a("t_sla", contentValues, (InterfaceC12919v) null);
            } catch (Throwable th) {
                C12820al.m15875b(th);
            }
        }
    }

    /* renamed from: a */
    public final void m15920a(List<C12812c> list) {
        if (list != null && !list.isEmpty()) {
            C12820al.m15874c("sla batch report event size:%s", Integer.valueOf(list.size()));
            ArrayList arrayList = new ArrayList();
            for (C12812c c12812c : list) {
                C12811b m15919b = m15919b(c12812c);
                if (m15919b != null) {
                    arrayList.add(m15919b);
                }
            }
            m15915e(arrayList);
            m15918b(arrayList);
            return;
        }
        C12820al.m15873d("sla batch report event is null", new Object[0]);
    }

    /* renamed from: b */
    public final void m15918b(final List<C12811b> list) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            C12818ak.m15887a().m15886a(new Runnable() { // from class: com.tencent.bugly.proguard.ag.1
                @Override // java.lang.Runnable
                public final void run() {
                    C12808ag.m15917c(list);
                }
            });
        } else {
            m15917c(list);
        }
    }

    private C12808ag() {
        this.f36490a = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS", Locale.US);
        this.f36491b = new C12805ad();
    }

    /* renamed from: b */
    private C12811b m15919b(C12812c c12812c) {
        if (c12812c != null && !TextUtils.isEmpty(c12812c.f36499b)) {
            C12786aa m16005b = C12786aa.m16005b();
            if (m16005b == null) {
                C12820al.m15873d("sla convert failed because ComInfoManager is null", new Object[0]);
                return null;
            }
            StringBuilder sb = new StringBuilder("&app_version=");
            sb.append(m16005b.f36462o);
            sb.append("&app_name=");
            sb.append(m16005b.f36464q);
            sb.append("&app_bundle_id=");
            sb.append(m16005b.f36450c);
            sb.append("&client_type=android&user_id=");
            sb.append(m16005b.m15996f());
            sb.append("&sdk_version=");
            sb.append(m16005b.f36455h);
            sb.append("&event_code=");
            sb.append(c12812c.f36499b);
            sb.append("&event_result=");
            sb.append(c12812c.f36501d ? 1 : 0);
            sb.append("&event_time=");
            sb.append(this.f36490a.format(new Date(c12812c.f36500c)));
            sb.append("&event_cost=");
            sb.append(c12812c.f36502e);
            sb.append("&device_id=");
            sb.append(m16005b.m15994g());
            sb.append("&debug=");
            sb.append(m16005b.f36402D ? 1 : 0);
            sb.append("&param_0=");
            sb.append(c12812c.f36503f);
            sb.append("&param_1=");
            sb.append(c12812c.f36498a);
            sb.append("&param_2=");
            sb.append(m16005b.f36411M ? "rqd" : SocializeProtocolConstants.PROTOCOL_KEY_EXTEND);
            sb.append("&param_4=");
            sb.append(m16005b.m15998e());
            String sb2 = sb.toString();
            if (!TextUtils.isEmpty(c12812c.f36504g)) {
                sb2 = sb2 + "&param_3=" + c12812c.f36504g;
            }
            C12820al.m15874c("sla convert eventId:%s eventType:%s, eventTime:%s success:%s cost:%s from:%s uploadMsg:", c12812c.f36498a, c12812c.f36499b, Long.valueOf(c12812c.f36500c), Boolean.valueOf(c12812c.f36501d), Long.valueOf(c12812c.f36502e), c12812c.f36503f, c12812c.f36504g);
            C12811b c12811b = new C12811b();
            c12811b.f36495a = c12812c.f36498a + "-" + c12812c.f36499b;
            c12811b.f36496b = c12812c.f36500c;
            c12811b.f36497c = sb2;
            return c12811b;
        }
        C12820al.m15873d("sla convert event is null", new Object[0]);
        return null;
    }

    /* compiled from: BUGLY */
    /* renamed from: com.tencent.bugly.proguard.ag$c */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static class C12812c {

        /* renamed from: a */
        String f36498a;

        /* renamed from: b */
        String f36499b;

        /* renamed from: c */
        long f36500c;

        /* renamed from: d */
        boolean f36501d;

        /* renamed from: e */
        long f36502e;

        /* renamed from: f */
        String f36503f;

        /* renamed from: g */
        String f36504g;

        public C12812c(String str, String str2, long j, boolean z, long j2, String str3, String str4) {
            this.f36498a = str;
            this.f36499b = str2;
            this.f36500c = j;
            this.f36501d = z;
            this.f36502e = j2;
            this.f36503f = str3;
            this.f36504g = str4;
        }

        public C12812c() {
        }
    }

    /* renamed from: a */
    private static String m15921a(String str, Iterable<C12811b> iterable) {
        Iterator<C12811b> it = iterable.iterator();
        if (it.hasNext()) {
            StringBuilder sb = new StringBuilder();
            sb.append("'");
            sb.append(it.next().f36495a);
            sb.append("'");
            while (it.hasNext()) {
                sb.append(str);
                sb.append("'");
                sb.append(it.next().f36495a);
                sb.append("'");
            }
            return sb.toString();
        }
        return "";
    }

    /* renamed from: a */
    public static List<C12811b> m15923a() {
        Cursor m15490a = C12920w.m15509a().m15490a("t_sla", new String[]{C13131bm.f37927d, "_tm", "_dt"}, (String) null, "_tm", "30");
        if (m15490a == null) {
            return null;
        }
        if (m15490a.getCount() <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        while (m15490a.moveToNext()) {
            try {
                C12811b c12811b = new C12811b();
                c12811b.f36495a = m15490a.getString(m15490a.getColumnIndex(C13131bm.f37927d));
                c12811b.f36496b = m15490a.getLong(m15490a.getColumnIndex("_tm"));
                c12811b.f36497c = m15490a.getString(m15490a.getColumnIndex("_dt"));
                C12820al.m15874c(c12811b.toString(), new Object[0]);
                arrayList.add(c12811b);
            } finally {
                try {
                    return arrayList;
                } finally {
                }
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    public final void m15922a(C12812c c12812c) {
        if (TextUtils.isEmpty(c12812c.f36499b)) {
            C12820al.m15873d("sla report event is null", new Object[0]);
            return;
        }
        C12820al.m15874c("sla report single event", new Object[0]);
        m15920a(Collections.singletonList(c12812c));
    }
}

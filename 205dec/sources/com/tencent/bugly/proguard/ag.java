package com.tencent.bugly.proguard;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Pair;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: BUGLY */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public final class ag {

    /* renamed from: a  reason: collision with root package name */
    private final SimpleDateFormat f50864a;

    /* renamed from: b  reason: collision with root package name */
    private final ad f50865b;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* compiled from: BUGLY */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private static final ag f50868a = new ag((byte) 0);

        public static /* synthetic */ ag a() {
            return f50868a;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* compiled from: BUGLY */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        String f50869a;

        /* renamed from: b  reason: collision with root package name */
        public long f50870b;

        /* renamed from: c  reason: collision with root package name */
        public String f50871c;

        public final String toString() {
            return "SLAData{uuid='" + this.f50869a + "', time=" + this.f50870b + ", data='" + this.f50871c + "'}";
        }
    }

    /* synthetic */ ag(byte b4) {
        this();
    }

    static void c(List<b> list) {
        if (list != null && !list.isEmpty()) {
            al.c("sla batch report list size:%s", Integer.valueOf(list.size()));
            if (list.size() > 30) {
                list = list.subList(0, 29);
            }
            ArrayList arrayList = new ArrayList();
            for (b bVar : list) {
                arrayList.add(bVar.f50871c);
            }
            Pair<Integer, String> a4 = ad.a(arrayList);
            al.c("sla batch report result, rspCode:%s rspMsg:%s", a4.first, a4.second);
            if (((Integer) a4.first).intValue() == 200) {
                d(list);
                return;
            }
            return;
        }
        al.c("sla batch report data is empty", new Object[0]);
    }

    public static void d(List<b> list) {
        if (list != null && !list.isEmpty()) {
            al.c("sla batch delete list size:%s", Integer.valueOf(list.size()));
            try {
                String str = "_id in (" + a(",", list) + ")";
                al.c("sla batch delete where:%s", str);
                w.a().a("t_sla", str);
                return;
            } catch (Throwable th) {
                al.b(th);
                return;
            }
        }
        al.c("sla batch delete list is null", new Object[0]);
    }

    private static void e(List<b> list) {
        for (b bVar : list) {
            al.c("sla save id:%s time:%s msg:%s", bVar.f50869a, Long.valueOf(bVar.f50870b), bVar.f50871c);
            try {
                ContentValues contentValues = new ContentValues();
                contentValues.put("_id", bVar.f50869a);
                contentValues.put("_tm", Long.valueOf(bVar.f50870b));
                contentValues.put("_dt", bVar.f50871c);
                w.a().a("t_sla", contentValues, (v) null);
            } catch (Throwable th) {
                al.b(th);
            }
        }
    }

    public final void a(List<c> list) {
        if (list != null && !list.isEmpty()) {
            al.c("sla batch report event size:%s", Integer.valueOf(list.size()));
            ArrayList arrayList = new ArrayList();
            for (c cVar : list) {
                b b4 = b(cVar);
                if (b4 != null) {
                    arrayList.add(b4);
                }
            }
            e(arrayList);
            b(arrayList);
            return;
        }
        al.d("sla batch report event is null", new Object[0]);
    }

    public final void b(final List<b> list) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            ak.a().a(new Runnable() { // from class: com.tencent.bugly.proguard.ag.1
                @Override // java.lang.Runnable
                public final void run() {
                    ag.c(list);
                }
            });
        } else {
            c(list);
        }
    }

    private ag() {
        this.f50864a = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS", Locale.US);
        this.f50865b = new ad();
    }

    private b b(c cVar) {
        if (cVar != null && !TextUtils.isEmpty(cVar.f50873b)) {
            aa b4 = aa.b();
            if (b4 == null) {
                al.d("sla convert failed because ComInfoManager is null", new Object[0]);
                return null;
            }
            StringBuilder sb = new StringBuilder("&app_version=");
            sb.append(b4.f50836o);
            sb.append("&app_name=");
            sb.append(b4.f50838q);
            sb.append("&app_bundle_id=");
            sb.append(b4.f50824c);
            sb.append("&client_type=android&user_id=");
            sb.append(b4.f());
            sb.append("&sdk_version=");
            sb.append(b4.f50829h);
            sb.append("&event_code=");
            sb.append(cVar.f50873b);
            sb.append("&event_result=");
            sb.append(cVar.f50875d ? 1 : 0);
            sb.append("&event_time=");
            sb.append(this.f50864a.format(new Date(cVar.f50874c)));
            sb.append("&event_cost=");
            sb.append(cVar.f50876e);
            sb.append("&device_id=");
            sb.append(b4.g());
            sb.append("&debug=");
            sb.append(b4.D ? 1 : 0);
            sb.append("&param_0=");
            sb.append(cVar.f50877f);
            sb.append("&param_1=");
            sb.append(cVar.f50872a);
            sb.append("&param_2=");
            sb.append(b4.M ? "rqd" : "ext");
            sb.append("&param_4=");
            sb.append(b4.e());
            String sb2 = sb.toString();
            if (!TextUtils.isEmpty(cVar.f50878g)) {
                sb2 = sb2 + "&param_3=" + cVar.f50878g;
            }
            al.c("sla convert eventId:%s eventType:%s, eventTime:%s success:%s cost:%s from:%s uploadMsg:", cVar.f50872a, cVar.f50873b, Long.valueOf(cVar.f50874c), Boolean.valueOf(cVar.f50875d), Long.valueOf(cVar.f50876e), cVar.f50877f, cVar.f50878g);
            b bVar = new b();
            bVar.f50869a = cVar.f50872a + "-" + cVar.f50873b;
            bVar.f50870b = cVar.f50874c;
            bVar.f50871c = sb2;
            return bVar;
        }
        al.d("sla convert event is null", new Object[0]);
        return null;
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* compiled from: BUGLY */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        String f50872a;

        /* renamed from: b  reason: collision with root package name */
        String f50873b;

        /* renamed from: c  reason: collision with root package name */
        long f50874c;

        /* renamed from: d  reason: collision with root package name */
        boolean f50875d;

        /* renamed from: e  reason: collision with root package name */
        long f50876e;

        /* renamed from: f  reason: collision with root package name */
        String f50877f;

        /* renamed from: g  reason: collision with root package name */
        String f50878g;

        public c(String str, String str2, long j4, boolean z3, long j5, String str3, String str4) {
            this.f50872a = str;
            this.f50873b = str2;
            this.f50874c = j4;
            this.f50875d = z3;
            this.f50876e = j5;
            this.f50877f = str3;
            this.f50878g = str4;
        }

        public c() {
        }
    }

    private static String a(String str, Iterable<b> iterable) {
        Iterator<b> it = iterable.iterator();
        if (it.hasNext()) {
            StringBuilder sb = new StringBuilder();
            sb.append("'");
            sb.append(it.next().f50869a);
            sb.append("'");
            while (it.hasNext()) {
                sb.append(str);
                sb.append("'");
                sb.append(it.next().f50869a);
                sb.append("'");
            }
            return sb.toString();
        }
        return "";
    }

    public static List<b> a() {
        Cursor a4 = w.a().a("t_sla", new String[]{"_id", "_tm", "_dt"}, (String) null, "_tm", "30");
        if (a4 == null) {
            return null;
        }
        if (a4.getCount() <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        while (a4.moveToNext()) {
            try {
                b bVar = new b();
                bVar.f50869a = a4.getString(a4.getColumnIndex("_id"));
                bVar.f50870b = a4.getLong(a4.getColumnIndex("_tm"));
                bVar.f50871c = a4.getString(a4.getColumnIndex("_dt"));
                al.c(bVar.toString(), new Object[0]);
                arrayList.add(bVar);
            } finally {
                try {
                    return arrayList;
                } finally {
                }
            }
        }
        return arrayList;
    }

    public final void a(c cVar) {
        if (TextUtils.isEmpty(cVar.f50873b)) {
            al.d("sla report event is null", new Object[0]);
            return;
        }
        al.c("sla report single event", new Object[0]);
        a(Collections.singletonList(cVar));
    }
}

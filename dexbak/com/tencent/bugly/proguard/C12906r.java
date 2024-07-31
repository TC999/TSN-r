package com.tencent.bugly.proguard;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.tencent.bugly.crashreport.biz.UserInfoBean;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.umeng.analytics.pro.C13131bm;
import java.io.BufferedReader;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.proguard.r */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public final class C12906r {

    /* renamed from: e */
    private static boolean f36895e = true;

    /* renamed from: a */
    private Context f36896a;

    /* renamed from: b */
    private long f36897b;

    /* renamed from: c */
    private int f36898c;

    /* renamed from: d */
    private boolean f36899d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BUGLY */
    /* renamed from: com.tencent.bugly.proguard.r$a */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public class RunnableC12909a implements Runnable {

        /* renamed from: b */
        private boolean f36905b;

        /* renamed from: c */
        private UserInfoBean f36906c;

        public RunnableC12909a(UserInfoBean userInfoBean, boolean z) {
            this.f36906c = userInfoBean;
            this.f36905b = z;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (C12906r.this.f36899d) {
                try {
                    UserInfoBean userInfoBean = this.f36906c;
                    if (userInfoBean != null) {
                        C12906r.m15562a(userInfoBean);
                        C12820al.m15874c("[UserInfo] Record user info.", new Object[0]);
                        C12906r.this.m15561a(this.f36906c, false);
                    }
                    if (this.f36905b) {
                        C12906r.this.m15552b();
                    }
                } catch (Throwable th) {
                    if (C12820al.m15877a(th)) {
                        return;
                    }
                    th.printStackTrace();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BUGLY */
    /* renamed from: com.tencent.bugly.proguard.r$b */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public class RunnableC12910b implements Runnable {
        RunnableC12910b() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis < C12906r.this.f36897b) {
                C12818ak.m15887a().m15885a(new RunnableC12910b(), (C12906r.this.f36897b - currentTimeMillis) + 5000);
                return;
            }
            C12906r.this.m15565a(3, false);
            C12906r.this.m15566a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BUGLY */
    /* renamed from: com.tencent.bugly.proguard.r$c */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public class RunnableC12911c implements Runnable {

        /* renamed from: b */
        private long f36909b;

        public RunnableC12911c(long j) {
            this.f36909b = j;
        }

        @Override // java.lang.Runnable
        public final void run() {
            C12906r.this.m15552b();
            C12906r.this.m15564a(this.f36909b);
        }
    }

    public C12906r(Context context, boolean z) {
        this.f36896a = context;
        this.f36899d = z;
    }

    /* renamed from: b */
    private static void m15548b(List<UserInfoBean> list, List<UserInfoBean> list2) {
        Iterator<UserInfoBean> it = list.iterator();
        while (it.hasNext()) {
            UserInfoBean next = it.next();
            if (next.f36274f != -1) {
                it.remove();
                if (next.f36273e < C12828ap.m15823b()) {
                    list2.add(next);
                }
            }
        }
    }

    /* renamed from: a */
    public final void m15565a(int i, boolean z) {
        C12803ac m15950a = C12803ac.m15950a();
        if (m15950a != null && !m15950a.m15941c().f36297g && i != 1 && i != 3) {
            C12820al.m15872e("UserInfo is disable", new Object[0]);
            return;
        }
        if (i == 1 || i == 3) {
            this.f36898c++;
        }
        C12786aa m16009a = C12786aa.m16009a(this.f36896a);
        UserInfoBean userInfoBean = new UserInfoBean();
        userInfoBean.f36270b = i;
        userInfoBean.f36271c = m16009a.f36451d;
        userInfoBean.f36272d = m16009a.m15996f();
        userInfoBean.f36273e = System.currentTimeMillis();
        userInfoBean.f36274f = -1L;
        userInfoBean.f36282n = m16009a.f36462o;
        userInfoBean.f36283o = i == 1 ? 1 : 0;
        userInfoBean.f36280l = m16009a.m16011a();
        userInfoBean.f36281m = m16009a.f36472y;
        userInfoBean.f36275g = m16009a.f36473z;
        userInfoBean.f36276h = m16009a.f36399A;
        userInfoBean.f36277i = m16009a.f36400B;
        userInfoBean.f36279k = m16009a.f36401C;
        userInfoBean.f36286r = m16009a.m15980t();
        userInfoBean.f36287s = m16009a.m15975y();
        userInfoBean.f36284p = m16009a.m15974z();
        userInfoBean.f36285q = m16009a.f36471x;
        C12818ak.m15887a().m15885a(new RunnableC12909a(userInfoBean, z), 0L);
    }

    /* renamed from: b */
    public final void m15552b() {
        C12818ak m15887a = C12818ak.m15887a();
        if (m15887a != null) {
            m15887a.m15886a(new Runnable() { // from class: com.tencent.bugly.proguard.r.2

                /* renamed from: a */
                final /* synthetic */ boolean f36902a = false;

                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        C12906r.this.m15553a(this.f36902a);
                    } catch (Throwable th) {
                        C12820al.m15877a(th);
                    }
                }
            });
        }
    }

    /* renamed from: b */
    private static void m15549b(List<UserInfoBean> list) {
        if (list.size() == 0) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size() && i < 50; i++) {
            sb.append(" or _id = ");
            sb.append(list.get(i).f36269a);
        }
        String sb2 = sb.toString();
        if (sb2.length() > 0) {
            sb2 = sb2.substring(4);
        }
        sb.setLength(0);
        try {
            C12820al.m15874c("[Database] deleted %s data %d", "t_ui", Integer.valueOf(C12920w.m15509a().m15493a("t_ui", sb2)));
        } catch (Throwable th) {
            if (C12820al.m15877a(th)) {
                return;
            }
            th.printStackTrace();
        }
    }

    /* renamed from: b */
    private static ContentValues m15551b(UserInfoBean userInfoBean) {
        if (userInfoBean == null) {
            return null;
        }
        try {
            ContentValues contentValues = new ContentValues();
            long j = userInfoBean.f36269a;
            if (j > 0) {
                contentValues.put(C13131bm.f37927d, Long.valueOf(j));
            }
            contentValues.put("_tm", Long.valueOf(userInfoBean.f36273e));
            contentValues.put("_ut", Long.valueOf(userInfoBean.f36274f));
            contentValues.put(C13131bm.f37928e, Integer.valueOf(userInfoBean.f36270b));
            contentValues.put("_pc", userInfoBean.f36271c);
            contentValues.put("_dt", C12828ap.m15840a(userInfoBean));
            return contentValues;
        } catch (Throwable th) {
            if (!C12820al.m15877a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    /* renamed from: a */
    public final void m15564a(long j) {
        C12818ak.m15887a().m15885a(new RunnableC12911c(j), j);
    }

    /* renamed from: a */
    public final void m15566a() {
        this.f36897b = C12828ap.m15823b() + 86400000;
        C12818ak.m15887a().m15885a(new RunnableC12910b(), (this.f36897b - System.currentTimeMillis()) + 5000);
    }

    /* renamed from: b */
    private boolean m15547b(boolean z) {
        boolean z2;
        boolean z3 = true;
        if (f36895e) {
            File file = new File(this.f36896a.getFilesDir(), "bugly_last_us_up_tm");
            long currentTimeMillis = System.currentTimeMillis();
            if (z) {
                C12821am.m15871a(file, String.valueOf(currentTimeMillis), 1024L, false);
                return true;
            }
            if (!file.exists()) {
                C12821am.m15871a(file, String.valueOf(currentTimeMillis), 1024L, false);
            } else {
                BufferedReader m15839a = C12828ap.m15839a(file);
                if (m15839a != null) {
                    try {
                        long longValue = Long.valueOf(m15839a.readLine().trim()).longValue();
                        if (currentTimeMillis >= longValue && currentTimeMillis - longValue <= 86400000) {
                            z2 = true;
                            if (z2 || currentTimeMillis - longValue >= 300000) {
                                C12821am.m15871a(file, String.valueOf(currentTimeMillis), 1024L, false);
                            } else {
                                z3 = false;
                            }
                        }
                        z2 = false;
                        if (z2) {
                        }
                        C12821am.m15871a(file, String.valueOf(currentTimeMillis), 1024L, false);
                    }
                }
                if (m15839a != null) {
                    m15839a.close();
                }
            }
            return z3;
        }
        return true;
    }

    /* renamed from: a */
    private static void m15555a(List<UserInfoBean> list, List<UserInfoBean> list2) {
        int size = list.size() - 20;
        if (size > 0) {
            int i = 0;
            while (i < list.size() - 1) {
                int i2 = i + 1;
                for (int i3 = i2; i3 < list.size(); i3++) {
                    if (list.get(i).f36273e > list.get(i3).f36273e) {
                        list.set(i, list.get(i3));
                        list.set(i3, list.get(i));
                    }
                }
                i = i2;
            }
            for (int i4 = 0; i4 < size; i4++) {
                list2.add(list.get(i4));
            }
        }
    }

    /* renamed from: a */
    private static int m15556a(List<UserInfoBean> list) {
        int i;
        long currentTimeMillis = System.currentTimeMillis();
        int i2 = 0;
        for (UserInfoBean userInfoBean : list) {
            if (userInfoBean.f36273e > currentTimeMillis - TTAdConstant.AD_MAX_EVENT_TIME && ((i = userInfoBean.f36270b) == 1 || i == 4 || i == 3)) {
                i2++;
            }
        }
        return i2;
    }

    /* renamed from: a */
    private void m15554a(final List<UserInfoBean> list, boolean z) {
        C12786aa m16005b;
        if (!m15547b(z)) {
            long currentTimeMillis = System.currentTimeMillis();
            for (UserInfoBean userInfoBean : list) {
                userInfoBean.f36274f = currentTimeMillis;
                m15561a(userInfoBean, true);
            }
            C12820al.m15873d("uploadCheck failed", new Object[0]);
            return;
        }
        int i = this.f36898c == 1 ? 1 : 2;
        C12889bv c12889bv = null;
        if (list != null && list.size() != 0 && (m16005b = C12786aa.m16005b()) != null) {
            m16005b.m15985o();
            C12889bv c12889bv2 = new C12889bv();
            c12889bv2.f36848b = m16005b.f36451d;
            c12889bv2.f36849c = m16005b.m15994g();
            ArrayList<C12888bu> arrayList = new ArrayList<>();
            for (UserInfoBean userInfoBean2 : list) {
                C12888bu m15933a = C12806ae.m15933a(userInfoBean2);
                if (m15933a != null) {
                    arrayList.add(m15933a);
                }
            }
            c12889bv2.f36850d = arrayList;
            HashMap hashMap = new HashMap();
            c12889bv2.f36851e = hashMap;
            hashMap.put("A7", new StringBuilder().toString());
            Map<String, String> map = c12889bv2.f36851e;
            map.put("A6", C12786aa.m15986n());
            Map<String, String> map2 = c12889bv2.f36851e;
            map2.put("A5", m16005b.m15987m());
            Map<String, String> map3 = c12889bv2.f36851e;
            StringBuilder sb = new StringBuilder();
            sb.append(m16005b.m15989k());
            map3.put("A2", sb.toString());
            Map<String, String> map4 = c12889bv2.f36851e;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(m16005b.m15989k());
            map4.put("A1", sb2.toString());
            Map<String, String> map5 = c12889bv2.f36851e;
            map5.put("A24", m16005b.f36458k);
            Map<String, String> map6 = c12889bv2.f36851e;
            StringBuilder sb3 = new StringBuilder();
            sb3.append(m16005b.m15988l());
            map6.put("A17", sb3.toString());
            Map<String, String> map7 = c12889bv2.f36851e;
            map7.put("A15", m16005b.m15983q());
            Map<String, String> map8 = c12889bv2.f36851e;
            StringBuilder sb4 = new StringBuilder();
            sb4.append(m16005b.m15982r());
            map8.put("A13", sb4.toString());
            Map<String, String> map9 = c12889bv2.f36851e;
            map9.put("F08", m16005b.f36403E);
            Map<String, String> map10 = c12889bv2.f36851e;
            map10.put("F09", m16005b.f36404F);
            Map<String, String> m15975y = m16005b.m15975y();
            if (m15975y != null && m15975y.size() > 0) {
                for (Map.Entry<String, String> entry : m15975y.entrySet()) {
                    Map<String, String> map11 = c12889bv2.f36851e;
                    map11.put("C04_" + entry.getKey(), entry.getValue());
                }
            }
            if (i == 1) {
                c12889bv2.f36847a = (byte) 1;
            } else if (i != 2) {
                C12820al.m15872e("unknown up type %d ", Integer.valueOf(i));
            } else {
                c12889bv2.f36847a = (byte) 2;
            }
            c12889bv = c12889bv2;
        }
        if (c12889bv == null) {
            C12820al.m15873d("[UserInfo] Failed to create UserInfoPackage.", new Object[0]);
            return;
        }
        byte[] m15932a = C12806ae.m15932a((AbstractC12901m) c12889bv);
        if (m15932a == null) {
            C12820al.m15873d("[UserInfo] Failed to encode data.", new Object[0]);
            return;
        }
        C12884bq m15934a = C12806ae.m15934a(this.f36896a, 840, m15932a);
        if (m15934a == null) {
            C12820al.m15873d("[UserInfo] Request package is null.", new Object[0]);
            return;
        }
        InterfaceC12813ah interfaceC12813ah = new InterfaceC12813ah() { // from class: com.tencent.bugly.proguard.r.1
            @Override // com.tencent.bugly.proguard.InterfaceC12813ah
            /* renamed from: a */
            public final void mo15546a(boolean z2, String str) {
                if (z2) {
                    C12820al.m15874c("[UserInfo] Successfully uploaded user info.", new Object[0]);
                    long currentTimeMillis2 = System.currentTimeMillis();
                    for (UserInfoBean userInfoBean3 : list) {
                        userInfoBean3.f36274f = currentTimeMillis2;
                        C12906r.this.m15561a(userInfoBean3, true);
                    }
                }
            }
        };
        C12814ai.m15913a().m15908a(1001, m15934a, C12803ac.m15950a().m15941c().f36307q, StrategyBean.f36291a, interfaceC12813ah, this.f36898c == 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m15561a(UserInfoBean userInfoBean, boolean z) {
        List<UserInfoBean> m15557a;
        if (userInfoBean == null) {
            return;
        }
        if (!z && userInfoBean.f36270b != 1 && (m15557a = m15557a(C12786aa.m16009a(this.f36896a).f36451d)) != null && m15557a.size() >= 20) {
            C12820al.m15878a("[UserInfo] There are too many user info in local: %d", Integer.valueOf(m15557a.size()));
            return;
        }
        long m15494a = C12920w.m15509a().m15494a("t_ui", m15551b(userInfoBean), (InterfaceC12919v) null);
        if (m15494a >= 0) {
            C12820al.m15874c("[Database] insert %s success with ID: %d", "t_ui", Long.valueOf(m15494a));
            userInfoBean.f36269a = m15494a;
        }
    }

    /* renamed from: a */
    public static List<UserInfoBean> m15557a(String str) {
        Cursor cursor;
        String str2;
        try {
            if (C12828ap.m15817b(str)) {
                str2 = null;
            } else {
                str2 = "_pc = '" + str + "'";
            }
            cursor = C12920w.m15509a().m15491a("t_ui", (String[]) null, str2);
            if (cursor == null) {
                return null;
            }
            try {
                StringBuilder sb = new StringBuilder();
                ArrayList arrayList = new ArrayList();
                while (cursor.moveToNext()) {
                    UserInfoBean m15563a = m15563a(cursor);
                    if (m15563a != null) {
                        arrayList.add(m15563a);
                    } else {
                        long j = cursor.getLong(cursor.getColumnIndex(C13131bm.f37927d));
                        sb.append(" or _id = ");
                        sb.append(j);
                    }
                }
                String sb2 = sb.toString();
                if (sb2.length() > 0) {
                    C12820al.m15873d("[Database] deleted %s error data %d", "t_ui", Integer.valueOf(C12920w.m15509a().m15493a("t_ui", sb2.substring(4))));
                }
                cursor.close();
                return arrayList;
            } catch (Throwable th) {
                th = th;
                try {
                    if (!C12820al.m15877a(th)) {
                        th.printStackTrace();
                    }
                    if (cursor != null) {
                        cursor.close();
                    }
                    return null;
                } finally {
                    if (cursor != null) {
                        cursor.close();
                    }
                }
            }
        } catch (Throwable th2) {
            th = th2;
            cursor = null;
        }
    }

    /* renamed from: a */
    private static UserInfoBean m15563a(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        try {
            byte[] blob = cursor.getBlob(cursor.getColumnIndex("_dt"));
            if (blob == null) {
                return null;
            }
            long j = cursor.getLong(cursor.getColumnIndex(C13131bm.f37927d));
            UserInfoBean userInfoBean = (UserInfoBean) C12828ap.m15824a(blob, UserInfoBean.CREATOR);
            if (userInfoBean != null) {
                userInfoBean.f36269a = j;
            }
            return userInfoBean;
        } catch (Throwable th) {
            if (!C12820al.m15877a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0029 A[DONT_GENERATE] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x002b A[Catch: all -> 0x0092, TRY_ENTER, TryCatch #0 {, blocks: (B:3:0x0001, B:21:0x002b, B:23:0x003e, B:25:0x004c, B:28:0x0061, B:30:0x0067, B:32:0x006c, B:35:0x0073, B:38:0x0089, B:26:0x005b, B:6:0x0009, B:9:0x0010, B:12:0x0017, B:14:0x001d), top: B:46:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0067 A[Catch: all -> 0x0092, TryCatch #0 {, blocks: (B:3:0x0001, B:21:0x002b, B:23:0x003e, B:25:0x004c, B:28:0x0061, B:30:0x0067, B:32:0x006c, B:35:0x0073, B:38:0x0089, B:26:0x005b, B:6:0x0009, B:9:0x0010, B:12:0x0017, B:14:0x001d), top: B:46:0x0001 }] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized void m15553a(boolean r8) {
        /*
            r7 = this;
            monitor-enter(r7)
            boolean r0 = r7.f36899d     // Catch: java.lang.Throwable -> L92
            r1 = 1
            r2 = 0
            if (r0 != 0) goto L9
        L7:
            r0 = 0
            goto L27
        L9:
            com.tencent.bugly.proguard.ai r0 = com.tencent.bugly.proguard.C12814ai.m15913a()     // Catch: java.lang.Throwable -> L92
            if (r0 != 0) goto L10
            goto L7
        L10:
            com.tencent.bugly.proguard.ac r3 = com.tencent.bugly.proguard.C12803ac.m15950a()     // Catch: java.lang.Throwable -> L92
            if (r3 != 0) goto L17
            goto L7
        L17:
            boolean r3 = r3.m15943b()     // Catch: java.lang.Throwable -> L92
            if (r3 == 0) goto L26
            r3 = 1001(0x3e9, float:1.403E-42)
            boolean r0 = r0.m15897b(r3)     // Catch: java.lang.Throwable -> L92
            if (r0 != 0) goto L26
            goto L7
        L26:
            r0 = 1
        L27:
            if (r0 != 0) goto L2b
            monitor-exit(r7)
            return
        L2b:
            android.content.Context r0 = r7.f36896a     // Catch: java.lang.Throwable -> L92
            com.tencent.bugly.proguard.aa r0 = com.tencent.bugly.proguard.C12786aa.m16009a(r0)     // Catch: java.lang.Throwable -> L92
            java.lang.String r0 = r0.f36451d     // Catch: java.lang.Throwable -> L92
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L92
            r3.<init>()     // Catch: java.lang.Throwable -> L92
            java.util.List r0 = m15557a(r0)     // Catch: java.lang.Throwable -> L92
            if (r0 == 0) goto L5b
            m15555a(r0, r3)     // Catch: java.lang.Throwable -> L92
            m15548b(r0, r3)     // Catch: java.lang.Throwable -> L92
            int r4 = m15556a(r0)     // Catch: java.lang.Throwable -> L92
            r5 = 15
            if (r4 <= r5) goto L60
            java.lang.String r5 = "[UserInfo] Upload user info too many times in 10 min: %d"
            java.lang.Object[] r6 = new java.lang.Object[r1]     // Catch: java.lang.Throwable -> L92
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch: java.lang.Throwable -> L92
            r6[r2] = r4     // Catch: java.lang.Throwable -> L92
            com.tencent.bugly.proguard.C12820al.m15873d(r5, r6)     // Catch: java.lang.Throwable -> L92
            r4 = 0
            goto L61
        L5b:
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L92
            r0.<init>()     // Catch: java.lang.Throwable -> L92
        L60:
            r4 = 1
        L61:
            int r5 = r3.size()     // Catch: java.lang.Throwable -> L92
            if (r5 <= 0) goto L6a
            m15549b(r3)     // Catch: java.lang.Throwable -> L92
        L6a:
            if (r4 == 0) goto L89
            int r3 = r0.size()     // Catch: java.lang.Throwable -> L92
            if (r3 != 0) goto L73
            goto L89
        L73:
            java.lang.String r3 = "[UserInfo] Upload user info(size: %d)"
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch: java.lang.Throwable -> L92
            int r4 = r0.size()     // Catch: java.lang.Throwable -> L92
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch: java.lang.Throwable -> L92
            r1[r2] = r4     // Catch: java.lang.Throwable -> L92
            com.tencent.bugly.proguard.C12820al.m15874c(r3, r1)     // Catch: java.lang.Throwable -> L92
            r7.m15554a(r0, r8)     // Catch: java.lang.Throwable -> L92
            monitor-exit(r7)
            return
        L89:
            java.lang.String r8 = "[UserInfo] There is no user info in local database."
            java.lang.Object[] r0 = new java.lang.Object[r2]     // Catch: java.lang.Throwable -> L92
            com.tencent.bugly.proguard.C12820al.m15874c(r8, r0)     // Catch: java.lang.Throwable -> L92
            monitor-exit(r7)
            return
        L92:
            r8 = move-exception
            monitor-exit(r7)
            goto L96
        L95:
            throw r8
        L96:
            goto L95
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.C12906r.m15553a(boolean):void");
    }

    /* renamed from: a */
    static /* synthetic */ void m15562a(UserInfoBean userInfoBean) {
        C12786aa m16005b;
        if (userInfoBean == null || (m16005b = C12786aa.m16005b()) == null) {
            return;
        }
        userInfoBean.f36278j = m16005b.m16000d();
    }
}

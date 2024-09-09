package com.tencent.bugly.proguard;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import com.tencent.bugly.crashreport.biz.UserInfoBean;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import java.io.BufferedReader;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: BUGLY */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public final class r {

    /* renamed from: e  reason: collision with root package name */
    private static boolean f51261e = true;

    /* renamed from: a  reason: collision with root package name */
    private Context f51262a;

    /* renamed from: b  reason: collision with root package name */
    private long f51263b;

    /* renamed from: c  reason: collision with root package name */
    private int f51264c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f51265d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* compiled from: BUGLY */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public class a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        private boolean f51271b;

        /* renamed from: c  reason: collision with root package name */
        private UserInfoBean f51272c;

        public a(UserInfoBean userInfoBean, boolean z3) {
            this.f51272c = userInfoBean;
            this.f51271b = z3;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (r.this.f51265d) {
                try {
                    UserInfoBean userInfoBean = this.f51272c;
                    if (userInfoBean != null) {
                        r.a(userInfoBean);
                        al.c("[UserInfo] Record user info.", new Object[0]);
                        r.this.a(this.f51272c, false);
                    }
                    if (this.f51271b) {
                        r.this.b();
                    }
                } catch (Throwable th) {
                    if (al.a(th)) {
                        return;
                    }
                    th.printStackTrace();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* compiled from: BUGLY */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis < r.this.f51263b) {
                ak.a().a(new b(), (r.this.f51263b - currentTimeMillis) + 5000);
                return;
            }
            r.this.a(3, false);
            r.this.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* compiled from: BUGLY */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public class c implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        private long f51275b;

        public c(long j4) {
            this.f51275b = j4;
        }

        @Override // java.lang.Runnable
        public final void run() {
            r.this.b();
            r.this.a(this.f51275b);
        }
    }

    public r(Context context, boolean z3) {
        this.f51262a = context;
        this.f51265d = z3;
    }

    private static void b(List<UserInfoBean> list, List<UserInfoBean> list2) {
        Iterator<UserInfoBean> it = list.iterator();
        while (it.hasNext()) {
            UserInfoBean next = it.next();
            if (next.f50724f != -1) {
                it.remove();
                if (next.f50723e < ap.b()) {
                    list2.add(next);
                }
            }
        }
    }

    public final void a(int i4, boolean z3) {
        ac a4 = ac.a();
        if (a4 != null && !a4.c().f50747g && i4 != 1 && i4 != 3) {
            al.e("UserInfo is disable", new Object[0]);
            return;
        }
        if (i4 == 1 || i4 == 3) {
            this.f51264c++;
        }
        aa a5 = aa.a(this.f51262a);
        UserInfoBean userInfoBean = new UserInfoBean();
        userInfoBean.f50720b = i4;
        userInfoBean.f50721c = a5.f50825d;
        userInfoBean.f50722d = a5.f();
        userInfoBean.f50723e = System.currentTimeMillis();
        userInfoBean.f50724f = -1L;
        userInfoBean.f50732n = a5.f50836o;
        userInfoBean.f50733o = i4 == 1 ? 1 : 0;
        userInfoBean.f50730l = a5.a();
        userInfoBean.f50731m = a5.f50846y;
        userInfoBean.f50725g = a5.f50847z;
        userInfoBean.f50726h = a5.A;
        userInfoBean.f50727i = a5.B;
        userInfoBean.f50729k = a5.C;
        userInfoBean.f50736r = a5.t();
        userInfoBean.f50737s = a5.y();
        userInfoBean.f50734p = a5.z();
        userInfoBean.f50735q = a5.f50845x;
        ak.a().a(new a(userInfoBean, z3), 0L);
    }

    public final void b() {
        ak a4 = ak.a();
        if (a4 != null) {
            a4.a(new Runnable() { // from class: com.tencent.bugly.proguard.r.2

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ boolean f51268a = false;

                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        r.this.a(this.f51268a);
                    } catch (Throwable th) {
                        al.a(th);
                    }
                }
            });
        }
    }

    private static void b(List<UserInfoBean> list) {
        if (list.size() == 0) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (int i4 = 0; i4 < list.size() && i4 < 50; i4++) {
            sb.append(" or _id = ");
            sb.append(list.get(i4).f50719a);
        }
        String sb2 = sb.toString();
        if (sb2.length() > 0) {
            sb2 = sb2.substring(4);
        }
        sb.setLength(0);
        try {
            al.c("[Database] deleted %s data %d", "t_ui", Integer.valueOf(w.a().a("t_ui", sb2)));
        } catch (Throwable th) {
            if (al.a(th)) {
                return;
            }
            th.printStackTrace();
        }
    }

    private static ContentValues b(UserInfoBean userInfoBean) {
        if (userInfoBean == null) {
            return null;
        }
        try {
            ContentValues contentValues = new ContentValues();
            long j4 = userInfoBean.f50719a;
            if (j4 > 0) {
                contentValues.put("_id", Long.valueOf(j4));
            }
            contentValues.put("_tm", Long.valueOf(userInfoBean.f50723e));
            contentValues.put("_ut", Long.valueOf(userInfoBean.f50724f));
            contentValues.put("_tp", Integer.valueOf(userInfoBean.f50720b));
            contentValues.put("_pc", userInfoBean.f50721c);
            contentValues.put("_dt", ap.a(userInfoBean));
            return contentValues;
        } catch (Throwable th) {
            if (!al.a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    public final void a(long j4) {
        ak.a().a(new c(j4), j4);
    }

    public final void a() {
        this.f51263b = ap.b() + 86400000;
        ak.a().a(new b(), (this.f51263b - System.currentTimeMillis()) + 5000);
    }

    private boolean b(boolean z3) {
        boolean z4;
        boolean z5 = true;
        if (f51261e) {
            File file = new File(this.f51262a.getFilesDir(), "bugly_last_us_up_tm");
            long currentTimeMillis = System.currentTimeMillis();
            if (z3) {
                am.a(file, String.valueOf(currentTimeMillis), 1024L, false);
                return true;
            }
            if (!file.exists()) {
                am.a(file, String.valueOf(currentTimeMillis), 1024L, false);
            } else {
                BufferedReader a4 = ap.a(file);
                if (a4 != null) {
                    try {
                        long longValue = Long.valueOf(a4.readLine().trim()).longValue();
                        if (currentTimeMillis >= longValue && currentTimeMillis - longValue <= 86400000) {
                            z4 = true;
                            if (z4 || currentTimeMillis - longValue >= 300000) {
                                am.a(file, String.valueOf(currentTimeMillis), 1024L, false);
                            } else {
                                z5 = false;
                            }
                        }
                        z4 = false;
                        if (z4) {
                        }
                        am.a(file, String.valueOf(currentTimeMillis), 1024L, false);
                    }
                }
                if (a4 != null) {
                    a4.close();
                }
            }
            return z5;
        }
        return true;
    }

    private static void a(List<UserInfoBean> list, List<UserInfoBean> list2) {
        int size = list.size() - 20;
        if (size > 0) {
            int i4 = 0;
            while (i4 < list.size() - 1) {
                int i5 = i4 + 1;
                for (int i6 = i5; i6 < list.size(); i6++) {
                    if (list.get(i4).f50723e > list.get(i6).f50723e) {
                        list.set(i4, list.get(i6));
                        list.set(i6, list.get(i4));
                    }
                }
                i4 = i5;
            }
            for (int i7 = 0; i7 < size; i7++) {
                list2.add(list.get(i7));
            }
        }
    }

    private static int a(List<UserInfoBean> list) {
        int i4;
        long currentTimeMillis = System.currentTimeMillis();
        int i5 = 0;
        for (UserInfoBean userInfoBean : list) {
            if (userInfoBean.f50723e > currentTimeMillis - 600000 && ((i4 = userInfoBean.f50720b) == 1 || i4 == 4 || i4 == 3)) {
                i5++;
            }
        }
        return i5;
    }

    private void a(final List<UserInfoBean> list, boolean z3) {
        aa b4;
        if (!b(z3)) {
            long currentTimeMillis = System.currentTimeMillis();
            for (UserInfoBean userInfoBean : list) {
                userInfoBean.f50724f = currentTimeMillis;
                a(userInfoBean, true);
            }
            al.d("uploadCheck failed", new Object[0]);
            return;
        }
        int i4 = this.f51264c == 1 ? 1 : 2;
        bv bvVar = null;
        if (list != null && list.size() != 0 && (b4 = aa.b()) != null) {
            b4.o();
            bv bvVar2 = new bv();
            bvVar2.f51215b = b4.f50825d;
            bvVar2.f51216c = b4.g();
            ArrayList<bu> arrayList = new ArrayList<>();
            for (UserInfoBean userInfoBean2 : list) {
                bu a4 = ae.a(userInfoBean2);
                if (a4 != null) {
                    arrayList.add(a4);
                }
            }
            bvVar2.f51217d = arrayList;
            HashMap hashMap = new HashMap();
            bvVar2.f51218e = hashMap;
            hashMap.put("A7", new StringBuilder().toString());
            Map<String, String> map = bvVar2.f51218e;
            map.put("A6", aa.n());
            Map<String, String> map2 = bvVar2.f51218e;
            map2.put("A5", b4.m());
            Map<String, String> map3 = bvVar2.f51218e;
            StringBuilder sb = new StringBuilder();
            sb.append(b4.k());
            map3.put("A2", sb.toString());
            Map<String, String> map4 = bvVar2.f51218e;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(b4.k());
            map4.put("A1", sb2.toString());
            Map<String, String> map5 = bvVar2.f51218e;
            map5.put("A24", b4.f50832k);
            Map<String, String> map6 = bvVar2.f51218e;
            StringBuilder sb3 = new StringBuilder();
            sb3.append(b4.l());
            map6.put("A17", sb3.toString());
            Map<String, String> map7 = bvVar2.f51218e;
            map7.put("A15", b4.q());
            Map<String, String> map8 = bvVar2.f51218e;
            StringBuilder sb4 = new StringBuilder();
            sb4.append(b4.r());
            map8.put("A13", sb4.toString());
            Map<String, String> map9 = bvVar2.f51218e;
            map9.put("F08", b4.E);
            Map<String, String> map10 = bvVar2.f51218e;
            map10.put("F09", b4.F);
            Map<String, String> y3 = b4.y();
            if (y3 != null && y3.size() > 0) {
                for (Map.Entry<String, String> entry : y3.entrySet()) {
                    Map<String, String> map11 = bvVar2.f51218e;
                    map11.put("C04_" + entry.getKey(), entry.getValue());
                }
            }
            if (i4 == 1) {
                bvVar2.f51214a = (byte) 1;
            } else if (i4 != 2) {
                al.e("unknown up type %d ", Integer.valueOf(i4));
            } else {
                bvVar2.f51214a = (byte) 2;
            }
            bvVar = bvVar2;
        }
        if (bvVar == null) {
            al.d("[UserInfo] Failed to create UserInfoPackage.", new Object[0]);
            return;
        }
        byte[] a5 = ae.a((m) bvVar);
        if (a5 == null) {
            al.d("[UserInfo] Failed to encode data.", new Object[0]);
            return;
        }
        bq a6 = ae.a(this.f51262a, 840, a5);
        if (a6 == null) {
            al.d("[UserInfo] Request package is null.", new Object[0]);
            return;
        }
        ah ahVar = new ah() { // from class: com.tencent.bugly.proguard.r.1
            @Override // com.tencent.bugly.proguard.ah
            public final void a(boolean z4, String str) {
                if (z4) {
                    al.c("[UserInfo] Successfully uploaded user info.", new Object[0]);
                    long currentTimeMillis2 = System.currentTimeMillis();
                    for (UserInfoBean userInfoBean3 : list) {
                        userInfoBean3.f50724f = currentTimeMillis2;
                        r.this.a(userInfoBean3, true);
                    }
                }
            }
        };
        ai.a().a(1001, a6, ac.a().c().f50757q, StrategyBean.f50741a, ahVar, this.f51264c == 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(UserInfoBean userInfoBean, boolean z3) {
        List<UserInfoBean> a4;
        if (userInfoBean == null) {
            return;
        }
        if (!z3 && userInfoBean.f50720b != 1 && (a4 = a(aa.a(this.f51262a).f50825d)) != null && a4.size() >= 20) {
            al.a("[UserInfo] There are too many user info in local: %d", Integer.valueOf(a4.size()));
            return;
        }
        long a5 = w.a().a("t_ui", b(userInfoBean), (v) null);
        if (a5 >= 0) {
            al.c("[Database] insert %s success with ID: %d", "t_ui", Long.valueOf(a5));
            userInfoBean.f50719a = a5;
        }
    }

    public static List<UserInfoBean> a(String str) {
        Cursor cursor;
        String str2;
        try {
            if (ap.b(str)) {
                str2 = null;
            } else {
                str2 = "_pc = '" + str + "'";
            }
            cursor = w.a().a("t_ui", (String[]) null, str2);
            if (cursor == null) {
                return null;
            }
            try {
                StringBuilder sb = new StringBuilder();
                ArrayList arrayList = new ArrayList();
                while (cursor.moveToNext()) {
                    UserInfoBean a4 = a(cursor);
                    if (a4 != null) {
                        arrayList.add(a4);
                    } else {
                        long j4 = cursor.getLong(cursor.getColumnIndex("_id"));
                        sb.append(" or _id = ");
                        sb.append(j4);
                    }
                }
                String sb2 = sb.toString();
                if (sb2.length() > 0) {
                    al.d("[Database] deleted %s error data %d", "t_ui", Integer.valueOf(w.a().a("t_ui", sb2.substring(4))));
                }
                cursor.close();
                return arrayList;
            } catch (Throwable th) {
                th = th;
                try {
                    if (!al.a(th)) {
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

    private static UserInfoBean a(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        try {
            byte[] blob = cursor.getBlob(cursor.getColumnIndex("_dt"));
            if (blob == null) {
                return null;
            }
            long j4 = cursor.getLong(cursor.getColumnIndex("_id"));
            UserInfoBean userInfoBean = (UserInfoBean) ap.a(blob, UserInfoBean.CREATOR);
            if (userInfoBean != null) {
                userInfoBean.f50719a = j4;
            }
            return userInfoBean;
        } catch (Throwable th) {
            if (!al.a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0029 A[DONT_GENERATE] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x002b A[Catch: all -> 0x0092, TRY_ENTER, TryCatch #0 {, blocks: (B:3:0x0001, B:21:0x002b, B:23:0x003e, B:25:0x004c, B:28:0x0061, B:30:0x0067, B:32:0x006c, B:35:0x0073, B:38:0x0089, B:26:0x005b, B:6:0x0009, B:9:0x0010, B:12:0x0017, B:14:0x001d), top: B:46:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0067 A[Catch: all -> 0x0092, TryCatch #0 {, blocks: (B:3:0x0001, B:21:0x002b, B:23:0x003e, B:25:0x004c, B:28:0x0061, B:30:0x0067, B:32:0x006c, B:35:0x0073, B:38:0x0089, B:26:0x005b, B:6:0x0009, B:9:0x0010, B:12:0x0017, B:14:0x001d), top: B:46:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized void a(boolean r8) {
        /*
            r7 = this;
            monitor-enter(r7)
            boolean r0 = r7.f51265d     // Catch: java.lang.Throwable -> L92
            r1 = 1
            r2 = 0
            if (r0 != 0) goto L9
        L7:
            r0 = 0
            goto L27
        L9:
            com.tencent.bugly.proguard.ai r0 = com.tencent.bugly.proguard.ai.a()     // Catch: java.lang.Throwable -> L92
            if (r0 != 0) goto L10
            goto L7
        L10:
            com.tencent.bugly.proguard.ac r3 = com.tencent.bugly.proguard.ac.a()     // Catch: java.lang.Throwable -> L92
            if (r3 != 0) goto L17
            goto L7
        L17:
            boolean r3 = r3.b()     // Catch: java.lang.Throwable -> L92
            if (r3 == 0) goto L26
            r3 = 1001(0x3e9, float:1.403E-42)
            boolean r0 = r0.b(r3)     // Catch: java.lang.Throwable -> L92
            if (r0 != 0) goto L26
            goto L7
        L26:
            r0 = 1
        L27:
            if (r0 != 0) goto L2b
            monitor-exit(r7)
            return
        L2b:
            android.content.Context r0 = r7.f51262a     // Catch: java.lang.Throwable -> L92
            com.tencent.bugly.proguard.aa r0 = com.tencent.bugly.proguard.aa.a(r0)     // Catch: java.lang.Throwable -> L92
            java.lang.String r0 = r0.f50825d     // Catch: java.lang.Throwable -> L92
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L92
            r3.<init>()     // Catch: java.lang.Throwable -> L92
            java.util.List r0 = a(r0)     // Catch: java.lang.Throwable -> L92
            if (r0 == 0) goto L5b
            a(r0, r3)     // Catch: java.lang.Throwable -> L92
            b(r0, r3)     // Catch: java.lang.Throwable -> L92
            int r4 = a(r0)     // Catch: java.lang.Throwable -> L92
            r5 = 15
            if (r4 <= r5) goto L60
            java.lang.String r5 = "[UserInfo] Upload user info too many times in 10 min: %d"
            java.lang.Object[] r6 = new java.lang.Object[r1]     // Catch: java.lang.Throwable -> L92
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch: java.lang.Throwable -> L92
            r6[r2] = r4     // Catch: java.lang.Throwable -> L92
            com.tencent.bugly.proguard.al.d(r5, r6)     // Catch: java.lang.Throwable -> L92
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
            b(r3)     // Catch: java.lang.Throwable -> L92
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
            com.tencent.bugly.proguard.al.c(r3, r1)     // Catch: java.lang.Throwable -> L92
            r7.a(r0, r8)     // Catch: java.lang.Throwable -> L92
            monitor-exit(r7)
            return
        L89:
            java.lang.String r8 = "[UserInfo] There is no user info in local database."
            java.lang.Object[] r0 = new java.lang.Object[r2]     // Catch: java.lang.Throwable -> L92
            com.tencent.bugly.proguard.al.c(r8, r0)     // Catch: java.lang.Throwable -> L92
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
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.r.a(boolean):void");
    }

    static /* synthetic */ void a(UserInfoBean userInfoBean) {
        aa b4;
        if (userInfoBean == null || (b4 = aa.b()) == null) {
            return;
        }
        userInfoBean.f50728j = b4.d();
    }
}

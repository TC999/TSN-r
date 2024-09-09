package cn.jpush.android.p;

import android.content.Context;
import cn.jpush.android.d.d;
import cn.jpush.android.helper.Logger;
import cn.jpush.android.helper.c;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private static List<d> f4293a = new LinkedList();

    /* renamed from: b  reason: collision with root package name */
    private static List<d> f4294b = new LinkedList();

    /* renamed from: c  reason: collision with root package name */
    private static int f4295c = 10;

    /* renamed from: d  reason: collision with root package name */
    private Context f4296d;

    /* renamed from: e  reason: collision with root package name */
    private List<Integer> f4297e;

    /* renamed from: f  reason: collision with root package name */
    private AtomicBoolean f4298f;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private static final b f4301a = new b();
    }

    private b() {
        this.f4297e = new ArrayList();
        this.f4298f = new AtomicBoolean(false);
    }

    public static b a() {
        return a.f4301a;
    }

    private void a(d dVar, boolean z3) {
        Context context;
        String str;
        long j4;
        if (z3) {
            context = this.f4296d;
            str = dVar.f4127d;
            j4 = 2007;
        } else if (40 == dVar.bs) {
            c.a(dVar.f4127d, 1603L, this.f4296d);
            return;
        } else {
            context = this.f4296d;
            str = dVar.f4127d;
            j4 = 2002;
        }
        c.a(context, str, j4, 4);
    }

    private void a(List<d> list) {
        if (list.size() >= f4295c) {
            b(list);
            while (list.size() >= f4295c) {
                d dVar = list.get(0);
                list.remove(0);
                cn.jpush.android.ad.c.d(this.f4296d, dVar.f4127d);
                a(dVar, true);
            }
            c(list);
        }
    }

    private void a(List<d> list, d dVar, String str) {
        if (a(dVar, list)) {
            Logger.d("InAppCacheMgr", "the notify message cache already, messageId: " + dVar.f4127d);
            return;
        }
        a(list);
        list.add(dVar);
        c(list);
        c(str, list);
    }

    private void a(List<d> list, String str, boolean z3) {
        if (z3) {
            list.clear();
        }
        b(str, list);
        c(list);
    }

    private static boolean a(int i4) {
        return 40 == i4;
    }

    private boolean a(d dVar, List<d> list) {
        if (list.size() <= 0) {
            return false;
        }
        if (dVar == null) {
            return true;
        }
        for (d dVar2 : list) {
            if (dVar2.f4127d.equals(dVar.f4127d)) {
                return true;
            }
        }
        return false;
    }

    private static List<d> b(int i4) {
        return a(i4) ? f4293a : f4294b;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x006f, code lost:
        cn.jpush.android.helper.Logger.d("InAppCacheMgr", "[loadObjects] reach max cache message count: " + cn.jpush.android.p.b.f4295c + ", drop message count: " + (r3.length() - cn.jpush.android.p.b.f4295c));
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00c9, code lost:
        if (r12.f4298f.get() == false) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00cc, code lost:
        cn.jpush.android.helper.Logger.i("InAppCacheMgr", "load object size: " + r14.size());
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00e4, code lost:
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void b(java.lang.String r13, java.util.List<cn.jpush.android.d.d> r14) {
        /*
            r12 = this;
            java.lang.String r0 = "InAppCacheMgr"
            r1 = 0
            android.content.Context r2 = r12.f4296d     // Catch: java.lang.Throwable -> La7
            java.io.File r2 = cn.jpush.android.ad.c.a(r2, r13)     // Catch: java.lang.Throwable -> La7
            if (r2 == 0) goto L98
            boolean r3 = r2.exists()     // Catch: java.lang.Throwable -> La7
            if (r3 == 0) goto L98
            java.lang.String r2 = cn.jpush.android.ad.c.c(r2)     // Catch: java.lang.Throwable -> La7
            boolean r3 = android.text.TextUtils.isEmpty(r2)     // Catch: java.lang.Throwable -> La7
            if (r3 != 0) goto L98
            org.json.JSONArray r3 = new org.json.JSONArray     // Catch: java.lang.Throwable -> La7
            r3.<init>(r2)     // Catch: java.lang.Throwable -> La7
            java.util.concurrent.atomic.AtomicBoolean r2 = r12.f4298f     // Catch: java.lang.Throwable -> La7
            r4 = 0
            r2.set(r4)     // Catch: java.lang.Throwable -> La7
            int r2 = r3.length()     // Catch: java.lang.Throwable -> La7
            r5 = 1
            int r2 = r2 - r5
        L2c:
            if (r2 < 0) goto L98
            java.lang.Object r6 = r3.get(r2)     // Catch: java.lang.Throwable -> La7
            java.lang.String r6 = r6.toString()     // Catch: java.lang.Throwable -> La7
            cn.jpush.android.d.d r6 = cn.jpush.android.d.d.b(r6)     // Catch: java.lang.Throwable -> La7
            if (r6 != 0) goto L3d
            goto L95
        L3d:
            long r7 = r6.bO     // Catch: java.lang.Throwable -> La7
            long r9 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> La7
            int r11 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r11 > 0) goto L64
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> La7
            r9.<init>()     // Catch: java.lang.Throwable -> La7
            java.lang.String r10 = "loadObjects message out of date, endTime: "
            r9.append(r10)     // Catch: java.lang.Throwable -> La7
            r9.append(r7)     // Catch: java.lang.Throwable -> La7
            java.lang.String r7 = r9.toString()     // Catch: java.lang.Throwable -> La7
            cn.jpush.android.helper.Logger.dd(r0, r7)     // Catch: java.lang.Throwable -> La7
            java.util.concurrent.atomic.AtomicBoolean r7 = r12.f4298f     // Catch: java.lang.Throwable -> La7
            r7.set(r5)     // Catch: java.lang.Throwable -> La7
            r12.a(r6, r4)     // Catch: java.lang.Throwable -> La7
            goto L95
        L64:
            r14.add(r6)     // Catch: java.lang.Throwable -> La7
            int r6 = r14.size()     // Catch: java.lang.Throwable -> La7
            int r7 = cn.jpush.android.p.b.f4295c     // Catch: java.lang.Throwable -> La7
            if (r6 != r7) goto L95
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> La7
            r2.<init>()     // Catch: java.lang.Throwable -> La7
            java.lang.String r4 = "[loadObjects] reach max cache message count: "
            r2.append(r4)     // Catch: java.lang.Throwable -> La7
            int r4 = cn.jpush.android.p.b.f4295c     // Catch: java.lang.Throwable -> La7
            r2.append(r4)     // Catch: java.lang.Throwable -> La7
            java.lang.String r4 = ", drop message count: "
            r2.append(r4)     // Catch: java.lang.Throwable -> La7
            int r3 = r3.length()     // Catch: java.lang.Throwable -> La7
            int r4 = cn.jpush.android.p.b.f4295c     // Catch: java.lang.Throwable -> La7
            int r3 = r3 - r4
            r2.append(r3)     // Catch: java.lang.Throwable -> La7
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> La7
            cn.jpush.android.helper.Logger.d(r0, r2)     // Catch: java.lang.Throwable -> La7
            goto L98
        L95:
            int r2 = r2 + (-1)
            goto L2c
        L98:
            java.util.concurrent.atomic.AtomicBoolean r2 = r12.f4298f
            boolean r2 = r2.get()
            if (r2 == 0) goto La3
        La0:
            r12.a(r13, r14)
        La3:
            cn.jpush.android.ad.m.a(r1)
            goto Lcc
        La7:
            r2 = move-exception
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Le5
            r3.<init>()     // Catch: java.lang.Throwable -> Le5
            java.lang.String r4 = "load objects error:"
            r3.append(r4)     // Catch: java.lang.Throwable -> Le5
            java.lang.String r2 = r2.getMessage()     // Catch: java.lang.Throwable -> Le5
            r3.append(r2)     // Catch: java.lang.Throwable -> Le5
            java.lang.String r2 = r3.toString()     // Catch: java.lang.Throwable -> Le5
            cn.jpush.android.helper.Logger.w(r0, r2)     // Catch: java.lang.Throwable -> Le5
            r12.d(r13)     // Catch: java.lang.Throwable -> Le5
            java.util.concurrent.atomic.AtomicBoolean r2 = r12.f4298f
            boolean r2 = r2.get()
            if (r2 == 0) goto La3
            goto La0
        Lcc:
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            java.lang.String r1 = "load object size: "
            r13.append(r1)
            int r14 = r14.size()
            r13.append(r14)
            java.lang.String r13 = r13.toString()
            cn.jpush.android.helper.Logger.i(r0, r13)
            return
        Le5:
            r0 = move-exception
            java.util.concurrent.atomic.AtomicBoolean r2 = r12.f4298f
            boolean r2 = r2.get()
            if (r2 == 0) goto Lf1
            r12.a(r13, r14)
        Lf1:
            cn.jpush.android.ad.m.a(r1)
            goto Lf6
        Lf5:
            throw r0
        Lf6:
            goto Lf5
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jpush.android.p.b.b(java.lang.String, java.util.List):void");
    }

    private void b(List<d> list) {
        if (list == null || list.size() <= 1) {
            return;
        }
        Collections.sort(list, new Comparator<d>() { // from class: cn.jpush.android.p.b.1
            @Override // java.util.Comparator
            /* renamed from: a */
            public int compare(d dVar, d dVar2) {
                return dVar.bN - dVar2.bN > 0 ? 1 : -1;
            }
        });
    }

    private static String c(int i4) {
        return a(i4) ? "notify_inapp_data" : "inapp_data";
    }

    private void c(String str, List<d> list) {
        Logger.v("InAppCacheMgr", "Action - saveObjects");
        if (list == null || list.size() < 0) {
            Logger.w("InAppCacheMgr", "mObjectList is null or size is 0");
        } else if (list.size() == 0) {
            d(str);
        } else {
            try {
                File a4 = cn.jpush.android.ad.c.a(this.f4296d, str);
                if (a4 == null) {
                    Logger.w("InAppCacheMgr", "file is null");
                    return;
                }
                new JSONArray();
                ArrayList arrayList = new ArrayList();
                int size = list.size() - 1;
                while (true) {
                    if (size < 0) {
                        break;
                    }
                    d dVar = list.get(size);
                    if (dVar != null) {
                        if (dVar.bO <= System.currentTimeMillis()) {
                            list.remove(dVar);
                            Logger.dd("InAppCacheMgr", "saveObjects message out of date, endTime: " + dVar.f4127d);
                            a(dVar, false);
                        } else {
                            arrayList.add(0, dVar.c());
                            if (arrayList.size() == f4295c) {
                                Logger.d("InAppCacheMgr", "[saveObjects] reach max cache message count: " + f4295c + ", drop message count: " + (list.size() - f4295c));
                                break;
                            }
                        }
                    }
                    size--;
                }
                cn.jpush.android.ad.c.a(a4.getAbsolutePath(), new JSONArray((Collection) arrayList).toString());
            } catch (Throwable th) {
                Logger.ww("InAppCacheMgr", "save Objects  error:" + th.getMessage());
            }
        }
    }

    private void c(List<d> list) {
        if (list == null || list.size() <= 1) {
            return;
        }
        Collections.sort(list, new Comparator<d>() { // from class: cn.jpush.android.p.b.2
            @Override // java.util.Comparator
            /* renamed from: a */
            public int compare(d dVar, d dVar2) {
                int i4 = dVar.bt - dVar2.bt;
                return i4 != 0 ? i4 > 0 ? -1 : 1 : dVar.bN - dVar2.bN > 0 ? -1 : 1;
            }
        });
    }

    private void d(String str) {
        File a4 = cn.jpush.android.ad.c.a(this.f4296d, str);
        if (a4 == null) {
            Logger.w("InAppCacheMgr", "can't get files dir");
        } else if (a4.exists()) {
            a4.delete();
        }
    }

    public d a(String str) {
        Logger.d("InAppCacheMgr", "deleteMessage msgID=" + str);
        for (d dVar : f4293a) {
            if (dVar.f4127d.equals(str)) {
                return dVar;
            }
        }
        for (d dVar2 : f4294b) {
            if (dVar2.f4127d.equals(str)) {
                return dVar2;
            }
        }
        return null;
    }

    public void a(Context context) {
        this.f4296d = context;
        a(f4293a, "notify_inapp_data", true);
        a(f4294b, "inapp_data", true);
    }

    public void a(d dVar) {
        if (dVar == null) {
            return;
        }
        int i4 = dVar.bs;
        int i5 = dVar.ax;
        if (i5 <= 0) {
            i5 = 10;
        }
        f4295c = i5;
        a(b(i4), dVar, c(i4));
    }

    public void a(String str, List<d> list) {
        c(str, list);
    }

    public synchronized int b() {
        return f4293a.size() + f4294b.size();
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x0108  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public cn.jpush.android.d.d b(java.lang.String r9) {
        /*
            Method dump skipped, instructions count: 308
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jpush.android.p.b.b(java.lang.String):cn.jpush.android.d.d");
    }

    public void b(d dVar) {
        try {
            if (this.f4297e == null) {
                this.f4297e = new ArrayList();
            }
            this.f4297e.add(Integer.valueOf(dVar.bt));
        } catch (Throwable unused) {
        }
    }

    public void c() {
        this.f4297e.clear();
    }

    public boolean c(String str) {
        List<d> list;
        String str2;
        Logger.d("InAppCacheMgr", "deleteMessage msgID=" + str);
        Iterator<d> it = f4293a.iterator();
        while (true) {
            if (!it.hasNext()) {
                for (d dVar : f4294b) {
                    if (dVar.f4127d.equals(str)) {
                        f4294b.remove(dVar);
                        Logger.d("InAppCacheMgr", "deleteMessage  mInAppList remove msgID=" + str);
                        list = f4294b;
                        str2 = "inapp_data";
                    }
                }
                return false;
            }
            d next = it.next();
            if (next.f4127d.equals(str)) {
                f4293a.remove(next);
                Logger.d("InAppCacheMgr", "deleteMessage  mNotifyInAppList remove msgID=" + str);
                list = f4293a;
                str2 = "notify_inapp_data";
                break;
            }
        }
        a(str2, list);
        return true;
    }
}

package com.amap.api.col.p0463l;

import android.content.Context;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: com.amap.api.col.3l.f0 */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class OfflineMapDataVerify extends Thread {

    /* renamed from: a */
    private Context f4088a;

    /* renamed from: b */
    private OfflineDBOperation f4089b;

    public OfflineMapDataVerify(Context context) {
        this.f4088a = context;
        this.f4089b = OfflineDBOperation.m54085b(context);
    }

    /* renamed from: a */
    private static UpdateItem m55098a(File file) {
        String m55687w = C1732a3.m55687w(file);
        UpdateItem updateItem = new UpdateItem();
        updateItem.m54533o(m55687w);
        return updateItem;
    }

    /* renamed from: b */
    private UpdateItem m55097b(String str) {
        if (str.equals("quanguo")) {
            str = "quanguogaiyaotu";
        }
        OfflineDownloadManager m55594b = OfflineDownloadManager.m55594b(this.f4088a);
        UpdateItem updateItem = null;
        if (m55594b != null) {
            String m55606E = m55594b.m55606E(str);
            File[] listFiles = new File(C1732a3.m55707f0(this.f4088a)).listFiles();
            if (listFiles == null) {
                return null;
            }
            for (File file : listFiles) {
                if ((file.getName().contains(m55606E) || file.getName().contains(str)) && file.getName().endsWith(".zip.tmp.dt")) {
                    updateItem = m55098a(file);
                    if (updateItem.m54256a() != null) {
                        return updateItem;
                    }
                }
            }
        }
        return updateItem;
    }

    /* renamed from: c */
    private void m55096c() {
        UpdateItem m55097b;
        String m53345i;
        int indexOf;
        String m53345i2;
        int indexOf2;
        String m53345i3;
        int indexOf3;
        ArrayList<String> arrayList = new ArrayList<>();
        ArrayList<UpdateItem> m54084c = this.f4089b.m54084c();
        m55095d(arrayList, "vmap/");
        m55095d(arrayList, "map/");
        m55092g(arrayList, "map/");
        ArrayList<String> m55093f = m55093f();
        Iterator<UpdateItem> it = m54084c.iterator();
        while (it.hasNext()) {
            UpdateItem next = it.next();
            if (next != null && next.m54256a() != null) {
                int i = next.f5038l;
                boolean z = true;
                if (i == 4 || i == 7) {
                    boolean contains = arrayList.contains(next.m54247j());
                    if (contains || (m53345i = Utility.m53345i(next.m54250g())) == null || (indexOf = arrayList.indexOf(m53345i)) == -1) {
                        z = contains;
                    } else {
                        arrayList.set(indexOf, next.m54247j());
                    }
                    if (!z) {
                        this.f4089b.m54076k(next);
                    }
                } else {
                    boolean z2 = false;
                    if (i != 0 && i != 1) {
                        if (i == 3 && next.m54248i() != 0) {
                            z2 = (m55093f.contains(next.m54252e()) || m55093f.contains(next.m54247j())) ? true : true;
                            if (z2 || (m53345i3 = Utility.m53345i(next.m54250g())) == null || (indexOf3 = m55093f.indexOf(m53345i3)) == -1) {
                                z = z2;
                            } else {
                                m55093f.set(indexOf3, next.m54247j());
                            }
                            if (!z) {
                                this.f4089b.m54076k(next);
                            }
                        }
                    } else {
                        z2 = (m55093f.contains(next.m54252e()) || m55093f.contains(next.m54247j())) ? true : true;
                        if (z2 || (m53345i2 = Utility.m53345i(next.m54250g())) == null || (indexOf2 = m55093f.indexOf(m53345i2)) == -1) {
                            z = z2;
                        } else {
                            m55093f.set(indexOf2, next.m54247j());
                        }
                        if (!z) {
                            this.f4089b.m54076k(next);
                        }
                    }
                }
            }
        }
        Iterator<String> it2 = arrayList.iterator();
        while (it2.hasNext()) {
            String next2 = it2.next();
            if (!m55094e(next2, m54084c) && (m55097b = m55097b(next2)) != null) {
                this.f4089b.m54082e(m55097b);
            }
        }
        OfflineDownloadManager m55594b = OfflineDownloadManager.m55594b(this.f4088a);
        if (m55594b != null) {
            m55594b.m55586j();
        }
    }

    /* renamed from: d */
    private void m55095d(ArrayList<String> arrayList, String str) {
        File[] listFiles;
        String name;
        int lastIndexOf;
        File file = new File(C1732a3.m55721X(this.f4088a) + str);
        if (file.exists() && (listFiles = file.listFiles()) != null) {
            for (File file2 : listFiles) {
                if (file2.getName().endsWith(".dat") && (lastIndexOf = (name = file2.getName()).lastIndexOf(46)) >= 0 && lastIndexOf < name.length()) {
                    String substring = name.substring(0, lastIndexOf);
                    if (!arrayList.contains(substring)) {
                        arrayList.add(substring);
                    }
                }
            }
        }
    }

    /* renamed from: e */
    private static boolean m55094e(String str, ArrayList<UpdateItem> arrayList) {
        Iterator<UpdateItem> it = arrayList.iterator();
        while (it.hasNext()) {
            if (str.equals(it.next().m54247j())) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: f */
    private ArrayList<String> m55093f() {
        File[] listFiles;
        String name;
        int lastIndexOf;
        ArrayList<String> arrayList = new ArrayList<>();
        File file = new File(C1732a3.m55707f0(this.f4088a));
        if (file.exists() && (listFiles = file.listFiles()) != null) {
            for (File file2 : listFiles) {
                if (file2.getName().endsWith(".zip") && (lastIndexOf = (name = file2.getName()).lastIndexOf(46)) >= 0 && lastIndexOf < name.length()) {
                    arrayList.add(name.substring(0, lastIndexOf));
                }
            }
            return arrayList;
        }
        return arrayList;
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x0086, code lost:
        if (r10 != false) goto L28;
     */
    /* JADX WARN: Removed duplicated region for block: B:42:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x008f A[SYNTHETIC] */
    /* renamed from: g */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void m55092g(java.util.ArrayList<java.lang.String> r14, java.lang.String r15) {
        /*
            r13 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            android.content.Context r1 = r13.f4088a
            java.lang.String r1 = com.amap.api.col.p0463l.C1732a3.m55688v(r1)
            r0.append(r1)
            r0.append(r15)
            java.io.File r15 = new java.io.File
            java.lang.String r0 = r0.toString()
            r15.<init>(r0)
            boolean r0 = r15.exists()
            if (r0 != 0) goto L21
            return
        L21:
            java.io.File[] r15 = r15.listFiles()
            if (r15 != 0) goto L28
            return
        L28:
            int r0 = r15.length
            r1 = 0
            r2 = 0
        L2b:
            if (r2 >= r0) goto L92
            r3 = r15[r2]
            boolean r4 = r3.isDirectory()
            if (r4 == 0) goto L8f
            java.lang.String r4 = r3.getName()
            boolean r5 = android.text.TextUtils.isEmpty(r4)
            if (r5 != 0) goto L8f
            java.lang.String[] r3 = r3.list()
            if (r3 == 0) goto L8f
            int r5 = r3.length
            if (r5 <= 0) goto L8f
            boolean r5 = r14.contains(r4)
            if (r5 != 0) goto L8f
            java.lang.String r5 = "a0"
            boolean r5 = r4.equals(r5)
            java.lang.String r6 = "m1.ans"
            r7 = 1
            if (r5 == 0) goto L69
            int r5 = r3.length
            r8 = 0
        L5b:
            if (r8 >= r5) goto L89
            r9 = r3[r8]
            boolean r9 = r6.equals(r9)
            if (r9 == 0) goto L66
            goto L8a
        L66:
            int r8 = r8 + 1
            goto L5b
        L69:
            int r5 = r3.length
            r8 = 0
            r9 = 0
            r10 = 0
        L6d:
            if (r8 >= r5) goto L84
            r11 = r3[r8]
            boolean r12 = r6.equals(r11)
            if (r12 == 0) goto L78
            r9 = 1
        L78:
            java.lang.String r12 = "m3.ans"
            boolean r11 = r12.equals(r11)
            if (r11 == 0) goto L81
            r10 = 1
        L81:
            int r8 = r8 + 1
            goto L6d
        L84:
            if (r9 == 0) goto L89
            if (r10 == 0) goto L89
            goto L8a
        L89:
            r7 = 0
        L8a:
            if (r7 == 0) goto L8f
            r14.add(r4)
        L8f:
            int r2 = r2 + 1
            goto L2b
        L92:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0463l.OfflineMapDataVerify.m55092g(java.util.ArrayList, java.lang.String):void");
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        try {
            m55096c();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}

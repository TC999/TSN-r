package com.amap.api.col.p0003l;

import android.content.Context;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* compiled from: OfflineMapDataVerify.java */
/* renamed from: com.amap.api.col.3l.f0  reason: invalid package */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class f0 extends Thread {

    /* renamed from: a  reason: collision with root package name */
    private Context f7666a;

    /* renamed from: b  reason: collision with root package name */
    private r0 f7667b;

    public f0(Context context) {
        this.f7666a = context;
        this.f7667b = r0.b(context);
    }

    private static m0 a(File file) {
        String w3 = a3.w(file);
        m0 m0Var = new m0();
        m0Var.o(w3);
        return m0Var;
    }

    private m0 b(String str) {
        if (str.equals("quanguo")) {
            str = "quanguogaiyaotu";
        }
        b0 b4 = b0.b(this.f7666a);
        m0 m0Var = null;
        if (b4 != null) {
            String E = b4.E(str);
            File[] listFiles = new File(a3.f0(this.f7666a)).listFiles();
            if (listFiles == null) {
                return null;
            }
            for (File file : listFiles) {
                if ((file.getName().contains(E) || file.getName().contains(str)) && file.getName().endsWith(".zip.tmp.dt")) {
                    m0Var = a(file);
                    if (m0Var.a() != null) {
                        return m0Var;
                    }
                }
            }
        }
        return m0Var;
    }

    private void c() {
        m0 b4;
        String i4;
        int indexOf;
        String i5;
        int indexOf2;
        String i6;
        int indexOf3;
        ArrayList<String> arrayList = new ArrayList<>();
        ArrayList<m0> c4 = this.f7667b.c();
        d(arrayList, "vmap/");
        d(arrayList, "map/");
        g(arrayList, "map/");
        ArrayList<String> f4 = f();
        Iterator<m0> it = c4.iterator();
        while (it.hasNext()) {
            m0 next = it.next();
            if (next != null && next.a() != null) {
                int i7 = next.f8591l;
                boolean z3 = true;
                if (i7 == 4 || i7 == 7) {
                    boolean contains = arrayList.contains(next.j());
                    if (contains || (i4 = z0.i(next.g())) == null || (indexOf = arrayList.indexOf(i4)) == -1) {
                        z3 = contains;
                    } else {
                        arrayList.set(indexOf, next.j());
                    }
                    if (!z3) {
                        this.f7667b.k(next);
                    }
                } else {
                    boolean z4 = false;
                    if (i7 != 0 && i7 != 1) {
                        if (i7 == 3 && next.i() != 0) {
                            z4 = (f4.contains(next.e()) || f4.contains(next.j())) ? true : true;
                            if (z4 || (i6 = z0.i(next.g())) == null || (indexOf3 = f4.indexOf(i6)) == -1) {
                                z3 = z4;
                            } else {
                                f4.set(indexOf3, next.j());
                            }
                            if (!z3) {
                                this.f7667b.k(next);
                            }
                        }
                    } else {
                        z4 = (f4.contains(next.e()) || f4.contains(next.j())) ? true : true;
                        if (z4 || (i5 = z0.i(next.g())) == null || (indexOf2 = f4.indexOf(i5)) == -1) {
                            z3 = z4;
                        } else {
                            f4.set(indexOf2, next.j());
                        }
                        if (!z3) {
                            this.f7667b.k(next);
                        }
                    }
                }
            }
        }
        Iterator<String> it2 = arrayList.iterator();
        while (it2.hasNext()) {
            String next2 = it2.next();
            if (!e(next2, c4) && (b4 = b(next2)) != null) {
                this.f7667b.e(b4);
            }
        }
        b0 b5 = b0.b(this.f7666a);
        if (b5 != null) {
            b5.j();
        }
    }

    private void d(ArrayList<String> arrayList, String str) {
        File[] listFiles;
        String name;
        int lastIndexOf;
        File file = new File(a3.X(this.f7666a) + str);
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

    private static boolean e(String str, ArrayList<m0> arrayList) {
        Iterator<m0> it = arrayList.iterator();
        while (it.hasNext()) {
            if (str.equals(it.next().j())) {
                return true;
            }
        }
        return false;
    }

    private ArrayList<String> f() {
        File[] listFiles;
        String name;
        int lastIndexOf;
        ArrayList<String> arrayList = new ArrayList<>();
        File file = new File(a3.f0(this.f7666a));
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
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void g(java.util.ArrayList<java.lang.String> r14, java.lang.String r15) {
        /*
            r13 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            android.content.Context r1 = r13.f7666a
            java.lang.String r1 = com.amap.api.col.p0003l.a3.v(r1)
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
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0003l.f0.g(java.util.ArrayList, java.lang.String):void");
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        try {
            c();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}

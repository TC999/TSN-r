package com.bytedance.sdk.component.adexpress.c.w;

import android.text.TextUtils;
import com.bytedance.sdk.component.adexpress.c.xv.c;
import com.bytedance.sdk.component.utils.a;
import com.bytedance.sdk.component.utils.z;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public abstract class xv {
    public abstract File c();

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean c(Map<String, com.bytedance.sdk.component.adexpress.c.xv.c> map) {
        if (map != null && map.size() != 0) {
            for (String str : map.keySet()) {
                com.bytedance.sdk.component.adexpress.c.xv.c cVar = map.get(str);
                if (cVar != null && !c(cVar.getResources())) {
                    a.w("PlayComponentEngineCacheManager", "resources is false");
                    return false;
                }
            }
            return true;
        }
        a.w("PlayComponentEngineCacheManager", "map is false");
        return false;
    }

    public List<c.C0435c> w(com.bytedance.sdk.component.adexpress.c.xv.c cVar, com.bytedance.sdk.component.adexpress.c.xv.c cVar2) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        if (cVar2 != null && !cVar2.getResources().isEmpty()) {
            if (cVar.getResources().isEmpty()) {
                arrayList.addAll(cVar2.getResources());
                a.w("PlayComponentEngineCacheManager", "loadTemplate update2");
            } else {
                for (c.C0435c c0435c : cVar.getResources()) {
                    if (!cVar2.getResources().contains(c0435c) && c0435c != null && c0435c.c() != null && c0435c.w() != null) {
                        arrayList2.add(c0435c);
                    }
                }
                for (c.C0435c c0435c2 : cVar2.getResources()) {
                    if (!cVar.getResources().contains(c0435c2)) {
                        arrayList.add(c0435c2);
                    }
                }
                a.w("PlayComponentEngineCacheManager", "loadTemplate update3");
            }
        } else {
            arrayList2.addAll(cVar.getResources());
            a.w("PlayComponentEngineCacheManager", "loadTemplate update1");
        }
        if (c(arrayList2, arrayList3)) {
            return arrayList;
        }
        return null;
    }

    public void xv(List<c.C0435c> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        for (c.C0435c c0435c : list) {
            File file = new File(c(), com.bytedance.sdk.component.utils.ux.w(c0435c.c()));
            File file2 = new File(file + ".tmp");
            if (file.exists()) {
                try {
                    file.delete();
                } catch (Throwable unused) {
                }
            }
            if (file2.exists()) {
                try {
                    file2.delete();
                } catch (Throwable unused2) {
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:12:0x001a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean c(java.util.List<com.bytedance.sdk.component.adexpress.c.xv.c.C0435c> r6) {
        /*
            r5 = this;
            r0 = 0
            if (r6 == 0) goto L5b
            int r1 = r6.size()
            if (r1 <= 0) goto L5b
            java.io.File r1 = r5.c()
            if (r1 != 0) goto L10
            goto L5b
        L10:
            java.util.Iterator r6 = r6.iterator()
        L14:
            boolean r1 = r6.hasNext()
            if (r1 == 0) goto L59
            java.lang.Object r1 = r6.next()
            com.bytedance.sdk.component.adexpress.c.xv.c$c r1 = (com.bytedance.sdk.component.adexpress.c.xv.c.C0435c) r1
            java.lang.String r2 = r1.c()
            java.lang.String r2 = com.bytedance.sdk.component.utils.ux.w(r2)
            boolean r3 = android.text.TextUtils.isEmpty(r2)
            if (r3 == 0) goto L2f
            return r0
        L2f:
            java.io.File r3 = new java.io.File
            java.io.File r4 = r5.c()
            r3.<init>(r4, r2)
            java.lang.String r2 = com.bytedance.sdk.component.utils.ux.c(r3)
            boolean r4 = r3.exists()
            if (r4 == 0) goto L58
            boolean r3 = r3.isFile()
            if (r3 == 0) goto L58
            java.lang.String r3 = r1.w()
            if (r3 == 0) goto L58
            java.lang.String r1 = r1.w()
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L14
        L58:
            return r0
        L59:
            r6 = 1
            return r6
        L5b:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.adexpress.c.w.xv.c(java.util.List):boolean");
    }

    public static boolean xv(com.bytedance.sdk.component.adexpress.c.xv.c cVar, com.bytedance.sdk.component.adexpress.c.xv.c cVar2) {
        if (cVar != null) {
            try {
                if (!TextUtils.isEmpty(cVar.xv())) {
                    if (cVar2 == null) {
                        return false;
                    }
                    if (c(cVar.xv(), cVar2.xv())) {
                        return true;
                    }
                    Map<String, com.bytedance.sdk.component.adexpress.c.xv.c> c4 = cVar.c();
                    Map<String, com.bytedance.sdk.component.adexpress.c.xv.c> c5 = cVar2.c();
                    if (c4.isEmpty()) {
                        a.w("PlayComponentEngineCacheManager", "old engine is empty");
                        return !c5.isEmpty();
                    } else if (c5.isEmpty()) {
                        return false;
                    } else {
                        boolean c6 = c(c4, c5);
                        a.w("PlayComponentEngineCacheManager", "update:" + c6);
                        return c6;
                    }
                }
            } catch (Throwable th) {
                a.w("PlayComponentEngineCacheManager", th.getMessage());
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0020  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean c(com.bytedance.sdk.component.adexpress.c.xv.c.w r5) {
        /*
            r4 = this;
            r0 = 0
            if (r5 == 0) goto L42
            java.io.File r1 = r4.c()
            if (r1 != 0) goto La
            goto L42
        La:
            java.util.List r5 = r5.w()
            if (r5 == 0) goto L40
            int r1 = r5.size()
            if (r1 <= 0) goto L40
            java.util.Iterator r5 = r5.iterator()
        L1a:
            boolean r1 = r5.hasNext()
            if (r1 == 0) goto L40
            java.lang.Object r1 = r5.next()
            android.util.Pair r1 = (android.util.Pair) r1
            java.io.File r2 = new java.io.File
            java.io.File r3 = r4.c()
            java.lang.Object r1 = r1.first
            java.lang.String r1 = (java.lang.String) r1
            r2.<init>(r3, r1)
            boolean r1 = r2.exists()
            if (r1 == 0) goto L3f
            boolean r1 = r2.isFile()
            if (r1 != 0) goto L1a
        L3f:
            return r0
        L40:
            r5 = 1
            return r5
        L42:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.adexpress.c.w.xv.c(com.bytedance.sdk.component.adexpress.c.xv.c$w):boolean");
    }

    public void w(List<c.C0435c> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        for (c.C0435c c0435c : list) {
            File file = new File(c(), com.bytedance.sdk.component.utils.ux.w(c0435c.c()));
            File file2 = new File(file + ".tmp");
            if (file.exists()) {
                try {
                    file.delete();
                } catch (Throwable unused) {
                }
            }
            if (file2.exists()) {
                try {
                    file2.delete();
                } catch (Throwable unused2) {
                }
            }
        }
    }

    public List<c.C0435c> c(com.bytedance.sdk.component.adexpress.c.xv.c cVar, com.bytedance.sdk.component.adexpress.c.xv.c cVar2) {
        Map<String, com.bytedance.sdk.component.adexpress.c.xv.c> c4 = cVar.c();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        if (c4.size() == 0) {
            if (cVar2 != null && cVar2.c().size() != 0) {
                Map<String, com.bytedance.sdk.component.adexpress.c.xv.c> c5 = cVar2.c();
                for (String str : c5.keySet()) {
                    com.bytedance.sdk.component.adexpress.c.xv.c cVar3 = c5.get(str);
                    if (cVar3 != null) {
                        arrayList.addAll(cVar3.getResources());
                        a.w("PlayComponentEngineCacheManager", "deleteAll");
                    }
                }
            }
        } else if (cVar2 != null && cVar2.c().size() != 0) {
            Map<String, com.bytedance.sdk.component.adexpress.c.xv.c> c6 = cVar2.c();
            for (String str2 : c4.keySet()) {
                com.bytedance.sdk.component.adexpress.c.xv.c cVar4 = c4.get(str2);
                com.bytedance.sdk.component.adexpress.c.xv.c cVar5 = c6.get(str2);
                if (cVar5 == null && cVar4 != null) {
                    arrayList2.addAll(cVar4.getResources());
                } else if (cVar4 == null && cVar5 != null) {
                    arrayList.addAll(cVar5.getResources());
                } else if (cVar4 != null) {
                    for (c.C0435c c0435c : cVar4.getResources()) {
                        if (c0435c != null && !cVar5.getResources().contains(c0435c) && c0435c.w() != null && c0435c.c() != null) {
                            arrayList2.add(c0435c);
                        }
                    }
                    for (c.C0435c c0435c2 : cVar5.getResources()) {
                        if (c0435c2 != null && !cVar4.getResources().contains(c0435c2)) {
                            arrayList.add(c0435c2);
                        }
                    }
                }
            }
        } else if (c4.size() != 0) {
            for (String str3 : c4.keySet()) {
                com.bytedance.sdk.component.adexpress.c.xv.c cVar6 = c4.get(str3);
                if (cVar6 != null) {
                    arrayList2.addAll(cVar6.getResources());
                    a.w("PlayComponentEngineCacheManager", "updateAll");
                }
            }
        }
        if (c(arrayList2, arrayList3)) {
            return arrayList;
        }
        a.w("PlayComponentEngineCacheManager", "download error");
        return null;
    }

    public static void w(File file, com.bytedance.sdk.component.adexpress.c.xv.c cVar, String str) {
        if (cVar == null || file == null) {
            return;
        }
        try {
            new File(file, str).delete();
        } catch (Throwable unused) {
            a.w("PlayComponentEngineCacheManager", "clear() pkgjson target error");
        }
        if (cVar.getResources() != null) {
            for (c.C0435c c0435c : cVar.getResources()) {
                try {
                    new File(file, com.bytedance.sdk.component.utils.ux.w(c0435c.c())).delete();
                } catch (Throwable unused2) {
                    a.w("PlayComponentEngineCacheManager", "clear() resource target error");
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:5:0x000a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean c(java.util.List<com.bytedance.sdk.component.adexpress.c.xv.c.C0435c> r8, java.util.List<com.bytedance.sdk.component.adexpress.c.xv.c.C0435c> r9) {
        /*
            r7 = this;
            java.util.Iterator r8 = r8.iterator()
        L4:
            boolean r0 = r8.hasNext()
            if (r0 == 0) goto L92
            java.lang.Object r0 = r8.next()
            com.bytedance.sdk.component.adexpress.c.xv.c$c r0 = (com.bytedance.sdk.component.adexpress.c.xv.c.C0435c) r0
            java.lang.String r1 = r0.c()
            java.lang.String r2 = com.bytedance.sdk.component.utils.ux.w(r1)
            java.io.File r3 = new java.io.File
            java.io.File r4 = r7.c()
            r3.<init>(r4, r2)
            java.io.File r4 = new java.io.File
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r5.append(r3)
            java.lang.String r6 = ".tmp"
            r5.append(r6)
            java.lang.String r5 = r5.toString()
            r4.<init>(r5)
            boolean r5 = r3.exists()
            if (r5 == 0) goto L42
            r3.delete()     // Catch: java.lang.Throwable -> L41
            goto L42
        L41:
        L42:
            boolean r3 = r4.exists()
            if (r3 == 0) goto L4d
            r4.delete()     // Catch: java.lang.Throwable -> L4c
            goto L4d
        L4c:
        L4d:
            com.bytedance.sdk.component.adexpress.c.c.c r3 = com.bytedance.sdk.component.adexpress.c.c.c.c()
            com.bytedance.sdk.component.adexpress.c.c.xv r3 = r3.xv()
            com.bytedance.sdk.component.ev.w.c r3 = r3.ux()
            r3.c(r1)
            java.io.File r1 = r7.c()
            java.lang.String r1 = r1.getAbsolutePath()
            r3.c(r1, r2)
            com.bytedance.sdk.component.ev.w r1 = r3.c()
            r9.add(r0)
            if (r1 == 0) goto L86
            boolean r0 = r1.ev()
            if (r0 == 0) goto L86
            java.io.File r0 = r1.r()
            if (r0 == 0) goto L86
            java.io.File r0 = r1.r()
            boolean r0 = r0.exists()
            if (r0 != 0) goto L4
        L86:
            r7.xv(r9)
            java.lang.String r8 = "PlayComponentEngineCacheManager"
            java.lang.String r9 = "really download error"
            com.bytedance.sdk.component.utils.a.w(r8, r9)
            r8 = 0
            return r8
        L92:
            r8 = 1
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.adexpress.c.w.xv.c(java.util.List, java.util.List):boolean");
    }

    public boolean c(String str) {
        String w3 = com.bytedance.sdk.component.utils.ux.w(str);
        File absoluteFile = c().getAbsoluteFile();
        File file = new File(absoluteFile, w3 + ".zip");
        com.bytedance.sdk.component.ev.w.c ux = com.bytedance.sdk.component.adexpress.c.c.c.c().xv().ux();
        ux.c(str);
        ux.c(file.getParent(), file.getName());
        com.bytedance.sdk.component.ev.w c4 = ux.c();
        if (c4.ev() && c4.r() != null && c4.r().exists()) {
            File r3 = c4.r();
            try {
                z.c(r3.getAbsolutePath(), file.getParent());
                if (r3.exists()) {
                    r3.delete();
                    return true;
                }
                return true;
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        }
        return false;
    }

    public void c(int i4) {
        if (com.bytedance.sdk.component.adexpress.c.c.c.c().sr() != null) {
            com.bytedance.sdk.component.adexpress.c.c.c.c().sr().c(i4);
        }
    }

    public static void c(File file, com.bytedance.sdk.component.adexpress.c.xv.c cVar, String str) {
        FileOutputStream fileOutputStream;
        if (cVar == null) {
            return;
        }
        String ev = cVar.ev();
        if (TextUtils.isEmpty(ev)) {
            return;
        }
        File file2 = new File(file, str);
        File file3 = new File(file2 + ".tmp");
        if (file3.exists()) {
            file3.delete();
        }
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                fileOutputStream = new FileOutputStream(file3);
            } catch (Throwable th) {
                th = th;
            }
            try {
                fileOutputStream.write(ev.getBytes("utf-8"));
                if (file2.exists()) {
                    file2.delete();
                }
                file3.renameTo(file2);
                fileOutputStream.close();
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream2 = fileOutputStream;
                try {
                    a.xv("PlayComponentEngineCacheManager", "version save error3", th);
                    if (fileOutputStream2 != null) {
                        fileOutputStream2.close();
                    }
                } catch (Throwable th3) {
                    if (fileOutputStream2 != null) {
                        try {
                            fileOutputStream2.close();
                        } catch (IOException unused) {
                        }
                    }
                    throw th3;
                }
            }
        } catch (IOException unused2) {
        }
    }

    private static boolean c(Map<String, com.bytedance.sdk.component.adexpress.c.xv.c> map, Map<String, com.bytedance.sdk.component.adexpress.c.xv.c> map2) {
        if (map.size() != map2.size()) {
            return true;
        }
        for (String str : map2.keySet()) {
            com.bytedance.sdk.component.adexpress.c.xv.c cVar = map.get(str);
            if (cVar == null) {
                return true;
            }
            com.bytedance.sdk.component.adexpress.c.xv.c cVar2 = map2.get(str);
            if (cVar2 == null) {
                return false;
            }
            if (c(cVar.xv(), cVar2.xv())) {
                return true;
            }
        }
        return false;
    }

    private static boolean c(String str, String str2) {
        String[] split = str2.split("\\.");
        String[] split2 = str.split("\\.");
        int min = Math.min(split.length, split2.length);
        for (int i4 = 0; i4 < min; i4++) {
            int length = split[i4].length() - split2[i4].length();
            if (length != 0) {
                return length > 0;
            }
            int compareTo = split[i4].compareTo(split2[i4]);
            if (compareTo > 0) {
                return true;
            }
            if (compareTo < 0) {
                return false;
            }
            if (i4 == min - 1) {
                return split.length > split2.length;
            }
        }
        return false;
    }

    @Deprecated
    public static boolean c(com.bytedance.sdk.component.adexpress.c.xv.c cVar, String str) {
        if (cVar != null) {
            try {
                if (TextUtils.isEmpty(cVar.xv())) {
                    return true;
                }
                if (TextUtils.isEmpty(str)) {
                    return false;
                }
                return c(cVar.xv(), str);
            } catch (Throwable unused) {
                return false;
            }
        }
        return true;
    }
}

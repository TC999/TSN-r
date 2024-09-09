package com.kuaishou.weapon.p0;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import java.io.File;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
@SuppressLint({"LongLogTag"})
/* renamed from: com.kuaishou.weapon.p0.do  reason: invalid class name */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class Cdo {

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* renamed from: com.kuaishou.weapon.p0.do$a */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    static final class a {
        private a() {
        }

        static /* synthetic */ void a(ClassLoader classLoader, File file) {
            b(classLoader, file);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void b(ClassLoader classLoader, File file) {
            Object obj = dq.a(classLoader, "pathList").get(classLoader);
            Field a4 = dq.a(obj, "nativeLibraryDirectories");
            File[] fileArr = (File[]) a4.get(obj);
            ArrayList arrayList = new ArrayList();
            for (File file2 : fileArr) {
                if (!file.equals(file2)) {
                    arrayList.add(file2);
                }
            }
            arrayList.add(file);
            a4.set(obj, arrayList.toArray(new File[0]));
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* renamed from: com.kuaishou.weapon.p0.do$b */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    static final class b {
        private b() {
        }

        static /* synthetic */ void a(ClassLoader classLoader, File file) {
            b(classLoader, file);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void b(ClassLoader classLoader, File file) {
            Object obj = dq.a(classLoader, "pathList").get(classLoader);
            Field a4 = dq.a(obj, "nativeLibraryDirectories");
            Collection collection = (List) a4.get(obj);
            if (collection == null) {
                collection = new ArrayList(2);
            }
            ArrayList<File> arrayList = new ArrayList(collection);
            for (File file2 : arrayList) {
                if (file.equals(file2)) {
                    return;
                }
            }
            arrayList.add(file);
            a4.set(obj, arrayList);
            if (a4.get(obj) != arrayList) {
                dq.b(obj, "nativeLibraryDirectories").set(obj, arrayList);
            }
            List list = (List) dq.a(obj, "systemNativeLibraryDirectories").get(obj);
            if (list == null) {
                list = new ArrayList(2);
            }
            ArrayList arrayList2 = new ArrayList(arrayList.size() + list.size() + 1);
            arrayList2.addAll(arrayList);
            arrayList2.addAll(list);
            Object[] objArr = (Object[]) dq.a(obj, "makePathElements", List.class, File.class, List.class).invoke(obj, arrayList2, null, new ArrayList());
            Field a5 = dq.a(obj, "nativeLibraryPathElements");
            a5.set(obj, objArr);
            if (a5.get(obj) != objArr) {
                dq.b(obj, "nativeLibraryPathElements").set(obj, objArr);
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* renamed from: com.kuaishou.weapon.p0.do$c */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    static final class c {
        private c() {
        }

        static /* synthetic */ void a(ClassLoader classLoader, File file) {
            b(classLoader, file);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void b(ClassLoader classLoader, File file) {
            Object obj = dq.a(classLoader, "pathList").get(classLoader);
            List<File> list = (List) dq.a(obj, "nativeLibraryDirectories").get(obj);
            if (list == null) {
                list = new ArrayList(2);
            }
            for (File file2 : list) {
                if (file.equals(file2)) {
                    return;
                }
            }
            list.add(file);
            List list2 = (List) dq.a(obj, "systemNativeLibraryDirectories").get(obj);
            if (list2 == null) {
                list2 = new ArrayList(2);
            }
            ArrayList arrayList = new ArrayList(list.size() + list2.size() + 1);
            arrayList.addAll(list);
            arrayList.addAll(list2);
            dq.a(obj, "nativeLibraryPathElements").set(obj, (Object[]) dq.a(obj, "makePathElements", List.class, File.class, List.class).invoke(obj, arrayList, null, new ArrayList()));
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* renamed from: com.kuaishou.weapon.p0.do$d */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    static final class d {
        private d() {
        }

        static /* synthetic */ void a(ClassLoader classLoader, File file) {
            b(classLoader, file);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void b(ClassLoader classLoader, File file) {
            Object obj = dq.a(classLoader, "pathList").get(classLoader);
            List<File> list = (List) dq.a(obj, "nativeLibraryDirectories").get(obj);
            if (list == null) {
                list = new ArrayList(2);
            }
            for (File file2 : list) {
                if (file.equals(file2)) {
                    return;
                }
            }
            list.add(file);
            List list2 = (List) dq.a(obj, "systemNativeLibraryDirectories").get(obj);
            if (list2 == null) {
                list2 = new ArrayList(2);
            }
            ArrayList arrayList = new ArrayList(list.size() + list2.size() + 1);
            arrayList.addAll(list);
            arrayList.addAll(list2);
            dq.a(obj, "nativeLibraryPathElements").set(obj, (Object[]) dq.a(obj, "makePathElements", List.class).invoke(obj, arrayList));
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* renamed from: com.kuaishou.weapon.p0.do$e */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    static final class e {
        private e() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void b(ClassLoader classLoader, File file) {
            String path = file.getPath();
            Field a4 = dq.a(classLoader, "libPath");
            String valueOf = String.valueOf(a4.get(classLoader));
            a4.set(classLoader, TextUtils.isEmpty(valueOf) ? path : valueOf + ":" + path);
            Field a5 = dq.a(classLoader, "libraryPathElements");
            List<String> list = (List) a5.get(classLoader);
            for (String str : list) {
                if (path.equals(str)) {
                    return;
                }
            }
            list.add(path);
            a5.set(classLoader, list);
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:35:0x003e
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:81)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:47)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    public static synchronized void a(java.lang.ClassLoader r4, java.io.File r5) {
        /*
            java.lang.Class<com.kuaishou.weapon.p0.do> r0 = com.kuaishou.weapon.p0.Cdo.class
            monitor-enter(r0)
            if (r5 == 0) goto L49
            boolean r1 = r5.exists()     // Catch: java.lang.Throwable -> L46
            if (r1 != 0) goto Lc
            goto L49
        Lc:
            int r1 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Throwable -> L46
            r2 = 25
            if (r1 != r2) goto L16
            int r3 = android.os.Build.VERSION.PREVIEW_SDK_INT     // Catch: java.lang.Throwable -> L46
            if (r3 != 0) goto L18
        L16:
            if (r1 <= r2) goto L22
        L18:
            com.kuaishou.weapon.p0.Cdo.d.a(r4, r5)     // Catch: java.lang.Throwable -> L1d
            monitor-exit(r0)
            return
        L1d:
            com.kuaishou.weapon.p0.Cdo.b.a(r4, r5)     // Catch: java.lang.Throwable -> L46
            monitor-exit(r0)
            return
        L22:
            r2 = 24
            if (r1 != r2) goto L31
            com.kuaishou.weapon.p0.Cdo.c.a(r4, r5)     // Catch: java.lang.Throwable -> L2b
            monitor-exit(r0)
            return
        L2b:
            r1 = move-exception
            com.kuaishou.weapon.p0.Cdo.a.a(r4, r5)     // Catch: java.lang.Throwable -> L30
            goto L3e
        L30:
            throw r1     // Catch: java.lang.Throwable -> L46
        L31:
            r2 = 23
            if (r1 < r2) goto L41
            com.kuaishou.weapon.p0.Cdo.b.a(r4, r5)     // Catch: java.lang.Throwable -> L3a
            monitor-exit(r0)
            return
        L3a:
            r1 = move-exception
            com.kuaishou.weapon.p0.Cdo.a.a(r4, r5)     // Catch: java.lang.Throwable -> L40
        L3e:
            monitor-exit(r0)
            return
        L40:
            throw r1     // Catch: java.lang.Throwable -> L46
        L41:
            com.kuaishou.weapon.p0.Cdo.a.a(r4, r5)     // Catch: java.lang.Throwable -> L46
            monitor-exit(r0)
            return
        L46:
            r4 = move-exception
            monitor-exit(r0)
            throw r4
        L49:
            monitor-exit(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kuaishou.weapon.p0.Cdo.a(java.lang.ClassLoader, java.io.File):void");
    }
}

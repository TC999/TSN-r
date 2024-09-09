package com.kwad.library.solder.lib.ext;

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
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class d {

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    static final class a {
        /* JADX INFO: Access modifiers changed from: private */
        public static void d(ClassLoader classLoader, File file) {
            Object obj = com.kwad.library.solder.lib.ext.e.c(classLoader, "pathList").get(classLoader);
            Field c4 = com.kwad.library.solder.lib.ext.e.c(obj, "nativeLibraryDirectories");
            File[] fileArr = (File[]) c4.get(obj);
            ArrayList arrayList = new ArrayList();
            for (File file2 : fileArr) {
                if (!file.equals(file2)) {
                    arrayList.add(file2);
                }
            }
            arrayList.add(file);
            c4.set(obj, arrayList.toArray(new File[0]));
        }

        static /* synthetic */ void e(ClassLoader classLoader, File file) {
            d(classLoader, file);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    static final class b {
        /* JADX INFO: Access modifiers changed from: private */
        public static void d(ClassLoader classLoader, File file) {
            Object obj = com.kwad.library.solder.lib.ext.e.c(classLoader, "pathList").get(classLoader);
            Field c4 = com.kwad.library.solder.lib.ext.e.c(obj, "nativeLibraryDirectories");
            Collection collection = (List) c4.get(obj);
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
            c4.set(obj, arrayList);
            if (c4.get(obj) != arrayList) {
                com.kwad.library.solder.lib.ext.e.d(obj, "nativeLibraryDirectories").set(obj, arrayList);
            }
            List list = (List) com.kwad.library.solder.lib.ext.e.c(obj, "systemNativeLibraryDirectories").get(obj);
            if (list == null) {
                list = new ArrayList(2);
            }
            ArrayList arrayList2 = new ArrayList(arrayList.size() + list.size() + 1);
            arrayList2.addAll(arrayList);
            arrayList2.addAll(list);
            Object[] objArr = (Object[]) com.kwad.library.solder.lib.ext.e.b(obj, "makePathElements", List.class, File.class, List.class).invoke(obj, arrayList2, null, new ArrayList());
            Field c5 = com.kwad.library.solder.lib.ext.e.c(obj, "nativeLibraryPathElements");
            c5.set(obj, objArr);
            if (c5.get(obj) != objArr) {
                com.kwad.library.solder.lib.ext.e.d(obj, "nativeLibraryPathElements").set(obj, objArr);
            }
        }

        static /* synthetic */ void f(ClassLoader classLoader, File file) {
            d(classLoader, file);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    static final class c {
        /* JADX INFO: Access modifiers changed from: private */
        public static void d(ClassLoader classLoader, File file) {
            Object obj = com.kwad.library.solder.lib.ext.e.c(classLoader, "pathList").get(classLoader);
            List<File> list = (List) com.kwad.library.solder.lib.ext.e.c(obj, "nativeLibraryDirectories").get(obj);
            if (list == null) {
                list = new ArrayList(2);
            }
            for (File file2 : list) {
                if (file.equals(file2)) {
                    return;
                }
            }
            list.add(file);
            List list2 = (List) com.kwad.library.solder.lib.ext.e.c(obj, "systemNativeLibraryDirectories").get(obj);
            if (list2 == null) {
                list2 = new ArrayList(2);
            }
            ArrayList arrayList = new ArrayList(list.size() + list2.size() + 1);
            arrayList.addAll(list);
            arrayList.addAll(list2);
            com.kwad.library.solder.lib.ext.e.c(obj, "nativeLibraryPathElements").set(obj, (Object[]) com.kwad.library.solder.lib.ext.e.b(obj, "makePathElements", List.class, File.class, List.class).invoke(obj, arrayList, null, new ArrayList()));
        }

        static /* synthetic */ void g(ClassLoader classLoader, File file) {
            d(classLoader, file);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* renamed from: com.kwad.library.solder.lib.ext.d$d  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    static final class C0680d {
        /* JADX INFO: Access modifiers changed from: private */
        public static void d(ClassLoader classLoader, File file) {
            Object obj = com.kwad.library.solder.lib.ext.e.c(classLoader, "pathList").get(classLoader);
            List<File> list = (List) com.kwad.library.solder.lib.ext.e.c(obj, "nativeLibraryDirectories").get(obj);
            if (list == null) {
                list = new ArrayList(2);
            }
            for (File file2 : list) {
                if (file.equals(file2)) {
                    return;
                }
            }
            list.add(file);
            List list2 = (List) com.kwad.library.solder.lib.ext.e.c(obj, "systemNativeLibraryDirectories").get(obj);
            if (list2 == null) {
                list2 = new ArrayList(2);
            }
            ArrayList arrayList = new ArrayList(list.size() + list2.size() + 1);
            arrayList.addAll(list);
            arrayList.addAll(list2);
            com.kwad.library.solder.lib.ext.e.c(obj, "nativeLibraryPathElements").set(obj, (Object[]) com.kwad.library.solder.lib.ext.e.b(obj, "makePathElements", List.class).invoke(obj, arrayList));
        }

        static /* synthetic */ void h(ClassLoader classLoader, File file) {
            d(classLoader, file);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    static final class e {
        /* JADX INFO: Access modifiers changed from: private */
        public static void d(ClassLoader classLoader, File file) {
            String path = file.getPath();
            Field c4 = com.kwad.library.solder.lib.ext.e.c(classLoader, "libPath");
            String valueOf = String.valueOf(c4.get(classLoader));
            c4.set(classLoader, TextUtils.isEmpty(valueOf) ? path : valueOf + ":" + path);
            Field c5 = com.kwad.library.solder.lib.ext.e.c(classLoader, "libraryPathElements");
            List<String> list = (List) c5.get(classLoader);
            for (String str : list) {
                if (path.equals(str)) {
                    return;
                }
            }
            list.add(path);
            c5.set(classLoader, list);
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:39:0x0094
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:81)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:47)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    public static synchronized void c(java.lang.ClassLoader r8, java.io.File r9) {
        /*
            java.lang.Class<com.kwad.library.solder.lib.ext.d> r0 = com.kwad.library.solder.lib.ext.d.class
            monitor-enter(r0)
            r1 = 0
            r2 = 1
            if (r9 == 0) goto L9c
            boolean r3 = r9.exists()     // Catch: java.lang.Throwable -> Lad
            if (r3 != 0) goto Lf
            goto L9c
        Lf:
            int r3 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Throwable -> Lad
            r4 = 25
            r5 = 2
            if (r3 != r4) goto L1a
            int r6 = android.os.Build.VERSION.PREVIEW_SDK_INT     // Catch: java.lang.Throwable -> Lad
            if (r6 != 0) goto L1c
        L1a:
            if (r3 <= r4) goto L42
        L1c:
            com.kwad.library.solder.lib.ext.d.C0680d.h(r8, r9)     // Catch: java.lang.Throwable -> L21
            monitor-exit(r0)
            return
        L21:
            r3 = move-exception
            java.lang.String r4 = "Sodler.ShareLibraryLoader"
            java.lang.String r6 = "installNativeLibraryPath, v25 fail, sdk: %d, error: %s, try to fallback to V23"
            java.lang.Object[] r5 = new java.lang.Object[r5]     // Catch: java.lang.Throwable -> Lad
            int r7 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Throwable -> Lad
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)     // Catch: java.lang.Throwable -> Lad
            r5[r1] = r7     // Catch: java.lang.Throwable -> Lad
            java.lang.String r1 = r3.getMessage()     // Catch: java.lang.Throwable -> Lad
            r5[r2] = r1     // Catch: java.lang.Throwable -> Lad
            java.lang.String r1 = java.lang.String.format(r6, r5)     // Catch: java.lang.Throwable -> Lad
            com.kwad.library.solder.lib.a.e(r4, r1)     // Catch: java.lang.Throwable -> Lad
            com.kwad.library.solder.lib.ext.d.b.f(r8, r9)     // Catch: java.lang.Throwable -> Lad
            monitor-exit(r0)
            return
        L42:
            r4 = 24
            if (r3 != r4) goto L6c
            com.kwad.library.solder.lib.ext.d.c.g(r8, r9)     // Catch: java.lang.Throwable -> L4b
            monitor-exit(r0)
            return
        L4b:
            r3 = move-exception
            java.lang.String r4 = "Sodler.ShareLibraryLoader"
            java.lang.String r6 = "installNativeLibraryPath, v23 fail, sdk: %d, error: %s, try to fallback to V14"
            java.lang.Object[] r5 = new java.lang.Object[r5]     // Catch: java.lang.Throwable -> Lad
            int r7 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Throwable -> Lad
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)     // Catch: java.lang.Throwable -> Lad
            r5[r1] = r7     // Catch: java.lang.Throwable -> Lad
            java.lang.String r1 = r3.getMessage()     // Catch: java.lang.Throwable -> Lad
            r5[r2] = r1     // Catch: java.lang.Throwable -> Lad
            java.lang.String r1 = java.lang.String.format(r6, r5)     // Catch: java.lang.Throwable -> Lad
            com.kwad.library.solder.lib.a.e(r4, r1)     // Catch: java.lang.Throwable -> Lad
            com.kwad.library.solder.lib.ext.d.a.e(r8, r9)     // Catch: java.lang.Throwable -> L6b
            goto L94
        L6b:
            throw r3     // Catch: java.lang.Throwable -> Lad
        L6c:
            r4 = 23
            if (r3 < r4) goto L97
            com.kwad.library.solder.lib.ext.d.b.f(r8, r9)     // Catch: java.lang.Throwable -> L75
            monitor-exit(r0)
            return
        L75:
            r3 = move-exception
            java.lang.String r4 = "Sodler.ShareLibraryLoader"
            java.lang.String r6 = "installNativeLibraryPath, v23 fail, sdk: %d, error: %s, try to fallback to V14"
            java.lang.Object[] r5 = new java.lang.Object[r5]     // Catch: java.lang.Throwable -> Lad
            int r7 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Throwable -> Lad
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)     // Catch: java.lang.Throwable -> Lad
            r5[r1] = r7     // Catch: java.lang.Throwable -> Lad
            java.lang.String r1 = r3.getMessage()     // Catch: java.lang.Throwable -> Lad
            r5[r2] = r1     // Catch: java.lang.Throwable -> Lad
            java.lang.String r1 = java.lang.String.format(r6, r5)     // Catch: java.lang.Throwable -> Lad
            com.kwad.library.solder.lib.a.e(r4, r1)     // Catch: java.lang.Throwable -> Lad
            com.kwad.library.solder.lib.ext.d.a.e(r8, r9)     // Catch: java.lang.Throwable -> L96
        L94:
            monitor-exit(r0)
            return
        L96:
            throw r3     // Catch: java.lang.Throwable -> Lad
        L97:
            com.kwad.library.solder.lib.ext.d.a.e(r8, r9)     // Catch: java.lang.Throwable -> Lad
            monitor-exit(r0)
            return
        L9c:
            java.lang.String r8 = "Sodler.ShareLibraryLoader"
            java.lang.String r3 = "installNativeLibraryPath, folder %s is illegal"
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch: java.lang.Throwable -> Lad
            r2[r1] = r9     // Catch: java.lang.Throwable -> Lad
            java.lang.String r9 = java.lang.String.format(r3, r2)     // Catch: java.lang.Throwable -> Lad
            com.kwad.library.solder.lib.a.e(r8, r9)     // Catch: java.lang.Throwable -> Lad
            monitor-exit(r0)
            return
        Lad:
            r8 = move-exception
            monitor-exit(r0)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.library.solder.lib.ext.d.c(java.lang.ClassLoader, java.io.File):void");
    }
}

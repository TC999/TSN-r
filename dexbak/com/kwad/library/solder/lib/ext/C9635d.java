package com.kwad.library.solder.lib.ext;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import java.io.File;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@SuppressLint({"LongLogTag"})
/* renamed from: com.kwad.library.solder.lib.ext.d */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9635d {

    /* renamed from: com.kwad.library.solder.lib.ext.d$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    static final class C9636a {
        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: d */
        public static void m28138d(ClassLoader classLoader, File file) {
            Object obj = C9641e.m28127c(classLoader, "pathList").get(classLoader);
            Field m28127c = C9641e.m28127c(obj, "nativeLibraryDirectories");
            File[] fileArr = (File[]) m28127c.get(obj);
            ArrayList arrayList = new ArrayList();
            for (File file2 : fileArr) {
                if (!file.equals(file2)) {
                    arrayList.add(file2);
                }
            }
            arrayList.add(file);
            m28127c.set(obj, arrayList.toArray(new File[0]));
        }

        /* renamed from: e */
        static /* synthetic */ void m28137e(ClassLoader classLoader, File file) {
            m28138d(classLoader, file);
        }
    }

    /* renamed from: com.kwad.library.solder.lib.ext.d$b */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    static final class C9637b {
        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: d */
        public static void m28136d(ClassLoader classLoader, File file) {
            Object obj = C9641e.m28127c(classLoader, "pathList").get(classLoader);
            Field m28127c = C9641e.m28127c(obj, "nativeLibraryDirectories");
            Collection collection = (List) m28127c.get(obj);
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
            m28127c.set(obj, arrayList);
            if (m28127c.get(obj) != arrayList) {
                C9641e.m28126d(obj, "nativeLibraryDirectories").set(obj, arrayList);
            }
            List list = (List) C9641e.m28127c(obj, "systemNativeLibraryDirectories").get(obj);
            if (list == null) {
                list = new ArrayList(2);
            }
            ArrayList arrayList2 = new ArrayList(arrayList.size() + list.size() + 1);
            arrayList2.addAll(arrayList);
            arrayList2.addAll(list);
            Object[] objArr = (Object[]) C9641e.m28128b(obj, "makePathElements", List.class, File.class, List.class).invoke(obj, arrayList2, null, new ArrayList());
            Field m28127c2 = C9641e.m28127c(obj, "nativeLibraryPathElements");
            m28127c2.set(obj, objArr);
            if (m28127c2.get(obj) != objArr) {
                C9641e.m28126d(obj, "nativeLibraryPathElements").set(obj, objArr);
            }
        }

        /* renamed from: f */
        static /* synthetic */ void m28135f(ClassLoader classLoader, File file) {
            m28136d(classLoader, file);
        }
    }

    /* renamed from: com.kwad.library.solder.lib.ext.d$c */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    static final class C9638c {
        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: d */
        public static void m28134d(ClassLoader classLoader, File file) {
            Object obj = C9641e.m28127c(classLoader, "pathList").get(classLoader);
            List<File> list = (List) C9641e.m28127c(obj, "nativeLibraryDirectories").get(obj);
            if (list == null) {
                list = new ArrayList(2);
            }
            for (File file2 : list) {
                if (file.equals(file2)) {
                    return;
                }
            }
            list.add(file);
            List list2 = (List) C9641e.m28127c(obj, "systemNativeLibraryDirectories").get(obj);
            if (list2 == null) {
                list2 = new ArrayList(2);
            }
            ArrayList arrayList = new ArrayList(list.size() + list2.size() + 1);
            arrayList.addAll(list);
            arrayList.addAll(list2);
            C9641e.m28127c(obj, "nativeLibraryPathElements").set(obj, (Object[]) C9641e.m28128b(obj, "makePathElements", List.class, File.class, List.class).invoke(obj, arrayList, null, new ArrayList()));
        }

        /* renamed from: g */
        static /* synthetic */ void m28133g(ClassLoader classLoader, File file) {
            m28134d(classLoader, file);
        }
    }

    /* renamed from: com.kwad.library.solder.lib.ext.d$d */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    static final class C9639d {
        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: d */
        public static void m28132d(ClassLoader classLoader, File file) {
            Object obj = C9641e.m28127c(classLoader, "pathList").get(classLoader);
            List<File> list = (List) C9641e.m28127c(obj, "nativeLibraryDirectories").get(obj);
            if (list == null) {
                list = new ArrayList(2);
            }
            for (File file2 : list) {
                if (file.equals(file2)) {
                    return;
                }
            }
            list.add(file);
            List list2 = (List) C9641e.m28127c(obj, "systemNativeLibraryDirectories").get(obj);
            if (list2 == null) {
                list2 = new ArrayList(2);
            }
            ArrayList arrayList = new ArrayList(list.size() + list2.size() + 1);
            arrayList.addAll(list);
            arrayList.addAll(list2);
            C9641e.m28127c(obj, "nativeLibraryPathElements").set(obj, (Object[]) C9641e.m28128b(obj, "makePathElements", List.class).invoke(obj, arrayList));
        }

        /* renamed from: h */
        static /* synthetic */ void m28131h(ClassLoader classLoader, File file) {
            m28132d(classLoader, file);
        }
    }

    /* renamed from: com.kwad.library.solder.lib.ext.d$e */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    static final class C9640e {
        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: d */
        public static void m28130d(ClassLoader classLoader, File file) {
            String path = file.getPath();
            Field m28127c = C9641e.m28127c(classLoader, "libPath");
            String valueOf = String.valueOf(m28127c.get(classLoader));
            m28127c.set(classLoader, TextUtils.isEmpty(valueOf) ? path : valueOf + ":" + path);
            Field m28127c2 = C9641e.m28127c(classLoader, "libraryPathElements");
            List<String> list = (List) m28127c2.get(classLoader);
            for (String str : list) {
                if (path.equals(str)) {
                    return;
                }
            }
            list.add(path);
            m28127c2.set(classLoader, list);
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:39:0x0094
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:81)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:47)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    /* renamed from: c */
    public static synchronized void m28139c(java.lang.ClassLoader r8, java.io.File r9) {
        /*
            java.lang.Class<com.kwad.library.solder.lib.ext.d> r0 = com.kwad.library.solder.lib.ext.C9635d.class
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
            com.kwad.library.solder.lib.ext.C9635d.C9639d.m28131h(r8, r9)     // Catch: java.lang.Throwable -> L21
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
            com.kwad.library.solder.lib.C9603a.m28252e(r4, r1)     // Catch: java.lang.Throwable -> Lad
            com.kwad.library.solder.lib.ext.C9635d.C9637b.m28135f(r8, r9)     // Catch: java.lang.Throwable -> Lad
            monitor-exit(r0)
            return
        L42:
            r4 = 24
            if (r3 != r4) goto L6c
            com.kwad.library.solder.lib.ext.C9635d.C9638c.m28133g(r8, r9)     // Catch: java.lang.Throwable -> L4b
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
            com.kwad.library.solder.lib.C9603a.m28252e(r4, r1)     // Catch: java.lang.Throwable -> Lad
            com.kwad.library.solder.lib.ext.C9635d.C9636a.m28137e(r8, r9)     // Catch: java.lang.Throwable -> L6b
            goto L94
        L6b:
            throw r3     // Catch: java.lang.Throwable -> Lad
        L6c:
            r4 = 23
            if (r3 < r4) goto L97
            com.kwad.library.solder.lib.ext.C9635d.C9637b.m28135f(r8, r9)     // Catch: java.lang.Throwable -> L75
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
            com.kwad.library.solder.lib.C9603a.m28252e(r4, r1)     // Catch: java.lang.Throwable -> Lad
            com.kwad.library.solder.lib.ext.C9635d.C9636a.m28137e(r8, r9)     // Catch: java.lang.Throwable -> L96
        L94:
            monitor-exit(r0)
            return
        L96:
            throw r3     // Catch: java.lang.Throwable -> Lad
        L97:
            com.kwad.library.solder.lib.ext.C9635d.C9636a.m28137e(r8, r9)     // Catch: java.lang.Throwable -> Lad
            monitor-exit(r0)
            return
        L9c:
            java.lang.String r8 = "Sodler.ShareLibraryLoader"
            java.lang.String r3 = "installNativeLibraryPath, folder %s is illegal"
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch: java.lang.Throwable -> Lad
            r2[r1] = r9     // Catch: java.lang.Throwable -> Lad
            java.lang.String r9 = java.lang.String.format(r3, r2)     // Catch: java.lang.Throwable -> Lad
            com.kwad.library.solder.lib.C9603a.m28252e(r8, r9)     // Catch: java.lang.Throwable -> Lad
            monitor-exit(r0)
            return
        Lad:
            r8 = move-exception
            monitor-exit(r0)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.library.solder.lib.ext.C9635d.m28139c(java.lang.ClassLoader, java.io.File):void");
    }
}

package com.kuaishou.weapon.p205p0;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import java.io.File;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@SuppressLint({"LongLogTag"})
/* renamed from: com.kuaishou.weapon.p0.do */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C7272do {

    /* renamed from: com.kuaishou.weapon.p0.do$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    static final class C7273a {
        private C7273a() {
        }

        /* renamed from: a */
        static /* synthetic */ void m33931a(ClassLoader classLoader, File file) {
            m33930b(classLoader, file);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: b */
        public static void m33930b(ClassLoader classLoader, File file) {
            Object obj = C7279dq.m33911a(classLoader, "pathList").get(classLoader);
            Field m33911a = C7279dq.m33911a(obj, "nativeLibraryDirectories");
            File[] fileArr = (File[]) m33911a.get(obj);
            ArrayList arrayList = new ArrayList();
            for (File file2 : fileArr) {
                if (!file.equals(file2)) {
                    arrayList.add(file2);
                }
            }
            arrayList.add(file);
            m33911a.set(obj, arrayList.toArray(new File[0]));
        }
    }

    /* renamed from: com.kuaishou.weapon.p0.do$b */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    static final class C7274b {
        private C7274b() {
        }

        /* renamed from: a */
        static /* synthetic */ void m33929a(ClassLoader classLoader, File file) {
            m33928b(classLoader, file);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: b */
        public static void m33928b(ClassLoader classLoader, File file) {
            Object obj = C7279dq.m33911a(classLoader, "pathList").get(classLoader);
            Field m33911a = C7279dq.m33911a(obj, "nativeLibraryDirectories");
            Collection collection = (List) m33911a.get(obj);
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
            m33911a.set(obj, arrayList);
            if (m33911a.get(obj) != arrayList) {
                C7279dq.m33909b(obj, "nativeLibraryDirectories").set(obj, arrayList);
            }
            List list = (List) C7279dq.m33911a(obj, "systemNativeLibraryDirectories").get(obj);
            if (list == null) {
                list = new ArrayList(2);
            }
            ArrayList arrayList2 = new ArrayList(arrayList.size() + list.size() + 1);
            arrayList2.addAll(arrayList);
            arrayList2.addAll(list);
            Object[] objArr = (Object[]) C7279dq.m33910a(obj, "makePathElements", List.class, File.class, List.class).invoke(obj, arrayList2, null, new ArrayList());
            Field m33911a2 = C7279dq.m33911a(obj, "nativeLibraryPathElements");
            m33911a2.set(obj, objArr);
            if (m33911a2.get(obj) != objArr) {
                C7279dq.m33909b(obj, "nativeLibraryPathElements").set(obj, objArr);
            }
        }
    }

    /* renamed from: com.kuaishou.weapon.p0.do$c */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    static final class C7275c {
        private C7275c() {
        }

        /* renamed from: a */
        static /* synthetic */ void m33927a(ClassLoader classLoader, File file) {
            m33926b(classLoader, file);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: b */
        public static void m33926b(ClassLoader classLoader, File file) {
            Object obj = C7279dq.m33911a(classLoader, "pathList").get(classLoader);
            List<File> list = (List) C7279dq.m33911a(obj, "nativeLibraryDirectories").get(obj);
            if (list == null) {
                list = new ArrayList(2);
            }
            for (File file2 : list) {
                if (file.equals(file2)) {
                    return;
                }
            }
            list.add(file);
            List list2 = (List) C7279dq.m33911a(obj, "systemNativeLibraryDirectories").get(obj);
            if (list2 == null) {
                list2 = new ArrayList(2);
            }
            ArrayList arrayList = new ArrayList(list.size() + list2.size() + 1);
            arrayList.addAll(list);
            arrayList.addAll(list2);
            C7279dq.m33911a(obj, "nativeLibraryPathElements").set(obj, (Object[]) C7279dq.m33910a(obj, "makePathElements", List.class, File.class, List.class).invoke(obj, arrayList, null, new ArrayList()));
        }
    }

    /* renamed from: com.kuaishou.weapon.p0.do$d */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    static final class C7276d {
        private C7276d() {
        }

        /* renamed from: a */
        static /* synthetic */ void m33925a(ClassLoader classLoader, File file) {
            m33924b(classLoader, file);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: b */
        public static void m33924b(ClassLoader classLoader, File file) {
            Object obj = C7279dq.m33911a(classLoader, "pathList").get(classLoader);
            List<File> list = (List) C7279dq.m33911a(obj, "nativeLibraryDirectories").get(obj);
            if (list == null) {
                list = new ArrayList(2);
            }
            for (File file2 : list) {
                if (file.equals(file2)) {
                    return;
                }
            }
            list.add(file);
            List list2 = (List) C7279dq.m33911a(obj, "systemNativeLibraryDirectories").get(obj);
            if (list2 == null) {
                list2 = new ArrayList(2);
            }
            ArrayList arrayList = new ArrayList(list.size() + list2.size() + 1);
            arrayList.addAll(list);
            arrayList.addAll(list2);
            C7279dq.m33911a(obj, "nativeLibraryPathElements").set(obj, (Object[]) C7279dq.m33910a(obj, "makePathElements", List.class).invoke(obj, arrayList));
        }
    }

    /* renamed from: com.kuaishou.weapon.p0.do$e */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    static final class C7277e {
        private C7277e() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: b */
        public static void m33922b(ClassLoader classLoader, File file) {
            String path = file.getPath();
            Field m33911a = C7279dq.m33911a(classLoader, "libPath");
            String valueOf = String.valueOf(m33911a.get(classLoader));
            m33911a.set(classLoader, TextUtils.isEmpty(valueOf) ? path : valueOf + ":" + path);
            Field m33911a2 = C7279dq.m33911a(classLoader, "libraryPathElements");
            List<String> list = (List) m33911a2.get(classLoader);
            for (String str : list) {
                if (path.equals(str)) {
                    return;
                }
            }
            list.add(path);
            m33911a2.set(classLoader, list);
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:35:0x003e
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:81)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:47)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    /* renamed from: a */
    public static synchronized void m33932a(java.lang.ClassLoader r4, java.io.File r5) {
        /*
            java.lang.Class<com.kuaishou.weapon.p0.do> r0 = com.kuaishou.weapon.p205p0.C7272do.class
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
            com.kuaishou.weapon.p205p0.C7272do.C7276d.m33925a(r4, r5)     // Catch: java.lang.Throwable -> L1d
            monitor-exit(r0)
            return
        L1d:
            com.kuaishou.weapon.p205p0.C7272do.C7274b.m33929a(r4, r5)     // Catch: java.lang.Throwable -> L46
            monitor-exit(r0)
            return
        L22:
            r2 = 24
            if (r1 != r2) goto L31
            com.kuaishou.weapon.p205p0.C7272do.C7275c.m33927a(r4, r5)     // Catch: java.lang.Throwable -> L2b
            monitor-exit(r0)
            return
        L2b:
            r1 = move-exception
            com.kuaishou.weapon.p205p0.C7272do.C7273a.m33931a(r4, r5)     // Catch: java.lang.Throwable -> L30
            goto L3e
        L30:
            throw r1     // Catch: java.lang.Throwable -> L46
        L31:
            r2 = 23
            if (r1 < r2) goto L41
            com.kuaishou.weapon.p205p0.C7272do.C7274b.m33929a(r4, r5)     // Catch: java.lang.Throwable -> L3a
            monitor-exit(r0)
            return
        L3a:
            r1 = move-exception
            com.kuaishou.weapon.p205p0.C7272do.C7273a.m33931a(r4, r5)     // Catch: java.lang.Throwable -> L40
        L3e:
            monitor-exit(r0)
            return
        L40:
            throw r1     // Catch: java.lang.Throwable -> L46
        L41:
            com.kuaishou.weapon.p205p0.C7272do.C7273a.m33931a(r4, r5)     // Catch: java.lang.Throwable -> L46
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
        throw new UnsupportedOperationException("Method not decompiled: com.kuaishou.weapon.p205p0.C7272do.m33932a(java.lang.ClassLoader, java.io.File):void");
    }
}

package com.bytedance.pangle.dex;

import com.bytedance.pangle.p119d.C6081c;
import com.bytedance.pangle.p120e.C6096b;
import com.bytedance.pangle.p120e.C6106g;
import com.bytedance.pangle.util.FieldUtils;
import dalvik.system.DexFile;
import java.io.File;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.ArrayList;

/* renamed from: com.bytedance.pangle.dex.a */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class C6086a {

    /* renamed from: a */
    private static volatile int f21927a;

    /* renamed from: b */
    private static volatile Constructor<?> f21928b;

    /* renamed from: a */
    public static void m37209a(ClassLoader classLoader, String str, int i) {
        Object obj = FieldUtils.getField(classLoader.getClass(), "pathList").get(classLoader);
        ArrayList arrayList = new ArrayList();
        String[] split = C6106g.m37179a(str, i).split(":");
        String m37226c = C6081c.m37226c(str, i);
        for (String str2 : split) {
            Object native_load_direct_dex = DirectDex.native_load_direct_dex(str2);
            if (native_load_direct_dex == null) {
                native_load_direct_dex = DexFile.loadDex(str2, m37226c + File.separator + C6096b.m37197a(str2), 0);
            }
            arrayList.add(m37210a(new File(str2), native_load_direct_dex));
        }
        Object[] array = arrayList.toArray();
        Field field = FieldUtils.getField(obj.getClass(), "dexElements");
        Object[] objArr = (Object[]) field.get(obj);
        Object[] objArr2 = (Object[]) Array.newInstance(objArr.getClass().getComponentType(), objArr.length + array.length);
        System.arraycopy(objArr, 0, objArr2, 0, objArr.length);
        System.arraycopy(array, 0, objArr2, objArr.length, array.length);
        field.set(obj, objArr2);
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0037 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0051 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x006b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0018 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.Object m37210a(java.io.File r11, java.lang.Object r12) {
        /*
            int r0 = com.bytedance.pangle.dex.C6086a.f21927a
            java.lang.reflect.Constructor<?> r1 = com.bytedance.pangle.dex.C6086a.f21928b
            r2 = 0
            if (r1 != 0) goto Le
            java.lang.String r3 = "dalvik.system.DexPathList$Element"
            java.lang.Class r3 = java.lang.Class.forName(r3)     // Catch: java.lang.Exception -> Le
            goto Lf
        Le:
            r3 = r2
        Lf:
            r4 = 8
            r5 = 4
            r6 = 0
            r7 = 3
            r8 = 2
            r9 = 1
            if (r1 != 0) goto L35
            java.lang.Class[] r1 = new java.lang.Class[r5]     // Catch: java.lang.Exception -> L34
            java.lang.Class<java.io.File> r10 = java.io.File.class
            r1[r6] = r10     // Catch: java.lang.Exception -> L34
            java.lang.Class r10 = java.lang.Boolean.TYPE     // Catch: java.lang.Exception -> L34
            r1[r9] = r10     // Catch: java.lang.Exception -> L34
            java.lang.Class<java.io.File> r10 = java.io.File.class
            r1[r8] = r10     // Catch: java.lang.Exception -> L34
            java.lang.Class<dalvik.system.DexFile> r10 = dalvik.system.DexFile.class
            r1[r7] = r10     // Catch: java.lang.Exception -> L34
            java.lang.reflect.Constructor r1 = r3.getConstructor(r1)     // Catch: java.lang.Exception -> L34
            r1.setAccessible(r9)     // Catch: java.lang.Exception -> L34
            r0 = 8
            goto L35
        L34:
            r1 = r2
        L35:
            if (r1 != 0) goto L4f
            java.lang.Class[] r1 = new java.lang.Class[r7]     // Catch: java.lang.Exception -> L4e
            java.lang.Class<java.io.File> r10 = java.io.File.class
            r1[r6] = r10     // Catch: java.lang.Exception -> L4e
            java.lang.Class<java.util.zip.ZipFile> r10 = java.util.zip.ZipFile.class
            r1[r9] = r10     // Catch: java.lang.Exception -> L4e
            java.lang.Class<dalvik.system.DexFile> r10 = dalvik.system.DexFile.class
            r1[r8] = r10     // Catch: java.lang.Exception -> L4e
            java.lang.reflect.Constructor r1 = r3.getConstructor(r1)     // Catch: java.lang.Exception -> L4e
            r1.setAccessible(r9)     // Catch: java.lang.Exception -> L4e
            r0 = 4
            goto L4f
        L4e:
            r1 = r2
        L4f:
            if (r1 != 0) goto L69
            java.lang.Class[] r1 = new java.lang.Class[r7]     // Catch: java.lang.Exception -> L68
            java.lang.Class<java.io.File> r10 = java.io.File.class
            r1[r6] = r10     // Catch: java.lang.Exception -> L68
            java.lang.Class<java.io.File> r10 = java.io.File.class
            r1[r9] = r10     // Catch: java.lang.Exception -> L68
            java.lang.Class<dalvik.system.DexFile> r10 = dalvik.system.DexFile.class
            r1[r8] = r10     // Catch: java.lang.Exception -> L68
            java.lang.reflect.Constructor r1 = r3.getConstructor(r1)     // Catch: java.lang.Exception -> L68
            r1.setAccessible(r9)     // Catch: java.lang.Exception -> L68
            r0 = 2
            goto L69
        L68:
            r1 = r2
        L69:
            if (r1 != 0) goto L87
            java.lang.Class[] r1 = new java.lang.Class[r5]     // Catch: java.lang.Exception -> L86
            java.lang.Class<java.io.File> r10 = java.io.File.class
            r1[r6] = r10     // Catch: java.lang.Exception -> L86
            java.lang.Class r10 = java.lang.Boolean.TYPE     // Catch: java.lang.Exception -> L86
            r1[r9] = r10     // Catch: java.lang.Exception -> L86
            java.lang.Class<java.io.File> r10 = java.io.File.class
            r1[r8] = r10     // Catch: java.lang.Exception -> L86
            java.lang.Class<dalvik.system.DexFile> r10 = dalvik.system.DexFile.class
            r1[r7] = r10     // Catch: java.lang.Exception -> L86
            java.lang.reflect.Constructor r1 = r3.getConstructor(r1)     // Catch: java.lang.Exception -> L86
            r1.setAccessible(r9)     // Catch: java.lang.Exception -> L86
            r0 = 1
            goto L87
        L86:
            r1 = r2
        L87:
            com.bytedance.pangle.dex.C6086a.f21928b = r1
            com.bytedance.pangle.dex.C6086a.f21927a = r0
            if (r0 == r9) goto La1
            if (r0 == r8) goto L94
            if (r0 == r5) goto L94
            if (r0 == r4) goto La1
            goto Lb1
        L94:
            java.lang.Object[] r0 = new java.lang.Object[r7]
            r0[r6] = r11
            r0[r9] = r2
            r0[r8] = r12
            java.lang.Object r2 = m37208a(r1, r0)
            goto Lb1
        La1:
            java.lang.Object[] r0 = new java.lang.Object[r5]
            r0[r6] = r11
            java.lang.Boolean r11 = java.lang.Boolean.FALSE
            r0[r9] = r11
            r0[r8] = r2
            r0[r7] = r12
            java.lang.Object r2 = m37208a(r1, r0)
        Lb1:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.pangle.dex.C6086a.m37210a(java.io.File, java.lang.Object):java.lang.Object");
    }

    /* renamed from: a */
    private static Object m37208a(Constructor<?> constructor, Object... objArr) {
        try {
            return constructor.newInstance(objArr);
        } catch (Exception unused) {
            return null;
        }
    }
}

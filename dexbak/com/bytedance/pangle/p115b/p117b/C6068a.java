package com.bytedance.pangle.p115b.p117b;

import com.bytedance.pangle.log.ZeusLogger;
import java.lang.reflect.Method;

/* renamed from: com.bytedance.pangle.b.b.a */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class C6068a {

    /* renamed from: a */
    private static Method f21858a;

    /* renamed from: b */
    private static Method f21859b;

    /* renamed from: c */
    private static Method f21860c;

    /* renamed from: d */
    private static Method f21861d;

    static {
        try {
            f21858a = Class.class.getDeclaredMethod("getDeclaredField", String.class);
            f21859b = Class.class.getDeclaredMethod("getDeclaredMethod", String.class, Class[].class);
            f21860c = Class.class.getDeclaredMethod("getDeclaredConstructor", Class[].class);
            f21861d = Class.class.getDeclaredMethod("forName", String.class);
        } catch (Throwable th) {
            ZeusLogger.errReport(ZeusLogger.TAG_INIT, "DoubleReflectorinit failed", th);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0044 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0045  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.reflect.Field m37259a(java.lang.Class<?> r8, java.lang.String r9) {
        /*
            java.lang.reflect.Method r0 = com.bytedance.pangle.p115b.p117b.C6068a.f21858a
            r1 = 0
            if (r0 == 0) goto L42
            r2 = 0
            r3 = 1
            java.lang.Object[] r4 = new java.lang.Object[r3]     // Catch: java.lang.Throwable -> L19
            r4[r2] = r9     // Catch: java.lang.Throwable -> L19
            java.lang.Object r0 = r0.invoke(r8, r4)     // Catch: java.lang.Throwable -> L19
            java.lang.reflect.Field r0 = (java.lang.reflect.Field) r0     // Catch: java.lang.Throwable -> L19
            if (r0 == 0) goto L41
            r0.setAccessible(r3)     // Catch: java.lang.Throwable -> L17
            goto L41
        L17:
            r1 = move-exception
            goto L1d
        L19:
            r0 = move-exception
            r7 = r1
            r1 = r0
            r0 = r7
        L1d:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r5 = "DoubleReflector"
            r4.<init>(r5)
            r5 = 2
            java.lang.Object[] r5 = new java.lang.Object[r5]
            java.lang.String r6 = r8.getName()
            r5[r2] = r6
            r5[r3] = r9
            java.lang.String r2 = "getField %s#%s failed !!!"
            java.lang.String r2 = java.lang.String.format(r2, r5)
            r4.append(r2)
            java.lang.String r2 = r4.toString()
            java.lang.String r3 = "Zeus_pangle"
            com.bytedance.pangle.log.ZeusLogger.m37076w(r3, r2, r1)
        L41:
            r1 = r0
        L42:
            if (r1 == 0) goto L45
            return r1
        L45:
            java.lang.reflect.Field r8 = com.bytedance.pangle.p115b.p116a.C6066a.m37266a(r8, r9)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.pangle.p115b.p117b.C6068a.m37259a(java.lang.Class, java.lang.String):java.lang.reflect.Field");
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0046 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0047  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.reflect.Method m37258a(java.lang.Class<?> r8, java.lang.String r9, java.lang.Class<?>... r10) {
        /*
            java.lang.reflect.Method r0 = com.bytedance.pangle.p115b.p117b.C6068a.f21859b
            r1 = 0
            if (r0 == 0) goto L44
            r2 = 0
            r3 = 2
            r4 = 1
            java.lang.Object[] r5 = new java.lang.Object[r3]     // Catch: java.lang.Throwable -> L1c
            r5[r2] = r9     // Catch: java.lang.Throwable -> L1c
            r5[r4] = r10     // Catch: java.lang.Throwable -> L1c
            java.lang.Object r0 = r0.invoke(r8, r5)     // Catch: java.lang.Throwable -> L1c
            java.lang.reflect.Method r0 = (java.lang.reflect.Method) r0     // Catch: java.lang.Throwable -> L1c
            if (r0 == 0) goto L43
            r0.setAccessible(r4)     // Catch: java.lang.Throwable -> L1a
            goto L43
        L1a:
            r1 = move-exception
            goto L20
        L1c:
            r0 = move-exception
            r7 = r1
            r1 = r0
            r0 = r7
        L20:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r6 = "DoubleReflector"
            r5.<init>(r6)
            java.lang.Object[] r3 = new java.lang.Object[r3]
            java.lang.String r6 = r8.getName()
            r3[r2] = r6
            r3[r4] = r9
            java.lang.String r2 = "getMethod %s#%s failed !!!"
            java.lang.String r2 = java.lang.String.format(r2, r3)
            r5.append(r2)
            java.lang.String r2 = r5.toString()
            java.lang.String r3 = "Zeus_pangle"
            com.bytedance.pangle.log.ZeusLogger.m37076w(r3, r2, r1)
        L43:
            r1 = r0
        L44:
            if (r1 == 0) goto L47
            return r1
        L47:
            java.lang.reflect.Method r8 = com.bytedance.pangle.p115b.p116a.C6066a.m37265a(r8, r9, r10)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.pangle.p115b.p117b.C6068a.m37258a(java.lang.Class, java.lang.String, java.lang.Class[]):java.lang.reflect.Method");
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x003d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:12:0x003e  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.reflect.Constructor m37257a(java.lang.Class<?> r6, java.lang.Class<?>... r7) {
        /*
            java.lang.reflect.Method r0 = com.bytedance.pangle.p115b.p117b.C6068a.f21860c
            if (r0 == 0) goto L3a
            r1 = 0
            r2 = 1
            java.lang.Object[] r3 = new java.lang.Object[r2]     // Catch: java.lang.Throwable -> L11
            r3[r1] = r7     // Catch: java.lang.Throwable -> L11
            java.lang.Object r0 = r0.invoke(r6, r3)     // Catch: java.lang.Throwable -> L11
            java.lang.reflect.Constructor r0 = (java.lang.reflect.Constructor) r0     // Catch: java.lang.Throwable -> L11
            goto L3b
        L11:
            r0 = move-exception
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "DoubleReflector"
            r3.<init>(r4)
            r4 = 2
            java.lang.Object[] r4 = new java.lang.Object[r4]
            java.lang.String r5 = r6.getName()
            r4[r1] = r5
            java.lang.Integer r1 = java.lang.Integer.valueOf(r2)
            r4[r2] = r1
            java.lang.String r1 = "getConstructor %s<init>%s failed !!!"
            java.lang.String r1 = java.lang.String.format(r1, r4)
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            java.lang.String r2 = "Zeus_pangle"
            com.bytedance.pangle.log.ZeusLogger.m37076w(r2, r1, r0)
        L3a:
            r0 = 0
        L3b:
            if (r0 == 0) goto L3e
            return r0
        L3e:
            java.lang.reflect.Constructor r6 = com.bytedance.pangle.p115b.p116a.C6066a.m37264a(r6, r7)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.pangle.p115b.p117b.C6068a.m37257a(java.lang.Class, java.lang.Class[]):java.lang.reflect.Constructor");
    }
}

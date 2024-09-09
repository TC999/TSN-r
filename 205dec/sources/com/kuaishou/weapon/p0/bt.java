package com.kuaishou.weapon.p0;

import android.content.Context;
import android.text.TextUtils;
import java.security.SecureRandom;
import java.util.UUID;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class bt {

    /* renamed from: a  reason: collision with root package name */
    private static String f38116a;

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:33:0x00a3
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:81)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:47)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    public static synchronized java.lang.String a(android.content.Context r5) {
        /*
            java.lang.Class<com.kuaishou.weapon.p0.bt> r0 = com.kuaishou.weapon.p0.bt.class
            monitor-enter(r0)
            java.lang.String r1 = com.kuaishou.weapon.p0.bt.f38116a     // Catch: java.lang.Throwable -> L9f
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.Throwable -> L9f
            if (r1 != 0) goto Lf
            java.lang.String r5 = com.kuaishou.weapon.p0.bt.f38116a     // Catch: java.lang.Throwable -> L9f
            monitor-exit(r0)
            return r5
        Lf:
            java.lang.String r1 = "re_po_rt"
            com.kuaishou.weapon.p0.h r1 = com.kuaishou.weapon.p0.h.a(r5, r1)     // Catch: java.lang.Throwable -> L9f
            java.lang.String r2 = "a1_p_s_p_s"
            boolean r2 = r1.e(r2)     // Catch: java.lang.Throwable -> L9f
            java.lang.String r3 = "a1_p_s_p_s_c_b"
            boolean r1 = r1.e(r3)     // Catch: java.lang.Throwable -> L9f
            com.kuaishou.weapon.p0.df r3 = com.kuaishou.weapon.p0.df.a(r5)     // Catch: java.lang.Throwable -> L9f
            java.lang.String r3 = com.kuaishou.weapon.p0.bu.a(r5, r3)     // Catch: java.lang.Throwable -> L9f
            boolean r4 = android.text.TextUtils.isEmpty(r3)     // Catch: java.lang.Throwable -> L9f
            if (r4 != 0) goto L33
            com.kuaishou.weapon.p0.bt.f38116a = r3     // Catch: java.lang.Throwable -> L9f
            monitor-exit(r0)
            return r3
        L33:
            java.lang.String r3 = ""
            java.lang.String r4 = ""
            if (r2 != 0) goto L3b
            if (r1 == 0) goto L43
        L3b:
            java.lang.String r3 = com.kuaishou.weapon.p0.bh.c(r5)     // Catch: java.lang.Throwable -> L9f
            java.lang.String r4 = com.kuaishou.weapon.p0.bh.f(r5)     // Catch: java.lang.Throwable -> L9f
        L43:
            boolean r1 = android.text.TextUtils.isEmpty(r3)     // Catch: java.lang.Throwable -> L9f
            if (r1 != 0) goto L54
            java.lang.String r1 = "RISK"
            boolean r1 = r3.startsWith(r1)     // Catch: java.lang.Throwable -> L9f
            if (r1 == 0) goto L52
            goto L54
        L52:
            r1 = r3
            goto L56
        L54:
            java.lang.String r1 = "0"
        L56:
            java.lang.String r2 = a(r5, r3, r4)     // Catch: java.lang.Throwable -> L9f
            java.lang.StringBuffer r3 = new java.lang.StringBuffer     // Catch: java.lang.Throwable -> L9f
            r3.<init>(r1)     // Catch: java.lang.Throwable -> L9f
            java.lang.StringBuffer r1 = r3.reverse()     // Catch: java.lang.Throwable -> L9f
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> L9f
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L9f
            r3.<init>()     // Catch: java.lang.Throwable -> L9f
            java.lang.String r2 = r2.toUpperCase()     // Catch: java.lang.Throwable -> L9f
            r3.append(r2)     // Catch: java.lang.Throwable -> L9f
            java.lang.String r2 = "|"
            r3.append(r2)     // Catch: java.lang.Throwable -> L9f
            java.lang.String r1 = r1.toUpperCase()     // Catch: java.lang.Throwable -> L9f
            r3.append(r1)     // Catch: java.lang.Throwable -> L9f
            java.lang.String r1 = r3.toString()     // Catch: java.lang.Throwable -> L9f
            com.kuaishou.weapon.p0.bn r2 = new com.kuaishou.weapon.p0.bn     // Catch: java.lang.Throwable -> L9f
            r2.<init>(r5)     // Catch: java.lang.Throwable -> L9f
            java.lang.String r3 = "OTUzc3E1N0w5NTIzMW80OUQxMGo3R1dFa0ZiandHT0w="
            java.lang.String r1 = r2.a(r1, r3)     // Catch: java.lang.Throwable -> L9f
            boolean r2 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.Throwable -> L9f
            if (r2 != 0) goto L9f
            com.kuaishou.weapon.p0.df r2 = com.kuaishou.weapon.p0.df.a(r5)     // Catch: java.lang.Throwable -> L9f
            com.kuaishou.weapon.p0.bu.a(r1, r5, r2)     // Catch: java.lang.Throwable -> L9f
            com.kuaishou.weapon.p0.bt.f38116a = r1     // Catch: java.lang.Throwable -> L9f
            monitor-exit(r0)
            return r1
        L9f:
            java.lang.String r5 = ""
            monitor-exit(r0)
            return r5
        La3:
            r5 = move-exception
            monitor-exit(r0)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kuaishou.weapon.p0.bt.a(android.content.Context):java.lang.String");
    }

    public static String a(Context context, String str, String str2) {
        try {
            String uuid = UUID.randomUUID().toString();
            String packageName = context != null ? context.getPackageName() : "";
            String a4 = f.a(str + str2 + packageName + uuid);
            return TextUtils.isEmpty(a4) ? "" : a4;
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String a(int i4) {
        StringBuilder sb = new StringBuilder();
        if (i4 < 3) {
            i4 = 3;
        }
        SecureRandom secureRandom = new SecureRandom();
        for (int i5 = 0; i5 < i4; i5++) {
            int nextInt = secureRandom.nextInt(3);
            if (nextInt == 0) {
                sb.append(secureRandom.nextInt(10));
            } else if (nextInt == 1) {
                sb.append((char) (secureRandom.nextInt(25) + 65));
            } else if (nextInt == 2) {
                sb.append((char) (secureRandom.nextInt(25) + 97));
            }
        }
        return sb.toString();
    }
}

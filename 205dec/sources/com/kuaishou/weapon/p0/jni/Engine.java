package com.kuaishou.weapon.p0.jni;

import java.lang.reflect.Member;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class Engine {
    private static volatile Engine instance;
    public static volatile int loadSoCount;
    public static volatile boolean loadSuccess;
    public static volatile String soPath;
    public static volatile String soVersion;

    public static native String abc();

    public static native String bcd();

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:41:0x00db
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:81)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:47)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    public static com.kuaishou.weapon.p0.jni.Engine getInstance(android.content.Context r8) {
        /*
            Method dump skipped, instructions count: 234
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kuaishou.weapon.p0.jni.Engine.getInstance(android.content.Context):com.kuaishou.weapon.p0.jni.Engine");
    }

    public static native int mmo(Member member, int i4, int i5);

    public static native int mqc(Member member, int i4);

    public static native int off();

    public static native String tao(int i4, long j4, Object obj);

    public native byte[] ac(byte[] bArr, byte[] bArr2);

    public native byte[] ar(byte[] bArr, byte[] bArr2);

    public native String cde();

    public native byte[] dc(byte[] bArr, byte[] bArr2);

    public native String def();

    public native byte[] dr(byte[] bArr, byte[] bArr2);

    public native String efg();

    public native String eopq(int i4, int i5, int i6, String str);

    public native String fgh();

    public native String ghi();

    public native String hij();

    public native String klm(int i4, String str);

    public native String nop();

    public native String pqr(int i4, int i5, int i6, String str);

    public native String qrs();

    public native String stu(int i4, int i5, int i6, int i7, String str);
}

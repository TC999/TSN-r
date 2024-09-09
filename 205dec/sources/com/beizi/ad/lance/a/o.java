package com.beizi.ad.lance.a;

import java.util.Random;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: ProbabilityUtil.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class o {
    public static boolean a(int i4) {
        float nextInt = new Random().nextInt(100);
        l.c("BeiZisAd", "ratio = " + nextInt + ",ratioCheckNum = " + i4);
        return nextInt < ((float) i4);
    }
}

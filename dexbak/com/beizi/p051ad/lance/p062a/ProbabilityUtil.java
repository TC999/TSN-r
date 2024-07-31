package com.beizi.p051ad.lance.p062a;

import java.util.Random;

/* renamed from: com.beizi.ad.lance.a.o */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class ProbabilityUtil {
    /* renamed from: a */
    public static boolean m49039a(int i) {
        float nextInt = new Random().nextInt(100);
        LogUtil.m49044c("BeiZisAd", "ratio = " + nextInt + ",ratioCheckNum = " + i);
        return nextInt < ((float) i);
    }
}

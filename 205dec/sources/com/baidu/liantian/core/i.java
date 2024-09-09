package com.baidu.liantian.core;

import java.util.Random;

/* compiled from: RandomKeyUtil.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class i {

    /* renamed from: a  reason: collision with root package name */
    private static String f12222a = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static byte[] a() {
        char[] charArray = f12222a.toCharArray();
        char[] cArr = new char[16];
        for (int i4 = 0; i4 < 16; i4++) {
            cArr[i4] = charArray[new Random().nextInt(62)];
        }
        return new String(cArr).getBytes();
    }
}

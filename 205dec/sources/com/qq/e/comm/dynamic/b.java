package com.qq.e.comm.dynamic;

import com.qq.e.comm.dynamic.c;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public abstract class b {
    public static b a(int i4) {
        if (i4 == 1 && c.a().d()) {
            a aVar = new a();
            if (aVar.b()) {
                return aVar;
            }
            return null;
        }
        c.a().a((c.e) null, false);
        return null;
    }

    public abstract Object a(byte[] bArr) throws Throwable;

    public abstract void a();

    public abstract <T> void a(String str, Class<T> cls, T t3);

    public abstract byte[] a(String str) throws Throwable;

    public abstract Object b(String str) throws Throwable;

    public abstract boolean b();
}

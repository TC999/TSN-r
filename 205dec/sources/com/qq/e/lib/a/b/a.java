package com.qq.e.lib.a.b;

import com.qq.e.lib.a.b.b.b;
import com.qq.e.lib.a.c.b;
import java.io.File;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class a extends com.qq.e.lib.a.a<b> {
    public a(com.qq.e.lib.a.f.b bVar) {
        super(bVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qq.e.lib.a.a
    /* renamed from: b */
    public b a(com.qq.e.lib.a.f.b bVar, b.j jVar) {
        return new com.qq.e.lib.a.b.b.b(bVar, jVar);
    }

    public static a a(File file, String str) {
        return new a(new com.qq.e.lib.a.f.a(file, str));
    }
}

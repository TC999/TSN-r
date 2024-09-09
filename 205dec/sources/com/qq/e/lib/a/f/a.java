package com.qq.e.lib.a.f;

import com.qq.e.lib.a.e.d;
import java.io.File;
import java.io.IOException;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class a implements b {

    /* renamed from: a  reason: collision with root package name */
    private final File f47361a;

    /* renamed from: b  reason: collision with root package name */
    private String f47362b;

    public a(File file, String str) {
        this.f47361a = file;
        this.f47362b = str;
    }

    @Override // com.qq.e.lib.a.f.b
    public synchronized d a() throws IOException {
        return new com.qq.e.lib.a.e.b(this.f47361a, this.f47362b);
    }
}

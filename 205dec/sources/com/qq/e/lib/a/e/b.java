package com.qq.e.lib.a.e;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class b extends c {

    /* renamed from: d  reason: collision with root package name */
    private final File f47357d;

    /* renamed from: e  reason: collision with root package name */
    public String f47358e;

    public b(File file, String str) throws IOException {
        super(new e(new FileInputStream(file)));
        this.f47357d = file;
        this.f47358e = str;
    }

    @Override // com.qq.e.lib.a.e.c, com.qq.e.lib.a.e.d
    public void reset() throws IOException {
        this.f47359c.close();
        this.f47359c = new e(new FileInputStream(this.f47357d));
    }
}

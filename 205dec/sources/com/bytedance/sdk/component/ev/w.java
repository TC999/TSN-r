package com.bytedance.sdk.component.ev;

import com.bytedance.sdk.component.w.c.k;
import java.io.File;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class w {

    /* renamed from: c  reason: collision with root package name */
    final int f29731c;

    /* renamed from: f  reason: collision with root package name */
    final long f29732f;
    private final boolean gd;

    /* renamed from: r  reason: collision with root package name */
    k f29734r;
    final String sr;
    final long ux;

    /* renamed from: w  reason: collision with root package name */
    final String f29735w;
    final Map<String, String> xv;
    private File ev = null;

    /* renamed from: p  reason: collision with root package name */
    private byte[] f29733p = null;

    public w(boolean z3, int i4, String str, Map<String, String> map, String str2, long j4, long j5) {
        this.gd = z3;
        this.f29731c = i4;
        this.f29735w = str;
        this.xv = map;
        this.sr = str2;
        this.ux = j4;
        this.f29732f = j5;
    }

    public int c() {
        return this.f29731c;
    }

    public boolean ev() {
        return this.gd;
    }

    public long f() {
        return this.f29732f;
    }

    public long gd() {
        return this.ux - this.f29732f;
    }

    public k k() {
        return this.f29734r;
    }

    public byte[] p() {
        return this.f29733p;
    }

    public File r() {
        return this.ev;
    }

    public String sr() {
        return this.sr;
    }

    public long ux() {
        return this.ux;
    }

    public String w() {
        return this.f29735w;
    }

    public Map<String, String> xv() {
        return this.xv;
    }

    public void c(File file) {
        this.ev = file;
    }

    public void c(byte[] bArr) {
        this.f29733p = bArr;
    }

    public void c(k kVar) {
        this.f29734r = kVar;
    }
}

package com.qq.e.comm.plugin.p0;

import android.text.TextUtils;
import android.util.Pair;
import com.qq.e.comm.plugin.util.b1;
import com.qq.e.comm.plugin.util.d1;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
class a {

    /* renamed from: a  reason: collision with root package name */
    private final String f45303a;

    /* renamed from: b  reason: collision with root package name */
    private long f45304b;

    /* renamed from: c  reason: collision with root package name */
    private String f45305c;

    /* renamed from: d  reason: collision with root package name */
    private final File f45306d;

    /* renamed from: e  reason: collision with root package name */
    private RandomAccessFile f45307e;

    /* renamed from: f  reason: collision with root package name */
    private long f45308f;

    /* renamed from: g  reason: collision with root package name */
    private InterfaceC0871a f45309g;

    /* compiled from: A */
    /* renamed from: com.qq.e.comm.plugin.p0.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    interface InterfaceC0871a {
        void a(boolean z3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(String str) throws k {
        this.f45303a = str;
        this.f45306d = com.qq.e.comm.plugin.o0.g.a.a().d(str);
        if (g()) {
            return;
        }
        d1.a("VideoCache_init FileCache dir: " + b1.p() + ", name: " + b1.d(str), new Object[0]);
        StringBuilder sb = new StringBuilder();
        sb.append("VideoCache_init FileCache ");
        sb.append(this.f45306d);
        d1.a(sb.toString(), new Object[0]);
        try {
            this.f45307e = new RandomAccessFile(this.f45306d, "r");
            c();
        } catch (FileNotFoundException e4) {
            throw new k("Error opening connection, open file for " + str, e4);
        }
    }

    private void c() {
        Pair<String, Long> c4 = com.qq.e.comm.plugin.o0.g.a.a().c(this.f45303a);
        if (c4 != null) {
            this.f45305c = (String) c4.first;
            this.f45304b = ((Long) c4.second).longValue();
        }
        d1.a("VideoCache_fetchContentInfo mime:" + this.f45305c + ", totalLength:" + this.f45304b, new Object[0]);
    }

    public long a() throws IOException {
        return this.f45307e.length();
    }

    public void b() throws k {
        RandomAccessFile randomAccessFile = this.f45307e;
        if (randomAccessFile != null) {
            try {
                randomAccessFile.close();
            } catch (IOException e4) {
                throw new k("Error closing file for " + this.f45303a, e4);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String d() {
        if (TextUtils.isEmpty(this.f45305c)) {
            c();
        }
        return this.f45305c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean e() throws IOException {
        if (this.f45306d != null && this.f45307e != null) {
            long a4 = a();
            if (this.f45308f < a4) {
                this.f45308f = a4;
                return true;
            }
            d1.a("VideoCache_isCacheAvailable lastAvailableLength:" + this.f45308f + ", currentAvailableLength:" + a4, new Object[0]);
        } else {
            d1.a("VideoCache_isCacheAvailable file:" + this.f45306d + ", randomAccessFile:" + this.f45307e, new Object[0]);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean f() throws IOException {
        return a() == this.f45304b;
    }

    public boolean g() {
        return com.qq.e.comm.plugin.o0.g.a.a().e(this.f45303a);
    }

    public long h() {
        if (this.f45304b <= 0) {
            c();
        }
        return this.f45304b;
    }

    public int a(byte[] bArr, long j4, int i4) throws k {
        if (this.f45307e != null) {
            if (g()) {
                InterfaceC0871a interfaceC0871a = this.f45309g;
                if (interfaceC0871a != null) {
                    interfaceC0871a.a(true);
                }
                throw new k("File download error");
            }
            InterfaceC0871a interfaceC0871a2 = this.f45309g;
            if (interfaceC0871a2 != null) {
                interfaceC0871a2.a(false);
            }
            try {
                this.f45307e.seek(j4);
                return this.f45307e.read(bArr, 0, i4);
            } catch (IOException unused) {
                throw new k("Error reading data from " + this.f45303a + " read exception");
            }
        }
        throw new k("Error reading data from " + this.f45303a + " file is null");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(InterfaceC0871a interfaceC0871a) {
        this.f45309g = interfaceC0871a;
    }
}

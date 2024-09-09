package com.qq.e.comm.plugin.p0;

import com.qq.e.comm.plugin.util.d1;
import java.io.IOException;
import java.io.OutputStream;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
abstract class j {

    /* renamed from: a  reason: collision with root package name */
    private final a f45352a;

    /* renamed from: b  reason: collision with root package name */
    private volatile boolean f45353b;

    /* renamed from: d  reason: collision with root package name */
    private boolean f45355d;

    /* renamed from: e  reason: collision with root package name */
    private ConcurrentHashMap<String, Boolean> f45356e = new ConcurrentHashMap<>();

    /* renamed from: c  reason: collision with root package name */
    private AtomicInteger f45354c = new AtomicInteger(0);

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(a aVar) {
        this.f45352a = aVar;
    }

    public int a(byte[] bArr, long j4, int i4, OutputStream outputStream, b bVar) throws k, IOException {
        l.a(bArr, j4, i4);
        while (a(j4, i4, bVar)) {
            d1.a("VideoCache_wait for cache available, available: " + this.f45352a.a() + ", offset + length: " + (i4 + j4), new Object[0]);
            c();
            if (!this.f45355d) {
                a(outputStream);
                this.f45355d = true;
            }
            a();
        }
        this.f45355d = false;
        d1.a("VideoCache_read data from file cache\uff0c offset:" + j4 + "\uff0clength:" + i4, new Object[0]);
        return this.f45352a.a(bArr, j4, i4);
    }

    protected abstract void a(OutputStream outputStream) throws IOException;

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        try {
            this.f45353b = true;
            this.f45352a.b();
        } catch (k e4) {
            d1.a("VideoCache_ProxyCache error", e4);
        }
    }

    protected void c() throws k {
        try {
            Thread.sleep((this.f45354c.get() + 1) * 300);
        } catch (InterruptedException e4) {
            throw new k("Error waiting cache", e4);
        }
    }

    private boolean a(long j4, int i4, b bVar) throws IOException {
        return !this.f45352a.f() && this.f45352a.a() < j4 + ((long) i4) && !this.f45353b && a(bVar);
    }

    protected void a() throws k {
        try {
            if (this.f45352a.e()) {
                return;
            }
            if (this.f45354c.incrementAndGet() >= 5 || this.f45352a.g()) {
                this.f45354c.set(0);
                throw new k("Error reading downloading file ");
            }
        } catch (IOException e4) {
            throw new k("Error reading downloading file IOException ", e4);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str) {
        d1.a("VideoCache", "stopReadCache=" + str);
        this.f45356e.put(str, Boolean.FALSE);
    }

    private boolean a(b bVar) {
        Boolean bool = this.f45356e.get(bVar.f45318e);
        d1.a("VideoCache", "isVideoViewLiving=" + bool);
        if (bool == null) {
            return true;
        }
        return bool.booleanValue();
    }
}

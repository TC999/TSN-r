package com.qq.e.comm.plugin.p.i;

import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.qq.e.comm.plugin.p.f;
import com.qq.e.comm.plugin.p.g;
import java.util.HashMap;
import java.util.Map;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class a implements f {

    /* renamed from: a  reason: collision with root package name */
    private final f f45207a;

    /* renamed from: b  reason: collision with root package name */
    private final c f45208b;

    /* renamed from: d  reason: collision with root package name */
    private int f45210d;

    /* renamed from: c  reason: collision with root package name */
    private long f45209c = -1;

    /* renamed from: e  reason: collision with root package name */
    private String f45211e = "";

    public a(f fVar, c cVar) {
        this.f45207a = fVar;
        this.f45208b = cVar;
    }

    @Override // com.qq.e.comm.plugin.p.f
    public String a() {
        return this.f45207a.a() + "\t" + this.f45211e;
    }

    @Override // com.qq.e.comm.plugin.p.f
    public int b() {
        return this.f45207a.b() | this.f45210d;
    }

    @Override // com.qq.e.comm.plugin.p.f
    public Map<String, Object> c() {
        HashMap hashMap = new HashMap();
        hashMap.put("retryCount", Integer.valueOf(this.f45208b.b()));
        hashMap.put("retryInterval", Long.valueOf(this.f45208b.c()));
        hashMap.put("core", this.f45207a.c());
        return hashMap;
    }

    @Override // com.qq.e.comm.plugin.p.f
    public void cancel() {
        this.f45207a.cancel();
    }

    @Override // com.qq.e.comm.plugin.p.f
    public long d() {
        return this.f45207a.d();
    }

    @Override // com.qq.e.comm.plugin.p.f
    public Map<String, Object> e() {
        return this.f45207a.e();
    }

    @Override // com.qq.e.comm.plugin.p.f
    public long f() {
        return this.f45209c;
    }

    @Override // com.qq.e.comm.plugin.p.f
    public boolean g() {
        long currentTimeMillis = System.currentTimeMillis();
        boolean z3 = false;
        do {
            try {
                z3 = this.f45207a.g();
                if (!this.f45208b.a(b())) {
                    this.f45209c = System.currentTimeMillis() - currentTimeMillis;
                    return false;
                }
                try {
                    Thread.sleep(this.f45208b.c());
                } catch (InterruptedException unused) {
                }
                if (this.f45208b.a()) {
                    this.f45210d = TTAdConstant.KEY_CLICK_AREA;
                    this.f45211e = "NetworkChangedAndPauseDownloadTask";
                    this.f45209c = System.currentTimeMillis() - currentTimeMillis;
                    return false;
                }
            } catch (Throwable unused2) {
            }
        } while (!z3);
        this.f45209c = System.currentTimeMillis() - currentTimeMillis;
        return z3;
    }

    @Override // com.qq.e.comm.plugin.p.f
    public String getContentType() {
        return this.f45207a.getContentType();
    }

    @Override // com.qq.e.comm.plugin.p.f
    public int h() {
        return this.f45207a.h();
    }

    @Override // com.qq.e.comm.plugin.p.f
    public long i() {
        return this.f45207a.i();
    }

    @Override // com.qq.e.comm.plugin.p.f
    public void pause() {
        this.f45207a.pause();
    }

    @Override // com.qq.e.comm.plugin.p.f
    public void a(g gVar) {
        this.f45207a.a(gVar);
    }
}

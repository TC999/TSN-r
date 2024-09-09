package com.qq.e.comm.plugin.o0;

import com.qq.e.comm.plugin.o0.h.f;
import com.qq.e.comm.plugin.util.d1;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class c implements f.o {

    /* renamed from: a  reason: collision with root package name */
    private static final String f45035a = "c";

    @Override // com.qq.e.comm.plugin.o0.h.f.o
    public void a(int i4, Exception exc) {
        d1.b(f45035a, "onVideoError");
    }

    @Override // com.qq.e.comm.plugin.o0.h.f.o
    public void b() {
        d1.a(f45035a, "onBeforeVideoViewRelease");
    }

    @Override // com.qq.e.comm.plugin.o0.h.f.o
    public void c() {
        d1.a(f45035a, "onLoadingEnd");
    }

    @Override // com.qq.e.comm.plugin.o0.h.f.o
    public void onVideoComplete() {
        d1.a(f45035a, "onVideoComplete");
    }

    @Override // com.qq.e.comm.plugin.o0.h.f.o
    public void onVideoPause() {
        d1.a(f45035a, "onVideoPause");
    }

    @Override // com.qq.e.comm.plugin.o0.h.f.o
    public void onVideoReady() {
        d1.a(f45035a, "onVideoReady");
    }

    @Override // com.qq.e.comm.plugin.o0.h.f.o
    public void onVideoResume() {
        d1.a(f45035a, "onVideoResume");
    }

    @Override // com.qq.e.comm.plugin.o0.h.f.o
    public void onVideoStart() {
        d1.a(f45035a, "onVideoStart");
    }

    @Override // com.qq.e.comm.plugin.o0.h.f.o
    public void onVideoStop() {
        d1.a(f45035a, "onVideoStop");
    }

    @Override // com.qq.e.comm.plugin.o0.h.f.o
    public void a() {
        d1.a(f45035a, "onLoadingStart");
    }
}

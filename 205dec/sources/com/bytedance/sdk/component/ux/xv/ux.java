package com.bytedance.sdk.component.ux.xv;

import android.content.Context;
import com.bytedance.sdk.component.ux.a;
import com.bytedance.sdk.component.ux.bk;
import com.bytedance.sdk.component.ux.fz;
import com.bytedance.sdk.component.ux.ia;
import com.bytedance.sdk.component.ux.s;
import java.util.concurrent.ExecutorService;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class ux implements bk {

    /* renamed from: c  reason: collision with root package name */
    private a f30305c;
    private com.bytedance.sdk.component.ux.w ev;

    /* renamed from: f  reason: collision with root package name */
    private com.bytedance.sdk.component.ux.xv f30306f;

    /* renamed from: r  reason: collision with root package name */
    private ia f30307r;
    private s sr;
    private fz ux;

    /* renamed from: w  reason: collision with root package name */
    private ExecutorService f30308w;
    private com.bytedance.sdk.component.ux.sr xv;

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static class c {

        /* renamed from: c  reason: collision with root package name */
        private a f30309c;
        private com.bytedance.sdk.component.ux.w ev;

        /* renamed from: f  reason: collision with root package name */
        private com.bytedance.sdk.component.ux.xv f30310f;

        /* renamed from: r  reason: collision with root package name */
        private ia f30311r;
        private s sr;
        private fz ux;

        /* renamed from: w  reason: collision with root package name */
        private ExecutorService f30312w;
        private com.bytedance.sdk.component.ux.sr xv;

        public c c(com.bytedance.sdk.component.ux.w wVar) {
            this.ev = wVar;
            return this;
        }

        public c c(ExecutorService executorService) {
            this.f30312w = executorService;
            return this;
        }

        public c c(com.bytedance.sdk.component.ux.sr srVar) {
            this.xv = srVar;
            return this;
        }

        public ux c() {
            return new ux(this);
        }
    }

    @Override // com.bytedance.sdk.component.ux.bk
    public a c() {
        return this.f30305c;
    }

    @Override // com.bytedance.sdk.component.ux.bk
    public com.bytedance.sdk.component.ux.w ev() {
        return this.ev;
    }

    @Override // com.bytedance.sdk.component.ux.bk
    public com.bytedance.sdk.component.ux.xv f() {
        return this.f30306f;
    }

    @Override // com.bytedance.sdk.component.ux.bk
    public ia r() {
        return this.f30307r;
    }

    @Override // com.bytedance.sdk.component.ux.bk
    public s sr() {
        return this.sr;
    }

    @Override // com.bytedance.sdk.component.ux.bk
    public fz ux() {
        return this.ux;
    }

    @Override // com.bytedance.sdk.component.ux.bk
    public ExecutorService w() {
        return this.f30308w;
    }

    @Override // com.bytedance.sdk.component.ux.bk
    public com.bytedance.sdk.component.ux.sr xv() {
        return this.xv;
    }

    private ux(c cVar) {
        this.f30305c = cVar.f30309c;
        this.f30308w = cVar.f30312w;
        this.xv = cVar.xv;
        this.sr = cVar.sr;
        this.ux = cVar.ux;
        this.f30306f = cVar.f30310f;
        this.ev = cVar.ev;
        this.f30307r = cVar.f30311r;
    }

    public static ux c(Context context) {
        return new c().c();
    }
}

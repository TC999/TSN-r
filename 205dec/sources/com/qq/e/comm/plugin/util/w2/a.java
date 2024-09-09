package com.qq.e.comm.plugin.util.w2;

import com.qq.e.comm.plugin.callback.biz.DialogStateCallback;
import com.qq.e.comm.plugin.callback.biz.LifecycleCallback;
import com.qq.e.comm.plugin.h.f;
import com.qq.e.comm.plugin.util.c2;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class a implements f {

    /* renamed from: e  reason: collision with root package name */
    private final c2.c f46690e;

    /* renamed from: c  reason: collision with root package name */
    private final com.qq.e.comm.plugin.h.e f46688c = new com.qq.e.comm.plugin.h.e();

    /* renamed from: d  reason: collision with root package name */
    private boolean f46689d = false;

    /* renamed from: f  reason: collision with root package name */
    private boolean f46691f = false;

    /* compiled from: A */
    /* renamed from: com.qq.e.comm.plugin.util.w2.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class C0907a implements c2.b {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ com.qq.e.comm.plugin.util.w2.c f46692c;

        C0907a(com.qq.e.comm.plugin.util.w2.c cVar) {
            this.f46692c = cVar;
        }

        @Override // com.qq.e.comm.plugin.util.c2.b
        public void a(long j4) {
            this.f46692c.a(a.this.f46690e.a());
        }

        @Override // com.qq.e.comm.plugin.util.c2.b
        public void b() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class b extends com.qq.e.comm.plugin.h.d<LifecycleCallback.a> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ c2.c f46694b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(f fVar, c2.c cVar) {
            super(fVar);
            this.f46694b = cVar;
        }

        @Override // com.qq.e.comm.plugin.h.d
        /* renamed from: a */
        public void b(LifecycleCallback.a aVar) {
            if (aVar == null) {
                return;
            }
            int i4 = e.f46700a[aVar.ordinal()];
            if (i4 != 1) {
                if (i4 == 2 && !a.this.f46689d) {
                    this.f46694b.f();
                }
            } else if (a.this.f46689d) {
            } else {
                this.f46694b.e();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class c extends com.qq.e.comm.plugin.h.d<Integer> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ c2.c f46696b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(f fVar, c2.c cVar) {
            super(fVar);
            this.f46696b = cVar;
        }

        @Override // com.qq.e.comm.plugin.h.d
        /* renamed from: a */
        public void b(Integer num) {
            a.this.f46689d = true;
            this.f46696b.e();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class d extends com.qq.e.comm.plugin.h.d<Integer> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ c2.c f46698b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(f fVar, c2.c cVar) {
            super(fVar);
            this.f46698b = cVar;
        }

        @Override // com.qq.e.comm.plugin.h.d
        /* renamed from: a */
        public void b(Integer num) {
            a.this.f46689d = false;
            this.f46698b.f();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public static /* synthetic */ class e {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f46700a;

        static {
            int[] iArr = new int[LifecycleCallback.a.values().length];
            f46700a = iArr;
            try {
                iArr[LifecycleCallback.a.PAUSED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f46700a[LifecycleCallback.a.RESUMED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(com.qq.e.comm.plugin.g0.e eVar, com.qq.e.comm.plugin.util.w2.c cVar) {
        c2.c cVar2 = new c2.c(9999000L, 500L);
        this.f46690e = cVar2;
        cVar2.a(new C0907a(cVar));
        a(eVar, this.f46690e);
        this.f46690e.g();
    }

    @Override // com.qq.e.comm.plugin.h.f
    public com.qq.e.comm.plugin.h.e g() {
        return this.f46688c;
    }

    @Override // com.qq.e.comm.plugin.h.f
    public boolean isDestroyed() {
        return this.f46691f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        this.f46690e.h();
        this.f46690e.a((c2.b) null);
        this.f46691f = true;
    }

    private void a(com.qq.e.comm.plugin.g0.e eVar, c2.c cVar) {
        ((LifecycleCallback) com.qq.e.comm.plugin.h.a.b(eVar.l0(), LifecycleCallback.class)).l().a(new b(this, cVar));
        DialogStateCallback dialogStateCallback = (DialogStateCallback) com.qq.e.comm.plugin.h.a.b(eVar.l0(), DialogStateCallback.class);
        dialogStateCallback.d().a(new c(this, cVar));
        dialogStateCallback.onDismiss().a(new d(this, cVar));
    }
}

package com.bxkj.base.v2.netty4android.service;

import android.content.Intent;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.LifecycleService;
import com.bjtsn.base.v2.netty4android.client.d;
import com.bxkj.base.BaseApp;
import com.bxkj.base.util.z;
import com.bxkj.base.v2.common.utils.m;
import com.bxkj.base.v2.data.a;
import com.bxkj.base.v2.http.a;
import com.bxkj.base.v2.http.result.ApiResult;
import com.bxkj.base.v2.netty4android.client.command.b;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.orhanobut.logger.j;
import d2.l;
import d2.p;
import java.util.Map;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.d0;
import kotlin.f1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.f0;
import kotlinx.coroutines.a1;
import kotlinx.coroutines.h;
import kotlinx.coroutines.q0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import retrofit2.HttpException;

/* compiled from: NettySocketService.kt */
@Metadata(bv = {}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\"\u0010\u000b\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0016J\u000e\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fJ\u000e\u0010\u000f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fR\u0014\u0010\u0012\u001a\u00020\b8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0014\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0011R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001b\u00a8\u0006\u001f"}, d2 = {"Lcom/bxkj/base/v2/netty4android/service/NettySocketService;", "Landroidx/lifecycle/LifecycleService;", "Lkotlin/f1;", "j", "i", "f", "Landroid/content/Intent;", "intent", "", "flags", "startId", "onStartCommand", "Lcom/bxkj/base/v2/netty4android/client/command/a;", "command", "h", "g", "a", "I", "MAX_CONNECT_FAIL_COUNT", "b", "connectFailCount", "Lcom/bxkj/base/v2/netty4android/client/heart/a;", "c", "Lcom/bxkj/base/v2/netty4android/client/heart/a;", "alarmChatTimer", "Lcom/bjtsn/base/v2/netty4android/client/d;", "d", "Lcom/bjtsn/base/v2/netty4android/client/d;", "nettyTcpClient", "<init>", "()V", "base_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: E:\TSN-r\205dec\4499832.dex */
public final class NettySocketService extends LifecycleService {

    /* renamed from: a  reason: collision with root package name */
    private final int f18785a = 5;

    /* renamed from: b  reason: collision with root package name */
    private int f18786b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private com.bxkj.base.v2.netty4android.client.heart.a f18787c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private com.bjtsn.base.v2.netty4android.client.d f18788d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: NettySocketService.kt */
    @Metadata(bv = {}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/q0;", "Lkotlin/f1;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    @DebugMetadata(c = "com.bxkj.base.v2.netty4android.service.NettySocketService$receiveCommand$1", f = "NettySocketService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* loaded from: E:\TSN-r\205dec\4499832.dex */
    public static final class a extends SuspendLambda implements p<q0, kotlin.coroutines.c<? super f1>, Object> {

        /* renamed from: a  reason: collision with root package name */
        int f18789a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ com.bxkj.base.v2.netty4android.client.command.a f18790b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(com.bxkj.base.v2.netty4android.client.command.a aVar, kotlin.coroutines.c<? super a> cVar) {
            super(2, cVar);
            this.f18790b = aVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final kotlin.coroutines.c<f1> create(@Nullable Object obj, @NotNull kotlin.coroutines.c<?> cVar) {
            return new a(this.f18790b, cVar);
        }

        @Override // d2.p
        @Nullable
        public final Object invoke(@NotNull q0 q0Var, @Nullable kotlin.coroutines.c<? super f1> cVar) {
            return ((a) create(q0Var, cVar)).invokeSuspend(f1.f55527a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.a.h();
            if (this.f18789a == 0) {
                d0.n(obj);
                this.f18790b.a();
                return f1.f55527a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: NettySocketService.kt */
    @Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"", "it", "Lkotlin/f1;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\4499832.dex */
    public static final class b extends Lambda implements l<Boolean, f1> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ com.bxkj.base.v2.netty4android.client.command.a f18791a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(com.bxkj.base.v2.netty4android.client.command.a aVar) {
            super(1);
            this.f18791a = aVar;
        }

        public final void a(boolean z3) {
            Boolean valueOf = Boolean.valueOf(z3);
            if (!(!valueOf.booleanValue())) {
                valueOf = null;
            }
            if (valueOf == null) {
                return;
            }
            com.bxkj.base.v2.netty4android.client.command.a aVar = this.f18791a;
            valueOf.booleanValue();
            j.e(aVar + " \u6d88\u606f\u53d1\u9001\u5931\u8d25", new Object[0]);
        }

        @Override // d2.l
        public /* bridge */ /* synthetic */ f1 invoke(Boolean bool) {
            a(bool.booleanValue());
            return f1.f55527a;
        }
    }

    /* compiled from: NettySocketService.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\t\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\n\u001a\u00020\u0006H\u0016\u00a8\u0006\u000b"}, d2 = {"com/bxkj/base/v2/netty4android/service/NettySocketService$c", "Lk/b;", "Lcom/bxkj/base/v2/netty4android/client/command/a;", "msg", "", "index", "Lkotlin/f1;", "d", "statusCode", "c", "b", "base_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\4499832.dex */
    public static final class c implements k.b<com.bxkj.base.v2.netty4android.client.command.a> {

        /* compiled from: NettySocketService.kt */
        @Metadata(bv = {}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/q0;", "Lkotlin/f1;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
        @DebugMetadata(c = "com.bxkj.base.v2.netty4android.service.NettySocketService$startConnect$1$onClientStatusConnectChanged$1", f = "NettySocketService.kt", i = {}, l = {169}, m = "invokeSuspend", n = {}, s = {})
        /* loaded from: E:\TSN-r\205dec\4499832.dex */
        static final class a extends SuspendLambda implements p<q0, kotlin.coroutines.c<? super f1>, Object> {

            /* renamed from: a  reason: collision with root package name */
            int f18793a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ NettySocketService f18794b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(NettySocketService nettySocketService, kotlin.coroutines.c<? super a> cVar) {
                super(2, cVar);
                this.f18794b = nettySocketService;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @NotNull
            public final kotlin.coroutines.c<f1> create(@Nullable Object obj, @NotNull kotlin.coroutines.c<?> cVar) {
                return new a(this.f18794b, cVar);
            }

            @Override // d2.p
            @Nullable
            public final Object invoke(@NotNull q0 q0Var, @Nullable kotlin.coroutines.c<? super f1> cVar) {
                return ((a) create(q0Var, cVar)).invokeSuspend(f1.f55527a);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                Object h4 = kotlin.coroutines.intrinsics.a.h();
                int i4 = this.f18793a;
                if (i4 == 0) {
                    d0.n(obj);
                    this.f18793a = 1;
                    if (a1.b(ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT, this) == h4) {
                        return h4;
                    }
                } else if (i4 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    d0.n(obj);
                }
                this.f18794b.j();
                return f1.f55527a;
            }
        }

        c() {
        }

        @Override // k.b
        public void b() {
            NettySocketService.this.f18786b++;
        }

        @Override // k.b
        public void c(int i4, int i5) {
            j.d(f0.C("onClientStatusConnectChanged:", Integer.valueOf(i4)), new Object[0]);
            if (i4 == 0) {
                j.d("onClientStatusConnectChanged->\u8fde\u63a5\u65ad\u5f00", new Object[0]);
                com.bxkj.base.v2.netty4android.client.heart.a aVar = NettySocketService.this.f18787c;
                if (aVar != null) {
                    aVar.a();
                }
                h.f(LifecycleOwnerKt.getLifecycleScope(NettySocketService.this), kotlinx.coroutines.f1.c(), null, new a(NettySocketService.this, null), 2, null);
            } else if (i4 != 1) {
            } else {
                a.b bVar = com.bxkj.base.v2.data.a.f18673h;
                bVar.a().V(System.currentTimeMillis());
                NettySocketService nettySocketService = NettySocketService.this;
                b.a aVar2 = com.bxkj.base.v2.netty4android.client.command.b.f18734a;
                String C = bVar.a().C();
                String B = bVar.a().B();
                String r3 = bVar.a().r();
                String h4 = z.h(BaseApp.b());
                f0.o(h4, "getVersionName(BaseApp.getApp())");
                nettySocketService.h(aVar2.a(C, B, r3, h4, bVar.a().w()));
            }
        }

        @Override // k.b
        /* renamed from: d */
        public void a(@NotNull com.bxkj.base.v2.netty4android.client.command.a msg, int i4) {
            f0.p(msg, "msg");
            NettySocketService.this.g(msg);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: NettySocketService.kt */
    @Metadata(bv = {}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/q0;", "Lkotlin/f1;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    @DebugMetadata(c = "com.bxkj.base.v2.netty4android.service.NettySocketService$startGetSocketConfig$1", f = "NettySocketService.kt", i = {}, l = {80}, m = "invokeSuspend", n = {}, s = {})
    /* loaded from: E:\TSN-r\205dec\4499832.dex */
    public static final class d extends SuspendLambda implements p<q0, kotlin.coroutines.c<? super f1>, Object> {

        /* renamed from: a  reason: collision with root package name */
        int f18795a;

        d(kotlin.coroutines.c<? super d> cVar) {
            super(2, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final kotlin.coroutines.c<f1> create(@Nullable Object obj, @NotNull kotlin.coroutines.c<?> cVar) {
            return new d(cVar);
        }

        @Override // d2.p
        @Nullable
        public final Object invoke(@NotNull q0 q0Var, @Nullable kotlin.coroutines.c<? super f1> cVar) {
            return ((d) create(q0Var, cVar)).invokeSuspend(f1.f55527a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Map map;
            Object h4 = kotlin.coroutines.intrinsics.a.h();
            int i4 = this.f18795a;
            try {
                if (i4 == 0) {
                    d0.n(obj);
                    com.bxkj.base.v2.http.a b4 = com.bxkj.base.v2.http.b.f18727a.b();
                    this.f18795a = 1;
                    obj = a.C0206a.a(b4, null, this, 1, null);
                    if (obj == h4) {
                        return h4;
                    }
                } else if (i4 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    d0.n(obj);
                }
                ApiResult apiResult = (ApiResult) obj;
                if (apiResult != null && (map = (Map) apiResult.apiData()) != null) {
                    NettySocketService nettySocketService = NettySocketService.this;
                    j.g(f0.C("getSocket", map), new Object[0]);
                    m mVar = m.a;
                    j.d(f0.C("JsonGet.getInt(it, \"serverOpen\")=", kotlin.coroutines.jvm.internal.a.f(mVar.k(map, "serverOpen"))), new Object[0]);
                    a.b bVar = com.bxkj.base.v2.data.a.f18673h;
                    bVar.a().n0(mVar.k(map, "serverOpen"));
                    if (mVar.k(map, "serverOpen") == 1) {
                        bVar.a().Z(mVar.t(map, "ip"));
                        bVar.a().a0(mVar.k(map, "port"));
                        bVar.a().b0(mVar.t(map, "secret"));
                        nettySocketService.i();
                    } else {
                        j.m("socket\u670d\u52a1\u5668\u8bbe\u7f6esokect\u914d\u7f6e\u672a\u5f00\u542f", new Object[0]);
                    }
                }
            } catch (Exception e4) {
                if ((e4 instanceof HttpException) && ((HttpException) e4).code() == 401) {
                    j.e("\u7531\u4e8e\u83b7\u53d6sokect\u914d\u7f6e\u63a5\u53e3401\uff0c\u5df2\u7ecf\u767b\u5f55\u5931\u6548\uff0c\u8bf7\u91cd\u65b0\u767b\u5f55", new Object[0]);
                    com.bxkj.base.v2.data.a.f18673h.a().Y(false);
                }
                j.e(f0.C("socket", e4), new Object[0]);
            }
            return f1.f55527a;
        }
    }

    private final void f() {
        com.bjtsn.base.v2.netty4android.client.d dVar = this.f18788d;
        if (dVar == null) {
            return;
        }
        dVar.q();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i() {
        a.b bVar = com.bxkj.base.v2.data.a.f18673h;
        if (bVar.a().G()) {
            if ((bVar.a().p().length() == 0) || bVar.a().q() == 0) {
                return;
            }
            if (bVar.a().r().length() == 0) {
                return;
            }
            f();
            if (this.f18788d == null) {
                this.f18788d = new d.a().d(bVar.a().p()).i(bVar.a().q()).f(0).g(0L).h(true).c(60L).b(com.bxkj.base.v2.netty4android.client.command.b.f18734a.b()).e(0).a();
            }
            com.bjtsn.base.v2.netty4android.client.d dVar = this.f18788d;
            if ((dVar == null || dVar.r()) ? false : true) {
                com.bjtsn.base.v2.netty4android.client.d dVar2 = this.f18788d;
                if (dVar2 != null) {
                    dVar2.n();
                }
                com.bjtsn.base.v2.netty4android.client.d dVar3 = this.f18788d;
                if (dVar3 == null) {
                    return;
                }
                dVar3.E(new c());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j() {
        com.bjtsn.base.v2.netty4android.client.d dVar = this.f18788d;
        if (dVar != null && dVar.r()) {
            j.e("socket\u5df2\u7ecf\u8fde\u63a5\uff0c\u4e0d\u518d\u8fde\u63a5", new Object[0]);
            return;
        }
        a.b bVar = com.bxkj.base.v2.data.a.f18673h;
        if (!bVar.a().G()) {
            j.e("\u7528\u6237\u672a\u767b\u5f55\uff0c\u4e0d\u518d\u8fde\u63a5", new Object[0]);
        } else if (bVar.a().z() == 0) {
            j.e("\u670d\u52a1\u5668\u8bbe\u7f6esokect\u914d\u7f6e\u672a\u5f00\u542f\uff0c\u4e0d\u518d\u8fde\u63a5", new Object[0]);
        } else if (this.f18786b >= this.f18785a) {
            j.e("\u8d85\u8fc7\u6700\u5927\u8fde\u63a5\u5931\u8d25\u6b21\u6570\uff0c\u4e0d\u518d\u8fde\u63a5", new Object[0]);
        } else {
            h.f(LifecycleOwnerKt.getLifecycleScope(this), kotlinx.coroutines.f1.c(), null, new d(null), 2, null);
        }
    }

    public final void g(@NotNull com.bxkj.base.v2.netty4android.client.command.a command) {
        f0.p(command, "command");
        com.bxkj.base.v2.data.a.f18673h.a().V(System.currentTimeMillis());
        h.f(LifecycleOwnerKt.getLifecycleScope(this), kotlinx.coroutines.f1.c(), null, new a(command, null), 2, null);
    }

    public final void h(@NotNull com.bxkj.base.v2.netty4android.client.command.a command) {
        f0.p(command, "command");
        com.bjtsn.base.v2.netty4android.client.d dVar = this.f18788d;
        if (dVar == null) {
            return;
        }
        dVar.B(command, new b(command));
    }

    @Override // androidx.lifecycle.LifecycleService, android.app.Service
    public int onStartCommand(@Nullable Intent intent, int i4, int i5) {
        super.onStartCommand(intent, i4, i5);
        j.d(f0.C("NettySocketService->onStartCommand:", intent == null ? null : Integer.valueOf(intent.getIntExtra("action", -1))), new Object[0]);
        com.bxkj.base.v2.netty4android.client.heart.a aVar = this.f18787c;
        if (aVar == null) {
            BaseApp b4 = BaseApp.b();
            f0.o(b4, "getApp()");
            aVar = new com.bxkj.base.v2.netty4android.client.heart.a(b4);
        }
        this.f18787c = aVar;
        aVar.b();
        if (intent != null) {
            if (!intent.hasExtra("action")) {
                intent = null;
            }
            if (intent != null) {
                int intExtra = intent.getIntExtra("action", 0);
                if (intExtra == 1) {
                    j.g("NettySocketService->ACTION_CONNECT", new Object[0]);
                    j();
                } else if (intExtra == 2) {
                    j.g("NettySocketService->ACTION_DISCONNECT", new Object[0]);
                    f();
                }
            }
        }
        return 1;
    }
}

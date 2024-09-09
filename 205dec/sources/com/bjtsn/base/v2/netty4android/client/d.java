package com.bjtsn.base.v2.netty4android.client;

import android.os.SystemClock;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.orhanobut.logger.j;
import d2.l;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.LineBasedFrameDecoder;
import io.netty.handler.timeout.IdleStateHandler;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.f1;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.u;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: NettyTcpClient.kt */
@Metadata(bv = {}, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\t\n\u0002\b\u000f\u0018\u00002\u00020\u0001:\u0001\u0018B!\b\u0002\u0012\u0006\u0010\u001a\u001a\u00020\u0017\u0012\u0006\u0010\u001e\u001a\u00020\u001b\u0012\u0006\u0010\"\u001a\u00020\u001b\u00a2\u0006\u0004\bI\u0010JJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0006\u0010\u0005\u001a\u00020\u0002J\u0006\u0010\u0006\u001a\u00020\u0002J\u001a\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tJ:\u0010\u0012\u001a\u0004\u0018\u00010\u00022\u0006\u0010\b\u001a\u00020\u00072!\u0010\n\u001a\u001d\u0012\u0013\u0012\u00110\u000e\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u00020\r\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u000e\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\u0007J\u0014\u0010\u0016\u001a\u00020\u00022\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u0015R\u0014\u0010\u001a\u001a\u00020\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001e\u001a\u00020\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0017\u0010\"\u001a\u00020\u001b8\u0006\u00a2\u0006\f\n\u0004\b\u001f\u0010\u001d\u001a\u0004\b \u0010!R\u0018\u0010&\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0018\u0010*\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)R\"\u00101\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R$\u00105\u001a\u00020\u001b2\u0006\u00102\u001a\u00020\u001b8\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b3\u0010\u001d\u001a\u0004\b4\u0010!R\u0016\u00107\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u0010\u001dR\u0016\u00109\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u0010,R\u0016\u0010;\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u0010,R$\u0010A\u001a\u00020<2\u0006\u00102\u001a\u00020<8\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b=\u0010>\u001a\u0004\b?\u0010@R$\u0010D\u001a\u00020<2\u0006\u00102\u001a\u00020<8\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\bB\u0010>\u001a\u0004\bC\u0010@R$\u0010F\u001a\u00020\u000e2\u0006\u00102\u001a\u00020\u000e8\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\u0005\u0010,\u001a\u0004\bE\u0010.R\u0018\u0010H\u001a\u0004\u0018\u00010\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010G\u00a8\u0006K"}, d2 = {"Lcom/bjtsn/base/v2/netty4android/client/d;", "", "Lkotlin/f1;", "o", "x", "n", CampaignEx.JSON_KEY_AD_Q, "Lcom/bxkj/base/v2/netty4android/client/command/a;", "data", "Lk/a;", "listener", "Lio/netty/channel/ChannelFuture;", "y", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "isSuccess", "B", "(Lcom/bxkj/base/v2/netty4android/client/command/a;Ld2/l;)Lkotlin/f1;", "z", "Lk/b;", "E", "", "a", "Ljava/lang/String;", "host", "", "b", "I", "port", "c", "t", "()I", "index", "Lio/netty/channel/EventLoopGroup;", "d", "Lio/netty/channel/EventLoopGroup;", "group", "Lio/netty/channel/Channel;", "f", "Lio/netty/channel/Channel;", "channel", "g", "Z", "r", "()Z", "D", "(Z)V", "connectStatus", "<set-?>", "h", "u", "maxConnectTimes", "i", "reconnectNum", "j", "isNeedReconnect", "k", "isConnecting", "", "l", "J", "v", "()J", "reconnectIntervalTime", "m", "s", "heartBeatInterval", "w", "isSendHeartbeat", "Ljava/lang/Object;", "heartBeatData", "<init>", "(Ljava/lang/String;II)V", "base_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: E:\TSN-r\205dec\4499832.dex */
public final class d {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final String f16396a;

    /* renamed from: b  reason: collision with root package name */
    private final int f16397b;

    /* renamed from: c  reason: collision with root package name */
    private final int f16398c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private EventLoopGroup f16399d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private k.b<com.bxkj.base.v2.netty4android.client.command.a> f16400e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private Channel f16401f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f16402g;

    /* renamed from: h  reason: collision with root package name */
    private int f16403h;

    /* renamed from: i  reason: collision with root package name */
    private int f16404i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f16405j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f16406k;

    /* renamed from: l  reason: collision with root package name */
    private long f16407l;

    /* renamed from: m  reason: collision with root package name */
    private long f16408m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f16409n;
    @Nullable

    /* renamed from: o  reason: collision with root package name */
    private Object f16410o;

    /* compiled from: NettyTcpClient.kt */
    @Metadata(bv = {}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001f\u0010 J\u000e\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0005J\u000e\u0010\n\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\bJ\u000e\u0010\f\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u0002J\u000e\u0010\u000e\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u0002J\u000e\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u0005J\u000e\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u0011J\u000e\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u0001J\u0006\u0010\u0017\u001a\u00020\u0016R\u0016\u0010\u0019\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u0006\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u001aR\u0018\u0010\t\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u001bR\u0016\u0010\u000b\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0018R\u0016\u0010\r\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0018R\u0016\u0010\u0012\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u001cR\u0016\u0010\u001d\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u001aR\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u001e\u00a8\u0006!"}, d2 = {"Lcom/bjtsn/base/v2/netty4android/client/d$a;", "", "", "reConnectTimes", "f", "", "reconnectIntervalTime", "g", "", "host", "d", "tcp_port", "i", "mIndex", "e", "intervalTime", "c", "", "isSendheartBeat", "h", "heartBeatData", "b", "Lcom/bjtsn/base/v2/netty4android/client/d;", "a", "I", "MAX_CONNECT_TIMES", "J", "Ljava/lang/String;", "Z", "heartBeatInterval", "Ljava/lang/Object;", "<init>", "()V", "base_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\4499832.dex */
    public static final class a {
        @Nullable

        /* renamed from: c  reason: collision with root package name */
        private String f16413c;

        /* renamed from: d  reason: collision with root package name */
        private int f16414d;

        /* renamed from: e  reason: collision with root package name */
        private int f16415e;

        /* renamed from: f  reason: collision with root package name */
        private boolean f16416f;
        @Nullable

        /* renamed from: h  reason: collision with root package name */
        private Object f16418h;

        /* renamed from: a  reason: collision with root package name */
        private int f16411a = Integer.MAX_VALUE;

        /* renamed from: b  reason: collision with root package name */
        private long f16412b = 5000;

        /* renamed from: g  reason: collision with root package name */
        private long f16417g = 5;

        @NotNull
        public final d a() {
            String str = this.f16413c;
            f0.m(str);
            d dVar = new d(str, this.f16414d, this.f16415e, null);
            dVar.f16403h = this.f16411a;
            dVar.f16407l = this.f16412b;
            dVar.f16408m = this.f16417g;
            dVar.f16409n = this.f16416f;
            dVar.f16410o = this.f16418h;
            return dVar;
        }

        @NotNull
        public final a b(@NotNull Object heartBeatData) {
            f0.p(heartBeatData, "heartBeatData");
            this.f16418h = heartBeatData;
            return this;
        }

        @NotNull
        public final a c(long j4) {
            this.f16417g = j4;
            return this;
        }

        @NotNull
        public final a d(@NotNull String host) {
            f0.p(host, "host");
            this.f16413c = host;
            return this;
        }

        @NotNull
        public final a e(int i4) {
            this.f16415e = i4;
            return this;
        }

        @NotNull
        public final a f(int i4) {
            this.f16411a = i4;
            return this;
        }

        @NotNull
        public final a g(long j4) {
            this.f16412b = j4;
            return this;
        }

        @NotNull
        public final a h(boolean z3) {
            this.f16416f = z3;
            return this;
        }

        @NotNull
        public final a i(int i4) {
            this.f16414d = i4;
            return this;
        }
    }

    /* compiled from: NettyTcpClient.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/bjtsn/base/v2/netty4android/client/d$b", "Ljava/lang/Thread;", "Lkotlin/f1;", "run", "base_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\4499832.dex */
    public static final class b extends Thread {
        b() {
            super("Netty-Client");
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            super.run();
            d.this.f16405j = true;
            d dVar = d.this;
            dVar.f16404i = dVar.u();
            d.this.o();
        }
    }

    /* compiled from: NettyTcpClient.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/bjtsn/base/v2/netty4android/client/d$c", "Lio/netty/channel/ChannelInitializer;", "Lio/netty/channel/socket/SocketChannel;", "ch", "Lkotlin/f1;", "a", "base_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\4499832.dex */
    public static final class c extends ChannelInitializer<SocketChannel> {
        c() {
        }

        @Override // io.netty.channel.ChannelInitializer
        /* renamed from: a */
        public void initChannel(@NotNull SocketChannel ch) throws Exception {
            f0.p(ch, "ch");
            if (d.this.w()) {
                ch.pipeline().addLast("ping", new IdleStateHandler(0L, d.this.s(), 0L, TimeUnit.SECONDS));
            }
            ch.pipeline().addLast(new com.bxkj.base.v2.netty4android.client.handler.c(null, 1, null));
            ch.pipeline().addLast(new com.bxkj.base.v2.netty4android.client.handler.b(null, 1, null));
            ch.pipeline().addLast(new LineBasedFrameDecoder(1024));
            ch.pipeline().addLast(new com.bxkj.base.v2.netty4android.client.handler.d(d.this.f16400e, d.this.t(), d.this.w(), d.this.f16410o));
        }
    }

    private d(String str, int i4, int i5) {
        this.f16396a = str;
        this.f16397b = i4;
        this.f16398c = i5;
        this.f16403h = Integer.MAX_VALUE;
        this.f16404i = Integer.MAX_VALUE;
        this.f16405j = true;
        this.f16407l = 5000L;
        this.f16408m = 5L;
    }

    public /* synthetic */ d(String str, int i4, int i5, u uVar) {
        this(str, i4, i5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A(k.a aVar, Future future) {
        if (aVar == null) {
            return;
        }
        aVar.a(future.isSuccess());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C(l listener, Future future) {
        f0.p(listener, "$listener");
        listener.invoke(Boolean.valueOf(future.isSuccess()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v23, types: [io.netty.channel.ChannelFuture] */
    public final void o() {
        Channel channel;
        EventLoopGroup eventLoopGroup;
        ChannelFuture closeFuture;
        synchronized (this) {
            if (!r()) {
                this.f16406k = true;
                this.f16399d = new NioEventLoopGroup();
                try {
                    Channel channel2 = new Bootstrap().group(this.f16399d).option(ChannelOption.TCP_NODELAY, Boolean.TRUE).option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 5000).channel(NioSocketChannel.class).handler(new c()).connect(this.f16396a, this.f16397b).addListener(new GenericFutureListener() { // from class: com.bjtsn.base.v2.netty4android.client.a
                        @Override // io.netty.util.concurrent.GenericFutureListener
                        public final void operationComplete(Future future) {
                            d.p(d.this, future);
                        }
                    }).sync().channel();
                    this.f16401f = channel2;
                    if (channel2 != null && (closeFuture = channel2.closeFuture()) != null) {
                        closeFuture.sync();
                    }
                    j.d(" \u65ad\u5f00\u8fde\u63a5", new Object[0]);
                    D(false);
                    k.b<com.bxkj.base.v2.netty4android.client.command.a> bVar = this.f16400e;
                    if (bVar != null) {
                        bVar.c(0, t());
                    }
                    Channel channel3 = this.f16401f;
                    if (channel3 != null) {
                        channel = channel3.isOpen() ? channel3 : null;
                        if (channel != null) {
                            channel.close();
                        }
                    }
                    eventLoopGroup = this.f16399d;
                    if (eventLoopGroup == null) {
                    }
                } catch (Exception e4) {
                    e4.printStackTrace();
                    D(false);
                    k.b<com.bxkj.base.v2.netty4android.client.command.a> bVar2 = this.f16400e;
                    if (bVar2 != null) {
                        bVar2.c(0, t());
                    }
                    Channel channel4 = this.f16401f;
                    if (channel4 != null) {
                        channel = channel4.isOpen() ? channel4 : null;
                        if (channel != null) {
                            channel.close();
                        }
                    }
                    eventLoopGroup = this.f16399d;
                    if (eventLoopGroup == null) {
                    }
                }
                eventLoopGroup.shutdownGracefully();
            }
            f1 f1Var = f1.f55527a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(d this$0, Future future) {
        f0.p(this$0, "this$0");
        if (future.isSuccess()) {
            j.d("\u8fde\u63a5\u6210\u529f", new Object[0]);
            this$0.f16404i = this$0.u();
            this$0.D(true);
        } else {
            k.b<com.bxkj.base.v2.netty4android.client.command.a> bVar = this$0.f16400e;
            if (bVar != null) {
                bVar.b();
            }
            j.d("\u8fde\u63a5\u5931\u8d25", new Object[0]);
            this$0.D(false);
        }
        this$0.f16406k = false;
    }

    private final void x() {
        int i4;
        j.d("\u5ba2\u6237\u7aef\u4e3b\u52a8\u91cd\u65b0\u8fde\u63a5", new Object[0]);
        if (!this.f16405j || (i4 = this.f16404i) <= 0 || this.f16402g) {
            return;
        }
        this.f16404i = i4 - 1;
        SystemClock.sleep(this.f16407l);
        if (!this.f16405j || this.f16404i <= 0 || this.f16402g) {
            return;
        }
        o();
    }

    @Nullable
    public final f1 B(@NotNull com.bxkj.base.v2.netty4android.client.command.a data, @NotNull final l<? super Boolean, f1> listener) {
        f0.p(data, "data");
        f0.p(listener, "listener");
        Channel channel = this.f16401f;
        if (channel == null) {
            return null;
        }
        if (r()) {
            channel.writeAndFlush(data).addListener(new GenericFutureListener() { // from class: com.bjtsn.base.v2.netty4android.client.b
                @Override // io.netty.util.concurrent.GenericFutureListener
                public final void operationComplete(Future future) {
                    d.C(l.this, future);
                }
            });
        }
        return f1.f55527a;
    }

    public final void D(boolean z3) {
        this.f16402g = z3;
    }

    public final void E(@NotNull k.b<com.bxkj.base.v2.netty4android.client.command.a> listener) {
        f0.p(listener, "listener");
        this.f16400e = listener;
    }

    public final void n() {
        if (this.f16406k) {
            return;
        }
        new b().start();
    }

    public final void q() {
        j.d("\u5ba2\u6237\u7aef\u4e3b\u52a8\u65ad\u5f00\u8fde\u63a5", new Object[0]);
        this.f16405j = false;
        EventLoopGroup eventLoopGroup = this.f16399d;
        if (eventLoopGroup == null) {
            return;
        }
        eventLoopGroup.shutdownGracefully();
    }

    public final boolean r() {
        return this.f16402g;
    }

    public final long s() {
        return this.f16408m;
    }

    public final int t() {
        return this.f16398c;
    }

    public final int u() {
        return this.f16403h;
    }

    public final long v() {
        return this.f16407l;
    }

    public final boolean w() {
        return this.f16409n;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [io.netty.channel.ChannelFuture] */
    @Nullable
    public final ChannelFuture y(@NotNull com.bxkj.base.v2.netty4android.client.command.a data, @Nullable final k.a aVar) {
        f0.p(data, "data");
        Channel channel = this.f16401f;
        if (channel == null) {
            return null;
        }
        if (!r()) {
            channel = null;
        }
        if (channel == null) {
            return null;
        }
        channel.writeAndFlush(data);
        return channel.writeAndFlush(data).addListener(new GenericFutureListener() { // from class: com.bjtsn.base.v2.netty4android.client.c
            @Override // io.netty.util.concurrent.GenericFutureListener
            public final void operationComplete(Future future) {
                d.A(k.a.this, future);
            }
        });
    }

    public final boolean z(@NotNull com.bxkj.base.v2.netty4android.client.command.a data) {
        f0.p(data, "data");
        Channel channel = this.f16401f;
        if (channel != null && r()) {
            return channel.writeAndFlush(data).awaitUninterruptibly().isSuccess();
        }
        return false;
    }
}

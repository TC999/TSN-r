package com.tsn.chat.utils;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import java.util.concurrent.CountDownLatch;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: SocketUtil.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class d extends Thread {

    /* renamed from: c  reason: collision with root package name */
    private static NioEventLoopGroup f52414c;

    /* renamed from: d  reason: collision with root package name */
    private static CountDownLatch f52415d;

    /* renamed from: a  reason: collision with root package name */
    String f52416a;

    /* renamed from: b  reason: collision with root package name */
    int f52417b;

    public d() {
    }

    /* JADX WARN: Type inference failed for: r5v6, types: [io.netty.util.concurrent.Future, io.netty.channel.ChannelFuture] */
    public static void a(String str, int i4) {
        if (b.f52404b.equals("")) {
            b.f52404b = "linking";
            if (b.f52403a.size() > 0) {
                b.f52403a.close();
                b.f52403a.clear();
            }
            NioEventLoopGroup nioEventLoopGroup = new NioEventLoopGroup();
            try {
                try {
                    Bootstrap bootstrap = new Bootstrap();
                    bootstrap.group(nioEventLoopGroup);
                    bootstrap.channel(NioSocketChannel.class);
                    bootstrap.option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 5000);
                    bootstrap.option(ChannelOption.TCP_NODELAY, Boolean.TRUE);
                    bootstrap.handler(new com.tsn.chat.handler.d());
                    ?? sync = bootstrap.connect(str, i4).sync();
                    if (sync.isSuccess()) {
                        b.f52403a.add(sync.channel());
                        f52415d.countDown();
                    }
                    sync.channel().closeFuture().await();
                } catch (Exception unused) {
                    b.f52403a.clear();
                    f52415d.countDown();
                    b.f52404b = "";
                    y0.a.a().b();
                }
            } finally {
                nioEventLoopGroup.shutdownGracefully();
            }
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        a(this.f52416a, this.f52417b);
    }

    public d(String str, int i4, CountDownLatch countDownLatch) {
        this.f52416a = str;
        this.f52417b = i4;
        f52415d = countDownLatch;
    }
}

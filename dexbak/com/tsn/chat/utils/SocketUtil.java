package com.tsn.chat.utils;

import com.tsn.chat.handler.MyClientInitializer;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import java.util.concurrent.CountDownLatch;
import p660y0.BaseApplication;

/* renamed from: com.tsn.chat.utils.d */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class SocketUtil extends Thread {

    /* renamed from: c */
    private static NioEventLoopGroup f37516c;

    /* renamed from: d */
    private static CountDownLatch f37517d;

    /* renamed from: a */
    String f37518a;

    /* renamed from: b */
    int f37519b;

    public SocketUtil() {
    }

    /* JADX WARN: Type inference failed for: r5v6, types: [io.netty.util.concurrent.Future, io.netty.channel.ChannelFuture] */
    /* renamed from: a */
    public static void m14857a(String str, int i) {
        if (Global.f37506b.equals("")) {
            Global.f37506b = "linking";
            if (Global.f37505a.size() > 0) {
                Global.f37505a.close();
                Global.f37505a.clear();
            }
            NioEventLoopGroup nioEventLoopGroup = new NioEventLoopGroup();
            try {
                try {
                    Bootstrap bootstrap = new Bootstrap();
                    bootstrap.group(nioEventLoopGroup);
                    bootstrap.channel(NioSocketChannel.class);
                    bootstrap.option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 5000);
                    bootstrap.option(ChannelOption.TCP_NODELAY, Boolean.TRUE);
                    bootstrap.handler(new MyClientInitializer());
                    ?? sync = bootstrap.connect(str, i).sync();
                    if (sync.isSuccess()) {
                        Global.f37505a.add(sync.channel());
                        f37517d.countDown();
                    }
                    sync.channel().closeFuture().await();
                } catch (Exception unused) {
                    Global.f37505a.clear();
                    f37517d.countDown();
                    Global.f37506b = "";
                    BaseApplication.m38a().mo27b();
                }
            } finally {
                nioEventLoopGroup.shutdownGracefully();
            }
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        m14857a(this.f37518a, this.f37519b);
    }

    public SocketUtil(String str, int i, CountDownLatch countDownLatch) {
        this.f37518a = str;
        this.f37519b = i;
        f37517d = countDownLatch;
    }
}

package com.kwad.sdk.p438ip.direct;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.utils.C11064bn;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.LinkedList;

/* renamed from: com.kwad.sdk.ip.direct.b */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10812b {
    private static Handler aIn = new Handler(Looper.getMainLooper());
    static int aIx = 80;
    static int port = 80;

    /* renamed from: com.kwad.sdk.ip.direct.b$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    static class C10813a extends Thread {
        LinkedList aIz = new LinkedList();
        volatile boolean aIA = false;
        Selector aIy = Selector.open();

        C10813a() {
            setName("Connector");
        }

        /* renamed from: IN */
        private void m24763IN() {
            synchronized (this.aIz) {
                while (this.aIz.size() > 0) {
                    C10815b c10815b = (C10815b) this.aIz.removeFirst();
                    c10815b.aIE.register(this.aIy, 8, c10815b);
                }
            }
        }

        /* renamed from: IO */
        private void m24762IO() {
            Iterator<SelectionKey> it = this.aIy.selectedKeys().iterator();
            while (it.hasNext()) {
                SelectionKey next = it.next();
                it.remove();
                C10815b c10815b = (C10815b) next.attachment();
                SocketChannel socketChannel = (SocketChannel) next.channel();
                try {
                    if (socketChannel.finishConnect()) {
                        next.cancel();
                        c10815b.aIJ = SystemClock.elapsedRealtime();
                        socketChannel.close();
                    }
                } catch (Throwable th) {
                    C11064bn.m23859c(socketChannel);
                    c10815b.aIF = th;
                }
            }
        }

        /* renamed from: a */
        final void m24761a(C10815b c10815b) {
            final SocketChannel socketChannel;
            try {
                socketChannel = SocketChannel.open();
                try {
                    socketChannel.configureBlocking(false);
                    boolean connect = socketChannel.connect(c10815b.aID);
                    c10815b.aIE = socketChannel;
                    long elapsedRealtime = SystemClock.elapsedRealtime();
                    c10815b.aII = elapsedRealtime;
                    if (connect) {
                        c10815b.aIJ = elapsedRealtime;
                        C11064bn.m23859c(socketChannel);
                    } else {
                        synchronized (this.aIz) {
                            this.aIz.add(c10815b);
                        }
                        Selector selector = this.aIy;
                        if (selector != null) {
                            try {
                                selector.wakeup();
                            } catch (Throwable unused) {
                            }
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    try {
                        C11064bn.m23859c(socketChannel);
                        c10815b.aIF = th;
                        try {
                            C10812b.aIn.postDelayed(new Runnable() { // from class: com.kwad.sdk.ip.direct.b.a.1
                                @Override // java.lang.Runnable
                                public final void run() {
                                    C11064bn.m23859c(socketChannel);
                                }
                            }, c10815b.aIH);
                        } catch (Throwable unused2) {
                        }
                    } finally {
                        try {
                            C10812b.aIn.postDelayed(new Runnable() { // from class: com.kwad.sdk.ip.direct.b.a.1
                                @Override // java.lang.Runnable
                                public final void run() {
                                    C11064bn.m23859c(socketChannel);
                                }
                            }, c10815b.aIH);
                        } catch (Throwable unused3) {
                        }
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                socketChannel = null;
            }
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public final void run() {
            while (true) {
                try {
                    if (this.aIy.select() > 0) {
                        m24762IO();
                    }
                    m24763IN();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
                if (this.aIA) {
                    Selector selector = this.aIy;
                    if (selector != null) {
                        try {
                            selector.close();
                            return;
                        } catch (IOException unused) {
                            return;
                        }
                    }
                    return;
                }
                continue;
            }
        }

        final void shutdown() {
            this.aIA = true;
            Selector selector = this.aIy;
            if (selector != null) {
                try {
                    selector.wakeup();
                } catch (Throwable unused) {
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.kwad.sdk.ip.direct.b$b */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class C10815b {
        InetSocketAddress aID;
        SocketChannel aIE;
        Throwable aIF;
        private float aIG;
        long aIH;
        long aII;
        long aIJ = 0;
        boolean aIK = false;
        private boolean success;

        C10815b(String str) {
            try {
                this.aID = new InetSocketAddress(InetAddress.getByName(str), C10812b.port);
            } catch (Throwable th) {
                this.aIF = th;
            }
        }

        /* renamed from: IP */
        final void m24760IP() {
            String str;
            if (this.aIJ != 0) {
                str = Long.toString(this.aIJ - this.aII) + "ms";
                this.aIG = (float) (this.aIJ - this.aII);
                this.success = true;
            } else {
                Throwable th = this.aIF;
                if (th != null) {
                    str = th.toString();
                    this.success = false;
                } else {
                    this.success = false;
                    str = "Timed out";
                }
            }
            C10331c.m26254d("IpDirect_Ping", this.aID + " : " + str);
            this.aIK = true;
        }
    }

    /* renamed from: f */
    public static C10816c m24764f(String str, long j) {
        C10813a c10813a;
        long j2 = j / 5;
        C10331c.m26254d("IpDirect_Ping", "ping:" + str);
        C10816c c10816c = new C10816c(str);
        try {
            c10813a = new C10813a();
        } catch (Throwable th) {
            th.printStackTrace();
            c10813a = null;
        }
        if (c10813a == null) {
            return c10816c;
        }
        try {
            c10813a.start();
            LinkedList linkedList = new LinkedList();
            for (int i = 0; i < c10816c.m24757IQ(); i++) {
                C10815b c10815b = new C10815b(str);
                c10815b.aIH = j + j2;
                linkedList.add(c10815b);
                try {
                    c10813a.m24761a(c10815b);
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            }
            try {
                Thread.sleep(j + j2);
                try {
                    c10813a.shutdown();
                    c10813a.join();
                    float f = 0.0f;
                    Iterator it = linkedList.iterator();
                    boolean z = true;
                    while (it.hasNext()) {
                        C10815b c10815b2 = (C10815b) it.next();
                        c10815b2.m24760IP();
                        z &= c10815b2.success;
                        c10816c.m24754bC(z);
                        f += c10815b2.aIG;
                    }
                    C10331c.m26254d("IpDirect_Ping", "sum:" + f + "*size:" + linkedList.size());
                    c10816c.m24752i(f / ((float) linkedList.size()));
                    return c10816c;
                } catch (Throwable th3) {
                    th3.printStackTrace();
                    return c10816c;
                }
            } catch (Throwable th4) {
                th4.printStackTrace();
                return c10816c;
            }
        } catch (Throwable th5) {
            th5.printStackTrace();
            return c10816c;
        }
    }
}

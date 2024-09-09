package com.kwad.sdk.ip.direct;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.kwad.sdk.utils.bn;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.LinkedList;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class b {
    private static Handler aIn = new Handler(Looper.getMainLooper());
    static int aIx = 80;
    static int port = 80;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    static class a extends Thread {
        LinkedList aIz = new LinkedList();
        volatile boolean aIA = false;
        Selector aIy = Selector.open();

        a() {
            setName("Connector");
        }

        private void IN() {
            synchronized (this.aIz) {
                while (this.aIz.size() > 0) {
                    C0712b c0712b = (C0712b) this.aIz.removeFirst();
                    c0712b.aIE.register(this.aIy, 8, c0712b);
                }
            }
        }

        private void IO() {
            Iterator<SelectionKey> it = this.aIy.selectedKeys().iterator();
            while (it.hasNext()) {
                SelectionKey next = it.next();
                it.remove();
                C0712b c0712b = (C0712b) next.attachment();
                SocketChannel socketChannel = (SocketChannel) next.channel();
                try {
                    if (socketChannel.finishConnect()) {
                        next.cancel();
                        c0712b.aIJ = SystemClock.elapsedRealtime();
                        socketChannel.close();
                    }
                } catch (Throwable th) {
                    bn.c(socketChannel);
                    c0712b.aIF = th;
                }
            }
        }

        final void a(C0712b c0712b) {
            final SocketChannel socketChannel;
            try {
                socketChannel = SocketChannel.open();
                try {
                    socketChannel.configureBlocking(false);
                    boolean connect = socketChannel.connect(c0712b.aID);
                    c0712b.aIE = socketChannel;
                    long elapsedRealtime = SystemClock.elapsedRealtime();
                    c0712b.aII = elapsedRealtime;
                    if (connect) {
                        c0712b.aIJ = elapsedRealtime;
                        bn.c(socketChannel);
                    } else {
                        synchronized (this.aIz) {
                            this.aIz.add(c0712b);
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
                        bn.c(socketChannel);
                        c0712b.aIF = th;
                        try {
                            b.aIn.postDelayed(new Runnable() { // from class: com.kwad.sdk.ip.direct.b.a.1
                                @Override // java.lang.Runnable
                                public final void run() {
                                    bn.c(socketChannel);
                                }
                            }, c0712b.aIH);
                        } catch (Throwable unused2) {
                        }
                    } finally {
                        try {
                            b.aIn.postDelayed(new Runnable() { // from class: com.kwad.sdk.ip.direct.b.a.1
                                @Override // java.lang.Runnable
                                public final void run() {
                                    bn.c(socketChannel);
                                }
                            }, c0712b.aIH);
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
                        IO();
                    }
                    IN();
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
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* renamed from: com.kwad.sdk.ip.direct.b$b  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public static class C0712b {
        InetSocketAddress aID;
        SocketChannel aIE;
        Throwable aIF;
        private float aIG;
        long aIH;
        long aII;
        long aIJ = 0;
        boolean aIK = false;
        private boolean success;

        C0712b(String str) {
            try {
                this.aID = new InetSocketAddress(InetAddress.getByName(str), b.port);
            } catch (Throwable th) {
                this.aIF = th;
            }
        }

        final void IP() {
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
            com.kwad.sdk.core.e.c.d("IpDirect_Ping", this.aID + " : " + str);
            this.aIK = true;
        }
    }

    public static c f(String str, long j4) {
        a aVar;
        long j5 = j4 / 5;
        com.kwad.sdk.core.e.c.d("IpDirect_Ping", "ping:" + str);
        c cVar = new c(str);
        try {
            aVar = new a();
        } catch (Throwable th) {
            th.printStackTrace();
            aVar = null;
        }
        if (aVar == null) {
            return cVar;
        }
        try {
            aVar.start();
            LinkedList linkedList = new LinkedList();
            for (int i4 = 0; i4 < cVar.IQ(); i4++) {
                C0712b c0712b = new C0712b(str);
                c0712b.aIH = j4 + j5;
                linkedList.add(c0712b);
                try {
                    aVar.a(c0712b);
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            }
            try {
                Thread.sleep(j4 + j5);
                try {
                    aVar.shutdown();
                    aVar.join();
                    float f4 = 0.0f;
                    Iterator it = linkedList.iterator();
                    boolean z3 = true;
                    while (it.hasNext()) {
                        C0712b c0712b2 = (C0712b) it.next();
                        c0712b2.IP();
                        z3 &= c0712b2.success;
                        cVar.bC(z3);
                        f4 += c0712b2.aIG;
                    }
                    com.kwad.sdk.core.e.c.d("IpDirect_Ping", "sum:" + f4 + "*size:" + linkedList.size());
                    cVar.i(f4 / ((float) linkedList.size()));
                    return cVar;
                } catch (Throwable th3) {
                    th3.printStackTrace();
                    return cVar;
                }
            } catch (Throwable th4) {
                th4.printStackTrace();
                return cVar;
            }
        } catch (Throwable th5) {
            th5.printStackTrace();
            return cVar;
        }
    }
}

package com.kwad.framework.filedownloader;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.kwad.framework.filedownloader.p353f.C9490b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;

/* renamed from: com.kwad.framework.filedownloader.j */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9506j {
    static int aeG = 10;
    static int aeH = 5;
    private final Executor aeC;
    private final LinkedBlockingQueue<InterfaceC9576t> aeD;
    private final Object aeE;
    private final ArrayList<InterfaceC9576t> aeF;
    private final Handler handler;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.kwad.framework.filedownloader.j$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static final class C9508a {
        private static final C9506j aeK = new C9506j((byte) 0);
    }

    /* renamed from: com.kwad.framework.filedownloader.j$b */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    static class C9509b implements Handler.Callback {
        private C9509b() {
        }

        /* renamed from: a */
        private static void m28475a(ArrayList<InterfaceC9576t> arrayList) {
            Iterator<InterfaceC9576t> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().mo28343uH();
            }
            arrayList.clear();
        }

        @Override // android.os.Handler.Callback
        public final boolean handleMessage(Message message) {
            int i = message.what;
            if (i == 1) {
                ((InterfaceC9576t) message.obj).mo28343uH();
            } else if (i == 2) {
                m28475a((ArrayList) message.obj);
                C9506j.m28478uD().push();
            }
            return true;
        }

        /* synthetic */ C9509b(byte b) {
            this();
        }
    }

    /* synthetic */ C9506j(byte b) {
        this();
    }

    /* renamed from: b */
    private void m28480b(InterfaceC9576t interfaceC9576t) {
        Handler handler = this.handler;
        handler.sendMessage(handler.obtainMessage(1, interfaceC9576t));
    }

    /* renamed from: c */
    private void m28479c(InterfaceC9576t interfaceC9576t) {
        synchronized (this.aeE) {
            this.aeD.offer(interfaceC9576t);
        }
        push();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void push() {
        synchronized (this.aeE) {
            if (this.aeF.isEmpty()) {
                if (this.aeD.isEmpty()) {
                    return;
                }
                int i = 0;
                if (!m28477uE()) {
                    this.aeD.drainTo(this.aeF);
                } else {
                    int i2 = aeG;
                    int min = Math.min(this.aeD.size(), aeH);
                    while (i < min) {
                        this.aeF.add(this.aeD.remove());
                        i++;
                    }
                    i = i2;
                }
                Handler handler = this.handler;
                handler.sendMessageDelayed(handler.obtainMessage(2, this.aeF), i);
            }
        }
    }

    /* renamed from: uD */
    public static C9506j m28478uD() {
        return C9508a.aeK;
    }

    /* renamed from: uE */
    private static boolean m28477uE() {
        return aeG > 0;
    }

    private C9506j() {
        this.aeC = C9490b.m28551o(5, "BlockCompleted");
        this.aeE = new Object();
        this.aeF = new ArrayList<>();
        this.handler = new Handler(Looper.getMainLooper(), new C9509b((byte) 0));
        this.aeD = new LinkedBlockingQueue<>();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public final void m28482a(InterfaceC9576t interfaceC9576t) {
        m28481a(interfaceC9576t, false);
    }

    /* renamed from: a */
    private void m28481a(final InterfaceC9576t interfaceC9576t, boolean z) {
        if (interfaceC9576t.mo28342uI()) {
            interfaceC9576t.mo28343uH();
        } else if (interfaceC9576t.mo28341uJ()) {
            this.aeC.execute(new Runnable() { // from class: com.kwad.framework.filedownloader.j.1
                @Override // java.lang.Runnable
                public final void run() {
                    interfaceC9576t.mo28343uH();
                }
            });
        } else {
            if (!m28477uE() && !this.aeD.isEmpty()) {
                synchronized (this.aeE) {
                    if (!this.aeD.isEmpty()) {
                        Iterator<InterfaceC9576t> it = this.aeD.iterator();
                        while (it.hasNext()) {
                            m28480b(it.next());
                        }
                    }
                    this.aeD.clear();
                }
            }
            if (!m28477uE()) {
                m28480b(interfaceC9576t);
            } else {
                m28479c(interfaceC9576t);
            }
        }
    }
}

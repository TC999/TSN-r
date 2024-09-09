package com.kwad.framework.filedownloader;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class j {
    static int aeG = 10;
    static int aeH = 5;
    private final Executor aeC;
    private final LinkedBlockingQueue<t> aeD;
    private final Object aeE;
    private final ArrayList<t> aeF;
    private final Handler handler;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public static final class a {
        private static final j aeK = new j((byte) 0);
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    static class b implements Handler.Callback {
        private b() {
        }

        private static void a(ArrayList<t> arrayList) {
            Iterator<t> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().uH();
            }
            arrayList.clear();
        }

        @Override // android.os.Handler.Callback
        public final boolean handleMessage(Message message) {
            int i4 = message.what;
            if (i4 == 1) {
                ((t) message.obj).uH();
            } else if (i4 == 2) {
                a((ArrayList) message.obj);
                j.uD().push();
            }
            return true;
        }

        /* synthetic */ b(byte b4) {
            this();
        }
    }

    /* synthetic */ j(byte b4) {
        this();
    }

    private void b(t tVar) {
        Handler handler = this.handler;
        handler.sendMessage(handler.obtainMessage(1, tVar));
    }

    private void c(t tVar) {
        synchronized (this.aeE) {
            this.aeD.offer(tVar);
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
                int i4 = 0;
                if (!uE()) {
                    this.aeD.drainTo(this.aeF);
                } else {
                    int i5 = aeG;
                    int min = Math.min(this.aeD.size(), aeH);
                    while (i4 < min) {
                        this.aeF.add(this.aeD.remove());
                        i4++;
                    }
                    i4 = i5;
                }
                Handler handler = this.handler;
                handler.sendMessageDelayed(handler.obtainMessage(2, this.aeF), i4);
            }
        }
    }

    public static j uD() {
        return a.aeK;
    }

    private static boolean uE() {
        return aeG > 0;
    }

    private j() {
        this.aeC = com.kwad.framework.filedownloader.f.b.o(5, "BlockCompleted");
        this.aeE = new Object();
        this.aeF = new ArrayList<>();
        this.handler = new Handler(Looper.getMainLooper(), new b((byte) 0));
        this.aeD = new LinkedBlockingQueue<>();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(t tVar) {
        a(tVar, false);
    }

    private void a(final t tVar, boolean z3) {
        if (tVar.uI()) {
            tVar.uH();
        } else if (tVar.uJ()) {
            this.aeC.execute(new Runnable() { // from class: com.kwad.framework.filedownloader.j.1
                @Override // java.lang.Runnable
                public final void run() {
                    tVar.uH();
                }
            });
        } else {
            if (!uE() && !this.aeD.isEmpty()) {
                synchronized (this.aeE) {
                    if (!this.aeD.isEmpty()) {
                        Iterator<t> it = this.aeD.iterator();
                        while (it.hasNext()) {
                            b(it.next());
                        }
                    }
                    this.aeD.clear();
                }
            }
            if (!uE()) {
                b(tVar);
            } else {
                c(tVar);
            }
        }
    }
}

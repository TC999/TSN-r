package javax.mail;

import java.util.Vector;
import javax.mail.event.MailEvent;

/* loaded from: E:\fuckcool\tsn\5406560.dex */
class EventQueue implements Runnable {
    private Thread qThread;
    private QueueElement head = null;
    private QueueElement tail = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static class QueueElement {
        MailEvent event;
        QueueElement next = null;
        QueueElement prev = null;
        Vector vector;

        QueueElement(MailEvent mailEvent, Vector vector) {
            this.event = mailEvent;
            this.vector = vector;
        }
    }

    public EventQueue() {
        Thread thread = new Thread(this, "JavaMail-EventQueue");
        this.qThread = thread;
        thread.setDaemon(true);
        this.qThread.start();
    }

    private synchronized QueueElement dequeue() throws InterruptedException {
        QueueElement queueElement;
        while (true) {
            queueElement = this.tail;
            if (queueElement != null) {
                break;
            }
            wait();
        }
        QueueElement queueElement2 = queueElement.prev;
        this.tail = queueElement2;
        if (queueElement2 == null) {
            this.head = null;
        } else {
            queueElement2.next = null;
        }
        queueElement.next = null;
        queueElement.prev = null;
        return queueElement;
    }

    public synchronized void enqueue(MailEvent mailEvent, Vector vector) {
        QueueElement queueElement = new QueueElement(mailEvent, vector);
        QueueElement queueElement2 = this.head;
        if (queueElement2 == null) {
            this.head = queueElement;
            this.tail = queueElement;
        } else {
            queueElement.next = queueElement2;
            queueElement2.prev = queueElement;
            this.head = queueElement;
        }
        notifyAll();
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0006 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:5:0x0007 A[Catch: InterruptedException -> 0x0024, TryCatch #2 {InterruptedException -> 0x0024, blocks: (B:2:0x0000, B:5:0x0007, B:6:0x000c, B:9:0x0013), top: B:18:0x0000 }] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void run() {
        /*
            r4 = this;
        L0:
            javax.mail.EventQueue$QueueElement r0 = r4.dequeue()     // Catch: java.lang.InterruptedException -> L24
            if (r0 != 0) goto L7
            goto L24
        L7:
            javax.mail.event.MailEvent r1 = r0.event     // Catch: java.lang.InterruptedException -> L24
            java.util.Vector r0 = r0.vector     // Catch: java.lang.InterruptedException -> L24
            r2 = 0
        Lc:
            int r3 = r0.size()     // Catch: java.lang.InterruptedException -> L24
            if (r2 < r3) goto L13
            goto L0
        L13:
            java.lang.Object r3 = r0.elementAt(r2)     // Catch: java.lang.Throwable -> L1b
            r1.dispatch(r3)     // Catch: java.lang.Throwable -> L1b
            goto L21
        L1b:
            r3 = move-exception
            boolean r3 = r3 instanceof java.lang.InterruptedException     // Catch: java.lang.InterruptedException -> L24
            if (r3 == 0) goto L21
            goto L24
        L21:
            int r2 = r2 + 1
            goto Lc
        L24:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: javax.mail.EventQueue.run():void");
    }

    void stop() {
        Thread thread = this.qThread;
        if (thread != null) {
            thread.interrupt();
            this.qThread = null;
        }
    }
}

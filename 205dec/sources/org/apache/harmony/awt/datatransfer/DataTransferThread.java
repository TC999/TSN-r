package org.apache.harmony.awt.datatransfer;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class DataTransferThread extends Thread {
    private final DTK dtk;

    public DataTransferThread(DTK dtk) {
        super("AWT-DataTransferThread");
        setDaemon(true);
        this.dtk = dtk;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        synchronized (this) {
            this.dtk.initDragAndDrop();
            notifyAll();
        }
        this.dtk.runEventLoop();
    }

    @Override // java.lang.Thread
    public void start() {
        synchronized (this) {
            super.start();
            try {
                wait();
            } catch (InterruptedException e4) {
                throw new RuntimeException(e4);
            }
        }
    }
}

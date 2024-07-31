package org.apache.harmony.awt.datatransfer;

/* loaded from: E:\fuckcool\tsn\5406560.dex */
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
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

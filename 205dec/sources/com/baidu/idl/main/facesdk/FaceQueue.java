package com.baidu.idl.main.facesdk;

import java.util.LinkedList;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class FaceQueue {
    private int nThreads;
    private LinkedList queue;
    private PoolWorker[] threads;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    private static class HolderClass {
        private static final FaceQueue instance = new FaceQueue(1);

        private HolderClass() {
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    private class PoolWorker extends Thread {
        private PoolWorker() {
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Runnable runnable;
            while (true) {
                synchronized (FaceQueue.this.queue) {
                    while (FaceQueue.this.queue.isEmpty()) {
                        try {
                            FaceQueue.this.queue.wait();
                        } catch (InterruptedException unused) {
                        }
                    }
                    runnable = (Runnable) FaceQueue.this.queue.removeFirst();
                }
                try {
                    runnable.run();
                } catch (RuntimeException e4) {
                    e4.printStackTrace();
                }
            }
        }
    }

    public FaceQueue(int i4) {
        this.queue = null;
        this.nThreads = i4;
        this.queue = new LinkedList();
        this.threads = new PoolWorker[i4];
        for (int i5 = 0; i5 < i4; i5++) {
            this.threads[i5] = new PoolWorker();
            this.threads[i5].start();
        }
    }

    public static FaceQueue getInstance() {
        return HolderClass.instance;
    }

    public void execute(Runnable runnable) {
        synchronized (this.queue) {
            this.queue.addLast(runnable);
            this.queue.notify();
        }
    }
}

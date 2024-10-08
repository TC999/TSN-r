package io.reactivex.internal.schedulers;

/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class ScheduledDirectPeriodicTask extends AbstractDirectTask implements Runnable {
    private static final long serialVersionUID = 1811839108042568751L;

    public ScheduledDirectPeriodicTask(Runnable runnable) {
        super(runnable);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.runner = Thread.currentThread();
        try {
            this.runnable.run();
        } finally {
            try {
            } finally {
            }
        }
    }
}

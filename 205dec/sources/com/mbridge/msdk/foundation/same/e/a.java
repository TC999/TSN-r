package com.mbridge.msdk.foundation.same.e;

/* compiled from: CommonTask.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public abstract class a implements Runnable {
    public static long id;
    public b mListener;
    public EnumC0740a mState = EnumC0740a.READY;

    /* compiled from: CommonTask.java */
    /* renamed from: com.mbridge.msdk.foundation.same.e.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public enum EnumC0740a {
        READY,
        RUNNING,
        PAUSE,
        CANCEL,
        FINISH
    }

    /* compiled from: CommonTask.java */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public interface b {
        void a(EnumC0740a enumC0740a);
    }

    public a() {
        id++;
    }

    private void setState(EnumC0740a enumC0740a) {
        this.mState = enumC0740a;
        b bVar = this.mListener;
        if (bVar != null) {
            bVar.a(enumC0740a);
        }
    }

    public final void cancel() {
        EnumC0740a enumC0740a = this.mState;
        EnumC0740a enumC0740a2 = EnumC0740a.CANCEL;
        if (enumC0740a != enumC0740a2) {
            setState(enumC0740a2);
            cancelTask();
        }
    }

    public abstract void cancelTask();

    public final long getId() {
        return id;
    }

    public EnumC0740a getState() {
        return this.mState;
    }

    public abstract void pauseTask(boolean z3);

    @Override // java.lang.Runnable
    public final void run() {
        try {
            if (this.mState == EnumC0740a.READY) {
                setState(EnumC0740a.RUNNING);
                runTask();
                setState(EnumC0740a.FINISH);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public abstract void runTask();

    public final void setPause(boolean z3) {
        EnumC0740a enumC0740a = this.mState;
        EnumC0740a enumC0740a2 = EnumC0740a.PAUSE;
        if (enumC0740a == enumC0740a2 || enumC0740a == EnumC0740a.CANCEL || enumC0740a == EnumC0740a.FINISH) {
            return;
        }
        if (z3) {
            setState(enumC0740a2);
        } else {
            setState(EnumC0740a.RUNNING);
        }
        pauseTask(z3);
    }

    public void setonStateChangeListener(b bVar) {
        this.mListener = bVar;
    }
}

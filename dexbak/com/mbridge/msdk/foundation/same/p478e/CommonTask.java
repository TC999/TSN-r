package com.mbridge.msdk.foundation.same.p478e;

/* renamed from: com.mbridge.msdk.foundation.same.e.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public abstract class CommonTask implements Runnable {

    /* renamed from: id */
    public static long f30665id;
    public InterfaceC11325b mListener;
    public EnumC11324a mState = EnumC11324a.READY;

    /* compiled from: CommonTask.java */
    /* renamed from: com.mbridge.msdk.foundation.same.e.a$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public enum EnumC11324a {
        READY,
        RUNNING,
        PAUSE,
        CANCEL,
        FINISH
    }

    /* compiled from: CommonTask.java */
    /* renamed from: com.mbridge.msdk.foundation.same.e.a$b */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public interface InterfaceC11325b {
        /* renamed from: a */
        void mo22311a(EnumC11324a enumC11324a);
    }

    public CommonTask() {
        f30665id++;
    }

    private void setState(EnumC11324a enumC11324a) {
        this.mState = enumC11324a;
        InterfaceC11325b interfaceC11325b = this.mListener;
        if (interfaceC11325b != null) {
            interfaceC11325b.mo22311a(enumC11324a);
        }
    }

    public final void cancel() {
        EnumC11324a enumC11324a = this.mState;
        EnumC11324a enumC11324a2 = EnumC11324a.CANCEL;
        if (enumC11324a != enumC11324a2) {
            setState(enumC11324a2);
            cancelTask();
        }
    }

    public abstract void cancelTask();

    public final long getId() {
        return f30665id;
    }

    public EnumC11324a getState() {
        return this.mState;
    }

    public abstract void pauseTask(boolean z);

    @Override // java.lang.Runnable
    public final void run() {
        try {
            if (this.mState == EnumC11324a.READY) {
                setState(EnumC11324a.RUNNING);
                runTask();
                setState(EnumC11324a.FINISH);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public abstract void runTask();

    public final void setPause(boolean z) {
        EnumC11324a enumC11324a = this.mState;
        EnumC11324a enumC11324a2 = EnumC11324a.PAUSE;
        if (enumC11324a == enumC11324a2 || enumC11324a == EnumC11324a.CANCEL || enumC11324a == EnumC11324a.FINISH) {
            return;
        }
        if (z) {
            setState(enumC11324a2);
        } else {
            setState(EnumC11324a.RUNNING);
        }
        pauseTask(z);
    }

    public void setonStateChangeListener(InterfaceC11325b interfaceC11325b) {
        this.mListener = interfaceC11325b;
    }
}

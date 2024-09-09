package com.bytedance.pangle.sdk.component.log.impl.net;

import java.util.UUID;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public abstract class TTRunnable implements Comparable<TTRunnable>, Runnable {
    private int mPriority;
    private String mRunnableUnique;
    private String name;

    public TTRunnable(String str, int i4) {
        this.mPriority = 0;
        this.mPriority = i4 == 0 ? 5 : i4;
        this.mRunnableUnique = UUID.randomUUID().toString() + "-" + String.valueOf(System.nanoTime());
        this.name = str;
    }

    public String getName() {
        return this.name;
    }

    public int getPriority() {
        return this.mPriority;
    }

    public String getUniqueCode() {
        return this.mRunnableUnique;
    }

    public void setPriority(int i4) {
        this.mPriority = i4;
    }

    @Override // java.lang.Comparable
    public int compareTo(TTRunnable tTRunnable) {
        if (getPriority() < tTRunnable.getPriority()) {
            return 1;
        }
        return getPriority() >= tTRunnable.getPriority() ? -1 : 0;
    }

    public TTRunnable(String str) {
        this.mPriority = 5;
        this.mRunnableUnique = UUID.randomUUID().toString() + "-" + String.valueOf(System.nanoTime());
        this.name = str;
    }
}

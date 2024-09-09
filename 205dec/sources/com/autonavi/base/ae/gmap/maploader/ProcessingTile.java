package com.autonavi.base.ae.gmap.maploader;

import com.autonavi.base.ae.gmap.maploader.Pools;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class ProcessingTile {
    private static final Pools.SynchronizedPool<ProcessingTile> M_POOL = new Pools.SynchronizedPool<>(30);
    public long mCreateTime = 0;
    public String mKeyName;

    public ProcessingTile(String str) {
        setParams(str);
    }

    public static ProcessingTile obtain(String str) {
        ProcessingTile acquire = M_POOL.acquire();
        if (acquire != null) {
            acquire.setParams(str);
            return acquire;
        }
        return new ProcessingTile(str);
    }

    private void setParams(String str) {
        this.mKeyName = str;
        this.mCreateTime = System.currentTimeMillis() / 1000;
    }

    public void recycle() {
        this.mKeyName = null;
        this.mCreateTime = 0L;
        M_POOL.release(this);
    }
}

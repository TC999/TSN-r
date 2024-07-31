package com.baidu.idl.main.facesdk.model;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class BDFaceInstance {
    private long index = 0;

    private native long nativeCreateInstance();

    private native long nativeGetDefautlInstance();

    private void setIndex(long j) {
        this.index = j;
    }

    public void creatInstance() {
        long nativeCreateInstance = nativeCreateInstance();
        this.index = nativeCreateInstance;
        setIndex(nativeCreateInstance);
    }

    public native int destory();

    public void getDefautlInstance() {
        setIndex(nativeGetDefautlInstance());
    }

    public long getIndex() {
        return this.index;
    }
}

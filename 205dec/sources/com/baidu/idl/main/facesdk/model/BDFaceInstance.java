package com.baidu.idl.main.facesdk.model;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class BDFaceInstance {
    private long index = 0;

    private native long nativeCreateInstance();

    private native long nativeGetDefautlInstance();

    private void setIndex(long j4) {
        this.index = j4;
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

package com.autonavi.base.ae.gmap;

import com.autonavi.base.amap.mapcore.jbinding.JBindingExclude;
import com.autonavi.base.amap.mapcore.jbinding.JBindingInclude;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
@JBindingInclude
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class ResourceCallback {
    private long instance;

    public ResourceCallback() {
        this.instance = 0L;
    }

    @JBindingExclude
    private static native void nativeCallCancel();

    @JBindingExclude
    private static native void nativeCallFailed(long j4, String str);

    @JBindingExclude
    private static native void nativeCallSuccess(long j4, AMapAppResourceItem aMapAppResourceItem);

    @JBindingExclude
    public void callCancel() {
        nativeCallCancel();
    }

    @JBindingExclude
    public void callFailed(String str) {
        nativeCallFailed(this.instance, str);
    }

    @JBindingExclude
    public void callSuccess(AMapAppResourceItem aMapAppResourceItem) {
        nativeCallSuccess(this.instance, aMapAppResourceItem);
    }

    @JBindingExclude
    public long getInstance() {
        return this.instance;
    }

    @JBindingExclude
    public void setInstance(long j4) {
        this.instance = j4;
    }

    public ResourceCallback(long j4) {
        this.instance = j4;
    }
}

package com.autonavi.base.p048ae.gmap;

import com.autonavi.base.amap.mapcore.jbinding.JBindingExclude;
import com.autonavi.base.amap.mapcore.jbinding.JBindingInclude;

@JBindingInclude
/* renamed from: com.autonavi.base.ae.gmap.ResourceCallback */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class ResourceCallback {
    private long instance;

    public ResourceCallback() {
        this.instance = 0L;
    }

    @JBindingExclude
    private static native void nativeCallCancel();

    @JBindingExclude
    private static native void nativeCallFailed(long j, String str);

    @JBindingExclude
    private static native void nativeCallSuccess(long j, AMapAppResourceItem aMapAppResourceItem);

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
    public void setInstance(long j) {
        this.instance = j;
    }

    public ResourceCallback(long j) {
        this.instance = j;
    }
}

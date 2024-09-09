package com.amap.api.maps.model;

import com.autonavi.base.amap.mapcore.jbinding.JBindingExclude;
import com.autonavi.base.amap.mapcore.jbinding.JBindingInclude;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
@JBindingInclude
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class BaseOptions {
    protected Object Field1;
    protected Object Field2;
    protected String type;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    @JBindingInclude
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static class BaseUpdateFlags {
        protected boolean zIndexUpdate = false;

        public void reset() {
            this.zIndexUpdate = false;
        }
    }

    protected BaseUpdateFlags getUpdateFlags() {
        return null;
    }

    protected Object method1(Object... objArr) {
        return null;
    }

    protected Object method2(Object... objArr) {
        return null;
    }

    @JBindingExclude
    public void resetUpdateFlags() {
    }
}

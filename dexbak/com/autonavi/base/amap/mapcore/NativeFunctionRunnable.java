package com.autonavi.base.amap.mapcore;

import androidx.core.graphics.C0262a;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class NativeFunctionRunnable {
    public static final String CLEAR_OVERLAY_FUNC = "clearOverlay";
    public static final String CREATE_OVERLAY_FUNC = "createOverlay";
    public static final String REMOVE_OVERLAY_FUNC = "removeOverlay";
    public static final String UPDATE_OPTIONS_FUNC = "updateOptions";
    private String name;
    private Runnable runnable;
    private String type;

    public NativeFunctionRunnable(String str, String str2, Runnable runnable) {
        this.type = str;
        this.name = str2;
        this.runnable = runnable;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        NativeFunctionRunnable nativeFunctionRunnable = (NativeFunctionRunnable) obj;
        if (C0262a.m60024a(this.type, nativeFunctionRunnable.type)) {
            return C0262a.m60024a(this.name, nativeFunctionRunnable.name);
        }
        return false;
    }

    public String getKey() {
        return this.type + "_" + this.name;
    }

    public Runnable getRunnable() {
        return this.runnable;
    }

    public int hashCode() {
        String str = this.type;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.name;
        return hashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "NativeFunctionRunnable{type='" + this.type + "', name='" + this.name + "', runnable=" + this.runnable + '}';
    }
}

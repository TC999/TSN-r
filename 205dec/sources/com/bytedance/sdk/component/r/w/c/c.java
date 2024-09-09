package com.bytedance.sdk.component.r.w.c;

import java.util.List;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public abstract class c {
    public List<com.bytedance.sdk.component.r.c.w> c(int i4, com.bytedance.sdk.component.r.c.w wVar, List<String> list, String str) {
        if (com.bytedance.sdk.component.r.w.xv.c.c(i4)) {
            return w(i4, wVar, list, str);
        }
        if (c(wVar)) {
            return w(i4, wVar, list, str);
        }
        return null;
    }

    public abstract boolean c(com.bytedance.sdk.component.r.c.w wVar);

    public abstract boolean c(String str);

    public abstract List<com.bytedance.sdk.component.r.c.w> w(int i4, com.bytedance.sdk.component.r.c.w wVar, List<String> list, String str);

    public abstract boolean w(int i4, String str, com.bytedance.sdk.component.r.c.w wVar);

    public boolean c(int i4, String str, com.bytedance.sdk.component.r.c.w wVar) {
        if (com.bytedance.sdk.component.r.w.xv.c.c(i4)) {
            return c(str);
        }
        if (c(wVar)) {
            return w(i4, str, wVar);
        }
        return false;
    }
}

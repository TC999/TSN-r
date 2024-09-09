package com.bytedance.msdk.core.bk;

import android.text.TextUtils;
import com.bykv.vk.openvk.api.proto.Bridge;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class c {

    /* renamed from: c  reason: collision with root package name */
    private static volatile c f27836c;
    private Bridge ux;
    private w xv;

    /* renamed from: w  reason: collision with root package name */
    private boolean f27837w = false;
    private boolean sr = false;

    private c() {
    }

    public static c c() {
        if (f27836c == null) {
            synchronized (c.class) {
                if (f27836c == null) {
                    f27836c = new c();
                }
            }
        }
        return f27836c;
    }

    public Bridge f() {
        return this.ux;
    }

    public void sr() {
        w wVar = this.xv;
        if (wVar != null) {
            wVar.c();
        }
    }

    public void ux() {
        this.sr = true;
    }

    public void w() {
        this.f27837w = true;
    }

    public boolean xv() {
        return this.f27837w;
    }

    public boolean c(String str, int i4) {
        return c(str) || com.bytedance.msdk.core.c.w().c(str, i4, 101) != null;
    }

    private boolean c(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if ("200000000".equals(str)) {
            return true;
        }
        return str.matches("^1[0-9]{8}$");
    }

    public void c(w wVar) {
        this.xv = wVar;
    }

    public void c(int i4, String str) {
        w wVar = this.xv;
        if (wVar != null) {
            wVar.c(i4, str);
        }
    }

    public void c(Bridge bridge) {
        this.ux = bridge;
    }
}

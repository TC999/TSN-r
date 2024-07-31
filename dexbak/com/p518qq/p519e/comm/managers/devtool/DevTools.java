package com.p518qq.p519e.comm.managers.devtool;

import android.content.Context;
import android.text.TextUtils;

/* renamed from: com.qq.e.comm.managers.devtool.DevTools */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class DevTools {

    /* renamed from: a */
    private String f32908a;

    public String getDemoGameUrl() {
        String str = this.f32908a;
        this.f32908a = null;
        return str;
    }

    public void testDemoGame(Context context, String str) {
        if (!TextUtils.isEmpty(str) && context.getPackageName().equals("com.qq.e.union.demo.union")) {
            this.f32908a = str;
        }
    }
}

package com.qq.e.comm.plugin.y;

import android.content.Context;
import android.text.TextUtils;
import com.qq.e.comm.plugin.g0.e;
import com.qq.e.comm.plugin.util.f1;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    static final int f46785a = f1.a(com.qq.e.comm.plugin.d0.a.d().a(), 35);

    public static b a(Context context, e eVar) {
        if (context == null || eVar == null) {
            return null;
        }
        return new c(context, "\u70b9\u51fb" + b(eVar));
    }

    public static String b(e eVar) {
        if (eVar.X0()) {
            return com.qq.e.comm.plugin.d0.a.d().f().a("srat", eVar.q0(), "\u4e0b\u8f7d\u6216\u8df3\u8f6c\u7b2c\u4e09\u65b9\u5e94\u7528");
        }
        return com.qq.e.comm.plugin.d0.a.d().f().a("srlt", eVar.q0(), "\u8df3\u8f6c\u8be6\u60c5\u6216\u7b2c\u4e09\u65b9\u5e94\u7528");
    }

    public static String a(e eVar) {
        if (TextUtils.isEmpty(eVar.m0())) {
            return eVar.m1() ? "\u53bb\u5fae\u4fe1\u770b\u770b" : eVar.X0() ? "\u70b9\u51fb\u4e0b\u8f7d\u6216\u8df3\u8f6c\u7b2c\u4e09\u65b9\u5e94\u7528" : "\u70b9\u51fb\u8df3\u8f6c\u8be6\u60c5\u6216\u7b2c\u4e09\u65b9\u5e94\u7528";
        }
        return eVar.m0();
    }
}

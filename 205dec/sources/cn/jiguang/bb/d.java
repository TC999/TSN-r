package cn.jiguang.bb;

import android.annotation.SuppressLint;
import android.content.Context;
import java.util.ArrayList;

@SuppressLint({"MissingPermission"})
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static final byte[] f2552a = {113, 116, 68, 115, 108, 106, 101, 114, 66, 73, 123, 109, 100, 88, 84};

    /* renamed from: b  reason: collision with root package name */
    private static int f2553b;

    public static ArrayList<cn.jiguang.ba.a> a(Context context) {
        if (cn.jiguang.ah.d.a(context, false, "do not get sim info")) {
            return null;
        }
        cn.jiguang.ah.d.a(context, "android.permission.READ_PHONE_STATE");
        return null;
    }
}

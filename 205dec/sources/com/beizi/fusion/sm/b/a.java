package com.beizi.fusion.sm.b;

import android.content.Context;
import android.text.TextUtils;
import com.beizi.fusion.sm.b.a.l;

/* compiled from: DeviceID.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class a implements b {

    /* renamed from: a  reason: collision with root package name */
    private String f15074a;

    public static void a(Context context, b bVar) {
        l.a(context).a(bVar);
    }

    @Override // com.beizi.fusion.sm.b.b
    public void a(Exception exc) {
    }

    public static boolean a(Context context) {
        return l.a(context).a();
    }

    @Override // com.beizi.fusion.sm.b.b
    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            a(new d("OAID is empty"));
        } else {
            this.f15074a = str;
        }
    }
}

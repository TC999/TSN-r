package com.baidu.mobads.sdk.internal;

import androidx.annotation.NonNull;
import com.baidu.mobads.sdk.api.IXAdContainerFactory;
import com.bytedance.pangle.sdk.component.log.impl.cache.db.TTPathConst;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class ay extends ax {

    /* renamed from: b  reason: collision with root package name */
    public static final String f12445b = "logout";

    /* renamed from: c  reason: collision with root package name */
    private static final String[] f12446c = {"#", "#", "V", "D", "I", "W", "E", "A"};

    @Override // com.baidu.mobads.sdk.internal.ax, com.baidu.mobads.sdk.internal.az.a
    @NonNull
    String a() {
        return "logout";
    }

    @Override // com.baidu.mobads.sdk.internal.ax, com.baidu.mobads.sdk.internal.az.a
    protected void a(int i4, String str, String str2, Throwable th) {
        try {
            IXAdContainerFactory c4 = aa.a().c();
            if (c4 != null) {
                c4.getRemoteParam("debugLogout", (new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS", Locale.getDefault()).format(new Date()) + " " + f12446c[i4] + TTPathConst.sSeparator + str + ": ") + "\u5f53\u524d\u7ebf\u7a0b\uff1a" + Thread.currentThread().getName() + ";  \u8c03\u7528\u4f4d\u7f6e\uff1a" + c() + ";  \u6253\u5370\u6d88\u606f\uff1a" + str2 + "\n");
            }
        } catch (Throwable unused) {
        }
    }
}

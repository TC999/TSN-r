package com.baidu.mobads.sdk.internal;

import androidx.annotation.NonNull;
import androidx.exifinterface.media.ExifInterface;
import com.baidu.mobads.sdk.api.IXAdContainerFactory;
import com.snail.antifake.deviceid.ShellAdbUtils;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* renamed from: com.baidu.mobads.sdk.internal.av */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class C2606av extends C2605au {

    /* renamed from: b */
    public static final String f8628b = "logout";

    /* renamed from: c */
    private static final String[] f8629c = {"#", "#", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "D", "I", ExifInterface.LONGITUDE_WEST, ExifInterface.LONGITUDE_EAST, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS};

    @Override // com.baidu.mobads.sdk.internal.C2605au, com.baidu.mobads.sdk.internal.C2607aw.AbstractC2608a
    @NonNull
    /* renamed from: a */
    String mo50887a() {
        return f8628b;
    }

    @Override // com.baidu.mobads.sdk.internal.C2605au, com.baidu.mobads.sdk.internal.C2607aw.AbstractC2608a
    /* renamed from: a */
    protected void mo50885a(int i, String str, String str2, Throwable th) {
        try {
            IXAdContainerFactory m51049c = C2580aa.m51057a().m51049c();
            if (m51049c != null) {
                m51049c.getRemoteParam("debugLogout", (new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS", Locale.getDefault()).format(new Date()) + " " + f8629c[i] + "/" + str + ": ") + "当前线程：" + Thread.currentThread().getName() + ";  调用位置：" + m50938c() + ";  打印消息：" + str2 + ShellAdbUtils.f33810d);
            }
        } catch (Throwable unused) {
        }
    }
}

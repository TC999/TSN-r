package defpackage;

import android.os.SystemProperties;
import android.text.TextUtils;
import android.util.Log;

/* renamed from: K0  reason: default package */
/* loaded from: E:\TSN-r\205dec\155424.dex */
public abstract class K0 {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f35a = !TextUtils.isEmpty(SystemProperties.get("ro.miui.ui.version.name"));

    static {
        TextUtils.isEmpty(SystemProperties.get("ro.lenovo.region"));
    }

    public static void a(String str, Throwable th) {
        Log.e("LSPosed", str, th);
    }
}

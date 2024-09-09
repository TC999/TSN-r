package bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_case1;

import android.text.TextUtils;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: CommonPermissionUtils.java */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static final Map<String, InterfaceC0019a> f302a = Collections.synchronizedMap(new HashMap());

    /* compiled from: CommonPermissionUtils.java */
    /* renamed from: bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_case1.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6276784.dex */
    public interface InterfaceC0019a {
        void a();

        void a(String str);
    }

    public static void a(String str) {
        InterfaceC0019a b4;
        if (TextUtils.isEmpty(str) || (b4 = b(str)) == null) {
            return;
        }
        b4.a();
    }

    private static InterfaceC0019a b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return f302a.remove(str);
    }

    public static void a(String str, String str2) {
        InterfaceC0019a b4;
        if (TextUtils.isEmpty(str) || (b4 = b(str)) == null) {
            return;
        }
        b4.a(str2);
    }
}

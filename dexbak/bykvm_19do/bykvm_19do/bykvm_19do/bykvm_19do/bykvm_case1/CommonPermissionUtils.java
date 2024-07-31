package bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_case1;

import android.text.TextUtils;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* renamed from: bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_case1.a */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class CommonPermissionUtils {

    /* renamed from: a */
    private static final Map<String, InterfaceC0945a> f305a = Collections.synchronizedMap(new HashMap());

    /* compiled from: CommonPermissionUtils.java */
    /* renamed from: bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_case1.a$a */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public interface InterfaceC0945a {
        /* renamed from: a */
        void m59831a();

        /* renamed from: a */
        void m59830a(String str);
    }

    /* renamed from: a */
    public static void m59834a(String str) {
        InterfaceC0945a m59832b;
        if (TextUtils.isEmpty(str) || (m59832b = m59832b(str)) == null) {
            return;
        }
        m59832b.m59831a();
    }

    /* renamed from: b */
    private static InterfaceC0945a m59832b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return f305a.remove(str);
    }

    /* renamed from: a */
    public static void m59833a(String str, String str2) {
        InterfaceC0945a m59832b;
        if (TextUtils.isEmpty(str) || (m59832b = m59832b(str)) == null) {
            return;
        }
        m59832b.m59830a(str2);
    }
}

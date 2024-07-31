package com.bytedance.pangle.receiver;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.pangle.util.FieldUtils;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* renamed from: com.bytedance.pangle.receiver.b */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class C6191b {

    /* renamed from: a */
    private static final InterfaceC6194c f22127a;

    /* renamed from: com.bytedance.pangle.receiver.b$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    static class C6192a implements InterfaceC6194c {
        private C6192a() {
        }

        /* renamed from: b */
        private static Object m37019b(Context context) {
            Field field;
            Object readField;
            try {
                Field field2 = FieldUtils.getField(Class.forName("android.app.LoadedApk"), "mReceiverResource");
                if (field2 == null || (field = FieldUtils.getField(Class.forName("android.app.ContextImpl"), "mPackageInfo")) == null || (readField = FieldUtils.readField(field, context)) == null) {
                    return null;
                }
                return FieldUtils.readField(field2, readField);
            } catch (Throwable unused) {
                return null;
            }
        }

        @Override // com.bytedance.pangle.receiver.C6191b.InterfaceC6194c
        /* renamed from: a */
        public boolean mo37018a(Context context) {
            Object m37019b = m37019b(context);
            Object m37020a = m37020a(m37019b, "mWhiteList");
            if (!(m37020a instanceof String[])) {
                if (m37019b != null) {
                    FieldUtils.writeField(m37019b, "mResourceConfig", (Object) null);
                    return false;
                }
                return false;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(context.getPackageName());
            Collections.addAll(arrayList, (String[]) m37020a);
            FieldUtils.writeField(m37019b, "mWhiteList", arrayList.toArray(new String[arrayList.size()]));
            return true;
        }

        /* synthetic */ C6192a(byte b) {
            this();
        }

        /* renamed from: a */
        static Object m37021a(Context context, String str) {
            return m37020a(m37019b(context), str);
        }

        /* renamed from: a */
        private static Object m37020a(Object obj, String str) {
            if (obj != null) {
                try {
                    return FieldUtils.readField(obj, str);
                } catch (Throwable unused) {
                    return null;
                }
            }
            return null;
        }
    }

    /* renamed from: com.bytedance.pangle.receiver.b$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    static class C6193b extends C6196e {
        private C6193b() {
            super((byte) 0);
        }

        @Override // com.bytedance.pangle.receiver.C6191b.C6196e, com.bytedance.pangle.receiver.C6191b.C6192a, com.bytedance.pangle.receiver.C6191b.InterfaceC6194c
        /* renamed from: a */
        public final boolean mo37018a(Context context) {
            return false;
        }

        /* synthetic */ C6193b(byte b) {
            this();
        }
    }

    /* renamed from: com.bytedance.pangle.receiver.b$c */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    interface InterfaceC6194c {
        /* renamed from: a */
        boolean mo37018a(Context context);
    }

    /* renamed from: com.bytedance.pangle.receiver.b$d */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    static class C6195d extends C6192a {
        private C6195d() {
            super((byte) 0);
        }

        @Override // com.bytedance.pangle.receiver.C6191b.C6192a, com.bytedance.pangle.receiver.C6191b.InterfaceC6194c
        /* renamed from: a */
        public final boolean mo37018a(Context context) {
            Object m37021a = C6192a.m37021a(context, "mWhiteList");
            if (m37021a instanceof List) {
                ((List) m37021a).add(context.getPackageName());
                return true;
            }
            return false;
        }

        /* synthetic */ C6195d(byte b) {
            this();
        }
    }

    /* renamed from: com.bytedance.pangle.receiver.b$e */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    static class C6196e extends C6192a {
        private C6196e() {
            super((byte) 0);
        }

        @Override // com.bytedance.pangle.receiver.C6191b.C6192a, com.bytedance.pangle.receiver.C6191b.InterfaceC6194c
        /* renamed from: a */
        public boolean mo37018a(Context context) {
            Object m37021a = C6192a.m37021a(context, "mWhiteListMap");
            if (m37021a instanceof Map) {
                Map map = (Map) m37021a;
                List list = (List) map.get(0);
                if (list == null) {
                    list = new ArrayList();
                    map.put(0, list);
                }
                list.add(context.getPackageName());
                return true;
            }
            return false;
        }

        /* synthetic */ C6196e(byte b) {
            this();
        }
    }

    static {
        int i = Build.VERSION.SDK_INT;
        if (i < 24) {
            f22127a = new C6192a((byte) 0);
        } else if (i < 26) {
            f22127a = new C6195d((byte) 0);
        } else if (i < 28) {
            f22127a = new C6196e((byte) 0);
        } else {
            f22127a = new C6193b((byte) 0);
        }
    }

    /* renamed from: a */
    public static void m37022a(Application application) {
        if (application != null) {
            try {
                if (TextUtils.equals(Build.BRAND.toLowerCase(), "huawei")) {
                    f22127a.mo37018a(application.getBaseContext());
                }
            } catch (Throwable unused) {
            }
        }
    }
}

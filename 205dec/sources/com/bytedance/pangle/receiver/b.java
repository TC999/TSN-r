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

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    private static final c f28888a;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    static class a implements c {
        private a() {
        }

        private static Object b(Context context) {
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

        @Override // com.bytedance.pangle.receiver.b.c
        public boolean a(Context context) {
            Object b4 = b(context);
            Object a4 = a(b4, "mWhiteList");
            if (!(a4 instanceof String[])) {
                if (b4 != null) {
                    FieldUtils.writeField(b4, "mResourceConfig", (Object) null);
                    return false;
                }
                return false;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(context.getPackageName());
            Collections.addAll(arrayList, (String[]) a4);
            FieldUtils.writeField(b4, "mWhiteList", arrayList.toArray(new String[arrayList.size()]));
            return true;
        }

        /* synthetic */ a(byte b4) {
            this();
        }

        static Object a(Context context, String str) {
            return a(b(context), str);
        }

        private static Object a(Object obj, String str) {
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

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* renamed from: com.bytedance.pangle.receiver.b$b  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    static class C0431b extends e {
        private C0431b() {
            super((byte) 0);
        }

        @Override // com.bytedance.pangle.receiver.b.e, com.bytedance.pangle.receiver.b.a, com.bytedance.pangle.receiver.b.c
        public final boolean a(Context context) {
            return false;
        }

        /* synthetic */ C0431b(byte b4) {
            this();
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    interface c {
        boolean a(Context context);
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    static class d extends a {
        private d() {
            super((byte) 0);
        }

        @Override // com.bytedance.pangle.receiver.b.a, com.bytedance.pangle.receiver.b.c
        public final boolean a(Context context) {
            Object a4 = a.a(context, "mWhiteList");
            if (a4 instanceof List) {
                ((List) a4).add(context.getPackageName());
                return true;
            }
            return false;
        }

        /* synthetic */ d(byte b4) {
            this();
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    static class e extends a {
        private e() {
            super((byte) 0);
        }

        @Override // com.bytedance.pangle.receiver.b.a, com.bytedance.pangle.receiver.b.c
        public boolean a(Context context) {
            Object a4 = a.a(context, "mWhiteListMap");
            if (a4 instanceof Map) {
                Map map = (Map) a4;
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

        /* synthetic */ e(byte b4) {
            this();
        }
    }

    static {
        int i4 = Build.VERSION.SDK_INT;
        if (i4 < 24) {
            f28888a = new a((byte) 0);
        } else if (i4 < 26) {
            f28888a = new d((byte) 0);
        } else if (i4 < 28) {
            f28888a = new e((byte) 0);
        } else {
            f28888a = new C0431b((byte) 0);
        }
    }

    public static void a(Application application) {
        if (application != null) {
            try {
                if (TextUtils.equals(Build.BRAND.toLowerCase(), "huawei")) {
                    f28888a.a(application.getBaseContext());
                }
            } catch (Throwable unused) {
            }
        }
    }
}

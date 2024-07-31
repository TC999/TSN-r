package com.umeng.commonsdk.config;

import android.content.Context;
import android.util.Pair;
import com.umeng.commonsdk.config.FieldTable;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import java.util.ArrayList;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class FieldManager {

    /* renamed from: a */
    private static final String f38621a = "cfgfd";

    /* renamed from: b */
    private static CollectController f38622b = CollectController.m14022b();

    /* renamed from: c */
    private static boolean f38623c = false;

    /* renamed from: d */
    private static Object f38624d = new Object();

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.umeng.commonsdk.config.FieldManager$a */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static class C13205a {

        /* renamed from: a */
        private static final FieldManager f38625a = new FieldManager();

        private C13205a() {
        }
    }

    /* renamed from: a */
    public static FieldManager m14036a() {
        return C13205a.f38625a;
    }

    public static boolean allow(String str) {
        synchronized (f38624d) {
            if (f38623c) {
                return CollectController.m14023a(str);
            }
            return false;
        }
    }

    /* renamed from: b */
    public static boolean m14032b() {
        boolean z;
        synchronized (f38624d) {
            z = f38623c;
        }
        return z;
    }

    private FieldManager() {
    }

    /* renamed from: a */
    public void m14035a(Context context) {
        String str;
        String str2 = "1001@3749699455,2130669566,262139,1983";
        String[] strArr = {FieldTable.EnumC13208a.class.getName(), FieldTable.EnumC13209b.class.getName(), FieldTable.EnumC13210c.class.getName(), FieldTable.EnumC13211d.class.getName()};
        String imprintProperty = UMEnvelopeBuild.imprintProperty(context, "cfgfd", "1001@3749699455,2130669566,262139,1983");
        synchronized (f38624d) {
            Pair<Long, String> m14033a = m14033a(imprintProperty);
            if (((Long) m14033a.first).longValue() > 1000 && (str = (String) m14033a.second) != null && str.length() > 0) {
                str2 = str;
            }
            String[] split = str2.split(",");
            int length = split.length;
            if (length > 0) {
                ArrayList arrayList = new ArrayList();
                SensitiveFieldHandler sensitiveFieldHandler = new SensitiveFieldHandler();
                for (int i = 0; i < length; i++) {
                    arrayList.add(sensitiveFieldHandler);
                    ((IConfigHandler) arrayList.get(i)).mo14017a(split[i], f38622b, FieldTable.m14019b(strArr[i]));
                }
            }
            f38623c = true;
        }
    }

    /* renamed from: a */
    public void m14034a(Context context, String str) {
        String str2;
        String str3 = "1001@3749699455,2130669566,262139,1983";
        String[] strArr = {FieldTable.EnumC13208a.class.getName(), FieldTable.EnumC13209b.class.getName(), FieldTable.EnumC13210c.class.getName(), FieldTable.EnumC13211d.class.getName()};
        synchronized (f38624d) {
            f38622b.m14024a();
            if (str != null) {
                Pair<Long, String> m14033a = m14033a(str);
                if (((Long) m14033a.first).longValue() > 1000 && (str2 = (String) m14033a.second) != null && str2.length() > 0) {
                    str3 = str2;
                }
            }
            String[] split = str3.split(",");
            int length = split.length;
            if (length > 0) {
                ArrayList arrayList = new ArrayList();
                SensitiveFieldHandler sensitiveFieldHandler = new SensitiveFieldHandler();
                for (int i = 0; i < length; i++) {
                    arrayList.add(sensitiveFieldHandler);
                    ((IConfigHandler) arrayList.get(i)).mo14017a(split[i], f38622b, FieldTable.m14019b(strArr[i]));
                }
            }
            f38623c = true;
        }
    }

    /* renamed from: a */
    private static Pair<Long, String> m14033a(String str) {
        Pair<Long, String> pair = new Pair<>(-1L, null);
        if (str != null && str.length() >= 2) {
            String[] split = str.split("@");
            if (split.length < 2) {
                return pair;
            }
            try {
                long parseLong = Long.parseLong(split[0]);
                return new Pair<>(Long.valueOf(parseLong), split[1]);
            } catch (Throwable unused) {
            }
        }
        return pair;
    }
}

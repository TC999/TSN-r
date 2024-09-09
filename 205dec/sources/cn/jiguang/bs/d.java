package cn.jiguang.bs;

import android.content.Context;
import android.text.TextUtils;
import cn.jiguang.f.c;
import cn.jiguang.internal.ActionManager;
import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private static String f2850a;

    /* renamed from: b  reason: collision with root package name */
    private static String f2851b;

    /* renamed from: c  reason: collision with root package name */
    private static ConcurrentHashMap<File, Boolean> f2852c = new ConcurrentHashMap<>();

    /* renamed from: d  reason: collision with root package name */
    private static final AtomicBoolean f2853d = new AtomicBoolean(false);

    public static File a(Context context, String str) {
        return new File(e(context) + str + File.separator + UUID.randomUUID().toString());
    }

    public static File a(Context context, String str, JSONObject jSONObject, boolean z3) {
        File a4 = a(context, str);
        if (z3) {
            b(a4);
        }
        cn.jiguang.f.c.c(a4, jSONObject.toString());
        return a4;
    }

    public static FileFilter a() {
        return new FileFilter() { // from class: cn.jiguang.bs.d.1
            @Override // java.io.FileFilter
            public boolean accept(File file) {
                return (file.getName().length() == 24 || file.getName().equals("0")) ? false : true;
            }
        };
    }

    public static void a(Context context) {
        c.a aVar = new c.a(false, true, "jpush_stat_history", 1);
        String e4 = cn.jiguang.d.a.e(context);
        File[] a4 = cn.jiguang.f.c.a(context.getFilesDir(), aVar, a());
        if (a4 != null) {
            for (File file : a4) {
                try {
                    cn.jiguang.f.c.e(new File(file, "nowrap"));
                    StringBuilder sb = new StringBuilder();
                    sb.append(file.getParent());
                    String str = File.separator;
                    sb.append(str);
                    sb.append(e4);
                    sb.append(str);
                    sb.append(file.getName());
                    File file2 = new File(sb.toString());
                    if (!file2.getParentFile().exists()) {
                        file2.getParentFile().mkdirs();
                    }
                    file.renameTo(file2);
                } catch (Throwable th) {
                    cn.jiguang.bq.d.c("updateByAppKey", "e=" + th);
                }
            }
        }
    }

    private static void a(Context context, File file) {
        if (((Long) cn.jiguang.g.b.a(context, cn.jiguang.g.a.x())).longValue() == 0) {
            cn.jiguang.bq.d.c("ReportHistory", "can't get uid, skip upload history");
            return;
        }
        File[] a4 = cn.jiguang.f.c.a(file, c.a.f3638a);
        if (a4 == null || a4.length == 0) {
            return;
        }
        LinkedList<File> linkedList = new LinkedList();
        for (File file2 : a4) {
            if (!Boolean.TRUE.equals(f2852c.get(file2))) {
                linkedList.add(file2);
            }
        }
        if (linkedList.isEmpty()) {
            return;
        }
        cn.jiguang.bq.d.c("ReportHistory", "process space=" + e(file) + " history[" + linkedList.size() + "]");
        Collections.sort(linkedList, new Comparator<File>() { // from class: cn.jiguang.bs.d.4
            @Override // java.util.Comparator
            /* renamed from: a */
            public int compare(File file3, File file4) {
                long lastModified = file3.lastModified() - file4.lastModified();
                if (lastModified < 0) {
                    return 1;
                }
                return lastModified == 0 ? 0 : -1;
            }
        });
        for (File file3 : linkedList) {
            try {
                JSONObject a5 = c.a(file3);
                if (a5 == null) {
                    cn.jiguang.f.c.a(file3);
                } else {
                    b(file3);
                    Set<String> a6 = f.a(a5);
                    cn.jiguang.bq.d.c("ReportHistory", "report history types=" + a6);
                    if (f.a(context, a6, a5, file3, null) == -2) {
                        return;
                    }
                }
            } catch (Throwable th) {
                cn.jiguang.bq.d.i("ReportHistory", "upload e:" + th);
            }
        }
    }

    public static void a(Context context, String... strArr) {
        FileFilter[] fileFilterArr;
        if (strArr == null || strArr.length == 0) {
            fileFilterArr = new FileFilter[1];
        } else {
            fileFilterArr = new FileFilter[strArr.length + 1];
            int i4 = 0;
            while (i4 < strArr.length) {
                int i5 = i4 + 1;
                fileFilterArr[i5] = c.a.a(strArr[i4]);
                i4 = i5;
            }
        }
        fileFilterArr[0] = new c.a(false, true, "jpush_stat_history", 1);
        File[] a4 = cn.jiguang.f.c.a(context.getFilesDir(), fileFilterArr);
        if (a4 != null) {
            for (File file : a4) {
                cn.jiguang.f.c.e(file);
            }
        }
    }

    public static void a(File file) {
        if (file != null) {
            f2852c.remove(file);
        }
    }

    private static Set<String> b() {
        HashSet hashSet = new HashSet();
        hashSet.add("uid");
        hashSet.add("app_key");
        hashSet.add("sdk_ver");
        hashSet.add("channel");
        hashSet.add("app_version");
        JSONObject jSONObject = new JSONObject();
        ActionManager.getInstance().wrapSdkVersionInfo(jSONObject);
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            hashSet.add(keys.next());
        }
        return hashSet;
    }

    public static void b(final Context context) {
        cn.jiguang.cm.b bVar;
        String str;
        if (f2853d.get()) {
            cn.jiguang.bq.d.c("ReportHistory", "isRunning, no need report");
            return;
        }
        if (TextUtils.isEmpty(cn.jiguang.bk.d.c(context)) || !context.getPackageName().equals(cn.jiguang.f.a.a(context))) {
            bVar = new cn.jiguang.cm.b("ReportHistory#submitReportAll") { // from class: cn.jiguang.bs.d.3
                @Override // cn.jiguang.cm.b
                public void a() {
                    d.f(context);
                }
            };
            str = "NORMAL_TASK";
        } else {
            bVar = new cn.jiguang.cm.b("ReportHistory#submitReportAll") { // from class: cn.jiguang.bs.d.2
                @Override // cn.jiguang.cm.b
                public void a() {
                    d.f(context);
                }
            };
            str = "MAJOR_TASK";
        }
        cn.jiguang.cm.d.a(str, bVar);
    }

    private static void b(Context context, File file) {
        try {
            JSONObject a4 = f.a(context);
            if (cn.jiguang.f.d.c(a4)) {
                return;
            }
            File[] a5 = cn.jiguang.f.c.a(new File(file, "nowrap"), c.a.f3638a);
            if (a5 != null && a5.length != 0) {
                cn.jiguang.bq.d.c("ReportHistory", "process space=" + e(file) + " nowrap[" + a5.length + "]");
                File file2 = new File(file, "tmp");
                c a6 = c.a(a5[0], a4);
                for (int i4 = 1; i4 < a5.length; i4++) {
                    c a7 = c.a(a5[i4], a4);
                    if (a7 != null) {
                        if (a6 != null && a6.a(a7, file2)) {
                        }
                        a6 = a7;
                    }
                }
                if (a6 != null) {
                    a6.a((c) null, file2);
                }
            }
        } catch (Throwable th) {
            cn.jiguang.bq.d.i("ReportHistory", "processNowrap e:" + th);
        }
    }

    private static void b(File file) {
        if (file != null) {
            f2852c.put(file, Boolean.TRUE);
        }
    }

    private static void c(Context context, File file) {
        cn.jiguang.bq.d.c("ReportHistory", "upload space=" + e(file));
        b(context, file);
        d(file);
        a(context, file);
        c(file);
    }

    private static void c(File file) {
        int i4 = 0;
        File[] a4 = cn.jiguang.f.c.a(file, c.a.f3638a);
        if (a4 == null || a4.length <= 1) {
            return;
        }
        List<File> asList = Arrays.asList(a4);
        Collections.sort(asList, new Comparator<File>() { // from class: cn.jiguang.bs.d.5
            @Override // java.util.Comparator
            /* renamed from: a */
            public int compare(File file2, File file3) {
                long lastModified = file2.lastModified() - file3.lastModified();
                if (lastModified < 0) {
                    return 1;
                }
                return lastModified == 0 ? 0 : -1;
            }
        });
        for (File file2 : asList) {
            i4 = (int) (i4 + file2.length());
            if (i4 > 1048576) {
                cn.jiguang.f.c.a(file2);
            }
        }
        if (asList.size() < a4.length) {
            cn.jiguang.bq.d.c("ReportHistory", "trim space history=" + e(file) + "," + a4.length + " to " + asList.size());
        }
    }

    private static synchronized String d(Context context) {
        String str;
        String replaceFirst;
        synchronized (d.class) {
            if (!TextUtils.isEmpty(f2851b)) {
                return f2851b;
            }
            if (f2850a == null) {
                String a4 = cn.jiguang.f.a.a(context);
                if (!TextUtils.isEmpty(a4)) {
                    if (a4.equals(context.getPackageName())) {
                        replaceFirst = "";
                    } else {
                        replaceFirst = a4.replaceFirst(context.getPackageName() + ":", "_");
                    }
                    f2850a = replaceFirst;
                }
            }
            if (f2850a != null) {
                str = "jpush_stat_history" + f2850a;
            } else {
                str = "jpush_stat_history";
            }
            File a5 = cn.jiguang.f.c.a(context, str);
            if (a5 != null) {
                String absolutePath = a5.getAbsolutePath();
                f2851b = absolutePath;
                return absolutePath;
            }
            return "jpush_stat_history" + f2850a;
        }
    }

    private static void d(File file) {
        try {
            File[] a4 = cn.jiguang.f.c.a(new File(file, "tmp"), c.a.f3638a);
            if (a4 != null && a4.length != 0) {
                LinkedList<File> linkedList = new LinkedList();
                for (File file2 : a4) {
                    if (!Boolean.TRUE.equals(f2852c.get(file2))) {
                        linkedList.add(file2);
                    }
                }
                if (linkedList.isEmpty()) {
                    return;
                }
                cn.jiguang.bq.d.c("ReportHistory", "process space=" + e(file) + " tmp[" + linkedList.size() + "]");
                Set<String> b4 = b();
                HashMap hashMap = new HashMap();
                c a5 = c.a(cn.jiguang.f.c.a(cn.jiguang.f.c.a(file, c.a.f3638a)), b4);
                if (a5 != null) {
                    hashMap.put(String.valueOf(a5.f2845b), a5);
                }
                for (File file3 : linkedList) {
                    c a6 = c.a(file3, b4);
                    if (a6 != null) {
                        String valueOf = String.valueOf(a6.f2845b);
                        c cVar = (c) hashMap.get(valueOf);
                        if (cVar != null && cVar.a(a6, file)) {
                        }
                        hashMap.put(valueOf, a6);
                    }
                }
                for (c cVar2 : hashMap.values()) {
                    cVar2.a((c) null, file);
                }
            }
        } catch (Throwable th) {
            cn.jiguang.bq.d.i("ReportHistory", "processTmp e:" + th);
        }
    }

    private static String e(Context context) {
        String e4 = cn.jiguang.d.a.e(context);
        if (TextUtils.isEmpty(e4)) {
            e4 = "0";
        }
        return d(context) + File.separator + e4;
    }

    private static String e(File file) {
        try {
            File parentFile = file.getParentFile();
            StringBuilder sb = new StringBuilder();
            sb.append(parentFile.getParentFile().getName());
            String str = File.separator;
            sb.append(str);
            sb.append(parentFile.getName());
            sb.append(str);
            sb.append(file.getName());
            return sb.toString();
        } catch (Throwable unused) {
            return file.getAbsolutePath();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void f(Context context) {
        try {
            f2853d.set(true);
            File[] a4 = cn.jiguang.f.c.a(e(context), c.a.f3639b);
            if (a4 != null) {
                for (File file : a4) {
                    c(context, file);
                }
            } else {
                cn.jiguang.bq.d.c("ReportHistory", "no history, no report");
            }
        } finally {
            try {
            } finally {
            }
        }
    }
}

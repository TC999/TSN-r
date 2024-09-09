package com.tencent.bugly.proguard;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Pair;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.tencent.bugly.BuglyStrategy;
import com.tencent.bugly.crashreport.common.info.PlugInBean;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.crashreport.crash.CrashDetailBean;
import com.tencent.bugly.proguard.ag;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: BUGLY */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public final class as {

    /* renamed from: a  reason: collision with root package name */
    public static int f50967a;

    /* renamed from: h  reason: collision with root package name */
    private static final Map<Integer, Pair<String, String>> f50968h = new HashMap<Integer, Pair<String, String>>() { // from class: com.tencent.bugly.proguard.as.1
        {
            put(3, new Pair("203", "103"));
            put(7, new Pair("208", "108"));
            put(0, new Pair("200", "100"));
            put(1, new Pair("201", "101"));
            put(2, new Pair("202", "102"));
            put(4, new Pair("204", "104"));
            put(6, new Pair("206", "106"));
            put(5, new Pair("207", "107"));
        }
    };

    /* renamed from: i  reason: collision with root package name */
    private static final ArrayList<a> f50969i = new ArrayList<a>() { // from class: com.tencent.bugly.proguard.as.2
        {
            add(new b((byte) 0));
            add(new c((byte) 0));
            add(new d((byte) 0));
            add(new e((byte) 0));
            add(new h((byte) 0));
            add(new i((byte) 0));
            add(new f((byte) 0));
            add(new g((byte) 0));
        }
    };

    /* renamed from: j  reason: collision with root package name */
    private static final Map<Integer, Integer> f50970j = new HashMap<Integer, Integer>() { // from class: com.tencent.bugly.proguard.as.3
        {
            put(3, 4);
            put(7, 7);
            put(2, 1);
            put(0, 0);
            put(1, 2);
            put(4, 3);
            put(5, 5);
            put(6, 6);
        }
    };

    /* renamed from: k  reason: collision with root package name */
    private static final Map<Integer, String> f50971k = new HashMap<Integer, String>() { // from class: com.tencent.bugly.proguard.as.4
        {
            put(3, "BuglyAnrCrash");
            put(0, "BuglyJavaCrash");
            put(1, "BuglyNativeCrash");
        }
    };

    /* renamed from: l  reason: collision with root package name */
    private static final Map<Integer, String> f50972l = new HashMap<Integer, String>() { // from class: com.tencent.bugly.proguard.as.5
        {
            put(3, "BuglyAnrCrashReport");
            put(0, "BuglyJavaCrashReport");
            put(1, "BuglyNativeCrashReport");
        }
    };

    /* renamed from: b  reason: collision with root package name */
    protected final Context f50973b;

    /* renamed from: c  reason: collision with root package name */
    protected final ai f50974c;

    /* renamed from: d  reason: collision with root package name */
    protected final w f50975d;

    /* renamed from: e  reason: collision with root package name */
    protected final ac f50976e;

    /* renamed from: f  reason: collision with root package name */
    protected aw f50977f;

    /* renamed from: g  reason: collision with root package name */
    protected BuglyStrategy.a f50978g;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* compiled from: BUGLY */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public static abstract class a {

        /* renamed from: a  reason: collision with root package name */
        final int f50983a;

        /* synthetic */ a(int i4, byte b4) {
            this(i4);
        }

        abstract boolean a();

        private a(int i4) {
            this.f50983a = i4;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* compiled from: BUGLY */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    static class b extends a {
        /* synthetic */ b(byte b4) {
            this();
        }

        @Override // com.tencent.bugly.proguard.as.a
        final boolean a() {
            return at.a().k();
        }

        private b() {
            super(3, (byte) 0);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* compiled from: BUGLY */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    static class c extends a {
        /* synthetic */ c(byte b4) {
            this();
        }

        @Override // com.tencent.bugly.proguard.as.a
        final boolean a() {
            return true;
        }

        private c() {
            super(7, (byte) 0);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* compiled from: BUGLY */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    static class d extends a {
        /* synthetic */ d(byte b4) {
            this();
        }

        @Override // com.tencent.bugly.proguard.as.a
        final boolean a() {
            return true;
        }

        private d() {
            super(2, (byte) 0);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* compiled from: BUGLY */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    static class e extends a {
        /* synthetic */ e(byte b4) {
            this();
        }

        @Override // com.tencent.bugly.proguard.as.a
        final boolean a() {
            return at.a().j();
        }

        private e() {
            super(0, (byte) 0);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* compiled from: BUGLY */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    static class f extends a {
        /* synthetic */ f(byte b4) {
            this();
        }

        @Override // com.tencent.bugly.proguard.as.a
        final boolean a() {
            return (at.a().B & 2) > 0;
        }

        private f() {
            super(5, (byte) 0);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* compiled from: BUGLY */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    static class g extends a {
        /* synthetic */ g(byte b4) {
            this();
        }

        @Override // com.tencent.bugly.proguard.as.a
        final boolean a() {
            return (at.a().B & 1) > 0;
        }

        private g() {
            super(6, (byte) 0);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* compiled from: BUGLY */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    static class h extends a {
        /* synthetic */ h(byte b4) {
            this();
        }

        @Override // com.tencent.bugly.proguard.as.a
        final boolean a() {
            return at.a().j();
        }

        private h() {
            super(1, (byte) 0);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* compiled from: BUGLY */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    static class i extends a {
        /* synthetic */ i(byte b4) {
            this();
        }

        @Override // com.tencent.bugly.proguard.as.a
        final boolean a() {
            return (at.a().B & 4) > 0;
        }

        private i() {
            super(4, (byte) 0);
        }
    }

    public as(Context context, ai aiVar, w wVar, ac acVar, BuglyStrategy.a aVar) {
        f50967a = 1004;
        this.f50973b = context;
        this.f50974c = aiVar;
        this.f50975d = wVar;
        this.f50976e = acVar;
        this.f50978g = aVar;
        this.f50977f = null;
    }

    private static List<ar> a(List<ar> list) {
        if (list == null || list.size() == 0) {
            return null;
        }
        long currentTimeMillis = System.currentTimeMillis();
        ArrayList arrayList = new ArrayList();
        for (ar arVar : list) {
            if (arVar.f50964d && arVar.f50962b <= currentTimeMillis - 86400000) {
                arrayList.add(arVar);
            }
        }
        return arrayList;
    }

    private static void b(CrashDetailBean crashDetailBean, List<ar> list) {
        StringBuilder sb = new StringBuilder(64);
        for (ar arVar : list) {
            if (!arVar.f50965e && !arVar.f50964d) {
                String str = crashDetailBean.f50783s;
                StringBuilder sb2 = new StringBuilder();
                sb2.append(arVar.f50962b);
                if (!str.contains(sb2.toString())) {
                    crashDetailBean.f50784t++;
                    sb.append(arVar.f50962b);
                    sb.append("\n");
                }
            }
        }
        crashDetailBean.f50783s += sb.toString();
    }

    private static ContentValues c(CrashDetailBean crashDetailBean) {
        if (crashDetailBean == null) {
            return null;
        }
        try {
            ContentValues contentValues = new ContentValues();
            long j4 = crashDetailBean.f50765a;
            if (j4 > 0) {
                contentValues.put("_id", Long.valueOf(j4));
            }
            contentValues.put("_tm", Long.valueOf(crashDetailBean.f50782r));
            contentValues.put("_s1", crashDetailBean.f50785u);
            int i4 = 1;
            contentValues.put("_up", Integer.valueOf(crashDetailBean.f50768d ? 1 : 0));
            if (!crashDetailBean.f50774j) {
                i4 = 0;
            }
            contentValues.put("_me", Integer.valueOf(i4));
            contentValues.put("_uc", Integer.valueOf(crashDetailBean.f50776l));
            contentValues.put("_dt", ap.a(crashDetailBean));
            return contentValues;
        } catch (Throwable th) {
            if (!al.a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    private static void d(List<ar> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("_id in (");
        for (ar arVar : list) {
            sb.append(arVar.f50961a);
            sb.append(",");
        }
        StringBuilder sb2 = new StringBuilder(sb.substring(0, sb.lastIndexOf(",")));
        sb2.append(")");
        String sb3 = sb2.toString();
        sb2.setLength(0);
        try {
            al.c("deleted %s data %d", "t_cr", Integer.valueOf(w.a().a("t_cr", sb3)));
        } catch (Throwable th) {
            if (al.a(th)) {
                return;
            }
            th.printStackTrace();
        }
    }

    private static void e(List<CrashDetailBean> list) {
        try {
            if (list.size() == 0) {
                return;
            }
            StringBuilder sb = new StringBuilder();
            for (CrashDetailBean crashDetailBean : list) {
                sb.append(" or _id = ");
                sb.append(crashDetailBean.f50765a);
            }
            String sb2 = sb.toString();
            if (sb2.length() > 0) {
                sb2 = sb2.substring(4);
            }
            sb.setLength(0);
            al.c("deleted %s data %d", "t_cr", Integer.valueOf(w.a().a("t_cr", sb2)));
        } catch (Throwable th) {
            if (al.a(th)) {
                return;
            }
            th.printStackTrace();
        }
    }

    private static void b(List<ar> list) {
        List<CrashDetailBean> c4 = c(list);
        if (c4 == null || c4.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (CrashDetailBean crashDetailBean : c4) {
            String str = f50972l.get(Integer.valueOf(crashDetailBean.f50766b));
            if (!TextUtils.isEmpty(str)) {
                al.c("find expired data,crashId:%s eventType:%s", crashDetailBean.f50767c, str);
                arrayList.add(new ag.c(crashDetailBean.f50767c, str, crashDetailBean.f50782r, false, 0L, "expired", null));
            }
        }
        ag.a.a().a(arrayList);
    }

    private static CrashDetailBean a(List<ar> list, CrashDetailBean crashDetailBean) {
        List<CrashDetailBean> c4;
        if (list.isEmpty()) {
            return crashDetailBean;
        }
        CrashDetailBean crashDetailBean2 = null;
        ArrayList arrayList = new ArrayList(10);
        for (ar arVar : list) {
            if (arVar.f50965e) {
                arrayList.add(arVar);
            }
        }
        if (!arrayList.isEmpty() && (c4 = c(arrayList)) != null && !c4.isEmpty()) {
            Collections.sort(c4);
            crashDetailBean2 = c4.get(0);
            a(crashDetailBean2, c4);
        }
        if (crashDetailBean2 == null) {
            crashDetailBean.f50774j = true;
            crashDetailBean.f50784t = 0;
            crashDetailBean.f50783s = "";
            crashDetailBean2 = crashDetailBean;
        }
        b(crashDetailBean2, list);
        if (crashDetailBean2.f50782r != crashDetailBean.f50782r) {
            String str = crashDetailBean2.f50783s;
            StringBuilder sb = new StringBuilder();
            sb.append(crashDetailBean.f50782r);
            if (!str.contains(sb.toString())) {
                crashDetailBean2.f50784t++;
                crashDetailBean2.f50783s += crashDetailBean.f50782r + "\n";
            }
        }
        return crashDetailBean2;
    }

    private static List<CrashDetailBean> c(List<ar> list) {
        Cursor cursor;
        if (list == null || list.size() == 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("_id in (");
        for (ar arVar : list) {
            sb.append(arVar.f50961a);
            sb.append(",");
        }
        if (sb.toString().contains(",")) {
            sb = new StringBuilder(sb.substring(0, sb.lastIndexOf(",")));
        }
        sb.append(")");
        String sb2 = sb.toString();
        sb.setLength(0);
        try {
            cursor = w.a().a("t_cr", (String[]) null, sb2);
            if (cursor == null) {
                return null;
            }
            try {
                ArrayList arrayList = new ArrayList();
                sb.append("_id in (");
                int i4 = 0;
                while (cursor.moveToNext()) {
                    CrashDetailBean a4 = a(cursor);
                    if (a4 != null) {
                        arrayList.add(a4);
                    } else {
                        sb.append(cursor.getLong(cursor.getColumnIndex("_id")));
                        sb.append(",");
                        i4++;
                    }
                }
                if (sb.toString().contains(",")) {
                    sb = new StringBuilder(sb.substring(0, sb.lastIndexOf(",")));
                }
                sb.append(")");
                String sb3 = sb.toString();
                if (i4 > 0) {
                    al.d("deleted %s illegal data %d", "t_cr", Integer.valueOf(w.a().a("t_cr", sb3)));
                }
                cursor.close();
                return arrayList;
            } catch (Throwable th) {
                th = th;
                try {
                    if (!al.a(th)) {
                        th.printStackTrace();
                    }
                    if (cursor != null) {
                        cursor.close();
                    }
                    return null;
                } finally {
                    if (cursor != null) {
                        cursor.close();
                    }
                }
            }
        } catch (Throwable th2) {
            th = th2;
            cursor = null;
        }
    }

    private static String e(CrashDetailBean crashDetailBean) {
        try {
            Pair<String, String> pair = f50968h.get(Integer.valueOf(crashDetailBean.f50766b));
            if (pair == null) {
                al.e("crash type error! %d", Integer.valueOf(crashDetailBean.f50766b));
                return "";
            } else if (crashDetailBean.f50774j) {
                return (String) pair.first;
            } else {
                return (String) pair.second;
            }
        } catch (Exception e4) {
            al.a(e4);
            return "";
        }
    }

    private boolean d(CrashDetailBean crashDetailBean) {
        try {
            al.c("save eup logs", new Object[0]);
            aa b4 = aa.b();
            String str = "#--------\npackage:" + b4.e() + "\nversion:" + b4.f50836o + "\nsdk:" + b4.f50829h + "\nprocess:" + crashDetailBean.A + "\ndate:" + ap.a(new Date(crashDetailBean.f50782r)) + "\ntype:" + crashDetailBean.f50778n + "\nmessage:" + crashDetailBean.f50779o + "\nstack:\n" + crashDetailBean.f50781q + "\neupID:" + crashDetailBean.f50767c + "\n";
            String str2 = null;
            if (at.f50995m == null) {
                if (Environment.getExternalStorageState().equals("mounted")) {
                    str2 = Environment.getExternalStorageDirectory().getAbsolutePath() + "/Tencent/" + this.f50973b.getPackageName();
                }
            } else {
                File file = new File(at.f50995m);
                if (file.isFile()) {
                    file = file.getParentFile();
                }
                str2 = file.getAbsolutePath();
            }
            am.a(str2 + "/euplog.txt", str, at.f50996n);
            return true;
        } catch (Throwable th) {
            al.d("rqdp{  save error} %s", th.toString());
            if (!al.a(th)) {
                th.printStackTrace();
            }
            return false;
        }
    }

    public final void b(CrashDetailBean crashDetailBean, boolean z3) {
        if (at.f50997o) {
            al.a("try to upload right now", new Object[0]);
            ArrayList arrayList = new ArrayList();
            arrayList.add(crashDetailBean);
            a(arrayList, 3000L, z3, crashDetailBean.f50766b == 7, z3);
            return;
        }
        al.a("do not upload spot crash right now, crash would be uploaded when app next start", new Object[0]);
    }

    public final void b(CrashDetailBean crashDetailBean) {
        if (crashDetailBean == null) {
            return;
        }
        ContentValues c4 = c(crashDetailBean);
        if (c4 != null) {
            long a4 = w.a().a("t_cr", c4, (v) null);
            if (a4 >= 0) {
                al.c("insert %s success!", "t_cr");
                crashDetailBean.f50765a = a4;
            }
        }
        if (at.f50994l) {
            d(crashDetailBean);
        }
    }

    private static void a(CrashDetailBean crashDetailBean, List<CrashDetailBean> list) {
        String[] split;
        StringBuilder sb = new StringBuilder(128);
        for (int i4 = 1; i4 < list.size(); i4++) {
            String str = list.get(i4).f50783s;
            if (str != null && (split = str.split("\n")) != null) {
                for (String str2 : split) {
                    if (!crashDetailBean.f50783s.contains(str2)) {
                        crashDetailBean.f50784t++;
                        sb.append(str2);
                        sb.append("\n");
                    }
                }
            }
        }
        crashDetailBean.f50783s += sb.toString();
    }

    private static ar b(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        try {
            ar arVar = new ar();
            arVar.f50961a = cursor.getLong(cursor.getColumnIndex("_id"));
            arVar.f50962b = cursor.getLong(cursor.getColumnIndex("_tm"));
            arVar.f50963c = cursor.getString(cursor.getColumnIndex("_s1"));
            arVar.f50964d = cursor.getInt(cursor.getColumnIndex("_up")) == 1;
            arVar.f50965e = cursor.getInt(cursor.getColumnIndex("_me")) == 1;
            arVar.f50966f = cursor.getInt(cursor.getColumnIndex("_uc"));
            return arVar;
        } catch (Throwable th) {
            if (!al.a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:77:0x01af  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x01d8  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0207  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x024a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0263  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean a(com.tencent.bugly.crashreport.crash.CrashDetailBean r20, boolean r21) {
        /*
            Method dump skipped, instructions count: 646
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.as.a(com.tencent.bugly.crashreport.crash.CrashDetailBean, boolean):boolean");
    }

    private static List<ar> b() {
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            Cursor a4 = w.a().a("t_cr", new String[]{"_id", "_tm", "_s1", "_up", "_me", "_uc"}, (String) null);
            if (a4 == null) {
                if (a4 != null) {
                    a4.close();
                }
                return null;
            }
            try {
                if (a4.getCount() <= 0) {
                    a4.close();
                    return arrayList;
                }
                StringBuilder sb = new StringBuilder();
                sb.append("_id in (");
                int i4 = 0;
                while (a4.moveToNext()) {
                    ar b4 = b(a4);
                    if (b4 != null) {
                        arrayList.add(b4);
                    } else {
                        sb.append(a4.getLong(a4.getColumnIndex("_id")));
                        sb.append(",");
                        i4++;
                    }
                }
                if (sb.toString().contains(",")) {
                    sb = new StringBuilder(sb.substring(0, sb.lastIndexOf(",")));
                }
                sb.append(")");
                String sb2 = sb.toString();
                sb.setLength(0);
                if (i4 > 0) {
                    al.d("deleted %s illegal data %d", "t_cr", Integer.valueOf(w.a().a("t_cr", sb2)));
                }
                a4.close();
                return arrayList;
            } catch (Throwable th) {
                th = th;
                cursor = a4;
                try {
                    if (!al.a(th)) {
                        th.printStackTrace();
                    }
                    return arrayList;
                } finally {
                    if (cursor != null) {
                        cursor.close();
                    }
                }
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private static void c(ArrayList<bn> arrayList, String str) {
        if (ap.b(str)) {
            return;
        }
        try {
            bn bnVar = new bn((byte) 1, "crashInfos.txt", str.getBytes("utf-8"));
            al.c("attach crash infos", new Object[0]);
            arrayList.add(bnVar);
        } catch (Exception e4) {
            e4.printStackTrace();
            al.a(e4);
        }
    }

    private static void b(ArrayList<bn> arrayList, String str) {
        if (str != null) {
            try {
                arrayList.add(new bn((byte) 1, "jniLog.txt", str.getBytes("utf-8")));
            } catch (Exception e4) {
                e4.printStackTrace();
                al.a(e4);
            }
        }
    }

    private static void b(ArrayList<bn> arrayList, CrashDetailBean crashDetailBean, Context context) {
        String str;
        if (crashDetailBean.f50766b == 1 && (str = crashDetailBean.f50786v) != null) {
            try {
                bn a4 = a("tomb.zip", context, str);
                if (a4 != null) {
                    al.c("attach tombs", new Object[0]);
                    arrayList.add(a4);
                }
            } catch (Exception e4) {
                al.a(e4);
            }
        }
    }

    private static void b(ArrayList<bn> arrayList, byte[] bArr) {
        if (bArr == null || bArr.length <= 0) {
            return;
        }
        try {
            arrayList.add(new bn((byte) 1, "userExtraByteData", bArr));
            al.c("attach extraData", new Object[0]);
        } catch (Exception e4) {
            al.a(e4);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0036, code lost:
        if (r0.size() >= com.tencent.bugly.proguard.at.f50986d) goto L18;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean b(com.tencent.bugly.crashreport.crash.CrashDetailBean r9, java.util.List<com.tencent.bugly.proguard.ar> r10, java.util.List<com.tencent.bugly.proguard.ar> r11) {
        /*
            r8 = this;
            int r0 = r9.f50766b
            r1 = 1
            r2 = 0
            if (r0 == 0) goto Lb
            if (r0 != r1) goto L9
            goto Lb
        L9:
            r3 = 0
            goto Lc
        Lb:
            r3 = 1
        Lc:
            r4 = 3
            if (r0 != r4) goto L11
            r0 = 1
            goto L12
        L11:
            r0 = 0
        L12:
            boolean r4 = com.tencent.bugly.proguard.p.f51258c
            if (r4 != 0) goto L1f
            if (r0 != 0) goto L1c
            if (r3 != 0) goto L1c
            r0 = 1
            goto L20
        L1c:
            boolean r0 = com.tencent.bugly.proguard.at.f50987e
            goto L20
        L1f:
            r0 = 0
        L20:
            if (r0 != 0) goto L23
            return r2
        L23:
            java.util.ArrayList r0 = new java.util.ArrayList
            r3 = 10
            r0.<init>(r3)
            boolean r10 = a(r9, r10, r0)
            if (r10 != 0) goto L38
            int r10 = r0.size()     // Catch: java.lang.Exception -> L6d
            int r3 = com.tencent.bugly.proguard.at.f50986d     // Catch: java.lang.Exception -> L6d
            if (r10 < r3) goto L78
        L38:
            java.lang.String r10 = "same crash occur too much do merged!"
            java.lang.Object[] r3 = new java.lang.Object[r2]     // Catch: java.lang.Exception -> L6d
            com.tencent.bugly.proguard.al.a(r10, r3)     // Catch: java.lang.Exception -> L6d
            com.tencent.bugly.crashreport.crash.CrashDetailBean r9 = a(r0, r9)     // Catch: java.lang.Exception -> L6d
            java.util.Iterator r10 = r0.iterator()     // Catch: java.lang.Exception -> L6d
        L47:
            boolean r0 = r10.hasNext()     // Catch: java.lang.Exception -> L6d
            if (r0 == 0) goto L5f
            java.lang.Object r0 = r10.next()     // Catch: java.lang.Exception -> L6d
            com.tencent.bugly.proguard.ar r0 = (com.tencent.bugly.proguard.ar) r0     // Catch: java.lang.Exception -> L6d
            long r3 = r0.f50961a     // Catch: java.lang.Exception -> L6d
            long r5 = r9.f50765a     // Catch: java.lang.Exception -> L6d
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 == 0) goto L47
            r11.add(r0)     // Catch: java.lang.Exception -> L6d
            goto L47
        L5f:
            r8.b(r9)     // Catch: java.lang.Exception -> L6d
            d(r11)     // Catch: java.lang.Exception -> L6d
            java.lang.String r9 = "[crash] save crash success. For this device crash many times, it will not upload crashes immediately"
            java.lang.Object[] r10 = new java.lang.Object[r2]     // Catch: java.lang.Exception -> L6d
            com.tencent.bugly.proguard.al.b(r9, r10)     // Catch: java.lang.Exception -> L6d
            return r1
        L6d:
            r9 = move-exception
            com.tencent.bugly.proguard.al.a(r9)
            java.lang.Object[] r9 = new java.lang.Object[r2]
            java.lang.String r10 = "Failed to merge crash."
            com.tencent.bugly.proguard.al.d(r10, r9)
        L78:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.as.b(com.tencent.bugly.crashreport.crash.CrashDetailBean, java.util.List, java.util.List):boolean");
    }

    private static boolean a(String str) {
        String str2 = at.f51000r;
        if (str2 != null && !str2.isEmpty()) {
            try {
                al.c("Crash regular filter for crash stack is: %s", at.f51000r);
                if (Pattern.compile(at.f51000r).matcher(str).find()) {
                    al.d("This crash matches the regular filter string set. It will not be record and upload.", new Object[0]);
                    return true;
                }
            } catch (Exception e4) {
                al.a(e4);
                al.d("Failed to compile " + at.f51000r, new Object[0]);
            }
        }
        return false;
    }

    private static boolean a(CrashDetailBean crashDetailBean, List<ar> list, List<ar> list2) {
        boolean z3 = false;
        for (ar arVar : list) {
            if (crashDetailBean.f50785u.equals(arVar.f50963c)) {
                if (arVar.f50965e) {
                    z3 = true;
                }
                list2.add(arVar);
            }
        }
        return z3;
    }

    public static List<CrashDetailBean> a() {
        StrategyBean c4 = ac.a().c();
        if (c4 == null) {
            al.d("have not synced remote!", new Object[0]);
            return null;
        } else if (!c4.f50746f) {
            al.d("Crashreport remote closed, please check your APP ID correct and Version available, then uninstall and reinstall your app.", new Object[0]);
            al.b("[init] WARNING! Crashreport closed by server, please check your APP ID correct and Version available, then uninstall and reinstall your app.", new Object[0]);
            return null;
        } else {
            long currentTimeMillis = System.currentTimeMillis();
            long b4 = ap.b();
            List<ar> b5 = b();
            al.c("Size of crash list loaded from DB: %s", Integer.valueOf(b5.size()));
            if (b5.size() <= 0) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            arrayList.addAll(a(b5));
            b5.removeAll(arrayList);
            Iterator<ar> it = b5.iterator();
            while (it.hasNext()) {
                ar next = it.next();
                long j4 = next.f50962b;
                if (j4 < b4 - at.f50992j) {
                    arrayList2.add(next);
                    it.remove();
                    arrayList.add(next);
                } else if (next.f50964d) {
                    if (j4 >= currentTimeMillis - 86400000) {
                        it.remove();
                    } else if (!next.f50965e) {
                        it.remove();
                        arrayList.add(next);
                    }
                } else if (next.f50966f >= 3 && j4 < currentTimeMillis - 86400000) {
                    it.remove();
                    arrayList.add(next);
                }
            }
            b(arrayList2);
            if (arrayList.size() > 0) {
                d(arrayList);
            }
            ArrayList arrayList3 = new ArrayList();
            List<CrashDetailBean> c5 = c(b5);
            if (c5 != null && c5.size() > 0) {
                String str = aa.b().f50836o;
                Iterator<CrashDetailBean> it2 = c5.iterator();
                while (it2.hasNext()) {
                    CrashDetailBean next2 = it2.next();
                    if (!str.equals(next2.f50770f)) {
                        it2.remove();
                        arrayList3.add(next2);
                    }
                }
            }
            if (arrayList3.size() > 0) {
                e(arrayList3);
            }
            return c5;
        }
    }

    public final void a(CrashDetailBean crashDetailBean) {
        int i4 = crashDetailBean.f50766b;
        if (i4 != 0) {
            if (i4 != 1) {
                if (i4 == 3 && !at.a().k()) {
                    return;
                }
            } else if (!at.a().j()) {
                return;
            }
        } else if (!at.a().j()) {
            return;
        }
        if (this.f50977f != null) {
            al.c("Calling 'onCrashHandleEnd' of RQD crash listener.", new Object[0]);
        }
    }

    public final void a(final List<CrashDetailBean> list, long j4, final boolean z3, boolean z4, boolean z5) {
        if (!aa.a(this.f50973b).f50827f) {
            al.d("warn: not upload process", new Object[0]);
            return;
        }
        ai aiVar = this.f50974c;
        if (aiVar == null) {
            al.d("warn: upload manager is null", new Object[0]);
        } else if (!z5 && !aiVar.b(at.f50984a)) {
            al.d("warn: not crashHappen or not should upload", new Object[0]);
        } else {
            StrategyBean c4 = this.f50976e.c();
            if (!c4.f50746f) {
                al.d("remote report is disable!", new Object[0]);
                al.b("[crash] server closed bugly in this app. please check your appid if is correct, and re-install it", new Object[0]);
            } else if (list != null && list.size() != 0) {
                try {
                    String str = c4.f50758r;
                    String str2 = StrategyBean.f50742b;
                    bp a4 = a(this.f50973b, list, aa.b());
                    if (a4 == null) {
                        al.d("create eupPkg fail!", new Object[0]);
                        return;
                    }
                    byte[] a5 = ae.a((m) a4);
                    if (a5 == null) {
                        al.d("send encode fail!", new Object[0]);
                        return;
                    }
                    bq a6 = ae.a(this.f50973b, AVMDLDataLoader.KeyIsGetVersionInfo, a5);
                    if (a6 == null) {
                        al.d("request package is null.", new Object[0]);
                        return;
                    }
                    final long currentTimeMillis = System.currentTimeMillis();
                    ah ahVar = new ah() { // from class: com.tencent.bugly.proguard.as.6
                        @Override // com.tencent.bugly.proguard.ah
                        public final void a(boolean z6, String str3) {
                            as.a(list, z6, System.currentTimeMillis() - currentTimeMillis, z3 ? "realtime" : "cache", str3);
                            as.a(z6, list);
                        }
                    };
                    if (z3) {
                        this.f50974c.a(f50967a, a6, str, str2, ahVar, j4, z4);
                    } else {
                        this.f50974c.a(f50967a, a6, str, str2, ahVar, false);
                    }
                } catch (Throwable th) {
                    al.e("req cr error %s", th.toString());
                    if (al.b(th)) {
                        return;
                    }
                    th.printStackTrace();
                }
            } else {
                al.d("warn: crashList is null or crashList num is 0", new Object[0]);
            }
        }
    }

    public static void a(boolean z3, List<CrashDetailBean> list) {
        if (list != null && list.size() > 0) {
            al.c("up finish update state %b", Boolean.valueOf(z3));
            for (CrashDetailBean crashDetailBean : list) {
                al.c("pre uid:%s uc:%d re:%b me:%b", crashDetailBean.f50767c, Integer.valueOf(crashDetailBean.f50776l), Boolean.valueOf(crashDetailBean.f50768d), Boolean.valueOf(crashDetailBean.f50774j));
                int i4 = crashDetailBean.f50776l + 1;
                crashDetailBean.f50776l = i4;
                crashDetailBean.f50768d = z3;
                al.c("set uid:%s uc:%d re:%b me:%b", crashDetailBean.f50767c, Integer.valueOf(i4), Boolean.valueOf(crashDetailBean.f50768d), Boolean.valueOf(crashDetailBean.f50774j));
            }
            for (CrashDetailBean crashDetailBean2 : list) {
                at.a().a(crashDetailBean2);
            }
            al.c("update state size %d", Integer.valueOf(list.size()));
        }
        if (z3) {
            return;
        }
        al.b("[crash] upload fail.", new Object[0]);
    }

    private static CrashDetailBean a(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        try {
            byte[] blob = cursor.getBlob(cursor.getColumnIndex("_dt"));
            if (blob == null) {
                return null;
            }
            long j4 = cursor.getLong(cursor.getColumnIndex("_id"));
            CrashDetailBean crashDetailBean = (CrashDetailBean) ap.a(blob, CrashDetailBean.CREATOR);
            if (crashDetailBean != null) {
                crashDetailBean.f50765a = j4;
            }
            return crashDetailBean;
        } catch (Throwable th) {
            if (!al.a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    private static bo a(Context context, CrashDetailBean crashDetailBean, aa aaVar) {
        ArrayList<bl> arrayList = null;
        if (context != null && crashDetailBean != null && aaVar != null) {
            bo boVar = new bo();
            boVar.f51127a = e(crashDetailBean);
            boVar.f51128b = crashDetailBean.f50782r;
            boVar.f51129c = crashDetailBean.f50778n;
            boVar.f51130d = crashDetailBean.f50779o;
            boVar.f51131e = crashDetailBean.f50780p;
            boVar.f51133g = crashDetailBean.f50781q;
            boVar.f51134h = crashDetailBean.f50790z;
            boVar.f51135i = crashDetailBean.f50767c;
            boVar.f51136j = null;
            boVar.f51138l = crashDetailBean.f50777m;
            boVar.f51139m = crashDetailBean.f50769e;
            boVar.f51132f = crashDetailBean.B;
            boVar.f51140n = null;
            Map<String, PlugInBean> map = crashDetailBean.f50772h;
            if (map != null && !map.isEmpty()) {
                arrayList = new ArrayList<>(crashDetailBean.f50772h.size());
                for (Map.Entry<String, PlugInBean> entry : crashDetailBean.f50772h.entrySet()) {
                    bl blVar = new bl();
                    blVar.f51110a = entry.getValue().f50738a;
                    blVar.f51112c = entry.getValue().f50740c;
                    blVar.f51114e = entry.getValue().f50739b;
                    arrayList.add(blVar);
                }
            }
            boVar.f51142p = arrayList;
            al.c("libInfo %s", boVar.f51141o);
            ArrayList<bn> arrayList2 = new ArrayList<>(20);
            a(arrayList2, crashDetailBean);
            a(arrayList2, crashDetailBean.f50787w);
            b(arrayList2, crashDetailBean.f50788x);
            c(arrayList2, crashDetailBean.Z);
            a(arrayList2, crashDetailBean.aa, context);
            a(arrayList2, crashDetailBean.f50789y);
            a(arrayList2, crashDetailBean, context);
            b(arrayList2, crashDetailBean, context);
            a(arrayList2, aaVar.f50821L);
            b(arrayList2, crashDetailBean.Y);
            boVar.f51143q = arrayList2;
            if (crashDetailBean.f50774j) {
                boVar.f51137k = crashDetailBean.f50784t;
            }
            boVar.f51144r = a(crashDetailBean, aaVar);
            boVar.f51145s = new HashMap();
            Map<String, String> map2 = crashDetailBean.S;
            if (map2 != null && map2.size() > 0) {
                boVar.f51145s.putAll(crashDetailBean.S);
                al.a("setted message size %d", Integer.valueOf(boVar.f51145s.size()));
            }
            Map<String, String> map3 = boVar.f51145s;
            al.c("pss:" + crashDetailBean.I + " vss:" + crashDetailBean.J + " javaHeap:" + crashDetailBean.K, new Object[0]);
            StringBuilder sb = new StringBuilder();
            sb.append(crashDetailBean.I);
            map3.put("SDK_UPLOAD_U1", sb.toString());
            StringBuilder sb2 = new StringBuilder();
            sb2.append(crashDetailBean.J);
            map3.put("SDK_UPLOAD_U2", sb2.toString());
            StringBuilder sb3 = new StringBuilder();
            sb3.append(crashDetailBean.K);
            map3.put("SDK_UPLOAD_U3", sb3.toString());
            Object[] objArr = new Object[12];
            objArr[0] = crashDetailBean.f50778n;
            objArr[1] = crashDetailBean.f50767c;
            objArr[2] = aaVar.d();
            objArr[3] = Long.valueOf((crashDetailBean.f50782r - crashDetailBean.Q) / 1000);
            objArr[4] = Boolean.valueOf(crashDetailBean.f50775k);
            objArr[5] = Boolean.valueOf(crashDetailBean.R);
            objArr[6] = Boolean.valueOf(crashDetailBean.f50774j);
            objArr[7] = Boolean.valueOf(crashDetailBean.f50766b == 1);
            objArr[8] = Integer.valueOf(crashDetailBean.f50784t);
            objArr[9] = crashDetailBean.f50783s;
            objArr[10] = Boolean.valueOf(crashDetailBean.f50768d);
            objArr[11] = Integer.valueOf(boVar.f51144r.size());
            al.c("%s rid:%s sess:%s ls:%ds isR:%b isF:%b isM:%b isN:%b mc:%d ,%s ,isUp:%b ,vm:%d", objArr);
            return boVar;
        }
        al.d("enExp args == null", new Object[0]);
        return null;
    }

    private static bp a(Context context, List<CrashDetailBean> list, aa aaVar) {
        if (context != null && list != null && list.size() != 0 && aaVar != null) {
            bp bpVar = new bp();
            bpVar.f51149a = new ArrayList<>();
            for (CrashDetailBean crashDetailBean : list) {
                bpVar.f51149a.add(a(context, crashDetailBean, aaVar));
            }
            return bpVar;
        }
        al.d("enEXPPkg args == null!", new Object[0]);
        return null;
    }

    private static bn a(String str, Context context, String str2) {
        FileInputStream fileInputStream;
        if (str2 != null && context != null) {
            al.c("zip %s", str2);
            File file = new File(str2);
            File file2 = new File(context.getCacheDir(), str);
            if (!ap.a(file, file2)) {
                al.d("zip fail!", new Object[0]);
                return null;
            }
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                fileInputStream = new FileInputStream(file2);
            } catch (Throwable th) {
                th = th;
                fileInputStream = null;
            }
            try {
                byte[] bArr = new byte[4096];
                while (true) {
                    int read = fileInputStream.read(bArr);
                    if (read <= 0) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, read);
                    byteArrayOutputStream.flush();
                }
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                al.c("read bytes :%d", Integer.valueOf(byteArray.length));
                bn bnVar = new bn((byte) 2, file2.getName(), byteArray);
                try {
                    fileInputStream.close();
                } catch (IOException e4) {
                    if (!al.a(e4)) {
                        e4.printStackTrace();
                    }
                }
                if (file2.exists()) {
                    al.c("del tmp", new Object[0]);
                    file2.delete();
                }
                return bnVar;
            } catch (Throwable th2) {
                th = th2;
                try {
                    if (!al.a(th)) {
                        th.printStackTrace();
                    }
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e5) {
                            if (!al.a(e5)) {
                                e5.printStackTrace();
                            }
                        }
                    }
                    if (file2.exists()) {
                        al.c("del tmp", new Object[0]);
                        file2.delete();
                    }
                    return null;
                } catch (Throwable th3) {
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e6) {
                            if (!al.a(e6)) {
                                e6.printStackTrace();
                            }
                        }
                    }
                    if (file2.exists()) {
                        al.c("del tmp", new Object[0]);
                        file2.delete();
                    }
                    throw th3;
                }
            }
        }
        al.d("rqdp{  createZipAttachment sourcePath == null || context == null ,pls check}", new Object[0]);
        return null;
    }

    public static void a(String str, String str2, String str3, String str4, String str5, CrashDetailBean crashDetailBean) {
        String str6;
        aa b4 = aa.b();
        if (b4 == null) {
            return;
        }
        al.e("#++++++++++Record By Bugly++++++++++#", new Object[0]);
        al.e("# You can use Bugly(http:\\\\bugly.qq.com) to get more Crash Detail!", new Object[0]);
        al.e("# PKG NAME: %s", b4.f50824c);
        al.e("# APP VER: %s", b4.f50836o);
        al.e("# SDK VER: %s", b4.f50829h);
        al.e("# LAUNCH TIME: %s", ap.a(new Date(aa.b().f50822a)));
        al.e("# CRASH TYPE: %s", str);
        al.e("# CRASH TIME: %s", str2);
        al.e("# CRASH PROCESS: %s", str3);
        al.e("# CRASH FOREGROUND: %s", Boolean.valueOf(b4.a()));
        al.e("# CRASH THREAD: %s", str4);
        if (crashDetailBean != null) {
            al.e("# REPORT ID: %s", crashDetailBean.f50767c);
            Object[] objArr = new Object[2];
            objArr[0] = b4.h();
            objArr[1] = b4.r().booleanValue() ? "ROOTED" : "UNROOT";
            al.e("# CRASH DEVICE: %s %s", objArr);
            al.e("# RUNTIME AVAIL RAM:%d ROM:%d SD:%d", Long.valueOf(crashDetailBean.C), Long.valueOf(crashDetailBean.D), Long.valueOf(crashDetailBean.E));
            al.e("# RUNTIME TOTAL RAM:%d ROM:%d SD:%d", Long.valueOf(crashDetailBean.F), Long.valueOf(crashDetailBean.G), Long.valueOf(crashDetailBean.H));
            if (!ap.b(crashDetailBean.O)) {
                al.e("# EXCEPTION FIRED BY %s %s", crashDetailBean.O, crashDetailBean.N);
            } else if (crashDetailBean.f50766b == 3) {
                Object[] objArr2 = new Object[1];
                if (crashDetailBean.T == null) {
                    str6 = "null";
                } else {
                    str6 = crashDetailBean.T.get("BUGLY_CR_01");
                }
                objArr2[0] = str6;
                al.e("# EXCEPTION ANR MESSAGE:\n %s", objArr2);
            }
        }
        if (!ap.b(str5)) {
            al.e("# CRASH STACK: ", new Object[0]);
            al.e(str5, new Object[0]);
        }
        al.e("#++++++++++++++++++++++++++++++++++++++++++#", new Object[0]);
    }

    private static void a(CrashDetailBean crashDetailBean, Map<String, String> map) {
        String value;
        if (map != null && !map.isEmpty()) {
            crashDetailBean.S = new LinkedHashMap(map.size());
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (!ap.b(entry.getKey())) {
                    String key = entry.getKey();
                    if (key.length() > 100) {
                        key = key.substring(0, 100);
                        al.d("setted key length is over limit %d substring to %s", 100, key);
                    }
                    if (!ap.b(entry.getValue()) && entry.getValue().length() > 100000) {
                        value = entry.getValue().substring(entry.getValue().length() - 100000);
                        al.d("setted %s value length is over limit %d substring", key, 100000);
                    } else {
                        value = entry.getValue();
                    }
                    crashDetailBean.S.put(key, value);
                    al.a("add setted key %s value size:%d", key, Integer.valueOf(value.length()));
                }
            }
            return;
        }
        al.d("extra map is empty. CrashBean won't have userDatas.", new Object[0]);
    }

    private static void a(ArrayList<bn> arrayList, CrashDetailBean crashDetailBean) {
        String str;
        if (crashDetailBean.f50774j && (str = crashDetailBean.f50783s) != null && str.length() > 0) {
            try {
                arrayList.add(new bn((byte) 1, "alltimes.txt", crashDetailBean.f50783s.getBytes("utf-8")));
            } catch (Exception e4) {
                e4.printStackTrace();
                al.a(e4);
            }
        }
    }

    private static void a(ArrayList<bn> arrayList, String str) {
        if (str != null) {
            try {
                arrayList.add(new bn((byte) 1, "log.txt", str.getBytes("utf-8")));
            } catch (Exception e4) {
                e4.printStackTrace();
                al.a(e4);
            }
        }
    }

    private static void a(ArrayList<bn> arrayList, String str, Context context) {
        if (str != null) {
            try {
                bn a4 = a("backupRecord.zip", context, str);
                if (a4 != null) {
                    al.c("attach backup record", new Object[0]);
                    arrayList.add(a4);
                }
            } catch (Exception e4) {
                al.a(e4);
            }
        }
    }

    private static void a(ArrayList<bn> arrayList, byte[] bArr) {
        if (bArr == null || bArr.length <= 0) {
            return;
        }
        try {
            bn bnVar = new bn((byte) 2, "buglylog.zip", bArr);
            al.c("attach user log", new Object[0]);
            arrayList.add(bnVar);
        } catch (Exception e4) {
            al.a(e4);
        }
    }

    private static void a(ArrayList<bn> arrayList, CrashDetailBean crashDetailBean, Context context) {
        bn a4;
        if (crashDetailBean.f50766b != 3) {
            return;
        }
        al.c("crashBean.anrMessages:%s", crashDetailBean.T);
        try {
            Map<String, String> map = crashDetailBean.T;
            if (map != null && map.containsKey("BUGLY_CR_01")) {
                if (!TextUtils.isEmpty(crashDetailBean.T.get("BUGLY_CR_01"))) {
                    arrayList.add(new bn((byte) 1, "anrMessage.txt", crashDetailBean.T.get("BUGLY_CR_01").getBytes("utf-8")));
                    al.c("attach anr message", new Object[0]);
                }
                crashDetailBean.T.remove("BUGLY_CR_01");
            }
            String str = crashDetailBean.f50786v;
            if (str == null || (a4 = a("trace.zip", context, str)) == null) {
                return;
            }
            al.c("attach traces", new Object[0]);
            arrayList.add(a4);
        } catch (Exception e4) {
            e4.printStackTrace();
            al.a(e4);
        }
    }

    private static void a(ArrayList<bn> arrayList, List<String> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (String str : list) {
            sb.append(str);
        }
        try {
            arrayList.add(new bn((byte) 1, "martianlog.txt", sb.toString().getBytes("utf-8")));
            al.c("attach pageTracingList", new Object[0]);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    private static Map<String, String> a(CrashDetailBean crashDetailBean, aa aaVar) {
        HashMap hashMap = new HashMap(30);
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(crashDetailBean.C);
            hashMap.put("A9", sb.toString());
            StringBuilder sb2 = new StringBuilder();
            sb2.append(crashDetailBean.D);
            hashMap.put("A11", sb2.toString());
            StringBuilder sb3 = new StringBuilder();
            sb3.append(crashDetailBean.E);
            hashMap.put("A10", sb3.toString());
            hashMap.put("A23", crashDetailBean.f50770f);
            StringBuilder sb4 = new StringBuilder();
            aaVar.getClass();
            hashMap.put("A7", sb4.toString());
            hashMap.put("A6", aa.n());
            hashMap.put("A5", aaVar.m());
            hashMap.put("A22", aaVar.g());
            StringBuilder sb5 = new StringBuilder();
            sb5.append(crashDetailBean.G);
            hashMap.put("A2", sb5.toString());
            StringBuilder sb6 = new StringBuilder();
            sb6.append(crashDetailBean.F);
            hashMap.put("A1", sb6.toString());
            hashMap.put("A24", aaVar.f50832k);
            StringBuilder sb7 = new StringBuilder();
            sb7.append(crashDetailBean.H);
            hashMap.put("A17", sb7.toString());
            hashMap.put("A25", aaVar.g());
            hashMap.put("A15", aaVar.q());
            StringBuilder sb8 = new StringBuilder();
            sb8.append(aaVar.r());
            hashMap.put("A13", sb8.toString());
            hashMap.put("A34", crashDetailBean.A);
            if (aaVar.G != null) {
                hashMap.put("productIdentify", aaVar.G);
            }
            hashMap.put("A26", URLEncoder.encode(crashDetailBean.f50764L, "utf-8"));
            boolean z3 = true;
            if (crashDetailBean.f50766b == 1) {
                hashMap.put("A27", crashDetailBean.O);
                hashMap.put("A28", crashDetailBean.N);
                StringBuilder sb9 = new StringBuilder();
                sb9.append(crashDetailBean.f50775k);
                hashMap.put("A29", sb9.toString());
            }
            hashMap.put("A30", crashDetailBean.P);
            StringBuilder sb10 = new StringBuilder();
            sb10.append(crashDetailBean.Q);
            hashMap.put("A18", sb10.toString());
            StringBuilder sb11 = new StringBuilder();
            if (crashDetailBean.R) {
                z3 = false;
            }
            sb11.append(z3);
            hashMap.put("A36", sb11.toString());
            StringBuilder sb12 = new StringBuilder();
            sb12.append(aaVar.f50847z);
            hashMap.put("F02", sb12.toString());
            StringBuilder sb13 = new StringBuilder();
            sb13.append(aaVar.A);
            hashMap.put("F03", sb13.toString());
            hashMap.put("F04", aaVar.d());
            StringBuilder sb14 = new StringBuilder();
            sb14.append(aaVar.B);
            hashMap.put("F05", sb14.toString());
            hashMap.put("F06", aaVar.f50846y);
            hashMap.put("F08", aaVar.E);
            hashMap.put("F09", aaVar.F);
            StringBuilder sb15 = new StringBuilder();
            sb15.append(aaVar.C);
            hashMap.put("F10", sb15.toString());
            a(hashMap, crashDetailBean);
        } catch (Exception e4) {
            e4.printStackTrace();
            al.a(e4);
        }
        return hashMap;
    }

    private static void a(Map<String, String> map, CrashDetailBean crashDetailBean) {
        if (crashDetailBean.U >= 0) {
            StringBuilder sb = new StringBuilder();
            sb.append(crashDetailBean.U);
            map.put("C01", sb.toString());
        }
        if (crashDetailBean.V >= 0) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(crashDetailBean.V);
            map.put("C02", sb2.toString());
        }
        Map<String, String> map2 = crashDetailBean.W;
        if (map2 != null && map2.size() > 0) {
            for (Map.Entry<String, String> entry : crashDetailBean.W.entrySet()) {
                map.put("C03_" + entry.getKey(), entry.getValue());
            }
        }
        Map<String, String> map3 = crashDetailBean.X;
        if (map3 == null || map3.size() <= 0) {
            return;
        }
        for (Map.Entry<String, String> entry2 : crashDetailBean.X.entrySet()) {
            map.put("C04_" + entry2.getKey(), entry2.getValue());
        }
    }

    static /* synthetic */ void a(List list, boolean z3, long j4, String str, String str2) {
        if (list == null || list.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            CrashDetailBean crashDetailBean = (CrashDetailBean) it.next();
            String str3 = f50972l.get(Integer.valueOf(crashDetailBean.f50766b));
            if (!TextUtils.isEmpty(str3)) {
                arrayList.add(new ag.c(crashDetailBean.f50767c, str3, crashDetailBean.f50782r, z3, j4, str, str2));
            }
        }
        ag.a.a().a(arrayList);
    }
}

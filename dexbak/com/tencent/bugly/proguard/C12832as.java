package com.tencent.bugly.proguard;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Pair;
import com.snail.antifake.deviceid.ShellAdbUtils;
import com.tencent.bugly.BUGLY;
import com.tencent.bugly.crashreport.common.info.PlugInBean;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.crashreport.crash.CrashDetailBean;
import com.tencent.bugly.proguard.C12808ag;
import com.umeng.analytics.pro.C13131bm;
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

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.proguard.as */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public final class C12832as {

    /* renamed from: a */
    public static int f36593a;

    /* renamed from: h */
    private static final Map<Integer, Pair<String, String>> f36594h = new HashMap<Integer, Pair<String, String>>() { // from class: com.tencent.bugly.proguard.as.1
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

    /* renamed from: i */
    private static final ArrayList<AbstractC12839a> f36595i = new ArrayList<AbstractC12839a>() { // from class: com.tencent.bugly.proguard.as.2
        {
            add(new C12840b((byte) 0));
            add(new C12841c((byte) 0));
            add(new C12842d((byte) 0));
            add(new C12843e((byte) 0));
            add(new C12846h((byte) 0));
            add(new C12847i((byte) 0));
            add(new C12844f((byte) 0));
            add(new C12845g((byte) 0));
        }
    };

    /* renamed from: j */
    private static final Map<Integer, Integer> f36596j = new HashMap<Integer, Integer>() { // from class: com.tencent.bugly.proguard.as.3
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

    /* renamed from: k */
    private static final Map<Integer, String> f36597k = new HashMap<Integer, String>() { // from class: com.tencent.bugly.proguard.as.4
        {
            put(3, "BuglyAnrCrash");
            put(0, "BuglyJavaCrash");
            put(1, "BuglyNativeCrash");
        }
    };

    /* renamed from: l */
    private static final Map<Integer, String> f36598l = new HashMap<Integer, String>() { // from class: com.tencent.bugly.proguard.as.5
        {
            put(3, "BuglyAnrCrashReport");
            put(0, "BuglyJavaCrashReport");
            put(1, "BuglyNativeCrashReport");
        }
    };

    /* renamed from: b */
    protected final Context f36599b;

    /* renamed from: c */
    protected final C12814ai f36600c;

    /* renamed from: d */
    protected final C12920w f36601d;

    /* renamed from: e */
    protected final C12803ac f36602e;

    /* renamed from: f */
    protected InterfaceC12857aw f36603f;

    /* renamed from: g */
    protected BUGLY.C12768a f36604g;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BUGLY */
    /* renamed from: com.tencent.bugly.proguard.as$a */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static abstract class AbstractC12839a {

        /* renamed from: a */
        final int f36609a;

        /* synthetic */ AbstractC12839a(int i, byte b) {
            this(i);
        }

        /* renamed from: a */
        abstract boolean mo15756a();

        private AbstractC12839a(int i) {
            this.f36609a = i;
        }
    }

    /* compiled from: BUGLY */
    /* renamed from: com.tencent.bugly.proguard.as$b */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    static class C12840b extends AbstractC12839a {
        /* synthetic */ C12840b(byte b) {
            this();
        }

        @Override // com.tencent.bugly.proguard.C12832as.AbstractC12839a
        /* renamed from: a */
        final boolean mo15756a() {
            return C12848at.m15755a().m15739k();
        }

        private C12840b() {
            super(3, (byte) 0);
        }
    }

    /* compiled from: BUGLY */
    /* renamed from: com.tencent.bugly.proguard.as$c */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    static class C12841c extends AbstractC12839a {
        /* synthetic */ C12841c(byte b) {
            this();
        }

        @Override // com.tencent.bugly.proguard.C12832as.AbstractC12839a
        /* renamed from: a */
        final boolean mo15756a() {
            return true;
        }

        private C12841c() {
            super(7, (byte) 0);
        }
    }

    /* compiled from: BUGLY */
    /* renamed from: com.tencent.bugly.proguard.as$d */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    static class C12842d extends AbstractC12839a {
        /* synthetic */ C12842d(byte b) {
            this();
        }

        @Override // com.tencent.bugly.proguard.C12832as.AbstractC12839a
        /* renamed from: a */
        final boolean mo15756a() {
            return true;
        }

        private C12842d() {
            super(2, (byte) 0);
        }
    }

    /* compiled from: BUGLY */
    /* renamed from: com.tencent.bugly.proguard.as$e */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    static class C12843e extends AbstractC12839a {
        /* synthetic */ C12843e(byte b) {
            this();
        }

        @Override // com.tencent.bugly.proguard.C12832as.AbstractC12839a
        /* renamed from: a */
        final boolean mo15756a() {
            return C12848at.m15755a().m15740j();
        }

        private C12843e() {
            super(0, (byte) 0);
        }
    }

    /* compiled from: BUGLY */
    /* renamed from: com.tencent.bugly.proguard.as$f */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    static class C12844f extends AbstractC12839a {
        /* synthetic */ C12844f(byte b) {
            this();
        }

        @Override // com.tencent.bugly.proguard.C12832as.AbstractC12839a
        /* renamed from: a */
        final boolean mo15756a() {
            return (C12848at.m15755a().f36629B & 2) > 0;
        }

        private C12844f() {
            super(5, (byte) 0);
        }
    }

    /* compiled from: BUGLY */
    /* renamed from: com.tencent.bugly.proguard.as$g */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    static class C12845g extends AbstractC12839a {
        /* synthetic */ C12845g(byte b) {
            this();
        }

        @Override // com.tencent.bugly.proguard.C12832as.AbstractC12839a
        /* renamed from: a */
        final boolean mo15756a() {
            return (C12848at.m15755a().f36629B & 1) > 0;
        }

        private C12845g() {
            super(6, (byte) 0);
        }
    }

    /* compiled from: BUGLY */
    /* renamed from: com.tencent.bugly.proguard.as$h */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    static class C12846h extends AbstractC12839a {
        /* synthetic */ C12846h(byte b) {
            this();
        }

        @Override // com.tencent.bugly.proguard.C12832as.AbstractC12839a
        /* renamed from: a */
        final boolean mo15756a() {
            return C12848at.m15755a().m15740j();
        }

        private C12846h() {
            super(1, (byte) 0);
        }
    }

    /* compiled from: BUGLY */
    /* renamed from: com.tencent.bugly.proguard.as$i */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    static class C12847i extends AbstractC12839a {
        /* synthetic */ C12847i(byte b) {
            this();
        }

        @Override // com.tencent.bugly.proguard.C12832as.AbstractC12839a
        /* renamed from: a */
        final boolean mo15756a() {
            return (C12848at.m15755a().f36629B & 4) > 0;
        }

        private C12847i() {
            super(4, (byte) 0);
        }
    }

    public C12832as(Context context, C12814ai c12814ai, C12920w c12920w, C12803ac c12803ac, BUGLY.C12768a c12768a) {
        f36593a = 1004;
        this.f36599b = context;
        this.f36600c = c12814ai;
        this.f36601d = c12920w;
        this.f36602e = c12803ac;
        this.f36604g = c12768a;
        this.f36603f = null;
    }

    /* renamed from: a */
    private static List<C12831ar> m15779a(List<C12831ar> list) {
        if (list == null || list.size() == 0) {
            return null;
        }
        long currentTimeMillis = System.currentTimeMillis();
        ArrayList arrayList = new ArrayList();
        for (C12831ar c12831ar : list) {
            if (c12831ar.f36590d && c12831ar.f36588b <= currentTimeMillis - 86400000) {
                arrayList.add(c12831ar);
            }
        }
        return arrayList;
    }

    /* renamed from: b */
    private static void m15770b(CrashDetailBean crashDetailBean, List<C12831ar> list) {
        StringBuilder sb = new StringBuilder(64);
        for (C12831ar c12831ar : list) {
            if (!c12831ar.f36591e && !c12831ar.f36590d) {
                String str = crashDetailBean.f36359s;
                StringBuilder sb2 = new StringBuilder();
                sb2.append(c12831ar.f36588b);
                if (!str.contains(sb2.toString())) {
                    crashDetailBean.f36360t++;
                    sb.append(c12831ar.f36588b);
                    sb.append(ShellAdbUtils.f33810d);
                }
            }
        }
        crashDetailBean.f36359s += sb.toString();
    }

    /* renamed from: c */
    private static ContentValues m15763c(CrashDetailBean crashDetailBean) {
        if (crashDetailBean == null) {
            return null;
        }
        try {
            ContentValues contentValues = new ContentValues();
            long j = crashDetailBean.f36340a;
            if (j > 0) {
                contentValues.put(C13131bm.f37927d, Long.valueOf(j));
            }
            contentValues.put("_tm", Long.valueOf(crashDetailBean.f36358r));
            contentValues.put("_s1", crashDetailBean.f36361u);
            int i = 1;
            contentValues.put("_up", Integer.valueOf(crashDetailBean.f36344d ? 1 : 0));
            if (!crashDetailBean.f36350j) {
                i = 0;
            }
            contentValues.put("_me", Integer.valueOf(i));
            contentValues.put("_uc", Integer.valueOf(crashDetailBean.f36352l));
            contentValues.put("_dt", C12828ap.m15840a(crashDetailBean));
            return contentValues;
        } catch (Throwable th) {
            if (!C12820al.m15877a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    /* renamed from: d */
    private static void m15759d(List<C12831ar> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("_id in (");
        for (C12831ar c12831ar : list) {
            sb.append(c12831ar.f36587a);
            sb.append(",");
        }
        StringBuilder sb2 = new StringBuilder(sb.substring(0, sb.lastIndexOf(",")));
        sb2.append(")");
        String sb3 = sb2.toString();
        sb2.setLength(0);
        try {
            C12820al.m15874c("deleted %s data %d", "t_cr", Integer.valueOf(C12920w.m15509a().m15493a("t_cr", sb3)));
        } catch (Throwable th) {
            if (C12820al.m15877a(th)) {
                return;
            }
            th.printStackTrace();
        }
    }

    /* renamed from: e */
    private static void m15757e(List<CrashDetailBean> list) {
        try {
            if (list.size() == 0) {
                return;
            }
            StringBuilder sb = new StringBuilder();
            for (CrashDetailBean crashDetailBean : list) {
                sb.append(" or _id = ");
                sb.append(crashDetailBean.f36340a);
            }
            String sb2 = sb.toString();
            if (sb2.length() > 0) {
                sb2 = sb2.substring(4);
            }
            sb.setLength(0);
            C12820al.m15874c("deleted %s data %d", "t_cr", Integer.valueOf(C12920w.m15509a().m15493a("t_cr", sb2)));
        } catch (Throwable th) {
            if (C12820al.m15877a(th)) {
                return;
            }
            th.printStackTrace();
        }
    }

    /* renamed from: b */
    private static void m15764b(List<C12831ar> list) {
        List<CrashDetailBean> m15761c = m15761c(list);
        if (m15761c == null || m15761c.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (CrashDetailBean crashDetailBean : m15761c) {
            String str = f36598l.get(Integer.valueOf(crashDetailBean.f36342b));
            if (!TextUtils.isEmpty(str)) {
                C12820al.m15874c("find expired data,crashId:%s eventType:%s", crashDetailBean.f36343c, str);
                arrayList.add(new C12808ag.C12812c(crashDetailBean.f36343c, str, crashDetailBean.f36358r, false, 0L, "expired", null));
            }
        }
        C12808ag.C12810a.m15914a().m15920a(arrayList);
    }

    /* renamed from: a */
    private static CrashDetailBean m15777a(List<C12831ar> list, CrashDetailBean crashDetailBean) {
        List<CrashDetailBean> m15761c;
        if (list.isEmpty()) {
            return crashDetailBean;
        }
        CrashDetailBean crashDetailBean2 = null;
        ArrayList arrayList = new ArrayList(10);
        for (C12831ar c12831ar : list) {
            if (c12831ar.f36591e) {
                arrayList.add(c12831ar);
            }
        }
        if (!arrayList.isEmpty() && (m15761c = m15761c(arrayList)) != null && !m15761c.isEmpty()) {
            Collections.sort(m15761c);
            crashDetailBean2 = m15761c.get(0);
            m15792a(crashDetailBean2, m15761c);
        }
        if (crashDetailBean2 == null) {
            crashDetailBean.f36350j = true;
            crashDetailBean.f36360t = 0;
            crashDetailBean.f36359s = "";
            crashDetailBean2 = crashDetailBean;
        }
        m15770b(crashDetailBean2, list);
        if (crashDetailBean2.f36358r != crashDetailBean.f36358r) {
            String str = crashDetailBean2.f36359s;
            StringBuilder sb = new StringBuilder();
            sb.append(crashDetailBean.f36358r);
            if (!str.contains(sb.toString())) {
                crashDetailBean2.f36360t++;
                crashDetailBean2.f36359s += crashDetailBean.f36358r + ShellAdbUtils.f33810d;
            }
        }
        return crashDetailBean2;
    }

    /* renamed from: c */
    private static List<CrashDetailBean> m15761c(List<C12831ar> list) {
        Cursor cursor;
        if (list == null || list.size() == 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("_id in (");
        for (C12831ar c12831ar : list) {
            sb.append(c12831ar.f36587a);
            sb.append(",");
        }
        if (sb.toString().contains(",")) {
            sb = new StringBuilder(sb.substring(0, sb.lastIndexOf(",")));
        }
        sb.append(")");
        String sb2 = sb.toString();
        sb.setLength(0);
        try {
            cursor = C12920w.m15509a().m15491a("t_cr", (String[]) null, sb2);
            if (cursor == null) {
                return null;
            }
            try {
                ArrayList arrayList = new ArrayList();
                sb.append("_id in (");
                int i = 0;
                while (cursor.moveToNext()) {
                    CrashDetailBean m15795a = m15795a(cursor);
                    if (m15795a != null) {
                        arrayList.add(m15795a);
                    } else {
                        sb.append(cursor.getLong(cursor.getColumnIndex(C13131bm.f37927d)));
                        sb.append(",");
                        i++;
                    }
                }
                if (sb.toString().contains(",")) {
                    sb = new StringBuilder(sb.substring(0, sb.lastIndexOf(",")));
                }
                sb.append(")");
                String sb3 = sb.toString();
                if (i > 0) {
                    C12820al.m15873d("deleted %s illegal data %d", "t_cr", Integer.valueOf(C12920w.m15509a().m15493a("t_cr", sb3)));
                }
                cursor.close();
                return arrayList;
            } catch (Throwable th) {
                th = th;
                try {
                    if (!C12820al.m15877a(th)) {
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

    /* renamed from: e */
    private static String m15758e(CrashDetailBean crashDetailBean) {
        try {
            Pair<String, String> pair = f36594h.get(Integer.valueOf(crashDetailBean.f36342b));
            if (pair == null) {
                C12820al.m15872e("crash type error! %d", Integer.valueOf(crashDetailBean.f36342b));
                return "";
            } else if (crashDetailBean.f36350j) {
                return (String) pair.first;
            } else {
                return (String) pair.second;
            }
        } catch (Exception e) {
            C12820al.m15877a(e);
            return "";
        }
    }

    /* renamed from: d */
    private boolean m15760d(CrashDetailBean crashDetailBean) {
        try {
            C12820al.m15874c("save eup logs", new Object[0]);
            C12786aa m16005b = C12786aa.m16005b();
            String str = "#--------\npackage:" + m16005b.m15998e() + "\nversion:" + m16005b.f36462o + "\nsdk:" + m16005b.f36455h + "\nprocess:" + crashDetailBean.f36314A + "\ndate:" + C12828ap.m15827a(new Date(crashDetailBean.f36358r)) + "\ntype:" + crashDetailBean.f36354n + "\nmessage:" + crashDetailBean.f36355o + "\nstack:\n" + crashDetailBean.f36357q + "\neupID:" + crashDetailBean.f36343c + ShellAdbUtils.f33810d;
            String str2 = null;
            if (C12848at.f36622m == null) {
                if (Environment.getExternalStorageState().equals("mounted")) {
                    str2 = Environment.getExternalStorageDirectory().getAbsolutePath() + "/Tencent/" + this.f36599b.getPackageName();
                }
            } else {
                File file = new File(C12848at.f36622m);
                if (file.isFile()) {
                    file = file.getParentFile();
                }
                str2 = file.getAbsolutePath();
            }
            C12821am.m15869a(str2 + "/euplog.txt", str, C12848at.f36623n);
            return true;
        } catch (Throwable th) {
            C12820al.m15873d("rqdp{  save error} %s", th.toString());
            if (!C12820al.m15877a(th)) {
                th.printStackTrace();
            }
            return false;
        }
    }

    /* renamed from: b */
    public final void m15768b(CrashDetailBean crashDetailBean, boolean z) {
        if (C12848at.f36624o) {
            C12820al.m15878a("try to upload right now", new Object[0]);
            ArrayList arrayList = new ArrayList();
            arrayList.add(crashDetailBean);
            m15778a(arrayList, 3000L, z, crashDetailBean.f36342b == 7, z);
            return;
        }
        C12820al.m15878a("do not upload spot crash right now, crash would be uploaded when app next start", new Object[0]);
    }

    /* renamed from: b */
    public final void m15771b(CrashDetailBean crashDetailBean) {
        if (crashDetailBean == null) {
            return;
        }
        ContentValues m15763c = m15763c(crashDetailBean);
        if (m15763c != null) {
            long m15494a = C12920w.m15509a().m15494a("t_cr", m15763c, (InterfaceC12919v) null);
            if (m15494a >= 0) {
                C12820al.m15874c("insert %s success!", "t_cr");
                crashDetailBean.f36340a = m15494a;
            }
        }
        if (C12848at.f36621l) {
            m15760d(crashDetailBean);
        }
    }

    /* renamed from: a */
    private static void m15792a(CrashDetailBean crashDetailBean, List<CrashDetailBean> list) {
        String[] split;
        StringBuilder sb = new StringBuilder(128);
        for (int i = 1; i < list.size(); i++) {
            String str = list.get(i).f36359s;
            if (str != null && (split = str.split(ShellAdbUtils.f33810d)) != null) {
                for (String str2 : split) {
                    if (!crashDetailBean.f36359s.contains(str2)) {
                        crashDetailBean.f36360t++;
                        sb.append(str2);
                        sb.append(ShellAdbUtils.f33810d);
                    }
                }
            }
        }
        crashDetailBean.f36359s += sb.toString();
    }

    /* renamed from: b */
    private static C12831ar m15772b(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        try {
            C12831ar c12831ar = new C12831ar();
            c12831ar.f36587a = cursor.getLong(cursor.getColumnIndex(C13131bm.f37927d));
            c12831ar.f36588b = cursor.getLong(cursor.getColumnIndex("_tm"));
            c12831ar.f36589c = cursor.getString(cursor.getColumnIndex("_s1"));
            c12831ar.f36590d = cursor.getInt(cursor.getColumnIndex("_up")) == 1;
            c12831ar.f36591e = cursor.getInt(cursor.getColumnIndex("_me")) == 1;
            c12831ar.f36592f = cursor.getInt(cursor.getColumnIndex("_uc"));
            return c12831ar;
        } catch (Throwable th) {
            if (!C12820al.m15877a(th)) {
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
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean m15789a(com.tencent.bugly.crashreport.crash.CrashDetailBean r20, boolean r21) {
        /*
            Method dump skipped, instructions count: 646
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.C12832as.m15789a(com.tencent.bugly.crashreport.crash.CrashDetailBean, boolean):boolean");
    }

    /* renamed from: b */
    private static List<C12831ar> m15773b() {
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            Cursor m15491a = C12920w.m15509a().m15491a("t_cr", new String[]{C13131bm.f37927d, "_tm", "_s1", "_up", "_me", "_uc"}, (String) null);
            if (m15491a == null) {
                if (m15491a != null) {
                    m15491a.close();
                }
                return null;
            }
            try {
                if (m15491a.getCount() <= 0) {
                    m15491a.close();
                    return arrayList;
                }
                StringBuilder sb = new StringBuilder();
                sb.append("_id in (");
                int i = 0;
                while (m15491a.moveToNext()) {
                    C12831ar m15772b = m15772b(m15491a);
                    if (m15772b != null) {
                        arrayList.add(m15772b);
                    } else {
                        sb.append(m15491a.getLong(m15491a.getColumnIndex(C13131bm.f37927d)));
                        sb.append(",");
                        i++;
                    }
                }
                if (sb.toString().contains(",")) {
                    sb = new StringBuilder(sb.substring(0, sb.lastIndexOf(",")));
                }
                sb.append(")");
                String sb2 = sb.toString();
                sb.setLength(0);
                if (i > 0) {
                    C12820al.m15873d("deleted %s illegal data %d", "t_cr", Integer.valueOf(C12920w.m15509a().m15493a("t_cr", sb2)));
                }
                m15491a.close();
                return arrayList;
            } catch (Throwable th) {
                th = th;
                cursor = m15491a;
                try {
                    if (!C12820al.m15877a(th)) {
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

    /* renamed from: c */
    private static void m15762c(ArrayList<C12881bn> arrayList, String str) {
        if (C12828ap.m15817b(str)) {
            return;
        }
        try {
            C12881bn c12881bn = new C12881bn((byte) 1, "crashInfos.txt", str.getBytes("utf-8"));
            C12820al.m15874c("attach crash infos", new Object[0]);
            arrayList.add(c12881bn);
        } catch (Exception e) {
            e.printStackTrace();
            C12820al.m15877a(e);
        }
    }

    /* renamed from: b */
    private static void m15766b(ArrayList<C12881bn> arrayList, String str) {
        if (str != null) {
            try {
                arrayList.add(new C12881bn((byte) 1, "jniLog.txt", str.getBytes("utf-8")));
            } catch (Exception e) {
                e.printStackTrace();
                C12820al.m15877a(e);
            }
        }
    }

    /* renamed from: b */
    private static void m15767b(ArrayList<C12881bn> arrayList, CrashDetailBean crashDetailBean, Context context) {
        String str;
        if (crashDetailBean.f36342b == 1 && (str = crashDetailBean.f36362v) != null) {
            try {
                C12881bn m15787a = m15787a("tomb.zip", context, str);
                if (m15787a != null) {
                    C12820al.m15874c("attach tombs", new Object[0]);
                    arrayList.add(m15787a);
                }
            } catch (Exception e) {
                C12820al.m15877a(e);
            }
        }
    }

    /* renamed from: b */
    private static void m15765b(ArrayList<C12881bn> arrayList, byte[] bArr) {
        if (bArr == null || bArr.length <= 0) {
            return;
        }
        try {
            arrayList.add(new C12881bn((byte) 1, "userExtraByteData", bArr));
            C12820al.m15874c("attach extraData", new Object[0]);
        } catch (Exception e) {
            C12820al.m15877a(e);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0036, code lost:
        if (r0.size() >= com.tencent.bugly.proguard.C12848at.f36613d) goto L18;
     */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean m15769b(com.tencent.bugly.crashreport.crash.CrashDetailBean r9, java.util.List<com.tencent.bugly.proguard.C12831ar> r10, java.util.List<com.tencent.bugly.proguard.C12831ar> r11) {
        /*
            r8 = this;
            int r0 = r9.f36342b
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
            boolean r4 = com.tencent.bugly.proguard.C12904p.f36892c
            if (r4 != 0) goto L1f
            if (r0 != 0) goto L1c
            if (r3 != 0) goto L1c
            r0 = 1
            goto L20
        L1c:
            boolean r0 = com.tencent.bugly.proguard.C12848at.f36614e
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
            boolean r10 = m15791a(r9, r10, r0)
            if (r10 != 0) goto L38
            int r10 = r0.size()     // Catch: java.lang.Exception -> L6d
            int r3 = com.tencent.bugly.proguard.C12848at.f36613d     // Catch: java.lang.Exception -> L6d
            if (r10 < r3) goto L78
        L38:
            java.lang.String r10 = "same crash occur too much do merged!"
            java.lang.Object[] r3 = new java.lang.Object[r2]     // Catch: java.lang.Exception -> L6d
            com.tencent.bugly.proguard.C12820al.m15878a(r10, r3)     // Catch: java.lang.Exception -> L6d
            com.tencent.bugly.crashreport.crash.CrashDetailBean r9 = m15777a(r0, r9)     // Catch: java.lang.Exception -> L6d
            java.util.Iterator r10 = r0.iterator()     // Catch: java.lang.Exception -> L6d
        L47:
            boolean r0 = r10.hasNext()     // Catch: java.lang.Exception -> L6d
            if (r0 == 0) goto L5f
            java.lang.Object r0 = r10.next()     // Catch: java.lang.Exception -> L6d
            com.tencent.bugly.proguard.ar r0 = (com.tencent.bugly.proguard.C12831ar) r0     // Catch: java.lang.Exception -> L6d
            long r3 = r0.f36587a     // Catch: java.lang.Exception -> L6d
            long r5 = r9.f36340a     // Catch: java.lang.Exception -> L6d
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 == 0) goto L47
            r11.add(r0)     // Catch: java.lang.Exception -> L6d
            goto L47
        L5f:
            r8.m15771b(r9)     // Catch: java.lang.Exception -> L6d
            m15759d(r11)     // Catch: java.lang.Exception -> L6d
            java.lang.String r9 = "[crash] save crash success. For this device crash many times, it will not upload crashes immediately"
            java.lang.Object[] r10 = new java.lang.Object[r2]     // Catch: java.lang.Exception -> L6d
            com.tencent.bugly.proguard.C12820al.m15876b(r9, r10)     // Catch: java.lang.Exception -> L6d
            return r1
        L6d:
            r9 = move-exception
            com.tencent.bugly.proguard.C12820al.m15877a(r9)
            java.lang.Object[] r9 = new java.lang.Object[r2]
            java.lang.String r10 = "Failed to merge crash."
            com.tencent.bugly.proguard.C12820al.m15873d(r10, r9)
        L78:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.C12832as.m15769b(com.tencent.bugly.crashreport.crash.CrashDetailBean, java.util.List, java.util.List):boolean");
    }

    /* renamed from: a */
    private static boolean m15788a(String str) {
        String str2 = C12848at.f36627r;
        if (str2 != null && !str2.isEmpty()) {
            try {
                C12820al.m15874c("Crash regular filter for crash stack is: %s", C12848at.f36627r);
                if (Pattern.compile(C12848at.f36627r).matcher(str).find()) {
                    C12820al.m15873d("This crash matches the regular filter string set. It will not be record and upload.", new Object[0]);
                    return true;
                }
            } catch (Exception e) {
                C12820al.m15877a(e);
                C12820al.m15873d("Failed to compile " + C12848at.f36627r, new Object[0]);
            }
        }
        return false;
    }

    /* renamed from: a */
    private static boolean m15791a(CrashDetailBean crashDetailBean, List<C12831ar> list, List<C12831ar> list2) {
        boolean z = false;
        for (C12831ar c12831ar : list) {
            if (crashDetailBean.f36361u.equals(c12831ar.f36589c)) {
                if (c12831ar.f36591e) {
                    z = true;
                }
                list2.add(c12831ar);
            }
        }
        return z;
    }

    /* renamed from: a */
    public static List<CrashDetailBean> m15798a() {
        StrategyBean m15941c = C12803ac.m15950a().m15941c();
        if (m15941c == null) {
            C12820al.m15873d("have not synced remote!", new Object[0]);
            return null;
        } else if (!m15941c.f36296f) {
            C12820al.m15873d("Crashreport remote closed, please check your APP ID correct and Version available, then uninstall and reinstall your app.", new Object[0]);
            C12820al.m15876b("[init] WARNING! Crashreport closed by server, please check your APP ID correct and Version available, then uninstall and reinstall your app.", new Object[0]);
            return null;
        } else {
            long currentTimeMillis = System.currentTimeMillis();
            long m15823b = C12828ap.m15823b();
            List<C12831ar> m15773b = m15773b();
            C12820al.m15874c("Size of crash list loaded from DB: %s", Integer.valueOf(m15773b.size()));
            if (m15773b.size() <= 0) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            arrayList.addAll(m15779a(m15773b));
            m15773b.removeAll(arrayList);
            Iterator<C12831ar> it = m15773b.iterator();
            while (it.hasNext()) {
                C12831ar next = it.next();
                long j = next.f36588b;
                if (j < m15823b - C12848at.f36619j) {
                    arrayList2.add(next);
                    it.remove();
                    arrayList.add(next);
                } else if (next.f36590d) {
                    if (j >= currentTimeMillis - 86400000) {
                        it.remove();
                    } else if (!next.f36591e) {
                        it.remove();
                        arrayList.add(next);
                    }
                } else if (next.f36592f >= 3 && j < currentTimeMillis - 86400000) {
                    it.remove();
                    arrayList.add(next);
                }
            }
            m15764b(arrayList2);
            if (arrayList.size() > 0) {
                m15759d(arrayList);
            }
            ArrayList arrayList3 = new ArrayList();
            List<CrashDetailBean> m15761c = m15761c(m15773b);
            if (m15761c != null && m15761c.size() > 0) {
                String str = C12786aa.m16005b().f36462o;
                Iterator<CrashDetailBean> it2 = m15761c.iterator();
                while (it2.hasNext()) {
                    CrashDetailBean next2 = it2.next();
                    if (!str.equals(next2.f36346f)) {
                        it2.remove();
                        arrayList3.add(next2);
                    }
                }
            }
            if (arrayList3.size() > 0) {
                m15757e(arrayList3);
            }
            return m15761c;
        }
    }

    /* renamed from: a */
    public final void m15794a(CrashDetailBean crashDetailBean) {
        int i = crashDetailBean.f36342b;
        if (i != 0) {
            if (i != 1) {
                if (i == 3 && !C12848at.m15755a().m15739k()) {
                    return;
                }
            } else if (!C12848at.m15755a().m15740j()) {
                return;
            }
        } else if (!C12848at.m15755a().m15740j()) {
            return;
        }
        if (this.f36603f != null) {
            C12820al.m15874c("Calling 'onCrashHandleEnd' of RQD crash listener.", new Object[0]);
        }
    }

    /* renamed from: a */
    public final void m15778a(final List<CrashDetailBean> list, long j, final boolean z, boolean z2, boolean z3) {
        if (!C12786aa.m16009a(this.f36599b).f36453f) {
            C12820al.m15873d("warn: not upload process", new Object[0]);
            return;
        }
        C12814ai c12814ai = this.f36600c;
        if (c12814ai == null) {
            C12820al.m15873d("warn: upload manager is null", new Object[0]);
        } else if (!z3 && !c12814ai.m15897b(C12848at.f36611a)) {
            C12820al.m15873d("warn: not crashHappen or not should upload", new Object[0]);
        } else {
            StrategyBean m15941c = this.f36602e.m15941c();
            if (!m15941c.f36296f) {
                C12820al.m15873d("remote report is disable!", new Object[0]);
                C12820al.m15876b("[crash] server closed bugly in this app. please check your appid if is correct, and re-install it", new Object[0]);
            } else if (list != null && list.size() != 0) {
                try {
                    String str = m15941c.f36308r;
                    String str2 = StrategyBean.f36292b;
                    C12883bp m15796a = m15796a(this.f36599b, list, C12786aa.m16005b());
                    if (m15796a == null) {
                        C12820al.m15873d("create eupPkg fail!", new Object[0]);
                        return;
                    }
                    byte[] m15932a = C12806ae.m15932a((AbstractC12901m) m15796a);
                    if (m15932a == null) {
                        C12820al.m15873d("send encode fail!", new Object[0]);
                        return;
                    }
                    C12884bq m15934a = C12806ae.m15934a(this.f36599b, 830, m15932a);
                    if (m15934a == null) {
                        C12820al.m15873d("request package is null.", new Object[0]);
                        return;
                    }
                    final long currentTimeMillis = System.currentTimeMillis();
                    InterfaceC12813ah interfaceC12813ah = new InterfaceC12813ah() { // from class: com.tencent.bugly.proguard.as.6
                        @Override // com.tencent.bugly.proguard.InterfaceC12813ah
                        /* renamed from: a */
                        public final void mo15546a(boolean z4, String str3) {
                            C12832as.m15776a(list, z4, System.currentTimeMillis() - currentTimeMillis, z ? "realtime" : "cache", str3);
                            C12832as.m15774a(z4, list);
                        }
                    };
                    if (z) {
                        this.f36600c.m15909a(f36593a, m15934a, str, str2, interfaceC12813ah, j, z2);
                    } else {
                        this.f36600c.m15908a(f36593a, m15934a, str, str2, interfaceC12813ah, false);
                    }
                } catch (Throwable th) {
                    C12820al.m15872e("req cr error %s", th.toString());
                    if (C12820al.m15875b(th)) {
                        return;
                    }
                    th.printStackTrace();
                }
            } else {
                C12820al.m15873d("warn: crashList is null or crashList num is 0", new Object[0]);
            }
        }
    }

    /* renamed from: a */
    public static void m15774a(boolean z, List<CrashDetailBean> list) {
        if (list != null && list.size() > 0) {
            C12820al.m15874c("up finish update state %b", Boolean.valueOf(z));
            for (CrashDetailBean crashDetailBean : list) {
                C12820al.m15874c("pre uid:%s uc:%d re:%b me:%b", crashDetailBean.f36343c, Integer.valueOf(crashDetailBean.f36352l), Boolean.valueOf(crashDetailBean.f36344d), Boolean.valueOf(crashDetailBean.f36350j));
                int i = crashDetailBean.f36352l + 1;
                crashDetailBean.f36352l = i;
                crashDetailBean.f36344d = z;
                C12820al.m15874c("set uid:%s uc:%d re:%b me:%b", crashDetailBean.f36343c, Integer.valueOf(i), Boolean.valueOf(crashDetailBean.f36344d), Boolean.valueOf(crashDetailBean.f36350j));
            }
            for (CrashDetailBean crashDetailBean2 : list) {
                C12848at.m15755a().m15752a(crashDetailBean2);
            }
            C12820al.m15874c("update state size %d", Integer.valueOf(list.size()));
        }
        if (z) {
            return;
        }
        C12820al.m15876b("[crash] upload fail.", new Object[0]);
    }

    /* renamed from: a */
    private static CrashDetailBean m15795a(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        try {
            byte[] blob = cursor.getBlob(cursor.getColumnIndex("_dt"));
            if (blob == null) {
                return null;
            }
            long j = cursor.getLong(cursor.getColumnIndex(C13131bm.f37927d));
            CrashDetailBean crashDetailBean = (CrashDetailBean) C12828ap.m15824a(blob, CrashDetailBean.CREATOR);
            if (crashDetailBean != null) {
                crashDetailBean.f36340a = j;
            }
            return crashDetailBean;
        } catch (Throwable th) {
            if (!C12820al.m15877a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    /* renamed from: a */
    private static C12882bo m15797a(Context context, CrashDetailBean crashDetailBean, C12786aa c12786aa) {
        ArrayList<C12879bl> arrayList = null;
        if (context != null && crashDetailBean != null && c12786aa != null) {
            C12882bo c12882bo = new C12882bo();
            c12882bo.f36760a = m15758e(crashDetailBean);
            c12882bo.f36761b = crashDetailBean.f36358r;
            c12882bo.f36762c = crashDetailBean.f36354n;
            c12882bo.f36763d = crashDetailBean.f36355o;
            c12882bo.f36764e = crashDetailBean.f36356p;
            c12882bo.f36766g = crashDetailBean.f36357q;
            c12882bo.f36767h = crashDetailBean.f36366z;
            c12882bo.f36768i = crashDetailBean.f36343c;
            c12882bo.f36769j = null;
            c12882bo.f36771l = crashDetailBean.f36353m;
            c12882bo.f36772m = crashDetailBean.f36345e;
            c12882bo.f36765f = crashDetailBean.f36315B;
            c12882bo.f36773n = null;
            Map<String, PlugInBean> map = crashDetailBean.f36348h;
            if (map != null && !map.isEmpty()) {
                arrayList = new ArrayList<>(crashDetailBean.f36348h.size());
                for (Map.Entry<String, PlugInBean> entry : crashDetailBean.f36348h.entrySet()) {
                    C12879bl c12879bl = new C12879bl();
                    c12879bl.f36740a = entry.getValue().f36288a;
                    c12879bl.f36742c = entry.getValue().f36290c;
                    c12879bl.f36744e = entry.getValue().f36289b;
                    arrayList.add(c12879bl);
                }
            }
            c12882bo.f36775p = arrayList;
            C12820al.m15874c("libInfo %s", c12882bo.f36774o);
            ArrayList<C12881bn> arrayList2 = new ArrayList<>(20);
            m15785a(arrayList2, crashDetailBean);
            m15783a(arrayList2, crashDetailBean.f36363w);
            m15766b(arrayList2, crashDetailBean.f36364x);
            m15762c(arrayList2, crashDetailBean.f36339Z);
            m15782a(arrayList2, crashDetailBean.f36341aa, context);
            m15780a(arrayList2, crashDetailBean.f36365y);
            m15784a(arrayList2, crashDetailBean, context);
            m15767b(arrayList2, crashDetailBean, context);
            m15781a(arrayList2, c12786aa.f36410L);
            m15765b(arrayList2, crashDetailBean.f36338Y);
            c12882bo.f36776q = arrayList2;
            if (crashDetailBean.f36350j) {
                c12882bo.f36770k = crashDetailBean.f36360t;
            }
            c12882bo.f36777r = m15793a(crashDetailBean, c12786aa);
            c12882bo.f36778s = new HashMap();
            Map<String, String> map2 = crashDetailBean.f36332S;
            if (map2 != null && map2.size() > 0) {
                c12882bo.f36778s.putAll(crashDetailBean.f36332S);
                C12820al.m15878a("setted message size %d", Integer.valueOf(c12882bo.f36778s.size()));
            }
            Map<String, String> map3 = c12882bo.f36778s;
            C12820al.m15874c("pss:" + crashDetailBean.f36322I + " vss:" + crashDetailBean.f36323J + " javaHeap:" + crashDetailBean.f36324K, new Object[0]);
            StringBuilder sb = new StringBuilder();
            sb.append(crashDetailBean.f36322I);
            map3.put("SDK_UPLOAD_U1", sb.toString());
            StringBuilder sb2 = new StringBuilder();
            sb2.append(crashDetailBean.f36323J);
            map3.put("SDK_UPLOAD_U2", sb2.toString());
            StringBuilder sb3 = new StringBuilder();
            sb3.append(crashDetailBean.f36324K);
            map3.put("SDK_UPLOAD_U3", sb3.toString());
            Object[] objArr = new Object[12];
            objArr[0] = crashDetailBean.f36354n;
            objArr[1] = crashDetailBean.f36343c;
            objArr[2] = c12786aa.m16000d();
            objArr[3] = Long.valueOf((crashDetailBean.f36358r - crashDetailBean.f36330Q) / 1000);
            objArr[4] = Boolean.valueOf(crashDetailBean.f36351k);
            objArr[5] = Boolean.valueOf(crashDetailBean.f36331R);
            objArr[6] = Boolean.valueOf(crashDetailBean.f36350j);
            objArr[7] = Boolean.valueOf(crashDetailBean.f36342b == 1);
            objArr[8] = Integer.valueOf(crashDetailBean.f36360t);
            objArr[9] = crashDetailBean.f36359s;
            objArr[10] = Boolean.valueOf(crashDetailBean.f36344d);
            objArr[11] = Integer.valueOf(c12882bo.f36777r.size());
            C12820al.m15874c("%s rid:%s sess:%s ls:%ds isR:%b isF:%b isM:%b isN:%b mc:%d ,%s ,isUp:%b ,vm:%d", objArr);
            return c12882bo;
        }
        C12820al.m15873d("enExp args == null", new Object[0]);
        return null;
    }

    /* renamed from: a */
    private static C12883bp m15796a(Context context, List<CrashDetailBean> list, C12786aa c12786aa) {
        if (context != null && list != null && list.size() != 0 && c12786aa != null) {
            C12883bp c12883bp = new C12883bp();
            c12883bp.f36782a = new ArrayList<>();
            for (CrashDetailBean crashDetailBean : list) {
                c12883bp.f36782a.add(m15797a(context, crashDetailBean, c12786aa));
            }
            return c12883bp;
        }
        C12820al.m15873d("enEXPPkg args == null!", new Object[0]);
        return null;
    }

    /* renamed from: a */
    private static C12881bn m15787a(String str, Context context, String str2) {
        FileInputStream fileInputStream;
        if (str2 != null && context != null) {
            C12820al.m15874c("zip %s", str2);
            File file = new File(str2);
            File file2 = new File(context.getCacheDir(), str);
            if (!C12828ap.m15837a(file, file2)) {
                C12820al.m15873d("zip fail!", new Object[0]);
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
                C12820al.m15874c("read bytes :%d", Integer.valueOf(byteArray.length));
                C12881bn c12881bn = new C12881bn((byte) 2, file2.getName(), byteArray);
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    if (!C12820al.m15877a(e)) {
                        e.printStackTrace();
                    }
                }
                if (file2.exists()) {
                    C12820al.m15874c("del tmp", new Object[0]);
                    file2.delete();
                }
                return c12881bn;
            } catch (Throwable th2) {
                th = th2;
                try {
                    if (!C12820al.m15877a(th)) {
                        th.printStackTrace();
                    }
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e2) {
                            if (!C12820al.m15877a(e2)) {
                                e2.printStackTrace();
                            }
                        }
                    }
                    if (file2.exists()) {
                        C12820al.m15874c("del tmp", new Object[0]);
                        file2.delete();
                    }
                    return null;
                } catch (Throwable th3) {
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e3) {
                            if (!C12820al.m15877a(e3)) {
                                e3.printStackTrace();
                            }
                        }
                    }
                    if (file2.exists()) {
                        C12820al.m15874c("del tmp", new Object[0]);
                        file2.delete();
                    }
                    throw th3;
                }
            }
        }
        C12820al.m15873d("rqdp{  createZipAttachment sourcePath == null || context == null ,pls check}", new Object[0]);
        return null;
    }

    /* renamed from: a */
    public static void m15786a(String str, String str2, String str3, String str4, String str5, CrashDetailBean crashDetailBean) {
        String str6;
        C12786aa m16005b = C12786aa.m16005b();
        if (m16005b == null) {
            return;
        }
        C12820al.m15872e("#++++++++++Record By Bugly++++++++++#", new Object[0]);
        C12820al.m15872e("# You can use Bugly(http:\\\\bugly.qq.com) to get more Crash Detail!", new Object[0]);
        C12820al.m15872e("# PKG NAME: %s", m16005b.f36450c);
        C12820al.m15872e("# APP VER: %s", m16005b.f36462o);
        C12820al.m15872e("# SDK VER: %s", m16005b.f36455h);
        C12820al.m15872e("# LAUNCH TIME: %s", C12828ap.m15827a(new Date(C12786aa.m16005b().f36424a)));
        C12820al.m15872e("# CRASH TYPE: %s", str);
        C12820al.m15872e("# CRASH TIME: %s", str2);
        C12820al.m15872e("# CRASH PROCESS: %s", str3);
        C12820al.m15872e("# CRASH FOREGROUND: %s", Boolean.valueOf(m16005b.m16011a()));
        C12820al.m15872e("# CRASH THREAD: %s", str4);
        if (crashDetailBean != null) {
            C12820al.m15872e("# REPORT ID: %s", crashDetailBean.f36343c);
            Object[] objArr = new Object[2];
            objArr[0] = m16005b.m15992h();
            objArr[1] = m16005b.m15982r().booleanValue() ? "ROOTED" : "UNROOT";
            C12820al.m15872e("# CRASH DEVICE: %s %s", objArr);
            C12820al.m15872e("# RUNTIME AVAIL RAM:%d ROM:%d SD:%d", Long.valueOf(crashDetailBean.f36316C), Long.valueOf(crashDetailBean.f36317D), Long.valueOf(crashDetailBean.f36318E));
            C12820al.m15872e("# RUNTIME TOTAL RAM:%d ROM:%d SD:%d", Long.valueOf(crashDetailBean.f36319F), Long.valueOf(crashDetailBean.f36320G), Long.valueOf(crashDetailBean.f36321H));
            if (!C12828ap.m15817b(crashDetailBean.f36328O)) {
                C12820al.m15872e("# EXCEPTION FIRED BY %s %s", crashDetailBean.f36328O, crashDetailBean.f36327N);
            } else if (crashDetailBean.f36342b == 3) {
                Object[] objArr2 = new Object[1];
                if (crashDetailBean.f36333T == null) {
                    str6 = "null";
                } else {
                    str6 = crashDetailBean.f36333T.get("BUGLY_CR_01");
                }
                objArr2[0] = str6;
                C12820al.m15872e("# EXCEPTION ANR MESSAGE:\n %s", objArr2);
            }
        }
        if (!C12828ap.m15817b(str5)) {
            C12820al.m15872e("# CRASH STACK: ", new Object[0]);
            C12820al.m15872e(str5, new Object[0]);
        }
        C12820al.m15872e("#++++++++++++++++++++++++++++++++++++++++++#", new Object[0]);
    }

    /* renamed from: a */
    private static void m15790a(CrashDetailBean crashDetailBean, Map<String, String> map) {
        String value;
        if (map != null && !map.isEmpty()) {
            crashDetailBean.f36332S = new LinkedHashMap(map.size());
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (!C12828ap.m15817b(entry.getKey())) {
                    String key = entry.getKey();
                    if (key.length() > 100) {
                        key = key.substring(0, 100);
                        C12820al.m15873d("setted key length is over limit %d substring to %s", 100, key);
                    }
                    if (!C12828ap.m15817b(entry.getValue()) && entry.getValue().length() > 100000) {
                        value = entry.getValue().substring(entry.getValue().length() - BUGLY.C12768a.MAX_USERDATA_VALUE_LENGTH);
                        C12820al.m15873d("setted %s value length is over limit %d substring", key, Integer.valueOf((int) BUGLY.C12768a.MAX_USERDATA_VALUE_LENGTH));
                    } else {
                        value = entry.getValue();
                    }
                    crashDetailBean.f36332S.put(key, value);
                    C12820al.m15878a("add setted key %s value size:%d", key, Integer.valueOf(value.length()));
                }
            }
            return;
        }
        C12820al.m15873d("extra map is empty. CrashBean won't have userDatas.", new Object[0]);
    }

    /* renamed from: a */
    private static void m15785a(ArrayList<C12881bn> arrayList, CrashDetailBean crashDetailBean) {
        String str;
        if (crashDetailBean.f36350j && (str = crashDetailBean.f36359s) != null && str.length() > 0) {
            try {
                arrayList.add(new C12881bn((byte) 1, "alltimes.txt", crashDetailBean.f36359s.getBytes("utf-8")));
            } catch (Exception e) {
                e.printStackTrace();
                C12820al.m15877a(e);
            }
        }
    }

    /* renamed from: a */
    private static void m15783a(ArrayList<C12881bn> arrayList, String str) {
        if (str != null) {
            try {
                arrayList.add(new C12881bn((byte) 1, "log.txt", str.getBytes("utf-8")));
            } catch (Exception e) {
                e.printStackTrace();
                C12820al.m15877a(e);
            }
        }
    }

    /* renamed from: a */
    private static void m15782a(ArrayList<C12881bn> arrayList, String str, Context context) {
        if (str != null) {
            try {
                C12881bn m15787a = m15787a("backupRecord.zip", context, str);
                if (m15787a != null) {
                    C12820al.m15874c("attach backup record", new Object[0]);
                    arrayList.add(m15787a);
                }
            } catch (Exception e) {
                C12820al.m15877a(e);
            }
        }
    }

    /* renamed from: a */
    private static void m15780a(ArrayList<C12881bn> arrayList, byte[] bArr) {
        if (bArr == null || bArr.length <= 0) {
            return;
        }
        try {
            C12881bn c12881bn = new C12881bn((byte) 2, "buglylog.zip", bArr);
            C12820al.m15874c("attach user log", new Object[0]);
            arrayList.add(c12881bn);
        } catch (Exception e) {
            C12820al.m15877a(e);
        }
    }

    /* renamed from: a */
    private static void m15784a(ArrayList<C12881bn> arrayList, CrashDetailBean crashDetailBean, Context context) {
        C12881bn m15787a;
        if (crashDetailBean.f36342b != 3) {
            return;
        }
        C12820al.m15874c("crashBean.anrMessages:%s", crashDetailBean.f36333T);
        try {
            Map<String, String> map = crashDetailBean.f36333T;
            if (map != null && map.containsKey("BUGLY_CR_01")) {
                if (!TextUtils.isEmpty(crashDetailBean.f36333T.get("BUGLY_CR_01"))) {
                    arrayList.add(new C12881bn((byte) 1, "anrMessage.txt", crashDetailBean.f36333T.get("BUGLY_CR_01").getBytes("utf-8")));
                    C12820al.m15874c("attach anr message", new Object[0]);
                }
                crashDetailBean.f36333T.remove("BUGLY_CR_01");
            }
            String str = crashDetailBean.f36362v;
            if (str == null || (m15787a = m15787a("trace.zip", context, str)) == null) {
                return;
            }
            C12820al.m15874c("attach traces", new Object[0]);
            arrayList.add(m15787a);
        } catch (Exception e) {
            e.printStackTrace();
            C12820al.m15877a(e);
        }
    }

    /* renamed from: a */
    private static void m15781a(ArrayList<C12881bn> arrayList, List<String> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (String str : list) {
            sb.append(str);
        }
        try {
            arrayList.add(new C12881bn((byte) 1, "martianlog.txt", sb.toString().getBytes("utf-8")));
            C12820al.m15874c("attach pageTracingList", new Object[0]);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    private static Map<String, String> m15793a(CrashDetailBean crashDetailBean, C12786aa c12786aa) {
        HashMap hashMap = new HashMap(30);
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(crashDetailBean.f36316C);
            hashMap.put("A9", sb.toString());
            StringBuilder sb2 = new StringBuilder();
            sb2.append(crashDetailBean.f36317D);
            hashMap.put("A11", sb2.toString());
            StringBuilder sb3 = new StringBuilder();
            sb3.append(crashDetailBean.f36318E);
            hashMap.put("A10", sb3.toString());
            hashMap.put("A23", crashDetailBean.f36346f);
            StringBuilder sb4 = new StringBuilder();
            c12786aa.getClass();
            hashMap.put("A7", sb4.toString());
            hashMap.put("A6", C12786aa.m15986n());
            hashMap.put("A5", c12786aa.m15987m());
            hashMap.put("A22", c12786aa.m15994g());
            StringBuilder sb5 = new StringBuilder();
            sb5.append(crashDetailBean.f36320G);
            hashMap.put("A2", sb5.toString());
            StringBuilder sb6 = new StringBuilder();
            sb6.append(crashDetailBean.f36319F);
            hashMap.put("A1", sb6.toString());
            hashMap.put("A24", c12786aa.f36458k);
            StringBuilder sb7 = new StringBuilder();
            sb7.append(crashDetailBean.f36321H);
            hashMap.put("A17", sb7.toString());
            hashMap.put("A25", c12786aa.m15994g());
            hashMap.put("A15", c12786aa.m15983q());
            StringBuilder sb8 = new StringBuilder();
            sb8.append(c12786aa.m15982r());
            hashMap.put("A13", sb8.toString());
            hashMap.put("A34", crashDetailBean.f36314A);
            if (c12786aa.f36405G != null) {
                hashMap.put("productIdentify", c12786aa.f36405G);
            }
            hashMap.put("A26", URLEncoder.encode(crashDetailBean.f36325L, "utf-8"));
            boolean z = true;
            if (crashDetailBean.f36342b == 1) {
                hashMap.put("A27", crashDetailBean.f36328O);
                hashMap.put("A28", crashDetailBean.f36327N);
                StringBuilder sb9 = new StringBuilder();
                sb9.append(crashDetailBean.f36351k);
                hashMap.put("A29", sb9.toString());
            }
            hashMap.put("A30", crashDetailBean.f36329P);
            StringBuilder sb10 = new StringBuilder();
            sb10.append(crashDetailBean.f36330Q);
            hashMap.put("A18", sb10.toString());
            StringBuilder sb11 = new StringBuilder();
            if (crashDetailBean.f36331R) {
                z = false;
            }
            sb11.append(z);
            hashMap.put("A36", sb11.toString());
            StringBuilder sb12 = new StringBuilder();
            sb12.append(c12786aa.f36473z);
            hashMap.put("F02", sb12.toString());
            StringBuilder sb13 = new StringBuilder();
            sb13.append(c12786aa.f36399A);
            hashMap.put("F03", sb13.toString());
            hashMap.put("F04", c12786aa.m16000d());
            StringBuilder sb14 = new StringBuilder();
            sb14.append(c12786aa.f36400B);
            hashMap.put("F05", sb14.toString());
            hashMap.put("F06", c12786aa.f36472y);
            hashMap.put("F08", c12786aa.f36403E);
            hashMap.put("F09", c12786aa.f36404F);
            StringBuilder sb15 = new StringBuilder();
            sb15.append(c12786aa.f36401C);
            hashMap.put("F10", sb15.toString());
            m15775a(hashMap, crashDetailBean);
        } catch (Exception e) {
            e.printStackTrace();
            C12820al.m15877a(e);
        }
        return hashMap;
    }

    /* renamed from: a */
    private static void m15775a(Map<String, String> map, CrashDetailBean crashDetailBean) {
        if (crashDetailBean.f36334U >= 0) {
            StringBuilder sb = new StringBuilder();
            sb.append(crashDetailBean.f36334U);
            map.put("C01", sb.toString());
        }
        if (crashDetailBean.f36335V >= 0) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(crashDetailBean.f36335V);
            map.put("C02", sb2.toString());
        }
        Map<String, String> map2 = crashDetailBean.f36336W;
        if (map2 != null && map2.size() > 0) {
            for (Map.Entry<String, String> entry : crashDetailBean.f36336W.entrySet()) {
                map.put("C03_" + entry.getKey(), entry.getValue());
            }
        }
        Map<String, String> map3 = crashDetailBean.f36337X;
        if (map3 == null || map3.size() <= 0) {
            return;
        }
        for (Map.Entry<String, String> entry2 : crashDetailBean.f36337X.entrySet()) {
            map.put("C04_" + entry2.getKey(), entry2.getValue());
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m15776a(List list, boolean z, long j, String str, String str2) {
        if (list == null || list.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            CrashDetailBean crashDetailBean = (CrashDetailBean) it.next();
            String str3 = f36598l.get(Integer.valueOf(crashDetailBean.f36342b));
            if (!TextUtils.isEmpty(str3)) {
                arrayList.add(new C12808ag.C12812c(crashDetailBean.f36343c, str3, crashDetailBean.f36358r, z, j, str, str2));
            }
        }
        C12808ag.C12810a.m15914a().m15920a(arrayList);
    }
}

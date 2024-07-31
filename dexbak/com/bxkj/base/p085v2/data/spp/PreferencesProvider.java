package com.bxkj.base.p085v2.data.spp;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.text.TextUtils;

/* renamed from: com.bxkj.base.v2.data.spp.PreferencesProvider */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public abstract class PreferencesProvider extends ContentProvider {

    /* renamed from: i */
    public static String f15200i = "SPCOLUMNNAME";

    /* renamed from: j */
    public static String f15201j = "authorities_key";

    /* renamed from: k */
    public static String f15202k = "authorities_spname";

    /* renamed from: l */
    public static final int f15203l = 100;

    /* renamed from: m */
    public static final int f15204m = 101;

    /* renamed from: n */
    public static final int f15205n = 102;

    /* renamed from: o */
    public static final int f15206o = 104;

    /* renamed from: p */
    public static final int f15207p = 105;

    /* renamed from: q */
    public static final int f15208q = 106;

    /* renamed from: r */
    public static final int f15209r = 107;

    /* renamed from: a */
    private UriMatcher f15210a;

    /* renamed from: b */
    private String f15211b = "string/*/*/";

    /* renamed from: c */
    private String f15212c = "integer/*/*/";

    /* renamed from: d */
    private String f15213d = "long/*/*/";

    /* renamed from: e */
    private String f15214e = "float/*/*/";

    /* renamed from: f */
    private String f15215f = "boolean/*/*/";

    /* renamed from: g */
    private String f15216g = "delete/*/*/";

    /* renamed from: h */
    private String f15217h = "puts";

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.bxkj.base.v2.data.spp.PreferencesProvider$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C3989b {

        /* renamed from: a */
        private String f15218a;

        /* renamed from: b */
        private String f15219b;

        /* renamed from: c */
        private Object f15220c;

        private C3989b() {
        }

        /* renamed from: a */
        public Object m43589a() {
            return this.f15220c;
        }

        /* renamed from: b */
        public String m43588b() {
            return this.f15219b;
        }

        /* renamed from: c */
        public String m43587c() {
            return this.f15218a;
        }

        /* renamed from: d */
        public void m43586d(Object obj) {
            this.f15220c = obj;
        }

        /* renamed from: e */
        public void m43585e(String str) {
            this.f15219b = str;
        }

        /* renamed from: f */
        public void m43584f(String str) {
            this.f15218a = str;
        }
    }

    /* renamed from: a */
    private Cursor m43591a(Context context, C3989b c3989b, int i) {
        Object m43555k;
        Object m43589a = c3989b.m43589a();
        switch (i) {
            case 100:
                if (m43589a == null) {
                    m43555k = PreferencesUtils.m43556j(context, c3989b.m43587c(), c3989b.m43588b());
                    break;
                } else {
                    m43555k = PreferencesUtils.m43555k(context, c3989b.m43587c(), c3989b.m43588b(), String.valueOf(m43589a));
                    break;
                }
            case 101:
                if (m43589a == null) {
                    m43555k = Integer.valueOf(PreferencesUtils.m43560f(context, c3989b.m43587c(), c3989b.m43588b()));
                    break;
                } else {
                    if (!TextUtils.isDigitsOnly(m43589a + "")) {
                        m43589a = -1;
                    }
                    m43555k = Integer.valueOf(PreferencesUtils.m43559g(context, c3989b.m43587c(), c3989b.m43588b(), Integer.parseInt(m43589a + "")));
                    break;
                }
            case 102:
                if (m43589a == null) {
                    m43555k = Long.valueOf(PreferencesUtils.m43558h(context, c3989b.m43587c(), c3989b.m43588b()));
                    break;
                } else {
                    if (!TextUtils.isDigitsOnly(m43589a + "")) {
                        m43589a = -1;
                    }
                    m43555k = Long.valueOf(PreferencesUtils.m43557i(context, c3989b.m43587c(), c3989b.m43588b(), Long.parseLong(m43589a + "")));
                    break;
                }
            case 103:
            default:
                m43555k = null;
                break;
            case 104:
                if (m43589a == null) {
                    m43555k = Float.valueOf(PreferencesUtils.m43562d(context, c3989b.m43587c(), c3989b.m43588b()));
                    break;
                } else {
                    m43555k = Float.valueOf(PreferencesUtils.m43561e(context, c3989b.m43587c(), c3989b.m43588b(), Float.parseFloat(m43589a + "")));
                    break;
                }
            case 105:
                if (m43589a == null) {
                    m43555k = PreferencesUtils.m43565a(context, c3989b.m43587c(), c3989b.m43588b()) + "";
                    break;
                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append(PreferencesUtils.m43564b(context, c3989b.m43587c(), c3989b.m43588b(), Boolean.valueOf(m43589a + "").booleanValue()));
                    sb.append("");
                    m43555k = sb.toString();
                    break;
                }
        }
        if (m43555k == null) {
            return null;
        }
        MatrixCursor matrixCursor = new MatrixCursor(new String[]{f15200i});
        matrixCursor.addRow(new Object[]{m43555k});
        return matrixCursor;
    }

    /* renamed from: c */
    private C3989b m43590c(Uri uri) {
        try {
            C3989b c3989b = new C3989b();
            c3989b.m43584f(uri.getPathSegments().get(1));
            if (uri.getPathSegments().size() > 2) {
                c3989b.m43585e(uri.getPathSegments().get(2));
            }
            if (uri.getPathSegments().size() > 3) {
                c3989b.m43586d(uri.getPathSegments().get(3));
            }
            return c3989b;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: b */
    public abstract String mo39364b();

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        C3989b m43590c = m43590c(uri);
        if (m43590c == null) {
            return -1;
        }
        int match = this.f15210a.match(uri);
        if (match == 100 || match == 101 || match == 102 || match == 104 || match == 105) {
            delete(getContext(), m43590c);
            return 0;
        }
        return 0;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        return null;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        C3989b m43590c = m43590c(uri);
        if (m43590c == null) {
            return null;
        }
        int match = this.f15210a.match(uri);
        if (match == 100 || match == 101 || match == 102 || match == 104 || match == 105 || match == 107) {
            insert(getContext(), contentValues, m43590c);
        }
        return uri;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        String mo39364b = mo39364b();
        PreferencesUtils.m43550p(getContext(), f15202k, f15201j, mo39364b);
        UriMatcher uriMatcher = new UriMatcher(-1);
        this.f15210a = uriMatcher;
        uriMatcher.addURI(mo39364b, this.f15211b, 100);
        UriMatcher uriMatcher2 = this.f15210a;
        uriMatcher2.addURI(mo39364b, this.f15211b + "*/", 100);
        this.f15210a.addURI(mo39364b, this.f15212c, 101);
        UriMatcher uriMatcher3 = this.f15210a;
        uriMatcher3.addURI(mo39364b, this.f15212c + "*/", 101);
        this.f15210a.addURI(mo39364b, this.f15213d, 102);
        UriMatcher uriMatcher4 = this.f15210a;
        uriMatcher4.addURI(mo39364b, this.f15213d + "*/", 102);
        this.f15210a.addURI(mo39364b, this.f15214e, 104);
        UriMatcher uriMatcher5 = this.f15210a;
        uriMatcher5.addURI(mo39364b, this.f15214e + "*/", 104);
        this.f15210a.addURI(mo39364b, this.f15215f, 105);
        UriMatcher uriMatcher6 = this.f15210a;
        uriMatcher6.addURI(mo39364b, this.f15215f + "*/", 105);
        this.f15210a.addURI(mo39364b, this.f15216g, 106);
        this.f15210a.addURI(mo39364b, this.f15217h, 107);
        return false;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        C3989b m43590c = m43590c(uri);
        if (m43590c == null) {
            return null;
        }
        return m43591a(getContext(), m43590c, this.f15210a.match(uri));
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        C3989b m43590c = m43590c(uri);
        if (m43590c == null) {
            return -1;
        }
        int match = this.f15210a.match(uri);
        if (match == 100 || match == 101 || match == 102 || match == 104 || match == 105) {
            insert(getContext(), contentValues, m43590c);
            return 0;
        }
        return 0;
    }

    private void delete(Context context, C3989b c3989b) {
        SharedPreferences.Editor m43563c = PreferencesUtils.m43563c(context, c3989b.m43587c());
        m43563c.remove(c3989b.m43588b());
        m43563c.apply();
    }

    private void insert(Context context, ContentValues contentValues, C3989b c3989b) {
        SharedPreferences.Editor m43563c = PreferencesUtils.m43563c(context, c3989b.m43587c());
        for (String str : contentValues.keySet()) {
            Object obj = contentValues.get(str);
            if (obj instanceof Integer) {
                m43563c.putInt(str, Integer.parseInt(obj + ""));
            } else if (obj instanceof Long) {
                m43563c.putLong(str, Long.parseLong(obj + ""));
            } else if (obj instanceof Float) {
                m43563c.putFloat(str, Float.parseFloat(obj + ""));
            } else if (obj instanceof Boolean) {
                m43563c.putBoolean(str, Boolean.valueOf(obj + "").booleanValue());
            } else {
                StringBuilder sb = new StringBuilder();
                if (obj == null) {
                    obj = "";
                }
                sb.append(obj);
                sb.append("");
                m43563c.putString(str, sb.toString());
            }
        }
        m43563c.apply();
    }
}

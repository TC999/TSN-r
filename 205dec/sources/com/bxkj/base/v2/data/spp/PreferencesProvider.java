package com.bxkj.base.v2.data.spp;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.text.TextUtils;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public abstract class PreferencesProvider extends ContentProvider {

    /* renamed from: i  reason: collision with root package name */
    public static String f18697i = "SPCOLUMNNAME";

    /* renamed from: j  reason: collision with root package name */
    public static String f18698j = "authorities_key";

    /* renamed from: k  reason: collision with root package name */
    public static String f18699k = "authorities_spname";

    /* renamed from: l  reason: collision with root package name */
    public static final int f18700l = 100;

    /* renamed from: m  reason: collision with root package name */
    public static final int f18701m = 101;

    /* renamed from: n  reason: collision with root package name */
    public static final int f18702n = 102;

    /* renamed from: o  reason: collision with root package name */
    public static final int f18703o = 104;

    /* renamed from: p  reason: collision with root package name */
    public static final int f18704p = 105;

    /* renamed from: q  reason: collision with root package name */
    public static final int f18705q = 106;

    /* renamed from: r  reason: collision with root package name */
    public static final int f18706r = 107;

    /* renamed from: a  reason: collision with root package name */
    private UriMatcher f18707a;

    /* renamed from: b  reason: collision with root package name */
    private String f18708b = "string/*/*/";

    /* renamed from: c  reason: collision with root package name */
    private String f18709c = "integer/*/*/";

    /* renamed from: d  reason: collision with root package name */
    private String f18710d = "long/*/*/";

    /* renamed from: e  reason: collision with root package name */
    private String f18711e = "float/*/*/";

    /* renamed from: f  reason: collision with root package name */
    private String f18712f = "boolean/*/*/";

    /* renamed from: g  reason: collision with root package name */
    private String f18713g = "delete/*/*/";

    /* renamed from: h  reason: collision with root package name */
    private String f18714h = "puts";

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class b {

        /* renamed from: a  reason: collision with root package name */
        private String f18715a;

        /* renamed from: b  reason: collision with root package name */
        private String f18716b;

        /* renamed from: c  reason: collision with root package name */
        private Object f18717c;

        private b() {
        }

        public Object a() {
            return this.f18717c;
        }

        public String b() {
            return this.f18716b;
        }

        public String c() {
            return this.f18715a;
        }

        public void d(Object obj) {
            this.f18717c = obj;
        }

        public void e(String str) {
            this.f18716b = str;
        }

        public void f(String str) {
            this.f18715a = str;
        }
    }

    private Cursor a(Context context, b bVar, int i4) {
        Object k4;
        Object a4 = bVar.a();
        switch (i4) {
            case 100:
                if (a4 == null) {
                    k4 = com.bxkj.base.v2.data.spp.b.j(context, bVar.c(), bVar.b());
                    break;
                } else {
                    k4 = com.bxkj.base.v2.data.spp.b.k(context, bVar.c(), bVar.b(), String.valueOf(a4));
                    break;
                }
            case 101:
                if (a4 == null) {
                    k4 = Integer.valueOf(com.bxkj.base.v2.data.spp.b.f(context, bVar.c(), bVar.b()));
                    break;
                } else {
                    if (!TextUtils.isDigitsOnly(a4 + "")) {
                        a4 = -1;
                    }
                    k4 = Integer.valueOf(com.bxkj.base.v2.data.spp.b.g(context, bVar.c(), bVar.b(), Integer.parseInt(a4 + "")));
                    break;
                }
            case 102:
                if (a4 == null) {
                    k4 = Long.valueOf(com.bxkj.base.v2.data.spp.b.h(context, bVar.c(), bVar.b()));
                    break;
                } else {
                    if (!TextUtils.isDigitsOnly(a4 + "")) {
                        a4 = -1;
                    }
                    k4 = Long.valueOf(com.bxkj.base.v2.data.spp.b.i(context, bVar.c(), bVar.b(), Long.parseLong(a4 + "")));
                    break;
                }
            case 103:
            default:
                k4 = null;
                break;
            case 104:
                if (a4 == null) {
                    k4 = Float.valueOf(com.bxkj.base.v2.data.spp.b.d(context, bVar.c(), bVar.b()));
                    break;
                } else {
                    k4 = Float.valueOf(com.bxkj.base.v2.data.spp.b.e(context, bVar.c(), bVar.b(), Float.parseFloat(a4 + "")));
                    break;
                }
            case 105:
                if (a4 == null) {
                    k4 = com.bxkj.base.v2.data.spp.b.a(context, bVar.c(), bVar.b()) + "";
                    break;
                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append(com.bxkj.base.v2.data.spp.b.b(context, bVar.c(), bVar.b(), Boolean.valueOf(a4 + "").booleanValue()));
                    sb.append("");
                    k4 = sb.toString();
                    break;
                }
        }
        if (k4 == null) {
            return null;
        }
        MatrixCursor matrixCursor = new MatrixCursor(new String[]{f18697i});
        matrixCursor.addRow(new Object[]{k4});
        return matrixCursor;
    }

    private b c(Uri uri) {
        try {
            b bVar = new b();
            bVar.f(uri.getPathSegments().get(1));
            if (uri.getPathSegments().size() > 2) {
                bVar.e(uri.getPathSegments().get(2));
            }
            if (uri.getPathSegments().size() > 3) {
                bVar.d(uri.getPathSegments().get(3));
            }
            return bVar;
        } catch (Exception e4) {
            e4.printStackTrace();
            return null;
        }
    }

    public abstract String b();

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        b c4 = c(uri);
        if (c4 == null) {
            return -1;
        }
        int match = this.f18707a.match(uri);
        if (match == 100 || match == 101 || match == 102 || match == 104 || match == 105) {
            delete(getContext(), c4);
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
        b c4 = c(uri);
        if (c4 == null) {
            return null;
        }
        int match = this.f18707a.match(uri);
        if (match == 100 || match == 101 || match == 102 || match == 104 || match == 105 || match == 107) {
            insert(getContext(), contentValues, c4);
        }
        return uri;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        String b4 = b();
        com.bxkj.base.v2.data.spp.b.p(getContext(), f18699k, f18698j, b4);
        UriMatcher uriMatcher = new UriMatcher(-1);
        this.f18707a = uriMatcher;
        uriMatcher.addURI(b4, this.f18708b, 100);
        UriMatcher uriMatcher2 = this.f18707a;
        uriMatcher2.addURI(b4, this.f18708b + "*/", 100);
        this.f18707a.addURI(b4, this.f18709c, 101);
        UriMatcher uriMatcher3 = this.f18707a;
        uriMatcher3.addURI(b4, this.f18709c + "*/", 101);
        this.f18707a.addURI(b4, this.f18710d, 102);
        UriMatcher uriMatcher4 = this.f18707a;
        uriMatcher4.addURI(b4, this.f18710d + "*/", 102);
        this.f18707a.addURI(b4, this.f18711e, 104);
        UriMatcher uriMatcher5 = this.f18707a;
        uriMatcher5.addURI(b4, this.f18711e + "*/", 104);
        this.f18707a.addURI(b4, this.f18712f, 105);
        UriMatcher uriMatcher6 = this.f18707a;
        uriMatcher6.addURI(b4, this.f18712f + "*/", 105);
        this.f18707a.addURI(b4, this.f18713g, 106);
        this.f18707a.addURI(b4, this.f18714h, 107);
        return false;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        b c4 = c(uri);
        if (c4 == null) {
            return null;
        }
        return a(getContext(), c4, this.f18707a.match(uri));
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        b c4 = c(uri);
        if (c4 == null) {
            return -1;
        }
        int match = this.f18707a.match(uri);
        if (match == 100 || match == 101 || match == 102 || match == 104 || match == 105) {
            insert(getContext(), contentValues, c4);
            return 0;
        }
        return 0;
    }

    private void delete(Context context, b bVar) {
        SharedPreferences.Editor c4 = com.bxkj.base.v2.data.spp.b.c(context, bVar.c());
        c4.remove(bVar.b());
        c4.apply();
    }

    private void insert(Context context, ContentValues contentValues, b bVar) {
        SharedPreferences.Editor c4 = com.bxkj.base.v2.data.spp.b.c(context, bVar.c());
        for (String str : contentValues.keySet()) {
            Object obj = contentValues.get(str);
            if (obj instanceof Integer) {
                c4.putInt(str, Integer.parseInt(obj + ""));
            } else if (obj instanceof Long) {
                c4.putLong(str, Long.parseLong(obj + ""));
            } else if (obj instanceof Float) {
                c4.putFloat(str, Float.parseFloat(obj + ""));
            } else if (obj instanceof Boolean) {
                c4.putBoolean(str, Boolean.valueOf(obj + "").booleanValue());
            } else {
                StringBuilder sb = new StringBuilder();
                if (obj == null) {
                    obj = "";
                }
                sb.append(obj);
                sb.append("");
                c4.putString(str, sb.toString());
            }
        }
        c4.apply();
    }
}

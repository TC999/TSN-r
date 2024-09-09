package cn.bluemobi.dylan.sqlitelibrary;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import android.util.Log;
import com.acse.ottn.f3;
import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* compiled from: SQLiteDbUtil.java */
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class c {

    /* renamed from: g  reason: collision with root package name */
    private static volatile c f1968g;

    /* renamed from: a  reason: collision with root package name */
    String[] f1969a = {"java.lang.Integer", "java.lang.Double", "java.lang.Float", "java.lang.Long", "java.lang.Short", "java.lang.Byte", "java.lang.Boolean", "java.lang.Character", "java.lang.String", "java.util.Date", "int", "double", "long", "short", "byte", "boolean", "char", "float"};

    /* renamed from: b  reason: collision with root package name */
    private final String f1970b = "SQLiteDbUtil";

    /* renamed from: c  reason: collision with root package name */
    private SQLiteDatabase f1971c;

    /* renamed from: d  reason: collision with root package name */
    private Context f1972d;

    /* renamed from: e  reason: collision with root package name */
    private String f1973e;

    /* renamed from: f  reason: collision with root package name */
    private String f1974f;

    private c() {
    }

    private <T> ContentValues g(T t3) {
        List<Map<String, Object>> a4 = b.a(t3);
        ContentValues contentValues = new ContentValues();
        for (int i4 = 0; i4 < a4.size(); i4++) {
            Map<String, Object> map = a4.get(i4);
            String str = (String) map.get("name");
            Object obj = map.get("value");
            if (obj == null) {
                contentValues.putNull(str);
            } else if (obj instanceof byte[]) {
                contentValues.put(str, (byte[]) obj);
            } else {
                contentValues.put(str, String.valueOf(obj));
            }
        }
        contentValues.remove("id");
        return contentValues;
    }

    private String getType(Class cls) {
        if (cls.equals(String.class)) {
            return "TEXT";
        }
        if (cls.equals(Integer.class) || cls.getName().equals("int")) {
            return "Integer";
        }
        if (cls.equals(Character.class) || cls.getName().equals("char")) {
            return "Character";
        }
        if (cls.equals(Boolean.class) || cls.getName().equals("boolean")) {
            return "boolean";
        }
        if (cls.equals(Float.class) || cls.getName().equals("float")) {
            return "Float";
        }
        if (cls.equals(Double.class) || cls.getName().equals("double")) {
            return "Double";
        }
        if (cls.equals(Byte.class) || cls.getName().equals("byte")) {
            return "Byte";
        }
        if (cls.equals(Short.class) || cls.getName().equals("short")) {
            return "Short";
        }
        if (cls.equals(Long.class) || cls.getName().equals("long")) {
            return "Long";
        }
        if (cls.equals(Date.class) || cls.equals(java.sql.Date.class)) {
            return "Date";
        }
        if (cls.isArray()) {
            String name = cls.getComponentType().getName();
            return ("byte".equals(name) || "Byte".equals(name)) ? "Blob" : "TEXT";
        }
        return "TEXT";
    }

    public static c h() {
        if (f1968g == null) {
            synchronized (c.class) {
                if (f1968g == null) {
                    f1968g = new c();
                }
            }
        }
        return f1968g;
    }

    private boolean j(String str) {
        List<Map<String, Object>> p3 = p("SELECT count(*) FROM sqlite_master WHERE type='table' AND name='" + str + "'");
        return p3 != null && p3.size() > 0 && Integer.parseInt(p3.get(0).get("count(*)").toString()) > 0;
    }

    private <T> T k(Class<T> cls, Cursor cursor) {
        Object valueOf;
        try {
            Constructor<T> constructor = cls.getConstructor(new Class[0]);
            constructor.setAccessible(true);
            T newInstance = constructor.newInstance(new Object[0]);
            Class<?>[] c4 = b.c(cls);
            String[] b4 = b.b(cls);
            for (int i4 = 0; i4 < c4.length; i4++) {
                String str = b4[i4];
                Class<?> cls2 = c4[i4];
                Method method = cls.getMethod(f3.f5659h + str.substring(0, 1).toUpperCase() + str.substring(1), cls2);
                if (cls2.equals(String.class)) {
                    valueOf = cursor.getString(cursor.getColumnIndex(str));
                } else {
                    if (!cls2.equals(Integer.class) && !cls2.getName().equals("int")) {
                        if (!cls2.equals(Character.class) && !cls2.getName().equals("char")) {
                            if (!cls2.equals(Boolean.class) && !cls2.getName().equals("boolean")) {
                                if (!cls2.equals(Float.class) && !cls2.getName().equals("float")) {
                                    if (!cls2.equals(Double.class) && !cls2.getName().equals("double")) {
                                        if (!cls2.equals(Byte.class) && !cls2.getName().equals("byte")) {
                                            if (!cls2.equals(Short.class) && !cls2.getName().equals("short")) {
                                                if (!cls2.equals(Long.class) && !cls2.getName().equals("long")) {
                                                    if (cls2.isArray()) {
                                                        valueOf = cursor.getBlob(cursor.getColumnIndex(str));
                                                    } else if (cls2.equals(Date.class)) {
                                                        if (!TextUtils.isEmpty(cursor.getString(cursor.getColumnIndex(str)))) {
                                                            valueOf = new Date(cursor.getString(cursor.getColumnIndex(str)));
                                                        }
                                                    } else if (cls2.equals(java.sql.Date.class)) {
                                                        valueOf = TextUtils.isEmpty(cursor.getString(cursor.getColumnIndex(str))) ? null : java.sql.Date.valueOf(cursor.getString(cursor.getColumnIndex(str)));
                                                    }
                                                }
                                                valueOf = Long.valueOf(cursor.getLong(cursor.getColumnIndex(str)));
                                            }
                                            valueOf = Short.valueOf(cursor.getShort(cursor.getColumnIndex(str)));
                                        }
                                        valueOf = Byte.valueOf(cursor.getString(cursor.getColumnIndex(str)));
                                    }
                                    valueOf = Double.valueOf(cursor.getDouble(cursor.getColumnIndex(str)));
                                }
                                valueOf = Float.valueOf(cursor.getFloat(cursor.getColumnIndex(str)));
                            }
                            valueOf = Boolean.valueOf("true".equalsIgnoreCase(cursor.getString(cursor.getColumnIndex(str))));
                        }
                        valueOf = Character.valueOf(cursor.getString(cursor.getColumnIndex(str)).charAt(0));
                    }
                    valueOf = Integer.valueOf(cursor.getInt(cursor.getColumnIndex(str)));
                }
                method.invoke(newInstance, valueOf);
            }
            return newInstance;
        } catch (IllegalAccessException e4) {
            e4.printStackTrace();
            return null;
        } catch (InstantiationException e5) {
            e5.printStackTrace();
            return null;
        } catch (NoSuchMethodException e6) {
            e6.printStackTrace();
            return null;
        } catch (InvocationTargetException e7) {
            e7.printStackTrace();
            return null;
        }
    }

    private void l() throws Exception {
        if (this.f1971c != null) {
            o(this.f1972d, this.f1973e, this.f1974f);
            return;
        }
        throw new Exception("\u672a\u521d\u59cb\u5316\u6570\u636e\u5e93");
    }

    public void a() {
        SQLiteDatabase sQLiteDatabase = this.f1971c;
        if (sQLiteDatabase == null || !sQLiteDatabase.isOpen()) {
            return;
        }
        this.f1971c.close();
    }

    public <T> void b(Class<T> cls) {
        String str;
        ArrayList arrayList;
        ArrayList arrayList2;
        String d4 = b.d(cls);
        ArrayList arrayList3 = new ArrayList(Arrays.asList(b.b(cls)));
        ArrayList arrayList4 = new ArrayList(Arrays.asList(b.c(cls)));
        int indexOf = arrayList3.indexOf("id");
        if (indexOf != -1) {
            arrayList3.remove(indexOf);
            arrayList4.remove(indexOf);
        }
        String str2 = ",";
        if (!j(d4)) {
            String str3 = ("CREATE TABLE IF NOT EXISTS " + d4 + "(") + "id  Integer PRIMARY KEY AUTOINCREMENT,";
            for (int i4 = 0; i4 < arrayList3.size(); i4++) {
                str3 = i4 != arrayList3.size() - 1 ? str3 + ((String) arrayList3.get(i4)) + " " + getType((Class) arrayList4.get(i4)) + "," : str3 + ((String) arrayList3.get(i4)) + " " + getType((Class) arrayList4.get(i4));
            }
            String str4 = str3 + ")";
            Log.d("SQLiteDbUtil", "\u521b\u5efa\u8868" + d4 + " sql=" + str4);
            f(str4);
            return;
        }
        List<Map<String, Object>> p3 = p("PRAGMA table_info([" + d4 + "])");
        StringBuilder sb = new StringBuilder();
        sb.append("\u8868\u4fe1\u606f");
        sb.append(p3);
        Log.d("SQLiteDbUtil", sb.toString());
        ArrayList arrayList5 = new ArrayList();
        ArrayList arrayList6 = new ArrayList();
        int i5 = 0;
        while (i5 < p3.size()) {
            String str5 = str2;
            String obj = p3.get(i5).get("name").toString();
            List<Map<String, Object>> list = p3;
            String obj2 = p3.get(i5).get("type").toString();
            arrayList5.add(obj);
            arrayList6.add(obj2);
            i5++;
            str2 = str5;
            p3 = list;
        }
        String str6 = str2;
        int indexOf2 = arrayList5.indexOf("id");
        if (indexOf2 != -1) {
            arrayList5.remove(indexOf2);
            arrayList6.remove(indexOf2);
        }
        int i6 = 0;
        boolean z3 = false;
        while (i6 < arrayList3.size()) {
            String str7 = (String) arrayList3.get(i6);
            String type = getType((Class) arrayList4.get(i6));
            if (!arrayList5.contains(str7)) {
                StringBuilder sb2 = new StringBuilder();
                arrayList2 = arrayList4;
                sb2.append("ALTER TABLE ");
                sb2.append(d4);
                sb2.append(" ADD COLUMN ");
                sb2.append(str7);
                sb2.append(" ");
                sb2.append(type);
                String sb3 = sb2.toString();
                f(sb3);
                Log.d("SQLiteDbUtil", "\u5347\u7ea7\u8868\u3010" + d4 + "\u3011\u65b0\u5b57\u6bb5" + str7 + ",sql=" + sb3);
            } else {
                arrayList2 = arrayList4;
                int indexOf3 = arrayList5.indexOf(str7);
                if (indexOf3 != -1) {
                    String str8 = (String) arrayList6.get(indexOf3);
                    if (!type.equals(str8)) {
                        Log.d("SQLiteDbUtil", "\u9700\u8981\u4fee\u6539\u8868\u7ed3\u6784newColumnType=" + type + "  oldColumnType=" + str8);
                        z3 = true;
                    }
                }
            }
            i6++;
            arrayList4 = arrayList2;
        }
        ArrayList arrayList7 = arrayList4;
        if (z3) {
            List<T> query = h().query(cls);
            h().e(d4);
            String str9 = ("CREATE TABLE IF NOT EXISTS " + d4 + "(") + "id  Integer PRIMARY KEY AUTOINCREMENT,";
            int i7 = 0;
            while (i7 < arrayList3.size()) {
                if (i7 != arrayList3.size() - 1) {
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append(str9);
                    sb4.append((String) arrayList3.get(i7));
                    sb4.append(" ");
                    arrayList = arrayList7;
                    sb4.append(getType((Class) arrayList.get(i7)));
                    str = str6;
                    sb4.append(str);
                    str9 = sb4.toString();
                } else {
                    str = str6;
                    arrayList = arrayList7;
                    str9 = str9 + ((String) arrayList3.get(i7)) + " " + getType((Class) arrayList.get(i7));
                }
                i7++;
                arrayList7 = arrayList;
                str6 = str;
            }
            String str10 = str9 + ")";
            Log.d("SQLiteDbUtil", "\u521b\u5efa\u8868" + d4 + " sql=" + str10);
            f(str10);
            h().insert((List) query);
        }
    }

    public <T> int c(Class<T> cls) {
        int i4 = 0;
        if (cls == null) {
            return 0;
        }
        String d4 = b.d(cls);
        try {
            try {
                l();
                i4 = this.f1971c.delete(d4, null, null);
            } catch (Exception e4) {
                e4.printStackTrace();
            }
            return i4;
        } finally {
            a();
        }
    }

    public <T> void d(Class<T> cls) {
        if (cls == null) {
            return;
        }
        String d4 = b.d(cls);
        f("DROP TABLE IF EXISTS " + d4);
    }

    public <T> int delete(Class<T> cls, int i4) {
        int i5 = 0;
        if (cls == null) {
            return 0;
        }
        String d4 = b.d(cls);
        try {
            try {
                l();
                i5 = this.f1971c.delete(d4, "id=?", new String[]{String.valueOf(i4)});
            } catch (Exception e4) {
                e4.printStackTrace();
            }
            return i5;
        } finally {
            a();
        }
    }

    public void e(String str) {
        f("DROP TABLE IF EXISTS " + str);
    }

    public void f(String str) {
        try {
            try {
                l();
                this.f1971c.execSQL(str);
            } catch (SQLException e4) {
                e4.printStackTrace();
            } catch (Exception e5) {
                e5.printStackTrace();
            }
        } finally {
            a();
        }
    }

    public SQLiteDatabase i() {
        return this.f1971c;
    }

    public <T> long insert(T t3) {
        if (t3 == null) {
            return -1L;
        }
        String d4 = b.d(t3.getClass());
        ContentValues g4 = g(t3);
        long j4 = 0;
        try {
            try {
                l();
                j4 = this.f1971c.insert(d4, null, g4);
            } catch (Exception e4) {
                e4.printStackTrace();
            }
            return j4;
        } finally {
            a();
        }
    }

    public void m(Context context) {
        o(context, null, null);
    }

    public void n(Context context, String str) {
        o(context, null, str);
    }

    public void o(Context context, String str, String str2) {
        this.f1972d = context;
        this.f1973e = str;
        this.f1974f = str2;
        if (TextUtils.isEmpty(str2)) {
            str2 = "mydb.db";
        }
        if (TextUtils.isEmpty(str)) {
            this.f1971c = context.openOrCreateDatabase(str2, 0, null);
            return;
        }
        File file = new File(str, str2);
        if (!file.getParentFile().exists()) {
            file.mkdirs();
        }
        this.f1971c = SQLiteDatabase.openOrCreateDatabase(file, (SQLiteDatabase.CursorFactory) null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x0063, code lost:
        if (r11 == null) goto L28;
     */
    /* JADX WARN: Removed duplicated region for block: B:36:0x006f  */
    @android.annotation.TargetApi(16)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.util.List<java.util.Map<java.lang.String, java.lang.Object>> p(java.lang.String r11) {
        /*
            r10 = this;
            r0 = 0
            r10.l()     // Catch: java.lang.Throwable -> L57 java.lang.Exception -> L5c
            android.database.sqlite.SQLiteDatabase r1 = r10.f1971c     // Catch: java.lang.Throwable -> L57 java.lang.Exception -> L5c
            android.database.Cursor r11 = r1.rawQuery(r11, r0, r0)     // Catch: java.lang.Throwable -> L57 java.lang.Exception -> L5c
            if (r11 != 0) goto L15
            if (r11 == 0) goto L11
            r11.close()
        L11:
            r10.a()
            return r0
        L15:
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch: java.lang.Exception -> L52 java.lang.Throwable -> L6c
            r1.<init>()     // Catch: java.lang.Exception -> L52 java.lang.Throwable -> L6c
        L1a:
            boolean r0 = r11.moveToNext()     // Catch: java.lang.Exception -> L50 java.lang.Throwable -> L6c
            if (r0 == 0) goto L65
            java.util.HashMap r0 = new java.util.HashMap     // Catch: java.lang.Exception -> L50 java.lang.Throwable -> L6c
            r0.<init>()     // Catch: java.lang.Exception -> L50 java.lang.Throwable -> L6c
            java.lang.String[] r2 = r11.getColumnNames()     // Catch: java.lang.Exception -> L50 java.lang.Throwable -> L6c
            int r3 = r2.length     // Catch: java.lang.Exception -> L50 java.lang.Throwable -> L6c
            r4 = 0
        L2b:
            if (r4 >= r3) goto L4c
            r5 = r2[r4]     // Catch: java.lang.Exception -> L50 java.lang.Throwable -> L6c
            int r6 = r11.getColumnIndex(r5)     // Catch: java.lang.Exception -> L50 java.lang.Throwable -> L6c
            int r7 = r11.getType(r6)     // Catch: java.lang.Exception -> L50 java.lang.Throwable -> L6c
            r8 = 4
            if (r7 != r8) goto L42
            byte[] r6 = r11.getBlob(r6)     // Catch: java.lang.Exception -> L50 java.lang.Throwable -> L6c
            r0.put(r5, r6)     // Catch: java.lang.Exception -> L50 java.lang.Throwable -> L6c
            goto L49
        L42:
            java.lang.String r6 = r11.getString(r6)     // Catch: java.lang.Exception -> L50 java.lang.Throwable -> L6c
            r0.put(r5, r6)     // Catch: java.lang.Exception -> L50 java.lang.Throwable -> L6c
        L49:
            int r4 = r4 + 1
            goto L2b
        L4c:
            r1.add(r0)     // Catch: java.lang.Exception -> L50 java.lang.Throwable -> L6c
            goto L1a
        L50:
            r0 = move-exception
            goto L60
        L52:
            r1 = move-exception
            r9 = r1
            r1 = r0
            r0 = r9
            goto L60
        L57:
            r11 = move-exception
            r9 = r0
            r0 = r11
            r11 = r9
            goto L6d
        L5c:
            r11 = move-exception
            r1 = r0
            r0 = r11
            r11 = r1
        L60:
            r0.printStackTrace()     // Catch: java.lang.Throwable -> L6c
            if (r11 == 0) goto L68
        L65:
            r11.close()
        L68:
            r10.a()
            return r1
        L6c:
            r0 = move-exception
        L6d:
            if (r11 == 0) goto L72
            r11.close()
        L72:
            r10.a()
            goto L77
        L76:
            throw r0
        L77:
            goto L76
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.bluemobi.dylan.sqlitelibrary.c.p(java.lang.String):java.util.List");
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x004a, code lost:
        if (r11 == null) goto L21;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0057  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public <T> T query(java.lang.Class<T> r10, int r11) {
        /*
            r9 = this;
            r0 = 0
            if (r10 != 0) goto L4
            return r0
        L4:
            java.lang.String r2 = cn.bluemobi.dylan.sqlitelibrary.b.d(r10)
            r9.l()     // Catch: java.lang.Throwable -> L43 java.lang.Exception -> L45
            android.database.sqlite.SQLiteDatabase r1 = r9.f1971c     // Catch: java.lang.Throwable -> L43 java.lang.Exception -> L45
            r3 = 0
            java.lang.String r4 = "id=?"
            r5 = 1
            java.lang.String[] r5 = new java.lang.String[r5]     // Catch: java.lang.Throwable -> L43 java.lang.Exception -> L45
            r6 = 0
            java.lang.String r11 = java.lang.String.valueOf(r11)     // Catch: java.lang.Throwable -> L43 java.lang.Exception -> L45
            r5[r6] = r11     // Catch: java.lang.Throwable -> L43 java.lang.Exception -> L45
            r6 = 0
            r7 = 0
            r8 = 0
            android.database.Cursor r11 = r1.query(r2, r3, r4, r5, r6, r7, r8)     // Catch: java.lang.Throwable -> L43 java.lang.Exception -> L45
            if (r11 != 0) goto L2c
            if (r11 == 0) goto L28
            r11.close()
        L28:
            r9.a()
            return r0
        L2c:
            boolean r1 = r11.moveToNext()     // Catch: java.lang.Exception -> L41 java.lang.Throwable -> L53
            if (r1 == 0) goto L3d
            java.lang.Object r10 = r9.k(r10, r11)     // Catch: java.lang.Exception -> L41 java.lang.Throwable -> L53
            r11.close()
            r9.a()
            return r10
        L3d:
            r11.close()     // Catch: java.lang.Exception -> L41 java.lang.Throwable -> L53
            goto L4c
        L41:
            r10 = move-exception
            goto L47
        L43:
            r10 = move-exception
            goto L55
        L45:
            r10 = move-exception
            r11 = r0
        L47:
            r10.printStackTrace()     // Catch: java.lang.Throwable -> L53
            if (r11 == 0) goto L4f
        L4c:
            r11.close()
        L4f:
            r9.a()
            return r0
        L53:
            r10 = move-exception
            r0 = r11
        L55:
            if (r0 == 0) goto L5a
            r0.close()
        L5a:
            r9.a()
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.bluemobi.dylan.sqlitelibrary.c.query(java.lang.Class, int):java.lang.Object");
    }

    public <T> int update(T t3, int i4) {
        int i5 = 0;
        try {
            if (t3 == null) {
                return 0;
            }
            try {
                String d4 = b.d(t3.getClass());
                ContentValues g4 = g(t3);
                l();
                i5 = this.f1971c.update(d4, g4, "id=?", new String[]{String.valueOf(i4)});
            } catch (Exception e4) {
                e4.printStackTrace();
            }
            return i5;
        } finally {
            a();
        }
    }

    public <T> int delete(Class<T> cls, String str, String[] strArr) {
        int i4 = 0;
        if (cls == null) {
            return 0;
        }
        String d4 = b.d(cls);
        try {
            try {
                l();
                i4 = this.f1971c.delete(d4, str, strArr);
            } catch (Exception e4) {
                e4.printStackTrace();
            }
            return i4;
        } finally {
            a();
        }
    }

    public <T> void insert(List<T> list) {
        try {
            if (list == null) {
                return;
            }
            try {
                l();
                this.f1971c.beginTransaction();
                for (T t3 : list) {
                    this.f1971c.insert(b.d(t3.getClass()), null, g(t3));
                }
                this.f1971c.setTransactionSuccessful();
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        } finally {
            this.f1971c.endTransaction();
            a();
        }
    }

    public <T> int update(T t3, String str, String[] strArr) {
        if (t3 == null) {
            return -1;
        }
        String d4 = b.d(t3.getClass());
        ContentValues g4 = g(t3);
        int i4 = 0;
        try {
            try {
                l();
                i4 = this.f1971c.update(d4, g4, str, strArr);
            } catch (Exception e4) {
                e4.printStackTrace();
            }
            return i4;
        } finally {
            a();
        }
    }

    public <T> List<T> query(Class<T> cls, String str, String[] strArr) {
        ArrayList arrayList;
        Cursor query;
        Cursor cursor = null;
        if (cls == null) {
            return null;
        }
        String d4 = b.d(cls);
        try {
            try {
                l();
                query = this.f1971c.query(d4, null, str, strArr, null, null, null);
            } catch (Exception e4) {
                e = e4;
                arrayList = null;
            }
            if (query == null) {
                if (query != null) {
                    query.close();
                }
                a();
                return null;
            }
            try {
                try {
                    arrayList = new ArrayList();
                    while (query.moveToNext()) {
                        try {
                            arrayList.add(k(cls, query));
                        } catch (Exception e5) {
                            e = e5;
                            cursor = query;
                            e.printStackTrace();
                            if (cursor != null) {
                                cursor.close();
                            }
                            a();
                            return arrayList;
                        }
                    }
                    query.close();
                    query.close();
                } catch (Exception e6) {
                    e = e6;
                    arrayList = null;
                }
                a();
                return arrayList;
            } catch (Throwable th) {
                th = th;
                cursor = query;
                if (cursor != null) {
                    cursor.close();
                }
                a();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public <T> List<T> query(Class<T> cls) {
        ArrayList arrayList;
        Cursor query;
        Cursor cursor = null;
        if (cls == null) {
            a();
            return null;
        }
        try {
            try {
                l();
                query = this.f1971c.query(b.d(cls), null, null, null, null, null, null);
            } catch (Exception e4) {
                e = e4;
                arrayList = null;
            }
            if (query == null) {
                if (query != null) {
                    query.close();
                }
                a();
                return null;
            }
            try {
                try {
                    arrayList = new ArrayList();
                    while (query.moveToNext()) {
                        try {
                            arrayList.add(k(cls, query));
                        } catch (Exception e5) {
                            e = e5;
                            cursor = query;
                            e.printStackTrace();
                            if (cursor != null) {
                                cursor.close();
                            }
                            a();
                            return arrayList;
                        }
                    }
                    query.close();
                } catch (Exception e6) {
                    e = e6;
                    arrayList = null;
                }
                a();
                return arrayList;
            } catch (Throwable th) {
                th = th;
                cursor = query;
                if (cursor != null) {
                    cursor.close();
                }
                a();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public <T> List<T> query(Class<T> cls, String[] strArr, String str, String[] strArr2, String str2, String str3, String str4, String str5) {
        ArrayList arrayList;
        Cursor query;
        Cursor cursor = null;
        if (cls == null) {
            a();
            return null;
        }
        try {
            try {
                l();
                query = this.f1971c.query(b.d(cls), strArr, str, strArr2, str2, str3, str4, str5);
            } catch (Throwable th) {
                th = th;
            }
        } catch (Exception e4) {
            e = e4;
            arrayList = null;
        }
        if (query == null) {
            if (query != null) {
                query.close();
            }
            a();
            return null;
        }
        try {
            try {
                arrayList = new ArrayList();
                while (query.moveToNext()) {
                    try {
                        arrayList.add(k(cls, query));
                    } catch (Exception e5) {
                        e = e5;
                        cursor = query;
                        e.printStackTrace();
                        if (cursor != null) {
                            cursor.close();
                        }
                        a();
                        return arrayList;
                    }
                }
                query.close();
            } catch (Exception e6) {
                e = e6;
                arrayList = null;
            }
            a();
            return arrayList;
        } catch (Throwable th2) {
            th = th2;
            cursor = query;
            if (cursor != null) {
                cursor.close();
            }
            a();
            throw th;
        }
    }
}

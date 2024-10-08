package cn.bluemobi.dylan.sqlitelibrary;

import android.content.ContentValues;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import net.sqlcipher.Cursor;
import net.sqlcipher.SQLException;
import net.sqlcipher.database.SQLiteDatabase;
import net.sqlcipher.database.SQLiteDatabaseHook;

/* renamed from: cn.bluemobi.dylan.sqlitelibrary.d */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class SQLitePwDbUtil {

    /* renamed from: h */
    private static volatile SQLitePwDbUtil f1998h;

    /* renamed from: a */
    String[] f1999a = {"java.lang.Integer", "java.lang.Double", "java.lang.Float", "java.lang.Long", "java.lang.Short", "java.lang.Byte", "java.lang.Boolean", "java.lang.Character", "java.lang.String", "java.util.Date", IAdInterListener.AdProdType.PRODUCT_INTERSTITIAL, "double", "long", "short", "byte", "boolean", "char", "float"};

    /* renamed from: b */
    private final String f2000b = "SQLiteDbUtil";

    /* renamed from: c */
    private SQLiteDatabase f2001c;

    /* renamed from: d */
    private Context f2002d;

    /* renamed from: e */
    private String f2003e;

    /* renamed from: f */
    private String f2004f;

    /* renamed from: g */
    private String f2005g;

    private SQLitePwDbUtil() {
    }

    /* renamed from: g */
    private <T> ContentValues m57459g(T t) {
        List<Map<String, Object>> m57486a = JavaReflectUtil.m57486a(t);
        ContentValues contentValues = new ContentValues();
        for (int i = 0; i < m57486a.size(); i++) {
            Map<String, Object> map = m57486a.get(i);
            String str = (String) map.get("name");
            Object obj = map.get(DomainCampaignEx.LOOPBACK_VALUE);
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
        if (cls.equals(Integer.class) || cls.getName().equals(IAdInterListener.AdProdType.PRODUCT_INTERSTITIAL)) {
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

    /* renamed from: h */
    public static SQLitePwDbUtil m57458h() {
        if (f1998h == null) {
            synchronized (SQLitePwDbUtil.class) {
                if (f1998h == null) {
                    f1998h = new SQLitePwDbUtil();
                }
            }
        }
        return f1998h;
    }

    /* renamed from: k */
    private boolean m57455k(String str) {
        List<Map<String, Object>> m57448r = m57448r("SELECT count(*) FROM sqlite_master WHERE type='table' AND name='" + str + "'");
        return m57448r != null && m57448r.size() > 0 && Integer.parseInt(m57448r.get(0).get("count(*)").toString()) > 0;
    }

    /* renamed from: l */
    private <T> T m57454l(Class<T> cls, Cursor cursor) {
        Object valueOf;
        try {
            Constructor<T> constructor = cls.getConstructor(new Class[0]);
            constructor.setAccessible(true);
            T newInstance = constructor.newInstance(new Object[0]);
            Class<?>[] m57484c = JavaReflectUtil.m57484c(cls);
            String[] m57485b = JavaReflectUtil.m57485b(cls);
            for (int i = 0; i < m57484c.length; i++) {
                String str = m57485b[i];
                Class<?> cls2 = m57484c[i];
                Method method = cls.getMethod("set" + str.substring(0, 1).toUpperCase() + str.substring(1), cls2);
                if (cls2.equals(String.class)) {
                    valueOf = cursor.getString(cursor.getColumnIndex(str));
                } else {
                    if (!cls2.equals(Integer.class) && !cls2.getName().equals(IAdInterListener.AdProdType.PRODUCT_INTERSTITIAL)) {
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
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return null;
        } catch (InstantiationException e2) {
            e2.printStackTrace();
            return null;
        } catch (NoSuchMethodException e3) {
            e3.printStackTrace();
            return null;
        } catch (InvocationTargetException e4) {
            e4.printStackTrace();
            return null;
        }
    }

    /* renamed from: m */
    private void m57453m() throws Exception {
        if (this.f2001c != null) {
            m57449q(this.f2002d, this.f2003e, this.f2004f, this.f2005g);
            return;
        }
        throw new Exception("未初始化数据库");
    }

    /* renamed from: a */
    public void m57465a() {
        SQLiteDatabase sQLiteDatabase = this.f2001c;
        if (sQLiteDatabase == null || !sQLiteDatabase.isOpen()) {
            return;
        }
        this.f2001c.close();
    }

    /* renamed from: b */
    public <T> void m57464b(Class<T> cls) {
        String str;
        ArrayList arrayList;
        ArrayList arrayList2;
        String m57483d = JavaReflectUtil.m57483d(cls);
        ArrayList arrayList3 = new ArrayList(Arrays.asList(JavaReflectUtil.m57485b(cls)));
        ArrayList arrayList4 = new ArrayList(Arrays.asList(JavaReflectUtil.m57484c(cls)));
        int indexOf = arrayList3.indexOf("id");
        if (indexOf != -1) {
            arrayList3.remove(indexOf);
            arrayList4.remove(indexOf);
        }
        String str2 = ",";
        if (!m57455k(m57483d)) {
            String str3 = ("CREATE TABLE IF NOT EXISTS " + m57483d + "(") + "id  Integer PRIMARY KEY AUTOINCREMENT,";
            for (int i = 0; i < arrayList3.size(); i++) {
                str3 = i != arrayList3.size() - 1 ? str3 + ((String) arrayList3.get(i)) + " " + getType((Class) arrayList4.get(i)) + "," : str3 + ((String) arrayList3.get(i)) + " " + getType((Class) arrayList4.get(i));
            }
            String str4 = str3 + ")";
            Log.d("SQLiteDbUtil", "创建表" + m57483d + " sql=" + str4);
            m57460f(str4);
            return;
        }
        List<Map<String, Object>> m57448r = m57448r("PRAGMA table_info([" + m57483d + "])");
        StringBuilder sb = new StringBuilder();
        sb.append("表信息");
        sb.append(m57448r);
        Log.d("SQLiteDbUtil", sb.toString());
        ArrayList arrayList5 = new ArrayList();
        ArrayList arrayList6 = new ArrayList();
        int i2 = 0;
        while (i2 < m57448r.size()) {
            String str5 = str2;
            String obj = m57448r.get(i2).get("name").toString();
            List<Map<String, Object>> list = m57448r;
            String obj2 = m57448r.get(i2).get("type").toString();
            arrayList5.add(obj);
            arrayList6.add(obj2);
            i2++;
            str2 = str5;
            m57448r = list;
        }
        String str6 = str2;
        int indexOf2 = arrayList5.indexOf("id");
        if (indexOf2 != -1) {
            arrayList5.remove(indexOf2);
            arrayList6.remove(indexOf2);
        }
        int i3 = 0;
        boolean z = false;
        while (i3 < arrayList3.size()) {
            String str7 = (String) arrayList3.get(i3);
            String type = getType((Class) arrayList4.get(i3));
            if (!arrayList5.contains(str7)) {
                StringBuilder sb2 = new StringBuilder();
                arrayList2 = arrayList4;
                sb2.append("ALTER TABLE ");
                sb2.append(m57483d);
                sb2.append(" ADD COLUMN ");
                sb2.append(str7);
                sb2.append(" ");
                sb2.append(type);
                String sb3 = sb2.toString();
                m57460f(sb3);
                Log.d("SQLiteDbUtil", "升级表【" + m57483d + "】新字段" + str7 + ",sql=" + sb3);
            } else {
                arrayList2 = arrayList4;
                int indexOf3 = arrayList5.indexOf(str7);
                if (indexOf3 != -1) {
                    String str8 = (String) arrayList6.get(indexOf3);
                    if (!type.equals(str8)) {
                        Log.d("SQLiteDbUtil", "需要修改表结构newColumnType=" + type + "  oldColumnType=" + str8);
                        z = true;
                    }
                }
            }
            i3++;
            arrayList4 = arrayList2;
        }
        ArrayList arrayList7 = arrayList4;
        if (z) {
            List<T> query = m57458h().query(cls);
            m57458h().m57461e(m57483d);
            String str9 = ("CREATE TABLE IF NOT EXISTS " + m57483d + "(") + "id  Integer PRIMARY KEY AUTOINCREMENT,";
            int i4 = 0;
            while (i4 < arrayList3.size()) {
                if (i4 != arrayList3.size() - 1) {
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append(str9);
                    sb4.append((String) arrayList3.get(i4));
                    sb4.append(" ");
                    arrayList = arrayList7;
                    sb4.append(getType((Class) arrayList.get(i4)));
                    str = str6;
                    sb4.append(str);
                    str9 = sb4.toString();
                } else {
                    str = str6;
                    arrayList = arrayList7;
                    str9 = str9 + ((String) arrayList3.get(i4)) + " " + getType((Class) arrayList.get(i4));
                }
                i4++;
                arrayList7 = arrayList;
                str6 = str;
            }
            String str10 = str9 + ")";
            Log.d("SQLiteDbUtil", "创建表" + m57483d + " sql=" + str10);
            m57460f(str10);
            m57458h().insert((List) query);
        }
    }

    /* renamed from: c */
    public <T> int m57463c(Class<T> cls) {
        int i = 0;
        if (cls == null) {
            return 0;
        }
        String m57483d = JavaReflectUtil.m57483d(cls);
        try {
            try {
                m57453m();
                i = this.f2001c.delete(m57483d, (String) null, (String[]) null);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return i;
        } finally {
            m57465a();
        }
    }

    /* renamed from: d */
    public <T> void m57462d(Class<T> cls) {
        if (cls == null) {
            return;
        }
        String m57483d = JavaReflectUtil.m57483d(cls);
        m57460f("DROP TABLE IF EXISTS " + m57483d);
    }

    public <T> int delete(Class<T> cls, int i) {
        int i2 = 0;
        if (cls == null) {
            return 0;
        }
        String m57483d = JavaReflectUtil.m57483d(cls);
        try {
            try {
                m57453m();
                i2 = this.f2001c.delete(m57483d, "id=?", new String[]{String.valueOf(i)});
            } catch (Exception e) {
                e.printStackTrace();
            }
            return i2;
        } finally {
            m57465a();
        }
    }

    /* renamed from: e */
    public void m57461e(String str) {
        m57460f("DROP TABLE IF EXISTS " + str);
    }

    /* renamed from: f */
    public void m57460f(String str) {
        try {
            try {
                m57453m();
                this.f2001c.execSQL(str);
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        } finally {
            m57465a();
        }
    }

    /* renamed from: i */
    public SQLiteDatabase m57457i() {
        return this.f2001c;
    }

    public <T> long insert(T t) {
        if (t == null) {
            return -1L;
        }
        String m57483d = JavaReflectUtil.m57483d(t.getClass());
        ContentValues m57459g = m57459g(t);
        long j = 0;
        try {
            try {
                m57453m();
                j = this.f2001c.insert(m57483d, (String) null, m57459g);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return j;
        } finally {
            m57465a();
        }
    }

    /* renamed from: j */
    public int m57456j() {
        try {
            m57453m();
            return this.f2001c.getVersion();
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        } finally {
            m57465a();
        }
    }

    /* renamed from: n */
    public void m57452n(Context context) {
        m57450p(context, null, null);
    }

    /* renamed from: o */
    public void m57451o(Context context, String str) {
        m57449q(context, null, str, "");
    }

    /* renamed from: p */
    public void m57450p(Context context, String str, String str2) {
        m57449q(context, null, str, str2);
    }

    /* renamed from: q */
    public void m57449q(Context context, String str, String str2, String str3) {
        this.f2002d = context;
        this.f2003e = str;
        this.f2004f = str2;
        this.f2005g = str3;
        try {
            this.f2001c = SQLiteDatabase.openOrCreateDatabase(SqlcipherUtils.m57445c(context, str, str2).getPath(), SQLiteDatabase.getBytes(str3.toCharArray()), (SQLiteDatabase.CursorFactory) null, (SQLiteDatabaseHook) null);
        } catch (Exception e) {
            e.printStackTrace();
        }
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
            java.lang.String r2 = cn.bluemobi.dylan.sqlitelibrary.JavaReflectUtil.m57483d(r10)
            r9.m57453m()     // Catch: java.lang.Throwable -> L43 java.lang.Exception -> L45
            net.sqlcipher.database.SQLiteDatabase r1 = r9.f2001c     // Catch: java.lang.Throwable -> L43 java.lang.Exception -> L45
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
            net.sqlcipher.Cursor r11 = r1.query(r2, r3, r4, r5, r6, r7, r8)     // Catch: java.lang.Throwable -> L43 java.lang.Exception -> L45
            if (r11 != 0) goto L2c
            if (r11 == 0) goto L28
            r11.close()
        L28:
            r9.m57465a()
            return r0
        L2c:
            boolean r1 = r11.moveToNext()     // Catch: java.lang.Exception -> L41 java.lang.Throwable -> L53
            if (r1 == 0) goto L3d
            java.lang.Object r10 = r9.m57454l(r10, r11)     // Catch: java.lang.Exception -> L41 java.lang.Throwable -> L53
            r11.close()
            r9.m57465a()
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
            r9.m57465a()
            return r0
        L53:
            r10 = move-exception
            r0 = r11
        L55:
            if (r0 == 0) goto L5a
            r0.close()
        L5a:
            r9.m57465a()
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.bluemobi.dylan.sqlitelibrary.SQLitePwDbUtil.query(java.lang.Class, int):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x0063, code lost:
        if (r11 == null) goto L28;
     */
    /* JADX WARN: Removed duplicated region for block: B:36:0x006f  */
    @android.annotation.TargetApi(16)
    /* renamed from: r */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.util.List<java.util.Map<java.lang.String, java.lang.Object>> m57448r(java.lang.String r11) {
        /*
            r10 = this;
            r0 = 0
            r10.m57453m()     // Catch: java.lang.Throwable -> L57 java.lang.Exception -> L5c
            net.sqlcipher.database.SQLiteDatabase r1 = r10.f2001c     // Catch: java.lang.Throwable -> L57 java.lang.Exception -> L5c
            net.sqlcipher.Cursor r11 = r1.rawQuery(r11, r0)     // Catch: java.lang.Throwable -> L57 java.lang.Exception -> L5c
            if (r11 != 0) goto L15
            if (r11 == 0) goto L11
            r11.close()
        L11:
            r10.m57465a()
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
            r10.m57465a()
            return r1
        L6c:
            r0 = move-exception
        L6d:
            if (r11 == 0) goto L72
            r11.close()
        L72:
            r10.m57465a()
            goto L77
        L76:
            throw r0
        L77:
            goto L76
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.bluemobi.dylan.sqlitelibrary.SQLitePwDbUtil.m57448r(java.lang.String):java.util.List");
    }

    public <T> int update(T t, int i) {
        int i2 = 0;
        try {
            if (t == null) {
                return 0;
            }
            try {
                String m57483d = JavaReflectUtil.m57483d(t.getClass());
                ContentValues m57459g = m57459g(t);
                m57453m();
                i2 = this.f2001c.update(m57483d, m57459g, "id=?", new String[]{String.valueOf(i)});
            } catch (Exception e) {
                e.printStackTrace();
            }
            return i2;
        } finally {
            m57465a();
        }
    }

    public <T> int delete(Class<T> cls, String str, String[] strArr) {
        int i = 0;
        if (cls == null) {
            return 0;
        }
        String m57483d = JavaReflectUtil.m57483d(cls);
        try {
            try {
                m57453m();
                i = this.f2001c.delete(m57483d, str, strArr);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return i;
        } finally {
            m57465a();
        }
    }

    public <T> void insert(List<T> list) {
        try {
            if (list == null) {
                return;
            }
            try {
                m57453m();
                this.f2001c.beginTransaction();
                for (T t : list) {
                    this.f2001c.insert(JavaReflectUtil.m57483d(t.getClass()), (String) null, m57459g(t));
                }
                this.f2001c.setTransactionSuccessful();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } finally {
            this.f2001c.endTransaction();
            m57465a();
        }
    }

    public <T> int update(T t, String str, String[] strArr) {
        if (t == null) {
            return -1;
        }
        String m57483d = JavaReflectUtil.m57483d(t.getClass());
        ContentValues m57459g = m57459g(t);
        int i = 0;
        try {
            try {
                m57453m();
                i = this.f2001c.update(m57483d, m57459g, str, strArr);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return i;
        } finally {
            m57465a();
        }
    }

    public <T> List<T> query(Class<T> cls, String str, String[] strArr) {
        ArrayList arrayList;
        Cursor query;
        Cursor cursor = null;
        if (cls == null) {
            return null;
        }
        String m57483d = JavaReflectUtil.m57483d(cls);
        try {
            try {
                m57453m();
                query = this.f2001c.query(m57483d, null, str, strArr, null, null, null);
            } catch (Exception e) {
                e = e;
                arrayList = null;
            }
            if (query == null) {
                if (query != null) {
                    query.close();
                }
                m57465a();
                return null;
            }
            try {
                try {
                    arrayList = new ArrayList();
                    while (query.moveToNext()) {
                        try {
                            arrayList.add(m57454l(cls, query));
                        } catch (Exception e2) {
                            e = e2;
                            cursor = query;
                            e.printStackTrace();
                            if (cursor != null) {
                                cursor.close();
                            }
                            m57465a();
                            return arrayList;
                        }
                    }
                    query.close();
                    query.close();
                } catch (Exception e3) {
                    e = e3;
                    arrayList = null;
                }
                m57465a();
                return arrayList;
            } catch (Throwable th) {
                th = th;
                cursor = query;
                if (cursor != null) {
                    cursor.close();
                }
                m57465a();
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
            m57465a();
            return null;
        }
        try {
            try {
                m57453m();
                query = this.f2001c.query(JavaReflectUtil.m57483d(cls), null, null, null, null, null, null);
            } catch (Exception e) {
                e = e;
                arrayList = null;
            }
            if (query == null) {
                if (query != null) {
                    query.close();
                }
                m57465a();
                return null;
            }
            try {
                try {
                    arrayList = new ArrayList();
                    while (query.moveToNext()) {
                        try {
                            arrayList.add(m57454l(cls, query));
                        } catch (Exception e2) {
                            e = e2;
                            cursor = query;
                            e.printStackTrace();
                            if (cursor != null) {
                                cursor.close();
                            }
                            m57465a();
                            return arrayList;
                        }
                    }
                    query.close();
                } catch (Exception e3) {
                    e = e3;
                    arrayList = null;
                }
                m57465a();
                return arrayList;
            } catch (Throwable th) {
                th = th;
                cursor = query;
                if (cursor != null) {
                    cursor.close();
                }
                m57465a();
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
            m57465a();
            return null;
        }
        try {
            try {
                m57453m();
                query = this.f2001c.query(JavaReflectUtil.m57483d(cls), strArr, str, strArr2, str2, str3, str4, str5);
            } catch (Throwable th) {
                th = th;
            }
        } catch (Exception e) {
            e = e;
            arrayList = null;
        }
        if (query == null) {
            if (query != null) {
                query.close();
            }
            m57465a();
            return null;
        }
        try {
            try {
                arrayList = new ArrayList();
                while (query.moveToNext()) {
                    try {
                        arrayList.add(m57454l(cls, query));
                    } catch (Exception e2) {
                        e = e2;
                        cursor = query;
                        e.printStackTrace();
                        if (cursor != null) {
                            cursor.close();
                        }
                        m57465a();
                        return arrayList;
                    }
                }
                query.close();
            } catch (Exception e3) {
                e = e3;
                arrayList = null;
            }
            m57465a();
            return arrayList;
        } catch (Throwable th2) {
            th = th2;
            cursor = query;
            if (cursor != null) {
                cursor.close();
            }
            m57465a();
            throw th;
        }
    }
}

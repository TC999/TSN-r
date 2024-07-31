package com.amap.api.col.p0463l;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.stub.StubApp;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.amap.api.col.3l.c6 */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class DBOperation {

    /* renamed from: d */
    private static Map<Class<? extends DBCreator>, DBCreator> f3739d = new HashMap();

    /* renamed from: a */
    private DB f3740a;

    /* renamed from: b */
    private SQLiteDatabase f3741b;

    /* renamed from: c */
    private DBCreator f3742c;

    public DBOperation(Context context, DBCreator dBCreator) {
        try {
            this.f3740a = new DB(StubApp.getOrigApplicationContext(context.getApplicationContext()), dBCreator.mo51411b(), dBCreator.mo51410c(), dBCreator);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        this.f3742c = dBCreator;
    }

    /* renamed from: a */
    private static ContentValues m55466a(Object obj, EntityClass entityClass) {
        Field[] m55454m;
        ContentValues contentValues = new ContentValues();
        for (Field field : m55454m(obj.getClass(), entityClass.m54739b())) {
            field.setAccessible(true);
            m55458i(obj, field, contentValues);
        }
        return contentValues;
    }

    /* renamed from: b */
    private SQLiteDatabase m55465b() {
        try {
            if (this.f3741b == null) {
                this.f3741b = this.f3740a.getReadableDatabase();
            }
        } catch (Throwable th) {
            BasicLogHandler.m54177e(th, "dbs", "grd");
        }
        return this.f3741b;
    }

    /* renamed from: c */
    public static synchronized DBCreator m55464c(Class<? extends DBCreator> cls) throws IllegalAccessException, InstantiationException {
        DBCreator dBCreator;
        synchronized (DBOperation.class) {
            if (f3739d.get(cls) == null) {
                f3739d.put(cls, cls.newInstance());
            }
            dBCreator = f3739d.get(cls);
        }
        return dBCreator;
    }

    /* renamed from: d */
    private static <T> T m55463d(Cursor cursor, Class<T> cls, EntityClass entityClass) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Field[] m55454m = m55454m(cls, entityClass.m54739b());
        Constructor<T> declaredConstructor = cls.getDeclaredConstructor(new Class[0]);
        declaredConstructor.setAccessible(true);
        T newInstance = declaredConstructor.newInstance(new Object[0]);
        for (Field field : m55454m) {
            field.setAccessible(true);
            Annotation annotation = field.getAnnotation(EntityField.class);
            if (annotation != null) {
                EntityField entityField = (EntityField) annotation;
                int m54737b = entityField.m54737b();
                int columnIndex = cursor.getColumnIndex(entityField.m54738a());
                switch (m54737b) {
                    case 1:
                        field.set(newInstance, Short.valueOf(cursor.getShort(columnIndex)));
                        continue;
                    case 2:
                        field.set(newInstance, Integer.valueOf(cursor.getInt(columnIndex)));
                        continue;
                    case 3:
                        field.set(newInstance, Float.valueOf(cursor.getFloat(columnIndex)));
                        continue;
                    case 4:
                        field.set(newInstance, Double.valueOf(cursor.getDouble(columnIndex)));
                        continue;
                    case 5:
                        field.set(newInstance, Long.valueOf(cursor.getLong(columnIndex)));
                        continue;
                    case 6:
                        field.set(newInstance, cursor.getString(columnIndex));
                        continue;
                    case 7:
                        field.set(newInstance, cursor.getBlob(columnIndex));
                        continue;
                }
            }
        }
        return newInstance;
    }

    /* renamed from: e */
    private static <T> String m55462e(EntityClass entityClass) {
        if (entityClass == null) {
            return null;
        }
        return entityClass.m54740a();
    }

    /* renamed from: f */
    private static <T> void m55461f(SQLiteDatabase sQLiteDatabase, T t) {
        EntityClass m55452o = m55452o(t.getClass());
        String m55462e = m55462e(m55452o);
        if (TextUtils.isEmpty(m55462e) || sQLiteDatabase == null) {
            return;
        }
        sQLiteDatabase.insert(m55462e, null, m55466a(t, m55452o));
    }

    /* renamed from: g */
    private <T> void m55460g(T t) {
        m55450q(t);
    }

    /* renamed from: i */
    private static void m55458i(Object obj, Field field, ContentValues contentValues) {
        Annotation annotation = field.getAnnotation(EntityField.class);
        if (annotation == null) {
            return;
        }
        EntityField entityField = (EntityField) annotation;
        try {
            switch (entityField.m54737b()) {
                case 1:
                    contentValues.put(entityField.m54738a(), Short.valueOf(field.getShort(obj)));
                    return;
                case 2:
                    contentValues.put(entityField.m54738a(), Integer.valueOf(field.getInt(obj)));
                    return;
                case 3:
                    contentValues.put(entityField.m54738a(), Float.valueOf(field.getFloat(obj)));
                    return;
                case 4:
                    contentValues.put(entityField.m54738a(), Double.valueOf(field.getDouble(obj)));
                    return;
                case 5:
                    contentValues.put(entityField.m54738a(), Long.valueOf(field.getLong(obj)));
                    return;
                case 6:
                    contentValues.put(entityField.m54738a(), (String) field.get(obj));
                    return;
                case 7:
                    contentValues.put(entityField.m54738a(), (byte[]) field.get(obj));
                    return;
                default:
                    return;
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: k */
    private <T> void m55456k(String str, Object obj) {
        synchronized (this.f3742c) {
            if (obj == null) {
                return;
            }
            EntityClass m55452o = m55452o(obj.getClass());
            String m55462e = m55462e(m55452o);
            if (TextUtils.isEmpty(m55462e)) {
                return;
            }
            ContentValues m55466a = m55466a(obj, m55452o);
            SQLiteDatabase m55453n = m55453n();
            this.f3741b = m55453n;
            if (m55453n == null) {
                return;
            }
            m55453n.update(m55462e, m55466a, str, null);
            SQLiteDatabase sQLiteDatabase = this.f3741b;
            if (sQLiteDatabase != null) {
                sQLiteDatabase.close();
                this.f3741b = null;
            }
        }
    }

    /* renamed from: m */
    private static Field[] m55454m(Class<?> cls, boolean z) {
        if (cls == null) {
            return null;
        }
        if (z) {
            return cls.getSuperclass().getDeclaredFields();
        }
        return cls.getDeclaredFields();
    }

    /* renamed from: n */
    private SQLiteDatabase m55453n() {
        try {
            SQLiteDatabase sQLiteDatabase = this.f3741b;
            if (sQLiteDatabase == null || sQLiteDatabase.isReadOnly()) {
                SQLiteDatabase sQLiteDatabase2 = this.f3741b;
                if (sQLiteDatabase2 != null) {
                    sQLiteDatabase2.close();
                }
                this.f3741b = this.f3740a.getWritableDatabase();
            }
        } catch (Throwable th) {
            BasicLogHandler.m54177e(th, "dbs", "gwd");
        }
        return this.f3741b;
    }

    /* renamed from: o */
    private static <T> EntityClass m55452o(Class<T> cls) {
        Annotation annotation = cls.getAnnotation(EntityClass.class);
        if (annotation != null) {
            return (EntityClass) annotation;
        }
        return null;
    }

    /* renamed from: q */
    private <T> void m55450q(T t) {
        synchronized (this.f3742c) {
            SQLiteDatabase m55453n = m55453n();
            this.f3741b = m55453n;
            if (m55453n == null) {
                return;
            }
            m55461f(m55453n, t);
            SQLiteDatabase sQLiteDatabase = this.f3741b;
            if (sQLiteDatabase != null) {
                sQLiteDatabase.close();
                this.f3741b = null;
            }
        }
    }

    /* renamed from: r */
    private <T> void m55449r(String str, Object obj) {
        m55456k(str, obj);
    }

    /* renamed from: s */
    private <T> List<T> m55448s(String str, Class<T> cls) {
        Cursor cursor;
        String str2;
        String str3;
        synchronized (this.f3742c) {
            ArrayList arrayList = new ArrayList();
            EntityClass m55452o = m55452o(cls);
            String m55462e = m55462e(m55452o);
            if (this.f3741b == null) {
                this.f3741b = m55465b();
            }
            if (this.f3741b == null || TextUtils.isEmpty(m55462e) || str == null) {
                return arrayList;
            }
            try {
                cursor = this.f3741b.query(m55462e, null, str, null, null, null, null);
            } catch (Throwable th) {
                th = th;
                cursor = null;
            }
            try {
            } catch (Throwable th2) {
                th = th2;
                BasicLogHandler.m54177e(th, "dbs", "sld");
                if (cursor != null) {
                    cursor.close();
                }
                try {
                    SQLiteDatabase sQLiteDatabase = this.f3741b;
                    if (sQLiteDatabase != null) {
                        sQLiteDatabase.close();
                        this.f3741b = null;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    str2 = "dbs";
                    str3 = "sld";
                    BasicLogHandler.m54177e(th, str2, str3);
                    return arrayList;
                }
                return arrayList;
            }
            if (cursor == null) {
                this.f3741b.close();
                this.f3741b = null;
                if (cursor != null) {
                    cursor.close();
                }
                SQLiteDatabase sQLiteDatabase2 = this.f3741b;
                if (sQLiteDatabase2 != null) {
                    sQLiteDatabase2.close();
                    this.f3741b = null;
                }
                return arrayList;
            }
            while (cursor.moveToNext()) {
                arrayList.add(m55463d(cursor, cls, m55452o));
            }
            cursor.close();
            try {
                SQLiteDatabase sQLiteDatabase3 = this.f3741b;
                if (sQLiteDatabase3 != null) {
                    sQLiteDatabase3.close();
                    this.f3741b = null;
                }
            } catch (Throwable th4) {
                th = th4;
                str2 = "dbs";
                str3 = "sld";
                BasicLogHandler.m54177e(th, str2, str3);
                return arrayList;
            }
            return arrayList;
        }
    }

    /* renamed from: h */
    public final void m55459h(Object obj, String str) {
        synchronized (this.f3742c) {
            List m55451p = m55451p(str, obj.getClass());
            if (m55451p != null && m55451p.size() != 0) {
                m55449r(str, obj);
            }
            m55460g(obj);
        }
    }

    /* renamed from: j */
    public final <T> void m55457j(String str, Class<T> cls) {
        synchronized (this.f3742c) {
            String m55462e = m55462e(m55452o(cls));
            if (TextUtils.isEmpty(m55462e)) {
                return;
            }
            SQLiteDatabase m55453n = m55453n();
            this.f3741b = m55453n;
            if (m55453n == null) {
                return;
            }
            m55453n.delete(m55462e, str, null);
            SQLiteDatabase sQLiteDatabase = this.f3741b;
            if (sQLiteDatabase != null) {
                sQLiteDatabase.close();
                this.f3741b = null;
            }
        }
    }

    /* renamed from: l */
    public final <T> void m55455l(List<T> list) {
        synchronized (this.f3742c) {
            if (list.size() == 0) {
                return;
            }
            SQLiteDatabase m55453n = m55453n();
            this.f3741b = m55453n;
            if (m55453n == null) {
                return;
            }
            m55453n.beginTransaction();
            for (T t : list) {
                m55461f(this.f3741b, t);
            }
            this.f3741b.setTransactionSuccessful();
            if (this.f3741b.inTransaction()) {
                this.f3741b.endTransaction();
            }
            try {
                this.f3741b.close();
                this.f3741b = null;
            } catch (Throwable th) {
                BasicLogHandler.m54177e(th, "dbs", "ild");
            }
        }
    }

    /* renamed from: p */
    public final <T> List<T> m55451p(String str, Class<T> cls) {
        return m55448s(str, cls);
    }
}

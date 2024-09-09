package com.amap.api.col.p0003l;

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

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* compiled from: DBOperation.java */
/* renamed from: com.amap.api.col.3l.d6  reason: invalid package */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class d6 {

    /* renamed from: d  reason: collision with root package name */
    private static Map<Class<? extends c6>, c6> f7432d = new HashMap();

    /* renamed from: a  reason: collision with root package name */
    private e6 f7433a;

    /* renamed from: b  reason: collision with root package name */
    private SQLiteDatabase f7434b;

    /* renamed from: c  reason: collision with root package name */
    private c6 f7435c;

    public d6(Context context, c6 c6Var) {
        try {
            this.f7433a = new e6(StubApp.getOrigApplicationContext(context.getApplicationContext()), c6Var.b(), c6Var.c(), c6Var);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        this.f7435c = c6Var;
    }

    private static ContentValues a(Object obj, hk hkVar) {
        Field[] m4;
        ContentValues contentValues = new ContentValues();
        for (Field field : m(obj.getClass(), hkVar.b())) {
            field.setAccessible(true);
            i(obj, field, contentValues);
        }
        return contentValues;
    }

    private SQLiteDatabase b() {
        try {
            if (this.f7434b == null) {
                this.f7434b = this.f7433a.getReadableDatabase();
            }
        } catch (Throwable th) {
            q5.e(th, "dbs", "grd");
        }
        return this.f7434b;
    }

    public static synchronized c6 c(Class<? extends c6> cls) throws IllegalAccessException, InstantiationException {
        c6 c6Var;
        synchronized (d6.class) {
            if (f7432d.get(cls) == null) {
                f7432d.put(cls, cls.newInstance());
            }
            c6Var = f7432d.get(cls);
        }
        return c6Var;
    }

    private static <T> T d(Cursor cursor, Class<T> cls, hk hkVar) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Field[] m4 = m(cls, hkVar.b());
        Constructor<T> declaredConstructor = cls.getDeclaredConstructor(new Class[0]);
        declaredConstructor.setAccessible(true);
        T newInstance = declaredConstructor.newInstance(new Object[0]);
        for (Field field : m4) {
            field.setAccessible(true);
            Annotation annotation = field.getAnnotation(hl.class);
            if (annotation != null) {
                hl hlVar = (hl) annotation;
                int b4 = hlVar.b();
                int columnIndex = cursor.getColumnIndex(hlVar.a());
                switch (b4) {
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

    private static <T> String e(hk hkVar) {
        if (hkVar == null) {
            return null;
        }
        return hkVar.a();
    }

    private static <T> void f(SQLiteDatabase sQLiteDatabase, T t3) {
        hk o4 = o(t3.getClass());
        String e4 = e(o4);
        if (TextUtils.isEmpty(e4) || sQLiteDatabase == null) {
            return;
        }
        sQLiteDatabase.insert(e4, null, a(t3, o4));
    }

    private <T> void g(T t3) {
        q(t3);
    }

    private static void i(Object obj, Field field, ContentValues contentValues) {
        Annotation annotation = field.getAnnotation(hl.class);
        if (annotation == null) {
            return;
        }
        hl hlVar = (hl) annotation;
        try {
            switch (hlVar.b()) {
                case 1:
                    contentValues.put(hlVar.a(), Short.valueOf(field.getShort(obj)));
                    return;
                case 2:
                    contentValues.put(hlVar.a(), Integer.valueOf(field.getInt(obj)));
                    return;
                case 3:
                    contentValues.put(hlVar.a(), Float.valueOf(field.getFloat(obj)));
                    return;
                case 4:
                    contentValues.put(hlVar.a(), Double.valueOf(field.getDouble(obj)));
                    return;
                case 5:
                    contentValues.put(hlVar.a(), Long.valueOf(field.getLong(obj)));
                    return;
                case 6:
                    contentValues.put(hlVar.a(), (String) field.get(obj));
                    return;
                case 7:
                    contentValues.put(hlVar.a(), (byte[]) field.get(obj));
                    return;
                default:
                    return;
            }
        } catch (IllegalAccessException e4) {
            e4.printStackTrace();
        }
    }

    private <T> void k(String str, Object obj) {
        synchronized (this.f7435c) {
            if (obj == null) {
                return;
            }
            hk o4 = o(obj.getClass());
            String e4 = e(o4);
            if (TextUtils.isEmpty(e4)) {
                return;
            }
            ContentValues a4 = a(obj, o4);
            SQLiteDatabase n4 = n();
            this.f7434b = n4;
            if (n4 == null) {
                return;
            }
            n4.update(e4, a4, str, null);
            SQLiteDatabase sQLiteDatabase = this.f7434b;
            if (sQLiteDatabase != null) {
                sQLiteDatabase.close();
                this.f7434b = null;
            }
        }
    }

    private static Field[] m(Class<?> cls, boolean z3) {
        if (cls == null) {
            return null;
        }
        if (z3) {
            return cls.getSuperclass().getDeclaredFields();
        }
        return cls.getDeclaredFields();
    }

    private SQLiteDatabase n() {
        try {
            SQLiteDatabase sQLiteDatabase = this.f7434b;
            if (sQLiteDatabase == null || sQLiteDatabase.isReadOnly()) {
                SQLiteDatabase sQLiteDatabase2 = this.f7434b;
                if (sQLiteDatabase2 != null) {
                    sQLiteDatabase2.close();
                }
                this.f7434b = this.f7433a.getWritableDatabase();
            }
        } catch (Throwable th) {
            q5.e(th, "dbs", "gwd");
        }
        return this.f7434b;
    }

    private static <T> hk o(Class<T> cls) {
        Annotation annotation = cls.getAnnotation(hk.class);
        if (annotation != null) {
            return (hk) annotation;
        }
        return null;
    }

    private <T> void q(T t3) {
        synchronized (this.f7435c) {
            SQLiteDatabase n4 = n();
            this.f7434b = n4;
            if (n4 == null) {
                return;
            }
            f(n4, t3);
            SQLiteDatabase sQLiteDatabase = this.f7434b;
            if (sQLiteDatabase != null) {
                sQLiteDatabase.close();
                this.f7434b = null;
            }
        }
    }

    private <T> void r(String str, Object obj) {
        k(str, obj);
    }

    private <T> List<T> s(String str, Class<T> cls) {
        Cursor cursor;
        String str2;
        String str3;
        synchronized (this.f7435c) {
            ArrayList arrayList = new ArrayList();
            hk o4 = o(cls);
            String e4 = e(o4);
            if (this.f7434b == null) {
                this.f7434b = b();
            }
            if (this.f7434b == null || TextUtils.isEmpty(e4) || str == null) {
                return arrayList;
            }
            try {
                cursor = this.f7434b.query(e4, null, str, null, null, null, null);
            } catch (Throwable th) {
                th = th;
                cursor = null;
            }
            try {
            } catch (Throwable th2) {
                th = th2;
                q5.e(th, "dbs", "sld");
                if (cursor != null) {
                    cursor.close();
                }
                try {
                    SQLiteDatabase sQLiteDatabase = this.f7434b;
                    if (sQLiteDatabase != null) {
                        sQLiteDatabase.close();
                        this.f7434b = null;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    str2 = "dbs";
                    str3 = "sld";
                    q5.e(th, str2, str3);
                    return arrayList;
                }
                return arrayList;
            }
            if (cursor == null) {
                this.f7434b.close();
                this.f7434b = null;
                if (cursor != null) {
                    cursor.close();
                }
                SQLiteDatabase sQLiteDatabase2 = this.f7434b;
                if (sQLiteDatabase2 != null) {
                    sQLiteDatabase2.close();
                    this.f7434b = null;
                }
                return arrayList;
            }
            while (cursor.moveToNext()) {
                arrayList.add(d(cursor, cls, o4));
            }
            cursor.close();
            try {
                SQLiteDatabase sQLiteDatabase3 = this.f7434b;
                if (sQLiteDatabase3 != null) {
                    sQLiteDatabase3.close();
                    this.f7434b = null;
                }
            } catch (Throwable th4) {
                th = th4;
                str2 = "dbs";
                str3 = "sld";
                q5.e(th, str2, str3);
                return arrayList;
            }
            return arrayList;
        }
    }

    public final void h(Object obj, String str) {
        synchronized (this.f7435c) {
            List p3 = p(str, obj.getClass());
            if (p3 != null && p3.size() != 0) {
                r(str, obj);
            }
            g(obj);
        }
    }

    public final <T> void j(String str, Class<T> cls) {
        synchronized (this.f7435c) {
            String e4 = e(o(cls));
            if (TextUtils.isEmpty(e4)) {
                return;
            }
            SQLiteDatabase n4 = n();
            this.f7434b = n4;
            if (n4 == null) {
                return;
            }
            n4.delete(e4, str, null);
            SQLiteDatabase sQLiteDatabase = this.f7434b;
            if (sQLiteDatabase != null) {
                sQLiteDatabase.close();
                this.f7434b = null;
            }
        }
    }

    public final <T> void l(List<T> list) {
        synchronized (this.f7435c) {
            if (list.size() == 0) {
                return;
            }
            SQLiteDatabase n4 = n();
            this.f7434b = n4;
            if (n4 == null) {
                return;
            }
            n4.beginTransaction();
            for (T t3 : list) {
                f(this.f7434b, t3);
            }
            this.f7434b.setTransactionSuccessful();
            if (this.f7434b.inTransaction()) {
                this.f7434b.endTransaction();
            }
            try {
                this.f7434b.close();
                this.f7434b = null;
            } catch (Throwable th) {
                q5.e(th, "dbs", "ild");
            }
        }
    }

    public final <T> List<T> p(String str, Class<T> cls) {
        return s(str, cls);
    }
}

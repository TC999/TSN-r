package cn.jpush.android.v;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public abstract class e extends SQLiteOpenHelper {

    /* renamed from: a  reason: collision with root package name */
    private volatile int f4469a;

    /* renamed from: b  reason: collision with root package name */
    private volatile int f4470b;

    /* renamed from: c  reason: collision with root package name */
    private volatile SQLiteDatabase f4471c;

    /* renamed from: d  reason: collision with root package name */
    private volatile SQLiteDatabase f4472d;

    /* renamed from: e  reason: collision with root package name */
    private final Object f4473e;

    /* renamed from: f  reason: collision with root package name */
    private final Object f4474f;

    /* renamed from: g  reason: collision with root package name */
    private final Context f4475g;

    /* renamed from: h  reason: collision with root package name */
    private final String f4476h;

    /* renamed from: i  reason: collision with root package name */
    private final int f4477i;

    /* renamed from: j  reason: collision with root package name */
    private final SQLiteDatabase.CursorFactory f4478j;

    public e(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i4) {
        super(context, str, cursorFactory, i4);
        this.f4469a = 0;
        this.f4470b = 0;
        this.f4473e = new Object();
        this.f4474f = new Object();
        this.f4475g = context;
        this.f4476h = str;
        this.f4477i = i4;
        this.f4478j = cursorFactory;
    }

    public boolean a(boolean z3) {
        try {
            if (z3) {
                synchronized (this.f4473e) {
                    getWritableDatabase();
                    this.f4470b++;
                }
                return true;
            }
            synchronized (this.f4474f) {
                getReadableDatabase();
                this.f4469a++;
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public void b(boolean z3) {
        boolean z4 = true;
        if (z3) {
            synchronized (this.f4473e) {
                if (this.f4472d != null && this.f4472d.isOpen()) {
                    int i4 = this.f4470b - 1;
                    this.f4470b = i4;
                    if (i4 > 0) {
                        z4 = false;
                    }
                }
                if (z4) {
                    this.f4470b = 0;
                    if (this.f4472d != null) {
                        this.f4472d.close();
                    }
                    this.f4472d = null;
                }
            }
            return;
        }
        synchronized (this.f4474f) {
            if (this.f4471c != null && this.f4471c.isOpen()) {
                int i5 = this.f4469a - 1;
                this.f4469a = i5;
                if (i5 > 0) {
                    z4 = false;
                }
            }
            if (z4) {
                this.f4469a = 0;
                if (this.f4471c != null) {
                    this.f4471c.close();
                }
                this.f4471c = null;
            }
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper, java.lang.AutoCloseable
    @Deprecated
    public void close() {
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public SQLiteDatabase getReadableDatabase() {
        if (this.f4471c == null || !this.f4471c.isOpen()) {
            synchronized (this.f4474f) {
                if (this.f4471c == null || !this.f4471c.isOpen()) {
                    try {
                        getWritableDatabase();
                    } catch (SQLiteException unused) {
                    }
                    String path = this.f4475g.getDatabasePath(this.f4476h).getPath();
                    this.f4471c = SQLiteDatabase.openDatabase(path, this.f4478j, 1);
                    if (this.f4471c.getVersion() != this.f4477i) {
                        throw new SQLiteException("Can't upgrade read-only database from version " + this.f4471c.getVersion() + " to " + this.f4477i + ": " + path);
                    }
                    this.f4469a = 0;
                    onOpen(this.f4471c);
                }
            }
        }
        return this.f4471c;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public SQLiteDatabase getWritableDatabase() {
        if (this.f4472d == null || !this.f4472d.isOpen()) {
            synchronized (this.f4473e) {
                if (this.f4472d == null || !this.f4472d.isOpen()) {
                    this.f4470b = 0;
                    this.f4472d = super.getWritableDatabase();
                    this.f4472d.enableWriteAheadLogging();
                }
            }
        }
        return this.f4472d;
    }
}

package androidx.room;

import androidx.annotation.RestrictTo;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public abstract class EntityInsertionAdapter<T> extends SharedSQLiteStatement {
    public EntityInsertionAdapter(RoomDatabase database) {
        super(database);
    }

    protected abstract void bind(SupportSQLiteStatement statement, T entity);

    public final void insert(T entity) {
        SupportSQLiteStatement acquire = acquire();
        try {
            bind(acquire, entity);
            acquire.executeInsert();
        } finally {
            release(acquire);
        }
    }

    public final long insertAndReturnId(T entity) {
        SupportSQLiteStatement acquire = acquire();
        try {
            bind(acquire, entity);
            return acquire.executeInsert();
        } finally {
            release(acquire);
        }
    }

    public final long[] insertAndReturnIdsArray(Collection<? extends T> entities) {
        SupportSQLiteStatement acquire = acquire();
        try {
            long[] jArr = new long[entities.size()];
            int i4 = 0;
            for (T t3 : entities) {
                bind(acquire, t3);
                jArr[i4] = acquire.executeInsert();
                i4++;
            }
            return jArr;
        } finally {
            release(acquire);
        }
    }

    public final Long[] insertAndReturnIdsArrayBox(Collection<? extends T> entities) {
        SupportSQLiteStatement acquire = acquire();
        try {
            Long[] lArr = new Long[entities.size()];
            int i4 = 0;
            for (T t3 : entities) {
                bind(acquire, t3);
                lArr[i4] = Long.valueOf(acquire.executeInsert());
                i4++;
            }
            return lArr;
        } finally {
            release(acquire);
        }
    }

    public final List<Long> insertAndReturnIdsList(T[] entities) {
        SupportSQLiteStatement acquire = acquire();
        try {
            ArrayList arrayList = new ArrayList(entities.length);
            int i4 = 0;
            for (T t3 : entities) {
                bind(acquire, t3);
                arrayList.add(i4, Long.valueOf(acquire.executeInsert()));
                i4++;
            }
            return arrayList;
        } finally {
            release(acquire);
        }
    }

    public final void insert(T[] entities) {
        SupportSQLiteStatement acquire = acquire();
        try {
            for (T t3 : entities) {
                bind(acquire, t3);
                acquire.executeInsert();
            }
        } finally {
            release(acquire);
        }
    }

    public final long[] insertAndReturnIdsArray(T[] entities) {
        SupportSQLiteStatement acquire = acquire();
        try {
            long[] jArr = new long[entities.length];
            int i4 = 0;
            for (T t3 : entities) {
                bind(acquire, t3);
                jArr[i4] = acquire.executeInsert();
                i4++;
            }
            return jArr;
        } finally {
            release(acquire);
        }
    }

    public final Long[] insertAndReturnIdsArrayBox(T[] entities) {
        SupportSQLiteStatement acquire = acquire();
        try {
            Long[] lArr = new Long[entities.length];
            int i4 = 0;
            for (T t3 : entities) {
                bind(acquire, t3);
                lArr[i4] = Long.valueOf(acquire.executeInsert());
                i4++;
            }
            return lArr;
        } finally {
            release(acquire);
        }
    }

    public final List<Long> insertAndReturnIdsList(Collection<? extends T> entities) {
        SupportSQLiteStatement acquire = acquire();
        try {
            ArrayList arrayList = new ArrayList(entities.size());
            int i4 = 0;
            for (T t3 : entities) {
                bind(acquire, t3);
                arrayList.add(i4, Long.valueOf(acquire.executeInsert()));
                i4++;
            }
            return arrayList;
        } finally {
            release(acquire);
        }
    }

    public final void insert(Iterable<? extends T> entities) {
        SupportSQLiteStatement acquire = acquire();
        try {
            for (T t3 : entities) {
                bind(acquire, t3);
                acquire.executeInsert();
            }
        } finally {
            release(acquire);
        }
    }
}

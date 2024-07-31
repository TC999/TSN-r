package androidx.room;

import androidx.annotation.RestrictTo;
import androidx.sqlite.p021db.SupportSQLiteStatement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: E:\fuckcool\tsn\6276784.dex */
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
            int i = 0;
            for (T t : entities) {
                bind(acquire, t);
                jArr[i] = acquire.executeInsert();
                i++;
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
            int i = 0;
            for (T t : entities) {
                bind(acquire, t);
                lArr[i] = Long.valueOf(acquire.executeInsert());
                i++;
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
            int i = 0;
            for (T t : entities) {
                bind(acquire, t);
                arrayList.add(i, Long.valueOf(acquire.executeInsert()));
                i++;
            }
            return arrayList;
        } finally {
            release(acquire);
        }
    }

    public final void insert(T[] entities) {
        SupportSQLiteStatement acquire = acquire();
        try {
            for (T t : entities) {
                bind(acquire, t);
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
            int i = 0;
            for (T t : entities) {
                bind(acquire, t);
                jArr[i] = acquire.executeInsert();
                i++;
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
            int i = 0;
            for (T t : entities) {
                bind(acquire, t);
                lArr[i] = Long.valueOf(acquire.executeInsert());
                i++;
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
            int i = 0;
            for (T t : entities) {
                bind(acquire, t);
                arrayList.add(i, Long.valueOf(acquire.executeInsert()));
                i++;
            }
            return arrayList;
        } finally {
            release(acquire);
        }
    }

    public final void insert(Iterable<? extends T> entities) {
        SupportSQLiteStatement acquire = acquire();
        try {
            for (T t : entities) {
                bind(acquire, t);
                acquire.executeInsert();
            }
        } finally {
            release(acquire);
        }
    }
}

package androidx.room;

import androidx.annotation.RestrictTo;
import androidx.sqlite.db.SupportSQLiteStatement;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public abstract class EntityDeletionOrUpdateAdapter<T> extends SharedSQLiteStatement {
    public EntityDeletionOrUpdateAdapter(RoomDatabase database) {
        super(database);
    }

    protected abstract void bind(SupportSQLiteStatement statement, T entity);

    @Override // androidx.room.SharedSQLiteStatement
    protected abstract String createQuery();

    public final int handle(T entity) {
        SupportSQLiteStatement acquire = acquire();
        try {
            bind(acquire, entity);
            return acquire.executeUpdateDelete();
        } finally {
            release(acquire);
        }
    }

    public final int handleMultiple(Iterable<? extends T> entities) {
        SupportSQLiteStatement acquire = acquire();
        int i4 = 0;
        try {
            for (T t3 : entities) {
                bind(acquire, t3);
                i4 += acquire.executeUpdateDelete();
            }
            return i4;
        } finally {
            release(acquire);
        }
    }

    public final int handleMultiple(T[] entities) {
        SupportSQLiteStatement acquire = acquire();
        try {
            int i4 = 0;
            for (T t3 : entities) {
                bind(acquire, t3);
                i4 += acquire.executeUpdateDelete();
            }
            return i4;
        } finally {
            release(acquire);
        }
    }
}

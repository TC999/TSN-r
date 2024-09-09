package androidx.room;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.room.RoomDatabase;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class Room {
    private static final String CURSOR_CONV_SUFFIX = "_CursorConverter";
    static final String LOG_TAG = "ROOM";
    public static final String MASTER_TABLE_NAME = "room_master_table";

    @NonNull
    public static <T extends RoomDatabase> RoomDatabase.Builder<T> databaseBuilder(@NonNull Context context, @NonNull Class<T> klass, @NonNull String name) {
        if (name != null && name.trim().length() != 0) {
            return new RoomDatabase.Builder<>(context, klass, name);
        }
        throw new IllegalArgumentException("Cannot build a database with null or empty name. If you are trying to create an in memory database, use Room.inMemoryDatabaseBuilder");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public static <T, C> T getGeneratedImplementation(Class<C> klass, String suffix) {
        String str;
        String name = klass.getPackage().getName();
        String canonicalName = klass.getCanonicalName();
        if (!name.isEmpty()) {
            canonicalName = canonicalName.substring(name.length() + 1);
        }
        String str2 = canonicalName.replace('.', '_') + suffix;
        try {
            if (name.isEmpty()) {
                str = str2;
            } else {
                str = name + "." + str2;
            }
            return (T) Class.forName(str, true, klass.getClassLoader()).newInstance();
        } catch (ClassNotFoundException unused) {
            throw new RuntimeException("cannot find implementation for " + klass.getCanonicalName() + ". " + str2 + " does not exist");
        } catch (IllegalAccessException unused2) {
            throw new RuntimeException("Cannot access the constructor" + klass.getCanonicalName());
        } catch (InstantiationException unused3) {
            throw new RuntimeException("Failed to create an instance of " + klass.getCanonicalName());
        }
    }

    @NonNull
    public static <T extends RoomDatabase> RoomDatabase.Builder<T> inMemoryDatabaseBuilder(@NonNull Context context, @NonNull Class<T> klass) {
        return new RoomDatabase.Builder<>(context, klass, null);
    }
}

package androidx.room.migration;

import androidx.annotation.NonNull;
import androidx.sqlite.p021db.SupportSQLiteDatabase;

/* loaded from: E:\fuckcool\tsn\6276784.dex */
public abstract class Migration {
    public final int endVersion;
    public final int startVersion;

    public Migration(int startVersion, int endVersion) {
        this.startVersion = startVersion;
        this.endVersion = endVersion;
    }

    public abstract void migrate(@NonNull SupportSQLiteDatabase database);
}

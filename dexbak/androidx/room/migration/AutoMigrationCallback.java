package androidx.room.migration;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.sqlite.p021db.SupportSQLiteDatabase;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public interface AutoMigrationCallback {
    void onPostMigrate(@NonNull SupportSQLiteDatabase db);
}

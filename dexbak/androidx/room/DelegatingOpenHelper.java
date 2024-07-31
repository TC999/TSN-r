package androidx.room;

import androidx.annotation.NonNull;
import androidx.sqlite.p021db.SupportSQLiteOpenHelper;

/* loaded from: E:\fuckcool\tsn\6276784.dex */
interface DelegatingOpenHelper {
    @NonNull
    SupportSQLiteOpenHelper getDelegate();
}

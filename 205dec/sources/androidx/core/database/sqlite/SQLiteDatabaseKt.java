package androidx.core.database.sqlite;

import android.database.sqlite.SQLiteDatabase;
import d2.l;
import kotlin.Metadata;
import kotlin.jvm.internal.c0;
import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* compiled from: SQLiteDatabase.kt */
@Metadata(bv = {}, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a=\u0010\u0007\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u00022\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00028\u00000\u0004\u00a2\u0006\u0002\b\u0005H\u0086\b\u00a2\u0006\u0004\b\u0007\u0010\b\u00a8\u0006\t"}, d2 = {"T", "Landroid/database/sqlite/SQLiteDatabase;", "", "exclusive", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "body", "transaction", "(Landroid/database/sqlite/SQLiteDatabase;ZLd2/l;)Ljava/lang/Object;", "core-ktx_release"}, k = 2, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public final class SQLiteDatabaseKt {
    public static final <T> T transaction(@NotNull SQLiteDatabase transaction, boolean z3, @NotNull l<? super SQLiteDatabase, ? extends T> body) {
        f0.q(transaction, "$this$transaction");
        f0.q(body, "body");
        if (z3) {
            transaction.beginTransaction();
        } else {
            transaction.beginTransactionNonExclusive();
        }
        try {
            T invoke = body.invoke(transaction);
            transaction.setTransactionSuccessful();
            return invoke;
        } finally {
            c0.d(1);
            transaction.endTransaction();
            c0.c(1);
        }
    }

    public static /* synthetic */ Object transaction$default(SQLiteDatabase transaction, boolean z3, l body, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            z3 = true;
        }
        f0.q(transaction, "$this$transaction");
        f0.q(body, "body");
        if (z3) {
            transaction.beginTransaction();
        } else {
            transaction.beginTransactionNonExclusive();
        }
        try {
            Object invoke = body.invoke(transaction);
            transaction.setTransactionSuccessful();
            return invoke;
        } finally {
            c0.d(1);
            transaction.endTransaction();
            c0.c(1);
        }
    }
}

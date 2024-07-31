package androidx.sqlite.p021db;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.internal.C14342f0;
import kotlin.jvm.internal.InlineMarker;
import org.jetbrains.annotations.NotNull;
import p617l1.InterfaceC15280l;

/* compiled from: SupportSQLiteDatabase.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a=\u0010\u0007\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u00022\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0002\b\u0005H\u0086\b¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, m12616d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/sqlite/db/SupportSQLiteDatabase;", "", "exclusive", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "body", "transaction", "(Landroidx/sqlite/db/SupportSQLiteDatabase;ZLl1/l;)Ljava/lang/Object;", "sqlite-ktx_release"}, m12615k = 2, m12614mv = {1, 4, 0})
/* renamed from: androidx.sqlite.db.SupportSQLiteDatabaseKt */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class SupportSQLiteDatabaseKt {
    public static final <T> T transaction(@NotNull SupportSQLiteDatabase transaction, boolean z, @NotNull InterfaceC15280l<? super SupportSQLiteDatabase, ? extends T> body) {
        C14342f0.m8183q(transaction, "$this$transaction");
        C14342f0.m8183q(body, "body");
        if (z) {
            transaction.beginTransaction();
        } else {
            transaction.beginTransactionNonExclusive();
        }
        try {
            T invoke = body.invoke(transaction);
            transaction.setTransactionSuccessful();
            return invoke;
        } finally {
            InlineMarker.m8228d(1);
            transaction.endTransaction();
            InlineMarker.m8229c(1);
        }
    }

    public static /* synthetic */ Object transaction$default(SupportSQLiteDatabase transaction, boolean z, InterfaceC15280l body, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        C14342f0.m8183q(transaction, "$this$transaction");
        C14342f0.m8183q(body, "body");
        if (z) {
            transaction.beginTransaction();
        } else {
            transaction.beginTransactionNonExclusive();
        }
        try {
            Object invoke = body.invoke(transaction);
            transaction.setTransactionSuccessful();
            return invoke;
        } finally {
            InlineMarker.m8228d(1);
            transaction.endTransaction();
            InlineMarker.m8229c(1);
        }
    }
}

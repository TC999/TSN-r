package androidx.room;

import androidx.arch.core.util.Function;
import androidx.sqlite.db.SupportSQLiteDatabase;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* compiled from: R8$$SyntheticClass */
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public final /* synthetic */ class n implements Function {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ n f189a = new n();

    private /* synthetic */ n() {
    }

    @Override // androidx.arch.core.util.Function
    public final Object apply(Object obj) {
        return Boolean.valueOf(((SupportSQLiteDatabase) obj).yieldIfContendedSafely());
    }
}

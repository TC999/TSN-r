package androidx.room;

import androidx.arch.core.util.Function;
import androidx.sqlite.p021db.SupportSQLiteDatabase;

/* compiled from: R8$$SyntheticClass */
/* renamed from: androidx.room.n */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final /* synthetic */ class C0761n implements Function {

    /* renamed from: a */
    public static final /* synthetic */ C0761n f189a = new C0761n();

    private /* synthetic */ C0761n() {
    }

    @Override // androidx.arch.core.util.Function
    public final Object apply(Object obj) {
        return Boolean.valueOf(((SupportSQLiteDatabase) obj).yieldIfContendedSafely());
    }
}

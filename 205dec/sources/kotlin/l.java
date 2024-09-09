package kotlin;

import kotlin.internal.InlineOnly;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: HashCode.kt */
@Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u001a\u000f\u0010\u0002\u001a\u00020\u0001*\u0004\u0018\u00010\u0000H\u0087\b\u00a8\u0006\u0003"}, d2 = {"", "", "a", "kotlin-stdlib"}, k = 2, mv = {1, 6, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class l {

    /* compiled from: KotlinVersion.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2 = {"Lkotlin/l$a;", "", "Lkotlin/l;", "CURRENT", "Lkotlin/l;", "", "MAX_COMPONENT_VALUE", "I", "<init>", "()V", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.u uVar) {
            this();
        }
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final int a(Object obj) {
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }
}

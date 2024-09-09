package kotlin.ranges;

import com.mbridge.msdk.foundation.entity.CampaignEx;
import kotlin.Metadata;
import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: Ranges.kt */
@Metadata(bv = {}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\f\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u0000 \u00162\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001\u0017B\u0017\u0012\u0006\u0010\u0011\u001a\u00020\u0003\u0012\u0006\u0010\u0013\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0011\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0096\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0016J\u0013\u0010\n\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0096\u0002J\b\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016R\u0014\u0010\u0011\u001a\u00020\u00038VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0013\u001a\u00020\u00038VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0012\u0010\u0010\u00a8\u0006\u0018"}, d2 = {"Lkotlin/ranges/c;", "Lkotlin/ranges/a;", "Lkotlin/ranges/g;", "", "value", "", "n", "isEmpty", "", "other", "equals", "", "hashCode", "", "toString", "p", "()Ljava/lang/Character;", CampaignEx.JSON_NATIVE_VIDEO_START, "o", "endInclusive", "<init>", "(CC)V", "e", "a", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class c extends kotlin.ranges.a implements g<Character> {
    @NotNull

    /* renamed from: e  reason: collision with root package name */
    public static final a f55784e = new a(null);
    @NotNull

    /* renamed from: f  reason: collision with root package name */
    private static final c f55785f = new c(1, 0);

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: Ranges.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\t"}, d2 = {"Lkotlin/ranges/c$a;", "", "Lkotlin/ranges/c;", "EMPTY", "Lkotlin/ranges/c;", "a", "()Lkotlin/ranges/c;", "<init>", "()V", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.u uVar) {
            this();
        }

        @NotNull
        public final c a() {
            return c.f55785f;
        }
    }

    public c(char c4, char c5) {
        super(c4, c5, 1);
    }

    @Override // kotlin.ranges.g
    public /* bridge */ /* synthetic */ boolean contains(Character ch) {
        return n(ch.charValue());
    }

    @Override // kotlin.ranges.a
    public boolean equals(@Nullable Object obj) {
        if (obj instanceof c) {
            if (!isEmpty() || !((c) obj).isEmpty()) {
                c cVar = (c) obj;
                if (c() != cVar.c() || g() != cVar.g()) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // kotlin.ranges.a
    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (c() * 31) + g();
    }

    @Override // kotlin.ranges.a, kotlin.ranges.g
    public boolean isEmpty() {
        return f0.t(c(), g()) > 0;
    }

    public boolean n(char c4) {
        return f0.t(c(), c4) <= 0 && f0.t(c4, g()) <= 0;
    }

    @Override // kotlin.ranges.g
    @NotNull
    /* renamed from: o */
    public Character getEndInclusive() {
        return Character.valueOf(g());
    }

    @Override // kotlin.ranges.g
    @NotNull
    /* renamed from: p */
    public Character getStart() {
        return Character.valueOf(c());
    }

    @Override // kotlin.ranges.a
    @NotNull
    public String toString() {
        return c() + ".." + g();
    }
}

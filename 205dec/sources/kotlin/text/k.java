package kotlin.text;

import java.util.List;
import kotlin.Metadata;
import kotlin.internal.InlineOnly;
import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: MatchResult.kt */
@Metadata(bv = {}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0001\u0010J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0000H&R\u0014\u0010\u0006\u001a\u00020\u00038&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\n\u001a\u00020\u00078&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0014\u0010\u000e\u001a\u00020\u000b8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\rR\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00070\u000f8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0016\u001a\u00020\u00138VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0017"}, d2 = {"Lkotlin/text/k;", "", "next", "Lkotlin/ranges/k;", "c", "()Lkotlin/ranges/k;", "range", "", "getValue", "()Ljava/lang/String;", "value", "Lkotlin/text/i;", "d", "()Lkotlin/text/i;", "groups", "", "b", "()Ljava/util/List;", "groupValues", "Lkotlin/text/k$b;", "a", "()Lkotlin/text/k$b;", "destructured", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public interface k {

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: MatchResult.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a {
        @NotNull
        public static b a(@NotNull k kVar) {
            f0.p(kVar, "this");
            return new b(kVar);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: MatchResult.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0000\u0012\u0006\u0010\u0013\u001a\u00020\u000f\u00a2\u0006\u0004\b\u0014\u0010\u0015J\t\u0010\u0003\u001a\u00020\u0002H\u0087\nJ\t\u0010\u0004\u001a\u00020\u0002H\u0087\nJ\t\u0010\u0005\u001a\u00020\u0002H\u0087\nJ\t\u0010\u0006\u001a\u00020\u0002H\u0087\nJ\t\u0010\u0007\u001a\u00020\u0002H\u0087\nJ\t\u0010\b\u001a\u00020\u0002H\u0087\nJ\t\u0010\t\u001a\u00020\u0002H\u0087\nJ\t\u0010\n\u001a\u00020\u0002H\u0087\nJ\t\u0010\u000b\u001a\u00020\u0002H\u0087\nJ\t\u0010\f\u001a\u00020\u0002H\u0087\nJ\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\rR\u0017\u0010\u0013\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lkotlin/text/k$b;", "", "", "a", "c", "d", "e", "f", "g", "h", "i", "j", "b", "", "l", "Lkotlin/text/k;", "Lkotlin/text/k;", "k", "()Lkotlin/text/k;", "match", "<init>", "(Lkotlin/text/k;)V", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class b {
        @NotNull

        /* renamed from: a  reason: collision with root package name */
        private final k f58951a;

        public b(@NotNull k match) {
            f0.p(match, "match");
            this.f58951a = match;
        }

        @InlineOnly
        private final String a() {
            return k().b().get(1);
        }

        @InlineOnly
        private final String b() {
            return k().b().get(10);
        }

        @InlineOnly
        private final String c() {
            return k().b().get(2);
        }

        @InlineOnly
        private final String d() {
            return k().b().get(3);
        }

        @InlineOnly
        private final String e() {
            return k().b().get(4);
        }

        @InlineOnly
        private final String f() {
            return k().b().get(5);
        }

        @InlineOnly
        private final String g() {
            return k().b().get(6);
        }

        @InlineOnly
        private final String h() {
            return k().b().get(7);
        }

        @InlineOnly
        private final String i() {
            return k().b().get(8);
        }

        @InlineOnly
        private final String j() {
            return k().b().get(9);
        }

        @NotNull
        public final k k() {
            return this.f58951a;
        }

        @NotNull
        public final List<String> l() {
            return this.f58951a.b().subList(1, this.f58951a.b().size());
        }
    }

    @NotNull
    b a();

    @NotNull
    List<String> b();

    @NotNull
    kotlin.ranges.k c();

    @NotNull
    i d();

    @NotNull
    String getValue();

    @Nullable
    k next();
}

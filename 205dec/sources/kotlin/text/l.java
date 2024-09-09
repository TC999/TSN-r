package kotlin.text;

import com.acse.ottn.f3;
import java.util.Iterator;
import java.util.List;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.f0;
import kotlin.sequences.SequencesKt___SequencesKt;
import kotlin.text.k;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: Regex.kt */
@Metadata(bv = {}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0007\u00a2\u0006\u0004\b!\u0010\"J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0016R\u0014\u0010\u0006\u001a\u00020\u00038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u0014\u0010\n\u001a\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u001a\u0010\u0010\u001a\u00020\u000b8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0013R\u0014\u0010\u0018\u001a\u00020\u00158BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u001b\u001a\u00020\u00198VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\u001aR\u0014\u0010\u001e\u001a\u00020\u00128VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u001a\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00120\u00118VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\u001f\u00a8\u0006#"}, d2 = {"Lkotlin/text/l;", "Lkotlin/text/k;", "next", "Ljava/util/regex/Matcher;", "a", "Ljava/util/regex/Matcher;", "matcher", "", "b", "Ljava/lang/CharSequence;", "input", "Lkotlin/text/i;", "c", "Lkotlin/text/i;", "d", "()Lkotlin/text/i;", "groups", "", "", "Ljava/util/List;", "groupValues_", "Ljava/util/regex/MatchResult;", "f", "()Ljava/util/regex/MatchResult;", "matchResult", "Lkotlin/ranges/k;", "()Lkotlin/ranges/k;", "range", "getValue", "()Ljava/lang/String;", "value", "()Ljava/util/List;", "groupValues", "<init>", "(Ljava/util/regex/Matcher;Ljava/lang/CharSequence;)V", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class l implements k {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final Matcher f58952a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final CharSequence f58953b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final i f58954c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private List<String> f58955d;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: Regex.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0011\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0096\u0002R\u0014\u0010\b\u001a\u00020\u00038VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\t"}, d2 = {"kotlin/text/l$a", "Lkotlin/collections/c;", "", "", "index", "c", "getSize", "()I", "size", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a extends kotlin.collections.c<String> {
        a() {
        }

        public /* bridge */ boolean a(String str) {
            return super.contains(str);
        }

        @Override // kotlin.collections.c, java.util.List
        @NotNull
        /* renamed from: c */
        public String get(int i4) {
            String group = l.this.f().group(i4);
            return group == null ? "" : group;
        }

        @Override // kotlin.collections.a, java.util.Collection
        public final /* bridge */ boolean contains(Object obj) {
            if (obj instanceof String) {
                return a((String) obj);
            }
            return false;
        }

        public /* bridge */ int g(String str) {
            return super.indexOf(str);
        }

        @Override // kotlin.collections.c, kotlin.collections.a
        public int getSize() {
            return l.this.f().groupCount() + 1;
        }

        @Override // kotlin.collections.c, java.util.List
        public final /* bridge */ int indexOf(Object obj) {
            if (obj instanceof String) {
                return g((String) obj);
            }
            return -1;
        }

        public /* bridge */ int k(String str) {
            return super.lastIndexOf(str);
        }

        @Override // kotlin.collections.c, java.util.List
        public final /* bridge */ int lastIndexOf(Object obj) {
            if (obj instanceof String) {
                return k((String) obj);
            }
            return -1;
        }
    }

    public l(@NotNull Matcher matcher, @NotNull CharSequence input) {
        f0.p(matcher, "matcher");
        f0.p(input, "input");
        this.f58952a = matcher;
        this.f58953b = input;
        this.f58954c = new b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final MatchResult f() {
        return this.f58952a;
    }

    @Override // kotlin.text.k
    @NotNull
    public k.b a() {
        return k.a.a(this);
    }

    @Override // kotlin.text.k
    @NotNull
    public List<String> b() {
        if (this.f58955d == null) {
            this.f58955d = new a();
        }
        List<String> list = this.f58955d;
        f0.m(list);
        return list;
    }

    @Override // kotlin.text.k
    @NotNull
    public kotlin.ranges.k c() {
        kotlin.ranges.k i4;
        i4 = RegexKt.i(f());
        return i4;
    }

    @Override // kotlin.text.k
    @NotNull
    public i d() {
        return this.f58954c;
    }

    @Override // kotlin.text.k
    @NotNull
    public String getValue() {
        String group = f().group();
        f0.o(group, "matchResult.group()");
        return group;
    }

    @Override // kotlin.text.k
    @Nullable
    public k next() {
        k f4;
        int end = f().end() + (f().end() == f().start() ? 1 : 0);
        if (end <= this.f58953b.length()) {
            Matcher matcher = this.f58952a.pattern().matcher(this.f58953b);
            f0.o(matcher, "matcher.pattern().matcher(input)");
            f4 = RegexKt.f(matcher, end, this.f58953b);
            return f4;
        }
        return null;
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: Regex.kt */
    @Metadata(bv = {}, d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010(\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u00012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u0011\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0006H\u0096\u0002J\u0013\u0010\n\u001a\u0004\u0018\u00010\u00032\u0006\u0010\t\u001a\u00020\bH\u0096\u0002J\u0013\u0010\n\u001a\u0004\u0018\u00010\u00032\u0006\u0010\f\u001a\u00020\u000bH\u0096\u0002R\u0014\u0010\u000f\u001a\u00020\b8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0010"}, d2 = {"kotlin/text/l$b", "Lkotlin/text/j;", "Lkotlin/collections/a;", "Lkotlin/text/h;", "", "isEmpty", "", "iterator", "", "index", f3.f5657f, "", "name", "getSize", "()I", "size", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class b extends kotlin.collections.a<h> implements j {

        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
        /* compiled from: Regex.kt */
        @Metadata(bv = {}, d1 = {"\u0000\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "it", "Lkotlin/text/h;", "a", "(I)Lkotlin/text/h;"}, k = 3, mv = {1, 6, 0})
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        static final class a extends Lambda implements d2.l<Integer, h> {
            a() {
                super(1);
            }

            @Nullable
            public final h a(int i4) {
                return b.this.get(i4);
            }

            @Override // d2.l
            public /* bridge */ /* synthetic */ h invoke(Integer num) {
                return a(num.intValue());
            }
        }

        b() {
        }

        public /* bridge */ boolean a(h hVar) {
            return super.contains(hVar);
        }

        @Override // kotlin.collections.a, java.util.Collection
        public final /* bridge */ boolean contains(Object obj) {
            if (obj == null ? true : obj instanceof h) {
                return a((h) obj);
            }
            return false;
        }

        @Override // kotlin.text.i
        @Nullable
        public h get(int i4) {
            kotlin.ranges.k j4;
            j4 = RegexKt.j(l.this.f(), i4);
            if (j4.getStart().intValue() >= 0) {
                String group = l.this.f().group(i4);
                f0.o(group, "matchResult.group(index)");
                return new h(group, j4);
            }
            return null;
        }

        @Override // kotlin.collections.a
        public int getSize() {
            return l.this.f().groupCount() + 1;
        }

        @Override // kotlin.collections.a, java.util.Collection
        public boolean isEmpty() {
            return false;
        }

        @Override // kotlin.collections.a, java.util.Collection, java.lang.Iterable
        @NotNull
        public Iterator<h> iterator() {
            kotlin.ranges.k G;
            kotlin.sequences.m l12;
            kotlin.sequences.m d12;
            G = CollectionsKt__CollectionsKt.G(this);
            l12 = kotlin.collections.f0.l1(G);
            d12 = SequencesKt___SequencesKt.d1(l12, new a());
            return d12.iterator();
        }

        @Override // kotlin.text.j
        @Nullable
        public h get(@NotNull String name) {
            f0.p(name, "name");
            return kotlin.internal.b.f55545a.c(l.this.f(), name);
        }
    }
}

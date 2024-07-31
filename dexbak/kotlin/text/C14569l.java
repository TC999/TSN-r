package kotlin.text;

import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import java.util.Iterator;
import java.util.List;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import kotlin.Metadata;
import kotlin.collections.AbstractCollection;
import kotlin.collections.AbstractList;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections._Collections;
import kotlin.internal.C14307b;
import kotlin.jvm.internal.C14342f0;
import kotlin.jvm.internal.Lambda;
import kotlin.ranges.C14413k;
import kotlin.sequences.Sequence;
import kotlin.sequences._Sequences;
import kotlin.text.InterfaceC14566k;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p617l1.InterfaceC15280l;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Regex.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0011\u001a\u00020\u000e\u0012\u0006\u0010\u0014\u001a\u00020\u0012¢\u0006\u0004\b!\u0010\"J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0016R\u001a\u0010\b\u001a\u00020\u00038\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\u0011\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0014\u001a\u00020\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0013R\u0014\u0010\u0018\u001a\u00020\u00158BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u001b\u001a\u00020\u00198VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u001aR\u0014\u0010\u001e\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u001a\u0010 \u001a\b\u0012\u0004\u0012\u00020\n0\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u001f¨\u0006#"}, m12616d2 = {"Lkotlin/text/l;", "Lkotlin/text/k;", "next", "Lkotlin/text/i;", "a", "Lkotlin/text/i;", "d", "()Lkotlin/text/i;", "groups", "", "", "b", "Ljava/util/List;", "groupValues_", "Ljava/util/regex/Matcher;", "c", "Ljava/util/regex/Matcher;", "matcher", "", "Ljava/lang/CharSequence;", "input", "Ljava/util/regex/MatchResult;", "f", "()Ljava/util/regex/MatchResult;", "matchResult", "Lkotlin/ranges/k;", "()Lkotlin/ranges/k;", "range", "getValue", "()Ljava/lang/String;", DomainCampaignEx.LOOPBACK_VALUE, "()Ljava/util/List;", "groupValues", "<init>", "(Ljava/util/regex/Matcher;Ljava/lang/CharSequence;)V", "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: kotlin.text.l */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class C14569l implements InterfaceC14566k {
    @NotNull

    /* renamed from: a */
    private final MatchResult f41614a;

    /* renamed from: b */
    private List<String> f41615b;

    /* renamed from: c */
    private final Matcher f41616c;

    /* renamed from: d */
    private final CharSequence f41617d;

    /* compiled from: Regex.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0011\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0096\u0002R\u0014\u0010\b\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, m12616d2 = {"kotlin/text/l$a", "Lkotlin/collections/d;", "", "", "index", "c", "getSize", "()I", "size", "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
    /* renamed from: kotlin.text.l$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C14570a extends AbstractList<String> {
        C14570a() {
        }

        /* renamed from: a */
        public /* bridge */ boolean m6787a(String str) {
            return super.contains(str);
        }

        @Override // kotlin.collections.AbstractList, java.util.List
        @NotNull
        /* renamed from: c */
        public String get(int i) {
            String group = C14569l.this.m6788f().group(i);
            return group != null ? group : "";
        }

        @Override // kotlin.collections.AbstractCollection, java.util.Collection
        public final /* bridge */ boolean contains(Object obj) {
            if (obj instanceof String) {
                return m6787a((String) obj);
            }
            return false;
        }

        /* renamed from: d */
        public /* bridge */ int m6785d(String str) {
            return super.indexOf(str);
        }

        /* renamed from: e */
        public /* bridge */ int m6784e(String str) {
            return super.lastIndexOf(str);
        }

        @Override // kotlin.collections.AbstractList, kotlin.collections.AbstractCollection
        public int getSize() {
            return C14569l.this.m6788f().groupCount() + 1;
        }

        @Override // kotlin.collections.AbstractList, java.util.List
        public final /* bridge */ int indexOf(Object obj) {
            if (obj instanceof String) {
                return m6785d((String) obj);
            }
            return -1;
        }

        @Override // kotlin.collections.AbstractList, java.util.List
        public final /* bridge */ int lastIndexOf(Object obj) {
            if (obj instanceof String) {
                return m6784e((String) obj);
            }
            return -1;
        }
    }

    public C14569l(@NotNull Matcher matcher, @NotNull CharSequence input) {
        C14342f0.m8184p(matcher, "matcher");
        C14342f0.m8184p(input, "input");
        this.f41616c = matcher;
        this.f41617d = input;
        this.f41614a = new C14571b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public final MatchResult m6788f() {
        return this.f41616c;
    }

    @Override // kotlin.text.InterfaceC14566k
    @NotNull
    /* renamed from: a */
    public InterfaceC14566k.C14568b mo6793a() {
        return InterfaceC14566k.C14567a.m6806a(this);
    }

    @Override // kotlin.text.InterfaceC14566k
    @NotNull
    /* renamed from: b */
    public List<String> mo6792b() {
        if (this.f41615b == null) {
            this.f41615b = new C14570a();
        }
        List<String> list = this.f41615b;
        C14342f0.m8187m(list);
        return list;
    }

    @Override // kotlin.text.InterfaceC14566k
    @NotNull
    /* renamed from: c */
    public C14413k mo6791c() {
        C14413k m6900j;
        m6900j = RegexKt.m6900j(m6788f());
        return m6900j;
    }

    @Override // kotlin.text.InterfaceC14566k
    @NotNull
    /* renamed from: d */
    public MatchResult mo6790d() {
        return this.f41614a;
    }

    @Override // kotlin.text.InterfaceC14566k
    @NotNull
    public String getValue() {
        String group = m6788f().group();
        C14342f0.m8185o(group, "matchResult.group()");
        return group;
    }

    @Override // kotlin.text.InterfaceC14566k
    @Nullable
    public InterfaceC14566k next() {
        InterfaceC14566k m6903g;
        int end = m6788f().end() + (m6788f().end() == m6788f().start() ? 1 : 0);
        if (end <= this.f41617d.length()) {
            Matcher matcher = this.f41616c.pattern().matcher(this.f41617d);
            C14342f0.m8185o(matcher, "matcher.pattern().matcher(input)");
            m6903g = RegexKt.m6903g(matcher, end, this.f41617d);
            return m6903g;
        }
        return null;
    }

    /* compiled from: Regex.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010(\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u00012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u0011\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0006H\u0096\u0002J\u0013\u0010\n\u001a\u0004\u0018\u00010\u00032\u0006\u0010\t\u001a\u00020\bH\u0096\u0002J\u0013\u0010\n\u001a\u0004\u0018\u00010\u00032\u0006\u0010\f\u001a\u00020\u000bH\u0096\u0002R\u0014\u0010\u000f\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e¨\u0006\u0010"}, m12616d2 = {"kotlin/text/l$b", "Lkotlin/text/j;", "Lkotlin/collections/a;", "Lkotlin/text/h;", "", "isEmpty", "", "iterator", "", "index", "get", "", "name", "getSize", "()I", "size", "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
    /* renamed from: kotlin.text.l$b */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C14571b extends AbstractCollection<C14564h> implements InterfaceC14565j {

        /* compiled from: Regex.kt */
        @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, m12616d2 = {"", "it", "Lkotlin/text/h;", "a", "(I)Lkotlin/text/h;"}, m12615k = 3, m12614mv = {1, 5, 1})
        /* renamed from: kotlin.text.l$b$a */
        /* loaded from: E:\fuckcool\tsn\5406560.dex */
        static final class C14572a extends Lambda implements InterfaceC15280l<Integer, C14564h> {
            C14572a() {
                super(1);
            }

            @Nullable
            /* renamed from: a */
            public final C14564h m6782a(int i) {
                return C14571b.this.get(i);
            }

            @Override // p617l1.InterfaceC15280l
            public /* bridge */ /* synthetic */ C14564h invoke(Integer num) {
                return m6782a(num.intValue());
            }
        }

        C14571b() {
        }

        /* renamed from: a */
        public /* bridge */ boolean m6783a(C14564h c14564h) {
            return super.contains(c14564h);
        }

        @Override // kotlin.collections.AbstractCollection, java.util.Collection
        public final /* bridge */ boolean contains(Object obj) {
            if (obj != null ? obj instanceof C14564h : true) {
                return m6783a((C14564h) obj);
            }
            return false;
        }

        @Override // kotlin.text.MatchResult
        @Nullable
        public C14564h get(int i) {
            C14413k m6899k;
            m6899k = RegexKt.m6899k(C14569l.this.m6788f(), i);
            if (m6899k.getStart().intValue() >= 0) {
                String group = C14569l.this.m6788f().group(i);
                C14342f0.m8185o(group, "matchResult.group(index)");
                return new C14564h(group, m6899k);
            }
            return null;
        }

        @Override // kotlin.collections.AbstractCollection
        public int getSize() {
            return C14569l.this.m6788f().groupCount() + 1;
        }

        @Override // kotlin.collections.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return false;
        }

        @Override // kotlin.collections.AbstractCollection, java.util.Collection, java.lang.Iterable
        @NotNull
        public Iterator<C14564h> iterator() {
            C14413k m12477F;
            Sequence m12090n1;
            Sequence m7159d1;
            m12477F = CollectionsKt__CollectionsKt.m12477F(this);
            m12090n1 = _Collections.m12090n1(m12477F);
            m7159d1 = _Sequences.m7159d1(m12090n1, new C14572a());
            return m7159d1.iterator();
        }

        @Override // kotlin.text.InterfaceC14565j
        @Nullable
        public C14564h get(@NotNull String name) {
            C14342f0.m8184p(name, "name");
            return C14307b.f41062a.mo8536c(C14569l.this.m6788f(), name);
        }
    }
}

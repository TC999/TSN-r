package kotlin.text;

import com.kuaishou.weapon.p205p0.C7304t;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import java.util.List;
import kotlin.Metadata;
import kotlin.internal.InlineOnly;
import kotlin.jvm.internal.C14342f0;
import kotlin.ranges.C14413k;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: MatchResult.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0001\u0010J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0000H&R\u0014\u0010\u0006\u001a\u00020\u00038&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\n\u001a\u00020\u00078&X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0014\u0010\u000e\u001a\u00020\u000b8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00070\u000f8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0016\u001a\u00020\u00138VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, m12616d2 = {"Lkotlin/text/k;", "", "next", "Lkotlin/ranges/k;", "c", "()Lkotlin/ranges/k;", "range", "", "getValue", "()Ljava/lang/String;", DomainCampaignEx.LOOPBACK_VALUE, "Lkotlin/text/i;", "d", "()Lkotlin/text/i;", "groups", "", "b", "()Ljava/util/List;", "groupValues", "Lkotlin/text/k$b;", "a", "()Lkotlin/text/k$b;", "destructured", "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: kotlin.text.k */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public interface InterfaceC14566k {

    /* compiled from: MatchResult.kt */
    @Metadata(m12615k = 3, m12614mv = {1, 5, 1})
    /* renamed from: kotlin.text.k$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C14567a {
        @NotNull
        /* renamed from: a */
        public static C14568b m6806a(@NotNull InterfaceC14566k interfaceC14566k) {
            return new C14568b(interfaceC14566k);
        }
    }

    /* compiled from: MatchResult.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0000\u0012\u0006\u0010\u0013\u001a\u00020\u000f¢\u0006\u0004\b\u0014\u0010\u0015J\t\u0010\u0003\u001a\u00020\u0002H\u0087\nJ\t\u0010\u0004\u001a\u00020\u0002H\u0087\nJ\t\u0010\u0005\u001a\u00020\u0002H\u0087\nJ\t\u0010\u0006\u001a\u00020\u0002H\u0087\nJ\t\u0010\u0007\u001a\u00020\u0002H\u0087\nJ\t\u0010\b\u001a\u00020\u0002H\u0087\nJ\t\u0010\t\u001a\u00020\u0002H\u0087\nJ\t\u0010\n\u001a\u00020\u0002H\u0087\nJ\t\u0010\u000b\u001a\u00020\u0002H\u0087\nJ\t\u0010\f\u001a\u00020\u0002H\u0087\nJ\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\rR\u0017\u0010\u0013\u001a\u00020\u000f8\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, m12616d2 = {"Lkotlin/text/k$b;", "", "", "a", "c", "d", "e", "f", "g", "h", "i", "j", "b", "", C7304t.f25048d, "Lkotlin/text/k;", "Lkotlin/text/k;", "k", "()Lkotlin/text/k;", "match", "<init>", "(Lkotlin/text/k;)V", "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
    /* renamed from: kotlin.text.k$b */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C14568b {
        @NotNull

        /* renamed from: a */
        private final InterfaceC14566k f41613a;

        public C14568b(@NotNull InterfaceC14566k match) {
            C14342f0.m8184p(match, "match");
            this.f41613a = match;
        }

        @InlineOnly
        /* renamed from: a */
        private final String m6805a() {
            return m6795k().mo6792b().get(1);
        }

        @InlineOnly
        /* renamed from: b */
        private final String m6804b() {
            return m6795k().mo6792b().get(10);
        }

        @InlineOnly
        /* renamed from: c */
        private final String m6803c() {
            return m6795k().mo6792b().get(2);
        }

        @InlineOnly
        /* renamed from: d */
        private final String m6802d() {
            return m6795k().mo6792b().get(3);
        }

        @InlineOnly
        /* renamed from: e */
        private final String m6801e() {
            return m6795k().mo6792b().get(4);
        }

        @InlineOnly
        /* renamed from: f */
        private final String m6800f() {
            return m6795k().mo6792b().get(5);
        }

        @InlineOnly
        /* renamed from: g */
        private final String m6799g() {
            return m6795k().mo6792b().get(6);
        }

        @InlineOnly
        /* renamed from: h */
        private final String m6798h() {
            return m6795k().mo6792b().get(7);
        }

        @InlineOnly
        /* renamed from: i */
        private final String m6797i() {
            return m6795k().mo6792b().get(8);
        }

        @InlineOnly
        /* renamed from: j */
        private final String m6796j() {
            return m6795k().mo6792b().get(9);
        }

        @NotNull
        /* renamed from: k */
        public final InterfaceC14566k m6795k() {
            return this.f41613a;
        }

        @NotNull
        /* renamed from: l */
        public final List<String> m6794l() {
            return this.f41613a.mo6792b().subList(1, this.f41613a.mo6792b().size());
        }
    }

    @NotNull
    /* renamed from: a */
    C14568b mo6793a();

    @NotNull
    /* renamed from: b */
    List<String> mo6792b();

    @NotNull
    /* renamed from: c */
    C14413k mo6791c();

    @NotNull
    /* renamed from: d */
    MatchResult mo6790d();

    @NotNull
    String getValue();

    @Nullable
    InterfaceC14566k next();
}

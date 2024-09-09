package kotlin.text;

import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.f0;
import kotlin.sequences.SequencesKt___SequencesKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: Indent.kt */
@Metadata(bv = {}, d1 = {"\u0000 \n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0006\u001a\u0014\u0010\u0002\u001a\u00020\u0000*\u00020\u00002\b\b\u0002\u0010\u0001\u001a\u00020\u0000\u001a\u001e\u0010\u0004\u001a\u00020\u0000*\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00002\b\b\u0002\u0010\u0001\u001a\u00020\u0000\u001a\n\u0010\u0005\u001a\u00020\u0000*\u00020\u0000\u001a\u0014\u0010\u0006\u001a\u00020\u0000*\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0000\u001a\u0014\u0010\b\u001a\u00020\u0000*\u00020\u00002\b\b\u0002\u0010\u0007\u001a\u00020\u0000\u001a\u0013\u0010\n\u001a\u00020\t*\u00020\u0000H\u0002\u00a2\u0006\u0004\b\n\u0010\u000b\u001a#\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00000\f2\u0006\u0010\u0007\u001a\u00020\u0000H\u0002\u00a2\u0006\u0004\b\r\u0010\u000e\u001aL\u0010\u0013\u001a\u00020\u0000*\b\u0012\u0004\u0012\u00020\u00000\u000f2\u0006\u0010\u0010\u001a\u00020\t2\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00000\f2\u0014\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u00000\fH\u0082\b\u00a2\u0006\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0015"}, d2 = {"", "marginPrefix", CampaignEx.JSON_KEY_AD_Q, "newIndent", "n", "p", "l", "indent", "i", "", "h", "(Ljava/lang/String;)I", "Lkotlin/Function1;", "g", "(Ljava/lang/String;)Ld2/l;", "", "resultSizeEstimate", "indentAddFunction", "indentCutFunction", "k", "(Ljava/util/List;ILd2/l;Ld2/l;)Ljava/lang/String;", "kotlin-stdlib"}, k = 5, mv = {1, 6, 0}, xs = "kotlin/text/StringsKt")
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class p extends o {

    /* compiled from: Indent.kt */
    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0003\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\n\u00a2\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"", "line", "a", "(Ljava/lang/String;)Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a extends Lambda implements d2.l<String, String> {

        /* renamed from: a */
        public static final a f58961a = new a();

        a() {
            super(1);
        }

        @Override // d2.l
        @NotNull
        /* renamed from: a */
        public final String invoke(@NotNull String line) {
            f0.p(line, "line");
            return line;
        }
    }

    /* compiled from: Indent.kt */
    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0003\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\n\u00a2\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"", "line", "a", "(Ljava/lang/String;)Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class b extends Lambda implements d2.l<String, String> {

        /* renamed from: a */
        final /* synthetic */ String f58962a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(String str) {
            super(1);
            this.f58962a = str;
        }

        @Override // d2.l
        @NotNull
        /* renamed from: a */
        public final String invoke(@NotNull String line) {
            f0.p(line, "line");
            return f0.C(this.f58962a, line);
        }
    }

    /* compiled from: Indent.kt */
    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0003\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\n\u00a2\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"", "it", "a", "(Ljava/lang/String;)Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class c extends Lambda implements d2.l<String, String> {

        /* renamed from: a */
        final /* synthetic */ String f58963a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(String str) {
            super(1);
            this.f58963a = str;
        }

        @Override // d2.l
        @NotNull
        /* renamed from: a */
        public final String invoke(@NotNull String it) {
            f0.p(it, "it");
            if (w.U1(it)) {
                return it.length() < this.f58963a.length() ? this.f58963a : it;
            }
            return f0.C(this.f58963a, it);
        }
    }

    private static final d2.l<String, String> g(String str) {
        return str.length() == 0 ? a.f58961a : new b(str);
    }

    private static final int h(String str) {
        boolean r3;
        int length = str.length();
        int i4 = 0;
        while (true) {
            if (i4 >= length) {
                i4 = -1;
                break;
            }
            int i5 = i4 + 1;
            r3 = kotlin.text.b.r(str.charAt(i4));
            if (!r3) {
                break;
            }
            i4 = i5;
        }
        return i4 == -1 ? str.length() : i4;
    }

    @NotNull
    public static final String i(@NotNull String str, @NotNull String indent) {
        kotlin.sequences.m d12;
        String X0;
        f0.p(str, "<this>");
        f0.p(indent, "indent");
        d12 = SequencesKt___SequencesKt.d1(x.K3(str), new c(indent));
        X0 = SequencesKt___SequencesKt.X0(d12, "\n", null, null, 0, null, null, 62, null);
        return X0;
    }

    public static /* synthetic */ String j(String str, String str2, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            str2 = "    ";
        }
        return i(str, str2);
    }

    private static final String k(List<String> list, int i4, d2.l<? super String, String> lVar, d2.l<? super String, String> lVar2) {
        int H;
        Appendable V2;
        H = CollectionsKt__CollectionsKt.H(list);
        ArrayList arrayList = new ArrayList();
        int i5 = 0;
        for (Object obj : list) {
            int i6 = i5 + 1;
            if (i5 < 0) {
                CollectionsKt__CollectionsKt.X();
            }
            String str = (String) obj;
            if ((i5 == 0 || i5 == H) && w.U1(str)) {
                str = null;
            } else {
                String invoke = lVar2.invoke(str);
                if (invoke != null) {
                    str = lVar.invoke(invoke);
                }
            }
            if (str != null) {
                arrayList.add(str);
            }
            i5 = i6;
        }
        V2 = kotlin.collections.f0.V2(arrayList, new StringBuilder(i4), "\n", null, null, 0, null, null, 124, null);
        String sb = ((StringBuilder) V2).toString();
        f0.o(sb, "mapIndexedNotNull { inde\u2026\"\\n\")\n        .toString()");
        return sb;
    }

    @NotNull
    public static final String l(@NotNull String str, @NotNull String newIndent) {
        int Z;
        Comparable V3;
        int H;
        Appendable V2;
        String u6;
        f0.p(str, "<this>");
        f0.p(newIndent, "newIndent");
        List<String> L3 = x.L3(str);
        ArrayList<String> arrayList = new ArrayList();
        for (Object obj : L3) {
            if (!w.U1((String) obj)) {
                arrayList.add(obj);
            }
        }
        Z = kotlin.collections.y.Z(arrayList, 10);
        ArrayList arrayList2 = new ArrayList(Z);
        for (String str2 : arrayList) {
            arrayList2.add(Integer.valueOf(h(str2)));
        }
        V3 = kotlin.collections.f0.V3(arrayList2);
        Integer num = (Integer) V3;
        int i4 = 0;
        int intValue = num == null ? 0 : num.intValue();
        int length = str.length() + (newIndent.length() * L3.size());
        d2.l<String, String> g4 = g(newIndent);
        H = CollectionsKt__CollectionsKt.H(L3);
        ArrayList arrayList3 = new ArrayList();
        for (Object obj2 : L3) {
            int i5 = i4 + 1;
            if (i4 < 0) {
                CollectionsKt__CollectionsKt.X();
            }
            String str3 = (String) obj2;
            if ((i4 == 0 || i4 == H) && w.U1(str3)) {
                str3 = null;
            } else {
                u6 = z.u6(str3, intValue);
                if (u6 != null) {
                    str3 = g4.invoke(u6);
                }
            }
            if (str3 != null) {
                arrayList3.add(str3);
            }
            i4 = i5;
        }
        V2 = kotlin.collections.f0.V2(arrayList3, new StringBuilder(length), "\n", null, null, 0, null, null, 124, null);
        String sb = ((StringBuilder) V2).toString();
        f0.o(sb, "mapIndexedNotNull { inde\u2026\"\\n\")\n        .toString()");
        return sb;
    }

    public static /* synthetic */ String m(String str, String str2, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            str2 = "";
        }
        return l(str, str2);
    }

    @NotNull
    public static final String n(@NotNull String str, @NotNull String newIndent, @NotNull String marginPrefix) {
        int H;
        Appendable V2;
        int i4;
        boolean t22;
        boolean r3;
        f0.p(str, "<this>");
        f0.p(newIndent, "newIndent");
        f0.p(marginPrefix, "marginPrefix");
        if (!w.U1(marginPrefix)) {
            List<String> L3 = x.L3(str);
            int length = str.length() + (newIndent.length() * L3.size());
            d2.l<String, String> g4 = g(newIndent);
            H = CollectionsKt__CollectionsKt.H(L3);
            ArrayList arrayList = new ArrayList();
            int i5 = 0;
            for (Object obj : L3) {
                int i6 = i5 + 1;
                if (i5 < 0) {
                    CollectionsKt__CollectionsKt.X();
                }
                String str2 = (String) obj;
                String str3 = null;
                if ((i5 == 0 || i5 == H) && w.U1(str2)) {
                    str2 = null;
                } else {
                    int length2 = str2.length();
                    int i7 = 0;
                    while (true) {
                        if (i7 >= length2) {
                            i4 = -1;
                            break;
                        }
                        int i8 = i7 + 1;
                        r3 = kotlin.text.b.r(str2.charAt(i7));
                        if (!r3) {
                            i4 = i7;
                            break;
                        }
                        i7 = i8;
                    }
                    if (i4 != -1) {
                        int i9 = i4;
                        t22 = w.t2(str2, marginPrefix, i4, false, 4, null);
                        if (t22) {
                            str3 = str2.substring(i9 + marginPrefix.length());
                            f0.o(str3, "this as java.lang.String).substring(startIndex)");
                        }
                    }
                    if (str3 != null) {
                        str2 = g4.invoke(str3);
                    }
                }
                if (str2 != null) {
                    arrayList.add(str2);
                }
                i5 = i6;
            }
            V2 = kotlin.collections.f0.V2(arrayList, new StringBuilder(length), "\n", null, null, 0, null, null, 124, null);
            String sb = ((StringBuilder) V2).toString();
            f0.o(sb, "mapIndexedNotNull { inde\u2026\"\\n\")\n        .toString()");
            return sb;
        }
        throw new IllegalArgumentException("marginPrefix must be non-blank string.".toString());
    }

    public static /* synthetic */ String o(String str, String str2, String str3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            str2 = "";
        }
        if ((i4 & 2) != 0) {
            str3 = "|";
        }
        return n(str, str2, str3);
    }

    @NotNull
    public static String p(@NotNull String str) {
        f0.p(str, "<this>");
        return l(str, "");
    }

    @NotNull
    public static final String q(@NotNull String str, @NotNull String marginPrefix) {
        f0.p(str, "<this>");
        f0.p(marginPrefix, "marginPrefix");
        return n(str, "", marginPrefix);
    }

    public static /* synthetic */ String r(String str, String str2, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            str2 = "|";
        }
        return q(str, str2);
    }
}

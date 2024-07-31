package kotlin.text;

import com.kuaishou.weapon.p205p0.C7304t;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.snail.antifake.deviceid.ShellAdbUtils;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.C14236x;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections._Collections;
import kotlin.internal.C14307b;
import kotlin.jvm.internal.C14342f0;
import kotlin.jvm.internal.Lambda;
import kotlin.sequences.Sequence;
import kotlin.sequences._Sequences;
import org.jetbrains.annotations.NotNull;
import p617l1.InterfaceC15280l;

@Metadata(m12618bv = {}, m12617d1 = {"\u0000 \n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0006\u001a\u0014\u0010\u0002\u001a\u00020\u0000*\u00020\u00002\b\b\u0002\u0010\u0001\u001a\u00020\u0000\u001a\u001e\u0010\u0004\u001a\u00020\u0000*\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00002\b\b\u0002\u0010\u0001\u001a\u00020\u0000\u001a\n\u0010\u0005\u001a\u00020\u0000*\u00020\u0000\u001a\u0014\u0010\u0006\u001a\u00020\u0000*\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0000\u001a\u0014\u0010\b\u001a\u00020\u0000*\u00020\u00002\b\b\u0002\u0010\u0007\u001a\u00020\u0000\u001a\u0013\u0010\n\u001a\u00020\t*\u00020\u0000H\u0002¢\u0006\u0004\b\n\u0010\u000b\u001a#\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00000\f2\u0006\u0010\u0007\u001a\u00020\u0000H\u0002¢\u0006\u0004\b\r\u0010\u000e\u001aL\u0010\u0013\u001a\u00020\u0000*\b\u0012\u0004\u0012\u00020\u00000\u000f2\u0006\u0010\u0010\u001a\u00020\t2\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00000\f2\u0014\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u00000\fH\u0082\b¢\u0006\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, m12616d2 = {"", "marginPrefix", CampaignEx.JSON_KEY_AD_Q, "newIndent", "n", "p", C7304t.f25048d, "indent", "i", "", "h", "(Ljava/lang/String;)I", "Lkotlin/Function1;", "g", "(Ljava/lang/String;)Ll1/l;", "", "resultSizeEstimate", "indentAddFunction", "indentCutFunction", "k", "(Ljava/util/List;ILl1/l;Ll1/l;)Ljava/lang/String;", "kotlin-stdlib"}, m12615k = 5, m12614mv = {1, 5, 1}, m12611xs = "kotlin/text/StringsKt")
/* renamed from: kotlin.text.p */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public class Indent extends Appendable {

    /* compiled from: Indent.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0003\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, m12616d2 = {"", "line", "a", "(Ljava/lang/String;)Ljava/lang/String;"}, m12615k = 3, m12614mv = {1, 5, 1})
    /* renamed from: kotlin.text.p$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C14574a extends Lambda implements InterfaceC15280l<String, String> {

        /* renamed from: a */
        public static final C14574a f41623a = new C14574a();

        C14574a() {
            super(1);
        }

        @Override // p617l1.InterfaceC15280l
        @NotNull
        /* renamed from: a */
        public final String invoke(@NotNull String line) {
            C14342f0.m8184p(line, "line");
            return line;
        }
    }

    /* compiled from: Indent.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0003\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, m12616d2 = {"", "line", "a", "(Ljava/lang/String;)Ljava/lang/String;"}, m12615k = 3, m12614mv = {1, 5, 1})
    /* renamed from: kotlin.text.p$b */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C14575b extends Lambda implements InterfaceC15280l<String, String> {

        /* renamed from: a */
        final /* synthetic */ String f41624a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C14575b(String str) {
            super(1);
            this.f41624a = str;
        }

        @Override // p617l1.InterfaceC15280l
        @NotNull
        /* renamed from: a */
        public final String invoke(@NotNull String line) {
            C14342f0.m8184p(line, "line");
            return this.f41624a + line;
        }
    }

    /* compiled from: Indent.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0003\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, m12616d2 = {"", "it", "a", "(Ljava/lang/String;)Ljava/lang/String;"}, m12615k = 3, m12614mv = {1, 5, 1})
    /* renamed from: kotlin.text.p$c */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C14576c extends Lambda implements InterfaceC15280l<String, String> {

        /* renamed from: a */
        final /* synthetic */ String f41625a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C14576c(String str) {
            super(1);
            this.f41625a = str;
        }

        @Override // p617l1.InterfaceC15280l
        @NotNull
        /* renamed from: a */
        public final String invoke(@NotNull String it) {
            C14342f0.m8184p(it, "it");
            if (StringsJVM.m6592U1(it)) {
                return it.length() < this.f41625a.length() ? this.f41625a : it;
            }
            return this.f41625a + it;
        }
    }

    /* renamed from: g */
    private static final InterfaceC15280l<String, String> m6728g(String str) {
        return str.length() == 0 ? C14574a.f41623a : new C14575b(str);
    }

    /* renamed from: h */
    private static final int m6727h(String str) {
        int length = str.length();
        int i = 0;
        while (true) {
            if (i >= length) {
                i = -1;
                break;
            } else if (!CharJVM.m6876r(str.charAt(i))) {
                break;
            } else {
                i++;
            }
        }
        return i == -1 ? str.length() : i;
    }

    @NotNull
    /* renamed from: i */
    public static final String m6726i(@NotNull String prependIndent, @NotNull String indent) {
        Sequence m7159d1;
        String m7183X0;
        C14342f0.m8184p(prependIndent, "$this$prependIndent");
        C14342f0.m8184p(indent, "indent");
        m7159d1 = _Sequences.m7159d1(C14579x.m6507K3(prependIndent), new C14576c(indent));
        m7183X0 = _Sequences.m7183X0(m7159d1, ShellAdbUtils.f33810d, null, null, 0, null, null, 62, null);
        return m7183X0;
    }

    /* renamed from: j */
    public static /* synthetic */ String m6725j(String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str2 = "    ";
        }
        return m6726i(str, str2);
    }

    /* renamed from: k */
    private static final String m6724k(List<String> list, int i, InterfaceC15280l<? super String, String> interfaceC15280l, InterfaceC15280l<? super String, String> interfaceC15280l2) {
        int m12476G;
        Appendable m12161X2;
        String str;
        String invoke;
        m12476G = CollectionsKt__CollectionsKt.m12476G(list);
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        for (Object obj : list) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                if (!C14307b.m8534a(1, 3, 0)) {
                    throw new ArithmeticException("Index overflow has happened.");
                }
                CollectionsKt__CollectionsKt.m12460W();
            }
            String str2 = (String) obj;
            if ((i2 == 0 || i2 == m12476G) && StringsJVM.m6592U1(str2)) {
                str = null;
            } else {
                String invoke2 = interfaceC15280l2.invoke(str2);
                if (invoke2 != null && (invoke = interfaceC15280l.invoke(invoke2)) != null) {
                    str2 = invoke;
                }
                str = str2;
            }
            if (str != null) {
                arrayList.add(str);
            }
            i2 = i3;
        }
        m12161X2 = _Collections.m12161X2(arrayList, new StringBuilder(i), ShellAdbUtils.f33810d, null, null, 0, null, null, 124, null);
        String sb = ((StringBuilder) m12161X2).toString();
        C14342f0.m8185o(sb, "mapIndexedNotNull { inde…\"\\n\")\n        .toString()");
        return sb;
    }

    @NotNull
    /* renamed from: l */
    public static final String m6723l(@NotNull String replaceIndent, @NotNull String newIndent) {
        int m8957Y;
        Comparable m12160X3;
        int m12476G;
        Appendable m12161X2;
        String str;
        String m6208u6;
        String invoke;
        C14342f0.m8184p(replaceIndent, "$this$replaceIndent");
        C14342f0.m8184p(newIndent, "newIndent");
        List<String> m6504L3 = C14579x.m6504L3(replaceIndent);
        ArrayList<String> arrayList = new ArrayList();
        for (Object obj : m6504L3) {
            if (!StringsJVM.m6592U1((String) obj)) {
                arrayList.add(obj);
            }
        }
        m8957Y = C14236x.m8957Y(arrayList, 10);
        ArrayList arrayList2 = new ArrayList(m8957Y);
        for (String str2 : arrayList) {
            arrayList2.add(Integer.valueOf(m6727h(str2)));
        }
        m12160X3 = _Collections.m12160X3(arrayList2);
        Integer num = (Integer) m12160X3;
        int i = 0;
        int intValue = num != null ? num.intValue() : 0;
        int length = replaceIndent.length() + (newIndent.length() * m6504L3.size());
        InterfaceC15280l<String, String> m6728g = m6728g(newIndent);
        m12476G = CollectionsKt__CollectionsKt.m12476G(m6504L3);
        ArrayList arrayList3 = new ArrayList();
        for (Object obj2 : m6504L3) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt__CollectionsKt.m12460W();
            }
            String str3 = (String) obj2;
            if ((i == 0 || i == m12476G) && StringsJVM.m6592U1(str3)) {
                str = null;
            } else {
                m6208u6 = _Strings.m6208u6(str3, intValue);
                if (m6208u6 != null && (invoke = m6728g.invoke(m6208u6)) != null) {
                    str3 = invoke;
                }
                str = str3;
            }
            if (str != null) {
                arrayList3.add(str);
            }
            i = i2;
        }
        m12161X2 = _Collections.m12161X2(arrayList3, new StringBuilder(length), ShellAdbUtils.f33810d, null, null, 0, null, null, 124, null);
        String sb = ((StringBuilder) m12161X2).toString();
        C14342f0.m8185o(sb, "mapIndexedNotNull { inde…\"\\n\")\n        .toString()");
        return sb;
    }

    /* renamed from: m */
    public static /* synthetic */ String m6722m(String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str2 = "";
        }
        return m6723l(str, str2);
    }

    @NotNull
    /* renamed from: n */
    public static final String m6721n(@NotNull String replaceIndentByMargin, @NotNull String newIndent, @NotNull String marginPrefix) {
        int m12476G;
        Appendable m12161X2;
        int i;
        String invoke;
        boolean m6550t2;
        C14342f0.m8184p(replaceIndentByMargin, "$this$replaceIndentByMargin");
        C14342f0.m8184p(newIndent, "newIndent");
        C14342f0.m8184p(marginPrefix, "marginPrefix");
        if (!StringsJVM.m6592U1(marginPrefix)) {
            List<String> m6504L3 = C14579x.m6504L3(replaceIndentByMargin);
            int length = replaceIndentByMargin.length() + (newIndent.length() * m6504L3.size());
            InterfaceC15280l<String, String> m6728g = m6728g(newIndent);
            m12476G = CollectionsKt__CollectionsKt.m12476G(m6504L3);
            ArrayList arrayList = new ArrayList();
            int i2 = 0;
            for (Object obj : m6504L3) {
                int i3 = i2 + 1;
                if (i2 < 0) {
                    CollectionsKt__CollectionsKt.m12460W();
                }
                String str = (String) obj;
                String str2 = null;
                if ((i2 != 0 && i2 != m12476G) || !StringsJVM.m6592U1(str)) {
                    int length2 = str.length();
                    int i4 = 0;
                    while (true) {
                        if (i4 >= length2) {
                            i = -1;
                            break;
                        } else if (!CharJVM.m6876r(str.charAt(i4))) {
                            i = i4;
                            break;
                        } else {
                            i4++;
                        }
                    }
                    if (i != -1) {
                        int i5 = i;
                        m6550t2 = StringsJVM.m6550t2(str, marginPrefix, i, false, 4, null);
                        if (m6550t2) {
                            int length3 = i5 + marginPrefix.length();
                            if (str == null) {
                                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                            }
                            str2 = str.substring(length3);
                            C14342f0.m8185o(str2, "(this as java.lang.String).substring(startIndex)");
                        }
                    }
                    if (str2 != null && (invoke = m6728g.invoke(str2)) != null) {
                        str = invoke;
                    }
                    str2 = str;
                }
                if (str2 != null) {
                    arrayList.add(str2);
                }
                i2 = i3;
            }
            m12161X2 = _Collections.m12161X2(arrayList, new StringBuilder(length), ShellAdbUtils.f33810d, null, null, 0, null, null, 124, null);
            String sb = ((StringBuilder) m12161X2).toString();
            C14342f0.m8185o(sb, "mapIndexedNotNull { inde…\"\\n\")\n        .toString()");
            return sb;
        }
        throw new IllegalArgumentException("marginPrefix must be non-blank string.".toString());
    }

    /* renamed from: o */
    public static /* synthetic */ String m6720o(String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str2 = "";
        }
        if ((i & 2) != 0) {
            str3 = "|";
        }
        return m6721n(str, str2, str3);
    }

    @NotNull
    /* renamed from: p */
    public static String m6719p(@NotNull String trimIndent) {
        C14342f0.m8184p(trimIndent, "$this$trimIndent");
        return m6723l(trimIndent, "");
    }

    @NotNull
    /* renamed from: q */
    public static final String m6718q(@NotNull String trimMargin, @NotNull String marginPrefix) {
        C14342f0.m8184p(trimMargin, "$this$trimMargin");
        C14342f0.m8184p(marginPrefix, "marginPrefix");
        return m6721n(trimMargin, "", marginPrefix);
    }

    /* renamed from: r */
    public static /* synthetic */ String m6717r(String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str2 = "|";
        }
        return m6718q(str, str2);
    }
}

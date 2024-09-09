package kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.f0;
import kotlin.collections.j1;
import kotlin.collections.o0;
import kotlin.collections.y;
import kotlin.collections.y0;
import kotlin.f1;
import kotlin.jvm.internal.u;
import kotlin.ranges.q;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf;
import kotlin.text.w;
import org.jetbrains.annotations.NotNull;

/* compiled from: JvmNameResolver.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class f implements kotlin.reflect.jvm.internal.impl.metadata.deserialization.c {
    @NotNull

    /* renamed from: e  reason: collision with root package name */
    public static final a f57540e = new a(null);
    @NotNull

    /* renamed from: f  reason: collision with root package name */
    private static final String f57541f;
    @NotNull

    /* renamed from: g  reason: collision with root package name */
    private static final List<String> f57542g;
    @NotNull

    /* renamed from: h  reason: collision with root package name */
    private static final Map<String, Integer> f57543h;
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final JvmProtoBuf.StringTableTypes f57544a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final String[] f57545b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final Set<Integer> f57546c;
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    private final List<JvmProtoBuf.StringTableTypes.Record> f57547d;

    /* compiled from: JvmNameResolver.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }
    }

    /* compiled from: JvmNameResolver.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public /* synthetic */ class b {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f57548a;

        static {
            int[] iArr = new int[JvmProtoBuf.StringTableTypes.Record.Operation.values().length];
            iArr[JvmProtoBuf.StringTableTypes.Record.Operation.NONE.ordinal()] = 1;
            iArr[JvmProtoBuf.StringTableTypes.Record.Operation.INTERNAL_TO_CLASS_ID.ordinal()] = 2;
            iArr[JvmProtoBuf.StringTableTypes.Record.Operation.DESC_TO_CLASS_ID.ordinal()] = 3;
            f57548a = iArr;
        }
    }

    static {
        List M;
        String X2;
        List<String> M2;
        Iterable<o0> S5;
        int Z;
        int j4;
        int n4;
        M = CollectionsKt__CollectionsKt.M('k', 'o', 't', 'l', 'i', 'n');
        X2 = f0.X2(M, "", null, null, 0, null, null, 62, null);
        f57541f = X2;
        M2 = CollectionsKt__CollectionsKt.M(kotlin.jvm.internal.f0.C(X2, "/Any"), kotlin.jvm.internal.f0.C(X2, "/Nothing"), kotlin.jvm.internal.f0.C(X2, "/Unit"), kotlin.jvm.internal.f0.C(X2, "/Throwable"), kotlin.jvm.internal.f0.C(X2, "/Number"), kotlin.jvm.internal.f0.C(X2, "/Byte"), kotlin.jvm.internal.f0.C(X2, "/Double"), kotlin.jvm.internal.f0.C(X2, "/Float"), kotlin.jvm.internal.f0.C(X2, "/Int"), kotlin.jvm.internal.f0.C(X2, "/Long"), kotlin.jvm.internal.f0.C(X2, "/Short"), kotlin.jvm.internal.f0.C(X2, "/Boolean"), kotlin.jvm.internal.f0.C(X2, "/Char"), kotlin.jvm.internal.f0.C(X2, "/CharSequence"), kotlin.jvm.internal.f0.C(X2, "/String"), kotlin.jvm.internal.f0.C(X2, "/Comparable"), kotlin.jvm.internal.f0.C(X2, "/Enum"), kotlin.jvm.internal.f0.C(X2, "/Array"), kotlin.jvm.internal.f0.C(X2, "/ByteArray"), kotlin.jvm.internal.f0.C(X2, "/DoubleArray"), kotlin.jvm.internal.f0.C(X2, "/FloatArray"), kotlin.jvm.internal.f0.C(X2, "/IntArray"), kotlin.jvm.internal.f0.C(X2, "/LongArray"), kotlin.jvm.internal.f0.C(X2, "/ShortArray"), kotlin.jvm.internal.f0.C(X2, "/BooleanArray"), kotlin.jvm.internal.f0.C(X2, "/CharArray"), kotlin.jvm.internal.f0.C(X2, "/Cloneable"), kotlin.jvm.internal.f0.C(X2, "/Annotation"), kotlin.jvm.internal.f0.C(X2, "/collections/Iterable"), kotlin.jvm.internal.f0.C(X2, "/collections/MutableIterable"), kotlin.jvm.internal.f0.C(X2, "/collections/Collection"), kotlin.jvm.internal.f0.C(X2, "/collections/MutableCollection"), kotlin.jvm.internal.f0.C(X2, "/collections/List"), kotlin.jvm.internal.f0.C(X2, "/collections/MutableList"), kotlin.jvm.internal.f0.C(X2, "/collections/Set"), kotlin.jvm.internal.f0.C(X2, "/collections/MutableSet"), kotlin.jvm.internal.f0.C(X2, "/collections/Map"), kotlin.jvm.internal.f0.C(X2, "/collections/MutableMap"), kotlin.jvm.internal.f0.C(X2, "/collections/Map.Entry"), kotlin.jvm.internal.f0.C(X2, "/collections/MutableMap.MutableEntry"), kotlin.jvm.internal.f0.C(X2, "/collections/Iterator"), kotlin.jvm.internal.f0.C(X2, "/collections/MutableIterator"), kotlin.jvm.internal.f0.C(X2, "/collections/ListIterator"), kotlin.jvm.internal.f0.C(X2, "/collections/MutableListIterator"));
        f57542g = M2;
        S5 = f0.S5(M2);
        Z = y.Z(S5, 10);
        j4 = y0.j(Z);
        n4 = q.n(j4, 16);
        LinkedHashMap linkedHashMap = new LinkedHashMap(n4);
        for (o0 o0Var : S5) {
            linkedHashMap.put((String) o0Var.f(), Integer.valueOf(o0Var.e()));
        }
        f57543h = linkedHashMap;
    }

    public f(@NotNull JvmProtoBuf.StringTableTypes types, @NotNull String[] strings) {
        Set<Integer> L5;
        kotlin.jvm.internal.f0.p(types, "types");
        kotlin.jvm.internal.f0.p(strings, "strings");
        this.f57544a = types;
        this.f57545b = strings;
        List<Integer> localNameList = types.getLocalNameList();
        if (localNameList.isEmpty()) {
            L5 = j1.k();
        } else {
            kotlin.jvm.internal.f0.o(localNameList, "");
            L5 = f0.L5(localNameList);
        }
        this.f57546c = L5;
        ArrayList arrayList = new ArrayList();
        List<JvmProtoBuf.StringTableTypes.Record> recordList = c().getRecordList();
        arrayList.ensureCapacity(recordList.size());
        for (JvmProtoBuf.StringTableTypes.Record record : recordList) {
            int range = record.getRange();
            int i4 = 0;
            while (i4 < range) {
                i4++;
                arrayList.add(record);
            }
        }
        arrayList.trimToSize();
        f1 f1Var = f1.f55527a;
        this.f57547d = arrayList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.metadata.deserialization.c
    public boolean a(int i4) {
        return this.f57546c.contains(Integer.valueOf(i4));
    }

    @Override // kotlin.reflect.jvm.internal.impl.metadata.deserialization.c
    @NotNull
    public String b(int i4) {
        return getString(i4);
    }

    @NotNull
    public final JvmProtoBuf.StringTableTypes c() {
        return this.f57544a;
    }

    @Override // kotlin.reflect.jvm.internal.impl.metadata.deserialization.c
    @NotNull
    public String getString(int i4) {
        String string;
        JvmProtoBuf.StringTableTypes.Record record = this.f57547d.get(i4);
        if (record.hasString()) {
            string = record.getString();
        } else {
            if (record.hasPredefinedIndex()) {
                List<String> list = f57542g;
                int size = list.size();
                int predefinedIndex = record.getPredefinedIndex();
                if (predefinedIndex >= 0 && predefinedIndex < size) {
                    string = list.get(record.getPredefinedIndex());
                }
            }
            string = this.f57545b[i4];
        }
        if (record.getSubstringIndexCount() >= 2) {
            List<Integer> substringIndexList = record.getSubstringIndexList();
            kotlin.jvm.internal.f0.o(substringIndexList, "substringIndexList");
            Integer begin = substringIndexList.get(0);
            Integer end = substringIndexList.get(1);
            kotlin.jvm.internal.f0.o(begin, "begin");
            if (begin.intValue() >= 0) {
                int intValue = begin.intValue();
                kotlin.jvm.internal.f0.o(end, "end");
                if (intValue <= end.intValue() && end.intValue() <= string.length()) {
                    kotlin.jvm.internal.f0.o(string, "string");
                    string = string.substring(begin.intValue(), end.intValue());
                    kotlin.jvm.internal.f0.o(string, "this as java.lang.String\u2026ing(startIndex, endIndex)");
                }
            }
        }
        String string2 = string;
        if (record.getReplaceCharCount() >= 2) {
            List<Integer> replaceCharList = record.getReplaceCharList();
            kotlin.jvm.internal.f0.o(replaceCharList, "replaceCharList");
            kotlin.jvm.internal.f0.o(string2, "string");
            string2 = w.j2(string2, (char) replaceCharList.get(0).intValue(), (char) replaceCharList.get(1).intValue(), false, 4, null);
        }
        String string3 = string2;
        JvmProtoBuf.StringTableTypes.Record.Operation operation = record.getOperation();
        if (operation == null) {
            operation = JvmProtoBuf.StringTableTypes.Record.Operation.NONE;
        }
        int i5 = b.f57548a[operation.ordinal()];
        if (i5 == 2) {
            kotlin.jvm.internal.f0.o(string3, "string");
            string3 = w.j2(string3, '$', '.', false, 4, null);
        } else if (i5 == 3) {
            if (string3.length() >= 2) {
                kotlin.jvm.internal.f0.o(string3, "string");
                string3 = string3.substring(1, string3.length() - 1);
                kotlin.jvm.internal.f0.o(string3, "this as java.lang.String\u2026ing(startIndex, endIndex)");
            }
            String string4 = string3;
            kotlin.jvm.internal.f0.o(string4, "string");
            string3 = w.j2(string4, '$', '.', false, 4, null);
        }
        kotlin.jvm.internal.f0.o(string3, "string");
        return string3;
    }
}

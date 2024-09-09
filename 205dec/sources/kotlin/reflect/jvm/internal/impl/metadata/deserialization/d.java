package kotlin.reflect.jvm.internal.impl.metadata.deserialization;

import com.bytedance.pangle.sdk.component.log.impl.cache.db.TTPathConst;
import java.util.LinkedList;
import java.util.List;
import kotlin.Triple;
import kotlin.jvm.internal.f0;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import org.jetbrains.annotations.NotNull;

/* compiled from: NameResolverImpl.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class d implements c {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final ProtoBuf.StringTable f57480a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final ProtoBuf.QualifiedNameTable f57481b;

    /* compiled from: NameResolverImpl.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f57482a;

        static {
            int[] iArr = new int[ProtoBuf.QualifiedNameTable.QualifiedName.Kind.values().length];
            iArr[ProtoBuf.QualifiedNameTable.QualifiedName.Kind.CLASS.ordinal()] = 1;
            iArr[ProtoBuf.QualifiedNameTable.QualifiedName.Kind.PACKAGE.ordinal()] = 2;
            iArr[ProtoBuf.QualifiedNameTable.QualifiedName.Kind.LOCAL.ordinal()] = 3;
            f57482a = iArr;
        }
    }

    public d(@NotNull ProtoBuf.StringTable strings, @NotNull ProtoBuf.QualifiedNameTable qualifiedNames) {
        f0.p(strings, "strings");
        f0.p(qualifiedNames, "qualifiedNames");
        this.f57480a = strings;
        this.f57481b = qualifiedNames;
    }

    private final Triple<List<String>, List<String>, Boolean> c(int i4) {
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        boolean z3 = false;
        while (i4 != -1) {
            ProtoBuf.QualifiedNameTable.QualifiedName qualifiedName = this.f57481b.getQualifiedName(i4);
            String string = this.f57480a.getString(qualifiedName.getShortName());
            ProtoBuf.QualifiedNameTable.QualifiedName.Kind kind = qualifiedName.getKind();
            f0.m(kind);
            int i5 = a.f57482a[kind.ordinal()];
            if (i5 == 1) {
                linkedList2.addFirst(string);
            } else if (i5 == 2) {
                linkedList.addFirst(string);
            } else if (i5 == 3) {
                linkedList2.addFirst(string);
                z3 = true;
            }
            i4 = qualifiedName.getParentQualifiedName();
        }
        return new Triple<>(linkedList, linkedList2, Boolean.valueOf(z3));
    }

    @Override // kotlin.reflect.jvm.internal.impl.metadata.deserialization.c
    public boolean a(int i4) {
        return c(i4).getThird().booleanValue();
    }

    @Override // kotlin.reflect.jvm.internal.impl.metadata.deserialization.c
    @NotNull
    public String b(int i4) {
        String X2;
        String X22;
        Triple<List<String>, List<String>, Boolean> c4 = c(i4);
        List<String> component1 = c4.component1();
        X2 = kotlin.collections.f0.X2(c4.component2(), ".", null, null, 0, null, null, 62, null);
        if (component1.isEmpty()) {
            return X2;
        }
        StringBuilder sb = new StringBuilder();
        X22 = kotlin.collections.f0.X2(component1, TTPathConst.sSeparator, null, null, 0, null, null, 62, null);
        sb.append(X22);
        sb.append('/');
        sb.append(X2);
        return sb.toString();
    }

    @Override // kotlin.reflect.jvm.internal.impl.metadata.deserialization.c
    @NotNull
    public String getString(int i4) {
        String string = this.f57480a.getString(i4);
        f0.o(string, "strings.getString(index)");
        return string;
    }
}

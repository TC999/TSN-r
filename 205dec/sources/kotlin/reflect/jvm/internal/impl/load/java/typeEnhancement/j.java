package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.o0;
import kotlin.collections.y;
import kotlin.collections.y0;
import kotlin.f1;
import kotlin.jvm.internal.f0;
import kotlin.l0;
import kotlin.ranges.q;
import kotlin.reflect.jvm.internal.impl.load.kotlin.w;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;
import org.jetbrains.annotations.NotNull;

/* compiled from: predefinedEnhancementInfo.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
final class j {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final Map<String, h> f57073a = new LinkedHashMap();

    /* compiled from: predefinedEnhancementInfo.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public final class a {
        @NotNull

        /* renamed from: a  reason: collision with root package name */
        private final String f57074a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ j f57075b;

        /* compiled from: predefinedEnhancementInfo.kt */
        /* renamed from: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.j$a$a  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        public final class C1143a {
            @NotNull

            /* renamed from: a  reason: collision with root package name */
            private final String f57076a;
            @NotNull

            /* renamed from: b  reason: collision with root package name */
            private final List<Pair<String, n>> f57077b;
            @NotNull

            /* renamed from: c  reason: collision with root package name */
            private Pair<String, n> f57078c;

            /* renamed from: d  reason: collision with root package name */
            final /* synthetic */ a f57079d;

            public C1143a(@NotNull a this$0, String functionName) {
                f0.p(this$0, "this$0");
                f0.p(functionName, "functionName");
                this.f57079d = this$0;
                this.f57076a = functionName;
                this.f57077b = new ArrayList();
                this.f57078c = l0.a("V", null);
            }

            @NotNull
            public final Pair<String, h> a() {
                int Z;
                int Z2;
                w wVar = w.f57261a;
                String b4 = this.f57079d.b();
                String b5 = b();
                List<Pair<String, n>> list = this.f57077b;
                Z = y.Z(list, 10);
                ArrayList arrayList = new ArrayList(Z);
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add((String) ((Pair) it.next()).getFirst());
                }
                String k4 = wVar.k(b4, wVar.j(b5, arrayList, this.f57078c.getFirst()));
                n second = this.f57078c.getSecond();
                List<Pair<String, n>> list2 = this.f57077b;
                Z2 = y.Z(list2, 10);
                ArrayList arrayList2 = new ArrayList(Z2);
                Iterator<T> it2 = list2.iterator();
                while (it2.hasNext()) {
                    arrayList2.add((n) ((Pair) it2.next()).getSecond());
                }
                return l0.a(k4, new h(second, arrayList2));
            }

            @NotNull
            public final String b() {
                return this.f57076a;
            }

            public final void c(@NotNull String type, @NotNull d... qualifiers) {
                Iterable<o0> Zy;
                int Z;
                int j4;
                int n4;
                n nVar;
                f0.p(type, "type");
                f0.p(qualifiers, "qualifiers");
                List<Pair<String, n>> list = this.f57077b;
                if (qualifiers.length == 0) {
                    nVar = null;
                } else {
                    Zy = kotlin.collections.p.Zy(qualifiers);
                    Z = y.Z(Zy, 10);
                    j4 = y0.j(Z);
                    n4 = q.n(j4, 16);
                    LinkedHashMap linkedHashMap = new LinkedHashMap(n4);
                    for (o0 o0Var : Zy) {
                        linkedHashMap.put(Integer.valueOf(o0Var.e()), (d) o0Var.f());
                    }
                    nVar = new n(linkedHashMap);
                }
                list.add(l0.a(type, nVar));
            }

            public final void d(@NotNull String type, @NotNull d... qualifiers) {
                Iterable<o0> Zy;
                int Z;
                int j4;
                int n4;
                f0.p(type, "type");
                f0.p(qualifiers, "qualifiers");
                Zy = kotlin.collections.p.Zy(qualifiers);
                Z = y.Z(Zy, 10);
                j4 = y0.j(Z);
                n4 = q.n(j4, 16);
                LinkedHashMap linkedHashMap = new LinkedHashMap(n4);
                for (o0 o0Var : Zy) {
                    linkedHashMap.put(Integer.valueOf(o0Var.e()), (d) o0Var.f());
                }
                this.f57078c = l0.a(type, new n(linkedHashMap));
            }

            public final void e(@NotNull JvmPrimitiveType type) {
                f0.p(type, "type");
                String desc = type.getDesc();
                f0.o(desc, "type.desc");
                this.f57078c = l0.a(desc, null);
            }
        }

        public a(@NotNull j this$0, String className) {
            f0.p(this$0, "this$0");
            f0.p(className, "className");
            this.f57075b = this$0;
            this.f57074a = className;
        }

        public final void a(@NotNull String name, @NotNull d2.l<? super C1143a, f1> block) {
            f0.p(name, "name");
            f0.p(block, "block");
            Map map = this.f57075b.f57073a;
            C1143a c1143a = new C1143a(this, name);
            block.invoke(c1143a);
            Pair<String, h> a4 = c1143a.a();
            map.put(a4.getFirst(), a4.getSecond());
        }

        @NotNull
        public final String b() {
            return this.f57074a;
        }
    }

    @NotNull
    public final Map<String, h> b() {
        return this.f57073a;
    }
}

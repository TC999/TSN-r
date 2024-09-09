package kotlin.sequences;

import java.util.Iterator;
import kotlin.BuilderInference;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.SinceKotlin;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.f1;
import kotlin.internal.InlineOnly;
import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: SequenceBuilder.kt */
@Metadata(bv = {}, d1 = {"\u0000P\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010(\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u001aO\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u00002/\b\u0001\u0010\u0007\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0001\u00a2\u0006\u0002\b\u0006H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b\t\u0010\n\u001aP\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u00002/\b\t\u0010\u000b\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0001\u00a2\u0006\u0002\b\u0006H\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b\f\u0010\n\u001aO\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\r\"\u0004\b\u0000\u0010\u00002/\b\u0001\u0010\u0007\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0001\u00a2\u0006\u0002\b\u0006H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000e\u0010\u000f\u001aP\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\r\"\u0004\b\u0000\u0010\u00002/\b\t\u0010\u000b\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0001\u00a2\u0006\u0002\b\u0006H\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0010\u0010\u000f\"\u0018\u0010\u0015\u001a\u00060\u0011j\u0002`\u00128\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014\"\u0018\u0010\u0016\u001a\u00060\u0011j\u0002`\u00128\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0014\"\u0018\u0010\u0017\u001a\u00060\u0011j\u0002`\u00128\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0014\"\u0018\u0010\u0018\u001a\u00060\u0011j\u0002`\u00128\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0014\"\u0018\u0010\u0019\u001a\u00060\u0011j\u0002`\u00128\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0014\"\u0018\u0010\u001b\u001a\u00060\u0011j\u0002`\u00128\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u0014*V\b\u0007\u0010'\u001a\u0004\b\u0000\u0010\u0000\"\b\u0012\u0004\u0012\u00028\u00000\u00022\b\u0012\u0004\u0012\u00028\u00000\u0002B6\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(\u001e\u0012\u001c\b\u001f\u0012\u0018\b\u000bB\u0014\b \u0012\u0006\b!\u0012\u0002\b\f\u0012\b\b\"\u0012\u0004\b\b(#\u0012\n\b$\u0012\u0006\b\n0%8&*\f\b\u0002\u0010(\"\u00020\u00112\u00020\u0011\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006)"}, d2 = {"T", "Lkotlin/Function2;", "Lkotlin/sequences/o;", "Lkotlin/coroutines/c;", "Lkotlin/f1;", "", "Lkotlin/ExtensionFunctionType;", "block", "Lkotlin/sequences/m;", "e", "(Ld2/p;)Lkotlin/sequences/m;", "builderAction", "c", "", "d", "(Ld2/p;)Ljava/util/Iterator;", "b", "", "Lkotlin/sequences/State;", "a", "I", "State_NotReady", "State_ManyNotReady", "State_ManyReady", "State_Ready", "State_Done", "f", "State_Failed", "Lkotlin/Deprecated;", "message", "Use SequenceScope class instead.", "replaceWith", "Lkotlin/ReplaceWith;", "imports", "expression", "SequenceScope<T>", "level", "Lkotlin/DeprecationLevel;", "ERROR", "SequenceBuilder", "State", "kotlin-stdlib"}, k = 5, mv = {1, 6, 0}, xs = "kotlin/sequences/SequencesKt")
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class q {

    /* renamed from: a  reason: collision with root package name */
    private static final int f58822a = 0;

    /* renamed from: b  reason: collision with root package name */
    private static final int f58823b = 1;

    /* renamed from: c  reason: collision with root package name */
    private static final int f58824c = 2;

    /* renamed from: d  reason: collision with root package name */
    private static final int f58825d = 3;

    /* renamed from: e  reason: collision with root package name */
    private static final int f58826e = 4;

    /* renamed from: f  reason: collision with root package name */
    private static final int f58827f = 5;

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: Sequences.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0096\u0002\u00a8\u0006\u0004\u00b8\u0006\u0000"}, d2 = {"kotlin/sequences/s$a", "Lkotlin/sequences/m;", "", "iterator", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a<T> implements m<T> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d2.p f58828a;

        public a(d2.p pVar) {
            this.f58828a = pVar;
        }

        @Override // kotlin.sequences.m
        @NotNull
        public Iterator<T> iterator() {
            Iterator<T> d4;
            d4 = q.d(this.f58828a);
            return d4;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: Sequences.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0096\u0002\u00a8\u0006\u0004\u00b8\u0006\u0000"}, d2 = {"kotlin/sequences/s$a", "Lkotlin/sequences/m;", "", "iterator", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class b<T> implements m<T> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d2.p f58829a;

        public b(d2.p pVar) {
            this.f58829a = pVar;
        }

        @Override // kotlin.sequences.m
        @NotNull
        public Iterator<T> iterator() {
            Iterator<T> d4;
            d4 = q.d(this.f58829a);
            return d4;
        }
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use SequenceScope class instead.", replaceWith = @ReplaceWith(expression = "SequenceScope<T>", imports = {}))
    public static /* synthetic */ void a() {
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use 'iterator { }' function instead.", replaceWith = @ReplaceWith(expression = "iterator(builderAction)", imports = {}))
    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final <T> Iterator<T> b(@BuilderInference d2.p<? super o<? super T>, ? super kotlin.coroutines.c<? super f1>, ? extends Object> builderAction) {
        Iterator<T> d4;
        f0.p(builderAction, "builderAction");
        d4 = d(builderAction);
        return d4;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use 'sequence { }' function instead.", replaceWith = @ReplaceWith(expression = "sequence(builderAction)", imports = {}))
    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final <T> m<T> c(@BuilderInference d2.p<? super o<? super T>, ? super kotlin.coroutines.c<? super f1>, ? extends Object> builderAction) {
        f0.p(builderAction, "builderAction");
        return new a(builderAction);
    }

    @SinceKotlin(version = "1.3")
    @NotNull
    public static <T> Iterator<T> d(@BuilderInference @NotNull d2.p<? super o<? super T>, ? super kotlin.coroutines.c<? super f1>, ? extends Object> block) {
        kotlin.coroutines.c<? super f1> c4;
        f0.p(block, "block");
        n nVar = new n();
        c4 = IntrinsicsKt__IntrinsicsJvmKt.c(block, nVar, nVar);
        nVar.m(c4);
        return nVar;
    }

    @SinceKotlin(version = "1.3")
    @NotNull
    public static <T> m<T> e(@BuilderInference @NotNull d2.p<? super o<? super T>, ? super kotlin.coroutines.c<? super f1>, ? extends Object> block) {
        f0.p(block, "block");
        return new b(block);
    }
}

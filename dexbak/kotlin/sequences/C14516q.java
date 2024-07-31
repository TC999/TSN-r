package kotlin.sequences;

import androidx.exifinterface.media.ExifInterface;
import com.baidu.mobads.sdk.internal.C2640by;
import java.util.Iterator;
import kotlin.Annotations;
import kotlin.DeprecationLevel;
import kotlin.Inference;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.SinceKotlin;
import kotlin.Unit;
import kotlin.coroutines.InterfaceC14268c;
import kotlin.coroutines.intrinsics.IntrinsicsJvm;
import kotlin.internal.InlineOnly;
import kotlin.jvm.internal.C14342f0;
import org.jetbrains.annotations.NotNull;
import p617l1.InterfaceC15284p;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SequenceBuilder.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000P\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010(\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u001aO\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u00002/\b\u0001\u0010\u0007\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0001¢\u0006\u0002\b\u0006H\u0007ø\u0001\u0000¢\u0006\u0004\b\t\u0010\n\u001aP\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u00002/\b\t\u0010\u000b\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0001¢\u0006\u0002\b\u0006H\u0087\bø\u0001\u0000¢\u0006\u0004\b\f\u0010\n\u001aO\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\r\"\u0004\b\u0000\u0010\u00002/\b\u0001\u0010\u0007\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0001¢\u0006\u0002\b\u0006H\u0007ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000f\u001aP\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\r\"\u0004\b\u0000\u0010\u00002/\b\t\u0010\u000b\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0001¢\u0006\u0002\b\u0006H\u0087\bø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u000f\"\u0018\u0010\u0015\u001a\u00060\u0011j\u0002`\u00128\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014\"\u0018\u0010\u0016\u001a\u00060\u0011j\u0002`\u00128\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0010\u0010\u0014\"\u0018\u0010\u0017\u001a\u00060\u0011j\u0002`\u00128\u0002X\u0082T¢\u0006\u0006\n\u0004\b\f\u0010\u0014\"\u0018\u0010\u0018\u001a\u00060\u0011j\u0002`\u00128\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000e\u0010\u0014\"\u0018\u0010\u0019\u001a\u00060\u0011j\u0002`\u00128\u0002X\u0082T¢\u0006\u0006\n\u0004\b\t\u0010\u0014\"\u0018\u0010\u001b\u001a\u00060\u0011j\u0002`\u00128\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001a\u0010\u0014*V\b\u0007\u0010'\u001a\u0004\b\u0000\u0010\u0000\"\b\u0012\u0004\u0012\u00028\u00000\u00022\b\u0012\u0004\u0012\u00028\u00000\u0002B6\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(\u001e\u0012\u001c\b\u001f\u0012\u0018\b\u000bB\u0014\b \u0012\u0006\b!\u0012\u0002\b\f\u0012\b\b\"\u0012\u0004\b\b(#\u0012\n\b$\u0012\u0006\b\n0%8&*\f\b\u0002\u0010(\"\u00020\u00112\u00020\u0011\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006)"}, m12616d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/Function2;", "Lkotlin/sequences/o;", "Lkotlin/coroutines/c;", "Lkotlin/f1;", "", "Lkotlin/ExtensionFunctionType;", "block", "Lkotlin/sequences/m;", "e", "(Ll1/p;)Lkotlin/sequences/m;", "builderAction", "c", "", "d", "(Ll1/p;)Ljava/util/Iterator;", "b", "", "Lkotlin/sequences/State;", "a", "I", "State_NotReady", "State_ManyNotReady", "State_ManyReady", "State_Ready", "State_Done", "f", "State_Failed", "Lkotlin/Deprecated;", "message", "Use SequenceScope class instead.", "replaceWith", "Lkotlin/ReplaceWith;", "imports", "expression", "SequenceScope<T>", "level", "Lkotlin/DeprecationLevel;", C2640by.f8774l, "SequenceBuilder", "State", "kotlin-stdlib"}, m12615k = 5, m12614mv = {1, 5, 1}, m12611xs = "kotlin/sequences/SequencesKt")
/* renamed from: kotlin.sequences.q */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class C14516q {

    /* renamed from: a */
    private static final int f41471a = 0;

    /* renamed from: b */
    private static final int f41472b = 1;

    /* renamed from: c */
    private static final int f41473c = 2;

    /* renamed from: d */
    private static final int f41474d = 3;

    /* renamed from: e */
    private static final int f41475e = 4;

    /* renamed from: f */
    private static final int f41476f = 5;

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: Sequences.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0096\u0002¨\u0006\u0004¸\u0006\u0000"}, m12616d2 = {"kotlin/sequences/s$a", "Lkotlin/sequences/m;", "", "iterator", "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
    /* renamed from: kotlin.sequences.q$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C14517a<T> implements Sequence<T> {

        /* renamed from: a */
        final /* synthetic */ InterfaceC15284p f41477a;

        public C14517a(InterfaceC15284p interfaceC15284p) {
            this.f41477a = interfaceC15284p;
        }

        @Override // kotlin.sequences.Sequence
        @NotNull
        public Iterator<T> iterator() {
            Iterator<T> m6994d;
            m6994d = C14516q.m6994d(this.f41477a);
            return m6994d;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: Sequences.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0096\u0002¨\u0006\u0004¸\u0006\u0000"}, m12616d2 = {"kotlin/sequences/s$a", "Lkotlin/sequences/m;", "", "iterator", "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
    /* renamed from: kotlin.sequences.q$b */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C14518b<T> implements Sequence<T> {

        /* renamed from: a */
        final /* synthetic */ InterfaceC15284p f41478a;

        public C14518b(InterfaceC15284p interfaceC15284p) {
            this.f41478a = interfaceC15284p;
        }

        @Override // kotlin.sequences.Sequence
        @NotNull
        public Iterator<T> iterator() {
            Iterator<T> m6994d;
            m6994d = C14516q.m6994d(this.f41478a);
            return m6994d;
        }
    }

    @Annotations(level = DeprecationLevel.ERROR, message = "Use SequenceScope class instead.", replaceWith = @ReplaceWith(expression = "SequenceScope<T>", imports = {}))
    /* renamed from: a */
    public static /* synthetic */ void m6997a() {
    }

    @Annotations(level = DeprecationLevel.ERROR, message = "Use 'iterator { }' function instead.", replaceWith = @ReplaceWith(expression = "iterator(builderAction)", imports = {}))
    @SinceKotlin(version = "1.3")
    @InlineOnly
    /* renamed from: b */
    private static final <T> Iterator<T> m6996b(@Inference InterfaceC15284p<? super AbstractC14514o<? super T>, ? super InterfaceC14268c<? super Unit>, ? extends Object> interfaceC15284p) {
        Iterator<T> m6994d;
        m6994d = m6994d(interfaceC15284p);
        return m6994d;
    }

    @Annotations(level = DeprecationLevel.ERROR, message = "Use 'sequence { }' function instead.", replaceWith = @ReplaceWith(expression = "sequence(builderAction)", imports = {}))
    @SinceKotlin(version = "1.3")
    @InlineOnly
    /* renamed from: c */
    private static final <T> Sequence<T> m6995c(@Inference InterfaceC15284p<? super AbstractC14514o<? super T>, ? super InterfaceC14268c<? super Unit>, ? extends Object> interfaceC15284p) {
        return new C14517a(interfaceC15284p);
    }

    @SinceKotlin(version = "1.3")
    @NotNull
    /* renamed from: d */
    public static <T> Iterator<T> m6994d(@Inference @NotNull InterfaceC15284p<? super AbstractC14514o<? super T>, ? super InterfaceC14268c<? super Unit>, ? extends Object> block) {
        InterfaceC14268c<? super Unit> m8651c;
        C14342f0.m8184p(block, "block");
        SequenceBuilder sequenceBuilder = new SequenceBuilder();
        m8651c = IntrinsicsJvm.m8651c(block, sequenceBuilder, sequenceBuilder);
        sequenceBuilder.m7019l(m8651c);
        return sequenceBuilder;
    }

    @SinceKotlin(version = "1.3")
    @NotNull
    /* renamed from: e */
    public static <T> Sequence<T> m6993e(@Inference @NotNull InterfaceC15284p<? super AbstractC14514o<? super T>, ? super InterfaceC14268c<? super Unit>, ? extends Object> block) {
        C14342f0.m8184p(block, "block");
        return new C14518b(block);
    }
}

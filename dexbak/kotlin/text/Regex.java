package kotlin.text;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.ExperimentalStdlibApi;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.SinceKotlin;
import kotlin.Unit;
import kotlin.collections.C14233v;
import kotlin.coroutines.InterfaceC14268c;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.internal.C14342f0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Lambda;
import kotlin.ranges.C14420o;
import kotlin.sequences.AbstractC14514o;
import kotlin.sequences.C14516q;
import kotlin.sequences.C14520s;
import kotlin.sequences.Sequence;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p617l1.InterfaceC15269a;
import p617l1.InterfaceC15280l;
import p617l1.InterfaceC15284p;

/* compiled from: Regex.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0014\u0018\u0000 32\u00060\u0001j\u0002`\u0002:\u000245B\u0011\b\u0001\u0012\u0006\u0010%\u001a\u00020\u001f¢\u0006\u0004\b-\u0010.B\u0011\b\u0016\u0012\u0006\u0010)\u001a\u00020\u0014¢\u0006\u0004\b-\u0010/B\u0019\b\u0016\u0012\u0006\u0010)\u001a\u00020\u0014\u0012\u0006\u00100\u001a\u00020\"¢\u0006\u0004\b-\u00101B\u001f\b\u0016\u0012\u0006\u0010)\u001a\u00020\u0014\u0012\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\"0!¢\u0006\u0004\b-\u00102J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0011\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0086\u0004J\u000e\u0010\t\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005J\u001a\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\nJ\u001e\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000e2\u0006\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\nJ\u0010\u0010\u0010\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0006\u001a\u00020\u0005J\u001a\u0010\u0012\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\nH\u0007J\u0018\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\nH\u0007J\u0016\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0014J\"\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0006\u001a\u00020\u00052\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00050\u0017J\u0016\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0014J\u001e\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00140\u001b2\u0006\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u001a\u001a\u00020\nJ \u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00140\u000e2\u0006\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u001a\u001a\u00020\nH\u0007J\b\u0010\u001e\u001a\u00020\u0014H\u0016J\u0006\u0010 \u001a\u00020\u001fR\u001e\u0010#\u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010$R\u0014\u0010%\u001a\u00020\u001f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u0011\u0010)\u001a\u00020\u00148F¢\u0006\u0006\u001a\u0004\b'\u0010(R\u0017\u0010,\u001a\b\u0012\u0004\u0012\u00020\"0!8F¢\u0006\u0006\u001a\u0004\b*\u0010+¨\u00066"}, m12616d2 = {"Lkotlin/text/Regex;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "", "writeReplace", "", "input", "", "matches", "containsMatchIn", "", "startIndex", "Lkotlin/text/k;", "find", "Lkotlin/sequences/m;", "findAll", "matchEntire", "index", "matchAt", "matchesAt", "", "replacement", "replace", "Lkotlin/Function1;", "transform", "replaceFirst", "limit", "", "split", "splitToSequence", "toString", "Ljava/util/regex/Pattern;", "toPattern", "", "Lkotlin/text/RegexOption;", "_options", "Ljava/util/Set;", "nativePattern", "Ljava/util/regex/Pattern;", "getPattern", "()Ljava/lang/String;", "pattern", "getOptions", "()Ljava/util/Set;", "options", "<init>", "(Ljava/util/regex/Pattern;)V", "(Ljava/lang/String;)V", "option", "(Ljava/lang/String;Lkotlin/text/RegexOption;)V", "(Ljava/lang/String;Ljava/util/Set;)V", "Companion", "a", "b", "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class Regex implements Serializable {
    @NotNull
    public static final C14553a Companion = new C14553a(null);
    private Set<? extends RegexOption> _options;
    private final Pattern nativePattern;

    /* compiled from: Regex.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005J\u000e\u0010\t\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005J\u000e\u0010\n\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005¨\u0006\r"}, m12616d2 = {"Lkotlin/text/Regex$a;", "", "", "flags", "b", "", "literal", "Lkotlin/text/Regex;", "e", "c", "d", "<init>", "()V", "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
    /* renamed from: kotlin.text.Regex$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C14553a {
        private C14553a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: b */
        public final int m6917b(int i) {
            return (i & 2) != 0 ? i | 64 : i;
        }

        @NotNull
        /* renamed from: c */
        public final String m6916c(@NotNull String literal) {
            C14342f0.m8184p(literal, "literal");
            String quote = Pattern.quote(literal);
            C14342f0.m8185o(quote, "Pattern.quote(literal)");
            return quote;
        }

        @NotNull
        /* renamed from: d */
        public final String m6915d(@NotNull String literal) {
            C14342f0.m8184p(literal, "literal");
            String quoteReplacement = Matcher.quoteReplacement(literal);
            C14342f0.m8185o(quoteReplacement, "Matcher.quoteReplacement(literal)");
            return quoteReplacement;
        }

        @NotNull
        /* renamed from: e */
        public final Regex m6914e(@NotNull String literal) {
            C14342f0.m8184p(literal, "literal");
            return new Regex(literal, RegexOption.LITERAL);
        }

        public /* synthetic */ C14553a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: Regex.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0007\b\u0002\u0018\u0000 \u00112\u00060\u0001j\u0002`\u0002:\u0001\u0006B\u0017\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000e\u001a\u00020\u000b¢\u0006\u0004\b\u000f\u0010\u0010J\b\u0010\u0004\u001a\u00020\u0003H\u0002R\u0017\u0010\n\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u0017\u0010\u000e\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b\b\u0010\f\u001a\u0004\b\u0006\u0010\r¨\u0006\u0012"}, m12616d2 = {"Lkotlin/text/Regex$b;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "", "readResolve", "", "a", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "pattern", "", "I", "()I", "flags", "<init>", "(Ljava/lang/String;I)V", "c", "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
    /* renamed from: kotlin.text.Regex$b */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    private static final class C14554b implements Serializable {
        @NotNull

        /* renamed from: c */
        public static final C14555a f41535c = new C14555a(null);
        private static final long serialVersionUID = 0;
        @NotNull

        /* renamed from: a */
        private final String f41536a;

        /* renamed from: b */
        private final int f41537b;

        /* compiled from: Regex.kt */
        @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, m12616d2 = {"Lkotlin/text/Regex$b$a;", "", "", "serialVersionUID", "J", "<init>", "()V", "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
        /* renamed from: kotlin.text.Regex$b$a */
        /* loaded from: E:\fuckcool\tsn\5406560.dex */
        public static final class C14555a {
            private C14555a() {
            }

            public /* synthetic */ C14555a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public C14554b(@NotNull String pattern, int i) {
            C14342f0.m8184p(pattern, "pattern");
            this.f41536a = pattern;
            this.f41537b = i;
        }

        private final Object readResolve() {
            Pattern compile = Pattern.compile(this.f41536a, this.f41537b);
            C14342f0.m8185o(compile, "Pattern.compile(pattern, flags)");
            return new Regex(compile);
        }

        /* renamed from: a */
        public final int m6913a() {
            return this.f41537b;
        }

        @NotNull
        /* renamed from: b */
        public final String m6912b() {
            return this.f41536a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Regex.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, m12616d2 = {"Lkotlin/text/k;", "a", "()Lkotlin/text/k;"}, m12615k = 3, m12614mv = {1, 5, 1})
    /* renamed from: kotlin.text.Regex$c */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C14556c extends Lambda implements InterfaceC15269a<InterfaceC14566k> {

        /* renamed from: b */
        final /* synthetic */ CharSequence f41539b;

        /* renamed from: c */
        final /* synthetic */ int f41540c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C14556c(CharSequence charSequence, int i) {
            super(0);
            this.f41539b = charSequence;
            this.f41540c = i;
        }

        @Override // p617l1.InterfaceC15269a
        @Nullable
        /* renamed from: a */
        public final InterfaceC14566k invoke() {
            return Regex.this.find(this.f41539b, this.f41540c);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Regex.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003"}, m12616d2 = {"Lkotlin/text/k;", "p1", "e", "(Lkotlin/text/k;)Lkotlin/text/k;"}, m12615k = 3, m12614mv = {1, 5, 1})
    /* renamed from: kotlin.text.Regex$d */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final /* synthetic */ class C14557d extends FunctionReferenceImpl implements InterfaceC15280l<InterfaceC14566k, InterfaceC14566k> {

        /* renamed from: a */
        public static final C14557d f41541a = new C14557d();

        C14557d() {
            super(1, InterfaceC14566k.class, "next", "next()Lkotlin/text/MatchResult;", 0);
        }

        @Override // p617l1.InterfaceC15280l
        @Nullable
        /* renamed from: e */
        public final InterfaceC14566k invoke(@NotNull InterfaceC14566k p1) {
            C14342f0.m8184p(p1, "p1");
            return p1.next();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Regex.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, m12616d2 = {"Lkotlin/sequences/o;", "", "Lkotlin/f1;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 5, 1})
    @DebugMetadata(m8639c = "kotlin.text.Regex$splitToSequence$1", m8638f = "Regex.kt", m8637i = {}, m8636l = {243, 251, 255}, m8635m = "invokeSuspend", m8634n = {}, m8633s = {})
    /* renamed from: kotlin.text.Regex$e */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C14558e extends RestrictedSuspendLambda implements InterfaceC15284p<AbstractC14514o<? super String>, InterfaceC14268c<? super Unit>, Object> {

        /* renamed from: a */
        private /* synthetic */ Object f41542a;

        /* renamed from: b */
        Object f41543b;

        /* renamed from: c */
        int f41544c;

        /* renamed from: d */
        int f41545d;

        /* renamed from: f */
        final /* synthetic */ CharSequence f41547f;

        /* renamed from: g */
        final /* synthetic */ int f41548g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C14558e(CharSequence charSequence, int i, InterfaceC14268c interfaceC14268c) {
            super(2, interfaceC14268c);
            this.f41547f = charSequence;
            this.f41548g = i;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final InterfaceC14268c<Unit> create(@Nullable Object obj, @NotNull InterfaceC14268c<?> completion) {
            C14342f0.m8184p(completion, "completion");
            C14558e c14558e = new C14558e(this.f41547f, this.f41548g, completion);
            c14558e.f41542a = obj;
            return c14558e;
        }

        @Override // p617l1.InterfaceC15284p
        public final Object invoke(AbstractC14514o<? super String> abstractC14514o, InterfaceC14268c<? super Unit> interfaceC14268c) {
            return ((C14558e) create(abstractC14514o, interfaceC14268c)).invokeSuspend(Unit.f41048a);
        }

        /* JADX WARN: Removed duplicated region for block: B:20:0x0072 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:23:0x007d  */
        /* JADX WARN: Removed duplicated region for block: B:27:0x009e A[RETURN] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0070 -> B:21:0x0073). Please submit an issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r11) {
            /*
                r10 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.C14286a.m8643h()
                int r1 = r10.f41545d
                r2 = 0
                r3 = 3
                r4 = 2
                r5 = 1
                if (r1 == 0) goto L33
                if (r1 == r5) goto L2e
                if (r1 == r4) goto L1f
                if (r1 != r3) goto L17
                kotlin.C14294d0.m8596n(r11)
                goto L9f
            L17:
                java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r11.<init>(r0)
                throw r11
            L1f:
                int r1 = r10.f41544c
                java.lang.Object r2 = r10.f41543b
                java.util.regex.Matcher r2 = (java.util.regex.Matcher) r2
                java.lang.Object r6 = r10.f41542a
                kotlin.sequences.o r6 = (kotlin.sequences.AbstractC14514o) r6
                kotlin.C14294d0.m8596n(r11)
                r7 = r10
                goto L73
            L2e:
                kotlin.C14294d0.m8596n(r11)
                goto Lb1
            L33:
                kotlin.C14294d0.m8596n(r11)
                java.lang.Object r11 = r10.f41542a
                kotlin.sequences.o r11 = (kotlin.sequences.AbstractC14514o) r11
                kotlin.text.Regex r1 = kotlin.text.Regex.this
                java.util.regex.Pattern r1 = kotlin.text.Regex.access$getNativePattern$p(r1)
                java.lang.CharSequence r6 = r10.f41547f
                java.util.regex.Matcher r1 = r1.matcher(r6)
                int r6 = r10.f41548g
                if (r6 == r5) goto La2
                boolean r6 = r1.find()
                if (r6 != 0) goto L51
                goto La2
            L51:
                r7 = r10
                r6 = r11
                r2 = r1
                r11 = 0
                r1 = 0
            L56:
                java.lang.CharSequence r8 = r7.f41547f
                int r9 = r2.start()
                java.lang.CharSequence r11 = r8.subSequence(r11, r9)
                java.lang.String r11 = r11.toString()
                r7.f41542a = r6
                r7.f41543b = r2
                r7.f41544c = r1
                r7.f41545d = r4
                java.lang.Object r11 = r6.mo7018c(r11, r7)
                if (r11 != r0) goto L73
                return r0
            L73:
                int r11 = r2.end()
                int r1 = r1 + r5
                int r8 = r7.f41548g
                int r8 = r8 - r5
                if (r1 == r8) goto L83
                boolean r8 = r2.find()
                if (r8 != 0) goto L56
            L83:
                java.lang.CharSequence r1 = r7.f41547f
                int r2 = r1.length()
                java.lang.CharSequence r11 = r1.subSequence(r11, r2)
                java.lang.String r11 = r11.toString()
                r1 = 0
                r7.f41542a = r1
                r7.f41543b = r1
                r7.f41545d = r3
                java.lang.Object r11 = r6.mo7018c(r11, r7)
                if (r11 != r0) goto L9f
                return r0
            L9f:
                kotlin.f1 r11 = kotlin.Unit.f41048a
                return r11
            La2:
                java.lang.CharSequence r1 = r10.f41547f
                java.lang.String r1 = r1.toString()
                r10.f41545d = r5
                java.lang.Object r11 = r11.mo7018c(r1, r10)
                if (r11 != r0) goto Lb1
                return r0
            Lb1:
                kotlin.f1 r11 = kotlin.Unit.f41048a
                return r11
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.text.Regex.C14558e.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @PublishedApi
    public Regex(@NotNull Pattern nativePattern) {
        C14342f0.m8184p(nativePattern, "nativePattern");
        this.nativePattern = nativePattern;
    }

    public static /* synthetic */ InterfaceC14566k find$default(Regex regex, CharSequence charSequence, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return regex.find(charSequence, i);
    }

    public static /* synthetic */ Sequence findAll$default(Regex regex, CharSequence charSequence, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return regex.findAll(charSequence, i);
    }

    public static /* synthetic */ List split$default(Regex regex, CharSequence charSequence, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return regex.split(charSequence, i);
    }

    public static /* synthetic */ Sequence splitToSequence$default(Regex regex, CharSequence charSequence, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return regex.splitToSequence(charSequence, i);
    }

    private final Object writeReplace() {
        String pattern = this.nativePattern.pattern();
        C14342f0.m8185o(pattern, "nativePattern.pattern()");
        return new C14554b(pattern, this.nativePattern.flags());
    }

    public final boolean containsMatchIn(@NotNull CharSequence input) {
        C14342f0.m8184p(input, "input");
        return this.nativePattern.matcher(input).find();
    }

    @Nullable
    public final InterfaceC14566k find(@NotNull CharSequence input, int i) {
        C14342f0.m8184p(input, "input");
        Matcher matcher = this.nativePattern.matcher(input);
        C14342f0.m8185o(matcher, "nativePattern.matcher(input)");
        return RegexKt.m6909a(matcher, i, input);
    }

    @NotNull
    public final Sequence<InterfaceC14566k> findAll(@NotNull CharSequence input, int i) {
        Sequence<InterfaceC14566k> m6981q;
        C14342f0.m8184p(input, "input");
        if (i >= 0 && i <= input.length()) {
            m6981q = C14520s.m6981q(new C14556c(input, i), C14557d.f41541a);
            return m6981q;
        }
        throw new IndexOutOfBoundsException("Start index out of bounds: " + i + ", input length: " + input.length());
    }

    @NotNull
    public final Set<RegexOption> getOptions() {
        Set set = this._options;
        if (set != null) {
            return set;
        }
        final int flags = this.nativePattern.flags();
        EnumSet allOf = EnumSet.allOf(RegexOption.class);
        C14233v.m9018P0(allOf, new InterfaceC15280l<T, Boolean>() { // from class: kotlin.text.Regex$fromInt$$inlined$apply$lambda$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // p617l1.InterfaceC15280l
            public /* bridge */ /* synthetic */ Boolean invoke(Object obj) {
                return Boolean.valueOf(invoke((Enum) obj));
            }

            /* JADX WARN: Incorrect types in method signature: (TT;)Z */
            public final boolean invoke(Enum r3) {
                InterfaceC14563g interfaceC14563g = (InterfaceC14563g) r3;
                return (flags & interfaceC14563g.getMask()) == interfaceC14563g.getValue();
            }
        });
        Set<RegexOption> unmodifiableSet = Collections.unmodifiableSet(allOf);
        C14342f0.m8185o(unmodifiableSet, "Collections.unmodifiable…mask == it.value }\n    })");
        this._options = unmodifiableSet;
        return unmodifiableSet;
    }

    @NotNull
    public final String getPattern() {
        String pattern = this.nativePattern.pattern();
        C14342f0.m8185o(pattern, "nativePattern.pattern()");
        return pattern;
    }

    @SinceKotlin(version = "1.5")
    @ExperimentalStdlibApi
    @Nullable
    public final InterfaceC14566k matchAt(@NotNull CharSequence input, int i) {
        C14342f0.m8184p(input, "input");
        Matcher region = this.nativePattern.matcher(input).useAnchoringBounds(false).useTransparentBounds(true).region(i, input.length());
        if (region.lookingAt()) {
            C14342f0.m8185o(region, "this");
            return new C14569l(region, input);
        }
        return null;
    }

    @Nullable
    public final InterfaceC14566k matchEntire(@NotNull CharSequence input) {
        C14342f0.m8184p(input, "input");
        Matcher matcher = this.nativePattern.matcher(input);
        C14342f0.m8185o(matcher, "nativePattern.matcher(input)");
        return RegexKt.m6907c(matcher, input);
    }

    public final boolean matches(@NotNull CharSequence input) {
        C14342f0.m8184p(input, "input");
        return this.nativePattern.matcher(input).matches();
    }

    @SinceKotlin(version = "1.5")
    @ExperimentalStdlibApi
    public final boolean matchesAt(@NotNull CharSequence input, int i) {
        C14342f0.m8184p(input, "input");
        return this.nativePattern.matcher(input).useAnchoringBounds(false).useTransparentBounds(true).region(i, input.length()).lookingAt();
    }

    @NotNull
    public final String replace(@NotNull CharSequence input, @NotNull String replacement) {
        C14342f0.m8184p(input, "input");
        C14342f0.m8184p(replacement, "replacement");
        String replaceAll = this.nativePattern.matcher(input).replaceAll(replacement);
        C14342f0.m8185o(replaceAll, "nativePattern.matcher(in…).replaceAll(replacement)");
        return replaceAll;
    }

    @NotNull
    public final String replaceFirst(@NotNull CharSequence input, @NotNull String replacement) {
        C14342f0.m8184p(input, "input");
        C14342f0.m8184p(replacement, "replacement");
        String replaceFirst = this.nativePattern.matcher(input).replaceFirst(replacement);
        C14342f0.m8185o(replaceFirst, "nativePattern.matcher(in…replaceFirst(replacement)");
        return replaceFirst;
    }

    @NotNull
    public final List<String> split(@NotNull CharSequence input, int i) {
        C14342f0.m8184p(input, "input");
        C14579x.m6499M4(i);
        Matcher matcher = this.nativePattern.matcher(input);
        if (i != 1 && matcher.find()) {
            ArrayList arrayList = new ArrayList(i > 0 ? C14420o.m7574u(i, 10) : 10);
            int i2 = 0;
            int i3 = i - 1;
            do {
                arrayList.add(input.subSequence(i2, matcher.start()).toString());
                i2 = matcher.end();
                if (i3 >= 0 && arrayList.size() == i3) {
                    break;
                }
            } while (matcher.find());
            arrayList.add(input.subSequence(i2, input.length()).toString());
            return arrayList;
        }
        return C14233v.m8998k(input.toString());
    }

    @SinceKotlin(version = "1.5")
    @ExperimentalStdlibApi
    @NotNull
    public final Sequence<String> splitToSequence(@NotNull CharSequence input, int i) {
        Sequence<String> m6993e;
        C14342f0.m8184p(input, "input");
        C14579x.m6499M4(i);
        m6993e = C14516q.m6993e(new C14558e(input, i, null));
        return m6993e;
    }

    @NotNull
    public final Pattern toPattern() {
        return this.nativePattern;
    }

    @NotNull
    public String toString() {
        String pattern = this.nativePattern.toString();
        C14342f0.m8185o(pattern, "nativePattern.toString()");
        return pattern;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public Regex(@org.jetbrains.annotations.NotNull java.lang.String r2) {
        /*
            r1 = this;
            java.lang.String r0 = "pattern"
            kotlin.jvm.internal.C14342f0.m8184p(r2, r0)
            java.util.regex.Pattern r2 = java.util.regex.Pattern.compile(r2)
            java.lang.String r0 = "Pattern.compile(pattern)"
            kotlin.jvm.internal.C14342f0.m8185o(r2, r0)
            r1.<init>(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.text.Regex.<init>(java.lang.String):void");
    }

    @NotNull
    public final String replace(@NotNull CharSequence input, @NotNull InterfaceC15280l<? super InterfaceC14566k, ? extends CharSequence> transform) {
        C14342f0.m8184p(input, "input");
        C14342f0.m8184p(transform, "transform");
        int i = 0;
        InterfaceC14566k find$default = find$default(this, input, 0, 2, null);
        if (find$default != null) {
            int length = input.length();
            StringBuilder sb = new StringBuilder(length);
            do {
                C14342f0.m8187m(find$default);
                sb.append(input, i, find$default.mo6791c().getStart().intValue());
                sb.append(transform.invoke(find$default));
                i = find$default.mo6791c().getEndInclusive().intValue() + 1;
                find$default = find$default.next();
                if (i >= length) {
                    break;
                }
            } while (find$default != null);
            if (i < length) {
                sb.append(input, i, length);
            }
            String sb2 = sb.toString();
            C14342f0.m8185o(sb2, "sb.toString()");
            return sb2;
        }
        return input.toString();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public Regex(@org.jetbrains.annotations.NotNull java.lang.String r2, @org.jetbrains.annotations.NotNull kotlin.text.RegexOption r3) {
        /*
            r1 = this;
            java.lang.String r0 = "pattern"
            kotlin.jvm.internal.C14342f0.m8184p(r2, r0)
            java.lang.String r0 = "option"
            kotlin.jvm.internal.C14342f0.m8184p(r3, r0)
            kotlin.text.Regex$a r0 = kotlin.text.Regex.Companion
            int r3 = r3.getValue()
            int r3 = kotlin.text.Regex.C14553a.m6918a(r0, r3)
            java.util.regex.Pattern r2 = java.util.regex.Pattern.compile(r2, r3)
            java.lang.String r3 = "Pattern.compile(pattern,…nicodeCase(option.value))"
            kotlin.jvm.internal.C14342f0.m8185o(r2, r3)
            r1.<init>(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.text.Regex.<init>(java.lang.String, kotlin.text.RegexOption):void");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public Regex(@org.jetbrains.annotations.NotNull java.lang.String r2, @org.jetbrains.annotations.NotNull java.util.Set<? extends kotlin.text.RegexOption> r3) {
        /*
            r1 = this;
            java.lang.String r0 = "pattern"
            kotlin.jvm.internal.C14342f0.m8184p(r2, r0)
            java.lang.String r0 = "options"
            kotlin.jvm.internal.C14342f0.m8184p(r3, r0)
            kotlin.text.Regex$a r0 = kotlin.text.Regex.Companion
            int r3 = kotlin.text.RegexKt.m6904f(r3)
            int r3 = kotlin.text.Regex.C14553a.m6918a(r0, r3)
            java.util.regex.Pattern r2 = java.util.regex.Pattern.compile(r2, r3)
            java.lang.String r3 = "Pattern.compile(pattern,…odeCase(options.toInt()))"
            kotlin.jvm.internal.C14342f0.m8185o(r2, r3)
            r1.<init>(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.text.Regex.<init>(java.lang.String, java.util.Set):void");
    }
}

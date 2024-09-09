package kotlin.text;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
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
import kotlin.WasExperimental;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.f1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: Regex.kt */
@Metadata(bv = {}, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0012\u0018\u0000 32\u00060\u0001j\u0002`\u0002:\u000245B\u0011\b\u0001\u0012\u0006\u0010!\u001a\u00020\u001f\u00a2\u0006\u0004\b-\u0010.B\u0011\b\u0016\u0012\u0006\u0010)\u001a\u00020\u0014\u00a2\u0006\u0004\b-\u0010/B\u0019\b\u0016\u0012\u0006\u0010)\u001a\u00020\u0014\u0012\u0006\u00100\u001a\u00020$\u00a2\u0006\u0004\b-\u00101B\u001f\b\u0016\u0012\u0006\u0010)\u001a\u00020\u0014\u0012\f\u0010,\u001a\b\u0012\u0004\u0012\u00020$0#\u00a2\u0006\u0004\b-\u00102J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0011\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0086\u0004J\u000e\u0010\t\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005J\u001a\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\nJ\u001e\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000e2\u0006\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\nJ\u0010\u0010\u0010\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0006\u001a\u00020\u0005J\u001a\u0010\u0012\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\nH\u0007J\u0018\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\nH\u0007J\u0016\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0014J\"\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0006\u001a\u00020\u00052\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00050\u0017J\u0016\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0014J\u001e\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00140\u001b2\u0006\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u001a\u001a\u00020\nJ \u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00140\u000e2\u0006\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u001a\u001a\u00020\nH\u0007J\b\u0010\u001e\u001a\u00020\u0014H\u0016J\u0006\u0010 \u001a\u00020\u001fR\u0014\u0010!\u001a\u00020\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u001e\u0010%\u001a\n\u0012\u0004\u0012\u00020$\u0018\u00010#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0011\u0010)\u001a\u00020\u00148F\u00a2\u0006\u0006\u001a\u0004\b'\u0010(R\u0017\u0010,\u001a\b\u0012\u0004\u0012\u00020$0#8F\u00a2\u0006\u0006\u001a\u0004\b*\u0010+\u00a8\u00066"}, d2 = {"Lkotlin/text/Regex;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "", "writeReplace", "", "input", "", "matches", "containsMatchIn", "", "startIndex", "Lkotlin/text/k;", "find", "Lkotlin/sequences/m;", "findAll", "matchEntire", "index", "matchAt", "matchesAt", "", "replacement", "replace", "Lkotlin/Function1;", "transform", "replaceFirst", "limit", "", "split", "splitToSequence", "toString", "Ljava/util/regex/Pattern;", "toPattern", "nativePattern", "Ljava/util/regex/Pattern;", "", "Lkotlin/text/RegexOption;", "_options", "Ljava/util/Set;", "getPattern", "()Ljava/lang/String;", "pattern", "getOptions", "()Ljava/util/Set;", "options", "<init>", "(Ljava/util/regex/Pattern;)V", "(Ljava/lang/String;)V", "option", "(Ljava/lang/String;Lkotlin/text/RegexOption;)V", "(Ljava/lang/String;Ljava/util/Set;)V", "Companion", "a", "b", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class Regex implements Serializable {
    @NotNull
    public static final a Companion = new a(null);
    @Nullable
    private Set<? extends RegexOption> _options;
    @NotNull
    private final Pattern nativePattern;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: Regex.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005J\u000e\u0010\t\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005J\u000e\u0010\n\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005\u00a8\u0006\r"}, d2 = {"Lkotlin/text/Regex$a;", "", "", "flags", "b", "", "literal", "Lkotlin/text/Regex;", "e", "c", "d", "<init>", "()V", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.u uVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final int b(int i4) {
            return (i4 & 2) != 0 ? i4 | 64 : i4;
        }

        @NotNull
        public final String c(@NotNull String literal) {
            f0.p(literal, "literal");
            String quote = Pattern.quote(literal);
            f0.o(quote, "quote(literal)");
            return quote;
        }

        @NotNull
        public final String d(@NotNull String literal) {
            f0.p(literal, "literal");
            String quoteReplacement = Matcher.quoteReplacement(literal);
            f0.o(quoteReplacement, "quoteReplacement(literal)");
            return quoteReplacement;
        }

        @NotNull
        public final Regex e(@NotNull String literal) {
            f0.p(literal, "literal");
            return new Regex(literal, RegexOption.LITERAL);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: Regex.kt */
    @Metadata(bv = {}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0007\b\u0002\u0018\u0000 \u00112\u00060\u0001j\u0002`\u0002:\u0001\u0006B\u0017\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u00a2\u0006\u0004\b\u000f\u0010\u0010J\b\u0010\u0004\u001a\u00020\u0003H\u0002R\u0017\u0010\n\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u0017\u0010\u000e\u001a\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\f\u001a\u0004\b\u0006\u0010\r\u00a8\u0006\u0012"}, d2 = {"Lkotlin/text/Regex$b;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "", "readResolve", "", "a", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "pattern", "", "I", "()I", "flags", "<init>", "(Ljava/lang/String;I)V", "c", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    private static final class b implements Serializable {
        @NotNull

        /* renamed from: c  reason: collision with root package name */
        public static final a f58886c = new a(null);
        private static final long serialVersionUID = 0;
        @NotNull

        /* renamed from: a  reason: collision with root package name */
        private final String f58887a;

        /* renamed from: b  reason: collision with root package name */
        private final int f58888b;

        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
        /* compiled from: Regex.kt */
        @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lkotlin/text/Regex$b$a;", "", "", "serialVersionUID", "J", "<init>", "()V", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0})
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        public static final class a {
            private a() {
            }

            public /* synthetic */ a(kotlin.jvm.internal.u uVar) {
                this();
            }
        }

        public b(@NotNull String pattern, int i4) {
            f0.p(pattern, "pattern");
            this.f58887a = pattern;
            this.f58888b = i4;
        }

        private final Object readResolve() {
            Pattern compile = Pattern.compile(this.f58887a, this.f58888b);
            f0.o(compile, "compile(pattern, flags)");
            return new Regex(compile);
        }

        public final int a() {
            return this.f58888b;
        }

        @NotNull
        public final String b() {
            return this.f58887a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: Regex.kt */
    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n\u00a2\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lkotlin/text/k;", "a", "()Lkotlin/text/k;"}, k = 3, mv = {1, 6, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class c extends Lambda implements d2.a<k> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ CharSequence f58890b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f58891c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(CharSequence charSequence, int i4) {
            super(0);
            this.f58890b = charSequence;
            this.f58891c = i4;
        }

        @Override // d2.a
        @Nullable
        /* renamed from: a */
        public final k invoke() {
            return Regex.this.find(this.f58890b, this.f58891c);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: Regex.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public /* synthetic */ class d extends FunctionReferenceImpl implements d2.l<k, k> {

        /* renamed from: a  reason: collision with root package name */
        public static final d f58892a = new d();

        d() {
            super(1, k.class, "next", "next()Lkotlin/text/MatchResult;", 0);
        }

        @Override // d2.l
        @Nullable
        /* renamed from: d */
        public final k invoke(@NotNull k p02) {
            f0.p(p02, "p0");
            return p02.next();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: Regex.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H\u008a@"}, d2 = {"Lkotlin/sequences/o;", "", "Lkotlin/f1;", "<anonymous>"}, k = 3, mv = {1, 6, 0})
    @DebugMetadata(c = "kotlin.text.Regex$splitToSequence$1", f = "Regex.kt", i = {1, 1, 1}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_POST_PREPARE, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_VSYNC_HELPER, MediaPlayer.MEDIA_PLAYER_OPTION_UPDATE_TIMESTAMP_MODE}, m = "invokeSuspend", n = {"$this$sequence", "matcher", "splitCount"}, s = {"L$0", "L$1", "I$0"})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class e extends RestrictedSuspendLambda implements d2.p<kotlin.sequences.o<? super String>, kotlin.coroutines.c<? super f1>, Object> {

        /* renamed from: a  reason: collision with root package name */
        Object f58893a;

        /* renamed from: b  reason: collision with root package name */
        int f58894b;

        /* renamed from: c  reason: collision with root package name */
        int f58895c;

        /* renamed from: d  reason: collision with root package name */
        private /* synthetic */ Object f58896d;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ CharSequence f58898f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ int f58899g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(CharSequence charSequence, int i4, kotlin.coroutines.c<? super e> cVar) {
            super(2, cVar);
            this.f58898f = charSequence;
            this.f58899g = i4;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final kotlin.coroutines.c<f1> create(@Nullable Object obj, @NotNull kotlin.coroutines.c<?> cVar) {
            e eVar = new e(this.f58898f, this.f58899g, cVar);
            eVar.f58896d = obj;
            return eVar;
        }

        @Override // d2.p
        @Nullable
        /* renamed from: e */
        public final Object invoke(@NotNull kotlin.sequences.o<? super String> oVar, @Nullable kotlin.coroutines.c<? super f1> cVar) {
            return ((e) create(oVar, cVar)).invokeSuspend(f1.f55527a);
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
                java.lang.Object r0 = kotlin.coroutines.intrinsics.a.h()
                int r1 = r10.f58895c
                r2 = 0
                r3 = 3
                r4 = 2
                r5 = 1
                if (r1 == 0) goto L33
                if (r1 == r5) goto L2e
                if (r1 == r4) goto L1f
                if (r1 != r3) goto L17
                kotlin.d0.n(r11)
                goto L9f
            L17:
                java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r11.<init>(r0)
                throw r11
            L1f:
                int r1 = r10.f58894b
                java.lang.Object r2 = r10.f58893a
                java.util.regex.Matcher r2 = (java.util.regex.Matcher) r2
                java.lang.Object r6 = r10.f58896d
                kotlin.sequences.o r6 = (kotlin.sequences.o) r6
                kotlin.d0.n(r11)
                r7 = r10
                goto L73
            L2e:
                kotlin.d0.n(r11)
                goto Lb1
            L33:
                kotlin.d0.n(r11)
                java.lang.Object r11 = r10.f58896d
                kotlin.sequences.o r11 = (kotlin.sequences.o) r11
                kotlin.text.Regex r1 = kotlin.text.Regex.this
                java.util.regex.Pattern r1 = kotlin.text.Regex.access$getNativePattern$p(r1)
                java.lang.CharSequence r6 = r10.f58898f
                java.util.regex.Matcher r1 = r1.matcher(r6)
                int r6 = r10.f58899g
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
                java.lang.CharSequence r8 = r7.f58898f
                int r9 = r2.start()
                java.lang.CharSequence r11 = r8.subSequence(r11, r9)
                java.lang.String r11 = r11.toString()
                r7.f58896d = r6
                r7.f58893a = r2
                r7.f58894b = r1
                r7.f58895c = r4
                java.lang.Object r11 = r6.e(r11, r7)
                if (r11 != r0) goto L73
                return r0
            L73:
                int r11 = r2.end()
                int r1 = r1 + r5
                int r8 = r7.f58899g
                int r8 = r8 - r5
                if (r1 == r8) goto L83
                boolean r8 = r2.find()
                if (r8 != 0) goto L56
            L83:
                java.lang.CharSequence r1 = r7.f58898f
                int r2 = r1.length()
                java.lang.CharSequence r11 = r1.subSequence(r11, r2)
                java.lang.String r11 = r11.toString()
                r1 = 0
                r7.f58896d = r1
                r7.f58893a = r1
                r7.f58895c = r3
                java.lang.Object r11 = r6.e(r11, r7)
                if (r11 != r0) goto L9f
                return r0
            L9f:
                kotlin.f1 r11 = kotlin.f1.f55527a
                return r11
            La2:
                java.lang.CharSequence r1 = r10.f58898f
                java.lang.String r1 = r1.toString()
                r10.f58895c = r5
                java.lang.Object r11 = r11.e(r1, r10)
                if (r11 != r0) goto Lb1
                return r0
            Lb1:
                kotlin.f1 r11 = kotlin.f1.f55527a
                return r11
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.text.Regex.e.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @PublishedApi
    public Regex(@NotNull Pattern nativePattern) {
        f0.p(nativePattern, "nativePattern");
        this.nativePattern = nativePattern;
    }

    public static /* synthetic */ k find$default(Regex regex, CharSequence charSequence, int i4, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            i4 = 0;
        }
        return regex.find(charSequence, i4);
    }

    public static /* synthetic */ kotlin.sequences.m findAll$default(Regex regex, CharSequence charSequence, int i4, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            i4 = 0;
        }
        return regex.findAll(charSequence, i4);
    }

    public static /* synthetic */ List split$default(Regex regex, CharSequence charSequence, int i4, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            i4 = 0;
        }
        return regex.split(charSequence, i4);
    }

    public static /* synthetic */ kotlin.sequences.m splitToSequence$default(Regex regex, CharSequence charSequence, int i4, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            i4 = 0;
        }
        return regex.splitToSequence(charSequence, i4);
    }

    private final Object writeReplace() {
        String pattern = this.nativePattern.pattern();
        f0.o(pattern, "nativePattern.pattern()");
        return new b(pattern, this.nativePattern.flags());
    }

    public final boolean containsMatchIn(@NotNull CharSequence input) {
        f0.p(input, "input");
        return this.nativePattern.matcher(input).find();
    }

    @Nullable
    public final k find(@NotNull CharSequence input, int i4) {
        f0.p(input, "input");
        Matcher matcher = this.nativePattern.matcher(input);
        f0.o(matcher, "nativePattern.matcher(input)");
        return RegexKt.a(matcher, i4, input);
    }

    @NotNull
    public final kotlin.sequences.m<k> findAll(@NotNull CharSequence input, int i4) {
        kotlin.sequences.m<k> p3;
        f0.p(input, "input");
        if (i4 >= 0 && i4 <= input.length()) {
            p3 = kotlin.sequences.s.p(new c(input, i4), d.f58892a);
            return p3;
        }
        throw new IndexOutOfBoundsException("Start index out of bounds: " + i4 + ", input length: " + input.length());
    }

    @NotNull
    public final Set<RegexOption> getOptions() {
        Set set = this._options;
        if (set == null) {
            final int flags = this.nativePattern.flags();
            EnumSet allOf = EnumSet.allOf(RegexOption.class);
            f0.o(allOf, "");
            kotlin.collections.c0.N0(allOf, new d2.l<RegexOption, Boolean>() { // from class: kotlin.text.Regex$special$$inlined$fromInt$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // d2.l
                @NotNull
                public final Boolean invoke(RegexOption regexOption) {
                    RegexOption regexOption2 = regexOption;
                    return Boolean.valueOf((flags & regexOption2.getMask()) == regexOption2.getValue());
                }
            });
            Set<RegexOption> unmodifiableSet = Collections.unmodifiableSet(allOf);
            f0.o(unmodifiableSet, "unmodifiableSet(EnumSet.\u2026mask == it.value }\n    })");
            this._options = unmodifiableSet;
            return unmodifiableSet;
        }
        return set;
    }

    @NotNull
    public final String getPattern() {
        String pattern = this.nativePattern.pattern();
        f0.o(pattern, "nativePattern.pattern()");
        return pattern;
    }

    @SinceKotlin(version = "1.5")
    @ExperimentalStdlibApi
    @Nullable
    public final k matchAt(@NotNull CharSequence input, int i4) {
        f0.p(input, "input");
        Matcher region = this.nativePattern.matcher(input).useAnchoringBounds(false).useTransparentBounds(true).region(i4, input.length());
        if (region.lookingAt()) {
            f0.o(region, "this");
            return new l(region, input);
        }
        return null;
    }

    @Nullable
    public final k matchEntire(@NotNull CharSequence input) {
        f0.p(input, "input");
        Matcher matcher = this.nativePattern.matcher(input);
        f0.o(matcher, "nativePattern.matcher(input)");
        return RegexKt.b(matcher, input);
    }

    public final boolean matches(@NotNull CharSequence input) {
        f0.p(input, "input");
        return this.nativePattern.matcher(input).matches();
    }

    @SinceKotlin(version = "1.5")
    @ExperimentalStdlibApi
    public final boolean matchesAt(@NotNull CharSequence input, int i4) {
        f0.p(input, "input");
        return this.nativePattern.matcher(input).useAnchoringBounds(false).useTransparentBounds(true).region(i4, input.length()).lookingAt();
    }

    @NotNull
    public final String replace(@NotNull CharSequence input, @NotNull String replacement) {
        f0.p(input, "input");
        f0.p(replacement, "replacement");
        String replaceAll = this.nativePattern.matcher(input).replaceAll(replacement);
        f0.o(replaceAll, "nativePattern.matcher(in\u2026).replaceAll(replacement)");
        return replaceAll;
    }

    @NotNull
    public final String replaceFirst(@NotNull CharSequence input, @NotNull String replacement) {
        f0.p(input, "input");
        f0.p(replacement, "replacement");
        String replaceFirst = this.nativePattern.matcher(input).replaceFirst(replacement);
        f0.o(replaceFirst, "nativePattern.matcher(in\u2026replaceFirst(replacement)");
        return replaceFirst;
    }

    @NotNull
    public final List<String> split(@NotNull CharSequence input, int i4) {
        List<String> l4;
        f0.p(input, "input");
        x.M4(i4);
        Matcher matcher = this.nativePattern.matcher(input);
        if (i4 != 1 && matcher.find()) {
            ArrayList arrayList = new ArrayList(i4 > 0 ? kotlin.ranges.q.u(i4, 10) : 10);
            int i5 = 0;
            int i6 = i4 - 1;
            do {
                arrayList.add(input.subSequence(i5, matcher.start()).toString());
                i5 = matcher.end();
                if (i6 >= 0 && arrayList.size() == i6) {
                    break;
                }
            } while (matcher.find());
            arrayList.add(input.subSequence(i5, input.length()).toString());
            return arrayList;
        }
        l4 = kotlin.collections.x.l(input.toString());
        return l4;
    }

    @SinceKotlin(version = "1.6")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @NotNull
    public final kotlin.sequences.m<String> splitToSequence(@NotNull CharSequence input, int i4) {
        kotlin.sequences.m<String> e4;
        f0.p(input, "input");
        x.M4(i4);
        e4 = kotlin.sequences.q.e(new e(input, i4, null));
        return e4;
    }

    @NotNull
    public final Pattern toPattern() {
        return this.nativePattern;
    }

    @NotNull
    public String toString() {
        String pattern = this.nativePattern.toString();
        f0.o(pattern, "nativePattern.toString()");
        return pattern;
    }

    @NotNull
    public final String replace(@NotNull CharSequence input, @NotNull d2.l<? super k, ? extends CharSequence> transform) {
        f0.p(input, "input");
        f0.p(transform, "transform");
        int i4 = 0;
        k find$default = find$default(this, input, 0, 2, null);
        if (find$default == null) {
            return input.toString();
        }
        int length = input.length();
        StringBuilder sb = new StringBuilder(length);
        do {
            sb.append(input, i4, find$default.c().getStart().intValue());
            sb.append(transform.invoke(find$default));
            i4 = find$default.c().getEndInclusive().intValue() + 1;
            find$default = find$default.next();
            if (i4 >= length) {
                break;
            }
        } while (find$default != null);
        if (i4 < length) {
            sb.append(input, i4, length);
        }
        String sb2 = sb.toString();
        f0.o(sb2, "sb.toString()");
        return sb2;
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
            kotlin.jvm.internal.f0.p(r2, r0)
            java.util.regex.Pattern r2 = java.util.regex.Pattern.compile(r2)
            java.lang.String r0 = "compile(pattern)"
            kotlin.jvm.internal.f0.o(r2, r0)
            r1.<init>(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.text.Regex.<init>(java.lang.String):void");
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
            kotlin.jvm.internal.f0.p(r2, r0)
            java.lang.String r0 = "option"
            kotlin.jvm.internal.f0.p(r3, r0)
            kotlin.text.Regex$a r0 = kotlin.text.Regex.Companion
            int r3 = r3.getValue()
            int r3 = kotlin.text.Regex.a.a(r0, r3)
            java.util.regex.Pattern r2 = java.util.regex.Pattern.compile(r2, r3)
            java.lang.String r3 = "compile(pattern, ensureUnicodeCase(option.value))"
            kotlin.jvm.internal.f0.o(r2, r3)
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
            kotlin.jvm.internal.f0.p(r2, r0)
            java.lang.String r0 = "options"
            kotlin.jvm.internal.f0.p(r3, r0)
            kotlin.text.Regex$a r0 = kotlin.text.Regex.Companion
            int r3 = kotlin.text.RegexKt.e(r3)
            int r3 = kotlin.text.Regex.a.a(r0, r3)
            java.util.regex.Pattern r2 = java.util.regex.Pattern.compile(r2, r3)
            java.lang.String r3 = "compile(pattern, ensureU\u2026odeCase(options.toInt()))"
            kotlin.jvm.internal.f0.o(r2, r3)
            r1.<init>(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.text.Regex.<init>(java.lang.String, java.util.Set):void");
    }
}

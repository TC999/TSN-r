package kotlin.io;

import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.io.File;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.f1;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.u;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: FileTreeWalk.kt */
@Metadata(bv = {}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u0011\u0015$B\u008b\u0001\b\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0014\u0012\u0014\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\u0014\u0010\u001c\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t\u0018\u00010\u0005\u00128\u0010 \u001a4\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u0018\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001f\u0012\u0004\u0012\u00020\t\u0018\u00010\u000b\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u000e\u00a2\u0006\u0004\b!\u0010\"B\u001b\b\u0010\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0014\u00a2\u0006\u0004\b!\u0010#J\u000f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0003H\u0096\u0002J\u001a\u0010\b\u001a\u00020\u00002\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0005J\u001a\u0010\n\u001a\u00020\u00002\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t0\u0005J \u0010\r\u001a\u00020\u00002\u0018\u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\t0\u000bJ\u000e\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u000eR\u0014\u0010\u0013\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0017\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u001a\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019\u00a8\u0006%"}, d2 = {"Lkotlin/io/h;", "Lkotlin/sequences/m;", "Ljava/io/File;", "", "iterator", "Lkotlin/Function1;", "", "function", "j", "Lkotlin/f1;", "l", "Lkotlin/Function2;", "Ljava/io/IOException;", "k", "", "depth", "i", "a", "Ljava/io/File;", CampaignEx.JSON_NATIVE_VIDEO_START, "Lkotlin/io/FileWalkDirection;", "b", "Lkotlin/io/FileWalkDirection;", "direction", "f", "I", "maxDepth", "onEnter", "onLeave", "Lkotlin/ParameterName;", "name", "e", "onFail", "<init>", "(Ljava/io/File;Lkotlin/io/FileWalkDirection;Ld2/l;Ld2/l;Ld2/p;I)V", "(Ljava/io/File;Lkotlin/io/FileWalkDirection;)V", "c", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class h implements kotlin.sequences.m<File> {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final File f55555a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final FileWalkDirection f55556b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private final d2.l<File, Boolean> f55557c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private final d2.l<File, f1> f55558d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private final d2.p<File, IOException, f1> f55559e;

    /* renamed from: f  reason: collision with root package name */
    private final int f55560f;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: FileTreeWalk.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\"\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005\u00a8\u0006\u0006"}, d2 = {"Lkotlin/io/h$a;", "Lkotlin/io/h$c;", "Ljava/io/File;", "rootDir", "<init>", "(Ljava/io/File;)V", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static abstract class a extends c {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(@NotNull File rootDir) {
            super(rootDir);
            f0.p(rootDir, "rootDir");
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: FileTreeWalk.kt */
    @Metadata(bv = {}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0082\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\b\u0010\u000bB\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u000b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0082\u0010J\b\u0010\b\u001a\u00020\u0007H\u0014R\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u0011"}, d2 = {"Lkotlin/io/h$b;", "Lkotlin/collections/b;", "Ljava/io/File;", "root", "Lkotlin/io/h$a;", "g", "h", "Lkotlin/f1;", "a", "Ljava/util/ArrayDeque;", "Lkotlin/io/h$c;", "c", "Ljava/util/ArrayDeque;", "state", "<init>", "(Lkotlin/io/h;)V", "b", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    private final class b extends kotlin.collections.b<File> {
        @NotNull

        /* renamed from: c  reason: collision with root package name */
        private final ArrayDeque<c> f55561c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ h f55562d;

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
        /* compiled from: FileTreeWalk.kt */
        @Metadata(bv = {}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016R\u0016\u0010\u0006\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0005R\u001e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0010\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0005\u00a8\u0006\u0014"}, d2 = {"Lkotlin/io/h$b$a;", "Lkotlin/io/h$a;", "Ljava/io/File;", "b", "", "Z", "rootVisited", "", "c", "[Ljava/io/File;", "fileList", "", "d", "I", "fileIndex", "e", "failed", "rootDir", "<init>", "(Lkotlin/io/h$b;Ljava/io/File;)V", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0})
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        public final class a extends a {

            /* renamed from: b  reason: collision with root package name */
            private boolean f55563b;
            @Nullable

            /* renamed from: c  reason: collision with root package name */
            private File[] f55564c;

            /* renamed from: d  reason: collision with root package name */
            private int f55565d;

            /* renamed from: e  reason: collision with root package name */
            private boolean f55566e;

            /* renamed from: f  reason: collision with root package name */
            final /* synthetic */ b f55567f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(@NotNull b this$0, File rootDir) {
                super(rootDir);
                f0.p(this$0, "this$0");
                f0.p(rootDir, "rootDir");
                this.f55567f = this$0;
            }

            @Override // kotlin.io.h.c
            @Nullable
            public File b() {
                if (!this.f55566e && this.f55564c == null) {
                    d2.l lVar = this.f55567f.f55562d.f55557c;
                    boolean z3 = false;
                    if (lVar != null && !((Boolean) lVar.invoke(a())).booleanValue()) {
                        z3 = true;
                    }
                    if (z3) {
                        return null;
                    }
                    File[] listFiles = a().listFiles();
                    this.f55564c = listFiles;
                    if (listFiles == null) {
                        d2.p pVar = this.f55567f.f55562d.f55559e;
                        if (pVar != null) {
                            pVar.invoke(a(), new AccessDeniedException(a(), null, "Cannot list files in a directory", 2, null));
                        }
                        this.f55566e = true;
                    }
                }
                File[] fileArr = this.f55564c;
                if (fileArr != null) {
                    int i4 = this.f55565d;
                    f0.m(fileArr);
                    if (i4 < fileArr.length) {
                        File[] fileArr2 = this.f55564c;
                        f0.m(fileArr2);
                        int i5 = this.f55565d;
                        this.f55565d = i5 + 1;
                        return fileArr2[i5];
                    }
                }
                if (!this.f55563b) {
                    this.f55563b = true;
                    return a();
                }
                d2.l lVar2 = this.f55567f.f55562d.f55558d;
                if (lVar2 != null) {
                    lVar2.invoke(a());
                }
                return null;
            }
        }

        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
        /* compiled from: FileTreeWalk.kt */
        @Metadata(bv = {}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016R\u0016\u0010\u0006\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0005\u00a8\u0006\n"}, d2 = {"Lkotlin/io/h$b$b;", "Lkotlin/io/h$c;", "Ljava/io/File;", "b", "", "Z", "visited", "rootFile", "<init>", "(Lkotlin/io/h$b;Ljava/io/File;)V", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0})
        /* renamed from: kotlin.io.h$b$b  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        private final class C1101b extends c {

            /* renamed from: b  reason: collision with root package name */
            private boolean f55568b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ b f55569c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C1101b(@NotNull b this$0, File rootFile) {
                super(rootFile);
                f0.p(this$0, "this$0");
                f0.p(rootFile, "rootFile");
                this.f55569c = this$0;
            }

            @Override // kotlin.io.h.c
            @Nullable
            public File b() {
                if (this.f55568b) {
                    return null;
                }
                this.f55568b = true;
                return a();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
        /* compiled from: FileTreeWalk.kt */
        @Metadata(bv = {}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016R\u0016\u0010\u0006\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0005R\u001e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\r\u00a8\u0006\u0012"}, d2 = {"Lkotlin/io/h$b$c;", "Lkotlin/io/h$a;", "Ljava/io/File;", "b", "", "Z", "rootVisited", "", "c", "[Ljava/io/File;", "fileList", "", "d", "I", "fileIndex", "rootDir", "<init>", "(Lkotlin/io/h$b;Ljava/io/File;)V", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0})
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        public final class c extends a {

            /* renamed from: b  reason: collision with root package name */
            private boolean f55570b;
            @Nullable

            /* renamed from: c  reason: collision with root package name */
            private File[] f55571c;

            /* renamed from: d  reason: collision with root package name */
            private int f55572d;

            /* renamed from: e  reason: collision with root package name */
            final /* synthetic */ b f55573e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public c(@NotNull b this$0, File rootDir) {
                super(rootDir);
                f0.p(this$0, "this$0");
                f0.p(rootDir, "rootDir");
                this.f55573e = this$0;
            }

            /* JADX WARN: Code restructure failed: missing block: B:35:0x0086, code lost:
                if (r0.length == 0) goto L32;
             */
            @Override // kotlin.io.h.c
            @org.jetbrains.annotations.Nullable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public java.io.File b() {
                /*
                    r10 = this;
                    boolean r0 = r10.f55570b
                    r1 = 0
                    if (r0 != 0) goto L2d
                    kotlin.io.h$b r0 = r10.f55573e
                    kotlin.io.h r0 = r0.f55562d
                    d2.l r0 = kotlin.io.h.e(r0)
                    r2 = 0
                    r3 = 1
                    if (r0 != 0) goto L12
                    goto L23
                L12:
                    java.io.File r4 = r10.a()
                    java.lang.Object r0 = r0.invoke(r4)
                    java.lang.Boolean r0 = (java.lang.Boolean) r0
                    boolean r0 = r0.booleanValue()
                    if (r0 != 0) goto L23
                    r2 = 1
                L23:
                    if (r2 == 0) goto L26
                    return r1
                L26:
                    r10.f55570b = r3
                    java.io.File r0 = r10.a()
                    return r0
                L2d:
                    java.io.File[] r0 = r10.f55571c
                    if (r0 == 0) goto L4d
                    int r2 = r10.f55572d
                    kotlin.jvm.internal.f0.m(r0)
                    int r0 = r0.length
                    if (r2 >= r0) goto L3a
                    goto L4d
                L3a:
                    kotlin.io.h$b r0 = r10.f55573e
                    kotlin.io.h r0 = r0.f55562d
                    d2.l r0 = kotlin.io.h.g(r0)
                    if (r0 != 0) goto L45
                    goto L4c
                L45:
                    java.io.File r2 = r10.a()
                    r0.invoke(r2)
                L4c:
                    return r1
                L4d:
                    java.io.File[] r0 = r10.f55571c
                    if (r0 != 0) goto L9b
                    java.io.File r0 = r10.a()
                    java.io.File[] r0 = r0.listFiles()
                    r10.f55571c = r0
                    if (r0 != 0) goto L7e
                    kotlin.io.h$b r0 = r10.f55573e
                    kotlin.io.h r0 = r0.f55562d
                    d2.p r0 = kotlin.io.h.f(r0)
                    if (r0 != 0) goto L68
                    goto L7e
                L68:
                    java.io.File r2 = r10.a()
                    kotlin.io.AccessDeniedException r9 = new kotlin.io.AccessDeniedException
                    java.io.File r4 = r10.a()
                    r5 = 0
                    r7 = 2
                    r8 = 0
                    java.lang.String r6 = "Cannot list files in a directory"
                    r3 = r9
                    r3.<init>(r4, r5, r6, r7, r8)
                    r0.invoke(r2, r9)
                L7e:
                    java.io.File[] r0 = r10.f55571c
                    if (r0 == 0) goto L88
                    kotlin.jvm.internal.f0.m(r0)
                    int r0 = r0.length
                    if (r0 != 0) goto L9b
                L88:
                    kotlin.io.h$b r0 = r10.f55573e
                    kotlin.io.h r0 = r0.f55562d
                    d2.l r0 = kotlin.io.h.g(r0)
                    if (r0 != 0) goto L93
                    goto L9a
                L93:
                    java.io.File r2 = r10.a()
                    r0.invoke(r2)
                L9a:
                    return r1
                L9b:
                    java.io.File[] r0 = r10.f55571c
                    kotlin.jvm.internal.f0.m(r0)
                    int r1 = r10.f55572d
                    int r2 = r1 + 1
                    r10.f55572d = r2
                    r0 = r0[r1]
                    return r0
                */
                throw new UnsupportedOperationException("Method not decompiled: kotlin.io.h.b.c.b():java.io.File");
            }
        }

        /* compiled from: FileTreeWalk.kt */
        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        public /* synthetic */ class d {

            /* renamed from: a  reason: collision with root package name */
            public static final /* synthetic */ int[] f55574a;

            static {
                int[] iArr = new int[FileWalkDirection.values().length];
                iArr[FileWalkDirection.TOP_DOWN.ordinal()] = 1;
                iArr[FileWalkDirection.BOTTOM_UP.ordinal()] = 2;
                f55574a = iArr;
            }
        }

        public b(h this$0) {
            f0.p(this$0, "this$0");
            this.f55562d = this$0;
            ArrayDeque<c> arrayDeque = new ArrayDeque<>();
            this.f55561c = arrayDeque;
            if (this$0.f55555a.isDirectory()) {
                arrayDeque.push(g(this$0.f55555a));
            } else if (this$0.f55555a.isFile()) {
                arrayDeque.push(new C1101b(this, this$0.f55555a));
            } else {
                d();
            }
        }

        private final a g(File file) {
            int i4 = d.f55574a[this.f55562d.f55556b.ordinal()];
            if (i4 != 1) {
                if (i4 == 2) {
                    return new a(this, file);
                }
                throw new NoWhenBranchMatchedException();
            }
            return new c(this, file);
        }

        private final File h() {
            File b4;
            while (true) {
                c peek = this.f55561c.peek();
                if (peek == null) {
                    return null;
                }
                b4 = peek.b();
                if (b4 == null) {
                    this.f55561c.pop();
                } else if (f0.g(b4, peek.a()) || !b4.isDirectory() || this.f55561c.size() >= this.f55562d.f55560f) {
                    break;
                } else {
                    this.f55561c.push(g(b4));
                }
            }
            return b4;
        }

        @Override // kotlin.collections.b
        protected void a() {
            File h4 = h();
            if (h4 != null) {
                e(h4);
            } else {
                d();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: FileTreeWalk.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\"\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0004\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lkotlin/io/h$c;", "", "Ljava/io/File;", "b", "a", "Ljava/io/File;", "()Ljava/io/File;", "root", "<init>", "(Ljava/io/File;)V", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static abstract class c {
        @NotNull

        /* renamed from: a  reason: collision with root package name */
        private final File f55575a;

        public c(@NotNull File root) {
            f0.p(root, "root");
            this.f55575a = root;
        }

        @NotNull
        public final File a() {
            return this.f55575a;
        }

        @Nullable
        public abstract File b();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private h(File file, FileWalkDirection fileWalkDirection, d2.l<? super File, Boolean> lVar, d2.l<? super File, f1> lVar2, d2.p<? super File, ? super IOException, f1> pVar, int i4) {
        this.f55555a = file;
        this.f55556b = fileWalkDirection;
        this.f55557c = lVar;
        this.f55558d = lVar2;
        this.f55559e = pVar;
        this.f55560f = i4;
    }

    @NotNull
    public final h i(int i4) {
        if (i4 > 0) {
            return new h(this.f55555a, this.f55556b, this.f55557c, this.f55558d, this.f55559e, i4);
        }
        throw new IllegalArgumentException("depth must be positive, but was " + i4 + '.');
    }

    @Override // kotlin.sequences.m
    @NotNull
    public Iterator<File> iterator() {
        return new b(this);
    }

    @NotNull
    public final h j(@NotNull d2.l<? super File, Boolean> function) {
        f0.p(function, "function");
        return new h(this.f55555a, this.f55556b, function, this.f55558d, this.f55559e, this.f55560f);
    }

    @NotNull
    public final h k(@NotNull d2.p<? super File, ? super IOException, f1> function) {
        f0.p(function, "function");
        return new h(this.f55555a, this.f55556b, this.f55557c, this.f55558d, function, this.f55560f);
    }

    @NotNull
    public final h l(@NotNull d2.l<? super File, f1> function) {
        f0.p(function, "function");
        return new h(this.f55555a, this.f55556b, this.f55557c, function, this.f55559e, this.f55560f);
    }

    /* synthetic */ h(File file, FileWalkDirection fileWalkDirection, d2.l lVar, d2.l lVar2, d2.p pVar, int i4, int i5, u uVar) {
        this(file, (i5 & 2) != 0 ? FileWalkDirection.TOP_DOWN : fileWalkDirection, lVar, lVar2, pVar, (i5 & 32) != 0 ? Integer.MAX_VALUE : i4);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public h(@NotNull File start, @NotNull FileWalkDirection direction) {
        this(start, direction, null, null, null, 0, 32, null);
        f0.p(start, "start");
        f0.p(direction, "direction");
    }

    public /* synthetic */ h(File file, FileWalkDirection fileWalkDirection, int i4, u uVar) {
        this(file, (i4 & 2) != 0 ? FileWalkDirection.TOP_DOWN : fileWalkDirection);
    }
}

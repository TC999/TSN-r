package kotlin.p613io;

import com.kuaishou.weapon.p205p0.C7304t;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.io.File;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.AbstractIterator;
import kotlin.jvm.internal.C14342f0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.sequences.Sequence;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p617l1.InterfaceC15280l;
import p617l1.InterfaceC15284p;

/* compiled from: FileTreeWalk.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u0011\u0015$B\u008b\u0001\b\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0014\u0012\u0014\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\u0014\u0010\u001c\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t\u0018\u00010\u0005\u00128\u0010 \u001a4\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u0018\u0012\u0013\u0012\u00110\f¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001f\u0012\u0004\u0012\u00020\t\u0018\u00010\u000b\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u000e¢\u0006\u0004\b!\u0010\"B\u001b\b\u0010\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0014¢\u0006\u0004\b!\u0010#J\u000f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0003H\u0096\u0002J\u001a\u0010\b\u001a\u00020\u00002\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0005J\u001a\u0010\n\u001a\u00020\u00002\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t0\u0005J \u0010\r\u001a\u00020\u00002\u0018\u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\t0\u000bJ\u000e\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u000eR\u0014\u0010\u0013\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0017\u001a\u00020\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u001a\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019¨\u0006%"}, m12616d2 = {"Lkotlin/io/h;", "Lkotlin/sequences/m;", "Ljava/io/File;", "", "iterator", "Lkotlin/Function1;", "", "function", "j", "Lkotlin/f1;", C7304t.f25048d, "Lkotlin/Function2;", "Ljava/io/IOException;", "k", "", "depth", "i", "a", "Ljava/io/File;", CampaignEx.JSON_NATIVE_VIDEO_START, "Lkotlin/io/FileWalkDirection;", "b", "Lkotlin/io/FileWalkDirection;", "direction", "f", "I", "maxDepth", "onEnter", "onLeave", "Lkotlin/ParameterName;", "name", "e", "onFail", "<init>", "(Ljava/io/File;Lkotlin/io/FileWalkDirection;Ll1/l;Ll1/l;Ll1/p;I)V", "(Ljava/io/File;Lkotlin/io/FileWalkDirection;)V", "c", "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: kotlin.io.h */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class C14311h implements Sequence<File> {

    /* renamed from: a */
    private final File f41072a;

    /* renamed from: b */
    private final FileTreeWalk f41073b;

    /* renamed from: c */
    private final InterfaceC15280l<File, Boolean> f41074c;

    /* renamed from: d */
    private final InterfaceC15280l<File, Unit> f41075d;

    /* renamed from: e */
    private final InterfaceC15284p<File, IOException, Unit> f41076e;

    /* renamed from: f */
    private final int f41077f;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: FileTreeWalk.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\"\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, m12616d2 = {"Lkotlin/io/h$a;", "Lkotlin/io/h$c;", "Ljava/io/File;", "rootDir", "<init>", "(Ljava/io/File;)V", "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
    /* renamed from: kotlin.io.h$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static abstract class AbstractC14312a extends AbstractC14317c {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AbstractC14312a(@NotNull File rootDir) {
            super(rootDir);
            C14342f0.m8184p(rootDir, "rootDir");
        }
    }

    /* compiled from: FileTreeWalk.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0082\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\b\u0010\u000bB\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u000b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0082\u0010J\b\u0010\b\u001a\u00020\u0007H\u0014R\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u0011"}, m12616d2 = {"Lkotlin/io/h$b;", "Lkotlin/collections/c;", "Ljava/io/File;", "root", "Lkotlin/io/h$a;", "f", "g", "Lkotlin/f1;", "a", "Ljava/util/ArrayDeque;", "Lkotlin/io/h$c;", "c", "Ljava/util/ArrayDeque;", "state", "<init>", "(Lkotlin/io/h;)V", "b", "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
    /* renamed from: kotlin.io.h$b */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    private final class C14313b extends AbstractIterator<File> {

        /* renamed from: c */
        private final ArrayDeque<AbstractC14317c> f41078c;

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: FileTreeWalk.kt */
        @Metadata(m12618bv = {}, m12617d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0011\u001a\u00020\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016R\u0016\u0010\u0006\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0005R\u001e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0010\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0005¨\u0006\u0014"}, m12616d2 = {"Lkotlin/io/h$b$a;", "Lkotlin/io/h$a;", "Ljava/io/File;", "b", "", "Z", "rootVisited", "", "c", "[Ljava/io/File;", "fileList", "", "d", "I", "fileIndex", "e", "failed", "rootDir", "<init>", "(Lkotlin/io/h$b;Ljava/io/File;)V", "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
        /* renamed from: kotlin.io.h$b$a */
        /* loaded from: E:\fuckcool\tsn\5406560.dex */
        public final class C14314a extends AbstractC14312a {

            /* renamed from: b */
            private boolean f41080b;

            /* renamed from: c */
            private File[] f41081c;

            /* renamed from: d */
            private int f41082d;

            /* renamed from: e */
            private boolean f41083e;

            /* renamed from: f */
            final /* synthetic */ C14313b f41084f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C14314a(@NotNull C14313b c14313b, File rootDir) {
                super(rootDir);
                C14342f0.m8184p(rootDir, "rootDir");
                this.f41084f = c14313b;
            }

            @Override // kotlin.p613io.C14311h.AbstractC14317c
            @Nullable
            /* renamed from: b */
            public File mo8442b() {
                if (!this.f41083e && this.f41081c == null) {
                    InterfaceC15280l interfaceC15280l = C14311h.this.f41074c;
                    if (interfaceC15280l != null && !((Boolean) interfaceC15280l.invoke(m8443a())).booleanValue()) {
                        return null;
                    }
                    File[] listFiles = m8443a().listFiles();
                    this.f41081c = listFiles;
                    if (listFiles == null) {
                        InterfaceC15284p interfaceC15284p = C14311h.this.f41076e;
                        if (interfaceC15284p != null) {
                            Unit unit = (Unit) interfaceC15284p.invoke(m8443a(), new AccessDeniedException(m8443a(), null, "Cannot list files in a directory", 2, null));
                        }
                        this.f41083e = true;
                    }
                }
                File[] fileArr = this.f41081c;
                if (fileArr != null) {
                    int i = this.f41082d;
                    C14342f0.m8187m(fileArr);
                    if (i < fileArr.length) {
                        File[] fileArr2 = this.f41081c;
                        C14342f0.m8187m(fileArr2);
                        int i2 = this.f41082d;
                        this.f41082d = i2 + 1;
                        return fileArr2[i2];
                    }
                }
                if (!this.f41080b) {
                    this.f41080b = true;
                    return m8443a();
                }
                InterfaceC15280l interfaceC15280l2 = C14311h.this.f41075d;
                if (interfaceC15280l2 != null) {
                    Unit unit2 = (Unit) interfaceC15280l2.invoke(m8443a());
                }
                return null;
            }
        }

        /* compiled from: FileTreeWalk.kt */
        @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tJ\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016R\u0016\u0010\u0006\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0005¨\u0006\n"}, m12616d2 = {"Lkotlin/io/h$b$b;", "Lkotlin/io/h$c;", "Ljava/io/File;", "b", "", "Z", "visited", "rootFile", "<init>", "(Lkotlin/io/h$b;Ljava/io/File;)V", "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
        /* renamed from: kotlin.io.h$b$b */
        /* loaded from: E:\fuckcool\tsn\5406560.dex */
        private final class C14315b extends AbstractC14317c {

            /* renamed from: b */
            private boolean f41085b;

            /* renamed from: c */
            final /* synthetic */ C14313b f41086c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C14315b(@NotNull C14313b c14313b, File rootFile) {
                super(rootFile);
                C14342f0.m8184p(rootFile, "rootFile");
                this.f41086c = c14313b;
            }

            @Override // kotlin.p613io.C14311h.AbstractC14317c
            @Nullable
            /* renamed from: b */
            public File mo8442b() {
                if (this.f41085b) {
                    return null;
                }
                this.f41085b = true;
                return m8443a();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: FileTreeWalk.kt */
        @Metadata(m12618bv = {}, m12617d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016R\u0016\u0010\u0006\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0005R\u001e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0012"}, m12616d2 = {"Lkotlin/io/h$b$c;", "Lkotlin/io/h$a;", "Ljava/io/File;", "b", "", "Z", "rootVisited", "", "c", "[Ljava/io/File;", "fileList", "", "d", "I", "fileIndex", "rootDir", "<init>", "(Lkotlin/io/h$b;Ljava/io/File;)V", "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
        /* renamed from: kotlin.io.h$b$c */
        /* loaded from: E:\fuckcool\tsn\5406560.dex */
        public final class C14316c extends AbstractC14312a {

            /* renamed from: b */
            private boolean f41087b;

            /* renamed from: c */
            private File[] f41088c;

            /* renamed from: d */
            private int f41089d;

            /* renamed from: e */
            final /* synthetic */ C14313b f41090e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C14316c(@NotNull C14313b c14313b, File rootDir) {
                super(rootDir);
                C14342f0.m8184p(rootDir, "rootDir");
                this.f41090e = c14313b;
            }

            /* JADX WARN: Code restructure failed: missing block: B:30:0x0085, code lost:
                if (r0.length == 0) goto L30;
             */
            @Override // kotlin.p613io.C14311h.AbstractC14317c
            @org.jetbrains.annotations.Nullable
            /* renamed from: b */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public java.io.File mo8442b() {
                /*
                    r10 = this;
                    boolean r0 = r10.f41087b
                    r1 = 0
                    if (r0 != 0) goto L28
                    kotlin.io.h$b r0 = r10.f41090e
                    kotlin.io.h r0 = kotlin.p613io.C14311h.this
                    l1.l r0 = kotlin.p613io.C14311h.m8453e(r0)
                    if (r0 == 0) goto L20
                    java.io.File r2 = r10.m8443a()
                    java.lang.Object r0 = r0.invoke(r2)
                    java.lang.Boolean r0 = (java.lang.Boolean) r0
                    boolean r0 = r0.booleanValue()
                    if (r0 != 0) goto L20
                    return r1
                L20:
                    r0 = 1
                    r10.f41087b = r0
                    java.io.File r0 = r10.m8443a()
                    return r0
                L28:
                    java.io.File[] r0 = r10.f41088c
                    if (r0 == 0) goto L4a
                    int r2 = r10.f41089d
                    kotlin.jvm.internal.C14342f0.m8187m(r0)
                    int r0 = r0.length
                    if (r2 >= r0) goto L35
                    goto L4a
                L35:
                    kotlin.io.h$b r0 = r10.f41090e
                    kotlin.io.h r0 = kotlin.p613io.C14311h.this
                    l1.l r0 = kotlin.p613io.C14311h.m8451g(r0)
                    if (r0 == 0) goto L49
                    java.io.File r2 = r10.m8443a()
                    java.lang.Object r0 = r0.invoke(r2)
                    kotlin.f1 r0 = (kotlin.Unit) r0
                L49:
                    return r1
                L4a:
                    java.io.File[] r0 = r10.f41088c
                    if (r0 != 0) goto L9c
                    java.io.File r0 = r10.m8443a()
                    java.io.File[] r0 = r0.listFiles()
                    r10.f41088c = r0
                    if (r0 != 0) goto L7d
                    kotlin.io.h$b r0 = r10.f41090e
                    kotlin.io.h r0 = kotlin.p613io.C14311h.this
                    l1.p r0 = kotlin.p613io.C14311h.m8452f(r0)
                    if (r0 == 0) goto L7d
                    java.io.File r2 = r10.m8443a()
                    kotlin.io.AccessDeniedException r9 = new kotlin.io.AccessDeniedException
                    java.io.File r4 = r10.m8443a()
                    r5 = 0
                    r7 = 2
                    r8 = 0
                    java.lang.String r6 = "Cannot list files in a directory"
                    r3 = r9
                    r3.<init>(r4, r5, r6, r7, r8)
                    java.lang.Object r0 = r0.invoke(r2, r9)
                    kotlin.f1 r0 = (kotlin.Unit) r0
                L7d:
                    java.io.File[] r0 = r10.f41088c
                    if (r0 == 0) goto L87
                    kotlin.jvm.internal.C14342f0.m8187m(r0)
                    int r0 = r0.length
                    if (r0 != 0) goto L9c
                L87:
                    kotlin.io.h$b r0 = r10.f41090e
                    kotlin.io.h r0 = kotlin.p613io.C14311h.this
                    l1.l r0 = kotlin.p613io.C14311h.m8451g(r0)
                    if (r0 == 0) goto L9b
                    java.io.File r2 = r10.m8443a()
                    java.lang.Object r0 = r0.invoke(r2)
                    kotlin.f1 r0 = (kotlin.Unit) r0
                L9b:
                    return r1
                L9c:
                    java.io.File[] r0 = r10.f41088c
                    kotlin.jvm.internal.C14342f0.m8187m(r0)
                    int r1 = r10.f41089d
                    int r2 = r1 + 1
                    r10.f41089d = r2
                    r0 = r0[r1]
                    return r0
                */
                throw new UnsupportedOperationException("Method not decompiled: kotlin.p613io.C14311h.C14313b.C14316c.mo8442b():java.io.File");
            }
        }

        public C14313b() {
            ArrayDeque<AbstractC14317c> arrayDeque = new ArrayDeque<>();
            this.f41078c = arrayDeque;
            if (C14311h.this.f41072a.isDirectory()) {
                arrayDeque.push(m8445f(C14311h.this.f41072a));
            } else if (C14311h.this.f41072a.isFile()) {
                arrayDeque.push(new C14315b(this, C14311h.this.f41072a));
            } else {
                m12318c();
            }
        }

        /* renamed from: f */
        private final AbstractC14312a m8445f(File file) {
            int i = C14318i.f41092a[C14311h.this.f41073b.ordinal()];
            if (i != 1) {
                if (i == 2) {
                    return new C14314a(this, file);
                }
                throw new NoWhenBranchMatchedException();
            }
            return new C14316c(this, file);
        }

        /* renamed from: g */
        private final File m8444g() {
            File mo8442b;
            while (true) {
                AbstractC14317c peek = this.f41078c.peek();
                if (peek == null) {
                    return null;
                }
                mo8442b = peek.mo8442b();
                if (mo8442b == null) {
                    this.f41078c.pop();
                } else if (C14342f0.m8193g(mo8442b, peek.m8443a()) || !mo8442b.isDirectory() || this.f41078c.size() >= C14311h.this.f41077f) {
                    break;
                } else {
                    this.f41078c.push(m8445f(mo8442b));
                }
            }
            return mo8442b;
        }

        @Override // kotlin.collections.AbstractIterator
        /* renamed from: a */
        protected void mo7072a() {
            File m8444g = m8444g();
            if (m8444g != null) {
                m12317d(m8444g);
            } else {
                m12318c();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: FileTreeWalk.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\"\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tJ\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&R\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0004\u0010\u0006¨\u0006\n"}, m12616d2 = {"Lkotlin/io/h$c;", "", "Ljava/io/File;", "b", "a", "Ljava/io/File;", "()Ljava/io/File;", "root", "<init>", "(Ljava/io/File;)V", "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
    /* renamed from: kotlin.io.h$c */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static abstract class AbstractC14317c {
        @NotNull

        /* renamed from: a */
        private final File f41091a;

        public AbstractC14317c(@NotNull File root) {
            C14342f0.m8184p(root, "root");
            this.f41091a = root;
        }

        @NotNull
        /* renamed from: a */
        public final File m8443a() {
            return this.f41091a;
        }

        @Nullable
        /* renamed from: b */
        public abstract File mo8442b();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private C14311h(File file, FileTreeWalk fileTreeWalk, InterfaceC15280l<? super File, Boolean> interfaceC15280l, InterfaceC15280l<? super File, Unit> interfaceC15280l2, InterfaceC15284p<? super File, ? super IOException, Unit> interfaceC15284p, int i) {
        this.f41072a = file;
        this.f41073b = fileTreeWalk;
        this.f41074c = interfaceC15280l;
        this.f41075d = interfaceC15280l2;
        this.f41076e = interfaceC15284p;
        this.f41077f = i;
    }

    @NotNull
    /* renamed from: i */
    public final C14311h m8449i(int i) {
        if (i > 0) {
            return new C14311h(this.f41072a, this.f41073b, this.f41074c, this.f41075d, this.f41076e, i);
        }
        throw new IllegalArgumentException("depth must be positive, but was " + i + '.');
    }

    @Override // kotlin.sequences.Sequence
    @NotNull
    public Iterator<File> iterator() {
        return new C14313b();
    }

    @NotNull
    /* renamed from: j */
    public final C14311h m8448j(@NotNull InterfaceC15280l<? super File, Boolean> function) {
        C14342f0.m8184p(function, "function");
        return new C14311h(this.f41072a, this.f41073b, function, this.f41075d, this.f41076e, this.f41077f);
    }

    @NotNull
    /* renamed from: k */
    public final C14311h m8447k(@NotNull InterfaceC15284p<? super File, ? super IOException, Unit> function) {
        C14342f0.m8184p(function, "function");
        return new C14311h(this.f41072a, this.f41073b, this.f41074c, this.f41075d, function, this.f41077f);
    }

    @NotNull
    /* renamed from: l */
    public final C14311h m8446l(@NotNull InterfaceC15280l<? super File, Unit> function) {
        C14342f0.m8184p(function, "function");
        return new C14311h(this.f41072a, this.f41073b, this.f41074c, function, this.f41076e, this.f41077f);
    }

    /* synthetic */ C14311h(File file, FileTreeWalk fileTreeWalk, InterfaceC15280l interfaceC15280l, InterfaceC15280l interfaceC15280l2, InterfaceC15284p interfaceC15284p, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(file, (i2 & 2) != 0 ? FileTreeWalk.TOP_DOWN : fileTreeWalk, interfaceC15280l, interfaceC15280l2, interfaceC15284p, (i2 & 32) != 0 ? Integer.MAX_VALUE : i);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public C14311h(@NotNull File start, @NotNull FileTreeWalk direction) {
        this(start, direction, null, null, null, 0, 32, null);
        C14342f0.m8184p(start, "start");
        C14342f0.m8184p(direction, "direction");
    }

    public /* synthetic */ C14311h(File file, FileTreeWalk fileTreeWalk, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(file, (i & 2) != 0 ? FileTreeWalk.TOP_DOWN : fileTreeWalk);
    }
}

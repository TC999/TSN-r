package kotlin.p613io;

import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.C14342f0;
import org.jetbrains.annotations.NotNull;

/* compiled from: FileTreeWalk.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0014\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0001\u001a\n\u0010\u0005\u001a\u00020\u0003*\u00020\u0000\u001a\n\u0010\u0006\u001a\u00020\u0003*\u00020\u0000¨\u0006\u0007"}, m12616d2 = {"Ljava/io/File;", "Lkotlin/io/FileWalkDirection;", "direction", "Lkotlin/io/h;", "J", "M", "L", "kotlin-stdlib"}, m12615k = 5, m12614mv = {1, 5, 1}, m12611xs = "kotlin/io/FilesKt")
/* renamed from: kotlin.io.m */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
class C14323m extends C14321l {
    @NotNull
    /* renamed from: J */
    public static final C14311h m8405J(@NotNull File walk, @NotNull FileTreeWalk direction) {
        C14342f0.m8184p(walk, "$this$walk");
        C14342f0.m8184p(direction, "direction");
        return new C14311h(walk, direction);
    }

    /* renamed from: K */
    public static /* synthetic */ C14311h m8404K(File file, FileTreeWalk fileTreeWalk, int i, Object obj) {
        if ((i & 1) != 0) {
            fileTreeWalk = FileTreeWalk.TOP_DOWN;
        }
        return m8405J(file, fileTreeWalk);
    }

    @NotNull
    /* renamed from: L */
    public static final C14311h m8403L(@NotNull File walkBottomUp) {
        C14342f0.m8184p(walkBottomUp, "$this$walkBottomUp");
        return m8405J(walkBottomUp, FileTreeWalk.BOTTOM_UP);
    }

    @NotNull
    /* renamed from: M */
    public static final C14311h m8402M(@NotNull File walkTopDown) {
        C14342f0.m8184p(walkTopDown, "$this$walkTopDown");
        return m8405J(walkTopDown, FileTreeWalk.TOP_DOWN);
    }
}

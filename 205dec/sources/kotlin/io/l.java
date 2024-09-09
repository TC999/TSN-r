package kotlin.io;

import java.io.File;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.f1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: FileTreeWalk.kt */
@Metadata(bv = {}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0014\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0001\u001a\n\u0010\u0005\u001a\u00020\u0003*\u00020\u0000\u001a\n\u0010\u0006\u001a\u00020\u0003*\u00020\u0000\u00a8\u0006\u0007"}, d2 = {"Ljava/io/File;", "Lkotlin/io/FileWalkDirection;", "direction", "Lkotlin/io/h;", "J", "M", "L", "kotlin-stdlib"}, k = 5, mv = {1, 6, 0}, xs = "kotlin/io/FilesKt")
/* loaded from: E:\TSN-r\205dec\7343912.dex */
class l extends k {

    /* compiled from: FileReadWrite.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u000e\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "it", "Lkotlin/f1;", "a", "(Ljava/lang/String;)V"}, k = 3, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    static final class a extends Lambda implements l1.l<String, f1> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ArrayList f55577a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(ArrayList arrayList) {
            super(1);
            this.f55577a = arrayList;
        }

        public final void a(@NotNull String it) {
            f0.p(it, "it");
            this.f55577a.add(it);
        }

        @Override // l1.l
        public /* bridge */ /* synthetic */ f1 invoke(String str) {
            a(str);
            return f1.f55527a;
        }
    }

    @NotNull
    public static final h J(@NotNull File file, @NotNull FileWalkDirection direction) {
        f0.p(file, "<this>");
        f0.p(direction, "direction");
        return new h(file, direction);
    }

    public static /* synthetic */ h K(File file, FileWalkDirection fileWalkDirection, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            fileWalkDirection = FileWalkDirection.TOP_DOWN;
        }
        return J(file, fileWalkDirection);
    }

    @NotNull
    public static final h L(@NotNull File file) {
        f0.p(file, "<this>");
        return J(file, FileWalkDirection.BOTTOM_UP);
    }

    @NotNull
    public static final h M(@NotNull File file) {
        f0.p(file, "<this>");
        return J(file, FileWalkDirection.TOP_DOWN);
    }
}

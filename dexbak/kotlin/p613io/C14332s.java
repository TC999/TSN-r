package kotlin.p613io;

import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.C14342f0;
import master.flame.danmaku.danmaku.parser.IDataSource;
import org.jetbrains.annotations.NotNull;

/* compiled from: Utils.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, m12616d2 = {"Lkotlin/io/s;", "Lkotlin/io/FileSystemException;", "Ljava/io/File;", IDataSource.f43973c, "<init>", "(Ljava/io/File;)V", "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: kotlin.io.s */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
final class C14332s extends FileSystemException {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C14332s(@NotNull File file) {
        super(file, null, null, 6, null);
        C14342f0.m8184p(file, "file");
    }
}

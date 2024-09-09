package com.bxkj.base.v2.common.utils;

import java.io.File;
import java.io.FileOutputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.u;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: FileUtils.kt */
@Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0005"}, d2 = {"Lcom/bxkj/base/v2/common/utils/g;", "", "<init>", "()V", "a", "base_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public final class g {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final a f18605a = new a(null);

    /* compiled from: FileUtils.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0016\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002\u00a8\u0006\t"}, d2 = {"Lcom/bxkj/base/v2/common/utils/g$a;", "", "", "base64Code", "targetPath", "Ljava/io/File;", "a", "<init>", "()V", "base_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }

        @NotNull
        public final File a(@NotNull String base64Code, @NotNull String targetPath) {
            f0.p(base64Code, "base64Code");
            f0.p(targetPath, "targetPath");
            try {
                try {
                    byte[] a4 = cn.bluemobi.dylan.base.utils.b.a(base64Code);
                    FileOutputStream fileOutputStream = new FileOutputStream(targetPath);
                    fileOutputStream.write(a4);
                    fileOutputStream.close();
                    return new File(targetPath);
                } catch (Exception e4) {
                    e4.printStackTrace();
                    return new File(targetPath);
                }
            } catch (Throwable unused) {
                return new File(targetPath);
            }
        }
    }
}

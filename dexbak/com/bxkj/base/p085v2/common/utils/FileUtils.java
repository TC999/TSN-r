package com.bxkj.base.p085v2.common.utils;

import cn.bluemobi.dylan.base.utils.C1138b;
import java.io.File;
import java.io.FileOutputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.C14342f0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

@Metadata(m12618bv = {}, m12617d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, m12616d2 = {"Lcom/bxkj/base/v2/common/utils/g;", "", "<init>", "()V", "a", "base_release"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: com.bxkj.base.v2.common.utils.g */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class FileUtils {
    @NotNull

    /* renamed from: a */
    public static final C3962a f15115a = new C3962a(null);

    /* compiled from: FileUtils.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0016\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002¨\u0006\t"}, m12616d2 = {"Lcom/bxkj/base/v2/common/utils/g$a;", "", "", "base64Code", "targetPath", "Ljava/io/File;", "a", "<init>", "()V", "base_release"}, m12615k = 1, m12614mv = {1, 5, 1})
    /* renamed from: com.bxkj.base.v2.common.utils.g$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C3962a {
        private C3962a() {
        }

        public /* synthetic */ C3962a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        /* renamed from: a */
        public final File m43802a(@NotNull String base64Code, @NotNull String targetPath) {
            C14342f0.m8184p(base64Code, "base64Code");
            C14342f0.m8184p(targetPath, "targetPath");
            try {
                try {
                    byte[] m57769a = C1138b.m57769a(base64Code);
                    FileOutputStream fileOutputStream = new FileOutputStream(targetPath);
                    fileOutputStream.write(m57769a);
                    fileOutputStream.close();
                    return new File(targetPath);
                } catch (Exception e) {
                    e.printStackTrace();
                    return new File(targetPath);
                }
            } catch (Throwable unused) {
                return new File(targetPath);
            }
        }
    }
}

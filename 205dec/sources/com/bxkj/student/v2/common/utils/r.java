package com.bxkj.student.v2.common.utils;

import com.bxkj.student.v2.common.utils.s;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* compiled from: UploadTypeUtils.kt */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final /* synthetic */ class r {

    /* compiled from: UploadTypeUtils.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007\u00a8\u0006\b"}, d2 = {"Lcom/bxkj/student/v2/common/utils/r$a;", "", "", "uploadType", "", "a", "<init>", "()V", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ a f23401a = new a();

        private a() {
        }

        @JvmStatic
        @NotNull
        public final String a(int i4) {
            return i4 != 1 ? i4 != 2 ? i4 != 3 ? "\u6b63\u5e38\u63d0\u4ea4 " : "\u8d85\u65f6\u4e0a\u4f20" : "\u5f02\u5e38\u4e0a\u4f20" : "\u9000\u51fa\u4e0a\u4f20";
        }
    }

    static {
        s.a aVar = s.f23402a;
    }

    @JvmStatic
    @NotNull
    public static String a(int i4) {
        return s.f23402a.a(i4);
    }
}

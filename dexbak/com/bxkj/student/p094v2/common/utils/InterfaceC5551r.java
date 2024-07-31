package com.bxkj.student.p094v2.common.utils;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;

/* compiled from: UploadTypeUtils.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bf\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, m12616d2 = {"Lcom/bxkj/student/v2/common/utils/r;", "", "a", "student_xiaomiRelease"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: com.bxkj.student.v2.common.utils.r */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public interface InterfaceC5551r {
    @NotNull

    /* renamed from: a */
    public static final C5552a f20150a = C5552a.f20151a;

    /* compiled from: UploadTypeUtils.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¨\u0006\b"}, m12616d2 = {"Lcom/bxkj/student/v2/common/utils/r$a;", "", "", "uploadType", "", "a", "<init>", "()V", "student_xiaomiRelease"}, m12615k = 1, m12614mv = {1, 5, 1})
    /* renamed from: com.bxkj.student.v2.common.utils.r$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C5552a {

        /* renamed from: a */
        static final /* synthetic */ C5552a f20151a = new C5552a();

        private C5552a() {
        }

        @JvmStatic
        @NotNull
        /* renamed from: a */
        public final String m39051a(int i) {
            return i != 1 ? i != 2 ? i != 3 ? "正常提交 " : "超时上传" : "异常上传" : "退出上传";
        }
    }
}

package com.bxkj.student.p094v2.common.type;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;
import org.jetbrains.annotations.NotNull;

/* compiled from: FaceType.kt */
@Target({ElementType.TYPE, ElementType.TYPE_USE})
@Metadata(m12618bv = {}, m12617d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003B\u0000¨\u0006\u0004"}, m12616d2 = {"Lcom/bxkj/student/v2/common/type/FaceType;", "", "Companion", "a", "student_xiaomiRelease"}, m12615k = 1, m12614mv = {1, 5, 1})
@kotlin.annotation.Target(allowedTargets = {AnnotationTarget.CLASS, AnnotationTarget.TYPE})
@Retention(RetentionPolicy.SOURCE)
@kotlin.annotation.Retention(AnnotationRetention.SOURCE)
/* renamed from: com.bxkj.student.v2.common.type.FaceType */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public @interface FaceType {
    @NotNull
    public static final C5536a Companion = C5536a.f20072a;
    @NotNull
    public static final String End = "3";
    @NotNull
    public static final String Middle = "2";
    @NotNull
    public static final String Start = "1";

    /* compiled from: FaceType.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\b\u0010\u0004¨\u0006\f"}, m12616d2 = {"Lcom/bxkj/student/v2/common/type/FaceType$a;", "", "", "b", "Ljava/lang/String;", "Start", "c", "Middle", "d", "End", "<init>", "()V", "student_xiaomiRelease"}, m12615k = 1, m12614mv = {1, 5, 1})
    /* renamed from: com.bxkj.student.v2.common.type.FaceType$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C5536a {

        /* renamed from: a */
        static final /* synthetic */ C5536a f20072a = new C5536a();
        @NotNull

        /* renamed from: b */
        public static final String f20073b = "1";
        @NotNull

        /* renamed from: c */
        public static final String f20074c = "2";
        @NotNull

        /* renamed from: d */
        public static final String f20075d = "3";

        private C5536a() {
        }
    }
}

package com.bxkj.student.p094v2.common.type;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;
import org.jetbrains.annotations.NotNull;

/* compiled from: SportsRecordStatus.kt */
@Target({ElementType.TYPE, ElementType.TYPE_USE})
@Metadata(m12618bv = {}, m12617d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003B\u0000¨\u0006\u0004"}, m12616d2 = {"Lcom/bxkj/student/v2/common/type/SportsRecordStatus;", "", "Companion", "a", "student_xiaomiRelease"}, m12615k = 1, m12614mv = {1, 5, 1})
@kotlin.annotation.Target(allowedTargets = {AnnotationTarget.CLASS, AnnotationTarget.TYPE})
@Retention(RetentionPolicy.SOURCE)
@kotlin.annotation.Retention(AnnotationRetention.SOURCE)
/* renamed from: com.bxkj.student.v2.common.type.SportsRecordStatus */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public @interface SportsRecordStatus {
    @NotNull
    public static final C5538a Companion = C5538a.f20082a;
    @NotNull
    public static final String INVALID = "0";
    @NotNull
    public static final String LOCAL = "-1";
    @NotNull
    public static final String PENDING_APPROVAL = "2";
    @NotNull
    public static final String VALID = "1";

    /* compiled from: SportsRecordStatus.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\f\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rR\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0014\u0010\u000b\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\n\u0010\u0004¨\u0006\u000e"}, m12616d2 = {"Lcom/bxkj/student/v2/common/type/SportsRecordStatus$a;", "", "", "b", "Ljava/lang/String;", "LOCAL", "c", "INVALID", "d", "VALID", "e", "PENDING_APPROVAL", "<init>", "()V", "student_xiaomiRelease"}, m12615k = 1, m12614mv = {1, 5, 1})
    /* renamed from: com.bxkj.student.v2.common.type.SportsRecordStatus$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C5538a {

        /* renamed from: a */
        static final /* synthetic */ C5538a f20082a = new C5538a();
        @NotNull

        /* renamed from: b */
        public static final String f20083b = "-1";
        @NotNull

        /* renamed from: c */
        public static final String f20084c = "0";
        @NotNull

        /* renamed from: d */
        public static final String f20085d = "1";
        @NotNull

        /* renamed from: e */
        public static final String f20086e = "2";

        private C5538a() {
        }
    }
}

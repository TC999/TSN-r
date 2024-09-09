package com.bxkj.student.v2.common.type;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: MenuType.kt */
@Target({ElementType.TYPE, ElementType.TYPE_USE})
@Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003B\u0000\u00a8\u0006\u0004"}, d2 = {"Lcom/bxkj/student/v2/common/type/MenuType;", "", "Companion", "a", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
@kotlin.annotation.Target(allowedTargets = {AnnotationTarget.CLASS, AnnotationTarget.TYPE})
@Retention(RetentionPolicy.SOURCE)
@kotlin.annotation.Retention(AnnotationRetention.SOURCE)
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public @interface MenuType {
    @NotNull
    public static final String CLASSIFY = "2";
    @NotNull
    public static final a Companion = a.f23321a;
    @NotNull
    public static final String HOME = "1";
    @NotNull
    public static final String MY = "5";
    @NotNull
    public static final String Navigation = "0";

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* compiled from: MenuType.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\f\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rR\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0014\u0010\u000b\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0004\u00a8\u0006\u000e"}, d2 = {"Lcom/bxkj/student/v2/common/type/MenuType$a;", "", "", "b", "Ljava/lang/String;", "Navigation", "c", "HOME", "d", "CLASSIFY", "e", "MY", "<init>", "()V", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ a f23321a = new a();
        @NotNull

        /* renamed from: b  reason: collision with root package name */
        public static final String f23322b = "0";
        @NotNull

        /* renamed from: c  reason: collision with root package name */
        public static final String f23323c = "1";
        @NotNull

        /* renamed from: d  reason: collision with root package name */
        public static final String f23324d = "2";
        @NotNull

        /* renamed from: e  reason: collision with root package name */
        public static final String f23325e = "5";

        private a() {
        }
    }
}

package com.bxkj.base.v2.netty4android.client.heart;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;

/* compiled from: AlarmActionType.kt */
@Retention(RetentionPolicy.SOURCE)
@Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003B\u0000\u00a8\u0006\u0004"}, d2 = {"Lcom/bxkj/base/v2/netty4android/client/heart/AlarmActionType;", "", "Companion", "a", "base_release"}, k = 1, mv = {1, 5, 1})
@kotlin.annotation.Retention(AnnotationRetention.SOURCE)
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public @interface AlarmActionType {
    @NotNull
    public static final a Companion = a.f18778a;

    /* compiled from: AlarmActionType.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nR\"\u0010\b\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0003\u0010\u0007\u00a8\u0006\u000b"}, d2 = {"Lcom/bxkj/base/v2/netty4android/client/heart/AlarmActionType$a;", "", "", "b", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "(Ljava/lang/String;)V", "CHECK_HEART_TIMEOUT", "<init>", "()V", "base_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\4499832.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ a f18778a = new a();
        @NotNull

        /* renamed from: b  reason: collision with root package name */
        private static String f18779b = "CHECK_HEART_TIMEOUT";

        private a() {
        }

        @NotNull
        public final String a() {
            return f18779b;
        }

        public final void b(@NotNull String str) {
            f0.p(str, "<set-?>");
            f18779b = str;
        }
    }
}

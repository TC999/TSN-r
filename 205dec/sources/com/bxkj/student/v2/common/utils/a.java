package com.bxkj.student.v2.common.utils;

import android.app.Activity;
import com.bxkj.student.v2.ui.face.FaceDetectV3Activity;
import com.bxkj.student.v2.ui.face.FaceLiveV3Activity;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* compiled from: ActivityManager.kt */
@Metadata(bv = {}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0002R\u001e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\b\u00a8\u0006\f"}, d2 = {"Lcom/bxkj/student/v2/common/utils/a;", "", "Landroid/app/Activity;", "a", "activity", "Lkotlin/f1;", "b", "Ljava/lang/ref/WeakReference;", "Ljava/lang/ref/WeakReference;", "sCurrentActivityWeakRef", "<init>", "()V", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class a {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final a f23334a = new a();
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private static WeakReference<Activity> f23335b;

    private a() {
    }

    @Nullable
    public final Activity a() {
        WeakReference<Activity> weakReference = f23335b;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    public final void b(@NotNull Activity activity) {
        f0.p(activity, "activity");
        if ((activity instanceof FaceDetectV3Activity) || (activity instanceof FaceLiveV3Activity)) {
            return;
        }
        f23335b = new WeakReference<>(activity);
    }
}

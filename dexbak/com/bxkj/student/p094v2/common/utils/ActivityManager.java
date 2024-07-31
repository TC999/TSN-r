package com.bxkj.student.p094v2.common.utils;

import android.app.Activity;
import com.bxkj.student.p094v2.p098ui.face.FaceDetectV3Activity;
import com.bxkj.student.p094v2.p098ui.face.FaceLiveV3Activity;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.C14342f0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(m12618bv = {}, m12617d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0002R\u001e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\b¨\u0006\f"}, m12616d2 = {"Lcom/bxkj/student/v2/common/utils/a;", "", "Landroid/app/Activity;", "a", TTDownloadField.TT_ACTIVITY, "Lkotlin/f1;", "b", "Ljava/lang/ref/WeakReference;", "Ljava/lang/ref/WeakReference;", "sCurrentActivityWeakRef", "<init>", "()V", "student_xiaomiRelease"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: com.bxkj.student.v2.common.utils.a */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class ActivityManager {
    @NotNull

    /* renamed from: a */
    public static final ActivityManager f20090a = new ActivityManager();
    @Nullable

    /* renamed from: b */
    private static WeakReference<Activity> f20091b;

    private ActivityManager() {
    }

    @Nullable
    /* renamed from: a */
    public final Activity m39150a() {
        WeakReference<Activity> weakReference = f20091b;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    /* renamed from: b */
    public final void m39149b(@NotNull Activity activity) {
        C14342f0.m8184p(activity, "activity");
        if ((activity instanceof FaceDetectV3Activity) || (activity instanceof FaceLiveV3Activity)) {
            return;
        }
        f20091b = new WeakReference<>(activity);
    }
}

package com.bytedance.pangle.fragment;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.app.Fragment;
import android.os.Bundle;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.bytedance.pangle.util.FieldUtils;
import java.lang.reflect.Array;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
@SuppressLint({"NewApi"})
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public final class c implements Application.ActivityLifecycleCallbacks {

    /* renamed from: a  reason: collision with root package name */
    Fragment f28772a;

    public c(Fragment fragment) {
        this.f28772a = fragment;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPostSaveInstanceState(@NonNull Activity activity, @NonNull Bundle bundle) {
        Object[] objArr;
        if (this.f28772a.getActivity() != activity) {
            return;
        }
        try {
            Parcelable parcelable = bundle.getParcelable("android:fragments");
            if (parcelable == null || (objArr = (Object[]) FieldUtils.readField(parcelable, "mActive")) == null) {
                return;
            }
            Object obj = null;
            for (Object obj2 : objArr) {
                Object readField = FieldUtils.readField(obj2, "mTag");
                if (!"androidx.lifecycle.LifecycleDispatcher.report_fragment_tag_plugin".equals(readField) && (!(readField instanceof String) || (!((String) readField).contains("androidx.lifecycle.LifecycleDispatcher.report_fragment_tag_pangle") && !((String) readField).contains("androidx.lifecycle.LifecycleDispatcher.report_fragment_tag_pangle")))) {
                }
                obj = obj2;
                break;
            }
            if (obj != null) {
                Object[] objArr2 = (Object[]) Array.newInstance(Class.forName("android.app.FragmentState"), objArr.length - 1);
                int[] iArr = new int[objArr.length - 1];
                int i4 = 0;
                for (int i5 = 0; i5 < objArr.length; i5++) {
                    if (objArr[i5] != obj) {
                        objArr2[i4] = objArr[i5];
                        iArr[i4] = i5;
                        i4++;
                    }
                }
                FieldUtils.writeField(parcelable, "mActive", objArr2);
                FieldUtils.writeField(parcelable, "mAdded", iArr);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        Object[] objArr;
        if (this.f28772a.getActivity() != activity) {
            return;
        }
        try {
            Parcelable parcelable = bundle.getParcelable("android:fragments");
            if (parcelable == null || (objArr = (Object[]) FieldUtils.readField(parcelable, "mActive")) == null) {
                return;
            }
            Object obj = null;
            for (Object obj2 : objArr) {
                Object readField = FieldUtils.readField(obj2, "mTag");
                if (!"androidx.lifecycle.LifecycleDispatcher.report_fragment_tag_plugin".equals(readField) && (!(readField instanceof String) || (!((String) readField).contains("androidx.lifecycle.LifecycleDispatcher.report_fragment_tag_pangle") && !((String) readField).contains("androidx.lifecycle.LifecycleDispatcher.report_fragment_tag_pangle")))) {
                }
                obj = obj2;
                break;
            }
            if (obj != null) {
                Object[] objArr2 = (Object[]) Array.newInstance(Class.forName("android.app.FragmentState"), objArr.length - 1);
                int[] iArr = new int[objArr.length - 1];
                int i4 = 0;
                for (int i5 = 0; i5 < objArr.length; i5++) {
                    if (objArr[i5] != obj) {
                        objArr2[i4] = objArr[i5];
                        iArr[i4] = i5;
                        i4++;
                    }
                }
                FieldUtils.writeField(parcelable, "mActive", objArr2);
                FieldUtils.writeField(parcelable, "mAdded", iArr);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
    }
}

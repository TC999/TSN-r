package cn.bluemobi.dylan.photoview.library.gestures;

import android.content.Context;

/* renamed from: cn.bluemobi.dylan.photoview.library.gestures.f */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class VersionedGestureDetector {
    /* renamed from: a */
    public static GestureDetector m57510a(Context context, OnGestureListener onGestureListener) {
        FroyoGestureDetector froyoGestureDetector = new FroyoGestureDetector(context);
        froyoGestureDetector.mo57516a(onGestureListener);
        return froyoGestureDetector;
    }
}

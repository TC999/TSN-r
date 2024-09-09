package com.bytedance.msdk.api.sr.c.c;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.msdk.api.sr.c.r.k;
import com.bytedance.sdk.openadsdk.TTDislikeDialogAbstract;
import com.bytedance.sdk.openadsdk.ys.w.w.ev;
import java.util.List;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public interface xv {
    com.bytedance.sdk.openadsdk.ys.w.w.sr a();

    @Nullable
    com.bytedance.msdk.api.sr.w c(Activity activity);

    @Nullable
    com.bytedance.msdk.api.sr.w c(Activity activity, Map<String, Object> map);

    @Nullable
    String c();

    void c(@NonNull Activity activity, @NonNull ViewGroup viewGroup, @NonNull List<View> list, @Nullable List<View> list2, @NonNull List<View> list3, k kVar);

    void c(Activity activity, com.bytedance.sdk.openadsdk.s.c.w.c.c cVar);

    void c(TTDislikeDialogAbstract tTDislikeDialogAbstract);

    int ev();

    @Nullable
    List<String> f();

    int gd();

    boolean k();

    @Nullable
    com.bytedance.msdk.api.sr.c.r.w p();

    @Nullable
    String r();

    @Nullable
    String sr();

    double ux();

    ev w(Activity activity);

    ev w(TTDislikeDialogAbstract tTDislikeDialogAbstract);

    @Nullable
    String w();

    @Nullable
    String xv();
}

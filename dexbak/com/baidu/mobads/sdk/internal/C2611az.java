package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.support.p015v4.media.RatingCompat;
import androidx.annotation.NonNull;
import androidx.collection.ArraySet;
import androidx.collection.LongSparseArray;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.viewpager.widget.ViewPager;

/* renamed from: com.baidu.mobads.sdk.internal.az */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class C2611az {
    /* renamed from: a */
    public static void m50844a(@NonNull Context context) {
        try {
            ViewCompat.generateViewId();
            AccessibilityNodeInfoCompat.obtain();
            LocalBroadcastManager.getInstance(context);
            new ViewPager(context);
            new NestedScrollView(context);
            new Fragment();
            new SwipeRefreshLayout(context);
            new RecyclerView(context);
            RatingCompat.newPercentageRating(1.0f);
            new ArraySet();
            new LongSparseArray();
            new LinearLayoutManager(context);
            new PagerSnapHelper();
        } catch (Throwable th) {
            C2634bs.m50744a().m50738a(th);
        }
    }
}

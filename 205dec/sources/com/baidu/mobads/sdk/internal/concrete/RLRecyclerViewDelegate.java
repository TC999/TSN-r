package com.baidu.mobads.sdk.internal.concrete;

import android.content.Context;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mobads.sdk.internal.a.a;
import com.baidu.mobads.sdk.internal.a.b;
import com.baidu.mobads.sdk.internal.a.c;
import com.baidu.mobads.sdk.internal.widget.RLRecyclerView;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class RLRecyclerViewDelegate extends RLRecyclerView implements a {

    /* renamed from: a  reason: collision with root package name */
    private final c f12669a;

    /* renamed from: b  reason: collision with root package name */
    private final b f12670b;

    public RLRecyclerViewDelegate(IAdInterListener iAdInterListener, Object[] objArr) {
        super((Context) objArr[0]);
        b bVar = new b();
        this.f12670b = bVar;
        setLayoutManager(bVar.a(objArr, 1, 1), bVar.a(objArr, 2, 1), bVar.a(objArr, 3, 0));
        this.f12669a = c.a(iAdInterListener, this);
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public int getCode() {
        return this.f12669a.getCode();
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public Map<String, Object> getData() {
        return this.f12669a.getData();
    }

    @Override // com.baidu.mobads.sdk.internal.a.a
    @NonNull
    public IAdInterListener getDelegator() {
        return this.f12669a.getDelegator();
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public String getMessage() {
        return this.f12669a.getMessage();
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public Object getTarget() {
        return this.f12669a.getTarget();
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public String getType() {
        return this.f12669a.getType();
    }

    @Override // com.baidu.mobads.sdk.internal.a.a
    public Object handleEvent(String str, String str2, Object[] objArr) {
        if ("setAdapter".equals(str2)) {
            setAdapter((RecyclerView.Adapter) objArr[0]);
            return null;
        } else if ("setRefreshing".equals(str2)) {
            setRefreshing(((Boolean) objArr[0]).booleanValue());
            return null;
        } else if ("setItemDecoration".equals(str2)) {
            setItemDecoration(this.f12670b.a(objArr, 0, 4), this.f12670b.a(objArr, 1, 10), this.f12670b.a(objArr, 2, 4), this.f12670b.a(objArr, 3, 10));
            return null;
        } else if ("setRvPadding".equals(str2)) {
            setRecyclerViewPadding(this.f12670b.a(objArr, 0, 6), this.f12670b.a(objArr, 1, 0), this.f12670b.a(objArr, 2, 6), this.f12670b.a(objArr, 3, 0));
            return null;
        } else if ("setRefreshEnable".equals(str2)) {
            setEnabled(((Boolean) objArr[0]).booleanValue());
            return null;
        } else if ("scrollToPosition".equals(str2)) {
            scrollToPosition(this.f12670b.a(objArr, 0, 0));
            return null;
        } else if ("addOnScrollListener".equals(str2)) {
            final Object obj = objArr[0];
            addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.baidu.mobads.sdk.internal.concrete.RLRecyclerViewDelegate.1
                @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
                public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i4) {
                    super.onScrollStateChanged(recyclerView, i4);
                    RLRecyclerViewDelegate.this.f12669a.a("onScrollStateChanged", obj, Integer.valueOf(i4));
                }

                @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
                public void onScrolled(@NonNull RecyclerView recyclerView, int i4, int i5) {
                    super.onScrolled(recyclerView, i4, i5);
                    RLRecyclerViewDelegate.this.f12669a.a("onScrolled", obj, Integer.valueOf(i4), Integer.valueOf(i5));
                }
            });
            return null;
        } else if ("setOnRefreshListener".equals(str2)) {
            setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: com.baidu.mobads.sdk.internal.concrete.RLRecyclerViewDelegate.2
                @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
                public void onRefresh() {
                    RLRecyclerViewDelegate.this.f12669a.a("onRefresh");
                }
            });
            return null;
        } else if ("findVisibleItemPositions".equals(str2)) {
            return findVisibleItemPositions();
        } else {
            if ("getLayoutManagerCounts".equals(str2)) {
                return getLayoutManagerCounts();
            }
            if ("getRvChildAt".equals(str2)) {
                return getRvChildAt(this.f12670b.a(objArr, 0, -1));
            }
            if ("getRvChildCount".equals(str2)) {
                return Integer.valueOf(getRvChildCount());
            }
            if ("indexOfRvChild".equals(str2)) {
                return Integer.valueOf(indexOfRvChild((View) objArr[0]));
            }
            if ("getChildAdapterPosition".equals(str2)) {
                return Integer.valueOf(getChildAdapterPosition((View) objArr[0]));
            }
            return null;
        }
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public void setTarget(Object obj) {
        this.f12669a.setTarget(obj);
    }
}

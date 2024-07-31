package com.baidu.mobads.sdk.internal.concrete;

import android.content.Context;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mobads.sdk.internal.p050a.C2575b;
import com.baidu.mobads.sdk.internal.p050a.C2576c;
import com.baidu.mobads.sdk.internal.p050a.InterfaceC2574a;
import com.baidu.mobads.sdk.internal.widget.RLRecyclerView;
import java.util.Map;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class RLRecyclerViewDelegate extends RLRecyclerView implements InterfaceC2574a {

    /* renamed from: a */
    private final C2576c f8868a;

    /* renamed from: b */
    private final C2575b f8869b;

    public RLRecyclerViewDelegate(IAdInterListener iAdInterListener, Object[] objArr) {
        super((Context) objArr[0]);
        C2575b c2575b = new C2575b();
        this.f8869b = c2575b;
        setLayoutManager(c2575b.m51076a(objArr, 1, 1), c2575b.m51076a(objArr, 2, 1), c2575b.m51076a(objArr, 3, 0));
        this.f8868a = C2576c.m51074a(iAdInterListener, this);
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public int getCode() {
        return this.f8868a.getCode();
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public Map<String, Object> getData() {
        return this.f8868a.getData();
    }

    @Override // com.baidu.mobads.sdk.internal.p050a.InterfaceC2574a
    @NonNull
    public IAdInterListener getDelegator() {
        return this.f8868a.getDelegator();
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public String getMessage() {
        return this.f8868a.getMessage();
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public Object getTarget() {
        return this.f8868a.getTarget();
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public String getType() {
        return this.f8868a.getType();
    }

    @Override // com.baidu.mobads.sdk.internal.p050a.InterfaceC2574a
    public Object handleEvent(String str, String str2, Object[] objArr) {
        if ("setAdapter".equals(str2)) {
            setAdapter((RecyclerView.Adapter) objArr[0]);
            return null;
        } else if ("setRefreshing".equals(str2)) {
            setRefreshing(((Boolean) objArr[0]).booleanValue());
            return null;
        } else if ("setItemDecoration".equals(str2)) {
            setItemDecoration(this.f8869b.m51076a(objArr, 0, 4), this.f8869b.m51076a(objArr, 1, 10), this.f8869b.m51076a(objArr, 2, 4), this.f8869b.m51076a(objArr, 3, 10));
            return null;
        } else if ("setRvPadding".equals(str2)) {
            setRecyclerViewPadding(this.f8869b.m51076a(objArr, 0, 6), this.f8869b.m51076a(objArr, 1, 0), this.f8869b.m51076a(objArr, 2, 6), this.f8869b.m51076a(objArr, 3, 0));
            return null;
        } else if ("setRefreshEnable".equals(str2)) {
            setEnabled(((Boolean) objArr[0]).booleanValue());
            return null;
        } else if ("scrollToPosition".equals(str2)) {
            scrollToPosition(this.f8869b.m51076a(objArr, 0, 0));
            return null;
        } else if ("addOnScrollListener".equals(str2)) {
            final Object obj = objArr[0];
            addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.baidu.mobads.sdk.internal.concrete.RLRecyclerViewDelegate.1
                @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
                public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i) {
                    super.onScrollStateChanged(recyclerView, i);
                    RLRecyclerViewDelegate.this.f8868a.m51072a("onScrollStateChanged", obj, Integer.valueOf(i));
                }

                @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
                public void onScrolled(@NonNull RecyclerView recyclerView, int i, int i2) {
                    super.onScrolled(recyclerView, i, i2);
                    RLRecyclerViewDelegate.this.f8868a.m51072a("onScrolled", obj, Integer.valueOf(i), Integer.valueOf(i2));
                }
            });
            return null;
        } else if ("setOnRefreshListener".equals(str2)) {
            setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: com.baidu.mobads.sdk.internal.concrete.RLRecyclerViewDelegate.2
                @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
                public void onRefresh() {
                    RLRecyclerViewDelegate.this.f8868a.m51073a("onRefresh");
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
                return getRvChildAt(this.f8869b.m51076a(objArr, 0, -1));
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
        this.f8868a.setTarget(obj);
    }
}

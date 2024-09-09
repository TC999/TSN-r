package com.baidu.mobads.sdk.internal.concrete;

import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mobads.sdk.internal.a.a;
import com.baidu.mobads.sdk.internal.a.b;
import com.baidu.mobads.sdk.internal.a.c;
import com.baidu.mobads.sdk.internal.widget.ViewPager2;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class RVAdapterDelegate extends RecyclerView.Adapter<RVViewHolderDelegate> implements a {

    /* renamed from: a  reason: collision with root package name */
    private final c f12674a;

    /* renamed from: b  reason: collision with root package name */
    private final b f12675b;

    public RVAdapterDelegate(@NonNull IAdInterListener iAdInterListener) {
        this.f12674a = c.a(iAdInterListener, this);
        registerAdapterDataObserver(new ViewPager2.DataSetChangeObserver() { // from class: com.baidu.mobads.sdk.internal.concrete.RVAdapterDelegate.1
            @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.DataSetChangeObserver, androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onChanged() {
                RVAdapterDelegate.this.f12674a.a("onChanged");
            }
        });
        this.f12675b = new b();
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public int getCode() {
        return this.f12674a.getCode();
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public Map<String, Object> getData() {
        return this.f12674a.getData();
    }

    @Override // com.baidu.mobads.sdk.internal.a.a
    @NonNull
    public IAdInterListener getDelegator() {
        return this.f12674a.getDelegator();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        Object a4 = this.f12674a.a("getItemCount", new Object[0]);
        if (a4 instanceof Integer) {
            return ((Integer) a4).intValue();
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i4) {
        Object a4 = this.f12674a.a("getItemId", Integer.valueOf(i4));
        if (a4 instanceof Integer) {
            return ((Integer) a4).intValue();
        }
        return super.getItemId(i4);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i4) {
        Object a4 = this.f12674a.a("getItemType", Integer.valueOf(i4));
        if (a4 instanceof Integer) {
            return ((Integer) a4).intValue();
        }
        return super.getItemViewType(i4);
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public String getMessage() {
        return this.f12674a.getMessage();
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public Object getTarget() {
        return this.f12674a.getTarget();
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public String getType() {
        return this.f12674a.getType();
    }

    @Override // com.baidu.mobads.sdk.internal.a.a
    public Object handleEvent(String str, String str2, Object[] objArr) {
        if ("notifyItemChanged".equals(str2)) {
            notifyItemChanged(this.f12675b.a(objArr, 0, 0), this.f12675b.a(objArr, 1, (Object) null));
        } else if ("notifyRangeInserted".equals(str2)) {
            notifyItemRangeInserted(this.f12675b.a(objArr, 0, 0), this.f12675b.a(objArr, 1, 0));
        } else if ("notifyRangeRemoved".equals(str2)) {
            notifyItemRangeRemoved(this.f12675b.a(objArr, 0, 0), this.f12675b.a(objArr, 1, 0));
        } else if ("notifyItemRangeChanged".equals(str2)) {
            notifyItemRangeChanged(this.f12675b.a(objArr, 0, 0), this.f12675b.a(objArr, 1, 0));
        } else if ("notifyDataSetChanged".equals(str2)) {
            notifyDataSetChanged();
        }
        return null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        this.f12674a.a("onAttachedToRecyclerView", recyclerView);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onDetachedFromRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
        this.f12674a.a("onDetachedFromRecyclerView", recyclerView);
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public void setTarget(Object obj) {
        this.f12674a.setTarget(obj);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RVViewHolderDelegate rVViewHolderDelegate, int i4) {
        this.f12674a.a("onBindViewHolder", rVViewHolderDelegate.getDelegator(), Integer.valueOf(i4));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RVViewHolderDelegate onCreateViewHolder(@NonNull ViewGroup viewGroup, int i4) {
        Object a4 = this.f12674a.a("onCreateViewHolder", viewGroup, Integer.valueOf(i4));
        if (a4 instanceof RVViewHolderDelegate) {
            return (RVViewHolderDelegate) a4;
        }
        return new RVViewHolderDelegate(this.f12674a.getDelegator(), viewGroup) { // from class: com.baidu.mobads.sdk.internal.concrete.RVAdapterDelegate.2
        };
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public boolean onFailedToRecycleView(@NonNull RVViewHolderDelegate rVViewHolderDelegate) {
        Object a4 = this.f12674a.a("onFailedToRecycleView", rVViewHolderDelegate.getDelegator());
        if (a4 instanceof Boolean) {
            return ((Boolean) a4).booleanValue();
        }
        return super.onFailedToRecycleView((RVAdapterDelegate) rVViewHolderDelegate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewAttachedToWindow(@NonNull RVViewHolderDelegate rVViewHolderDelegate) {
        super.onViewAttachedToWindow((RVAdapterDelegate) rVViewHolderDelegate);
        this.f12674a.a("onViewAttachedToWindow", rVViewHolderDelegate.getDelegator());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewDetachedFromWindow(@NonNull RVViewHolderDelegate rVViewHolderDelegate) {
        super.onViewDetachedFromWindow((RVAdapterDelegate) rVViewHolderDelegate);
        this.f12674a.a("onViewDetachedFromWindow", rVViewHolderDelegate.getDelegator());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewRecycled(@NonNull RVViewHolderDelegate rVViewHolderDelegate) {
        super.onViewRecycled((RVAdapterDelegate) rVViewHolderDelegate);
        this.f12674a.a("onViewRecycled", rVViewHolderDelegate.getDelegator());
    }
}

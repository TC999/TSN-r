package com.baidu.mobads.sdk.internal.concrete;

import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mobads.sdk.internal.p050a.C2575b;
import com.baidu.mobads.sdk.internal.p050a.C2576c;
import com.baidu.mobads.sdk.internal.p050a.InterfaceC2574a;
import com.baidu.mobads.sdk.internal.widget.ViewPager2;
import java.util.Map;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class RVAdapterDelegate extends RecyclerView.Adapter<RVViewHolderDelegate> implements InterfaceC2574a {

    /* renamed from: a */
    private final C2576c f8873a;

    /* renamed from: b */
    private final C2575b f8874b;

    public RVAdapterDelegate(@NonNull IAdInterListener iAdInterListener) {
        this.f8873a = C2576c.m51074a(iAdInterListener, this);
        registerAdapterDataObserver(new ViewPager2.DataSetChangeObserver() { // from class: com.baidu.mobads.sdk.internal.concrete.RVAdapterDelegate.1
            @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.DataSetChangeObserver, androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onChanged() {
                RVAdapterDelegate.this.f8873a.m51073a("onChanged");
            }
        });
        this.f8874b = new C2575b();
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public int getCode() {
        return this.f8873a.getCode();
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public Map<String, Object> getData() {
        return this.f8873a.getData();
    }

    @Override // com.baidu.mobads.sdk.internal.p050a.InterfaceC2574a
    @NonNull
    public IAdInterListener getDelegator() {
        return this.f8873a.getDelegator();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        Object m51072a = this.f8873a.m51072a("getItemCount", new Object[0]);
        if (m51072a instanceof Integer) {
            return ((Integer) m51072a).intValue();
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i) {
        Object m51072a = this.f8873a.m51072a("getItemId", Integer.valueOf(i));
        if (m51072a instanceof Integer) {
            return ((Integer) m51072a).intValue();
        }
        return super.getItemId(i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        Object m51072a = this.f8873a.m51072a("getItemType", Integer.valueOf(i));
        if (m51072a instanceof Integer) {
            return ((Integer) m51072a).intValue();
        }
        return super.getItemViewType(i);
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public String getMessage() {
        return this.f8873a.getMessage();
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public Object getTarget() {
        return this.f8873a.getTarget();
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public String getType() {
        return this.f8873a.getType();
    }

    @Override // com.baidu.mobads.sdk.internal.p050a.InterfaceC2574a
    public Object handleEvent(String str, String str2, Object[] objArr) {
        if ("notifyItemChanged".equals(str2)) {
            notifyItemChanged(this.f8874b.m51076a(objArr, 0, 0), this.f8874b.m51075a(objArr, 1, (Object) null));
        } else if ("notifyRangeInserted".equals(str2)) {
            notifyItemRangeInserted(this.f8874b.m51076a(objArr, 0, 0), this.f8874b.m51076a(objArr, 1, 0));
        } else if ("notifyRangeRemoved".equals(str2)) {
            notifyItemRangeRemoved(this.f8874b.m51076a(objArr, 0, 0), this.f8874b.m51076a(objArr, 1, 0));
        } else if ("notifyItemRangeChanged".equals(str2)) {
            notifyItemRangeChanged(this.f8874b.m51076a(objArr, 0, 0), this.f8874b.m51076a(objArr, 1, 0));
        } else if ("notifyDataSetChanged".equals(str2)) {
            notifyDataSetChanged();
        }
        return null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        this.f8873a.m51072a("onAttachedToRecyclerView", recyclerView);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onDetachedFromRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
        this.f8873a.m51072a("onDetachedFromRecyclerView", recyclerView);
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public void setTarget(Object obj) {
        this.f8873a.setTarget(obj);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RVViewHolderDelegate rVViewHolderDelegate, int i) {
        this.f8873a.m51072a("onBindViewHolder", rVViewHolderDelegate.getDelegator(), Integer.valueOf(i));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RVViewHolderDelegate onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        Object m51072a = this.f8873a.m51072a("onCreateViewHolder", viewGroup, Integer.valueOf(i));
        if (m51072a instanceof RVViewHolderDelegate) {
            return (RVViewHolderDelegate) m51072a;
        }
        return new RVViewHolderDelegate(this.f8873a.getDelegator(), viewGroup) { // from class: com.baidu.mobads.sdk.internal.concrete.RVAdapterDelegate.2
        };
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public boolean onFailedToRecycleView(@NonNull RVViewHolderDelegate rVViewHolderDelegate) {
        Object m51072a = this.f8873a.m51072a("onFailedToRecycleView", rVViewHolderDelegate.getDelegator());
        if (m51072a instanceof Boolean) {
            return ((Boolean) m51072a).booleanValue();
        }
        return super.onFailedToRecycleView((RVAdapterDelegate) rVViewHolderDelegate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewAttachedToWindow(@NonNull RVViewHolderDelegate rVViewHolderDelegate) {
        super.onViewAttachedToWindow((RVAdapterDelegate) rVViewHolderDelegate);
        this.f8873a.m51072a("onViewAttachedToWindow", rVViewHolderDelegate.getDelegator());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewDetachedFromWindow(@NonNull RVViewHolderDelegate rVViewHolderDelegate) {
        super.onViewDetachedFromWindow((RVAdapterDelegate) rVViewHolderDelegate);
        this.f8873a.m51072a("onViewDetachedFromWindow", rVViewHolderDelegate.getDelegator());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewRecycled(@NonNull RVViewHolderDelegate rVViewHolderDelegate) {
        super.onViewRecycled((RVAdapterDelegate) rVViewHolderDelegate);
        this.f8873a.m51072a("onViewRecycled", rVViewHolderDelegate.getDelegator());
    }
}

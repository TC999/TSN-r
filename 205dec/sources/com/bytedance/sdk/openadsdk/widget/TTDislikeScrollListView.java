package com.bytedance.sdk.openadsdk.widget;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import com.bytedance.sdk.openadsdk.core.dislike.c.w;
import com.bytedance.sdk.openadsdk.ys.w.w.f;

/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class TTDislikeScrollListView extends ListView {

    /* renamed from: c  reason: collision with root package name */
    private w f36371c;

    /* renamed from: w  reason: collision with root package name */
    private AdapterView.OnItemClickListener f36372w;
    private AdapterView.OnItemClickListener xv;

    public TTDislikeScrollListView(Context context) {
        super(context);
        this.xv = new AdapterView.OnItemClickListener() { // from class: com.bytedance.sdk.openadsdk.widget.TTDislikeScrollListView.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i4, long j4) {
                if (TTDislikeScrollListView.this.getAdapter() != null && TTDislikeScrollListView.this.getAdapter().getItem(i4) != null && (TTDislikeScrollListView.this.getAdapter().getItem(i4) instanceof f)) {
                    f fVar = (f) TTDislikeScrollListView.this.getAdapter().getItem(i4);
                    if (fVar.f()) {
                        return;
                    }
                    if (TTDislikeScrollListView.this.f36372w != null) {
                        TTDislikeScrollListView.this.f36372w.onItemClick(adapterView, view, i4, j4);
                    }
                    if (TTDislikeScrollListView.this.f36371c != null) {
                        TTDislikeScrollListView.this.f36371c.c(fVar);
                        return;
                    }
                    return;
                }
                throw new IllegalArgumentException("adapter\u6570\u636e\u5f02\u5e38\uff0c\u5fc5\u987b\u4e3aFilterWord");
            }
        };
        c();
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.View
    protected void onMeasure(int i4, int i5) {
        super.onMeasure(i4, View.MeasureSpec.makeMeasureSpec(536870911, Integer.MIN_VALUE));
    }

    public void setDislikeController(w wVar) {
        this.f36371c = wVar;
    }

    @Override // android.widget.AdapterView
    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.f36372w = onItemClickListener;
    }

    private void c() {
        super.setOnItemClickListener(this.xv);
    }
}

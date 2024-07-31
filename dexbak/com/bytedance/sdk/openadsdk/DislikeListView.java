package com.bytedance.sdk.openadsdk;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import com.bykv.p106ok.p107ok.p108ok.p109ok.C5930a;
import com.bykv.p106ok.p107ok.p108ok.p109ok.C5934b;
import com.bykv.p110vk.openvk.api.proto.EventListener;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class DislikeListView extends ListView {
    private EventListener mOnItemClickBridge;
    private AdapterView.OnItemClickListener mOnItemClickListener;
    private AdapterView.OnItemClickListener mOnItemClickListenerInner;

    public DislikeListView(Context context) {
        super(context);
        this.mOnItemClickListenerInner = new AdapterView.OnItemClickListener() { // from class: com.bytedance.sdk.openadsdk.DislikeListView.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (DislikeListView.this.getAdapter() != null && DislikeListView.this.getAdapter().getItem(i) != null && (DislikeListView.this.getAdapter().getItem(i) instanceof FilterWord)) {
                    FilterWord filterWord = (FilterWord) DislikeListView.this.getAdapter().getItem(i);
                    if (filterWord.hasSecondOptions()) {
                        return;
                    }
                    if (DislikeListView.this.mOnItemClickListener != null) {
                        DislikeListView.this.mOnItemClickListener.onItemClick(adapterView, view, i, j);
                    }
                    if (DislikeListView.this.mOnItemClickBridge != null) {
                        DislikeListView.this.mOnItemClickBridge.onEvent(0, C5934b.m37914b().m37912d(C5930a.m37925b().m37918i(0, filterWord.getId()).m37918i(1, filterWord.getName()).m37926a()).m37915a());
                        return;
                    }
                    return;
                }
                throw new IllegalArgumentException("adapter数据异常，必须为FilterWord");
            }
        };
        init();
    }

    private void init() {
        super.setOnItemClickListener(this.mOnItemClickListenerInner);
    }

    @Override // android.widget.AdapterView
    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        if (onItemClickListener instanceof EventListener) {
            this.mOnItemClickBridge = (EventListener) onItemClickListener;
        } else {
            this.mOnItemClickListener = onItemClickListener;
        }
    }

    public DislikeListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mOnItemClickListenerInner = new AdapterView.OnItemClickListener() { // from class: com.bytedance.sdk.openadsdk.DislikeListView.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (DislikeListView.this.getAdapter() != null && DislikeListView.this.getAdapter().getItem(i) != null && (DislikeListView.this.getAdapter().getItem(i) instanceof FilterWord)) {
                    FilterWord filterWord = (FilterWord) DislikeListView.this.getAdapter().getItem(i);
                    if (filterWord.hasSecondOptions()) {
                        return;
                    }
                    if (DislikeListView.this.mOnItemClickListener != null) {
                        DislikeListView.this.mOnItemClickListener.onItemClick(adapterView, view, i, j);
                    }
                    if (DislikeListView.this.mOnItemClickBridge != null) {
                        DislikeListView.this.mOnItemClickBridge.onEvent(0, C5934b.m37914b().m37912d(C5930a.m37925b().m37918i(0, filterWord.getId()).m37918i(1, filterWord.getName()).m37926a()).m37915a());
                        return;
                    }
                    return;
                }
                throw new IllegalArgumentException("adapter数据异常，必须为FilterWord");
            }
        };
        init();
    }

    public DislikeListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mOnItemClickListenerInner = new AdapterView.OnItemClickListener() { // from class: com.bytedance.sdk.openadsdk.DislikeListView.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
                if (DislikeListView.this.getAdapter() != null && DislikeListView.this.getAdapter().getItem(i2) != null && (DislikeListView.this.getAdapter().getItem(i2) instanceof FilterWord)) {
                    FilterWord filterWord = (FilterWord) DislikeListView.this.getAdapter().getItem(i2);
                    if (filterWord.hasSecondOptions()) {
                        return;
                    }
                    if (DislikeListView.this.mOnItemClickListener != null) {
                        DislikeListView.this.mOnItemClickListener.onItemClick(adapterView, view, i2, j);
                    }
                    if (DislikeListView.this.mOnItemClickBridge != null) {
                        DislikeListView.this.mOnItemClickBridge.onEvent(0, C5934b.m37914b().m37912d(C5930a.m37925b().m37918i(0, filterWord.getId()).m37918i(1, filterWord.getName()).m37926a()).m37915a());
                        return;
                    }
                    return;
                }
                throw new IllegalArgumentException("adapter数据异常，必须为FilterWord");
            }
        };
        init();
    }
}

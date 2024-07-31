package com.baidu.mobads.sdk.internal.concrete;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mobads.sdk.internal.p050a.C2576c;
import com.baidu.mobads.sdk.internal.p050a.InterfaceC2574a;
import java.util.Map;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class RVViewHolderDelegate extends RecyclerView.ViewHolder implements InterfaceC2574a {

    /* renamed from: a */
    private final C2576c f8877a;

    public RVViewHolderDelegate(@NonNull IAdInterListener iAdInterListener, View view) {
        super(view);
        this.f8877a = C2576c.m51074a(iAdInterListener, this);
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public int getCode() {
        return this.f8877a.getCode();
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public Map<String, Object> getData() {
        return this.f8877a.getData();
    }

    @Override // com.baidu.mobads.sdk.internal.p050a.InterfaceC2574a
    @NonNull
    public IAdInterListener getDelegator() {
        return this.f8877a.getDelegator();
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public String getMessage() {
        return this.f8877a.getMessage();
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public Object getTarget() {
        return this.f8877a.getTarget();
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public String getType() {
        return this.f8877a.getType();
    }

    @Override // com.baidu.mobads.sdk.internal.p050a.InterfaceC2574a
    public Object handleEvent(String str, String str2, Object[] objArr) {
        return null;
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public void setTarget(Object obj) {
        this.f8877a.setTarget(obj);
    }
}

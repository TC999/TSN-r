package com.bytedance.sdk.openadsdk.bl.ok.ok;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.FilterWord;
import java.util.ArrayList;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\5141176.dex */
public final class kf implements Bridge, FilterWord {

    /* renamed from: a  reason: collision with root package name */
    private FilterWord f31635a;
    private final Bridge ok;

    public kf(FilterWord filterWord) {
        this.f31635a = filterWord;
        this.ok = com.bykv.ok.ok.ok.ok.a.f24748d;
    }

    @Override // com.bytedance.sdk.openadsdk.FilterWord
    public void addOption(FilterWord filterWord) {
        com.bykv.ok.ok.ok.ok.a c4 = com.bykv.ok.ok.ok.ok.a.c(1);
        c4.h(0, new kf(filterWord));
        this.ok.call(241101, c4.a(), Void.class);
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i4, ValueSet valueSet, Class<T> cls) {
        FilterWord filterWord = this.f31635a;
        if (filterWord == null) {
            return null;
        }
        switch (i4) {
            case 241101:
                this.f31635a.addOption(new kf((Bridge) valueSet.objectValue(0, Bridge.class)));
                break;
            case 241102:
                this.f31635a.setIsSelected(valueSet.booleanValue(0));
                break;
            case 241103:
                return (T) filterWord.getId();
            case 241104:
                return (T) filterWord.getName();
            case 241105:
                return (T) Boolean.class.cast(Boolean.valueOf(filterWord.getIsSelected()));
            case 241106:
                return (T) Boolean.class.cast(Boolean.valueOf(filterWord.hasSecondOptions()));
            case 241107:
                return (T) Boolean.class.cast(Boolean.valueOf(filterWord.isValid()));
            case 241108:
                return (T) filterWord.getOptions();
        }
        ok(i4, valueSet, cls);
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.FilterWord
    public String getId() {
        return (String) this.ok.call(241103, com.bykv.ok.ok.ok.ok.a.c(0).a(), String.class);
    }

    @Override // com.bytedance.sdk.openadsdk.FilterWord
    public boolean getIsSelected() {
        return ((Boolean) this.ok.call(241105, com.bykv.ok.ok.ok.ok.a.c(0).a(), Boolean.TYPE)).booleanValue();
    }

    @Override // com.bytedance.sdk.openadsdk.FilterWord
    public String getName() {
        return (String) this.ok.call(241104, com.bykv.ok.ok.ok.ok.a.c(0).a(), String.class);
    }

    @Override // com.bytedance.sdk.openadsdk.FilterWord
    public List<FilterWord> getOptions() {
        List<Bridge> list = (List) this.ok.call(241108, com.bykv.ok.ok.ok.ok.a.c(0).a(), List.class);
        if (list == null) {
            list = new ArrayList(0);
        }
        ArrayList arrayList = new ArrayList();
        for (Bridge bridge : list) {
            arrayList.add(new kf(bridge));
        }
        return arrayList;
    }

    @Override // com.bytedance.sdk.openadsdk.FilterWord
    public boolean hasSecondOptions() {
        return ((Boolean) this.ok.call(241106, com.bykv.ok.ok.ok.ok.a.c(0).a(), Boolean.TYPE)).booleanValue();
    }

    @Override // com.bytedance.sdk.openadsdk.FilterWord
    public boolean isValid() {
        return ((Boolean) this.ok.call(241107, com.bykv.ok.ok.ok.ok.a.c(0).a(), Boolean.TYPE)).booleanValue();
    }

    protected void ok(int i4, ValueSet valueSet, Class cls) {
    }

    @Override // com.bytedance.sdk.openadsdk.FilterWord
    public void setIsSelected(boolean z3) {
        com.bykv.ok.ok.ok.ok.a c4 = com.bykv.ok.ok.ok.ok.a.c(1);
        c4.j(0, z3);
        this.ok.call(241102, c4.a(), Void.class);
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return com.bykv.ok.ok.ok.ok.a.f24747c;
    }

    public kf(Bridge bridge) {
        this.ok = bridge == null ? com.bykv.ok.ok.ok.ok.a.f24748d : bridge;
    }
}

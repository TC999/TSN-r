package com.bytedance.sdk.openadsdk.ys.c.c;

import com.bykv.c.c.c.c.b;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.FilterWord;
import java.util.ArrayList;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6241084.dex */
public final class f implements Bridge, FilterWord {

    /* renamed from: c  reason: collision with root package name */
    private final Bridge f36408c;

    /* renamed from: w  reason: collision with root package name */
    private FilterWord f36409w;

    public f(FilterWord filterWord) {
        this.f36409w = filterWord;
        this.f36408c = b.f24741d;
    }

    @Override // com.bytedance.sdk.openadsdk.FilterWord
    public void addOption(FilterWord filterWord) {
        b b4 = b.b(1);
        b4.h(0, new f(filterWord));
        this.f36408c.call(241101, b4.l(), Void.class);
    }

    protected void c(int i4, ValueSet valueSet, Class cls) {
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i4, ValueSet valueSet, Class<T> cls) {
        FilterWord filterWord = this.f36409w;
        if (filterWord == null) {
            return null;
        }
        switch (i4) {
            case 241101:
                this.f36409w.addOption(new f((Bridge) valueSet.objectValue(0, Bridge.class)));
                break;
            case 241102:
                this.f36409w.setIsSelected(valueSet.booleanValue(0));
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
        c(i4, valueSet, cls);
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.FilterWord
    public String getId() {
        return (String) this.f36408c.call(241103, b.b(0).l(), String.class);
    }

    @Override // com.bytedance.sdk.openadsdk.FilterWord
    public boolean getIsSelected() {
        return ((Boolean) this.f36408c.call(241105, b.b(0).l(), Boolean.TYPE)).booleanValue();
    }

    @Override // com.bytedance.sdk.openadsdk.FilterWord
    public String getName() {
        return (String) this.f36408c.call(241104, b.b(0).l(), String.class);
    }

    @Override // com.bytedance.sdk.openadsdk.FilterWord
    public List<FilterWord> getOptions() {
        List<Bridge> list = (List) this.f36408c.call(241108, b.b(0).l(), List.class);
        if (list == null) {
            list = new ArrayList(0);
        }
        ArrayList arrayList = new ArrayList();
        for (Bridge bridge : list) {
            arrayList.add(new f(bridge));
        }
        return arrayList;
    }

    @Override // com.bytedance.sdk.openadsdk.FilterWord
    public boolean hasSecondOptions() {
        return ((Boolean) this.f36408c.call(241106, b.b(0).l(), Boolean.TYPE)).booleanValue();
    }

    @Override // com.bytedance.sdk.openadsdk.FilterWord
    public boolean isValid() {
        return ((Boolean) this.f36408c.call(241107, b.b(0).l(), Boolean.TYPE)).booleanValue();
    }

    @Override // com.bytedance.sdk.openadsdk.FilterWord
    public void setIsSelected(boolean z3) {
        b b4 = b.b(1);
        b4.j(0, z3);
        this.f36408c.call(241102, b4.l(), Void.class);
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return b.f24740c;
    }

    public f(Bridge bridge) {
        this.f36408c = bridge == null ? b.f24741d : bridge;
    }
}

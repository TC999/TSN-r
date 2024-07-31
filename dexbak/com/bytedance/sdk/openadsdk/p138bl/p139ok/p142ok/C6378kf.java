package com.bytedance.sdk.openadsdk.p138bl.p139ok.p142ok;

import com.bykv.p106ok.p107ok.p108ok.p109ok.C5930a;
import com.bykv.p110vk.openvk.api.proto.Bridge;
import com.bykv.p110vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.FilterWord;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.bytedance.sdk.openadsdk.bl.ok.ok.kf */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class C6378kf implements Bridge, FilterWord {

    /* renamed from: a */
    private FilterWord f22519a;

    /* renamed from: ok */
    private final Bridge f22520ok;

    public C6378kf(FilterWord filterWord) {
        this.f22519a = filterWord;
        this.f22520ok = C5930a.f21280d;
    }

    @Override // com.bytedance.sdk.openadsdk.FilterWord
    public void addOption(FilterWord filterWord) {
        C5930a m37924c = C5930a.m37924c(1);
        m37924c.m37919h(0, new C6378kf(filterWord));
        this.f22520ok.call(241101, m37924c.m37926a(), Void.class);
    }

    @Override // com.bykv.p110vk.openvk.api.proto.Caller
    public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
        FilterWord filterWord = this.f22519a;
        if (filterWord == null) {
            return null;
        }
        switch (i) {
            case 241101:
                this.f22519a.addOption(new C6378kf((Bridge) valueSet.objectValue(0, Bridge.class)));
                break;
            case 241102:
                this.f22519a.setIsSelected(valueSet.booleanValue(0));
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
        m36502ok(i, valueSet, cls);
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.FilterWord
    public String getId() {
        return (String) this.f22520ok.call(241103, C5930a.m37924c(0).m37926a(), String.class);
    }

    @Override // com.bytedance.sdk.openadsdk.FilterWord
    public boolean getIsSelected() {
        return ((Boolean) this.f22520ok.call(241105, C5930a.m37924c(0).m37926a(), Boolean.TYPE)).booleanValue();
    }

    @Override // com.bytedance.sdk.openadsdk.FilterWord
    public String getName() {
        return (String) this.f22520ok.call(241104, C5930a.m37924c(0).m37926a(), String.class);
    }

    @Override // com.bytedance.sdk.openadsdk.FilterWord
    public List<FilterWord> getOptions() {
        List<Bridge> list = (List) this.f22520ok.call(241108, C5930a.m37924c(0).m37926a(), List.class);
        if (list == null) {
            list = new ArrayList(0);
        }
        ArrayList arrayList = new ArrayList();
        for (Bridge bridge : list) {
            arrayList.add(new C6378kf(bridge));
        }
        return arrayList;
    }

    @Override // com.bytedance.sdk.openadsdk.FilterWord
    public boolean hasSecondOptions() {
        return ((Boolean) this.f22520ok.call(241106, C5930a.m37924c(0).m37926a(), Boolean.TYPE)).booleanValue();
    }

    @Override // com.bytedance.sdk.openadsdk.FilterWord
    public boolean isValid() {
        return ((Boolean) this.f22520ok.call(241107, C5930a.m37924c(0).m37926a(), Boolean.TYPE)).booleanValue();
    }

    /* renamed from: ok */
    protected void m36502ok(int i, ValueSet valueSet, Class cls) {
    }

    @Override // com.bytedance.sdk.openadsdk.FilterWord
    public void setIsSelected(boolean z) {
        C5930a m37924c = C5930a.m37924c(1);
        m37924c.m37917j(0, z);
        this.f22520ok.call(241102, m37924c.m37926a(), Void.class);
    }

    @Override // com.bykv.p110vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return C5930a.f21279c;
    }

    public C6378kf(Bridge bridge) {
        this.f22520ok = bridge == null ? C5930a.f21280d : bridge;
    }
}

package com.bytedance.sdk.openadsdk.core.dislike.c;

import android.app.Dialog;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import com.bykv.vk.openvk.api.proto.EventListener;
import com.bykv.vk.openvk.api.proto.Result;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.ys.w.w.f;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class w {

    /* renamed from: c  reason: collision with root package name */
    private final com.bytedance.sdk.openadsdk.core.dislike.xv.w f33131c;

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    private static final class c implements AdapterView.OnItemClickListener, EventListener {

        /* renamed from: c  reason: collision with root package name */
        private final w f33132c;

        @Override // com.bykv.vk.openvk.api.proto.EventListener
        public ValueSet onEvent(int i4, Result result) {
            if (result == null || result.values() == null) {
                return null;
            }
            this.f33132c.c(new com.bytedance.sdk.openadsdk.core.dislike.xv.xv(result.values().stringValue(0), result.values().stringValue(1)));
            return null;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i4, long j4) {
        }

        private c(w wVar) {
            this.f33132c = wVar;
        }
    }

    public w(com.bytedance.sdk.openadsdk.core.dislike.xv.w wVar) {
        this.f33131c = wVar;
    }

    public void c(f fVar) {
        if (this.f33131c == null || fVar == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.dislike.c.c.c().c(this.f33131c, fVar);
    }

    public static final void c(com.bytedance.sdk.openadsdk.core.dislike.xv.w wVar, Dialog dialog, int[] iArr) {
        if (iArr == null || iArr.length <= 0) {
            return;
        }
        w wVar2 = new w(wVar);
        for (int i4 : iArr) {
            View findViewById = dialog.findViewById(i4);
            if (findViewById instanceof ListView) {
                ((ListView) findViewById).setOnItemClickListener(new c());
            }
        }
    }
}

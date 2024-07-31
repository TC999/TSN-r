package com.kwad.components.core.webview.tachikoma.p336d;

import android.text.TextUtils;
import com.alibaba.fastjson.asm.Opcodes;
import com.kwad.sdk.utils.AbstractRunnableC11033ay;
import com.kwad.sdk.utils.C11064bn;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONObject;

/* renamed from: com.kwad.components.core.webview.tachikoma.d.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9279a {
    private List<Integer> aaQ;
    private final List<Integer> aaR;

    /* renamed from: com.kwad.components.core.webview.tachikoma.d.a$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    static class C9282a {
        private static final C9279a aaV = new C9279a((byte) 0);
    }

    /* synthetic */ C9279a(byte b) {
        this();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: aV */
    public void m29123aV(int i) {
        if (this.aaR.contains(Integer.valueOf(i))) {
            this.aaQ.add(Integer.valueOf(i));
        }
    }

    /* renamed from: sY */
    public static C9279a m29119sY() {
        return C9282a.aaV;
    }

    /* renamed from: aW */
    public final void m29121aW(final int i) {
        C11064bn.runOnUiThread(new AbstractRunnableC11033ay() { // from class: com.kwad.components.core.webview.tachikoma.d.a.1
            @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
            public final void doTask() {
                C9279a.this.m29123aV(i);
            }
        });
    }

    /* renamed from: sZ */
    public final List<Integer> m29118sZ() {
        return this.aaQ;
    }

    /* renamed from: ta */
    public final void m29117ta() {
        this.aaQ.clear();
    }

    private C9279a() {
        this.aaQ = new ArrayList();
        this.aaR = Arrays.asList(123, Integer.valueOf((int) Opcodes.INVOKESTATIC), Integer.valueOf((int) Opcodes.INVOKEINTERFACE), 190, Integer.valueOf((int) Opcodes.IFNONNULL), 200);
    }

    /* renamed from: aW */
    public final void m29120aW(final String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        C11064bn.runOnUiThread(new AbstractRunnableC11033ay() { // from class: com.kwad.components.core.webview.tachikoma.d.a.2
            @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
            public final void doTask() {
                C9279a.this.m29122aV(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: aV */
    public void m29122aV(String str) {
        int i;
        try {
            i = new JSONObject(str).optInt("elementType");
        } catch (Exception unused) {
            i = Integer.MAX_VALUE;
        }
        if (this.aaR.contains(Integer.valueOf(i))) {
            this.aaQ.add(Integer.valueOf(i));
        }
    }
}

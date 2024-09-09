package com.kwad.components.core.webview.tachikoma.d;

import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.kwad.sdk.utils.ay;
import com.kwad.sdk.utils.bn;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class a {
    private List<Integer> aaQ;
    private final List<Integer> aaR;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* renamed from: com.kwad.components.core.webview.tachikoma.d.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    static class C0659a {
        private static final a aaV = new a((byte) 0);
    }

    /* synthetic */ a(byte b4) {
        this();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aV(int i4) {
        if (this.aaR.contains(Integer.valueOf(i4))) {
            this.aaQ.add(Integer.valueOf(i4));
        }
    }

    public static a sY() {
        return C0659a.aaV;
    }

    public final void aW(final int i4) {
        bn.runOnUiThread(new ay() { // from class: com.kwad.components.core.webview.tachikoma.d.a.1
            @Override // com.kwad.sdk.utils.ay
            public final void doTask() {
                a.this.aV(i4);
            }
        });
    }

    public final List<Integer> sZ() {
        return this.aaQ;
    }

    public final void ta() {
        this.aaQ.clear();
    }

    private a() {
        this.aaQ = new ArrayList();
        this.aaR = Arrays.asList(123, 184, 185, Integer.valueOf((int) MediaPlayer.MEDIA_PLAYER_OPTION_SLOW_PLAY_TIME), 199, 200);
    }

    public final void aW(final String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        bn.runOnUiThread(new ay() { // from class: com.kwad.components.core.webview.tachikoma.d.a.2
            @Override // com.kwad.sdk.utils.ay
            public final void doTask() {
                a.this.aV(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aV(String str) {
        int i4;
        try {
            i4 = new JSONObject(str).optInt("elementType");
        } catch (Exception unused) {
            i4 = Integer.MAX_VALUE;
        }
        if (this.aaR.contains(Integer.valueOf(i4))) {
            this.aaQ.add(Integer.valueOf(i4));
        }
    }
}

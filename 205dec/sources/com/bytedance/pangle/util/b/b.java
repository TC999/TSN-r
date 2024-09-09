package com.bytedance.pangle.util.b;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public final class b {
    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:64:0x01b4
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:81)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:47)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    public static boolean a(java.lang.String r30, boolean r31, boolean r32, java.lang.String r33, int r34, int r35) {
        /*
            Method dump skipped, instructions count: 1005
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.pangle.util.b.b.a(java.lang.String, boolean, boolean, java.lang.String, int, int):boolean");
    }

    private static void a(int i4, String str, int i5, long j4, Throwable th, String str2) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        try {
            jSONObject.putOpt("status_code", com.bytedance.pangle.log.b.a(Integer.valueOf(i4)));
            jSONObject.putOpt("plugin_package_name", com.bytedance.pangle.log.b.a(str));
            jSONObject.putOpt("version_code", com.bytedance.pangle.log.b.a(Integer.valueOf(i5)));
            jSONObject3.putOpt("duration", Integer.valueOf(com.bytedance.pangle.log.b.b(Long.valueOf(j4))));
            jSONObject2.putOpt("message", str2 + com.bytedance.pangle.log.b.a(th));
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
        com.bytedance.pangle.c.b.a().a(com.bytedance.pangle.c.b.f28642k, jSONObject, jSONObject3, jSONObject2);
    }
}

package com.bytedance.pangle.util.p127b;

import com.bytedance.pangle.log.C6165b;
import com.bytedance.pangle.p118c.C6073b;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.bytedance.pangle.util.b.b */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class C6242b {
    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:64:0x01b4
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:81)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:47)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    /* renamed from: a */
    public static boolean m36912a(java.lang.String r30, boolean r31, boolean r32, java.lang.String r33, int r34, int r35) {
        /*
            Method dump skipped, instructions count: 1005
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.pangle.util.p127b.C6242b.m36912a(java.lang.String, boolean, boolean, java.lang.String, int, int):boolean");
    }

    /* renamed from: a */
    private static void m36913a(int i, String str, int i2, long j, Throwable th, String str2) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        try {
            jSONObject.putOpt("status_code", C6165b.m37072a(Integer.valueOf(i)));
            jSONObject.putOpt("plugin_package_name", C6165b.m37072a(str));
            jSONObject.putOpt("version_code", C6165b.m37072a(Integer.valueOf(i2)));
            jSONObject3.putOpt("duration", Integer.valueOf(C6165b.m37070b(Long.valueOf(j))));
            jSONObject2.putOpt("message", str2 + C6165b.m37071a(th));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        C6073b.m37254a().m37253a(C6073b.f21873k, jSONObject, jSONObject3, jSONObject2);
    }
}

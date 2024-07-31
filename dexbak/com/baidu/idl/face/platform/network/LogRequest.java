package com.baidu.idl.face.platform.network;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class LogRequest extends BaseRequest {
    public static final String URL_GET_LOG = "";

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:100:0x012b A[Catch: IOException -> 0x017f, TryCatch #9 {IOException -> 0x017f, blocks: (B:40:0x00b1, B:42:0x00b6, B:44:0x00bb, B:45:0x00be, B:85:0x0109, B:87:0x010e, B:89:0x0113, B:91:0x0118, B:98:0x0126, B:100:0x012b, B:102:0x0130, B:104:0x0135, B:111:0x0143, B:113:0x0148, B:115:0x014d, B:117:0x0152, B:124:0x015f, B:126:0x0164, B:128:0x0169, B:130:0x016e, B:137:0x017b, B:141:0x0183, B:143:0x0188, B:145:0x018d), top: B:165:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0130 A[Catch: IOException -> 0x017f, TryCatch #9 {IOException -> 0x017f, blocks: (B:40:0x00b1, B:42:0x00b6, B:44:0x00bb, B:45:0x00be, B:85:0x0109, B:87:0x010e, B:89:0x0113, B:91:0x0118, B:98:0x0126, B:100:0x012b, B:102:0x0130, B:104:0x0135, B:111:0x0143, B:113:0x0148, B:115:0x014d, B:117:0x0152, B:124:0x015f, B:126:0x0164, B:128:0x0169, B:130:0x016e, B:137:0x017b, B:141:0x0183, B:143:0x0188, B:145:0x018d), top: B:165:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0135 A[Catch: IOException -> 0x017f, TRY_LEAVE, TryCatch #9 {IOException -> 0x017f, blocks: (B:40:0x00b1, B:42:0x00b6, B:44:0x00bb, B:45:0x00be, B:85:0x0109, B:87:0x010e, B:89:0x0113, B:91:0x0118, B:98:0x0126, B:100:0x012b, B:102:0x0130, B:104:0x0135, B:111:0x0143, B:113:0x0148, B:115:0x014d, B:117:0x0152, B:124:0x015f, B:126:0x0164, B:128:0x0169, B:130:0x016e, B:137:0x017b, B:141:0x0183, B:143:0x0188, B:145:0x018d), top: B:165:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0143 A[Catch: IOException -> 0x017f, TRY_ENTER, TryCatch #9 {IOException -> 0x017f, blocks: (B:40:0x00b1, B:42:0x00b6, B:44:0x00bb, B:45:0x00be, B:85:0x0109, B:87:0x010e, B:89:0x0113, B:91:0x0118, B:98:0x0126, B:100:0x012b, B:102:0x0130, B:104:0x0135, B:111:0x0143, B:113:0x0148, B:115:0x014d, B:117:0x0152, B:124:0x015f, B:126:0x0164, B:128:0x0169, B:130:0x016e, B:137:0x017b, B:141:0x0183, B:143:0x0188, B:145:0x018d), top: B:165:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0148 A[Catch: IOException -> 0x017f, TryCatch #9 {IOException -> 0x017f, blocks: (B:40:0x00b1, B:42:0x00b6, B:44:0x00bb, B:45:0x00be, B:85:0x0109, B:87:0x010e, B:89:0x0113, B:91:0x0118, B:98:0x0126, B:100:0x012b, B:102:0x0130, B:104:0x0135, B:111:0x0143, B:113:0x0148, B:115:0x014d, B:117:0x0152, B:124:0x015f, B:126:0x0164, B:128:0x0169, B:130:0x016e, B:137:0x017b, B:141:0x0183, B:143:0x0188, B:145:0x018d), top: B:165:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:115:0x014d A[Catch: IOException -> 0x017f, TryCatch #9 {IOException -> 0x017f, blocks: (B:40:0x00b1, B:42:0x00b6, B:44:0x00bb, B:45:0x00be, B:85:0x0109, B:87:0x010e, B:89:0x0113, B:91:0x0118, B:98:0x0126, B:100:0x012b, B:102:0x0130, B:104:0x0135, B:111:0x0143, B:113:0x0148, B:115:0x014d, B:117:0x0152, B:124:0x015f, B:126:0x0164, B:128:0x0169, B:130:0x016e, B:137:0x017b, B:141:0x0183, B:143:0x0188, B:145:0x018d), top: B:165:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0152 A[Catch: IOException -> 0x017f, TRY_LEAVE, TryCatch #9 {IOException -> 0x017f, blocks: (B:40:0x00b1, B:42:0x00b6, B:44:0x00bb, B:45:0x00be, B:85:0x0109, B:87:0x010e, B:89:0x0113, B:91:0x0118, B:98:0x0126, B:100:0x012b, B:102:0x0130, B:104:0x0135, B:111:0x0143, B:113:0x0148, B:115:0x014d, B:117:0x0152, B:124:0x015f, B:126:0x0164, B:128:0x0169, B:130:0x016e, B:137:0x017b, B:141:0x0183, B:143:0x0188, B:145:0x018d), top: B:165:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:124:0x015f A[Catch: IOException -> 0x017f, TRY_ENTER, TryCatch #9 {IOException -> 0x017f, blocks: (B:40:0x00b1, B:42:0x00b6, B:44:0x00bb, B:45:0x00be, B:85:0x0109, B:87:0x010e, B:89:0x0113, B:91:0x0118, B:98:0x0126, B:100:0x012b, B:102:0x0130, B:104:0x0135, B:111:0x0143, B:113:0x0148, B:115:0x014d, B:117:0x0152, B:124:0x015f, B:126:0x0164, B:128:0x0169, B:130:0x016e, B:137:0x017b, B:141:0x0183, B:143:0x0188, B:145:0x018d), top: B:165:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0164 A[Catch: IOException -> 0x017f, TryCatch #9 {IOException -> 0x017f, blocks: (B:40:0x00b1, B:42:0x00b6, B:44:0x00bb, B:45:0x00be, B:85:0x0109, B:87:0x010e, B:89:0x0113, B:91:0x0118, B:98:0x0126, B:100:0x012b, B:102:0x0130, B:104:0x0135, B:111:0x0143, B:113:0x0148, B:115:0x014d, B:117:0x0152, B:124:0x015f, B:126:0x0164, B:128:0x0169, B:130:0x016e, B:137:0x017b, B:141:0x0183, B:143:0x0188, B:145:0x018d), top: B:165:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0169 A[Catch: IOException -> 0x017f, TryCatch #9 {IOException -> 0x017f, blocks: (B:40:0x00b1, B:42:0x00b6, B:44:0x00bb, B:45:0x00be, B:85:0x0109, B:87:0x010e, B:89:0x0113, B:91:0x0118, B:98:0x0126, B:100:0x012b, B:102:0x0130, B:104:0x0135, B:111:0x0143, B:113:0x0148, B:115:0x014d, B:117:0x0152, B:124:0x015f, B:126:0x0164, B:128:0x0169, B:130:0x016e, B:137:0x017b, B:141:0x0183, B:143:0x0188, B:145:0x018d), top: B:165:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:130:0x016e A[Catch: IOException -> 0x017f, TRY_LEAVE, TryCatch #9 {IOException -> 0x017f, blocks: (B:40:0x00b1, B:42:0x00b6, B:44:0x00bb, B:45:0x00be, B:85:0x0109, B:87:0x010e, B:89:0x0113, B:91:0x0118, B:98:0x0126, B:100:0x012b, B:102:0x0130, B:104:0x0135, B:111:0x0143, B:113:0x0148, B:115:0x014d, B:117:0x0152, B:124:0x015f, B:126:0x0164, B:128:0x0169, B:130:0x016e, B:137:0x017b, B:141:0x0183, B:143:0x0188, B:145:0x018d), top: B:165:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:137:0x017b A[Catch: IOException -> 0x017f, TRY_ENTER, TryCatch #9 {IOException -> 0x017f, blocks: (B:40:0x00b1, B:42:0x00b6, B:44:0x00bb, B:45:0x00be, B:85:0x0109, B:87:0x010e, B:89:0x0113, B:91:0x0118, B:98:0x0126, B:100:0x012b, B:102:0x0130, B:104:0x0135, B:111:0x0143, B:113:0x0148, B:115:0x014d, B:117:0x0152, B:124:0x015f, B:126:0x0164, B:128:0x0169, B:130:0x016e, B:137:0x017b, B:141:0x0183, B:143:0x0188, B:145:0x018d), top: B:165:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:141:0x0183 A[Catch: IOException -> 0x017f, TryCatch #9 {IOException -> 0x017f, blocks: (B:40:0x00b1, B:42:0x00b6, B:44:0x00bb, B:45:0x00be, B:85:0x0109, B:87:0x010e, B:89:0x0113, B:91:0x0118, B:98:0x0126, B:100:0x012b, B:102:0x0130, B:104:0x0135, B:111:0x0143, B:113:0x0148, B:115:0x014d, B:117:0x0152, B:124:0x015f, B:126:0x0164, B:128:0x0169, B:130:0x016e, B:137:0x017b, B:141:0x0183, B:143:0x0188, B:145:0x018d), top: B:165:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:143:0x0188 A[Catch: IOException -> 0x017f, TryCatch #9 {IOException -> 0x017f, blocks: (B:40:0x00b1, B:42:0x00b6, B:44:0x00bb, B:45:0x00be, B:85:0x0109, B:87:0x010e, B:89:0x0113, B:91:0x0118, B:98:0x0126, B:100:0x012b, B:102:0x0130, B:104:0x0135, B:111:0x0143, B:113:0x0148, B:115:0x014d, B:117:0x0152, B:124:0x015f, B:126:0x0164, B:128:0x0169, B:130:0x016e, B:137:0x017b, B:141:0x0183, B:143:0x0188, B:145:0x018d), top: B:165:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:145:0x018d A[Catch: IOException -> 0x017f, TRY_LEAVE, TryCatch #9 {IOException -> 0x017f, blocks: (B:40:0x00b1, B:42:0x00b6, B:44:0x00bb, B:45:0x00be, B:85:0x0109, B:87:0x010e, B:89:0x0113, B:91:0x0118, B:98:0x0126, B:100:0x012b, B:102:0x0130, B:104:0x0135, B:111:0x0143, B:113:0x0148, B:115:0x014d, B:117:0x0152, B:124:0x015f, B:126:0x0164, B:128:0x0169, B:130:0x016e, B:137:0x017b, B:141:0x0183, B:143:0x0188, B:145:0x018d), top: B:165:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:155:0x01a0 A[Catch: IOException -> 0x019c, TryCatch #32 {IOException -> 0x019c, blocks: (B:151:0x0198, B:155:0x01a0, B:157:0x01a5, B:159:0x01aa), top: B:169:0x0198 }] */
    /* JADX WARN: Removed duplicated region for block: B:157:0x01a5 A[Catch: IOException -> 0x019c, TryCatch #32 {IOException -> 0x019c, blocks: (B:151:0x0198, B:155:0x01a0, B:157:0x01a5, B:159:0x01aa), top: B:169:0x0198 }] */
    /* JADX WARN: Removed duplicated region for block: B:159:0x01aa A[Catch: IOException -> 0x019c, TRY_LEAVE, TryCatch #32 {IOException -> 0x019c, blocks: (B:151:0x0198, B:155:0x01a0, B:157:0x01a5, B:159:0x01aa), top: B:169:0x0198 }] */
    /* JADX WARN: Removed duplicated region for block: B:169:0x0198 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0109 A[Catch: IOException -> 0x017f, TRY_ENTER, TryCatch #9 {IOException -> 0x017f, blocks: (B:40:0x00b1, B:42:0x00b6, B:44:0x00bb, B:45:0x00be, B:85:0x0109, B:87:0x010e, B:89:0x0113, B:91:0x0118, B:98:0x0126, B:100:0x012b, B:102:0x0130, B:104:0x0135, B:111:0x0143, B:113:0x0148, B:115:0x014d, B:117:0x0152, B:124:0x015f, B:126:0x0164, B:128:0x0169, B:130:0x016e, B:137:0x017b, B:141:0x0183, B:143:0x0188, B:145:0x018d), top: B:165:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x010e A[Catch: IOException -> 0x017f, TryCatch #9 {IOException -> 0x017f, blocks: (B:40:0x00b1, B:42:0x00b6, B:44:0x00bb, B:45:0x00be, B:85:0x0109, B:87:0x010e, B:89:0x0113, B:91:0x0118, B:98:0x0126, B:100:0x012b, B:102:0x0130, B:104:0x0135, B:111:0x0143, B:113:0x0148, B:115:0x014d, B:117:0x0152, B:124:0x015f, B:126:0x0164, B:128:0x0169, B:130:0x016e, B:137:0x017b, B:141:0x0183, B:143:0x0188, B:145:0x018d), top: B:165:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0113 A[Catch: IOException -> 0x017f, TryCatch #9 {IOException -> 0x017f, blocks: (B:40:0x00b1, B:42:0x00b6, B:44:0x00bb, B:45:0x00be, B:85:0x0109, B:87:0x010e, B:89:0x0113, B:91:0x0118, B:98:0x0126, B:100:0x012b, B:102:0x0130, B:104:0x0135, B:111:0x0143, B:113:0x0148, B:115:0x014d, B:117:0x0152, B:124:0x015f, B:126:0x0164, B:128:0x0169, B:130:0x016e, B:137:0x017b, B:141:0x0183, B:143:0x0188, B:145:0x018d), top: B:165:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0118 A[Catch: IOException -> 0x017f, TRY_LEAVE, TryCatch #9 {IOException -> 0x017f, blocks: (B:40:0x00b1, B:42:0x00b6, B:44:0x00bb, B:45:0x00be, B:85:0x0109, B:87:0x010e, B:89:0x0113, B:91:0x0118, B:98:0x0126, B:100:0x012b, B:102:0x0130, B:104:0x0135, B:111:0x0143, B:113:0x0148, B:115:0x014d, B:117:0x0152, B:124:0x015f, B:126:0x0164, B:128:0x0169, B:130:0x016e, B:137:0x017b, B:141:0x0183, B:143:0x0188, B:145:0x018d), top: B:165:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0126 A[Catch: IOException -> 0x017f, TRY_ENTER, TryCatch #9 {IOException -> 0x017f, blocks: (B:40:0x00b1, B:42:0x00b6, B:44:0x00bb, B:45:0x00be, B:85:0x0109, B:87:0x010e, B:89:0x0113, B:91:0x0118, B:98:0x0126, B:100:0x012b, B:102:0x0130, B:104:0x0135, B:111:0x0143, B:113:0x0148, B:115:0x014d, B:117:0x0152, B:124:0x015f, B:126:0x0164, B:128:0x0169, B:130:0x016e, B:137:0x017b, B:141:0x0183, B:143:0x0188, B:145:0x018d), top: B:165:0x000a }] */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r4v1, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r4v14, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r4v15, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r4v16, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r4v17, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r4v18 */
    /* JADX WARN: Type inference failed for: r4v19, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v21 */
    /* JADX WARN: Type inference failed for: r4v33 */
    /* JADX WARN: Type inference failed for: r4v46 */
    /* JADX WARN: Type inference failed for: r4v48 */
    /* JADX WARN: Type inference failed for: r4v50 */
    /* JADX WARN: Type inference failed for: r4v52 */
    /* JADX WARN: Type inference failed for: r4v54 */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r9v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r9v1 */
    /* JADX WARN: Type inference failed for: r9v11 */
    /* JADX WARN: Type inference failed for: r9v17, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r9v18, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r9v19, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r9v2, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r9v20, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r9v21 */
    /* JADX WARN: Type inference failed for: r9v22, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r9v25, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r9v26 */
    /* JADX WARN: Type inference failed for: r9v27 */
    /* JADX WARN: Type inference failed for: r9v28 */
    /* JADX WARN: Type inference failed for: r9v29 */
    /* JADX WARN: Type inference failed for: r9v30 */
    /* JADX WARN: Type inference failed for: r9v31 */
    /* JADX WARN: Type inference failed for: r9v32 */
    /* JADX WARN: Type inference failed for: r9v33 */
    /* JADX WARN: Type inference failed for: r9v34 */
    /* JADX WARN: Type inference failed for: r9v35 */
    /* JADX WARN: Type inference failed for: r9v4 */
    /* JADX WARN: Type inference failed for: r9v41 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void httpUrlConnectionPost(java.lang.String r9) {
        /*
            Method dump skipped, instructions count: 436
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.idl.face.platform.network.LogRequest.httpUrlConnectionPost(java.lang.String):void");
    }

    public static void sendLogMessage(final String str) {
        if (str == null || str.length() <= 0) {
            return;
        }
        new Thread(new Runnable() { // from class: com.baidu.idl.face.platform.network.LogRequest.1
            @Override // java.lang.Runnable
            public void run() {
                LogRequest.httpUrlConnectionPost(str);
            }
        }).start();
    }
}

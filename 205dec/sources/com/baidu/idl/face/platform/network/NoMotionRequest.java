package com.baidu.idl.face.platform.network;

import android.os.Handler;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class NoMotionRequest extends BaseRequest {
    private static final String TAG = "NoMotionRequest";
    public static final String URL_POST_NOMOTION_LIVENESS = "";

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:100:0x0156 A[Catch: IOException -> 0x014d, TryCatch #27 {IOException -> 0x014d, blocks: (B:94:0x0149, B:98:0x0151, B:100:0x0156, B:102:0x015b), top: B:206:0x0149 }] */
    /* JADX WARN: Removed duplicated region for block: B:102:0x015b A[Catch: IOException -> 0x014d, TRY_LEAVE, TryCatch #27 {IOException -> 0x014d, blocks: (B:94:0x0149, B:98:0x0151, B:100:0x0156, B:102:0x015b), top: B:206:0x0149 }] */
    /* JADX WARN: Removed duplicated region for block: B:116:0x017a A[Catch: IOException -> 0x0176, TryCatch #2 {IOException -> 0x0176, blocks: (B:112:0x0172, B:116:0x017a, B:118:0x017f, B:120:0x0184), top: B:198:0x0172 }] */
    /* JADX WARN: Removed duplicated region for block: B:118:0x017f A[Catch: IOException -> 0x0176, TryCatch #2 {IOException -> 0x0176, blocks: (B:112:0x0172, B:116:0x017a, B:118:0x017f, B:120:0x0184), top: B:198:0x0172 }] */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0184 A[Catch: IOException -> 0x0176, TRY_LEAVE, TryCatch #2 {IOException -> 0x0176, blocks: (B:112:0x0172, B:116:0x017a, B:118:0x017f, B:120:0x0184), top: B:198:0x0172 }] */
    /* JADX WARN: Removed duplicated region for block: B:134:0x01a3 A[Catch: IOException -> 0x019f, TryCatch #37 {IOException -> 0x019f, blocks: (B:130:0x019b, B:134:0x01a3, B:136:0x01a8, B:138:0x01ad), top: B:209:0x019b }] */
    /* JADX WARN: Removed duplicated region for block: B:136:0x01a8 A[Catch: IOException -> 0x019f, TryCatch #37 {IOException -> 0x019f, blocks: (B:130:0x019b, B:134:0x01a3, B:136:0x01a8, B:138:0x01ad), top: B:209:0x019b }] */
    /* JADX WARN: Removed duplicated region for block: B:138:0x01ad A[Catch: IOException -> 0x019f, TRY_LEAVE, TryCatch #37 {IOException -> 0x019f, blocks: (B:130:0x019b, B:134:0x01a3, B:136:0x01a8, B:138:0x01ad), top: B:209:0x019b }] */
    /* JADX WARN: Removed duplicated region for block: B:152:0x01cb A[Catch: IOException -> 0x01c7, TryCatch #9 {IOException -> 0x01c7, blocks: (B:148:0x01c3, B:152:0x01cb, B:154:0x01d0, B:156:0x01d5), top: B:202:0x01c3 }] */
    /* JADX WARN: Removed duplicated region for block: B:154:0x01d0 A[Catch: IOException -> 0x01c7, TryCatch #9 {IOException -> 0x01c7, blocks: (B:148:0x01c3, B:152:0x01cb, B:154:0x01d0, B:156:0x01d5), top: B:202:0x01c3 }] */
    /* JADX WARN: Removed duplicated region for block: B:156:0x01d5 A[Catch: IOException -> 0x01c7, TRY_LEAVE, TryCatch #9 {IOException -> 0x01c7, blocks: (B:148:0x01c3, B:152:0x01cb, B:154:0x01d0, B:156:0x01d5), top: B:202:0x01c3 }] */
    /* JADX WARN: Removed duplicated region for block: B:170:0x01f3 A[Catch: IOException -> 0x01ef, TryCatch #6 {IOException -> 0x01ef, blocks: (B:166:0x01eb, B:170:0x01f3, B:172:0x01f8, B:174:0x01fd), top: B:200:0x01eb }] */
    /* JADX WARN: Removed duplicated region for block: B:172:0x01f8 A[Catch: IOException -> 0x01ef, TryCatch #6 {IOException -> 0x01ef, blocks: (B:166:0x01eb, B:170:0x01f3, B:172:0x01f8, B:174:0x01fd), top: B:200:0x01eb }] */
    /* JADX WARN: Removed duplicated region for block: B:174:0x01fd A[Catch: IOException -> 0x01ef, TRY_LEAVE, TryCatch #6 {IOException -> 0x01ef, blocks: (B:166:0x01eb, B:170:0x01f3, B:172:0x01f8, B:174:0x01fd), top: B:200:0x01eb }] */
    /* JADX WARN: Removed duplicated region for block: B:186:0x0221 A[Catch: IOException -> 0x021d, TryCatch #39 {IOException -> 0x021d, blocks: (B:182:0x0219, B:186:0x0221, B:188:0x0226, B:190:0x022b), top: B:211:0x0219 }] */
    /* JADX WARN: Removed duplicated region for block: B:188:0x0226 A[Catch: IOException -> 0x021d, TryCatch #39 {IOException -> 0x021d, blocks: (B:182:0x0219, B:186:0x0221, B:188:0x0226, B:190:0x022b), top: B:211:0x0219 }] */
    /* JADX WARN: Removed duplicated region for block: B:190:0x022b A[Catch: IOException -> 0x021d, TRY_LEAVE, TryCatch #39 {IOException -> 0x021d, blocks: (B:182:0x0219, B:186:0x0221, B:188:0x0226, B:190:0x022b), top: B:211:0x0219 }] */
    /* JADX WARN: Removed duplicated region for block: B:194:0x0234  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x0172 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:200:0x01eb A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:202:0x01c3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:206:0x0149 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:209:0x019b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:211:0x0219 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:226:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:227:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:228:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:229:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:230:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0151 A[Catch: IOException -> 0x014d, TryCatch #27 {IOException -> 0x014d, blocks: (B:94:0x0149, B:98:0x0151, B:100:0x0156, B:102:0x015b), top: B:206:0x0149 }] */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r0v16, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r0v18, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v20, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r0v22, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r0v24, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r0v27 */
    /* JADX WARN: Type inference failed for: r0v28 */
    /* JADX WARN: Type inference failed for: r0v29 */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v30 */
    /* JADX WARN: Type inference failed for: r0v31 */
    /* JADX WARN: Type inference failed for: r0v32 */
    /* JADX WARN: Type inference failed for: r0v35, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r0v37 */
    /* JADX WARN: Type inference failed for: r0v38 */
    /* JADX WARN: Type inference failed for: r0v39 */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v40 */
    /* JADX WARN: Type inference failed for: r0v41 */
    /* JADX WARN: Type inference failed for: r0v42 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r2v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v13, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r2v14, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r2v15, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r2v16, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r2v17, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r2v18, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v20, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r2v21 */
    /* JADX WARN: Type inference failed for: r2v22 */
    /* JADX WARN: Type inference failed for: r2v23 */
    /* JADX WARN: Type inference failed for: r2v24 */
    /* JADX WARN: Type inference failed for: r2v25 */
    /* JADX WARN: Type inference failed for: r2v26 */
    /* JADX WARN: Type inference failed for: r2v27 */
    /* JADX WARN: Type inference failed for: r2v28 */
    /* JADX WARN: Type inference failed for: r2v29 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v30 */
    /* JADX WARN: Type inference failed for: r2v31 */
    /* JADX WARN: Type inference failed for: r2v32 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r2v9 */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v12, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r5v13, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r5v14, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r5v15, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r5v16, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r5v17, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v21 */
    /* JADX WARN: Type inference failed for: r5v22 */
    /* JADX WARN: Type inference failed for: r5v23 */
    /* JADX WARN: Type inference failed for: r5v24 */
    /* JADX WARN: Type inference failed for: r5v25 */
    /* JADX WARN: Type inference failed for: r5v3 */
    /* JADX WARN: Type inference failed for: r5v31 */
    /* JADX WARN: Type inference failed for: r5v32 */
    /* JADX WARN: Type inference failed for: r5v33 */
    /* JADX WARN: Type inference failed for: r5v34 */
    /* JADX WARN: Type inference failed for: r5v35 */
    /* JADX WARN: Type inference failed for: r5v38 */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v40 */
    /* JADX WARN: Type inference failed for: r5v42 */
    /* JADX WARN: Type inference failed for: r5v44 */
    /* JADX WARN: Type inference failed for: r5v46 */
    /* JADX WARN: Type inference failed for: r5v48 */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v53 */
    /* JADX WARN: Type inference failed for: r5v54 */
    /* JADX WARN: Type inference failed for: r5v7 */
    /* JADX WARN: Type inference failed for: r5v8 */
    /* JADX WARN: Type inference failed for: r5v9 */
    /* JADX WARN: Type inference failed for: r9v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r9v10 */
    /* JADX WARN: Type inference failed for: r9v12 */
    /* JADX WARN: Type inference failed for: r9v14 */
    /* JADX WARN: Type inference failed for: r9v16 */
    /* JADX WARN: Type inference failed for: r9v18 */
    /* JADX WARN: Type inference failed for: r9v19, types: [int] */
    /* JADX WARN: Type inference failed for: r9v21 */
    /* JADX WARN: Type inference failed for: r9v22 */
    /* JADX WARN: Type inference failed for: r9v23 */
    /* JADX WARN: Type inference failed for: r9v24 */
    /* JADX WARN: Type inference failed for: r9v25 */
    /* JADX WARN: Type inference failed for: r9v26, types: [int] */
    /* JADX WARN: Type inference failed for: r9v43, types: [int] */
    /* JADX WARN: Type inference failed for: r9v8 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void httpUrlConnectionPost(java.lang.String r9, android.os.Handler r10) {
        /*
            Method dump skipped, instructions count: 582
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.idl.face.platform.network.NoMotionRequest.httpUrlConnectionPost(java.lang.String, android.os.Handler):void");
    }

    public static void sendMessage(final String str, final Handler handler) {
        if (str == null || str.length() <= 0) {
            return;
        }
        new Thread(new Runnable() { // from class: com.baidu.idl.face.platform.network.NoMotionRequest.1
            @Override // java.lang.Runnable
            public void run() {
                NoMotionRequest.httpUrlConnectionPost(str, handler);
            }
        }).start();
    }
}

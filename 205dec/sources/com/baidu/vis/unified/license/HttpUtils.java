package com.baidu.vis.unified.license;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class HttpUtils {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0193 A[Catch: IOException -> 0x018f, TryCatch #15 {IOException -> 0x018f, blocks: (B:98:0x018b, B:102:0x0193, B:104:0x0198), top: B:134:0x018b }] */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0198 A[Catch: IOException -> 0x018f, TRY_LEAVE, TryCatch #15 {IOException -> 0x018f, blocks: (B:98:0x018b, B:102:0x0193, B:104:0x0198), top: B:134:0x018b }] */
    /* JADX WARN: Removed duplicated region for block: B:117:0x01b1 A[Catch: IOException -> 0x01ad, TryCatch #4 {IOException -> 0x01ad, blocks: (B:113:0x01a9, B:117:0x01b1, B:119:0x01b6), top: B:128:0x01a9 }] */
    /* JADX WARN: Removed duplicated region for block: B:119:0x01b6 A[Catch: IOException -> 0x01ad, TRY_LEAVE, TryCatch #4 {IOException -> 0x01ad, blocks: (B:113:0x01a9, B:117:0x01b1, B:119:0x01b6), top: B:128:0x01a9 }] */
    /* JADX WARN: Removed duplicated region for block: B:123:0x01bf  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x01a9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0152 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:134:0x018b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0118 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:149:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:150:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:151:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0120 A[Catch: IOException -> 0x011c, TryCatch #24 {IOException -> 0x011c, blocks: (B:64:0x0118, B:68:0x0120, B:70:0x0125), top: B:136:0x0118 }] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0125 A[Catch: IOException -> 0x011c, TRY_LEAVE, TryCatch #24 {IOException -> 0x011c, blocks: (B:64:0x0118, B:68:0x0120, B:70:0x0125), top: B:136:0x0118 }] */
    /* JADX WARN: Removed duplicated region for block: B:85:0x015a A[Catch: IOException -> 0x0156, TryCatch #11 {IOException -> 0x0156, blocks: (B:81:0x0152, B:85:0x015a, B:87:0x015f), top: B:132:0x0152 }] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x015f A[Catch: IOException -> 0x0156, TRY_LEAVE, TryCatch #11 {IOException -> 0x0156, blocks: (B:81:0x0152, B:85:0x015a, B:87:0x015f), top: B:132:0x0152 }] */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r0v12, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r0v13, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r0v17 */
    /* JADX WARN: Type inference failed for: r0v18 */
    /* JADX WARN: Type inference failed for: r0v19 */
    /* JADX WARN: Type inference failed for: r0v20 */
    /* JADX WARN: Type inference failed for: r0v24 */
    /* JADX WARN: Type inference failed for: r0v28, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r0v29, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r0v30 */
    /* JADX WARN: Type inference failed for: r0v31 */
    /* JADX WARN: Type inference failed for: r0v32 */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r7v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARN: Type inference failed for: r7v11 */
    /* JADX WARN: Type inference failed for: r7v13 */
    /* JADX WARN: Type inference failed for: r7v14 */
    /* JADX WARN: Type inference failed for: r7v15 */
    /* JADX WARN: Type inference failed for: r7v16, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r7v17 */
    /* JADX WARN: Type inference failed for: r7v19, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r7v22 */
    /* JADX WARN: Type inference failed for: r7v23 */
    /* JADX WARN: Type inference failed for: r7v24 */
    /* JADX WARN: Type inference failed for: r7v25 */
    /* JADX WARN: Type inference failed for: r7v26 */
    /* JADX WARN: Type inference failed for: r7v27 */
    /* JADX WARN: Type inference failed for: r7v9 */
    /* JADX WARN: Type inference failed for: r9v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r9v11 */
    /* JADX WARN: Type inference failed for: r9v12, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r9v13, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r9v14, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r9v18, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r9v19 */
    /* JADX WARN: Type inference failed for: r9v20 */
    /* JADX WARN: Type inference failed for: r9v21 */
    /* JADX WARN: Type inference failed for: r9v22 */
    /* JADX WARN: Type inference failed for: r9v23 */
    /* JADX WARN: Type inference failed for: r9v24 */
    /* JADX WARN: Type inference failed for: r9v7 */
    /* JADX WARN: Type inference failed for: r9v8 */
    /* JADX WARN: Type inference failed for: r9v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.baidu.vis.unified.license.HttpStatus requestPost(java.lang.String r7, java.lang.String r8, java.lang.String r9, java.lang.String r10) {
        /*
            Method dump skipped, instructions count: 453
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.vis.unified.license.HttpUtils.requestPost(java.lang.String, java.lang.String, java.lang.String, java.lang.String):com.baidu.vis.unified.license.HttpStatus");
    }
}

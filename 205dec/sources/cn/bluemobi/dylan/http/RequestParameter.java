package cn.bluemobi.dylan.http;

import androidx.collection.ArrayMap;
import java.io.File;
import java.util.List;
import java.util.Map;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class RequestParameter {
    public static MultipartBody.Part getFilePart(String str, File file) {
        return MultipartBody.Part.createFormData(str, file.getName(), getRequestBody(file));
    }

    public static Map<String, RequestBody> getFilePartMap(String str, List<File> list) {
        ArrayMap arrayMap = new ArrayMap();
        for (int i4 = 0; i4 < list.size(); i4++) {
            File file = list.get(i4);
            RequestBody create = RequestBody.create(MediaType.parse("image/png"), file);
            arrayMap.put(str + i4 + "\"; filename=\"" + file.getName(), create);
        }
        return arrayMap;
    }

    public static RequestBody getRequestBody(String str) {
        return RequestBody.create(MediaType.parse("multipart/form-data"), str);
    }

    public static RequestBody getRequestBody2(File file) {
        return RequestBody.create(MediaType.parse("json"), file);
    }

    public static RequestBody getRequestBody(File file) {
        return RequestBody.create(MediaType.parse("image/png"), file);
    }
}

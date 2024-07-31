package cn.bluemobi.dylan.http;

import androidx.collection.ArrayMap;
import io.netty.handler.codec.http.HttpHeaders;
import java.io.File;
import java.util.List;
import java.util.Map;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class RequestParameter {
    public static MultipartBody.Part getFilePart(String str, File file) {
        return MultipartBody.Part.createFormData(str, file.getName(), getRequestBody(file));
    }

    public static Map<String, RequestBody> getFilePartMap(String str, List<File> list) {
        ArrayMap arrayMap = new ArrayMap();
        for (int i = 0; i < list.size(); i++) {
            File file = list.get(i);
            RequestBody create = RequestBody.create(MediaType.parse("image/png"), file);
            arrayMap.put(str + i + "\"; filename=\"" + file.getName(), create);
        }
        return arrayMap;
    }

    public static RequestBody getRequestBody(String str) {
        return RequestBody.create(MediaType.parse(HttpHeaders.Values.MULTIPART_FORM_DATA), str);
    }

    public static RequestBody getRequestBody2(File file) {
        return RequestBody.create(MediaType.parse("json"), file);
    }

    public static RequestBody getRequestBody(File file) {
        return RequestBody.create(MediaType.parse("image/png"), file);
    }
}

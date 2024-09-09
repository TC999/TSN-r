package xyz.adscope.common.json.inter;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public interface IJSONParse {
    <T> T fromJson(String str, Class<T> cls);

    <T> T fromJsonAnnotation(String str, Class<T> cls);

    String toJson(Object obj);
}

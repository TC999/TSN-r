package xyz.adscope.common.network;

import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import xyz.adscope.common.network.util.IOUtils;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class FileBinary extends BaseContent<FileBinary> implements Binary {

    /* renamed from: b  reason: collision with root package name */
    public File f64771b;

    public FileBinary(File file) {
        this.f64771b = file;
    }

    @Override // xyz.adscope.common.network.BaseContent
    public void a(OutputStream outputStream) {
        FileInputStream fileInputStream = new FileInputStream(this.f64771b);
        IOUtils.write(fileInputStream, outputStream);
        IOUtils.closeQuietly(fileInputStream);
    }

    @Override // xyz.adscope.common.network.Content
    public long contentLength() {
        return this.f64771b.length();
    }

    @Override // xyz.adscope.common.network.Content
    public String contentType() {
        String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(MimeTypeMap.getFileExtensionFromUrl(this.f64771b.getName()));
        return TextUtils.isEmpty(mimeTypeFromExtension) ? "application/octet-stream" : mimeTypeFromExtension;
    }

    @Override // xyz.adscope.common.network.Binary
    public String name() {
        return this.f64771b.getName();
    }
}

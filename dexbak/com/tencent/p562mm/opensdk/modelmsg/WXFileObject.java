package com.tencent.p562mm.opensdk.modelmsg;

import android.os.Bundle;
import com.tencent.p562mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p562mm.opensdk.utils.C12989b;
import com.tencent.p562mm.opensdk.utils.Log;

/* renamed from: com.tencent.mm.opensdk.modelmsg.WXFileObject */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class WXFileObject implements WXMediaMessage.IMediaObject {
    private static final int CONTENT_LENGTH_LIMIT = 1920991232;
    private static final String TAG = "MicroMsg.SDK.WXFileObject";
    private int contentLengthLimit;
    public byte[] fileData;
    public String filePath;

    public WXFileObject() {
        this.contentLengthLimit = CONTENT_LENGTH_LIMIT;
        this.fileData = null;
        this.filePath = null;
    }

    public WXFileObject(String str) {
        this.contentLengthLimit = CONTENT_LENGTH_LIMIT;
        this.filePath = str;
    }

    public WXFileObject(byte[] bArr) {
        this.contentLengthLimit = CONTENT_LENGTH_LIMIT;
        this.fileData = bArr;
    }

    private int getFileSize(String str) {
        return C12989b.m15258a(str);
    }

    @Override // com.tencent.p562mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public boolean checkArgs() {
        String str;
        String str2;
        byte[] bArr = this.fileData;
        if ((bArr == null || bArr.length == 0) && ((str = this.filePath) == null || str.length() == 0)) {
            str2 = "checkArgs fail, both arguments is null";
        } else {
            byte[] bArr2 = this.fileData;
            if (bArr2 == null || bArr2.length <= this.contentLengthLimit) {
                String str3 = this.filePath;
                if (str3 == null || getFileSize(str3) <= this.contentLengthLimit) {
                    return true;
                }
                str2 = "checkArgs fail, fileSize is too large";
            } else {
                str2 = "checkArgs fail, fileData is too large";
            }
        }
        Log.m15264e(TAG, str2);
        return false;
    }

    @Override // com.tencent.p562mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public void serialize(Bundle bundle) {
        bundle.putByteArray("_wxfileobject_fileData", this.fileData);
        bundle.putString("_wxfileobject_filePath", this.filePath);
    }

    public void setContentLengthLimit(int i) {
        this.contentLengthLimit = i;
    }

    public void setFileData(byte[] bArr) {
        this.fileData = bArr;
    }

    public void setFilePath(String str) {
        this.filePath = str;
    }

    @Override // com.tencent.p562mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public int type() {
        return 6;
    }

    @Override // com.tencent.p562mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public void unserialize(Bundle bundle) {
        this.fileData = bundle.getByteArray("_wxfileobject_fileData");
        this.filePath = bundle.getString("_wxfileobject_filePath");
    }
}

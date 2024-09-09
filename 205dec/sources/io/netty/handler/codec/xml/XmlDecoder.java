package io.netty.handler.codec.xml;

import com.fasterxml.aalto.AsyncByteArrayFeeder;
import com.fasterxml.aalto.AsyncXMLInputFactory;
import com.fasterxml.aalto.AsyncXMLStreamReader;
import com.fasterxml.aalto.stax.InputFactoryImpl;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import java.util.List;
import javax.xml.stream.XMLStreamException;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
public class XmlDecoder extends ByteToMessageDecoder {
    private final AsyncByteArrayFeeder streamFeeder;
    private final AsyncXMLStreamReader<AsyncByteArrayFeeder> streamReader;
    private static final AsyncXMLInputFactory XML_INPUT_FACTORY = new InputFactoryImpl();
    private static final XmlDocumentEnd XML_DOCUMENT_END = XmlDocumentEnd.INSTANCE;

    public XmlDecoder() {
        AsyncXMLStreamReader<AsyncByteArrayFeeder> createAsyncForByteArray = XML_INPUT_FACTORY.createAsyncForByteArray();
        this.streamReader = createAsyncForByteArray;
        this.streamFeeder = createAsyncForByteArray.getInputFeeder();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.handler.codec.ByteToMessageDecoder
    public void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        int readableBytes = byteBuf.readableBytes();
        byte[] bArr = new byte[readableBytes];
        byteBuf.readBytes(bArr);
        try {
            this.streamFeeder.feedInput(bArr, 0, readableBytes);
            while (!this.streamFeeder.needMoreInput()) {
                switch (this.streamReader.next()) {
                    case 1:
                        XmlElementStart xmlElementStart = new XmlElementStart(this.streamReader.getLocalName(), this.streamReader.getName().getNamespaceURI(), this.streamReader.getPrefix());
                        for (int i4 = 0; i4 < this.streamReader.getAttributeCount(); i4++) {
                            xmlElementStart.attributes().add(new XmlAttribute(this.streamReader.getAttributeType(i4), this.streamReader.getAttributeLocalName(i4), this.streamReader.getAttributePrefix(i4), this.streamReader.getAttributeNamespace(i4), this.streamReader.getAttributeValue(i4)));
                        }
                        for (int i5 = 0; i5 < this.streamReader.getNamespaceCount(); i5++) {
                            xmlElementStart.namespaces().add(new XmlNamespace(this.streamReader.getNamespacePrefix(i5), this.streamReader.getNamespaceURI(i5)));
                        }
                        list.add(xmlElementStart);
                        break;
                    case 2:
                        XmlElementEnd xmlElementEnd = new XmlElementEnd(this.streamReader.getLocalName(), this.streamReader.getName().getNamespaceURI(), this.streamReader.getPrefix());
                        for (int i6 = 0; i6 < this.streamReader.getNamespaceCount(); i6++) {
                            xmlElementEnd.namespaces().add(new XmlNamespace(this.streamReader.getNamespacePrefix(i6), this.streamReader.getNamespaceURI(i6)));
                        }
                        list.add(xmlElementEnd);
                        break;
                    case 3:
                        list.add(new XmlProcessingInstruction(this.streamReader.getPIData(), this.streamReader.getPITarget()));
                        break;
                    case 4:
                        list.add(new XmlCharacters(this.streamReader.getText()));
                        break;
                    case 5:
                        list.add(new XmlComment(this.streamReader.getText()));
                        break;
                    case 6:
                        list.add(new XmlSpace(this.streamReader.getText()));
                        break;
                    case 7:
                        list.add(new XmlDocumentStart(this.streamReader.getEncoding(), this.streamReader.getVersion(), this.streamReader.isStandalone(), this.streamReader.getCharacterEncodingScheme()));
                        break;
                    case 8:
                        list.add(XML_DOCUMENT_END);
                        break;
                    case 9:
                        list.add(new XmlEntityReference(this.streamReader.getLocalName(), this.streamReader.getText()));
                        break;
                    case 11:
                        list.add(new XmlDTD(this.streamReader.getText()));
                        break;
                    case 12:
                        list.add(new XmlCdata(this.streamReader.getText()));
                        break;
                }
            }
        } catch (XMLStreamException e4) {
            byteBuf.skipBytes(byteBuf.readableBytes());
            throw e4;
        }
    }
}

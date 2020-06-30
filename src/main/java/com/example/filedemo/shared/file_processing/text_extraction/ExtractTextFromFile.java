package com.example.filedemo.shared.file_processing.text_extraction;

import com.example.filedemo.shared.file_processing.file_conversion.MultipartToFileConverter;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.text.PDFTextStripperByArea;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.converter.pdf.PdfConverter;
import org.apache.poi.xwpf.converter.pdf.PdfOptions;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.jsoup.Jsoup;
import org.jsoup.safety.Whitelist;

import org.springframework.web.multipart.MultipartFile;
import java.io.*;

/**
 * @author Vladimir Cvjetkovic
 */
public abstract class ExtractTextFromFile extends MultipartToFileConverter {

    protected String extractTextFromHTML(MultipartFile file) {

        org.jsoup.nodes.Document htmlDocument = null;
        try {
            htmlDocument = Jsoup.parse(convertMultipartFileToFile(file), "utf-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        assert htmlDocument != null;
        String str = htmlDocument.html().replaceAll("\\\\n", "\n");

        return Jsoup.clean(str, "", Whitelist.none(), new org.jsoup.nodes.Document.OutputSettings().prettyPrint(true)).
                replaceAll("\\\\nl", "\n").
                replaceAll("\r", "").
                replaceAll("\n\\s+\n", "\n").
                replaceAll("\n\n+", "\n\n").
                replaceAll("&nbsp;", "\n").
                trim();
    }

    protected String extractTextFromWORD(MultipartFile file) {

        XWPFDocument wordDocument = null;
        try {
            wordDocument = new XWPFDocument(OPCPackage.open(convertMultipartFileToFile(file)));
        } catch (IOException | InvalidFormatException e) {
            e.printStackTrace();
        }
        XWPFWordExtractor xwpfWordExtractor = new XWPFWordExtractor(wordDocument);

        return xwpfWordExtractor.getText();
    }

    protected String extractTextFromPDF(MultipartFile file) {

        PDDocument pdfDocument = null;
        PDFTextStripper tStripper = null;
        try {
            pdfDocument = PDDocument.load(convertMultipartFileToFile(file));
            PDFTextStripperByArea stripper = new PDFTextStripperByArea();
            stripper.setSortByPosition(true);
            tStripper = new PDFTextStripper();

            return tStripper.getText(pdfDocument);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                assert pdfDocument != null;
                pdfDocument.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }


    protected byte[] convertWordToPdf(MultipartFile multipartFile) throws IOException {

        File file = convertMultipartFileToFile(multipartFile);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            InputStream is = new FileInputStream(file);
            XWPFDocument document = new XWPFDocument(is);
            PdfOptions options = PdfOptions.create();
            PdfConverter.getInstance().convert(document, byteArrayOutputStream, options);
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return byteArrayOutputStream.toByteArray();
    }


}

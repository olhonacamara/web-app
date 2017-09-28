/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.donc.util;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
 
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfReaderContentParser;
import com.itextpdf.text.pdf.parser.SimpleTextExtractionStrategy;
import com.itextpdf.text.pdf.parser.TextExtractionStrategy;
import java.io.File;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
 
public class ExtractPageContent {
 
    /** The original PDF that will be parsed. */
    public static final String PREFACE = "/home/danilosetubal/Devlopment/repositories/olho-na-camara/falcon/sggpJaneiro2017.pdf";
    /** The resulting text file. */
    public static final String RESULT = "/home/danilosetubal/Devlopment/repositories/olho-na-camara/falcon/sggpJaneiro2017.txt";
 
    // kitaba1 = new PrintWriter(new OutputStreamWriter(new FileOutputStream(new File(ismmilaf), true), StandardCharsets.UTF_8));

    
    
    /**
     * Parses a PDF to a plain text file.
     * @param pdf the original PDF
     * @param txt the resulting text
     * @throws IOException
     */
    public void parsePdf(String pdf, String txt) throws IOException {
        PdfReader reader = new PdfReader(pdf);
        PdfReaderContentParser parser = new PdfReaderContentParser(reader);
        // PrintWriter out = new PrintWriter(new FileOutputStream(txt));
                
        PrintWriter out = new PrintWriter(new OutputStreamWriter(new FileOutputStream(new File(txt), true), StandardCharsets.UTF_16LE));
        
        TextExtractionStrategy strategy;
        for (int i = 1; i <= reader.getNumberOfPages(); i++) {
            strategy = parser.processContent(i, new SimpleTextExtractionStrategy());
            out.println(strategy.getResultantText());
        }
        out.flush();
        out.close();
        reader.close();
    }
 
    /**
     * Main method.
     * @param    args    no arguments needed
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        new ExtractPageContent().parsePdf(PREFACE, RESULT);
    }
}

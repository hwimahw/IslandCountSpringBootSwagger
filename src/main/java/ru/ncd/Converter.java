
package ru.ncd;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class Converter
{
    public String xmlToString(String xmlFile, String xslFile) throws Exception {
        // Открыть файлы в виде потоков
        InputStream xml = new FileInputStream(xmlFile);
        InputStream xsl = new FileInputStream(xslFile);
        // Сщоздать источник для транформации из потоков
        StreamSource xmlSource = new StreamSource(xml);
        StreamSource stylesource = new StreamSource(xsl);

        // Создать байтовый поток для результата
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        // СОздать приемноик для результатат из байтового потока
        StreamResult xmlOutput = new StreamResult(bos);
        // Создать трансформатор и выполнить трансформацию
        Transformer transformer = TransformerFactory.newInstance().newTransformer(stylesource);
        transformer.transform(xmlSource, xmlOutput);

        // вернуть результат в виде строки
        return bos.toString();
    }

    public static void main(String[] arg) throws IOException {
        Converter c = new Converter();

        final String xml = "./src/main/resources/Matrix.xml";
        final String xsl = "./src/main/resources/MatrixConverter2.xsl";
        try {
            String result = c.xmlToString(xml, xsl);
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }
}
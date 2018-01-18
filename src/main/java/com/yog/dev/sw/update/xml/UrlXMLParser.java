package com.yog.dev.sw.update.xml;

import com.yog.dev.sw.update.beans.Dependency;
import com.yog.dev.sw.update.beans.Update;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author Yougeshwar
 */
public final class UrlXMLParser {

    public Update loadXML(String fileUrl) throws Exception {
        URL url = new URL(fileUrl);

        String baseUrl = fileUrl.substring(0, fileUrl.lastIndexOf("/") + 1);

        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(url.openStream());

        doc.getDocumentElement().normalize();

        NodeList nList = doc.getElementsByTagName("update");

        Node updateNode = nList.item(0);
        Element eElement = (Element) updateNode;

        String version = eElement.getElementsByTagName("version").item(0).getTextContent();
        String mainFile = baseUrl + eElement.getElementsByTagName("main-file").item(0).getTextContent();
        long mainFileSize = getFileSize(new URL(mainFile));
        Update update = new Update(version, mainFile, mainFileSize);

        Element depEle = (Element) eElement.getElementsByTagName("dependencies").item(0);
        if (depEle != null) {
            NodeList dependencies = depEle.getElementsByTagName("dependency");
            for (int i = 0; i < dependencies.getLength(); i++) {
                Element el = (Element) dependencies.item(i);
                String depFile = baseUrl + el.getTextContent();
                long fileSize = getFileSize(new URL(depFile));
                update.addDependency(new Dependency(depFile, fileSize));
            }
        }
        return update;
    }

    private long getFileSize(URL url) {
        try {
            URLConnection conn = url.openConnection();
            return conn.getContentLengthLong();
        } catch (IOException e) {
            return 0;
        }
    }

//    public static void main(String[] args) throws Exception {
//        UrlXMLParser aa = new UrlXMLParser();
//        Update update = (aa.loadXML("http://localhost/update/update.xml"));
//        System.out.println(update);
//    }
}

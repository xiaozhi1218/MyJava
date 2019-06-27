package jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * @author chenyongzhi
 * @create 2019/6/27 21:23
 */
public class JsoupTest {

    @Test
    public void test1() throws IOException {

        String path = JsoupTest.class.getClassLoader().getResource("student.xml").getPath();

        Document document = Jsoup.parse(new File(path), "utf-8");

        Elements elements = document.getElementsByTag("name");

        System.out.println(elements.size());

        Element element = elements.get(0);

        String name = element.text();

        System.out.println(name);

    }

    @Test
    public void test2() throws IOException {
        String path = JsoupTest.class.getClassLoader().getResource("student.xml").getPath();

        /*Document document = Jsoup.parse(new File(path), "utf-8");

        String str = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n" +
                "\n" +
                "<students>\n" +
                "\t<student number=\"heima_0001\">\n" +
                "\t\t<name id=\"itcast\">\n" +
                "\t\t\t<xing>张</xing>\n" +
                "\t\t\t<ming>三</ming>\n" +
                "\t\t</name>\n" +
                "\t\t<age>18</age>\n" +
                "\t\t<sex>male</sex>\n" +
                "\t</student>\n" +
                "\t<student number=\"heima_0002\">\n" +
                "\t\t<name>jack</name>\n" +
                "\t\t<age>18</age>\n" +
                "\t\t<sex>female</sex>\n" +
                "\t</student>\n" +
                "\n" +
                "</students>";
        Document document1 = Jsoup.parse(str);
        System.out.println(document1);*/

        URL url = new URL("https://www.baidu.com");
        Document document2 = Jsoup.parse(url, 10000);
        System.out.println(document2);
    }

    @Test
    public void test3() throws IOException {
        String path = JsoupTest.class.getClassLoader().getResource("student.xml").getPath();

        Document document = Jsoup.parse(new File(path), "utf-8");

        Elements elements = document.getElementsByTag("student");

        System.out.println(elements);

        System.out.println("----------------");

        Elements elements1 = document.getElementsByAttribute("id");
        System.out.println(elements1);

        System.out.println("----------------");

        Elements elements2 = document.getElementsByAttributeValue("number", "heima_0001");

        System.out.println(elements2);

        System.out.println("-----------------");

        Element itcast = document.getElementById("itcast");
        System.out.println(itcast);
    }

    @Test
    public void test4() throws IOException {
        String path = JsoupTest.class.getClassLoader().getResource("student.xml").getPath();

        Document document = Jsoup.parse(new File(path), "utf-8");

        Elements elements = document.getElementsByTag("name");

        System.out.println(elements.size());

        System.out.println("--------------");

        Element element_student = document.getElementsByTag("student").get(0);

        Elements ele_name = element_student.getElementsByTag("name");
        System.out.println(ele_name.size());

        String number = element_student.attr("number");
        System.out.println(number);


        System.out.println("------------");

        String text = ele_name.text();
        String html = ele_name.html();
        System.out.println(text);
        System.out.println(html);


    }

    @Test
    public void test5() throws IOException {

        String path = JsoupTest.class.getClassLoader().getResource("student.xml").getPath();

        Document document = Jsoup.parse(new File(path), "utf-8");

        Elements elements = document.select("name");
//        System.out.println(elements);
        for (Element element : elements) {
            System.out.println(element);
            System.out.println("---------");
        }
        System.out.println("-----------");

        Elements elements1 = document.select("#itcast");
        System.out.println(elements1);


    }


}

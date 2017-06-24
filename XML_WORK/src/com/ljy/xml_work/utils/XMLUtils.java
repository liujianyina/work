package com.ljy.xml_work.utils;

import com.ljy.xml_work.domain.Student;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by 刘剑银 on 2017/6/8.
 */
public class XMLUtils {

    private static Document document;

    static {
        document = getDocment();
    }


    /**
     * 获取Document对象
     *
     * @return
     */
    private static Document getDocment() {
        SAXReader saxReader = new SAXReader();
        saxReader.setEncoding("UTF-8");
        Document document = null;
        try {
            try {
                document = saxReader.read(new InputStreamReader(new FileInputStream(new File("student.xml")), "UTF-8"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return document;
    }

    /**
     * 将dom树保存到xml文档
     */
    public static void save() {
        try {
            FileOutputStream fos = new FileOutputStream("student.xml");
            OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
            OutputFormat of = new OutputFormat();
            of.setEncoding("UTF-8");
            of.setIndent(true);
            of.setIndent("\t");
            of.setNewlines(true);
            XMLWriter xmlWriter = new XMLWriter(osw, of);
            xmlWriter.write(document);
            xmlWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取当前所有学生的信息
     *
     * @return
     */
    public static List<Student> getAllStudent() {

        List<Student> returnList = new ArrayList<>();

        Element root = document.getRootElement();
        //所有student对象
        List list = root.elements();

        for (int i = 0; i < list.size(); i++) {

            //某个student对象
            Element student = (Element) list.get(i);
            Student s = new Student();

            s.setId(Integer.parseInt(student.attributeValue("id")));

            List elements = student.elements();

           /* for (int j = 0; j < elements.size(); j++) {
                System.out.print(((Element) elements.get(j)).getText() + "  ");
            }*/

            s.setName(((Element) elements.get(0)).getText());
            s.setSex(((Element) elements.get(1)).getText());
            s.setDepartment(((Element) elements.get(2)).getText());
            s.setGrade(Integer.parseInt(((Element) elements.get(3)).getText()));

            returnList.add(s);

        }
        return returnList;
    }

    /**
     * 通过id修改学生信息
     *
     * @param id
     */
    public static void update(String id, Student student) {

        Element root = document.getRootElement();
        List students = root.elements();
        for (int i = 0; i < students.size(); i++) {
            Element rstudent = (Element) students.get(i);
            if (id.equals(rstudent.attributeValue("id"))) {

                List elements = rstudent.elements();

                ((Element) elements.get(0)).setText(student.getName());
                ((Element) elements.get(1)).setText(student.getSex());
                ((Element) elements.get(2)).setText(student.getDepartment());
                ((Element) elements.get(3)).setText(student.getGrade() + "");

                save();
                break;
            }
        }

    }


    /**
     * 增加一个新的学生
     *
     * @param student
     */
    public static void addStudent(Student student) {

        Element root = document.getRootElement();
        Element newBook = root.addElement("student");
        newBook.addAttribute("id", student.getId() + "");

        Element name = newBook.addElement("name");
        name.setText(student.getName());

        Element sex = newBook.addElement("sex");
        sex.setText(student.getSex());

        Element department = newBook.addElement("department");
        department.setText(student.getDepartment());

        Element grade = newBook.addElement("grade");
        grade.setText(student.getGrade() + "");

        save();

    }

    /**
     * 通过id删除该学生
     *
     * @param id
     */
    public static void deleteStudent(String id) {

        Element root = document.getRootElement();
        for (Iterator it = root.elementIterator(); it.hasNext(); ) {
            Element book = (Element) it.next();
            String sid = book.attributeValue("id");
            if (sid.equals(id)) {
                Element parent = book.getParent();
                parent.remove(book);
                save();
                break;
            }
        }
    }

}

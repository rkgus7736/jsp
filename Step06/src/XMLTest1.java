import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


public class XMLTest1 {

	public static void main(String[] args) throws Exception {
		File file = new File("test.xml");
		System.out.println(file.exists());
		//DocumentBuilderFactory : 추상화 처리가 되어있어 인스턴스로 찍어내야함
		DocumentBuilderFactory f = DocumentBuilderFactory.newDefaultInstance();
		DocumentBuilder dBuilder = f.newDocumentBuilder();
		Document doc = dBuilder.parse(file);
		doc.getDocumentElement().normalize();
		
		//test.xml의 element이름
		String root = doc.getDocumentElement().getNodeName();
		System.out.println("root: "+ root);	
		NodeList list = doc.getElementsByTagName(root); //company 선택
		//System.out.println(list.getLength());
		Node temp = list.item(0);
		//System.out.println(temp.getNodeName());
		
		//자식 node 접근
		NodeList child = temp.getChildNodes();
		//System.out.println(child.item(1).getNodeName());
		for(int i=0; i<child.getLength();i++) {
			Node n = child.item(i);
			if(n.getNodeType() == Node.ELEMENT_NODE) {
				System.out.println(n.getNodeName());//test.xml에 staff이 두개라서 두개나옴
				System.out.println("no : " + n.getAttributes().getNamedItem("no").getTextContent());//test.xml에 staff이 두개라서 두개나옴
				if(n.getNodeName().equals("staff")) {
					NodeList sChild = n.getChildNodes();
					for(int j=0;j<sChild.getLength();j++) {
						Node t = sChild.item(i);
						if(n.getNodeType() == Node.ELEMENT_NODE) {
							System.out.println(t.getNodeName()+":"+t.getTextContent());
							
						}
					
					}
						
				}
			}
		}
		
	}

}

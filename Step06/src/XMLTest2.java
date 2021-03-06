import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XMLTest2 {
	public static void PrintNode(Node n) {
		//node의 자식 노드들을 전부 출력하는 기능
		NodeList list = n.getChildNodes(); 
		for(int i=0; i<list.getLength();i++) {
			Node t = list.item(i);
			if(t.getNodeType() == Node.ELEMENT_NODE){
				//자식 노드에 또 자식 노드들이 있으면 PrintNode를 호출 
				if(t.getChildNodes().getLength() > 1) {
						PrintNode(t);
					}else {
						
						System.out.println(t.getNodeName()+":"+t.getTextContent());
				}
			}
		}
	}
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
		PrintNode(list.item(0));
	}

}

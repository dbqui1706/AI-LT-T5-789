package lab_2_3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NodeUtils {
	public static List<String> printPath(Node node) {
		if (node != null) {
			List<String> result = new ArrayList<String>();
			result.add(node.getLabel());
			Node tmp;
			while ((tmp = node.getParent()) != null) {

				result.add(tmp.getLabel());
				node = tmp;
			}
			Collections.reverse(result);
			return result;
		} else
			return new ArrayList<String>();
	}

	public static Node dummy(){
		Node nodeStart = new Node("Start");
		Node nodeA = new Node("A"); Node nodeB = new Node("B");
		Node nodeC = new Node("C"); Node nodeD = new Node("D");
		Node nodeE = new Node("E"); Node nodeF = new Node("F");
		Node nodeH = new Node("H"); Node nodeP = new Node("P");
		Node nodeQ = new Node("Q"); Node nodeR = new Node("R");
		Node nodeGoal = new Node("Goal");

		nodeStart.addEdge(nodeD, 3); nodeStart.addEdge(nodeE, 9); nodeStart.addEdge(nodeP, 1);
		nodeB.addEdge(nodeA, 2);
		nodeC.addEdge(nodeA, 2);
		nodeD.addEdge(nodeB, 1); nodeD.addEdge(nodeC, 8); nodeD.addEdge(nodeE, 3);
		nodeE.addEdge(nodeH, 1); nodeE.addEdge(nodeR, 9);
		nodeF.addEdge(nodeC, 5); nodeF.addEdge(nodeGoal, 5);
		nodeH.addEdge(nodeP, 4); nodeH.addEdge(nodeQ, 4);
		nodeP.addEdge(nodeQ, 15);
		nodeQ.addEdge(nodeR, 3);
		nodeR.addEdge(nodeF, 5);

		return nodeStart;
	}
}

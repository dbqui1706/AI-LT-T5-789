package lab_8_Minimax_AlphaBeta.game_alphabeta_student;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public class MiniMaxSearchAlgo implements ISearchAlgo {
	private boolean isMax;
	// function MINIMAX-DECISION(state) returns an action
	// inputs: state, current state in game
	// v <- MAX-VALUE(state)
	// return the action in SUCCESSORS(state) with value v
	@Override
	public void execute(Node node) {
		// Enter your code here
		node.setValue(maxValue(node));
	}

	@Override
	public Node bestNextNode(Node node, boolean isMax) {
		if (isMax){
			return maxNode(node);
		}else return minNode(node);
	}

	// function MAX-VALUE(state) returns a utility value
	// if TERMINAL-TEST(state) then return UTILITY(state)
	// v <- Integer.MIN_VALUE
	// for each s in SUCCESSORS(state) do
	// v <- MAX(v, MIN-VALUE(s))
	// return v
	public int maxValue(Node node) {
		// Enter your code here
		if (node.isTerminal()){
			return node.getValue();
		}
		int v = Integer.MIN_VALUE;
		for (Node curr: node.getChildren()){
			v = Math.max(v, minValue(curr));
		}
		return v;
	}
	// function MIN-VALUE(state) returns a utility value
	// if TERMINAL-TEST(state) then return UTILITY(state)
	// v <- Integer.MAX_VALUE
	// for each s in SUCCESSORS(state) do
	// v <- MIN(v, MAX-VALUE(s))
	// return v

	public int minValue(Node node) {
		// Enter your code here
		if (node.isTerminal()) return node.getValue();
		int v = Integer.MAX_VALUE;
		for (Node minNode : node.getChildren()){
			v = Math.min(v, maxValue(minNode));
		}
		return v;
	}

	public Node maxNode(Node node){
		if (node.isTerminal()) return node;
		Node maxNode = null;
		int max = Integer.MIN_VALUE;
		for (Node curr : node.getChildren()){
			int c = minValue(curr);
			if (max < c){
				maxNode = curr;
				max = c;
			}
		}
		return maxNode;
	}
	public Node minNode(Node node){
		if (node.isTerminal()) return node;
		Node minNode = null;
		int min = Integer.MAX_VALUE;
		for (Node curr : node.getChildren()){
			int c = minValue(curr);
			if (min > c){
				minNode = curr;
				min = c;
			}
		}
		return minNode;
	}
}

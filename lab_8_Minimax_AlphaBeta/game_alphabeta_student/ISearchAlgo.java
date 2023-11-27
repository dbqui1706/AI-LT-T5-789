package lab_8_Minimax_AlphaBeta.game_alphabeta_student;

public interface ISearchAlgo {
	public void execute(Node node);
	public Node bestNextNode(Node node, boolean isMax);
}

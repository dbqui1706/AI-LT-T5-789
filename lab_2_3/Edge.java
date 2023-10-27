package lab_2_3;

import java.util.Objects;

public class Edge implements Comparable<Edge>{
	private Node begin;
	private Node end;
	private double weight;

	public Edge(Node begin, Node end, double weight) {
		super();
		this.begin = begin;
		this.end = end;
		this.weight = weight;
	}

	public Edge(Node begin, Node end) {
		super();
		this.begin = begin;
		this.end = end;
		this.weight = 1;
	}

	public Node getBegin() {
		return begin;
	}

	public Node getEnd() {
		return end;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Edge edge = (Edge) o;
		return Objects.equals(weight, edge.weight) && Objects.equals(begin, edge.begin) && Objects.equals(end, edge.end);
	}

	@Override
	public int hashCode() {
		return Objects.hash(begin, end, weight);
	}

	public double getWeight() {
		return weight;
	}

	@Override
	public int compareTo(Edge o) {
		return -this.end.getLabel().compareTo(o.getEnd().getLabel());
	}

}

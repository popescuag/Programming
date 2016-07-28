package powerOf2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class PowersOfTwo {
	class Node {
		long sum;
		List<Long> numbersList;

		public Node(long sum, List<Long> numbersList) {
			this.sum = sum;
			this.numbersList = numbersList;
		}

		public long getSum() {
			return sum;
		}

		public List<Long> getNumbersList() {
			return numbersList;
		}
	}

	private List<Long> sums = new ArrayList<Long>();

	private List<Node> buildNodes(Node parent) {
		List<Node> childNodes = new ArrayList<Node>();
		if (parent.getNumbersList().size() > 1) {
			for (int i = 0; i < parent.getNumbersList().size(); i++) {
				long number = parent.getNumbersList().get(i);
				List<Long> newNumbers = new ArrayList<Long>(
						parent.getNumbersList());
				newNumbers.remove(i);
				long sum = parent.getSum() - number;
				Node newNode = new Node(sum, newNumbers);
				if (!sums.contains(sum)) {
					sums.add(sum);
				}
				childNodes.add(newNode);
			}
		}

		return childNodes;
	}

	private void process(Node n) {
		List<Node> childNodes = new ArrayList<Node>();
		childNodes = buildNodes(n);
		for (Node child : childNodes) {
			process(child);
			if (childNodes.size() < 1) {
				return;
			}
		}
	}

	public long count(long[] powers) {
		long count = 0;

		List<Long> powList = new ArrayList<Long>();
		Arrays.sort(powers);
		// remove duplicates, store them in a separate structure
		Map<Long, Integer> duplicates = new HashMap<Long, Integer>(); // duplicates[x][0]
		// =
		// duplicate
		// number;
		// duplicates[x][1]
		// =
		// number
		// of
		// appearances
		for (int i = 0; i < powers.length; i++) {
			if (powList.contains(powers[i])) {
				Object o = duplicates.get(powers[i]);
				if (o != null) {
					int tmpCount = (Integer) o;
					tmpCount++;
					duplicates.put(powers[i], tmpCount);
				} else {
					duplicates.put(powers[i], 1);
				}
			} else {
				powList.add(powers[i]);
			}
		}

		if (duplicates.isEmpty()) {
			count = (long) Math.pow(2, powers.length);
		} else {
			// duplicates found
			Iterator<Long> duplicatesIterator = duplicates.keySet().iterator();
			while (duplicatesIterator.hasNext()) {
				Long duplicateValue = duplicatesIterator.next();
				int tmpCount = duplicates.get(duplicateValue);

				int idx = 2;
				// build groups of duplicates and find if their sum appears in
				// the initial list
				if (duplicateValue == 1L) {
					do {
						long tmpVal = duplicateValue * idx;
						if (powList.contains(tmpVal)) {
							idx *= 2;
						} else {
							// element not found
							powList.add(tmpVal);
							tmpCount -= idx;
						}
					} while (idx < tmpCount);
					count += tmpCount;
				} else {
					idx = 1;
					boolean additionsMade = false;
					do {
						long tmpVal = (long) (duplicateValue * Math.pow(2, idx));
						if (powList.contains(tmpVal)) {
							idx++;
						} else {
							// element not found
							powList.add(tmpVal);
							tmpCount -= idx;
							additionsMade = true;
						}
					} while (idx < tmpCount + 1);
					if (tmpCount > 0 && additionsMade) {
						count += tmpCount;
					}
				}
			}
			count += (long) Math.pow(2, powList.size());
		}

		return count;
	}

	public long count1(long[] powers) {
		long sum = 0;
		List<Long> powList = new ArrayList<Long>();
		// remove duplicates, store them in a separate structure
		Map<Long, Integer> duplicates = new HashMap<Long, Integer>(); // duplicates[x][0]
		// =
		// duplicate
		// number;
		// duplicates[x][1]
		// =
		// number
		// of
		// appearances
		for (int i = 0; i < powers.length; i++) {
			if (powList.contains(powers[i])) {
				Object o = duplicates.get(powers[i]);
				if (o != null) {
					int count = (Integer) o;
					count++;
					duplicates.put(powers[i], count);
				} else {
					duplicates.put(powers[i], 1);
				}
			} else {
				sum += powers[i];
				powList.add(powers[i]);
			}

		}

		// no duplicates? return 2^sums.size()
		// duplicates found: create groups of duplicate value and add them to
		// the numbers list. eliminate the values from the duplicates list.
		// TBD: what to do with duplicates?

		sums.add(0L);
		sums.add(sum);
		Node parent = new Node(sum, powList);
		process(parent);
		// add duplicates
		if (!duplicates.isEmpty()) {
			Iterator<Long> duplicatesIterator = duplicates.keySet().iterator();
			while (duplicatesIterator.hasNext()) {
				Long duplicateValue = duplicatesIterator.next();
				int count = duplicates.get(duplicateValue);
				for (int i = 1; i < count; i++) {
					// for (long currSum : sums) {
					for (int j = 0; j < sums.size(); j++) {
						long currSum = sums.get(j);
						long newSum = currSum + (i * duplicateValue);
						if (!sums.contains(newSum)) {
							sums.add(newSum);
						}
					}
				}
			}
		}
		return sums.size();
	}
}

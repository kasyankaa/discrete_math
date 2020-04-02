package diskretna;

import java.util.LinkedList;
import java.util.List;

public class SecondAlgorithm {
	private static final int numberOfNumbersInRaw = 4;
	private static int block[] = new int[numberOfNumbersInRaw];
	private static int next[] = new int[numberOfNumbersInRaw];
	private static int previous[] = new int[numberOfNumbersInRaw];
	private static boolean moveForward[] = new boolean[numberOfNumbersInRaw];

	static {
		for (int currentNumber = 0; currentNumber < numberOfNumbersInRaw; currentNumber++) {
			block[currentNumber] = 0;
			moveForward[currentNumber] = true;
		}
		next[0] = 0;
	}

	private static void printLine() {
		List<List<Integer>> blocks = new LinkedList<List<Integer>>();
		for (int currentNumber = 0; currentNumber < numberOfNumbersInRaw; currentNumber++) {
			blocks.add(new LinkedList<Integer>());
		}
		for (int i = 0; i < numberOfNumbersInRaw; i++) {
			blocks.get(block[i]).add(i);
		}
		for (List<Integer> list : blocks) {
			if (!list.isEmpty()) {
				System.out.print("(");
				for (Integer element : list) {
					if (list.indexOf(element) != 0) {
						System.out.print(" ");
					}
					System.out.print(element + 1);
				}

				System.out.print(")");
			}
		}
		System.out.println();

	}

	public static void main(String[] args) {
		printLine();
		int thisNumber = numberOfNumbersInRaw - 1;
		while (thisNumber > 0) {
			int currentBlock = block[thisNumber];
			if (moveForward[thisNumber]) {
				if (next[currentBlock] == 0) {
					next[currentBlock] = thisNumber;
					previous[thisNumber] = currentBlock;
					next[thisNumber] = 0;
				}
				if (next[currentBlock] > thisNumber) {
					previous[thisNumber] = currentBlock;
					next[thisNumber] = next[currentBlock];
					previous[next[currentBlock]] = thisNumber;
					next[currentBlock] = thisNumber;
				}
				block[thisNumber] = next[currentBlock];
			} else {
				block[thisNumber] = previous[currentBlock];
				if (currentBlock == thisNumber) {
					if (next[thisNumber] == 0) {
						next[previous[currentBlock]] = 0;
					} else {
						next[previous[currentBlock]] = next[currentBlock];
						previous[next[currentBlock]] = previous[currentBlock];
					}
				}
			}
			printLine();

			thisNumber = numberOfNumbersInRaw - 1;
			while ((thisNumber > 0) && ((moveForward[thisNumber] && block[thisNumber] == thisNumber)
					|| (!moveForward[thisNumber] && block[thisNumber] == 0))) {
				moveForward[thisNumber] = !moveForward[thisNumber];
				thisNumber -= 1;
			}
		}
	}
}
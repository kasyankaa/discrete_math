package diskretna;

public class FirstAlghorithm {

	public static int numberOfNumbersInRaw = 4;
	private static int[] array;

	static {
		array = new int[numberOfNumbersInRaw + 1];
		for (int currentNumber = 1; currentNumber <= numberOfNumbersInRaw; currentNumber++) {
			array[currentNumber] = currentNumber;
		}
	}

	private static int function(int thisNumber, int currentNumber) {
		if ((thisNumber % 2 == 0) && (thisNumber > 2)) {
			if (currentNumber < thisNumber - 1) {
				return currentNumber;
			} else {
				return thisNumber - 2;
			}
		} else {
			return thisNumber - 1;
		}
	}

	private static void result(int thisNumber) {
		if (thisNumber == 1) {
			for (int currentNumber = 1; currentNumber <= numberOfNumbersInRaw; currentNumber++) {
				System.out.print(array[currentNumber] + " ");
			}
			System.out.println(" ");
		} else
			for (int currentNumber = 1; currentNumber <= thisNumber; currentNumber++) {
				result(thisNumber - 1);
				if (currentNumber < thisNumber) {
					int resultingNumber = function(thisNumber, currentNumber);
					array[resultingNumber] = array[resultingNumber] + array[thisNumber]
							- (array[thisNumber] = array[resultingNumber]);
				}
			}
	}

	public static void main(String[] args) {
		result(numberOfNumbersInRaw);
	}

}

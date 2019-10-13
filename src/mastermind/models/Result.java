package mastermind.models;

public class Result {

	private int blacks = 0;

	private int whites = 0;
	
	public Result() {
	}

	public Result(int blacks, int whites) {
		assert blacks >= 0;
		assert whites >= 0;
		this.blacks = blacks;
		this.whites = whites;
	}

	public boolean isWinner() {
		return this.blacks == Combination.getWidth();
	}

	public int getBlacks() {
		return this.blacks;
	}
	
	public void setBlacks(int blacks) {
		this.blacks = blacks;
	}

	public int getWhites() {
		return this.whites;
	}
	
	public void setWhites(int whites) {
		this.whites = whites;
	}
	
	public Result copy() {
		return new Result(this.blacks, this.whites);
	}

}

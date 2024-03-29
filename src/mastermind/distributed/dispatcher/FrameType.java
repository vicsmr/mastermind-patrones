package mastermind.distributed.dispatcher;

public enum FrameType {
	
	START, 
	STATE,
	UNDO, 
	REDO, 
	UNDOABLE, 
	REDOABLE, 
	WINNER, 
	LOSER, 
	ATTEMPTS, 
	COLORS, 
	PROPOSED_COMBINATION, 
	WIDTH,
	NEW_GAME,
	EXISTS, 
	HAS_NAME, 
	SAVE,
	NEXT,
	CLOSE, 
	START_NAME, 
	TITLES, 
	GET_TITLE, 
	SET_TITLE, 
	SAVE_NAMED, 
	BLACKS, 
	WHITES;

	public static FrameType parser(String string) {
		for(FrameType frameType : FrameType.values()) {
			if (frameType.name().equals(string)) {
				return frameType;
			}
		}
		return null;
	}

}

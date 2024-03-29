package mastermind.distributed;

import mastermind.distributed.dispatcher.DispatcherPrototype;
import mastermind.distributed.dispatcher.FrameType;
import mastermind.distributed.dispatcher.GetTitleDispatcher;
import mastermind.distributed.dispatcher.NextDispatcher;
import mastermind.distributed.dispatcher.ResumeDispatcher;
import mastermind.distributed.dispatcher.SetTitleDispatcher;
import mastermind.distributed.dispatcher.StartDispatcher;
import mastermind.distributed.dispatcher.StartNameDispatcher;
import mastermind.distributed.dispatcher.StateDispatcher;
import mastermind.distributed.dispatcher.WidthDispatcher;
import mastermind.distributed.dispatcher.gameinfo.ColorsDispatcher;
import mastermind.distributed.dispatcher.gameinfo.GetAttemptsDispatcher;
import mastermind.distributed.dispatcher.gameinfo.GetBlacksDispatcher;
import mastermind.distributed.dispatcher.gameinfo.GetWhitesDispatcher;
import mastermind.distributed.dispatcher.gameinfo.IsLoserDispatcher;
import mastermind.distributed.dispatcher.gameinfo.IsWinnerDispatcher;
import mastermind.distributed.dispatcher.gameinfo.ProposedCombinationDispatcher;
import mastermind.distributed.dispatcher.saves.ExistsDispatcher;
import mastermind.distributed.dispatcher.saves.GamesNamesDispatcher;
import mastermind.distributed.dispatcher.saves.HasNameDispatcher;
import mastermind.distributed.dispatcher.saves.SaveDispatcher;
import mastermind.distributed.dispatcher.saves.SaveNamedDispatcher;
import mastermind.distributed.dispatcher.undoredo.RedoDispatcher;
import mastermind.distributed.dispatcher.undoredo.RedoableDispatcher;
import mastermind.distributed.dispatcher.undoredo.UndoDispatcher;
import mastermind.distributed.dispatcher.undoredo.UndoableDispatcher;
import mastermind.controllers.implementation.LogicImplementation;

public class LogicImplementationServer extends LogicImplementation {

	protected void createDispatchers(DispatcherPrototype dispatcherPrototype) {
		dispatcherPrototype.add(FrameType.START, new StartDispatcher(this.startControllerImplementation));
        dispatcherPrototype.add(FrameType.NEW_GAME, new ResumeDispatcher(this.resumeControllerImplementation));
        dispatcherPrototype.add(FrameType.START_NAME, new StartNameDispatcher(this.startControllerImplementation));
        dispatcherPrototype.add(FrameType.TITLES, new GamesNamesDispatcher(this.startControllerImplementation));
        dispatcherPrototype.add(FrameType.STATE, new StateDispatcher(this.playControllerImplementation));
        dispatcherPrototype.add(FrameType.UNDO, new UndoDispatcher(this.playControllerImplementation));
        dispatcherPrototype.add(FrameType.REDO, new RedoDispatcher(this.playControllerImplementation));
        dispatcherPrototype.add(FrameType.UNDOABLE, new UndoableDispatcher(this.playControllerImplementation));
        dispatcherPrototype.add(FrameType.REDOABLE, new RedoableDispatcher(this.playControllerImplementation));
		
		dispatcherPrototype.add(FrameType.ATTEMPTS, new GetAttemptsDispatcher(this.playControllerImplementation));
		dispatcherPrototype.add(FrameType.WINNER, new IsWinnerDispatcher(this.playControllerImplementation));
		dispatcherPrototype.add(FrameType.LOSER, new IsLoserDispatcher(this.playControllerImplementation));
		dispatcherPrototype.add(FrameType.COLORS, new ColorsDispatcher(this.playControllerImplementation));
		dispatcherPrototype.add(FrameType.PROPOSED_COMBINATION,
				new ProposedCombinationDispatcher(this.playControllerImplementation));
		dispatcherPrototype.add(FrameType.WIDTH, new WidthDispatcher(this.playControllerImplementation));
		dispatcherPrototype.add(FrameType.NEXT, new NextDispatcher(this.playControllerImplementation));
		dispatcherPrototype.add(FrameType.BLACKS, new GetBlacksDispatcher(this.playControllerImplementation));
		dispatcherPrototype.add(FrameType.WHITES, new GetWhitesDispatcher(this.playControllerImplementation));
		
		dispatcherPrototype.add(FrameType.SAVE, new SaveDispatcher(this.saveControllerImplementation));
		dispatcherPrototype.add(FrameType.SAVE_NAMED, new SaveNamedDispatcher(this.saveControllerImplementation));
		dispatcherPrototype.add(FrameType.HAS_NAME, new HasNameDispatcher(this.saveControllerImplementation));
		dispatcherPrototype.add(FrameType.EXISTS, new ExistsDispatcher(this.saveControllerImplementation));
		dispatcherPrototype.add(FrameType.GET_TITLE, new GetTitleDispatcher(this.saveControllerImplementation));
		dispatcherPrototype.add(FrameType.SET_TITLE, new SetTitleDispatcher(this.saveControllerImplementation));
	}

}

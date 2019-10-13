package distributed;

import distributed.dispatcher.AttemptsDispatcher;
import distributed.dispatcher.BlacksDispatcher;
import distributed.dispatcher.ColorsDispatcher;
import distributed.dispatcher.DispatcherPrototype;
import distributed.dispatcher.ExistsDispatcher;
import distributed.dispatcher.FrameType;
import distributed.dispatcher.GetTitleDispatcher;
import distributed.dispatcher.HasNameDispatcher;
import distributed.dispatcher.LoserDispatcher;
import distributed.dispatcher.NextDispatcher;
import distributed.dispatcher.ProposedCombinationDispatcher;
import distributed.dispatcher.RedoDispatcher;
import distributed.dispatcher.RedoableDispatcher;
import distributed.dispatcher.ResumeDispatcher;
import distributed.dispatcher.SaveDispatcher;
import distributed.dispatcher.SaveNamedDispatcher;
import distributed.dispatcher.SetTitleDispatcher;
import distributed.dispatcher.StartDispatcher;
import distributed.dispatcher.StartNameDispatcher;
import distributed.dispatcher.StateDispatcher;
import distributed.dispatcher.TitlesDispatcher;
import distributed.dispatcher.UndoDispatcher;
import distributed.dispatcher.UndoableDispatcher;
import distributed.dispatcher.WhitesDispatcher;
import distributed.dispatcher.WidthDispatcher;
import distributed.dispatcher.WinnerDispatcher;
import mastermind.controllers.implementation.LogicImplementation;

public class LogicImplementationServer extends LogicImplementation {

	public void createDispatchers(DispatcherPrototype dispatcherPrototype) {
		dispatcherPrototype.add(FrameType.START, new StartDispatcher(this.startControllerImplementation));
        dispatcherPrototype.add(FrameType.NEW_GAME, new ResumeDispatcher(this.resumeControllerImplementation));
        dispatcherPrototype.add(FrameType.START_NAME, new StartNameDispatcher(this.startControllerImplementation));
        dispatcherPrototype.add(FrameType.TITLES, new TitlesDispatcher(this.startControllerImplementation));
        dispatcherPrototype.add(FrameType.STATE, new StateDispatcher(this.playControllerImplementation));
        dispatcherPrototype.add(FrameType.UNDO, new UndoDispatcher(this.playControllerImplementation));
        dispatcherPrototype.add(FrameType.REDO, new RedoDispatcher(this.playControllerImplementation));
        dispatcherPrototype.add(FrameType.UNDOABLE, new UndoableDispatcher(this.playControllerImplementation));
        dispatcherPrototype.add(FrameType.REDOABLE, new RedoableDispatcher(this.playControllerImplementation));
		
		dispatcherPrototype.add(FrameType.ATTEMPTS, new AttemptsDispatcher(this.playControllerImplementation));
		dispatcherPrototype.add(FrameType.WINNER, new WinnerDispatcher(this.playControllerImplementation));
		dispatcherPrototype.add(FrameType.LOSER, new LoserDispatcher(this.playControllerImplementation));
		dispatcherPrototype.add(FrameType.COLORS, new ColorsDispatcher(this.playControllerImplementation));
		dispatcherPrototype.add(FrameType.PROPOSED_COMBINATION,
				new ProposedCombinationDispatcher(this.playControllerImplementation));
		dispatcherPrototype.add(FrameType.WIDTH, new WidthDispatcher(this.playControllerImplementation));
		dispatcherPrototype.add(FrameType.NEXT, new NextDispatcher(this.playControllerImplementation));
		dispatcherPrototype.add(FrameType.BLACKS, new BlacksDispatcher(this.playControllerImplementation));
		dispatcherPrototype.add(FrameType.WHITES, new WhitesDispatcher(this.playControllerImplementation));
		
		dispatcherPrototype.add(FrameType.SAVE, new SaveDispatcher(this.saveControllerImplementation));
		dispatcherPrototype.add(FrameType.SAVE_NAMED, new SaveNamedDispatcher(this.saveControllerImplementation));
		dispatcherPrototype.add(FrameType.HAS_NAME, new HasNameDispatcher(this.saveControllerImplementation));
		dispatcherPrototype.add(FrameType.EXISTS, new ExistsDispatcher(this.saveControllerImplementation));
		dispatcherPrototype.add(FrameType.GET_TITLE, new GetTitleDispatcher(this.saveControllerImplementation));
		dispatcherPrototype.add(FrameType.SET_TITLE, new SetTitleDispatcher(this.saveControllerImplementation));
	}

}

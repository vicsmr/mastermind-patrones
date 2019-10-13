package distributed;

import mastermind.GraphicsMastermind;
import mastermind.controllers.Logic;

public class GraphicsMastermindClient extends GraphicsMastermind {
	
	private LogicProxy logicProxy;
	
	@Override
	protected Logic createLogic() {
		this.logicProxy = new LogicProxy();
		return this.logicProxy;
	}
	
	@Override
	protected void play() {
		super.play();
		this.logicProxy.close();
	}
	
	public static void main(String[] args) {
		new GraphicsMastermindClient().play();
	}

}

package mastermind.distributed;

import mastermind.distributed.dispatcher.TCPIP;
import mastermind.controllers.Logic;
import mastermind.models.StateValue;

public class LogicProxy extends Logic {
	
	private TCPIP tcpip;

	protected LogicProxy() {
        this.tcpip = TCPIP.createClientSocket();
        this.session = new SessionProxy(this.tcpip);
        this.acceptorControllers.put(StateValue.INITIAL, new StartControllerProxy(this.session, this.tcpip));
        this.acceptorControllers.put(StateValue.IN_GAME, new PlayControllerProxy(this.session, this.tcpip));
        this.acceptorControllers.put(StateValue.SAVING, new SaveControllerProxy(this.session, this.tcpip));
        this.acceptorControllers.put(StateValue.FINAL, new ResumeControllerProxy(this.session, this.tcpip));
        this.acceptorControllers.put(StateValue.EXIT, null);
    }

	protected void close() {
        this.tcpip.close();
    }

}

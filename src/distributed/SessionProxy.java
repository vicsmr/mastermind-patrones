package distributed;

import distributed.dispatcher.FrameType;
import distributed.dispatcher.TCPIP;
import mastermind.models.Session;
import mastermind.models.StateValue;

public class SessionProxy implements Session {
	
	private TCPIP tcpip;

	public SessionProxy(TCPIP tcpip) {
		this.tcpip = tcpip;
	}
	
	@Override
	public StateValue getStateValue() {
		this.tcpip.send(FrameType.STATE.name());
		return StateValue.values()[this.tcpip.receiveInt()];
	}

	@Override
	public int getWidth() {
		this.tcpip.send(FrameType.WIDTH.name());
		return this.tcpip.receiveInt();
	}
	
	@Override
	public String getName() {
		this.tcpip.send(FrameType.GET_TITLE.name());
		return this.tcpip.receiveLine();
	}
	
	@Override
	public void setName(String title) {
		this.tcpip.send(FrameType.SET_TITLE.name());
		this.tcpip.send(title);
	}

}

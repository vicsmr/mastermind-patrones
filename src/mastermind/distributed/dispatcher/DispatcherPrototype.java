package mastermind.distributed.dispatcher;

import java.util.HashMap;
import java.util.Map;

public class DispatcherPrototype {
	
	private TCPIP tcpip;
	
	private Map<FrameType, Dispatcher> dispatcherMap;
	
	public DispatcherPrototype() {
		this.tcpip = TCPIP.createServerSocket();
		this.dispatcherMap = new HashMap<FrameType, Dispatcher>();
	}
	
	public void add(FrameType frameType, Dispatcher dispatcher) {
		this.dispatcherMap.put(frameType, dispatcher);
		dispatcher.associate(this.tcpip);
	}

	public void dispatch(FrameType frameType) {
		Dispatcher dispatcher = this.dispatcherMap.get(frameType);
		dispatcher.dispatch();
	}

	public void serve() {
		FrameType frameType = null;
		do {
			frameType = FrameType.parser(this.tcpip.receiveLine());
			if (frameType != FrameType.CLOSE) {
				this.dispatch(frameType);
			}
		} while (frameType != FrameType.CLOSE);
		this.tcpip.close();		
	}

}

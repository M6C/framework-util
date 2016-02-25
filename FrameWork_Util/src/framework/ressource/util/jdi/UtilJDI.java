package framework.ressource.util.jdi;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.sun.jdi.AbsentInformationException;
import com.sun.jdi.Bootstrap;
import com.sun.jdi.ClassType;
import com.sun.jdi.Location;
import com.sun.jdi.VirtualMachine;
import com.sun.jdi.connect.AttachingConnector;
import com.sun.jdi.connect.Connector;
import com.sun.jdi.connect.IllegalConnectorArgumentsException;
import com.sun.jdi.request.BreakpointRequest;
import com.sun.jdi.request.EventRequestManager;

public class UtilJDI {

	private UtilJDI() {
	}

	public static VirtualMachine createVirtualMachine(String hostName, Integer port) throws IOException, IllegalConnectorArgumentsException {
		VirtualMachine ret = null;
    	Connector connector=null;
    	List connectors=Bootstrap.virtualMachineManager().allConnectors();
    	Iterator iter=connectors.iterator();
    	while (iter.hasNext()) {
    		Connector thisConnector=(Connector)iter.next();
    		if (thisConnector.name().equals("com.sun.jdi.SocketAttach"))
    			connector=thisConnector;
    	}
    	if (connector!=null) {
    		Map arguments=connector.defaultArguments();
    		Connector.Argument cHost=(Connector.Argument) arguments.get("hostname");
    		Connector.Argument cPort=(Connector.Argument) arguments.get("port");
    		cHost.setValue(hostName);//"localhost");//targetMachine");
    		cPort.setValue(port.toString());//"4082");//4142");//8000");
    		for (Iterator itr=arguments.keySet().iterator(); itr.hasNext(); ) {
    			Connector.Argument argument=(Connector.Argument)arguments.get(itr.next());
    			System.out.println("label:"+argument.label()+" name:"+argument.name()+" value:"+argument.value());
    		}
    		AttachingConnector attacher=(AttachingConnector) connector;
    		ret = attacher.attach(arguments);
    	}
    	return ret;
	}

	public static BreakpointRequest createBreakpointRequest(VirtualMachine virtualMachine, String className, Integer rowNum) throws AbsentInformationException {
		BreakpointRequest ret = null;
		EventRequestManager em = virtualMachine.eventRequestManager();
		List listClass = virtualMachine.classesByName(className);
		if ((listClass!=null)&&(listClass.size()>0)) {
			ClassType ct = (ClassType)listClass.get(0);
			List listLocation = ct.locationsOfLine(rowNum.intValue());
			if ((listLocation!=null)&&(listLocation.size()>0)) {
				Location loc = (Location)listLocation.get(0);
				ret =em.createBreakpointRequest(loc);
				ret.enable();
			}
		}
		return ret;
	}
}
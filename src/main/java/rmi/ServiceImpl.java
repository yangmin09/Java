package rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created by yangmin on 16/8/14.
 */
public class ServiceImpl extends UnicastRemoteObject implements IService {

	private static final long serialVersionUID = 4077329331699640331L;
	//UnicastRemoteOjbect的无参构造方法将自动生成stub&skeleton
	private String name;

	public ServiceImpl(String name) throws RemoteException {
		this.name = name;
	}

	@Override
	public String service(String content) {
		return "server >> " + content;
	}


}

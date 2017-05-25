package rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by yangmin on 16/8/14.
 */
public interface IService extends Remote {

	//声明服务器端必须提供的服务
	String service(String content) throws RemoteException;

}
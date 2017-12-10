package uz.ruslan.gwttimeout;

import com.google.gwt.core.ext.typeinfo.JClassType;
import com.google.gwt.user.rebind.rpc.ProxyCreator;
import com.google.gwt.user.rebind.rpc.ServiceInterfaceProxyGenerator;

/**
 * User: dilsh0d
 * Date: 20.07.13 17:45
 */
public class MumarRpcRemoteProxyGenerator extends ServiceInterfaceProxyGenerator {

    @Override
    protected ProxyCreator createProxyCreator(JClassType remoteService) {
        return new MumarProxyCreator(remoteService);
    }
}

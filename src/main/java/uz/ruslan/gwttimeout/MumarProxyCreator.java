package uz.ruslan.gwttimeout;

import com.google.gwt.core.ext.typeinfo.JClassType;
import com.google.gwt.core.ext.typeinfo.JMethod;
import com.google.gwt.core.ext.typeinfo.TypeOracle;
import com.google.gwt.user.rebind.SourceWriter;
import com.google.gwt.user.rebind.rpc.ProxyCreator;
import com.google.gwt.user.rebind.rpc.SerializableTypeOracle;

import java.util.Map;

/**
 * User: dilsh0d
 * Date: 20.07.13 17:53
 */
public class MumarProxyCreator extends ProxyCreator {

    private final String methodStrTemplate = "@Override\n"
                                             + "protected <T> com.google.gwt.http.client.Request doInvoke(ResponseReader responseReader, "
                                             + "String methodName, RpcStatsContext statsContext, String requestData, "
                                             + "com.google.gwt.user.client.rpc.AsyncCallback<T> callback) {\n"
                                             + "${method-body}" + "}\n";

    public MumarProxyCreator(JClassType serviceIntf) {
        super(serviceIntf);
    }

    @Override
    protected void generateProxyMethods(SourceWriter w, SerializableTypeOracle serializableTypeOracle, TypeOracle typeOracle, Map<JMethod, JMethod> syncMethToAsyncMethMap) {
        // generate standard proxy methods
        super.generateProxyMethods(w, serializableTypeOracle, typeOracle, syncMethToAsyncMethMap);

        // generate additional method
        overrideDoInvokeMethod(w);
    }

    private void overrideDoInvokeMethod(SourceWriter w) {
        StringBuilder methodBody = new StringBuilder();
        methodBody.append("final com.google.gwt.user.client.rpc.AsyncCallback newAsyncCallback = new com.motoriety.app.gwt.core.client.callback.MotorietyAsyncCallback(callback);\n");
        methodBody.append("return super.doInvoke(responseReader, methodName, statsContext, requestData, newAsyncCallback);\n");

        String methodStr = methodStrTemplate.replace("${method-body}", methodBody);
        w.print(methodStr);
    }

}

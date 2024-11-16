package train.tickets;

import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import java.util.HashMap;
import java.util.Map;

public class PaymentRequest implements JavaDelegate {
    public void execute(DelegateExecution execution) throws Exception {
        RuntimeService runtimeService = execution.getProcessEngineServices().getRuntimeService();
        Map<String, Object> processVariables = new HashMap<String, Object>();
        processVariables.put("parentBussinesKey", execution.getProcessInstanceId());
        processVariables.put("payment_confirment",execution.getVariable
                ("payment_confirment"));
        runtimeService.startProcessInstanceByMessage("PaymentRequestMsg",
                processVariables);
    }
}

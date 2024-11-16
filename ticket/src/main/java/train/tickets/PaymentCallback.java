package train.tickets;

import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class PaymentCallback implements JavaDelegate {
    public void execute(DelegateExecution execution) throws Exception {
        RuntimeService runtimeService =
                execution.getProcessEngineServices().getRuntimeService();
        runtimeService.createMessageCorrelation("PaymentCallbackMsg")
                .processInstanceId(execution.getVariable("parentBussinesKey").toString())
                .setVariable("payment_confirment", execution.getVariable("payment_confirment"))
                .setVariable("randomNo", execution.getVariable("randomNo"))
                .correlateWithResult();
    }
}
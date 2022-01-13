import io.temporal.workflow.WorkflowInterface;
import io.temporal.workflow.WorkflowMethod;

@WorkflowInterface
public interface ConvertWorkFlow {
    @WorkflowMethod
    float[] convertAndInverse(float num);
}

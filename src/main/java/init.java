//package "conv14";
import io.temporal.client.WorkflowClient;
import io.temporal.client.WorkflowOptions;
import io.temporal.serviceclient.WorkflowServiceStubs;

public class init {
    public static void main(String[] args) throws Exception {
        WorkflowServiceStubs service = WorkflowServiceStubs.newInstance();
        WorkflowClient client = WorkflowClient.newInstance(service);

        WorkflowOptions options = WorkflowOptions.newBuilder()
                .setTaskQueue("my_task_queue")
                .build();
        float usd_in = (float) 4;
        ConvertWorkFlow wf = client.newWorkflowStub(ConvertWorkFlow.class, options);
        float[] result = wf.convertAndInverse(usd_in);
        System.out.println(result);
        System.exit(0);
    }
}

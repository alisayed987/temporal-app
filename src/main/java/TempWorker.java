import io.temporal.client.WorkflowClient;
import io.temporal.serviceclient.WorkflowServiceStubs;
import io.temporal.worker.Worker;
import io.temporal.worker.WorkerFactory;
public class TempWorker {
    public static void main(String[] args) {
        WorkflowServiceStubs service = WorkflowServiceStubs.newInstance();
        WorkflowClient client = WorkflowClient.newInstance(service);
        WorkerFactory factory = WorkerFactory.newInstance(client);
        Worker worker = factory.newWorker("my_task_queue");
        worker.registerWorkflowImplementationTypes(ConvertWorkFlowImp.class);
        worker.registerActivitiesImplementations(new ConvActivityImp(),new InvActivityImp());
        factory.start();

    }
}


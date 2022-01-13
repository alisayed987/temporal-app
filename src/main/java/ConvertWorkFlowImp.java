/////////////////////////
import java.time.Duration;
import io.temporal.activity.ActivityOptions;

import io.temporal.workflow.Workflow;

public class ConvertWorkFlowImp implements ConvertWorkFlow{
    ////////////////////////////////
    ActivityOptions options = ActivityOptions.newBuilder()
            .setScheduleToCloseTimeout(Duration.ofSeconds(5))
            .build();

    private final ConvActivity ca = Workflow.newActivityStub(ConvActivity.class,options);
    private final InvActivity ia = Workflow.newActivityStub(InvActivity.class,options);


    @Override
    public float[] convertAndInverse(float num) {
        float[] c_i = new float[2];
        float E = ca.Convert_Activity(num);
        c_i[0]=E;
        float U = ia.Inverse_Activity(E,num);
        c_i[1]=U;
        return c_i;
    }
}

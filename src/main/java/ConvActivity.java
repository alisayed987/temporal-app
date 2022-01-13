
import io.temporal.activity.ActivityInterface;
import io.temporal.activity.ActivityMethod;

@ActivityInterface
public interface ConvActivity {
    @ActivityMethod
    float Convert_Activity(float USD);
}

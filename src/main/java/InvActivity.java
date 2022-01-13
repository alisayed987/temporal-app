import io.temporal.activity.ActivityInterface;
import io.temporal.activity.ActivityMethod;

@ActivityInterface
public interface InvActivity {
    @ActivityMethod
    float Inverse_Activity(float EGP,float dollars);
}

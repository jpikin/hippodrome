import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import java.util.concurrent.TimeUnit;

public class MainTest {

    @Disabled
    @Test
    @org.junit.jupiter.api.Timeout(value = 22, unit = TimeUnit.SECONDS)
    public void testMainRunningPer22Sec() throws Exception {

        Main.main(new String[]{});

        }
    }


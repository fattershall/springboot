package MultiThread;

import com.example.springboot.SpringbootApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author pengh
 */
@SpringBootApplication
public class SpringRun {

    @Autowired
    static ThreadService threadService;

    public static void main(String[] args) {
        SpringApplication.run(SpringRun.class, args);
        threadService.A();
        threadService.B();
        threadService.C();
    }
}

package MultiThread;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author pengh
 */
public class SpringThread {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ac =
                new AnnotationConfigApplicationContext(Config.class);
        ThreadService acBean = ac.getBean(ThreadService.class);
        acBean.A();
        acBean.B();
        acBean.C();

    }
}

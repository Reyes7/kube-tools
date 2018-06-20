package kubernetes.host.resolver;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@PropertySource("classpath:application.properties")
public class AppStartupRunner implements CommandLineRunner {

    @Value("${host}")
    private String host;

    @Autowired
    private HostResolver hostResolver;

    @Override
    public void run(String... args) throws Exception {
        try {
            hostResolver.resolveHost(host);
        }catch (Exception e){
            log.info("Exception: ",e.getMessage());
        }
    }
}
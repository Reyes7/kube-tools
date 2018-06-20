package kubernetes.host.resolver;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.List;

@Slf4j
@Component
public class HostResolver {

    void resolveHost(String host) throws UnknownHostException {
        log.info("trying to find host: {}",host);
        InetAddress inetAddress = InetAddress.getByName(host);
        showInfo(inetAddress);

        log.info("trying to find all by name: {}",host);
        List<InetAddress> inetAddresses = Arrays.asList(InetAddress.getAllByName(host));
        log.info("found {} addresses", inetAddresses.size());
        inetAddresses.forEach(this::showInfo);
    }

    private void showInfo(InetAddress address){
        if(address == null) return;

        log.info("host address: {}",address.getHostAddress());
        log.info("is any local address ? {}",address.isAnyLocalAddress());
        log.info("hostname: {}",address.getHostName());
    }
}
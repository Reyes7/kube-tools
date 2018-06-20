package host.resolver;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.List;

public class HostResolverApp {

	public static void main(String[] args) {
		try {
			new HostResolver().resolveHost("mongodb-vm.onwelo.com");
		}catch (Exception e){
			System.out.println("Exception: "+e.getMessage());
		}
	}
}


class HostResolver {

	void resolveHost(String host) throws UnknownHostException {
		System.out.println("trying to find host: "+host);
		InetAddress inetAddress = InetAddress.getByName(host);
		showInfo(inetAddress);

		System.out.println("trying to find all by name: "+host);
		List<InetAddress> inetAddresses = Arrays.asList(InetAddress.getAllByName(host));
		System.out.println("found "+ inetAddresses.size()+" addresses");
		inetAddresses.forEach(this::showInfo);
	}

	private void showInfo(InetAddress address){
		if(address == null) return;

		System.out.println("host address: "+address.getHostAddress());
		System.out.println("is any local address ? : "+address.isAnyLocalAddress());
		System.out.println("hostname: "+address.getHostName());

	}
}
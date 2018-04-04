package text;

import org.apache.commons.net.util.SubnetUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RunWith(SpringRunner.class)
public class HintFinder {

    @Test
    public void testRegex() {

        String s = "add  vm kj sd";

        Pattern p = Pattern.compile("add\\s+vm\\s+(kj\\s+)?sd");
        Matcher m = p.matcher(s);
        boolean b = m.matches();

        assert b;


    }

    @Test
    public void testRegexGroup() {

        String s = "create  vm kj lj lsdf sd";

        Pattern p = Pattern.compile("(add|create)\\s+vm.+");
        Matcher m = p.matcher(s);
        boolean b = m.matches();

        assert b;


    }

    @Test
    public void extract() {

        Map<String, String> params = new HashMap<>();
        String s = "set policy p1 allow traffic  from  vm1 to  db1";
//        String s = "set policy p1 allow traffic to node5 from node4 ";
//        String s = "set policy p1 allow traffic from node4 to node5 ";

        Pattern p = Pattern.compile("set\\s+policy\\s+([a-z0-9]+)\\s+(allow|deny).*?(from|to)\\s+([a-z0-9]+).*?(from|to)\\s+([a-z0-9]+)");
        Matcher m = p.matcher(s);

        if (!m.find()) {
            System.out.println("error");
            return;
        }

        int groupCount = m.groupCount();

        if (groupCount < 6)
            return;

        String policyName = m.group(1);
        params.put("name", policyName);

        String grant1 = m.group(2);
        params.put("operation", grant1);

        String toFrom = m.group(3);
        String node1 = m.group(4);
        params.put(toFrom, node1);


        String toFrom2 = m.group(5);
        String node2 = m.group(6);
        params.put(toFrom2, node2);

        System.out.println(params);

    }


    @Test
    public void extractWord() {

        String s = "add application app1 listen on port 3306 host host1";

        Pattern p = Pattern.compile("(add|create)\\s+application\\s+([a-z0-9]+).*port\\s+([0-9]+)");
        Matcher m = p.matcher(s);

        boolean b = m.find();

        int groupCount = m.groupCount();

        String appName = m.group(2);

        String portNumber = m.group(3);

        assert portNumber != null;

        p = Pattern.compile(".*(host|vm)\\s+([a-z0-9]+).*");
        m = p.matcher(s);
        boolean found = m.find();

        String hostName = m.group(2);
        assert found;

    }

    @Test
    public void testSubnet(){

        SubnetUtils subnetUtils = new SubnetUtils( "192.168.1.14/24");

        String address = subnetUtils.getInfo().getAddress();

        boolean inRange = subnetUtils.getInfo().isInRange("192.168.1.13");

        String lowAddress = subnetUtils.getInfo().getLowAddress();

        String netmask = subnetUtils.getInfo().getNetmask();

        String[] allAddresses = subnetUtils.getInfo().getAllAddresses();

        SubnetUtils subnet1 = new SubnetUtils(lowAddress, netmask);

        long addressCount = subnetUtils.getInfo().getAddressCountLong();



        assert inRange;

    }

    @Test
    public void extractPath() {

        List<String> commandList = new LinkedList<>();
        commandList.add("find path from node1 to node2");
        commandList.add("find traffic from node1 to node2");
        commandList.add("show path to node2 from node1 ");

        Map<String,String> params;
//        Pattern p = Pattern.compile("set\\s+policy\\s+([a-z0-9]+)\\s+(allow|deny).*?(from|to)\\s+([a-z0-9]+).*?(from|to)\\s+([a-z0-9]+)");
        Pattern p = Pattern.compile("(find|show)\\s+(path|traffic)\\s+(from|to)\\s+([a-z0-9]+)\\s+(from|to)\\s+([a-z0-9]+)\\s*");

        for (String command : commandList) {

            params = new HashMap<>();

            Matcher m = p.matcher(command);
            boolean found = m.find();
            assert found;

            params.put(m.group(3), m.group(4));
            params.put(m.group(5), m.group(6));

            assert params.get("from").equals("node1");
            assert params.get("to").equals("node2");
        }

    }

}

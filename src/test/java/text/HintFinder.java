package text;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
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



}

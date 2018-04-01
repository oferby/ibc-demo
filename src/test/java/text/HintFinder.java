package text;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RunWith(SpringRunner.class)
public class HintFinder {

    @Test
    public void testRegex(){

        String s = "add  vm kj lj lsdf sd";

        Pattern p = Pattern.compile("add\\s+vm.+");
        Matcher m = p.matcher(s);
        boolean b = m.matches();

        assert b;


    }



}

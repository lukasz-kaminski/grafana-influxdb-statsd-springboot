package demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by lk on 04.10.15.
 */
@Controller
public class MyController {
    private SecureRandom random = new SecureRandom();

    @RequestMapping("/")
    @ResponseBody
    public String bla() {
        StringBuilder sb = new StringBuilder();
        //something to make the heap go up a bit
        for (int i = 0; i < 100; i++) {
            sb.append(new BigInteger(130, random).toString(32)).append("\n");
        }
        return sb.toString();
    }
}

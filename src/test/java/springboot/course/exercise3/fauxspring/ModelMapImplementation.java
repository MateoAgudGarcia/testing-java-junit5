package springboot.course.exercise3.fauxspring;

import org.junit.jupiter.api.DisplayName;
import springboot.course.exercise3.testinterfaces.FauxTests;

import java.util.HashMap;
import java.util.Map;


public class ModelMapImplementation implements Model, FauxTests {

    Map<String, Object> map = new HashMap<>();
    @Override
    public void addAttribute(String key, Object o) {
        map.put(key,o);
    }

    @Override
    public void addAttribute(Object o) {
        // do nothing
    }

    public Map<String, Object> getMap() {
        return map;
    }
}

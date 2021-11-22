package co.com.jsierra.integrationtest;

import com.intuit.karate.junit5.Karate;

public class RunnerJunit5 {

    @Karate.Test
    Karate getKey() {
        return Karate.run("get_key.feature")
                .relativeTo(getClass());
    }

    @Karate.Test
    Karate saveKey() {
        return Karate.run("save_key.feature")
                .relativeTo(getClass());
    }

    @Karate.Test
    Karate deleteKey() {
        return Karate.run("delete_key.feature")
                .relativeTo(getClass());
    }

}
